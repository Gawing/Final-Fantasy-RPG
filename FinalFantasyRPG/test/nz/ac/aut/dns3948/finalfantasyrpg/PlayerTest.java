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
public class PlayerTest {
    ItemInventory testInvent = new ItemInventory();
    Player testPlayer = new Player(testInvent);

    public PlayerTest() {
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
    public void testGenBladesmen(){
        testPlayer.setType("bladesman");
        testPlayer.assignAttribute();
        assertEquals(200, testPlayer.getHealth());
        assertEquals(50, testPlayer.getDamage());
        assertEquals(10, testPlayer.getMP());
        assertEquals(5, testPlayer.getMagicStr());

    }

    @Test
    public void testGenSpellcaster(){
        testPlayer.setType("spellcaster");
        testPlayer.assignAttribute();
        assertEquals(120, testPlayer.getHealth());
        assertEquals(25, testPlayer.getDamage());
        assertEquals(30, testPlayer.getMP());
        assertEquals(20, testPlayer.getMagicStr());

    }

    @Test
    public void testGenHybrid(){
        testPlayer.setType("hybrid");
        testPlayer.assignAttribute();
        assertEquals(100, testPlayer.getHealth());
        assertEquals(50, testPlayer.getDamage());
        assertEquals(15, testPlayer.getMP());
        assertEquals(20, testPlayer.getMagicStr());

    }
    @Test
    public void testDisplayStats(){
        testPlayer.setName("Test");
        testPlayer.setType("bladesman");
        testPlayer.assignAttribute();
        assertEquals("Test,bladesman,200,10,50,5,1,200", testPlayer.toString());

    }

    @Test
    public void testResetLvl(){
        testPlayer.setPlayerLvl(2);
        testPlayer.resetlvl();
        assertEquals(400,testPlayer.getNextLvl());
    }

    @Test
    public void testIncreaseBlademansLvl(){
        testPlayer.setType("bladesman");
        testPlayer.assignAttribute();
        testPlayer.setNextLvl(0);
        testPlayer.incPlaylvl();
        assertEquals(300, testPlayer.getHealth());
        assertEquals(80, testPlayer.getDamage());
        assertEquals(15, testPlayer.getMagicStr());
        assertEquals(20, testPlayer.getMP());
        assertEquals(2, testPlayer.getPlayerLvl());
        assertEquals(400, testPlayer.getNextLvl());

    }

    @Test
    public void testIncreaseSpellcasterLvl(){
        testPlayer.setType("spellcaster");
        testPlayer.assignAttribute();
        testPlayer.setNextLvl(0);
        testPlayer.incPlaylvl();
        assertEquals(170, testPlayer.getHealth());
        assertEquals(35, testPlayer.getDamage());
        assertEquals(40, testPlayer.getMagicStr());
        assertEquals(50, testPlayer.getMP());
        assertEquals(2, testPlayer.getPlayerLvl());
        assertEquals(400, testPlayer.getNextLvl());
    }

    @Test
    public void testIncreaseHybridLvl(){
        testPlayer.setType("hybrid");
        testPlayer.assignAttribute();
        testPlayer.setNextLvl(0);
        testPlayer.incPlaylvl();
        assertEquals(175, testPlayer.getHealth());
        assertEquals(75, testPlayer.getDamage());
        assertEquals(35, testPlayer.getMagicStr());
        assertEquals(30, testPlayer.getMP());
        assertEquals(2, testPlayer.getPlayerLvl());
        assertEquals(400, testPlayer.getNextLvl());
    }

}