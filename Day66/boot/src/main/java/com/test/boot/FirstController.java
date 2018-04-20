package com.test.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class FirstController {
    @RequestMapping("print")
    @ResponseBody
    public  String print(){
        return "Springboot";
    }
}
