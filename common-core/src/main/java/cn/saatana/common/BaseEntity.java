package cn.saatana.common;

import cn.saatana.core.Safer;
import cn.saatana.entity.AuthorizationInformation;
import cn.saatana.entity.Authorize;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * 公共实体类
 *
 * @author 向文可
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int STATUS_NORMAL = 0;
	public static final int STATUS_DELETED = 1;
	public static final String WHERE_CLAUSE = "data_status = " + STATUS_NORMAL;
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 64)
	private String id;
	private String description;
	private Date createDate;
	private Date updateDate;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Authorize creator;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Authorize updator;
	@JsonIgnore
	private int dataStatus = 0;
	@Transient
	protected Integer page;
	@Transient
	protected Integer limit;

	public boolean isNormal() {
		return this.dataStatus == BaseEntity.STATUS_NORMAL;
	}

	public void preCreate() {
		this.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		AuthorizationInformation authInfo = Safer.currentAuthInfo();
		if (authInfo != null) {
			this.setCreator(authInfo.getAuth());
		}
		this.setCreateDate(new Date());
	}

	public void preUpdate() {
		AuthorizationInformation authInfo = Safer.currentAuthInfo();
		if (authInfo != null) {
			this.setUpdator(authInfo.getAuth());
		}
		this.setUpdateDate(new Date());
	}

	public void preDelete() {
		preUpdate();
		this.dataStatus = STATUS_DELETED;
	}

	public void preRestore() {
		preUpdate();
		this.dataStatus = STATUS_NORMAL;
	}

	@JsonGetter
	public String getCreatorId() {
		String res = null;
		Authorize auth = this.getCreator();
		if (auth != null) {
			res = auth.getId();
		}
		return res;
	}

	@JsonGetter
	public String getCreatorUsername() {
		String res = null;
		Authorize auth = this.getCreator();
		if (auth != null) {
			res = auth.getUsername();
		}
		return res;
	}

	@JsonGetter
	public String getUpdatorId() {
		String res = null;
		Authorize auth = this.getUpdator();
		if (auth != null) {
			res = auth.getId();
		}
		return res;
	}

	@JsonGetter
	public String getUpdatorUsername() {
		String res = null;
		Authorize auth = this.getUpdator();
		if (auth != null) {
			res = auth.getUsername();
		}
		return res;
	}
}
