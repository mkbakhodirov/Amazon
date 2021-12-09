package uz.amazon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.amazon.abstractEntity.BaseModel;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel {
    private double price;
    private int amount;
    private UUID shopId;
    private UUID categoryId;
    private Date deliveryDate;

}