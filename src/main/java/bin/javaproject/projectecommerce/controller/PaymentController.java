//package bin.javaproject.projectecommerce.controller;
//
//
//
//import bin.javaproject.projectecommerce.services.PaymentService;
//import com.paypal.api.payments.Payment;
//import com.paypal.base.rest.PayPalRESTException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/paypal")
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    @Autowired
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    // 發起支付
//    @PostMapping("/pay")
//    public ResponseEntity<Map<String, Object>> pay(@RequestParam Double total) {
//        Map<String, Object> response = new HashMap<>();
//        try {
//            // 創建支付請求
//            Payment payment = paymentService.createPayment(
//                    total, "USD", "paypal",
//                    "sale", "Payment description",
//                    "http://localhost:8080/api/paypal/cancel",
//                    "http://localhost:8080/api/paypal/success");
//
//            // 返回重定向 URL
//            response.put("status", "success");
//            response.put("redirect_url", payment.getPayer());
//        } catch (PayPalRESTException e) {
//            response.put("status", "error");
//            response.put("message", e.getMessage());
//        }
//        return ResponseEntity.ok(response);
//    }
//
//    // 支付成功回調
//    @GetMapping("/success")
//    public ResponseEntity<String> successPay(@RequestParam String paymentId, @RequestParam String PayerID) {
//        try {
//            // 確認支付
//            Payment payment = paymentService.executePayment(paymentId, PayerID);
//            return ResponseEntity.ok("Payment successful! " + payment);
//        } catch (PayPalRESTException e) {
//            return ResponseEntity.badRequest().body("Payment failed: " + e.getMessage());
//        }
//    }
//
//    // 支付取消回調
//    @GetMapping("/cancel")
//    public ResponseEntity<String> cancelPay() {
//        return ResponseEntity.ok("Payment canceled");
//    }
//}