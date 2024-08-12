package bin.javaproject.projectecommerce.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;

import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uid")
    public Long Id;

    @Column(name = "name")
    String name;
    @Column(name = "role")
    String role;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "insert_time", nullable = false, updatable = false)
    private Date insertTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    // One To Many
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders =new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartItem> cartItems= new ArrayList<>();


    @PrePersist
    protected void onCreate() {
        insertTime = new Date();
        updateTime = new Date();
    }
    // Method for  One To Many
    // Method to add an item to the cart
    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
        cartItem.setUser(this);
    }

    // Method to remove an item from the cart
    public void removeCartItem(CartItem cartItem) {
        cartItems.remove(cartItem);
        cartItem.setUser(null);
    }

}
