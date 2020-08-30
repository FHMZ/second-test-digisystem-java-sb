package br.com.digisystem.secondtestdigisystem.service;

import br.com.digisystem.secondtestdigisystem.model.Pessoa;
import br.com.digisystem.secondtestdigisystem.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Fernando Zandonadi
 * @Email ferzan17@gmail.com
 **/
@Service
public class PessoaService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private PessoaRepository pessoaRepo;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepo) {
        this.pessoaRepo = pessoaRepo;
    }

    /**
     * 1 - TODAS AS PESSOAS CADASTRADAS NO BANCO
     **/
    public List<Pessoa> findAll() throws Exception {
        logger.info("#### Busca todas as pessoas cadastradas");
        return (List<Pessoa>) Optional
                .of(this.pessoaRepo.findAll())
                .orElseThrow(() -> new Exception("Lista de pessoas está vazia."));
    }

    /**
     * 2 - PESSOA PELO ID
     **/
    public Pessoa findById(Long id) throws Exception {
        logger.info("#### Busca de pessoa por id: {}", id);
        return this.pessoaRepo
                .findById(id)
                .orElseThrow(() -> new Exception("Pessoa não encontrada Id: " + id));
    }

    /**
     * 3 - PESSOA PELO NOME
     **/
    public Pessoa findByName(String name) throws Exception {
        logger.info("#### Busca de pessoa por nome: {}", name);
        return Optional
                .of(this.pessoaRepo.findByNome(name))
                .orElseThrow(() -> new Exception("Pessoa não encontrada Nome: " + name));
    }

    /**
     * 4 - PESSOA PELO SALARIO
     **/
    public List<Pessoa> findBySalary(String salary) throws Exception {
        logger.info("#### Busca de pessoa por salario: {}", salary);
        return Optional
                .of(this.pessoaRepo.findBySalario(salary))
                .orElseThrow(() -> new Exception("Pessoa não encontrada Salário: " + salary));
    }

    /**
     * 5 - ALTERAR PESSOA PELO ID
     **/
    public Pessoa save(Pessoa pessoa) throws Exception {
        logger.info("#### Atualizar pessoa por Id: {}", pessoa.getId());
        logger.info("#### Atualizar pessoa por Nome: {}", pessoa.getNome());
        return Optional
                .of(this.pessoaRepo.save(pessoa))
                .orElseThrow(() -> new Exception("Não foi possivel atualizar a pessoa Nome: " + pessoa.getNome()));
    }
}
