package service;

import bot.bot_replies.ReplyBot;
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

    public static ReplyKeyboardMarkup buymenu() {
        ReplyKeyboardMarkup replyKeyboardMarkup1 = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        replyKeyboardMarkup1.setKeyboard(keyboardRows);

        replyKeyboardMarkup1.setSelective(true);
        replyKeyboardMarkup1.setOneTimeKeyboard(false);
        replyKeyboardMarkup1.setResizeKeyboard(true);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(LAPTOPS);
        keyboardRow.add(MOBILE);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(EDIBLES);
        keyboardRow1.add(BOOKS);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(BACK);
        keyboardRow2.add(CLOTHES);

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);

        return replyKeyboardMarkup1;
    }

    public static ReplyKeyboardMarkup payType() {
        ReplyKeyboardMarkup replyKeyboardMarkup1 = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        replyKeyboardMarkup1.setKeyboard(keyboardRows);

        replyKeyboardMarkup1.setSelective(true);
        replyKeyboardMarkup1.setOneTimeKeyboard(false);
        replyKeyboardMarkup1.setResizeKeyboard(true);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(CLICK);
        keyboardRow.add(PAY_ME);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(PAYPAL);
        keyboardRow1.add(MASTER_CARD);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(BACK);
        keyboardRow2.add(VISA);

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);

        return replyKeyboardMarkup1;
    }

//    public static SendMessage balance(){
//
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        SendMessage sendMessage = new SendMessage();
//
//        sendMessage.setReplyMarkup(replyKeyboardMarkup);
//        List<KeyboardRow> keyboardRows = new ArrayList<>();
//        replyKeyboardMarkup.setKeyboard(keyboardRows);
//
//        replyKeyboardMarkup.setSelective(true);
//        replyKeyboardMarkup.setOneTimeKeyboard(false);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//
//        KeyboardRow keyboardRow = new KeyboardRow();
//        keyboardRow.add(BACK);
//        keyboardRows.add(keyboardRow);
//
//        replyKeyboardMarkup.setKeyboard(keyboardRows);
//        return sendMessage;
//    }

//    public static ReplyKeyboardMarkup history(){
//        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//        List<KeyboardRow> keyboardRows = new ArrayList<>();
//        replyKeyboardMarkup.setKeyboard(keyboardRows);
//        replyKeyboardMarkup.setResizeKeyboard(true);
//
//        KeyboardRow keyboardRow = new KeyboardRow();
//        keyboardRow.add(BACK);
//        keyboardRows.add(keyboardRow);
//
//        return replyKeyboardMarkup;
//    }
}
