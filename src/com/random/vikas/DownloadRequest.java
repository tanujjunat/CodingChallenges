package com.random.vikas;

import java.util.List;

public class DownloadRequest {
	
	private String id;
	private List<QueryParam> queryParam;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<QueryParam> getQueryParam() {
		return queryParam;
	}
	public void setQueryParam(List<QueryParam> queryParam) {
		this.queryParam = queryParam;
	}
	
	

}
