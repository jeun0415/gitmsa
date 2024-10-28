package com.cew.org.filter;

import com.cew.org.error.UserException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    public SecurityFilter(JWTUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info("Security Filter");

        String authorization = request.getHeader("Authorization");
        log.info("Security Filter"+authorization);

        // securityContextHolder 안 만듦
        if(authorization == null || !authorization.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        // securityContextHolder 만듦
        String jwt = authorization.split("Bearer ")[1];
        String email = jwtUtils.getEmailFromJwt(jwt);
        String role = jwtUtils.getRoleFromJwt(jwt);

        if (email == null){
            throw new UserException("user email not found");
        }



        Authentication authentication = new UsernamePasswordAuthenticationToken(
                User.builder()
                        .username(email)
                        .password("temp")
                        .roles(role)
                        .build(),
                null
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

//        SecurityContextHolder.getContext()
//                .setAuthentication(authentication);

        // JWT token Valid
        // 다음 요청으로 진행해라
        filterChain.doFilter(request, response);
    }
}
