/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.ac.aut.dns3948.finalfantasyrpg;

import java.util.Random;

/**
 *
 * @author dns3948 GavinC
 */
public class Item {

    private String itemName;
    private Random itemGen = new Random();


    public Item(){
        int createItem = itemGen.nextInt(20);
        if(createItem > 10){
            itemName = "Potion";

        }
        else if(createItem <= 10 && createItem != 0 ){
            itemName = "MagicStone";
        }
        else{
            itemName = "UltimaStone";

        }
        //Check item creation integer
        //System.out.println(createItem);

   }

    public String getName(){
        return itemName;
    }




}
