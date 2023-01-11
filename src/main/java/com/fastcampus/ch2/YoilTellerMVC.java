package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTellerMVC {//http://localhost/ch2/getYoilMVC?year=2023&month=1&day=10
    @RequestMapping("/getYoilMVC")
    public String main(int year, int month, int day, Model model) throws IOException {
        //1. 유효성 검사
        if (!isValid(year, month, day))
            return "yoilError"; //에러시 출력할 jsp파일 지정

        //2. 요일 계산
        char yoil = getYoil(year, month, day);

        //3. 계산한 결과 모델에 저장
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
        return "yoil"; //출력할 jsp파일 지정, 반환타입 String으로
    }

    private boolean isValid(int year, int month, int day) {
        return false;
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);

        int datOfWeek = cal.get(Calendar.DAY_OF_WEEK);//요일이 숫자로 나온다 1:일요일, 2:월요일
        return " 일월화수목금토".charAt(datOfWeek);
    }
}
