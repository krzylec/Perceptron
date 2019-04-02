import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public List<String> arrayData;
    public ArrayList<Vector> vectorList = new ArrayList<>();
    public int attributesSize;
    String kind1="setosa";
    String kind2="versicolor";

    public Data(String fileName){
        try {
            arrayData= Files.readAllLines((Paths.get(fileName)));
            attributesSize=arrayData.get(0).split(",").length-2;
            arrayData.stream().forEach(x -> {

                String[] tmpSplit= x.split(",");


                if(tmpSplit[tmpSplit.length-1].equals("\""+kind1+"\"") || tmpSplit[tmpSplit.length-1].equals("\""+kind2+"\"")){
                    ArrayList<Double> tmpDoubleList = new ArrayList<>();
                    for(int i=1; i<tmpSplit.length-1;i++)
                        tmpDoubleList.add(Double.parseDouble(tmpSplit[i]));

                    if(tmpSplit[tmpSplit.length-1].equals("\""+kind1+"\""))
                    vectorList.add(
                            new Vector( tmpDoubleList,0 )
                    );
                    else
                        vectorList.add(
                                new Vector( tmpDoubleList,1 )
                        );
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
