package com.snomyc.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.snomyc.base.domain.ResponseConstant;
import com.snomyc.base.domain.ResponseEntity;
import com.snomyc.base.redis.JedisPoolUtil;
import com.snomyc.controller.user.request.UserAddRequest;
import com.snomyc.controller.user.request.UserEditRequest;
import com.snomyc.sys.user.bean.User;
import com.snomyc.sys.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Api(value = "返回json格式接口", tags = "返回json格式接口")
@RestController
@RequestMapping("/api/user")
public class UserJsonController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private JedisPool jedisPool;
	
	@Autowired
	private JedisPoolUtil jedisPoolUtil;

	@ApiOperation(value = "返回用户列表",httpMethod = "POST",notes = "app升级推送所有设备")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResponseEntity list() {
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			List<User> users = userService.findAll();
			responseEntity.success(users, "调用成功");
		} catch (Exception e) {
			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
		}
		return responseEntity;
	}

	@ApiOperation(value = "添加用户",httpMethod = "POST")  
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity add(@RequestBody UserAddRequest request) {
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			User user = new User();
			user.setUserName(request.getUserName());
			user.setPassword(request.getPassword());
			user.setAge(request.getAge());
			userService.save(user);
			responseEntity.success();
		} catch (Exception e) {
			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
		}
		return responseEntity;
	}

	@ApiOperation(value = "编辑用户",httpMethod = "POST")  
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ResponseEntity edit(@RequestBody UserEditRequest request) {
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			User user = new User();
			user.setId(request.getId());
			user.setUserName(request.getUserName());
			user.setPassword(request.getPassword());
			user.setAge(request.getAge());
			userService.save(user);
			responseEntity.success();
		} catch (Exception e) {
			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
		}
		return responseEntity;
	}

	@ApiOperation(value = "删除用户",httpMethod = "POST")  
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity delete(@ApiParam(required = true, name = "id", value = "用户id") @RequestParam(name = "id",required = true) String id) {
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			userService.delete(id);
			responseEntity.success();
		} catch (Exception e) {
			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
		}
		return responseEntity;
	}
	
	@ApiOperation(value = "测试缓存",httpMethod = "POST")  
	@RequestMapping(value = "/redisKey", method = RequestMethod.POST)
	public ResponseEntity redisKey(@ApiParam(required = true, name = "key", value = "reids key") @RequestParam(name = "key",required = true) String key) {
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			try (Jedis jedis = jedisPool.getResource()) {
	             jedis.setex(key, 3600, "wtf");
	        }
			jedisPoolUtil.setex(key+2, "wtf",3600);
			responseEntity.success();
		} catch (Exception e) {
			responseEntity.failure(ResponseConstant.CODE_500, "接口调用异常");
		}
		return responseEntity;
	}
	
}
