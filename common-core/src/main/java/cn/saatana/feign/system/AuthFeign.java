package cn.saatana.feign.system;

import cn.saatana.common.Res;
import cn.saatana.entity.Authorize;
import cn.saatana.fallback.system.AuthFeignFallback;
import cn.saatana.feign.CurdFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Component
@FeignClient(contextId="authFeign",value = "system-server",fallback = AuthFeignFallback.class)
public interface AuthFeign extends CurdFeign<Authorize> {
	@Override
	@RequestMapping("auth/get")
	Res<Authorize> get(@PathVariable String id);
	@Override
	@RequestMapping("auth/check")
	Res<List<Authorize>> check(@RequestBody Authorize entity);
	@Override
	@RequestMapping("auth/page")
	Res<Page<Authorize>> findPage(@RequestBody Authorize entity);
	@Override
	@RequestMapping("auth/list")
	Res<List<Authorize>> findList(@RequestBody Authorize entity);
	@Override
	@RequestMapping("auth/all")
	Res<List<Authorize>> findAll();
	@Override
	@RequestMapping("auth/create")
	Res<Authorize> create(@RequestBody Authorize entity);
	@Override
	@RequestMapping("auth/update")
	Res<Authorize> update(@RequestBody Authorize entity);
	@Override
	@RequestMapping("auth/remove")
	Res<Authorize> remove(@PathVariable String id);
	@Override
	@RequestMapping("auth/removeAll")
	Res<List<Authorize>> removeAll(@RequestBody List<String> idList);
	@Override
	@RequestMapping("auth/restore")
	Res<Authorize> restore(@PathVariable String id);
	@Override
	@RequestMapping("auth/restoreAll")
	Res<List<Authorize>> restore(@RequestBody List<String> idList);
	@Override
	@RequestMapping("auth/delete")
	Res<Authorize> delete(@PathVariable String id);
	@Override
	@RequestMapping("auth/deleteAll")
	Res<List<Authorize>> deleteAll(@RequestBody List<String> ids);
}
