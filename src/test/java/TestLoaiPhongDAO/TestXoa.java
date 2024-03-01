package TestLoaiPhongDAO;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import TroViet.Connect.SQL_Connection;
import TroViet.DAO.LoaiPhongDAO;

public class TestXoa {
	Connection con = SQL_Connection.con;
	LoaiPhongDAO lpd = new LoaiPhongDAO();
	@Test
	public void testXoa() {
		int idtest = 11;
		try {
			lpd.deleteLPById(idtest);
		} catch (SQLException e) {
			fail("fail test");
		}
	}
	@Test(expected = SQLException.class)
	public void testXoa1() throws SQLException {
		int idtest = 10;
		lpd.deleteLPById(idtest);
	}
}
