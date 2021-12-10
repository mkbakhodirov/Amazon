import Database.BaseUrl;
import ui.HomeUI;

public class Main {

    public static void main(String[] args) throws Exception {
        BaseUrl.urls.add("C:\\D\\PDP\\Java Backend FAANG\\Amazon\\src\\main\\java\\Database\\");
        BaseUrl.urls.add("C:\\Users\\Tohir\\Desktop\\Amazon\\src\\main\\java\\Database\\");
        BaseUrl.urls.add("/home/muhammadsodiq/PDP Projects/Amazon1/src/main/java/Database\\");
        BaseUrl.url = BaseUrl.urls.get(0);
        HomeUI.home();
    }
}
