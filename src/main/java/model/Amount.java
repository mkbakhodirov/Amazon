package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Amount {
    private double discount;
    private double balance;
    private UUID userId;
    private final UUID id;

    {
        id = UUID.randomUUID();
    }

    public Amount(UUID userId) {
        this.userId = userId;
    }
}
