-- Gerado por Oracle SQL Developer Data Modeler 18.4.0.339.1532
--   em:        2020-03-18 09:30:48 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE t_estabeleci (
    est_codigo               INTEGER NOT NULL,
    est_descricao            CLOB NOT NULL,
    t_tipoest_tes_codigo     INTEGER NOT NULL,
    est_abertura             DATE NOT NULL,
    est_fechamento           DATE NOT NULL,
    t_pjuridica_psj_codigo   INTEGER NOT NULL
);

CREATE UNIQUE INDEX t_estabeleci__idx ON
    t_estabeleci (
        t_pjuridica_psj_codigo
    ASC );

ALTER TABLE t_estabeleci ADD CONSTRAINT t_estabeleci_pk PRIMARY KEY ( est_codigo );

CREATE TABLE t_estgenmusical (
    t_genmusical_gmu_codigo   INTEGER NOT NULL,
    t_estabeleci_est_codigo   INTEGER NOT NULL
);

CREATE TABLE t_galeriaest (
    gae_codigo                 INTEGER NOT NULL,
    gae_foto                   BLOB NOT NULL,
    t_estabeleci_est_codigo    INTEGER NOT NULL,
    t_tipogaleria_tga_codigo   INTEGER NOT NULL
);

ALTER TABLE t_galeriaest ADD CONSTRAINT t_galeriaest_pk PRIMARY KEY ( gae_codigo );

CREATE TABLE t_genmusical (
    gmu_codigo   INTEGER NOT NULL,
    gmu_nome     VARCHAR2(60) NOT NULL
);

ALTER TABLE t_genmusical ADD CONSTRAINT t_genmusical_pk PRIMARY KEY ( gmu_codigo );

CREATE TABLE t_pfgestor (
    t_pfisica_psa_codigo     INTEGER NOT NULL,
    t_pjuridica_psj_codigo   INTEGER NOT NULL,
    rge_perfil               VARCHAR2(40),
    rge_codigo               INTEGER NOT NULL
);

ALTER TABLE t_pfgestor ADD CONSTRAINT t_pfgestor_pk PRIMARY KEY ( rge_codigo );

CREATE TABLE t_pfisica (
    psa_nome                 VARCHAR2(40) NOT NULL,
    psa_codigo               INTEGER NOT NULL,
    psa_sobrenome            VARCHAR2(100) NOT NULL,
    psa_dtnascimento         DATE NOT NULL,
    psa_rg                   VARCHAR2(15) NOT NULL,
    psa_rgorgaoemissor       VARCHAR2(15) NOT NULL,
    psa_rgestadoemissor      VARCHAR2(15) NOT NULL,
    psa_cpf                  NUMBER(11) NOT NULL,
    psa_sexo                 VARCHAR2(1) NOT NULL,
    psa_cdprofissao          INTEGER,
    psa_email                VARCHAR2(100) NOT NULL,
    psa_senha                VARCHAR2(40) NOT NULL,
    psa_telresidencial       NUMBER(15),
    psa_telcomercial         NUMBER(15),
    psa_telcelular           NUMBER(15) NOT NULL,
    psa_cepres               NUMBER(8),
    psa_enderecores          VARCHAR2(60),
    psa_numerores            INTEGER,
    psa_complementores       VARCHAR2(20),
    psa_bairrores            VARCHAR2(30),
    psa_cidaderes            VARCHAR2(30),
    psa_estadores            VARCHAR2(30),
    psa_cepcom               NUMBER(8),
    psa_enderecocom          VARCHAR2(60),
    psa_numerocom            INTEGER,
    psa_complementocom       VARCHAR2(15),
    psa_bairrocom            VARCHAR2(30),
    psa_cidadecom            VARCHAR2(30),
    psa_estadocom            VARCHAR2(30),
    psa_tipousuario          VARCHAR2(20) NOT NULL,
    t_pjuridica_psj_codigo   INTEGER
);

ALTER TABLE t_pfisica ADD CONSTRAINT t_pfisica_pk PRIMARY KEY ( psa_codigo );

CREATE TABLE t_pjuridica (
    psj_nome             VARCHAR2(40) NOT NULL,
    psj_codigo           INTEGER NOT NULL,
    psj_dtfundacao       DATE,
    psj_inscestadual     VARCHAR2(15),
    psj_inscestado       VARCHAR2(15),
    psj_cnpj             NUMBER(14) NOT NULL,
    psj_email            VARCHAR2(100) NOT NULL,
    psj_telcomercial     NUMBER(15) NOT NULL,
    psj_cepcom           NUMBER(8) NOT NULL,
    psj_enderecocom      VARCHAR2(60) NOT NULL,
    psj_numerocom        INTEGER NOT NULL,
    psj_complementocom   VARCHAR2(15),
    psj_bairrocom        VARCHAR2(30) NOT NULL,
    psj_estadocom        VARCHAR2(30) NOT NULL,
    psj_cidadecom        VARCHAR2(30) NOT NULL
);

ALTER TABLE t_pjuridica ADD CONSTRAINT t_pjuridica_pk PRIMARY KEY ( psj_codigo );

CREATE TABLE t_tipoest (
    tes_codigo   INTEGER NOT NULL,
    tes_nome     VARCHAR2(60) NOT NULL
);

ALTER TABLE t_tipoest ADD CONSTRAINT t_tipoest_pk PRIMARY KEY ( tes_codigo );

CREATE TABLE t_tipogaleria (
    tga_codigo      INTEGER NOT NULL,
    tga_nome        VARCHAR2(25) NOT NULL,
    tga_descricao   VARCHAR2(50) NOT NULL
);

ALTER TABLE t_tipogaleria ADD CONSTRAINT t_tipogaleria_pk PRIMARY KEY ( tga_codigo );

ALTER TABLE t_estabeleci
    ADD CONSTRAINT t_estabeleci_t_pjuridica_fk FOREIGN KEY ( t_pjuridica_psj_codigo )
        REFERENCES t_pjuridica ( psj_codigo );

ALTER TABLE t_estabeleci
    ADD CONSTRAINT t_estabeleci_t_tipoest_fk FOREIGN KEY ( t_tipoest_tes_codigo )
        REFERENCES t_tipoest ( tes_codigo );

ALTER TABLE t_estgenmusical
    ADD CONSTRAINT t_estgenmusical_t_esti_fk FOREIGN KEY ( t_estabeleci_est_codigo )
        REFERENCES t_estabeleci ( est_codigo );

ALTER TABLE t_estgenmusical
    ADD CONSTRAINT t_estgenmusical_t_genl_fk FOREIGN KEY ( t_genmusical_gmu_codigo )
        REFERENCES t_genmusical ( gmu_codigo );

ALTER TABLE t_galeriaest
    ADD CONSTRAINT t_galeriaest_t_estabeleci_fk FOREIGN KEY ( t_estabeleci_est_codigo )
        REFERENCES t_estabeleci ( est_codigo );

ALTER TABLE t_galeriaest
    ADD CONSTRAINT t_galeriaest_t_tipogaleria_fk FOREIGN KEY ( t_tipogaleria_tga_codigo )
        REFERENCES t_tipogaleria ( tga_codigo );

ALTER TABLE t_pfgestor
    ADD CONSTRAINT t_pfgestor_t_pfisica_fk FOREIGN KEY ( t_pfisica_psa_codigo )
        REFERENCES t_pfisica ( psa_codigo );

ALTER TABLE t_pfgestor
    ADD CONSTRAINT t_pfgestor_t_pjuridica_fk FOREIGN KEY ( t_pjuridica_psj_codigo )
        REFERENCES t_pjuridica ( psj_codigo );

ALTER TABLE t_pfisica
    ADD CONSTRAINT t_pfisica_t_pjuridica_fk FOREIGN KEY ( t_pjuridica_psj_codigo )
        REFERENCES t_pjuridica ( psj_codigo );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             1
-- ALTER TABLE                             17
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
