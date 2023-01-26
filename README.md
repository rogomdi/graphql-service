[![License: LGPL v3](https://img.shields.io/badge/License-LGPLv3-blue.svg)](https://www.gnu.org/licenses/lgpl-3.0)
![CD Pipeline](https://github.com/rogomdi/graphql-service/workflows/CD%20Pipeline/badge.svg)

# GraphQL Service Template
This is a template to start a graphql service with some boilerplate code in place. It contains a dummy query and mutation

Tech stack
---
The project used the followig technologies:
- Java 17
- Spring Boot 3.0
- Github Actions


Continuous integration and continuous deployment (CI/CD)
---
The steps defined in the workflows are the following:
- Build: This step compiles the code. This step runs on every pipeline
- Test: The mission of this step is to run all tests in the project
- Build docker image: (_commented on cd-pipeline.yml_) Builds the docker image for the service
- Publish docker image: (_commented on cd-pipeline.yml_) Publishes the docker image to a docker registry

Software architecture
---

Even though there is only boilerplate code for the graphql layer, the packages are structured in three layers, so we can start building our codebase in a more scalable, maintainable and testable way.

- **Application layer**: is the only one that interacts with the user or any third party wanting to interact with our application. It is the **entrypoint**

 - **Domain layer**: This layer will contain the business logic for the application. We define the interfaces for the repositories or any other external API.

- **Infrastructure layer**: Contains all the implementations for the APIs or repositories defined on the domain layer and, if applies, any configuration parameters for our application. So, here we have all the infrastructure implementations that our application needs to work.
