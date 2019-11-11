package com.tesla.springboot.evapi.utility;

import javax.servlet.http.HttpServletRequest;

public class LogFormat {

    /**
     * Formats Log messages based on if there is a query string or not.
     * @param request
     * @return
     */

    public static String urlLogFormat(HttpServletRequest request, String userName){

        if(request.getQueryString() == null){
            return(userName + " at " + request.getRemoteAddr() + " requesting " + request.getRequestURI());
        }
        else {
            return (userName + " at " + request.getRemoteAddr() + " requesting "
                    + request.getRequestURI()+"?"+request.getQueryString());
        }

    }
}
