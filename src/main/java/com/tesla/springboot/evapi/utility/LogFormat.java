package com.tesla.springboot.evapi.utility;

import javax.servlet.http.HttpServletRequest;

public class LogFormat {

    /**
     * Formats Log messages based on if there is a query string or not.
     * @param request
     * @return
     */

    public static String urlLogFormat(HttpServletRequest request){

        if(request.getQueryString() == null){
            return(request.getRemoteAddr() + " requesting " + request.getRequestURI());
        }
        else {
            return (request.getRemoteAddr() + " requesting " + request.getRequestURI()+"?"+request.getQueryString());
        }

    }
}
