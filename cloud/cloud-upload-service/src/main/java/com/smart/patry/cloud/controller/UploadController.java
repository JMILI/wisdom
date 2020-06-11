package com.smart.patry.cloud.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

import com.smart.patry.cloud.dto.FileInfo;
import com.smart.patry.commons.dto.CodeStatus;
import com.smart.patry.commons.dto.ResponseResult;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传服务
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-08-26 07:20:41
 */
@RestController
@RequestMapping(value = "upload")
public class UploadController {

    private static final String ENDPOINT = "oss-cn-shenzhen.aliyuncs.com";
    private static final String ACCESS_KEY_ID = "LTAIUEM4x1YOqT0O";
    private static final String ACCESS_KEY_SECRET = "XVRECYNWqS7uzssIXeNrcgKIamBjTh";
    private static final String BUCKET_NAME = "javasite";
    /**
     * 文件上传
     *
     * @param multipartFile @{code MultipartFile}
     */
//    @PostMapping(value = "")
//    public ResponseResult<FileInfo> upload(MultipartFile multipartFile) {
//        String fileName = multipartFile.getOriginalFilename();
//        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//        String newName = UUID.randomUUID() + "." + suffix;
//
//        OSS client = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
//
//        try {
//            client.putObject(new PutObjectRequest(BUCKET_NAME, newName, new ByteArrayInputStream(multipartFile.getBytes())));
//            // 上传文件路径 = http://BUCKET_NAME.ENDPOINT/自定义路径/fileName
//            return new ResponseResult<FileInfo>(CodeStatus.OK, "文件上传成功", new FileInfo("http://" + BUCKET_NAME + "." + ENDPOINT + "/" + newName));
//        } catch (IOException e) {
//            return new ResponseResult<FileInfo>(CodeStatus.FAIL, "文件上传失败，请重试");
//        } finally {
//            client.shutdown();
//        }
//    }


    private static final String UPLOAD_PATH = "http://192.168.73.1:8080";
    @PostMapping("uploadFile")
    public String uploadFile(MultipartFile file) {
        String result = "";
        try {
            OkHttpClient httpClient = new OkHttpClient();
            MultipartBody multipartBody = new MultipartBody.Builder().
                    setType(MultipartBody.FORM)
                    .addFormDataPart("file", file.getOriginalFilename(),
                            RequestBody.create(MediaType.parse("multipart/form-data;charset=utf-8"),
                                    file.getBytes()))
                    .addFormDataPart("output", "json")
                    .build();

            Request request = new Request.Builder()
                    .url(UPLOAD_PATH)
                    .post(multipartBody)
                    .build();

            Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    result = body.string();
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
