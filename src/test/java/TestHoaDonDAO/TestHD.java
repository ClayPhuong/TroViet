package TestHoaDonDAO;
import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import org.junit.Test;
import TroViet.DAO.HoaDonDAO;
import TroViet.DAO.HoaDonEnum;
import TroViet.DAO.HopDongDAO;
import TroViet.Model.HoaDon;

public class TestHD {
	HoaDonDAO hoaDonDAO = new HoaDonDAO();
	HopDongDAO hopDongDAO = new HopDongDAO();
	@Test
	public void testCheckIDHD() {
		long idhopDong = 1;
		String ngayBD = "2023-11-01";
		String ngayKT = "2023-11-15";
		float soDienCu = 452;
		float soDienMoi = 480;
		float soNuocCu = 47;
		float soNuocMoi = 66;
		float no = 0;
		float khauTru = 0;
		float giaPhong = 2000000;
		float tongCong = ((soDienMoi - soDienCu) * 3000) + ((soNuocMoi - soNuocCu) * 17000) + 150000 + 30000 + no
				- khauTru + giaPhong;
		try {
			boolean expectedResult = true;
			boolean result = hopDongDAO.isHopDongExists(idhopDong);
			assertEquals(expectedResult, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCheckIDHD2() {
		long idhopDong = 1000;
		String ngayBD = "2023-11-01";
		String ngayKT = "2023-11-15";
		float soDienCu = 452;
		float soDienMoi = 480;
		float soNuocCu = 47;
		float soNuocMoi = 66;
		float no = 0;
		float khauTru = 0;
		float giaPhong = 2000000;
		float tongCong = ((soDienMoi - soDienCu) * 3000) + ((soNuocMoi - soNuocCu) * 17000) + 150000 + 30000 + no
				- khauTru + giaPhong;
		boolean expectedResult = false;
		try {
			boolean result = hopDongDAO.isHopDongExists(idhopDong);
			assertEquals(expectedResult, result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testThemHoaDon() {
		long idhopDong = 1;
		String ngayBD = "2023-11-01";
		String ngayKT = "2023-11-15";
		float soDienCu = 452;
		float soDienMoi = 480;
		float soNuocCu = 47;
		float soNuocMoi = 66;
		float no = 0;
		float khauTru = 0;
		float giaPhong = 2000000;
		float tongCong = ((soDienMoi - soDienCu) * 3000) + ((soNuocMoi - soNuocCu) * 17000) + 150000 + 30000 + no
				- khauTru + giaPhong;

		HoaDon hoaDon = new HoaDon(idhopDong, ngayBD, ngayKT, soDienCu, soDienMoi, soNuocCu, soNuocMoi, khauTru, no,
				tongCong, ngayKT, null, null, null, 0, HoaDonEnum.Unpaid);
		boolean expectedResult = true;
		boolean result;
		try {
			hoaDonDAO.add(hoaDon);
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		assertEquals(expectedResult, result);
	}
	@Test
	public void testSuaHoaDon() throws SQLException {
		long idhopDong = 1;
		HoaDon hoaDon = hoaDonDAO.get(idhopDong);
		hoaDon.setNgaySua("2023-11-22");
		hoaDon.setNguoiSua("Phương Vũ");
		hoaDon.setStatus(HoaDonEnum.Paid);
		boolean expectedResult = true;
		boolean result;
		if (hoaDon != null) {
			if (hoaDonDAO.updateByID(hoaDon) > 0) {
				result = true;
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		assertEquals(expectedResult, result);
	}
	@Test
	public void testXoaHD() {
		Long id = (long) 13;
		boolean expectedResult = true;
		boolean result;
		try {
			hoaDonDAO.deleteById(id);
			result = true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		}
		assertEquals(expectedResult, result);
	}
}
