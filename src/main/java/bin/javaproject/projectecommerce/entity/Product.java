package bin.javaproject.projectecommerce.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    Long pid;

    @Column(name = "name",nullable = false, length = 100)
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name ="price",nullable = false)
    private Double price;

    @Column(name = "img")
    private String img;


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
