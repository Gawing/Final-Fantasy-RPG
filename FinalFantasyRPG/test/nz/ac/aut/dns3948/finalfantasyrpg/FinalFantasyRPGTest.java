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
public class FinalFantasyRPGTest {

    FinalFantasyRPG ffTest = new FinalFantasyRPG();
    ItemInventory inventTest = new ItemInventory();
    Player charTest = new Player(inventTest);
    

    public FinalFantasyRPGTest() {
        charTest.setType("bladesman");
        charTest.assignAttribute();
        ffTest.newPlayer(charTest);
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
    public void testCorrectName() {
        ffTest.checkName("Tester");
        assertEquals("Tester",ffTest.getName());
        assertTrue(ffTest.getConfirmName());

    }

    @Test
    public void testInvalidNameChar() {
        ffTest.checkName(" char");
        assertEquals(null,ffTest.getName());
        ffTest.checkName("*&^*&char");
        assertEquals(null,ffTest.getName());
       
    }
    
    @Test
    public void testInvalidNameLength() {
        ffTest.checkName("ch");
        assertEquals(null,ffTest.getName());
       
    }

    @Test
    public void testCheckTypeBladesman(){
        ffTest.checkType("Bladesman");
        assertTrue(ffTest.getConfirmType());
    }

    @Test
    public void testCheckTypeSpellcaster(){
        ffTest.checkType("Spellcaster");
        assertTrue(ffTest.getConfirmType());
    }

    @Test
    public void testCheckTypeHybrid(){
        ffTest.checkType("Hybrid");
        assertTrue(ffTest.getConfirmType());
    }

    @Test
    public void testInvalidType(){
        ffTest.checkType("dfkt");
        assertFalse(ffTest.getConfirmType());
    }

    @Test
    public void testInvalidCommand(){
        ffTest.mainCommand("random input");
        assertFalse(ffTest.getCommand());
    }

    @Test
    public void testValidCommandFight(){
        ffTest.mainCommand("fight");
        assertTrue(ffTest.getCommand());
    }

    @Test
    public void testValidCommandCheck(){
        ffTest.mainCommand("check");
        assertTrue(ffTest.getCommand());
    }


    @Test
    public void testValidCommandItem(){
        ffTest.mainCommand("item");
        assertTrue(ffTest.getCommand());
    }

    @Test
    public void testValidCommandSave(){
        ffTest.mainCommand("save");
        assertTrue(ffTest.getCommand());
    }

    @Test
    public void testObtainItem(){
        ffTest.monsBattle();
        ffTest.endBattle();
        assertTrue(ffTest.endBattle());

    }

    @Test
    public void testGainExp(){
        ffTest.monsBattle();
        ffTest.endBattle();
        assertEquals(100, ffTest.getNextLvl());
    }

    @Test
    public void testLevelUp(){
        ffTest.setNextLvl(100);
        ffTest.monsBattle();
        ffTest.endBattle();
        assertEquals(2, ffTest.getPlayerLvl());

    }
   /**
    * Test the increased experience points gained from characters that are level 3 or higher
    */
    @Test
    public void testIncExp(){
        charTest.setPlayerLvl(4);
        charTest.setNextLvl(300);
        ffTest.newPlayer(charTest);
        ffTest.monsBattle();
        ffTest.endBattle();
        assertEquals(50, ffTest.getNextLvl());

    }

}