package model.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
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
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    protected final UUID id;
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    protected String name;
    @JacksonXmlProperty(isAttribute = true, localName = "isActive")
    protected boolean isActive;
    @JacksonXmlProperty(isAttribute = true, localName = "createdAt")
    protected Date createdAt;
    @JacksonXmlProperty(isAttribute = true, localName = "updatedAt")
    protected Date updatedAt;

    {
        id = UUID.randomUUID();
    }

    public BaseModel(String name) {
        this.name = name;
        this.isActive = true;
        this.createdAt = new Date();
    }
}
