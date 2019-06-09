package com.week;

import com.sun.deploy.net.HttpResponse;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author week
 * @Title: test
 * @ProjectName tsetAs
 * @Description: TODO
 * @date 2019/3/2918:12
 */
public class test {
    public static void main(String[] args) {

        try {

            String path = "https://www.ysxmb.com/api/as.php";
            //[3]以httpClient 方式进行post 提交
            DefaultHttpClient client = new DefaultHttpClient();
            //[3.1]准备post 请求
            HttpPost post = new HttpPost(path);
            //[3.1.0]准备parameters
            List<NameValuePair> lists = new ArrayList<NameValuePair>();
            //[3.1.1]准备 NameValuePair 实际上就是我们要提交的用户名 和密码  key是服务器key :username
            BasicNameValuePair nameValuePair = new BasicNameValuePair("data",barcodeStr);

            //[3.1.3] 把nameValuePair  和 pwdValuePair  加入到集合中
            lists.add(nameValuePair);

            //[3.1.3]准备entity
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(lists,"utf-8");

            //[3.2]准备post方式提交的正文   以实体形式准备 (键值对形式 )
            post.setEntity(entity);


            HttpResponse response = client.execute(post);
            //[4]获取服务器返回的状态码
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                //[5]获取服务器返回的数据   以流的形式返回
                InputStream inputStream = response.getEntity().getContent();

                //[6]把流转换成字符串
                String content = StreamTools.readStream(inputStream);

                //[7]展示结果


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
