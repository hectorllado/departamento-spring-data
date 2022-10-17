package br.com.hector.springdata.repository;

import br.com.hector.springdata.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
//primeiro parametro é a entidade e o segundo é o tipo do ID

}
