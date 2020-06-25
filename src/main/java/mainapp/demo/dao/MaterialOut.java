package mainapp.demo.dao;

import mainapp.demo.model.ItemsOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialOut extends JpaRepository<ItemsOut,Long> {
}
