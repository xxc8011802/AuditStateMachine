package com.example.audit2.constants;

import com.example.audit2.state.AuditRecordState;

public enum StateEnum
{
    //新建
    newState(1,"新建"),
    //待分配
    assignState(2,"待分配"),
    //已分配
    assignFinState(3,"已分配"),
    //初审中
    auditRunState(4,"初审中"),
    //初审通过
    auditPassState(5,"初审通过"),
    //复审中
    reviewRunState(6,"复审中"),
    //复审通过
    reviewPassState(7,"复审通过"),
    //主站审核中
    miguRunState(8,"主站审核中"),
    //主站审核通过
    miguPassState(9,"主站审核通过"),
    //已驳回
    rejectState(10,"已驳回");

    StateEnum(int status,String desc){
        this.status = status;
        this.desc = desc;
    }

    public int status;

    public String desc;
}
