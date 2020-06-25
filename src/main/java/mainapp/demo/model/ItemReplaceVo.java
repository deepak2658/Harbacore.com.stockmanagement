package mainapp.demo.model;

import lombok.Data;

@Data
public class ItemReplaceVo {
    private Integer idItemReplace;
    private String productName;
    private String buyer;
    private Integer quantity;
    private String date;
    private String replacementMethod;
    private String remark;
}
