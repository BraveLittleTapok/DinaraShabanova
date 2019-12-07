Feature: Exercise 1

  Scenario: Check different pages
    Given I open EPAM JDI Site
    Then browser title should be 'Home Page'
    When I login as 'epam' with password '1234'
    Then username should be 'PITER CHAILOVSKII' on the Home page
    And 4 pictures are displayed on the Home Page
    And 4 text are displayed under pictures on the Home Page
    And headline above the pictures is displayed on the Home Page
    And description above the pictures is displayed on the Home Page
    When I click on 'Service' in the header menu
    Then Service in the header menu contains subcategories 'SUPPORT, DATES, SEARCH, COMPLEX TABLE, SIMPLE TABLE, USER TABLE, TABLE WITH PAGES, DIFFERENT ELEMENTS, PERFORMANCE'
    When I click on 'Service' in the left section
    Then Service in the left menu contains subcategories 'Support, Dates, Search, Complex Table, Simple Table, User Table, Table with pages, Different elements, Performance'
    When I click on 'Service' in the header menu
    And I click on 'Different Elements' button in Service dropdown
    Then 'Different Elements' is opened
    And 4 checkboxes are displayed on the Different Elements Page
    And 4 radio are displayed on the Different Elements Page
    And 1 dropdown is displayed on the Different Elements Page
    And 2 buttons are displayed on the Different Elements Page
    And Right Section is displayed on the Different Elements Page
    And Left Section is displayed on the Different Elements Page
    When I select 'Water' checkbox on the Different Elements Page
    Then 1 Log row has 'Water: condition changed to true' on the Different Elements Page
    When I select 'Wind' checkbox on the Different Elements Page
    Then 1 Log row has 'Wind: condition changed to true' on the Different Elements Page
    When I select 'Selen' radio on the Different Elements Page
    Then 1 Log row has 'metal: value changed to Selen' on the Different Elements Page
    When I select 'Yellow' in dropdown on the Different Elements Page
    Then element of dropdown is selected on the Different Elements Page
    And 1 Log row has 'Colors: value changed to Yellow' on the Different Elements Page
    When I select 'Water' checkbox on the Different Elements Page
    Then 1 Log row has 'Water: condition changed to false' on the Different Elements Page
    When I select 'Wind' checkbox on the Different Elements Page
    Then 1 Log row has 'Wind: condition changed to false' on the Different Elements Page



