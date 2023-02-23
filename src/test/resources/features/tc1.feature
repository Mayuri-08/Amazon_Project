
Feature: Amazon Customization
  Background: User navigates to homepage
    Given the user navigates to home page


  Scenario: Verify that the user is able to search for the product
    When the user enters with the product
    Then the user is able to view for a product


  Scenario: Verify that user is able to search a product according to her price range
    When the user enters with the product
    And the user enters min Price
    And the user enters max Price
    Then the user is able to view a product in  selected price range


    Scenario: Verify that the user is able Select from the dropdown feature after searching for a product
      When the user enters with the product
      And the user selects from the drop down feature
      Then the user is able to view a product as per selected feature


      Scenario: Verify that the user is able to select different features from different category for a searched product
        When the user enters with the product
        And the user selects a OS feature
        And the user selects display type
        And the user selects cellular technology
        Then the user is able to view products from the applied categories


  Scenario Outline: Customize product on Amazon
    When user searches for "<product>"
    And user selects the  "<brand>"
    Then it should display all the related searches "<result>"


    Examples:
      | product     | brand  | result |
      | T-shirt     | Adidas | t-shirt adidas |
      | Earphones   | Boat   | earphones boat |



    Scenario: Verify that the user is able to see the new releases for books section.
      When the user navigates to all section
      Then the user clicks on the books section
      And the user should be able to view the bestseller books









