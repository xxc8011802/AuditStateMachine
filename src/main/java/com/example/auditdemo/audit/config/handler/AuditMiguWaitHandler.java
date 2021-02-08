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
public class AuditMiguWaitHandler implements Handler{

    public void handle(TransactionContext context, StateMachine stateMachine) {
       AuditPermit auditPermit=(AuditPermit)context.getData(AuditContextConstans.LEAVE_PERMIT);
        auditPermit.setStatus("等待主站审核");
        log.info("[{}],permit=[{}]", this.getClass().getSimpleName(),auditPermit);
        String auditMiguSuggestion=(String)context.getData(AuditContextConstans.AUDIT_MIGU_SUGGESTION);
        //如果未审核，等待主站审核
        if(auditMiguSuggestion==null){
            log.info("等待主站审核");
            return;
        }
    }
}
