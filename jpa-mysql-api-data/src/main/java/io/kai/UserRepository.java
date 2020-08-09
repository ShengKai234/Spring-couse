package io.kai;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.json.JSONObject;

@Repository
@Transactional
public class UserRepository {
	
	
	
	
	
	/**
	 * we are autowiring jdbc template
	 * using the properties we have configuration in application.properties spring
	 * automatically detects and create jdbc template obj using the configuration
	 */
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * return list user names
	 * @return userNameList
	 */
	public List<String> getAllUserNames() {
		List<String> userNameList = new ArrayList<>();
		userNameList.addAll(jdbcTemplate.queryForList("select Name from user_info;", String.class));
		return userNameList;
	}
	
	/**
	 * return count user names's Ip and severit
	 * @return countList
	 */
	public List<String> getCountByIpAndServity() {
		List<String> countList = new ArrayList<>();
		countList.addAll(jdbcTemplate.queryForList("select Count(Severit) from user_info Group By Ip, Severit;", String.class));
		return countList;
	}
	
	
}
