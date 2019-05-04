package services;

import model.Aluno;
import model.ContasAReceber;
import model.Enum.StatusContas;
import model.Universidade;

import javax.xml.bind.ValidationException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class ContasAReceberService {

    public ContasAReceberService() {
    }

    public void lancarContasAReceber(Aluno aluno, Universidade universidade, LocalDate dataVencimento) throws ValidationException {

        if(aluno == null){
            throw new ValidationException("Aluno inválido!");
        }

        if(universidade == null){
            throw new ValidationException("Universidade inválida!");
        }

        ContasAReceber contasAreceber = new ContasAReceber();
        contasAreceber.setId(null);
        contasAreceber.setAluno(aluno);
        contasAreceber.setDataVencimento(dataVencimento);
        contasAreceber.setValorAReceber(aluno.getCurso().getValorMensalidade());
        contasAreceber.setStatusConta(StatusContas.AGUARDANDO);
        contasAreceber.setFinanceiro(universidade.getFinanceiro());
        universidade.getFinanceiro().getContasAReceber().add(contasAreceber);

    }

    public void acionarCobrancas(Universidade universidade){
        Calendar cal = Calendar.getInstance();
        TimeZone tz = cal.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        LocalDateTime.ofInstant(cal.toInstant(), zid);

        List<Aluno> alunosReceberCobranca = new ArrayList<>();
        for(ContasAReceber contas : universidade.getFinanceiro().getContasAReceber()){
            if(contas.getDataVencimento().isBefore(LocalDateTime.ofInstant(cal.toInstant(), zid).toLocalDate())) {
                alunosReceberCobranca.add(contas.getAluno());
            }
        }

        if(!alunosReceberCobranca.isEmpty())
            enviarAlunosSistemaCobranca(alunosReceberCobranca);
    }

    private void enviarAlunosSistemaCobranca(List<Aluno> alunosReceberCobranca) {
        try {
            ICobrancaService servicoCobranca = (ICobrancaService) Naming.lookup("//localhost/cobranca");
            String msg = servicoCobranca.emailCobrancaServico("Luany@legal.com", "Pague suas contas, bonita!");
            System.out.println(msg);
        } catch (MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }

}
