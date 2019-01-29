package com.panchen.beacon.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringCloudApplication
@EnableDiscoveryClient
public class ApiGateWayStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayStarter.class, args);
    }
    
}
