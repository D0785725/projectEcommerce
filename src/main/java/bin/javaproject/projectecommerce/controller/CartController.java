package bin.javaproject.projectecommerce.controller;

import bin.javaproject.projectecommerce.entity.CartItem;
import bin.javaproject.projectecommerce.entity.User;

import bin.javaproject.projectecommerce.services.CartService;
import bin.javaproject.projectecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/users/{userId}/cart")
public class CartController {


    private final CartService cartService;
    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long userId) {
        User user = userService.findUserById(userId); // 假設有這個方法根據 ID 獲取用戶
        List<CartItem> cartItems = cartService.getCartItems(user);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addProductToCart(@PathVariable Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        User user = userService.findUserById(userId);
        cartService.addProductToCart(user, productId, quantity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long userId, @RequestParam Long productId) {
        User user = userService.findUserById(userId);
        cartService.removeProductFromCart(user, productId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateProductQuantity(@PathVariable Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        User user = userService.findUserById(userId);
        cartService.updateProductQuantity(user, productId, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/total")
    public ResponseEntity<Double> calculateTotalPrice(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        double total = cartService.calculateTotalPrice(user);
        return ResponseEntity.ok(total);
    }
}
