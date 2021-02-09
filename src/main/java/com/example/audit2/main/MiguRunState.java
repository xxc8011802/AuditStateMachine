package com.example.audit2.main;

import com.example.audit2.AuditRecord;
import com.example.audit2.AuditRecordState;

public class MiguRunState extends AuditRecordState
{
    public MiguRunState(AuditRecord auditRecord)
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
        System.out.println("审核中记录不能进行分配");
    }

    @Override
    public void audit()
    {
        System.out.println("进行主站审核");
    }

    @Override
    public void pass(String condition)
    {
        // 1、变化为主站审核通过状态
        this.auditRecord.setState(auditRecord.getMiguPassState());
        // 2、审核通过
        this.auditRecord.pass(condition);
    }

    @Override
    public void reject()
    {
        // 1、变化为审核驳回状态
        this.auditRecord.setState(auditRecord.getRejectState());
        // 2、审核驳回
        this.auditRecord.reject();
    }
}
