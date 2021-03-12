package com.example.audit;

import com.example.audit.audit.config.AuditContextConstans;
import com.example.audit.audit.config.AuditEvent;
import com.example.audit.audit.config.AuditState;
import com.example.audit.audit.config.bean.AuditPermit;
import com.example.audit.core.fire.StateMachineFactory;
import com.example.audit.core.fire.TransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
class AuditDemoApplicationTests
{
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException
    {
/*        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();*/

        log.info("作家创建审核");
        TransactionContext transactionContext=new TransactionContext();
        transactionContext.setData(AuditContextConstans.CURRENT_STATE, AuditState.SUBMIT_AUDIT);
        StateMachineFactory.getStateMachine("LEAVE_PERMIT").fire(AuditEvent.SUBMIT_AUDIT, transactionContext);

        log.info("编辑分配审核人员");
        AuditPermit auditPermit=(AuditPermit)transactionContext.getData(AuditContextConstans.LEAVE_PERMIT);
        TransactionContext transactionContext2=new TransactionContext();
        //设置当前环境状态
        transactionContext2.setData(AuditContextConstans.LEAVE_PERMIT,auditPermit);
        transactionContext2.setData(AuditContextConstans.CURRENT_STATE, AuditState.AUDIT_ASSIGN);
        //分配了复审人员
        //transactionContext2.setData(AuditContextConstans.AUDIT_ASSIGN_REVIEW,"AUDIT_ASSIGN_REVIEW");
        //实际分配完成事件
        StateMachineFactory.getStateMachine("LEAVE_PERMIT").fire(AuditEvent.AUDIT_ASSIGN_FINISH, transactionContext2);

        log.info("初审人员介入审核");
        AuditPermit auditPermit2=(AuditPermit)transactionContext.getData(AuditContextConstans.LEAVE_PERMIT);
        TransactionContext transactionContext3=new TransactionContext();
        transactionContext3.setData(AuditContextConstans.AUDIT_ASSIGN_REVIEW,transactionContext2.getData(AuditContextConstans.AUDIT_ASSIGN_REVIEW));
        transactionContext3.setData(AuditContextConstans.LEAVE_PERMIT,auditPermit2);
        transactionContext3.setData(AuditContextConstans.CURRENT_STATE, AuditState.AUDIT_FIRST);
        StateMachineFactory.getStateMachine("LEAVE_PERMIT").fire(AuditEvent.AUDIT_FIRST_AGREE, transactionContext3);

        //若未分配复审人员，不需要复审人员操作
        if(transactionContext3.getData(AuditContextConstans.AUDIT_ASSIGN_REVIEW)!=null){
            log.info("复审人员介入审核");
            AuditPermit auditPermit3=(AuditPermit)transactionContext.getData(AuditContextConstans.LEAVE_PERMIT);
            TransactionContext transactionContext4=new TransactionContext();
            transactionContext4.setData(AuditContextConstans.LEAVE_PERMIT,auditPermit3);
            transactionContext4.setData(AuditContextConstans.CURRENT_STATE, AuditState.AUDIT_REVIEW);
            StateMachineFactory.getStateMachine("LEAVE_PERMIT").fire(AuditEvent.AUDIT_REVIEW_AGREE, transactionContext4);
        }


        log.info("主站审核");
        AuditPermit auditPermit4=(AuditPermit)transactionContext.getData(AuditContextConstans.LEAVE_PERMIT);
        TransactionContext transactionContext5=new TransactionContext();
        transactionContext5.setData(AuditContextConstans.LEAVE_PERMIT,auditPermit4);
        transactionContext5.setData(AuditContextConstans.CURRENT_STATE, AuditState.AUDIT_MIGU);
        StateMachineFactory.getStateMachine("LEAVE_PERMIT").fire(AuditEvent.AUDIT_MIGU_AGREE, transactionContext5);

        log.info("主站审核通过结束");
    }

}
