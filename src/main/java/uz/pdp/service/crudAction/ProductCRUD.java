package uz.pdp.service.crudAction;
//Muhammadaliy Furkatbek Umaraliev , 0:15


import org.apache.commons.math3.stat.descriptive.summary.Product;
import uz.pdp.library.CrudRepository;
import uz.pdp.library.SessionMessage;
import uz.pdp.library.Util;
import uz.pdp.model.user.User;

import static uz.pdp.library.Util.*;

public class ProductCRUD implements CrudRepository<Product>, SessionMessage {
    //    private String name;
    //    private int productCode;
    //    private double price;
    //    private double discount;
    //    private int amount;
    //    private UUID shopId;
    //    private UUID categoryId;
    //    private Date deliveryDate;
    @Override
    public void create(User user) {
        print(CYAN, ENTER_PRODUCT_NAME);
        String name = Util.inputStr();
        print(CYAN, "ENTER_PRODUCT_PRICE");
        double price = inputDouble();
        print(CYAN, "ENTER_PRODUCT_DISCOUNT");
        double discount = inputDouble();
        print(CYAN, "ENTER_PRODUCT_AMOUNT");
        int amount = inputInt();


    }

    @Override
    public void read(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Product findById() {
        return null;
    }

    @Override
    public Product filter(String object) {
        return null;
    }

    @Override
    public void writeJson() {

    }

    @Override
    public void crudMenu(User user) {
        print(CYAN, """
                1.USER ACTION
                2.PRODUCT ACTION
                3.STORE ACTION
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
        crudMenu(user);
    }
}
