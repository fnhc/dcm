package com.chinawiserv.dsp.dcm.service.impl;

import com.chinawiserv.dsp.dcm.dao.CityDao;
import com.chinawiserv.dsp.dcm.domain.City;
import com.chinawiserv.dsp.dcm.domain.CityExample;
import com.chinawiserv.dsp.dcm.mapper.CityMapper;
import com.chinawiserv.dsp.dcm.mapper.HotelMapper;
import com.chinawiserv.dsp.dcm.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanf on 2017/3/30.
 */
@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityMapper cityMapper ;

    @Autowired
    private HotelMapper hotelMapper ;

    public City selectCityById(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<City> getCities() {
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andCountryLike("%中国%");

        return cityMapper.selectByExample(cityExample);
    }
}
