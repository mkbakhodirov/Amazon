package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.base.BaseModel;

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
    private int deliveryDays;

    public Product(String name, double price, int amount, UUID shopId, UUID categoryId, int deliveryDays) {
        super(name);
        this.price = price;
        this.amount = amount;
        this.shopId = shopId;
        this.categoryId = categoryId;
        this.deliveryDays = deliveryDays;
    }
}
