public class Perceptron {
    double wantedAccuracy;



/*

    public void learn(Flower flower, double wantedAccuracy){
        double accuracy = 0.0;
        int generation = 0;
        while(accuracy < wantedAccuracy) {
            int accurateCounter = 0;
            for (Vector inputVector : inputVectors) {
                int outputSignal = getOutputSignal(inputVector);
                if(inputVector.getDecisionalAtributte() == outputSignal)
                    accurateCounter++;
                theta -= learningConstant * (inputVector.getDecisionalAtributte() - outputSignal);
                weightVector.sumWithVector(inputVector.multiplyVector(learningConstant * (inputVector.getDecisionalAtributte() - outputSignal)));
            }
            generation++;
            accuracy = (double)accurateCounter/inputVectors.size();
            System.out.println("Accuracy in " + generation +" generation: "+accuracy);
        }
    }
    */

}
