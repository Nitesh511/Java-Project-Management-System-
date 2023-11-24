package JavaTesting;
import System.Hlogin;
import System.Hregister;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.sql.ResultSet;
import org.junit.Before;
import org.junit.Test;
public class testing {
    Hlogin obj;
    Modulesetget setget;
    Staff_Registration sf;
    Admins hd;
  
  
  
     
    @Before
    public void setUp() {
        obj = new Hlogin();
        sf= new Hregister();
        hd=new Admins();
    }
    @Test
    public void test_getDoctors() {
        boolean actual = obj.LoginUser("avishek","123","Doctor");
        assertTrue(actual);
    }
    @Test
    public void test_register() {
        boolean actual=sf.registration12("avishek", "khadka", "avid", "avi@gmail.com", "123", "Doctor");
        assertTrue(actual);
    }
  
    @Test
    public void test_load_table() {
        boolean actual=hd.update_patient_tabel();
        assertTrue(actual);
    }
  
}