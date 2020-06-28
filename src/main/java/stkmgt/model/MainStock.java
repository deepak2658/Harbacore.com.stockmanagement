package stkmgt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MainStock {
    @Id
    private String productName;
    private Integer quantity;
    private String updateDate;

    @OneToOne
    @JoinColumn(name = "productId")
    private Products product;
}
