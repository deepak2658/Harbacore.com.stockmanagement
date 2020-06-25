package mainapp.demo.dao;

import mainapp.demo.model.ItemReplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Replacement extends JpaRepository<ItemReplace,Long> {
}
