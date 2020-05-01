package com.yyan.serviceImpl;

import com.sun.jnlp.BasicServiceImpl;
import com.yyan.dao.DepartmentDao;
import com.yyan.dao.DocDao;
import com.yyan.pojo.Doc;
import com.yyan.service.DocService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DocServiceImpl extends BaseServiceImpl implements DocService {

    @Autowired
    private DocDao docDao;

    @Override
    public void insertDoc(Doc doc) {
      // todo 插入区块
    }

    @Override
    public void deleteDoc(String id) {

    }

    @Override
    public Map<String, Object> selectListDoc(Map map) {
        return null;
    }
}
