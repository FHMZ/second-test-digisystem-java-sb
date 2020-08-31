package br.com.digisystem.secondtestdigisystem.service;

import br.com.digisystem.secondtestdigisystem.model.Pessoa;
import br.com.digisystem.secondtestdigisystem.repository.PessoaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PessoaServiceTest {

    @Autowired
    private PessoaService service;

    @MockBean
    private PessoaRepository repo;

    @Test
    public void mustFindValidAll() throws Exception {

        when(this.repo.findAll()).thenReturn(this.getListPessoa());

        List<Pessoa> pessoaList = this.service.findAll();
        assertThat(pessoaList.size()).isEqualTo(2);
        assertThat(pessoaList).isNotNull();
    }

    @Test
    public void mustFindValidId() throws Exception {
        final long id = 5l;
        final Pessoa pessoa = this.getPessoa();

        when(this.repo.findById(id)).thenReturn(Optional.of(pessoa));

        Pessoa found = this.service.findById(id);
        assertThat(found.getId()).isEqualTo(id);
    }

    @Test
    public void mustFindValidName() throws Exception {
        final String name = "Joaquim da Vilas Boas";
        final Pessoa pessoa = this.getPessoa();

        when(this.repo.findByNome(name)).thenReturn(pessoa);

        Pessoa found = this.service.findByName(name);
        assertThat(found.getNome()).isEqualTo(name);
    }

    @Test
    public void mustFindValidSalary() throws Exception {
        final String salary = "1.000,00";
        final List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(this.getPessoa());

        when(this.repo.findBySalario(salary)).thenReturn(pessoaList);

        final List<Pessoa> listFound = this.service.findBySalary(salary);
        assertThat(listFound.get(0).getSalario()).isEqualTo(salary);
        assertThat(listFound.size()).isEqualTo(1);
        assertThat(pessoaList).isNotNull();
    }

    @Test
    public void mustSavePessoa() throws Exception {

        Pessoa pessoa = new Pessoa();
        pessoa.setId(1l);
        pessoa.setNome("Fernando Zandonadi");
        pessoa.setIdade("28");
        pessoa.setSalario("1.800,00");

        when(this.repo.save(pessoa)).thenReturn(pessoa);

        final Pessoa saved = this.service.save(pessoa);
        assertThat(saved).isNotNull();
    }

    private Pessoa getPessoa() {
        final Pessoa pessoa = new Pessoa();
        pessoa.setId(5L);
        pessoa.setNome("Joaquim da Vilas Boas");
        pessoa.setIdade("20");
        pessoa.setSalario("1.000,00");
        return pessoa;
    }

    private List<Pessoa> getListPessoa(){
        final List<Pessoa> pessoaList = new ArrayList<>();
        final Pessoa pessoa = new Pessoa();
        pessoa.setId(5L);
        pessoa.setNome("Joaquim da Vilas Boas");
        pessoa.setIdade("20");
        pessoa.setSalario("1.000,00");
        pessoaList.add(pessoa);

        final Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(4L);
        pessoa1.setNome("José da Silva");
        pessoa1.setIdade("30");
        pessoa1.setSalario("2.000,00");
        pessoaList.add(pessoa1);

        return pessoaList;
    }
}
