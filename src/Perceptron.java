import java.util.ArrayList;

public class Perceptron {
    int countpentla=0;
    double wantedAccuracy;
    double parameter=0.1;
    double theta=0;
    double accuracy;

   private ArrayList<Double> vektorW= new ArrayList<>();
   private Data traingData = new Data("iristrain.csv");

    public Perceptron(){

        for(int i=0;i<traingData.attributesSize;i++)
            vektorW.add(1.0);

    }

    public int getOutput(ArrayList<Double> toSum){
        double sum=0;
            for(int i=0; i<toSum.size();i++)
                sum+=toSum.get(i)*vektorW.get(i);
        if(sum-theta>0)
            return 1;
        return 0;
    }

    private void correctVektor(Vector vector){
        double multiplier= parameter * ( vector.decisionalAtributte- getOutput(vector.attributes));
        ArrayList<Double> tmpFlowerAttributes= vector.attributes;

        for(int i=0; i<tmpFlowerAttributes.size();i++)
            tmpFlowerAttributes.set(i, tmpFlowerAttributes.get(i)*multiplier);

        for(int i=0; i<vektorW.size();i++)
            vektorW.set(i,vektorW.get(i)+tmpFlowerAttributes.get(i));

    }

    public void learn(){
        accuracy=0;
        int generaction=0;

        while(accuracy<=100){
            int tmpAccuracy=0;
            for(Vector inputVector : traingData.vectorList){

                if(inputVector.decisionalAtributte == getOutput(inputVector.attributes)){
                    tmpAccuracy++;
                }
                else {
                    theta -= parameter * (inputVector.decisionalAtributte - getOutput((inputVector.attributes)));
                    correctVektor(inputVector);
                }

            }
            generaction++;
            accuracy = (double)tmpAccuracy/traingData.vectorList.size()*100;


        }

    }





}
