package com.example.audit.audit2.first;

import com.example.audit.audit2.AuditRecord;
import com.example.audit.audit2.AuditRecordState;

public class AuditPassState extends AuditRecordState
{
    public AuditPassState(AuditRecord auditRecord)
    {
        super(auditRecord);
    }

    @Override
    public void create()
    {
        System.out.println("初审已通过，不能创建");
    }

    @Override
    public void assign()
    {
        System.out.println("初审已通过，不能分配");
    }

    @Override
    public void audit()
    {
        System.out.println("初审已通过，不能审核");
    }

    @Override
    public void pass(String condition)
    {
        System.out.println("初审审核通过");
        //安排了复审跳转到复审状态
        if(condition.equals("1")){
            // 1、变化为复审中状态
            this.auditRecord.setState(auditRecord.getReviewRunState());
            // 2、执行复审
            this.auditRecord.audit();
        }else{
            //未安排复审跳转主站审核流程
            // 1、变化为复审中状态
            this.auditRecord.setState(auditRecord.getMiguRunState());
            // 2、执行复审
            this.auditRecord.audit();
        }
    }

    @Override
    public void reject()
    {
        System.out.println("初审已通过，不能驳回");
    }
}
