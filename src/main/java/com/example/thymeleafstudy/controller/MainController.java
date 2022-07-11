package com.example.thymeleafstudy.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public static String main(@NotNull Model model){
        Map<String, Object> foodMap = new HashMap<String, Object>();
        foodMap.put("food1", "치킨");
        foodMap.put("food2", "<strong>피자</strong>");
        foodMap.put("food3", "삼겹살");
        foodMap.put("food4", "파스타");

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for(int i=0; i<10; i++){
            Map<String, Object> listMap = new HashMap<String, Object>();
            listMap.put("userName", "userName"+i);
            listMap.put("userId", "userId"+i);
            list.add(listMap);
        }

        model.addAttribute("list", list);
        model.addAttribute("foodMap", foodMap);
        model.addAttribute("localDateTime", LocalDate.now());
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        model.addAttribute("localDateTime", LocalDate.now());
        return "index.html";
    }

    @Component("helloBean")
    static class HelloBean{
        public String hello(String data){
            return "Hello" +data;
        }
    }



}
