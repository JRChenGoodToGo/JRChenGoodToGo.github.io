package tw.org.iii.cma.MusicWeb.C.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;

public interface TagInfoDAO {

	public abstract TagInfoBean select(Integer id);
	public abstract List<TagInfoBean> select(Integer start, Integer total);
	public abstract TagInfoBean selectByTagName(String tagName);
	public abstract Object countTotal();
	public abstract TagInfoBean insert(TagInfoBean bean);
	public abstract TagInfoBean update(String tagName, TagInfoBean newBean);
	public abstract boolean delete(String tagName);
	public abstract Object findIdentifierByTagName(String tagName);
}
