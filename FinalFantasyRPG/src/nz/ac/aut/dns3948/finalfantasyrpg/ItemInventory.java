/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.ac.aut.dns3948.finalfantasyrpg;

import java.util.ArrayList;

/**
 *
 * @author dns3948 GavinC
 */
public class ItemInventory {
    private ArrayList<Item> invent = new ArrayList();

    int potionCount = 0;
    int stoneCount = 0;
    int ultiCount = 0;
    boolean hasItem = false;


    public ItemInventory(){

    }

    public String addItem(Item newItem){
     
        if(newItem.getName().equalsIgnoreCase("Potion")){
                potionCount++;
            }

            else if(newItem.getName().equalsIgnoreCase("MagicStone"))
            {
                stoneCount++;
            }

            else if(newItem.getName().equalsIgnoreCase("UltimaStone")){
                ultiCount++;
            }

        invent.add(newItem);
        hasItem = true;
        return newItem.getName();

    }

    public void useItem(String itemName){
        hasItem = false;

        if(invent.isEmpty()){
            System.out.println("No item in inventory");

        }
        else{
            for(Item item: invent){
                if(item.getName().equalsIgnoreCase(itemName)){
                    invent.remove(item);
                    hasItem = true;
                    break;

                }
                else{

                    hasItem = false;

                }
            }
            if(!hasItem){
                System.out.println("Does not have item");
            }

        }

        if(itemName.equalsIgnoreCase("Potion") && !hasItem == false){
            System.out.println("Your character uses Potion");
            potionCount--;

        }
        else if(itemName.equalsIgnoreCase("MagicStone") && !hasItem == false){
            System.out.println("Your character uses MagicStone");
            stoneCount--;
        }
        else if (itemName.equalsIgnoreCase("UltimaStone") && !hasItem == false){
            System.out.println("Your character uses an UltimaStone!");
            ultiCount--;
        }

    }

    public boolean hasItem(){
        return hasItem;
    }

    public int getPotion(){
        return potionCount;
    }

    public int getStone(){
        return stoneCount;
    }

    public int getUlti(){
        return ultiCount;
    }

   


    public void displayList(){
        
        System.out.println("*******Item Inventory*******\n"
                + "Potion - Heals 200 health points: " + potionCount + "\n"
                + "MagicStone - Damages enemy with a random elemental magic: " + stoneCount + "\n"
                + "UltimaStone - Rare Stone that unleashes the Ultima Magic : "+ ultiCount);

    }

}
