package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request , HttpServletResponse response){
        String data = request.getParameter("data"); // 문자 타입으로 조회
        Integer integer = Integer.valueOf(data); // 숫자 타입으로 변경
        log.info("integer = {}" , integer);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){
        log.info("data = {}" , data);
        return "ok";
    }

    @GetMapping("/hello-v3")
    public String helloV3(@RequestParam IpPort ipPort){
        log.info("ipPort = {}" , ipPort);
        return "ok";
    }
}
