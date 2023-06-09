package br.com.java9Features;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Java9FeaturesApplicationTests {

private static final Optional<Object> OPTIONAL_EMPTY = Optional.empty();

/* 
	*Static Factory Methods; List - Set- Map
	- Optional.empty
    - Optional.of
    - Optional.ofNullable
	- Collections.unmodifiableList
	- List.of
 */
	@Test
	void optionalEmpty_retornaVazio_quandoSucesso() {
		Optional<Integer> opt = Optional.empty();
		assertEquals(OPTIONAL_EMPTY, opt);
	}

	@Test
	void optionalOf_retornaValorIniciado_quandoSucesso() {
		Optional<Integer> opt = Optional.of(10);
		assertEquals(10, opt.get());
	}

	@Test
	void optionalOfNullable_retornaVazio_quandoSucesso() {
		Optional<Integer> opt = Optional.ofNullable(null);
		assertEquals(OPTIONAL_EMPTY, opt);
	}

	@Test
	void collectionsUnmodifiableList_retornaExcecaoAoTentarAdicionarValorEmListaImutavel_quandoErro() {
		List<Integer> list = new ArrayList<>();
		List<Integer> novaLista = Collections.unmodifiableList(list);
		assertThrows(UnsupportedOperationException.class, () -> adicionaValorNaLista(novaLista).orElseThrow());
	}

	public Optional<List<Integer>> adicionaValorNaLista(List<Integer> novaLista){
		novaLista.add(10);
		return Optional.of(novaLista);
	}
	
	@Test
	void listOf_retornaListaInicializada_quandoSucesso() {
		List<Integer> list = List.of(1, 2, 3, 4, 5);
		assertEquals(List.of(1, 2, 3, 4, 5), list);
	}
}
