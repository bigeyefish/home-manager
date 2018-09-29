package com.honeypotato.homemanager.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志管理器
 * Created by wangshiyu on 2015/12/1.
 */
public class LogUtil {


    public static final Logger errorLog = LogManager.getLogger(LogType.ERROR);

    public static final Logger systemLog = LogManager.getLogger(LogType.SYSTEM);
    public static final Logger tempLog = LogManager.getLogger(LogType.TEMP);

    private static Map<String, Logger> loggerMap = new HashMap<>(16);
    static {
        loggerMap.put(LogType.ERROR, errorLog);
        loggerMap.put(LogType.SYSTEM, systemLog);
    }

    public static Logger getLogger(String type) {
        if (loggerMap.containsKey(type)) {
            return loggerMap.get(type);
        }
        errorLog.error("未找到名字是{}的logger", type);
        return tempLog;
    }

    /**
     * 缓存log4j日志名称
     */
    public static class LogType {

        public static final String ERROR = "error";

        public static final String SYSTEM = "system";

        public static final String TEMP = "temp";

    }
}
