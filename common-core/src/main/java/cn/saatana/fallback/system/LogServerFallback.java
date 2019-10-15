package cn.saatana.fallback.system;

import cn.saatana.common.Res;
import cn.saatana.entity.Dictionary;
import cn.saatana.feign.system.DictServer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictServerFallback implements DictServer {

	@Override
	public Res<Dictionary> get(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Dictionary>> check(Dictionary entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Page<Dictionary>> findPage(Dictionary entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Dictionary>> findList(Dictionary entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Dictionary>> findAll() {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Dictionary> create(Dictionary entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Dictionary> update(Dictionary entity) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Dictionary> remove(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Dictionary>> removeAll(List<String> idList) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Dictionary> restore(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Dictionary>> restore(List<String> idList) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<Dictionary> delete(String id) {
		return Res.error("授权服务连接异常",null);
	}

	@Override
	public Res<List<Dictionary>> deleteAll(List<String> ids) {
		return Res.error("授权服务连接异常",null);
	}
}
