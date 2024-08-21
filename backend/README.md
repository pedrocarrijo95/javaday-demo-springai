# OCI Generative AI - Spring Cloud Oracle Sample

This sample demonstrates getting started quickly with Spring Cloud Oracle to work with Oracle Cloud Infrastructure (OCI) Generative AI Service. This sample implements simple REST service which internally uses Spring Cloud Oracle Generate AI APIs.

## What is Spring Cloud Oracle?

Spring Cloud for OCI, eases the integration of OCI services with the help of internal OCI Java SDK. It offers a convenient way to interact with OCI-provided services using well-known Spring idioms and APIs, such as the messaging or storage API. Developers can build applications around the hosted services without concern for infrastructure or maintenance. Spring Cloud for OCI contains autoconfiguration support for OCI-managed services.

## What is OCI Generative AI?

Generative AI is a fully managed Oracle Cloud Infrastructure service that provides a set of state-of-the-art, customizable large language models (LLMs) that cover a wide range of use cases, including chat, text generation, summarization, and creating text embeddings.

## Prerequisites
Configuration items that are needed to run the Application can be configured in `application.properties`.

* `spring.cloud.oci.region.static` - OCI Region name(Ex: us-phoenix-1) where the OCI resources need to be created.
* `spring.cloud.oci.config.type` - Authentication type to be used for OCI. It could be one of the following: RESOURCE_PRINCIPAL, INSTANCE_PRINCIPAL, SESSION_TOKEN, SIMPLE, FILE, and WORKLOAD_IDENTITY. If nothing is specified, FILE type is used by default.
* `spring.cloud.oci.config.file` - The file path set to this property will be used as the configuration file for FILE type authentication which uses the OCI configuration file. If nothing is specified, the OCI configuration file from the user's home directory will be used.
* `spring.cloud.oci.config.profile` - Profile to be used in the OCI config file for Authentication. If a profile is not specified, a DEFAULT profile will be used.

If the `spring.cloud.oci.config.type` is SIMPLE, then the following properties also need to be set in the `application.properties`.

* `spring.cloud.oci.config.userId`
* `spring.cloud.oci.config.tenantId`
* `spring.cloud.oci.config.fingerprint`
* `spring.cloud.oci.config.privateKey`
* `spring.cloud.oci.config.passPhrase`
* `spring.cloud.oci.config.region`

Refer to [OCI SDK Authentication Methods](https://docs.oracle.com/en-us/iaas/Content/API/Concepts/sdk_authentication_methods.htm) for more details on the Authentication types supported by OCI.

## Quick Launch

Clone the repository manually with the following instructions:

```
git clone https://github.com/oracle/spring-cloud-oci.git spring-cloud-oci
```

## Getting Started

1. Run `mvn clean install` from the root directory of the repository code.

1. Set appropriate values at `application.properties` for the following properties. (Refer to the Spring Cloud Oracle docs for more details.)
```
spring.cloud.oci.region.static = US_ASHBURN_1

spring.cloud.oci.genai.embedding.compartment = ${OCI_COMPARTMENT_ID}
spring.cloud.oci.genai.chat.compartment = ${OCI_COMPARTMENT_ID}

spring.cloud.oci.genai.chat.onDemandModelId = ${OCI_CHAT_MODEL_ID}
spring.cloud.oci.genai.embedding.onDemandModelId = ${OCI_EMBEDDING_MODEL_ID}
```
1. Start the application using the following command from sample root directory.
```
mvn spring-boot:run
```

Note: Default service port is `8080`. You can change this with the  `server.port` property.

## Sample Application API Reference

Launch the Swagger UI (http://localhost:8080/swagger-ui/index.html) to view all available APIs and their payload samples.

![Swagger UI](./images/swagger-ui.png)

## References
* [Spring Cloud Oracle - Documentation](#)
* [Spring Cloud Oracle - Open Source](https://github.com/oracle/spring-cloud-oci)
* [OCI SDK - Documentation](https://docs.oracle.com/en-us/iaas/Content/API/Concepts/sdks.htm)

## Contributing
This project is open source.  Submit your contributions by forking this repository and submitting a pull request.  Oracle appreciates any contributions that are made by the open source community.

## License
Copyright (c) 2024 Oracle and/or its affiliates.

Licensed under the Universal Permissive License (UPL), Version 1.0.

See [LICENSE](../../LICENSE.txt) for more details.

ORACLE AND ITS AFFILIATES DO NOT PROVIDE ANY WARRANTY WHATSOEVER, EXPRESS OR IMPLIED, FOR ANY SOFTWARE, MATERIAL OR CONTENT OF ANY KIND CONTAINED OR PRODUCED WITHIN THIS REPOSITORY, AND IN PARTICULAR SPECIFICALLY DISCLAIM ANY AND ALL IMPLIED WARRANTIES OF TITLE, NON-INFRINGEMENT, MERCHANTABILITY, AND FITNESS FOR A PARTICULAR PURPOSE.  FURTHERMORE, ORACLE AND ITS AFFILIATES DO NOT REPRESENT THAT ANY CUSTOMARY SECURITY REVIEW HAS BEEN PERFORMED WITH RESPECT TO ANY SOFTWARE, MATERIAL OR CONTENT CONTAINED OR PRODUCED WITHIN THIS REPOSITORY. IN ADDITION, AND WITHOUT LIMITING THE FOREGOING, THIRD PARTIES MAY HAVE POSTED SOFTWARE, MATERIAL OR CONTENT TO THIS REPOSITORY WITHOUT ANY REVIEW. USE AT YOUR OWN RISK. 