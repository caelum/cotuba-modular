package cotuba.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cotuba.web.application.CadastroDeCapitulos;
import cotuba.web.application.CadastroDeLivros;
import cotuba.web.domain.Capitulo;

@Controller
public class CapitulosController {

	private final CadastroDeLivros livros;
	private final CadastroDeCapitulos capitulos;
	
	public CapitulosController(CadastroDeLivros livros, CadastroDeCapitulos capitulos) {
		this.livros = livros;
		this.capitulos = capitulos;
	}

	@GetMapping("/livros/{livroId}/capitulos/{capituloId}")
	public String lista(@PathVariable("livroId") Long livroId, @PathVariable("capituloId") Long capituloId, Model model) {
		model.addAttribute("livro", livros.detalha(livroId));
		model.addAttribute("capitulo", capitulos.detalha(capituloId));
		return "capitulos/detalhe";
	}

	@PostMapping("/livros/{livroId}/capitulos/{capituloId}")
	public String lista(@PathVariable("livroId") Long livroId, @PathVariable("capituloId") Long capituloId, Capitulo capitulo) {
		capitulos.atualiza(capitulo);
		return "redirect:/livros/"+livroId;
	}

}
