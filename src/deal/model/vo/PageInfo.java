package deal.model.vo;

public class PageInfo {
	
	private int boardCount; 	
	private int limit; 			

	
	private int currentPage; 	
	private int maxPage;	 


	
	public PageInfo() {}
	
	public PageInfo(int boardCount, int limit, int currentPage, int maxPage) {

		this.boardCount = boardCount;
		this.limit = limit;
		this.currentPage = currentPage;
		this.maxPage = maxPage;

	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}



	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	@Override
	public String toString() {
		return "PageInfo [boardCount=" + boardCount + ", limit=" + limit + ", currentPage=" + currentPage + ", maxPage="
				+ maxPage + "]";
	}




	

}