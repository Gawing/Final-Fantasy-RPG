/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nz.ac.aut.dns3948.finalfantasyrpg;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dns3948
 */
public class BattleTest {
    private ItemInventory invent = new ItemInventory();
    private Player player = new Player(invent);

    private Battle battleTest;

    public BattleTest() {
        player.setType("bladesman");
        player.assignAttribute();
        battleTest = new Battle(player);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    @Test
    public void testGenValefor(){
        battleTest.monsGen();
        while(!battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            battleTest.monsGen();
        }
        assertEquals("Valefor", battleTest.getMonsName());
        assertEquals(250, battleTest.getMonsHealth());
        assertEquals(10,battleTest.getMonsDmg());

    }

    @Test
    public void testGenShiva(){
        battleTest.monsGen();
        while(!battleTest.getMonsName().equalsIgnoreCase("Shiva")){
            battleTest.monsGen();
        }
        assertEquals("Shiva", battleTest.getMonsName());
        assertEquals(150, battleTest.getMonsHealth());
        assertEquals(30,battleTest.getMonsDmg());

    }

    @Test
    public void testGenIfrit(){
        battleTest.monsGen();
        while(!battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            battleTest.monsGen();
        }
        assertEquals("Ifrit", battleTest.getMonsName());
        assertEquals(200, battleTest.getMonsHealth());
        assertEquals(25,battleTest.getMonsDmg());

    }
    @Test
    public void testBossGen(){
        battleTest.bossGen();
        assertEquals("Bahamut", battleTest.getMonsName());
        assertEquals(5000,battleTest.getMonsHealth());
        assertEquals(100,battleTest.getMonsDmg());

    }

    @Test
    public void testPlayerAttack(){
        battleTest.monsGen();
        battleTest.playerAttack();
        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            assertEquals(200, battleTest.getMonsHealth());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            assertEquals(150, battleTest.getMonsHealth());

        }
        else{
            assertEquals(100, battleTest.getMonsHealth());
        }

    }

    @Test
    public void testAtkBoss(){
        battleTest.bossGen();
        battleTest.playerAttack();
        if(battleTest.regenBoss()){
            assertEquals(5000,battleTest.getMonsHealth());
        }
        else{
            assertEquals(4950,battleTest.getMonsHealth());
        }

    }
    
    @Test
    public void testMonsterAtk(){
        battleTest.monsGen();
        battleTest.monsAttack();
        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            assertEquals(190, battleTest.getPlayerHP());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            assertEquals(175, battleTest.getPlayerHP());

        }
        else{
            assertEquals(170, battleTest.getPlayerHP());
        }
    }

    @Test
    public void testBossAtk(){
        battleTest.bossGen();
        battleTest.monsAttack();
        assertEquals(100, battleTest.getPlayerHP());

    }

   /**
    * Test if boss recovers and boss recovery does not exceed max health
    */
    @Test
    public void testBossRecover(){
        battleTest.bossGen();
        battleTest.playerAttack();
        
        if(!battleTest.regenBoss()){
            testBossRecover();
        }
        else{
            assertEquals(5000,battleTest.getMonsHealth());
        }
    }

    @Test
    public void testElementalMagic(){
        battleTest.monsGen();
        battleTest.magicSelection();
        battleTest.useMagic("Fire");
        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            assertEquals(240, battleTest.getMonsHealth());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            assertEquals(190, battleTest.getMonsHealth());

        }
        else{
            assertEquals(140, battleTest.getMonsHealth());
        }
    }

    @Test
    public void testNoMP(){
        battleTest.monsGen();
        battleTest.magicSelection();
        battleTest.useMagic("holy");
        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            assertEquals(250, battleTest.getMonsHealth());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            assertEquals(200, battleTest.getMonsHealth());

        }
        else{
            assertEquals(150, battleTest.getMonsHealth());
        }
    }

    @Test
    public void testHolyMagic(){
        battleTest.monsGen();
        battleTest.setPlayerMP(100);
        battleTest.magicSelection();
        battleTest.useMagic("holy");
        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            assertEquals(225, battleTest.getMonsHealth());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            assertEquals(175, battleTest.getMonsHealth());

        }
        else{
            assertEquals(125, battleTest.getMonsHealth());
        }
    }

    @Test
    public void testUltima(){
        battleTest.monsGen();
        battleTest.setPlayerMP(100);
        battleTest.magicSelection();
        battleTest.useMagic("ulti");
        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            assertEquals(150, battleTest.getMonsHealth());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            assertEquals(100, battleTest.getMonsHealth());

        }
        else{
            assertEquals(50, battleTest.getMonsHealth());
        }

    }

    @Test
    public void testUsePotion(){
        battleTest.monsGen();
        battleTest.monsAttack();
        battleTest.usePotion();
        assertEquals(200, battleTest.getPlayerHP());

    }

    @Test
    public void testUseStone(){
        battleTest.monsGen();
        battleTest.useStone();
        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            assertEquals(240, battleTest.getMonsHealth());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            assertEquals(190, battleTest.getMonsHealth());

        }
        else{
            assertEquals(140, battleTest.getMonsHealth());
        }

    }

    @Test
    public void testUltiStone(){
        battleTest.monsGen();
        battleTest.useUltimaStone();
        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            assertEquals(200, battleTest.getMonsHealth());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            assertEquals(150, battleTest.getMonsHealth());

        }
        else{
            assertEquals(100, battleTest.getMonsHealth());
        }

    }

    @Test
    public void testBladeOD(){
        battleTest.setPlayerHP(player.getHealth() /10);
        battleTest.checkOverDrive();
        assertTrue(battleTest.getOverDrive());
        assertEquals(200, battleTest.getPlayerStr());

    }
    @Test
    public void testRecoverMP(){
        battleTest.setPlayerMP(5);
        battleTest.monsGen();
        battleTest.recoverMagic();
        assertEquals(10, battleTest.getPlayerMP());

    }


    @Test
    public void testHybridOD(){
        ItemInventory item = new ItemInventory();
        Player hybridTest = new Player(item);
        hybridTest.setType("hybrid");
        hybridTest.assignAttribute();
        battleTest = new Battle(hybridTest);
        battleTest.setPlayerHP(hybridTest.getHealth() /10);
        battleTest.checkOverDrive();
        assertTrue(battleTest.getOverDrive());
        assertEquals(100, battleTest.getPlayerStr());
        assertEquals(40, battleTest.getPlayerMagic());

    }

    @Test
    public void testMonsSpecAtk(){

        battleTest.monsGen();

        if(battleTest.getMonsName().equalsIgnoreCase("Valefor")){
            battleTest.decMonsHealth(240);
            battleTest.monsAttack();
            assertEquals(170, battleTest.getPlayerHP());
        }
        else if(battleTest.getMonsName().equalsIgnoreCase("Ifrit")){
            battleTest.decMonsHealth(190);
            battleTest.monsAttack();
            assertEquals(125, battleTest.getPlayerHP());

        }
        else{
            battleTest.decMonsHealth(140);
            battleTest.monsAttack();
            assertEquals(110, battleTest.getPlayerHP());
        }


    }

    @Test
    public void testBossSpecAtk(){
        battleTest.setPlayerHP(400);
        battleTest.bossGen();
        battleTest.decMonsHealth(4900);
        battleTest.monsAttack();
        assertEquals(100, battleTest.getPlayerHP());

    }

    


    @Test
    public void checkDeath(){
        battleTest.setPlayerHP(0);
        assertTrue(battleTest.checkHealth());

    }

}