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
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "product")

public class Product extends BaseModel {
    @JacksonXmlProperty(isAttribute = true, localName = "price")
    private double price;
    @JacksonXmlProperty(isAttribute = true, localName = "amount")
    private int amount;
    @JacksonXmlProperty(isAttribute = true, localName = "shopId")
    private UUID shopId;
    @JacksonXmlProperty(isAttribute = true, localName = "categoryId")
    private UUID categoryId;
    @JacksonXmlProperty(isAttribute = true, localName = "deliveryDate")
    private Date deliveryDate;

}
