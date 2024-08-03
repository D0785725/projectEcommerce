package bin.javaproject.projectecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    private List<Integer> productIds;
    @Column(name="status")
    private String status;
    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="total_amount",nullable = false)
    private Double totalAmount;



}
