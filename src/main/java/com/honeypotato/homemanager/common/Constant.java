package com.honeypotato.homemanager.common;

/**
 * 静态常量类
 * Created by sanyihwang on 2018/9/20.
 **/
public class Constant {

    public static final String MD5_FRE = "*_*ILovePotato*_*";

    public static final String PROP_SEP_SIGN = "@@";

    public static class LogType {
        public static final String INFO = "info";
        public static final String ERROR = "error";
    }

    /* 任务类型 1-个人 2-竞争 3- 共同 4轮流*/
    public static class TaskType {
        public static final int PERSONAL = 1;
        public static final int COMPETE = 2;
        public static final int TOGETHER = 3;
        public static final int BYTURN = 4;
    }

    public static class CACHE_KEY {
        public static final String USER_RESOURCE = "user_resource";
        public static final String USER_BASIC = "user_basic";
        // 带敏感信息（token、password）的用户基本信息
        public static final String USER_BASIC_SEC = "user_basic_sec";
        public static final String FAMILY_BASIC = "family_basic";
    }

    /**
     * 资源类型
     */
    public static class RESOURCE_TYPE {
        public static final int MENU = 1;
        public static final int BUTTON = 2;
        public static final int DATA = 3;
        public static final int DATA_COMMON = 4;
    }

    /* 放在JobDataMap中的task信息的key */
    public static final String KEY_TASK_ID = "TASK_ID";

    /* task状态（根据起止时间计算）*/
    public static class TASK_STATUS {
        public static final String NOT_START = "未启动";
        public static final String RUNNING = "运行中";
        public static final String END = "已结束";
    }

    /* job状态 运行中、已完成、已过期、已下线、待抢 */
    public static class JOB_STATUS {
        public static final int RUNNING = 1;
        public static final int FINISHED = 2;
        public static final int EXPIRED = 3;
        public static final int TO_BE_GRAB = 4;
        public static final int OFF_LINE  = 5;
    }

    /* 延期类型 - 本日、本周、一周、本月 */
    public static class EXPIRE_TYPE {
        public static final int CUR_DAY = 1;
        public static final int CUR_WEEK = 2;
        public static final int WEEK_DAYS = 3;
        public static final int CUR_MONTH = 4;
    }
}
