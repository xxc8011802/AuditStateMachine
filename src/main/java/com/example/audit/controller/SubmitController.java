package com.example.audit.controller;

import com.example.audit.audit.config.AuditContextConstans;
import com.example.audit.audit.config.AuditEvent;
import com.example.audit.audit.config.AuditState;
import com.example.audit.core.fire.StateMachineFactory;
import com.example.audit.core.fire.TransactionContext;
import com.example.audit2.state.AuditRecord;
import com.example.audit2.state.NewState;
import com.example.audit.service.audit.AuditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        transactionContext.setData("bookId",bookId);
        StateMachineFactory.getStateMachine("LEAVE_PERMIT").fire(AuditEvent.SUBMIT_AUDIT, transactionContext);
        //获取图书Id,创建插入审核记录
        return null;
    }
}
