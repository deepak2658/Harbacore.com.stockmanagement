package stkmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import stkmgt.model.Products;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Integer> {
    //Find all products
    @Query("select productName from Products ")
    List<String> findAllProductsByName();

    @Query("select productName from Products where productName=:productName")
    List<String> checkName(List<String> productName);

    Products findProductByproductName(String productName);
}
