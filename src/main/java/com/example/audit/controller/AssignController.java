package com.example.audit.controller;

import com.example.audit.audit.config.AuditContextConstans;
import com.example.audit.audit.config.AuditEvent;
import com.example.audit.audit.config.AuditState;
import com.example.audit.audit.config.bean.AuditPermit;
import com.example.audit.core.fire.StateMachineFactory;
import com.example.audit.core.fire.TransactionContext;
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
        log.info("编辑分配审核人员");
        TransactionContext transactionContext=new TransactionContext();
        AuditPermit auditPermit=(AuditPermit)transactionContext.getData(AuditContextConstans.LEAVE_PERMIT);
        TransactionContext transactionContext2=new TransactionContext();
        //设置当前环境状态
        transactionContext2.setData(AuditContextConstans.LEAVE_PERMIT,auditPermit);
        transactionContext2.setData(AuditContextConstans.CURRENT_STATE, AuditState.AUDIT_ASSIGN);
        //分配了复审人员
        //transactionContext2.setData(AuditContextConstans.AUDIT_ASSIGN_REVIEW,"AUDIT_ASSIGN_REVIEW");
        //实际分配完成事件
        StateMachineFactory.getStateMachine("LEAVE_PERMIT").fire(AuditEvent.AUDIT_ASSIGN_FINISH, transactionContext2);
        return null;
    }
}
