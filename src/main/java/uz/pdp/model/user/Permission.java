package uz.pdp.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.model.base.BaseModel;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data

@NoArgsConstructor
public class Permission extends BaseModel {
    private String name;
}
