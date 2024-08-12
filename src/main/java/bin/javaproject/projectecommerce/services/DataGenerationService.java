package bin.javaproject.projectecommerce.services;


import bin.javaproject.projectecommerce.entity.*;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataGenerationService {

    private static final Faker faker = new Faker();
    // 1 create user
    public List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setName(faker.name().fullName());
            user.setRole("User");
//            user.setEmail(faker.internet().emailAddress());
//            user.setPassword(faker.internet().password());
            users.add(user);
        }
        return users;
    }
    // 2. create products
    public List<Product> generateProducts(int count) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setDescription(faker.lorem().sentence());
            product.setPrice(Double.parseDouble(faker.commerce().price()));
            product.setImg("/asset/image"+i);
            products.add(product);
        }
        return products;
    }

    // 3. createe order
    public List<Order> generateOrders(List<User> users, List<Product> products, int orderDetailCountPerOrder) {
        List<Order> orders = new ArrayList<>();
        for (User user : users) {
            List<OrderDetail> userOrderDetails = new ArrayList<>();
            for (int i = 0; i < orderDetailCountPerOrder; i++) {
                Product product = products.get(faker.number().numberBetween(0, products.size()));
                OrderDetail orderDetail = new OrderDetail();
                // orderDetail record product
                orderDetail.setProduct(product);
                orderDetail.setQuantity(faker.number().numberBetween(1, 5));
                orderDetail.setUnitPrice(5.0);
                orderDetail.setDiscount(1.0);
                orderDetail.setUnitPrice(product.getPrice());
                userOrderDetails.add(orderDetail);
            }
            Order order = new Order();
            order.setUser(user);
            order.setOrderDetails(userOrderDetails);
            order.setStatus("notplan");
            order.setTotalAmount(100.0);
            order.setPaymentMethod("Paypli");
            orders.add(order);
            for( OrderDetail orderDetail : userOrderDetails ) {
                orderDetail.setOrder(order);
            }
        }
        return orders;
    }

    public List<CartItem> generateCartItems(List<User> users, List<Product> products) {
        List<CartItem> cartItems = new ArrayList<>();
        for (User user : users) {
            Product product = products.get(faker.number().numberBetween(0, products.size()));
            CartItem cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(faker.number().numberBetween(1, 5));
            cartItems.add(cartItem);
        }
        return cartItems;
    }
}
