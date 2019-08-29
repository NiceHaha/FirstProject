package entity.page;


public class PageEntity {
	private int pageSize = 4;   //每页显示多少条
	private int pageNow = 1;	//当前页
	private int pageCount;		//总页数
	private int count;			//总条数
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageCount() {
		if((count % pageSize) == 0) {
			pageCount = count / pageSize;
		}else {
			pageCount = (count / pageSize) + 1;
		}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNow=" + pageNow + ", pageCount=" + pageCount + ", count=" + count
				+ "]";
	}
}
