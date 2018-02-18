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

import com.restaurant.c1603g.Entity.other.Table;
import com.restaurant.c1603g.Service.table.TableService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class TableApiController {
	
	@Autowired
	TableService tableService;
	
	@GetMapping("/get/table")
	public Table getTableById(@RequestParam("Id") String id) {
		return tableService.getTable(id);
	}
	
	@GetMapping("/get/tables")
	public List<Table> getTablesByName(@RequestParam("typeseat") String typeseat){
		return tableService.getTablesByTypeSeat(typeseat);
	}
	
	@PostMapping("/insert/table")
	public String insertTable(@RequestBody Table table) {
		return tableService.insertTable(table);
	}
	
	@PostMapping("/update/table")
	public String updateTable(@RequestBody Table table) {
		return tableService.updateTable(table);
	}
	
	@PostMapping("/delete/table")
	public String deleteTable(@RequestParam("Id") String id) {
		return tableService.deleteTable(id);
	}
	
}
