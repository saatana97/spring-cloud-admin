package cn.saatana.fallback.system;

import cn.saatana.common.Res;
import cn.saatana.entity.OparetionLog;
import cn.saatana.feign.system.LogFeign;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogFeignFallback implements LogFeign {

	@Override
	public Res<OparetionLog> get(String id) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<List<OparetionLog>> check(OparetionLog entity) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<Page<OparetionLog>> findPage(OparetionLog entity) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<List<OparetionLog>> findList(OparetionLog entity) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<List<OparetionLog>> findAll() {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<OparetionLog> create(OparetionLog entity) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<OparetionLog> update(OparetionLog entity) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<OparetionLog> remove(String id) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<List<OparetionLog>> removeAll(List<String> idList) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<OparetionLog> restore(String id) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<List<OparetionLog>> restore(List<String> idList) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<OparetionLog> delete(String id) {
		return Res.error("日志服务连接异常",null);
	}

	@Override
	public Res<List<OparetionLog>> deleteAll(List<String> ids) {
		return Res.error("日志服务连接异常",null);
	}
}
