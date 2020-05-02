package com.yyan.serviceImpl;

import com.sun.jnlp.BasicServiceImpl;
import com.yyan.dao.DepartmentDao;
import com.yyan.dao.DocDao;
import com.yyan.pojo.Block;
import com.yyan.pojo.Doc;
import com.yyan.service.DocService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class DocServiceImpl extends BaseServiceImpl implements DocService {

    @Autowired
    private DocDao docDao;
    private BlockServiceImpl blockService;

    @Override
    @Transactional // 添加事务
    public void insertDoc(Doc doc) {

        String depId = getDepartmentIdByToken();
        doc.setDepartmentId(depId);

        docDao.insertDoc(doc);
        // 插入区块
        Block block = new Block();
        block.setCategory("file");
        block.setData(doc.getFileUrl());
        blockService.insertBlock(block);

    }

    @Override
    public void deleteDoc(String id) {

    }

    @Override
    public Map<String, Object> selectListDoc(Map map) {
        return null;
    }
}
