drop table t_pjuridica CASCADE CONSTRAINTS;
drop table t_pfisica  CASCADE CONSTRAINTS;
drop table t_estabeleci  CASCADE CONSTRAINTS;
drop table t_ritmo  CASCADE CONSTRAINTS; 
drop table t_tipoest  CASCADE CONSTRAINTS;
drop table T_ESTGENMUSICAL CASCADE CONSTRAINTS;
drop table T_GALERIAEST  CASCADE CONSTRAINTS;
drop table T_GENMUSICAL CASCADE CONSTRAINTS;
drop table T_TIPOGALERIA CASCADE CONSTRAINTS;




--- BLOCO DE INSTRUÇÕES INSERT --------------------

-- PESSOA FÍSICA -------------------

INSERT INTO t_pfisica (
    psa_nome,
    psa_codigo,
    psa_sobrenome,
    psa_dtnascimento,
    psa_rg,
    psa_rgorgaoemissor,
    psa_rgestadoemissor,
    psa_cpf,
    psa_sexo,
    psa_email,
    psa_senha,
    psa_telcelular,
    psa_tipousuario,
    t_pjuridica_psj_codigo
) VALUES (
   
    'Rodolfo',
    1,
    'dos Santos Neto',
    '15/02/2000 00:00:00',
    '15.111.455-12',
    'SSP',
    'SP',
    11111111111,
    'M',
    'rodolfo@gmail.com',
    'rodolfoneto',
    11995133145,
    'consumidor',
    null
    );

-- PESSOA JURÍDICA -------------------

INSERT INTO t_pjuridica (
    psj_nome,
    psj_codigo,
    psj_cnpj,
    psj_email,
    psj_telcomercial,
    psj_cepcom,
    psj_enderecocom,
    psj_numerocom,
    psj_bairrocom,
    psj_estadocom,
    psj_cidadecom
) VALUES (
    'The Blue Pub',
    seq_t_pjuridica.nextval,
    99999999000199,
    'thebluepub@thebluepub.br',
    115466646644,
    1145511,
    'Al. Ribeirão Preto',
    384,
    'Bela Vista',
    'SP',
    'SP'
    );


-- TIPO DE ESTABELECIMENTO ----


INSERT INTO t_tipoest (
    tes_codigo,
    tes_nome
) VALUES (
    1,
    'Pub'
);

INSERT INTO t_tipoest (
    tes_codigo,
    tes_nome
) VALUES (
    2,
    'Bar'
);

INSERT INTO t_tipoest (
    tes_codigo,
    tes_nome
) VALUES (
    3,
    'Balada'
);

-- GENEROS MUSICAIS -------------------

INSERT INTO t_GENMUSICAL (
    GMU_codigo,
    GMU_nome
) VALUES (
    1,
    'Rock'
);

INSERT INTO t_GENMUSICAL (
    GMU_codigo,
    GMU_nome
) VALUES (
    2,
    'Sertanejo'
);

INSERT INTO t_GENMUSICAL (
    GMU_codigo,
    GMU_nome
) VALUES (
    3,
    'Funck'
);

INSERT INTO t_GENMUSICAL (
    GMU_codigo,
    GMU_nome
) VALUES (
    4,
    'Samba'
);

---- CADASTRO DO ESTABELECIMENTO ----------------------------

INSERT INTO t_estabeleci (
    est_codigo,
    est_descricao,
    T_GENMUSICAL_GMU_CODIGO,
    t_tipoest_tes_codigo,
    est_abertura,
    est_fechamento,
    t_pjuridica_psj_codigo
) VALUES (
    1,
    'A sacada de encontrar um ponto em comum para estrangeiros e brasileiros no mesmo lugar,
    foi o motivo pelo qual o The Blue Pub nasceu. Desde janeiro de 2008 em diante, vem unindo
    pessoas através da boa e única “gelada”, além de inovar com um cardápio inigualável,
    cheio de sabor e cultura. Quem já teve a oportunidade sabe,
    que as experiencias vividas no The Blue Pub só acontecem lá, pois são momentos únicos vividos com os amigos.
    O vasto cardápio do pub contempla cervejas vindas de mais de 10 países,
    onde há mais de 50 tipos diferentes. Também 23 tipos de whiskys, bem como variedades de gim,
    rum, vodka, coquetéis e drinks únicos de dar água na boca. Entre os pratos e acompanhamentos
    é possível perceber a mistura de temperos brasileiros dos mais variados e unicamente feitos
    por chefes do The Blue Pub.',
    1,
    1,
    '01/01/2000 18:00:00',
    '01/01/2000 01:00:00',
    1
);

---- TIPO DE INFORMAÇÃO PARA GALERIA  ----------------------------

INSERT INTO t_tipogaleria (
    tga_codigo,
    tga_nome,
    tga_descricao
) VALUES (
    1,
    'Fachada',
    'Foto da Fachada do Estabelecimento'
);

INSERT INTO t_tipogaleria (
    tga_codigo,
    tga_nome,
    tga_descricao
) VALUES (
    2,
    'Area de Bar',
    'Foto da area de Bar/Bebidas do Estabelecimento'
);

--- VINCULAÇÃO DOS GENEROS MUSICAIS AO ESTABELECIMENTO

    INSERT INTO t_estgenmusical (
    t_genmusical_gmu_codigo,
    t_estabeleci_est_codigo
) VALUES (
    1,
    1
);

--- SELECT TABELA PESSOA JURÍDICA

    select 
        b.*
    from
        T_PFISICA b
    where
        UPPER(B.PSA_EMAIL)=UPPER('lexduarte@yahoo.cOm.br');
    
    
--- CRIAÇÃO DE UM REGISTRO DE AGENDA

INSERT INTO t_agenda (
    age_codigo,
    age_detalhes,
    age_data,
    t_estabeleci_est_codigo
) VALUES (
    SEQ_T_AGENDA.nextval,
    'Melhor noite de São Paulo, com um público jovem que adora curtir',
    '27/04/2020 23:00:00',
    3
);
    
--- CRIAÇÃO DE UMA INTENÇÃO DE PRESENÇA

INSERT INTO t_agenda (
    age_codigo,
    age_detalhes,
    age_data,
    t_estabeleci_est_codigo
) VALUES (
    SEQ_T_AGENDA.nextval,
    'Melhor noite de São Paulo, com um público jovem que adora curtir',
    '27/04/2020 23:00:00',
    3
);

INSERT INTO t_presenca (
    pre_codigo,
    pre_status,
    t_pfisica_psa_codigo,
    t_agenda_age_codigo
) VALUES (
    seq_t_presenca.nextval,
    'INTENÇÃO',
    22,
    21
);
    