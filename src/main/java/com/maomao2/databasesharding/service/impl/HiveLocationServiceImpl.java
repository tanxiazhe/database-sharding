package com.maomao2.databasesharding.service.impl;

import com.maomao2.databasesharding.mapper.pkg1.HiveLocationMapper;
import com.maomao2.databasesharding.model.HiveLocation;
import com.maomao2.databasesharding.service.HiveLocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class HiveLocationServiceImpl implements HiveLocationService {
    @Resource
    HiveLocationMapper hiveLocationMapper;

    @Override
    public boolean addHiveLocation(HiveLocation hiveLocation) {
        boolean result = false;
        try {
            hiveLocationMapper.insertSelective(hiveLocation);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public HiveLocation getHiveLocationById(Integer id) {
        return hiveLocationMapper.selectByPrimaryKey(id);
    }
}
