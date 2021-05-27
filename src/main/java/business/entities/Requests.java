package business.entities;

public class Requests {
    private int order_id;
    private int date;
    private int customer_id;
    private int length;
    private int width;
    private String roof_type;

    public Requests(int order_id, int date, int customer_id, int length, int width, String roof_type) {
        this.order_id = order_id;
        this.date = date;
        this.customer_id = customer_id;
        this.length = length;
        this.width = width;
        this.roof_type = roof_type;
    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getRoof_type() {
        return roof_type;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }
}
