package br.com.hector.springdata.service;

import br.com.hector.springdata.orm.Cargo;
import br.com.hector.springdata.orm.Funcionario;
import br.com.hector.springdata.repository.CargoRepository;
import br.com.hector.springdata.repository.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        salvar(scanner);
    }

    public void salvar(Scanner scanner) {
        System.out.println("Nome do funcionario");
        String nome = scanner.next();
        System.out.println("Cpf do funcionario");
        String cpf = scanner.next();
        System.out.println("Salario do funcionario");
        double salario = scanner.nextInt();

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionarioRepository.save(funcionario);

        System.out.println("Salvo");
    }

    public void atualizar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        System.out.println("Nome do funcionario");
        String nome = scanner.next();
        System.out.println("Cpf do funcionario");
        String cpf = scanner.next();
        System.out.println("Salario do funcionario");
        double salario = scanner.nextDouble();

        Funcionario funcionario = new Funcionario();

        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionarioRepository.save(funcionario);

        System.out.println("Registro de funcionario atualizado");
    }

    public void visualizar(Scanner scanner) {
        System.out.println("Qual pagina vc deseja visualizar?");
        Integer page = scanner.nextInt();

        Pageable pageable = PageRequest.of(page, 5, Sort.unsorted());


        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);

        System.out.println(funcionarios);
        System.out.println("Pagina atual: " + funcionarios.getNumber());
        System.out.println("Quantidade total de elementos " + funcionarios.getTotalElements());
        funcionarios.forEach(funcionario -> System.out.println(funcionarios.toString()));
    }

    public void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
    }


}
