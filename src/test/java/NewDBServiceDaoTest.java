import java.util.List;

import org.junit.Test;

import com.gxq.learn.extractor.dao.DBServiceDao;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class NewDBServiceDaoTest {

	@Test
	public final void test() {
		DBServiceDao dao = new DBServiceDao();
		List<Object[]> list = dao.getAllByArray("select * from person");
		for(Object obj : list) {
			Array[] arr = (Array[]) obj;
			for(String str : arr) {
				System.out.print(str +" ");
			}
			System.out.println();
		}
	}

}
