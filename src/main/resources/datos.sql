PGDMP  5    '                |            LIGABETPLAY    16.3 (Debian 16.3-1.pgdg120+1)    16.2     %           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            &           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            '           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            (           1262    16384    LIGABETPLAY    DATABASE     x   CREATE DATABASE "LIGABETPLAY" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE "LIGABETPLAY";
                hazzard    false            �            1259    16385    equipo    TABLE     �  CREATE TABLE public.equipo (
    id bigint NOT NULL,
    diferencia_goles integer NOT NULL,
    goles_contra integer NOT NULL,
    goles_favor integer NOT NULL,
    nombre character varying(255),
    partidos_empatados integer NOT NULL,
    partidos_ganados integer NOT NULL,
    partidos_jugados integer NOT NULL,
    partidos_perdidos integer NOT NULL,
    total_puntos integer NOT NULL
);
    DROP TABLE public.equipo;
       public         heap    hazzard    false            �            1259    16388 
   equipo_seq    SEQUENCE     t   CREATE SEQUENCE public.equipo_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.equipo_seq;
       public          hazzard    false            �            1259    16389    partido    TABLE     �   CREATE TABLE public.partido (
    id bigint NOT NULL,
    goles_local integer NOT NULL,
    goles_visitante integer NOT NULL,
    jugado boolean NOT NULL,
    equipo_local_id bigint,
    equipo_visitante_id bigint,
    fecha_partido date
);
    DROP TABLE public.partido;
       public         heap    hazzard    false            �            1259    16392    partido_seq    SEQUENCE     u   CREATE SEQUENCE public.partido_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.partido_seq;
       public          hazzard    false                      0    16385    equipo 
   TABLE DATA           �   COPY public.equipo (id, diferencia_goles, goles_contra, goles_favor, nombre, partidos_empatados, partidos_ganados, partidos_jugados, partidos_perdidos, total_puntos) FROM stdin;
    public          hazzard    false    215   �       !          0    16389    partido 
   TABLE DATA           �   COPY public.partido (id, goles_local, goles_visitante, jugado, equipo_local_id, equipo_visitante_id, fecha_partido) FROM stdin;
    public          hazzard    false    217   �       )           0    0 
   equipo_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.equipo_seq', 300, true);
          public          hazzard    false    216            *           0    0    partido_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.partido_seq', 500, true);
          public          hazzard    false    218            �           2606    16394    equipo equipo_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.equipo DROP CONSTRAINT equipo_pkey;
       public            hazzard    false    215            �           2606    16396    partido partido_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.partido DROP CONSTRAINT partido_pkey;
       public            hazzard    false    217            �           2606    16398 "   equipo ukl0ojfog3r4a4ppf9kju1y70j7 
   CONSTRAINT     _   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT ukl0ojfog3r4a4ppf9kju1y70j7 UNIQUE (nombre);
 L   ALTER TABLE ONLY public.equipo DROP CONSTRAINT ukl0ojfog3r4a4ppf9kju1y70j7;
       public            hazzard    false    215            �           2606    16399 #   partido fk7d0ff294y8ul2ego1km5r0tmq    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fk7d0ff294y8ul2ego1km5r0tmq FOREIGN KEY (equipo_local_id) REFERENCES public.equipo(id);
 M   ALTER TABLE ONLY public.partido DROP CONSTRAINT fk7d0ff294y8ul2ego1km5r0tmq;
       public          hazzard    false    3209    217    215            �           2606    16404 #   partido fkksi4gq2o9almp8a1gfnadjfu1    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fkksi4gq2o9almp8a1gfnadjfu1 FOREIGN KEY (equipo_visitante_id) REFERENCES public.equipo(id);
 M   ALTER TABLE ONLY public.partido DROP CONSTRAINT fkksi4gq2o9almp8a1gfnadjfu1;
       public          hazzard    false    215    3209    217               �   x�MP�N�0<��"?�u�4=�4Q�\V�%,9v��z�!�h���ǎm;�[��4�Ʌ�#i��������n.�T==.l��U�"�OQt�w�m��Ԓi�$��.�w ,�bxkF��C���:�kN�e��gͫ�=?�BL��.�R����g����zG\���r��Rؖ�rzg�r��B�8
I�#b��9	� ����miG{��o�d�%���rut�PH���7E�פY��M�ǝR���O�      !   �   x�u�K�0D��]����.��Oh�#��ٞ7I*)%�(�N&��&�iV�(uWVp���arla��<�3������a��	�r�\H�P��Ay)"�;��(�/+i��^[�/'�fyT��}�(��.����E,����8;���jaT<}l��獙�IQIj     