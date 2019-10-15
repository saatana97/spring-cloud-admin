package cn.saatana.role.service;

import cn.saatana.common.CurdService;
import cn.saatana.entity.Role;
import cn.saatana.role.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends CurdService<RoleRepository, Role> {

}
