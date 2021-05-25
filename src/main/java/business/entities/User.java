package business.entities;

public class User
{
    public User(String email, String password, String role)
    {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private String name;
    private String phone;
    private String address;
    private String postcode;
    private int credit;
    private int date;
    private int length;
    private int width;
    private int price;
    private String roof_type;
    private int orderId;

    public User(int id, String email, String password, String role, String name, String phone, String address, String postcode) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
    }

    public User(int id, String email, String address, String name, String phone, int credit) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.credit = credit;
    }


    public User(int date, int length, int width, int price, String roof_type) {
        this.date = date;
        this.length = length;
        this.width = width;
        this.price = price;
        this.roof_type = roof_type;
    }

    public User(int orderid, int date, int length, int width, int price, String roof_type) {
        this.orderId = orderid;
        this.date = date;
        this.length = length;
        this.width = width;
        this.price = price;
        this.roof_type = roof_type;
    }

    @Override
    public String toString() {
      return "id" + id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRoof_type() {
        return roof_type;
    }

    public void setRoof_type(String roof_type) {
        this.roof_type = roof_type;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
