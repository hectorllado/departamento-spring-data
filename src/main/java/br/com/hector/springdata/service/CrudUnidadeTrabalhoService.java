package br.com.hector.springdata.service;

import br.com.hector.springdata.orm.Cargo;
import br.com.hector.springdata.orm.UnidadeTrabalho;
import br.com.hector.springdata.repository.CargoRepository;
import br.com.hector.springdata.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;

    }

    public void inicial(Scanner scanner) {
        salvar(scanner);
    }

    public void salvar(Scanner scanner) {
        System.out.println("Descrição da UT");
        String descricao = scanner.next();
        System.out.println("Endereço da UT");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);
        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("Salvo");
    }

    public void atualizar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        System.out.println("Descrição da UT");
        String descricao = scanner.next();
        System.out.println("Endereço da UT");
        String endereco = scanner.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);
        unidadeTrabalhoRepository.save(unidadeTrabalho);

        System.out.println("Registro da UT Atualizado!");
    }

    public void visualizar() {
        Iterable<UnidadeTrabalho> unidadeTrabalhos = unidadeTrabalhoRepository.findAll();
        unidadeTrabalhos.forEach(unidadeTrabalho -> System.out.println(unidadeTrabalho.toString()));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        unidadeTrabalhoRepository.deleteById(id);
    }
}
