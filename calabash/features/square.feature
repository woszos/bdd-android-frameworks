Feature: Square feature

  Scenario: As a user I can calculate area of square
    Then I press view with id "square_button"
    Then I enter text "5" into field with id "value_x_edittext"
    Then I enter text "8" into field with id "value_y_edittext"
    Then I go back
    Given I press the "Calculate" button
    Then I see the text "Area of square is 40"
