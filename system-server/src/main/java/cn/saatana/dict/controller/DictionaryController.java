package cn.saatana.system.dict.controller;

import cn.saatana.annotation.LogOparetion;
import cn.saatana.common.CurdController;
import cn.saatana.common.Res;
import cn.saatana.entity.Dictionary;
import cn.saatana.system.dict.repository.DictionaryRepository;
import cn.saatana.system.dict.service.DictionaryService;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@LogOparetion("字典管理")
@RequestMapping("/dict")
public class DictionaryController extends CurdController<DictionaryService, DictionaryRepository, Dictionary> {
	@PostMapping("query")
	@LogOparetion(ignore = true, value = "查字典")
	public Res<String> query(@RequestBody Dictionary entity) {
		String res = "未知";
		List<Dictionary> list = service.findList(entity, StringMatcher.EXACT);
		if (list.size() > 0) {
			res = list.get(0).getLabel();
		}
		return Res.ok(res);
	}
}
