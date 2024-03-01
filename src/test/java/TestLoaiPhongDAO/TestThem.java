package TestLoaiPhongDAO;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import TroViet.Connect.SQL_Connection;
import TroViet.DAO.KhuVucDAO;
import TroViet.DAO.LoaiPhongDAO;
import TroViet.Model.LoaiPhong;

public class TestThem {
	Connection con = SQL_Connection.con;
	LoaiPhongDAO lpd = new LoaiPhongDAO();
	@Test
	public void testThem() {
		int expectResult = 1;
		LoaiPhong lp = new LoaiPhong(7, "phòng nhảm");
		try {
			int actualResualt = lpd.saveLP(lp);
			assertEquals(expectResult, actualResualt);
		} catch (Exception e) {
		}
	}
	@Test
	public void testThem1() {
		LoaiPhong lp = new LoaiPhong(7, "phòng nhảm");
		try {
			int actualResualt = lpd.saveLP(lp);
			assertEquals(0, actualResualt);
		} catch (Exception e) {
		}
	}
}
