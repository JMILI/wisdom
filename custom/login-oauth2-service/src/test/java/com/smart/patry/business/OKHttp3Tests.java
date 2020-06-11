package com.smart.patry.business;

//import com.funtl.myshop.plus.commons.utils.OkHttpClientUtil;
import com.smart.patry.business.dto.front2end.LoginParam;
import com.smart.patry.commons.utils.OkHttpClientUtil;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import net.sf.json.JSON;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sf.json.JSONSerializer;
import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OKHttp3Tests {

    @Test
    public void testGet() {
        String url = "https://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String url = "http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username", "300004")
                .add("password", "300004")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAsyncGet() {
        String url = "https://www.baidu.com";
        OkHttpClientUtil.getInstance().getDataAsync(url, new OkHttpClientUtil.MyNetCall() {
            @Override
            public void success(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }

            @Override
            public void failed(Call call, IOException e) {
                e.printStackTrace();
            }
        });

        // 直接异步请求看不出效果，等待 5 秒
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Resource
//    LoginParam loginParam;



//    @Test
//    public void tran(){
//        LoginParam loginParam = new LoginParam();
//        LoginParam loginParam1 = new LoginParam();
//        loginParam.setUsername("300004");
//        loginParam.setPassword("300004");
//        loginParam.setLoginIdentity("党支部");
////String s = loginParam.toString();
////    System.out.println(s);
//        JSONObject fromObject = JSONObject.fromObject(loginParam);//java转换为json对象
//
//        String string = fromObject.toString();//转换为字符串
//
//
//        JSONObject jsonObject = JSONObject.fromObject(string );//json字符串转换为json对象
//
//        Object obj = (Object ) JSONObject.toBean(jsonObject, Object.class);
////        loginParam1=s.
//    }
}
