package business.entities;

public class SeeProducts {
    private int id;
    private int length;
    private int price_per_unit;
    private String name;
    private String unit;

    public SeeProducts(int id, int length, int price_per_unit, String name, String unit) {
        this.id = id;
        this.length = length;
        this.price_per_unit = price_per_unit;
        this.name = name;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(int price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
