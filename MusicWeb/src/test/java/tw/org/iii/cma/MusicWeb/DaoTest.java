package tw.org.iii.cma.MusicWeb;
//import java.util.List;
//import javax.persistence.PersistenceContext;
//import org.hibernate.Session;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class DaoTest {
//	@Test
//	void contextLoads() {}
//
//	@PersistenceContext
//	private Session session;
//	
//	@Test
//	@Transactional
//	public void testSessionFactory() {
//		
//		List<?> result= session.createNativeQuery("select * from locationinfo").list();
//		for(Object obj: result) { 
//			Object[] arrary= (Object[]) obj;
//			System.out.println(arrary[0]+":"+arrary[1]+":"+arrary[2]);
//		}			
//		
//		System.out.println("--------");
//	
//}
//	}
