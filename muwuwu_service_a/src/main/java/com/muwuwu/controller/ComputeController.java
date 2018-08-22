package com.muwuwu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ComputeController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/sub" ,method = RequestMethod.GET)
    public String sub(@RequestParam Integer a, @RequestParam Integer b) {
        List<ServiceInstance> instanceList =  client.getInstances("MYWUWU_SERVICE");

        String psot = "";
        if(instanceList != null && instanceList.size() > 0){
            ServiceInstance instance = instanceList.get(0);
            psot =  instance.getPort() + "";
        }

        Integer r = a - b;
        return "From Service-B, Result is " + r+" \nPort:"+ psot;
    }

    //call service-A
    @RequestMapping(value="testServiceB",method=RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){
        List<ServiceInstance> instanceList =  client.getInstances("MYWUWU_SERVICE");
        if(instanceList != null && instanceList.size() > 0){
            ServiceInstance instance = instanceList.get(0);
            RestTemplate restTemplate=new RestTemplate();
            return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/add?a="+a+"&b="+b, String.class);
        }
        return "";
    }
}