-- Initialize database on startup. See
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html#howto-initialize-a-database-using-spring-jdbc
-- for explanation. This is a cool spring feature :-).


-- Remove everything.
DELETE FROM POST_COMMENTS;
DELETE FROM COMMENT;
DELETE FROM POST;
DELETE FROM USER_;


-- Insert new users.
INSERT INTO USER_ (id, email, PASSWORD) VALUES
  (1, 'michael', 'c5ce3a9cb904b362072cabbdaeef90d5bd73680a478b509ebf1d013b4ad77b92e7706114a5bbbf160715396606e01fbfb2cc4ef5bffef4cfd0dea74ca04f2f5f'), -- foo
  (2, 'kai',     '9036c1111fdcbfa01a60a3f5d4647e7369caf5153b5e65eb7f45688748d070157fe9b62650ee564fbbcb42e6efc79df3238b8e1c10325b2e998f6d882e4d2071');     -- bar

-- Add some posts.
-- Used search terms "h2 timestamp", the second link lead to parsedatetime.
-- Note that JPA transforms your column names from camelCase to camel_case using underscores.
INSERT INTO POST (ID, TITLE, CREATED_AT, AUTHOR_ID) VALUES
  (1, 'title-1', parsedatetime('2017-05-20 05:01', 'yyyy-MM-dd HH:mm'), 1),
  (2, 'title-2', parsedatetime('2017-05-21 12:01', 'yyyy-MM-dd HH:mm'), 2);

-- Add some comments.
INSERT INTO COMMENT (ID, CREATED_AT, AUTHOR_ID, TEXT) VALUES
  (1, parsedatetime('2017-05-20 05:01', 'yyyy-MM-dd HH:mm'), 1, 'comment-1'),
  (2, parsedatetime('2017-05-20 06:01', 'yyyy-MM-dd HH:mm'), 1, 'comment-2'),
  (3, parsedatetime('2017-05-20 05:01', 'yyyy-MM-dd HH:mm'), 2, 'comment-3');

-- Link posts and comments.
INSERT INTO POST_COMMENTS (POST_ID, COMMENTS_ID) VALUES
  (1, 1),
  (1, 2),
  (2, 3);
