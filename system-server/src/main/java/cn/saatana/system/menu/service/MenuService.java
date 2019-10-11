package cn.saatana.system.menu.service;

import cn.saatana.system.common.CurdService;
import cn.saatana.system.menu.entity.Menu;
import cn.saatana.system.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends CurdService<MenuRepository, Menu> {

}
