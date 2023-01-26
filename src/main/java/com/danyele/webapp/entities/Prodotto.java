package com.danyele.webapp.entities;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Entity
@Table(name = "Prodotto")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotti")
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "descrizione", nullable = false)
    private String descrizione;
    @Column(name = "prezzo", nullable = false)
    private Double prezzo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_posizione", nullable = false)
    private Posizioni posizione;


    public Prodotto (){};

    public Prodotto(String nome, String descrizione, Double prezzo, Posizioni posizione){
        this.nome=nome;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        this.posizione=posizione;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
