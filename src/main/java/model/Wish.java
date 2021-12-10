package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.base.BaseModel;

import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wish extends BaseModel {
    @JacksonXmlProperty(isAttribute = true, localName = "userId")
    private UUID userId;
    @JacksonXmlProperty(isAttribute = true, localName = "productId")
    private UUID productId;
}
