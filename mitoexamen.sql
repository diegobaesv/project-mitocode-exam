
CREATE DATABASE "MITO_EXAM"
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;

\c MITO_EXAM;

CREATE TABLE public.categories
(
    id_category SERIAL PRIMARY KEY,
    title character varying(150) NOT NULL,
    active boolean NOT NULL default true,
    create_at timestamp not null default current_timestamp
);

CREATE TABLE public.products
(
    id_product SERIAL PRIMARY KEY,
    title character varying(150) NOT NULL,
    description character varying(200) NULL,
    price numeric not null default 0,
    active boolean NOT NULL default true,
    create_at timestamp not null default current_timestamp
);

CREATE TABLE public.product_category
(
   id_category    int REFERENCES categories (id_category) ON UPDATE CASCADE ON DELETE CASCADE, 
   id_product int REFERENCES product (id_product) ON UPDATE CASCADE,
   CONSTRAINT product_category_pkey PRIMARY KEY (id_category, id_product)  -- explicit pk
);
