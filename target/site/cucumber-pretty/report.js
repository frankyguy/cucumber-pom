$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("loginTest.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "Login to gumtree website",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Login with correct username and password",
  "description": "",
  "id": "login;login-with-correct-username-and-password",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I am on gumtree home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click SignIn link",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I sign in with \u003cusername\u003e and \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should see the home page with user as \"Francis\" logged in",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "login;login-with-correct-username-and-password;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 11,
      "id": "login;login-with-correct-username-and-password;;1"
    },
    {
      "cells": [
        "francisemmanuel786@gmail.com",
        "Test@12345"
      ],
      "line": 12,
      "id": "login;login-with-correct-username-and-password;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5864261500,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Login with correct username and password",
  "description": "",
  "id": "login;login-with-correct-username-and-password;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I am on gumtree home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click SignIn link",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I sign in with francisemmanuel786@gmail.com and Test@12345",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should see the home page with user as \"Francis\" logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "loginSteps.iAmOnGumtreeHomePage()"
});
formatter.result({
  "duration": 9260949100,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.iClickSignInLink()"
});
formatter.result({
  "duration": 1485145000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "francisemmanuel786@gmail.com",
      "offset": 15
    },
    {
      "val": "Test@12345",
      "offset": 48
    }
  ],
  "location": "loginSteps.iEnterUsernameAndPassword(String,String)"
});
formatter.result({
  "duration": 420124400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Francis",
      "offset": 41
    }
  ],
  "location": "loginSteps.iShouldSeeTheHomePageWithUserAsLoggedIn(String)"
});
formatter.result({
  "duration": 6863697400,
  "status": "passed"
});
formatter.after({
  "duration": 965612300,
  "status": "passed"
});
});