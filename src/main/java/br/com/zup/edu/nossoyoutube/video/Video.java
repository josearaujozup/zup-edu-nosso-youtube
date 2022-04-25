package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String link;
    
    
    @OneToOne(mappedBy = "video", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeVisualizacoes visualizacoes;
    
    @OneToOne(mappedBy = "video", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeGostei gostei;//joinha para cima
    
    
    @Column(nullable = false)
    private Integer naoGostei;//joinha para baixo
    
    @Version
    private int versao; 

    public Video(String titulo, String descricao, String link) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.visualizacoes = new QuantidadeVisualizacoes(this);
        this.gostei = new QuantidadeGostei(this);
        this.naoGostei=0;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Video() {
    }

    public Long getId() {
        return id;
    }

	public void aumentarVisualizacao() {
		this.visualizacoes.incrementa();
	}

	public void aumentarGostei() {
		this.gostei.incrementa();
	}
}
