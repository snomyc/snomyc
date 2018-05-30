package com.snomyc.base.security;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snomyc.base.security.annotation.IgnoreSecurity;
import com.snomyc.base.security.exception.TokenException;
import com.snomyc.base.security.manager.TokenManager;

/**
 * 
 * 类名称：SecurityAspect<br>
 * 类描述：用于检查 token 的切面<br>
 * @version v1.0
 *@Aspect
 */
@Aspect
@Component
public class SecurityAspect {

    private static final String DEFAULT_TOKEN_NAME = "accessToken";

    @Autowired
    private TokenManager tokenManager;
    private String tokenName;

    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    public void setTokenName(String tokenName) {
        if (StringUtils.isEmpty(tokenName)) {
            tokenName = DEFAULT_TOKEN_NAME;
        }
        this.tokenName = tokenName;
    }

    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();


        String uri = WebContext.getRequest().getRequestURI().replaceAll(WebContext.getRequest().getContextPath(), "");

        // 若目标方法忽略了安全性检查或不为ajax请求，则直接调用目标方法
        if (method.isAnnotationPresent(IgnoreSecurity.class)  || (!StringUtils.startsWith(uri, "/wxapi/") && !StringUtils.startsWith(uri, "/api/"))) {
            return pjp.proceed();
        }
        // 从 request header 中获取当前 token
        String token = StringUtils.isBlank(WebContext.getRequest().getHeader(tokenName)) ? WebContext.getRequest().getParameter("accessToken") : WebContext.getRequest().getHeader(tokenName);
        // 检查 token 有效性
        if ( token ==null || !tokenManager.checkToken(token) ) {
            String message = String.format("token [%s] is invalid", token);
            throw new TokenException(message);
        }
        // 调用目标方法
        return pjp.proceed();
    }
}
