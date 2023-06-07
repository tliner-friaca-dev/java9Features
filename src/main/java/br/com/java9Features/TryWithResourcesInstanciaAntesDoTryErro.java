package br.com.java9Features;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TryWithResourcesInstanciaAntesDoTryErro {

	public static void main(String[] args) {
		SpringApplication.run(TryWithResourcesInstanciaAntesDoTryErro.class, args);
		
		System.out.println("\n------------------------------------------------------------------------------------------------------");
		System.out.println("Instâncias antes da declaração do Try!!!\n");
		System.out.println("Com este tipo de declaração, passando os recursos por parâmetro para o Try, temos um ponto de anteção.");
		System.out.println("Caso ocorra uma exceção algum recurso pode não ser fechado!!!");
		System.out.println("------------------------------------------------------------------------------------------------------\n");

        RecursoA recursoA = new RecursoA();
        RecursoB recursoB = new RecursoB();
        
		try (recursoA; recursoB) {
            
            System.out.println("Try");

        } catch (Exception e) {
			System.err.println("Catch");
		}

	}

	static public class RecursoA implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("Recurso - Close = fechou corretamente o RecursoA");
        }
        
    }

	static public class RecursoB implements AutoCloseable {

        public RecursoB() {
            throw new RuntimeException("Erro ao chamar o RecursoB");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Recurso - Close = fechou corretamente o RecursoB");
        }
        
    }
}
