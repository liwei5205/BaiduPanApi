package com.kirck.test;

import com.alibaba.fastjson.JSONObject;
import com.kirck.baidu.BaiduPanDiskConstant;
import com.kirck.baidu.BaiduPanDiskUtil;
import com.kirck.baidu.result.FileListGuResult;
import org.junit.Test;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 13:39
 * @Description:
 */
public class HttpClientTest {
    /**
     *
     */
    @Test
    public void demo01(){
        System.out.println(JSONObject.toJSONString(BaiduPanDiskUtil.getUserInfo(BaiduPanDiskConstant.BAIDU.ACCESSTOKEN)));

    }

    @Test
    public void demo02(){
        System.out.println(BaiduPanDiskUtil.getCode(BaiduPanDiskConstant.BAIDU.CLINETID));
    }

    @Test
    public void demo03(){
        FileListGuResult fileList = BaiduPanDiskUtil.getFileList(BaiduPanDiskConstant.BAIDU.ACCESSTOKEN);
        System.out.println(JSONObject.toJSONString(fileList.getList()));
    }
}
