package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //1. 원격 호출 가능한 프로그램으로 등록
public class MainController {
    @RequestMapping("/") //2. URL과 메서드 연결(맵핑)
    public String main(){
        return "index";
    }
}