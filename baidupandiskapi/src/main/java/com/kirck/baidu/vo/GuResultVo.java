package com.kirck.baidu.vo;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 17:22
 * @Description:
 */
public class GuResultVo {
    private Integer errno;
    private String guid_info;
    private String request_id;
    private Integer guid;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getGuid_info() {
        return guid_info;
    }

    public void setGuid_info(String guid_info) {
        this.guid_info = guid_info;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public Integer getGuid() {
        return guid;
    }

    public void setGuid(Integer guid) {
        this.guid = guid;
    }
}
