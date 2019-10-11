package cn.saatana.system.role.controller;

import cn.saatana.system.annotation.LogOparetion;
import cn.saatana.system.auth.entity.Authorizer;
import cn.saatana.system.auth.service.AuthorizerService;
import cn.saatana.system.common.CurdController;
import cn.saatana.system.common.Res;
import cn.saatana.system.role.entity.Role;
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
	private AuthorizerService authService;

	@PostMapping("/dispatch/{id}")
	@LogOparetion("分配用户角色")
	public Res<List<Authorizer>> dispatch(@PathVariable String id, @RequestBody List<String> ids) {
		List<Authorizer> list = authService.findAllByIds(ids);
		Role role = service.get(id);
		list.forEach(item -> {
			item.getRoles().add(role);
		});
		authService.updateAll(list);
		return Res.ok(list);
	}

	@PostMapping("/undispatch/{id}")
	@LogOparetion("移除用户角色")
	public Res<List<Authorizer>> undispatch(@PathVariable String id, @RequestBody List<String> ids) {
		List<Authorizer> list = authService.findAllByIds(ids);
		Role role = service.get(id);
		list.forEach(item -> {
			item.getRoles().remove(role);
		});
		authService.updateAll(list);
		return Res.ok(list);
	}

}
