package bot.bot_pictures;

public interface Base {
    String EXAMPLE1 = "/home/muhammadsodiq/PDP Projects/Amazon1/src/main/java/bot/bot_pictures/images/calm.jpg";
    String EXAMPLE = "D:\\p.jpg";


    default boolean isCategory(String data){
        return data.startsWith("C");
    }
    default boolean isProduct(String data){
        return data.startsWith("P");
    }
}
