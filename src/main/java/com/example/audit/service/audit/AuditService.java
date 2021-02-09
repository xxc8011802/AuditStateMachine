package com.example.audit.service.audit;

import com.example.audit.DO.AuditBookInfoDO;

import java.util.List;

public interface AuditService
{

    /**
     * 查询图书审核记录
     * @param auditBookInfoDO
     * @return
     */
    List<AuditBookInfoDO> selectAuditBookInfoList(AuditBookInfoDO auditBookInfoDO);
    /**
     * 提交审核服务
     */
    boolean submit(String bookId);

    /**
     * 关联审核人员
     */
    void assign();

    /**
     * 取消关联审核人员
     * @param
     */
    void unassign();

    /**
     * 审核通过
     */
    void auditPass();

    /**
     * 审核驳回
     */
    void auditReject();


}
