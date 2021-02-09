package com.example.audit2;

public class NewState extends AuditRecordState
{

    public NewState(AuditRecord auditRecord)
    {
        super(auditRecord);
    }

    @Override
    public void create()
    {
        System.out.println("已新建审核记录，不能再创建相同审核记录");
    }

    @Override
    public void assign()
    {
        // 1、变化为分配状态
        this.auditRecord.setState(auditRecord.getAssignState());
        // 2、执行分配
        this.auditRecord.assign();
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
