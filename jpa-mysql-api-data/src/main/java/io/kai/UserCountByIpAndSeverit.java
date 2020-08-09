package io.kai;

public class UserCountByIpAndSeverit {
	private String ip;
	private String severit;
	private Long count;
	
	public UserCountByIpAndSeverit(String ip, String severit, long count) {
	      this.ip = ip;
	      this.severit = severit;
	      this.count = count;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSeverit() {
		return severit;
	}

	public void setSeverit(String severit) {
		this.severit = severit;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
