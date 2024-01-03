import java.util.ArrayList;
import java.util.List;

public class Nurone {
    private final String name;
    private double bias;
    private double outputValue;

    private List<Conections> incommingConections = new ArrayList<>();
    private List<Conections> outgoingConections = new ArrayList<>();
    public Nurone(String name,double bias) {
        this.name = name;
        this.bias = bias;
    }

    public void calculateOutputValue(){
        double total = bias;
        for(Conections conections : incommingConections){
            total = total + conections.getW() * conections.getFrom().getOutputValue();
        }
    }
    private double activate(double value){
        return 1.0 / (1.0 + Math.exp(-value));
    }
    public String getName() {
        return name;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }
    public void addIncomingConnections(Conections conections){
        incommingConections.add(conections);
    }
    public void addOutGoingConnections(Conections conections){
        outgoingConections.add(conections);
    }
    @Override
    public String toString(){
        String incomingConnetionWeight = "[";
        for(Conections conections : incommingConections) incomingConnetionWeight += conections.getW() + "";
        incomingConnetionWeight += "]";

        return "Nuron{" +
                "name" +  name +'\'' +
                ", bias = " + bias +
                ", outputValue = " + outputValue +
                ", incomingConnections = " + incommingConections + " } " ;
    }
}
