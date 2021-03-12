package com.example.audit.service.audit.impl;

import com.example.audit.DO.AuditBookInfoDO;
import com.example.audit.mapper.audit.AuditBookInfoMapper;
import com.example.audit.service.audit.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class AuditServiceImpl implements AuditService
{

    private static Logger logger = LoggerFactory.getLogger(AuditServiceImpl.class);

    @Autowired
    AuditBookInfoMapper auditBookInfoMapper;

    /**
     * 根据条件分页查询图书审核列表
     *
     * @return 用户信息集合信息
     */
    @Override
    public List<AuditBookInfoDO> selectAuditBookInfoList(AuditBookInfoDO auditBookInfoDO)
    {
        /*auditBookInfoMapper.selectAuditBookInfoList();*/
        return null;
    }

    /**
     * 提交审核服务
     */
    @Override
    public boolean submit(String bookId)
    {
        Date date = new Date();
        AuditBookInfoDO auditBookInfoDO = new AuditBookInfoDO();
        auditBookInfoDO.setBookIdCenter(bookId);
        auditBookInfoDO.setAuditState(1);
        auditBookInfoDO.setReverseState(0);
        auditBookInfoDO.setSubmitTime(date);
        //图书审核记录插入表
        auditBookInfoMapper.insertAuditBookByBookId(auditBookInfoDO);
        //查询图书关联信息表
        return true;
    }

    /**
     * 更新审核记录
     */
    public boolean update(String bookId)
    {
        Date date = new Date();
        AuditBookInfoDO auditBookInfoDO = new AuditBookInfoDO();
        auditBookInfoDO.setBookIdCenter(bookId);
        auditBookInfoDO.setAuditState(2);
        //图书审核记录插入表
        auditBookInfoMapper.updateAuditBookByBookId(auditBookInfoDO);
        //查询图书关联信息表
        return true;
    }

    /**
     * 关联审核人员
     */
    @Override
    public void assign()
    {
        return;
    }

    /**
     * 取消关联审核人员
     *
     * @param
     */
    @Override
    public void unassign()
    {
        return;
    }

    /**
     * 审核通过
     */
    @Override
    public void auditPass()
    {
        return;
    }

    /**
     * 审核驳回
     */
    @Override
    public void auditReject()
    {
        return;
    }

}
