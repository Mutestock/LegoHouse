/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.HelperClasses.LegoHelper;

import Logic.HelperClasses.OrderHelper.Order;

/**
 *
 * @author Henning
 */
public class Lego {

    private int brickID;
    private int height;
    private int width;
    private int length;
    private Order order;

    public Lego(int brickID, int height, int width, int length, Order order) {
        this.brickID = brickID;
        this.height = height;
        this.width = width;
        this.length = length;
        this.order = order;
    }

    public int getBrickID() {
        return brickID;
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

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Lego{" + "brickID=" + brickID + ", height=" + height + ", width=" + width + ", length=" + length + ", order=" + order + '}';
    }
}
