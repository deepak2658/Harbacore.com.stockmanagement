package mainapp.demo.dao;

import mainapp.demo.model.ItemIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialIn extends JpaRepository<ItemIn,Long> {
}
