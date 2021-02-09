package com.example.audit2;

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
        System.out.println("进行审核人员分配");
    }

    @Override
    public void audit()
    {
        // 1、变化为初审中状态
        this.auditRecord.setState(auditRecord.getAuditRunState());
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
