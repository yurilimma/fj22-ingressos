package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala){
		this.sessoesDaSala = sessoesDaSala;
	}
	
	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova){
		
		LocalTime horarioSessaoExistente = sessaoExistente.getHorario();
		LocalTime horarioSessaoNova = sessaoNova.getHorario();
		
		boolean terminaAntes = sessaoNova.getHoraTermino().isBefore(horarioSessaoExistente);
		boolean comecaDepois = sessaoExistente.getHoraTermino().isBefore(horarioSessaoNova);
		
		
		if(terminaAntes || comecaDepois){
			return false;
		}
		return true;
	}
	
	public boolean cabe(Sessao sessaoNova){
		//comando Java 8, percorre uma Lista por foreach e compara a mesma
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente,sessaoNova));
	}

	public List<Sessao> getSessoesDaSala() {
		return sessoesDaSala;
	}

	public void setSessoesDaSala(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

}
