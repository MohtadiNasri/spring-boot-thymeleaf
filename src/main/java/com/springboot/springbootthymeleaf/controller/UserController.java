package com.springboot.springbootthymeleaf.controller;

import com.springboot.springbootthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("demoGrade")
    public String demo(Model model) {
        model.addAttribute("message", "Hello Thymeleaf");

        double grade = 90.5;
        //to test failing exam resultbon app
        //double grade = 90.5;
        model.addAttribute("grade", grade);
        // as the grade is 90.5 the convertGPA should return
        model.addAttribute("GPA", convertGPA(grade));

        // return to templates/demo.html page.
        return "demo";
    }

    private String convertGPA(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade < 90 && grade >= 80) {
            return "B";
        } else if (grade < 80 && grade >= 70) {
            return "C";
        } else if (grade < 70 && grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @RequestMapping("demoList")
    public String demo2(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Tom", 30));
        userList.add(new User(2, "Jerry", 29));
        userList.add(new User(3, "Nancy", 27));
        model.addAttribute("userList", userList);
        return "demo2";
    }
}
