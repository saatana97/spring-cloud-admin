package cn.saatana.utils;

import cn.saatana.entity.Dictionary;
import cn.saatana.feign.system.DictServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictUtils {
	private static DictServer dictService;

	@Autowired
	public void setDictService(DictServer dictService) {
		DictUtils.dictService = dictService;
	}

	/**
	 * 根据字典代码和字典值查询字典标签
	 *
	 * @param code  字典代码
	 * @param value 字典值
	 * @return 字典标签
	 */
	public static String query(String code, int value) {
		String res = "未知";
		Dictionary entity = new Dictionary(code, value);
		List<Dictionary> list = dictService.check(entity).getData();
		if (list.size() > 0) {
			res = list.get(0).getLabel();
		}
		return res;
	}
}
