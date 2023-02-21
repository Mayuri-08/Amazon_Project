
Feature: Amazon Customization

  Scenario: Verify that the user is able to search for the product
  Given the user navigates to home page
  When the user enters with the product
  Then the user is able to view for a product


  Scenario: Verify that user is able to search a product according to her price range
    Given the user navigates to home page
    When the user enters with the product
    And the user enters min Price
    And the user enters max Price
    Then the user is able to view a product according to the range


    Scenario: Verify that the user is able Select from the dropdown feature after searching for a product
      Given the user navigates to home page
      When the user enters with the product
      And the user selects from the drop down feature
      Then the user is able to view a product as per selected feature


      Scenario: Verify that the user is able to select different features from different category for a searched product
        Given the user navigates to home page
        When the user enters with the product
        And the user selects a OS feature
        And the user selects display type
        And the user selects cellular technology
        Then the user is able to view for a product
@smoke
  Scenario Outline: Customize product on Amazon
    Given the user navigates to home page
    When user searches for "<product>"
    And user selects the  brand
    Then the item should be applied

    Examples:
      | product     |
      | T-shirt     |
      | Earphones   |








