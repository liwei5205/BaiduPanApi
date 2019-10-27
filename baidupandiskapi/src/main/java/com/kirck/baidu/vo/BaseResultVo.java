package com.kirck.baidu.vo;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 20:32
 * @Description:
 */
public class BaseResultVo {
    private String errmsg;
    private Integer errno;
    private String request_id;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}
