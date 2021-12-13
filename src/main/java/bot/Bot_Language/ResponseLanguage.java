package bot.Bot_Language;

 public class ResponseLanguage {

    protected class Language{

        public String messageUz;
        public String messageRu;
        public String messageEn;

        public Language(String messageUz, String messageRu, String messageEn) {
            this.messageUz = messageUz;
            this.messageRu = messageRu;
            this.messageEn = messageEn;
        }

        @Override
        public String toString() {
            return "Language{" +
                    "messageUz='" + messageUz + '\'' +
                    ", messageRu='" + messageRu + '\'' +
                    ", messageEn='" + messageEn + '\'' +
                    '}';
        }
    }
    private int status;
    private Language language;

    public ResponseLanguage(int status, Language language) {
        this.status = status;
        this.language = language;
    }

    public ResponseLanguage() {
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", language=" + language +
                '}';
    }
}