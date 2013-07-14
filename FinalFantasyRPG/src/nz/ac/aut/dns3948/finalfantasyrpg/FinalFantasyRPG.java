

package nz.ac.aut.dns3948.finalfantasyrpg;




/**
 * @author dns3948 GavinC
 */

public class FinalFantasyRPG  {
    private ItemInventory item = new ItemInventory();
    private Player player = new Player(item);
    private Battle battle;
    private Boolean confirmName;
    private Boolean confirmType;
    private Boolean confirmCommand;
    private SaveLoad loadGame;
    
    

    /**
    * Constructor for class FinalFantasyRPG
    */
     public FinalFantasyRPG(){
         confirmName = false;   //Character name has not been confirmed
         confirmType = false;   //Character type has not been confirmed
         confirmCommand = false;    //user command has not been confirmed
         
     }

    /**
    * Game menu for the FinalFantasy RPG game
    */
     public void gameMenu(){
         System.out.println("********Final Fantasy RPG*******\n"
                 + "New Game - 1\n"
                 + "Load Game - 2\n"
                 + "Exit Game - 3\n");
         System.out.print("Please select: ");
     }

    /**
    * New game greeting for the FinalFantasyRPG game
    */
     public void startGreeting(){

         System.out.println("******* Welcome to the world of Final Fantasy RPG *******\n"
                 + "We will start of by giving your character a name \n");
         System.out.print("Character Name: ");

     }
     
    /**
    * A boolean to confirm that the character's name is valid
    * @return true if the name is valid otherwise false
    */
     public boolean getConfirmName(){
         return confirmName;
     }

    /**
    * Validates if the character's name contains any invalid characters and if the name is blank or too short in length
    * @param the user input of their character name
    * @throws when the parameter length is null
    */
     public void checkName(String name)throws NullPointerException{
         if(!name.matches("^[\\w]+$")){
             System.out.println("Invalid characters in username. Please use letters or numbers");

         }
         else if(name.length() < 3){
              System.out.println("Name has to be at least 3 letters ");
         }
         else{
             player.setName(name);
             confirmName = true;
             System.out.println("Name is valid!\n");
         }

     }

    /**
     * Gets the character's name
    * @return player's name
    */
     public String getName(){
         return player.getName();
     }

    /**
    * Display instructions of the possible character types the user can select
    */
     public void typeSelection(){
         System.out.println("******* Type Selection *******\n"
                 + "Now please select the type you want " + getName() + " to be \n"
                 + "You can choose from a:  \n"
                 + "Bladesman - A warrior that wields multiple swords. Has high Health and Strength(Damage) \n"
                 + "Spellcaster - A magician that uses destructive magic. Has high Magic and Mana Points \n"
                 + "Hybrid - A character that is adept in both magic and blades. Has high Strength and Magic");

         System.out.print("Type: ");
     
     }

   /**
    * Check if the user's input is a valid type. If it is then assigns the character's attribute.
    * @param the user's inputted type
    * @throws NullPointerException
    */
     public void checkType(String type) throws NullPointerException{

         if(!type.equalsIgnoreCase("Bladesman") && !type.equalsIgnoreCase("Spellcaster") && !type.equalsIgnoreCase("Hybrid")){
             System.out.println("Invalid Character Type - Please re-enter");
             confirmType = false;
         }
         else{
             player.setType(type);
             player.assignAttribute();
             confirmType = true;
         }
         System.out.println();
     }

   /**
    * A boolean to confirm that the character's type valid
    * @return true if the type is valid otherwise false
    */
     public boolean getConfirmType(){
         return confirmType;
     }
     
     public int getPlayerLvl(){
         return player.getPlayerLvl();
     }

     public int getNextLvl(){
         return player.getNextLvl();
     }

     public void setNextLvl(int newLvl){
         player.setNextLvl(newLvl);
     }


    /**
     * Display the in-game command
     */
     public void mainInteract(){

         confirmCommand = false;
         
         System.out.println("******* Welcome to the Main Realm *******\n"
                 + "You can fight monsters to gain levels, check your status and inventory, save and exit your game or, \nif you think you are strong enough, take on the Final Boss.\n "
                 + "What would you like " + getName() + " to do: \n"
                 + "Battle Monsters - Fight\n"
                 + "Check Character's Status - Check\n"
                 + "Fight the Final Boss - Final\n"
                 + "Check Item Inventory - Item\n"
                 + "Save the game (Items will not be saved) - Save\n"
                 + "End the Game - Endgame\n");
         System.out.print("Command: ");
                 

     }

    /**
     * A boolean to confirm that the character's type valid
     * @return true if user inputted a correct command
     */
     public boolean getCommand(){
         return confirmCommand;
     }


    /**
     * The actions that results from the user's command
     * @param the user's inputted command
     */

     public void mainCommand(String command){
         confirmCommand = false;
         if(command.equalsIgnoreCase("Fight")){
             confirmCommand = true;
             monsBattle();
             // Check if confirmCommand is true;
             // System.out.println(getCommand());
         }
         else if(command.equalsIgnoreCase("Check")){
             confirmCommand = true;
             displayStat();

         }
         else if(command.equalsIgnoreCase("Final")){
             confirmCommand = true;
             bossBattle();
         }

         else if(command.equalsIgnoreCase("Item")){
             confirmCommand = true;
             displayInvent();
             
         }

         else if(command.equalsIgnoreCase("Save")){
             confirmCommand = true;
             saveGame();
         }

         else if(command.equalsIgnoreCase("endgame")){
             
         }
         else{
             System.out.println("Invalid input");
         }

     }

    /**
     *  Initialization of a monster battle, creates a monster and displays battle commands
     */

     public void monsBattle(){
         battle = new Battle(player);
         battle.monsGen();
        //Check generated monster
        //System.out.println("Name: " + battle.getMonsName() + "Health " + monsHealth());
         
         
     }
     /**
      * Calls the battle class and display the battle command to the user
      */

     public void battleIntro(){
         battle.battleCommands();
         
     }

     /**
     *  The users battle command input
     */

     public void battleCommand(String com){
         battle.battleInput(com);

     }

    /**
     * Display character status to the user
     */

     public void displayStat(){
         System.out.println();
         player.displayStats();
         
     }

     /**
      * Displays the monster's health
      * @return monsters health
      */

     public int monsHealth(){
         return battle.getMonsHealth();
     }

      /**
      * Displays the monster's name
      * @return monsters name
      */
     public String monsName(){
         return battle.getMonsName();
     }


     /**
      * End of the battle where the character gains experience depending on the character's level and level up.
      */

     public boolean endBattle(){
         boolean obtainItem = false;
         System.out.println("*******");

         System.out.println("You have defeated " + battle.getMonsName());

         Item newItem = new Item();
         String itemName = newItem.getName();
         System.out.print("Obtained a " + itemName);
         System.out.println();
         player.addItem(newItem);
         obtainItem = true;
        
         
         if(player.getPlayerLvl() < 3){
             player.decNextLvl(100);
         }
         else{
             player.decNextLvl(250);
         }
             player.incPlaylvl();
             return obtainItem;
    }

     

     /**
     *  The users battle command input
     */

     public void displayInvent(){
         player.displayInvent();
         

     }

     public void magicMenu(){
         battle.magicSelection();
     }

     public void useMagic(String magicName){
         battle.useMagic(magicName);
     }

     /**
     *  Save the users character
     */

     public void saveGame(){
         SaveLoad save = new SaveLoad(this);
         save.saveGame(player);

     }

     public boolean listGame() throws Exception{
         loadGame = new SaveLoad(this);
         loadGame.listDir();
         boolean checkLoad = loadGame.confirmSave();
         return checkLoad;

     }

     public void loadGame(String loadName){
         loadGame.loadGame(loadName);
     }

     public boolean confirmLoad(){
         boolean load = loadGame.confirmLoad();
         return load;
     }

     public void newPlayer(Player newPlayer){
         player = newPlayer;
     }

     /**
     *  Fighting the final boss
     */
     public void bossBattle(){
         battle = new Battle(player);
         battle.bossGen();
         


     }

     /**
      * Check if the character has died
      */
     
     public boolean checkDeath(){
         return battle.checkHealth();
             
     }

    /*
     * Game over menu
     */
     public void gameOver(){
       System.out.println("*******Game Over*******\n"
               + "Restart Game - 1\n"
               + "Load Game - 2\n"
               + "Exit - 3\n");
       System.out.print("Please select: ");
     }

     public void itemSelection(){
         battle.itemSelection();
     }

     public void useItem(String item){
         battle.useItem(item);
     }

     public String charString(){
         return player.toString();
     }



    
}
