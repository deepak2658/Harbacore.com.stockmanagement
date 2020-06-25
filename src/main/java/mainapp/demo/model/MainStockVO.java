package mainapp.demo.model;

import lombok.Data;

@Data
public class MainStockVO {
    private Long idMainStock;
    private String productName;
    private Integer quantity;
    private String updateDate;
}
