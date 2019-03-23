package Logic.Buildingsplan;

import java.util.ArrayList;

public class Side {

    private int numberOf1x2;
    private int numberOf2x2;
    private int numberOf4x2;

    public Side(int numberOf4x2, int numberOf2x2, int numberOf1x2) {
        this.numberOf4x2 = numberOf4x2;
        this.numberOf2x2 = numberOf2x2;
        this.numberOf1x2 = numberOf1x2;
    }

    public int getNumberOf1x2() {
        return numberOf1x2;
    }

    public int getNumberOf2x2() {
        return numberOf2x2;
    }

    public int getNumberOf4x2() {
        return numberOf4x2;
    }

    @Override
    public String toString() {
        return "Side{" + "numberOf1x2=" + numberOf1x2 + ", numberOf2x2=" + numberOf2x2 + ", numberOf4x2=" + numberOf4x2 + '}';
    }

};
