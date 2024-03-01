package TestLoaiPhongDAO;
import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import org.junit.Test;
import TroViet.Connect.SQL_Connection;
import TroViet.DAO.LoaiPhongDAO;
import TroViet.Model.LoaiPhong;
public class TestSua {
	Connection con = SQL_Connection.con;
	LoaiPhongDAO lpd = new LoaiPhongDAO();
	@Test
	public void testSua() {
		String tenp = "phong test1";
		int id = 7;
		LoaiPhong lp = new LoaiPhong(id, tenp);
		int expectResult = 1;
		try {
			int actualResualt = lpd.updateLPByID(lp);
			assertEquals(expectResult, actualResualt);
		} catch (Exception e) {
		}
	}
	@Test
	public void testSua1() {
		String tenp = "phong test1123";
		int id = 7123123;
		LoaiPhong lp = new LoaiPhong(id, tenp);
		int expectResult = -1;
		try {
			int actualResualt = lpd.updateLPByID(lp);
			assertEquals(expectResult, actualResualt);
		} catch (Exception e) {
		}
	}
}
