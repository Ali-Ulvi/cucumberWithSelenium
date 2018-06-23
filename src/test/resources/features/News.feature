@News
Feature: News structure
  As a visitor of webrazzi.com/
  I want to check popular news

  Background: User navigates to home page
    Given I am on the Home page on URL "https://webrazzi.com/"

  Scenario: Successful login
    When I Navigate to "2nd" content in the popular news
    Then I should see the browser title is the same with the news title
    And I should see the content has an author
    And I should see the news has an image
