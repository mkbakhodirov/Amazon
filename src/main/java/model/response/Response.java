package model.response;

public interface Response {
    String SUCCESS = "SUCCESS";
    String CAN_LOGIN = "================ YOU = CAN = LOGIN = NOW ================";
    String NOT_FOUND = "NOT FOUND";
    String AVAILABLE = "AVAILABLE";
    String NOT_AVAILABLE = "NOT AVAILABLE";
    String PHONE_BEGINNING = "+998 ";
    String ENTER_PHONE = "ENTER PHONE NUMBER(SHOULD BE 7 DIGIT AND RECOMENDED WITHOUT SPACE)";
    String ENTER_PASSWORD = "ENTER PASSWORD";
    String ENTER_USERNAME = "ENTER USERNAME";
    String INCORRECT = "INCORRECT";
    String ENTER_PASSWORD_AGAIN = "ENTER PASSWORD AGAIN";
    String GO_TO_REGISTER = "REGISTER FIRST";
    String WANT_GO_BEGINNING = "WANT TO GO BEGINNING? YES(press 1)/NO(press any other number only)";
    String WANT_TAKE = "REALLY WANT TO TAKE THIS BOOK? YES(press 1)/NO(press any other number only)";
    String WELCOME = "WELCOME";
    String SELECT = "******SELECT******";
    String INVALID_COMMAND = "ENTER VALID COMMAND";
    String INVALID_PHONE = "THERE IS ALREADY USER WITH THIS PHONE NUMBER";
    String NAME_USED = "THIS NAME IS ALREADY USED";
    String ENTER_NAME = "ENTER NAME";
    String PHONE_USED = "THIS PHONE IS ALREADY USED";
    String INCORRECT_NUM_TYPE = "NUMBER TYPR IS INCORRECT";
    String WHO_ARE_YOU = "WHO ARE YOU?";
    String INVALID_PRODUCT = "THERE IS ALREADY PRODUCT WITH THIS NAME";
    String INVALID_USERNAME = "THERE IS ALREADY USER WITH THIS USERNAME";
    String INVALID_CATEGORY = "THERE IS ALREADY CATEGORY WITH THIS NAME";
    String INCORRECT_ADMIN = "Username or password is incorrect";
    String EMPTY_LIST = "List is empty";
    String ENTER_INDEX = "Enter index";
}
