@feature_one
Feature: Story1 - Contact form

  Background:
    Given Open Gecko home page

  Scenario: 01 TC - Contact form - Submit no data for all required field
    And Click on link Contact us
    And Click on button for Send message
    Then Verify that in this case User can not send message

  Scenario Outline: 02 TC - Contact form - Submit only data in field Your name
    And Click on link Contact us
    And Enter valid data <testDataForFieldYourName> in field Your name
    And Click on button for Send message after entering data in field Your name
    Then Verify that in this case User can not send message if he enter submit only field Your name

    Examples:

      | testDataForFieldYourName |
      | Predrag                  |

  Scenario Outline: 03 TC - Contact form - Submit only data in field Your Email address
    And Click on link Contact us
    And Enter valid data <testDataForFieldYourEmailAddress> in field Your Email address
    And Click on button for Send message after entering data in field Your Email address
    Then Verify that in this case User can not send message if he enter submit only field Your Email address

    Examples:

      | testDataForFieldYourEmailAddress |
      | office@gecko.rs                  |