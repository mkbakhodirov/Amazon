package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Account {
    private double discountPercent;
    private double balance;
    private UUID userId;
    private final UUID id;

    {
        id = UUID.randomUUID();
    }

    public Account(UUID userId) {
        this.userId = userId;
    }
}
