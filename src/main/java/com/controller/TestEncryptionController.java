package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.EncryptionService;

@RestController
public class TestEncryptionController {

	@GetMapping(value = "/encrypt")
	public static ResponseEntity<Object> getEncryptedString (@RequestParam(required = false) String param){
		ResponseEntity<Object> entity = null;
		try {
			Map<String, String> response = new HashMap<String, String>();
			response.put("param", param);
			response.put("encryptedParam", EncryptionService.encrypt(param));
			entity = new ResponseEntity<Object>(response, HttpStatus.OK);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Object>(e.getMessage(), HttpStatus.METHOD_FAILURE);
			return entity;
		}
	}
}
