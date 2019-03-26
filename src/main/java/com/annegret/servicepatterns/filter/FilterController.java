package com.annegret.servicepatterns.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class FilterController {
    @GetMapping(value ="filter")
    public String filtered(@RequestParam("inputString") String inputString) {
        String returnString = filter(inputString);
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
