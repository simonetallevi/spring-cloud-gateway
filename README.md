# Spring Cloud Gateway - Examples

The purpose of the repository is to provide some examples of how 
to configure the different capabilities of Spring Cloud Gateway.
For this reason we are going to build 3 different microservices:
- **hello-service**: it exposes examples APIs
- **world-service**: it exposes examples APIs
- **api-gateway**: is a single entry point of our microservices (hello-service and world-service)

Below a simple diagram of the entire architecture:

![alt text][logo]

[logo]: docs/SpingCloudGateway.svg "Architecture"

## How to run the example

To run the example you just need to follow the steps below.

### 0. Before start
Before start please make sure to have [Docker](https://docs.docker.com/get-docker/) and 
[Docker Compose](https://docs.docker.com/compose/install/) properly installed in you system.

### 1. Build
To build the example run:
```
docker-compose build --parallel
```
### 2. Run
To run the example run:
```
docker-compose up
```
### 3. Test
To test the example click on the following links:

A simple redirect from **api-gateway** to **world-service**:
- [http://localhost:8080/world/api/v1/salutation/en](http://localhost:8080/world/api/v1/salutation/en)
- [http://localhost:8080/world/api/v1/salutation/it](http://localhost:8080/world/api/v1/salutation/it)

A redirect with matching variables from **api-gateway** to **hello-service**:
- [http://localhost:8080/hello/api/v1/salutation/en/{name}](http://localhost:8080/hello/api/v1/salutation/en/Try2CatchIt)
- [http://localhost:8080/hello/api/v1/salutation/it/{name}](http://localhost:8080/hello/api/v1/salutation/it/Try2CatchIt)

Endpoint re-writing with matching variables from **api-gateway** to **hello-service**:
- [http://localhost:8080/hello/{name}](http://localhost:8080/hello/Try2CatchIt)
- [http://localhost:8080/ciao/{name}](http://localhost:8080/ciao/Try2CatchIt)
