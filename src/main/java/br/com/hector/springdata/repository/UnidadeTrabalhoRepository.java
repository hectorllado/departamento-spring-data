package br.com.hector.springdata.repository;

import br.com.hector.springdata.orm.Funcionario;
import br.com.hector.springdata.orm.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalho, Integer> {

}
