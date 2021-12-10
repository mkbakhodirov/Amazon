package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Amount {
    @JacksonXmlProperty(isAttribute = true, localName = "discount")
    private double discount;
    @JacksonXmlProperty(isAttribute = true, localName = "balance")
    private double balance;
    @JacksonXmlProperty(isAttribute = true, localName = "userId")
    private UUID userId;
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private final UUID id;

    {
        id = UUID.randomUUID();
    }

    public Amount(UUID userId) {
        this.userId = userId;
    }
}
