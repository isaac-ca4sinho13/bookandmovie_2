package www.vog.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Livro")
public class Livro extends Obra {
    private String autor_a;
    private int qtd_paginas;
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    

    public Livro() {} 
        
    
    
    public Livro( Long id, String nome, String pais_origem, String genero, String classificacao_indicativa, int qtd_paginas, String autor_a){
        super(pais_origem, genero, classificacao_indicativa);
        this.qtd_paginas = qtd_paginas;
        this.autor_a = autor_a; 
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

    public String getAutor_a() {
        return autor_a;
    }

    public void setAutor_a(String autor_a) {
        this.autor_a = autor_a;
    }

    public int getQtd_paginas() {
        return qtd_paginas;
    }

    public void setQtd_paginas(int qtdPaginas) {
        this.qtd_paginas = qtdPaginas;
    }

    public void imprimirInformacoes() {
        System.out.println("Título: " + getNome());
        System.out.println("País de origem: " + getPais_origem());
        System.out.println("Gênero: " + getGenero());
        System.out.println("Classificação indicativa: " + getClassificacao_indicativa());
        System.out.println("Autor: " + getAutor_a());
        System.out.println("Número de Páginas: " + getQtd_paginas());
}

}