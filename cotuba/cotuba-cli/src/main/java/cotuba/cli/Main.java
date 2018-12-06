package cotuba.cli;

import java.nio.file.Path;

import cotuba.application.Cotuba;
import cotuba.application.RepositorioDeMDs;
import cotuba.domain.builder.CapituloBuilder;
import cotuba.md.RenderizadorMDParaHTMLComCommonMark;
import cotuba.tema.AplicadorTema;

public class Main {

	public static void main(String[] args) {

		CapituloBuilder builder = new CapituloBuilder();
		RenderizadorMDParaHTMLComCommonMark md = new RenderizadorMDParaHTMLComCommonMark();
		AplicadorTema tema = new AplicadorTema();

		LeitorOpcoesCLI opcoesCLI = new LeitorOpcoesCLI(args);

		Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
		boolean modoVerboso = opcoesCLI.isModoVerboso();

		Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();

		try {

			RepositorioDeMDs repositorio = new MDsDoDiretorio(diretorioDosMD);

			Cotuba cotuba = new Cotuba();
			cotuba.executa(opcoesCLI, System.out::println, repositorio);

			System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

}
