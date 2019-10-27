package com.kirck;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 18:01
 * @Description:
 */
public class BaseException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8458544317507845657L;

    /**
     * 各系统内部用的异常code
     */
    private Integer code;

    /**
     * 用于页面显示的友好异常提示信息
     */
    private String friendlyMessage = "";


    /**
     * 缺省友好异常提示信息
     */
    private String defaultFriendlyMessage;

    /**
     * 构造方法
     */
    public BaseException() {

    }

    /**
     * 用指定的cause异常构造一个新的BaseException
     *
     * @param cause the exception cause
     */
    public BaseException(Throwable cause) {
        super(cause);
    }

    /**
     * 用指定的异常日志 message构造一个BaseException
     *
     * @param logMsg the detail message
     */
    public BaseException(String logMsg) {
        super(logMsg);
    }

    /**
     * 用指定code和cause异常构造一个BaseException
     *
     * @param code the exception code
     * @param cause the exception cause
     *
     */
    public BaseException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }



    /**
     * 用指定code和异常日志 message构造一个BaseException
     *
     * @param code the exception code
     * @param logMsg the log message
     *
     */
    public BaseException(Integer code, String logMsg) {
        super(logMsg);
        this.code = code;
    }


    /**
     * 用指定code和异常日志 message以及异常cause构造一个BaseException,
     *
     * @param code the exception code
     * @param logMsg the detail message
     * @param cause the root cause
     */
    public BaseException(Integer code, String logMsg, Throwable cause) {
        super(logMsg, cause);
        this.code = code;
    }


    /**
     * 用指定的code和异常cause以及缺省的页面友好message构造一个BaseException
     *
     * @param code the exception code
     * @param cause the root cause
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     */
    public BaseException(Integer code, Throwable cause, String defaultFriendlyMessage) {
        super(cause);
        this.code = code;
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }



    /**
     * 用指定的code和异常日志message构造一个BaseException,并指定缺省的页面友好message
     *
     * @param code the exception code
     * @param logMsg the detail message
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     *
     */
    public BaseException(Integer code, String logMsg, String defaultFriendlyMessage) {
        super(logMsg);
        this.code = code;
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }


    /**
     * 用指定的code和异常日志message以及异常cause构造一个BaseException, 并指定缺省的页面友好message
     *
     * @param code the exception code
     * @param logMsg the detail message
     * @param cause the root cause
     * @param defaultFriendlyMessage the default friendly message if the friendly message corresponding to code is not
     *            exist.
     *
     */
    public BaseException(Integer code, String logMsg, Throwable cause, String defaultFriendlyMessage) {
        super(logMsg, cause);
        this.code = code;
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }



    /**
     * Return the detail message, including the message from the nested exception if there is one.
     */
    /**
     * @Override public String getMessage() { if(code!=null && code.trim().length()>0){ StringBuilder sb = new
     * StringBuilder(); sb.append("Code: ").append(code) .append("\rMessage: ").append(super.getMessage()); return
     * sb.toString(); } return super.getMessage(); }
     */

    /**
     * 返回friendlyMessage
     *
     * @return the friendlyMessage
     */
    public String getFriendlyMessage() {
        return friendlyMessage;
    }



    /**
     * 设置提示信息
     *
     * @param friendlyMessage the friendlyMessage to set
     */
    public void setFriendlyMessage(String friendlyMessage) {
        this.friendlyMessage = friendlyMessage;
    }


    /**
     * 返回默认的提示信息
     *
     * @return the formattedMessage
     */
    public String getDefaultFriendlyMessage() {
        return defaultFriendlyMessage;
    }

    /**
     * 设置默认的提示信息
     *
     * @param defaultFriendlyMessage the defaultFriendlyMessage to set
     */
    public void setDefaultFriendlyMessage(String defaultFriendlyMessage) {
        this.defaultFriendlyMessage = defaultFriendlyMessage;
    }




    /**
     * 返回系统内部错误编码
     *
     * @return 系统内部错误编码
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置系统内部错误编码
     *
     * @param code 系统内部错误编码
     */
    public void setCode(Integer code) {
        this.code = code;
    }
}
