package stkmgt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsOut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seqNo;
    private String productName;
    private String date;
    private String Buyer;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;
}
