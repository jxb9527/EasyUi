package cn.et.food.util;

import java.util.List;

public class PageTool {

	public PageTool(Integer curPage, Integer totalCount, Integer pageCount) {
		this.curPage = curPage;
		this.total = totalCount;
		this.pageCount = (pageCount == null ? this.pageCount : pageCount);
		this.prePage = (curPage == 1 ? 1 : curPage - 1);
		this.totalPage = (totalCount % this.pageCount == 0 ? totalCount / this.pageCount : totalCount / this.pageCount + 1);
		this.nextPage = (curPage == totalPage) ? totalPage : (curPage + 1);
		this.startIndex = (curPage - 1) * this.pageCount + 1;
		this.endIndex = curPage * this.pageCount;
	}

	private Integer prePage;

	private Integer curPage;

	private Integer nextPage;

	private Integer pageCount = 10;

	private Integer totalPage;

	private Integer total;

	private List rows;

	private Integer startIndex;

	private Integer endIndex;

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

}