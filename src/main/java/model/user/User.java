package model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import model.base.BaseModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class User extends BaseModel {
    private UserRole role;
    private String phoneNumber;
    private String chatId;
    private String username;
    private String password;
    private double balance;

    public User(String name, UserRole role, String phoneNumber, String chatId) {
        super(name);
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.chatId = chatId;
    }

    public User(UserRole role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }
}