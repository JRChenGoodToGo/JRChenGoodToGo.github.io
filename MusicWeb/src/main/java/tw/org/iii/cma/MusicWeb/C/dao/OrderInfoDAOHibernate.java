package tw.org.iii.cma.MusicWeb.C.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.org.iii.cma.MusicWeb.domain.OrderInfoBean;
import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

@Repository
public class OrderInfoDAOHibernate implements OrderInfoDAO {

	@PersistenceContext
	private Session session;
//	public OrderInfoDAOHibernate(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
	
	public Session getSession() {
		return session;
	}
	
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		
//		OrderInfoDAO orderInfo = new OrderInfoDAOHibernate(sessionFactory);
//
////// r1		
////		OrderInfoBean selectOne = orderInfo.select(1);
////		System.out.println(selectOne);
////// r2		
////		Object countNoAcId = orderInfo.countNoActivityId();
////		System.out.println(countNoAcId);
//		
////// r3		
////		List<OrderInfoBean> selectNoAcId = orderInfo.selectNoActivityId();
////		System.out.println(selectNoAcId);
//		
////// r4
////		Object countByAcId = orderInfo.countByActivityId(2);
////		System.out.println(countByAcId);
//	
////// r5
////		List<OrderInfoBean> selectAcId = orderInfo.selectActivityId(2);
////		System.out.println(selectAcId);
//		
////// r6		
////		Object countByMemId = orderInfo.countByMemberId(1);
////		System.out.println(countByMemId);
//		
////// r7		
////		List<OrderInfoBean> selectMemId = orderInfo.selectMemberId(1);
////		System.out.println(selectMemId);
//		
////// r8		
////		Object countTotal = orderInfo.countTotal();
////		System.out.println(countTotal);
//		
////// r9		
////		List<OrderInfoBean> selectAll = orderInfo.selectAll(0, 2);
////		System.out.println(selectAll);
//		
////// r10		
////		OrderInfoBean insertObj = new OrderInfoBean();
////		insertObj.setName("Allen");
////		insertObj.setIdentification("A124577752");
////		insertObj.setEmail("allen@aaa.ss");
////		insertObj.setTicketKind("?????????"); // ??????TicketSetting??????????????????
////		insertObj.setCost(100.0f);
////		insertObj.setPurchaseAmt(3);
////		insertObj.setPayment("Credit");
////		insertObj.setMemberId(10);
////		insertObj.setActivityId(3); // ??????TicketSetting??????????????????
////		OrderInfoBean insertResult = orderInfo.insert(insertObj);
////		System.out.println(insertResult);
//		
////// r11		
////		Object orderIdByOption = orderInfo.findOrderIdByOption(3, "?????????", "N123456852");
////		System.out.println(orderIdByOption);
//		
////// r12
////		OrderInfoBean updateObjByOrderId = new OrderInfoBean();
////		updateObjByOrderId.setOrderId(6);
////		updateObjByOrderId.setName("Hank");
////		updateObjByOrderId.setEmail("hank@board.tw");
////		updateObjByOrderId.setActivityId(2);
////		updateObjByOrderId.setCost(200f);
////		OrderInfoBean updateResult = orderInfo.update(updateObjByOrderId);
////		System.out.println(updateResult);
//		
////// r13		
////		OrderInfoBean updateObj = new OrderInfoBean();
////		updateObj.setActivityId(2);
////		updateObj.setMemberId(10);
////		updateObj.setName("Lulu");
////		updateObj.setEmail("lulu@ddd");
//////		updateObj.setPayment("Cash");
////		updateObj.setIdentification("A124577752");
////		updateObj.setTicketKind("?????????");
////		updateObj.setPurchaseAmt(3);
////		OrderInfoBean updateResult = orderInfo.update(null, updateObj);
////		System.out.println(updateResult);
//		
////// r14		
////		boolean deleteResult = orderInfo.delete(8);
////		System.out.println(deleteResult);
//		
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		sessionFactory.getCurrentSession().close();
//		HibernateUtil.closeSessionFactory();
//	}

	@Override
	public OrderInfoBean select(Integer id) {
		if(id != null) {
			OrderInfoBean r1 = this.getSession().get(OrderInfoBean.class, id);
			if(r1 != null) {
				return r1;
			}
		}
		return null;
	}
	@Override
	public Object countNoActivityId() {
		Object r2 = this.getSession().createQuery("SELECT count(*) FROM OrderInfoBean WHERE activityId IS NULL")
						.uniqueResult();
		if(r2 != null) {
			return r2;
		}
		return null;
	}

	@Override
	public List<OrderInfoBean> selectNoActivityId() {
		List<OrderInfoBean> r3 = this.getSession().createQuery("FROM OrderInfoBean WHERE activityId IS NULL", OrderInfoBean.class)
									.list();
		if(r3 != null) {
			return r3;
		}
		return null;
	}

	@Override
	public Object countByActivityId(Integer activityId) {
		if(activityId != null) {
			 Object r4 = this.getSession().createQuery("SELECT count(*) FROM OrderInfoBean WHERE activityId = :activityId")
					 .setParameter("activityId", activityId)
				.uniqueResult();
			 if(r4 != null) {
				 return r4;
			 }
		}
		return null;
	}

	@Override
	public List<OrderInfoBean> selectActivityId(Integer activityId) {
		if(activityId != null) {
			List<OrderInfoBean> r5 = this.getSession().createQuery("FROM OrderInfoBean WHERE activityId = :activityId", OrderInfoBean.class)
						.setParameter("activityId", activityId)
						.list();
			if(r5 != null) {
				return r5;
			}
		}

		return null;
	}

	@Override
	public Object countByMemberId(Integer memberId) {
		if(memberId != null) {
			Object r6 = this.getSession().createQuery("SELECT count(*) FROM OrderInfoBean WHERE memberId = :memberId")
				.setParameter("memberId", memberId)
				.uniqueResult();
			if(r6 != null) {
				return r6;
			}
		}
		return null;
	}

	@Override
	public List<OrderInfoBean> selectMemberId(Integer memberId) {
		if(memberId != null) {
			List<OrderInfoBean> r7 = this.getSession().createQuery("FROM OrderInfoBean WHERE memberId = :memberId", OrderInfoBean.class)
				.setParameter("memberId", memberId)
				.list();
			if(r7 != null) {
				return r7;
			}
		}
		return null;
	}

	@Override
	public Object countTotal() {
		Object r8 = this.getSession().createQuery("SELECT count(*) FROM OrderInfoBean")
			.uniqueResult();
		if(r8 != null) {
			return r8;
		}
		return null;
	}

	@Override
	public List<OrderInfoBean> selectAll(Integer start, Integer total) {
		if(start!=null && total!=null) {
			List<OrderInfoBean> r9 = this.getSession().createQuery("FROM OrderInfoBean", OrderInfoBean.class)
				.setFirstResult(start)
				.setMaxResults(total)
				.list();
			if(r9 != null) {
				return r9;
			}
		}
		return null;
	}

	@Transactional
	@Override
	public OrderInfoBean insert(OrderInfoBean bean) { // ?????????????????????????????????????????????????????????????????????????????????
		if(bean != null && bean.getIdentification()!=null && !bean.getIdentification().isEmpty() 
					&& bean.getTicketKind()!=null && !bean.getTicketKind().isEmpty() 
					&& bean.getActivityId()!=null 
					&& (((bean.getName()!=null && !bean.getName().isEmpty()) 
					|| bean.getMemberId()!=null))) {
			// ????????????????????????????????????
			System.out.println("prepare insert");
			TicketSettingBean ticketInfo = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId = :activityId AND ticketKind = :ticketKind", TicketSettingBean.class)
				.setParameter("activityId", bean.getActivityId())
				.setParameter("ticketKind", bean.getTicketKind())
				.uniqueResult();
//			Integer leftStorage = this.getSession().createQuery("SELECT storage FROM TicketSettingBean WHERE activityId = :activityId AND ticketKind = :ticketKind", Integer.class)
//				.setParameter("activityId", bean.getActivityId())
//				.setParameter("ticketKind", bean.getTicketKind())
//				.uniqueResult();
			Integer leftStorage = ticketInfo.getStorage();
			System.out.println("leftStorage= " + leftStorage);
			// ?????????>0 ????????????
			if(leftStorage > 0) {
				// ???????????????????????????
				int r10 = this.getSession().createQuery("UPDATE TicketSettingBean SET storage = storage - :purchaseAmt WHERE activityId = :activityId AND ticketKind = :ticketKind")
					.setParameter("purchaseAmt", bean.getPurchaseAmt())
					.setParameter("activityId", bean.getActivityId())
					.setParameter("ticketKind", bean.getTicketKind())
					.executeUpdate();
				if(r10 > 0) {
					// ??????????????????
					bean.setCost(ticketInfo.getCost());
					Serializable pk = this.getSession().save(bean);
					System.out.println("pk = " + pk);
					return bean;
				}
			}
		}
		return null;
	}

	@Override
	public Object findOrderIdByOption(Integer activityId, String ticketKind, String identification) {
		if(activityId!=null && !ticketKind.isEmpty() && ticketKind!=null && identification!=null && !identification.isEmpty()) {
			Object r11 = this.getSession().createQuery("SELECT orderId FROM OrderInfoBean WHERE activityId=:activityId AND ticketKind=:ticketKind AND identification=:identification")
				.setParameter("activityId", activityId)
				.setParameter("ticketKind", ticketKind)
				.setParameter("identification", identification)
				.uniqueResult();
			if(r11 != null) {
				return r11;
			}
		}
		return null;
	}
	
	@Override
	public OrderInfoBean update(OrderInfoBean bean) {
		if(bean != null) {
			OrderInfoBean r12 = this.getSession().get(OrderInfoBean.class, bean.getOrderId());
			if(r12!=null) {
				bean.setOrderId(r12.getOrderId());
				bean.setIdentification(bean.getIdentification()==null? r12.getIdentification(): bean.getIdentification());
				bean.setTicketKind(bean.getTicketKind()==null? r12.getTicketKind(): bean.getTicketKind());
				bean.setCost(bean.getCost()==null? r12.getCost(): bean.getCost());
				bean.setPurchaseAmt(bean.getPurchaseAmt()==null? r12.getPurchaseAmt(): bean.getPurchaseAmt());
				bean.setPayment(bean.getPayment()==null? r12.getPayment(): bean.getPayment());
				bean.setMemberId(bean.getMemberId()==null? r12.getMemberId(): bean.getMemberId());

				return (OrderInfoBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	
	@Transactional
	@Override
	public OrderInfoBean update(String originalTicketKind, OrderInfoBean bean) {//newBean????????????????????????
		// ?????????????????????????????????????????????
		if(bean.getTicketKind()!=null && !bean.getTicketKind().isEmpty()) {
			System.out.println("ticketKind= " + bean.getTicketKind());
			// ???????????????????????????????????????????????????????????????????????????????????????
			if(bean != null && bean.getIdentification()!=null && !bean.getIdentification().isEmpty() 
					&& bean.getTicketKind()!=null && !bean.getTicketKind().isEmpty() 
					&&  bean.getActivityId()!=null 
					&& (((bean.getName()!=null && !bean.getName().isEmpty()) 
							|| bean.getMemberId()!=null))) {
				// ?????????????????????????????????????????????
				if(originalTicketKind != null && !originalTicketKind.isEmpty()) {
					System.out.println("Prepare to update ticketKind, cost and purchaseAmt");
					// ??????????????????????????????bean????????????????????????
					// ??????????????????????????????????????????????????? ???????????????
					Object id = this.findOrderIdByOption(bean.getActivityId(), originalTicketKind, bean.getIdentification());
					OrderInfoBean orderInfoById = this.getSession().get(OrderInfoBean.class, (Serializable) id);
					System.out.println("??????????????????: " + orderInfoById);
					// ????????????????????????????????????????????????????????????
					TicketSettingBean ticketInfo = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId=:activityId AND ticketKind=:ticketKind", TicketSettingBean.class)
							.setParameter("activityId", bean.getActivityId())
							.setParameter("ticketKind", bean.getTicketKind())
							.uniqueResult();
					System.out.println("???????????????????????????: " + ticketInfo);
					if(ticketInfo != null) {// ?????????????????????
						// ????????????????????????????????????(<??????)
						if(bean.getPurchaseAmt() <= ticketInfo.getStorage()) {
							// ????????????????????????????????????????????????
							int updateCrpdStorage = this.getSession().createQuery("UPDATE TicketSettingBean SET storage = storage - :purchaseAmt WHERE activityId=:activityId AND ticketKind=:ticketKind")
								.setParameter("purchaseAmt", bean.getPurchaseAmt())
								.setParameter("activityId", bean.getActivityId())
								.setParameter("ticketKind", bean.getTicketKind())
								.executeUpdate();
							if(updateCrpdStorage > 0) {
								// ?????????????????????
								System.out.println("Update Crpd Storage Success");
								// ???????????????????????????????????????????????????
								int updateOriginalStorage = this.getSession().createQuery("UPDATE TicketSettingBean SET storage = storage + :purchaseAmt WHERE activityId=:activityId AND ticketKind=:ticketKind")
									.setParameter("purchaseAmt", orderInfoById.getPurchaseAmt()) // ??????????????????????????????
									.setParameter("activityId", bean.getActivityId())
									.setParameter("ticketKind", originalTicketKind)
									.executeUpdate();
								if(updateOriginalStorage > 0) {
									// ??????????????????????????????
									// orderInfoById ?????? ticketKind, cost, purchaseAmt
									orderInfoById.setOrderId((Integer)id);
									
									orderInfoById.setName(bean.getName()==null? orderInfoById.getName(): bean.getName());
									orderInfoById.setIdentification(bean.getIdentification()==null? orderInfoById.getIdentification(): bean.getIdentification());
									orderInfoById.setEmail(bean.getEmail()==null? orderInfoById.getEmail(): bean.getEmail());
									orderInfoById.setPayment(bean.getPayment()==null? orderInfoById.getPayment(): bean.getPayment());
									
									orderInfoById.setTicketKind(bean.getTicketKind());
									orderInfoById.setCost(ticketInfo.getCost());
									orderInfoById.setPurchaseAmt(bean.getPurchaseAmt());
									System.out.println("Update OrderInfo Success!");
									return (OrderInfoBean) this.getSession().merge(orderInfoById);
								}
							} // ????????????????????????
						} else {
							// ????????????????????????
							System.out.println("storage is not enough");
							return null;
						}
					} // ticketInfo = null ????????????????????????????????????
				} // ???????????????null
				// ????????????????????????bean?????????????????????
				if(bean.getPurchaseAmt()!=null) {
					System.out.println("Prepare ONLY update purchaseAmt");
					// ????????????????????????????????????????????????????????????
					Object id = this.findOrderIdByOption(bean.getActivityId(), bean.getTicketKind(), bean.getIdentification());
					OrderInfoBean orderInfoById = this.getSession().get(OrderInfoBean.class, (Serializable) id);
					System.out.println("orderInfoById= " + orderInfoById);
					// ?????????????????????????????????????????????????????????????????????
					TicketSettingBean ticketInfo = this.getSession().createQuery("FROM TicketSettingBean WHERE activityId=:activityId AND ticketKind=:ticketKind", TicketSettingBean.class)
							.setParameter("activityId", bean.getActivityId())
							.setParameter("ticketKind", bean.getTicketKind())
							.uniqueResult();
					// ???????????????
					Object leftStorage =  ticketInfo.getStorage();
					System.out.println("leftStorage= " + leftStorage);
					if(orderInfoById.getPurchaseAmt() < bean.getPurchaseAmt()) {
						// ????????????<????????????
						// ???????????????????????????????????????????????????
						// ???????????????
						Integer addAmt = (bean.getPurchaseAmt() - orderInfoById.getPurchaseAmt());
						if(addAmt <= (Integer)leftStorage) {
							// ????????????????????????????????????????????????
							int updateStorage = this.getSession().createQuery("UPDATE TicketSettingBean SET storage = storage - :addAmt WHERE activityId=:activityId AND ticketKind=:ticketKind")
								.setParameter("addAmt", addAmt)
								.setParameter("activityId", bean.getActivityId())
								.setParameter("ticketKind", bean.getTicketKind())
								.executeUpdate();
							if(updateStorage > 0) {
								System.out.println("??????????????????");
								orderInfoById.setOrderId((Integer)id);
								orderInfoById.setPurchaseAmt(bean.getPurchaseAmt());
								return (OrderInfoBean) this.getSession().merge(orderInfoById);
							}
						}
					} else { // ???????????????
						System.out.println("?????????????????????");
						// ????????????
						Integer deductAmt = (orderInfoById.getPurchaseAmt() - bean.getPurchaseAmt());
						// ???????????????????????????????????????
						int updateStorage = this.getSession().createQuery("UPDATE TicketSettingBean SET storage = storage + :deductAmt WHERE activityId=:activityId AND ticketKind=:ticketKind")
							.setParameter("deductAmt", deductAmt)
							.setParameter("activityId", bean.getActivityId())
							.setParameter("ticketKind", bean.getTicketKind())
							.executeUpdate();
						if(updateStorage > 0) {
							System.out.println("??????????????????");
							orderInfoById.setOrderId((Integer)id);
							
							orderInfoById.setName(bean.getName()==null? orderInfoById.getName(): bean.getName());
							orderInfoById.setIdentification(bean.getIdentification()==null? orderInfoById.getIdentification(): bean.getIdentification());
							orderInfoById.setEmail(bean.getEmail()==null? orderInfoById.getEmail(): bean.getEmail());
							orderInfoById.setPayment(bean.getPayment()==null? orderInfoById.getPayment(): bean.getPayment());
							
							orderInfoById.setPurchaseAmt(bean.getPurchaseAmt());
							return (OrderInfoBean) this.getSession().merge(orderInfoById);
						}
					}
				} // ???????????????
				
			}  // ???????????????
			return null;
		}
		// ??????????????????????????????
		// payment, email
		// name, identification
		if((bean.getIdentification()!=null && !bean.getIdentification().isEmpty()) 
				|| (bean.getName()!=null&&!bean.getName().isEmpty())
				|| (bean.getEmail()!=null&&!bean.getEmail().isEmpty())
				|| (bean.getPayment()!=null&&!bean.getPayment().isEmpty()) ) {
			System.out.println("Prepare update stuff "); // *??????????????????????????????
			if(bean.getActivityId()!=null && bean.getMemberId()!=null){// ??????????????????????????????????????????????????? 
				System.out.println("Condition pass");
				// ?????????????????????????????????????????????????????????????????????????????????
				List<OrderInfoBean>  r13 = this.getSession().createQuery("FROM OrderInfoBean WHERE activityId=:activityId AND memberId = :memberId", OrderInfoBean.class)
					.setParameter("activityId", bean.getActivityId())
					.setParameter("memberId", bean.getMemberId())
					.list();
				System.out.println("???????????????name, identification??????r12= " + r13);
				if(r13 != null) {
					System.out.println("ActivityId= " + bean.getActivityId());
					System.out.println("MemberId= " + bean.getMemberId());
					int update = this.getSession().createQuery("UPDATE OrderInfoBean SET name=:name "
												+ ", identification=:identification"
												+ ", email=:email"
												+ ", payment=:payment"
												+ ", memberId=:memberId WHERE activityId= :activityId AND memberId= :memberId")
						.setParameter("name", bean.getName()==null? r13.get(0).getName(): bean.getName())
						.setParameter("identification", bean.getIdentification()==null? r13.get(0).getIdentification(): bean.getIdentification())
						.setParameter("email", bean.getEmail()==null? r13.get(0).getEmail(): bean.getEmail())
						.setParameter("payment", bean.getPayment()==null? r13.get(0).getPayment(): bean.getPayment())
						.setParameter("memberId", bean.getMemberId()==null? r13.get(0).getMemberId(): bean.getMemberId())
						.setParameter("activityId", bean.getActivityId())
						.setParameter("memberId", bean.getMemberId())
						.executeUpdate();
					if(update>0) {
						System.out.println("?????????");
						return bean;
					}
				}
			} // ????????????????????????????????????
		}// ??????????????????
		return null;
	}

	@Transactional
	@Override
	public boolean delete(Integer id) { // delete??????????????????????????????
		if(id != null) {
			OrderInfoBean r14 = this.getSession().get(OrderInfoBean.class, id);
			if(r14 != null) {
				int update = this.getSession().createQuery("UPDATE TicketSettingBean SET storage=storage + :purchaseAmt "
												+ "WHERE activityId=:activityId "
												+ "AND ticketKind=:ticketKind ")
					.setParameter("purchaseAmt", r14.getPurchaseAmt())
					.setParameter("activityId", r14.getActivityId())
					.setParameter("ticketKind", r14.getTicketKind())
					.executeUpdate();
				if(update > 0) {
					System.out.println("update: " + update);
					this.getSession().delete(r14);
					return true;
				}
			}
		}
		return false;
	}
}
