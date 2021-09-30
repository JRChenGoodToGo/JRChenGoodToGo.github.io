package tw.org.iii.cma.MusicWeb.C.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;

@Repository
public class TagInfoDAOHibernate implements TagInfoDAO{
	@PersistenceContext
	private Session session;
//	public TagInfoDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	public Session getSession() {
		return session;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		TagInfoDAO tagInfo = new TagInfoDAOHibernate(sessionFactory);
//// r1		
////		TagInfoBean selectOne = tagInfo.select(1);
////		System.out.println(selectOne);
//		
//// r2		
////		List<TagInfoBean> selectSeveral = tagInfo.select(0, 3);
////		System.out.println(selectSeveral);
//		
//// r3		
////		TagInfoBean selectKey = tagInfo.findFullWord("管弦樂");
////		System.out.println(selectKey);
//		
//// r4		
////		Object count = tagInfo.countTotal();
////		System.out.println(count);
//		
//// r5		
////		TagInfoBean insertObj = new TagInfoBean();
////		insertObj.setTagName("9m");
////		TagInfoBean resultInsert = tagInfo.insert(insertObj);
////		System.out.println(resultInsert);
//		
//// r6		
////		TagInfoBean updateObj = new TagInfoBean();
////		updateObj.setTagName("甘蔗人");
////		TagInfoBean resultUdt = tagInfo.update("今夏下", updateObj);
////		System.out.println(resultUdt);
//		
//// r7		
////		boolean deleteObj = tagInfo.delete(5);
////		System.out.println(deleteObj);
//		
//// r8
////		Object identifierFound = tagInfo.findIdentifierByTagName("榨乾人");
////		System.out.println(identifierFound);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		sessionFactory.getCurrentSession().close();
//		HibernateUtil.closeSessionFactory();
//	}

	@Override
	public TagInfoBean select(Integer id) {
		if(id != null) {
			TagInfoBean r1 = this.getSession().get(TagInfoBean.class, id);
			if(r1 != null) {
				return r1;
			}
		}
		return null;
	}

	@Override
	public List<TagInfoBean> select(Integer start, Integer total) {
		if(start != null && total != null) {
			List<TagInfoBean> r2 = this.getSession().createQuery("FROM TagInfoBean ORDER BY tagId", TagInfoBean.class)
				.setFirstResult(start)
				.setMaxResults(total)
				.list();
			return r2;
		}
		return null;
	}

	@Override
	public TagInfoBean selectByTagName(String tagName) {
		if(!tagName.isBlank() && !tagName.isEmpty() && tagName != null) {
			System.out.println("tagName not null!");
//			List<String> data = new ArrayList<String>();
//			data.add(fullWord); 
//			System.out.println("data = " + data);
//			List<TagInfoBean> r3 = this.getSession().createQuery("FROM TagInfoBean WHERE tagName in :names", TagInfoBean.class)
//				.setParameterList("names", data)
//				.list();
			TagInfoBean r3 = this.getSession().createQuery("FROM TagInfoBean WHERE tagName = :tagName", TagInfoBean.class)
				.setParameter("tagName", tagName)
				.uniqueResult();
			return r3;
		}
		return null;
	}

	@Override
	public Object countTotal() {
		Object r4 = this.getSession().createQuery("SELECT count(*) FROM TagInfoBean").uniqueResult();
		return r4;
	}

	@Override // r5
	public TagInfoBean insert(TagInfoBean bean) {
		if(bean != null && bean.getTagName() != null) {
			Serializable pk = this.getSession().save(bean);
			System.out.println(pk);
			return bean;
		}
		return null;
	}

	@Transactional
	@Override
	public TagInfoBean update(String tagName, TagInfoBean newBean) {
		if(tagName != null && newBean != null) {
			TagInfoBean r6 = this.getSession().createQuery("FROM TagInfoBean WHERE tagName = :tagName", TagInfoBean.class)
				.setParameter("tagName", tagName)
				.uniqueResult();
			if(r6 != null) {
				newBean.setTagId(r6.getTagId());
				return (TagInfoBean) this.getSession().merge(newBean);
			}
		}
		return null;
	}
	
	@Override
	public boolean delete(String tagName) {
		if(tagName != null) {
			TagInfoBean r7 = this.getSession().createQuery("FROM TagInfoBean WHERE tagName = :tagName", TagInfoBean.class)
				.setParameter("tagName", tagName)
				.uniqueResult();
			if(r7 != null) {
				this.getSession().delete(r7);
				return true;
			}
		}
		return false;
	}
	@Override
	public Object findIdentifierByTagName(String tagName) {
		if(tagName != null && !tagName.isEmpty()) {
			Object r8 = this.getSession().createQuery("SELECT tagId FROM TagInfoBean WHERE tagName = :tagName")
					.setParameter("tagName", tagName)
					.uniqueResult();
				return r8;
		}
		return null;
	}

}
