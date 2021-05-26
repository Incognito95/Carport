package business.entities;

public class Material {
    private int id;
    private int rem;
    private int meter;

    public Material(int id, int rem, int meter) {
        this.id = id;
        this.rem = rem;
        this.meter = meter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRem() {
        return rem;
    }

    public void setRem(int rem) {
        this.rem = rem;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }
}
