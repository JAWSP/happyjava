package com.example.jwtex.jwt.filter;

import com.example.jwtex.jwt.exception.JwtExceptionCode;
import com.example.jwtex.jwt.token.JwtAuthenticationToken;
import com.example.jwtex.jwt.util.JwtTokenizer;
import com.example.jwtex.security.dto.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
//extends부분은 한번의 요청에 한번만 실행되는 필터
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtTokenizer jwtTokenizer;

    //jwt인증하는 필터

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("내가 만든 필터가 여기서 실행된다");
        //요청으로부터 토큰을 얻어온다
        String token = getTokken(request);
        //토큰을 시큐리티에 넣어준다
        if (StringUtils.hasText(token)) {
            try{
                Authentication authentication = getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }  catch (ExpiredJwtException e){
                request.setAttribute("exception", JwtExceptionCode.EXPIRED_TOKEN.getCode());
                log.error("Expired Token : {}",token,e);
                SecurityContextHolder.clearContext();
                throw new BadCredentialsException("Expired token exception", e);
                //지원하지 않는 형식의 토큰
            }catch (UnsupportedJwtException e){
                request.setAttribute("exception", JwtExceptionCode.UNSUPPORTED_TOKEN.getCode());
                log.error("Unsupported Token: {}", token, e);
                SecurityContextHolder.clearContext();
                throw new BadCredentialsException("Unsupported token exception", e);
                //토큰이 이상함
            } catch (MalformedJwtException e) {
                request.setAttribute("exception", JwtExceptionCode.INVALID_TOKEN.getCode());
                log.error("Invalid Token: {}", token, e);

                SecurityContextHolder.clearContext();

                throw new BadCredentialsException("Invalid token exception", e);
                //토큰을 못찾음
            } catch (IllegalArgumentException e) {
                request.setAttribute("exception", JwtExceptionCode.NOT_FOUND_TOKEN.getCode());
                log.error("Token not found: {}", token, e);

                SecurityContextHolder.clearContext();

                throw new BadCredentialsException("Token not found exception", e);
            } catch (Exception e) {
                log.error("JWT 필터에 뭔가 에러가 남 : {}", token, e);
                throw new RuntimeException(e);
                //토큰만료
            }
        }

        filterChain.doFilter(request, response);
    }

    private Authentication getAuthentication(String token) {
        Claims claims = jwtTokenizer.parseAccessToken(token);
        String email = claims.getSubject();
        Long userId = claims.get("userId", Long.class);
        String name = claims.get("name", String.class);
        String username = claims.get("username", String.class);
        //권한. 굳이 저런 형태로 바꾸는 이유는 필터가 저걸 원해서
        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(claims);

        //UserDetails
        //패스워드는 안넣었다고..?
        CustomUserDetails customUserDetails = new CustomUserDetails(username, "", name, grantedAuthorities);
        return new JwtAuthenticationToken(grantedAuthorities, customUserDetails, null);
    }

    private List<GrantedAuthority> getGrantedAuthorities(Claims claims) {
       List<String> roles = (List<String>) claims.get("roles");
       return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    private String getTokken(HttpServletRequest request) {
        //요기서 헤더의 정보를 가져온다
        String auth =  request.getHeader("Authorization");
        if (StringUtils.hasText(auth) && auth.startsWith("Bearer "))
            //앞의 Bearer 부분을 빼준다
            return auth.substring(7);
        //쿠키로 받았다면?
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //name에 저걸 넣었으니 일치한놈만 고른다
                if (cookie.getName().equals("accessToken"))
                    return cookie.getValue();
            }
        }
        return null;
    }
}
