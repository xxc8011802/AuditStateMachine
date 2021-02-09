package com.example.audit2;

import com.example.lift.ClosingState;
import com.example.lift.Lift;

public class test
{
    public static void main(String[] args)
    {
        AuditRecord auditRecord = new AuditRecord();
        //记录新建
/*        auditRecord.setState(new NewState(auditRecord));
        auditRecord.assign();
        auditRecord.audit();
        auditRecord.reject();
        auditRecord.pass();*/

        //--------------------------
        auditRecord.setState(new NewState(auditRecord));
        auditRecord.assign();
        auditRecord.audit();
        //表示未安排复审 1表示安排了复审
        //初审审核通过
        auditRecord.pass("0");
        //复审审核通过
        auditRecord.pass("0");
        //主站审核通过
        auditRecord.pass("0");
    }
}
