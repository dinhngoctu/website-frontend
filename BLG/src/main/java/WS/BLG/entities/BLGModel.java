package WS.BLG.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BLGModel {
    @Id
    private String id;

    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;

}
