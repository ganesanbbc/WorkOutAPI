
Feature: As a developer I want to create service definition, define the request and response details
  so that I know which RTFA micro service should be produced and what is required for implementing the service.


  Background:


  Scenario Outline: Create Swagger specification API's information details for FraudAssessment API
    Given Requirement specification and external interface details and its service definitions if any
    When creating service specification file in yaml editor
    Then able to define <SECTION> with <KEY> having <VALUE>

    Examples:
      | SECTION | KEY         | VALUE
      | Info    | title       | Real Time Fraud Assessment
      | Info    | description | This specification includes service definitions for RTFA
      | Info    | version     | 1.0


  Scenario Outline: Create Swagger specification API's endpoint detail for FraudAssessment API
    Given Requirement specification and external interface details and its service definitions if any
    When creating service specification file in yaml editor
    Then able to define host/endpoint information like <KEY> having <VALUE>

    Examples:
      | KEY      | VALUE
      | Host     | <hostname>
      | basePath | /v1/rtfa
      | Schemes  | http, https

  Scenario Outline: Create Swagger specification API's service methods for FraudAssessment API
    Given Requirement specification and external interface details and its service definitions if any
    When creating service specification file in yaml editor
    Then able to define service having <SECTION> having <SUBSECTION> with <KEY> having <VALUE>
    Examples:
      | SECTION | SUBSECTION | KEY              | VALUE
      | Paths   |            | endpoint path    | /fraudassessment
      | Paths   |            | method           | Post
      | Paths   |            | tags             | RTFA
      | Paths   |            | summary          | Assess Fraud details for customer
      | Paths   |            | description      | Assess Fraud details for customer
      | Paths   |            | operation        | performFraudAssessment
      | Paths   |            | consumes         | application/json
      | Paths   |            | produces         | application/json
      | Paths   | parameters | body             | FraudAssessmentRequest
      | Paths   | parameters | header.authToken | <<OAUTH-TOKEN>>
      | Paths   | responses  | 200              | FraudAssessmentResponse
      | Paths   |            | 400              | FraudAssessmentResponse
      | Paths   |            | 401              | FraudAssessmentResponse


  Scenario Outline: Create Swagger specification API's  model definitions for FraudAssessment API
    Given Requirement specification and external interface details and its service definitions if any
    When creating service specification file in yaml editor
    Then able to define <SECTION> with <KEY>
    Examples:
      | SECTION     | KEY
      | definitions | FraudAssessmentRequest
      | definitions | FraudAssessmentResponse


  Scenario Outline: Create Swagger specification API's property definitions for models
    Given Requirement specification and external interface details and its service definitions if any
    When creating service specification file in yaml editor
    Then able to define <PROPERTY> as a <TYPE> in <ENTITY>
    Examples:
      | PROPERTY | TYPE    | ENTITY
      | id       | integer | FraudAssessmentRequest
      | order_id | integer | FraudAssessmentRequest
      | message  | string  | FraudAssessmentResponse
