package uz.amazon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.amazon.abstractEntity.BaseHistory;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryUser extends BaseHistory {
    private UUID productId;
    private double price;
    private int amount;
}
