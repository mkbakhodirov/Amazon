package bot.bot_replies.bot_state;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BotState {
    START1(0),
    START(1),
    BUY(2),
    PAYMENT_TYPE(3),
    BALANCE(4),
    WEBPAGE(5),
    HISTORY(6);
    int ordinal;

}
