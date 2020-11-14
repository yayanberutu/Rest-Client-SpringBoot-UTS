package del.ac.id.demo.restapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import del.ac.id.demo.model.Item;

@Service
public class ItemRestApi {
//	private final static Logger LOGGER = LoggerFactory.getLogger(ItemRestApi.class.getName());
	
	@Value(value = "${base.url}")
	private String url;	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Item> getAllItem(){
		List<Item> listItem = Arrays.stream(restTemplate.getForObject(url, Item[].class)).collect(Collectors.toList());
		return listItem;
	}
	
	public Item getItemById(String id) {
		Item item = restTemplate.getForObject(url + "/{id}", Item.class, id);
		return item;
	}
}
