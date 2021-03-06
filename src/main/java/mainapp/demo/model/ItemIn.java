package mainapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemIn {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idItemIn;
    private String productName;
    private  Integer quantity;
    private String insertionDate;
    private String seller;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

}
