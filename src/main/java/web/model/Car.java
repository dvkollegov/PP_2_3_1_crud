package web.model;

public class Car {
    private String name;
    private String model;
    private double cost;

    public Car(String name, String model, double cost) {
        this.name = name;
        this.model = model;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
