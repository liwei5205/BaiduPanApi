package com.kirck.baidu;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 17:24
 * @Description:
 */
public class BaiduErrorBook {

    interface GENERAL_ERROR {
        /**
         * 参数错误
         */
        Integer PARAM_ERROR = 0;
        /**
         * 身份验证失败
         */
        Integer AUTH_ERROR = -6;
        /**
         * 客户端通用降级错误码，客户端收到此错误码不会重试
         */
        Integer DOWN_ERROR = 100;
        /**
         * 命中接口频控
         */
        Integer LIMIT_ERROR = 31034;
        /**
         * 访问过于频繁
         */
        Integer FREQUENTLY_ERROR = 42000;
        /**
         * rand校验失败
         */
        Integer RAND_ERROR = 42001;
        /**
         * 功能下线
         */
        Integer OFFLINE_ERROR = 42999;
        /**
         * 一级封禁
         */
        Integer BAN_ONE_ERROR = 9100;
        /**
         * 二级封禁
         */
        Integer BAN_TWO_ERROR = 9200;
        /**
         * 三级封禁
         */
        Integer BAN_THREE_ERROR = 9300;
        /**
         * 四级封禁
         */
        Integer BAN_FOUR_ERROR = 9400;
        /**
         * 五级封禁
         */
        Integer BAN_FIVE_ERROR = 9500;

    }

    interface FILE_ERROR{
        /**
         * 文件或目录名错误或无权访问
         */
        Integer FILE_ERROR = -7;
        /**
         * 文件或目录不存在
         */
        Integer FILE_NOT_EXISIT = -9;

    }
}
