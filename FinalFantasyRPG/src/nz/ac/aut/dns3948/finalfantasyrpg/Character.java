/*
 * FileInputStream/FileOutputStream
 * ObjectInputStream/ObjectOutputStream
 *
 */

package nz.ac.aut.dns3948.finalfantasyrpg;



/**
 *
 * @author dns3948 GavinC
 */
public abstract class Character {

   private String charName;
   private int maxHp;
   private int maxDmg;

   public Character(){
     maxHp = 0;
     maxDmg = 0;
    }

   public int getHealth(){
       return maxHp;
   }

   public int getDamage(){
       return maxDmg;
   }

   public String getName(){
       return charName;
   }

   public void setDmg(int newDmg){
       maxDmg = newDmg;
   }

   public void setHealth(int newHealth){
       maxHp = newHealth;
   }

   public void setName(String newName){
       charName = newName;
   }
}
