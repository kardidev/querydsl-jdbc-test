package com.kardi.test.querydsl.entities;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "roomname", nullable = false)
    private String roomName;

    @Column(name = "creator_client_id", nullable = false)
    private Integer clientCreatorId;

    @ManyToOne
    @JoinColumn(name = "roomname", referencedColumnName = "name", insertable = false, updatable = false)
    private Room room;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getClientCreatorId() {
        return clientCreatorId;
    }

    public void setClientCreatorId(Integer clientCreatorId) {
        this.clientCreatorId = clientCreatorId;
    }

    public Room getRoom() {
        return room;
    }
}
