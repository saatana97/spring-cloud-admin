package cn.saatana.system.role.service;

import cn.saatana.system.common.CurdService;
import cn.saatana.system.role.entity.Role;
import cn.saatana.system.role.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends CurdService<RoleRepository, Role> {

}
