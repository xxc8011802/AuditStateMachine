package com.example.audit.controller;

import com.example.audit.mapper.audit.AuditBookInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuditController
{
    @RequestMapping("/audit")
    public String getUserName(){

        return null;
    }
}
