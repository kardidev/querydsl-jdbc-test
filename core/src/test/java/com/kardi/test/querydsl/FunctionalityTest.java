package com.kardi.test.querydsl;

import com.querydsl.sql.SQLQuery;
import org.junit.Test;

import java.sql.SQLException;

public class FunctionalityTest extends BaseTest {

    @Test
    public void testSimpleQueryWithTupleMapping() throws SQLException {


        System.out.println(getConnection().getMetaData().getDatabaseProductVersion());

//        QRoom room = QRoom.room;
//
//        SQLQuery<Room> query = getQuery();
//        List list = query
//                .select(room.id, room.name)
//                .from(room)
//                .fetch();
//
//        System.out.println(list.size());
    }

    private <T> SQLQuery<T> getQuery() {
        return new SQLQuery<T>(getConnection(), getSQLTemplates());
    }

}
