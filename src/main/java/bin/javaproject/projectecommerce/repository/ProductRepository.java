package bin.javaproject.projectecommerce.repository;

import bin.javaproject.projectecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
