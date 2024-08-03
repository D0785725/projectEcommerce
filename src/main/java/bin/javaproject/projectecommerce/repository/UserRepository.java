package bin.javaproject.projectecommerce.repository;


import bin.javaproject.projectecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
