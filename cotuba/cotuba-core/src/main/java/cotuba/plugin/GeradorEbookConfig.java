package cotuba.plugin;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cotuba.domain.FormatoEbook;

@Configuration
public class GeradorEbookConfig {

	@Bean("geradores")
	public ServiceListFactoryBean geradoresFactory() {
		ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
		serviceListFactoryBean.setServiceType(GeradorEbook.class);
		return serviceListFactoryBean;
	}

	@Bean
	public Map<FormatoEbook, GeradorEbook> formatosParaGeradores(
			@Qualifier("geradores") ServiceListFactoryBean geradoresFactory) {
		try {
			List<GeradorEbook> geradores = (List<GeradorEbook>) geradoresFactory.getObject();
			return geradores.stream().collect(Collectors.toMap(GeradorEbook::formato, Function.identity()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}