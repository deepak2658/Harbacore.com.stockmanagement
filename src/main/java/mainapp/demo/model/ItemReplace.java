package mainapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemReplace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItemReplace;
    private String productName;
    private String buyer;
    private Integer quantity;
    private String date;
    private String replacementMethod;
    private String remark;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
