package bin.javaproject.projectecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name =  "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(name = "quantity", nullable = false)
    private int quantity ;
    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;
    @Column(name = "discount", nullable = false)
    private Double discount;
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
    public OrderDetail(Order order, Product product, int quantity, Double unitPrice, Double discount) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    // Calculate the total price for this order detail considering discount
    public Double getTotalPrice() {
        return quantity * unitPrice * (1 - discount);
    }

    // Increase quantity
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    // Decrease quantity
    public void decreaseQuantity(int amount) {
        if (this.quantity > amount) {
            this.quantity -= amount;
        } else {
            this.quantity = 0; // Or handle as exception
        }
    }
}
