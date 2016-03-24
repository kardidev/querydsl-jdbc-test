package com.kardi.test.querydsl;

public class QueryCombinationsTest {

//    private static final Logger logger = LoggerFactory.getLogger(QueryCombinationsTest.class);
//
//    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/htest";
//
//    private Connection connection;
//    private SQLTemplates dialect = new MySQLTemplates();
//
//    @BeforeClass
//    public static void prepare() throws ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
//    }
//
//    @Before
//    public void setUp() throws SQLException {
//        connection = DriverManager.getConnection(CONNECTION_STRING, "root", "1234567890");
//    }
//
//    @After
//    public void tearDown() throws SQLException {
//        connection.close();
//    }
//
//    @Test
//    public void testSimpleQueryWithTupleMapping() {
//        QRoom room = QRoom.room;
//
//        SQLQuery<Room> query = getQuery();
//        List list = query
//                .select(room.id, room.name)
//                .from(room)
//                .fetch();
//
//        logger.debug("testSimpleQueryWithTupleMapping: " + list.size());
//    }
//
//    @Test
//    public void testSimpleQueryWithDtoMapping() {
//        QRoom room = QRoom.room;
//
//        SQLQuery<Room> query = getQuery();
//        List<RoomDto> list = query
//                .select(Projections.bean(RoomDto.class, room.id, room.name))
//                .from(room)
//                .fetch();
//
//        logger.debug("testSimpleQueryWithDtoMapping: " + list.size());
//    }
//
//    @Test
//    public void testLeftJoin() {
//        QRoom room = QRoom.room;
//        QTicket ticket = QTicket.ticket;
//
//        SQLQuery<Room> query = getQuery();
//        List list = query
//                .select(room.id, room.name, ticket.id)
//                .from(room)
//                .leftJoin(ticket).on(room.name.eq(ticket.roomname))
//                .fetch();
//
//        logger.debug("testLeftJoin: " + list.size());
//    }
//
//    @Test
//    public void testHavingWithConstructorMapping() {
//        QRoom room = QRoom.room;
//        QTicket ticket = QTicket.ticket;
//
//        SQLQuery<Ticket> query = getQuery();
//        List list = query
//                .select(Projections.constructor(RoomDto.class, room.id, room.name, ticket.id.countDistinct()))
//                .from(ticket)
//                .rightJoin(room).on(room.name.eq(ticket.roomname))
//                .groupBy(room.id)
//                .having(ticket.id.countDistinct().gt(0))
//                .fetch();
//
//        logger.debug("testHavingWithConstructorMapping: " + list.size());
//    }
//
//    @Test
//    public void testSelectInWhereClause() {
//        QClient client = QClient.client;
//        QNote note = QNote.note;
//        QNote noteSub = new QNote("subnote");
//
//        SQLQuery<Client> query = getQuery();
//        List list = query
//                .select(client.id, client.name, note.id, note.message)
//                .from(client)
//                .leftJoin(note).on(note.clientId.eq(client.id))
//                .where(note.id.eq(
//                        SQLExpressions
//                                .select(noteSub.id.max())
//                                .from(noteSub)
//                                .where(noteSub.clientId.eq(client.id))
//                ))
//                .fetch();
//
//        logger.debug("testSelectInWhereClause: " + list.size());
//    }
//
//    @Test
//    public void testPagination() {
//        QTicket ticket = QTicket.ticket;
//
//        List list = getQuery()
//                .select(ticket.id)
//                .from(ticket)
//                .offset(1)
//                .limit(2)
//                .fetch();
//
//        logger.debug("testPagination: " + list.size());
//    }
//
//    private <T> SQLQuery<T> getQuery() {
//        return new SQLQuery<T>(connection, dialect);
//    }
}
