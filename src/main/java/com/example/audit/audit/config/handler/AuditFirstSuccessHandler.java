package com.example.audit.audit.config.handler;

import com.example.audit.audit.config.AuditContextConstans;
import com.example.audit.audit.config.AuditEvent;
import com.example.audit.audit.config.AuditState;
import com.example.audit.audit.config.bean.AuditPermit;
import com.example.audit.core.config.BaseStateMachineKey;
import com.example.audit.core.config.Handler;
import com.example.audit.core.fire.StateMachine;
import com.example.audit.core.fire.TransactionContext;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jetty on 2019/7/31.
 */
@Slf4j
public class AuditFirstSuccessHandler implements Handler
{
    public void handle(TransactionContext context, StateMachine stateMachine) {
        AuditPermit auditPermit=(AuditPermit)context.getData(AuditContextConstans.LEAVE_PERMIT);
        auditPermit.setStatus("初审成功");
        log.info("[{}],permit=[{}],审批意见:[{}]", this.getClass().getSimpleName(), auditPermit);
        String auditReviewAssign=(String)context.getData(AuditContextConstans.AUDIT_ASSIGN_REVIEW);
        //分配复审
        if(auditReviewAssign!=null){
            context.setData(BaseStateMachineKey.CURRENT_STATE, AuditState.AUDIT_REVIEW);
            stateMachine.fire(AuditEvent.AUDIT_REVIEW,context);
        }else{
            //未分配复审
            context.setData(BaseStateMachineKey.CURRENT_STATE, AuditState.AUDIT_MIGU);
            stateMachine.fire(AuditEvent.AUDIT_MIGU,context);
        }
    }
}