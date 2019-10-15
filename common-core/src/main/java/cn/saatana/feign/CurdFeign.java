package cn.saatana.feign;

import cn.saatana.common.BaseEntity;
import cn.saatana.common.Res;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CurdFeign<Entity extends BaseEntity> {
	Res<Entity> get(@PathVariable String id);
	Res<List<Entity>> check(@RequestBody Entity entity);
	Res<Page<Entity>> findPage(@RequestBody Entity entity);
	Res<List<Entity>> findList(@RequestBody Entity entity);
	Res<List<Entity>> findAll();
	Res<Entity> create(@Validated @RequestBody Entity entity);
	Res<Entity> update(@Validated @RequestBody Entity entity);
	Res<Entity> remove(@PathVariable String id);
	Res<List<Entity>> removeAll(@RequestBody List<String> idList);
	Res<Entity> restore(@PathVariable String id);
	Res<List<Entity>> restore(@RequestBody List<String> idList);
	Res<Entity> delete(@PathVariable String id);
	Res<List<Entity>> deleteAll(@RequestBody List<String> ids);
}
