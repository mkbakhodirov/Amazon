package bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotMain {
    public static void main(String[] args) throws TelegramApiException {
        try{
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new MyBot());
        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
    }
}
