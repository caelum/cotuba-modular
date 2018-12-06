package cotuba.application;

import java.util.List;

import cotuba.domain.Capitulo;
import cotuba.md.RenderizadorMDParaHTMLComCommonMark;

public interface RenderizadorMDParaHTML {

	List<Capitulo> renderiza(RepositorioDeMDs repositorioDeMDs);

	public static RenderizadorMDParaHTML cria() {
		return new RenderizadorMDParaHTMLComCommonMark();
	}

}