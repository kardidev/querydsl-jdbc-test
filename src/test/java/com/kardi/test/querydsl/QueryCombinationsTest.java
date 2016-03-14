package com.kardi.test.querydsl;

import com.kardi.test.querydsl.entities.QRoom;
import com.kardi.test.querydsl.entities.QTicket;
import com.kardi.test.querydsl.entities.Room;
import com.kardi.test.querydsl.entities.Ticket;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLTemplates;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class QueryCombinationsTest {

    private static final Logger logger = LoggerFactory.getLogger(QueryCombinationsTest.class);

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/htest";

    private Connection connection;
    private SQLTemplates dialect = new MySQLTemplates();

    @BeforeClass
    public static void prepare() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    @Before
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection(CONNECTION_STRING, "root", "1234567890");
    }

    @After
    public void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    public void testSimpleQuery() {
        QRoom room = QRoom.room;

        SQLQuery<Room> query = getQuery();
        List list = query.select(room.id, room.name).from(room).fetch();

        logger.debug("testSimpleQuery: " + list.size());
    }

    @Test
    public void testLeftJoin() {
        QRoom room = QRoom.room;
        QTicket ticket = QTicket.ticket;

        SQLQuery<Room> query = getQuery();
        List list = query
                .select(room.id, room.name, ticket.id)
                .from(room)
                .leftJoin(ticket).on(room.name.eq(ticket.roomName))
                .fetch();

        logger.debug("testLeftJoin: " + list.size());
    }

    @Test
    public void testHaving() {
        QRoom room = QRoom.room;
        QTicket ticket = QTicket.ticket;

        SQLQuery<Ticket> query = getQuery();
        List list = query
                .select(room.id, room.name, ticket.id.countDistinct())
                .from(ticket)
                .rightJoin(room).on(room.name.eq(ticket.roomName))
                .groupBy(room.id)
                .having(ticket.id.countDistinct().gt(0))
                .fetch();

        logger.debug("testHaving: " + list.size());
    }

    private <T> SQLQuery<T> getQuery() {
        return new SQLQuery<T>(connection, dialect);
    }
}
