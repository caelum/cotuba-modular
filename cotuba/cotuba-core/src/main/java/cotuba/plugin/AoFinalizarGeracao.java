package cotuba.plugin;

import java.util.function.Consumer;

import cotuba.domain.Ebook;

public interface AoFinalizarGeracao {

	void aposGeracao(Ebook ebook, Consumer<String> acaoPosGeracao);

}