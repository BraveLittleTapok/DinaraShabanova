Feature: Exercise

  Scenario: Check different pages
    Given I open EPAM JDI Site
    Then browser title should be 'Home Page'
    When I login as 'epam' with password '1234'
    Then username should be 'PITER CHAILOVSKII' on the Home page
    And 4 pictures should be displayed on the Home Page
    And 4 text should be displayed under pictures on the Home Page
    And headline above the pictures should be displayed on the Home Page
    And description above the pictures should be displayed on the Home Page
    When I click on 'Service' button in Header
    Then Service in the header menu should contains subcategories 'SUPPORT, DATES, SEARCH, COMPLEX TABLE, SIMPLE TABLE, USER TABLE, TABLE WITH PAGES, DIFFERENT ELEMENTS, PERFORMANCE'
    When I click on 'Service' in the left section on the Home page
    Then Service in the left menu should contains subcategories 'Support, Dates, Search, Complex Table, Simple Table, User Table, Table with pages, Different elements, Performance'
    When I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown on the Home page
    Then 'Different Elements' is opened
    And 4 checkboxes should be displayed on the Different Elements Page
    And 4 radio should be displayed on the Different Elements Page
    And 1 dropdown should be displayed on the Different Elements Page
    And 2 buttons should be displayed on the Different Elements Page
    And Right Section should be displayed on the Different Elements Page
    And Left Section should be displayed on the Different Elements Page
    When I select 'Water' checkbox on the Different Elements Page
    Then 1 Log row should has 'Water: condition changed to true' on the Different Elements Page
    When I select 'Wind' checkbox on the Different Elements Page
    Then 1 Log row should has 'Wind: condition changed to true' on the Different Elements Page
    When I select 'Selen' radio on the Different Elements Page
    Then 1 Log row should has 'metal: value changed to Selen' on the Different Elements Page
    When I select 'Yellow' in dropdown on the Different Elements Page
    Then element of dropdown should be selected on the Different Elements Page
    And 1 Log row should has 'Colors: value changed to Yellow' on the Different Elements Page
    When I select 'Water' checkbox on the Different Elements Page
    Then 1 Log row should has 'Water: condition changed to false' on the Different Elements Page
    When I select 'Wind' checkbox on the Different Elements Page
    Then 1 Log row should has 'Wind: condition changed to false' on the Different Elements Page

  Scenario: User Table Page test
    Given I am on 'Home Page'
    And I login as user 'Piter Chailovskii'
    When I click on 'Service' button in Header
    And I click on 'User Table' button in Service dropdown
    Then 'User Table' page is opened
    And 6 Number are displayed on Users Table on User Table Page
    And 6 Type Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section
    When I click on dropdown in column Type for user Roman
    Then droplist contains values
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |