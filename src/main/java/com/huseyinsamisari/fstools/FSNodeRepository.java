package com.huseyinsamisari.fstools;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FSNodeRepository extends MongoRepository<FSNode, String>{
	@Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
	public List<FSNode> findByNameRegex(String name);
	public List<FSNode> findByName(String name);
}
