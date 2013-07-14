/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.ac.aut.dns3948.finalfantasyrpg;

import java.io.Serializable;

/**
 *
 * @author dns3948 GavinC
 */
public class Player extends Character implements Serializable{

    private String type;
    private int magicStr;
    private int nextLevel;
    private int playerLevel;
    private int magicPoints;
    private ItemInventory item;
    



    public Player(ItemInventory newItem){
        super();   
        type = "";
        item = newItem;
        magicStr = 0;
        nextLevel = 200;
        playerLevel = 1;
        magicPoints = 0;
        

    }




    public void setNextLvl(int nextLvl){
        nextLevel = nextLvl;
    }


    public int getMagicStr(){
       return magicStr;

    }
    public void setMagicStr(int mag){
        magicStr = mag;
    }

    public int getMP(){
        return magicPoints;
    }

    public void setMP(int newMP){
        magicPoints = newMP;

    }

    public void incMagPoints(int newPoints){
        magicPoints  = magicPoints += newPoints;
    }


    public String getType(){
        return type;
    }

    public void setType(String newType){
        if(newType.equalsIgnoreCase("Bladesman") || newType.equalsIgnoreCase("Spellcaster") || newType.equalsIgnoreCase("Hybrid")){
          type = newType;
        }
        else{
            System.out.println("Invalid Type");
        }
        
    }

    public int getNextLvl(){
        return nextLevel;
    }

    public void decNextLvl(int newLvl){
        nextLevel-= newLvl;
    }

    public void resetlvl(){
        nextLevel = playerLevel * 200;
    }

    public int getPlayerLvl(){
        return playerLevel;
    }

    public void setPlayerLvl(int newLvl){
        playerLevel = newLvl;
    }

    public void incPlaylvl(){
        if(nextLevel <= 0){
            playerLevel++;
            System.out.println("Your character has leveled up!!");
            if(getType().equalsIgnoreCase("Bladesman")){
               setHealth(getHealth() + 100);
               setDmg(getDamage() + 30);
               magicStr += 10;
               incMagPoints(10);
            }
            else if(getType().equalsIgnoreCase("Spellcaster")){
               setHealth(getHealth() + 50);
               setDmg(getDamage() + 10);
               magicStr += 20;
               incMagPoints(20);
            }
            else{
               setHealth(getHealth() + 75);
               setDmg(getDamage() + 25);
               magicStr += 15;
               incMagPoints(15);
            }
            resetlvl();
        }
        else{
            System.out.println("Your character has gained experience");
        }
    }

    public void displayStats(){
        System.out.println("Name: " + getName() + "\nType: " + type +  " \nHP (Health Points): " + getHealth() + "\nMP (Magic Points): " + magicPoints + "\nStrength: " + getDamage() +
                " \nMagic: " + magicStr + " \nLevel: " +  playerLevel + " \nNext Level: " + nextLevel);
    }

    public void assignAttribute(){
        if(type.equalsIgnoreCase("Bladesman")) {

            setHealth(200);
            setDmg(50);
            magicPoints = 10;
            magicStr = 5;
        }

        else if(type.equalsIgnoreCase("Hybrid")) {
            setHealth(100);
            setDmg(50);
            magicPoints = 15;
            magicStr = 20;
        }

        else if(type.equalsIgnoreCase("Spellcaster")) {

            setHealth(120);
            setDmg(25);
            magicPoints = 30;
            magicStr = 20;
        }
    }

    public void displayInvent(){
        item.displayList();
    }

    public void addItem(Item newItem){
        item.addItem(newItem);

    }

    public boolean useItem(String itemName){
        item.useItem(itemName);
        return item.hasItem();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(getName());
        builder.append(",");
        builder.append(type);
        builder.append(",");
        builder.append(getHealth());
        builder.append(",");
        builder.append(magicPoints);
        builder.append(",");
        builder.append(getDamage());
        builder.append(",");
        builder.append(magicStr);
        builder.append(",");
        builder.append(playerLevel);
        builder.append(",");
        builder.append(nextLevel);

        return builder.toString();


    }






    

}
