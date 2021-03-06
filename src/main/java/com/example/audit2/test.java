package com.example.audit2;

import com.example.audit2.constants.StateEnum;
import com.example.audit2.state.AuditRecord;
import com.example.audit2.state.NewState;

public class test
{
    public static void main(String[] args)
    {
        AuditRecord auditRecord = new AuditRecord();
        //记录新建
        auditRecord.setState(StateEnum.newState);
        //作家创建后等待分配
        auditRecord.create();
        System.out.println("================================");
        //分配员进行审核分配
        auditRecord.assign();
        System.out.println("================================");
        //表示未安排复审 1表示安排了复审
        //初审审核通过
        auditRecord.pass("1");
        System.out.println("================================");
        //复审审核通过
        auditRecord.pass("1");
        System.out.println("================================");
        auditRecord.reject();
        //主站审核通过
        auditRecord.pass("1");
    }
}
