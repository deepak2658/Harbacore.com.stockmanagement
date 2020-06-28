package mainapp.demo.dao;

import mainapp.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT productName from Product ")
    List<String> getNames();

    @Query("SELECT productName from Product where productName = :check")
    List<String> checkName(List check);

    Product findByProductName(String productName);

//    @Query("SELECT ")
//    Product findProductByName(List<String> productName);
}
