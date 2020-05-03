package com.yyan.serviceImpl;

import com.yyan.dao.AuthDao;
import com.yyan.dao.DocDao;
import com.yyan.pojo.Block;
import com.yyan.pojo.Doc;
import com.yyan.service.DocService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DocServiceImpl extends BaseServiceImpl implements DocService {

    @Autowired
    private DocDao docDao;
    @Autowired
    private BlockServiceImpl blockService;
    @Autowired
    private AuthDao authDao;

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
    @Transactional // 添加事务
    public void deleteDoc(String id) {
        String[] idArr = id.split(",");
        for (String idString : idArr) {

            docDao.deleteDoc(idString);
        }
    }

    @Override
    public Map<String, Object> selectListDoc(Map map) {


        // todo 用户登录 部门验证 申请
//        map.put("userId",);
        // 用户未登录
        if (getUserIdToken() == null) {
            List<Map> list = docDao.selectListDoc(checkPageSize(map));
            List<Map> newList = new ArrayList<>();
            for (Map mp : list) {
                mp.put("state", "未申请");
                newList.add(mp);
            }
            Integer count = docDao.countListDoc(map);
            return this.queryListSuccess(newList, count, map); //查询成功
        }


        if (map.get("departmentId").equals(getDepartmentIdByToken())) {
            // 可以阅读当前部门
            List<Map> list = docDao.selectListDoc(checkPageSize(map));
            List<Map> newList = new ArrayList<>();
            for (Map mp : list) {
                mp.put("state", "同意");
                newList.add(mp);
            }
            Integer count = docDao.countListDoc(map);
            return this.queryListSuccess(newList, count, map); //查询成功
        }

        // 跨部门查看
        List<Map> list = docDao.selectListDoc(checkPageSize(map));
        List<Map> newList = new ArrayList<>();
        for (Map<String, Object> mp : list) {
            Map aMap = new HashMap();
            aMap.put("docId", mp.get("id"));
            aMap.put("userId", getUserIdToken());
//                aMap.put("docId",mp.get("id"));
            String state = "未申请";
            String sTime = null;
            String eTime = null;

            List<Map> li = authDao.selectListAuth(checkPageSize(aMap));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (Map sMap : li) {
                state = (String) sMap.get("state");
                sTime = formatter.format(sMap.get("sTime"));
                eTime = formatter.format(sMap.get("eTime"));
                Date eDate = (Date) sMap.get("eTime");
                Date nDate = new Date();
                if (eDate.getTime() < nDate.getTime()) {
                    state = "到期";
                }
            }
            mp.put("state", state);
            mp.put("sTime", sTime);
            mp.put("eTime", eTime);
            newList.add(mp);
        }
        Integer count = docDao.countListDoc(map);
        return this.queryListSuccess(newList, count, map); //查询成功


    }

    @Override
    public Map<String, Object> selectListSelfDoc(Map map) {
        // todo 考虑上级部门
        map.put("departmentId", getDepartmentIdByToken());
        List<Map> newList = docDao.selectListDoc(checkPageSize(map));
        Integer count = docDao.countListDoc(map);
        return this.queryListSuccess(newList, count, map); //查询成功
    }
}
