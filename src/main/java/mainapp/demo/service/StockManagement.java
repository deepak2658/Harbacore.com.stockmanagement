package mainapp.demo.service;

import mainapp.demo.dao.*;
import mainapp.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    @Autowired
    private ProductRepository productRepository;

    //For in Class Use

    public Boolean checkName(List<String> productName) {
//        System.out.println((stockRepository.checkName(productName)));
//        System.out.println(productName);
        return productName.equals(productRepository.checkName(productName));
    }

    public void updateMainStock(String productName, Integer quantity, String updateDate) {
        MainStock prod = stockRepository.findByProductName(productName);
        prod.setQuantity(prod.getQuantity() + quantity);
        prod.setUpdateDate(updateDate);
        System.out.println(prod.getQuantity());
        stockRepository.save(prod);
    }

    public void save(ItemInVO product) {
        Product product1 = new Product(null,product.getProductName());
        MainStock prod = new MainStock(product.getProductName(),product.getQuantity(),product.getInsertionDate(),productRepository.findByProductName(product.getProductName()));
        System.out.println(product1);
        System.out.println(prod);
        productRepository.save(product1);
        stockRepository.save(prod);
    }

    public List<String> listProductName() {
        return productRepository.getNames();
    }

    public void addProductToItemIn(ItemInVO product) {
        ItemIn prod = new ItemIn(null,product.getProductName(),product.getQuantity(),product.getInsertionDate(),product.getSeller(),productRepository.findByProductName(product.getProductName()));
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
