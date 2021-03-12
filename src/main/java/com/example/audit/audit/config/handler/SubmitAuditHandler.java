package com.example.audit.audit.config.handler;

import com.example.audit.audit.config.AuditContextConstans;
import com.example.audit.audit.config.AuditEvent;
import com.example.audit.audit.config.bean.AuditPermit;
import com.example.audit.core.config.Handler;
import com.example.audit.core.fire.StateMachine;
import com.example.audit.core.fire.TransactionContext;
import com.example.audit.mapper.audit.AuditBookInfoMapper;
import com.example.audit.service.audit.impl.AuditServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jetty on 2019/7/31.
 */
@Slf4j
@Component
public class SubmitAuditHandler implements Handler
{
    @Autowired
    AuditServiceImpl auditServiceImpl;

    public void handle(TransactionContext context, StateMachine stateMachine) {
        AuditPermit auditPermit=new AuditPermit();
        auditPermit.setPermitNo("PERMITN");
        auditPermit.setStatus("提交审核");//设置为初始状态
        log.info("[{}],permit=[{}]", this.getClass().getSimpleName(), auditPermit);
        context.setData(AuditContextConstans.LEAVE_PERMIT, auditPermit);
        //先查询该记录
        //-----------------------------------------//
        //获取图书Id,新建一条审核记录
        String bookId = (String)context.getData("bookId");
        //AuditServiceImpl AuditServiceImpl = new AuditServiceImpl();
        auditServiceImpl.submit(bookId);
        //-----------------------------------------//
        //提交完后是自动去触发分配事件
        stateMachine.fire(AuditEvent.AUDIT_ASSIGN,context);
    }
}
