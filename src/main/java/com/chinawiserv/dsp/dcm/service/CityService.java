package com.chinawiserv.dsp.dcm.service;

import com.chinawiserv.dsp.dcm.domain.City;

import java.util.List;

/**
 * Created by zhanf on 2017/3/30.
 */
public interface CityService {
    public City selectCityById(Integer id) ;

    public List<City> getCities();
}
