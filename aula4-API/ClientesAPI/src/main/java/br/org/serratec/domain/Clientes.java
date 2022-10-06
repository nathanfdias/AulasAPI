package br.org.serratec.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clienteaula")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(length = 60)
    private String nome;

    @Column(length = 11)
    private String cpf;

    @Column(length = 50)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;


//	public Clientes(Long id, String nome, String cpf, String email, LocalDate dataNascimento) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.cpf = cpf;
//		this.email = email;
//		this.dataNascimento = dataNascimento;
//	}
//
//	public Clientes() {
//
//	}
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
                + dataNascimento + "]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
