import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        NuralNetwork nuralNetwork = new NuralNetwork(2,2,2);
        nuralNetwork.printNuralNetwork();
        List<Double> resultValue1 = new ArrayList<>();
        resultValue1.add(0.6);
        resultValue1.add(0.1);
        List<Double> resultValue = nuralNetwork.calculateOutptuts(resultValue1);
        System.out.println("results: ");
        for (Double d: resultValue) System.out.println(d);
    }
}