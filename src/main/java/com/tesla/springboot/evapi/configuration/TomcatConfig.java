/**
 * The purpose of this configuration class is to make the API more user friendly by redirecting non-secure http
 * requests to use secured https instead.
 **/

package com.tesla.springboot.evapi.configuration;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    public class HttpsRedirectConf {
        private final static String SECURITY_USER_CONSTRAINT = "CONFIDENTIAL";
        private final static String REDIRECT_PATTERN = "/*";
        private final static String CONNECTOR_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";
        private final static String CONNECTOR_SCHEME = "http";

        @Bean
        public TomcatServletWebServerFactory servletContainer() {
            TomcatServletWebServerFactory tomcat =
                    new TomcatServletWebServerFactory() {

                        @Override
                        protected void postProcessContext(Context context) {
                            SecurityConstraint securityConstraint = new SecurityConstraint();
                            securityConstraint.setUserConstraint(SECURITY_USER_CONSTRAINT);
                            SecurityCollection collection = new SecurityCollection();
                            collection.addPattern(REDIRECT_PATTERN);
                            securityConstraint.addCollection(collection);
                            context.addConstraint(securityConstraint);
                        }
                    };
            tomcat.addAdditionalTomcatConnectors(createHttpConnector());
            return tomcat;
        }

        private Connector createHttpConnector() {
            Connector connector =
                    new Connector(CONNECTOR_PROTOCOL);
            connector.setScheme(CONNECTOR_SCHEME);
            connector.setSecure(false);
            connector.setPort(8080);
            connector.setRedirectPort(8443);
            return connector;
        }
    }
}