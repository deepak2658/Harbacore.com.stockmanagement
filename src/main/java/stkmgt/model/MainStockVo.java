package stkmgt.model;

import lombok.Data;

@Data
public class MainStockVo {
    private String productName;
    private Integer quantity;
    private String updateDate;
}
