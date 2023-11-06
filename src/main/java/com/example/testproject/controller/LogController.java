package com.example.testproject.controller;


import com.example.testproject.dto.LogForm;
import com.example.testproject.entity.Log;
import com.example.testproject.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogController {
    @Autowired
    private LogRepository logRepository;

    @GetMapping("/logs/login")
    public String niceToMeetYou(){
        return "/logs/login";
    }
    @PostMapping("/logs/create")
    public String createLog(LogForm form){
        System.out.println(form.toString());
        //1.dto를 entity로 변환
        Log log = form.toEntity();
        System.out.println(log.toString());
        //2. repository로 엔티티를 디비에 저장
        Log saved = logRepository.save(log);
        System.out.println(saved.toString());
        return "";
    }
}
