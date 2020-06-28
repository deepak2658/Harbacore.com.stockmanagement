package stkmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import stkmgt.model.ProductsIn;

public interface StockInRepository extends JpaRepository<ProductsIn,Integer> {
}
