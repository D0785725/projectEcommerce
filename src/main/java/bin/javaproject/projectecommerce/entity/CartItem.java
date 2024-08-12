package bin.javaproject.projectecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "uid", nullable = false)
    private User user;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pid", nullable = false)
    private Product product;
    @Column(name = "quantity")
    private int quantity;

    public CartItem(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity+=amount;
    }

    public void decreaseQuantity(int amount) {
        if(this.quantity>amount){
            this.quantity-=amount;
        }else {
            this.quantity=0; // Or handle as exception
        }
    }

}