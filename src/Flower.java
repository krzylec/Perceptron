import java.util.ArrayList;

public class Flower {
    ArrayList<Double> attributes;
    String flowerName;

    public Flower(ArrayList<Double> attributes, String flowerName) {
        this.attributes = attributes;
        this.flowerName = flowerName;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "attributes=" + attributes +
                ", flowerName='" + flowerName + '\'' +
                '}';
    }
}
