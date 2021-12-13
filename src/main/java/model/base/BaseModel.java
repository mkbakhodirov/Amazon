package model.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public abstract class BaseModel {
    protected final UUID id;
    protected String name;
    protected boolean isActive;
    protected Date createdAt;
    protected Date updatedAt;

    {
        isActive = true;
        id = UUID.randomUUID();
        createdAt = new Date();
    }

    public BaseModel(String name) {
        this.name = name;
    }
}
