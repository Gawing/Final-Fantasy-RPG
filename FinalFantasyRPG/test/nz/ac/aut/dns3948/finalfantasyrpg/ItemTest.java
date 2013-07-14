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
public class ItemTest {

    public ItemTest() {
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
    public void testItemGen() {
       Item testItem = new Item();
       boolean itemName = false;
        if(testItem.getName().equalsIgnoreCase("Potion") || testItem.getName().equalsIgnoreCase("MagicStone") || testItem.getName().equalsIgnoreCase("UltimaStone")){
            itemName = true;
        }
       assertTrue(itemName);
      
    }

}