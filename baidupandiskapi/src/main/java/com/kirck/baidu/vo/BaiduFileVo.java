package com.kirck.baidu.vo;

import java.util.Date;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 17:39
 * @Description:
 */
public class BaiduFileVo {
    /**
     *文件在云端的唯一标识ID
     */
    private String fs_id;
    /**
     * 文件名称
     */
    private String server_filename;
    /**
     *文件的绝对路径
     */
    private String path;
    /**
     *文件类型，1 视频、2 音频、3 图片、4 文档、5 应用、6 其他、7 种子
     */
    private Integer category;
    /**
     *文件大小，单位B
     */
    private Long size;
    /**
     *文件在服务器创建时间
     */
    private Date server_ctime;
    /**
     *文件在服务器修改时间
     */
    private Date server_mtime;
    /**
     * 文件在客户端修改时间
     */
    private Date local_mtime;
    /**
     *文件在客户端创建时间
     */
    private Date local_ctime;
    /**
     * 是否目录，0 文件、1 目录
     */
    private Integer isdir;

    public String getFs_id() {
        return fs_id;
    }

    public void setFs_id(String fs_id) {
        this.fs_id = fs_id;
    }

    public String getServer_filename() {
        return server_filename;
    }

    public void setServer_filename(String server_filename) {
        this.server_filename = server_filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getServer_ctime() {
        return server_ctime;
    }

    public void setServer_ctime(Date server_ctime) {
        this.server_ctime = server_ctime;
    }

    public Date getServer_mtime() {
        return server_mtime;
    }

    public void setServer_mtime(Date server_mtime) {
        this.server_mtime = server_mtime;
    }

    public Date getLocal_mtime() {
        return local_mtime;
    }

    public void setLocal_mtime(Date local_mtime) {
        this.local_mtime = local_mtime;
    }

    public Date getLocal_ctime() {
        return local_ctime;
    }

    public void setLocal_ctime(Date local_ctime) {
        this.local_ctime = local_ctime;
    }

    public Integer getIsdir() {
        return isdir;
    }

    public void setIsdir(Integer isdir) {
        this.isdir = isdir;
    }
}
