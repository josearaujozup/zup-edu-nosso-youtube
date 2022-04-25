package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class QuantidadeVisualizacoes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private long quantidade;
	
	@Version
    private int versao;
	
	@OneToOne
	private Video video;

	public QuantidadeVisualizacoes(Video video) {
		this.video = video;
		this.quantidade=0;
	}
	
	/**
     * @deprecated
     */
    @Deprecated
	public QuantidadeVisualizacoes() {
		
	}
	
	public void incrementa() {
		this.quantidade++;
	}
	
}
