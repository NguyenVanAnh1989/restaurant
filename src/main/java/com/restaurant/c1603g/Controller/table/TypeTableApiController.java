package com.restaurant.c1603g.Controller.table;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.c1603g.Entity.table.TypeTable;
import com.restaurant.c1603g.Service.table.TypeTableService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TypeTableApiController {
	
	@Autowired
	TypeTableService typetableService;
	
	@GetMapping("/get/typetable")
	public TypeTable getTypeTableById(@RequestParam("Id") String id) {
		return typetableService.getTypeTable(id);
	}
	
	@GetMapping("/get/typetables")
	public List<TypeTable> getTypeTablesByName(@RequestParam("name") String name){
		return typetableService.getTypeTablesByName(name);
	}
	
	@PostMapping("/insert/typetable")
	public String insertTypeTable(@RequestBody TypeTable typeTable) {
		return typetableService.insertTypeTable(typeTable);
	}
	
	@PostMapping("/update/typetable")
	public String updateTypeTable(@RequestBody TypeTable typeTable) {
		return typetableService.updateTypeTable(typeTable);
	}
	
	@PostMapping("/delete/typetable")
	public String deleteTypeTable(@RequestParam("Id") String id) {
		return typetableService.deleteTypeTable(id);
	}
	
}
