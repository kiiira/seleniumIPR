Feature: MainPage

  @Test
  Scenario: 01 - Main page operations

    Given test host open
    And fill e-mail field with value "kerakeera@gmail.com"
    And press "Далее" button
    And fill password field with value "testytest123"
    And press "Далее" button
    And click "Написать" div button
    And fill "Кому" addressee field with value "testytest@test.com"
    And fill "Тема" subject field with value "This is a very small letter"
    And fill "Тело письма" text field with random value
    And click "Сохранить и закрыть" button in letter title bar
    And go to "Черновики" folder
    And check template has been created
    And open the template
    And the template has addressee field as "testytest@test.com"
    And the template has subject field as "This is a very small letter"
    And the template has body field as "A teeny-tine one"

#    And press send button
#    And go to templates
#    Then template with header "" has been deleted
#    And open "Sent" section
#    Then there is the lettter with header ""
#    Then log out



