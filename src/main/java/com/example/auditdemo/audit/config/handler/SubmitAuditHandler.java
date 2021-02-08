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
public class SubmitAuditHandler implements Handler
{

    public void handle(TransactionContext context, StateMachine stateMachine) {
        AuditPermit auditPermit=new AuditPermit();
        auditPermit.setPermitNo("PERMITN");
        auditPermit.setStatus("提交审核");//设置为初始状态
        log.info("[{}],permit=[{}]", this.getClass().getSimpleName(), auditPermit);
        //获取图书Id,创建审核记录
        context.getData("bookId");

        context.setData(AuditContextConstans.LEAVE_PERMIT, auditPermit); //
        //提交完后是自动去触发分配事件
        stateMachine.fire(AuditEvent.AUDIT_ASSIGN,context);
    }
}
