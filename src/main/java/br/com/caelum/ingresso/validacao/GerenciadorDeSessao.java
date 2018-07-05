package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {

	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	private boolean horarioIsConflitante(Sessao sNova, Sessao sExist) {
		
		boolean terminaAntes = sNova.getHorarioTermino().isBefore(sExist.getHorarioTermino());
		
		boolean comecaDepois = sExist.getHorarioTermino().isBefore(sNova.getHorarioTermino());
		
		
		if (terminaAntes || comecaDepois) {
			return false;
		}
		return true;
	}
	
	

	public boolean cabe(Sessao sessaoNova) {
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));
	}

}
