package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class QuantidadeGostei {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private long quantidade;
	
	@Version
    private int versao;
	
	@OneToOne
	private Video video;

	public QuantidadeGostei(Video video) {
		this.video = video;
		this.quantidade=0;
	}
	
	/**
     * @deprecated
     */
    @Deprecated
	public QuantidadeGostei() {
		
	}
	
	public void incrementa() {
		this.quantidade++;
	}
	
}
