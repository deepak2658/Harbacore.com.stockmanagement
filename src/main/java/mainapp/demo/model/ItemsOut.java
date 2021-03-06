package mainapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemsOut {
    @Id
    @GeneratedValue
    private Long idItemOut;
    private String productName;
    private String date;
    private String Buyer;
    private Integer quantity;

    //relations
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
