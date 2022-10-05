package br.serratec.org.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.serratec.org.domain.Veiculo;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	private static List<Veiculo> lista = new ArrayList<Veiculo>();
	static {
		lista.add(new Veiculo(1L, "Ford", "Fiesta"));
		lista.add(new Veiculo(2L, "Honda", "Civic"));
		lista.add(new Veiculo(3L, "Toyota", "Etios"));
	}
	
	@GetMapping
	public List<Veiculo> listar() {
		return lista;
	}
	
	@GetMapping("/{placa}")
	public Veiculo buscar(@PathVariable Long placa) {
		for (int i = 0; i< lista.size(); i++) {
			if (lista.get(i).getPlaca().equals(placa)) {
				return lista.get(i);
			}
		}
		return null;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		lista.add(veiculo);
		return veiculo;
	}
	
	@DeleteMapping("/{placa}")
	public void delete(@PathVariable Long placa) {
		for (int i = 0; i< lista.size(); i++) {
			if (lista.get(i).getPlaca().equals(placa)) {
				lista.remove(i);
				break;
			}
		}
	}
	
	@PutMapping("/{placa}")
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable Long placa) {
		for (int i = 0; i< lista.size(); i++) {
			if (lista.get(i).getPlaca().equals(placa)) {
				Veiculo add = new Veiculo(placa, veiculo.getMarca(), veiculo.getModelo());
				lista.set(i, add);
				return add;
			}
		}
		return null;
	}
}
