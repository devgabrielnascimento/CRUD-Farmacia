package com.generation.farmacia.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.generation.farmacia.model.Categoria;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoriaControllerTest {
	
		@Autowired

		private TestRestTemplate testRestTemplate;

		@Test
		@DisplayName("Cadastrar uma categoria")
		public void deveCriarUmaCategoria() {

			HttpEntity<Categoria> corpoRequisicao = new HttpEntity<Categoria>(
					new Categoria(0L, "Genérico", ".................."));

			ResponseEntity<Categoria> corpoResposta = testRestTemplate.exchange("/categorias/cadastrar", HttpMethod.POST,
					corpoRequisicao, Categoria.class);

			assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());

		}

}


