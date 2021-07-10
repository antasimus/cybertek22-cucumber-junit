Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts.And dashboard should be displayed.
  Accounts are: librarian, student, admin

    @librarian @employee
    Scenario: Login as Librarian
      Given user is on login page
      When user enters librarian username
      And user enters librarian password
      Then user should see the dashboard

    @student
    Scenario: Login as student
      Given user is on login page
      When user enters student username
      And user enters student password
      Then user should see the dashboard

      @admin @employee
    Scenario: Login as Admin
      Given user is on login page
      When user enters admin username
      And user enters admin password
      Then user should see the dashboard