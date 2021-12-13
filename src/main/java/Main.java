import Database.BaseUrl;
import model.user.User;
import model.user.UserRole;
import service.UsersService;
import ui.HomeUI;

public class Main {

    public static void main(String[] args) throws Exception {
        BaseUrl.urls.add("C:\\D\\PDP\\Java Backend FAANG\\Amazon\\src\\main\\java\\Database\\");
        BaseUrl.urls.add("C:\\Users\\Tohir\\Desktop\\Amazon\\src\\main\\java\\Database\\");
        BaseUrl.urls.add("/home/muhammadsodiq/PDP Projects/Amazon1/src/main/java/Database\\");
        BaseUrl.url = BaseUrl.urls.get(0);
        UsersService usersService = new UsersService();
        User superAdmin = new User(UserRole.SUPER_ADMIN, "qwe", "123");
        usersService.add(superAdmin);
        HomeUI.home();
    }
}
