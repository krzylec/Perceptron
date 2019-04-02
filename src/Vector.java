import java.util.ArrayList;

public class Vector {
    ArrayList<Double> attributes;
    int decisionalAtributte;

    public Vector(ArrayList<Double> attributes, int decisionalAtributte) {
        this.attributes = attributes;
        this.decisionalAtributte = decisionalAtributte;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "attributes=" + attributes +
                ", decisionalAtributte='" + decisionalAtributte + '\'' +
                '}';
    }
}
