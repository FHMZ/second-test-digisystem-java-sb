package br.com.digisystem.secondtestdigisystem.controller;

import br.com.digisystem.secondtestdigisystem.model.Pessoa;
import br.com.digisystem.secondtestdigisystem.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Fernando Zandonadi
 * @Email ferzan17@gmail.com
 * @Doc variaveis de ambiente adicionadas para  melhor pratica
 **/
@RestController
@RequestMapping(value = "${controller.url}")
public class PessoaController implements Serializable {

    /** Se forem realizadas mudanças muito grandes nesta classe,
     * deve-se tambem alterar este valor
     **/
    private static final long serialVersionUID = 1L;

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping()
    public List<Pessoa> findAll() throws Exception {
        return this.pessoaService.findAll();
    }

    @GetMapping(value = "${controller.urn.findById}")
    public Pessoa findById(@PathVariable("id") Long id) throws Exception {
        return this.pessoaService.findById(id);
    }

    @GetMapping(value = "${controller.urn.findByName}")
    public Pessoa findByName(@PathVariable("name") String name) throws Exception {
        return this.pessoaService.findByName(name);
    }

    @GetMapping(value = "${controller.urn.findBySalary}")
    public List<Pessoa> findBySalary(@PathVariable("salary") String salary) throws Exception {
        return this.pessoaService.findBySalary(salary);
    }

    @PostMapping()
    public Pessoa save(@RequestBody final Pessoa pessoa) throws Exception {
        return this.pessoaService.save(pessoa);
    }
}
