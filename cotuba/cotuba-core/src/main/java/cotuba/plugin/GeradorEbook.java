package cotuba.plugin;

import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;

public interface GeradorEbook {

	void gera(Ebook ebook);

	FormatoEbook formato();

}
