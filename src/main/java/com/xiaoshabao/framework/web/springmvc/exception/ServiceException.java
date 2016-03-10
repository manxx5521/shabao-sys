package com.xiaoshabao.framework.web.springmvc.exception;

/**
 * Service层业务异常
 * <p>
 * 用于输出业务曾提示信息
 * </p>
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String mess) {
		super(mess);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
