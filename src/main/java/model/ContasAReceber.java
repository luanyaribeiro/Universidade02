package model;

import model.Enum.StatusContas;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;


@Entity
public class ContasAReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="aluno_id")
    private Aluno aluno;

    private LocalDate dataVencimento;
    private BigDecimal valorAReceber;

    @ManyToOne
    @JoinColumn(name="status_conta_id")
    private StatusContas statusConta;

    @ManyToOne
    @JoinColumn(name="financeiro_id")
    private Financeiro financeiro;

    public ContasAReceber() {
    }

    public ContasAReceber(Integer id, Aluno aluno, LocalDate dataVencimento, BigDecimal valorAReceber, StatusContas statusConta, Financeiro financeiro) {
        this.id = id;
        this.aluno = aluno;
        this.dataVencimento = dataVencimento;
        this.valorAReceber = valorAReceber;
        this.statusConta = statusConta;
        this.financeiro = financeiro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorAReceber() {
        return valorAReceber;
    }

    public void setValorAReceber(BigDecimal valorAReceber) {
        this.valorAReceber = valorAReceber;
    }

    public StatusContas getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusContas statusConta) {
        this.statusConta = statusConta;
    }

    public Financeiro getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(Financeiro financeiro) {
        this.financeiro = financeiro;
    }
}
