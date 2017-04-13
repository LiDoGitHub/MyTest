package com.gjyl.appserver.controllers;

import java.util.UUID;

public class Test {

	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			System.out.println(UUID.randomUUID().toString().replace("-", ""));
		}
	}
}
