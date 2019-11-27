package com.tesla.springboot.evapi.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class LogFormatTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void urlLogFormatTest() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRemoteAddr("12.45.212.176");
        request.setRequestURI("/api/v1/vehicles");
        assertEquals("Bob at 12.45.212.176 requesting /api/v1/vehicles",
                LogFormat.urlLogFormat(request,"Bob"));
        request.setQueryString("size=5&display_name=red");
        assertEquals("Bob at 12.45.212.176 requesting /api/v1/vehicles?size=5&display_name=red",
                LogFormat.urlLogFormat(request,"Bob"));

    }
}