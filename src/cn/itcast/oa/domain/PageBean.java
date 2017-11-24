package cn.itcast.oa.domain;

import java.util.List;


/**
 * 
 * @Title: PageBean
 * @Description: 封装分页信息
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月10日 上午11:13:58
 *
 */
public class PageBean {
	//从页面提交过来的参数
	private int currentPage;   //当前页码
	private int pageSize;   //每页显示条目数量
	
	//查询数据库获得
	private int recordCount;   //总记录数
	private List recordList;  //页面要显示的数据集合
	
	//由上面数据计算所得
	private int pageCount;   //总页码数
	private int beginPageIndex;   //开始页码
	private int endPageIndex;   //结束页码
	
	public PageBean() {
	}

	public PageBean(int currentPage, int pageSize, int recordCount,
			List recordList) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		pageCount = (this.recordCount + this.pageSize - 1) / this.pageSize;  //计算总页数
		
		if (pageCount <= 10) { // 总页数小于10，则全部显示，
			this.beginPageIndex = 1;
			this.endPageIndex = this.pageCount;
		}else {  // 否则就根据规定，前面显示四个，后面显示五个
			this.beginPageIndex = this.currentPage - 4 ;
			this.endPageIndex = this.currentPage + 5 ;
			
			//  如果开始页数小于1  则显示前十个数据
			if (this.beginPageIndex < 1 ) {
				this.beginPageIndex = 1;
				this.endPageIndex = 10;
			}
			
			//  如果结束页数大于总页数，则显示最后十个
			if (this.endPageIndex > this.pageCount ) {
				this.endPageIndex = this.pageCount;
				this.beginPageIndex = this.pageCount - 9 ;
			}
		}
		
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	@Override
	public String toString() {
		return "PageBean [recordList=" + recordList + "]";
	}

	
	
	
	
	
	
	

}
