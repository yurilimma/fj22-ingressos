package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;

public class SessaoForm {
	
	//pode vir nulo pois no banco esta autoincrement / generate value
	private Integer id;
	@NotNull
	private Integer salaId;
	@DateTimeFormat(pattern="HH:mm")
	@NotNull
	private LocalTime horario;
	@NotNull
	private Integer filmeId;
	
	
	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao){
		Filme filme = filmeDao.findOne(filmeId);
		Sala sala = salaDao.findOne(salaId);
		
		Sessao sessao = new Sessao(horario,filme,sala, BigDecimal.ONE);
		sessao.setId(id);
		
		return sessao;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getSalaId() {
		return salaId;
	}


	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}


	public LocalTime getHorario() {
		return horario;
	}


	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}


	public Integer getFilmeId() {
		return filmeId;
	}


	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

}
