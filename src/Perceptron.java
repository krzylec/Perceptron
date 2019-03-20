import java.util.ArrayList;

public class Perceptron {
    double wantedAccuracy;

    ArrayList<Double> vektorW= new ArrayList<>();
    Data traingData = new Data("iristrain.csv", "setosa", "versicolor");

    public Perceptron(){
        for(int i=0;i<traingData.attributesSize;i++)
            vektorW.add(1.0);
    }

    public boolean getOutput(Flower flower){
        double sum=0;
            for(int i=0; i<flower.attributes.size();i++)
                sum+=flower.attributes.get(i)*vektorW.get(i);
        if(sum>0)
            return true;
        return false;
    }

    public ArrayList<Double> correctVektor(ArrayList<Double> toCorrect){
return null;
    }

    public void learn(){
        boolean fine=true;
        while(fine){

            for(Flower flower: traingData.flowerList){
                //if(!getOutput(flower))

            }

        }
    }


}
