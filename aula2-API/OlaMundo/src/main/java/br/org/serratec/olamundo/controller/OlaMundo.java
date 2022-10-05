package br.org.serratec.olamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OlaMundo {

	@GetMapping("/ola")
	public String olaMundo() {
		return "Oi sumida!";
	}
	
	@GetMapping("/resposta")
	public String resposta() {
		return "Vem sempre aqui?";
	}
	
	@GetMapping("/maiscula")
	public String maiuscula(@RequestParam String nome ,@RequestParam Integer idade){
		return nome.toUpperCase() + idade.toString();
	}
	
	@GetMapping("/tamanho")
	public Integer tamanho(@RequestParam String texto) {
		return texto.length();
	}
}
/*Parametro texto ?texto=bom dia&nome=nathan*/