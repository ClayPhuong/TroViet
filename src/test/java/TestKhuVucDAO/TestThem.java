package TestKhuVucDAO;
import static org.junit.Assert.fail;

import org.junit.Test;

import TroViet.DAO.KhuVucDAO;
import TroViet.Model.KhuVuc;
public class TestThem {
	KhuVucDAO kvd = new KhuVucDAO();
	@Test
	public void testthem() {
		KhuVuc kv= new KhuVuc(1,"Khu Vực Vip",4,3);
		try {
			kvd.saveKV(kv);
			fail("Expected an exception, but it was successful");
		} catch (Exception e) {
			System.out.println("loi ce");
		}
		
	}
}
