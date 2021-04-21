package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.MyDao;

@CrossOrigin(maxAge = 3600)
@RestController
public class MainController {
	
	private final MyDao mydao;
	Map<String,String> memory = new HashMap<String,String>();
	
	public MainController(MyDao mydao) {
		this.mydao = mydao;
	}
	
	
	@PostMapping("/M/{paramId}")
	public Map M(@PathVariable String paramId,@RequestParam("data") String data) {
//		Map<String,String> m = new HashMap<>();
		memory.put(paramId, mydao.test(data));
		System.out.println("M Connection Detected");
		return memory; 
	}
	
	@GetMapping("/M/{paramId}")
	public Map mGet(@PathVariable String paramId) {
		Map<String,String> m = new HashMap<>();
		m.put(paramId, memory.get(paramId));
		System.out.println("mGet Connection Detected");
		return m;
	}
}
