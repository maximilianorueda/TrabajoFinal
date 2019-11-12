PGDMP     %    &            
    w            TrabajoFinal    12.0    12.0 9    P           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Q           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            R           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            S           1262    16909    TrabajoFinal    DATABASE     �   CREATE DATABASE "TrabajoFinal" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Argentina.1252' LC_CTYPE = 'Spanish_Argentina.1252';
    DROP DATABASE "TrabajoFinal";
                postgres    false            �            1259    16971    Alumnos    TABLE     �   CREATE TABLE public."Alumnos" (
    id_alumno integer NOT NULL,
    matricula integer NOT NULL,
    id_persona integer NOT NULL
);
    DROP TABLE public."Alumnos";
       public         heap    postgres    false            �            1259    16969    Alumnos_id_alumno_seq    SEQUENCE     �   CREATE SEQUENCE public."Alumnos_id_alumno_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public."Alumnos_id_alumno_seq";
       public          postgres    false    211            T           0    0    Alumnos_id_alumno_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public."Alumnos_id_alumno_seq" OWNED BY public."Alumnos".id_alumno;
          public          postgres    false    210            �            1259    16912    Cargos    TABLE     �   CREATE TABLE public."Cargos" (
    id_cargo integer NOT NULL,
    codigo integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public."Cargos";
       public         heap    postgres    false            �            1259    16910    Cargo_id_cargo_seq    SEQUENCE     �   CREATE SEQUENCE public."Cargo_id_cargo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public."Cargo_id_cargo_seq";
       public          postgres    false    203            U           0    0    Cargo_id_cargo_seq    SEQUENCE OWNED BY     N   ALTER SEQUENCE public."Cargo_id_cargo_seq" OWNED BY public."Cargos".id_cargo;
          public          postgres    false    202            �            1259    16951    Docentes    TABLE     �   CREATE TABLE public."Docentes" (
    id_docente integer NOT NULL,
    legajo integer NOT NULL,
    id_persona integer NOT NULL,
    id_cargo integer NOT NULL
);
    DROP TABLE public."Docentes";
       public         heap    postgres    false            �            1259    16949    Docentes_id_docente_seq    SEQUENCE     �   CREATE SEQUENCE public."Docentes_id_docente_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Docentes_id_docente_seq";
       public          postgres    false    209            V           0    0    Docentes_id_docente_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Docentes_id_docente_seq" OWNED BY public."Docentes".id_docente;
          public          postgres    false    208            �            1259    17008    Grados    TABLE     �   CREATE TABLE public."Grados" (
    id_grado integer NOT NULL,
    numero integer NOT NULL,
    seccion character varying NOT NULL,
    id_docente integer NOT NULL,
    id_turno integer NOT NULL
);
    DROP TABLE public."Grados";
       public         heap    postgres    false            �            1259    17006    Grados_id_grado_seq    SEQUENCE     �   CREATE SEQUENCE public."Grados_id_grado_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public."Grados_id_grado_seq";
       public          postgres    false    213            W           0    0    Grados_id_grado_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public."Grados_id_grado_seq" OWNED BY public."Grados".id_grado;
          public          postgres    false    212            �            1259    16938    Personas    TABLE     �   CREATE TABLE public."Personas" (
    id_persona integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    documento integer NOT NULL,
    fecha_nacimiento date NOT NULL,
    sexo character varying NOT NULL
);
    DROP TABLE public."Personas";
       public         heap    postgres    false            �            1259    16936    Personas_id_persona_seq    SEQUENCE     �   CREATE SEQUENCE public."Personas_id_persona_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public."Personas_id_persona_seq";
       public          postgres    false    207            X           0    0    Personas_id_persona_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public."Personas_id_persona_seq" OWNED BY public."Personas".id_persona;
          public          postgres    false    206            �            1259    16925    Turnos    TABLE     �   CREATE TABLE public."Turnos" (
    id_turno integer NOT NULL,
    codigo integer NOT NULL,
    descripcion character varying NOT NULL
);
    DROP TABLE public."Turnos";
       public         heap    postgres    false            �            1259    16923    Turnos_id_turno_seq    SEQUENCE     �   CREATE SEQUENCE public."Turnos_id_turno_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public."Turnos_id_turno_seq";
       public          postgres    false    205            Y           0    0    Turnos_id_turno_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public."Turnos_id_turno_seq" OWNED BY public."Turnos".id_turno;
          public          postgres    false    204            �
           2604    16974    Alumnos id_alumno    DEFAULT     z   ALTER TABLE ONLY public."Alumnos" ALTER COLUMN id_alumno SET DEFAULT nextval('public."Alumnos_id_alumno_seq"'::regclass);
 B   ALTER TABLE public."Alumnos" ALTER COLUMN id_alumno DROP DEFAULT;
       public          postgres    false    211    210    211            �
           2604    16915    Cargos id_cargo    DEFAULT     u   ALTER TABLE ONLY public."Cargos" ALTER COLUMN id_cargo SET DEFAULT nextval('public."Cargo_id_cargo_seq"'::regclass);
 @   ALTER TABLE public."Cargos" ALTER COLUMN id_cargo DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    16954    Docentes id_docente    DEFAULT     ~   ALTER TABLE ONLY public."Docentes" ALTER COLUMN id_docente SET DEFAULT nextval('public."Docentes_id_docente_seq"'::regclass);
 D   ALTER TABLE public."Docentes" ALTER COLUMN id_docente DROP DEFAULT;
       public          postgres    false    208    209    209            �
           2604    17011    Grados id_grado    DEFAULT     v   ALTER TABLE ONLY public."Grados" ALTER COLUMN id_grado SET DEFAULT nextval('public."Grados_id_grado_seq"'::regclass);
 @   ALTER TABLE public."Grados" ALTER COLUMN id_grado DROP DEFAULT;
       public          postgres    false    212    213    213            �
           2604    16941    Personas id_persona    DEFAULT     ~   ALTER TABLE ONLY public."Personas" ALTER COLUMN id_persona SET DEFAULT nextval('public."Personas_id_persona_seq"'::regclass);
 D   ALTER TABLE public."Personas" ALTER COLUMN id_persona DROP DEFAULT;
       public          postgres    false    207    206    207            �
           2604    16928    Turnos id_turno    DEFAULT     v   ALTER TABLE ONLY public."Turnos" ALTER COLUMN id_turno SET DEFAULT nextval('public."Turnos_id_turno_seq"'::regclass);
 @   ALTER TABLE public."Turnos" ALTER COLUMN id_turno DROP DEFAULT;
       public          postgres    false    205    204    205            K          0    16971    Alumnos 
   TABLE DATA           E   COPY public."Alumnos" (id_alumno, matricula, id_persona) FROM stdin;
    public          postgres    false    211   YA       C          0    16912    Cargos 
   TABLE DATA           A   COPY public."Cargos" (id_cargo, codigo, descripcion) FROM stdin;
    public          postgres    false    203   ~A       I          0    16951    Docentes 
   TABLE DATA           N   COPY public."Docentes" (id_docente, legajo, id_persona, id_cargo) FROM stdin;
    public          postgres    false    209   �A       M          0    17008    Grados 
   TABLE DATA           S   COPY public."Grados" (id_grado, numero, seccion, id_docente, id_turno) FROM stdin;
    public          postgres    false    213   B       G          0    16938    Personas 
   TABLE DATA           e   COPY public."Personas" (id_persona, nombre, apellido, documento, fecha_nacimiento, sexo) FROM stdin;
    public          postgres    false    207   5B       E          0    16925    Turnos 
   TABLE DATA           A   COPY public."Turnos" (id_turno, codigo, descripcion) FROM stdin;
    public          postgres    false    205   �B       Z           0    0    Alumnos_id_alumno_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public."Alumnos_id_alumno_seq"', 6, true);
          public          postgres    false    210            [           0    0    Cargo_id_cargo_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."Cargo_id_cargo_seq"', 13, true);
          public          postgres    false    202            \           0    0    Docentes_id_docente_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public."Docentes_id_docente_seq"', 8, true);
          public          postgres    false    208            ]           0    0    Grados_id_grado_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."Grados_id_grado_seq"', 5, true);
          public          postgres    false    212            ^           0    0    Personas_id_persona_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public."Personas_id_persona_seq"', 11, true);
          public          postgres    false    206            _           0    0    Turnos_id_turno_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."Turnos_id_turno_seq"', 6, true);
          public          postgres    false    204            �
           2606    16976    Alumnos pk_alumno 
   CONSTRAINT     X   ALTER TABLE ONLY public."Alumnos"
    ADD CONSTRAINT pk_alumno PRIMARY KEY (id_alumno);
 =   ALTER TABLE ONLY public."Alumnos" DROP CONSTRAINT pk_alumno;
       public            postgres    false    211            �
           2606    16920    Cargos pk_cargo 
   CONSTRAINT     U   ALTER TABLE ONLY public."Cargos"
    ADD CONSTRAINT pk_cargo PRIMARY KEY (id_cargo);
 ;   ALTER TABLE ONLY public."Cargos" DROP CONSTRAINT pk_cargo;
       public            postgres    false    203            �
           2606    16956    Docentes pk_docente 
   CONSTRAINT     [   ALTER TABLE ONLY public."Docentes"
    ADD CONSTRAINT pk_docente PRIMARY KEY (id_docente);
 ?   ALTER TABLE ONLY public."Docentes" DROP CONSTRAINT pk_docente;
       public            postgres    false    209            �
           2606    17016    Grados pk_grado 
   CONSTRAINT     U   ALTER TABLE ONLY public."Grados"
    ADD CONSTRAINT pk_grado PRIMARY KEY (id_grado);
 ;   ALTER TABLE ONLY public."Grados" DROP CONSTRAINT pk_grado;
       public            postgres    false    213            �
           2606    16946    Personas pk_persona 
   CONSTRAINT     [   ALTER TABLE ONLY public."Personas"
    ADD CONSTRAINT pk_persona PRIMARY KEY (id_persona);
 ?   ALTER TABLE ONLY public."Personas" DROP CONSTRAINT pk_persona;
       public            postgres    false    207            �
           2606    16933    Turnos pk_turno 
   CONSTRAINT     h   ALTER TABLE ONLY public."Turnos"
    ADD CONSTRAINT pk_turno PRIMARY KEY (id_turno) INCLUDE (id_turno);
 ;   ALTER TABLE ONLY public."Turnos" DROP CONSTRAINT pk_turno;
       public            postgres    false    205    205            �
           2606    16978    Alumnos u_alumno 
   CONSTRAINT     f   ALTER TABLE ONLY public."Alumnos"
    ADD CONSTRAINT u_alumno UNIQUE (matricula) INCLUDE (matricula);
 <   ALTER TABLE ONLY public."Alumnos" DROP CONSTRAINT u_alumno;
       public            postgres    false    211    211            �
           2606    16922    Cargos u_cargo 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Cargos"
    ADD CONSTRAINT u_cargo UNIQUE (codigo) INCLUDE (codigo);
 :   ALTER TABLE ONLY public."Cargos" DROP CONSTRAINT u_cargo;
       public            postgres    false    203    203            �
           2606    16958    Docentes u_docente 
   CONSTRAINT     b   ALTER TABLE ONLY public."Docentes"
    ADD CONSTRAINT u_docente UNIQUE (legajo) INCLUDE (legajo);
 >   ALTER TABLE ONLY public."Docentes" DROP CONSTRAINT u_docente;
       public            postgres    false    209    209            �
           2606    17018    Grados u_grado 
   CONSTRAINT     p   ALTER TABLE ONLY public."Grados"
    ADD CONSTRAINT u_grado UNIQUE (numero, seccion) INCLUDE (numero, seccion);
 :   ALTER TABLE ONLY public."Grados" DROP CONSTRAINT u_grado;
       public            postgres    false    213    213    213    213            �
           2606    16948    Personas u_persona 
   CONSTRAINT     h   ALTER TABLE ONLY public."Personas"
    ADD CONSTRAINT u_persona UNIQUE (documento) INCLUDE (documento);
 >   ALTER TABLE ONLY public."Personas" DROP CONSTRAINT u_persona;
       public            postgres    false    207    207            �
           2606    16935    Turnos u_turno 
   CONSTRAINT     ^   ALTER TABLE ONLY public."Turnos"
    ADD CONSTRAINT u_turno UNIQUE (codigo) INCLUDE (codigo);
 :   ALTER TABLE ONLY public."Turnos" DROP CONSTRAINT u_turno;
       public            postgres    false    205    205            �
           2606    16979    Alumnos fk_alumno_persona    FK CONSTRAINT     �   ALTER TABLE ONLY public."Alumnos"
    ADD CONSTRAINT fk_alumno_persona FOREIGN KEY (id_persona) REFERENCES public."Personas"(id_persona);
 E   ALTER TABLE ONLY public."Alumnos" DROP CONSTRAINT fk_alumno_persona;
       public          postgres    false    2736    211    207            �
           2606    16964    Docentes fk_docente_cargo    FK CONSTRAINT     �   ALTER TABLE ONLY public."Docentes"
    ADD CONSTRAINT fk_docente_cargo FOREIGN KEY (id_cargo) REFERENCES public."Cargos"(id_cargo);
 E   ALTER TABLE ONLY public."Docentes" DROP CONSTRAINT fk_docente_cargo;
       public          postgres    false    2728    203    209            �
           2606    16959    Docentes fk_docente_persona    FK CONSTRAINT     �   ALTER TABLE ONLY public."Docentes"
    ADD CONSTRAINT fk_docente_persona FOREIGN KEY (id_persona) REFERENCES public."Personas"(id_persona);
 G   ALTER TABLE ONLY public."Docentes" DROP CONSTRAINT fk_docente_persona;
       public          postgres    false    209    207    2736            �
           2606    17019    Grados fk_grado_docente    FK CONSTRAINT     �   ALTER TABLE ONLY public."Grados"
    ADD CONSTRAINT fk_grado_docente FOREIGN KEY (id_docente) REFERENCES public."Docentes"(id_docente);
 C   ALTER TABLE ONLY public."Grados" DROP CONSTRAINT fk_grado_docente;
       public          postgres    false    213    209    2740            �
           2606    17029    Grados fk_grado_turno    FK CONSTRAINT     �   ALTER TABLE ONLY public."Grados"
    ADD CONSTRAINT fk_grado_turno FOREIGN KEY (id_turno) REFERENCES public."Turnos"(id_turno) NOT VALID;
 A   ALTER TABLE ONLY public."Grados" DROP CONSTRAINT fk_grado_turno;
       public          postgres    false    213    205    2732            K      x�3�430�4����� ��      C   B   x�3�444��,)�I,�2�422�.-�I�+I�2�466��2�2���9MLL8�B�b���� ��      I   !   x�3䴰0�4�4�2�02�4�4����� .\`      M   $   x�3�440��M,I�=��$39��ӐӐ+F��� u#i      G   �   x�E�1� ����/8�z�:�IgRo �`0$�|iҤ���,��/�)�X*<��#�3�L`Cpڢ68�w�9��U�K�#Z�i�����0�*e�n=�c�����d���6^wp�9�&e�klM��|���F:��R�@_4      E   #   x�3�4��M<�11/�ˈӈ3$�(%�+F��� i��     