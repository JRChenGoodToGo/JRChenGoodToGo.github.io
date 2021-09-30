package tw.org.iii.cma.MusicWeb.C.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.org.iii.cma.MusicWeb.C.dao.TagInfoDAO;
import tw.org.iii.cma.MusicWeb.C.dao.TagInfoDAOHibernate;
import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TagInfoService {
	@Autowired
	private TagInfoDAO tagInfoDao;
	public TagInfoService(TagInfoDAO tagInfoDao) {
		this.tagInfoDao = tagInfoDao;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		TagInfoService tagInfoService = new TagInfoService(new TagInfoDAOHibernate(sessionFactory));
//		
////		Object tagIdFind = tagInfoService.findTagId("甘蔗人");
////		System.out.println(tagIdFind);
//		
////		TagInfoBean tagData = tagInfoService.findTagData("甘蔗人");
////		System.out.println(tagData);
//		
////		List<TagInfoBean> tagList = tagInfoService.listTagByRange(0, 1);
////		System.out.println(tagList);
//		
////		Object count = tagInfoService.countAllTag();
////		System.out.println(count);
//		
////		TagInfoBean insertObj = new TagInfoBean();
////		insertObj.setTagName("電音");
////		TagInfoBean resultInsert = tagInfoService.insertTag(insertObj);
////		System.out.println(resultInsert);
//		
////		TagInfoBean updateObj = new TagInfoBean();
////		updateObj.setTagName("榨乾人");
////		tagInfoService.updateTagName("甘蔗人", updateObj);
//		
//		boolean resultUdt = tagInfoService.deleteTag("電音");
//		System.out.println(resultUdt);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.closeSessionFactory();
//	}

	public TagInfoBean select(Integer id) {
		if(id!=null) {
			return tagInfoDao.select(id);
		}
		return null;
	}
	
	public Object findTagId(String tagName) {
		if(tagName != null) {
			TagInfoBean tagData = tagInfoDao.selectByTagName(tagName);
			if(tagData != null) {
				return tagData.getTagId();
			}
		}
		return null;
	}
	public TagInfoBean findTagData(String tagName) {
		if(tagName != null) {
			return tagInfoDao.selectByTagName(tagName);
		}
		return null;
	}
	public List<TagInfoBean> listTagByRange(Integer start, Integer total){
		if(start != null && total != null) {
			return tagInfoDao.select(start, total);
		}
		return null;
	}
	public Object countAllTag() {
		return tagInfoDao.countTotal();
	}
	public TagInfoBean insertTag(TagInfoBean bean) {
		if(bean != null) {
			return tagInfoDao.insert(bean);
		}
		return null;
	}
	public TagInfoBean updateTagName(String tagName, TagInfoBean newBean) {
		if(tagName != null && newBean != null) {
			return tagInfoDao.update(tagName, newBean);
		}
		return null;
	}
	public boolean deleteTag(String tagName) {
		if(tagName != null) {
			return tagInfoDao.delete(tagName);
		}
		return false;
	}
	public Object findIdentifier(String tagName) {
		if(tagName != null) {
			return tagInfoDao.findIdentifierByTagName(tagName);
		}
		return null;
	}
}
