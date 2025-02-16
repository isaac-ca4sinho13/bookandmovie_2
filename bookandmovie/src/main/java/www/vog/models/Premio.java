package www.vog.models;
/*Essa classe é uma agregação, já que, nem todo filme tem um prêmio e nem precisa de um necessariamente. 
Sendo 1 para n, pois um filme pode ter vários prêmios */
import jakarta.persistence.*;

@Entity
public class Premio {
    private String nome;
    private String ano;
    private String categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;
    
    public Premio() {}

    public Premio(String nome, String ano, String categoria){
        this.nome = nome;
        this.ano = ano;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
