package uz.pdp.service.amazon;


//Muhammadaliy Furkatbek Umaraliev , 23:52


import uz.pdp.library.SessionMessage;
import uz.pdp.model.user.User;
import uz.pdp.service.interfaces.BaseInterface;

import static uz.pdp.library.Util.*;


public class AmazonService implements BaseInterface, SessionMessage {


    @Override
    public void menu(User user) {

        print(CYAN, """
                1.USER ACTION
                2.SHOP ACTION
                3.STORE ACTION
                4.HISTORY ACTION
                5.CATEGORY ACTION
                6.BALANCE
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
