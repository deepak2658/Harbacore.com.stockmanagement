package stkmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import stkmgt.model.ProductsOut;

public interface StockOutRepository extends JpaRepository<ProductsOut,Integer> {
}
