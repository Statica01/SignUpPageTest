Feature: SignUp
  As a user
  I want to sign up for Mailchimps webservice

  @success
  Scenario Outline: Filling in the sign up form field
    Given I open up "<browser>" as browser
    And Navigate to Sign up page
    When I enter "<email>" into the email form field
    And enter "<username>" into the username form field
    And enter "<password>" into the password form field
    When I click on the signUp button
    Then I should either fail or successfully be signed up
    Examples:
      | browser | email | username        | password    |
      | chrome  | test  | username        | password1!A |
      | edge    | test  | tooLongUsername | password2!A |
      | chrome  | test  | takenUsername   | password3   |
      | chrome  |       | username        | password!A  |