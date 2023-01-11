package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@Controller
public class YoilTeller { //년월일을 입력하면 해당 날짜의 요일이 출력됨
//    public static void main(String[] args) {
    @RequestMapping("/getYoil")
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //입력
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        // int로 변환
        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        // 날짜 계산
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm-1, dd);


        int datOfWeek = cal.get(Calendar.DAY_OF_WEEK);//요일이 숫자로 나온다 1:일요일, 2:월요일
        char yoil = " 일월화수목금토".charAt(datOfWeek);//숫자를 문자로 바꿔줌 1이면 '일'

//        System.out.println(year +"년 " + month + "월 " + day +"일은 ");
//        System.out.println(yoil + "요일입니다. ");

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter(); //response 객체에서 브라우져로의 출력 스트림을 얻는다
        out.println(year +"년 " + month + "월 " + day +"일은 ");
        out.println(yoil + "요일입니다. ");
    }
}
