package com.example.audit2.state.assign;

import com.example.audit2.constants.StateEnum;
import com.example.audit2.state.AuditRecord;
import com.example.audit2.state.AuditRecordState;

public class AssignFinState extends AuditRecordState
{
    public AssignFinState(AuditRecord auditRecord)
    {
        super(auditRecord);
    }

    @Override
    public void create()
    {

    }

    @Override
    public void assign()
    {
        System.out.println("审核分配通过");
        this.auditRecord.audit();
        //this.auditRecord.setState(auditRecord.getAssignFinState());
    }

    @Override
    public void audit()
    {
        // 1、变化为初审中状态
        //this.auditRecord.setState(auditRecord.getAuditRunState());
        this.auditRecord.setState(StateEnum.auditRunState);
        // 2、执行初审
        this.auditRecord.audit();
    }

    @Override
    public void pass(String condition)
    {
        System.out.println("分配中的审核记录不能通过");
    }

    @Override
    public void reject()
    {
        System.out.println("分配中的审核记录不能驳回");
    }
}
