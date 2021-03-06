package cn.saatana.menu.service;

import cn.saatana.common.CurdService;
import cn.saatana.entity.Menu;
import cn.saatana.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends CurdService<MenuRepository, Menu> {

}
