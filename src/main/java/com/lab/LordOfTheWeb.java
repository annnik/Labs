package com.lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/webapps")
public class LordOfTheWeb {
	@RequestMapping("/webapps/pages/{url:.*}")
	public String loadPage(HttpServletRequest request) {
		return load(request);
	}
	
	private String load(HttpServletRequest request) {
		BufferedReader reader = null;
		try {
			StringBuilder pageBuilder = new StringBuilder();
			String url = request.getRequestURI();
			reader = new BufferedReader(new FileReader(url.toString().substring(1, url.length())));
			String line = null;
			while ((line = reader.readLine()) != null) {
				pageBuilder.append(line).append("\n");
			}
			return pageBuilder.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
