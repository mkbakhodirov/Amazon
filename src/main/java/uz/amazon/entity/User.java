package uz.amazon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.amazon.abstractEntity.BaseModel;
import uz.amazon.enums.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {
    private UserRole role;
    private String phoneNumber;
    private String password;
}
