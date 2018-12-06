package cotuba.web.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import cotuba.application.ParametrosCotuba;
import cotuba.domain.FormatoEbook;

public class ParametrosCotubaWeb implements ParametrosCotuba {

	private FormatoEbook formato;
	private Path arquivoDeSaida;

	public ParametrosCotubaWeb(FormatoEbook formato) {
		this.formato = formato;
	}

	@Override
	public FormatoEbook getFormato() {
		return formato;
	}

	@Override
	public Path getArquivoDeSaida() {
		if (arquivoDeSaida != null) {
			return arquivoDeSaida;
		}
		try {
			Path diretorio = Files.createTempDirectory("ebooks");
			String nomeDoArquivoDeSaida = "book." + formato.name().toLowerCase();
			this.arquivoDeSaida = diretorio.resolve(nomeDoArquivoDeSaida);
			return arquivoDeSaida;
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}