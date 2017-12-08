package com.design.util.aop;

import com.design.util.annotaion.MyPermission;
import com.design.util.annotaion.PermissionType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ke Zhang on 2017/12/8.
 */
@Component
@Aspect
public class PermissionAspect {

    private static final String DEFAULT_TOKEN_NAME = "elevator-token";

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Around("@annotation(permission)")
    public Object execute(ProceedingJoinPoint pjp, MyPermission permission) throws Throwable{
        //该方法需要的权限
        PermissionType[] permissionType = permission.value();
        httpServletRequest.getHeader(DEFAULT_TOKEN_NAME);

        return null;
    }
}
