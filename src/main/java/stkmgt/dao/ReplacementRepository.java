package stkmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import stkmgt.model.ProductReplace;

public interface ReplacementRepository extends JpaRepository<ProductReplace,Integer> {
}
