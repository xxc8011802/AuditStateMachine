package com.example.audit2.state.main;

import com.example.audit2.state.AuditRecord;
import com.example.audit2.state.AuditRecordState;

public class MiguPassState extends AuditRecordState
{
    public MiguPassState(AuditRecord auditRecord)
    {
        super(auditRecord);
    }

    @Override
    public void create()
    {
        System.out.println("主站审核已通过，请停止操作");
    }

    @Override
    public void assign()
    {
        System.out.println("主站审核已通过，请停止操作");
    }

    @Override
    public void audit()
    {
        System.out.println("主站审核已通过，请停止操作");
    }

    @Override
    public void pass(String condition)
    {
        System.out.println("主站审核审核通过");
    }

    @Override
    public void reject()
    {
        System.out.println("主站审核已通过，请停止操作");
    }
}
