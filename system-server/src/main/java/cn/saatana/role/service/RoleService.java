package cn.saatana.system.role.service;

import cn.saatana.common.CurdService;
import cn.saatana.entity.Role;
import cn.saatana.system.role.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends CurdService<RoleRepository, Role> {

}
