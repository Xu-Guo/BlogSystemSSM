package com.xuguo.util;

/**
 * Paging util class
 * @author Administrator
 *
 */
public class PageUtil {

	/**
	 * 生成分页代码
	 * @param targetUrl //目标地址
	 * @param totalNum 	//
	 * @param currentPage //当前页数
	 * @param pageSize //每页显示博客数量
	 * @return
	 */
	public static String genPagination(String targetUrl,long totalNum,int currentPage,int pageSize,String param){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			System.out.println("No data found!");
			return "No data found!";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<li><a href='"+targetUrl+"?page=1&"+param+"'>Home</a></li>");//添加首页链接
			
			//处理Pre标签
			if(currentPage>1){
				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage-1)+"&"+param+"'>Next</a></li>");			
			}else{
				pageCode.append("<li class='disabled'><a href='"+targetUrl+"?page="+(currentPage-1)+"&"+param+"'>Pre</a></li>");//当前页<=1，不存在上一也，disable “pre”		
			}
			
			//不显示所有页码，只显示当前页的前后2个页码，总共5页页码
			for(int i=currentPage-2;i<=currentPage+2;i++){
				
				if(i<1||i>totalPage){//check if the current page is 1st or the last
					continue;
				}
				if(i==currentPage){//give current page number "active" mark.
					pageCode.append("<li class='active'><a href='"+targetUrl+"?page="+i+"&"+param+"'>"+i+"</a></li>");	
				}else{
					pageCode.append("<li><a href='"+targetUrl+"?page="+i+"&"+param+"'>"+i+"</a></li>");	
				}
			}
			
			//处理Next标签
			if(currentPage<totalPage){//has next page, current page is not last page
				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"&"+param+"'>Next</a></li>");		
			}else{
				pageCode.append("<li class='disabled'><a href='"+targetUrl+"?page="+(currentPage+1)+"&"+param+"'>Next</a></li>"); //当前页大于等于总页数，不存在下一也next， disable “next”.
			}
			pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"&"+param+"'>Last</a></li>");//添加尾页链接
			return pageCode.toString();
		}
	}
	

	
	
}
