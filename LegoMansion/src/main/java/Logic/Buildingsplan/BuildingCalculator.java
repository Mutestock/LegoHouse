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

//        HashMap<Integer, Integer> capitalCities = new HashMap<Integer, Integer>();
//        int[][][][][] arr = null;
//        height, width, length represent input values from ordercreate.jsp
//        Parameters are found with request.getParameter("height"); etc
//        sizeLimitationCheck(height, length, width);
        ArrayList<Layer> layerList = new ArrayList<>();
        System.out.println("GONE THROUGH HEIGHT / LAYER WIDTH CONDITIONS");
        ArrayList<Layer> layers = new ArrayList<>();
        //Doesn't do anything but establish connection to enums.
//        Layer layer = new Layer(length, building);
        {
            System.out.println("ENTERED NESTED LOOPS");
            System.out.println("*********************");

            for (int i = 1; i < (height + 1); i++) {

                System.out.println("NEW LAYER");

                ArrayList<Side> sides = new ArrayList<>();

//                 int frontBackLength = length - (layerNumber % 2 == 0 ? 0 : 4);
//            int sideLength = width - (layerNumber % 2 == 1 ? 0 : 4); 
                layers.add(new Layer(i, sides));

                for (int j = 0; j < 4; j++) {
                    System.out.println("NEW SIDE");

                    String enumStrings = SideEnums.sidesEnum.values()[j].toString();
                    int sideAccumulator = 0;
                    int storeMod = 0;
                    double temp = 0;

                    System.out.println("FOUND ENUMS FROM SIDEENUMS");

                    sideAccumulator = checkEnums(enumStrings, sideAccumulator, length, i, width);

                    getSideNrByEnum(enumStrings);

                    System.out.println("CHECKED ENUM VALUES");
                    System.out.println(enumStrings);
                    System.out.println("ENTERED WITH: " + height + ", " + width + ", " + length);

                    int largeBrickCount = 0;
                    int mediumBrickCount = 0;
                    int smallBrickCount = 0;

                    largeBrickCount = sideAccumulator / 4;
                    int remaining = sideAccumulator % 4;
                    mediumBrickCount = remaining / 2;
                    remaining = remaining % 2;
                    smallBrickCount = remaining;

//                    storeMod = sideAccumulator % 4;
//                    temp = sideAccumulator / 2;
//                    sideAccumulator = (int) Math.floor(temp);
//                    largeBrickCount = sideAccumulator;
//                    sideAccumulator = storeMod;
//
//                    storeMod = sideAccumulator % 2;
//                    temp = sideAccumulator / 2;
//                    sideAccumulator = (int) Math.floor(temp);
//                    mediumBrickCount = sideAccumulator;
//                    sideAccumulator = storeMod;
//
//                    storeMod = sideAccumulator % 1;
//                    temp = sideAccumulator / 1;
//                    sideAccumulator = (int) Math.floor(temp);
//                    smallBrickCount = sideAccumulator;

                    sides.add(new Side(largeBrickCount, mediumBrickCount, smallBrickCount));

//                    int[][][][][] innerArr = new int[i][j][smallBrickCount][mediumBrickCount][largeBrickCount];
//                    arr = innerArr;
                    System.out.println("ASSIGNED ALL BRICK SIZES");

                    //Return and use brickcounts in some way.
                    if (storeMod != 0) {
                        throw new Error();
                    }
                    System.out.println("**************");
                    System.out.println("LAYER: " + i);
                    System.out.println("SIDE: " + j);
                    System.out.println(largeBrickCount);
                    System.out.println(mediumBrickCount);
                    System.out.println(smallBrickCount);
                    System.out.println("**************");
                }
            }
            System.out.println("EXITED NESTED LOOPS");
        }
//        System.out.println(Arrays.deepToString(arr));

        System.out.println(
                "\n" + "SUCCESS.......");

        Building building = new Building(height, width, length, layers);

        System.out.println(
                "BUILDING CONTAINS: " + building);
        System.out.println(
                "LAYERS CONTAINS: " + building.getLayers());
        System.out.println(
                "SIDE CONTAINS: " + building.getLayers().get(5).getSides());

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
        }
        
        
        System.out.println("||||||||||CHECKENUM ACCUM||||||||||||");
        System.out.println(sideAccumulator);
        System.out.println("||||||||||||||||||||||");
        
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

    public static void main(String[] args) {

        Building building = null;
//        building = createBulding(7, 13, 21);
        System.out.println(building);
        
        System.out.println("Seriously though --------------------------------------");
       
        ArrayList<Layer> layers =  building.getLayers();
        for(Layer y : layers)
        {
            System.out.println( y.getSides());
           
        }
        

        System.out.println("###################");
        System.out.println("1x2 total: " + getBrickType1x2Total(building));
        System.out.println("2x2 total: " + getBrickType2x2Total(building));
        System.out.println("4x2 total: " + getBrickType4x2Total(building));
        System.out.println("###################");

        int right = getSideNrByEnum("RIGHT");
        int front = getSideNrByEnum("FRONT");
        int back = getSideNrByEnum("BACK");
        int left = getSideNrByEnum("LEFT");

        System.out.println("****1x2****");
        System.out.println("RIGHT SIDE: " + getBrickCount1x2BySide(building, right));
        System.out.println("FRONT SIDE: " + getBrickCount1x2BySide(building, front));
        System.out.println("BACK SIDE: " + getBrickCount1x2BySide(building, back));
        System.out.println("LEFT SIDE: " + getBrickCount1x2BySide(building, left));

        System.out.println("******2x2******");
        System.out.println("RIGHT SIDE: " + getBrickCount2x2BySide(building, right));
        System.out.println("FRONT SIDE: " + getBrickCount2x2BySide(building, front));
        System.out.println("BACK SIDE: " + getBrickCount2x2BySide(building, back));
        System.out.println("LEFT SIDE: " + getBrickCount2x2BySide(building, left));

        System.out.println("******4x2");
        System.out.println("Second RIGHT: " + getBrickCount4x2BySide(building, right));
        System.out.println("Second FRONT: " + getBrickCount4x2BySide(building, front));
        System.out.println("Second BACK : " + getBrickCount4x2BySide(building, back));
        System.out.println("Second LEFT : " + getBrickCount4x2BySide(building, left));

        System.out.println("1x2 line 0: " + getBrickCount1x2BySideLine0(building, front));
        System.out.println("2x2 line 0: " + getBrickCount2x2BySideLine0(building, left));
        System.out.println("4x2 line 0: " + getBrickCount4x2BySideLine0(building, left));

        DatamapperImplementation dmi = new DatamapperImplementation();
        try {
            ArrayList<Order> orders = dmi.getAllOrders();
            for (Order o : orders)
            {
                String date = o.getDate();
                System.out.println(date);
            }
            
            
        ArrayList<Order> orderList = dmi.getAllOrders();
        Order order = orderList.get(0);
            System.out.println(order.getDate());
            
            System.out.println(orderList);

            
            
            
        } catch (DataException ex) {
            Logger.getLogger(BuildingCalculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuildingCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
