package model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
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

    public BaseModel(String name, Date createdAt, Date updatedAt) {
        this.name = name;
        this.isActive = true;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
