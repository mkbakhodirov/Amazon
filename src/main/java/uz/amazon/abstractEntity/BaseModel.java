package uz.amazon.abstractEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {
    protected final UUID id;
    protected String name;
    protected boolean isActive;
    protected Date createdAt;
    protected Date updatedAt;

    {
        id = UUID.randomUUID();
    }
}