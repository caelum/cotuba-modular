package cotuba.web.application;

import org.springframework.stereotype.Service;

@Service
public class GeracaoDeLivros {

	private final CadastroDeLivros livros;

	public GeracaoDeLivros(CadastroDeLivros livros) {
		this.livros = livros;
	}
}
