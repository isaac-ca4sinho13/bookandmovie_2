package www.vog.models;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Filme extends Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nome;
    private String diretor_a;
    private String estudio;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Premio> premios = new ArrayList<>();

    public Filme() {}

public Filme(String nome, String pais_origem, String genero, String classificacaoIndicativa, String diretor_a, 
String estudio, ArrayList<Premio> premios){
    
    super(pais_origem, genero, classificacaoIndicativa);

    this.diretor_a = diretor_a;
    this.estudio = estudio;
}

  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getDiretor_a() {
        return diretor_a;
    }

    public void setDiretor_a(String diretor_a) {
        this.diretor_a = diretor_a;
    }

    
    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;

    }

    public List<Premio> getPremios() {
        return premios;
    }

    public void setPremios(List<Premio> premios) {
        this.premios = premios;
    }


    public void adicionarPremio(Premio premio) {
        premios.add(premio);
        premio.setFilme(this);
    }
}
