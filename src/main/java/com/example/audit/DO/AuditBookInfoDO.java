package com.example.audit.DO;


import java.io.Serializable;
import java.util.Date;

public class AuditBookInfoDO implements Serializable
{
    private static final long serialVersionUID = 4679918873286524716L;

    //长度不超过10 不可为空 不良词id
    private Integer id;

    //图书ID(中台)
    private String bookIdCenter;

    //图书ID(主站)
    private String bookIdMigu;

    //初审编辑ID
    private String auditorFirst;

    //复审主编ID
    private String auditorReview;

    //审核状态 1待提交 2待分配 3初审中 4复审中 5待提交主站审核 6主站审核中 7初审驳回 8复审驳回 9主站驳回 10最终审核通过
    private Integer auditState;

    //提交审核时间
    private Date submitTime;

    //审核结果枚举:1初审结果 2复审结果 3主站审核结果
    private Integer auditResultEnum;

    //审核结果记录ID:对应AUDIT_RESULT_RECORD 审核结果记录ID
    private Integer auditResultId;

    //修改状态:1新建 2待修改 3已修改 4通过
    private Integer reverseState;

    //最终结果:1通过 2不通过
    private String finalResult;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getBookIdCenter()
    {
        return bookIdCenter;
    }

    public void setBookIdCenter(String bookIdCenter)
    {
        this.bookIdCenter = bookIdCenter;
    }

    public String getBookIdMigu()
    {
        return bookIdMigu;
    }

    public void setBookIdMigu(String bookIdMigu)
    {
        this.bookIdMigu = bookIdMigu;
    }

    public String getAuditorFirst()
    {
        return auditorFirst;
    }

    public void setAuditorFirst(String auditorFirst)
    {
        this.auditorFirst = auditorFirst;
    }

    public String getAuditorReview()
    {
        return auditorReview;
    }

    public void setAuditorReview(String auditorReview)
    {
        this.auditorReview = auditorReview;
    }

    public Integer getAuditState()
    {
        return auditState;
    }

    public void setAuditState(Integer auditState)
    {
        this.auditState = auditState;
    }

    public Date getSubmitTime()
    {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime)
    {
        this.submitTime = submitTime;
    }

    public Integer getAuditResultEnum()
    {
        return auditResultEnum;
    }

    public void setAuditResultEnum(Integer auditResultEnum)
    {
        this.auditResultEnum = auditResultEnum;
    }

    public Integer getAuditResultId()
    {
        return auditResultId;
    }

    public void setAuditResultId(Integer auditResultId)
    {
        this.auditResultId = auditResultId;
    }

    public Integer getReverseState()
    {
        return reverseState;
    }

    public void setReverseState(Integer reverseState)
    {
        this.reverseState = reverseState;
    }

    public String getFinalResult()
    {
        return finalResult;
    }

    public void setFinalResult(String finalResult)
    {
        this.finalResult = finalResult;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("AuditBookInfoDO{");
        sb.append("id=").append(id);
        sb.append(", bookIdCenter='").append(bookIdCenter).append('\'');
        sb.append(", bookIdMigu='").append(bookIdMigu).append('\'');
        sb.append(", auditorFirst='").append(auditorFirst).append('\'');
        sb.append(", auditorReview='").append(auditorReview).append('\'');
        sb.append(", auditState=").append(auditState);
        sb.append(", submitTime=").append(submitTime);
        sb.append(", auditResultEnum=").append(auditResultEnum);
        sb.append(", auditResultId=").append(auditResultId);
        sb.append(", reverseState=").append(reverseState);
        sb.append(", finalResult='").append(finalResult).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
