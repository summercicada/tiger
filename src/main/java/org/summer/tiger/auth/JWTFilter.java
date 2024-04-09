package org.summer.tiger.auth;

import com.google.common.net.HttpHeaders;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (!request.getServletPath().startsWith("/security/dont")) {
            filterChain.doFilter(request, response);
        }

        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);



        filterChain.doFilter(request, response);
    }
}
