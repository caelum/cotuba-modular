package cotuba.web.application;

import java.nio.file.Path;

import org.springframework.stereotype.Service;

import cotuba.application.Cotuba;
import cotuba.application.ParametrosCotuba;
import cotuba.application.RepositorioDeMDs;
import cotuba.domain.FormatoEbook;
import cotuba.web.domain.Livro;

@Service
public class GeracaoDeLivros {

	private final CadastroDeLivros livros;

	public GeracaoDeLivros(CadastroDeLivros livros) {
		this.livros = livros;
	}

	public Path geraLivro(Long id, FormatoEbook formato) {
		Livro livro = livros.detalha(id);

		Cotuba cotuba = new Cotuba();

		ParametrosCotuba parametros = new ParametrosCotubaWeb(formato);
		RepositorioDeMDs mdsDoBD = new MDsDoBancoDeDados(livro);

		cotuba.executa(parametros, System.out::println, mdsDoBD);

		return parametros.getArquivoDeSaida();
	}

}
