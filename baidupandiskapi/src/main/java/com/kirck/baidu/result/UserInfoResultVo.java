package com.kirck.baidu.result;

import com.kirck.baidu.vo.BaseResultVo;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 20:33
 * @Description:
 */
public class UserInfoResultVo extends BaseResultVo {
    /**
     * 用户头像
     */
    private String avatar_url;
    /**
     * 百度账号
     */
    private String baidu_name;
    /**
     * 网盘账号
     */
    private String netdisk_name;
    /**
     * 用户ID
     */
    private Integer uk;
    /**
     * vip类型
     */
    private Integer vip_type;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getBaidu_name() {
        return baidu_name;
    }

    public void setBaidu_name(String baidu_name) {
        this.baidu_name = baidu_name;
    }

    public String getNetdisk_name() {
        return netdisk_name;
    }

    public void setNetdisk_name(String netdisk_name) {
        this.netdisk_name = netdisk_name;
    }

    public Integer getUk() {
        return uk;
    }

    public void setUk(Integer uk) {
        this.uk = uk;
    }

    public Integer getVip_type() {
        return vip_type;
    }

    public void setVip_type(Integer vip_type) {
        this.vip_type = vip_type;
    }
}
