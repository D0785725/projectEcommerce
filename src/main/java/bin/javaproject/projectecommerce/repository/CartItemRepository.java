package bin.javaproject.projectecommerce.repository;


import bin.javaproject.projectecommerce.entity.CartItem;
import bin.javaproject.projectecommerce.entity.Product;
import bin.javaproject.projectecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
    Optional<CartItem> findByUserAndProduct(User user, Product product);
    void deleteByUserAndProduct(User user, Product product);
}