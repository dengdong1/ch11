package cn.intro.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyTimerInterceptor extends AbstractInterceptor {


    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        long starTime=System.currentTimeMillis();
        System.out.println("开始时间:"+starTime);
        //执行后拦截器或Action
        String result=actionInvocation.invoke();
        //结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("结束时间"+endTime);
        long execTime=starTime-endTime;
        System.out.println("总用时间时间"+execTime);
        //返回结果字符串
        return result;
    }
}
