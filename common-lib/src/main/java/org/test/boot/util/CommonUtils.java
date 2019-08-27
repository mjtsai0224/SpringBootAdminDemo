package org.test.boot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	public static void log(String s) {
		logger.debug(">>>log={}", s);
		logger.info(">>>log={}", s);
		logger.error(">>>log={}", s);
	}

}
