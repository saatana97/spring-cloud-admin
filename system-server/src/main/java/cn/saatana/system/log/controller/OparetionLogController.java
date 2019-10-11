package cn.saatana.system.log.controller;

import cn.saatana.system.annotation.Admin;
import cn.saatana.system.annotation.LogOparetion;
import cn.saatana.system.common.CurdController;
import cn.saatana.system.common.Res;
import cn.saatana.system.log.entity.OparetionLog;
import cn.saatana.system.log.repository.OparetionLogRepository;
import cn.saatana.system.log.service.OparetionLogService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Admin
@RestController
@LogOparetion("操作日志管理")
@RequestMapping("/log")
public class OparetionLogController extends CurdController<OparetionLogService, OparetionLogRepository, OparetionLog> {

	@Override
	@Admin(false)
	@PostMapping("page")
	@LogOparetion(value = "", ignore = true)
	public Res<Page<OparetionLog>> page(@RequestBody OparetionLog entity) {
		return super.page(entity);
	}

}
