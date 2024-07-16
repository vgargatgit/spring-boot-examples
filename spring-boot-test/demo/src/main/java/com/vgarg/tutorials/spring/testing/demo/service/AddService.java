package com.vgarg.tutorials.spring.testing.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AddService {

	public int add(int a, int b) {
		return a + b;
	}

}
