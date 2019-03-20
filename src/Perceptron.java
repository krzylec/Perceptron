import java.util.ArrayList;

public class Perceptron {
    int countpentla=0;
    double wantedAccuracy;
    double parameter=0.1;

    ArrayList<Double> vektorW= new ArrayList<>();
    Data traingData = new Data("iristrain.csv", "setosa", "versicolor");

    public Perceptron(){
        for(int i=0;i<traingData.attributesSize;i++)
            vektorW.add(1.0);
    }

    public int getOutput(ArrayList<Double> toSum){
        double sum=0;
            for(int i=0; i<toSum.size();i++)
                sum+=toSum.get(i)*vektorW.get(i);
        if(sum>0)
            return 1;
        return 0;
    }

    public void correctVektor(Flower flower){
        countpentla++;
        System.out.println("pentla: "+ countpentla);
            int tmp= flower.decisionalAtributte-getOutput(flower.attributes);
        System.out.println("roznica wynosi:"+ tmp);
            ArrayList<Double> tmpAttributes= new ArrayList<>();
            for(int i=0; i<flower.attributes.size();i++){
               tmpAttributes.add(flower.attributes.get(i)*parameter*tmp);

            }
        System.out.println("atrybuty przed mnozeniem");
        tmpAttributes.stream().forEach(x -> System.out.print(x+ " "));
        System.out.println();
            for(int i=0; i<vektorW.size();i++){
                vektorW.set(i, vektorW.get(i)+tmpAttributes.get(i));
            }

            vektorW.stream().forEach(x -> System.out.print(x+ " "));
        System.out.println();

    }

    public void learn(){
        boolean fine=true;
        double accuracy=0;
        int accuracyCount=0;
        while(accuracy<90){
            accuracy=0;
            for(Flower flower: traingData.flowerList){
                if(flower.decisionalAtributte==getOutput(flower.attributes)){
                    accuracyCount++;
                }
                correctVektor(flower);

            }

            accuracy=(double)accuracyCount/(double)traingData.flowerList.size()*100;
            System.out.println("accuracy: "+ accuracy);
        }
    }


}
