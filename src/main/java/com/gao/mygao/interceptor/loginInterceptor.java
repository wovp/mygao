package com.gao.mygao.interceptor;

import com.gao.mygao.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClassName: loginInterceptor
 * Package: com.gao.mygao.interceptor
 * Description:
 * Author: my
 * Creat: 2023/4/22 20:24
 * @author 11
 */
public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了拦截器的preHandle方法");
        try {
            HttpSession session = request.getSession();
            // 统一拦截（查询当前session是否存在user）(这里user会在每次登录成功后，写入session)
            String username = (String) session.getAttribute("user");
            if (username != null) {
                return true;
            }
            response.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        // 如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        // 如果设置为true时，请求将会继续执行后面的操作
    }

}
