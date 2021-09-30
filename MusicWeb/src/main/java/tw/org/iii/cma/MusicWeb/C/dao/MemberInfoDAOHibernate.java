package tw.org.iii.cma.MusicWeb.C.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;

@Repository
public class MemberInfoDAOHibernate implements MemberInfoDAO{
	@PersistenceContext
	private Session session;
	
//	public MemberInfoDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return session;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		MemberInfoDAO memberInfo = new MemberInfoDAOHibernate(sessionFactory);
//		
//// r1		
////		MemberInfoBean selectObj = memberInfo.select(1);
////		System.out.println(selectObj);
//		
//// r2		
////		List<MemberInfoBean> selectAll = memberInfo.select(1, 3);
////		System.out.println(selectAll);
//		
//// r3		
////		Object count = memberInfo.countTotal();
////		System.out.println(count);
//		
//// r4		
////		MemberInfoBean bean = new MemberInfoBean();
////		bean.setAccount("Vic");
////		bean.setEmail("vic@typical.ww");
////		bean.setName("Vic Yeh");
////		bean.setPasswd("145632");
////		MemberInfoBean insertObj = memberInfo.insert(bean);
////		System.out.println(insertObj);
//		
//
//// r5		
////		boolean deleteObj = memberInfo.delete(23);
////		System.out.println(deleteObj);
//	
//// r6
//		MemberInfoBean selectAccount = memberInfo.select("boy");
//		System.out.println(selectAccount);
//		
//// r7
////		MemberInfoBean result = memberInfo.update("Hushyyyyy", "123456");
////		System.out.println("merge result = " + result);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}

	@Override
	public MemberInfoBean select(Integer id) {
		MemberInfoBean r1 = this.getSession().get(MemberInfoBean.class, id);
		if(id != null && r1.getMemberId() != null) {
			return this.getSession().get(MemberInfoBean.class, id);
		}
		return null;
	}

	@Override
	public List<MemberInfoBean> select(Integer start, Integer total) {
		List<MemberInfoBean> r2 = this.getSession()
					.createQuery("FROM MemberInfoBean", MemberInfoBean.class)
					.setFirstResult(start)
					.setMaxResults(total)
					.list();
		return r2;
	}
	
	@Override
	public Object countTotal() {
		Object r3 = this.getSession().createQuery("SELECT count(*) FROM MemberInfoBean").getSingleResult();
		return r3;
	}

	@Override // r4
	public MemberInfoBean insert(MemberInfoBean bean) {
		if(bean != null 
				&& bean.getAccount() != null && !bean.getAccount().isEmpty()
				&& bean.getEmail() != null && !bean.getEmail().isEmpty() 
				&& bean.getPasswd() != null && !bean.getPasswd().isEmpty() 
				&& bean.getName() != null && !bean.getName().isEmpty()) {
			System.out.println("Yes you can insert");
			Serializable pk = this.getSession().save(bean);
			System.out.println(pk);
			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		if(id != null) {
			MemberInfoBean r5 = this.getSession().get(MemberInfoBean.class, id);
			if(r5 != null) {
				this.getSession().delete(r5);
				return true;
			}
		}
		return false;
	}
	@Override
	public MemberInfoBean select(String account) {
		if(account != null) {
			MemberInfoBean r6 = this.getSession().createQuery("FROM MemberInfoBean WHERE account = :account", MemberInfoBean.class)
				.setParameter("account", account)
				.uniqueResult();
			if(r6 != null) {
				return r6;
			}
		}
		return null;
	}
	@Transactional
	@Override
	public MemberInfoBean update(String account, String newPasswd) {
		if(account != null) {
			System.out.println("start update!");
			MemberInfoBean r7 = this.getSession().createQuery("FROM MemberInfoBean WHERE account = :account", MemberInfoBean.class)
				.setParameter("account", account)
				.uniqueResult();
			if(r7 != null ) {
				System.out.println("start set new Passwd");
				r7.setPasswd(newPasswd);
				return (MemberInfoBean) this.getSession().merge(r7);
			}
		}
		return null;
	}
	@Override
	public boolean isAccountExist(String account) {
		if(account != null && !account.isEmpty()) {
			MemberInfoBean r8 = this.getSession().createQuery("FROM MemberInfoBean WHERE account = :account", MemberInfoBean.class)
				.setParameter("account", account)
				.uniqueResult();
			if(r8 != null) {
				// 帳號已存在
				return true;
			} else {
				// 帳號不存在
				return false;
			}
		}
		return true;
	}
}
