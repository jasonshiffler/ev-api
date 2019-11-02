package com.tesla.springboot.evapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AdjustQuerySizeService {

    private Integer maxQuerySize;
    private Integer defaultQuerySize;

    @Autowired
    AdjustQuerySizeService(@Qualifier("maxQuerySize") Integer max,
                           @Qualifier("defaultQuerySize") Integer defSize) {
        defaultQuerySize = defSize;
        maxQuerySize = max;
    }


    public Integer AdjustQuerySize(Integer size) {
        //If the query size wasn't set use a default size to 25
        //don't allow a query size larger than 1000

        if (size == null) {
            size = Integer.valueOf(this.defaultQuerySize);
        } else if (size > 500) {
            size = Integer.valueOf(this.maxQuerySize);
        }
        return size;

    }

}

