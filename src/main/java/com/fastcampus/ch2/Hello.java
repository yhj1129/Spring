package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
    @RequestMapping("/hello") //hello url과 메인 메서드가 연결된 것
    private void main(){
        //static 없는데 왜 되는지 = url로 호출하면 톰캣이 객체를 생성해준다
        //그래서 인스턴스 메서드여도 된다
        //왜 인스턴스 메서드로 할까 = 인스턴스 메서드는 iv(인스턴스 변수)와 cv(스태틱 변수, 공유 변수) 모두 사용가능
        // static 메서드는 cv만 사용가능해서 iv쓰면 오류
        // private void main() 도 가능 = RequestMapping으로 연결하겠다는 것은 외부에서 사용하겠다는 의미라 접근 제어자는 상관 없다

        System.out.println("Hellop");
    }
}
