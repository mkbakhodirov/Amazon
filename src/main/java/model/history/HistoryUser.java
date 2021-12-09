package model.history;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryUser extends BaseHistory {
    @JacksonXmlProperty(isAttribute = true, localName = "productId")
    private UUID productId;
    @JacksonXmlProperty(isAttribute = true, localName = "price")
    private double price;
    @JacksonXmlProperty(isAttribute = true, localName = "amount")
    private int amount;
}
