package com.maomao2.databasesharding.controller;

import com.maomao2.databasesharding.model.HiveTable;
import com.maomao2.databasesharding.service.HiveTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/HiveTables")
public class HiveTableController {
    @Resource
    HiveTableService hiveTableService;

    @GetMapping
    public HiveTable get(@RequestParam int id) {
        return hiveTableService.getHiveTableById(id);
    }

}
