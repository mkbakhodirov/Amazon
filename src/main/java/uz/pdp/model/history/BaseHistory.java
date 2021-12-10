package uz.pdp.model.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.model.Product;
import uz.pdp.model.base.BaseModel;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class BaseHistory extends BaseModel {

    private double price;
    private int amount;
    private UUID productId;
    private UUID userId;
    private UUID paymentId;

}
