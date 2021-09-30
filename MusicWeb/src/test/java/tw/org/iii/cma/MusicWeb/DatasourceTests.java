package tw.org.iii.cma.MusicWeb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatasourceTests {
	@Test
	void contextLoads() {
	}

	@Autowired
	private DataSource dataSource;

	@Test
	public void testDataSource() throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from memberinfo");
		ResultSet rset = stmt.executeQuery();

		while (rset.next())
		{
			int id = rset.getInt("memberId");
			String name = rset.getString("account");
			System.out.println(id + ":" + name);
		}
		rset.close();
		stmt.close();
		conn.close();

	}
}