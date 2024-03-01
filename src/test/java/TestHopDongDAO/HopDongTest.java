package TestHopDongDAO;
import TroViet.DAO.HopDongDAO;
import TroViet.Model.HopDongEntity;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import java.sql.SQLException;
import java.util.Date;
public class HopDongTest {
	HopDongDAO hopDongDao = new HopDongDAO();
	@Test
	public void testTaoHopDong() throws SQLException {
		HopDongEntity hopDong = new HopDongEntity();
		hopDong.setIdMaPhongTro(11);
		hopDong.setIdNguoiDung(5);
		hopDong.setNgayBatDauThue("2024-01-01");
		hopDong.setNgayKetThucThue("2024-01-02");
		hopDong.setTienDatCoc(1000000);
		hopDong.setGiaPhong(678);
		hopDong.setGiaDien(600);
		hopDong.setGiaNuoc(600);
		hopDong.setGiaInternet(100);
		hopDong.setGiaRac(120);
		hopDong.setTrash(1);
		HopDongEntity savedHopDong = hopDongDao.saveEntity1(hopDong);
		assertNotNull(savedHopDong);
	}
	@Test
	public void testUpdateHopDong() throws SQLException {
		Long id = (long) 15;
		HopDongEntity hopDong = hopDongDao.get(id);
		hopDong.setGiaRac(500);
		hopDongDao.updateOrderById(hopDong);
		HopDongEntity updatedHopDong = hopDongDao.get(id);
		assertNotNull("HopDong should not be null", updatedHopDong);
		assertEquals(500, updatedHopDong.getGiaRac(), 0.01);
	}
	@Test
	public void testDeleteHopDong() throws SQLException {
		Long id = (long) 15;
		hopDongDao.deleteFromRecycle(id);
		HopDongEntity deletedHopDong = hopDongDao.get(id);
		assertEquals(0, deletedHopDong.getTrash());
	}
}
