import bot.bot_base.botLogic.MyBot;
import database.BaseUrl;
import model.user.User;
import model.user.UserRole;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import service.UsersService;
import ui.HomeUI;

public class Main {

    public static void main(String[] args) throws Exception {
        BaseUrl.urls.add("C:\\Users\\Tohir\\Desktop\\Amazon\\src\\main\\java\\database\\");
        BaseUrl.urls.add("C:\\D\\PDP\\Java Backend FAANG\\Amazon\\src\\main\\java\\database");
        BaseUrl.url = BaseUrl.urls.get(1);
        UsersService usersService = new UsersService();
        usersService.add(UserRole.SUPER_ADMIN, "super", "123");

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new MyBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

        HomeUI.home();

    }
}
