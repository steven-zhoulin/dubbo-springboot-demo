package com.topsail.crm.framework.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 自定义用户加载服务
 *
 * @author Steven
 * @date 2019-09-09
 */
@Slf4j
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    /**
     * 在 Security 中，角色和权限共用 GrantedAuthority 接口，唯一的不同角色就是多了个前缀 "ROLE_"
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserContext userContext = new UserContext();

        // 查询用户


        // 查用户角色


        // 根据角色查操作权限


        // 加载操作权限


        // 设置用户角色


        // 查登录用户的 orgId, employeeId


        return userContext;
    }

}