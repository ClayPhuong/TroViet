package TestPhongTroDAO;
import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;
import TroViet.DAO.PhongTroDAO;
import TroViet.Model.PhongTro;
public class PhongTrotest {
	PhongTroDAO phongTroDao = new PhongTroDAO();
	@Test
	public void testThemPhongTro() throws SQLException {
		PhongTro pt = new PhongTro();
		pt.setIdMaloaiphong(10);
		pt.setIdNguoidung(25);
		pt.setIdKhuvuc(4);
		pt.setTenphong("Phòng đôi 1222");
		pt.setDientich(34);
		pt.setGiaphong(3000000);
		pt.setDiachi("Bình Thạnh, HCM q12");
		pt.setMota("Phòng có 2 phòng nhỏ, nhà vệ sinh riêng, có bếp 111");
		pt.setTrash(1);
		PhongTro savePhongTro = phongTroDao.save(pt);
		assertNotNull(savePhongTro);
	}
	@Test
	public void testUpdatePhongTro() throws SQLException {
		Long id = (long) 10;
		PhongTro phongTro = phongTroDao.get(id);
		phongTro.setDientich(15);
		phongTroDao.update(phongTro);
		PhongTro updatePhongTro = phongTroDao.get(id);
		assertNotNull("Phong Tro không nên rỗng", updatePhongTro);
		assertEquals(15, updatePhongTro.getDientich(), 0.01);
	}
	@Test
	public void testDeletePhongTro() throws SQLException {
		long id = (long) 8;
		phongTroDao.deleteFromRecycle(id);
		PhongTro deletedPhongTro = phongTroDao.get(id);
		assertEquals(0, deletedPhongTro.getTrash());
	}
}
