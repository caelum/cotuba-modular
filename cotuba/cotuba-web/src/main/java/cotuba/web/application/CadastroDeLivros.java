package cotuba.web.application;

import java.util.List;

import org.springframework.stereotype.Service;

import cotuba.web.domain.Livro;

@Service
public class CadastroDeLivros {

	private final RepositorioDeLivros repositorio;

	public CadastroDeLivros(RepositorioDeLivros repositorio) {
		this.repositorio = repositorio;
	}

	public List<Livro> listagem() {
		return repositorio.findAll();
	}

	public Livro detalha(Long id) {
		return repositorio.getOne(id);
	}
}
