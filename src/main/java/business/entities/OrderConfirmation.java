package business.entities;


public class OrderConfirmation {
    private int date;
    private int price;
    private String address;
    private int width;
    private int length;
    private String roof_type;
    private int order_id;


    public OrderConfirmation(int order_id, int date, int price, int length, int width, String roof_type) {
        this.order_id = order_id;
        this.date = date;
        this.price = price;
        this.length = length;
        this.width = width;
        this.roof_type = roof_type;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoof_type() {
        return roof_type;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }

    public int getOrderid() {
        return order_id;
    }

    public void setOrderid(int order_id) {
        this.order_id = order_id;
    }
}
