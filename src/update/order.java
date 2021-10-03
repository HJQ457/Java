package update;

import java.util.Date;

public class order {
    private int orderId;
    private String orderName;
    private Date orderDate;

    public order() {
    }

    public order(int orderId, String orderName, Date orderDate) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
