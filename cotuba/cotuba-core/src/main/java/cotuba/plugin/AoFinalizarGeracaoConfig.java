package cotuba.plugin;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AoFinalizarGeracaoConfig {

	@Bean("finalizacoes")
	public ServiceListFactoryBean finalizacoesFactory() {
		ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
		serviceListFactoryBean.setServiceType(AoFinalizarGeracao.class);
		return serviceListFactoryBean;
	}

	@Bean
	public List<AoFinalizarGeracao> listaDeFinalizacoes(
			@Qualifier("finalizacoes") ServiceListFactoryBean finalizacoesFactory) {
		try {
			return (List<AoFinalizarGeracao>) finalizacoesFactory.getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}