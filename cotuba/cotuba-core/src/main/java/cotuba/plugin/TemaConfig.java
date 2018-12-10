package cotuba.plugin;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemaConfig {

	@Bean("temas")
	public ServiceListFactoryBean temasFactory() {
		ServiceListFactoryBean serviceListFactoryBean = new ServiceListFactoryBean();
		serviceListFactoryBean.setServiceType(Tema.class);
		return serviceListFactoryBean;
	}

	@Bean
	public List<Tema> listaDeTemas(@Qualifier("temas") ServiceListFactoryBean temasFactory) {
		try {
			return (List<Tema>) temasFactory.getObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}