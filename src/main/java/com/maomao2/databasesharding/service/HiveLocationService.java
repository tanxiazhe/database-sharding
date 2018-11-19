package com.maomao2.databasesharding.service;

import com.maomao2.databasesharding.model.HiveLocation;
import com.maomao2.databasesharding.model.HiveTable;

public interface HiveLocationService {
    boolean addHiveLocation(HiveLocation hiveLocation);

    HiveLocation getHiveLocationById(Integer id);
}
