-- This works every time since we have an in-memory-database.
--
-- Remove everything.
-- DELETE FROM POST_COMMENTS;
-- DELETE FROM COMMENT;
-- DELETE FROM POST;
-- DELETE FROM USER_;


-- Insert new users.
INSERT INTO USER_ (id, email, PASSWORD) VALUES
  (1, 'michael', 'c5ce3a9cb904b362072cabbdaeef90d5bd73680a478b509ebf1d013b4ad77b92e7706114a5bbbf160715396606e01fbfb2cc4ef5bffef4cfd0dea74ca04f2f5f'), -- foo
  (2, 'kai',     '9036c1111fdcbfa01a60a3f5d4647e7369caf5153b5e65eb7f45688748d070157fe9b62650ee564fbbcb42e6efc79df3238b8e1c10325b2e998f6d882e4d2071');     -- bar
