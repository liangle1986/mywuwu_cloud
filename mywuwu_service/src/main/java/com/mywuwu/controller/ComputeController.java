package com.mywuwu.controller;

import com.mywuwu.entity.ManagerResult;
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
@RequestMapping("/manager")
public class ComputeController {


    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public ManagerResult add(@RequestParam Integer a, @RequestParam Integer b) {
        ManagerResult result = new ManagerResult();
        List<ServiceInstance> instanceList =  client.getInstances("MYWUWU-SERVICE");
        String port = "";
        if(instanceList != null && instanceList.size() > 0){
            ServiceInstance instance = instanceList.get(0);
            port = instance.getPort() + "";
//            RestTemplate restTemplate=new RestTemplate();
//            return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/add?a="+a+"&b="+b, String.class);
        }
        Integer r = a + b;
        result.setSuccess(true);
        result.setManage( "From Service-A, Result is " + r+"\nPort:" + port);
        return result;
    }

    //call service-B
    @RequestMapping(value="/testServiceB",method=RequestMethod.GET)
    public String testServiceB(@RequestParam Integer a,@RequestParam Integer b){

        List<ServiceInstance> instanceList =  client.getInstances("MUWUWU_SERVICE_A");
        if(instanceList != null && instanceList.size() > 0){
            ServiceInstance instance = instanceList.get(0);
            RestTemplate restTemplate=new RestTemplate();
            return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/add?a="+a+"&b="+b, String.class);
        }
        return "";
    }
    
}