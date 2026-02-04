package models;

public class OrderStatusResponseDTO {

    private String status;   // "ORDER_PLACED", etc
    private int stepIndex;   // 1..3

    public OrderStatusResponseDTO(String status, int stepIndex) {
        this.status = status;
        this.stepIndex = stepIndex;
    }

    public String getStatus() {
        return status;
    }

    public int getStepIndex() {
        return stepIndex;
    }
}
