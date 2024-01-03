import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NuralNetwork {
    private static final Random random = new Random();
    private final List<Nurone> inputLayer = new ArrayList<>();
    private final List<Nurone> hiddenLayer = new ArrayList<>();
    private final List<Nurone> outputLayer = new ArrayList<>();

    public NuralNetwork(int inputCount, int hiddenCount, int outputCount) {
        for(int i = 1; i <= inputCount ; i ++){
            inputLayer.add(new Nurone("input" + i , 0));
        }
        for (int i = 1 ; i<= hiddenCount ; i++){
            Nurone hidden = new Nurone("hidden" + i , random.nextDouble() - 0.5);
            for(Nurone input : inputLayer){
                Conections.connect(input, hidden);
            }
            hiddenLayer.add(hidden);
        }

        for(int i = 1; i <= outputCount; i++){
            Nurone output = new Nurone("output" + i , random.nextDouble() - 0.5);
            for(Nurone hidden : hiddenLayer){
                Conections.connect(hidden, output);
            }
            outputLayer.add(output);
        }
    }

    public List<Double> calculateOutptuts(List<Double> inputValues) {
        for(int i = 0; i < inputValues.size();i++){
            inputLayer.get(i).setOutputValue(inputValues.get(i));
        }
        for(Nurone hiddemNuroe: hiddenLayer){
            hiddemNuroe.calculateOutputValue();
        }
        List<Double> resultValues = new ArrayList<>();
        for(Nurone outputNuron : outputLayer){
            outputNuron.calculateOutputValue();
            resultValues.add(outputNuron.getOutputValue());
        }
        return  resultValues;
    }
    public void printNuralNetwork(){
        System.out.println("Hidden layer: ");
        for(Nurone hiddenNeuron : hiddenLayer){
            System.out.println(hiddenNeuron);
        }
        System.out.println();

        System.out.println("output layer");
        for(Nurone outputNeurone : outputLayer){
            System.out.println(outputNeurone);
        }
        System.out.println();
    }
}
