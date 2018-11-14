package kr.co.hucloud.batch.visit;

public class UrlVO {

	private String yyyyMmDd;
	private String url;
	private String method;
	private int count;

	public UrlVO(String[] args) {
		this.yyyyMmDd = args[0];
		this.url = args[1];
		this.method = args[2];
		this.count = Integer.parseInt(args[3]);
	}

	public String getYyyyMmDd() {
		return yyyyMmDd;
	}

	public void setYyyyMmDd(String yyyyMmDd) {
		this.yyyyMmDd = yyyyMmDd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
