package io.kai;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_info", uniqueConstraints = {@UniqueConstraint(columnNames = "Id")})
public class User {
	private int id;
	private String name;
	private String sex;
	private String City;
	private String Ip;
	private String Severit;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false, insertable = false, updatable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "Name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "Sex", nullable = false)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name = "City", nullable = false)
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	
	@Column(name = "Ip", nullable = false)
	public String getIp() {
		return Ip;
	}
	public void setIp(String ip) {
		this.Ip = ip;
	}
	
	@Column(name = "Severit", nullable = false)
	public String getSeverit() {
		return Severit;
	}
	public void setSeverit(String severit) {
		this.Severit = severit;
	}
	
	
	
}
