package cn.saatana.feign.system;

import cn.saatana.entity.Authorizer;
import cn.saatana.entity.Res;
import cn.saatana.fallback.system.AuthServerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "system-server",name = "AuthFeign",fallback = AuthServerFallback.class)
public interface AuthServer extends CurdFeign<Authorizer> {
	@RequestMapping("/test/hi")
	String testHi(@RequestParam String name);

	@Override
	@RequestMapping("auth/get")
	Res<Authorizer> get(@PathVariable String id);
	@Override
	@RequestMapping("auth/check")
	Res<List<Authorizer>> check(@RequestBody Authorizer entity);
	@Override
	@RequestMapping("auth/page")
	Res<Page<Authorizer>> findPage(@RequestBody Authorizer entity);
	@Override
	@RequestMapping("auth/list")
	Res<List<Authorizer>> findList(@RequestBody Authorizer entity);
	@Override
	@RequestMapping("auth/all")
	Res<List<Authorizer>> findAll();
	@Override
	@RequestMapping("auth/create")
	Res<Authorizer> create(@RequestBody Authorizer entity);
	@Override
	@RequestMapping("auth/update")
	Res<Authorizer> update(@RequestBody Authorizer entity);
	@Override
	@RequestMapping("auth/remove")
	Res<Authorizer> remove(@PathVariable String id);
	@Override
	@RequestMapping("auth/removeAll")
	Res<List<Authorizer>> removeAll(@RequestBody List<String> idList);
	@Override
	@RequestMapping("auth/restore")
	Res<Authorizer> restore(@PathVariable String id);
	@Override
	@RequestMapping("auth/restoreAll")
	Res<List<Authorizer>> restore(@RequestBody List<String> idList);
	@Override
	@RequestMapping("auth/delete")
	Res<Authorizer> delete(@PathVariable String id);
	@Override
	@RequestMapping("auth/deleteAll")
	Res<List<Authorizer>> deleteAll(@RequestBody List<String> ids);
}
