PGDMP         /                x            zoo    12.2    12.2                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    49152    zoo    DATABASE     �   CREATE DATABASE zoo WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE zoo;
                postgres    false            �            1259    49168    animales    TABLE     -  CREATE TABLE public.animales (
    descripcion character varying(30) NOT NULL,
    circulacion character varying(30),
    alimentacion character varying(30),
    altura numeric(10,2),
    peso numeric(10,2),
    edad integer,
    atributo character varying(30),
    categoria character varying(10)
);
    DROP TABLE public.animales;
       public         heap    postgres    false            �
          0    49168    animales 
   TABLE DATA           s   COPY public.animales (descripcion, circulacion, alimentacion, altura, peso, edad, atributo, categoria) FROM stdin;
    public          postgres    false    202   @       ~
           2606    49172    animales animales_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.animales
    ADD CONSTRAINT animales_pkey PRIMARY KEY (descripcion);
 @   ALTER TABLE ONLY public.animales DROP CONSTRAINT animales_pkey;
       public            postgres    false    202            �
   q   x�;ܘ^�������^��������W�ʙ�X���ihj�g`�if"8�K���9�R�a:܊29���3���9!J-�A��gdiEIbAijqIb1gPjAIfW� ��#�     