package br.senac.tads.dsw.usuariocrud.model;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Component
@Table(name="usuario")
@Configurable
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Size(min = 1, max = 100)
	@NotBlank
	private String username;

	@Size(max = 200)
	@NotBlank
	private String nomeCompleto;
	
	@Size(max = 1000)
	@NotBlank
	private String senha;
	
	
	private boolean ativado;
	
	private LocalDateTime dataHoraCadastro;

	@Size(max=10000)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_papel",
			joinColumns = @JoinColumn(name = "id_usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_papel"))
	private Set<Papel> papeis;
	
	public Usuario() {

	}

	public Usuario(String username, String nomeCompleto, String senha, boolean ativado, LocalDateTime dataHoraCadastro) {
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
		this.ativado= ativado;
		this.dataHoraCadastro =dataHoraCadastro;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivado() {
		return ativado;
	}

	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Set<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(Set<Papel> papeis) {
		this.papeis = papeis;
	}

}
