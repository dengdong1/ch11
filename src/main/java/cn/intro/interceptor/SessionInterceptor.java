package cn.intro.interceptor;

import cn.intro.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class SessionInterceptor extends AbstractInterceptor{

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String result=actionInvocation.invoke();
        //获取会话信息
        Map session=actionInvocation.getInvocationContext().getSession();
        User user= (User) session.get("loginUser");
        if(user==null){
            return "input";
        }else{
            return result;
        }
    }
}
