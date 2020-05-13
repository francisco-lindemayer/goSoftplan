package lab.gosoftplan.remark;

import java.util.List;

public class GeradorObservacao {

	static final String textoCabecalhoSingular = "Fatura da nota fiscal de simples remessa: ";
	static final String textoCabecalhoPlural = "Fatura das notas fiscais de simples remessa: ";
	static final String separadorMeio = ", ";
	static final String separadorFim = " e ";
	static final String pontofinal = ".";

	protected String retornaTextoCabecalho(Integer quantidadeDeNotas) {
		if (quantidadeDeNotas > 1) {
			return textoCabecalhoPlural;
		} else {
			return textoCabecalhoSingular;
		}
	}

	public String geraListagemNotasComValor(List<NotaFiscal> notas) {

		final String cabecalho = retornaTextoCabecalho(notas.size());
		final String precedenteValor = " cujo valor é ";
		final StringBuilder listagemDeNotas = new StringBuilder();
		final int indicePenultimaNota = notas.size() - 2;
		final int indiceUltimaNota = notas.size() - 1;

		if (notas.size() > 0) {

			listagemDeNotas.append(cabecalho);

			for (int indice = 0; notas.size() > indice; indice++) {

				listagemDeNotas.append(notas.get(indice).getNumber());
				listagemDeNotas.append(precedenteValor);
				listagemDeNotas.append(notas.get(indice).getFormattedTotalValue());

				if (indicePenultimaNota == indice) {
					listagemDeNotas.append(separadorFim);
				} else if (indiceUltimaNota == indice) {
					listagemDeNotas.append(pontofinal);
				} else {
					listagemDeNotas.append(separadorMeio);
				}
			}
		}

		return listagemDeNotas.toString();
	}

	public String geraObservacao(List<Integer> notas) {
		final String cabecalho = retornaTextoCabecalho(notas.size());
		final StringBuilder listagemDeNotas = new StringBuilder();
		final int indicePenultimaNota = notas.size() - 2;
		final int indiceUltimaNota = notas.size() - 1;

		if (notas.size() > 0) {

			listagemDeNotas.append(cabecalho);

			for (int indice = 0; notas.size() > indice; indice++) {

				listagemDeNotas.append(notas.get(indice));

				if (indicePenultimaNota == indice) {
					listagemDeNotas.append(separadorFim);
				} else if (indiceUltimaNota == indice) {
					listagemDeNotas.append(pontofinal);
				} else {
					listagemDeNotas.append(separadorMeio);
				}
			}
		}
		return listagemDeNotas.toString();
	}

}