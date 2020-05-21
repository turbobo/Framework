package com.wonders.base.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 *测试默认拦截器
 */
@Component
public class DefaultFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(DefaultFilter.class);


    //排除过滤的 uri 地址
    private static final String LOGIN_URI = "/login/login";

    //无权限时的提示语
    private static final String INVALID_TOKEN = "invalid token";
    private static final String INVALID_USERID = "invalid userId";

    /**
     * 指定过滤器的类型
     pre ：可以在请求被路由之前调用
     route ：在路由请求时候被调用
     post ：在route和error过滤器之后被调用
     error ：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }
    /**
     *  指定过滤器的优先级, 0表示优先执行, 因为我们可以写很多个过滤器
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }
    /**
     *  当前过滤器是否开启, true表示开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
     /*   RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info("===uri===", request.getRequestURI());
        //注册和登录接口不拦截，其他接口都要拦截校验 token
        if (LOGIN_URI.equals(request.getRequestURI())) {
            return false;
        }*/
        return true;
      //  return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.err.println("经过了后台的过滤器");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        return null;

    }

}