# Atlassian JWT

Atlassian JWT is a library for authenticating requests containing JWTs (JSON Web Tokens) in the query string or Authorization header. It is based on the [11th draft of the JSON Web Token IETF memo](http://tools.ietf.org/html/draft-ietf-oauth-json-web-token-11) by the OAuth Working Group.

See [the JWT draft](http://tools.ietf.org/html/draft-ietf-oauth-json-web-token-11#section-3.1) for more information on making JWT authenticated requests.

# How do I..

## Build atlassian-jwt

Run ``mvn clean install`` from the root directory. (Append ``-DskipTests`` if you want to skip the tests.)

## Run atlassian-jwt in an Atlassian product

**Build atlassian-jwt**, install the [Atlassian SDK](https://developer.atlassian.com/display/DOCS/Getting+Started), then run ``atlas-debug -Dproduct=jira`` from the ``/plugin`` directory.

# Project modules

## jwt-api

The collection of interfaces and utility classes that form the stable API of atlassian-jwt.

## jwt-core

The reference implementation of jwt-api.

## jwt-applinks

A set of services for issuing and verifying JWTs to/from applications linked via [application-links](https://bitbucket.org/atlassian/application-links).

## jwt-plugin

An Atlassian plugin that bundles jwt-api, jwt-core and jwt-applinks modules.

## jwt-test-plugin

An Atlassian plugin that is deployed alongside jwt-test-plugin to expose test functionality needed by the jwt-integration-tests module. 

This module should **never** be deployed in production.

## jwt-integration-tests

A light-weight Jetty application and set of test classes that run against an Atlassian application. 

# Supported Signing Algorithms

Atlassian JWT supports the following JWA signing algorithms:

- HMAC SHA-256 ("HS256")

# Deployment environments

## Atlassian products

Atlassian products should add the jwt-plugin as a bundled plugin. 

Optionally, an Atlassian product may include the jwt-api, jwt-core and jwt-applinks libraries in their WEB-INF/lib directory and look up the implementations provided by jwt-plugin via OSGi. In this way JWT services may be used from the product core. 

## 3rd party applications

Since atlassian-applinks is non-trivial to implement, 3rd party applications should embed only the jwt-api and jwt-core libraries. The integration-tests module contains an example Jetty application that embed jwt-api and jwt-core as a reference.