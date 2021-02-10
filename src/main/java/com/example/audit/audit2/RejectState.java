package com.example.audit.audit2;

public class RejectState extends AuditRecordState
{
    public RejectState(AuditRecord auditRecord)
    {
        super(auditRecord);
    }

    @Override
    public void create()
    {
        System.out.println("记录已驳回，请停止操作");
    }

    @Override
    public void assign()
    {
        System.out.println("记录已驳回，请停止操作");
    }

    @Override
    public void audit()
    {
        System.out.println("记录已驳回，请停止操作");
    }

    @Override
    public void pass(String condition)
    {
        System.out.println("记录已驳回，请停止操作");
    }

    @Override
    public void reject()
    {
        System.out.println("审核驳回");
    }
}
