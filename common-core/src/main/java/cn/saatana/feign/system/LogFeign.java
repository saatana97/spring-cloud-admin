package cn.saatana.feign.system;

import cn.saatana.common.Res;
import cn.saatana.entity.OparetionLog;
import cn.saatana.fallback.system.LogFeignFallback;
import cn.saatana.feign.CurdFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Component
@FeignClient(contextId = "logFeign",value = "system-server",fallback = LogFeignFallback.class)
public interface LogFeign extends CurdFeign<OparetionLog> {
	@Override
	@RequestMapping("log/get")
	Res<OparetionLog> get(@PathVariable String id);
	@Override
	@RequestMapping("log/check")
	Res<List<OparetionLog>> check(@RequestBody OparetionLog entity);
	@Override
	@RequestMapping("log/page")
	Res<Page<OparetionLog>> findPage(@RequestBody OparetionLog entity);
	@Override
	@RequestMapping("log/list")
	Res<List<OparetionLog>> findList(@RequestBody OparetionLog entity);
	@Override
	@RequestMapping("log/all")
	Res<List<OparetionLog>> findAll();
	@Override
	@RequestMapping("log/create")
	Res<OparetionLog> create(@RequestBody OparetionLog entity);
	@Override
	@RequestMapping("log/update")
	Res<OparetionLog> update(@RequestBody OparetionLog entity);
	@Override
	@RequestMapping("log/remove")
	Res<OparetionLog> remove(@PathVariable String id);
	@Override
	@RequestMapping("log/removeAll")
	Res<List<OparetionLog>> removeAll(@RequestBody List<String> idList);
	@Override
	@RequestMapping("log/restore")
	Res<OparetionLog> restore(@PathVariable String id);
	@Override
	@RequestMapping("log/restoreAll")
	Res<List<OparetionLog>> restore(@RequestBody List<String> idList);
	@Override
	@RequestMapping("log/delete")
	Res<OparetionLog> delete(@PathVariable String id);
	@Override
	@RequestMapping("log/deleteAll")
	Res<List<OparetionLog>> deleteAll(@RequestBody List<String> ids);
}
