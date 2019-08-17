package customer.model.vo;

public class PageInfo {
	private int FaqCount; // (바카운트)공시사항 전체 게시글 수
	private int Faqlimit; // (페이지리밋)한 페이지에서 보여주고 싶은 게시글 수
	private int pagingBarSize; //(페이징바사이즈) 보여질 페이징바의 페이지 수 / 1~10
	// 페이지 체크 내용
	private int currentPage; // (커런트)현재 페이지 번호를 표시할 변수
	private int maxPage; // 전체 페이지에서 가장 마지막 페이지를 의미
	// 페이지 시작과 끝
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	
	public PageInfo() {
		
	}

	public PageInfo(int faqCount, int faqlimit, int pagingBarSize, int currentPage, int maxPage, int startPage,
			int endPage) {
		super();
		FaqCount = faqCount;
		Faqlimit = faqlimit;
		this.pagingBarSize = pagingBarSize;
		this.currentPage = currentPage;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getFaqCount() {
		return FaqCount;
	}

	public void setFaqCount(int faqCount) {
		FaqCount = faqCount;
	}

	public int getFaqlimit() {
		return Faqlimit;
	}

	public void setFaqlimit(int faqlimit) {
		Faqlimit = faqlimit;
	}

	public int getPagingBarSize() {
		return pagingBarSize;
	}

	public void setPagingBarSize(int pagingBarSize) {
		this.pagingBarSize = pagingBarSize;
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

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageInfo [FaqCount=" + FaqCount + ", Faqlimit=" + Faqlimit + ", pagingBarSize=" + pagingBarSize
				+ ", currentPage=" + currentPage + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
}

	