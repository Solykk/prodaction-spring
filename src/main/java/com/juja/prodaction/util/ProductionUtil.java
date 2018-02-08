package com.juja.prodaction.util;

import com.juja.prodaction.dao.AreaRepository;
import com.juja.prodaction.dao.StatusRepository;
import com.juja.prodaction.domain.entity.Area;
import com.juja.prodaction.domain.entity.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitriy Lyashenko
 */
@Component
public class ProductionUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProductionUtil.class);

    private static Map<String, Area> areaMap;
    private static Map<String, Status> statusMap;

    private final static String DEFAULT_AREA_KEY = "POST";
    private final static String DEFAULT_STATUS_KEY = "JUNIOR";

    private AreaRepository areaRepository;
    private StatusRepository statusRepository;

    @PostConstruct
    private void initializeAreaMap(){
        areaMap = new HashMap<>();
        for (Area area : areaRepository.findAll()) {
            areaMap.put(area.getCode(), area);
        }

        LOGGER.info("---- AreaMap was initialized ----");
    }

    @PostConstruct
    private void initializeStatusMap(){
        statusMap = new HashMap<>();
        for (Status status : statusRepository.findAll()) {
            statusMap.put(status.getCode(), status);
        }

        LOGGER.info("---- StatusMap was initialized ----");
    }

    public static Area getAreaByKey(String key){
        return areaMap.getOrDefault(key, areaMap.get(DEFAULT_AREA_KEY));
    }

    public static Status getStatusByKey(String key){
        return statusMap.getOrDefault(key, statusMap.get(DEFAULT_STATUS_KEY));
    }

    public static Map<String, Area> getAreaMap() {
        return areaMap;
    }

    public static Map<String, Status> getStatusMap() {
        return statusMap;
    }

    @Autowired
    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Autowired
    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
}
