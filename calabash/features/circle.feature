Feature: Circle feature

  Scenario: As a user I can calculate area of circle
    Then I press view with id "circle_button"
    Then I enter text "55" into field with id "radius_edittext"
    Then I go back
    Given I press the "Calculate" button
    Then I see the text "Area of circle is 9503.32"

  Scenario: As a user I write bad radius
    Then I press view with id "circle_button"
    Then I enter text "-4" into field with id "radius_edittext"
    Then I go back
    Given I press the "Calculate" button
    Then I see the text "Radius must be non-negative"
    Then I clear "radius_edittext"
    Then I go back
    Given I press the "Calculate" button
    Then I see the text "Incorrect data"
