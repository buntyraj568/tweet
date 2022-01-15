package com.example.tweetProject.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomCorsFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;

        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", "*");
//      response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
//      response.setHeader("Access-Control-Allow-Origin",
//                   "http://projectang-env.elasticbeanstalk.com");
        response.setHeader("Access-Control-Request-Headers", " Content-Type, Accept");
        response.setHeader("Access-Control-Expose-Headers",
                "x-auth-token,x-local-token,Content-Disposition,X-Local-Token-Refresh, Authorization, refresh_token");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, Key,x-auth-token,X-CSRF-TOKEN,x-local-token, Authorization, refresh_token");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
//      response.setHeader("Access-Control-Allow-Credentials", "true");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            if (request.getServletPath().contains("/trackoweb/") || request.getServletPath().contains("/assets/")) {
                response.setHeader("Cache-Control", "max-age=3600, must-revalidate");
            } else {
                response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
                response.setHeader("Pragma", "no-cacheExpires");
                response.setHeader("Expires", "0");
            }
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
