package bin.javaproject.projectecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
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
    @JoinColumn(name = "uid", nullable = false)
    private User user;

    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    private List<Integer> productIds;


    @Column(name="status")
    private String status;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="totalAmount",nullable = false)
    private Double totalAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "insert_time", nullable = false, updatable = false)
    private Date insertTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time", nullable = false)
    private Date updateTime;


    @PrePersist
    protected void onCreate() {
        insertTime = new Date();
        updateTime = new Date();
    }


}
