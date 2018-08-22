package com.mywuwu.controller;

import com.mywuwu.entity.ManagerResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired  
    private LoadBalancerClient loadBalancerClient;  

    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    public ManagerResult sub(@RequestParam Integer a,@RequestParam Integer b) {
        ServiceInstance instance = this.loadBalancerClient.choose("MYWUWU-SERVICE");
        if(instance != null){
            ResponseEntity responseEntity = restTemplate.getForEntity("http://"+instance.getServiceId()+"/manager/add?a="+a+"&b="+b, ManagerResult.class);
            return (ManagerResult) responseEntity.getBody();
        }
//        return restTemplate.getForEntity("http://MYWUWU-SERVICE/add?a="+a+"&b="+b,String.class).getBody();
    	return null;
    }
    
}