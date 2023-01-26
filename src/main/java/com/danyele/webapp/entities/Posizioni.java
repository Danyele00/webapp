package com.danyele.webapp.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Posizioni")
public class Posizioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "posizione")
    private String posizione;

    @OneToMany(mappedBy = "posizione", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Prodotto> prodotto;

    public Posizioni() {
    }

    public Posizioni(Long id, List<Prodotto> prodotto) {
        this.id = id;
        this.prodotto = prodotto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Prodotto> getProdotto() {
        return prodotto;
    }

    public void setProdotto(List<Prodotto> prodotto) {
        this.prodotto = prodotto;
    }
}
