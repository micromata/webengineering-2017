-- Initialize database on startup. See
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html#howto-initialize-a-database-using-spring-jdbc
-- for explanation. This is a cool spring feature :-).


-- Remove everything.
DELETE FROM POST;
DELETE FROM USER_;

-- Insert new users.
INSERT INTO USER_ (id, email, PASSWORD) VALUES
  (1, 'michael', 'foo'),
  (2, 'kai', 'bar');

-- Add some posts.
INSERT INTO POST (id, title, AUTHOR_ID) VALUES
  (1, 'title-1', 1),
  (2, 'title-2', 2);


