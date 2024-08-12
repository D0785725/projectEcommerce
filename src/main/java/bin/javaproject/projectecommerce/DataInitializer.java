package bin.javaproject.projectecommerce;

import bin.javaproject.projectecommerce.entity.*;
import bin.javaproject.projectecommerce.repository.*;
import bin.javaproject.projectecommerce.services.DataGenerationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataInitializer implements CommandLineRunner {
    private final DataGenerationService dataGenerationService;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CartItemRepository cartItemRepository;
    public DataInitializer(
            DataGenerationService dataGenerationService,
            UserRepository userRepository,
            ProductRepository productRepository,
            OrderRepository orderRepository,
            OrderDetailRepository orderDetailRepository,
            CartItemRepository cartItemRepository) {
        this.dataGenerationService = dataGenerationService;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = dataGenerationService.generateUsers(20);
        List<Product> products = dataGenerationService.generateProducts(20);
        List<Order> orders = dataGenerationService.generateOrders(users, products, 3);
        List<CartItem> cartItems = dataGenerationService.generateCartItems(users, products);

        // 将生成的数据保存到数据库
        userRepository.saveAll(users);
        productRepository.saveAll(products);
        orderRepository.saveAll(orders);
        orderDetailRepository.saveAll(extractOrderDetails(orders));
        cartItemRepository.saveAll(cartItems);

        // 打印数据的保存状态
        System.out.println("生成并保存的用户数: " + users.size());
        System.out.println("生成并保存的产品数: " + products.size());
        System.out.println("生成并保存的订单数: " + orders.size());
        System.out.println("生成并保存的购物车项数: " + cartItems.size());
    }

    private List<OrderDetail> extractOrderDetails(List<Order> orders) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (Order order : orders) {
            orderDetails.addAll(order.getOrderDetails());
        }
        return orderDetails;
    }
}
