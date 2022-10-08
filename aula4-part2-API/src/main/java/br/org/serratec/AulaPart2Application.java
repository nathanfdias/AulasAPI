
package br.org.serratec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.org.serratec.model.Pagamento;

@SpringBootApplication
public class AulaPart2Application implements CommandLineRunner {

	@Autowired
	private Pagamento pagamento;

	public static void main(String[] args) {
		SpringApplication.run(AulaPart2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// IOC - Inversão de controle
		// Exame exame = new Exame();
		// Consulta consulta = new Consulta();
		// Pagamento pagamento = new Pagamento(consulta, exame);

		System.out.printf("Total a pagar: %.2f", pagamento.calcularProcedimentos(200.0, 80.0));

	}
}
