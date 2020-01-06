package com.topsail.crm.framework.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topsail.crm.framework.util.ResultUtils;
import com.topsail.crm.upc.common.data.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证成功处理器
 *
 * @author Steven
 * @date 2019-09-10
 */
@Component
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        // Authentication接口封装认证信息
        log.info("Authentication success: {}", authentication.getName());

        String token = TokenContext.associateWithToken(authentication.getName());
        request.getSession().setAttribute("token", token);

        Result result = ResultUtils.success(authentication);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }

}
