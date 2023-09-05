Feature: Login Test
  As a user
  I want to login to the app
  So that i send my credentials

  Scenario Outline: Login Test
    Given I am open the login page
    When I am inputin my "<name>"
    When I am inputing my password
    And Click subbmit button
    Then Main page is displayed

    Examples:
      | name                    |  |
      | standard_user           |  |
      | problem_user            |  |
      | performance_glitch_user |  |
