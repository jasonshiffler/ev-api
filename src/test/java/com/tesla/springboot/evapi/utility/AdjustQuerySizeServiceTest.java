package com.tesla.springboot.evapi.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdjustQuerySizeServiceTest {

    AdjustQuerySizeService service;

    @BeforeEach
    public void setup() {
        service = new AdjustQuerySizeService(500, 25);
    }

    @Test
    public void adjustQuerySizeTest() {
        assertEquals(Integer.valueOf(25), service.AdjustQuerySize(null));
        assertEquals(Integer.valueOf(500), service.AdjustQuerySize(1000));
        assertEquals(Integer.valueOf(5), service.AdjustQuerySize(5));
    }

}