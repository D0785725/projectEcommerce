package bin.javaproject.projectecommerce.repository;

import bin.javaproject.projectecommerce.entity.OrderDetail;
import org.springframework.data.jpa.repository.*;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}