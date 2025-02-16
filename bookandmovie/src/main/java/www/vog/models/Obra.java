package www.vog.models;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;

@MappedSuperclass
public abstract class Obra {
   

    @Column(name = "pais_origem")
    private String pais_origem;
    
    @Column(name = "genero")
    private String genero;
    
    @Column(name = "classificacao_indicativa")
    private String classificacao_indicativa;

    public Obra() {
    }
    

    
    public Obra(String pais_origem, String genero, String classificacao_indicativa){
        this.pais_origem = pais_origem;
        this.genero = genero;
        this.classificacao_indicativa = classificacao_indicativa;

    }


    
    public String getPais_origem() {
        return pais_origem;
    }

    public void setPais_origem(String paisOrigem) {
        this.pais_origem = paisOrigem;
    }

  
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    public String getClassificacao_indicativa() {
        return classificacao_indicativa;
    }

    public void setClassificacao_indicativa(String classificacaoIndicativa) {
        this.classificacao_indicativa = classificacaoIndicativa;
    }
}

