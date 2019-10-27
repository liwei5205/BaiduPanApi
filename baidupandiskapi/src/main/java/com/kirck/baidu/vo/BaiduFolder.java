package com.kirck.baidu.vo;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 17:38
 * @Description:
 */
public class BaiduFolder extends BaiduFileVo{

    private Integer unlist;
    /**
     * 该目录是否存在子目录， 只有请求参数带WEB且该条目为目录时，该KEY才存在
     */
    private Integer dir_empty;
    private Integer oper_id;
    private Integer share;
    private Integer empty;

    public Integer getUnlist() {
        return unlist;
    }

    public void setUnlist(Integer unlist) {
        this.unlist = unlist;
    }

    public Integer getDir_empty() {
        return dir_empty;
    }

    public void setDir_empty(Integer dir_empty) {
        this.dir_empty = dir_empty;
    }

    public Integer getOper_id() {
        return oper_id;
    }

    public void setOper_id(Integer oper_id) {
        this.oper_id = oper_id;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getEmpty() {
        return empty;
    }

    public void setEmpty(Integer empty) {
        this.empty = empty;
    }
}
