package com.xuguo.lucene;


import java.nio.file.Paths;
import java.util.Date;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.xuguo.entity.Blog;
import com.xuguo.util.DateUtil;

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
}
