package com.example.auditdemo.audit.config.handler;

import com.example.auditdemo.audit.config.AuditContextConstans;
import com.example.auditdemo.audit.config.AuditEvent;
import com.example.auditdemo.audit.config.bean.AuditPermit;
import com.example.auditdemo.core.config.Handler;
import com.example.auditdemo.core.fire.StateMachine;
import com.example.auditdemo.core.fire.TransactionContext;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jetty on 2019/7/31.
 */
@Slf4j
public class AuditFailHandler implements Handler
{
    public void handle(TransactionContext context, StateMachine stateMachine) {
        AuditPermit auditPermit=(AuditPermit)context.getData(AuditContextConstans.LEAVE_PERMIT);
        auditPermit.setStatus("FAIL");
        log.info("[{}],permit=[{}],审批意见:[{}]", this.getClass().getSimpleName(), auditPermit);
    }
}