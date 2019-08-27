package cn.kaixin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;


/**
 * Http请求工具
 *
 *
 */
public class HttpUtil {
    private static final String CHARSET = "charset=";

    /** 连接超时,默认5秒 */
    private static final int DEFAULT_CONNECT_TIMEOUT = 5000;
    /** 连接local的参数编码 */
    private static final String DEFAULT_ENCODE_TYPE = "utf-8";
    /** 读取超时,默认5秒 */
    private static final int DEFAULT_READ_TIMEOUT = 5000;


    /**
     * 尝试解析Http请求的编码格式,如果没有解析到则使用GBK编码(主要考虑到Local平台的返回编码是gb2312的)
     *
     * @param urlConnection
     * @return
     */
    public static String parseEncoding(HttpURLConnection urlConnection) {
        String _encoding = urlConnection.getContentEncoding();
        if (_encoding != null) {
            return _encoding;
        }
        String _contentType = urlConnection.getContentType();
        if (_contentType != null) {
            int _index = _contentType.toLowerCase().indexOf(CHARSET);
            if (_index > 0) {
                _encoding = _contentType.substring(_index + CHARSET.length());
            }
        }
        if (_encoding != null) {
            return _encoding;
        } else {
            return DEFAULT_ENCODE_TYPE;
        }
    }

    /**
     * 获取指定地址的内容，如果能够从URLConnection中可以解析出编码则使用解析出的编码，否则就使用GBK编码
     *
     * @param requestUrl
     * @param timeout
     * @param POST
     * @return
     */
    public static String getUrl(String requestUrl, int timeout, boolean POST,
                                String postContent) throws IOException {
        BufferedReader reader = null;
        HttpURLConnection urlConnection = null;
        try {
            if (requestUrl.startsWith("https")) {
                trustAllHosts();
            }
            InputStream urlStream;
            URL url = new URL(requestUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(timeout * 1000);
            urlConnection.setReadTimeout(timeout * 1000);
            if (POST) {
                urlConnection.setRequestMethod("POST");
            }

            if (POST && postContent != null) {
                urlConnection.setDoOutput(true);
                OutputStreamWriter writer = new OutputStreamWriter(
                        urlConnection.getOutputStream());
                writer.write(postContent);
                writer.flush();
            } else {
                urlConnection.connect();
            }
            urlStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(urlStream,
                    parseEncoding(urlConnection)));

            char[] _buff = new char[128];
            StringBuilder temp = new StringBuilder();
            int _len = -1;
            while ((_len = reader.read(_buff)) != -1) {
                temp.append(_buff, 0, _len);
            }
            return temp.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                urlConnection.disconnect();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * 信任所有主机-对于任何证书都不做检查
     */
    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        // Android 采用X509的证书信息机制
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain,
                                           String authType) throws CertificateException {
            }

            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {
                // TODO Auto-generated method stub

            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {

            }
        } };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection
                    .setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
