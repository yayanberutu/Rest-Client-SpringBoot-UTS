package del.ac.id.demo.model;

public class Category {
	private String id_cat;
	
	private String cat_name;

	
	
	public Category() {
//		super();
	}

	public Category(String id_cat, String cat_name) {
//		super();
		this.id_cat = id_cat;
		this.cat_name = cat_name;
	}

	public String getId_cat() {
		return id_cat;
	}

	public void setId_cat(String id_cat) {
		this.id_cat = id_cat;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	

	
}
