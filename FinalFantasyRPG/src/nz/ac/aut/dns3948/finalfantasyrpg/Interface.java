/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.ac.aut.dns3948.finalfantasyrpg;

import java.util.Scanner;

/**
 *
 * @author dns3948 Gavin C
 */


public class Interface {
   private Scanner gameReader = new Scanner(System.in);
   private FinalFantasyRPG playGame = new FinalFantasyRPG();

   public Interface(){

   }


   public static void main(String[] args) throws Exception{
      Interface iniGame = new Interface();
      iniGame.startGame();

   }

   private static String SENTINEL = "endgame";

  /*
   * New Game menu
   */
   public void startGame() throws Exception{


       playGame.gameMenu();
       String command = gameReader.nextLine();

       //Start the new game
       if(command.equals("1")){
           newGame();
       }
       //Load the game
       else if(command.equals("2")){
          boolean loadCheck = playGame.listGame();
          if(loadCheck){
              String loadName = gameReader.nextLine();
              playGame.loadGame(loadName);

              if(playGame.confirmLoad()){
                  System.out.println("Load Complete");
                  intermission();
                  mainCommand();
              }
              else{
                  startGame();
              }

          }
           
       }
       //Exit the game otherwise iterates back to the new game menu
       else if(command.equals("3")){
           exitGame();
           startGame();
           
       }
       else{
           startGame();
       }
    }

  /*
   * New game greeting with character name input
   */
   public void newGame(){
       playGame = new FinalFantasyRPG();
       playGame.startGreeting();
       String name = gameReader.nextLine();
       playGame.checkName(name);

       while(playGame.getConfirmName() == false){
           System.out.print("Name: ");
           String newName = gameReader.nextLine();
           playGame.checkName(newName);
       }
       typeSelection();
       mainCommand();

   }

  /**
   * Character Type Selection
   */
   public void typeSelection(){
       playGame.typeSelection();
       String type = gameReader.nextLine();
       playGame.checkType(type);

       while(playGame.getConfirmType() == false){
           System.out.print("Type: ");
           String newType = gameReader.nextLine();
           playGame.checkType(newType);
       }
   }

  /**
   * In-game interactions
   */
   public void mainCommand(){
       System.out.println();
       playGame.mainInteract();
       String command = gameReader.nextLine();
       playGame.mainCommand(command);

       if(command.equalsIgnoreCase(SENTINEL)){
           exitGame();
           mainCommand();
       }

       if(command.equalsIgnoreCase("item"))
       {
           intermission();
           mainCommand();
       }
       
       while(playGame.getCommand() == false){

            playGame.mainInteract();
            command = gameReader.nextLine();
            playGame.mainCommand(command);
       }

       if(command.equalsIgnoreCase("check")){
           intermission();
           mainCommand();
       }

       else if(command.equalsIgnoreCase("save")){
           playGame.saveGame();
           System.out.println("Save Complete");
           intermission();
           mainCommand();
       }

       else if(command.equalsIgnoreCase("fight"))
       {
            battleCommand();
       }

       else if(command.equalsIgnoreCase("final"))
       {
            battleCommand();
       }

       else if(command.equalsIgnoreCase("item"))
       {
           intermission();
           mainCommand();
       }

       else if(command.equalsIgnoreCase(SENTINEL))
       {
           exitGame();
           mainCommand();
       }
       else{

       }


   }

  /**
   * Battle command and interactions input
   */
   public void battleCommand(){

       String newMove;
       // Iterator to represent the battle
       while(playGame.monsHealth() > 0 && playGame.checkDeath() == false ){

           playGame.battleIntro();
           newMove = gameReader.nextLine();
           playGame.battleCommand(newMove);

           if(newMove.equalsIgnoreCase("escape"))
           {
           intermission();
           mainCommand();
           }

           else if(newMove.equalsIgnoreCase("atk") || newMove.equalsIgnoreCase("scan")
                   || newMove.equalsIgnoreCase("recov")){
           intermission();
           }

           else if(newMove.equalsIgnoreCase("magic")){
               magicMenu();

           }

           else if(newMove.equalsIgnoreCase("item")){
           itemMenu();
           intermission();

           }

           else{

           }

           System.out.println();
       }
       //Check if the characters hp is 0
       if(playGame.checkDeath()){
           System.out.println(playGame.getName() + " has been defeated....");
           intermission();
           gameOver();
       }

       else{

       }
       //When monster is defeated, returns to the in game interations
       if(playGame.monsHealth() <= 0 && !playGame.monsName().equalsIgnoreCase("Bahamut")){
           playGame.endBattle();
           intermission();
           mainCommand();
       }
      
       else{
           System.out.println("Congratulations!! you have beaten the strongest monster and won the game =D");
           intermission();
           gameOver();
       }

   }

  /**
   * Exit game confirmation
   */
   public void exitGame(){

       
       System.out.println("Are you sure you want to exit the game? - Yes to confirm otherwise press any key");
       System.out.print("Command: ");
       
       String command = gameReader.nextLine();

       if(command.equalsIgnoreCase("yes")){
           System.exit(0);
       }
       else{

           
       }
   }
  /**
   * Intermission between interactions
   */
   public void intermission(){
       System.out.print("Press any key to continue: ");
       gameReader.nextLine();
   }
  /**
   * Displays input for item menu
   */
   public void itemMenu(){
       String command = gameReader.nextLine();
       if(command.equalsIgnoreCase("Potion") || command.equalsIgnoreCase("MagicStone") || command.equalsIgnoreCase("UltimaStone") ){
           playGame.useItem(command);
       }
       else{
           System.out.println("Invalid Item");
           battleCommand();
       }

   }
  /**
   * Displays magic menu and input
   */
   public void magicMenu(){
       playGame.magicMenu();
       String command = gameReader.nextLine();
       
       if(command.equalsIgnoreCase("Fire") || command.equalsIgnoreCase("Ice")
               || command.equalsIgnoreCase("Light") || command.equalsIgnoreCase("Holy") || command.equalsIgnoreCase("Ulti")){
           playGame.useMagic(command);
           intermission();
           battleCommand();
       }


       else if(command.equalsIgnoreCase("exit")) {
           battleCommand();
       }
            
       else{
           magicMenu();
           
       }
       
   }

  /**
   * Game over menu and input
   */
   public void gameOver(){
       playGame.gameOver();
       String command = gameReader.nextLine();

       if(command.equals("1")){
           newGame();
       }
       else if(command.equals("2")){
           
           mainCommand();
       }
       else if(command.equals("3")){
           exitGame();
           gameOver();

       }
       else{
           gameOver();
       }

   }


   
}
