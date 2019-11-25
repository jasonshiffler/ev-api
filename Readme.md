This Spring Boot project is a scaled down version of a Tesla REST API documented here: https://www.teslaapi.io/ .
The purpose of this project is to build a REST API that would have the features and security that one would find in a
production grade API. Search features include size and page based queries as well the ability to filter on certain fields.
Fields can also be updated with various GET requests. Security items include a required secure transport layer with 
TLS 1.2, HTTP basic authentication with Spring Security, and identity based object access(a user can only see their
own data). This is still a work in progress and not all of the API has been implemented yet. 

A few words on the exception handling within this program:

Exceptions are intentionally not declared as runtime exceptions so they have to be caught by controllers. The controllers
normally throw a Command Response object. In the case an Exception is thrown we want to make sure the controller doesn't
throw the normal response object but at the same time throws an exception to the controller advice. We also want to
make sure that a new exception isn't added to the service layer that the Controller isn't aware of. There is probably
a more elegant way to handle this but it works for now and prevents successful command response messages from being 
sent out when they shouldn't    