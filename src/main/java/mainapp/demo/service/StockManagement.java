package mainapp.demo.service;

import mainapp.demo.dao.MaterialIn;
import mainapp.demo.dao.MaterialOut;
import mainapp.demo.dao.Replacement;
import mainapp.demo.dao.StockRepository;
import mainapp.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockManagement {
    @Autowired
    private MaterialIn materialIn;
    @Autowired
    private MaterialOut materialOut;
    @Autowired
    private Replacement replacement;
    @Autowired
    private StockRepository stockRepository;


    public Boolean checkName(List<String> productName) {
        System.out.println((stockRepository.checkName(productName)));
        System.out.println(productName);
        return productName.equals(stockRepository.checkName(productName));
    }

    public void updateMainStock(String productName, Integer quantity, String updateDate) {
        MainStock prod = stockRepository.findByProductName(productName);
        prod.setQuantity(prod.getQuantity() + quantity);
        prod.setUpdateDate(updateDate);
        System.out.println(prod.getQuantity());
        stockRepository.save(prod);
    }

    public void save(ItemInVO product) {
        MainStock prod = new MainStock(null,product.getProductName(),product.getQuantity(),product.getInsertionDate());
        stockRepository.save(prod);
    }

    public List<String> listProductName() {
        return stockRepository.getNames();
    }

    public void addProductToItemIn(ItemInVO product) {
        ItemIn prod = new ItemIn(null,product.getProductName(),product.getQuantity(),product.getInsertionDate(),product.getSeller());
        materialIn.save(prod);
    }

    public void updateMainStockOut(String productName, Integer quantity, String updateDate) {
        MainStock prod = stockRepository.findByProductName(productName);
            prod.setQuantity(prod.getQuantity()-quantity);
            prod.setUpdateDate(updateDate);
    }

    public MainStock getProdByName(String name){
       return stockRepository.findByProductName(name);
    }

    public void addProductToItemOut(ItemsOutVo product) {
        ItemsOut prod = new ItemsOut(null,product.getProductName(),product.getDate(),product.getBuyer(),product.getQuantity());
        materialOut.save(prod);
    }

    public void addProductToItemReplace(ItemReplaceVo product) {
        ItemReplace prod = new ItemReplace(null,product.getProductName(),product.getBuyer(),product.getQuantity(),product.getDate(),product.getReplacementMethod(),product.getRemark());
        replacement.save(prod);
    }

    public void updateMainStockReplace(String productName, Integer quantity, String date) {
        updateMainStockOut(productName, quantity, date);
    }
}
