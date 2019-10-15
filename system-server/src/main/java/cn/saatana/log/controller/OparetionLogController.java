package cn.saatana.system.log.controller;

import cn.saatana.annotation.Admin;
import cn.saatana.annotation.LogOparetion;
import cn.saatana.common.CurdController;
import cn.saatana.common.Res;
import cn.saatana.entity.OparetionLog;
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
