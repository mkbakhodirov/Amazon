package bot.bot_replies.bot_state;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BotState {
    START(1),
    MY_CARDS(2);

    BotState(int i) {
    }
}
