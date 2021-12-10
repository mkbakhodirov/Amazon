package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @JacksonXmlProperty(isAttribute = true, localName = "productId")
    private UUID productId;
    @JacksonXmlProperty(isAttribute = true, localName = "userId")
    private UUID userId;
    @JacksonXmlProperty(isAttribute = true, localName = "parentId")
    private UUID parentId;
}
