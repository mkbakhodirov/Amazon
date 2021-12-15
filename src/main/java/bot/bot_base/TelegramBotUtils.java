package bot.bot_base;

import bot.bot_replies.ReplyBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface TelegramBotUtils extends ReplyBot {
    String Bot_UserName = "MyFirstPDP_bot";
    String BOT_TOKEN ="5043279796:AAG4rr4el-7_Z0rYDLGunWj6OPa3CbT6pEM";

    void check(String data) throws TelegramApiException;
//
//    default boolean isStart(String text){
//        return text.equals("/start");
//    }
//
//    default boolean isBuy(String text){
//      return text.equals(BUY);
//    }

}
