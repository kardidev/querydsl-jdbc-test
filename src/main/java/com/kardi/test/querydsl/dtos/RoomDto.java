package com.kardi.test.querydsl.dtos;

public class RoomDto {

    private Integer id;
    private String name;
    private Long ticketCount;

    public RoomDto() {}

    public RoomDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoomDto(Integer id, String name, long count) {
        this.id = id;
        this.name = name;
        this.ticketCount = count;
    }

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

}
