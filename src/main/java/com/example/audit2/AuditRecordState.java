package com.example.audit2;

public abstract class AuditRecordState
{
    // 拥有一个审核单对象，用于更新审核单当前状态
    protected AuditRecord auditRecord;

    public AuditRecordState(AuditRecord auditRecord){
        this.auditRecord=auditRecord;
    }

    /**
     * 行为：审核记录新建
     */
    public abstract void create();

    /**
     * 行为：审核记录分配
     */
    public abstract void assign();

    /**
     * 行为：审核记录审核
     */
    public abstract void audit();

    /**
     * 行为：审核记录通过
     */
    public abstract void pass(String condition);


    /**
     * 行为：审核记录驳回
     */
    public abstract void reject();
}
