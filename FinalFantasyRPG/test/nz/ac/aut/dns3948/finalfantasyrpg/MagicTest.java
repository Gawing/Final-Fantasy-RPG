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
public class MagicTest {
    ItemInventory inventTest = new ItemInventory();
    Player charTest = new Player(inventTest);
    Magic magicTest;

    public MagicTest() {
        charTest.setType("Spellcaster");
        charTest.assignAttribute();
        magicTest = new Magic(charTest, charTest.getMP(), false);
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
     * Test of magicMenu method, of class Magic.
     */
    @Test
    public void testConfirmMagicUse(){
        magicTest.useMagic("Ice");
        assertTrue(magicTest.getConfirmDmg());
        assertTrue(magicTest.getConfirmMag());

    }

    @Test
    public void testDenyMagicUse(){
        magicTest.useMagic("Ultima");
        assertFalse(magicTest.getConfirmDmg());
        assertFalse(magicTest.getConfirmMag());

    }

    @Test
    public void testUseElemental(){
        magicTest.useMagic("Light");
        assertEquals(25, magicTest.getPlayerMP());

    }

    @Test
    public void testUseHoly(){
        magicTest.useHoly();
        assertEquals(10, magicTest.getPlayerMP());

    }

    @Test
    public void testUseUltima(){
        magicTest = new Magic(charTest, 120, false);
        magicTest.useUltima();
        assertEquals(20, magicTest.getPlayerMP());

    }


    @Test
    public void testSpellcasterOD(){

        magicTest = new Magic(charTest, charTest.getMP(), true);
        assertTrue(magicTest.spellOverdrive());
        magicTest.useElemental("fire");
        assertEquals(1,magicTest.getMpCost());
        magicTest.useHoly();
        assertEquals(1,magicTest.getMpCost());
        magicTest.useUltima();
        assertEquals(1,magicTest.getMpCost());


    }


   

}