package com.snomyc.base.security.service;

import java.sql.Timestamp;
import java.util.List;

import com.snomyc.base.security.domain.AccessToken;
import com.snomyc.base.service.BaseService;


/**
 * 
 * 类名称：AccessTokenService<br>
 * 类描述：访问令牌服务接口<br>
 * @version v1.0
 *
 */
public interface AccessTokenService extends BaseService<AccessToken, String> {

    /**
     * 创建token
     * @param userId 用户id
     * @param token
     */
    public void createToken(String userId, String token);

    /**
     * 创建token
     * @param userId 用户id
     * @param token
     */
    public void createToken(String userId, String token, Timestamp tokenExpiresTime);

    /**
     * 创建token
     * @param userId
     * @param token
     * @param tokenExpiresTime
     * @param openId
     * @param source
     */
    public void createToken(String userId, String token, Timestamp tokenExpiresTime, String openId, int source,String sessionKey);

    /**
     * 通过token删除访问令牌信息
     * @param accessToken
     */
    public void deleteByAccessToken(String accessToken);

    /**
     * 更新token失效时间
     * @param userId
     * @param token
     * @param tokenExpiresTime
     */
    public void updateTokenExpiresTime(String userId, String token, Timestamp tokenExpiresTime);

    /**
     * 通过用户id查找令牌信息
     * @param userId
     * @return
     */
    public AccessToken findByUserIdAndOpenIdAndSource(String userId, String openId, int source);

    /**
     * 通过token获取令牌信息
     * @param toekn
     * @return
     */
    public AccessToken findByAccessToken(String token);

    /**
     * 获取所有未过期token
     * @return
     */
    public List<AccessToken> findAllUnexpiredToken();

    /**
     * 获取所有过期token
     * @return
     */
    public List<AccessToken> findAllExpiredToken();

}
