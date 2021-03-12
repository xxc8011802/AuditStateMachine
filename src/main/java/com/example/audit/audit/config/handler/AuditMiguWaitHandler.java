package com.example.audit.audit.config.handler;

import com.example.audit.audit.config.AuditContextConstans;
import com.example.audit.audit.config.bean.AuditPermit;
import com.example.audit.core.config.Handler;
import com.example.audit.core.fire.StateMachine;
import com.example.audit.core.fire.TransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by jetty on 2019/7/31.
 */
@Slf4j
@Component
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
