Feature: Compute a shopping cart price with discount

  Scenario: No book
    Given A shopping cart
      | name                     | Quantity |
      | The Philosopher's Stone  | 0        |
      | The Chamber of Secrets   | 0        |
      | The Prisoner of Azkaban  | 0        |
      | The Goblet of Fire       | 0        |
      | The Order of the Phoenix | 0        |
    When I compute the cart price
    Then I get 0