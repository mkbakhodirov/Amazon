package bot;

import bot.bot_base.TelegramBotUtils;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import service.MyBotService;

public class MyBot extends TelegramLongPollingBot implements TelegramBotUtils {

    private String chatId;
    private String message;
//    MyBotService services = new MyBotService();

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
                if(isStart(text)){
                    this.message = START;
                    execute(MyBotService.menu(), null);
                }else if(text.equals(BUY)){
                    this.message = BALANCE;
                    execute(MyBotService.categories(), null);
            }
        }
    }
    private void execute(ReplyKeyboardMarkup r, InlineKeyboardMarkup i){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(this.chatId);/// kimga junatish krk
        sendMessage.setText(this.message);/// accountga boradigan message
        sendMessage.setReplyMarkup(i == null ? r: i);

        try{
            execute(sendMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
