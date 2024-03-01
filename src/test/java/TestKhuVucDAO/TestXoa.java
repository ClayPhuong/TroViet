package TestKhuVucDAO;
import static org.junit.Assert.fail;
import java.sql.Connection;
import org.junit.Test;
import TroViet.Connect.SQL_Connection;
import TroViet.DAO.KhuVucDAO;
public class TestXoa {
	Connection con = SQL_Connection.con;
	KhuVucDAO kvd = new KhuVucDAO();
	int id=12;
	@Test
    public void testXoa() {
			try {
				kvd.deleteKVById(id);
			} catch (Exception e) {
	            e.printStackTrace();
			}
    }
	@Test
    public void testXoa1() {
		int id2=1111;
			try {
				kvd.deleteKVById(id2);
			} catch (Exception e) {
		        e.printStackTrace();
		        fail("Exception was thrown: " + e.toString());
			}
    }
}
