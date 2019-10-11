package cn.saatana.wechat.button.service;

import cn.saatana.system.common.CurdService;
import cn.saatana.wechat.button.entity.Button;
import cn.saatana.wechat.button.repository.ButtonRepository;
import org.springframework.stereotype.Service;

@Service
public class ButtonService extends CurdService<ButtonRepository, Button> {

}
