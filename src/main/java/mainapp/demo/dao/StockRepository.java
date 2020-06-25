package mainapp.demo.dao;

import mainapp.demo.model.MainStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<MainStock,Long> {

    @Query("SELECT productName from MainStock ")
    List<String> getNames();

    @Query("SELECT productName from MainStock where productName = :check")
    List<String> checkName(List check);

    MainStock findByProductName(String name);

    @Query("update MainStock set quantity = :newQuantity, updateDate=:newdate where productName =:prodname" )
    void updateProduct(Integer newQuantity, String newdate, String prodname);


}
