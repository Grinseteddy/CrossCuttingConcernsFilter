package com.annegret.servicepatterns.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
@ConfigurationProperties
public class FilterController {

    static Logger logger=LoggerFactory.getLogger(FilterController.class);

    @Value("${index:1}")
    private String index;

    @GetMapping(value ="filter")
    public String filtered(@RequestParam("inputString") String inputString) {
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
