package com.example.audit.audit.config.handler;


import com.example.audit.audit.config.AuditContextConstans;
import com.example.audit.audit.config.AuditEvent;
import com.example.audit.audit.config.bean.AuditPermit;
import com.example.audit.core.config.Handler;
import com.example.audit.core.fire.StateMachine;
import com.example.audit.core.fire.TransactionContext;
import com.example.audit.service.audit.AuditService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * Created by jetty on 2019/7/31.
 */
@Slf4j
public class SubmitAuditHandler implements Handler
{
    @Resource
    AuditService auditService;

    public void handle(TransactionContext context, StateMachine stateMachine) {
        AuditPermit auditPermit=new AuditPermit();
        auditPermit.setPermitNo("PERMITN");
        auditPermit.setStatus("提交审核");//设置为初始状态
        log.info("[{}],permit=[{}]", this.getClass().getSimpleName(), auditPermit);
        //获取图书Id,创建插入审核记录
        String bookId = (String)context.getData("bookId");
        auditService.submit(bookId);

        context.setData(AuditContextConstans.LEAVE_PERMIT, auditPermit); //
        //提交完后是自动去触发分配事件
        stateMachine.fire(AuditEvent.AUDIT_ASSIGN,context);
    }
}
