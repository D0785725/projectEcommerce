package bin.javaproject.projectecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderDetail> orderDetails;

//    @ElementCollection
//    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
//    private List<Integer> productIds;
//

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
