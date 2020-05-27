@LCDLV
Feature: get shopping cart

  Scenario: get shopping cart
    Given the following book are present in a client shopping cart
      | id | name                    | price |
      | 1  | The Philosopher's Stone | 10    |
      | 2  | The Chamber of Secrets  | 10    |
      | 3  | The Prisoner of Azkaban | 10    |
      | 4  | The Goblet of Fire      | 10    |

    When client want to see his shopping cart

    Then api should display a shopping cart with the following books
      | id | name                     | price |
      | 1  | The Philosopher's Stone  | 10    |
      | 2  | The Chamber of Secrets   | 10    |
      | 3  | The Prisoner of Azkaban  | 10    |
      | 4  | The Goblet of Fire       | 10    |

