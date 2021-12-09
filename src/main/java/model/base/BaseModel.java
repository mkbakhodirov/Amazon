package model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {
    private final UUID id;
    String name;


    {
        id = UUID.randomUUID();
    }
}
