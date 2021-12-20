package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.base.BaseModel;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class Category extends BaseModel {
    private UUID parentId;
    private boolean isLastSubcategory;

    {
        isLastSubcategory = true;
    }

    public Category(String name, UUID parentId) {
        super(name);
        this.parentId = parentId;
    }

    public Category(String name) {
        super(name);
    }
}