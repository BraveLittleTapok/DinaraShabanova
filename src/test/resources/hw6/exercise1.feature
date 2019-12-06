Feature: Exercise 1

    Scenario: Check different pages
      Given I open EPAM JDI Site
      And I login as '{0}' with password '{1}'
      I click item '{0}' on the Header Menu
      Username should be '{0}' on the Home Page

