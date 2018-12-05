package cotuba.plugin;

import java.util.ServiceLoader;

import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;

public interface GeradorEbook {

	void gera(Ebook ebook);

	FormatoEbook formato();

	public static GeradorEbook cria(FormatoEbook formato) {
		for (GeradorEbook gerador : ServiceLoader.load(GeradorEbook.class)) {
			if (gerador.formato().equals(formato)) {
				return gerador;
			}
		}
		throw new RuntimeException("Formato do ebook inválido: " + formato);
	}

}
