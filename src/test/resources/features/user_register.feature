Feature: User register

  Scenario: User is not registered
    Given user is unknown
    When user is registered with success
    Then user is known

  Scenario: User without email
    Given user without email
    When user fail to register
    Then notify email must be not null
