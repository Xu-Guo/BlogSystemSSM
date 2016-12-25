package com.xuguo.util;

/**
 * Paging util class
 * @author Administrator
 *
 */
public class PageUtil {

	/**
	 * paging code
	 * @param targetUrl // target url
	 * @param totalNum 	//
	 * @param currentPage //current page number
	 * @param pageSize //number of records per page
	 * @return
	 */
	public static String genPagination(String targetUrl,long totalNum,int currentPage,int pageSize,String param){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		if(totalPage==0){
			//System.out.println("No data found!");
			return "No data found!";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<li><a href='"+targetUrl+"?page=1&"+param+"'>Home</a></li>");//add homepage link
			
			//handle Pre tag
			if(currentPage>1){
				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage-1)+"&"+param+"'>Previous</a></li>");			
			}else{
				pageCode.append("<li class='disabled'><a href='#'>Previous</a></li>");//current page <=1£¬no pre£¬disable ¡°pre¡±		
			}
			
			//only display 5 page (page-2, page-1, page, page+1, page+2)
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
			
			//handle Next tag
			if(currentPage<totalPage){//has next page, current page is not last page
				pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"&"+param+"'>Next</a></li>");		
			}else{
				pageCode.append("<li class='disabled'><a href='#'>Next</a></li>"); //current page >=total page£¬no next£¬ disable ¡°next¡±.
			}
			pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"&"+param+"'>Last</a></li>");//add next page link
			return pageCode.toString();
		}
	}
	

	
	
}
