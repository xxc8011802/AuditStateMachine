package com.example.audit2.state.review;

import com.example.audit2.constants.StateEnum;
import com.example.audit2.state.AuditRecord;
import com.example.audit2.state.AuditRecordState;

public class ReviewRunState extends AuditRecordState
{
    public ReviewRunState(AuditRecord auditRecord)
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
        System.out.println("等待复审");
    }

    @Override
    public void pass(String condition)
    {
        // 1、变化为复审通过状态
        //this.auditRecord.setState(auditRecord.getReviewPassState());
        this.auditRecord.setState(StateEnum.reviewPassState);
        // 2、审核通过
        this.auditRecord.pass(condition);
    }

    @Override
    public void reject()
    {
        // 1、变化为审核通过状态
        //this.auditRecord.setState(auditRecord.getRejectState());
        this.auditRecord.setState(StateEnum.rejectState);
        // 2、审核驳回
        this.auditRecord.reject();
    }
}
