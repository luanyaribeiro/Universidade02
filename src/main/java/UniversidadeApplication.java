import model.Aluno;
import model.Curso;
import model.Universidade;
import services.ContasAReceberService;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UniversidadeApplication {

    public static void  main (String[] args){

        Universidade universidade = new Universidade();
        universidade.setId(null);
        universidade.setNome("Estudando que se aprende");
        universidade.setCnpj(123145648);

        Curso curso = new Curso();
        curso.setId(null);
        curso.setNome("Sistemas de informação");
        curso.setValorMensalidade(new BigDecimal(800.00));

        Aluno aluno1 = new Aluno(null,"Luany",988098,new Date(1996,11,4),new Date(2012,1,1),curso);
        universidade.getAlunos().add(new Aluno(null,"Luany",988098,new Date(1996,11,4),new Date(2012,1,1),curso));
        universidade.getAlunos().add(new Aluno(null,"Marcos",988099,new Date(1995,01,18),new Date(2012,1,1),curso));
        universidade.getAlunos().add(new Aluno(null,"Raiana",988010,new Date(2000,04,15),new Date(2012,1,1),curso ));


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ContasAReceberService contasAReceberService = new ContasAReceberService();
        try {
            contasAReceberService.lancarContasAReceber(aluno1, universidade, LocalDate.parse("02/02/2018",formatter));
        } catch (ValidationException e) {
            System.out.println("Não foi possivel realizar a operação " + e.getMessage());
        }

        contasAReceberService.acionarCobrancas(universidade);
    }
}
