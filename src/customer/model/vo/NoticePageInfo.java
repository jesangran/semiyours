package customer.model.vo;

public class NoticePageInfo {
	private int nCount; // (바카운트)공시사항 전체 게시글 수
	private int nLimit; // (페이지리밋)한 페이지에서 보여주고 싶은 게시글 수
	private int pagingBarSize; //(페이징바사이즈) 보여질 페이징바의 페이지 수 / 1~10
	// 페이지 체크 내용
	private int currentPage; // (커런트)현재 페이지 번호를 표시할 변수
	private int maxPage; // 전체 페이지에서 가장 마지막 페이지를 의미
	// 페이지 시작과 끝
	private int startPage; // 시작 페이지
	private int endPage; // 끝 페이지
	
	public NoticePageInfo() {
		
	}

	public NoticePageInfo(int nCount, int nLimit, int pagingBarSize, int currentPage, int maxPage, int startPage,
			int endPage) {
		super();
		this.nCount = nCount;
		this.nLimit = nLimit;
		this.pagingBarSize = pagingBarSize;
		this.currentPage = currentPage;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	public int getNlimit() {
		return nLimit;
	}

	public void setNlimit(int nlimit) {
		this.nLimit = nlimit;
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
		return "NoticePageInfo [nCount=" + nCount + ", nLimit=" + nLimit + ", pagingBarSize=" + pagingBarSize
				+ ", currentPage=" + currentPage + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
}
	