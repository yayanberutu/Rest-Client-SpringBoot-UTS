package del.ac.id.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/edit/{id}")
	public ModelAndView editItem(@PathVariable("id") String id) {
		Item item = itemApi.getItemById(id);
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("item", item);
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView addItem() {
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("item", new Item());
		return mv;
	}
	
	@RequestMapping("/save")
	public ModelAndView saveItem(@ModelAttribute Item item) {
		System.out.println("Ini pageController");
		System.out.println(item.getId_item());
		itemApi.updateItem(item);
		return index();
	}
	
	@RequestMapping("/add")
	public ModelAndView addItem(@ModelAttribute Item item) {
		itemApi.addItem(item);
		return index();
	}
	
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteItem(@PathVariable("id") String id) {
		itemApi.deleteItem(id);
		return index();
	}
}
