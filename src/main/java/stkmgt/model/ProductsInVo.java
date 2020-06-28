package stkmgt.model;

import lombok.Data;

@Data
public class ProductsInVo {
    private String productName;
    private  Integer quantity;
    private String insertionDate;
    private String seller;
}
