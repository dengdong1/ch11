package cn.intro.action;

import cn.intro.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class InterceptorAction extends ActionSupport {

    //前台登录的User
    private User user;

    //Session判断的User
    private User loginUser;

/*    public String myInvocation() {
        System.out.println("myInvocation method");
        return "myInvocation";
    }*/

        public String myInvocation(){
            System.out.println("this is myInvocation");
            return "myInvocation";
        }

        public String login(){
            System.out.println("login Interceptor");

            if(null!=user.getUserName()){
                if(user.getUserName().equals("admin")){
                    loginUser=user;
                }
            }
            Map session=ActionContext.getContext().getSession();
            session.put("loginUser",loginUser);

            return "success";
        }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }
}
