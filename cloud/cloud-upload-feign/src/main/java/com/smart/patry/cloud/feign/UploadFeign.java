package com.smart.patry.cloud.feign;

import com.smart.patry.cloud.feign.fallback.UploadFeignFallback;
import com.smart.patry.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-08-26 06:31:08
 */
@FeignClient(value = "cloud-upload", path = "upload", configuration = FeignRequestConfiguration.class, fallback = UploadFeignFallback.class)
public interface UploadFeign {

    /**
     * 文件上传
     *
     * @param multipartFile {@code MultipartFile}
     * @return {@code String} 文件上传路径
     */
    @PostMapping(value = "")
    String upload(@RequestPart(value = "multipartFile") MultipartFile multipartFile);

}
