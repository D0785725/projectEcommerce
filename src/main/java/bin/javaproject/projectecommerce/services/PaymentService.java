//package bin.javaproject.projectecommerce.services;
//
//import com.paypal.api.payments.*;
//import com.paypal.base.rest.APIContext;
//import com.paypal.base.rest.PayPalRESTException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//public class PaymentService {
//
//    @Autowired
//    private APIContext apiContext;
//
//    // 創建支付請求
//    public Payment createPayment(Double total, String currency, String method,
//                                 String intent, String description, String cancelUrl, String successUrl) throws PayPalRESTException {
//
//        // 設置支付金額
//        Amount amount = new Amount();
//        amount.setCurrency(currency);
//        amount.setTotal(String.format("%.2f", total));
//
//        // 設置交易信息
//        Transaction transaction = new Transaction();
//        transaction.setDescription(description);
//        transaction.setAmount(amount);
//
//        List<Transaction> transactions = new ArrayList<>();
//        transactions.add(transaction);
//
//        // 設置付款人信息
//        Payer payer = new Payer();
//        payer.setPaymentMethod(method.toString());
//
//        // 創建支付對象
//        Payment payment = new Payment();
//        payment.setIntent(intent.toString());
//        payment.setPayer(payer);
//        payment.setTransactions(transactions);
//
//        // 設置回調 URL
//        RedirectUrls redirectUrls = new RedirectUrls();
//        redirectUrls.setCancelUrl(cancelUrl);
//        redirectUrls.setReturnUrl(successUrl);
//        payment.setRedirectUrls(redirectUrls);
//
//        // 創建支付
//        return payment.create(apiContext);
//    }
//
//    // 執行支付
//    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
//        Payment payment = new Payment();
//        payment.setId(paymentId);
//        PaymentExecution paymentExecution = new PaymentExecution();
//        paymentExecution.setPayerId(payerId);
//        return payment.execute(apiContext, paymentExecution);
//    }
//}