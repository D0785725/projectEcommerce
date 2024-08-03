package bin.javaproject.projectecommerce.entity;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    Long Id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name ="price",nullable = false)
    private Double price;

    @Column(name ="stock", nullable = false)
    private Integer stock;

    @Column(name = "image_url")
    private String imageUrl;

}
