package cotuba.cli;

import java.nio.file.Path;

import org.springframework.stereotype.Component;

import cotuba.application.Cotuba;
import cotuba.application.RepositorioDeMDs;

@Component
public class CotubaCLI {

	private final Cotuba cotuba;

	public CotubaCLI(Cotuba cotuba) {
		this.cotuba = cotuba;
	}

	public void executa(String[] args) {

		LeitorOpcoesCLI opcoesCLI = new LeitorOpcoesCLI(args);

		Path arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
		boolean modoVerboso = opcoesCLI.isModoVerboso();

		Path diretorioDosMD = opcoesCLI.getDiretorioDosMD();

		try {

			RepositorioDeMDs repositorio = new MDsDoDiretorio(diretorioDosMD);

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
