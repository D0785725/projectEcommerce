package bin.javaproject.projectecommerce.entity;
import lombok.*;
import jakarta.persistence.*;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Getter
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    public Long Id;
    @Column(name = "username")
    String Username;
    @Column(name = "email")
    String email;
    @Column(name = "address")
    String address;
    @Column(name = "phone")
    String phone;

}
