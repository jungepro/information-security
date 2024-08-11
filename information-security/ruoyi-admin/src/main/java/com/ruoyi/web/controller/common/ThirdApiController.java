package com.ruoyi.web.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.http.ThirdApiUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 调用第三方接口
 */
@RestController
@RequestMapping("/thirdApi")
public class ThirdApiController {
    private static final Logger log = LoggerFactory.getLogger(ThirdApiController.class);

    /**
     * 高德地图_Web服务_逆地理编码
     */
    @GetMapping("/geocodeRegeo")
    public AjaxResult geocodeRegeo(HttpServletRequest request) {
        String url = "https://restapi.amap.com/v3/geocode/regeo";
        Map<String, Object> param = ThirdApiUtils.requestParam(request);
        param.put("key", "4c4ac95c32e951d175c53c55206578a9"); //高德地图key
        JSONObject apiData = ThirdApiUtils.getApiData(url, param);
        return AjaxResult.success(apiData);
    }

}