package com.annegret.servicepatterns.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;


@RefreshScope
@RestController
@EnableAutoConfiguration
@Configuration
public class FilterController {

    private static Logger logger = LoggerFactory.getLogger(FilterController.class);

    @Value("${index}")
    private String index;

    @GetMapping(value = "/filter/{inputString}")
    @ResponseBody
    public String filtered(@PathVariable("inputString") String input) {
        String filteredInput = filter(input) + " " + index;
        logger.info(input + "--> " + filteredInput);
        return filteredInput;
    }

    private String filter(String input) {
        return input.replaceAll("A","");
    }

}
