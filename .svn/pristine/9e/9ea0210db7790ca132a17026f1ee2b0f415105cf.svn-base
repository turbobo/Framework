package com.wonders.base.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
@Component
public class BaseFilter extends ZuulFilter {
    // 指定过滤器的类型，一共有4种类型，包括 PRE、POST、ROUTING、ERROR
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    // 过滤器的执行顺序，值越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    // 表示该过滤器是否执行过滤逻辑，为true则执行run()方法，为false不执行
    @Override
    public boolean shouldFilter() {
        return false;
    }

    // 具体的过滤逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

}
