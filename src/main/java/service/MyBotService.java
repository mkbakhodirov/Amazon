package service;

import bot.bot_replies.ReplyBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MyBotService implements ReplyBot {
    private String chatId;
    private String message;

    private InlineKeyboardMarkup getButtons(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        inlineKeyboardMarkup.setKeyboard(list);

        List<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText((i + 1) + "");
            inlineKeyboardButton.setCallbackData(String.valueOf(i));
            inlineKeyboardButtons.add(inlineKeyboardButton);

            if((i + 1) % 3 == 0){
                list.add(inlineKeyboardButtons);
                inlineKeyboardButtons = new ArrayList<>();
            }
        }
        return inlineKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup menu(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setResizeKeyboard(true);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(BUY);

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(PAYMENT_TYPE);
        keyboardRow1.add(BALANCE);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(EXIT);
        keyboardRow2.add(HISTORY);

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);
        keyboardRows.add(keyboardRow2);

        return replyKeyboardMarkup;
    }

    public static ReplyKeyboardMarkup categories(){
        ReplyKeyboardMarkup replyKeyboardMarkup1 = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        replyKeyboardMarkup1.setKeyboard(keyboardRows);
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
//
//        SendMessage sendMessage=new SendMessage();
//        sendMessage.setReplyMarkup(replyKeyboardMarkup1);

        return replyKeyboardMarkup1;
    }
}
