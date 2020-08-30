package br.com.digisystem.secondtestdigisystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Fernando Zandonadi
 * @Email ferzan17@gmail.com
 **/
@Data
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {


    /** Se forem realizadas mudanças muito grandes nesta classe,
     * deve-se tambem alterar este valor
     **/
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String idade;

    private String salario;

}
