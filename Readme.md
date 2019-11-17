This Spring Boot project is a scaled down version of a Tesla REST API documented here: https://www.teslaapi.io/ .
The purpose of this project is to build a REST API that would have the features and security that one would find in a
production grade API. Search features include size and page based queries as well the ability to filter on certain fields.
Fields can also be updated with various GET requests. Security items include a required secure transport layer with 
TLS 1.2, HTTP basic authentication with Spring Security, and identity based object access(a user can only see their
own data). This is still a work in progress and not all of the API has been implemented yet.