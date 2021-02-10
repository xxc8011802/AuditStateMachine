package com.example.audit2.state.assign;

import com.example.audit2.constants.StateEnum;
import com.example.audit2.state.AuditRecord;
import com.example.audit2.state.AuditRecordState;

public class AssignState extends AuditRecordState
{
    public AssignState(AuditRecord auditRecord)
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
        System.out.println("进行审核分配");
        //this.auditRecord.setState(auditRecord.getAssignFinState());
        this.auditRecord.setState(StateEnum.assignFinState);
        // 2、执行分配
        this.auditRecord.assign();
    }

    @Override
    public void audit()
    {
        System.out.println("审核记录还未分配,无法进行审核");
    }

    @Override
    public void pass(String condition)
    {
        System.out.println("记录还未分配,审核记录不能通过");
    }

    @Override
    public void reject()
    {
        System.out.println("记录还未分配,审核记录不能驳回");
    }
}
