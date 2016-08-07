package com.finance.web.controller;

public class Result<T> {

	private final int code;
	private final String msg;
	private final T value;

	private Result(int code, String msg, T value) {
		this.code = code;
		this.msg = msg;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getValue() {
		return value;
	}

	public static <T> Result<T> success(T value) {
		return new Result<T>(200, "", value);
	}

	public static <T> Result<T> error(int code, String msg) {
		return new Result<T>(code, msg, null);
	}

}
