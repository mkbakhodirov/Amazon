package model.user;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.base.BaseModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class User extends BaseModel {
    @JacksonXmlProperty(isAttribute = true, localName = "role")
    private UserRole role;
    @JacksonXmlProperty(isAttribute = true, localName = "phoneNumber")
    private String phoneNumber;
    @JacksonXmlProperty(isAttribute = true, localName = "password")
    private String password;
    @JacksonXmlProperty(isAttribute = true, localName = "username")
    private String username;
}
