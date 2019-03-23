package Logic.Buildingsplan;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BuildingCalculator {

    public static Building createBulding(int height, int width, int length) {
        System.out.println("STARTED CREATEBUILDING.....");

//        HashMap<Integer, Integer> capitalCities = new HashMap<Integer, Integer>();
//        int[][][][][] arr = null;
//        height, width, length represent input values from ordercreate.jsp
//        Parameters are found with request.getParameter("height"); etc
        sizeLimitationCheck(height, length, width);
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

                layers.add(new Layer(i, sides));

                for (int j = 0; j < 4; j++) {
                    System.out.println("NEW SIDE");

                    String enumStrings = SideEnums.sidesEnum.values()[j].toString();
                    int sideAccumulator = 0;
                    int storeMod = 0;
                    double temp = 0;

                    System.out.println("FOUND ENUMS FROM SIDEENUMS");

                    sideAccumulator = checkEnums(enumStrings, sideAccumulator, length, i, width);

                    System.out.println("CHECKED ENUM VALUES");
                    System.out.println(enumStrings);
                    System.out.println("ENTERED WITH: " + height + ", " + width + ", " + length);

                    int largeBrickCount = 0;
                    int mediumBrickCount = 0;
                    int smallBrickCount = 0;

                    storeMod = sideAccumulator % 4;
                    temp = sideAccumulator / 2;
                    sideAccumulator = (int) Math.floor(temp);
                    largeBrickCount = sideAccumulator;
                    sideAccumulator = storeMod;

                    storeMod = sideAccumulator % 2;
                    temp = sideAccumulator / 2;
                    sideAccumulator = (int) Math.floor(temp);
                    mediumBrickCount = sideAccumulator;
                    sideAccumulator = storeMod;

                    storeMod = sideAccumulator % 1;
                    temp = sideAccumulator / 1;
                    sideAccumulator = (int) Math.floor(temp);
                    smallBrickCount = sideAccumulator;

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
        System.out.println("\n" + "SUCCESS.......");

        Building building = new Building(height, width, length, layers);

        System.out.println("BUILDING CONTAINS: " + building);
        System.out.println("LAYERS CONTAINS: " + building.getLayers());
        System.out.println("SIDE CONTAINS: " + building.getLayers().get(5).getSides());

        return building;
    }

    private static int checkEnums(String enumStrings, int sideAccumulator, int length, int i, int width) {
        if (enumStrings.equals("FRONT") || enumStrings.equals("BACK")) {
            //sideAccumulator is now 11
            sideAccumulator = length;

        } else if (enumStrings.equals("RIGHT") || enumStrings.equals("LEFT")) {
            if (i < 5) {
                //represents door and window sides.sideAccumulator = length;
                System.out.println("THIS IS A WINDOW/DOOR");
                sideAccumulator = width - 4;
                //sideAccumulator is now 13-4 = 9
            } else {
                sideAccumulator = width;
            }
        } else {
            System.out.println("SOMETHING WENT WRONG WITH ENUMS");
        }
        return sideAccumulator;
    }

    private static void sizeLimitationCheck(int height, int length, int width) throws Error {
        if (height < 5 || length < 5 || width < 5) {
            System.out.println("Height / length / width below 5. This is a placeholder exception");
            throw new Error();
        }
    }

    public static void main(String[] args) {

        Building building = null;
        building = createBulding(12, 9, 7);
        System.out.println(building);
    }
}

/*
        Building(15,13,11)
        {
        
            building height, width, length are read from orderinput.
            written like so:
                request.getParameter("height"); ..etc
        
            if(height<5 || length<5 || width<5)
                {
                    belowMinSizeError;
                }
            else {
        }
        Layer(Building)
            Enum currentSide{front,back, left, right}
        {
         for (int i = 0; i < Building.getHeight; i++) {
            for (int j = 0; j < 4; j++ {
                Side();
                currentSide -> one spot right;
            }
        }
        
        }
        Side(Layer, Enum)
        {
            int sideAccumulator = 0;
                if(Layer.currentSide == front || Layer.currentSide == back)
                    {
                        sideAccumulator = Building.getLength()-4;  (11-4 = 7);
                    }
                else if(Layer.currentSide == left || Layer.currentSide == right
                    {
                        sideAccumulator = Building.getWidth;  (
                    }
        
                     
            int temp = 0;
            int storeMod = 0;
     int largeBrick = 0;
     int mediumBrick = 0;
     int smallBrick = 0;
    
    
            for (int i = 0; i < sideAccumulator; i++) {
                 storeMod = sideAccumulator % 4; (storemod is 3)
                 sideAccumulator / 2 = temp;
                 sideAccumulator = math.rounddown(temp);
                    (sideAccumulator is now 2);
                 Add LengthAccumulator to 4x2 brick (adding 2 bricks)
                 largeBrick = sideAccumulator;
                 sideAccumulator = storeMod;
                 
                 storeMod = sideAccumulator % 2 (storemod is 1)
                 LengthAccumulator / 2 = temp;
                 sideAccumulator = math.rounddown(temp);
                    (sideAccumulator is now 1);
                 Add LengthAccumulator to 2x2 brick (adding 1 brick)
                 mediumBrick = sideAccumulator;
                 sideAccumulator = storeMod;
                 
                 
                 storeMod = sideAccumulator % 1 (storemod is 0)
                 sideAccumulator / 1 = temp;
                 sideAccumulator = math.rounddown(temp);
                    (sideAccumulator is now 1);
                 Add LengthAccumulator to 1x2 brick (adding 1 brick)
                 smallBrick = sideAccumulator;
    
                 Complete sideFront = (2,1,1) => send to table side 1
        
    
                
    
                    
                 Math
        
                 (if storeMod != 0)
                     {
                        throw error;
                     }
                     }
                 put enum amounts to table.
        
                Brick(side)
                {
                    
                    Enum {4x2, 2x2 1x2}
                    
                    
                        
        
                 }
        
         for (int i = 0; i < getBuilding.length; i++) {
         Side(Layer)  
        
        }
        Brick(Side)
        
        
        
        
        
        
        
        
 */
