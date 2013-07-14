package nz.ac.aut.dns3948.finalfantasyrpg;

import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dns3948 GavinC
 */
public class Battle {
    private int playerMp;               
    private int playerHp;              
    private int playerMagic;            
    private int playerStr;              
    private int nextLevel;              
    private int playerLvl;
    private int monsHealth;
    private boolean overDrive;
    private Player player;
    private Monster monster = new Monster();
    private Magic magic;
    private boolean bossRecover;


    public Battle(Player newP){
        player = newP;
        playerMp = player.getMP();
        playerHp = player.getHealth();
        playerMagic = player.getMagicStr();
        playerStr = player.getDamage();
        nextLevel = player.getNextLvl();
        playerLvl = player.getPlayerLvl();
        overDrive = false;
        bossRecover = false;
        


    }

    /**
     * Displays monster's health
     * @return monster's health points
     */
    public int getMonsHealth(){
        
        return monsHealth;
    }

    /**
     * Decreases the monster's health by the damage made by the user's character
     * @param damage taken
     */
    public void decMonsHealth(int dmg){
        monsHealth -= dmg;
    }

    /**
     * Displays the monster's name
     * @return monster's name
     */
    public String getMonsName(){
        return monster.getName();
    }

   /**
    * Players battle HP
    * @return player's battle HP
    */
    public int getPlayerHP(){
        return playerHp;
    }

   /**
    * Set the players battle HP
    */
    public void setPlayerHP(int newHp){
        playerHp = newHp;
    }

    /**
     * Players battle MP
     * @return player's battle MP
     */
    public int getPlayerMP(){
        return playerMp;
    }

    /**
     * Set the player's MP
     */
    public void setPlayerMP(int newMp){
        playerMp = newMp;
    }

    public int getPlayerStr(){
        return playerStr;
    }

    public int getPlayerMagic(){
        return playerMagic;
    }

    public int getMonsDmg(){
        return monster.getDamage();
    }

    public void monsGen(){
        monster.genMonster(playerLvl);
        monsHealth = monster.getHealth();
    }

    public void bossGen(){
        monster.bossMonster();
        monsHealth = monster.getHealth();
    }

    public boolean regenBoss(){
        return bossRecover;
    }

    public void battleCommands(){
      
        System.out.println("*******");

        //Check if the character can go into overdrive mode
        checkOverDrive();

        //Display the character's status
        System.out.println("Name: " + player.getName() + " Current Health: " + playerHp + " Current MP: " + playerMp + " Strength: " + playerStr +
                "\nMagic: " + playerMagic + " Level: "+ playerLvl + " Next Level: " + nextLevel );

        //Displays the special abilities while the character is in overdrive mode
        if(overDrive){
            System.out.println("*******");
            System.out.println("Characters in Overdrive Mode!!");
            if(player.getType().equalsIgnoreCase("Bladesman")){
                System.out.println(player.getName() + " Strength increases by a multiply of 4");
            }
            else if(player.getType().equalsIgnoreCase("Spellcaster")){
                System.out.println("All MP cost for magic is 1 MP");
            }
            else{
                System.out.println(player.getName() + " doubles the Strength and Magic");
            }
            System.out.println("*******");
        }
        else{

        }
        // Resets the bosses regen
        bossRecover = false;

        System.out.println("******* Battle Menu *******\n"
                + "Choose your move! \n"
                + "Check Monster's Status - Scan\n"
                + "Attack - Atk\n"
                + "Use Magic - Magic\n"
                + "Use Item - Item \n"
                + "Recover MP - Recov\n"
                + "Run away - Escape\n ");
        
        System.out.print("Command: ");

    }


    public void battleInput(String command){

        if(command.equalsIgnoreCase("Scan")){
            scanMonster();
        }

        else if(command.equalsIgnoreCase("Atk"))
        {
            playerAttack();
        }
        else if(command.equalsIgnoreCase("Recov")){
            recoverMagic();
        }
        else if(command.equalsIgnoreCase("Item")){
            itemSelection();
        }
        
        else if(command.equalsIgnoreCase("Escape")){
            escape();
        }
    }


    public void scanMonster(){

        System.out.println("*******");
        monster.monsDetails();
        System.out.println("Current Health: " + monsHealth);
        System.out.println("*******");
    }


    public void playerAttack(){

        decMonsHealth(playerStr);
        System.out.println("*******");
        System.out.println(player.getName() + " dealt " + playerStr + " damage to " + monster.getName());

        if(monsHealth > 0){
          monsAttack();
        }
        else{

        }
        
    }


    public boolean checkHealth(){
        boolean charDeath = false;
        if(playerHp <= 0){
            charDeath = true;
        }
        return charDeath;


    }


    public void monsAttack(){

        // Determine Monsters Overdrive(Special Attack)
        int monsLimit = monster.getHealth() / 10;
        
        if(getMonsHealth() <= monsLimit){
          int monsOverdrive = getMonsDmg() * 3;

          if(getMonsName().equalsIgnoreCase("Valefor")){
              System.out.println("Valefor executes a Sonic Ray dealing " + monsOverdrive + " damage to " + player.getName());
          }

          else if(getMonsName().equalsIgnoreCase("Ifrit")){
              System.out.println("Ifrit erupts a volcano and strikes with HellFire dealing " + monsOverdrive + " damage to " + player.getName());
          }

          else if(getMonsName().equalsIgnoreCase("Shiva")){
              System.out.println("Shiva freezes the area and uses Diamond Dust dealing " + monsOverdrive + " damage to " + player.getName());

          }
          else{
              System.out.println("Bahumut takes flight and gathers energy from the stars and unleashes Mega Flare dealing  " + monsOverdrive + " damage to " + player.getName());
          }
          playerHp -= monsOverdrive;
        }
        else{
            // Determine if the boss regenerates
            if(monster.getName().equalsIgnoreCase("Bahamut") && monsHealth < 5000){
                Random bossRegen = new Random();
                int regen = bossRegen.nextInt(2);

                if(regen == 0){
                    System.out.println("Bahamut regenerates...");

                    monsHealth += 100;
                    bossRecover = true;
                    if(monsHealth > 5000){
                        monsHealth = 5000;
                    }
                    else{

                    }
                }
                else{

                }
            }
            else{

            }
            // Monsters Attack
            playerHp -= getMonsDmg();
            System.out.println( monster.getName()+ " retaliates with a " + monster.getDamage() + " attack to " + player.getName());
            System.out.println("*******");
        }
    }
    

    public void magicSelection(){
       magic = new Magic(player,playerMp,overDrive);
       magic.magicMenu();
       System.out.print("Select your Magic: ");

    }

    public void useMagic(String magicName){
        magic.useMagic(magicName);
        if(magic.getConfirmDmg()){
            monsHealth -= magic.getMagicDmg();
            playerMp = magic.getPlayerMP();
            System.out.println("dealing " + magic.getMagicDmg() + " damage to " + monster.getName());
            if(monsHealth > 0 ){
                monsAttack();
            }
            else{
                
            }
        }
        else{
            
        }
    }

    public void itemSelection(){
        player.displayInvent();
        System.out.print("Select your item: ");

    }

    public void useItem(String itemName){
       boolean useItem =  player.useItem(itemName);
       if(useItem){
           if(itemName.equalsIgnoreCase("Potion")){
               usePotion();
           }
           else if(itemName.equalsIgnoreCase("MagicStone"))
           {
               useStone();
           }
           else{
               useUltimaStone();

           }
       }
       else{
           
       }
       if(monsHealth > 0){
           monsAttack();
       }
    }


    public void usePotion(){
        playerHp += 200;
        if(playerHp > player.getHealth()){
            playerHp = player.getHealth();
        }
        else{
            
        }
        
        System.out.println(player.getName() + " recovers 200 HP");
           
    }

    
    public void useStone(){
        int stoneDmg = playerMagic * 2;
        String stoneName;
        Random nameStone = new Random();
        int stoneNum = nameStone.nextInt(2);
        if(stoneNum == 0){
            stoneName = "Fire";
        }
        else if(stoneNum == 1){
            stoneName = "Ice";
        }
        else{
            stoneName = "Light";
        }
        monsHealth -= stoneDmg;
        System.out.println(" The MagicStone unleashed the power of " + stoneName + " dealing " + stoneDmg + " damage to " + monster.getName() );
           
    }


    public void useUltimaStone(){
        int stoneDmg = playerMagic * 10;
        monsHealth -= stoneDmg;
        System.out.println("The UltimaStone unleashed a hint of the power of Ultima dealing " + stoneDmg + " damage to " + monster.getName() );

    }


    public void recoverMagic(){
        int recovPoints = playerLvl * 5;
        playerMp += recovPoints;

        if(playerMp > player.getMP()){
            playerMp = player.getMP();
        }
        else{
            
        }
        System.out.println("*******\n"
                + player.getName() + " recovers " + recovPoints + " MP\n"
                + "*******");

        monsAttack();

    }


    public boolean getOverDrive(){
        return overDrive;
    }

   /**
    * Character goes into overdrive mode when health is 10% or less
    */
    public void checkOverDrive(){

        int odLimit = player.getHealth() / 10;

        if(playerHp <= odLimit && overDrive == false ){
            overDrive = true;
            overdriveMode();
        }
        else{

        }

    }


    public void overdriveMode(){

        if(player.getType().equalsIgnoreCase("Bladesman")){
            playerStr *= 4;
        }
        else if(player.getType().equalsIgnoreCase("Hybrid")){
            playerStr *= 2;
            playerMagic *=2;
        }
    }
        

    public void escape(){
        System.out.println(player.getName() + " escapes from battle\n"
                + "********\n"
                + player.getName() + " did not gain any experience");
    }

}
