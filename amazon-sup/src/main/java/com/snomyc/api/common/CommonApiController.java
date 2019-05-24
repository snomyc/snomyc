package com.snomyc.api.common;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.snomyc.base.domain.ResponseConstant;
import com.snomyc.base.domain.ResponseEntity;
import com.snomyc.util.face.FaceReq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;
@Api(value = "公共接口", tags = "公共接口")
@ApiIgnore
@RestController
@RequestMapping("/api/common")
public class CommonApiController {

	@ApiOperation(value = "识别图片信息",httpMethod = "POST")  
	@RequestMapping(value = "/discernPicture", method = RequestMethod.POST)
	public ResponseEntity discernPicture(@ApiParam(required = true, name = "fileName", value = "图片存放 服务器绝对地址") @RequestParam(name = "fileName",required = true) String fileName) {
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			org.json.JSONObject words = FaceReq.basicAccurateGeneral(fileName, new HashMap<String, String>());
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("words", words);
			responseEntity.success(data,"成功!");
		} catch (Exception e) {
			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
		}
		return responseEntity;
	}
	
}
