package com.kgc.hx.controller.basicinfo.factory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.hx.controller.BaseController;
import com.kgc.hx.pojo.Factory;
import com.kgc.hx.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/basicinfo/factory")
public class FactoryController extends BaseController {
	@Resource
	FactoryService factoryService;
	
	//列表
	@RequestMapping("/list.action")
	public String list(Model model,@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size){
		PageHelper.startPage(page,size);
		List<Factory> dataList = factoryService.find(null);
		PageInfo pageInfo = new PageInfo(dataList);
		model.addAttribute("pageInfo", pageInfo);			//将数据传递到页面
		return "basicinfo/factory/jFactoryList";		//转向页面
	}
	
	//转向新增页面
	@RequestMapping("/tocreate.action")
	public String tocreate(){
		return "basicinfo/factory/jFactoryCreate";
	}
	
	//新增保存
	@RequestMapping("/insert.action")
	public String insert(Factory factory){
		factoryService.insert(factory);
		
		return "redirect:/basicinfo/factory/list.action";	//转向列表的action
	}
	
	//转向修改页面
	@RequestMapping("/toupdate.action")
	public String toupdate(String id, Model model){
		Factory obj = factoryService.get(id);
		model.addAttribute("obj", obj);
		
		return "basicinfo/factory/jFactoryUpdate";
	}
	
	//修改保存
	@RequestMapping("/update.action")
	public String update(Factory factory){
		factoryService.update(factory);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//删除一个
	@RequestMapping("/deleteById.action")
	public String deleteById(String id){
		factoryService.deleteById(id);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//删除多条
	@RequestMapping("/delete.action")
	public String delete(@RequestParam("id")String[] ids){
		factoryService.delete(ids);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//查看
	@RequestMapping("/toview.action")
	public String toview(String id, Model model){
		Factory obj = factoryService.get(id);
		model.addAttribute("obj", obj);
		
		return "/basicinfo/factory/jFactoryView.jsp";
	}

	//批量启用
	@RequestMapping("/start.action")
	public String start(@RequestParam("id")String[] ids){
		factoryService.start(ids);

		return "redirect:/basicinfo/factory/list.action";
	}
	
	//批量停用
	@RequestMapping("/stop.action")
	public String stop(@RequestParam("id")String[] ids){
		factoryService.stop(ids);
		
		return "redirect:/basicinfo/factory/list.action";
	}
}
