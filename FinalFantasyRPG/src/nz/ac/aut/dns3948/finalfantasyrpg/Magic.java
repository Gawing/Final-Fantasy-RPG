/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.ac.aut.dns3948.finalfantasyrpg;

/**
 *
 * @author dns3948 GavinC
 */
public class Magic {

    
    private Player playChar;
    private int playMP;
    private int magicDmg;
    private int mpCost;
    private boolean confirmMagic;
    private boolean odMode;
    private boolean confirmDmg;
    

    public Magic(Player newP, int playerMP, boolean overDrive){

        playChar = newP;
        playMP = playerMP;
        magicDmg = 0;
        confirmMagic = false;
        odMode = overDrive;
        confirmDmg = false;
        
    }

    public void magicMenu(){
        System.out.println("******* Magic Menu*******\n"
                + "Please select what magic you want to use: \n"
                + "Use Fire - Cost 5 MP - Fire\n"
                + "Use Blizzard - Cost 5 MP - Ice\n"
                + "Use Thunder - Cost 5 MP - Light\n"
                + "Use Holy - Cost 20 MP - Holy \n"
                + "Use Ultima - Cost 100 MP - Ulti\n"
                +"Exit - exit");


    }

    public void confirmMagic(){
        if(playMP >= mpCost){
            confirmMagic = true;
            playMP -= mpCost;
        }
        else{
            confirmMagic = false;
            System.out.println(playChar.getName() + " does not enough MP");
        }

    }

    public boolean getConfirmMag(){
        return confirmMagic;
    }

    public boolean getConfirmDmg(){
        return confirmDmg;
    }

    public int getPlayerMP(){
        return playMP;
    }
    
    public int getMpCost(){
        return mpCost;
    }

    public int getMagicDmg(){
        return magicDmg;
    }

    public boolean spellOverdrive(){
        boolean overDrive;
        if(odMode == true && playChar.getType().equalsIgnoreCase("Spellcaster")){
        overDrive = true;
        }
        else{
            overDrive = false;
        }
        return overDrive;

    }


    public void useMagic(String magicName){
        if(magicName.equalsIgnoreCase("Fire") || magicName.equalsIgnoreCase("Light")
                || magicName.equalsIgnoreCase("Ice")){
            useElemental(magicName);
        }

        else if(magicName.equalsIgnoreCase("Holy")){
            useHoly();
        }

        else if(magicName.equalsIgnoreCase("Ulti")){
            useUltima();

        }
        else{

        }

    }

    public void useElemental(String magicName){
        if(spellOverdrive()){
            mpCost = 1;
        }
        else{
            mpCost = 5;
        }
        confirmMagic();

        if(getConfirmMag()){

            magicDmg = playChar.getMagicStr() * 2;
            if(magicName.equalsIgnoreCase("Fire")){
                System.out.println(playChar.getName() + " scorches the monster with Fire");
            }

            else if(magicName.equalsIgnoreCase("Ice")){
                System.out.println(playChar.getName() + " freezes the monster with Blizzard");

            }
            else{
                System.out.println(playChar.getName() + " strikes the monster with Thunder");

            }
            confirmDmg = true;

        }


    }
   

    public void useHoly(){

        if(spellOverdrive()){
            mpCost = 1;
        }
        else{
            mpCost = 20;
        }
        confirmMagic();

        if(getConfirmMag()){
            System.out.println(playChar.getName() + " summons a white powerful light called Holy");
            magicDmg = playChar.getMagicStr() * 5;
            confirmDmg = true;

        }

    }

    public void useUltima(){
        if(spellOverdrive()){
            mpCost = 1;
        }
        else{
            mpCost = 100;
        }
        confirmMagic();

        if(getConfirmMag()){
            System.out.println(playChar.getName() + " unleashes Ultima, the ulimate destructive magic which destroys anything in its path ");
            magicDmg = playChar.getMagicStr() * 20;
            confirmDmg = true;
        }

    }

}
