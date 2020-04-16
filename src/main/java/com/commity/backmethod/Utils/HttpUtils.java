package com.commity.backmethod.Utils;


import org.springframework.stereotype.Component;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
//spring创建它的实例
@Component
public class HttpUtils {

    //使用连接池
    private PoolingHttpClientConnectionManager cm;


    public HttpUtils() {
        this.cm = new PoolingHttpClientConnectionManager();

        //设置最大连接数
        this.cm.setMaxTotal(100);
        //设置主机最大连接数
        this.cm.setDefaultMaxPerRoute(10);




    }

    //根据请求地址 下载页面数据
    public String DoGetHtml(String url) {
        //获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();

        CloseableHttpResponse response = null;
        //设置HttpGet请求对象  设置url
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");

        //httpGet.setHeader("Referer", "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&wq=%E6%89%8B%E6%9C%BA&pvid=b1a43153d64f4920a10f8ca31aa6fa6b");
        //设置请求信息

        httpGet.setConfig(this.getConfig());

        try {
            //使用httpClient发起请求  获取响应
            response = httpClient.execute(httpGet);
            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                //判断响应体Entity是否是不为空
                if (response.getEntity() != null) {
                    return    EntityUtils.toString(response.getEntity(), "utf8");

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return "";
    }


    /*
     * 下载图片
     * @param url
     * @return  图片名称
     */
    public  String doGetImages(String url){
        //获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        CloseableHttpResponse response = null;
        //设置HttpGet请求对象  设置url
        HttpGet httpGet;
        httpGet = new HttpGet(url);

        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");


        //设置请求信息

        httpGet.setConfig(this.getConfig());

        try {
            //使用httpClient发起请求  获取响应
            response = httpClient.execute(httpGet);
            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                //判断响应体Entity是否是不为空
                if (response.getEntity() != null) {
                    //下载图片

                    //获取图片的后缀
                    String extName = url.substring(url.lastIndexOf("."));
                    //创建图片名  重命名图片
                    String picName = UUID.randomUUID().toString()+extName;
                    //下载图片
                    //声明OutputStream
                    OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\mac12\\Desktop\\手机图片\\"+picName));
                    response.getEntity().writeTo(outputStream);
                    //返回图片名称
                    return picName;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //返回空
        return "";
    }
    //设置请求信息
    private RequestConfig getConfig(){
        return RequestConfig.custom().setConnectTimeout(1000)
                .setConnectionRequestTimeout(500)
                .setSocketTimeout(10*1000).build();

    }

}
