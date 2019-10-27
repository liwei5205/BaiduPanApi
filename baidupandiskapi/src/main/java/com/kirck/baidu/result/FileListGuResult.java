package com.kirck.baidu.result;

import com.kirck.baidu.vo.BaiduFolder;
import com.kirck.baidu.vo.GuResultVo;

import java.util.List;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 17:47
 * @Description:
 */
public class FileListGuResult extends GuResultVo {
    private List<BaiduFolder> list;

    public List<BaiduFolder> getList() {
        return list;
    }

    public void setList(List<BaiduFolder> list) {
        this.list = list;
    }
}
