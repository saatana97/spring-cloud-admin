package cn.saatana.feign.system;

import cn.saatana.common.Res;
import cn.saatana.entity.Dictionary;
import cn.saatana.fallback.system.DictServerFallback;
import cn.saatana.feign.CurdFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "system-server",name = "DictFeign",fallback = DictServerFallback.class)
public interface DictServer extends CurdFeign<Dictionary> {
	@Override
	@RequestMapping("dict/get")
	Res<Dictionary> get(@PathVariable String id);
	@Override
	@RequestMapping("dict/check")
	Res<List<Dictionary>> check(@RequestBody Dictionary entity);
	@Override
	@RequestMapping("dict/page")
	Res<Page<Dictionary>> findPage(@RequestBody Dictionary entity);
	@Override
	@RequestMapping("dict/list")
	Res<List<Dictionary>> findList(@RequestBody Dictionary entity);
	@Override
	@RequestMapping("dict/all")
	Res<List<Dictionary>> findAll();
	@Override
	@RequestMapping("dict/create")
	Res<Dictionary> create(@RequestBody Dictionary entity);
	@Override
	@RequestMapping("dict/update")
	Res<Dictionary> update(@RequestBody Dictionary entity);
	@Override
	@RequestMapping("dict/remove")
	Res<Dictionary> remove(@PathVariable String id);
	@Override
	@RequestMapping("dict/removeAll")
	Res<List<Dictionary>> removeAll(@RequestBody List<String> idList);
	@Override
	@RequestMapping("dict/restore")
	Res<Dictionary> restore(@PathVariable String id);
	@Override
	@RequestMapping("dict/restoreAll")
	Res<List<Dictionary>> restore(@RequestBody List<String> idList);
	@Override
	@RequestMapping("dict/delete")
	Res<Dictionary> delete(@PathVariable String id);
	@Override
	@RequestMapping("dict/deleteAll")
	Res<List<Dictionary>> deleteAll(@RequestBody List<String> ids);
}
