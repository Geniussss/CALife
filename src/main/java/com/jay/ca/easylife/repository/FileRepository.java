package com.jay.ca.easylife.repository;

import org.springframework.data.repository.CrudRepository;

import com.jay.ca.easylife.model.File;

public interface FileRepository extends CrudRepository<File,Long>{
	
	File findFirstByOrderByIdDesc();

}
