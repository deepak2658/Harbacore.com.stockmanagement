package mainapp.demo.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MainStock {
    @Id
    private String productName;
    private Integer quantity;
    private String updateDate;


    //The relations
    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;

}
