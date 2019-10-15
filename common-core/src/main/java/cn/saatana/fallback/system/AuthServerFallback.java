package cn.saatana.fallback.system;

import cn.saatana.common.Res;
import cn.saatana.entity.Authorize;
import cn.saatana.feign.system.AuthServer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthServerFallback implements AuthServer {

	@Override
	public String testHi(String name) {
		return "Sorry Dear " + name + ",Services are busy.";
	}

	@Override
	public Res<Authorize> get(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorize>> check(Authorize entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Page<Authorize>> findPage(Authorize entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorize>> findList(Authorize entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorize>> findAll() {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorize> create(Authorize entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorize> update(Authorize entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorize> remove(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorize>> removeAll(List<String> idList) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorize> restore(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorize>> restore(List<String> idList) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorize> delete(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorize>> deleteAll(List<String> ids) {
		return Res.error("授权服务连接异常",null);
	}
}
