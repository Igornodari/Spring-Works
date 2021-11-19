package br.senac.tads.dsw.usuariocrud.repository;

import org.springframework.data.repository.CrudRepository;

import br.senac.tads.dsw.usuariocrud.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Integer> {

	List<Usuario> findAll();

	Usuario findById(@Valid int id);

	void deleteById(Integer id);

	Usuario save(Usuario user);

}
