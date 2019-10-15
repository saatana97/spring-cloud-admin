package cn.saatana.entity;

import cn.saatana.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "button")
public class Button extends BaseEntity {
	private static final long serialVersionUID = 1L;
	public static final String TYPE_CLICK = "click";
	public static final String TYPE_VIEW = "view";
	public static final String TYPE_SCANCODE_PUSH = "scancode_push";
	public static final String TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";
	public static final String TYPE_PIC_SYSPHOTO = "pic_sysphoto";
	public static final String TYPE_PIC_SYSPHOTO_OR_ALBUM = "pic_photo_or_album";
	public static final String TYPE_PIC_WEIXIN = "pic_weixin";
	public static final String TYPE_LOCATION_SELECT = "location_select";
	public static final String TYPE_MEDIA_ID = "media_id";
	public static final String TYPE_VIEW_LIMITED = "view_limited";

	private String type;
	@Column(length = 60)
	private String name;
	@Column(length = 128)
	@JsonProperty("key")
	private String buttonKey;
	@Column(length = 1024)
	private String url;
	@JsonProperty("media_id")
	private String mediaId;
	private String appid;
	private String pagepath;
	@JsonProperty("sub_button")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pid")
	private List<Button> children = new ArrayList<>();
	private String pid;
}
