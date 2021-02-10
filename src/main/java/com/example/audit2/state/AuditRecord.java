package com.example.audit2.state;

import com.example.audit2.constants.StateEnum;
import com.example.audit2.state.assign.AssignFinState;
import com.example.audit2.state.assign.AssignState;
import com.example.audit2.state.first.AuditRunState;
import com.example.audit2.state.first.AuditPassState;
import com.example.audit2.state.main.MiguPassState;
import com.example.audit2.state.main.MiguRunState;
import com.example.audit2.state.review.ReviewPassState;
import com.example.audit2.state.review.ReviewRunState;

public class AuditRecord
{
    //定义出审核单的状态
    /*//新建
    private AuditRecordState newState;
    //待分配
    private AuditRecordState assignState;
    //已分配
    private AuditRecordState assignFinState;
    //初审中
    private AuditRecordState auditRunState;
    //初审通过
    private AuditRecordState auditPassState;
    //复审中
    private AuditRecordState reviewRunState;
    //复审通过
    private AuditRecordState reviewPassState;
    //主站审核中
    private AuditRecordState miguRunState;
    //主站审核通过
    private AuditRecordState miguPassState;
    //已驳回
    private AuditRecordState rejectState;*/


    private StateEnum state;

    // 定义当前审核记录状态
    private AuditRecordState currentState;

    /**
     * 构造方法
     */
    public AuditRecord() {
        /*newState = new NewState(this);
        assignState = new AssignState(this);
        assignFinState = new AssignFinState(this);
        auditRunState = new AuditRunState(this);
        auditPassState = new AuditPassState(this);
        reviewRunState = new ReviewRunState(this);
        reviewPassState = new ReviewPassState(this);
        miguRunState = new MiguRunState(this);
        miguPassState = new MiguPassState(this);
        rejectState = new RejectState(this);*/
    }


    /**
     * 执行审核单创建
     */
    public void create() {
        currentState.create();
    }

    /**
     * 执行审核单分配
     */
    public void assign()
    {
        currentState.assign();
    }

    /**
     * 执行审核单审核
     */
    public void audit()
    {
        currentState.audit();
    }

    /**
     * 执行审核单分配
     */
    public void pass(String condition)
    {
        currentState.pass(condition);
    }

    /**
     * 执行审核单驳回
     */
    public void reject()
    {
        currentState.reject();
    }

    // ##################设置当前审核记录的状态#####################

    /**
     * 设置当前审核记录的状态
     *
     * @param state
     */
    public void setState(StateEnum state) {
        this.state = state;
    }

    // ###################获取审核记录的全部状态####################

    /*public AuditRecordState getNewState()
    {
        return newState;
    }

    public AuditRecordState getAssignState()
    {
        return assignState;
    }

    public AuditRecordState getAssignFinState()
    {
        return assignFinState;
    }

    public AuditRecordState getAuditRunState()
    {
        return auditRunState;
    }

    public AuditRecordState getAuditPassState()
    {
        return auditPassState;
    }

    public AuditRecordState getReviewRunState()
    {
        return reviewRunState;
    }

    public AuditRecordState getReviewPassState()
    {
        return reviewPassState;
    }

    public AuditRecordState getRejectState()
    {
        return rejectState;
    }

    public AuditRecordState getMiguRunState()
    {
        return miguRunState;
    }

    public AuditRecordState getMiguPassState()
    {
        return miguPassState;
    }*/

    public AuditRecordState getCurrentState()
    {
        return currentState;
    }
}
