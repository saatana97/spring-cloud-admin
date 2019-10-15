package cn.saatana.fallback.system;

import cn.saatana.entity.Authorizer;
import cn.saatana.entity.Res;
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
	public Res<Authorizer> get(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorizer>> check(Authorizer entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Page<Authorizer>> findPage(Authorizer entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorizer>> findList(Authorizer entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorizer>> findAll() {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorizer> create(Authorizer entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorizer> update(Authorizer entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorizer> remove(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorizer>> removeAll(List<String> idList) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorizer> restore(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorizer>> restore(List<String> idList) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Authorizer> delete(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Authorizer>> deleteAll(List<String> ids) {
		return Res.error("授权服务连接异常",null);
	}
}
