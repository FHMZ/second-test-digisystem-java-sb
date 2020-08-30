package br.com.digisystem.secondtestdigisystem.repository;


import br.com.digisystem.secondtestdigisystem.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fernando Zandonadi
 * @Email ferzan17@gmail.com
 **/
@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

    List<Pessoa> findByNome(String nome);

    List<Pessoa> findBySalario(String salario);
}
