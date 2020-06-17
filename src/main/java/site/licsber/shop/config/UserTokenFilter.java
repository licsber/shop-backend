package site.licsber.shop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import site.licsber.shop.model.entity.User;
import site.licsber.shop.service.impl.CheckUserTokenServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "UserTokenFilter", urlPatterns = {
        "/api/v1/comment",
        "/api/v1/userItems",
        "/api/v1/unPublishItem",
        "/api/v1/rePublishItem",
        "/api/v1/buyItem"
})
@Order(1)
public class UserTokenFilter implements Filter {

    final private CheckUserTokenServiceImpl checkUserTokenService;

    public UserTokenFilter(CheckUserTokenServiceImpl checkUserTokenService) {
        this.checkUserTokenService = checkUserTokenService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("userToken");
        if (token != null) {
            log.info(token);
            User user = checkUserTokenService.valid(token);
            if (user != null) {
                servletRequest.setAttribute("user", user);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        response.setStatus(401);
        response.setHeader("WWW-Authenticate", "Use Token for auth.");
    }

}
