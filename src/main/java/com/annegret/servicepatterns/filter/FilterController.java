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

    static Logger logger=LoggerFactory.getLogger(FilterController.class);

    @Value("${index}")
    private String index;

    @GetMapping(value = "/filter/{inputString}")
    @ResponseBody
    public String filtered(@PathVariable("inputString") String inputString) {
        String returnString = filter(inputString)+" "+index;
        logger.info(inputString+" --> "+returnString);
        return returnString;
    }

    private String filter(String inputString) {

        if (inputString.length()>0) {

            String filterString = inputString.replaceAll("A","");

            return String.valueOf(filterString);

        }

        return "";
    }

}
