package com.example.jwtex.jwt.exception;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

//AuthenticationEntryPoint 는 시큐리티가 미리 구현해놓은 인터페이스
//그 인터페이스가 인증되지 않은 사용자가 접근시 동작하는 인터페이스라고 한다
@Slf4j
@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {
    //요 메서드를 반드시 오버라이드 시켜줘야한다
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //사용자가 인증되지 않았을때 어떻게 응답할지를 정의

        //시큐리티 필터에서 넣었던 예외를 컨트롤러에서 호출된 여기서 실행된다고 한다
        String exception = (String) request.getAttribute("exception");

        //점마가 rest한 요청이냐
        if (isRestRequest(request)) {
            handleRestResponse(request, response, exception);
        } else {
            //혹은 page로 요청했나
            handlePageResponse(request, response, exception);
        }
    }

    //페이지 요청 중에 예외가 발생하면 로그 남기고 로그인폼으로 리다이렉트시킨다
    //왜 이렇게 하냐고? 로그인
    private void handlePageResponse(HttpServletRequest request, HttpServletResponse response, String exception) throws IOException {
        log.error("Page Request - Commence Get Exception : {}", exception);

        if (exception != null) {
            // 추가적인 페이지 요청에 대한 예외 처리 로직을 여기에 추가할 수 있습니다.
        }

        response.sendRedirect("/loginform");
    }

    //응답객체를 직접 만든다
    private void setResponse(HttpServletResponse response, JwtExceptionCode exceptionCode) throws IOException {
        //응답 객체의 타입을 결정
        response.setContentType("application/json;charset=UTF-8");
        //401응답코드로 만든다
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        //에러 정보를 map으로 만든다고 선언
        HashMap<String, Object> errorInfo = new HashMap<>();
        //에러코드와 메세지를 넣는다
        errorInfo.put("message", exceptionCode.getMessage());
        errorInfo.put("code", exceptionCode.getCode());
        //Gson이라는 라이브러리가 있는데 컬랙터럴 JSON으로 만든다고 한다
        Gson gson = new Gson();
        //JSON으로 만든다
        String responseJson = gson.toJson(errorInfo);
        //그리고 그 부분을 response객체에 넣는다
        response.getWriter().print(responseJson);
    }


    private void handleRestResponse(HttpServletRequest request, HttpServletResponse response, String exception) throws IOException {
        log.error("Rest Request - Commence Get Exception : {}", exception);

        //그냥 예외가 어떤 예외이냐에 따라 메세지와 코드를 넣는다고 생각하면 됨
        if (exception != null) {
            if (exception.equals(JwtExceptionCode.INVALID_TOKEN.getCode())) {
                log.error("entry point >> invalid token");
                setResponse(response, JwtExceptionCode.INVALID_TOKEN);
            } else if (exception.equals(JwtExceptionCode.EXPIRED_TOKEN.getCode())) {
                log.error("entry point >> expired token");
                setResponse(response, JwtExceptionCode.EXPIRED_TOKEN);
            } else if (exception.equals(JwtExceptionCode.UNSUPPORTED_TOKEN.getCode())) {
                log.error("entry point >> unsupported token");
                setResponse(response, JwtExceptionCode.UNSUPPORTED_TOKEN);
            } else if (exception.equals(JwtExceptionCode.NOT_FOUND_TOKEN.getCode())) {
                log.error("entry point >> not found token");
                setResponse(response, JwtExceptionCode.NOT_FOUND_TOKEN);
            } else {
                setResponse(response, JwtExceptionCode.UNKNOWN_ERROR);
            }
        } else {
            setResponse(response, JwtExceptionCode.UNKNOWN_ERROR);
        }
    }

    private boolean isRestRequest(HttpServletRequest request) {
        String requestedWithHeader = request.getHeader("X-Requested-With");
        //왼쪽은 ajax 비동기 요청, 오른쪽은 /api/요청
        //근데 rest를 판단한다고 저 두개가 아니면 무조건 rest가 아니다는건 아님
        //일단은 저 두개만 가지고 판단한다는거
        //점마는 RestController, Controller쪽도 배제함, 이름에 너무 매몰되지 마소
        return "XMLHTTPRequest".equals(requestedWithHeader) || request.getRequestURI().startsWith("/api/");
    }
}
