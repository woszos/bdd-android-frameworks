Feature: Login screen to authenticate users

    Scenario: As a user I can calculate area of circle
        Then I enter text "55" into field with id "radius_edittext"
        Given I press the "Calculate" button
        Then I see the text "Area of circle is 9503.32"

    Scenario: As a user I write bad radius
        Then I enter text "-4" into field with id "radius_edittext"
        Given I press the "Calculate" button
        Then I see the text "Radius must be non-negative"
        Then I clear "radius_edittext"
        Given I press the "Calculate" button
        Then I see the text "Incorrect data"