package Topic4;

import java.util.ArrayList;
import java.util.List;

import Notifications.Manager;
import Products.Item;
import Products.Offer;
import Products.Product;
import Products.ProductFactory;
import Services.UserService;
import Shop.ShoppingCart;
import Transactions.TransactionFactory;
import Users.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    			
    			UserService us= new UserService();
    			
    			//Create a User
    			us.CreateUser("martin izquierdo","izqmartin","1234",5432,"izqmartin_88@hotmail.com");
    			//Create a shopping cart
    			us.CreateShoppingCart();
    			Item item= new Item("LEDtv", 100);
    			//insert items to a shopping cart
    			us.UpdateShoppingCart(item, "INSERT");
    			us.UpdateShoppingCart(item, "INSERT");
    			System.out.println(us.ReadShoppingCart().getItemList());
    			//delete items to a shopping cart
    			us.UpdateShoppingCart(item, "DELETE");
    			System.out.println(us.ReadShoppingCart().getItemList());
    			//make transaction
    			us.CreateTransaction("CREDIT_CARD");
    			
    			
    			//create a new user
    			UserService us1= new UserService();
    			us1.CreateUser("marco ciotola","mvccool","4321",654321,"mvccool@hotmail.com");
      			//add the second user like friend 
    			us.addFriend(us1.ReadUser());
    			//upload photo
    			us.uploadPhoto("https://pbs.twimg.com/media/B8nt2GFCUAA7DMN.jpg");
    			System.out.println(us.ReadUser());
    			// mvccool like martin photo
    			us.likePhoto("https://pbs.twimg.com/media/B8nt2GFCUAA7DMN.jpg", "mvccool");
    			System.out.println(us.ReadUser());
    			
    			
    }
}
