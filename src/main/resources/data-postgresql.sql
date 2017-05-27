-- Initialize database on startup. See
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html#howto-initialize-a-database-using-spring-jdbc
-- for explanation. This is a cool spring feature :-).


-- Remove everything.
-- DELETE FROM POST_COMMENTS;
-- DELETE FROM COMMENT;
-- DELETE FROM POST;
-- DELETE FROM USER_;
--
--
-- -- Insert new users.
-- INSERT INTO USER_ (id, email, PASSWORD) VALUES
--   (1, 'michael', 'be799e1ee6265c7f0d512b10d20b8a9a9c70d61d544976e61901a1ff24c77a1cb5132f771bb5a5885064302d175e0e0fc79590140e36488559f3d493c1282c95'), -- foo
--   (2, 'kai',     '63fedb58181d7091ed433e9280a71829a4c81ce3d2e8ec1dc57d4814755194ee2748aec72ab78c9879be4b89db052d12e83e9dd7d9b36c2e79ad026e7d0eb6ff');     -- bar

