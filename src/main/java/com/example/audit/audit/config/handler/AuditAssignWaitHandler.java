package com.example.audit.audit.config.handler;

import com.example.audit.audit.config.AuditContextConstans;
import com.example.audit.audit.config.bean.AuditPermit;
import com.example.audit.core.config.Handler;
import com.example.audit.core.fire.StateMachine;
import com.example.audit.core.fire.TransactionContext;
import com.example.audit.service.audit.impl.AuditServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jetty on 2019/7/31.
 */
@Slf4j
public class AuditAssignWaitHandler implements Handler{

    public void handle(TransactionContext context, StateMachine stateMachine) {
       AuditPermit auditPermit=(AuditPermit)context.getData(AuditContextConstans.LEAVE_PERMIT);
        auditPermit.setStatus("等待分配");
        log.info("[{}],permit=[{}]", this.getClass().getSimpleName(),auditPermit);
        String auditAssign=(String)context.getData(AuditContextConstans.AUDIT_ASSIGN);
        //如果未分配，等待分配
        if(auditAssign==null){
            log.info("等待分配");
            //----------------------------------//
            //获取图书Id,更新该图书审核记录的状态为待分配
            String bookId = (String)context.getData("bookId");
            AuditServiceImpl AuditServiceImpl = new AuditServiceImpl();
            AuditServiceImpl.submit(bookId);
            //----------------------------------//
            return;
        }
    }
}
