package bot.bot_base.botLogic;

import bot.bot_base.TelegramBotUtils;
import bot.bot_pictures.Base;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class MyBot extends TelegramLongPollingBot implements TelegramBotUtils, Base {

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
        String data = "";
        this.chatId = update.getMessage().getChatId().toString();
//        Contact contact = update.getMessage().getContact();
        BotState botState = null;
        if (update.hasMessage()) {
            String text = update.getMessage().getText();
            switch (text) {
                case STARTBOT -> {
                    botState = BotState.STARTHELLO;
                }
//                case MENU -> {
//                    botState = BotState.START;
//                }
                case BUY -> {
                    botState = BotState.BUY;
                }
                case PAYMENT_TYPE -> {
                    botState = BotState.PAYMENT_TYPE;
                }
                case BALANCE -> {
                    botState = BotState.BALANCE;
                }
                case HISTORY -> {
                    botState = BotState.HISTORY;
                }
                case WEBPAGE -> {
                    botState = BotState.WEBPAGE;
                }
//                default -> execute(null, null, INVALID_COMMAND);
            }
        } else if (update.hasCallbackQuery()) {
            this.chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            data = update.getCallbackQuery().getData();

            if (isCategory(data)) {
                botState = BotState.CATEGORY;
            } else if (isProduct(data)) {
                botState = BotState.PRODUCT;
            } else if (data.equals(BACK)) {
//                botState = BotState.START;
                switch (botState) {
                    case BALANCE -> botState = BotState.START;
                    case HISTORY -> botState = BotState.START;
                    case WEBPAGE -> botState = BotState.START;
                    case BUY -> botState = BotState.START;
                    case CATEGORY -> botState = BotState.START;
                    case PRODUCT -> botState = BotState.SUBCATEGORY;
                    case SUBCATEGORY -> botState = BotState.CATEGORY;
                    case START -> botState = BotState.STARTHELLO;
                }
            }
        }
        switch (botState) {
            case STARTHELLO -> execute(null, MyBotService.menu(), STARTHELLO);
            case START -> execute(null, MyBotService.menu(), null);
            case BUY -> execute(null, MyBotService.buyMenu(), READY);
            case PAYMENT_TYPE -> execute(null, MyBotService.payType(), READY);
            case SUBCATEGORY -> execute(null, null, null);
            //case CATEGORY -> ;
            //case PRODUCT ->    ;
            case HISTORY -> execute(null, MyBotService.history(), READY);
            case BALANCE -> execute(null, MyBotService.balance(data), READY);
            case WEBPAGE -> execute(null, null, WEBPAGE);
            default -> execute(null, null, INVALID_COMMAND);

        }
    }

    private synchronized void execute(ReplyKeyboardMarkup r, InlineKeyboardMarkup i, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(this.chatId);/// kimga junatish krk
        sendMessage.setText(text);/// accountga boradigan message
        sendMessage.setReplyMarkup(i == null ? r : i);

        try {
            execute(sendMessage);
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

