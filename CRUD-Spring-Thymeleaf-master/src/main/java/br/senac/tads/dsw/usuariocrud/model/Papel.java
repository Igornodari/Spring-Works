package br.senac.tads.dsw.usuariocrud.model;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Component
@Table(name="papel")
@Configurable
public class Papel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@NotBlank
	@Size(min = 1, max = 100)
	private String nome;

	@Size(min = 1, max = 100)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "papel_usuario",
			joinColumns = @JoinColumn(name = "id_papel"),
			inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	private Set<Usuario> usuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
