package mainapp.demo.model;

import lombok.Data;

@Data
public class ItemInVO {
    private Long idItemIn;
    private String productName;
    private  Integer quantity;
    private String insertionDate;
    private String seller;
}
