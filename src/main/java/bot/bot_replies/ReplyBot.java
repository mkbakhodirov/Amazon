package bot.bot_replies;

public interface ReplyBot {

     String START = "Assalamu alaykum \nBizning Online Amazon botimizga hush kelibsiz";
     /// Registration
     String SIGN_IN = "Sign in";
     String SIGN_UP = "Sign up";
     String SHARE_CONTACK = "Kontactimini ulashing";

     /// main manu
     String BUY = "\uD83D\uDCBC Sotib olish";
     String PAYMENT_TYPE = "\uD83D\uDCB8 To'lov turi";
     String BALANCE = "\uD83C\uDFE6 Mening Balansim";
     String HISTORY = "\uD83D\uDC40 Histroy";
     String BACK = "\uD83D\uDD19 Back";
     String WEBPAGE = "\uD83D\uDD17 Our Website";
     String PURCHASES = "\uD83D\uDED2 Basket";

          ///  buy menu
     String LAPTOPS = "\uD83D\uDCBB Laptops";
     String MOBILE = "\uD83D\uDCF1 MOBILE";
     String CLOTHES = "\uD83D\uDC55 CLothes";
     String EDIBLES = "\uD83C\uDF5F Edibles";
     String BOOKS = "\uD83D\uDCDA Books";

     //// payment type
     String CLICK = "\uD83D\uDCB3 Click";
     String PAY_ME = "\uD83D\uDCB7 Payme";
     String PAYPAL = "\uD83D\uDCB2 PayPal";
     String MASTER_CARD = "\uD83D\uDCB5 Master Card";
     String VISA = "\uD83D\uDCB0 VISA";

      //// inline keyboard markup words
      String[] BUTTON_WORDS = {"-", "Clear", "+", "\uD83D\uDC4D", "Add to card","\uD83D\uDC4E and ❌"};
     //
     String MINUS = "-";
     String CLEAR = "Clear";
     String ADD = "+";
     String ADD_TO_CARD = "Add to card";
     String LIKE = "\uD83D\uDC4D";
     String DISLIKE = "\uD83D\uDC4E and ❌";
}
