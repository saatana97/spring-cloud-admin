package cn.saatana.system.org.controller;

import cn.saatana.system.annotation.LogOparetion;
import cn.saatana.system.common.CurdController;
import cn.saatana.system.common.Res;
import cn.saatana.system.org.entity.Org;
import cn.saatana.system.org.repository.OrgRepository;
import cn.saatana.system.org.service.OrgService;
import cn.saatana.system.utils.TreeUtils;
import cn.saatana.system.utils.tree.TreeNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/org")
@LogOparetion("组织机构管理")
public class OrgController extends CurdController<OrgService, OrgRepository, Org> {

	@RequestMapping("tree")
	public Res<List<TreeNode<Org>>> tree() {
		List<Org> all = service.findList(new Org());
		List<TreeNode<Org>> tree = TreeUtils.buildTree(all);
		return Res.ok(tree);
	}

}
