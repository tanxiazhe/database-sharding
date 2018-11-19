package com.maomao2.databasesharding.controller;

import com.maomao2.databasesharding.model.HiveLocation;
import com.maomao2.databasesharding.model.HiveTable;
import com.maomao2.databasesharding.service.HiveLocationService;
import com.maomao2.databasesharding.service.HiveTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/HiveLocations")
public class HiveLocationController {
    @Resource
    HiveLocationService hiveLocationService;

    @GetMapping
    @ResponseBody
    public HiveLocation get(@RequestParam int id) {
        return  hiveLocationService.getHiveLocationById(id);
    }

    @PostMapping
    public boolean create(@RequestBody HiveLocation hiveLocation) {
        return  hiveLocationService.addHiveLocation(hiveLocation);
    }


}
