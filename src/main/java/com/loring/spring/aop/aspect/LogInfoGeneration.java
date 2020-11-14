package com.loring.spring.aop.aspect;


import com.google.gson.Gson;
import com.loring.spring.aop.annotation.LogKey;
import com.loring.spring.aop.manager.model.LogAdmModel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangrongyou@yixin.im on 2018/4/9.
 */
@Component
public class LogInfoGeneration {

    public void processingManagerLogMessage(ProceedingJoinPoint jp, LogAdmModel logBean, Method method) {
        Object[] args = jp.getArgs();
        if(args.length > 0){
            Gson gson = new Gson();
            Map<String,Object> map = new HashMap<>();
            // 获取方法上参数的注解
            Annotation[][] methodAnnotations = method.getParameterAnnotations();
            for(int i = 0; i < args.length; i++){
                Object arg = args[i];
                // 如果参数被 LogKey 注解了，则直接返回内容
                if(checkArgAnnotationWithIsLogKey(arg, i, methodAnnotations, gson)){
                   continue;
                }

                Field[] fs = arg.getClass().getDeclaredFields();
                for (Field f : fs) {
                    Annotation[] ans = f.getAnnotations();
                    for (Annotation an : ans) {
                        if ((an instanceof LogKey) && (((LogKey) an).isLog())) {
                            String fieldName = f.getName();
                            // 如果注解的有定义keyName，则覆盖对象成员变量名称
                            String fieldNameLogkey = ((LogKey)an).keyName();
                            if(!StringUtils.isEmpty(fieldNameLogkey)){
                                fieldName = fieldNameLogkey;
                            }
                            try {
                                f.setAccessible(true);
                                Object fieldValue = f.get(arg);
                                map.put(fieldName, fieldValue);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } finally {
                                f.setAccessible(false);
                            }
                        }
                    }
                }
                logBean.setAdmOptContent(gson.toJson(map));
            }

        }
    }

    /**
     * 如果方法参数被Logkey注解，则将获取整个类的信息
     * @param index
     * @param methodAnnotations
     * @param gson
     * @return
     */
    private boolean checkArgAnnotationWithIsLogKey(Object arg, int index, Annotation[][] methodAnnotations, Gson gson) {
        Map<String ,String> map = new HashMap<>();
        for(Annotation annotation : methodAnnotations[index]){
            if(annotation instanceof LogKey){
                LogKey logKey = ((LogKey)annotation);
                if(logKey.isLog()){
                    String keyName = logKey.keyName();
                    map.put(keyName, arg.toString());
                }
                break;
            }
        }
        return false;
    }
}
