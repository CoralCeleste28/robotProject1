package controllers;

import com.example.robotdelivery.model.OrderStatus;
import com.example.robotdelivery.model.OrderStatusResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Duration;
import java.time.Instant;

@Controller
public class OrderStatusController {

    private static final String SESSION_ORDER_START = "orderStartInstant";
    private static final long UPDATE_INTERVAL_MINUTES = 10;

    @GetMapping("/order-status")
    public String orderStatusPage(HttpSession session) {
        // If user lands here for the first time, start the timer
        if (session.getAttribute(SESSION_ORDER_START) == null) {
            session.setAttribute(SESSION_ORDER_START, Instant.now());
        }
        return "order-status";
    }

    // Frontend polls this endpoint every 10 minutes
    @GetMapping("/api/order-status")
    @ResponseBody
    public OrderStatusResponse getOrderStatus(HttpSession session) {

        Instant start = (Instant) session.getAttribute(SESSION_ORDER_START);
        if (start == null) {
            start = Instant.now();
            session.setAttribute(SESSION_ORDER_START, start);
        }

        long minutesElapsed = Duration.between(start, Instant.now()).toMinutes();
        long stage = minutesElapsed / UPDATE_INTERVAL_MINUTES; // 0,1,2,...

        OrderStatus status;
        int stepIndex;

        if (stage <= 0) {
            status = OrderStatus.ORDER_PLACED;
            stepIndex = 1;
        } else if (stage == 1) {
            status = OrderStatus.EN_ROUTE;
            stepIndex = 2;
        } else {
            status = OrderStatus.ARRIVED;
            stepIndex = 3;
        }

        return new OrderStatusResponse(status.name(), stepIndex);
    }
}
