package bin.javaproject.projectecommerce.entity;
import lombok.*;
import jakarta.persistence.*;

import lombok.NoArgsConstructor;

import java.util.Date;

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


    @PrePersist
    protected void onCreate() {
        insertTime = new Date();
        updateTime = new Date();
    }

}
