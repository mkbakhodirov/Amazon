package bot;

import bot.bot_base.TelegramBotUtils;
import bot.bot_pictures.Pictures;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import service.MyBotService;

import java.io.File;

public class MyBot extends TelegramLongPollingBot implements TelegramBotUtils, Pictures {

    private String chatId;
    private String message;
    private String pictureName;

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
            String text = update.getMessage().getText();
            switch (text) {
                case "/start" -> {
                    this.message = START;
                    execute(MyBotService.menu(), null);
                }
                case BUY -> {
                    this.message = "Ready";
                    execute(MyBotService.buymenu(), null);
                }
                case PAYMENT_TYPE -> {
                    this.message = "Ready";
                    execute(MyBotService.payType(), null);
                }
                case BALANCE -> {
                    this.message = "running";
                    sendPhoto();
                }
                case HISTORY -> {
                    this.message = "";
//                    execute(MyBotService.history(), null);
                }
                case WEBPAGE -> {
                    this.message = "Opening...";
                    execute(null, null);
                }
            }
        } else if (update.hasCallbackQuery()) {
            this.chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            String data = update.getCallbackQuery().getData();

            switch (data) {
                case "1" -> this.message = "Men ishlayapman";
            }
        }
    }

    private void execute(ReplyKeyboardMarkup r, InlineKeyboardMarkup i) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(this.chatId);/// kimga junatish krk
        sendMessage.setText(this.message);/// accountga boradigan message
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
//        sendPhoto.setReplyMarkup(MyBotService.getButtons(5));
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
