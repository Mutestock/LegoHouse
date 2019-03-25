/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Buildingsplan.Building;
import Logic.Buildingsplan.BuildingCalculator;
import Logic.Buildingsplan.Layer;
import Logic.Interfaces.Facade;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Henning
 */
public class FacadeImplementation implements Facade {

    @Override
    public Building calculateAllBricksInHouse(int height, int width, int length) {
        BuildingCalculator bc = new BuildingCalculator();
        Building building = bc.createBulding(height, width, length);
        return building;
    }

    @Override
    public String timeString() {
        LocalDate localdate = LocalDate.now();
        return localdate.toString();
    }
}
