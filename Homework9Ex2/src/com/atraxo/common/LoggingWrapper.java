package com.atraxo.common;

import org.apache.log4j.Logger;

public class LoggingWrapper {

	private static Logger logger = Logger.getLogger(LoggingWrapper.class);

	public static void log(String message) {
		logger.info(message);
	}
}
