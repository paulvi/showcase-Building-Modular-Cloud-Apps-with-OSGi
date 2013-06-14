package org.example.tests;

import java.util.List;
import java.util.Properties;

import org.amdatu.bndtools.test.BaseOSGiServiceTest;
import org.amdatu.mongo.MongoDBService;

import webshop.products.api.Product;
import webshop.products.api.ProductService;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class MongoProductServiceTest extends BaseOSGiServiceTest<ProductService> {
	private volatile MongoDBService mongoDBService;
	private DBCollection collection;

	public MongoProductServiceTest() {
		super(ProductService.class);
	}
	
	@Override
	public void setUp() throws Exception {
		Properties properties = new Properties();
		properties.put("dbName", "webshoptests");
		configureFactory("org.amdatu.mongo", properties);
		
		addServiceDependencies(MongoDBService.class);
		
		super.setUp();
		
		collection = mongoDBService.getDB().getCollection("products");
		
		collection.remove(new BasicDBObject());
	}
	
    public void testListCategories() {
    	collection.save(new BasicDBObject("category", "books"));
    	collection.save(new BasicDBObject("category", "books"));
    	collection.save(new BasicDBObject("category", "games"));
    	
    	List<String> categories = instance.listCategories();
    	assertEquals(2, categories.size());
    }
    
    public void testListProductsInCategory() {
    	collection.save(new BasicDBObject("category", "books").append("name", "Modular Java in the Cloud"));
    	collection.save(new BasicDBObject("category", "books").append("name", "OSGi in Action"));
    	collection.save(new BasicDBObject("category", "games").append("name", "Space invaders"));
    	
    	List<Product> books = instance.listProductsInCategory("books");
    	assertEquals(2, books.size());
    	
    	List<Product> games = instance.listProductsInCategory("games");
    	assertEquals(1, games.size());
    }
}
