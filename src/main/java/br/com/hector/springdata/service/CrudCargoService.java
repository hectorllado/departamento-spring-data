package br.com.hector.springdata.service;

import br.com.hector.springdata.orm.Cargo;
import br.com.hector.springdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import javax.sql.rowset.CachedRowSet;
import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;

    }

    public void inicial(Scanner scanner) {
        salvar(scanner);
    }

    public void salvar(Scanner scanner) {
        System.out.println("Descrição do cargo");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);

        System.out.println("Salvo");
    }

    public void atualizar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        System.out.println("Descricao do cargo");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);

        System.out.println("Registro Atualizado!");
    }

    public void visualizar() {
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo.toString()));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        cargoRepository.deleteById(id);
    }
}
