package cotuba.application;

import java.util.List;

import cotuba.domain.Capitulo;

public interface RenderizadorMDParaHTML {

	List<Capitulo> renderiza(RepositorioDeMDs repositorioDeMDs);

}