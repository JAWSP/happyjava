package com.example.rest.controller;

import com.example.rest.domain.UploadInfo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@Slf4j
public class FileController {
    //파일 다운로드
    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response) {
        //다운 받을 경로 가져오기
       Path path= Paths.get("src/main/resources/static/images/k02u9w0tsla57brd27o3.jpg");
       //다운 받을 파일의 타입 정하기
       response.setContentType("image/jpeg");
       //파일 입출력은 try-catch로 묶어줘야 함
        //경로에 따른 입력 스트림 생성
       try (InputStream inputStream = Files.newInputStream(path)) {
           //이 스트림을 응답 객체에 복사시킴
           StreamUtils.copy(inputStream, response.getOutputStream());
           //그리고 버퍼를 초기화(중복될 수 있으니)
           response.flushBuffer();
       } catch (IOException e) {
           log.info("io error");
       }
    }

    //파일 업로드
    @PostMapping("/upload")
    public ResponseEntity<String> uploadfile(
            //파일에 대한정보와,
            @RequestParam("file")MultipartFile file
           // @RequestParam(name = "info", required = false)UploadInfo uploadInfo
            ) {
        //여기서 부터 함수내용
        //얜 그냥 파일명 확인
        log.info(file.getOriginalFilename());
        //메세지초기화
        String msg="";
        //인자로 받은 파일을 정보를 바탕으로 입력 스트림을 초기화
        try(InputStream inputStream = file.getInputStream()) {

            //요청 받은 부분을 바탕으로 파일을 저장
            //안풋 -> 내쪽으로 아웃풋
            StreamUtils.copy(inputStream,
                    new FileOutputStream("src/main/resources/static/images/"+file.getOriginalFilename()));
            return ResponseEntity.ok().body("파일 저장 성공");
        }catch (IOException e) {
            return ResponseEntity
                    .badRequest()
                    .body("파일 업로드가 안됨"+file.getOriginalFilename());
        }
    }
}
