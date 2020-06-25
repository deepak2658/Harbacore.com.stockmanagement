package mainapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}
