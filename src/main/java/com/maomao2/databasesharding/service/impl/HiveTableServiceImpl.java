package com.maomao2.databasesharding.service.impl;

import com.maomao2.databasesharding.mapper.pkg1.HiveTableMapper;
import com.maomao2.databasesharding.model.HiveTable;
import com.maomao2.databasesharding.service.HiveTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class HiveTableServiceImpl implements HiveTableService {
    @Resource
    HiveTableMapper hiveTableMapper;

    @Override
    public boolean addHiveTable(HiveTable hiveTable) {
        boolean result = false;
        try {
            hiveTableMapper.insertSelective(hiveTable);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public HiveTable getHiveTableById(Integer id) {
        return hiveTableMapper.selectByPrimaryKey(id);
    }
}
