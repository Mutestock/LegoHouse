package Logic.Buildingsplan;

import java.util.ArrayList;

public class Layer {

    private int layernr;
    private ArrayList<Side> sides;

    public Layer(int layernr, ArrayList<Side> sides) {
        this.layernr = layernr;
        this.sides = sides;
    }

    public int getLayernr() {
        return layernr;
    }

    public ArrayList<Side> getSides() {
        return sides;
    }

    @Override
    public String toString() {
        return "Layer{" + "layernr=" + layernr + ", sides=" + sides + '}';
    }

 
}
