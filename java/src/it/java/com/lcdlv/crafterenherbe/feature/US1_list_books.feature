Feature: list books

  Scenario: List all books
    When client want to see all books available
    Then api should display the following books
      | id | name                     | price |
      | 1  | The Philosopher's Stone  | 10    |
      | 2  | The Chamber of Secrets   | 10    |
      | 3  | The Prisoner of Azkaban  | 10    |
      | 4  | The Goblet of Fire       | 10    |
      | 5  | The Order of the Phoenix | 10    |
      | 6  | The Half-Blood Prince    | 10    |
      | 7  | The Deathly Hallows      | 10    |

