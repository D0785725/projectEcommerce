package bin.javaproject.projectecommerce.services;


import bin.javaproject.projectecommerce.entity.OrderDetail;
import bin.javaproject.projectecommerce.exception.OrderItemNotFoundException;

import bin.javaproject.projectecommerce.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new OrderItemNotFoundException("OrderItem not found with ID: " + id));
    }

    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        // 可以在此處執行驗證或其他業務邏輯
        return orderDetailRepository.save(orderDetail);
    }

    public OrderDetail updateOrderDetail(Long id, OrderDetail orderDetailDetails) {
        OrderDetail orderDetail = getOrderDetailById(id);
        orderDetail.setQuantity(orderDetailDetails.getQuantity());
        orderDetail.setUnitPrice(orderDetailDetails.getUnitPrice());
        orderDetail.setDiscount(orderDetailDetails.getDiscount());
        return orderDetailRepository.save(orderDetail);
    }

    public void deleteOrderItem(Long id) {
        OrderDetail orderDetail = getOrderDetailById(id);
        orderDetailRepository.delete(orderDetail);
    }
}
