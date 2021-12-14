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
    private UserRole role;
    private String phoneNumber;
    private String password;
    private String username;

    public User(UserRole role, String str, String password) {
        this.role = role;
        if (role.equals(UserRole.USER))
            this.phoneNumber = str;
        else
            this.username = str;
        this.password = password;
    }

    public User(String name, UserRole role, String phoneNumber, String password, String username) {
        super(name);
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.username = username;
    }
}
