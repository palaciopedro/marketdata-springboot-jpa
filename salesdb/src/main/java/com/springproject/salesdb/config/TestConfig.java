package com.springproject.salesdb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springproject.salesdb.entities.Category;
import com.springproject.salesdb.entities.Order;
import com.springproject.salesdb.entities.Product;
import com.springproject.salesdb.entities.User;
import com.springproject.salesdb.entities.enums.OrderStatus;
import com.springproject.salesdb.repositories.CategoryRepository;
import com.springproject.salesdb.repositories.OrderRepository;
import com.springproject.salesdb.repositories.ProductRepository;
import com.springproject.salesdb.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

    TestConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "An epic fantasy masterpiece", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "A modern television that connects to the internet", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "A high-performance laptop by Apple", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "A high-performance computer", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "A beginner-friendly guide that teaches Ruby on Rails", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAIMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED,  u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAIMENT, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}