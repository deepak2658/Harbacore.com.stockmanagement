package stkmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import stkmgt.model.MainStock;

public interface MainStockRepository extends JpaRepository<MainStock,String> {
    MainStock findByProductName(String productName);
}
