Feature: MainPage

  Scenario: 01 - Main page operations

    * test host open

    # login actions
    * fill e-mail field with value "kerakeera@gmail.com"
    * press "Далее" button
    * fill password field with value "testytest123"
    * press "Далее" button

    # create a letter
    * click "Написать" div button
    * fill "Кому" addressee field with value "testytest@test.test"
    * fill "Тема" subject field with random value
    * fill "Тело письма" text field with value "This is a very small letter"
    * click "Сохранить и закрыть" button in letter title bar
    * go to "Черновики" folder
    * the letter has been created

    # send the letter and check if it deleted from templates folder
    * open the template
    * the template has addressee field as "testytest@test.test"
    * the template has subject field as randomly generated text
    * the template has body field as "This is a very small letter"
    * press "Отправить" button in letter window
    * go to "Черновики" folder
    * the template has been deleted

    # check the letter moved to sent folder and log out
    * go to "Отправленные" folder
    * the letter has been created
    * press account button