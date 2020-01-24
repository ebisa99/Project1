package com.revature.superhuman.util;

import org.apache.log4j.Logger;

public class LoggerUtil {

	private static Logger Log = Logger.getRootLogger();
	
	public static void fatal (String m) {
		Log.fatal(m);
	}
	
	public static void error (String m) {
		Log.error(m);
	}
	public static void warn (String m) {
		Log.warn(m);
	}
	public static void debug (String m) {
		Log.debug(m);
	}
	public static void info (String m) {
		Log.info(m);
	}
	public static void trace (String m) {
		Log.trace(m);
	}
}
