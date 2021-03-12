package com.example.audit.mapper.audit;

import com.example.audit.DO.AuditBookInfoDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 审核接口
 */
@Component
public interface AuditBookInfoMapper
{
/*    *//**
     * 根据条件分页查询图书审核列表
     *
     * @param auditBookInfoDO 图书信息
     * @return 图书审核记录信息
     *//*
    List<AuditBookInfoDO> selectAuditBookInfoList(@Param("auditBookInfoDO") AuditBookInfoDO auditBookInfoDO);

    *//**
     * 根据图书Id查询图书审核记录
     *
     * @param bookId 图书Id
     * @return 图书审核记录
     *//*
     AuditBookInfoDO selectAuditBookByBookId(@Param("bookId") String bookId);

    *//**
     * 插入图书审核记录
     *
     * @param auditBookInfoDO 审核记录信息
     * @return 图书审核记录
     */
    void insertAuditBookByBookId(@Param("auditBookInfoDO") AuditBookInfoDO auditBookInfoDO);

    /**
     * 更新审核记录
     *
     * @param auditBookInfoDO 审核记录信息
     * @return 图书审核记录
     */
    void updateAuditBookByBookId(@Param("auditBookInfoDO") AuditBookInfoDO auditBookInfoDO);

}
