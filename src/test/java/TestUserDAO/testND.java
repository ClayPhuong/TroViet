package TestUserDAO;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import TroViet.DAO.UserDAO;
import TroViet.Model.UserEntity;
public class testND {
	UserDAO userDao = new UserDAO();
	long id = 2;
	@Test
	public void testthemND() {
		try {
			userDao.saveAccountToDatabase("Sang", "123456789", "sang@gmail.com", "Bình dương", "123", "user");
			fail("Expected an SQLException, but it was successful");
		} catch (Exception e) {
			System.out.println("SQLException occurred, as expected");
		}
	}
	@Test
	public void testxoaND() {
		try {
			userDao.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Test
	public void testsuaND() throws SQLException {
		long id = (long) 2;
		UserEntity user = userDao.get(id);
		user.setHoTen("Toan");
		userDao.SuaND(user);
		UserEntity updateuser = userDao.get(id);
		assertNotNull("Phong Tro không nên rỗng", updateuser);
	}
}
