import java.util.ArrayList;
import java.util.List;

public class Perceptron {
    int countpentla=0;
    double wantedAccuracy;
    double parameter=0.1;
    double theta=0;
    double accuracy;

    ArrayList<Double> vektorW= new ArrayList<>();
    Data traingData = new Data("iristrain.csv");

    public Perceptron(){

        for(int i=0;i<traingData.attributesSize;i++)
            vektorW.add(1.0);

    }

    public int getOutput(ArrayList<Double> toSum){
        double sum=0;
            for(int i=0; i<toSum.size();i++)
                sum+=toSum.get(i)*vektorW.get(i);
       // System.out.println("suma: "+sum);
        if(sum-theta>0)
            return 1;
        return 0;
    }

    public void correctVektor(Flower flower){
        double multiplier= parameter * ( flower.decisionalAtributte- getOutput(flower.attributes));
        ArrayList<Double> tmpFlowerAtributes= flower.attributes;

        for(int i=0; i<tmpFlowerAtributes.size();i++){
            tmpFlowerAtributes.set(i, tmpFlowerAtributes.get(i)*multiplier);
        }


            for(int i=0; i<vektorW.size();i++){
                vektorW.set(i,vektorW.get(i)+tmpFlowerAtributes.get(i));
            }
    }

    public void learn( double wantedAccuracy){
        accuracy=0;
        int generaction=0;

        while(accuracy<wantedAccuracy){
            int tmpAccuracy=0;
            for(Flower inputFlower: traingData.flowerList){

                if(inputFlower.decisionalAtributte == getOutput(inputFlower.attributes)){
                    tmpAccuracy++;
                 //   System.out.println("dodaje tmp");
                }
                else {
                  //  System.out.println("zmienia thete i zmienia wektor");
                    theta -= parameter * (inputFlower.decisionalAtributte - getOutput((inputFlower.attributes)));
                    correctVektor(inputFlower);
                }

            }
            generaction++;
            accuracy = (double)tmpAccuracy/traingData.flowerList.size()*100;
            System.out.println(vektorW);
           // System.out.println(tmpAccuracy+ "   " +traingData.flowerList.size());
        //   System.out.println("generacja: "+generaction+" z dokladnoscia: "+ accuracy);
        }

    }





}
