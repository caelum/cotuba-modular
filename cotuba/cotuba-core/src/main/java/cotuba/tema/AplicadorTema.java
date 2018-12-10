package cotuba.tema;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import cotuba.plugin.Tema;

@Component
public class AplicadorTema {

	private final List<Tema> temas;

	public AplicadorTema(List<Tema> temas) {
		this.temas = temas;
	}

	public String aplica(String html) {

		Document document = Jsoup.parse(html);

		for (Tema tema : temas) {
			String css = tema.cssDoTema();
			document.select("head").append("<style> " + css + " </style>");
		}

		return document.html();

	}

}