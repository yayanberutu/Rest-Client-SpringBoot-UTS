package del.ac.id.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import del.ac.id.demo.model.Item;
import del.ac.id.demo.restapi.ItemRestApi;

@RestController
public class PageController {
	@Autowired
	private ItemRestApi itemApi;
	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listItem", itemApi.getAllItem());
		mv.addObject("item",new Item());
		return mv;
	}
	
	@RequestMapping("/get")
	public ModelAndView getItemById(@ModelAttribute Item item) {
//		System.out.println(id);
		System.out.println("Tess");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("listItem", itemApi.getItemById(item.getId_item()));
		return mv;
	}
}
