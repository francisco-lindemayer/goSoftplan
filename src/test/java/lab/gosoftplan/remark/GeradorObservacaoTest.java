package lab.gosoftplan.remark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeradorObservacaoTest {

    @Test
    public void obterTemplateSingular() {

        final String cabecalhoEsperado = "Fatura da nota fiscal de simples remessa: ";
        final String mensagemFalha = "Corpo do cabeçalho de observações não é o esperado";

        final GeradorObservacao gerador = new GeradorObservacao();
        final String cabecalho = gerador.retornaTextoCabecalho(1);

        assertEquals(cabecalhoEsperado, cabecalho, mensagemFalha);
    }

    @Test
    public void geraCabecalhoPlural() {

        final String cabecalhoEsperado = "Fatura das notas fiscais de simples remessa: ";
        final String mensagemFalha = "Corpo do cabeçalho de observações não é o esperado";

        final GeradorObservacao gerador = new GeradorObservacao();
        final String cabecalho = gerador.retornaTextoCabecalho(2);

        assertEquals(cabecalhoEsperado, cabecalho, mensagemFalha);
    }

    @Test
    public void geraObservacaoUmaNota() {

        final String observacaoEsperada = "Fatura da nota fiscal de simples remessa: 12.";
        final String mensagemFalha = "Corpo do texto de observações não é o esperado";

        GeradorObservacao gerador = new GeradorObservacao();
        List<Integer> notas = Arrays.asList(12);

        final String observacaoRetornada = gerador.geraObservacao(notas);

        assertEquals(observacaoEsperada, observacaoRetornada, mensagemFalha);
    }

    @Test
    public void geraObservacaoMultiplasNotas() {

        final String observacaoEsperada = "Fatura das notas fiscais de simples remessa: 12, 13 e 15.";
        final String mensagemFalha = "Corpo do texto de observações não é o esperado";

        GeradorObservacao gerador = new GeradorObservacao();
        List<Integer> notas = Arrays.asList(12, 13, 15);

        final String observacaoRetornada = gerador.geraObservacao(notas);

        assertEquals(observacaoEsperada, observacaoRetornada, mensagemFalha);
    }

    @Test
    public void geraListagemFaturaComValor() {

        final String observacaoEsperada = "Fatura das notas fiscais de simples remessa: 12 cujo valor é R$ 35,50, 13 cujo valor é R$ 25,10 e 14 cujo valor é R$ 10,00.";
        final String mensagemFalha = "Corpo do texto de observações não é o esperado";

        final GeradorObservacao gerador = new GeradorObservacao();
        final List<NotaFiscal> notas = new ArrayList<NotaFiscal>();

        notas.add(new NotaFiscal("12", 35.50));
        notas.add(new NotaFiscal("13", 25.10));
        notas.add(new NotaFiscal("14", 10.00));

        final String observacaoRetornada = gerador.geraListagemNotasComValor(notas);

        assertEquals(observacaoEsperada, observacaoRetornada, mensagemFalha);

    }

}