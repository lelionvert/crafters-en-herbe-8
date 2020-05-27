Feature: Compute a shopping cart price with discount

  Scenario Outline: add books
    Given A shopping cart
      | name                     | Quantity |
      | The Philosopher's Stone  | <book1>  |
      | The Chamber of Secrets   | <book2>  |
      | The Prisoner of Azkaban  | <book3>  |
      | The Goblet of Fire       | <book4>  |
      | The Order of the Phoenix | <book5>  |
    When I compute the cart price
    Then I get <result>
    Examples:
      | book1 | book2 | book3 | book4 | book5 | result |
      | 0     | 0     | 0     | 0     | 0     | 0      |
      | 0     | 1     | 0     | 0     | 0     | 10     |
      | 0     | 0     | 2     | 0     | 0     | 20     |
      | 1     | 0     | 1     | 0     | 0     | 19     |

