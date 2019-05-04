package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Financeiro
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<ContasAReceber> contasAReceber = new ArrayList<>();
    private Universidade universidade;

    public Financeiro(Integer id, Universidade universidade) {
        this.id = id;
        this.universidade = universidade;
    }

    public Financeiro(Universidade universidade) {
        this.universidade = universidade;
    }

    public Financeiro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ContasAReceber> getContasAReceber() {
        return contasAReceber;
    }

    public void setContasAReceber(List<ContasAReceber> contasAReceber) {
        this.contasAReceber = contasAReceber;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }
}
