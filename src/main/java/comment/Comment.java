package comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private UUID productId;
    private UUID userId;
    private UUID parentId;
}
