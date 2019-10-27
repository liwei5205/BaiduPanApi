package com.kirck.baidu;

/**
 * @Auther: kirck007
 * @Date: 2019/10/27 14:47
 * @Description:
 */
public class BaiduPanDiskConstant {
    public interface Url{
        String GET_CODE = "https://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=%s&redirect_uri=oob&scope=basic,netdisk&display=tv&qrcode=1&force_login=1";
        String FILE_LIST = "https://pan.baidu.com/rest/2.0/xpan/file";
        String GET_USER_INFO = "https://pan.baidu.com/rest/2.0/xpan/nas";
    }

    public interface BAIDU{
        String CLINETID = "s4jSHeMSpsdnZGQC2eoeO49w";
        String ACCESSTOKEN = "21.cea4e588326b46e0fe9bc6765cdb577f.2592000.1574744817.705906526-17622149";
    }

    public interface CODE{
        int SUCCESS = 0;
    }
}
