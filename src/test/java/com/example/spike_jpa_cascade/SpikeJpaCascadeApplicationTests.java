package com.example.spike_jpa_cascade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpikeJpaCascadeApplicationTests {

	@Autowired
	PessoaRepo pessoaRepo;

	@Autowired
	ProfissaoRepo profissaoRepo;

	@Test
	void deveCadastrarEExcluirComSucesso() {

		Profissao profissao = new Profissao().setNome("Dev");

		profissao = profissaoRepo.saveAndFlush(profissao);

		Pessoa pessoa = new Pessoa().setNome("Alisson").setProfissao(profissao);
		Pessoa pessoa2 = new Pessoa().setNome("Alisson 2").setProfissao(profissao);

		pessoa = pessoaRepo.saveAndFlush(pessoa);
		pessoa2 = pessoaRepo.saveAndFlush(pessoa2);

		System.out.println();

//		profissaoRepo.delete(profissao); Anotando a profissao com @OnDelete(action = OnDeleteAction.CASCADE) quando deletada, exclui os filhos tbm (Pessoa)

		//Para deletar um child (pessoa), deve buscar sempre do banco novamente todas as entidades nos testes unitarios, assim carrega tudo no objeto....

		Pessoa pessoaDelete = pessoaRepo.findById(1L).get();

		profissao = profissaoRepo.findById(1L).get();

		//Foi necessario copiar do drive, o metodo na classe pai que exclui por la o filho com o metodo removeIf, necessario usar fetch EAGER

		profissao.deletarPessoa(pessoaDelete);

		profissao = profissaoRepo.saveAndFlush(profissao);

		System.out.println();
	}

}
