package Logic.Buildingsplan;

import Data.DatamapperImplementation;
import Data.Exceptions.DataException;
import Logic.HelperClasses.OrderHelper.Order;
import Logic.HelperClasses.UserHelpers.User;
import java.lang.Exception;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuildingCalculator {

    public Building createBulding(int height, int width, int length) {
        System.out.println("STARTED CREATEBUILDING.....");

        ArrayList<Layer> layerList = new ArrayList<>();
        System.out.println("GONE THROUGH HEIGHT / LAYER WIDTH CONDITIONS");
        ArrayList<Layer> layers = new ArrayList<>();
        {

            for (int i = 1; i < (height + 1); i++) {

                ArrayList<Side> sides = new ArrayList<>();

                layers.add(new Layer(i, sides));

                for (int j = 0; j < 4; j++) {

                    String enumStrings = SideEnums.sidesEnum.values()[j].toString();
                    int sideAccumulator = 0;
                    int storeMod = 0;
                    double temp = 0;

                    sideAccumulator = checkEnums(enumStrings, sideAccumulator, length, i, width);

                    getSideNrByEnum(enumStrings);

                    int largeBrickCount = 0;
                    int mediumBrickCount = 0;
                    int smallBrickCount = 0;

                    largeBrickCount = sideAccumulator / 4;
                    int remaining = sideAccumulator % 4;
                    mediumBrickCount = remaining / 2;
                    remaining = remaining % 2;
                    smallBrickCount = remaining;


                    sides.add(new Side(largeBrickCount, mediumBrickCount, smallBrickCount));

                    if (storeMod != 0) {
                        throw new Error();
                    }
                }
            }
        }

        Building building = new Building(height, width, length, layers);
        return building;
    }

    public static int getSideNrByEnum(String enumStrings) {
        int acc = 0;
        if (enumStrings.equals("FRONT")) {
            acc = 0;
        } else if (enumStrings.equals("BACK")) {
            acc = 1;
        } else if (enumStrings.equals("LEFT")) {
            acc = 2;
        } else if (enumStrings.equals("RIGHT")) {
            acc = 3;
        } else {
            System.out.println("Struck error in getSideNrByEnum");
        }
        return acc;
    }

    private static int checkEnums(String enumStrings, int sideAccumulator, int length, int i, int width) {
        if (enumStrings.equals("FRONT") || enumStrings.equals("BACK")) {
            sideAccumulator = length;
            if (i % 2 == 0) {
                sideAccumulator = sideAccumulator - 4;
            }
        } else if (enumStrings.equals("RIGHT") || enumStrings.equals("LEFT")) {
            if (i < 5) {
                //represents door and window sides.sideAccumulator = length;
                sideAccumulator = width - 4;
            } else {
                sideAccumulator = width;
            }
            if (i % 2 == 1) {
                sideAccumulator = sideAccumulator - 4;
            }
        } else {
            System.out.println("SOMETHING WENT WRONG WITH ENUMS");
            throw new Error();
        }
        
        return sideAccumulator;
    }

    public static int getBrickType4x2Total(Building building) {
        ArrayList<Layer> layers = building.getLayers();
        ArrayList<Side> sides = null;
        int countUp = 0;
        for (Layer y : layers) {
            sides = y.getSides();
            for (Side s : sides) {
                countUp = countUp + s.getNumberOf4x2();
            }
        }
        return countUp;
    }

    public static int getBrickType2x2Total(Building building) {
        ArrayList<Layer> layers = building.getLayers();
        ArrayList<Side> sides = null;
        int countUp = 0;

        for (Layer y : layers) {
            sides = y.getSides();
            for (Side s : sides) {
                countUp = countUp + s.getNumberOf2x2();
            }
        }
        return countUp;
    }

    public static int getBrickType1x2Total(Building building) {
        ArrayList<Layer> layers = building.getLayers();
        ArrayList<Side> sides = null;
        int countUp = 0;

        for (Layer y : layers) {
            sides = y.getSides();
            for (Side s : sides) {
                countUp = countUp + s.getNumberOf1x2();
            }
        }
        return countUp;
    }

    public static int getBrickCount1x2BySide(Building building, int sideCount) {
        ArrayList<Layer> layers = building.getLayers();
        ArrayList<Side> sides = null;
        int countUp = 0;
        for (Layer y : layers) {
            sides = y.getSides();
            countUp = countUp + sides.get(sideCount).getNumberOf1x2();
        }
        return countUp;
    }

    public static int getBrickCount2x2BySide(Building building, int sideCount) {
        ArrayList<Layer> layers = building.getLayers();
        ArrayList<Side> sides = null;
        int countUp = 0;
        for (Layer y : layers) {
            sides = y.getSides();
            countUp = countUp + sides.get(sideCount).getNumberOf2x2();
        }
        return countUp;
    }

    public static int getBrickCount4x2BySide(Building building, int sideCount) {
        ArrayList<Layer> layers = building.getLayers();
        ArrayList<Side> sides = null;
        int countUp = 0;
        for (Layer y : layers) {
            sides = y.getSides();
            countUp = countUp + sides.get(sideCount).getNumberOf4x2();
        }
        return countUp;
    }

    public static int getBrickCount1x2BySideLine0(Building building, int sideCount) {
        ArrayList<Layer> layers = building.getLayers();
        Layer line0 = layers.get(0);
        ArrayList<Side> sides = line0.getSides();
        int countUp = sides.get(sideCount).getNumberOf1x2();
        return countUp;
    }

    public static int getBrickCount2x2BySideLine0(Building building, int sideCount) {
        ArrayList<Layer> layers = building.getLayers();
        Layer line0 = layers.get(0);
        ArrayList<Side> sides = line0.getSides();
        int countUp = sides.get(sideCount).getNumberOf2x2();
        return countUp;
    }

    public static int getBrickCount4x2BySideLine0(Building building, int sideCount) {
        ArrayList<Layer> layers = building.getLayers();
        Layer line0 = layers.get(0);
        ArrayList<Side> sides = line0.getSides();
        int countUp = sides.get(sideCount).getNumberOf4x2();
        return countUp;
    }

  

}
