
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="car")
public class car {
    private int id;
    private String brand;
    private String model;
    private double price;
    private int wheels;

    public car() {
        super();
    }

    public car(int id, String brand, String model, double price, int wheels) {
        super();
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.wheels = wheels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

   
}
