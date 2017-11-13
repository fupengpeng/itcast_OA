package cn.itcast.test;

import cn.itcast.oa.domain.PageBean;



public class PageBeanTest {
	
	public static void main(String[] args) {
		PageBean pb = new PageBean(10, 10, 300, null);
		System.out.println("总页数   = " + pb.getPageCount());
		System.out.println("开始页数   = " + pb.getBeginPageIndex());
		System.out.println("结束页数   = " + pb.getEndPageIndex());
		
		
	}

}
