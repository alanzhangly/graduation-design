package com.design.util.aop;

import com.design.util.annotaion.LogAuto;
import com.design.util.exception.DesignCommonException;
import com.design.util.utils.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 */
@Component
@Aspect
public class LogAop {
    private final static Logger logger = LoggerFactory.getLogger(LogAop.class);

    private final static Logger monitor_logger = LoggerFactory.getLogger("LogMonitor");

    private static String ip_address = null;

    static {
        try {
            ip_address = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {

            logger.error("获取本地IP信息异常 请检查..");
        }
    }

    @Around("@annotation(logAuto)")
    public Object aroud(ProceedingJoinPoint pjp, LogAuto logAuto) throws Throwable {

        Object result = null;
        LogAuto.ParamPrintOption printOption = logAuto.outParamPrint();
        long current_time = System.currentTimeMillis();
        // 防止入参字符串中含有管道符出现异常,替换掉入参的管道符
        String inParam = Arrays.toString(pjp.getArgs()).replaceAll("[|]","#");
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        String relateId = String.valueOf(new StringBuilder(String.valueOf(current_time)).append(className).append(methodName).toString().hashCode());


        try {

            result = pjp.proceed();

            if (LogAuto.ParamPrintOption.UNCONFIG.equals(printOption)) {
                if (result != null && result instanceof Collection) {
                    printOption = LogAuto.ParamPrintOption.IGNORE;
                } else if (result != null && result.getClass().isArray()) {
                    printOption = LogAuto.ParamPrintOption.IGNORE;
                } else {
                    printOption = LogAuto.ParamPrintOption.PRINT;
                }
            }


            long lastTime = System.currentTimeMillis() - current_time;

            if (lastTime >= 2000) {
                LogUtil.info(logger, "{0}.{1}:{2}该方法执行较慢请检查  入参: {3}, \t出参: {4} 响应时间:{5}毫秒", className,
                        methodName, relateId, inParam,
                        printOption.equals(LogAuto.ParamPrintOption.PRINT) ? result : "", lastTime);
            } else {
                LogUtil.info(logger, "{0}.{1}:{2} 入参: {3} \t出参: {4} 响应时间:{5}毫秒", className,
                        methodName, relateId, inParam, printOption.equals(LogAuto.ParamPrintOption.PRINT) ? result : "", lastTime);
            }

            monitor_logger.info("{}|{}|{}|{}|{}|{}|{}|{}|{}", className, methodName, relateId, "uid/设备ID", logAuto.value(), ip_address, inParam, "T", lastTime);

        } catch (DesignCommonException ex) {
            LogUtil.error(logger, ex, "{0}.{1}:{2} 执行报错,入参: {3}", pjp.getTarget().getClass().getName(),
                    pjp.getSignature().getName(), relateId, Arrays.toString(pjp.getArgs()));

            monitor_logger.info("{}|{}|{}|{}|{}|{}|{}|{}|{}", className, methodName, relateId, "uid/设备ID", logAuto.value(), ip_address, inParam, "T", 0);

            throw ex;
        } catch (Throwable throwable) {
            LogUtil.error(logger, throwable, "{0}.{1}:{2} 执行报错,入参: {3}", pjp.getTarget().getClass().getName(),
                    pjp.getSignature().getName(), relateId, Arrays.toString(pjp.getArgs()));

            monitor_logger.info("{}|{}|{}|{}|{}|{}|{}|{}|{}", className, methodName, relateId, "uid/设备ID", logAuto.value(), ip_address, inParam, "F", 0);

            throw throwable;
        }

        return result;

    }
}
