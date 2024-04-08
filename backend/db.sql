--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2024-04-08 23:18:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE acfun_comm_web;
--
-- TOC entry 4902 (class 1262 OID 16513)
-- Name: acfun_comm_web; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE acfun_comm_web WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Chinese (Simplified)_China.936';


ALTER DATABASE acfun_comm_web OWNER TO postgres;

\connect acfun_comm_web

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4903 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 16712)
-- Name: permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permission (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    url character varying(255) NOT NULL,
    method integer
);


ALTER TABLE public.permission OWNER TO postgres;

--
-- TOC entry 4904 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE permission; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.permission IS '权限表';


--
-- TOC entry 4905 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN permission.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.permission.id IS 'id';


--
-- TOC entry 4906 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN permission.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.permission.name IS '权限名';


--
-- TOC entry 4907 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN permission.url; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.permission.url IS '路径';


--
-- TOC entry 4908 (class 0 OID 0)
-- Dependencies: 220
-- Name: COLUMN permission.method; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.permission.method IS '请求方式（0-get；1-post）';


--
-- TOC entry 219 (class 1259 OID 16711)
-- Name: permission_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.permission_id_seq OWNER TO postgres;

--
-- TOC entry 4909 (class 0 OID 0)
-- Dependencies: 219
-- Name: permission_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permission_id_seq OWNED BY public.permission.id;


--
-- TOC entry 222 (class 1259 OID 16721)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    name character varying(50),
    remark character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 4910 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.role IS '角色';


--
-- TOC entry 4911 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN role.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.role.id IS 'id';


--
-- TOC entry 4912 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN role.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.role.name IS '角色名';


--
-- TOC entry 4913 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN role.remark; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.role.remark IS '备注';


--
-- TOC entry 221 (class 1259 OID 16720)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.role_id_seq OWNER TO postgres;

--
-- TOC entry 4914 (class 0 OID 0)
-- Dependencies: 221
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 224 (class 1259 OID 16729)
-- Name: role_permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_permission (
    id bigint NOT NULL,
    role_id bigint NOT NULL,
    permission_id bigint NOT NULL
);


ALTER TABLE public.role_permission OWNER TO postgres;

--
-- TOC entry 4915 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE role_permission; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.role_permission IS '角色权限表';


--
-- TOC entry 4916 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN role_permission.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.role_permission.id IS 'if';


--
-- TOC entry 4917 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN role_permission.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.role_permission.role_id IS '角色ID';


--
-- TOC entry 4918 (class 0 OID 0)
-- Dependencies: 224
-- Name: COLUMN role_permission.permission_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.role_permission.permission_id IS '权限ID';


--
-- TOC entry 223 (class 1259 OID 16728)
-- Name: role_permission_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.role_permission_id_seq OWNER TO postgres;

--
-- TOC entry 4919 (class 0 OID 0)
-- Dependencies: 223
-- Name: role_permission_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_permission_id_seq OWNED BY public.role_permission.id;


--
-- TOC entry 216 (class 1259 OID 16558)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    user_id bigint NOT NULL,
    username character varying(255) DEFAULT NULL::character varying,
    state bigint DEFAULT '0'::bigint,
    avatar_img_url character varying(255) DEFAULT NULL::character varying,
    password character varying(255) DEFAULT NULL::character varying,
    deleted boolean DEFAULT false
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 4920 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE "user"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."user" IS '用户表，user_id表示唯一用户';


--
-- TOC entry 4921 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "user".user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".user_id IS '用户ID';


--
-- TOC entry 4922 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "user".username; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".username IS '用户名';


--
-- TOC entry 4923 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "user".state; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".state IS '用户状态：0=正常，1=禁用';


--
-- TOC entry 4924 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "user".avatar_img_url; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".avatar_img_url IS '头像地址';


--
-- TOC entry 4925 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "user".password; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".password IS '密码';


--
-- TOC entry 4926 (class 0 OID 0)
-- Dependencies: 216
-- Name: COLUMN "user".deleted; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".deleted IS '逻辑删除';


--
-- TOC entry 217 (class 1259 OID 16662)
-- Name: user_auths; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_auths (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    identifier character varying(255) NOT NULL,
    identifier_type integer DEFAULT 0 NOT NULL,
    deleted boolean DEFAULT false
);


ALTER TABLE public.user_auths OWNER TO postgres;

--
-- TOC entry 4927 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE user_auths; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.user_auths IS '用户认证表，不同登录方式关联到同一用户';


--
-- TOC entry 4928 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN user_auths.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.user_auths.id IS '自增ID';


--
-- TOC entry 4929 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN user_auths.user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.user_auths.user_id IS '用户ID';


--
-- TOC entry 4930 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN user_auths.identifier; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.user_auths.identifier IS '身份唯一标识，如账号，邮箱，手机号等';


--
-- TOC entry 4931 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN user_auths.identifier_type; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.user_auths.identifier_type IS '身份唯一标识类别：0=无效，1=账号，2=邮箱';


--
-- TOC entry 4932 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN user_auths.deleted; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.user_auths.deleted IS '逻辑删除';


--
-- TOC entry 218 (class 1259 OID 16665)
-- Name: user_auths_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_auths_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_auths_id_seq OWNER TO postgres;

--
-- TOC entry 4933 (class 0 OID 0)
-- Dependencies: 218
-- Name: user_auths_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_auths_id_seq OWNED BY public.user_auths.id;


--
-- TOC entry 226 (class 1259 OID 16736)
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_role (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- TOC entry 4934 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE user_role; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.user_role IS '用户角色表';


--
-- TOC entry 4935 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN user_role.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.user_role.id IS 'id';


--
-- TOC entry 4936 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN user_role.user_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.user_role.user_id IS '用户ID';


--
-- TOC entry 4937 (class 0 OID 0)
-- Dependencies: 226
-- Name: COLUMN user_role.role_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.user_role.role_id IS '角色ID';


--
-- TOC entry 225 (class 1259 OID 16735)
-- Name: user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_role_id_seq OWNER TO postgres;

--
-- TOC entry 4938 (class 0 OID 0)
-- Dependencies: 225
-- Name: user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_role_id_seq OWNED BY public.user_role.id;


--
-- TOC entry 215 (class 1259 OID 16557)
-- Name: user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_user_id_seq OWNER TO postgres;

--
-- TOC entry 4939 (class 0 OID 0)
-- Dependencies: 215
-- Name: user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_user_id_seq OWNED BY public."user".user_id;


--
-- TOC entry 4722 (class 2604 OID 16715)
-- Name: permission id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission ALTER COLUMN id SET DEFAULT nextval('public.permission_id_seq'::regclass);


--
-- TOC entry 4723 (class 2604 OID 16724)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 4724 (class 2604 OID 16732)
-- Name: role_permission id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_permission ALTER COLUMN id SET DEFAULT nextval('public.role_permission_id_seq'::regclass);


--
-- TOC entry 4713 (class 2604 OID 16561)
-- Name: user user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user" ALTER COLUMN user_id SET DEFAULT nextval('public.user_user_id_seq'::regclass);


--
-- TOC entry 4719 (class 2604 OID 16666)
-- Name: user_auths id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_auths ALTER COLUMN id SET DEFAULT nextval('public.user_auths_id_seq'::regclass);


--
-- TOC entry 4725 (class 2604 OID 16739)
-- Name: user_role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role ALTER COLUMN id SET DEFAULT nextval('public.user_role_id_seq'::regclass);


--
-- TOC entry 4890 (class 0 OID 16712)
-- Dependencies: 220
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permission (id, name, url, method) FROM stdin;
\.


--
-- TOC entry 4892 (class 0 OID 16721)
-- Dependencies: 222
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, name, remark) FROM stdin;
\.


--
-- TOC entry 4894 (class 0 OID 16729)
-- Dependencies: 224
-- Data for Name: role_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role_permission (id, role_id, permission_id) FROM stdin;
\.


--
-- TOC entry 4886 (class 0 OID 16558)
-- Dependencies: 216
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (user_id, username, state, avatar_img_url, password, deleted) FROM stdin;
\.


--
-- TOC entry 4887 (class 0 OID 16662)
-- Dependencies: 217
-- Data for Name: user_auths; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_auths (id, user_id, identifier, identifier_type, deleted) FROM stdin;
\.


--
-- TOC entry 4896 (class 0 OID 16736)
-- Dependencies: 226
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_role (id, user_id, role_id) FROM stdin;
\.


--
-- TOC entry 4940 (class 0 OID 0)
-- Dependencies: 219
-- Name: permission_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permission_id_seq', 1, false);


--
-- TOC entry 4941 (class 0 OID 0)
-- Dependencies: 221
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 1, false);


--
-- TOC entry 4942 (class 0 OID 0)
-- Dependencies: 223
-- Name: role_permission_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_permission_id_seq', 1, false);


--
-- TOC entry 4943 (class 0 OID 0)
-- Dependencies: 218
-- Name: user_auths_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_auths_id_seq', 1, false);


--
-- TOC entry 4944 (class 0 OID 0)
-- Dependencies: 225
-- Name: user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_role_id_seq', 1, false);


--
-- TOC entry 4945 (class 0 OID 0)
-- Dependencies: 215
-- Name: user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_user_id_seq', 1, true);


--
-- TOC entry 4734 (class 2606 OID 16719)
-- Name: permission permission_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission
    ADD CONSTRAINT permission_pk PRIMARY KEY (id);


--
-- TOC entry 4738 (class 2606 OID 16734)
-- Name: role_permission role_permission_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_permission
    ADD CONSTRAINT role_permission_pk PRIMARY KEY (id);


--
-- TOC entry 4736 (class 2606 OID 16726)
-- Name: role role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pk PRIMARY KEY (id);


--
-- TOC entry 4730 (class 2606 OID 16671)
-- Name: user_auths user_auths_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_auths
    ADD CONSTRAINT user_auths_pk PRIMARY KEY (id);


--
-- TOC entry 4732 (class 2606 OID 16673)
-- Name: user_auths user_auths_unique; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_auths
    ADD CONSTRAINT user_auths_unique UNIQUE (identifier);


--
-- TOC entry 4728 (class 2606 OID 16565)
-- Name: user user_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pk PRIMARY KEY (user_id);


--
-- TOC entry 4740 (class 2606 OID 16741)
-- Name: user_role user_role_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pk PRIMARY KEY (id);


--
-- TOC entry 4726 (class 1259 OID 16710)
-- Name: user_name_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX user_name_idx ON public."user" USING btree (username);


--
-- TOC entry 4741 (class 2606 OID 16680)
-- Name: user_auths user_auths_user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_auths
    ADD CONSTRAINT user_auths_user_fk FOREIGN KEY (user_id) REFERENCES public."user"(user_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


-- Completed on 2024-04-08 23:18:43

--
-- PostgreSQL database dump complete
--

