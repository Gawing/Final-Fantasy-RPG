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
public class ItemInventoryTest {
    ItemInventory inventTest = new ItemInventory();
    Item testItem = new Item();

    public ItemInventoryTest() {
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
    public void testAddItem(){
       inventTest.addItem(testItem);
       
       if(testItem.getName().equalsIgnoreCase("Potion")){
           assertEquals(1, inventTest.getPotion());
       }
       else if(testItem.getName().equalsIgnoreCase("MagicStone")){
           assertEquals(1, inventTest.getStone());

       }
       else{
           assertEquals(1, inventTest.getUlti());

       }
       assertTrue(inventTest.hasItem());



    }

    @Test
    public void testUsePotion(){
        inventTest.addItem(testItem);
        inventTest.useItem("Potion");

        if(inventTest.hasItem()){
            assertEquals(0, inventTest.getPotion());
        }
        else{
            assertFalse(inventTest.hasItem());
        }

    }

    @Test
    public void testUseMagicStone(){
        inventTest.addItem(testItem);
        inventTest.useItem("MagicStone");

        if(inventTest.hasItem()){
            assertEquals(0, inventTest.getStone());
        }
        else{
            assertFalse(inventTest.hasItem());
        }
    }
    
    @Test
    public void testUseUltiStone(){
        inventTest.addItem(testItem);
        inventTest.useItem("UltimaStone");

        if(inventTest.hasItem()){
            assertEquals(0, inventTest.getPotion());
        }
        else{
            assertFalse(inventTest.hasItem());
        }
    }

    @Test
    public void testUseInvalidItem(){
        inventTest.useItem("RandomItem");
        assertFalse(inventTest.hasItem());

    }


   

}