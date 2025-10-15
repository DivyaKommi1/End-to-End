Feature: LanguageSelection in Amazon HomePage

Scenario: Change language from the homepage
Given the user loads locators from the properties file
And the user is on the Home Page
When the user hovers over the Language Selection option
And the user clicks on a language
Then the page language should change according to the selected option