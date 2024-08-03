package bin.javaproject.projectecommerce.repository;

import bin.javaproject.projectecommerce.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
