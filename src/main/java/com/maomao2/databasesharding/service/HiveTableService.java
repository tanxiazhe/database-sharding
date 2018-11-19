package com.maomao2.databasesharding.service;

import com.maomao2.databasesharding.model.HiveTable;

public interface HiveTableService {
    boolean addHiveTable(HiveTable hiveTable);
    HiveTable getHiveTableById(Integer id);
}
