package com.panchen.beacon.apigw.hystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HystrixCommandController {

    @RequestMapping("/hystrixTimeout")
    public void hystrixTimeout() {
        log.info("hystrixTimeout");
    }

    @HystrixCommand(commandKey = "authHystrixCommand")
    public void authHystrixCommand() {
        log.info("hystrixTimeout");
    }

}
