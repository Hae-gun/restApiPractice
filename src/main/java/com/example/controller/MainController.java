package com.example.controller;

import java.util.HashMap;
import java.util.Map;


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
	public Map M(@PathVariable String paramId,@RequestParam String data) {
		Map<String,String> m = new HashMap<>();
		System.out.println("M Connection Detected");
		if(memory.containsKey(paramId)) {
			m.put("result", paramId+" 수정");
		}else {
			m.put("result", paramId+" 등록완료");
		}
		memory.put(paramId, mydao.test(data));
		return m;
	}
	
	@GetMapping("/M/{paramId}")
	public Map mGet(@PathVariable String paramId) {
		Map<String,String> m = new HashMap<>();
		m.put(paramId, memory.get(paramId));
		System.out.println("mGet Connection Detected");
		return m;
	}
}
