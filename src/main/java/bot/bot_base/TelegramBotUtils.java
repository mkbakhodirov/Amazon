package bot.bot_base;

import bot.bot_replies.ReplyBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface TelegramBotUtils extends ReplyBot {
    String Bot_UserName = "amazon_online_shop_bot";
    String BOT_TOKEN ="5062062870:AAGfBZDn8t0L51pWOO1Ip13NR7YIpSsD3hc";

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
