package com.kgc.hx.controller.export;

import com.kgc.hx.controller.BaseController;
import com.kgc.hx.pojo.Contract;
import com.kgc.hx.pojo.Export;
import com.kgc.hx.service.ExportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ExportController extends BaseController {
	@Resource
	ExportService exportService;
	
	@RequestMapping("/cargo/export/list.action")
	public String list(Model model){
		List<Export> dataList = exportService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "cargo/export/jExportList";
	}
	
	//购销合同查询列表
	@RequestMapping("/cargo/export/contractList.action")
	public String contractList(Model model){
		List<Contract> dataList = exportService.getContractList();
		model.addAttribute("dataList", dataList);
		
		return "cargo/export/jContractList";		//报运目录下调用购销合同列表
	}
	
	//报运新增，直接进行后台保存
	@RequestMapping("/cargo/export/insert.action")
	public String insert(@RequestParam("id")String[] contractIds){			//合同的id集合
		exportService.insert(contractIds);
		
		return "redirect:/cargo/export/list.action";
	}
	
	@RequestMapping("/cargo/export/toupdate.action")
	public String toupdate(String id, Model model){
		Export obj = exportService.get(id);
		model.addAttribute("obj", obj);
		
		//准备批量修改控件的数据mrecord
		model.addAttribute("mRecordData", exportService.getMrecordData(id));
		
		return "cargo/export/jExportUpdate";
	}
	
	@RequestMapping("/cargo/export/update.action")
	public String update(Export export,
				String[] mr_id,
				Integer[] mr_orderNo,
				Integer[] mr_cnumber,
				Double[] mr_grossWeight,
				Double[] mr_netWeight,
				Double[] mr_sizeLength,
				Double[] mr_sizeWidth,
				Double[] mr_sizeHeight,
				Double[] mr_exPrice,
				Double[] mr_tax,
				Integer[] mr_changed
			){
		exportService.update(export,
				mr_id,
				mr_orderNo,
				mr_cnumber,
				mr_grossWeight,
				mr_netWeight,
				mr_sizeLength,
				mr_sizeWidth,
				mr_sizeHeight,
				mr_exPrice,
				mr_tax,
				mr_changed
			);
		
		return "redirect:/cargo/export/list.action";
	}
}
