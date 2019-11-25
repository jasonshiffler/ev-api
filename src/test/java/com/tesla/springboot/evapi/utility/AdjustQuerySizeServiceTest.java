package com.tesla.springboot.evapi.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjustQuerySizeServiceTest {

    AdjustQuerySizeService service;

    @BeforeEach
    void setup(){
        service = new AdjustQuerySizeService(500, 25);
    }
/*
    @Test
    void adjustQuerySizeTest() {

        assertEquals(25,service.AdjustQuerySize(null));
        assertEquals(500,service.AdjustQuerySize(1000));
        assertEquals(5,service.AdjustQuerySize(5));

    }*/
}