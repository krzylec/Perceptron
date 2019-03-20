import java.util.ArrayList;

public class Flower {
    ArrayList<Double> attributes;
    int decisionalAtributte;

    public Flower(ArrayList<Double> attributes, int decisionalAtributte) {
        this.attributes = attributes;
        this.decisionalAtributte = decisionalAtributte;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "attributes=" + attributes +
                ", decisionalAtributte='" + decisionalAtributte + '\'' +
                '}';
    }
}
