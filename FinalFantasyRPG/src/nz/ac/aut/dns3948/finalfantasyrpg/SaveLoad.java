/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.ac.aut.dns3948.finalfantasyrpg;



import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author GavinC
 */
public class SaveLoad {
    File charDir = new File("Saved Games");
    private boolean confirmSav;
    private static boolean confirmLoad;
    private FinalFantasyRPG game = new FinalFantasyRPG();


    public SaveLoad(FinalFantasyRPG newGame){

        game = newGame;
         
        if(!charDir.exists()){
            charDir.mkdirs();
        }
        confirmSav = false;


    }

    public boolean confirmSave(){
        return confirmSav;
    }

    public boolean confirmLoad(){
        return confirmLoad;
    }


    
    public static void saveGame(Player player){

        try{

        File charFile = new File("Saved Games/" + player.getName() + ".txt");
        BufferedWriter writer = new BufferedWriter( new FileWriter(charFile));
        String character = player.toString();
        writer.write(character);
        writer.flush();
        writer.close();

         
        }

        catch(IOException ex){
            System.err.println("IO Exception");
        }

    }

    public void listDir() throws Exception{
        String[] listGames = charDir.list();
        if (listGames == null || listGames.length == 0) {
            System.out.println("does not exist or has no save files");
        }
        else{
            System.out.println("*******Saved Games*******");
            for (int i = 0; i < listGames.length; i++) {
            String filename = listGames[i];
            System.out.println(filename);
            }
            System.out.print("Input the selected file name(without .txt) : ");
            confirmSav = true;
        }


    }
   

    public void loadGame(String gameName){

        try{

            FileReader fr = new FileReader("Saved Games/" + gameName + ".txt");
            Scanner scan = new Scanner(fr);

            scan.useDelimiter(",");

            ItemInventory item = new ItemInventory();
            Player newPlayer = new Player(item);
            while(scan.hasNext()){
                
                newPlayer.setName(scan.next());
                newPlayer.setType(scan.next());
                int health = Integer.parseInt(scan.next());
                newPlayer.setHealth(health);
                int magicPoints = Integer.parseInt(scan.next());
                newPlayer.setMP(magicPoints);
                int str = Integer.parseInt(scan.next());
                newPlayer.setDmg(str);
                int magic = Integer.parseInt(scan.next());
                newPlayer.setMagicStr(magic);
                int level = Integer.parseInt(scan.next());
                newPlayer.setPlayerLvl(level);
                int nxtLvl = Integer.parseInt(scan.next());
                newPlayer.setNextLvl(nxtLvl);
                //break;
            }
            game.newPlayer(newPlayer);
            confirmLoad = true;

        }
        catch(FileNotFoundException ex){
            System.out.println("File does not exist");
            confirmLoad = false;
        }

    }







}
