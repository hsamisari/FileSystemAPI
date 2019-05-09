package com.huseyinsamisari.fstools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FSToolsController {

	@Autowired
	private FSNodeRepository repository;

	@GetMapping(path = "store")
	public ResponseEntity<FSNode> browse() {
		FSTreeWalker walker = new FSTreeWalker(repository);
		walker.initWalk();
		return new ResponseEntity<FSNode>(walker.getRoot(), HttpStatus.OK);
	}

	@GetMapping(path = "findAll")
	public ResponseEntity<List<FSNode>> retreive() {
		return new ResponseEntity<List<FSNode>>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "findByName")
	public ResponseEntity<List<FSNode>> findByName(@RequestParam() String name) {
		return new ResponseEntity<List<FSNode>>(repository.findByName(name), HttpStatus.OK);
	}
	@GetMapping(path = "findByNameRegexp")
	public ResponseEntity<List<FSNode>> findByNameRegexp(@RequestParam() String name) {
		return new ResponseEntity<List<FSNode>>(repository.findByNameRegex(name), HttpStatus.OK);
	}
	
}
