package cn.saatana.entity;

import cn.saatana.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"roles"})
@Entity
@Table(name = "authorize")
public class Authorize extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	@Transient
	private String code;
	private String openId;
	@Column(name = "login_date")
	private Date loginDate;
	@Where(clause = WHERE_CLAUSE)
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "r_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
			@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<>();

	public Authorize() {
	}

	public Authorize(String openId) {
		this.openId = openId;
	}

	public Authorize(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonGetter
	public Set<Menu> getMenu() {
		Set<Menu> res = new HashSet<>();
		this.roles.forEach(role -> {
			res.addAll(role.getMenus());
		});
		return res;
	}
}
