package Logic.Buildingsplan;

import Data.Exceptions.UnderMinimumValuesException;
import Data.Exceptions.ValidationCollection;
import java.util.ArrayList;

public class Building {

    private int height;
    private int width;
    private int length;
    private ArrayList<Layer> layers;

    public Building(int height, int width, int length, ArrayList<Layer> layers) {

        try {
            ValidationCollection vc = new ValidationCollection();
            vc.validateSizes(height, width, length);
            this.height = height;
            this.width = width;
            this.length = length;
            this.layers = layers;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<Layer> getLayers() {
        return layers;
    }

    @Override
    public String toString() {
        return "Building{" + "height=" + height + ", width=" + width + ", length=" + length + ", layers=" + layers + '}';
    }

}
