package bot;

import bot.bot_base.TelegramBotUtils;
import bot.bot_pictures.Pictures;
import bot.bot_replies.bot_state.BotState;
import lombok.Data;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import service.MyBotService;

import java.io.File;

@Data
public class MyBot extends TelegramLongPollingBot implements TelegramBotUtils, Pictures {

    private String chatId;
    private String message;
    private String pictureName;
    private String pathToPicture;

    BotState botState = null;

    @Override
    public void check(String data) {
    }

    @Override
    public String getBotUsername() {
        return Bot_UserName;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        this.chatId = update.getMessage().getChatId().toString();
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String text = update.getMessage().getText();
            switch (text) {
                case "/start" -> botState = BotState.START;
                case BUY -> botState = BotState.BUY;
                case PAYMENT_TYPE -> botState = BotState.PAYMENT_TYPE;
                case BALANCE -> botState = BotState.BALANCE;
                case HISTORY -> botState = BotState.HISTORY;
                case WEBPAGE -> botState = BotState.WEBPAGE;
            }
        } else if (update.hasCallbackQuery()) {
            this.chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            String data = update.getCallbackQuery().getData();

            switch (data) {
                case "1" -> this.message = "Men ishlayapman";
            }
        }
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String text = update.getMessage().getText();
            if (text.equals(BACK)) {
                if (botState == BotState.BUY)
                    botState = BotState.START1;
                else if (botState == BotState.PAYMENT_TYPE)
                    botState = BotState.START1;
            }
        }

        switch (botState) {
            case START -> {
            }
            case START1 -> {

            }
            case BUY -> {
            }
            case PAYMENT_TYPE -> {
            }
            case BALANCE -> {
            }
            case WEBPAGE -> {
            }
            case HISTORY -> {
            }
        }
    }

    private void execute(ReplyKeyboardMarkup r, InlineKeyboardMarkup i) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(this.chatId);/// kimga junatish krk
        sendMessage.setText(this.message);/// accountga boradigan message
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setReplyMarkup(i == null ? r : i);

        try {
            execute(sendMessage);
//            this.message = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendPhoto() {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(this.chatId);
        sendPhoto.setPhoto(new InputFile(new File(EXAMPLE)));
        sendPhoto.setCaption(this.pictureName);
        sendPhoto.setReplyMarkup(MyBotService.getButtons(6));
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
/*
bot state enum ochiladi
keyin obyekt olib botni state beriladi


 */
