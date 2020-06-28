package stkmgt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsIn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seqNo;
    private String productName;
    private  Integer quantity;
    private String insertionDate;
    private String seller;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;
}
