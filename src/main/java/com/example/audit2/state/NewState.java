package com.example.audit2.state;

import com.example.audit2.constants.StateEnum;

public class NewState extends AuditRecordState
{

    public NewState(AuditRecord auditRecord)
    {
        super(auditRecord);
    }

    @Override
    public void create()
    {
        System.out.println("新建审核记录");
        this.auditRecord.assign();
    }

    @Override
    public void assign()
    {
        System.out.println("等待审核分配");
        // 1、变化为待分配状态,状态扭转
        //this.auditRecord.setState(auditRecord.getAssignState());
        this.auditRecord.setState(StateEnum.assignState);
    }

    @Override
    public void audit()
    {
        System.out.println("新建状态不能进行审核");
    }

    @Override
    public void pass(String condition)
    {
        System.out.println("新建状态不能进行审核通过");
    }

    @Override
    public void reject()
    {
        System.out.println("新建状态不能进行审核驳回");
    }
}
