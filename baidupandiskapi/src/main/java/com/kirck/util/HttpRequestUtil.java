package com.kirck.util;


import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * restful请求工具类，推荐使用，支持http和https
 *
 * @author niuming
 *
 */
public class HttpRequestUtil {
    private final static Integer TIME_OUT = 30000;
    private final static String HTTPS = "https://";
    private final static String UTF_8 = "UTF-8";
    private final static String POST = "post";


    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @return 请求结果
     */
    public static String sendGet(String url) {
      return sendGet(url,"");
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 请求结果
     */
    public static String sendGet(String url, String param) {
        try {
            if (url.contains(HTTPS)) {
                HttpsURLConnection.setDefaultHostnameVerifier(new HttpRequestUtil().new NullHostNameVerifier());
                SSLContext sc = SSLContext.getInstance("TLS");
                sc.init(null, trustAllCerts, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }
            URL urlObject = new URL(StringUtils.isNoneBlank(param)?url + "?" + param:url);
            // 打开连接
            HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
            // 连接超时30秒
            conn.setConnectTimeout(TIME_OUT);
            // 读取超时300秒
            conn.setReadTimeout(TIME_OUT);
            // 获得响应状态
            int resultCode = conn.getResponseCode();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                // 得到输入流
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while (-1 != (len = is.read(buffer))) {
                    baos.write(buffer, 0, len);
                    baos.flush();
                }
                return baos.toString(UTF_8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url      发送请求的URL
     * @param paramMap 请求参数的集合
     * @return 请求结果
     */
    public static String sendGet(String url, Map<String, String> paramMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        // 去掉最后一个&
        sb.deleteCharAt(sb.lastIndexOf("&"));
        return sendGet(url, sb.toString());
    }

    /**
     * 向指定 URL发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 请求结果
     */
    public static String sendPost(String url, String param) {
        String result = "";
        try {
            if (url.contains("https://")) {
                HttpsURLConnection.setDefaultHostnameVerifier(new HttpRequestUtil().new NullHostNameVerifier());
                SSLContext sc = SSLContext.getInstance("TLS");
                sc.init(null, trustAllCerts, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }

            URL urlObject = new URL(url);
            // 打开链接
            HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
            // 设置参数
            conn.setRequestMethod(POST); // 设置POST方式连接
            conn.setDoOutput(true); // 需要输出
            conn.setDoInput(true); // 需要输入
            conn.setUseCaches(false); // 不允许缓存
            // 设置请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            // 连接超时30秒
            conn.setConnectTimeout(TIME_OUT);
            // 读取超时300秒
            conn.setReadTimeout(TIME_OUT);

            // 建立输入流，向指向的URL传入参数
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(param);
            dos.flush();
            dos.close();
            // 获得响应状态
            int resultCode = conn.getResponseCode();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                StringBuffer sb = new StringBuffer();
                String readLine = new String();
                BufferedReader responseReader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();
                result = sb.toString();
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sendPost(String url, String param, Map<String, Object> headers) {
        String result = "";
        try {
            if (url.contains(HTTPS)) {
                HttpsURLConnection.setDefaultHostnameVerifier(new HttpRequestUtil().new NullHostNameVerifier());
                SSLContext sc = SSLContext.getInstance("TLS");
                sc.init(null, trustAllCerts, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }


            URL urlObject = new URL(url);
            // 打开链接
            HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
            if(MapUtils.isNotEmpty(headers)) {
                for (Map.Entry<String, Object> header : headers.entrySet()) {
                    conn.setRequestProperty(header.getKey(), String.valueOf(header.getValue()));
                }
            }

            // 设置参数
            conn.setRequestMethod("POST"); // 设置POST方式连接
            conn.setDoOutput(true); // 需要输出
            conn.setDoInput(true); // 需要输入
            conn.setUseCaches(false); // 不允许缓存
            // 设置请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            // 连接超时30秒
            conn.setConnectTimeout(TIME_OUT);
            // 读取超时300秒
            conn.setReadTimeout(TIME_OUT);

            // 建立输入流，向指向的URL传入参数
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(param);
            dos.flush();
            dos.close();
            // 获得响应状态
            int resultCode = conn.getResponseCode();
            if (HttpURLConnection.HTTP_OK == resultCode) {
                StringBuffer sb = new StringBuffer();
                String readLine = new String();
                BufferedReader responseReader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append(readLine).append("\n");
                }
                responseReader.close();
                result = sb.toString();
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 向指定 URL发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param  paramMap 请求参数的集合
     * @return 请求结果
     */
    public static String sendPost(String url, Map<String, String> paramMap) {
        String param = "";
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            param = param + entry.getKey() + "=" + entry.getValue() + "&";
        }
        // 去掉最后一个&
        param = param.substring(0, param.length() - 1);
        return sendPost(url, param);
    }

    // ----这块代码不要动，niuming，2018-12-17
    static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }
    } };

    public class NullHostNameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String arg0, SSLSession arg1) {
            // TODO Auto-generated method stub
            return true;
        }
    }

}