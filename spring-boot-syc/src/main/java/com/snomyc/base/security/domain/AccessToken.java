package com.snomyc.base.security.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.snomyc.base.domain.BaseEntity;


/**
 * 
 * 类名称：AccessToken<br>
 * 类描述：访问令牌<br>
 * @version v1.0
 *
 */
@Entity
@Table(name = "tb_user_access_token")
public class AccessToken extends BaseEntity {

    private static final long serialVersionUID = -3031263779646876634L;

    private String accessToken;//访问令牌,uuid
    private String userId;//账户id
    private Timestamp tokenExpiresTime;//令牌过期时间
    private String openId;//openId
    private Integer source;//登录设备类型 1-andriod 2-ios 3-html5 4 -小程序
    private Date createdDate;//创建时间
    private Date updatedDate;//updated_date
    private String sessionKey;

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

  

    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getTokenExpiresTime() {
        return tokenExpiresTime;
    }
    public void setTokenExpiresTime(Timestamp tokenExpiresTime) {
        this.tokenExpiresTime = tokenExpiresTime;
    }

   
    
    public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getSource() {
        return source;
    }
    
    public void setSource(Integer source) {
        this.source = source;
    }
    
    @Column(updatable = false)
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(insertable = false, updatable = false)
    public Date getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
    
    
}
