package cotuba.cli;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		CotubaCLI cli = context.getBean(CotubaCLI.class);
		cli.executa(args);

	}

}