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
public class MonsterTest {
    Monster testMons = new Monster();
    ItemInventory inventTest = new ItemInventory();
    Player charTest = new Player(inventTest);

    public MonsterTest() {
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
    public void testMonsGen(){
        testMons.genMonster(1);

        if(testMons.getName().equalsIgnoreCase("Valefor")){
            assertEquals(250, testMons.getHealth());
            assertEquals(10, testMons.getDamage());
        }

        else if(testMons.getName().equalsIgnoreCase("Ifrit")){
            assertEquals(200, testMons.getHealth());
            assertEquals(25, testMons.getDamage());
        }
        else{
            assertEquals(150, testMons.getHealth());
            assertEquals(30, testMons.getDamage());
        }

    }

    @Test
    public void testMonsterDiff(){
        charTest.setPlayerLvl(2);
        testMons.genMonster(charTest.getPlayerLvl());
        if(testMons.getName().equalsIgnoreCase("Valefor")){
            assertEquals(350, testMons.getHealth());
            assertEquals(20, testMons.getDamage());
        }
        
        else if(testMons.getName().equalsIgnoreCase("Ifrit")){
            assertEquals(300, testMons.getHealth());
            assertEquals(35, testMons.getDamage());
        }
        else{
            assertEquals(250, testMons.getHealth());
            assertEquals(40, testMons.getDamage());
        }
        //Test when char level is at 4
        charTest.setPlayerLvl(4);
        testMons.genMonster(charTest.getPlayerLvl());
        if(testMons.getName().equalsIgnoreCase("Valefor")){
            assertEquals(550, testMons.getHealth());
            assertEquals(40, testMons.getDamage());
        }

        else if(testMons.getName().equalsIgnoreCase("Ifrit")){
            assertEquals(500, testMons.getHealth());
            assertEquals(55, testMons.getDamage());
        }
        else{
            assertEquals(450, testMons.getHealth());
            assertEquals(60, testMons.getDamage());
        }
        
    }

    @Test
    public void testBossGen(){
        testMons.bossMonster();
        assertEquals(5000, testMons.getHealth());
        assertEquals(100, testMons.getDamage());

    }

}