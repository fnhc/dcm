package com.chinawiserv.dsp.dcm.controller;

import com.chinawiserv.dsp.dcm.domain.City;
import com.chinawiserv.dsp.dcm.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("/home")
    String home() {
        City city = this.cityService.selectCityById(1) ;
        return city.toString();
    }

    @RequestMapping("/getCities")
    @ResponseBody
    String getCities(HttpServletRequest request, HttpServletResponse response){
        String key = request.getParameter("key");



        return  cityService.getCities().toString();
    }

}
