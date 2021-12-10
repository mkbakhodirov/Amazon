package uz.pdp.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.model.base.BaseModel;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PaymentType extends BaseModel {
    private String name;
    private double commissionFee;

}
