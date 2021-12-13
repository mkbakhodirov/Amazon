package service;

import bot.bot_replies.ReplyBot;
import model.payment.PaymentType;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MyBotService implements ReplyBot {

    public static InlineKeyboardMarkup getButtons(int numberOfButtons) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        inlineKeyboardMarkup.setKeyboard(list);

        List<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();

        for (int i = 0; i < numberOfButtons; i++) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText((i + 1) + "");
            inlineKeyboardButton.setCallbackData(String.valueOf(i));
            inlineKeyboardButtons.add(inlineKeyboardButton);

            if ((i + 1) % 3 == 0) {
                list.add(inlineKeyboardButtons);
                inlineKeyboardButtons = new ArrayList<>();
            }
        }
        return inlineKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup menu() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setResizeKeyboard(true);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(BUY);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(PAYMENT_TYPE);
        keyboardRow1.add(BALANCE);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(WEBPAGE);
        keyboardRow2.add(HISTORY);

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);

        return replyKeyboardMarkup;
    }

    static CategoriesService categoriesService;

    public static InlineKeyboardMarkup buymenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        inlineKeyboardMarkup.setKeyboard(list);

        List<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();
        if(categoriesService.getList() != null)
        for (int i = 0; i < categoriesService.getList().size(); i++) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(categoriesService.getList().get(i).toString());
            inlineKeyboardButton.setCallbackData(String.valueOf(i));
            inlineKeyboardButtons.add(inlineKeyboardButton);

            if (i + 1 % 3 == 0) {
                list.add(inlineKeyboardButtons);
                inlineKeyboardButtons = new ArrayList<>();
            } else if (i > categoriesService.getList().size() - 3 && inlineKeyboardButtons != null)
                list.add(inlineKeyboardButtons);
        }
        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup payType() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        inlineKeyboardMarkup.setKeyboard(list);

        List<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();

        List<PaymentType> paymentTypeList = new ArrayList<>();
        paymentTypeList.add(PaymentType.PAY_ME);
        paymentTypeList.add(PaymentType.VISA);
        paymentTypeList.add(PaymentType.PAY_PAL);
        paymentTypeList.add(PaymentType.MASTER_CARD);
        paymentTypeList.add(PaymentType.CLICK);
        for (int i = 0; i < paymentTypeList.size(); i++) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(paymentTypeList.get(i).toString());
            inlineKeyboardButton.setCallbackData(String.valueOf(i));
            inlineKeyboardButtons.add(inlineKeyboardButton);

            if (i % 2 == 0) {
                list.add(inlineKeyboardButtons);
                inlineKeyboardButtons = new ArrayList<>();
            }  //else if (i > categoriesService.getList().size() - 3 && inlineKeyboardButtons != null)
               //  list.add(inlineKeyboardButtons);
        }
        return inlineKeyboardMarkup;
    }
}
