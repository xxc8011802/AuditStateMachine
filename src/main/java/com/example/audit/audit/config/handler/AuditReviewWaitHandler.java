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
public class AuditReviewWaitHandler implements Handler{

    public void handle(TransactionContext context, StateMachine stateMachine) {
       AuditPermit auditPermit=(AuditPermit)context.getData(AuditContextConstans.LEAVE_PERMIT);
        auditPermit.setStatus("等待复审审核");
        log.info("[{}],permit=[{}]", this.getClass().getSimpleName(),auditPermit);
        String auditReviewSuggestion=(String)context.getData(AuditContextConstans.AUDIT_REVIEW_SUGGESTION);
        //如果未审核，等待复审
        if(auditReviewSuggestion==null){
            log.info("等待复审");
            return;
        }
    }
}
