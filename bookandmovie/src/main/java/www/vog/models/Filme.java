package www.vog.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "Livro")
public class Filme extends Obra {
    @Id
    private String nome;
    private String faturamento;
    private String diretor_a;
    private String estudio;
    private ArrayList<Premio> premios;

public Filme(String nome, String pais_origem, String genero, String classificacaoIndicativa, String faturamento, String diretor_a, 
String estudio, ArrayList<Premio> premios){
    
    super(pais_origem, genero, classificacaoIndicativa);

    this.premios = premios;
    this.faturamento = faturamento;
    this.diretor_a = diretor_a;
    this.estudio = estudio;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(String faturamento) {
        this.faturamento = faturamento;
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

    public ArrayList<Premio> getPremios() {
        return premios;
    }

    public void setPremios(ArrayList<Premio> premios) {
        this.premios = premios;
    }

    // Método para adicionar um prêmio à lista de prêmios
    public void adicionarPremio(Premio premio) {
        this.premios.add(premio);
    }

    public void imprimirInformacoes() {
        System.out.println("Título: " + getNome());
        System.out.println("País de origem: " + getPais_origem());
        System.out.println("genero: " + getGenero());
        System.out.println("Classificação indicativa: " + getClassificacao_indicativa());
        System.out.println("faturamento: " + getFaturamento());
        System.out.println("diretor/a: " + getDiretor_a());
        System.out.println("estudio: " + getEstudio());
        
        if (premios != null && !premios.isEmpty()) {
            System.out.println("Prêmios: ");
            for (Premio premio : premios) {
                System.out.println("  - " + premio.getNome() + " (" + premio.getAno() + ") - Categoria: " + premio.getCategoria());
            }
        } else {
            System.out.println("Nenhum prêmio registrado.");
        }
        System.out.println("---------//--------//---------");
    }

}
