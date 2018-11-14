package kr.co.hucloud.batch.visit;

public class BehaviorVO {

	private String ip;
	private String id;
	private String yyyyMmDd;
	private String url;
	private String method;
	private int count;

	public BehaviorVO(String[] args) {
		this.ip = args[0];
		this.id = args[1];
		this.yyyyMmDd = args[2];
		this.url = args[3];
		this.method = args[4];
		this.count = Integer.parseInt(args[5]);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
