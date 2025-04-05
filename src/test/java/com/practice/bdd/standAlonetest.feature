  @Ecomm
  Feature: Ordering products from Ecommerce website

    Background:
      Given user landed on Ecommerce Page

    @Regression_01
    Scenario Outline: Test for getting product details
      Given user logged in wih "<username>" and "<password>" on "<url>"
      Then user add the "<productName>" to cart and checks out

      Examples:
        | username                | password  | productName     | url                                    |
        | rajat.mahadik@gmail.com | Rahul@3448| ADIDAS ORIGINAL | https://rahulshettyacademy.com/client  |

    @Regression_02
    Scenario Outline: Select the product and place order
      Given user logged in wih "<username>" and "<password>" on "<url>"
      Then user add the "<productName>" to cart
      And user enters pricing details as follows "<countryNameInitials>", "<countryName>", "<ccExpMonth>" and "<ccExpday>"

      Examples:
        | username                | password  | productName     | url                                    | countryNameInitials | countryName | ccExpMonth | ccExpday |
        | rajat.mahadik@gmail.com | Rahul@3448| ADIDAS ORIGINAL | https://rahulshettyacademy.com/client  |      Ind            |  India      |  11        | 07       |

    @Validation
    Scenario Outline: Verify the Order ID
      Given user logged in wih "<username>" and "<password>" on "<url>"
      Then user add the "<productName>" to cart
      And user enters pricing details as follows "<countryNameInitials>", "<countryName>", "<ccExpMonth>" and "<ccExpday>" and proceed
      Then user verifies Order ID

      Examples:
        | username                | password  | productName     | url                                    | countryNameInitials | countryName | ccExpMonth | ccExpday |
        | rajat.mahadik@gmail.com | Rahul@3448| ADIDAS ORIGINAL | https://rahulshettyacademy.com/client  |      Ind            |  India      |  11        | 07       |

