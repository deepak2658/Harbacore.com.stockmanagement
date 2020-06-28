package stkmgt.StockServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stkmgt.dao.*;
import stkmgt.model.*;

import java.util.List;

@Service
public class StockServices {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MainStockRepository stockRepository;
    @Autowired
    private StockInRepository stockInRepository;
    @Autowired
    private StockOutRepository stockOutRepository;
    @Autowired
    private ReplacementRepository replacementRepository;

    private Products getProduct(String productName) {
        return productRepository.findProductByproductName(productName);
    }

    public List<String> getAllProducts() {
       return productRepository.findAllProductsByName();
    }

    public boolean checkName(List<String> productName) {
        return productName.equals(productRepository.checkName(productName));
    }

    @Transactional
    public void updateMainStockAndProductIn(ProductsInVo product) {
        //updating main stock table
        MainStock prod = stockRepository.findByProductName(product.getProductName());
        prod.setQuantity(prod.getQuantity() + product.getQuantity());
        prod.setUpdateDate(product.getInsertionDate());
        stockRepository.save(prod);
        //save to productin table
        ProductsIn prod1 = new ProductsIn(null,product.getProductName(),product.getQuantity(),product.getInsertionDate(),product.getSeller(),getProduct(product.getProductName()));
        stockInRepository.save(prod1);
    }

    @Transactional
    public void addToMainStockAndProductIn(ProductsInVo product) {
        //save to product
        Products prod1 = new Products(null,product.getProductName());
        productRepository.save(prod1);
        //save to main stock table
        MainStock prod2 = new MainStock(product.getProductName(),product.getQuantity(),product.getInsertionDate(),getProduct(product.getProductName()));
        stockRepository.save(prod2);
        //save to productin table
        ProductsIn prod3 = new ProductsIn(null,product.getProductName(),product.getQuantity(),product.getInsertionDate(),product.getSeller(),getProduct(product.getProductName()));
        stockInRepository.save(prod3);
    }

    public MainStock getProdByName(String productName) {
        return stockRepository.findByProductName(productName);
    }

    @Transactional
    public void updateMainStockOutAndProductsOut(ProductsOutVo product) {
        //saving to mainstock table
        MainStock prod1 = stockRepository.findByProductName(product.getProductName());
        prod1.setQuantity(prod1.getQuantity()-product.getQuantity());
        prod1.setUpdateDate(product.getDate());
        //saving to product out table
        ProductsOut prod2 = new ProductsOut(null,product.getProductName(),product.getDate(),product.getBuyer(),product.getQuantity(),getProduct(product.getProductName()));
        stockOutRepository.save(prod2);
    }

    @Transactional
    public void updateMainStockAndReplacement(ProductReplaceVo product) {
        //updating mainstock table
        MainStock prod1 = stockRepository.findByProductName(product.getProductName());
        prod1.setQuantity(prod1.getQuantity()-product.getQuantity());
        prod1.setUpdateDate(product.getDate());
        stockRepository.save(prod1);
        //adding to replacement table
        ProductReplace prod2 = new ProductReplace(null,product.getProductName(),product.getBuyer(),product.getQuantity(),product.getDate(),product.getReplacementMethod(),product.getRemark(),getProduct(product.getProductName()));
        replacementRepository.save(prod2);
    }

    public List<MainStock> getAllProductsList() {
    return stockRepository.findAll();
    }
}
