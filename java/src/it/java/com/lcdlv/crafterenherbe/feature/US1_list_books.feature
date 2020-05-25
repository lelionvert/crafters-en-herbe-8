Feature: list books

  Scenario: List all books
    When client want to see all books available
    Then api should display the following books
      | id | name                     | price |
      | 1  | The Philosopher's Stone  | 8     |
      | 2  | The Chamber of Secrets   | 8     |
      | 3  | The Prisoner of Azkaban  | 9     |
      | 4  | The Goblet of Fire       | 13    |
      | 5  | The Order of the Phoenix | 14    |
      | 6  | The Half-Blood Prince    | 14    |
      | 7  | The Deathly Hallows      | 14    |