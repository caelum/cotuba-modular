package cotuba.application;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.stereotype.Component;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;
import cotuba.plugin.AoFinalizarGeracao;
import cotuba.plugin.GeradorEbook;

@Component
public class Cotuba {

	private final RenderizadorMDParaHTML renderizador;
	private final Map<FormatoEbook, GeradorEbook> geradores;
	private final List<AoFinalizarGeracao> finalizacoes;

	public Cotuba(RenderizadorMDParaHTML renderizador, Map<FormatoEbook, GeradorEbook> geradores,
			List<AoFinalizarGeracao> finalizacoes) {
		this.renderizador = renderizador;
		this.geradores = geradores;
		this.finalizacoes = finalizacoes;
	}

	public void executa(ParametrosCotuba parametros, Consumer<String> acaoPosGeracao,
			RepositorioDeMDs repositorioDeMDs) {

		FormatoEbook formato = parametros.getFormato();
		Path arquivoDeSaida = parametros.getArquivoDeSaida();

		List<Capitulo> capitulos = renderizador.renderiza(repositorioDeMDs);

		Ebook ebook = new Ebook(formato, arquivoDeSaida, capitulos);

		GeradorEbook gerador = geradores.get(formato);
		if (gerador == null) {
			throw new RuntimeException("Não há gerador de livro para o formato " + formato);
		}
		gerador.gera(ebook);

		for (AoFinalizarGeracao finalizacao : finalizacoes) {
			finalizacao.aposGeracao(ebook, acaoPosGeracao);
		}
	}

}