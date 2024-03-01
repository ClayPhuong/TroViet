package TestKhuVucDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import TroViet.Connect.SQL_Connection;

import TroViet.DAO.KhuVucDAO;
import TroViet.Model.KhuVuc;
import junit.framework.Assert;

public class TestSua {
	KhuVucDAO kvd = new KhuVucDAO();
	Connection con =SQL_Connection.con;
	int id=5;
	String tenKhuVuc="Khu Vip Sua";
	int tang=2;
	int day=1;
	
	@Test
	public void testSua() {
		KhuVuc kv= new KhuVuc(id, tenKhuVuc, tang, day);
		try {
			kvd.updateKVByID(kv);
	        String query = "select TenKhuVuc * from KhuVuc where id=5;";
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        String nameAfterupdate=rs.getString(1);        
            assertEquals(tenKhuVuc, nameAfterupdate);

	    } catch (SQLException e) {
	
	    }
	}
	@Test
	public void testSua1() {
		KhuVuc kv1= new KhuVuc(1111, tenKhuVuc, tang, day);
			try {
				System.out.println(kvd.updateKVByID(kv1));
				 assertTrue(kvd.updateKVByID(kv1) == -1);
			} catch (Exception e) {
					e.printStackTrace();
			}	
			
	}

	
}