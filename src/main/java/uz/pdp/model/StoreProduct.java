package uz.pdp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.model.base.BaseModel;

import java.util.UUID;

@Data
@NoArgsConstructor
public class StoreProduct extends BaseModel {

    private double balance;
    private UUID userId;
    private UUID productId;

}
