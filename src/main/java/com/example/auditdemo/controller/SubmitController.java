package com.example.auditdemo.controller;

import com.example.auditdemo.audit.config.AuditContextConstans;
import com.example.auditdemo.audit.config.AuditEvent;
import com.example.auditdemo.audit.config.AuditState;
import com.example.auditdemo.core.fire.StateMachineFactory;
import com.example.auditdemo.core.fire.TransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SubmitController
{
    @RequestMapping("/submit")
    public String submit(String bookId){

        log.info("作家提交审核");
        TransactionContext transactionContext=new TransactionContext();
        //设置当前提交状态
        transactionContext.setData(AuditContextConstans.CURRENT_STATE, AuditState.SUBMIT_AUDIT);
        //塞入图书id创建审核记录
        transactionContext.setData(bookId,"1");
        StateMachineFactory.getStateMachine("LEAVE_PERMIT").fire(AuditEvent.SUBMIT_AUDIT, transactionContext);

        return null;
    }
}
