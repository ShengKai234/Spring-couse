package io.kai;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public JSONObject getAllUser() {
		JSONObject result = new JSONObject();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// createQuery()方法參數是criteriaQuery最後回傳值的型別
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		// from()方法設定criteriaQuery查詢的table，類似SQL的from xxxTable
		Root<User> root = criteriaQuery.from(User.class);
		
		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
		List<User> resultList = typedQuery.getResultList();
		result.put("data", resultList);
		return result;
	}
	
	public JSONObject getCountByIpAndSeverit() {
		JSONObject result = new JSONObject();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// createQuery()方法參數是criteriaQuery最後回傳值的型別
		CriteriaQuery<UserCountByIpAndSeverit> criteriaQuery = criteriaBuilder.createQuery(UserCountByIpAndSeverit.class);
		// from()方法設定criteriaQuery查詢的table，類似SQL的from xxxTable
		Root<User> root = criteriaQuery.from(User.class);
		
		Expression<String> groupByIp = root.get("ip").as(String.class);
		Expression<String> groupBySeverit = root.get("severit").as(String.class);
		Expression<Long> countSeverit = criteriaBuilder.count(groupBySeverit);
		CriteriaQuery<UserCountByIpAndSeverit> select = criteriaQuery.multiselect(groupByIp, groupBySeverit, countSeverit);
		criteriaQuery.groupBy(groupByIp, groupBySeverit);
//		criteriaQuery.having(criteriaBuilder.gt(criteriaBuilder.count(root), 0));
		
		TypedQuery<UserCountByIpAndSeverit> typedQuery = entityManager.createQuery(select);
		List<UserCountByIpAndSeverit> resultList = typedQuery.getResultList();
		for (int i = 0; i < resultList.size(); i++) {
			JSONObject data = new JSONObject(resultList.get(i));
			System.out.println(data.get("ip"));
		}
		result.put("data", resultList);
		return result;
	}
}
