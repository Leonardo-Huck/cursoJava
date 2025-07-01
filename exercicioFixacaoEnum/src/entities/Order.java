package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime date;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(LocalDateTime date, OrderStatus status, Client client) {
        this.date = date;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeItem(OrderItem item) {
        this.items.remove(item);
    }

    public double total() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.subTotal();
        }
        return total;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMARY:\n");
        sb.append("Order moment: ");
        sb.append(getDate().format(formatter));
        sb.append("\nOrder status: ");
        sb.append(getStatus());
        sb.append("\nClient: ");
        sb.append(getClient());
        sb.append("\nOrder items:\n");
        for (OrderItem item : items) {
            sb.append(item.getProduct());
            sb.append(", Quantity: ");
            sb.append(item.getQuantity());
            sb.append(", Subtotal: $");
            sb.append(String.format("%.2f", item.subTotal()));
            sb.append("\n");
        }
        sb.append("Order total: R$ ");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }
}
