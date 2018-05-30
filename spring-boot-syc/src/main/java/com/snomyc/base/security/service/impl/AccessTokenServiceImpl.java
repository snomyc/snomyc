package com.snomyc.base.security.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.snomyc.base.security.dao.AccessTokenDao;
import com.snomyc.base.security.domain.AccessToken;
import com.snomyc.base.security.service.AccessTokenService;
import com.snomyc.base.service.BaseServiceImpl;


/**
 * 
 * 类名称：AccessTokenServiceImpl<br>
 * 类描述：访问令牌服务接口实现<br>
 * @version v1.0
 *
 */
@Service
public class AccessTokenServiceImpl extends BaseServiceImpl<AccessToken, String> implements AccessTokenService {

    @Autowired
    private AccessTokenDao accessTokenDao;

    @Override
    public PagingAndSortingRepository<AccessToken, String> getDao() {
        return accessTokenDao;
    }

    /*
     * (non-Javadoc)
     */
    public void createToken(String userId, String token) {
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(token);
        accessToken.setUserId(userId);
        accessToken.setCreatedDate(new Date());
        accessTokenDao.save(accessToken);
    }

    /*
     * (non-Javadoc)
     */
    public void deleteByAccessToken(String accessToken) {
        accessTokenDao.deleteByAccessToken(accessToken);
    }

    /*
     * (non-Javadoc)
     */
    public void updateTokenExpiresTime(String userId, String token, Timestamp tokenExpiresTime) {
        accessTokenDao.updateTokenExpiresTime(userId, token, tokenExpiresTime);
    }

    /*
     * (non-Javadoc)
     */
    public void createToken(String userId, String token, Timestamp tokenExpiresTime) {
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(token);
        accessToken.setUserId(userId);
        accessToken.setTokenExpiresTime(tokenExpiresTime);
        accessToken.setCreatedDate(new Date());
        accessTokenDao.save(accessToken);
    }

    /*
     * (non-Javadoc)
     */
    public List<AccessToken> findAllUnexpiredToken() {
        return accessTokenDao.findByTokenExpiresTimeGreaterThan(new Timestamp(System.currentTimeMillis()));
    }

    /*
     * (non-Javadoc)
     */
    public List<AccessToken> findAllExpiredToken() {
        return accessTokenDao.findByTokenExpiresTimeLessThan(new Timestamp(System.currentTimeMillis()));
    }

    /*
     * (non-Javadoc)
     */
    public AccessToken findByAccessToken(String token) {
        return accessTokenDao.findByAccessToken(token);
    }

    /*
     * (non-Javadoc)    
     */
    public void createToken(String userId, String token, Timestamp tokenExpiresTime, String openId, int source,String sessionKey) {
        AccessToken	accessToken = new AccessToken();
        accessToken.setUserId(userId);
        accessToken.setOpenId(openId);
        accessToken.setSource(source);
        accessToken.setCreatedDate(new Date());
        accessToken.setAccessToken(token);
        accessToken.setSessionKey(sessionKey);
        accessToken.setTokenExpiresTime(tokenExpiresTime);
        accessTokenDao.save(accessToken);
    }

    /*
     * (non-Javadoc)    
     */
    public AccessToken findByUserIdAndOpenIdAndSource(String userId, String openId, int source) {
        return accessTokenDao.findByUserIdAndOpenIdAndSource(userId, openId, source);
    }

}
