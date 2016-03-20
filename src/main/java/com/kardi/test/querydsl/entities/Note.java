package com.kardi.test.querydsl.entities;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "client_id")
    private Integer clientId;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Client client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
