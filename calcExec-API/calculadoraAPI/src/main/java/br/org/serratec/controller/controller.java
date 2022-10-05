package br.org.serratec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class controller {
	
	@GetMapping("/soma")
	public Integer soma(@RequestParam Integer n1 ,@RequestParam Integer n2) {
		return n1 + n2;
	}
	
	@GetMapping("/subtracao")
	public Double sub(@RequestParam Double n1 ,@RequestParam Double n2) {
		return n1 - n2;
	}
	
	@GetMapping("/multiplicacao")
	public Double mult(@RequestParam Double n1 ,@RequestParam Double n2) {
		return n1 * n2;
	}
	
	@GetMapping("/divisao")
	public Double div(@RequestParam Double n1 ,@RequestParam Double n2) {
		return n1 / n2;
	}
}
