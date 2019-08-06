Feature: MainPage

  Scenario: 01 - Main page operations

    Given test host open
    And fill e-mail field with value "kerakeera@gmail.com"
    And press "Далее" button
    And fill password field with value "testytest123"
    And press "Далее" button
    And click "Написать" div button
    And fill "Кому" addressee field with value "testytest@test.test"
    And fill "Тема" subject field with random value
    And fill "Тело письма" text field with value "This is a very small letter"
    And click "Сохранить и закрыть" button in letter title bar
    And go to "Черновики" folder
    Then the letter has been created
    And open the template
    And the template has addressee field as "testytest@test.test"
    And the template has subject field as randomly generated text
    And the template has body field as "This is a very small letter"
    And press "Отправить" button in letter window
    And go to "Черновики" folder
    Then the template has been deleted
    And go to "Отправленные" folder
    Then the letter has been created
    And press account button
    And press "Выйти" button in account popup



