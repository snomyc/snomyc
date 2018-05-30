package com.snomyc.base.security.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.snomyc.base.security.domain.AccessToken;

/**
 * 
 * 类名称：AccessTokenDao<br>
 * 类描述：访问 令牌数据访问接口<br>
 * @version v1.0
 *
 */
@Repository
public interface AccessTokenDao extends JpaRepository<AccessToken, String> {

    /**
     * 通过访问令牌查找令牌信息
     * @param accessToken
     */
    public AccessToken findByAccessToken(String accessToken);

    /**
     * 通过令牌删除
     * @param accessToken
     */
    @Query(value = "delete from AccessToken where accessToken = ?1")
    @Modifying
    public void deleteByAccessToken(String accessToken);

    /**
     * 通过用户id查找令牌信息
     * @param userId
     * @param appId
     * @param source
     * @return
     */
    public AccessToken findByUserIdAndOpenIdAndSource(String userId, String openId, int source);

    /**
     * 更新token失效时间
     * @param userId
     * @param token
     * @param tokenExpiresTime
     */
    @Query(value = "update AccessToken set tokenExpiresTime = ?3 where userId = ?1 and accessToken = ?2")
    @Modifying
    public void updateTokenExpiresTime(String userId, String token, Timestamp tokenExpiresTime);

    /**
     * 查询所有未过期的token
     * @param timestamp
     * @return
     */
    public List<AccessToken> findByTokenExpiresTimeGreaterThan(Timestamp tokenExpiresTime);

    /**
     * 查询所有过期的token
     * @param timestamp
     * @return
     */
    public List<AccessToken> findByTokenExpiresTimeLessThan(Timestamp tokenExpiresTime);

}
