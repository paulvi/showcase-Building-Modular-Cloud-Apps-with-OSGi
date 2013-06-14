package webshop.products.api;

import net.vz.mongodb.jackson.ObjectId;

public class Product {
	@ObjectId
    private String _id;
	private String name;
	private String category;
    
    public String get_id() {
    	return _id;
    }
    
    public void set_id(String id) {
    	this._id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
}