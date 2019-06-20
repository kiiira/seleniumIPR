Feature: MainPage

  @Test
  Scenario: 01 - Main page operations

    Given test host open
    And type in "Логин" field value "kerakeera@inbox.ru"
    And type in "Пароль" field value "testytest123"
    Then main page opened
    And click "Написать письмо" button
    # //span[contains(@class, 'compose-button') and text() ='Написать письмо']
    And fill "Кому" field with value "testytest@test.com"
    # //div[text()='Кому']//ancestor::div//div[contains(@class, 'input')]
    And fill "Тема" field with value "This is a very small letter"
    # //div[text()='Тема']//ancestor::div//div[contains(@class, 'input')]
    And fill "Тело письма" field with value "A teeny-tiny one."
    # pick css selector
    And click "Сохранить" button

    Then open newly created template
    And the template has "testytest@test.com" as "Адресат"
    And the template has "This is a very small letter" as "Тема письма"
    And the template has "A teeny-tine one" as "Тело письма"
    And press send button
    And go to templates
    Then template with header "" has been deleted
    And open "Sent" section
    Then there is the lettter with header ""
    Then log out



