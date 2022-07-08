package com.example.thymeleafstudy.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(@NotNull Model model){
        Map<String, Object> foodMap = new HashMap<String, Object>();
        foodMap.put("food1", "치킨");
        foodMap.put("food2", "<strong>피자</strong>");
        foodMap.put("food3", "삼겹살");
        foodMap.put("food4", "파스타");

        model.addAttribute("foodMap", foodMap);
        model.addAttribute("localDateTime", LocalDate.now());

        return "index.html";
    }

    @GetMapping("/date")
    public String date(@NotNull Model model){
        model.addAttribute("localDateTime", LocalDate.now());
        return "date.html";
    }

    @Component("helloBean")
    static class HelloBean{
        public String hello(String data){
            return "Hello" +data;
        }
    }



}
