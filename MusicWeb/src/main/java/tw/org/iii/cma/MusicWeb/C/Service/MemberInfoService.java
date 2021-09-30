package tw.org.iii.cma.MusicWeb.C.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.org.iii.cma.MusicWeb.C.dao.MemberInfoDAO;
import tw.org.iii.cma.MusicWeb.C.dao.MemberInfoDAOHibernate;
import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;

@Service
@Transactional
public class MemberInfoService {
	@Autowired
	private MemberInfoDAO memberInfoDao;
	
	public MemberInfoService(MemberInfoDAO memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		MemberInfoDAO dao = new MemberInfoDAOHibernate(sessionFactory);
//		MemberInfoService memberInfoService = new MemberInfoService(dao);
//		
////		MemberInfoBean result = memberInfoService.login("accusefive", "123456");
////		System.out.println(result);
//		
////		MemberInfoBean passwdChange = memberInfoService.changePasswd("accusefive", "123456", "123123");
////		System.out.println(passwdChange);
//		
////		MemberInfoBean insert = new MemberInfoBean();
////		insert.setAccount("Ariana");
////		insert.setEmail("ariana@test.t");
////		insert.setPasswd("14412");
////		insert.setName("Arian A");
////		MemberInfoBean register = memberInfoService.register(insert);
////		System.out.println(register);
//		
////		Object allMemberCount = memberInfoService.countAllMember();
////		System.out.println(allMemberCount);
//		
////		boolean memberDelete = memberInfoService.deleteMember("Irish", "456123");
////		System.out.println(memberDelete);
//		
////		List<MemberInfoBean> rangeSelect = memberInfoService.selectRange(1, 3);
////		System.out.println(rangeSelect);
//		 
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//		
//	}
	
	public MemberInfoBean login(String account, String passwd) {
		if(account != null && passwd != null) {
			MemberInfoBean checkData = memberInfoDao.select(account);
			if(checkData != null && checkData.getPasswd().equals(passwd)) {
				System.out.println("login success");
				return checkData;
				
			}
		}
		System.out.println("login fail");
		return null;
	}
	public MemberInfoBean changePasswd(String account, String oldPasswd, String newPasswd) {
		MemberInfoBean checkIdentity = this.login(account, oldPasswd);
		if(checkIdentity != null) {
			return memberInfoDao.update(account, newPasswd);
		}
		return null;
	}
	public MemberInfoBean register(MemberInfoBean bean){ 
		if(bean != null) {
			return memberInfoDao.insert(bean);
		}
		return null;
	}
	public Object countAllMember() {
		return memberInfoDao.countTotal();
	}
	public boolean deleteMember(String account, String passwd) {
		if(account != null) {
			MemberInfoBean checkAccountForDelete = memberInfoDao.select(account);
			if(checkAccountForDelete != null && checkAccountForDelete.getPasswd().equals(passwd)) {
				return memberInfoDao.delete(checkAccountForDelete.getMemberId());
			}
		}
		return false;
	}
	public List<MemberInfoBean> selectRange(Integer start, Integer total){
		if(start != null && total != null) {
			return memberInfoDao.select(start, total);
		}
		return null;
	}
	public boolean isAccountExist(String account) {
		if(account != null && !account.isEmpty()) {
			return memberInfoDao.isAccountExist(account);
		}
		return true;
	}
	
}
