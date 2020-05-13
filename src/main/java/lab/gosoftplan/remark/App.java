package lab.gosoftplan.remark;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        GeradorObservacao gerador = new GeradorObservacao();

        final List<NotaFiscal> notas = new ArrayList<NotaFiscal>();

        notas.add(new NotaFiscal("12", 35.50));
        notas.add(new NotaFiscal("13", 25.10));
        notas.add(new NotaFiscal("14", 10.00));

        final String observacaoRetornada = gerador.geraListagemNotasComValor(notas);

        System.out.println(observacaoRetornada);

    }
}
