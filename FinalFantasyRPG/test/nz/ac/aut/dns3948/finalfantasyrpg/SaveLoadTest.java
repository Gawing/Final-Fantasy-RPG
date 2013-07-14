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
 * @author Gawing
 */
public class SaveLoadTest {

    FinalFantasyRPG ffTest = new FinalFantasyRPG();
    ItemInventory inventTest = new ItemInventory();
    Player charTest = new Player(inventTest);
    SaveLoad testTxt;

    public SaveLoadTest() {
        testTxt = new SaveLoad(ffTest);
        charTest.setName("Test");
        charTest.setType("bladesman");
        charTest.assignAttribute();


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

   /**
    * Test of saveGame method, of class SaveLoad.
    */
    @Test
    public void testSaveGame() throws Exception {
        testTxt.saveGame(charTest);
        testTxt.listDir();
        assertTrue(testTxt.confirmSave());
    }
   

   /**
    * Test of loadGame method, of class SaveLoad.
    */
    @Test
    public void testLoadGame() {
        testTxt.loadGame("Test");
        assertTrue(testTxt.confirmLoad());
        assertEquals("Test,bladesman,200,10,50,5,1,200", ffTest.charString());
    
    }

}