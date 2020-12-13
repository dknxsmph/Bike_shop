
public class Bicycle {

    private int id_bi;
    private Type_bike type;
    private double cost;
    public static int id;

    public Bicycle(Type_bike type, double cost) {
        this.type = type;
        this.cost = cost;
        id++;
        this.id_bi = id;
    }

    public int getId_bi() {
        return id_bi;
    }

    public Type_bike getType() {
        return type;
    }

    public double getPrice() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ID=" + getId_bi() + ", type=" + getType() + ", price=" + getPrice() + " Bath";
    }
}
