package mainapp.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MainStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMainStock;
    private String productName;
    private Integer quantity;
    private String updateDate;

}
