package com.kirck.baidu;

import com.alibaba.fastjson.JSONObject;
import com.kirck.BaseException;
import com.kirck.baidu.result.FileListGuResult;
import com.kirck.baidu.result.UserInfoResultVo;
import com.kirck.util.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 14:46
 * @Description: https://pan.baidu.com/union/document/entrance
 */
public class BaiduPanDiskUtil {

    private Logger logger = LoggerFactory.getLogger(BaiduPanDiskUtil.class);

    /**
     * 获取code
     * @param clinetId
     * @return
     */
    public static String getCode(String clinetId){
        return HttpRequestUtil.sendGet(String.format(BaiduPanDiskConstant.Url.GET_CODE, clinetId));
    }

    public static UserInfoResultVo getUserInfo(String accessToken){
        Map<String,String> maps = new HashMap<>();
        maps.put("method","uinfo");
        maps.put("access_token",accessToken);
        String resultJson = HttpRequestUtil.sendGet(BaiduPanDiskConstant.Url.GET_USER_INFO, maps);
        UserInfoResultVo userInfoResultVo = JSONObject.parseObject(resultJson, UserInfoResultVo.class);
        if(userInfoResultVo.getErrno()==BaiduPanDiskConstant.CODE.SUCCESS){
            return userInfoResultVo;
        }else{
            throw  new BaseException(userInfoResultVo.getErrno(),"获取用户信息出现异常");
        }
    }

    /**
     * 获取文件列表
     * @param accessToken
     * @return
     */
    public static FileListGuResult getFileList(String accessToken) {
        Map<String,String> maps = new HashMap<>();
        maps.put("method","list");
        maps.put("access_token",accessToken);
        String resultJson = HttpRequestUtil.sendGet(BaiduPanDiskConstant.Url.FILE_LIST, maps);
        FileListGuResult fileListResult = JSONObject.parseObject(resultJson, FileListGuResult.class);
        if(fileListResult.getErrno()==BaiduPanDiskConstant.CODE.SUCCESS){
            return fileListResult;
        }else{
            throw  new BaseException(fileListResult.getErrno(),"获取文件列表出现异常");
        }
    }


}
