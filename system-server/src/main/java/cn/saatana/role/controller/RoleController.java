package cn.saatana.system.role.controller;

import cn.saatana.annotation.LogOparetion;
import cn.saatana.common.CurdController;
import cn.saatana.common.Res;
import cn.saatana.entity.Authorize;
import cn.saatana.entity.Role;
import cn.saatana.system.auth.service.AuthorizeService;
import cn.saatana.system.role.repository.RoleRepository;
import cn.saatana.system.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@LogOparetion("角色管理")
public class RoleController extends CurdController<RoleService, RoleRepository, Role> {
	@Autowired
	private AuthorizeService authService;

	@PostMapping("/dispatch/{id}")
	@LogOparetion("分配用户角色")
	public Res<List<Authorize>> dispatch(@PathVariable String id, @RequestBody List<String> ids) {
		List<Authorize> list = authService.findAllByIds(ids);
		Role role = service.get(id);
		list.forEach(item -> {
			item.getRoles().add(role);
		});
		authService.updateAll(list);
		return Res.ok(list);
	}

	@PostMapping("/undispatch/{id}")
	@LogOparetion("移除用户角色")
	public Res<List<Authorize>> undispatch(@PathVariable String id, @RequestBody List<String> ids) {
		List<Authorize> list = authService.findAllByIds(ids);
		Role role = service.get(id);
		list.forEach(item -> {
			item.getRoles().remove(role);
		});
		authService.updateAll(list);
		return Res.ok(list);
	}

}
