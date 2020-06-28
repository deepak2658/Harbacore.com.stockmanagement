package stkmgt.model;

import lombok.Data;

@Data
public class ProductReplaceVo {
    private String productName;
    private String buyer;
    private Integer quantity;
    private String date;
    private String replacementMethod;
    private String remark;
}
