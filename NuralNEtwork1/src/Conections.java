import java.util.Random;

public class Conections {

    private static  final Random random = new Random();
    private double w;
    private final Nurone from;
    private final Nurone to;

    public Conections(Nurone from, Nurone to) {
        this.from = from;
        this.from.addOutGoingConnections(this);
        this.to = to;
        this.to.addIncomingConnections(this);
        this.w = random.nextDouble();

    }


    public static void connect(Nurone from,Nurone to){
        new Conections(from, to);
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public Nurone getFrom() {
        return from;
    }

    public Nurone getTo() {
        return to;
    }
}
