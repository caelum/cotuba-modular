package cotuba.domain;

import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;
import cotuba.plugin.GeradorEbook;

public enum FormatoEbook {

	PDF(new GeradorPDF()),
	EPUB(new GeradorEPUB());

	private GeradorEbook gerador;

	private FormatoEbook(GeradorEbook gerador) {
		this.gerador = gerador;
	}

	public GeradorEbook getGerador() {
		return gerador;
	}

}