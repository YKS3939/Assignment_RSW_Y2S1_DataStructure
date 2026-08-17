package tarc.assignment.entity;

import java.math.BigDecimal;
import java.time.Instant;

public record CheckOut(
        String id,
        String roomNum,
        String customerId,
        BigDecimal penalty,
        BigDecimal mealFee,
        BigDecimal roomFee,
        BigDecimal total,
        int days,
        Instant checkOutTime
) {
}
