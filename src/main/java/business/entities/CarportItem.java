package business.entities;

public class CarportItem {
    private int order_id;
    private int item_id;
    private int length;
    private int quantity;
    private int price;
    private String description;
    private int width;

    public CarportItem(int order_id, int item_id, int length, int width, int quantity, int price, String description) {
        this.order_id = order_id;
        this.item_id = item_id;
        this.length = length;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.width = width;
        this.item_id = item_id;
    }

    public CarportItem(int order_id, int length, int width, int quantity, int price, String description) {
        this.order_id = order_id;
        this.length = length;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.width = width;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
