package model.Enum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum StatusContas {

    QUITADO("Quitado",1),
    PENDENTE("Pendente",2),
    AGUARDANDO("Aguardanto",3);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;
    private String descricao;

    StatusContas(String descricao, Integer cod) {
        this.descricao = descricao;
        this.cod = cod;
    }
}
