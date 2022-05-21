package com.dev.firstapi;

import java.util.Arrays;

import com.dev.firstapi.models.Client;
import com.dev.firstapi.models.Employee;
import com.dev.firstapi.repositories.ClientRepository;
import com.dev.firstapi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.firstapi.entities.Category;
import com.dev.firstapi.entities.Product;
import com.dev.firstapi.repositories.CategoryRepository;
import com.dev.firstapi.repositories.ProductRepository;

@SpringBootApplication
public class InitiApplication  implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
   SpringApplication.run(InitiApplication.class, args);
 }

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics", "Technology");
		Category cat2 = new Category(null, "Books" ,"Knowledge");

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);

		Product p1 = new Product(null, "TV", 2200.00, "Big TV", "21/01/2030",30, cat1);
		Product p2 = new Product(null, "Domain Driven Design", 120.00, "Facility", "01/05/2050", 50, cat2);
		Product p3 = new Product(null, "PS5", 2800.00, "Play Games", "01/01/2070", 9, cat1);
		Product p4 = new Product(null, "Docker", 100.00, "Innovation", "05/09/2029", 10, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));

		Product product = productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);

		product.setQuantity(product.getQuantity()-1);
		productRepository.save(product);

		Client c1 = new Client(null, "Leonardo Chermaut", "leo123", "leo.chermaut@gmail.com", "198.179.268-98", "21/11/1996", "Rua Almirante Barroso", "(21)96660-9888");
		Client c2 = new Client(null, "Mark Zuckerberg", "zuckDoFB", "facebook@gmail.com", "987.871.877.00", "01/10/1979", "Rua do Alaquim", "(21)99999-0000");

		clientRepository.save(c1);
		clientRepository.save(c2);

		Employee e1 = new Employee(null,"Adailton Machado de Cruz", "974.851.987-70");
		Employee e2 = new Employee(null,"Bruna Carl Marx", "666.777.888-99");
		Employee e3 = new Employee(null,"Charles Oliveira do Bronx", "664.771.999-11");

		employeeRepository.save(e1);
		employeeRepository.save(e2);
		employeeRepository.save(e3);

	}

}

