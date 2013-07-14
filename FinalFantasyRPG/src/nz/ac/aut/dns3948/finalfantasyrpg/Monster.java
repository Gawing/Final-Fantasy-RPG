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
public class Monster extends Character {

   private Random monster;
   private String monsDesc;
   private int dmgtotal;


   public Monster(){

      super();
      monsDesc = " ";
      monster = new Random();
      dmgtotal = 0;
   }

   public void genMonster(int num){

       int monsGen = monster.nextInt(4);
       int monsHealth = num * 100;
       int monsDmg = num * 10;

       if(monsGen <=1){
           setName("Valefor");
           setHealth(monsHealth + 150);
           setDmg(monsDmg);
           monsDesc = "A wyvern descended from above, may use a devastating attack " +
                 "called Sonic Ray when near death";
       }
       else if(monsGen == 3){
           setName("Shiva");
           setHealth(monsHealth + 50);
           setDmg(monsDmg + 20);
           monsDesc = "A ice queen that resides at the top of the earth, Beware of her Diamond Dust Attack ";

       }
       else{
           setName("Ifrit");
           setHealth(monsHealth + 100);
           setDmg(monsDmg + 15);
           monsDesc = "A beast that emerged from Hell, his Hellfire is a force to be reckon with";
       }
       
       System.out.println("*******");
       System.out.println(" You have encountered " + getName());

   }

   public void bossMonster(){

       setName("Bahamut");
       setHealth(5000);
       setDmg(100);
       monsDesc = "A Dragon that awoke from its slumber from the depth of the earth, " +
               "Beat it to win the game";

       System.out.println(getName() + " emerges.......");

   }

   public void monsDetails(){
       System.out.println("Monster: " + getName() + "\nDetails: " + monsDesc + "\nHealth: " + getHealth() + "\nDamage: " + getDamage() );
   }


   public String getMonsDesc(){
       return monsDesc;
   }




}
