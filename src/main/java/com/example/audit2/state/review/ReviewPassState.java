package com.example.audit2.state.review;

import com.example.audit2.constants.StateEnum;
import com.example.audit2.state.AuditRecord;
import com.example.audit2.state.AuditRecordState;

public class ReviewPassState extends AuditRecordState
{
    public ReviewPassState(AuditRecord auditRecord)
    {
        super(auditRecord);
    }

    @Override
    public void create()
    {
        System.out.println("记录复审已通过，请停止操作");
    }

    @Override
    public void assign()
    {
        System.out.println("记录复审已通过，请停止操作");
    }

    @Override
    public void audit()
    {
        System.out.println("记录复审已通过，请停止操作");
    }

    @Override
    public void pass(String condition)
    {
        System.out.println("复审审核通过");
        //未安排复审跳转主站审核流程
        // 1、变化为复审中状态
        //this.auditRecord.setState(auditRecord.getMiguRunState());
        this.auditRecord.setState(StateEnum.miguRunState);
        // 2、执行复审
        this.auditRecord.audit();
    }

    @Override
    public void reject()
    {
        System.out.println("记录复审已通过，请停止操作");
    }
}
