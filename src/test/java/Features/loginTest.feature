Feature: Login
  Login to gumtree website

    Scenario Outline: Login with correct username and password
      Given I am on gumtree home page
      And I click SignIn link
      And I sign in with <username> and <password>
      Then I should see the home page with user as "Francis" logged in

      Examples:
        | username                     | password        |
        | francisemmanuel786@gmail.com | Test@12345      |