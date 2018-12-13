package com.poesifacile.java;

import com.poesifacile.java.repository.UtilisateurRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaApplicationTests {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Test
	public void testConnexionBdd() {
		//Given

		//When
		long nbUtilisateurs = utilisateurRepository.count();
		//Then
		Assert.assertTrue(nbUtilisateurs > 0);
	}

}

