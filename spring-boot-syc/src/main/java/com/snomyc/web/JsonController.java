package com.snomyc.web;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.snomyc.base.domain.ResponseConstant;
import com.snomyc.base.domain.ResponseEntity;
import com.snomyc.entity.User;
import com.snomyc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
@Api(value = "返回json格式接口", tags = "返回json格式接口")
@RestController
@RequestMapping("api/json")
public class JsonController {
	
	@Resource
	UserService userService;

//	@ApiOperation(value = "返回用户列表",httpMethod = "POST",notes = "app升级推送所有设备")
//	@RequestMapping(value = "/list", method = RequestMethod.POST)
//	public ResponseEntity list() {
//		ResponseEntity responseEntity = new ResponseEntity();
//		try {
//			List<User> users = userService.findAll();
//			responseEntity.success(users, "调用成功");
//		} catch (Exception e) {
//			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
//		}
//		return responseEntity;
//	}
//
//	@ApiOperation(value = "添加用户",httpMethod = "POST")  
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	@ApiModelProperty(name="user",value="user",required=true)
//	public ResponseEntity add(@RequestParam(name = "user")User user) {
//		ResponseEntity responseEntity = new ResponseEntity();
//		try {
//			userService.save(user);
//			responseEntity.success("调用成功");
//		} catch (Exception e) {
//			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
//		}
//		return responseEntity;
//	}
//
//	@ApiOperation(value = "编辑用户",httpMethod = "POST")  
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	@ApiModelProperty(name="user",value="user",required=true)
//	public ResponseEntity edit(@RequestParam(name = "user")User user) {
//		ResponseEntity responseEntity = new ResponseEntity();
//		try {
//			userService.save(user);
//			responseEntity.success("调用成功");
//		} catch (Exception e) {
//			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
//		}
//		return responseEntity;
//	}

	@ApiOperation(value = "删除用户",httpMethod = "POST")  
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ApiModelProperty(name="id",value="id",required=true)
	public ResponseEntity delete(@RequestBody String id) {
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			userService.delete(id);
			responseEntity.success("调用成功");
		} catch (Exception e) {
			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
		}
		return responseEntity;
	}
}
