package com.ap.backendPortfolio.utils;

import java.util.List;

public class Response<T> {
	public String msg;
	public String token;
	public List<T> data;
	public int code;

}
