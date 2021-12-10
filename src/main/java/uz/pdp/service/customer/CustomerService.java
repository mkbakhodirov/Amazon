package uz.pdp.service.customer;
//Muhammadaliy Furkatbek Umaraliev , 0:13

import uz.pdp.library.SessionMessage;
import uz.pdp.model.user.User;
import uz.pdp.service.interfaces.BaseInterface;

import static uz.pdp.library.Util.*;

public class CustomerService implements BaseInterface, SessionMessage {
    @Override
    public void menu(User user) {

        print(CYAN, """
                1.PRODUCT LIST
                2.MY CART
                3.CHECKOUT
                4.HISTORY ACTION
                0.LOGOUT
                """);

        switch (inputInt()) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 0:
                print(BLACK, LOGOUT_SUCCESS);
                break;
            default:
                print(RED, WRONG_OPTION);
                break;
        }
        menu(user);
    }
}
