package com.xuguo.lucene;


import java.io.StringReader;
import java.nio.file.Paths; 
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.xuguo.entity.Blog;
import com.xuguo.util.DateUtil;
import com.xuguo.util.StringUtil;

/**
 * Blog index
 * @author xu
 *
 */
public class BlogIndex {
	
	private Directory directory;
	
	
	/**
	 * get IndexWrite instance
	 * @return
	 * @throws Exception
	 */
	private IndexWriter getWriter()throws Exception{
		directory = FSDirectory.open(Paths.get("D://lucene"));
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(directory, indexWriterConfig);
		return writer;
	}
	/**
	 * add blog index
	 * @param blog
	 * @throws Exception
	 */
	public void addIndex(Blog blog) throws Exception{
		IndexWriter writer = getWriter();
		Document document = new Document();
		document.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
		document.add(new TextField("title",blog.getTitle(),Field.Store.YES));
		document.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"), Field.Store.YES));
		document.add(new TextField("content", blog.getContentNoTag(),Field.Store.YES));
		writer.addDocument(document);
		writer.close();
	}
	
	
	/**
	 * delete lucene index of a particular blog or blogs
	 * @param blogId
	 * @throws Exception
	 */
	public void deleteIndex(String blogId)throws Exception{
		IndexWriter writer = getWriter();
		writer.deleteDocuments(new Term("id", blogId));
		writer.forceMergeDeletes();//force delete at once
		writer.commit();
		writer.close();
	}
	
	
	
	
	/**
	 * search blog using lucene
	 * @param q : String to search
	 * @return
	 * @throws Exception
	 */
	public List<Blog> searchBlog(String q) throws Exception{
		directory = FSDirectory.open(Paths.get("D://lucene"));
		IndexReader reader = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(reader);
		BooleanQuery.Builder booleanQuery= new BooleanQuery.Builder();
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		QueryParser parser = new QueryParser("title", analyzer);
		Query query = parser.parse(q);
		
		QueryParser parser2 = new QueryParser("content", analyzer);
		Query query2 = parser2.parse(q);
		
		booleanQuery.add(query,BooleanClause.Occur.SHOULD);// logic or
		booleanQuery.add(query2,BooleanClause.Occur.SHOULD);
		
		TopDocs hits = indexSearcher.search(booleanQuery.build(), 100);
		QueryScorer scorer = new QueryScorer(query);
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
		highlighter.setTextFragmenter(fragmenter);
		
		List<Blog> blogList = new LinkedList<Blog>();
		for(ScoreDoc scoreDoc : hits.scoreDocs){
			Document document = indexSearcher.doc(scoreDoc.doc);
			Blog blog = new Blog();
			blog.setId(Integer.parseInt(document.get("id")));
			blog.setReleaseDateStr(document.get("releaseDate"));
			String title = document.get("title");
			//filter html content in string
			String content = StringEscapeUtils.escapeHtml(document.get("content"));
			if(title!=null){
				TokenStream tokenStream=analyzer.tokenStream("title", new StringReader(title));
				String hTitle = highlighter.getBestFragment(tokenStream, title);
				if(StringUtil.isEmpty(hTitle)){
					blog.setTitle(title);
				}else{
					blog.setTitle(hTitle);
				}
			}
			if(content!=null){
				TokenStream tokenStream=analyzer.tokenStream("content", new StringReader(content));
				String hContent = highlighter.getBestFragment(tokenStream, content);
				if (StringUtil.isEmpty(hContent)) {
					if(content.length() <= 200){
						blog.setContent(content);
					}else{
						blog.setContent(content.substring(0, 200));
					}
				}else {
					blog.setContent(hContent);
				}
			}
			blogList.add(blog);
		}
		return blogList;
		
	}
}
