package br.com.forum.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.forum.modelo.Topico;
import br.com.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String mensagem;
	
	public AtualizacaoTopicoForm() {		
	}

	public AtualizacaoTopicoForm(@NotNull @NotEmpty @Length(min = 5) String titulo,
			@NotNull @NotEmpty @Length(min = 5) String mensagem) {	
		this.titulo = titulo;
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Optional<Topico> topico = topicoRepository.findById(id);
		if(topico.isPresent()) {
			topico.get().setTitulo(this.titulo);
			topico.get().setMensagem(this.mensagem);
			return topico.get();
		}else {
			return null;			
		}
	}
	
	

}
