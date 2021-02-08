package com.example.auditdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AssignController
{
    //分配审核员
    @RequestMapping("/assign")
    public String assign(){

        return null;
    }
}
