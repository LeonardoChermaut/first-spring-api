package com.dev.firstapi.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.firstapi.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{



	


	
}