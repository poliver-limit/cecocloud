--
-- Create Schema Script 
--   Database Version   : 9.2.0.6.0 
--   TOAD Version       : 9.7.0.51 
--   DB Connect String  : DES 
--   Schema             : CONTACEC 
--   Script Created by  : CECOGEST 
--   Script Created at  : 05/02/2020 9:17:28 
--   Physical Location  :  
--   Notes              :  
--

-- Object Counts: 
--   Indexes: 499       Columns: 1599       
--   Sequences: 4 
--   Tables: 428        Columns: 12940      Constraints: 657    
--   Views: 25          


CREATE SEQUENCE DIM_SEQ
  START WITH 1
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  NOORDER;


CREATE SEQUENCE SCMP_AUX
  START WITH 141
  MAXVALUE 1000
  MINVALUE 1
  CYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SCMP_DEL
  START WITH 1920355
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SCMP_VEN
  START WITH 3901
  MAXVALUE 9999999999
  MINVALUE 1
  CYCLE
  CACHE 20
  ORDER;




CREATE TABLE COMPTABILITAT_FORM_HELP
(
  HLP_APPLN        VARCHAR2(30 BYTE)                NULL,
  HLP_INDEX        VARCHAR2(100 BYTE)               NULL,
  HLP_MODTAB_NAME  VARCHAR2(30 BYTE)                NULL,
  HLP_GENERATED    VARCHAR2(1 BYTE)                 NULL,
  HLP_SEQ          NUMBER(5)                        NULL,
  HLP_TEXT         VARCHAR2(70 BYTE)                NULL,
  HLP_TYPE         VARCHAR2(1 BYTE)                 NULL
)
;


CREATE TABLE COMPTABILITAT_REF_CODES
(
  RV_LOW_VALUE     VARCHAR2(240 BYTE)               NULL,
  RV_HIGH_VALUE    VARCHAR2(240 BYTE)               NULL,
  RV_ABBREVIATION  VARCHAR2(240 BYTE)               NULL,
  RV_DOMAIN        VARCHAR2(100 BYTE)               NULL,
  RV_MEANING       VARCHAR2(240 BYTE)               NULL,
  RV_TYPE          VARCHAR2(10 BYTE)                NULL
)
;








CREATE TABLE TCMP_347OPH_HIST
(
  OPH_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  OPH_EMP_COD       VARCHAR2(4 BYTE)                NULL,
  OPH_CLASSE        VARCHAR2(1 BYTE)                NULL,
  OPH_CLIPRO        VARCHAR2(10 BYTE)               NULL,
  OPH_EJE           VARCHAR2(4 BYTE)                NULL,
  OPH_IMPORT        NUMBER(15,2)                    NULL,
  OPH_TIPUS         VARCHAR2(1 BYTE)                NULL,
  OPH_NIF           VARCHAR2(12 BYTE)               NULL,
  OPH_NOM           VARCHAR2(40 BYTE)               NULL,
  OPH_PRVPAI        VARCHAR2(5 BYTE)                NULL,
  OPH_POB           VARCHAR2(30 BYTE)               NULL,
  OPH_SEGU          VARCHAR2(1 BYTE)                NULL,
  OPH_ARRE          VARCHAR2(1 BYTE)                NULL,
  OPH_USUCRE        VARCHAR2(30 BYTE)               NULL,
  OPH_DATCRE        DATE                            NULL,
  OPH_USUMOD        VARCHAR2(30 BYTE)               NULL,
  OPH_DATMOD        DATE                            NULL,
  OPH_IMPORTMET     NUMBER(15,2)                    NULL,
  OPH_IMPORTTRA     NUMBER(15,2)                    NULL,
  OPH_EXCMET        VARCHAR2(4 BYTE)                NULL,
  OPH_SEQ           NUMBER(3)                   DEFAULT 0                         NULL,
  OPH_IMP001        NUMBER(15,2)                    NULL,
  OPH_IMP002        NUMBER(15,2)                    NULL,
  OPH_IMP003        NUMBER(15,2)                    NULL,
  OPH_IMP004        NUMBER(15,2)                    NULL,
  OPH_IMPTRA001     NUMBER(15,2)                    NULL,
  OPH_IMPTRA002     NUMBER(15,2)                    NULL,
  OPH_IMPTRA003     NUMBER(15,2)                    NULL,
  OPH_IMPTRA004     NUMBER(15,2)                    NULL,
  OPH_CRICXA        NUMBER(15,2)                    NULL,
  OPH_NIFCEE        VARCHAR2(17 BYTE)               NULL,
  OPH_OPSREGCRICXA  VARCHAR2(1 BYTE)                NULL,
  OPH_OPSINVSUJPAS  VARCHAR2(1 BYTE)                NULL,
  OPH_OPSREGDIP     VARCHAR2(1 BYTE)                NULL
)
;






CREATE GLOBAL TEMPORARY TABLE TCMP_ACUMULATS_ANA
(
  ACU_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  ACU_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  ACU_EJE_COD    VARCHAR2(4 BYTE)                   NULL,
  ACU_DIA_COD    VARCHAR2(2 BYTE)                   NULL,
  ACU_CT5_COD    VARCHAR2(10 BYTE)                  NULL,
  ACU_ANY        NUMBER(4)                          NULL,
  ACU_UNIDEBINI  NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_UNIHABINI  NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_UNISALN_1  NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEBINI     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HABINI     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_SALN_1     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB001     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB001     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB002     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB002     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB003     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB003     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB004     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB004     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB005     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB005     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB006     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB006     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB007     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB007     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB008     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB008     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB009     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB009     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB010     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB010     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB011     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB011     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB012     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB012     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEBTAN     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HABTAN     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_CANMONINI  NUMBER(10,4)                       NULL,
  ACU_PRO_COD    VARCHAR2(4 BYTE)                   NULL
)
ON COMMIT PRESERVE ROWS;





CREATE TABLE TCMP_ACUMULATS_JN
(
  JN_OPERATION    VARCHAR2(3 BYTE)                  NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_NOTES        VARCHAR2(240 BYTE)                NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  JN_SESSION      NUMBER(38)                        NULL,
  ACU_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  ACU_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  ACU_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  ACU_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  ACU_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  ACU_ANY         NUMBER(4)                         NULL,
  ACU_UNIDEBINI   NUMBER(15,3)                      NULL,
  ACU_UNIHABINI   NUMBER(15,3)                      NULL,
  ACU_UNISALN_1   NUMBER(15,3)                      NULL,
  ACU_DEBINI      NUMBER(15,3)                      NULL,
  ACU_HABINI      NUMBER(15,3)                      NULL,
  ACU_SALN_1      NUMBER(15,3)                      NULL,
  ACU_DEBTAN      NUMBER(15,3)                      NULL,
  ACU_HABTAN      NUMBER(15,3)                      NULL,
  ACU_CANMONINI   NUMBER(10,4)                      NULL
)
;





CREATE TABLE TCMP_AGE
(
  AGE_COD     VARCHAR2(4 BYTE)                      NULL,
  AGE_DATCRE  DATE                                  NULL,
  AGE_NOM     VARCHAR2(30 BYTE)                     NULL,
  AGE_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  AGE_DATMOD  DATE                                  NULL,
  AGE_USUMOD  VARCHAR2(30 BYTE)                     NULL,
  AGE_NIF     VARCHAR2(12 BYTE)                     NULL
)
;




CREATE TABLE TCMP_APUNTS_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_NOTES        VARCHAR2(240 BYTE)                NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  JN_SESSION      NUMBER(38)                        NULL,
  APU_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  APU_ASI_NUMASI  NUMBER(10)                        NULL,
  APU_NUMAPU      NUMBER(10)                        NULL,
  APU_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  APU_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  APU_IMPDEB      NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_IMPHAB      NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_CON         VARCHAR2(255 BYTE)                NULL,
  APU_IVA_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_IVA_CODINT  VARCHAR2(4 BYTE)                  NULL,
  APU_CIV_COD     VARCHAR2(2 BYTE)                  NULL,
  APU_CIV_CODINT  VARCHAR2(2 BYTE)                  NULL,
  APU_CONTRA      VARCHAR2(10 BYTE)                 NULL,
  APU_NUMDOC      VARCHAR2(8 BYTE)                  NULL,
  APU_DATFAC      DATE                              NULL,
  APU_NUMFAC      VARCHAR2(60 BYTE)                 NULL,
  APU_BASIVA      NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_PUNTEO      VARCHAR2(1 BYTE)                  NULL,
  APU_MARCAERR    DATE                              NULL,
  APU_VALIMPDEB   NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_VALIMPHAB   NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_VALBASIVA   NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_ACU_ANY     NUMBER(4)                         NULL,
  APU_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  APU_DATCRE      DATE                              NULL,
  APU_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  APU_DATMOD      DATE                              NULL,
  APU_DATVLR      DATE                              NULL,
  APU_ASI_DAT     DATE                              NULL,
  APU_NUMDOCFRT   VARCHAR2(8 BYTE)                  NULL,
  APU_NIFCPA      VARCHAR2(12 BYTE)                 NULL,
  APU_NOMCPA      VARCHAR2(40 BYTE)                 NULL,
  APU_DATOPE      DATE                              NULL
)
;




CREATE TABLE TCMP_ASIENTOS_JN
(
  JN_OPERATION          CHAR(3 BYTE)                NULL,
  JN_ORACLE_USER        VARCHAR2(30 BYTE)           NULL,
  JN_DATETIME           DATE                        NULL,
  JN_NOTES              VARCHAR2(240 BYTE)          NULL,
  JN_APPLN              VARCHAR2(30 BYTE)           NULL,
  JN_SESSION            NUMBER(38)                  NULL,
  ASI_CEC_COD           VARCHAR2(4 BYTE)            NULL,
  ASI_EMP_COD           VARCHAR2(4 BYTE)            NULL,
  ASI_EJE_COD           VARCHAR2(4 BYTE)            NULL,
  ASI_DIA_COD           VARCHAR2(2 BYTE)            NULL,
  ASI_NUMASI            NUMBER(10)                  NULL,
  ASI_TAS_COD           VARCHAR2(2 BYTE)            NULL,
  ASI_DAT               DATE                        NULL,
  ASI_USUCRE            VARCHAR2(30 BYTE)           NULL,
  ASI_DATCRE            DATE                        NULL,
  ASI_MODIFICABLE       VARCHAR2(1 BYTE)            NULL,
  ASI_OBS               VARCHAR2(4000 BYTE)         NULL,
  ASI_DATAVI            DATE                        NULL,
  ASI_MARAVI            VARCHAR2(1 BYTE)            NULL,
  ASI_USUMOD            VARCHAR2(30 BYTE)           NULL,
  ASI_DATMOD            DATE                        NULL,
  ASI_NUMASI001         NUMBER(10)                  NULL,
  ASI_PRD               VARCHAR2(1 BYTE)            NULL,
  ASI_EJE_CODPRDORI     VARCHAR2(4 BYTE)            NULL,
  ASI_DIA_CODPRDORI     VARCHAR2(2 BYTE)            NULL,
  ASI_ASI_NUMASIPRDORI  NUMBER(10)                  NULL,
  ASI_DATPRS            DATE                        NULL,
  ASI_DATCNF            DATE                        NULL
)
;





CREATE TABLE TCMP_BANCS_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  BAN_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  BAN_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  BAN_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  BAN_NUMCTA      VARCHAR2(20 BYTE)                 NULL,
  BAN_TIPOCTA     VARCHAR2(30 BYTE)                 NULL,
  BAN_LIMPOLIZA   NUMBER(15,3)                      NULL,
  BAN_DATVTO      DATE                              NULL,
  BAN_LIQINT      VARCHAR2(30 BYTE)                 NULL,
  BAN_AMOCAP      VARCHAR2(30 BYTE)                 NULL,
  BAN_PTEINT      NUMBER(5,2)                       NULL,
  BAN_PTEDES      NUMBER(5,2)                       NULL,
  BAN_DATREV      DATE                              NULL,
  BAN_INCVALING   NUMBER(5,2)                       NULL,
  BAN_INCVALGAS   NUMBER(5,2)                       NULL,
  BAN_CON         VARCHAR2(100 BYTE)                NULL,
  BAN_TEL         VARCHAR2(30 BYTE)                 NULL,
  BAN_FAX         VARCHAR2(30 BYTE)                 NULL,
  BAN_EML         VARCHAR2(60 BYTE)                 NULL,
  BAN_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  BAN_DATCRE      DATE                              NULL,
  BAN_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  BAN_DATMOD      DATE                              NULL,
  BAN_IBAN_PAIS   VARCHAR2(2 BYTE)                  NULL,
  BAN_IBAN_DC     VARCHAR2(2 BYTE)                  NULL,
  BAN_IBAN_BBAN   VARCHAR2(30 BYTE)                 NULL,
  BAN_BIC         VARCHAR2(11 BYTE)                 NULL,
  BAN_BAN         VARCHAR2(4 BYTE)                  NULL,
  BAN_OFI         VARCHAR2(4 BYTE)                  NULL,
  BAN_CCR         VARCHAR2(10 BYTE)                 NULL
)
;





CREATE TABLE TCMP_CLICECO
(
  CEC_COD     VARCHAR2(4 BYTE)                      NULL,
  CEC_NOM     VARCHAR2(40 BYTE)                     NULL,
  CEC_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  CEC_DATCRE  DATE                                  NULL,
  CEC_USUMOD  VARCHAR2(30 BYTE)                     NULL,
  CEC_DATMOD  DATE                                  NULL,
  CEC_LOG     LONG RAW                              NULL,
  CEC_IMPLOG  VARCHAR2(1 BYTE)                  DEFAULT 'N'                       NULL
)
;





CREATE TABLE TCMP_CLV
(
  CLV_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CLV_COD      VARCHAR2(4 BYTE)                     NULL,
  CLV_DATCRE   DATE                                 NULL,
  CLV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CLV_NOM      VARCHAR2(30 BYTE)                    NULL,
  CLV_DATMOD   DATE                                 NULL,
  CLV_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;




CREATE TABLE TCMP_CNAES
(
  CNA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CNA_COD      VARCHAR2(4 BYTE)                     NULL,
  CNA_DES      VARCHAR2(250 BYTE)                   NULL,
  CNA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CNA_DATCRE   DATE                                 NULL,
  CNA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CNA_DATMOD   DATE                                 NULL
)
;




CREATE TABLE TCMP_CONCEPTES
(
  CON_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CON_COD      VARCHAR2(3 BYTE)                     NULL,
  CON_DES      VARCHAR2(255 BYTE)                   NULL,
  CON_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CON_DATCRE   DATE                                 NULL,
  CON_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CON_DATMOD   DATE                                 NULL
)
;




CREATE TABLE TCMP_CONCOM
(
  CCO_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CCO_COD      VARCHAR2(2 BYTE)                     NULL,
  CCO_DES      VARCHAR2(300 BYTE)                   NULL
)
;





CREATE TABLE TCMP_CT4CLV
(
  CTV_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CTV_CT4_COD  VARCHAR2(4 BYTE)                     NULL,
  CTV_CLV_COD  VARCHAR2(4 BYTE)                     NULL,
  CTV_DATCRE   DATE                                 NULL,
  CTV_USUCRE   VARCHAR2(30 BYTE)                    NULL
)
;





CREATE TABLE TCMP_DELETE
(
  DEL_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DEL_MIS      VARCHAR2(2000 BYTE)                  NULL,
  DEL_SEQ      NUMBER                               NULL,
  DEL_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DEL_EJE_COD  VARCHAR2(4 BYTE)                     NULL
)
;





CREATE TABLE TCMP_DEPCTA002
(
  DCT_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  DCT_FIS_COD    VARCHAR2(4 BYTE)                   NULL,
  DCT_EXC        VARCHAR2(4 BYTE)                   NULL,
  DCT_BA1_BII1   NUMBER(15,3)                       NULL,
  DCT_BA1_BII2   NUMBER(15,3)                       NULL,
  DCT_BA1_BII3   NUMBER(15,3)                       NULL,
  DCT_BA1_BII4   NUMBER(15,3)                       NULL,
  DCT_BA1_BII5   NUMBER(15,3)                       NULL,
  DCT_BA1_BII6   NUMBER(15,3)                       NULL,
  DCT_BA1_BII7   NUMBER(15,3)                       NULL,
  DCT_BA1_BII8   NUMBER(15,3)                       NULL,
  DCT_BA1_BII9   NUMBER(15,3)                       NULL,
  DCT_BA1_BIII1  NUMBER(15,3)                       NULL,
  DCT_BA1_BIII2  NUMBER(15,3)                       NULL,
  DCT_BA1_BIII3  NUMBER(15,3)                       NULL,
  DCT_BA1_BIII4  NUMBER(15,3)                       NULL,
  DCT_BA1_BIII5  NUMBER(15,3)                       NULL,
  DCT_BA1_BIII6  NUMBER(15,3)                       NULL,
  DCT_BA1_BIII7  NUMBER(15,3)                       NULL,
  DCT_BA1_BIV1   NUMBER(15,3)                       NULL,
  DCT_BA1_BIV2   NUMBER(15,3)                       NULL,
  DCT_BA1_BIV3   NUMBER(15,3)                       NULL,
  DCT_BA1_BIV4   NUMBER(15,3)                       NULL,
  DCT_BA1_BIV5   NUMBER(15,3)                       NULL,
  DCT_BA1_BIV6   NUMBER(15,3)                       NULL,
  DCT_BA1_BIV7   NUMBER(15,3)                       NULL,
  DCT_BA1_BIV8   NUMBER(15,3)                       NULL,
  DCT_BA1_BIV9   NUMBER(15,3)                       NULL,
  DCT_BA1_DII1   NUMBER(15,3)                       NULL,
  DCT_BA1_DII2   NUMBER(15,3)                       NULL,
  DCT_BA1_DII3   NUMBER(15,3)                       NULL,
  DCT_BA1_DII4   NUMBER(15,3)                       NULL,
  DCT_BA1_DII5   NUMBER(15,3)                       NULL,
  DCT_BA1_DII6   NUMBER(15,3)                       NULL,
  DCT_BA1_DII7   NUMBER(15,3)                       NULL,
  DCT_BA1_DIII1  NUMBER(15,3)                       NULL,
  DCT_BA1_DIII2  NUMBER(15,3)                       NULL,
  DCT_BA1_DIII3  NUMBER(15,3)                       NULL,
  DCT_BA1_DIII4  NUMBER(15,3)                       NULL,
  DCT_BA1_DIII5  NUMBER(15,3)                       NULL,
  DCT_BA1_DIII6  NUMBER(15,3)                       NULL,
  DCT_BA1_DIII7  NUMBER(15,3)                       NULL,
  DCT_BA1_DIV1   NUMBER(15,3)                       NULL,
  DCT_BA1_DIV2   NUMBER(15,3)                       NULL,
  DCT_BA1_DIV3   NUMBER(15,3)                       NULL,
  DCT_BA1_DIV4   NUMBER(15,3)                       NULL,
  DCT_BA1_DIV5   NUMBER(15,3)                       NULL,
  DCT_BA1_DIV6   NUMBER(15,3)                       NULL,
  DCT_BA1_DIV7   NUMBER(15,3)                       NULL,
  DCT_BA1_DIV8   NUMBER(15,3)                       NULL,
  DCT_BA2_AIV3   NUMBER(15,3)                       NULL,
  DCT_BA2_AIV4   NUMBER(15,3)                       NULL,
  DCT_BA2_AIV5   NUMBER(15,3)                       NULL,
  DCT_BA2_AIV6   NUMBER(15,3)                       NULL,
  DCT_BA2_AV1    NUMBER(15,3)                       NULL,
  DCT_BA2_AV2    NUMBER(15,3)                       NULL,
  DCT_BA2_AV3    NUMBER(15,3)                       NULL,
  DCT_BA2_B1     NUMBER(15,3)                       NULL,
  DCT_BA2_B2     NUMBER(15,3)                       NULL,
  DCT_BA2_B3     NUMBER(15,3)                       NULL,
  DCT_BA2_B4     NUMBER(15,3)                       NULL,
  DCT_BA2_C1     NUMBER(15,3)                       NULL,
  DCT_BA2_C2     NUMBER(15,3)                       NULL,
  DCT_BA2_C3     NUMBER(15,3)                       NULL,
  DCT_BA2_C4     NUMBER(15,3)                       NULL,
  DCT_BA2_DI     NUMBER(15,3)                       NULL,
  DCT_BA2_DI1    NUMBER(15,3)                       NULL,
  DCT_BA2_DI2    NUMBER(15,3)                       NULL,
  DCT_BA2_DI3    NUMBER(15,3)                       NULL,
  DCT_BA2_DII    NUMBER(15,3)                       NULL,
  DCT_BA2_DII1   NUMBER(15,3)                       NULL,
  DCT_BA2_DII2   NUMBER(15,3)                       NULL,
  DCT_BA2_DIII   NUMBER(15,3)                       NULL,
  DCT_BA2_DIII1  NUMBER(15,3)                       NULL,
  DCT_BA2_DIII2  NUMBER(15,3)                       NULL,
  DCT_BA2_DIV    NUMBER(15,3)                       NULL,
  DCT_BA2_DIV1   NUMBER(15,3)                       NULL,
  DCT_BA2_DIV2   NUMBER(15,3)                       NULL,
  DCT_BA2_DIV3   NUMBER(15,3)                       NULL,
  DCT_BA2_DIV4   NUMBER(15,3)                       NULL,
  DCT_BA2_DV     NUMBER(15,3)                       NULL,
  DCT_BA2_DV1    NUMBER(15,3)                       NULL,
  DCT_BA2_DV2    NUMBER(15,3)                       NULL,
  DCT_BA2_DV3    NUMBER(15,3)                       NULL,
  DCT_BA2_DVI    NUMBER(15,3)                       NULL,
  DCT_BA2_EI     NUMBER(15,3)                       NULL,
  DCT_BA2_EI1    NUMBER(15,3)                       NULL,
  DCT_BA2_EI2    NUMBER(15,3)                       NULL,
  DCT_BA2_EI3    NUMBER(15,3)                       NULL,
  DCT_BA2_EI4    NUMBER(15,3)                       NULL,
  DCT_BA2_EII    NUMBER(15,3)                       NULL,
  DCT_BA2_EII1   NUMBER(15,3)                       NULL,
  DCT_BA2_EII2   NUMBER(15,3)                       NULL,
  DCT_BA2_EII3   NUMBER(15,3)                       NULL,
  DCT_BA2_EIII   NUMBER(15,3)                       NULL,
  DCT_BA2_EIII1  NUMBER(15,3)                       NULL,
  DCT_BA2_EIII2  NUMBER(15,3)                       NULL,
  DCT_BA2_EIV    NUMBER(15,3)                       NULL,
  DCT_BA2_EIV1   NUMBER(15,3)                       NULL,
  DCT_BA2_EIV2   NUMBER(15,3)                       NULL,
  DCT_BA2_EIV3   NUMBER(15,3)                       NULL,
  DCT_BA2_EV     NUMBER(15,3)                       NULL,
  DCT_BA2_EV1    NUMBER(15,3)                       NULL,
  DCT_BA2_EV2    NUMBER(15,3)                       NULL,
  DCT_BA2_EV3    NUMBER(15,3)                       NULL,
  DCT_BA2_EV4    NUMBER(15,3)                       NULL,
  DCT_BA2_EV5    NUMBER(15,3)                       NULL,
  DCT_BA2_EVI    NUMBER(15,3)                       NULL,
  DCT_BA2_EVII   NUMBER(15,3)                       NULL,
  DCT_PA1_A2C    NUMBER(15,3)                       NULL,
  DCT_PA1_A3A    NUMBER(15,3)                       NULL,
  DCT_PA1_A3B    NUMBER(15,3)                       NULL,
  DCT_PA1_A5A    NUMBER(15,3)                       NULL,
  DCT_PA1_A5B    NUMBER(15,3)                       NULL,
  DCT_PA1_A5C    NUMBER(15,3)                       NULL,
  DCT_PA1_A7A    NUMBER(15,3)                       NULL,
  DCT_PA1_A7B    NUMBER(15,3)                       NULL,
  DCT_PA1_A7C    NUMBER(15,3)                       NULL,
  DCT_PA1_A7D    NUMBER(15,3)                       NULL,
  DCT_PA1_A16    NUMBER(15,3)                       NULL,
  DCT_PA2_B1C    NUMBER(15,3)                       NULL,
  DCT_PA2_B4A    NUMBER(15,3)                       NULL,
  DCT_PA2_B4B    NUMBER(15,3)                       NULL,
  DCT_PA2_B4C    NUMBER(15,3)                       NULL,
  DCT_PA2_B5A    NUMBER(15,3)                       NULL,
  DCT_PA2_B5B    NUMBER(15,3)                       NULL,
  DCT_PA2_B5C    NUMBER(15,3)                       NULL,
  DCT_PA2_B6A    NUMBER(15,3)                       NULL,
  DCT_PA2_B6B    NUMBER(15,3)                       NULL,
  DCT_PA2_B6C    NUMBER(15,3)                       NULL,
  DCT_PA2_B7A    NUMBER(15,3)                       NULL,
  DCT_PA2_B7B    NUMBER(15,3)                       NULL,
  DCT_PA2_B7C    NUMBER(15,3)                       NULL,
  DCT_PA2_B7D    NUMBER(15,3)                       NULL,
  DCT_PA2_B9     NUMBER(15,3)                       NULL,
  DCT_PA2_B10    NUMBER(15,3)                       NULL,
  DCT_PA2_B11    NUMBER(15,3)                       NULL,
  DCT_PA2_B12    NUMBER(15,3)                       NULL,
  DCT_PA2_B13    NUMBER(15,3)                       NULL,
  DCP_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  DCP_DATCRE     DATE                               NULL,
  DCP_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  DCP_DATMOD     DATE                               NULL
)
;


CREATE TABLE TCMP_DEPCTA003
(
  DCT_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  DCT_FIS_COD        VARCHAR2(4 BYTE)               NULL,
  DCT_EXC            VARCHAR2(4 BYTE)               NULL,
  DCT_BA1_BII1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BII2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BII3_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BII4_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BII5_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BII6_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BII7_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BII8_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BII9_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIII1_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_BIII2_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_BIII3_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_BIII4_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_BIII5_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_BIII6_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_BIII7_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_BIV1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV3_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV4_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV5_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV6_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV7_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV8_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV9_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DII1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DII2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DII3_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DII4_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DII5_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DII6_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DII7_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIII1_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_DIII2_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_DIII3_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_DIII4_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_DIII5_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_DIII6_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_DIII7_ANT  NUMBER(15,3)                   NULL,
  DCT_BA1_DIV1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIV2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIV3_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIV4_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIV5_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIV6_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIV7_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIV8_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AIV3_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AIV4_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AIV5_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AIV6_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AV1_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_AV2_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_AV3_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_B1_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_B2_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_B3_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_B4_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_C1_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_C2_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_C3_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_C4_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_DI_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_DI1_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_DI2_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_DI3_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_DII_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_DII1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_DII2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_DIII_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_DIII1_ANT  NUMBER(15,3)                   NULL,
  DCT_BA2_DIII2_ANT  NUMBER(15,3)                   NULL,
  DCT_BA2_DIV_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_DIV1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_DIV2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_DIV3_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_DIV4_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_DV_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_DV1_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_DV2_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_DV3_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_DVI_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EI_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_EI1_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EI2_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EI3_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EI4_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EII_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EII1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_EII2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_EII3_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_EIII_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_EIII1_ANT  NUMBER(15,3)                   NULL,
  DCT_BA2_EIII2_ANT  NUMBER(15,3)                   NULL,
  DCT_BA2_EIV_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EIV1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_EIV2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_EIV3_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_EV_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_EV1_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EV2_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EV3_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EV4_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EV5_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EVI_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_EVII_ANT   NUMBER(15,3)                   NULL,
  DCT_PA1_A2C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A3A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A3B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A5A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A5B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A5C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A7A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A7B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A7C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A7D_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A16_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B1C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B4A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B4B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B4C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B5A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B5B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B5C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B6A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B6B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B6C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B7A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B7B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B7C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B7D_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B9_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_B10_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B11_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B12_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B13_ANT    NUMBER(15,3)                   NULL,
  DCP_USUCRE         VARCHAR2(30 BYTE)              NULL,
  DCP_DATCRE         DATE                           NULL,
  DCP_USUMOD         VARCHAR2(30 BYTE)              NULL,
  DCP_DATMOD         DATE                           NULL
)
;


CREATE TABLE TCMP_DEPCTA08_BAL
(
  DCB_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DCB_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  DCB_EXC      VARCHAR2(4 BYTE)                     NULL,
  DCB_COD      VARCHAR2(4 BYTE)                     NULL,
  DCB_TIP      VARCHAR2(1 BYTE)                     NULL,
  DCB_SEQ      NUMBER(2)                            NULL,
  DCB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DCB_DATCRE   DATE                                 NULL,
  DCB_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DCB_DATMOD   DATE                                 NULL,
  DCB_001      NUMBER(15,2)                         NULL,
  DCB_001ANT   NUMBER(15,2)                         NULL,
  DCB_001NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_002      NUMBER(15,2)                         NULL,
  DCB_002ANT   NUMBER(15,2)                         NULL,
  DCB_002NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_003      NUMBER(15,2)                         NULL,
  DCB_003ANT   NUMBER(15,2)                         NULL,
  DCB_003NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_004      NUMBER(15,2)                         NULL,
  DCB_004ANT   NUMBER(15,2)                         NULL,
  DCB_004NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_005      NUMBER(15,2)                         NULL,
  DCB_005ANT   NUMBER(15,2)                         NULL,
  DCB_005NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_006      NUMBER(15,2)                         NULL,
  DCB_006ANT   NUMBER(15,2)                         NULL,
  DCB_006NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_007      NUMBER(15,2)                         NULL,
  DCB_007ANT   NUMBER(15,2)                         NULL,
  DCB_007NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_008      NUMBER(15,2)                         NULL,
  DCB_008ANT   NUMBER(15,2)                         NULL,
  DCB_008NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_009      NUMBER(15,2)                         NULL,
  DCB_009ANT   NUMBER(15,2)                         NULL,
  DCB_009NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_010      NUMBER(15,2)                         NULL,
  DCB_010ANT   NUMBER(15,2)                         NULL,
  DCB_010NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_011      NUMBER(15,2)                         NULL,
  DCB_011ANT   NUMBER(15,2)                         NULL,
  DCB_011NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_012      NUMBER(15,2)                         NULL,
  DCB_012ANT   NUMBER(15,2)                         NULL,
  DCB_012NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_013      NUMBER(15,2)                         NULL,
  DCB_013ANT   NUMBER(15,2)                         NULL,
  DCB_013NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_014      NUMBER(15,2)                         NULL,
  DCB_014ANT   NUMBER(15,2)                         NULL,
  DCB_014NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_015      NUMBER(15,2)                         NULL,
  DCB_015ANT   NUMBER(15,2)                         NULL,
  DCB_015NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_016      NUMBER(15,2)                         NULL,
  DCB_016ANT   NUMBER(15,2)                         NULL,
  DCB_016NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_017      NUMBER(15,2)                         NULL,
  DCB_017ANT   NUMBER(15,2)                         NULL,
  DCB_017NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_018      NUMBER(15,2)                         NULL,
  DCB_018ANT   NUMBER(15,2)                         NULL,
  DCB_018NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_019      NUMBER(15,2)                         NULL,
  DCB_019ANT   NUMBER(15,2)                         NULL,
  DCB_019NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_020      NUMBER(15,2)                         NULL,
  DCB_020ANT   NUMBER(15,2)                         NULL,
  DCB_020NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_021      NUMBER(15,2)                         NULL,
  DCB_021ANT   NUMBER(15,2)                         NULL,
  DCB_021NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_022      NUMBER(15,2)                         NULL,
  DCB_022ANT   NUMBER(15,2)                         NULL,
  DCB_022NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_023      NUMBER(15,2)                         NULL,
  DCB_023ANT   NUMBER(15,2)                         NULL,
  DCB_023NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_024      NUMBER(15,2)                         NULL,
  DCB_024ANT   NUMBER(15,2)                         NULL,
  DCB_024NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_025      NUMBER(15,2)                         NULL,
  DCB_025ANT   NUMBER(15,2)                         NULL,
  DCB_025NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_026      NUMBER(15,2)                         NULL,
  DCB_026ANT   NUMBER(15,2)                         NULL,
  DCB_026NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_027      NUMBER(15,2)                         NULL,
  DCB_027ANT   NUMBER(15,2)                         NULL,
  DCB_027NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_028      NUMBER(15,2)                         NULL,
  DCB_028ANT   NUMBER(15,2)                         NULL,
  DCB_028NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_029      NUMBER(15,2)                         NULL,
  DCB_029ANT   NUMBER(15,2)                         NULL,
  DCB_029NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_030      NUMBER(15,2)                         NULL,
  DCB_030ANT   NUMBER(15,2)                         NULL,
  DCB_030NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_031      NUMBER(15,2)                         NULL,
  DCB_031ANT   NUMBER(15,2)                         NULL,
  DCB_031NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_032      NUMBER(15,2)                         NULL,
  DCB_032ANT   NUMBER(15,2)                         NULL,
  DCB_032NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_033      NUMBER(15,2)                         NULL,
  DCB_033ANT   NUMBER(15,2)                         NULL,
  DCB_033NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_034      NUMBER(15,2)                         NULL,
  DCB_034ANT   NUMBER(15,2)                         NULL,
  DCB_034NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_035      NUMBER(15,2)                         NULL,
  DCB_035ANT   NUMBER(15,2)                         NULL,
  DCB_035NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_036      NUMBER(15,2)                         NULL,
  DCB_036ANT   NUMBER(15,2)                         NULL,
  DCB_036NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_037      NUMBER(15,2)                         NULL,
  DCB_037ANT   NUMBER(15,2)                         NULL,
  DCB_037NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_038      NUMBER(15,2)                         NULL,
  DCB_038ANT   NUMBER(15,2)                         NULL,
  DCB_038NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_039      NUMBER(15,2)                         NULL,
  DCB_039ANT   NUMBER(15,2)                         NULL,
  DCB_039NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_040      NUMBER(15,2)                         NULL,
  DCB_040ANT   NUMBER(15,2)                         NULL,
  DCB_040NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_041      NUMBER(15,2)                         NULL,
  DCB_041ANT   NUMBER(15,2)                         NULL,
  DCB_041NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_042      NUMBER(15,2)                         NULL,
  DCB_042ANT   NUMBER(15,2)                         NULL,
  DCB_042NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_043      NUMBER(15,2)                         NULL,
  DCB_043ANT   NUMBER(15,2)                         NULL,
  DCB_043NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_044      NUMBER(15,2)                         NULL,
  DCB_044ANT   NUMBER(15,2)                         NULL,
  DCB_044NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_045      NUMBER(15,2)                         NULL,
  DCB_045ANT   NUMBER(15,2)                         NULL,
  DCB_045NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_046      NUMBER(15,2)                         NULL,
  DCB_046ANT   NUMBER(15,2)                         NULL,
  DCB_046NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_047      NUMBER(15,2)                         NULL,
  DCB_047ANT   NUMBER(15,2)                         NULL,
  DCB_047NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_048      NUMBER(15,2)                         NULL,
  DCB_048ANT   NUMBER(15,2)                         NULL,
  DCB_048NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_049      NUMBER(15,2)                         NULL,
  DCB_049ANT   NUMBER(15,2)                         NULL,
  DCB_049NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_050      NUMBER(15,2)                         NULL,
  DCB_050ANT   NUMBER(15,2)                         NULL,
  DCB_050NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_051      NUMBER(15,2)                         NULL,
  DCB_051ANT   NUMBER(15,2)                         NULL,
  DCB_051NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_052      NUMBER(15,2)                         NULL,
  DCB_052ANT   NUMBER(15,2)                         NULL,
  DCB_052NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_053      NUMBER(15,2)                         NULL,
  DCB_053ANT   NUMBER(15,2)                         NULL,
  DCB_053NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_054      NUMBER(15,2)                         NULL,
  DCB_054ANT   NUMBER(15,2)                         NULL,
  DCB_054NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_055      NUMBER(15,2)                         NULL,
  DCB_055ANT   NUMBER(15,2)                         NULL,
  DCB_055NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_056      NUMBER(15,2)                         NULL,
  DCB_056ANT   NUMBER(15,2)                         NULL,
  DCB_056NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_057      NUMBER(15,2)                         NULL,
  DCB_057ANT   NUMBER(15,2)                         NULL,
  DCB_057NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_058      NUMBER(15,2)                         NULL,
  DCB_058ANT   NUMBER(15,2)                         NULL,
  DCB_058NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_059      NUMBER(15,2)                         NULL,
  DCB_059ANT   NUMBER(15,2)                         NULL,
  DCB_059NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_060      NUMBER(15,2)                         NULL,
  DCB_060ANT   NUMBER(15,2)                         NULL,
  DCB_060NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_061      NUMBER(15,2)                         NULL,
  DCB_061ANT   NUMBER(15,2)                         NULL,
  DCB_061NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_062      NUMBER(15,2)                         NULL,
  DCB_062ANT   NUMBER(15,2)                         NULL,
  DCB_062NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_063      NUMBER(15,2)                         NULL,
  DCB_063ANT   NUMBER(15,2)                         NULL,
  DCB_063NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_064      NUMBER(15,2)                         NULL,
  DCB_064ANT   NUMBER(15,2)                         NULL,
  DCB_064NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_065      NUMBER(15,2)                         NULL,
  DCB_065ANT   NUMBER(15,2)                         NULL,
  DCB_065NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_066      NUMBER(15,2)                         NULL,
  DCB_066ANT   NUMBER(15,2)                         NULL,
  DCB_066NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_067      NUMBER(15,2)                         NULL,
  DCB_067ANT   NUMBER(15,2)                         NULL,
  DCB_067NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_068      NUMBER(15,2)                         NULL,
  DCB_068ANT   NUMBER(15,2)                         NULL,
  DCB_068NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_069      NUMBER(15,2)                         NULL,
  DCB_069ANT   NUMBER(15,2)                         NULL,
  DCB_069NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_070      NUMBER(15,2)                         NULL,
  DCB_070ANT   NUMBER(15,2)                         NULL,
  DCB_070NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_071      NUMBER(15,2)                         NULL,
  DCB_071ANT   NUMBER(15,2)                         NULL,
  DCB_071NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_072      NUMBER(15,2)                         NULL,
  DCB_072ANT   NUMBER(15,2)                         NULL,
  DCB_072NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_073      NUMBER(15,2)                         NULL,
  DCB_073ANT   NUMBER(15,2)                         NULL,
  DCB_073NOT   VARCHAR2(5 BYTE)                     NULL,
  DCB_074      NUMBER(15,2)                         NULL,
  DCB_074ANT   NUMBER(15,2)                         NULL,
  DCB_074NOT   VARCHAR2(5 BYTE)                     NULL
)
;


CREATE TABLE TCMP_DEPCTA08_PNP
(
  PNP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PNP_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  PNP_EXC      VARCHAR2(4 BYTE)                     NULL,
  PNP_COD      VARCHAR2(4 BYTE)                     NULL,
  PNP_TIP      VARCHAR2(1 BYTE)                     NULL,
  PNP_SEQ      NUMBER(2)                            NULL,
  PNP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PNP_DATCRE   DATE                                 NULL,
  PNP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PNP_DATMOD   DATE                                 NULL,
  PNP_ESC001   NUMBER(15,2)                         NULL,
  PNP_NEX001   NUMBER(15,2)                         NULL,
  PNP_PEM001   NUMBER(15,2)                         NULL,
  PNP_RES001   NUMBER(15,2)                         NULL,
  PNP_ACC001   NUMBER(15,2)                         NULL,
  PNP_REA001   NUMBER(15,2)                         NULL,
  PNP_OAS001   NUMBER(15,2)                         NULL,
  PNP_REJ001   NUMBER(15,2)                         NULL,
  PNP_DIV001   NUMBER(15,2)                         NULL,
  PNP_OIP001   NUMBER(15,2)                         NULL,
  PNP_APN001   NUMBER(15,2)                         NULL,
  PNP_SDL001   NUMBER(15,2)                         NULL,
  PNP_TOT001   NUMBER(15,2)                         NULL,
  PNP_ESC002   NUMBER(15,2)                         NULL,
  PNP_NEX002   NUMBER(15,2)                         NULL,
  PNP_PEM002   NUMBER(15,2)                         NULL,
  PNP_RES002   NUMBER(15,2)                         NULL,
  PNP_ACC002   NUMBER(15,2)                         NULL,
  PNP_REA002   NUMBER(15,2)                         NULL,
  PNP_OAS002   NUMBER(15,2)                         NULL,
  PNP_REJ002   NUMBER(15,2)                         NULL,
  PNP_DIV002   NUMBER(15,2)                         NULL,
  PNP_OIP002   NUMBER(15,2)                         NULL,
  PNP_APN002   NUMBER(15,2)                         NULL,
  PNP_SDL002   NUMBER(15,2)                         NULL,
  PNP_TOT002   NUMBER(15,2)                         NULL,
  PNP_ESC003   NUMBER(15,2)                         NULL,
  PNP_NEX003   NUMBER(15,2)                         NULL,
  PNP_PEM003   NUMBER(15,2)                         NULL,
  PNP_RES003   NUMBER(15,2)                         NULL,
  PNP_ACC003   NUMBER(15,2)                         NULL,
  PNP_REA003   NUMBER(15,2)                         NULL,
  PNP_OAS003   NUMBER(15,2)                         NULL,
  PNP_REJ003   NUMBER(15,2)                         NULL,
  PNP_DIV003   NUMBER(15,2)                         NULL,
  PNP_OIP003   NUMBER(15,2)                         NULL,
  PNP_APN003   NUMBER(15,2)                         NULL,
  PNP_SDL003   NUMBER(15,2)                         NULL,
  PNP_TOT003   NUMBER(15,2)                         NULL,
  PNP_ESC004   NUMBER(15,2)                         NULL,
  PNP_NEX004   NUMBER(15,2)                         NULL,
  PNP_PEM004   NUMBER(15,2)                         NULL,
  PNP_RES004   NUMBER(15,2)                         NULL,
  PNP_ACC004   NUMBER(15,2)                         NULL,
  PNP_REA004   NUMBER(15,2)                         NULL,
  PNP_OAS004   NUMBER(15,2)                         NULL,
  PNP_REJ004   NUMBER(15,2)                         NULL,
  PNP_DIV004   NUMBER(15,2)                         NULL,
  PNP_OIP004   NUMBER(15,2)                         NULL,
  PNP_APN004   NUMBER(15,2)                         NULL,
  PNP_SDL004   NUMBER(15,2)                         NULL,
  PNP_TOT004   NUMBER(15,2)                         NULL,
  PNP_ESC005   NUMBER(15,2)                         NULL,
  PNP_NEX005   NUMBER(15,2)                         NULL,
  PNP_PEM005   NUMBER(15,2)                         NULL,
  PNP_RES005   NUMBER(15,2)                         NULL,
  PNP_ACC005   NUMBER(15,2)                         NULL,
  PNP_REA005   NUMBER(15,2)                         NULL,
  PNP_OAS005   NUMBER(15,2)                         NULL,
  PNP_REJ005   NUMBER(15,2)                         NULL,
  PNP_DIV005   NUMBER(15,2)                         NULL,
  PNP_OIP005   NUMBER(15,2)                         NULL,
  PNP_APN005   NUMBER(15,2)                         NULL,
  PNP_SDL005   NUMBER(15,2)                         NULL,
  PNP_TOT005   NUMBER(15,2)                         NULL,
  PNP_ESC006   NUMBER(15,2)                         NULL,
  PNP_NEX006   NUMBER(15,2)                         NULL,
  PNP_PEM006   NUMBER(15,2)                         NULL,
  PNP_RES006   NUMBER(15,2)                         NULL,
  PNP_ACC006   NUMBER(15,2)                         NULL,
  PNP_REA006   NUMBER(15,2)                         NULL,
  PNP_OAS006   NUMBER(15,2)                         NULL,
  PNP_REJ006   NUMBER(15,2)                         NULL,
  PNP_DIV006   NUMBER(15,2)                         NULL,
  PNP_OIP006   NUMBER(15,2)                         NULL,
  PNP_APN006   NUMBER(15,2)                         NULL,
  PNP_SDL006   NUMBER(15,2)                         NULL,
  PNP_TOT006   NUMBER(15,2)                         NULL,
  PNP_ESC007   NUMBER(15,2)                         NULL,
  PNP_NEX007   NUMBER(15,2)                         NULL,
  PNP_PEM007   NUMBER(15,2)                         NULL,
  PNP_RES007   NUMBER(15,2)                         NULL,
  PNP_ACC007   NUMBER(15,2)                         NULL,
  PNP_REA007   NUMBER(15,2)                         NULL,
  PNP_OAS007   NUMBER(15,2)                         NULL,
  PNP_REJ007   NUMBER(15,2)                         NULL,
  PNP_DIV007   NUMBER(15,2)                         NULL,
  PNP_OIP007   NUMBER(15,2)                         NULL,
  PNP_APN007   NUMBER(15,2)                         NULL,
  PNP_SDL007   NUMBER(15,2)                         NULL,
  PNP_TOT007   NUMBER(15,2)                         NULL,
  PNP_ESC008   NUMBER(15,2)                         NULL,
  PNP_NEX008   NUMBER(15,2)                         NULL,
  PNP_PEM008   NUMBER(15,2)                         NULL,
  PNP_RES008   NUMBER(15,2)                         NULL,
  PNP_ACC008   NUMBER(15,2)                         NULL,
  PNP_REA008   NUMBER(15,2)                         NULL,
  PNP_OAS008   NUMBER(15,2)                         NULL,
  PNP_REJ008   NUMBER(15,2)                         NULL,
  PNP_DIV008   NUMBER(15,2)                         NULL,
  PNP_OIP008   NUMBER(15,2)                         NULL,
  PNP_APN008   NUMBER(15,2)                         NULL,
  PNP_SDL008   NUMBER(15,2)                         NULL,
  PNP_TOT008   NUMBER(15,2)                         NULL,
  PNP_ESC009   NUMBER(15,2)                         NULL,
  PNP_NEX009   NUMBER(15,2)                         NULL,
  PNP_PEM009   NUMBER(15,2)                         NULL,
  PNP_RES009   NUMBER(15,2)                         NULL,
  PNP_ACC009   NUMBER(15,2)                         NULL,
  PNP_REA009   NUMBER(15,2)                         NULL,
  PNP_OAS009   NUMBER(15,2)                         NULL,
  PNP_REJ009   NUMBER(15,2)                         NULL,
  PNP_DIV009   NUMBER(15,2)                         NULL,
  PNP_OIP009   NUMBER(15,2)                         NULL,
  PNP_APN009   NUMBER(15,2)                         NULL,
  PNP_SDL009   NUMBER(15,2)                         NULL,
  PNP_TOT009   NUMBER(15,2)                         NULL,
  PNP_ESC010   NUMBER(15,2)                         NULL,
  PNP_NEX010   NUMBER(15,2)                         NULL,
  PNP_PEM010   NUMBER(15,2)                         NULL,
  PNP_RES010   NUMBER(15,2)                         NULL,
  PNP_ACC010   NUMBER(15,2)                         NULL,
  PNP_REA010   NUMBER(15,2)                         NULL,
  PNP_OAS010   NUMBER(15,2)                         NULL,
  PNP_REJ010   NUMBER(15,2)                         NULL,
  PNP_DIV010   NUMBER(15,2)                         NULL,
  PNP_OIP010   NUMBER(15,2)                         NULL,
  PNP_APN010   NUMBER(15,2)                         NULL,
  PNP_SDL010   NUMBER(15,2)                         NULL,
  PNP_TOT010   NUMBER(15,2)                         NULL,
  PNP_ESC011   NUMBER(15,2)                         NULL,
  PNP_NEX011   NUMBER(15,2)                         NULL,
  PNP_PEM011   NUMBER(15,2)                         NULL,
  PNP_RES011   NUMBER(15,2)                         NULL,
  PNP_ACC011   NUMBER(15,2)                         NULL,
  PNP_REA011   NUMBER(15,2)                         NULL,
  PNP_OAS011   NUMBER(15,2)                         NULL,
  PNP_REJ011   NUMBER(15,2)                         NULL,
  PNP_DIV011   NUMBER(15,2)                         NULL,
  PNP_OIP011   NUMBER(15,2)                         NULL,
  PNP_APN011   NUMBER(15,2)                         NULL,
  PNP_SDL011   NUMBER(15,2)                         NULL,
  PNP_TOT011   NUMBER(15,2)                         NULL,
  PNP_ESC012   NUMBER(15,2)                         NULL,
  PNP_NEX012   NUMBER(15,2)                         NULL,
  PNP_PEM012   NUMBER(15,2)                         NULL,
  PNP_RES012   NUMBER(15,2)                         NULL,
  PNP_ACC012   NUMBER(15,2)                         NULL,
  PNP_REA012   NUMBER(15,2)                         NULL,
  PNP_OAS012   NUMBER(15,2)                         NULL,
  PNP_REJ012   NUMBER(15,2)                         NULL,
  PNP_DIV012   NUMBER(15,2)                         NULL,
  PNP_OIP012   NUMBER(15,2)                         NULL,
  PNP_APN012   NUMBER(15,2)                         NULL,
  PNP_SDL012   NUMBER(15,2)                         NULL,
  PNP_TOT012   NUMBER(15,2)                         NULL,
  PNP_ESC013   NUMBER(15,2)                         NULL,
  PNP_NEX013   NUMBER(15,2)                         NULL,
  PNP_PEM013   NUMBER(15,2)                         NULL,
  PNP_RES013   NUMBER(15,2)                         NULL,
  PNP_ACC013   NUMBER(15,2)                         NULL,
  PNP_REA013   NUMBER(15,2)                         NULL,
  PNP_OAS013   NUMBER(15,2)                         NULL,
  PNP_REJ013   NUMBER(15,2)                         NULL,
  PNP_DIV013   NUMBER(15,2)                         NULL,
  PNP_OIP013   NUMBER(15,2)                         NULL,
  PNP_APN013   NUMBER(15,2)                         NULL,
  PNP_SDL013   NUMBER(15,2)                         NULL,
  PNP_TOT013   NUMBER(15,2)                         NULL,
  PNP_ESC014   NUMBER(15,2)                         NULL,
  PNP_NEX014   NUMBER(15,2)                         NULL,
  PNP_PEM014   NUMBER(15,2)                         NULL,
  PNP_RES014   NUMBER(15,2)                         NULL,
  PNP_ACC014   NUMBER(15,2)                         NULL,
  PNP_REA014   NUMBER(15,2)                         NULL,
  PNP_OAS014   NUMBER(15,2)                         NULL,
  PNP_REJ014   NUMBER(15,2)                         NULL,
  PNP_DIV014   NUMBER(15,2)                         NULL,
  PNP_OIP014   NUMBER(15,2)                         NULL,
  PNP_APN014   NUMBER(15,2)                         NULL,
  PNP_SDL014   NUMBER(15,2)                         NULL,
  PNP_TOT014   NUMBER(15,2)                         NULL,
  PNP_ESC015   NUMBER(15,2)                         NULL,
  PNP_NEX015   NUMBER(15,2)                         NULL,
  PNP_PEM015   NUMBER(15,2)                         NULL,
  PNP_RES015   NUMBER(15,2)                         NULL,
  PNP_ACC015   NUMBER(15,2)                         NULL,
  PNP_REA015   NUMBER(15,2)                         NULL,
  PNP_OAS015   NUMBER(15,2)                         NULL,
  PNP_REJ015   NUMBER(15,2)                         NULL,
  PNP_DIV015   NUMBER(15,2)                         NULL,
  PNP_OIP015   NUMBER(15,2)                         NULL,
  PNP_APN015   NUMBER(15,2)                         NULL,
  PNP_SDL015   NUMBER(15,2)                         NULL,
  PNP_TOT015   NUMBER(15,2)                         NULL,
  PNP_ESC016   NUMBER(15,2)                         NULL,
  PNP_NEX016   NUMBER(15,2)                         NULL,
  PNP_PEM016   NUMBER(15,2)                         NULL,
  PNP_RES016   NUMBER(15,2)                         NULL,
  PNP_ACC016   NUMBER(15,2)                         NULL,
  PNP_REA016   NUMBER(15,2)                         NULL,
  PNP_OAS016   NUMBER(15,2)                         NULL,
  PNP_REJ016   NUMBER(15,2)                         NULL,
  PNP_DIV016   NUMBER(15,2)                         NULL,
  PNP_OIP016   NUMBER(15,2)                         NULL,
  PNP_APN016   NUMBER(15,2)                         NULL,
  PNP_SDL016   NUMBER(15,2)                         NULL,
  PNP_TOT016   NUMBER(15,2)                         NULL,
  PNP_ESC017   NUMBER(15,2)                         NULL,
  PNP_NEX017   NUMBER(15,2)                         NULL,
  PNP_PEM017   NUMBER(15,2)                         NULL,
  PNP_RES017   NUMBER(15,2)                         NULL,
  PNP_ACC017   NUMBER(15,2)                         NULL,
  PNP_REA017   NUMBER(15,2)                         NULL,
  PNP_OAS017   NUMBER(15,2)                         NULL,
  PNP_REJ017   NUMBER(15,2)                         NULL,
  PNP_DIV017   NUMBER(15,2)                         NULL,
  PNP_OIP017   NUMBER(15,2)                         NULL,
  PNP_APN017   NUMBER(15,2)                         NULL,
  PNP_SDL017   NUMBER(15,2)                         NULL,
  PNP_TOT017   NUMBER(15,2)                         NULL,
  PNP_ESC018   NUMBER(15,2)                         NULL,
  PNP_NEX018   NUMBER(15,2)                         NULL,
  PNP_PEM018   NUMBER(15,2)                         NULL,
  PNP_RES018   NUMBER(15,2)                         NULL,
  PNP_ACC018   NUMBER(15,2)                         NULL,
  PNP_REA018   NUMBER(15,2)                         NULL,
  PNP_OAS018   NUMBER(15,2)                         NULL,
  PNP_REJ018   NUMBER(15,2)                         NULL,
  PNP_DIV018   NUMBER(15,2)                         NULL,
  PNP_OIP018   NUMBER(15,2)                         NULL,
  PNP_APN018   NUMBER(15,2)                         NULL,
  PNP_SDL018   NUMBER(15,2)                         NULL,
  PNP_TOT018   NUMBER(15,2)                         NULL,
  PNP_ESC019   NUMBER(15,2)                         NULL,
  PNP_NEX019   NUMBER(15,2)                         NULL,
  PNP_PEM019   NUMBER(15,2)                         NULL,
  PNP_RES019   NUMBER(15,2)                         NULL,
  PNP_ACC019   NUMBER(15,2)                         NULL,
  PNP_REA019   NUMBER(15,2)                         NULL,
  PNP_OAS019   NUMBER(15,2)                         NULL,
  PNP_REJ019   NUMBER(15,2)                         NULL,
  PNP_DIV019   NUMBER(15,2)                         NULL,
  PNP_OIP019   NUMBER(15,2)                         NULL,
  PNP_APN019   NUMBER(15,2)                         NULL,
  PNP_SDL019   NUMBER(15,2)                         NULL,
  PNP_TOT019   NUMBER(15,2)                         NULL,
  PNP_ESC020   NUMBER(15,2)                         NULL,
  PNP_NEX020   NUMBER(15,2)                         NULL,
  PNP_PEM020   NUMBER(15,2)                         NULL,
  PNP_RES020   NUMBER(15,2)                         NULL,
  PNP_ACC020   NUMBER(15,2)                         NULL,
  PNP_REA020   NUMBER(15,2)                         NULL,
  PNP_OAS020   NUMBER(15,2)                         NULL,
  PNP_REJ020   NUMBER(15,2)                         NULL,
  PNP_DIV020   NUMBER(15,2)                         NULL,
  PNP_OIP020   NUMBER(15,2)                         NULL,
  PNP_APN020   NUMBER(15,2)                         NULL,
  PNP_SDL020   NUMBER(15,2)                         NULL,
  PNP_TOT020   NUMBER(15,2)                         NULL,
  PNP_ESC021   NUMBER(15,2)                         NULL,
  PNP_NEX021   NUMBER(15,2)                         NULL,
  PNP_PEM021   NUMBER(15,2)                         NULL,
  PNP_RES021   NUMBER(15,2)                         NULL,
  PNP_ACC021   NUMBER(15,2)                         NULL,
  PNP_REA021   NUMBER(15,2)                         NULL,
  PNP_OAS021   NUMBER(15,2)                         NULL,
  PNP_REJ021   NUMBER(15,2)                         NULL,
  PNP_DIV021   NUMBER(15,2)                         NULL,
  PNP_OIP021   NUMBER(15,2)                         NULL,
  PNP_APN021   NUMBER(15,2)                         NULL,
  PNP_SDL021   NUMBER(15,2)                         NULL,
  PNP_TOT021   NUMBER(15,2)                         NULL,
  PNP_ESC022   NUMBER(15,2)                         NULL,
  PNP_NEX022   NUMBER(15,2)                         NULL,
  PNP_PEM022   NUMBER(15,2)                         NULL,
  PNP_RES022   NUMBER(15,2)                         NULL,
  PNP_ACC022   NUMBER(15,2)                         NULL,
  PNP_REA022   NUMBER(15,2)                         NULL,
  PNP_OAS022   NUMBER(15,2)                         NULL,
  PNP_REJ022   NUMBER(15,2)                         NULL,
  PNP_DIV022   NUMBER(15,2)                         NULL,
  PNP_OIP022   NUMBER(15,2)                         NULL,
  PNP_APN022   NUMBER(15,2)                         NULL,
  PNP_SDL022   NUMBER(15,2)                         NULL,
  PNP_TOT022   NUMBER(15,2)                         NULL,
  PNP_ESC023   NUMBER(15,2)                         NULL,
  PNP_NEX023   NUMBER(15,2)                         NULL,
  PNP_PEM023   NUMBER(15,2)                         NULL,
  PNP_RES023   NUMBER(15,2)                         NULL,
  PNP_ACC023   NUMBER(15,2)                         NULL,
  PNP_REA023   NUMBER(15,2)                         NULL,
  PNP_OAS023   NUMBER(15,2)                         NULL,
  PNP_REJ023   NUMBER(15,2)                         NULL,
  PNP_DIV023   NUMBER(15,2)                         NULL,
  PNP_OIP023   NUMBER(15,2)                         NULL,
  PNP_APN023   NUMBER(15,2)                         NULL,
  PNP_SDL023   NUMBER(15,2)                         NULL,
  PNP_TOT023   NUMBER(15,2)                         NULL,
  PNP_ESC024   NUMBER(15,2)                         NULL,
  PNP_NEX024   NUMBER(15,2)                         NULL,
  PNP_PEM024   NUMBER(15,2)                         NULL,
  PNP_RES024   NUMBER(15,2)                         NULL,
  PNP_ACC024   NUMBER(15,2)                         NULL,
  PNP_REA024   NUMBER(15,2)                         NULL,
  PNP_OAS024   NUMBER(15,2)                         NULL,
  PNP_REJ024   NUMBER(15,2)                         NULL,
  PNP_DIV024   NUMBER(15,2)                         NULL,
  PNP_OIP024   NUMBER(15,2)                         NULL,
  PNP_APN024   NUMBER(15,2)                         NULL,
  PNP_SDL024   NUMBER(15,2)                         NULL,
  PNP_TOT024   NUMBER(15,2)                         NULL,
  PNP_ESC025   NUMBER(15,2)                         NULL,
  PNP_NEX025   NUMBER(15,2)                         NULL,
  PNP_PEM025   NUMBER(15,2)                         NULL,
  PNP_RES025   NUMBER(15,2)                         NULL,
  PNP_ACC025   NUMBER(15,2)                         NULL,
  PNP_REA025   NUMBER(15,2)                         NULL,
  PNP_OAS025   NUMBER(15,2)                         NULL,
  PNP_REJ025   NUMBER(15,2)                         NULL,
  PNP_DIV025   NUMBER(15,2)                         NULL,
  PNP_OIP025   NUMBER(15,2)                         NULL,
  PNP_APN025   NUMBER(15,2)                         NULL,
  PNP_SDL025   NUMBER(15,2)                         NULL,
  PNP_TOT025   NUMBER(15,2)                         NULL,
  PNP_ESC026   NUMBER(15,2)                         NULL,
  PNP_NEX026   NUMBER(15,2)                         NULL,
  PNP_PEM026   NUMBER(15,2)                         NULL,
  PNP_RES026   NUMBER(15,2)                         NULL,
  PNP_ACC026   NUMBER(15,2)                         NULL,
  PNP_REA026   NUMBER(15,2)                         NULL,
  PNP_OAS026   NUMBER(15,2)                         NULL,
  PNP_REJ026   NUMBER(15,2)                         NULL,
  PNP_DIV026   NUMBER(15,2)                         NULL,
  PNP_OIP026   NUMBER(15,2)                         NULL,
  PNP_APN026   NUMBER(15,2)                         NULL,
  PNP_SDL026   NUMBER(15,2)                         NULL,
  PNP_TOT026   NUMBER(15,2)                         NULL,
  PNP_ESC027   NUMBER(15,2)                         NULL,
  PNP_NEX027   NUMBER(15,2)                         NULL,
  PNP_PEM027   NUMBER(15,2)                         NULL,
  PNP_RES027   NUMBER(15,2)                         NULL,
  PNP_ACC027   NUMBER(15,2)                         NULL,
  PNP_REA027   NUMBER(15,2)                         NULL,
  PNP_OAS027   NUMBER(15,2)                         NULL,
  PNP_REJ027   NUMBER(15,2)                         NULL,
  PNP_DIV027   NUMBER(15,2)                         NULL,
  PNP_OIP027   NUMBER(15,2)                         NULL,
  PNP_APN027   NUMBER(15,2)                         NULL,
  PNP_SDL027   NUMBER(15,2)                         NULL,
  PNP_TOT027   NUMBER(15,2)                         NULL,
  PNP_ESC028   NUMBER(15,2)                         NULL,
  PNP_NEX028   NUMBER(15,2)                         NULL,
  PNP_PEM028   NUMBER(15,2)                         NULL,
  PNP_RES028   NUMBER(15,2)                         NULL,
  PNP_ACC028   NUMBER(15,2)                         NULL,
  PNP_REA028   NUMBER(15,2)                         NULL,
  PNP_OAS028   NUMBER(15,2)                         NULL,
  PNP_REJ028   NUMBER(15,2)                         NULL,
  PNP_DIV028   NUMBER(15,2)                         NULL,
  PNP_OIP028   NUMBER(15,2)                         NULL,
  PNP_APN028   NUMBER(15,2)                         NULL,
  PNP_SDL028   NUMBER(15,2)                         NULL,
  PNP_TOT028   NUMBER(15,2)                         NULL,
  PNP_ESC029   NUMBER(15,2)                         NULL,
  PNP_NEX029   NUMBER(15,2)                         NULL,
  PNP_PEM029   NUMBER(15,2)                         NULL,
  PNP_RES029   NUMBER(15,2)                         NULL,
  PNP_ACC029   NUMBER(15,2)                         NULL,
  PNP_REA029   NUMBER(15,2)                         NULL,
  PNP_OAS029   NUMBER(15,2)                         NULL,
  PNP_REJ029   NUMBER(15,2)                         NULL,
  PNP_DIV029   NUMBER(15,2)                         NULL,
  PNP_OIP029   NUMBER(15,2)                         NULL,
  PNP_APN029   NUMBER(15,2)                         NULL,
  PNP_SDL029   NUMBER(15,2)                         NULL,
  PNP_TOT029   NUMBER(15,2)                         NULL,
  PNP_ESC030   NUMBER(15,2)                         NULL,
  PNP_NEX030   NUMBER(15,2)                         NULL,
  PNP_PEM030   NUMBER(15,2)                         NULL,
  PNP_RES030   NUMBER(15,2)                         NULL,
  PNP_ACC030   NUMBER(15,2)                         NULL,
  PNP_REA030   NUMBER(15,2)                         NULL,
  PNP_OAS030   NUMBER(15,2)                         NULL,
  PNP_REJ030   NUMBER(15,2)                         NULL,
  PNP_DIV030   NUMBER(15,2)                         NULL,
  PNP_OIP030   NUMBER(15,2)                         NULL,
  PNP_APN030   NUMBER(15,2)                         NULL,
  PNP_SDL030   NUMBER(15,2)                         NULL,
  PNP_TOT030   NUMBER(15,2)                         NULL,
  PNP_ESC031   NUMBER(15,2)                         NULL,
  PNP_NEX031   NUMBER(15,2)                         NULL,
  PNP_PEM031   NUMBER(15,2)                         NULL,
  PNP_RES031   NUMBER(15,2)                         NULL,
  PNP_ACC031   NUMBER(15,2)                         NULL,
  PNP_REA031   NUMBER(15,2)                         NULL,
  PNP_OAS031   NUMBER(15,2)                         NULL,
  PNP_REJ031   NUMBER(15,2)                         NULL,
  PNP_DIV031   NUMBER(15,2)                         NULL,
  PNP_OIP031   NUMBER(15,2)                         NULL,
  PNP_APN031   NUMBER(15,2)                         NULL,
  PNP_SDL031   NUMBER(15,2)                         NULL,
  PNP_TOT031   NUMBER(15,2)                         NULL
)
;




CREATE TABLE TCMP_DEPPROCOM_TRASPAS
(
  DCO_USU            VARCHAR2(30 BYTE)              NULL,
  DCO_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  DCO_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  DCO_EJE_COD        VARCHAR2(4 BYTE)               NULL,
  DCO_DIA_COD        VARCHAR2(2 BYTE)               NULL,
  DCO_ASI_NUMASIAUX  NUMBER(10)                     NULL,
  DCO_APU_NUMAPUAUX  NUMBER(10)                     NULL,
  DCO_SEQ            NUMBER(10)                     NULL,
  DCO_PTEDEP         NUMBER(5,2)                DEFAULT 0                         NULL,
  DCO_IMPDEP         NUMBER(15,3)               DEFAULT 0                         NULL,
  DCO_PTEPRO         NUMBER(5,2)                DEFAULT 0                         NULL,
  DCO_IMPPRO         NUMBER(15,3)               DEFAULT 0                         NULL,
  DCO_VALDEP         NUMBER(15,3)               DEFAULT 0                         NULL,
  DCO_VALPRO         NUMBER(15,3)               DEFAULT 0                         NULL,
  DCO_PRO_COD        VARCHAR2(4 BYTE)               NULL,
  DCO_DEP_COD        VARCHAR2(4 BYTE)               NULL,
  DCO_EXD_COD        VARCHAR2(4 BYTE)               NULL,
  DCO_PTEEXD         NUMBER(5,2)                    NULL,
  DCO_IMPEXD         NUMBER(15,3)                   NULL,
  DCO_VALEXD         NUMBER(15,3)                   NULL,
  DCO_DEL_COD        VARCHAR2(4 BYTE)               NULL,
  DCO_PTEDEL         NUMBER(5,2)                    NULL,
  DCO_IMPDEL         NUMBER(15,3)                   NULL,
  DCO_VALDEL         NUMBER(15,3)                   NULL,
  DCO_OBS            VARCHAR2(4000 BYTE)            NULL
)
;




CREATE TABLE TCMP_DINAMICS
(
  DIN_COD  NUMBER(10)                               NULL
)
;


CREATE TABLE TCMP_DMO
(
  DMO_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DMO_MDL      VARCHAR2(3 BYTE)                     NULL,
  DMO_GRP      VARCHAR2(3 BYTE)                     NULL,
  DMO_COD      VARCHAR2(7 BYTE)                     NULL,
  DMO_ORD      NUMBER(2)                            NULL,
  DMO_DES      VARCHAR2(128 BYTE)                   NULL,
  DMO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DMO_DATCRE   DATE                                 NULL,
  DMO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DMO_DATMOD   DATE                                 NULL,
  DMO_PTE      NUMBER(5,2)                          NULL
)
;





CREATE TABLE TCMP_DPG
(
  DPG_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DPG_COD      VARCHAR2(4 BYTE)                     NULL,
  DPG_EFE      VARCHAR2(1 BYTE)                     NULL,
  DPG_DATCRE   DATE                                 NULL,
  DPG_DES      VARCHAR2(30 BYTE)                    NULL,
  DPG_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DPG_DATMOD   DATE                                 NULL,
  DPG_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;





CREATE TABLE TCMP_EFC
(
  EFC_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  EFC_NUMREG   VARCHAR2(30 BYTE)                    NULL,
  EFC_SEQ      NUMBER(3)                            NULL,
  EFC_EST      VARCHAR2(4 BYTE)                     NULL,
  EFC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EFC_DATCRE   DATE                                 NULL,
  EFC_ENV      VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  EFC_DATMOD   DATE                                 NULL,
  EFC_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  EFC_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;




CREATE TABLE TCMP_ESI
(
  ESI_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ESI_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  ESI_SEQ      NUMBER(10)                           NULL,
  ESI_DAT      DATE                                 NULL,
  ESI_DATCRE   DATE                             DEFAULT NULL                      NULL,
  ESI_USUCRE   VARCHAR2(30 BYTE)                DEFAULT NULL                      NULL
)
;


CREATE TABLE TCMP_EST
(
  EST_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  EST_COD      VARCHAR2(4 BYTE)                     NULL,
  EST_NOM      VARCHAR2(30 BYTE)                    NULL,
  EST_CMP      VARCHAR2(1 BYTE)                     NULL,
  EST_CNF      VARCHAR2(1 BYTE)                     NULL,
  EST_DATCRE   DATE                                 NULL,
  EST_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EST_DATMOD   DATE                                 NULL,
  EST_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;





CREATE TABLE TCMP_FCE
(
  FCE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  FCE_NUMREG   VARCHAR2(30 BYTE)                    NULL,
  FCE_PRC      VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  FCE_SER      VARCHAR2(30 BYTE)                    NULL,
  FCE_NUM      VARCHAR2(30 BYTE)                    NULL,
  FCE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FCE_DATCRE   DATE                                 NULL,
  FCE_FIT      VARCHAR2(1000 BYTE)                  NULL,
  FCE_DATMOD   DATE                                 NULL,
  FCE_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  FCE_FITPDF   VARCHAR2(1000 BYTE)                  NULL,
  FCE_FRM001   DATE                                 NULL,
  FCE_FRM002   DATE                                 NULL,
  FCE_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TCMP_FPA
(
  FPA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  FPA_COD      VARCHAR2(4 BYTE)                     NULL,
  FPA_DATCRE   DATE                                 NULL,
  FPA_DES      VARCHAR2(30 BYTE)                    NULL,
  FPA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FPA_DTI      VARCHAR2(10 BYTE)                    NULL,
  FPA_DATMOD   DATE                                 NULL,
  FPA_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;





CREATE TABLE TCMP_GRUPS
(
  GRP_COD      VARCHAR2(15 BYTE)                    NULL,
  GRP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  GRP_NOM      VARCHAR2(30 BYTE)                    NULL,
  GRP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  GRP_DATCRE   DATE                                 NULL,
  GRP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  GRP_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_HISENDES
(
  HIS_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  HIS_COD      NUMBER(5)                            NULL,
  HIS_NOMDEL   VARCHAR2(30 BYTE)                    NULL,
  HIS_NOMADM   VARCHAR2(30 BYTE)                    NULL,
  HIS_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  HIS_DATCRE   DATE                                 NULL,
  HIS_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  HIS_DATMOD   DATE                                 NULL
)
;




CREATE TABLE TCMP_HPR
(
  HPR_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  HPR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  HPR_COD      VARCHAR2(6 BYTE)                     NULL,
  HPR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  HPR_DATCRE   DATE                                 NULL,
  HPR_DES      VARCHAR2(255 BYTE)                   NULL,
  HPR_DATCOP   DATE                                 NULL,
  HPR_DATINS   DATE                                 NULL,
  HPR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  HPR_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_IAES
(
  IAE_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  IAE_EPIGRAFE   VARCHAR2(5 BYTE)                   NULL,
  IAE_DES        VARCHAR2(40 BYTE)                  NULL,
  IAE_MAGPER     NUMBER(5,2)                    DEFAULT 0                         NULL,
  IAE_MAGVEH     NUMBER(5,2)                    DEFAULT 0                         NULL,
  IAE_MAGANY     NUMBER(15,3)                   DEFAULT 0                         NULL,
  IAE_PTE_A_CTA  NUMBER(5,2)                    DEFAULT 0                         NULL,
  IAE_PTEMINANY  NUMBER(5,2)                    DEFAULT 0                         NULL,
  IAE_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  IAE_DATCRE     DATE                               NULL,
  IAE_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  IAE_DATMOD     DATE                               NULL,
  IAE_IDXCOR     NUMBER                             NULL,
  IAE_CLA        VARCHAR2(1 BYTE)                   NULL,
  IAE_CODPRN     VARCHAR2(5 BYTE)                   NULL
)
;





CREATE TABLE TCMP_ICV
(
  ICV_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ICV_COD      VARCHAR2(4 BYTE)                     NULL,
  ICV_DES      VARCHAR2(30 BYTE)                    NULL,
  ICV_DATCRE   DATE                                 NULL,
  ICV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ICV_DATMOD   DATE                                 NULL,
  ICV_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_IMPRESSIONS
(
  IMP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  IMP_COD      VARCHAR2(4 BYTE)                     NULL,
  IMP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  IMP_DATCRE   DATE                                 NULL,
  IMP_DES      VARCHAR2(1000 BYTE)                  NULL,
  IMP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  IMP_DATMOD   DATE                                 NULL
)
;




CREATE TABLE TCMP_INFORMES
(
  INF_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  INF_COD      VARCHAR2(4 BYTE)                     NULL,
  INF_DES      VARCHAR2(1000 BYTE)                  NULL,
  INF_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  INF_DATCRE   DATE                                 NULL,
  INF_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  INF_DATMOD   DATE                                 NULL
)
;





CREATE TABLE TCMP_INFORMES_BMP
(
  INB_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  INB_COD      VARCHAR2(4 BYTE)                     NULL,
  INB_DES      VARCHAR2(1000 BYTE)                  NULL,
  INB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  INB_DATCRE   DATE                                 NULL,
  INB_TTL001   VARCHAR2(256 BYTE)                   NULL,
  INB_TTL002   VARCHAR2(256 BYTE)                   NULL,
  INB_TTL003   VARCHAR2(256 BYTE)                   NULL,
  INB_TTL004   VARCHAR2(256 BYTE)                   NULL,
  INB_TTL005   VARCHAR2(256 BYTE)                   NULL,
  INB_TTL006   VARCHAR2(256 BYTE)                   NULL,
  INB_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  INB_DATMOD   DATE                                 NULL,
  INB_ORD002   NUMBER(3)                            NULL
)
;




CREATE TABLE TCMP_LINIES_DINAMIC
(
  LDI_DIN_COD  NUMBER(10)                           NULL,
  LDI_NUM      NUMBER(10)                           NULL,
  LDI_DES      VARCHAR2(132 BYTE)                   NULL
)
;


CREATE TABLE TCMP_LINIES_IMPRESSIO
(
  LIM_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  LIM_IMP_COD  VARCHAR2(4 BYTE)                     NULL,
  LIM_NUM      NUMBER(10)                           NULL,
  LIM_DES      VARCHAR2(132 BYTE)                   NULL,
  LIM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  LIM_DATCRE   DATE                                 NULL,
  LIM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  LIM_DATMOD   DATE                                 NULL
)
;





CREATE TABLE TCMP_LINIES_INFORME
(
  LIN_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  LIN_INF_COD  VARCHAR2(4 BYTE)                     NULL,
  LIN_COD      NUMBER(10)                           NULL,
  LIN_DES      VARCHAR2(34 BYTE)                    NULL,
  LIN_ORD      NUMBER(10)                           NULL,
  LIN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  LIN_DATCRE   DATE                                 NULL,
  LIN_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  LIN_DATMOD   DATE                                 NULL,
  LIN_OPE      VARCHAR2(1 BYTE)                     NULL,
  LIN_CND      VARCHAR2(1 BYTE)                     NULL
)
;





CREATE TABLE TCMP_LINIES_INFORME_BMP
(
  LIB_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  LIB_INB_COD  VARCHAR2(4 BYTE)                     NULL,
  LIB_COD      NUMBER(10)                           NULL,
  LIB_DES      VARCHAR2(64 BYTE)                    NULL,
  LIB_ORD      NUMBER(10)                           NULL,
  LIB_DTI      VARCHAR2(1 BYTE)                     NULL,
  LIB_TIP      VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  LIB_LIN      VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  LIB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  LIB_DATCRE   DATE                                 NULL,
  LIB_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  LIB_DATMOD   DATE                                 NULL,
  LIB_OPE      VARCHAR2(1 BYTE)                     NULL,
  LIB_CND      VARCHAR2(1 BYTE)                     NULL,
  LIB_DIM      NUMBER(2)                            NULL,
  LIB_VIS      VARCHAR2(1 BYTE)                     NULL
)
;





CREATE TABLE TCMP_LSTTAN
(
  TAN_NUM      NUMBER(10)                           NULL,
  TAN_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  TAN_LST      VARCHAR2(1 BYTE)                     NULL,
  TAN_PRN      VARCHAR2(1 BYTE)                     NULL,
  TAN_DES      VARCHAR2(30 BYTE)                    NULL,
  TAN_PAR      VARCHAR2(2000 BYTE)                  NULL,
  TAN_DATCRE   DATE                                 NULL,
  TAN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TAN_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TAN_DATMOD   DATE                                 NULL
)
;





CREATE TABLE TCMP_M00_R1
(
  M001_CEC_COD       VARCHAR2(4 BYTE)               NULL,
  M001_FIS_COD       VARCHAR2(4 BYTE)               NULL,
  M001_EXC           VARCHAR2(4 BYTE)               NULL,
  M001_PRD           VARCHAR2(2 BYTE)               NULL,
  M001_SEQ           NUMBER(2)                      NULL,
  M001_AG_COD        NUMBER(2)                      NULL,
  M001_AG_VOL        NUMBER(17,2)                   NULL,
  M001_AG_INDQUO     NUMBER(6,5)                    NULL,
  M001_AG_QUODEV     NUMBER(17,2)                   NULL,
  M001_AG_PTETRI     NUMBER(5,2)                    NULL,
  M001_AG_INGCTA     NUMBER(17,2)                   NULL,
  M001_AG_QUOSOP     NUMBER(17,2)                   NULL,
  M001_AG_QUOANU     NUMBER(17,2)                   NULL,
  M001_RS_IAE        VARCHAR2(4 BYTE)               NULL,
  M001_RS_UNI001     NUMBER(10,2)                   NULL,
  M001_RS_IMP001     NUMBER(17,2)                   NULL,
  M001_RS_UNI002     NUMBER(10,2)                   NULL,
  M001_RS_IMP002     NUMBER(17,2)                   NULL,
  M001_RS_UNI003     NUMBER(10,2)                   NULL,
  M001_RS_IMP003     NUMBER(17,2)                   NULL,
  M001_RS_UNI004     NUMBER(10,2)                   NULL,
  M001_RS_IMP004     NUMBER(17,2)                   NULL,
  M001_RS_UNI005     NUMBER(10,2)                   NULL,
  M001_RS_IMP005     NUMBER(17,2)                   NULL,
  M001_RS_UNI006     NUMBER(10,2)                   NULL,
  M001_RS_IMP006     NUMBER(17,2)                   NULL,
  M001_RS_UNI007     NUMBER(10,2)                   NULL,
  M001_RS_IMP007     NUMBER(17,2)                   NULL,
  M001_RS_QUODEVACT  NUMBER(17,2)                   NULL,
  M001_RS_RED        NUMBER(17,2)                   NULL,
  M001_RS_INDCOR     NUMBER(3,2)                    NULL,
  M001_RS_PTEINGCTA  NUMBER(5,2)                    NULL,
  M001_RS_INGCTA     NUMBER(17,2)                   NULL,
  M001_RS_QUOSOP     NUMBER(17,2)                   NULL,
  M001_RS_INDCORTDA  NUMBER(3,2)                    NULL,
  M001_RS_RES        NUMBER(17,2)                   NULL,
  M001_RS_PTEQUOMIN  NUMBER(5,2)                    NULL,
  M001_RS_DEVQUOPAI  NUMBER(17,2)                   NULL,
  M001_RS_QUOMIN     NUMBER(17,2)                   NULL,
  M001_RS_QUOANU     NUMBER(17,2)                   NULL,
  M001_USUCRE        VARCHAR2(30 BYTE)              NULL,
  M001_DATCRE        DATE                           NULL,
  M001_USUMOD        VARCHAR2(30 BYTE)              NULL,
  M001_DATMOD        DATE                           NULL
)
;





CREATE TABLE TCMP_MOD200DSG
(
  M200DSG_CEC_COD   VARCHAR2(4 BYTE)                NULL,
  M200DSG_M201_NUM  NUMBER(5)                       NULL,
  M200DSG_COD       VARCHAR2(5 BYTE)                NULL,
  M200DSG_DMO_COD   VARCHAR2(7 BYTE)                NULL,
  M200DSG_USUCRE    VARCHAR2(30 BYTE)               NULL,
  M200DSG_USUMOD    VARCHAR2(30 BYTE)               NULL,
  M200DSG_DES       VARCHAR2(128 BYTE)              NULL,
  M200DSG_DATCRE    DATE                            NULL,
  M200DSG_DATMOD    DATE                            NULL,
  M200DSG_IMP       NUMBER(15,2)                    NULL
)
;




CREATE TABLE TCMP_MOD347
(
  M347_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M347_EMP_COD     VARCHAR2(4 BYTE)                 NULL,
  M347_EXC         VARCHAR2(4 BYTE)                 NULL,
  M347_DAT         DATE                             NULL,
  M347_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M347_DATCRE      DATE                             NULL,
  M347_DECL_COMP   VARCHAR2(1 BYTE)                 NULL,
  M347_DECL_SUST   VARCHAR2(1 BYTE)                 NULL,
  M347_NUMDECLANT  VARCHAR2(13 BYTE)                NULL,
  M347_NUMDECL     VARCHAR2(13 BYTE)                NULL,
  M347_USUMOD      VARCHAR2(30 BYTE)                NULL,
  M347_DATMOD      DATE                             NULL
)
;


CREATE TABLE TCMP_MOD347_R1
(
  M3471_CEC_COD       VARCHAR2(4 BYTE)              NULL,
  M3471_EMP_COD       VARCHAR2(4 BYTE)              NULL,
  M3471_EXC           VARCHAR2(4 BYTE)              NULL,
  M3471_SEQ           NUMBER(10)                    NULL,
  M3471_CLS           VARCHAR2(1 BYTE)              NULL,
  M3471_CLIPRO        VARCHAR2(10 BYTE)             NULL,
  M3471_RPR           VARCHAR2(1 BYTE)              NULL,
  M3471_NIF           VARCHAR2(12 BYTE)             NULL,
  M3471_NOM           VARCHAR2(40 BYTE)             NULL,
  M3471_PRV           VARCHAR2(2 BYTE)              NULL,
  M3471_PAI           VARCHAR2(2 BYTE)              NULL,
  M3471_IMP           NUMBER(15,2)                  NULL,
  M3471_IMP001        NUMBER(15,2)                  NULL,
  M3471_IMP002        NUMBER(15,2)                  NULL,
  M3471_IMP003        NUMBER(15,2)                  NULL,
  M3471_IMP004        NUMBER(15,2)                  NULL,
  M3471_POB           VARCHAR2(30 BYTE)             NULL,
  M3471_ASE           VARCHAR2(1 BYTE)              NULL,
  M3471_LLO           VARCHAR2(1 BYTE)              NULL,
  M3471_USUCRE        VARCHAR2(30 BYTE)             NULL,
  M3471_DATCRE        DATE                          NULL,
  M3471_USUMOD        VARCHAR2(30 BYTE)             NULL,
  M3471_DATMOD        DATE                          NULL,
  M3471_EJE           VARCHAR2(4 BYTE)              NULL,
  M3471_IMPORTMET     NUMBER(15,2)                  NULL,
  M3471_IMPIMM        NUMBER(15,2)                  NULL,
  M3471_IMPIMM001     NUMBER(15,2)                  NULL,
  M3471_IMPIMM002     NUMBER(15,2)                  NULL,
  M3471_IMPIMM003     NUMBER(15,2)                  NULL,
  M3471_IMPIMM004     NUMBER(15,2)                  NULL,
  M3471_EXCMET        VARCHAR2(4 BYTE)              NULL,
  M3471_CRICXA        NUMBER(15,2)                  NULL,
  M3471_NIFCEE        VARCHAR2(17 BYTE)             NULL,
  M3471_OPSREGCRICXA  VARCHAR2(1 BYTE)              NULL,
  M3471_OPSINVSUJPAS  VARCHAR2(1 BYTE)              NULL,
  M3471_OPSREGDIP     VARCHAR2(1 BYTE)              NULL
)
;


CREATE TABLE TCMP_MOD347_R2
(
  M3472_CEC_COD    VARCHAR2(4 BYTE)                 NULL,
  M3472_EMP_COD    VARCHAR2(4 BYTE)                 NULL,
  M3472_EXC        VARCHAR2(4 BYTE)                 NULL,
  M3472_M3471_SEQ  NUMBER(10)                       NULL,
  M3472_COD        VARCHAR2(8 BYTE)                 NULL,
  M3472_IMP        NUMBER(15,2)                     NULL,
  M3472_NIF        VARCHAR2(12 BYTE)                NULL,
  M3472_NOM        VARCHAR2(40 BYTE)                NULL,
  M3472_PRV        VARCHAR2(2 BYTE)                 NULL,
  M3472_POB        VARCHAR2(30 BYTE)                NULL,
  M3472_SGL        VARCHAR2(5 BYTE)                 NULL,
  M3472_DOM        VARCHAR2(50 BYTE)                NULL,
  M3472_NUM        NUMBER(5)                        NULL,
  M3472_ESC        VARCHAR2(3 BYTE)                 NULL,
  M3472_PIS        VARCHAR2(3 BYTE)                 NULL,
  M3472_PTA        VARCHAR2(3 BYTE)                 NULL,
  M3472_CAD        VARCHAR2(25 BYTE)                NULL,
  M3472_USUCRE     VARCHAR2(30 BYTE)                NULL,
  M3472_DATCRE     DATE                             NULL,
  M3472_USUMOD     VARCHAR2(30 BYTE)                NULL,
  M3472_DATMOD     DATE                             NULL,
  M3472_SITINM     VARCHAR2(1 BYTE)                 NULL,
  M3472_TIPNUM     VARCHAR2(3 BYTE)                 NULL,
  M3472_CALNUM     VARCHAR2(3 BYTE)                 NULL,
  M3472_BLC        VARCHAR2(3 BYTE)                 NULL,
  M3472_POR        VARCHAR2(3 BYTE)                 NULL,
  M3472_CPL        VARCHAR2(40 BYTE)                NULL,
  M3472_MUN        VARCHAR2(30 BYTE)                NULL,
  M3472_CODMUN     VARCHAR2(5 BYTE)                 NULL,
  M3472_CPO        VARCHAR2(5 BYTE)                 NULL
)
;




CREATE TABLE TCMP_MONEDES
(
  MON_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  MON_COD      VARCHAR2(1 BYTE)                     NULL,
  MON_NOM      VARCHAR2(30 BYTE)                    NULL,
  MON_DATACT   DATE                                 NULL,
  MON_VALCAN   NUMBER(15,8)                     DEFAULT 0                         NULL,
  MON_REF      VARCHAR2(1 BYTE)                     NULL,
  MON_NUMDEC   NUMBER(1)                            NULL,
  MON_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  MON_DATCRE   DATE                                 NULL,
  MON_DATMOD   DATE                                 NULL,
  MON_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;





CREATE TABLE TCMP_MOVACT
(
  MAC_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  MAC_EMP_COD       VARCHAR2(4 BYTE)                NULL,
  MAC_DIA_COD       VARCHAR2(2 BYTE)                NULL,
  MAC_ASI_NUMASI    NUMBER(10)                      NULL,
  MAC_EJE_COD       VARCHAR2(4 BYTE)                NULL,
  MAC_MON_COD       VARCHAR2(1 BYTE)                NULL,
  MAC_CT5_COD       VARCHAR2(10 BYTE)               NULL,
  MAC_DEB           NUMBER(15,3)                DEFAULT 0                         NULL,
  MAC_HAB           NUMBER(15,3)                DEFAULT 0                         NULL,
  MAC_VALIMPDEB     NUMBER(15,3)                DEFAULT 0                         NULL,
  MAC_VALIMPHAB     NUMBER(15,3)                    NULL,
  MAC_ASI_DAT       DATE                            NULL,
  MAC_DATCRE        DATE                            NULL,
  MAC_USUCRE        VARCHAR2(30 BYTE)               NULL,
  MAC_CON           VARCHAR2(255 BYTE)              NULL,
  MAC_CT5DES        VARCHAR2(30 BYTE)               NULL,
  MAC_CONTRA        VARCHAR2(10 BYTE)               NULL,
  MAC_CONTRACT5DES  VARCHAR2(30 BYTE)               NULL,
  MAC_NUMDOCFRT     VARCHAR2(8 BYTE)                NULL,
  MAC_IVA_COD       VARCHAR2(4 BYTE)                NULL,
  MAC_IVA_CODINT    VARCHAR2(4 BYTE)                NULL,
  MAC_NUMDOC        VARCHAR2(8 BYTE)                NULL,
  MAC_TAS_COD       VARCHAR2(2 BYTE)                NULL,
  MAC_MONVALCAN     NUMBER(10,4)                    NULL,
  MAC_DATMOD        DATE                            NULL,
  MAC_USUMOD        VARCHAR2(30 BYTE)               NULL
)
;




CREATE TABLE TCMP_N43_CABCTA
(
  CAB_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CAB_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CAB_SEQ      NUMBER(18)                           NULL,
  CAB_TIPRGT   NUMBER(2)                            NULL,
  CAB_BAN      NUMBER(4)                            NULL,
  CAB_OFI      NUMBER(4)                            NULL,
  CAB_CCR      NUMBER(10)                           NULL,
  CAB_FECINI   DATE                                 NULL,
  CAB_FECFIN   DATE                                 NULL,
  CAB_DEBHAB   NUMBER(1)                            NULL,
  CAB_SALINI   NUMBER(12,2)                         NULL,
  CAB_DIV_COD  NUMBER(3)                            NULL,
  CAB_MDLINF   NUMBER(1)                            NULL,
  CAB_NOMABR   VARCHAR2(26 BYTE)                    NULL,
  CAB_DATCRE   DATE                                 NULL,
  CAB_USUCRE   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_N43_FINCTA
(
  FIN_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  FIN_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  FIN_CAB_SEQ  NUMBER(18)                           NULL,
  FIN_SEQ      NUMBER(18)                           NULL,
  FIN_TIPRGT   NUMBER(2)                            NULL,
  FIN_BAN      NUMBER(4)                            NULL,
  FIN_OFI      NUMBER(4)                            NULL,
  FIN_CCR      NUMBER(10)                           NULL,
  FIN_APUDEB   NUMBER(5)                            NULL,
  FIN_TOTDEB   NUMBER(12,2)                         NULL,
  FIN_APUHAB   NUMBER(5)                            NULL,
  FIN_TOTHAB   NUMBER(12,2)                         NULL,
  FIN_SALCOD   NUMBER(1)                            NULL,
  FIN_SAL      NUMBER(12,2)                         NULL,
  FIN_DIV_COD  NUMBER(3)                            NULL
)
;


CREATE TABLE TCMP_N43_IMPAPU
(
  IAP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  IAP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  IAP_CAB_SEQ  NUMBER(18)                           NULL,
  IAP_SEQ      NUMBER(18)                           NULL,
  IAP_TIPRGT   NUMBER(2)                            NULL,
  IAP_CODDAD   NUMBER(2)                            NULL,
  IAP_DIV_COD  NUMBER(3)                            NULL,
  IAP_IMP      NUMBER(12,2)                         NULL
)
;


CREATE TABLE TCMP_N43_PPLMOV
(
  MOV_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  MOV_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  MOV_CAB_SEQ  NUMBER(18)                           NULL,
  MOV_SEQ      NUMBER(18)                           NULL,
  MOV_TIPRGT   NUMBER(2)                            NULL,
  MOV_OFIORI   NUMBER(4)                            NULL,
  MOV_DATOPE   DATE                                 NULL,
  MOV_DATVAL   DATE                                 NULL,
  MOV_CNC      NUMBER(2)                            NULL,
  MOV_CNCPOP   NUMBER(3)                            NULL,
  MOV_DEBHAB   NUMBER(1)                            NULL,
  MOV_IMP      NUMBER(12,2)                         NULL,
  MOV_NUMDOC   NUMBER(10)                           NULL,
  MOV_REF002   VARCHAR2(16 BYTE)                    NULL,
  MOV_REF001   VARCHAR2(12 BYTE)                    NULL
)
;




CREATE TABLE TCMP_OBLIGACIONS
(
  OBL_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  OBL_COD      VARCHAR2(3 BYTE)                     NULL,
  OBL_DES      VARCHAR2(30 BYTE)                    NULL,
  OBL_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OBL_DATCRE   DATE                                 NULL,
  OBL_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  OBL_DATMOD   DATE                                 NULL,
  OBL_MDL      VARCHAR2(3 BYTE)                     NULL,
  OBL_PRD      NUMBER(3)                            NULL
)
;




CREATE TABLE TCMP_OPERACIONS
(
  OPE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  OPE_INF_COD  VARCHAR2(4 BYTE)                     NULL,
  OPE_LIN_COD  NUMBER(10)                           NULL,
  OPE_COD      NUMBER(10)                           NULL,
  OPE_CTA      VARCHAR2(10 BYTE)                    NULL,
  OPE_DATCRE   DATE                                 NULL,
  OPE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OPE_OPE      VARCHAR2(1 BYTE)                     NULL,
  OPE_OPR      VARCHAR2(1 BYTE)                     NULL,
  OPE_CND      VARCHAR2(1 BYTE)                     NULL,
  OPE_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  OPE_DATMOD   DATE                                 NULL
)
;





CREATE TABLE TCMP_OPERACIONS_BMP
(
  OPB_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  OPB_INB_COD  VARCHAR2(4 BYTE)                     NULL,
  OPB_LIB_COD  NUMBER(10)                           NULL,
  OPB_COD      NUMBER(10)                           NULL,
  OPB_CTA      VARCHAR2(10 BYTE)                    NULL,
  OPB_DATCRE   DATE                                 NULL,
  OPB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OPB_OPE      VARCHAR2(1 BYTE)                     NULL,
  OPB_OPR      VARCHAR2(1 BYTE)                     NULL,
  OPB_CND      VARCHAR2(1 BYTE)                     NULL,
  OPB_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  OPB_DATMOD   DATE                                 NULL
)
;





CREATE TABLE TCMP_ORDRE
(
  ORD_NUM     NUMBER(10)                            NULL,
  ORD_NOM     VARCHAR2(200 BYTE)                    NULL,
  ORD_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  ORD_DATCRE  DATE                                  NULL,
  ORD_USUMOD  VARCHAR2(30 BYTE)                     NULL,
  ORD_DATMOD  DATE                                  NULL
)
;


CREATE TABLE TCMP_PAISOS
(
  PAI_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  PAI_COD        VARCHAR2(5 BYTE)                   NULL,
  PAI_NOM        VARCHAR2(30 BYTE)                  NULL,
  PAI_CEE        VARCHAR2(1 BYTE)                   NULL,
  PAI_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  PAI_DATCRE     DATE                               NULL,
  PAI_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  PAI_DATMOD     DATE                               NULL,
  PAI_CODISO002  VARCHAR2(2 BYTE)                   NULL,
  PAI_CODISO     VARCHAR2(3 BYTE)                   NULL
)
;





CREATE TABLE TCMP_PARAMETRES
(
  PAR_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PAR_COD      VARCHAR2(15 BYTE)                    NULL,
  PAR_DES      VARCHAR2(50 BYTE)                    NULL,
  PAR_PAR      VARCHAR2(100 BYTE)                   NULL,
  PAR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PAR_DATCRE   DATE                                 NULL,
  PAR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PAR_DATMOD   DATE                                 NULL
)
;







CREATE TABLE TCMP_PDD
(
  PDD_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  PDD_PRO_COD     VARCHAR2(4 BYTE)                  NULL,
  PDD_PRO_COD002  VARCHAR2(4 BYTE)                  NULL,
  PDD_DATCRE      DATE                              NULL,
  PDD_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  PDD_PTE         NUMBER(5,2)                       NULL,
  PDD_DATMOD      DATE                              NULL,
  PDD_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;





CREATE TABLE TCMP_PRESENTA
(
  PRS_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PRS_NIF      VARCHAR2(12 BYTE)                    NULL,
  PRS_NOM      VARCHAR2(40 BYTE)                    NULL,
  PRS_SG       VARCHAR2(2 BYTE)                     NULL,
  PRS_DOM      VARCHAR2(20 BYTE)                    NULL,
  PRS_NUM      NUMBER(5)                            NULL,
  PRS_CP       VARCHAR2(5 BYTE)                     NULL,
  PRS_MUN      VARCHAR2(12 BYTE)                    NULL,
  PRS_PRV      VARCHAR2(15 BYTE)                    NULL,
  PRS_PRETEL   VARCHAR2(3 BYTE)                     NULL,
  PRS_TEL      VARCHAR2(7 BYTE)                     NULL,
  PRS_ADM      VARCHAR2(5 BYTE)                     NULL,
  PRS_FIRMA    VARCHAR2(30 BYTE)                    NULL,
  PRS_CAR      VARCHAR2(15 BYTE)                    NULL,
  PRS_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PRS_DATCRE   DATE                                 NULL,
  PRS_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PRS_DATMOD   DATE                                 NULL,
  PRS_EMPFIS   VARCHAR2(4 BYTE)                     NULL
)
;





CREATE TABLE TCMP_PRESUDESGLOSES_ANUAL002
(
  PDA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PDA_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDA_HPR_COD  VARCHAR2(6 BYTE)                     NULL,
  PDA_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  PDA_PRE_ANY  NUMBER(4)                            NULL,
  PDA_SEQ      NUMBER(10)                           NULL,
  PDA_PTE      NUMBER(5,2)                      DEFAULT 0                         NULL,
  PDA_IMPPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PDA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PDA_DATCRE   DATE                                 NULL,
  PDA_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDA_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  PDA_DIA_COD  VARCHAR2(2 BYTE)                     NULL
)
;




CREATE TABLE TCMP_PRESUPOSTS002
(
  PRE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PRE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PRE_HPR_COD  VARCHAR2(6 BYTE)                     NULL,
  PRE_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  PRE_ANY      NUMBER(4)                            NULL,
  PRE_MES      NUMBER(2)                            NULL,
  PRE_MON_COD  VARCHAR2(1 BYTE)                     NULL,
  PRE_IMPPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PRE_VALPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PRE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PRE_DATCRE   DATE                                 NULL,
  PRE_MOD      NUMBER(15,3)                         NULL
)
;




CREATE TABLE TCMP_PRESUPOSTS_X
(
  PRE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PRE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PRE_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  PRE_ANY      NUMBER(4)                            NULL,
  PRE_MES      NUMBER(2)                            NULL,
  PRE_MON_COD  VARCHAR2(1 BYTE)                     NULL,
  PRE_IMPPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PRE_VALPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PRE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PRE_DATCRE   DATE                                 NULL,
  PRE_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PRE_DATMOD   DATE                                 NULL,
  PRE_MOD      NUMBER(15,3)                         NULL,
  PRE_VALMOD   NUMBER(15,3)                         NULL
)
;


CREATE TABLE TCMP_PROJECTES
(
  PRO_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  PRO_COD        VARCHAR2(4 BYTE)                   NULL,
  PRO_DES        VARCHAR2(150 BYTE)                 NULL,
  PRO_ACT        VARCHAR2(1 BYTE)                   NULL,
  PRO_MON_COD    VARCHAR2(1 BYTE)                   NULL,
  PRO_IMPORT     NUMBER(15,3)                       NULL,
  PRO_VALIMP     NUMBER(15,3)                       NULL,
  PRO_DATINI     DATE                               NULL,
  PRO_DATFIN     DATE                               NULL,
  PRO_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  PRO_DATCRE     DATE                               NULL,
  PRO_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  PRO_DATMOD     DATE                               NULL,
  PRO_COSPRT     NUMBER(15,3)                       NULL,
  PRO_TIPCOSIDR  VARCHAR2(1 BYTE)                   NULL
)
;



CREATE TABLE TCMP_PROVINCIES
(
  PRV_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PRV_COD      VARCHAR2(3 BYTE)                     NULL,
  PRV_NOM      VARCHAR2(30 BYTE)                    NULL,
  PRV_PAI_COD  VARCHAR2(5 BYTE)                     NULL,
  PRV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PRV_DATCRE   DATE                                 NULL,
  PRV_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PRV_DATMOD   DATE                                 NULL
)
;




CREATE TABLE TCMP_RFA
(
  RFA_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  RFA_EMP_COD       VARCHAR2(4 BYTE)                NULL,
  RFA_DIA_COD       VARCHAR2(2 BYTE)                NULL,
  RFA_NUMRGT        NUMBER(10)                      NULL,
  RFA_ANY           NUMBER(4)                       NULL,
  RFA_DATRGT        DATE                            NULL,
  RFA_DATCRE        DATE                            NULL,
  RFA_USUCRE        VARCHAR2(30 BYTE)               NULL,
  RFA_CT5_CODPRO    VARCHAR2(10 BYTE)               NULL,
  RFA_NOMPRO        VARCHAR2(40 BYTE)               NULL,
  RFA_NIFPRO        VARCHAR2(12 BYTE)               NULL,
  RFA_DATFAC        DATE                            NULL,
  RFA_NUMFAC        VARCHAR2(60 BYTE)               NULL,
  RFA_FPV_SEQ       NUMBER(10)                      NULL,
  RFA_DATMOD        DATE                            NULL,
  RFA_USUMOD        VARCHAR2(30 BYTE)               NULL,
  RFA_NUMREGFACELE  VARCHAR2(30 BYTE)               NULL
)
;


CREATE TABLE TCMP_SELVEN001
(
  SLV_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  SLV_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  SLV_SEQ        NUMBER(4)                          NULL,
  SLV_DATCRE     DATE                               NULL,
  SLV_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  SLV_NOM        VARCHAR2(30 BYTE)                  NULL,
  SLV_BANEMP     VARCHAR2(15 BYTE)                  NULL,
  SLV_DATVTO001  DATE                               NULL,
  SLV_DATVTO002  DATE                               NULL,
  SLV_DATDOC001  DATE                               NULL,
  SLV_DATDOC002  DATE                               NULL,
  SLV_CTA001     VARCHAR2(10 BYTE)                  NULL,
  SLV_CTA002     VARCHAR2(10 BYTE)                  NULL,
  SLV_DOC001     VARCHAR2(8 BYTE)                   NULL,
  SLV_DOC002     VARCHAR2(8 BYTE)                   NULL,
  SLV_FPA        VARCHAR2(4 BYTE)                   NULL,
  SLV_CLAVEN     VARCHAR2(4 BYTE)                   NULL,
  SLV_INGDSP     VARCHAR2(1 BYTE)                   NULL,
  SLV_VENACT     VARCHAR2(1 BYTE)                   NULL,
  SLV_DTI        VARCHAR2(10 BYTE)                  NULL,
  SLV_CANDTI     VARCHAR2(10 BYTE)                  NULL,
  SLV_DAT        DATE                               NULL,
  SLV_OPE        VARCHAR2(2 BYTE)                   NULL,
  SLV_DSP        VARCHAR2(4 BYTE)                   NULL,
  SLV_ORD        VARCHAR2(4 BYTE)                   NULL,
  SLV_IMP        NUMBER(17,5)                       NULL,
  SLV_TIP        VARCHAR2(1 BYTE)                   NULL
)
;


CREATE TABLE TCMP_SELVEN002
(
  SLV002_CEC_COD  VARCHAR2(4 BYTE)                  NULL,
  SLV002_EMP_COD  VARCHAR2(4 BYTE)                  NULL,
  SLV002_SLV_SEQ  NUMBER(4)                         NULL,
  SLV002_DIA_COD  VARCHAR2(2 BYTE)                  NULL,
  SLV002_VEN_SEQ  NUMBER(10)                        NULL
)
;


CREATE TABLE TCMP_SID_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  SID_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  SID_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  SID_SII_SEQ     NUMBER(10)                        NULL,
  SID_SEQ         NUMBER(10)                        NULL,
  SID_IVATIPIMS   NUMBER(5,2)                       NULL,
  SID_IVABIM      NUMBER(14,2)                      NULL,
  SID_IVAQUO      NUMBER(14,2)                      NULL,
  SID_IVATIPREQ   NUMBER(5,2)                       NULL,
  SID_IVAQUOREQ   NUMBER(14,2)                      NULL,
  SID_PTECMS      NUMBER(5,2)                       NULL,
  SID_IMPCMS      NUMBER(14,2)                      NULL,
  SID_TIP         VARCHAR2(1 BYTE)                  NULL,
  SID_DATCRE      DATE                              NULL,
  SID_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  SID_DATMOD      DATE                              NULL,
  SID_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  SID_BIMEXE      NUMBER(14,2)                      NULL,
  SID_SIT_CODEXE  VARCHAR2(2 BYTE)                  NULL,
  SID_SIT_CODIMM  VARCHAR2(2 BYTE)                  NULL,
  SID_REFIMM      VARCHAR2(25 BYTE)                 NULL
)
;


CREATE TABLE TCMP_SIE_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  SIE_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  SIE_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  SIE_ESI_SEQ     NUMBER(10)                        NULL,
  SIE_SII_SEQ     NUMBER(10)                        NULL,
  SIE_DATCRE      DATE                              NULL,
  SIE_USUCRE      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TCMP_SIF_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  SIF_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  SIF_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  SIF_SII_SEQ     NUMBER(10)                        NULL,
  SIF_TIP         VARCHAR2(1 BYTE)                  NULL,
  SIF_SEQ         NUMBER(2)                         NULL,
  SIF_DATFAC      DATE                              NULL,
  SIF_NUMFAC      VARCHAR2(60 BYTE)                 NULL,
  SIF_DATCRE      DATE                              NULL,
  SIF_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  SIF_DATMOD      DATE                              NULL,
  SIF_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TCMP_SII_JN
(
  JN_OPERATION             CHAR(3 BYTE)             NULL,
  JN_ORACLE_USER           VARCHAR2(30 BYTE)        NULL,
  JN_DATETIME              DATE                     NULL,
  JN_APPLN                 VARCHAR2(30 BYTE)        NULL,
  SII_CEC_COD              VARCHAR2(4 BYTE)         NULL,
  SII_EMP_COD              VARCHAR2(4 BYTE)         NULL,
  SII_SEQ                  NUMBER(10)               NULL,
  SII_TIPLLB               VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODTIPCMU        VARCHAR2(2 BYTE)         NULL,
  SII_MON_COD              VARCHAR2(2 BYTE)         NULL,
  SII_EJE_COD              VARCHAR2(4 BYTE)         NULL,
  SII_DIA_COD              VARCHAR2(2 BYTE)         NULL,
  SII_ASI_NUMASI           NUMBER(10)               NULL,
  SII_EJE                  VARCHAR2(4 BYTE)         NULL,
  SII_PRD                  VARCHAR2(2 BYTE)         NULL,
  SII_NUM                  VARCHAR2(60 BYTE)        NULL,
  SII_NUM002               VARCHAR2(60 BYTE)        NULL,
  SII_DAT                  DATE                     NULL,
  SII_SIT_CODFAC           VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODRCT           VARCHAR2(2 BYTE)         NULL,
  SII_BASRCT               NUMBER(14,2)             NULL,
  SII_QUORCT               NUMBER(14,2)             NULL,
  SII_REQRCT               NUMBER(14,2)             NULL,
  SII_DATOPE               DATE                     NULL,
  SII_SIT_CODCLA           VARCHAR2(2 BYTE)         NULL,
  SII_IMPTOT               NUMBER(14,2)             NULL,
  SII_DESOPE               VARCHAR2(500 BYTE)       NULL,
  SII_SIT_CODIMM           VARCHAR2(2 BYTE)         NULL,
  SII_REFIMM               VARCHAR2(25 BYTE)        NULL,
  SII_IMPTRFIVA            NUMBER(14,2)             NULL,
  SII_EMIALT               VARCHAR2(1 BYTE)         NULL,
  SII_VARDTI               VARCHAR2(1 BYTE)         NULL,
  SII_CUP                  VARCHAR2(1 BYTE)         NULL,
  SII_NOMCPA               VARCHAR2(120 BYTE)       NULL,
  SII_NIFRPR               VARCHAR2(9 BYTE)         NULL,
  SII_NIFCPA               VARCHAR2(9 BYTE)         NULL,
  SII_SIT_CODPAICPA        VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODTIPIDFPAI     VARCHAR2(2 BYTE)         NULL,
  SII_IDFCPA               VARCHAR2(20 BYTE)        NULL,
  SII_IDFBIN               VARCHAR2(40 BYTE)        NULL,
  SII_BINFECINI            DATE                     NULL,
  SII_BINFECFIN            NUMBER(4,2)              NULL,
  SII_BINRGLANY            NUMBER(14,2)             NULL,
  SII_BINIDFENT            VARCHAR2(40 BYTE)        NULL,
  SII_BINRGLEFE            NUMBER(14,2)             NULL,
  SII_SIT_CODICOTIPOPE     VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODICOCLA        VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODICOPAI        VARCHAR2(2 BYTE)         NULL,
  SII_ICOPLAOPE            NUMBER(3)                NULL,
  SII_ICODESBIN            VARCHAR2(40 BYTE)        NULL,
  SII_ICODIROPE            VARCHAR2(120 BYTE)       NULL,
  SII_ICOFACDOC            VARCHAR2(150 BYTE)       NULL,
  SII_DATCOBPAG            DATE                     NULL,
  SII_SIT_CODTIPCOB        VARCHAR2(2 BYTE)         NULL,
  SII_IBN                  VARCHAR2(34 BYTE)        NULL,
  SII_NUMFACCOB            VARCHAR2(60 BYTE)        NULL,
  SII_NUMFACGRPCOB         VARCHAR2(60 BYTE)        NULL,
  SII_EST                  VARCHAR2(1 BYTE)         NULL,
  SII_DATENV               DATE                     NULL,
  SII_DATREGCMP            DATE                     NULL,
  SII_QUO                  NUMBER(14,2)             NULL,
  SII_TXTENV               VARCHAR2(1000 BYTE)      NULL,
  SII_TIP                  VARCHAR2(1 BYTE)         NULL,
  SII_SUJNOTEXEFAC         VARCHAR2(1 BYTE)         NULL,
  SII_SUJEXEFAC            VARCHAR2(1 BYTE)         NULL,
  SII_NOTSUJFAC            VARCHAR2(1 BYTE)         NULL,
  SII_SUJNOTEXEOPESRV      VARCHAR2(1 BYTE)         NULL,
  SII_SUJEXEOPESRV         VARCHAR2(1 BYTE)         NULL,
  SII_NOTSUJOPESRV         VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODEXEFAC        VARCHAR2(2 BYTE)         NULL,
  SII_BIMEXEFAC            NUMBER(14,2)             NULL,
  SII_SIT_CODEXEOPESRV     VARCHAR2(2 BYTE)         NULL,
  SII_BIMEXEOPESRV         NUMBER(14,2)             NULL,
  SII_IMPSUJFAC001         NUMBER(14,2)             NULL,
  SII_IMPSUJFAC002         NUMBER(14,2)             NULL,
  SII_IMPSUJOPESRV001      NUMBER(14,2)             NULL,
  SII_IMPSUJOPESRV002      NUMBER(14,2)             NULL,
  SII_PRSSRV               VARCHAR2(1 BYTE)         NULL,
  SII_ENTBIN               VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODDSGTIPFAC     VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODDSGTIPOPESRV  VARCHAR2(2 BYTE)         NULL,
  SII_DATCRE               DATE                     NULL,
  SII_USUCRE               VARCHAR2(30 BYTE)        NULL,
  SII_DATMOD               DATE                     NULL,
  SII_USUMOD               VARCHAR2(30 BYTE)        NULL,
  SII_SIT_CODCLA001        VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODCLA002        VARCHAR2(2 BYTE)         NULL,
  SII_NUMREG               VARCHAR2(15 BYTE)        NULL,
  SII_DATASI               DATE                     NULL,
  SII_DATREB               DATE                     NULL,
  SII_SUJNOTEXEOPEBIN      VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODDSGTIPOPEBIN  VARCHAR2(2 BYTE)         NULL,
  SII_SUJEXEOPEBIN         VARCHAR2(1 BYTE)         NULL,
  SII_BIMEXEOPEBIN         NUMBER(14,2)             NULL,
  SII_SIT_CODEXEOPEBIN     VARCHAR2(2 BYTE)         NULL,
  SII_NOTSUJOPEBIN         VARCHAR2(1 BYTE)         NULL,
  SII_IMPSUJOPEBIN001      NUMBER(14,2)             NULL,
  SII_IMPSUJOPEBIN002      NUMBER(14,2)             NULL,
  SII_SIT_CODIMM002        VARCHAR2(2 BYTE)         NULL,
  SII_REFIMM002            VARCHAR2(25 BYTE)        NULL,
  SII_SIT_CODIMM003        VARCHAR2(2 BYTE)         NULL,
  SII_REFIMM003            VARCHAR2(25 BYTE)        NULL,
  SII_FACSIM               VARCHAR2(1 BYTE)         NULL,
  SII_FACNOTIDF            VARCHAR2(1 BYTE)         NULL,
  SII_ETTNIF               VARCHAR2(9 BYTE)         NULL,
  SII_ETTNOM               VARCHAR2(120 BYTE)       NULL,
  SII_FACALT               VARCHAR2(1 BYTE)         NULL,
  SII_REFEXT               VARCHAR2(60 BYTE)        NULL,
  SII_NOTPLA               VARCHAR2(1 BYTE)         NULL,
  SII_IMPSUP               VARCHAR2(1 BYTE)         NULL,
  SII_FACALTORGMTL         VARCHAR2(1 BYTE)         NULL
)
;


CREATE TABLE TCMP_TCO
(
  TCO_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  TCO_COD      VARCHAR2(4 BYTE)                     NULL,
  TCO_DES      VARCHAR2(30 BYTE)                    NULL,
  TCO_DATCRE   DATE                                 NULL,
  TCO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TCO_DATMOD   DATE                                 NULL,
  TCO_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_TIPUSASIENTOS
(
  TAS_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  TAS_COD      VARCHAR2(2 BYTE)                     NULL,
  TAS_DES      VARCHAR2(30 BYTE)                    NULL,
  TAS_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TAS_DATCRE   DATE                                 NULL,
  TAS_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TAS_DATMOD   DATE                                 NULL
)
;





CREATE TABLE TCMP_TMI
(
  TMI_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  TMI_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  TMI_BAS_IVA  NUMBER                               NULL,
  TMI_PTE_IVA  NUMBER                               NULL,
  TMI_CUO_IVA  NUMBER                               NULL,
  TMI_BAS_REQ  NUMBER                               NULL,
  TMI_PTE_REQ  NUMBER                               NULL,
  TMI_CUO_REQ  NUMBER                               NULL,
  TMI_USU      VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_TMP_BSS
(
  BSS_NUMFIT   NUMBER(10)                           NULL,
  BSS_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  BSS_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  BSS_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  BSS_EJE_COD  VARCHAR2(4 BYTE)                     NULL,
  BSS_SAL      NUMBER(15,2)                         NULL,
  BSS_SALFIN   NUMBER                               NULL
)
;


CREATE TABLE TCMP_TMP_BSSBMP
(
  BSS_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  BSS_COD        NUMBER(10)                         NULL,
  BSS_ORD        NUMBER(4)                          NULL,
  BSS_LIN001     VARCHAR2(1 BYTE)               DEFAULT 'N'                       NULL,
  BSS_LIN002     VARCHAR2(1 BYTE)               DEFAULT 'N'                       NULL,
  BSS_TIP001     VARCHAR2(1 BYTE)               DEFAULT 'N'                       NULL,
  BSS_TIP002     VARCHAR2(1 BYTE)               DEFAULT 'N'                       NULL,
  BSS_DIM001     NUMBER(2)                          NULL,
  BSS_DIM002     NUMBER(2)                          NULL,
  BSS_SAL001     NUMBER(15,2)                       NULL,
  BSS_SALFIN001  NUMBER(15,2)                       NULL,
  BSS_SAL002     NUMBER(15,2)                       NULL,
  BSS_SALFIN002  NUMBER(15,2)                       NULL,
  BSS_DES001     VARCHAR2(64 BYTE)                  NULL,
  BSS_DES002     VARCHAR2(64 BYTE)                  NULL
)
;


CREATE GLOBAL TEMPORARY TABLE TCMP_TMP_BSSBMPANYMES
(
  BSS_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  BSS_COD      NUMBER(10)                           NULL,
  BSS_ORD      NUMBER(4)                            NULL,
  BSS_ANY      NUMBER(4)                            NULL,
  BSS_SEC      VARCHAR2(1 BYTE)                     NULL,
  BSS_DES      VARCHAR2(64 BYTE)                    NULL,
  BSS_SAL001   NUMBER(15,2)                         NULL,
  BSS_SAL002   NUMBER(15,2)                         NULL,
  BSS_SAL003   NUMBER(15,2)                         NULL,
  BSS_SAL004   NUMBER(15,2)                         NULL,
  BSS_SAL005   NUMBER(15,2)                         NULL,
  BSS_SAL006   NUMBER(15,2)                         NULL,
  BSS_SAL007   NUMBER(15,2)                         NULL,
  BSS_SAL008   NUMBER(15,2)                         NULL,
  BSS_SAL009   NUMBER(15,2)                         NULL,
  BSS_SAL010   NUMBER(15,2)                         NULL,
  BSS_SAL011   NUMBER(15,2)                         NULL,
  BSS_SAL012   NUMBER(15,2)                         NULL,
  BSS_SALTOT   NUMBER(15,2)                         NULL,
  BSS_PRE001   NUMBER(15,2)                         NULL,
  BSS_PRE002   NUMBER(15,2)                         NULL,
  BSS_PRE003   NUMBER(15,2)                         NULL,
  BSS_PRE004   NUMBER(15,2)                         NULL,
  BSS_PRE005   NUMBER(15,2)                         NULL,
  BSS_PRE006   NUMBER(15,2)                         NULL,
  BSS_PRE007   NUMBER(15,2)                         NULL,
  BSS_PRE008   NUMBER(15,2)                         NULL,
  BSS_PRE009   NUMBER(15,2)                         NULL,
  BSS_PRE010   NUMBER(15,2)                         NULL,
  BSS_PRE011   NUMBER(15,2)                         NULL,
  BSS_PRE012   NUMBER(15,2)                         NULL,
  BSS_PRETOT   NUMBER(15,2)                         NULL,
  BSS_DIF001   NUMBER(15,2)                         NULL,
  BSS_DIF002   NUMBER(15,2)                         NULL,
  BSS_DIF003   NUMBER(15,2)                         NULL,
  BSS_DIF004   NUMBER(15,2)                         NULL,
  BSS_DIF005   NUMBER(15,2)                         NULL,
  BSS_DIF006   NUMBER(15,2)                         NULL,
  BSS_DIF007   NUMBER(15,2)                         NULL,
  BSS_DIF008   NUMBER(15,2)                         NULL,
  BSS_DIF009   NUMBER(15,2)                         NULL,
  BSS_DIF010   NUMBER(15,2)                         NULL,
  BSS_DIF011   NUMBER(15,2)                         NULL,
  BSS_DIF012   NUMBER(15,2)                         NULL,
  BSS_DIFTOT   NUMBER(15,2)                         NULL,
  BSS_PTE001   NUMBER(5,2)                          NULL,
  BSS_PTE002   NUMBER(5,2)                          NULL,
  BSS_PTE003   NUMBER(5,2)                          NULL,
  BSS_PTE004   NUMBER(5,2)                          NULL,
  BSS_PTE005   NUMBER(5,2)                          NULL,
  BSS_PTE006   NUMBER(5,2)                          NULL,
  BSS_PTE007   NUMBER(5,2)                          NULL,
  BSS_PTE008   NUMBER(5,2)                          NULL,
  BSS_PTE009   NUMBER(5,2)                          NULL,
  BSS_PTE010   NUMBER(5,2)                          NULL,
  BSS_PTE011   NUMBER(5,2)                          NULL,
  BSS_PTE012   NUMBER(5,2)                          NULL,
  BSS_PTETOT   NUMBER(5,2)                          NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TCMP_TMP_BSSBMPANYMES002
(
  BSS_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  BSS_COD      NUMBER(10)                           NULL,
  BSS_ORD      NUMBER(4)                            NULL,
  BSS_ANY      NUMBER(4)                            NULL,
  BSS_MES      NUMBER(2)                            NULL,
  BSS_DES001   VARCHAR2(64 BYTE)                    NULL,
  BSS_SAL      NUMBER(15,2)                         NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TCMP_TMP_CT5CON
(
  CT5_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CT5_COD      VARCHAR2(10 BYTE)                    NULL,
  CT5_NIF      VARCHAR2(12 BYTE)                    NULL,
  CT5_DES      VARCHAR2(30 BYTE)                    NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TCMP_TMP_CT5CONEMP
(
  EMP_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  EMP_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  EMP_COD         VARCHAR2(4 BYTE)                  NULL,
  EMP_CT5_COD002  VARCHAR2(10 BYTE)                 NULL,
  EMP_CT5DES      VARCHAR2(30 BYTE)                 NULL
)
ON COMMIT PRESERVE ROWS;


CREATE TABLE TCMP_TMP_DIA
(
  DIA_DAT     DATE                                  NULL,
  DIA_NUMASI  NUMBER                                NULL,
  DIA_CT5     VARCHAR2(10 BYTE)                     NULL,
  DIA_DES     VARCHAR2(30 BYTE)                     NULL,
  DIA_DEB     NUMBER                                NULL,
  DIA_HAB     NUMBER                                NULL,
  DIA_CON     VARCHAR2(255 BYTE)                    NULL,
  DIA_IVA     VARCHAR2(4 BYTE)                      NULL,
  DIA_CONTRA  VARCHAR2(30 BYTE)                     NULL,
  DIA_NDOC    VARCHAR2(8 BYTE)                      NULL,
  DIA_DIA     VARCHAR2(2 BYTE)                      NULL,
  DIA_CEC     VARCHAR2(4 BYTE)                      NULL,
  DIA_EMP     VARCHAR2(4 BYTE)                      NULL,
  DIA_TIP     VARCHAR2(1 BYTE)                      NULL,
  DIA_ORD     VARCHAR2(10 BYTE)                     NULL,
  DIA_OBS     VARCHAR2(30 BYTE)                     NULL,
  DIA_USU     VARCHAR2(30 BYTE)                     NULL,
  DIA_DATFAC  DATE                                  NULL,
  DIA_DATCRE  DATE                                  NULL,
  DIA_DATMOD  DATE                                  NULL,
  DIA_DATPRS  DATE                                  NULL,
  DIA_DATCNF  DATE                                  NULL,
  DIA_EJE     VARCHAR2(4 BYTE)                      NULL,
  DIA_NUMFAC  VARCHAR2(60 BYTE)                     NULL
)
;


CREATE TABLE TCMP_TMP_EAC
(
  EAC_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  EAC_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  EAC_CT5      VARCHAR2(10 BYTE)                    NULL,
  EAC_NUMFAC   VARCHAR2(8 BYTE)                     NULL,
  EAC_DIA      VARCHAR2(2 BYTE)                     NULL,
  EAC_DEB      NUMBER                               NULL,
  EAC_HAB      NUMBER                               NULL,
  EAC_USU      VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_TMP_IVA
(
  IVA_DAT     DATE                                  NULL,
  IVA_NUMDOC  VARCHAR2(8 BYTE)                      NULL,
  IVA_NUMFAC  VARCHAR2(8 BYTE)                      NULL,
  IVA_CON     VARCHAR2(255 BYTE)                    NULL,
  IVA_BIMP    NUMBER                                NULL,
  IVA_IVA     VARCHAR2(4 BYTE)                      NULL,
  IVA_CIV     VARCHAR2(2 BYTE)                      NULL,
  IVA_CUOTA   NUMBER                                NULL,
  IVA_TOTFRA  NUMBER                                NULL,
  IVA_CONTRA  VARCHAR2(10 BYTE)                     NULL,
  IVA_DESCTA  VARCHAR2(30 BYTE)                     NULL,
  IVA_NIF     VARCHAR2(12 BYTE)                     NULL,
  IVA_CEC     VARCHAR2(4 BYTE)                      NULL,
  IVA_EMP     VARCHAR2(4 BYTE)                      NULL,
  IVA_USU     VARCHAR2(30 BYTE)                     NULL
)
;


CREATE TABLE TCMP_TMP_RET
(
  TRE_CT5      VARCHAR2(14 BYTE)                    NULL,
  TRE_BAS      NUMBER(15,2)                         NULL,
  TRE_CUO      NUMBER(15,2)                         NULL,
  TRE_RET      NUMBER(15,2)                         NULL,
  TRE_LIQ      NUMBER(15,2)                         NULL,
  TRE_USU      VARCHAR2(30 BYTE)                    NULL,
  TRE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  TRE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  TRE_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  TRE_NOMCPA   VARCHAR2(128 BYTE)                   NULL
)
;


CREATE TABLE TCMP_TOC
(
  TOC_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  TOC_COD      VARCHAR2(4 BYTE)                     NULL,
  TOC_DES      VARCHAR2(140 BYTE)                   NULL,
  TOC_DATCRE   DATE                                 NULL,
  TOC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TOC_DATMOD   DATE                                 NULL,
  TOC_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TOC_TIP      VARCHAR2(1 BYTE)                     NULL,
  TOC_IMPMAX   NUMBER(15,2)                         NULL
)
;


CREATE TABLE TCMP_TRASPAS
(
  TRS_USU         VARCHAR2(30 BYTE)                 NULL,
  TRS_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  TRS_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  TRS_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  TRS_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  TRS_ASIAUX      NUMBER(10)                        NULL,
  TRS_ASI         NUMBER(10)                    DEFAULT -1                        NULL,
  TRS_APUAUX      NUMBER(10)                        NULL,
  TRS_TAS_COD     VARCHAR2(2 BYTE)                  NULL,
  TRS_DATASI      DATE                              NULL,
  TRS_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  TRS_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  TRS_IMPDEB      NUMBER(15,3)                  DEFAULT 0                         NULL,
  TRS_IMPHAB      NUMBER(15,3)                  DEFAULT 0                         NULL,
  TRS_BASIVA      NUMBER(15,3)                  DEFAULT 0                         NULL,
  TRS_TIP         VARCHAR2(1 BYTE)                  NULL,
  TRS_CON         VARCHAR2(255 BYTE)                NULL,
  TRS_IVA_COD     VARCHAR2(4 BYTE)                  NULL,
  TRS_CIV_COD     VARCHAR2(2 BYTE)                  NULL,
  TRS_IVA_CODINT  VARCHAR2(4 BYTE)                  NULL,
  TRS_CIV_CODINT  VARCHAR2(2 BYTE)                  NULL,
  TRS_CONTRA      VARCHAR2(10 BYTE)                 NULL,
  TRS_DATFAC      DATE                              NULL,
  TRS_NUMDOC      VARCHAR2(8 BYTE)                  NULL,
  TRS_NUMFAC      VARCHAR2(60 BYTE)                 NULL,
  TRS_DATVLR      DATE                              NULL,
  TRS_OBSASI      VARCHAR2(4000 BYTE)               NULL,
  TRS_MIS         VARCHAR2(1000 BYTE)               NULL,
  TRS_SER_COD     VARCHAR2(2 BYTE)                  NULL,
  TRS_FAC_NUM     NUMBER(10)                        NULL,
  TRS_FAC_CLS     VARCHAR2(1 BYTE)                  NULL,
  TRS_CXA_COD     VARCHAR2(4 BYTE)                  NULL,
  TRS_VALIMPDEB   NUMBER(15,3)                      NULL,
  TRS_VALIMPHAB   NUMBER(15,3)                      NULL,
  TRS_VALBASIVA   NUMBER(15,3)                      NULL,
  TRS_ASIGLOAUX   NUMBER(10)                        NULL,
  TRS_NIFCPA      VARCHAR2(12 BYTE)                 NULL,
  TRS_NOMCPA      VARCHAR2(40 BYTE)                 NULL,
  TRS_ASIESB      NUMBER(10)                        NULL,
  TRS_DIAESB      VARCHAR2(2 BYTE)                  NULL,
  TRS_EJEESB      VARCHAR2(4 BYTE)                  NULL
)
;


CREATE TABLE TCMP_TRASPAS_APUFAC
(
  APF_USU            VARCHAR2(30 BYTE)              NULL,
  APF_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  APF_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  APF_EJE_COD        VARCHAR2(4 BYTE)               NULL,
  APF_DIA_COD        VARCHAR2(4 BYTE)               NULL,
  APF_ASIAUX         NUMBER(10)                     NULL,
  APF_APUAUX         NUMBER                         NULL,
  APF_EJE_CODIVA     VARCHAR2(4 BYTE)               NULL,
  APF_ASI_NUMASIIVA  NUMBER(10)                     NULL,
  APF_APU_NUMAPUIVA  NUMBER                         NULL,
  APF_DPG_COD        VARCHAR2(4 BYTE)               NULL,
  APF_DAT            DATE                           NULL,
  APF_IMP            NUMBER(17,3)                   NULL,
  APF_CCR            VARCHAR2(34 BYTE)              NULL
)
;


CREATE TABLE TCMP_TRASPAS_SID
(
  SID_USU        VARCHAR2(30 BYTE)                  NULL,
  SID_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  SID_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  SID_SII_SEQ    NUMBER(10)                         NULL,
  SID_SEQ        NUMBER(10)                         NULL,
  SID_IVATIPIMS  NUMBER(5,2)                        NULL,
  SID_IVABIM     NUMBER(14,2)                       NULL,
  SID_IVAQUO     NUMBER(14,2)                       NULL,
  SID_IVATIPREQ  NUMBER(5,2)                        NULL,
  SID_IVAQUOREQ  NUMBER(14,2)                       NULL,
  SID_IMP001     NUMBER(14,2)                       NULL,
  SID_IMP002     NUMBER(14,2)                       NULL,
  SID_PTECMS     NUMBER(5,2)                        NULL,
  SID_IMPCMS     NUMBER(14,2)                       NULL,
  SID_TIP        VARCHAR2(1 BYTE)                   NULL
)
;


CREATE TABLE TCMP_TRASPAS_SIF
(
  SIF_USU      VARCHAR2(30 BYTE)                    NULL,
  SIF_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  SIF_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  SIF_SII_SEQ  NUMBER(10)                           NULL,
  SIF_TIP      VARCHAR2(1 BYTE)                     NULL,
  SIF_SEQ      NUMBER(2)                            NULL,
  SIF_DATFAC   DATE                                 NULL,
  SIF_NUMFAC   VARCHAR2(60 BYTE)                    NULL
)
;


CREATE TABLE TCMP_TRASPAS_SII
(
  SII_USU                  VARCHAR2(30 BYTE)        NULL,
  SII_CEC_COD              VARCHAR2(4 BYTE)         NULL,
  SII_EMP_COD              VARCHAR2(4 BYTE)         NULL,
  SII_SEQ                  NUMBER(10)               NULL,
  SII_TIPLLB               VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODTIPCMU        VARCHAR2(2 BYTE)         NULL,
  SII_EJE_COD              VARCHAR2(4 BYTE)         NULL,
  SII_DIA_COD              VARCHAR2(2 BYTE)         NULL,
  SII_ASIAUX               NUMBER(10)               NULL,
  SII_EJE                  VARCHAR2(4 BYTE)         NULL,
  SII_PRD                  VARCHAR2(2 BYTE)         NULL,
  SII_NUM                  VARCHAR2(60 BYTE)        NULL,
  SII_NUM002               VARCHAR2(60 BYTE)        NULL,
  SII_DAT                  DATE                     NULL,
  SII_SIT_CODFAC           VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODRCT           VARCHAR2(2 BYTE)         NULL,
  SII_BASRCT               NUMBER(14,2)             NULL,
  SII_QUORCT               NUMBER(14,2)             NULL,
  SII_REQRCT               NUMBER(14,2)             NULL,
  SII_DATOPE               DATE                     NULL,
  SII_SIT_CODCLA           VARCHAR2(2 BYTE)         NULL,
  SII_IMPTOT               NUMBER(14,2)             NULL,
  SII_DESOPE               VARCHAR2(500 BYTE)       NULL,
  SII_SIT_CODIMM           VARCHAR2(2 BYTE)         NULL,
  SII_REFIMM               VARCHAR2(25 BYTE)        NULL,
  SII_IMPTRFIVA            NUMBER(14,2)             NULL,
  SII_EMIALT               VARCHAR2(1 BYTE)         NULL,
  SII_VARDTI               VARCHAR2(1 BYTE)         NULL,
  SII_CUP                  VARCHAR2(1 BYTE)         NULL,
  SII_NOMCPA               VARCHAR2(120 BYTE)       NULL,
  SII_NIFRPR               VARCHAR2(9 BYTE)         NULL,
  SII_NIFCPA               VARCHAR2(9 BYTE)         NULL,
  SII_SIT_CODPAICPA        VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODTIPIDFPAI     VARCHAR2(2 BYTE)         NULL,
  SII_IDFCPA               VARCHAR2(20 BYTE)        NULL,
  SII_IDFBIN               VARCHAR2(40 BYTE)        NULL,
  SII_BINFECINI            DATE                     NULL,
  SII_BINFECFIN            NUMBER(4,2)              NULL,
  SII_BINRGLANY            NUMBER(14,2)             NULL,
  SII_BINIDFENT            VARCHAR2(40 BYTE)        NULL,
  SII_BINRGLEFE            NUMBER(14,2)             NULL,
  SII_SIT_CODICOTIPOPE     VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODICOCLA        VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODICOPAI        VARCHAR2(2 BYTE)         NULL,
  SII_ICOPLAOPE            NUMBER(3)                NULL,
  SII_ICODESBIN            VARCHAR2(40 BYTE)        NULL,
  SII_ICODIROPE            VARCHAR2(120 BYTE)       NULL,
  SII_ICOFACDOC            VARCHAR2(150 BYTE)       NULL,
  SII_DATCOBPAG            DATE                     NULL,
  SII_SIT_CODTIPCOB        VARCHAR2(2 BYTE)         NULL,
  SII_IBN                  VARCHAR2(34 BYTE)        NULL,
  SII_NUMFACCOB            VARCHAR2(60 BYTE)        NULL,
  SII_NUMFACGRPCOB         VARCHAR2(60 BYTE)        NULL,
  SII_DSGPTECMS            NUMBER(5,2)              NULL,
  SII_DSGIMPCMS            NUMBER(14,2)             NULL,
  SII_DATREGCMP            DATE                     NULL,
  SII_QUO                  NUMBER(14,2)             NULL,
  SII_TIP                  VARCHAR2(1 BYTE)         NULL,
  SII_SUJNOTEXEFAC         VARCHAR2(1 BYTE)         NULL,
  SII_SUJEXEFAC            VARCHAR2(1 BYTE)         NULL,
  SII_NOTSUJFAC            VARCHAR2(1 BYTE)         NULL,
  SII_SUJNOTEXEOPESRV      VARCHAR2(1 BYTE)         NULL,
  SII_SUJEXEOPESRV         VARCHAR2(1 BYTE)         NULL,
  SII_NOTSUJOPESRV         VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODEXEFAC        VARCHAR2(2 BYTE)         NULL,
  SII_BIMEXEFAC            NUMBER(14,2)             NULL,
  SII_SIT_CODEXEOPESRV     VARCHAR2(2 BYTE)         NULL,
  SII_BIMEXEOPESRV         NUMBER(14,2)             NULL,
  SII_IMPSUJFAC001         NUMBER(14,2)             NULL,
  SII_IMPSUJFAC002         NUMBER(14,2)             NULL,
  SII_IMPSUJOPESRV001      NUMBER(14,2)             NULL,
  SII_IMPSUJOPESRV002      NUMBER(14,2)             NULL,
  SII_PRSSRV               VARCHAR2(1 BYTE)         NULL,
  SII_ENTBIN               VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODDSGTIPFAC     VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODDSGTIPOPESRV  VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODCLA001        VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODCLA002        VARCHAR2(2 BYTE)         NULL,
  SII_NUMREG               VARCHAR2(15 BYTE)        NULL,
  SII_DATASI               DATE                     NULL,
  SII_DATREB               DATE                     NULL,
  SII_SUJNOTEXEOPEBIN      VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODDSGTIPOPEBIN  VARCHAR2(2 BYTE)         NULL,
  SII_SUJEXEOPEBIN         VARCHAR2(1 BYTE)         NULL,
  SII_BIMEXEOPEBIN         NUMBER(14,2)             NULL,
  SII_SIT_CODEXEOPEBIN     VARCHAR2(2 BYTE)         NULL,
  SII_NOTSUJOPEBIN         VARCHAR2(1 BYTE)         NULL,
  SII_IMPSUJOPEBIN001      NUMBER(14,2)             NULL,
  SII_IMPSUJOPEBIN002      NUMBER(14,2)             NULL
)
;


CREATE TABLE TCMP_TRSAPU
(
  APU_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  APU_ASIAUX      NUMBER(10)                        NULL,
  APU_ASI         NUMBER(10)                    DEFAULT -1                        NULL,
  APU_APUAUX      NUMBER(10)                        NULL,
  APU_TAS_COD     VARCHAR2(2 BYTE)                  NULL,
  APU_DATASI      DATE                              NULL,
  APU_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  APU_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  APU_IMPDEB      NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_IMPHAB      NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_BASIVA      NUMBER(15,3)                  DEFAULT 0                         NULL,
  APU_TIP         VARCHAR2(1 BYTE)                  NULL,
  APU_DATCRE      DATE                              NULL,
  APU_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  APU_CON         VARCHAR2(255 BYTE)                NULL,
  APU_IVA_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_CIV_COD     VARCHAR2(2 BYTE)                  NULL,
  APU_IVA_CODINT  VARCHAR2(4 BYTE)                  NULL,
  APU_CIV_CODINT  VARCHAR2(2 BYTE)                  NULL,
  APU_CONTRA      VARCHAR2(10 BYTE)                 NULL,
  APU_DATFAC      DATE                              NULL,
  APU_NUMDOC      VARCHAR2(8 BYTE)                  NULL,
  APU_NUMFAC      VARCHAR2(8 BYTE)                  NULL,
  APU_DATVLR      DATE                              NULL,
  APU_OBSASI      VARCHAR2(150 BYTE)                NULL,
  APU_SER_COD     VARCHAR2(2 BYTE)                  NULL,
  APU_FAC_NUM     NUMBER(10)                        NULL,
  APU_FAC_CLS     VARCHAR2(1 BYTE)                  NULL,
  APU_CXA_COD     VARCHAR2(4 BYTE)                  NULL,
  APU_NIFCPA      VARCHAR2(12 BYTE)                 NULL,
  APU_NOMCPA      VARCHAR2(40 BYTE)                 NULL,
  APU_DATTRA      DATE                              NULL,
  APU_TRA         VARCHAR2(1 BYTE)                  NULL
)
;


CREATE TABLE TCMP_TRSCT5
(
  CT5_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CT5_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CT5_COD      VARCHAR2(10 BYTE)                    NULL,
  CT5_DES      VARCHAR2(30 BYTE)                    NULL,
  CT5_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CT5_DATCRE   DATE                                 NULL,
  CT5_DATTRA   DATE                                 NULL,
  CT5_TRA      VARCHAR2(1 BYTE)                     NULL,
  CT5_IG       VARCHAR2(1 BYTE)                     NULL,
  CT5_TVE_COD  VARCHAR2(4 BYTE)                     NULL,
  CT5_FPA_COD  VARCHAR2(4 BYTE)                     NULL,
  CT5_CLV_COD  VARCHAR2(4 BYTE)                     NULL,
  CT5_NIF      VARCHAR2(12 BYTE)                    NULL,
  CT5_TEL      VARCHAR2(30 BYTE)                    NULL,
  CT5_FAX      VARCHAR2(30 BYTE)                    NULL,
  CT5_EML      VARCHAR2(60 BYTE)                    NULL,
  CT5_TAD      VARCHAR2(2 BYTE)                     NULL,
  CT5_DOM      VARCHAR2(30 BYTE)                    NULL,
  CT5_NUM      VARCHAR2(5 BYTE)                     NULL,
  CT5_ESC      VARCHAR2(2 BYTE)                     NULL,
  CT5_PIS      VARCHAR2(2 BYTE)                     NULL,
  CT5_PTA      VARCHAR2(2 BYTE)                     NULL,
  CT5_POB_COD  VARCHAR2(8 BYTE)                     NULL,
  CT5_PRV_COD  VARCHAR2(3 BYTE)                     NULL,
  CT5_PAI_COD  VARCHAR2(5 BYTE)                     NULL,
  CT5_POB      VARCHAR2(30 BYTE)                    NULL,
  CT5_PRV      VARCHAR2(30 BYTE)                    NULL,
  CT5_PAI      VARCHAR2(30 BYTE)                    NULL,
  CT5_CON      VARCHAR2(100 BYTE)                   NULL,
  CT5_OBS      VARCHAR2(225 BYTE)                   NULL
)
;


CREATE TABLE TCMP_TRSDEP
(
  DEP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DEP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DEP_EJE_COD  VARCHAR2(4 BYTE)                     NULL,
  DEP_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  DEP_ASIAUX   NUMBER(10)                           NULL,
  DEP_APUAUX   NUMBER(10)                           NULL,
  DEP_SEQ      NUMBER(10)                           NULL,
  DEP_PTEDEP   NUMBER(5,2)                      DEFAULT 0                         NULL,
  DEP_IMPDEP   NUMBER(15,3)                     DEFAULT 0                         NULL,
  DEP_PTEPRO   NUMBER(5,2)                      DEFAULT 0                         NULL,
  DEP_IMPPRO   NUMBER(15,3)                     DEFAULT 0                         NULL,
  DEP_DATCRE   DATE                                 NULL,
  DEP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DEP_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  DEP_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  DEP_DATTRA   DATE                                 NULL,
  DEP_TRA      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TCMP_TRSVEN
(
  VEN_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  VEN_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  VEN_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  VEN_SEQ      NUMBER(10)                           NULL,
  VEN_IG       VARCHAR2(1 BYTE)                     NULL,
  VEN_DATDOC   DATE                                 NULL,
  VEN_DATVTO   DATE                                 NULL,
  VEN_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  VEN_CON      VARCHAR2(30 BYTE)                    NULL,
  VEN_MON_COD  VARCHAR2(1 BYTE)                     NULL,
  VEN_IMPVTO   NUMBER(15,3)                     DEFAULT 0                         NULL,
  VEN_NUMFAC   VARCHAR2(8 BYTE)                     NULL,
  VEN_DESTI    VARCHAR2(10 BYTE)                    NULL,
  VEN_ACTIU    VARCHAR2(1 BYTE)                 DEFAULT 'S'                       NULL,
  VEN_REMESA   VARCHAR2(10 BYTE)                    NULL,
  VEN_DATREM   DATE                                 NULL,
  VEN_VALIMP   NUMBER(15,3)                     DEFAULT 0                         NULL,
  VEN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VEN_DATCRE   DATE                                 NULL,
  VEN_CONTAPU  NUMBER(10)                           NULL,
  VEN_OBS      VARCHAR2(1000 BYTE)                  NULL,
  VEN_CIV_COD  VARCHAR2(2 BYTE)                     NULL,
  VEN_IVA_COD  VARCHAR2(4 BYTE)                     NULL,
  VEN_CLV_COD  VARCHAR2(4 BYTE)                     NULL,
  VEN_ASIAUX   NUMBER(10)                           NULL,
  VEN_DATTRA   DATE                                 NULL,
  VEN_TRA      VARCHAR2(1 BYTE)                     NULL,
  VEN_SEQDTI   NUMBER(10)                           NULL
)
;


CREATE TABLE TCMP_TVE
(
  TVE_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  TVE_COD        VARCHAR2(4 BYTE)                   NULL,
  TVE_TIP        VARCHAR2(1 BYTE)                   NULL,
  TVE_DATCRE     DATE                               NULL,
  TVE_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  TVE_DIAINI     VARCHAR2(1 BYTE)                   NULL,
  TVE_DES        VARCHAR2(30 BYTE)                  NULL,
  TVE_DIAPLA     NUMBER(2)                          NULL,
  TVE_NUMPLA     NUMBER(2)                          NULL,
  TVE_DIAPLA001  NUMBER(3)                          NULL,
  TVE_DIAPLA002  NUMBER(3)                          NULL,
  TVE_DIAPLA003  NUMBER(3)                          NULL,
  TVE_DIAPLA004  NUMBER(3)                          NULL,
  TVE_DIAPLA005  NUMBER(3)                          NULL,
  TVE_MINDIA     NUMBER(3)                          NULL,
  TVE_DIA002PLA  NUMBER(2)                          NULL,
  TVE_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  TVE_DATMOD     DATE                               NULL
)
;





CREATE TABLE TCMP_UBI
(
  UBI_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  UBI_COD      VARCHAR2(6 BYTE)                     NULL,
  UBI_DATCRE   DATE                                 NULL,
  UBI_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  UBI_DES      VARCHAR2(1000 BYTE)                  NULL,
  UBI_DATMOD   DATE                                 NULL,
  UBI_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;





CREATE TABLE TCMP_USUARISGRUPS
(
  UGR_GRP_COD  VARCHAR2(15 BYTE)                    NULL,
  UGR_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  UGR_USU_COD  VARCHAR2(30 BYTE)                    NULL,
  UGR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  UGR_DATCRE   DATE                                 NULL,
  UGR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  UGR_DATMOD   DATE                                 NULL
)
;





CREATE TABLE TCMP_VENCIMENTS_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_NOTES        VARCHAR2(240 BYTE)                NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  JN_SESSION      NUMBER(38)                        NULL,
  VEN_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  VEN_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  VEN_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  VEN_SEQ         NUMBER(10)                        NULL,
  VEN_IG          VARCHAR2(1 BYTE)                  NULL,
  VEN_DATDOC      DATE                              NULL,
  VEN_DATVTO      DATE                              NULL,
  VEN_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  VEN_CON         VARCHAR2(30 BYTE)                 NULL,
  VEN_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  VEN_IMPVTO      NUMBER(15,3)                  DEFAULT 0                         NULL,
  VEN_NUMFAC      VARCHAR2(8 BYTE)                  NULL,
  VEN_DESTI       VARCHAR2(10 BYTE)                 NULL,
  VEN_ACTIU       VARCHAR2(1 BYTE)              DEFAULT 'S'                       NULL,
  VEN_REMESA      VARCHAR2(10 BYTE)                 NULL,
  VEN_DATREM      DATE                              NULL,
  VEN_VALIMP      NUMBER(15,3)                  DEFAULT 0                         NULL,
  VEN_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  VEN_DATCRE      DATE                              NULL,
  VEN_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  VEN_DATMOD      DATE                              NULL,
  VEN_CONTAPU     NUMBER(10)                        NULL,
  VEN_OBS         VARCHAR2(1000 BYTE)               NULL,
  VEN_CIV_COD     VARCHAR2(2 BYTE)                  NULL,
  VEN_IVA_COD     VARCHAR2(4 BYTE)                  NULL
)
;





CREATE TABLE TCMP_VMO
(
  VMO_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  VMO_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  VMO_EXC      VARCHAR2(4 BYTE)                     NULL,
  VMO_PRD      VARCHAR2(4 BYTE)                     NULL,
  VMO_MDL      VARCHAR2(3 BYTE)                     NULL,
  VMO_GRP      VARCHAR2(3 BYTE)                     NULL,
  VMO_COD      VARCHAR2(7 BYTE)                     NULL,
  VMO_VAL1     NUMBER(15,3)                         NULL,
  VMO_VAL2     NUMBER(15,3)                         NULL,
  VMO_VAL3     NUMBER(15,3)                         NULL,
  VMO_DATCRE   DATE                                 NULL,
  VMO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VMO_DATMOD   DATE                                 NULL,
  VMO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  VMO_VAL4     VARCHAR2(100 BYTE)                   NULL,
  VMO_VAL5     NUMBER(15,3)                         NULL
)
;






CREATE INDEX ICMP_CNA_CEC_FK_I ON TCMP_CNAES
(CNA_CEC_COD)
;


CREATE INDEX ICMP_CON_FK_I ON TCMP_CONCEPTES
(CON_CEC_COD)
;




CREATE INDEX ICMP_DEL_CEC_FK ON TCMP_DELETE
(DEL_CEC_COD)
;


CREATE INDEX ICMP_DEL_EJE_FK ON TCMP_DELETE
(DEL_CEC_COD, DEL_EMP_COD, DEL_EJE_COD)
;


CREATE INDEX ICMP_DMO_CEC_FK_I ON TCMP_DMO
(DMO_CEC_COD)
;


CREATE INDEX ICMP_EAC_TOT ON TCMP_TMP_EAC
(EAC_CEC_COD, EAC_EMP_COD, EAC_CT5, EAC_DIA, EAC_NUMFAC)
;


CREATE INDEX ICMP_FIN_CAB_FK ON TCMP_N43_FINCTA
(FIN_CEC_COD, FIN_EMP_COD, FIN_CAB_SEQ)
;


CREATE INDEX ICMP_GRP_CEC_FK_I ON TCMP_GRUPS
(GRP_CEC_COD)
;


CREATE INDEX ICMP_HIS_CEC_FK_I ON TCMP_HISENDES
(HIS_CEC_COD)
;


CREATE INDEX ICMP_IAE_CEC_FK_I ON TCMP_IAES
(IAE_CEC_COD)
;


CREATE INDEX ICMP_IAP_CAB_FK ON TCMP_N43_IMPAPU
(IAP_CEC_COD, IAP_EMP_COD, IAP_CAB_SEQ)
;


CREATE INDEX ICMP_IMP_CEC_FK ON TCMP_IMPRESSIONS
(IMP_CEC_COD)
;


CREATE INDEX ICMP_INF_CEC_FK ON TCMP_INFORMES
(INF_CEC_COD)
;


CREATE INDEX ICMP_LDI_DIN_FK ON TCMP_LINIES_DINAMIC
(LDI_DIN_COD)
;


CREATE INDEX ICMP_LIM_IMP_FK ON TCMP_LINIES_IMPRESSIO
(LIM_CEC_COD, LIM_IMP_COD)
;


CREATE INDEX ICMP_LIN_INF_FK ON TCMP_LINIES_INFORME
(LIN_CEC_COD, LIN_INF_COD)
;


CREATE INDEX ICMP_MAC_TOT ON TCMP_MOVACT
(MAC_CEC_COD, MAC_EMP_COD, MAC_CT5_COD, MAC_TAS_COD, MAC_DIA_COD, 
MAC_ASI_DAT)
;


CREATE INDEX ICMP_MON_FK_I ON TCMP_MONEDES
(MON_CEC_COD)
;


CREATE INDEX ICMP_MOV_CAB_FK ON TCMP_N43_PPLMOV
(MOV_CEC_COD, MOV_EMP_COD, MOV_CAB_SEQ)
;


CREATE INDEX ICMP_OBL_CEC_FK_I ON TCMP_OBLIGACIONS
(OBL_CEC_COD)
;


CREATE UNIQUE INDEX ICMP_OBL_PK ON TCMP_OBLIGACIONS
(OBL_CEC_COD, OBL_COD)
;


CREATE INDEX ICMP_OPE_LIN_FK ON TCMP_OPERACIONS
(OPE_CEC_COD, OPE_INF_COD, OPE_LIN_COD)
;


CREATE INDEX ICMP_PAI_CEC_FK_I ON TCMP_PAISOS
(PAI_CEC_COD)
;


CREATE INDEX ICMP_PAR_FK_I ON TCMP_PARAMETRES
(PAR_CEC_COD)
;




CREATE INDEX ICMP_PRO_CEC_FK_I ON TCMP_PROJECTES
(PRO_CEC_COD)
;


CREATE INDEX ICMP_PRO_MON_FK_I ON TCMP_PROJECTES
(PRO_CEC_COD, PRO_MON_COD)
;


CREATE INDEX ICMP_PRS_CEC_FK ON TCMP_PRESENTA
(PRS_CEC_COD)
;


CREATE INDEX ICMP_PRV_CEC_FK_I ON TCMP_PROVINCIES
(PRV_CEC_COD)
;


CREATE INDEX ICMP_PRV_PAI_FK_I ON TCMP_PROVINCIES
(PRV_CEC_COD, PRV_PAI_COD)
;


CREATE INDEX ICMP_TAN_CEC_FK ON TCMP_LSTTAN
(TAN_CEC_COD)
;


CREATE INDEX ICMP_TAS_FK_I ON TCMP_TIPUSASIENTOS
(TAS_CEC_COD)
;






CREATE INDEX ICMP_VMO_DMO_FK_I ON TCMP_VMO
(VMO_CEC_COD, VMO_MDL, VMO_GRP, VMO_COD)
;


CREATE INDEX ICMP_VMO_M201_FK_I ON TCMP_VMO
(VMO_CEC_COD, VMO_FIS_COD, VMO_EXC, VMO_PRD)
;


CREATE UNIQUE INDEX PK_TCMP_N43_FINCTA ON TCMP_N43_FINCTA
(FIN_CEC_COD, FIN_CAB_SEQ, FIN_SEQ)
;


CREATE UNIQUE INDEX PK_TCMP_N43_IMPAPU ON TCMP_N43_IMPAPU
(IAP_CEC_COD, IAP_EMP_COD, IAP_CAB_SEQ, IAP_SEQ)
;


CREATE UNIQUE INDEX RCMP_ACASA_FAC_PK ON TCMP_ACASA_FACTURES
(FAC_CEC_COD, FAC_EMP_COD, FAC_EJE_COD, FAC_DIA_COD, FAC_ASI_NUMASI)
;


CREATE UNIQUE INDEX RCMP_ACASA_IVA_PK ON TCMP_ACASA_FACTURES_IVA
(IVA_CEC_COD, IVA_EMP_COD, IVA_EJE_COD, IVA_DIA_COD, IVA_ASI_NUMASI, 
IVA_COD)
;


CREATE UNIQUE INDEX RCMP_ACASA_PRO_PK ON TCMP_ACASA_FACTURES_PRO
(PRO_CEC_COD, PRO_EMP_COD, PRO_EJE_COD, PRO_DIA_COD, PRO_ASI_NUMASI, 
PRO_COD)
;


CREATE UNIQUE INDEX RCMP_AGE_PK ON TCMP_AGE
(AGE_COD)
;


CREATE UNIQUE INDEX RCMP_AMO08_PK ON TCMP_AMORTIZACIONS_PLA2008
(AMO08_CEC_COD, AMO08_EMP_COD, AMO08_TIP, AMO08_CT5_COD)
;


CREATE UNIQUE INDEX RCMP_APU08_PK ON TCMP_APUNTS_PLA2008
(APU08_CEC_COD, APU08_EMP_COD, APU08_EJE_COD, APU08_DIA_COD, APU08_CONTRA, 
APU08_ASI_NUMASI, APU08_NUMAPU)
;


CREATE UNIQUE INDEX RCMP_BSSTMP_PK ON TCMP_TMP_BSSBMP
(BSS_CEC_COD, BSS_COD, BSS_ORD)
;


CREATE UNIQUE INDEX RCMP_CAB_PK ON TCMP_N43_CABCTA
(CAB_CEC_COD, CAB_EMP_COD, CAB_SEQ)
;


CREATE UNIQUE INDEX RCMP_CEC_PK ON TCMP_CLICECO
(CEC_COD)
;


CREATE UNIQUE INDEX RCMP_CLV_PK ON TCMP_CLV
(CLV_CEC_COD, CLV_COD)
;


CREATE UNIQUE INDEX RCMP_CNA_PK ON TCMP_CNAES
(CNA_CEC_COD, CNA_COD)
;


CREATE UNIQUE INDEX RCMP_CONCOM_PK ON TCMP_CONCOM
(CCO_CEC_COD, CCO_COD)
;


CREATE UNIQUE INDEX RCMP_CON_PK ON TCMP_CONCEPTES
(CON_CEC_COD, CON_COD)
;


CREATE UNIQUE INDEX RCMP_CTV_PK ON TCMP_CT4CLV
(CTV_CEC_COD, CTV_CT4_COD, CTV_CLV_COD)
;


CREATE UNIQUE INDEX RCMP_DCB_PK ON TCMP_DEPCTA08_BAL
(DCB_CEC_COD, DCB_FIS_COD, DCB_EXC, DCB_COD, DCB_TIP, 
DCB_SEQ)
;


CREATE UNIQUE INDEX RCMP_DCOTRS_PK ON TCMP_DEPPROCOM_TRASPAS
(DCO_USU, DCO_CEC_COD, DCO_EMP_COD, DCO_EJE_COD, DCO_DIA_COD, 
DCO_ASI_NUMASIAUX, DCO_APU_NUMAPUAUX, DCO_SEQ)
;


CREATE UNIQUE INDEX RCMP_DCT002_PK ON TCMP_DEPCTA002
(DCT_CEC_COD, DCT_FIS_COD, DCT_EXC)
;


CREATE UNIQUE INDEX RCMP_DCT003_PK ON TCMP_DEPCTA003
(DCT_CEC_COD, DCT_FIS_COD, DCT_EXC)
;


CREATE UNIQUE INDEX RCMP_DEL_PK ON TCMP_DELETE
(DEL_CEC_COD, DEL_SEQ)
;


CREATE UNIQUE INDEX RCMP_DIN_PK ON TCMP_DINAMICS
(DIN_COD)
;


CREATE UNIQUE INDEX RCMP_DMO_PK ON TCMP_DMO
(DMO_CEC_COD, DMO_MDL, DMO_GRP, DMO_COD)
;


CREATE UNIQUE INDEX RCMP_DPG_PK ON TCMP_DPG
(DPG_CEC_COD, DPG_COD)
;


CREATE UNIQUE INDEX RCMP_EFC_PK ON TCMP_EFC
(EFC_CEC_COD, EFC_NUMREG, EFC_SEQ)
;


CREATE UNIQUE INDEX RCMP_ESI_PK ON TCMP_ESI
(ESI_CEC_COD, ESI_EMP_COD, ESI_SEQ)
;


CREATE UNIQUE INDEX RCMP_EST_PK ON TCMP_EST
(EST_CEC_COD, EST_COD)
;


CREATE UNIQUE INDEX RCMP_FCE_PK ON TCMP_FCE
(FCE_CEC_COD, FCE_NUMREG)
;


CREATE UNIQUE INDEX RCMP_FPA_PK ON TCMP_FPA
(FPA_CEC_COD, FPA_COD)
;


CREATE UNIQUE INDEX RCMP_GRP_PK ON TCMP_GRUPS
(GRP_CEC_COD, GRP_COD)
;


CREATE UNIQUE INDEX RCMP_HIS_PK ON TCMP_HISENDES
(HIS_CEC_COD, HIS_COD)
;


CREATE UNIQUE INDEX RCMP_HPR_PK ON TCMP_HPR
(HPR_CEC_COD, HPR_EMP_COD, HPR_COD)
;


CREATE UNIQUE INDEX RCMP_IAE_PK ON TCMP_IAES
(IAE_CEC_COD, IAE_EPIGRAFE)
;


CREATE UNIQUE INDEX RCMP_ICV_PK ON TCMP_ICV
(ICV_CEC_COD, ICV_COD)
;


CREATE UNIQUE INDEX RCMP_IMP_PK ON TCMP_IMPRESSIONS
(IMP_CEC_COD, IMP_COD)
;


CREATE UNIQUE INDEX RCMP_INB_PK ON TCMP_INFORMES_BMP
(INB_CEC_COD, INB_COD)
;


CREATE UNIQUE INDEX RCMP_INF_PK ON TCMP_INFORMES
(INF_CEC_COD, INF_COD)
;


CREATE UNIQUE INDEX RCMP_LDI_PK ON TCMP_LINIES_DINAMIC
(LDI_DIN_COD, LDI_NUM)
;


CREATE UNIQUE INDEX RCMP_LIB_PK ON TCMP_LINIES_INFORME_BMP
(LIB_CEC_COD, LIB_INB_COD, LIB_COD)
;


CREATE UNIQUE INDEX RCMP_LIM_PK ON TCMP_LINIES_IMPRESSIO
(LIM_CEC_COD, LIM_IMP_COD, LIM_NUM)
;


CREATE UNIQUE INDEX RCMP_LIN_PK ON TCMP_LINIES_INFORME
(LIN_INF_COD, LIN_CEC_COD, LIN_COD)
;


CREATE UNIQUE INDEX RCMP_M200DSG_PK ON TCMP_MOD200DSG
(M200DSG_CEC_COD, M200DSG_M201_NUM, M200DSG_COD, M200DSG_DMO_COD)
;


CREATE UNIQUE INDEX RCMP_M3471_PK ON TCMP_MOD347_R1
(M3471_CEC_COD, M3471_EMP_COD, M3471_EXC, M3471_SEQ)
;


CREATE UNIQUE INDEX RCMP_M3472_PK ON TCMP_MOD347_R2
(M3472_CEC_COD, M3472_EMP_COD, M3472_EXC, M3472_M3471_SEQ, M3472_COD)
;


CREATE UNIQUE INDEX RCMP_M347_PK ON TCMP_MOD347
(M347_CEC_COD, M347_EMP_COD, M347_EXC)
;


CREATE UNIQUE INDEX RCMP_MON_PK ON TCMP_MONEDES
(MON_CEC_COD, MON_COD)
;


CREATE UNIQUE INDEX RCMP_MOV_PK ON TCMP_N43_PPLMOV
(MOV_CEC_COD, MOV_EMP_COD, MOV_CAB_SEQ, MOV_SEQ)
;


CREATE UNIQUE INDEX RCMP_MULLERFAC_PK ON TCMP_MULLER_FAC
(EMPRESA, NUMSERIEFACTURAEMISOR, TIPOIMPOSITIVO)
;


CREATE UNIQUE INDEX RCMP_MULLERFPV_PK ON TCMP_MULLER_FPV
(EMPRESA, NIF, NUMSERIEFACTURAEMISOR, TIPOIMPOSITIVO)
;


CREATE UNIQUE INDEX RCMP_MULLERTIK_PK ON TCMP_MULLER_TIK
(EMPRESA, TIENDA, CAJA, FECHAFACTURA)
;


CREATE UNIQUE INDEX RCMP_OPB_PK ON TCMP_OPERACIONS_BMP
(OPB_CEC_COD, OPB_INB_COD, OPB_LIB_COD, OPB_COD)
;


CREATE UNIQUE INDEX RCMP_OPE_PK ON TCMP_OPERACIONS
(OPE_CEC_COD, OPE_INF_COD, OPE_LIN_COD, OPE_COD)
;


CREATE UNIQUE INDEX RCMP_OPHH_PK ON TCMP_347OPH_HIST
(OPH_CEC_COD, OPH_EMP_COD, OPH_CLASSE, OPH_CLIPRO, OPH_SEQ, 
OPH_EJE)
;


CREATE UNIQUE INDEX RCMP_PAI_PK ON TCMP_PAISOS
(PAI_CEC_COD, PAI_COD)
;


CREATE UNIQUE INDEX RCMP_PAR_PK ON TCMP_PARAMETRES
(PAR_CEC_COD, PAR_COD)
;


CREATE UNIQUE INDEX RCMP_PDA002_PK ON TCMP_PRESUDESGLOSES_ANUAL002
(PDA_CEC_COD, PDA_EMP_COD, PDA_HPR_COD, PDA_CT5_COD, PDA_PRE_ANY, 
PDA_SEQ)
;


CREATE UNIQUE INDEX RCMP_PDD_PK ON TCMP_PDD
(PDD_CEC_COD, PDD_PRO_COD, PDD_PRO_COD002)
;


CREATE UNIQUE INDEX RCMP_PNP_PK ON TCMP_DEPCTA08_PNP
(PNP_CEC_COD, PNP_FIS_COD, PNP_EXC, PNP_COD, PNP_TIP, 
PNP_SEQ)
;


CREATE UNIQUE INDEX RCMP_PRE002_PK ON TCMP_PRESUPOSTS002
(PRE_CEC_COD, PRE_EMP_COD, PRE_HPR_COD, PRE_CT5_COD, PRE_ANY, 
PRE_MES)
;


CREATE UNIQUE INDEX RCMP_PRO_PK ON TCMP_PROJECTES
(PRO_CEC_COD, PRO_COD)
;


CREATE UNIQUE INDEX RCMP_PRS_PK ON TCMP_PRESENTA
(PRS_CEC_COD, PRS_NIF)
;


CREATE UNIQUE INDEX RCMP_PRV_PK ON TCMP_PROVINCIES
(PRV_CEC_COD, PRV_COD)
;


CREATE UNIQUE INDEX RCMP_RFA_PK ON TCMP_RFA
(RFA_CEC_COD, RFA_EMP_COD, RFA_DIA_COD, RFA_NUMRGT, RFA_ANY)
;


CREATE UNIQUE INDEX RCMP_SAL07_PK ON TCMP_SALDOS07_PLA2008
(SAL07_CEC_COD, SAL07_EMP_COD, SAL07_CT5_COD, SAL07_DIA_COD, SAL07_CT5_CODDTI)
;


CREATE UNIQUE INDEX RCMP_SAL08_PK ON TCMP_SALDOS_PLA2008
(SAL08_CEC_COD, SAL08_EMP_COD, SAL08_CT5_COD, SAL08_DIA_COD, SAL08_CT5_CODDTI)
;


CREATE UNIQUE INDEX RCMP_SLV001_PK ON TCMP_SELVEN001
(SLV_CEC_COD, SLV_EMP_COD, SLV_SEQ)
;


CREATE UNIQUE INDEX RCMP_SLV002_PK ON TCMP_SELVEN002
(SLV002_CEC_COD, SLV002_EMP_COD, SLV002_SLV_SEQ, SLV002_DIA_COD, SLV002_VEN_SEQ)
;


CREATE UNIQUE INDEX RCMP_TAN_PK ON TCMP_LSTTAN
(TAN_NUM)
;


CREATE UNIQUE INDEX RCMP_TAS_PK ON TCMP_TIPUSASIENTOS
(TAS_CEC_COD, TAS_COD)
;


CREATE UNIQUE INDEX RCMP_TCO_PK ON TCMP_TCO
(TCO_CEC_COD, TCO_COD)
;


CREATE UNIQUE INDEX RCMP_TMP_BSS_PK ON TCMP_TMP_BSS
(BSS_NUMFIT, BSS_CEC_COD, BSS_EMP_COD, BSS_EJE_COD, BSS_CT5_COD)
;


CREATE UNIQUE INDEX RCMP_TOC_PK ON TCMP_TOC
(TOC_CEC_COD, TOC_COD)
;


CREATE UNIQUE INDEX RCMP_TRS_PK ON TCMP_TRASPAS
(TRS_USU, TRS_CEC_COD, TRS_EMP_COD, TRS_EJE_COD, TRS_DIA_COD, 
TRS_ASIAUX, TRS_APUAUX)
;


CREATE UNIQUE INDEX RCMP_TVE_PK ON TCMP_TVE
(TVE_CEC_COD, TVE_COD)
;


CREATE UNIQUE INDEX RCMP_UBI_PK ON TCMP_UBI
(UBI_CEC_COD, UBI_COD)
;


CREATE INDEX RCMP_UGR_GRP_FK_I ON TCMP_USUARISGRUPS
(UGR_CEC_COD, UGR_GRP_COD)
;


CREATE UNIQUE INDEX RCMP_UGR_PK ON TCMP_USUARISGRUPS
(UGR_CEC_COD, UGR_GRP_COD, UGR_USU_COD)
;


CREATE INDEX RCMP_UGR_USU_FK_I ON TCMP_USUARISGRUPS
(UGR_USU_COD)
;


CREATE UNIQUE INDEX RCMP_UHTRS_PK ON TCMP_UH_TRASPASSOS
(TRS_CEC_COD, TRS_EMP_COD, TRS_EJE_COD, TRS_DIA_COD, TRS_ASI_NUMASI, 
TRS_APU_NUMAPU)
;


CREATE UNIQUE INDEX RCMP_VEN08_PK ON TCMP_VENCIMENTS_PLA2008
(VEN08_CEC_COD, VEN08_EMP_COD, VEN08_DIA_COD, VEN08_SEQ, VEN08_DTI)
;


CREATE UNIQUE INDEX RCMP_VMO_PK ON TCMP_VMO
(VMO_CEC_COD, VMO_FIS_COD, VMO_EXC, VMO_PRD, VMO_MDL, 
VMO_GRP, VMO_COD)
;


CREATE UNIQUE INDEX RLVR_CAM_PK ON TLVR_CAMPOS
(CAM_NUM)
;


CREATE UNIQUE INDEX RLVR_DEC_PK ON TLVR_DECLAR
(DEC_NUM)
;


CREATE INDEX X_COMPTABILITAT_FORM_HELP_1 ON COMPTABILITAT_FORM_HELP
(HLP_INDEX, HLP_TYPE, HLP_APPLN, HLP_SEQ)
;


CREATE INDEX X_COMPTABILITAT_REF_CODES_1 ON COMPTABILITAT_REF_CODES
(RV_DOMAIN, RV_LOW_VALUE)
;



CREATE OR REPLACE FORCE VIEW VCMP_N43_PPLMOV
AS 
select MOV_CEC_COD, MOV_EMP_COD, MOV_CAB_SEQ, MOV_SEQ, MOV_TIPRGT, MOV_OFIORI, MOV_datOPE, MOV_datVAL, MOV_CNC,
       MOV_CNCPOP, MOV_DEBHAB, MOV_IMP, MOV_NUMDOC, MOV_REF002, MOV_REF001 /*, MOV_EJE_COD, MOV_DIA_COD,
	   MOV_ASI_NUMASI, MOV_APU_NUMAPU*/,
	   decode(mov_debhab, '1', 0, mov_imp) as mov_deb, decode(mov_debhab, '1', mov_imp, 0) as mov_hab
  from TCMP_N43_PPLMOV;


CREATE OR REPLACE FORCE VIEW VCMP_PRESTIGE_FACPRO
AS 
select FECHA, IDFACTURA, TOTALFACTURA, PROVEEDOR, CIF,
NUMERO, CODIGOERP, CODIGOPRESTIGE, PROCESADO,
FECHATRASPASO, FECHACONTA, ASIENTO
from ct_st_facturas--@prestige;


CREATE OR REPLACE FORCE VIEW VCMP_SALDOS07_PLA2008
AS 
select sal07_cec_cod, sal07_emp_cod, sal07_dia_cod,
sal07_ct5_cod, sal07_ct5_coddti,
case
 when sal07_fin<0 then abs(sal07_fin)
 else 0
end as sal07_deb,
case
 when sal07_fin>0 then sal07_fin
 else 0
end as sal07_hab,
sal07_ct5des
from tcmp_saldos07_pla2008;


CREATE OR REPLACE FORCE VIEW VCMP_TMP_BSSBMP
AS 
select '1' as bss_sec, bss_cec_cod, bss_cod, bss_ord, Bss_Des001 as bss_des, /*Bss_Lin001, Bss_Tip001, Bss_Dim001,*/ Bss_Sal001 as bss_sal /*, Bss_Salfin001*/
from tcmp_tmp_bssbmp
where /*bss_cod = :p_bss_cod and*/
(Bss_des001 is not null /*or bss_lin001='S'*/)
union all
select '2' as bss_sec, bss_cec_cod, bss_cod, bss_ord, Bss_Des002 as bss_des, /*Bss_Lin002, Bss_Tip002, Bss_Dim002,*/ Bss_Sal002 as bss_sal /*, Bss_Salfin002*/
from tcmp_tmp_bssbmp
where /*bss_cod = :p_bss_cod and*/
(Bss_des002 is not null /*or bss_lin002='S'*/)
order by bss_sec, bss_ord;


CREATE TABLE TCMP_347ARRE_HIST
(
  ARR_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ARR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  ARR_CLASSE   VARCHAR2(1 BYTE)                     NULL,
  ARR_CLIPRO   VARCHAR2(10 BYTE)                    NULL,
  ARR_OPH_EJE  VARCHAR2(4 BYTE)                     NULL,
  ARR_COD      VARCHAR2(8 BYTE)                     NULL,
  ARR_IMPORT   NUMBER(15,2)                         NULL,
  ARR_NIF      VARCHAR2(12 BYTE)                    NULL,
  ARR_NOM      VARCHAR2(40 BYTE)                    NULL,
  ARR_PRVPAI   VARCHAR2(5 BYTE)                     NULL,
  ARR_POB      VARCHAR2(30 BYTE)                    NULL,
  ARR_SG       VARCHAR2(5 BYTE)                     NULL,
  ARR_DOM      VARCHAR2(50 BYTE)                    NULL,
  ARR_NUM      NUMBER(5)                            NULL,
  ARR_ESC      VARCHAR2(3 BYTE)                     NULL,
  ARR_PIS      VARCHAR2(3 BYTE)                     NULL,
  ARR_PORTA    VARCHAR2(3 BYTE)                     NULL,
  ARR_CAD      VARCHAR2(25 BYTE)                    NULL,
  ARR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ARR_DATCRE   DATE                                 NULL,
  ARR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  ARR_DATMOD   DATE                                 NULL,
  ARR_SITINM   VARCHAR2(1 BYTE)                     NULL,
  ARR_TIPNUM   VARCHAR2(3 BYTE)                     NULL,
  ARR_CALNUM   VARCHAR2(3 BYTE)                     NULL,
  ARR_BLC      VARCHAR2(3 BYTE)                     NULL,
  ARR_POR      VARCHAR2(3 BYTE)                     NULL,
  ARR_CPL      VARCHAR2(40 BYTE)                    NULL,
  ARR_MUN      VARCHAR2(30 BYTE)                    NULL,
  ARR_CODMUN   VARCHAR2(5 BYTE)                     NULL,
  ARR_CPO      VARCHAR2(5 BYTE)                     NULL,
  ARR_OPH_SEQ  NUMBER(3)                            NULL
)
;


CREATE TABLE TCMP_ACV
(
  ACV_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ACV_ICV_COD  VARCHAR2(4 BYTE)                     NULL,
  ACV_COD      VARCHAR2(4 BYTE)                     NULL,
  ACV_DATCRE   DATE                                 NULL,
  ACV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ACV_DES      VARCHAR2(128 BYTE)                   NULL,
  ACV_ACV_COD  VARCHAR2(4 BYTE)                     NULL,
  ACV_ORD      NUMBER(3)                            NULL,
  ACV_DATMOD   DATE                                 NULL,
  ACV_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_APJ
(
  APJ_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  APJ_COD      VARCHAR2(6 BYTE)                     NULL,
  APJ_NOM      VARCHAR2(30 BYTE)                    NULL,
  APJ_DATCRE   DATE                                 NULL,
  APJ_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  APJ_DATMOD   DATE                                 NULL,
  APJ_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_ASP
(
  ASP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ASP_COD      VARCHAR2(6 BYTE)                     NULL,
  ASP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ASP_DATCRE   DATE                                 NULL,
  ASP_TAS_COD  VARCHAR2(2 BYTE)                     NULL,
  ASP_DAT      DATE                                 NULL,
  ASP_OBS      VARCHAR2(150 BYTE)                   NULL,
  ASP_PRC00A   VARCHAR2(30 BYTE)                    NULL,
  ASP_PRC00B   VARCHAR2(30 BYTE)                    NULL,
  ASP_PRC00C   VARCHAR2(30 BYTE)                    NULL,
  ASP_DES      VARCHAR2(1000 BYTE)                  NULL,
  ASP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  ASP_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_CAMPS
(
  CAM_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CAM_IMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CAM_LIM_NUM  NUMBER(10)                           NULL,
  CAM_NUM      NUMBER(10)                           NULL,
  CAM_COD      VARCHAR2(15 BYTE)                    NULL,
  CAM_POS      NUMBER(10)                           NULL,
  CAM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CAM_DATCRE   DATE                                 NULL,
  CAM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CAM_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_CAV
(
  CAV_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  CAV_ICV_COD     VARCHAR2(4 BYTE)                  NULL,
  CAV_ACV_COD     VARCHAR2(4 BYTE)                  NULL,
  CAV_SEQ         NUMBER(3)                         NULL,
  CAV_OPE         VARCHAR2(1 BYTE)                  NULL,
  CAV_DATCRE      DATE                              NULL,
  CAV_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  CAV_CLV_COD     VARCHAR2(4 BYTE)                  NULL,
  CAV_ACV_COD002  VARCHAR2(4 BYTE)                  NULL,
  CAV_DATMOD      DATE                              NULL,
  CAV_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  CAV_CTE         VARCHAR2(10 BYTE)                 NULL,
  CAV_SAL         VARCHAR2(1 BYTE)                  NULL,
  CAV_MAN         VARCHAR2(1 BYTE)                  NULL
)
;


CREATE TABLE TCMP_CLASEIVAS
(
  CIV_CEC_COD              VARCHAR2(4 BYTE)         NULL,
  CIV_COD                  VARCHAR2(2 BYTE)         NULL,
  CIV_DES                  VARCHAR2(30 BYTE)        NULL,
  CIV_USUCRE               VARCHAR2(30 BYTE)        NULL,
  CIV_DATCRE               DATE                     NULL,
  CIV_USUMOD               VARCHAR2(30 BYTE)        NULL,
  CIV_DATMOD               DATE                     NULL,
  CIV_SIT_CODCLAEXD        VARCHAR2(2 BYTE)         NULL,
  CIV_SIT_CODCLAREB        VARCHAR2(2 BYTE)         NULL,
  CIV_SIT_CODCLACRICXAREB  VARCHAR2(2 BYTE)         NULL
)
;


CREATE TABLE TCMP_DPP
(
  DPP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DPP_ASP_COD  VARCHAR2(6 BYTE)                     NULL,
  DPP_SEQ      NUMBER(3)                            NULL,
  DPP_DATCRE   DATE                                 NULL,
  DPP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DPP_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  DPP_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  DPP_PTEDEP   NUMBER(5,2)                          NULL,
  DPP_PTEPRO   NUMBER(5,2)                          NULL,
  DPP_DATMOD   DATE                                 NULL,
  DPP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DPP_APP_ORD  NUMBER(10)                           NULL
)
;


CREATE TABLE TCMP_HVD
(
  HVD_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  HVD_MON_COD  VARCHAR2(4 BYTE)                     NULL,
  HVD_DIA      DATE                                 NULL,
  HVD_VALCAN   NUMBER(15,8)                         NULL,
  HVD_DATCRE   DATE                                 NULL,
  HVD_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  HVD_DATMOD   DATE                                 NULL,
  HVD_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_IVAS
(
  IVA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  IVA_COD      VARCHAR2(4 BYTE)                     NULL,
  IVA_PTEIVA   NUMBER(5,2)                      DEFAULT 0                         NULL,
  IVA_PTEREQ   NUMBER(5,2)                      DEFAULT 0                         NULL,
  IVA_CIV_COD  VARCHAR2(2 BYTE)                     NULL,
  IVA_CTEIVA   VARCHAR2(1 BYTE)                     NULL,
  IVA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  IVA_DATCRE   DATE                                 NULL,
  IVA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  IVA_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_MODULSIRPF
(
  MIR_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  MIR_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  MIR_SEQ           NUMBER(10)                      NULL,
  MIR_MON_COD       VARCHAR2(1 BYTE)                NULL,
  MIR_CLAVE         VARCHAR2(1 BYTE)                NULL,
  MIR_DES           VARCHAR2(50 BYTE)               NULL,
  MIR_IMP           NUMBER(15,3)                DEFAULT 0                         NULL,
  MIR_VALIMP        NUMBER(15,3)                DEFAULT 0                         NULL,
  MIR_USUCRE        VARCHAR2(30 BYTE)               NULL,
  MIR_DATCRE        DATE                            NULL,
  MIR_USUMOD        VARCHAR2(30 BYTE)               NULL,
  MIR_DATMOD        DATE                            NULL,
  MIR_PTEINC        NUMBER(5,2)                     NULL
)
;


CREATE TABLE TCMP_MODULSIVA
(
  MIV_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  MIV_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  MIV_SEQ           NUMBER(10)                      NULL,
  MIV_MON_COD       VARCHAR2(1 BYTE)                NULL,
  MIV_DES           VARCHAR2(50 BYTE)               NULL,
  MIV_IMP           NUMBER(15,3)                DEFAULT 0                         NULL,
  MIV_VALIMP        NUMBER(15,3)                DEFAULT 0                         NULL,
  MIV_USUCRE        VARCHAR2(30 BYTE)               NULL,
  MIV_DATCRE        DATE                            NULL,
  MIV_USUMOD        VARCHAR2(30 BYTE)               NULL,
  MIV_DATMOD        DATE                            NULL
)
;


CREATE TABLE TCMP_N43_CPLCON
(
  CON_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CON_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CON_CAB_SEQ  NUMBER(18)                           NULL,
  CON_SEQ      NUMBER(4)                            NULL,
  CON_TIPRGT   NUMBER(2)                            NULL,
  CON_CODDAD   NUMBER(2)                            NULL,
  CON_CNC001   VARCHAR2(38 BYTE)                    NULL,
  CON_CNC002   VARCHAR2(38 BYTE)                    NULL,
  CON_MOV_SEQ  NUMBER(18)                       DEFAULT 0                         NULL,
  CAB_MDLINF   NUMBER(1)                            NULL
)
;


CREATE TABLE TCMP_PJA
(
  PJA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PJA_APJ_COD  VARCHAR2(6 BYTE)                     NULL,
  PJA_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  PJA_DATCRE   DATE                                 NULL,
  PJA_USUCRE   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_POBLACIONS
(
  POB_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  POB_COD      VARCHAR2(8 BYTE)                     NULL,
  POB_NOM      VARCHAR2(30 BYTE)                    NULL,
  POB_NOMMUN   VARCHAR2(30 BYTE)                    NULL,
  POB_CODMUN   NUMBER(3)                            NULL,
  POB_PRV_COD  VARCHAR2(3 BYTE)                     NULL,
  POB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  POB_DATCRE   DATE                                 NULL,
  POB_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  POB_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_PRESUDESGLOSES002
(
  PDE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_HPR_COD  VARCHAR2(6 BYTE)                     NULL,
  PDE_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  PDE_PRE_ANY  NUMBER(4)                            NULL,
  PDE_PRE_MES  NUMBER(2)                            NULL,
  PDE_SEQ      NUMBER(10)                           NULL,
  PDE_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  PDE_PTE      NUMBER(5,2)                      DEFAULT 0                         NULL,
  PDE_IMPPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PDE_VALPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PDE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PDE_DATCRE   DATE                                 NULL
)
;


CREATE TABLE TLVR_DATOS
(
  DAT_DEC_NUM  NUMBER(4)                            NULL,
  DAT_CAM_NUM  NUMBER(4)                            NULL,
  DAT_VAL      VARCHAR2(200 BYTE)                   NULL,
  DAT_SEQ      NUMBER                               NULL
)
;


CREATE INDEX ICMP_ASP_CEC_FK ON TCMP_ASP
(ASP_CEC_COD)
;


CREATE INDEX ICMP_ASP_TAS_FK ON TCMP_ASP
(ASP_TAS_COD, ASP_CEC_COD)
;


CREATE INDEX ICMP_CAM_LIM_FK ON TCMP_CAMPS
(CAM_CEC_COD, CAM_IMP_COD, CAM_LIM_NUM)
;


CREATE INDEX ICMP_CIV_FK_I ON TCMP_CLASEIVAS
(CIV_CEC_COD)
;


CREATE INDEX ICMP_CON_CAB_FK ON TCMP_N43_CPLCON
(CON_CEC_COD, CON_EMP_COD, CON_CAB_SEQ)
;


CREATE INDEX ICMP_IVA_CEC_FK_I ON TCMP_IVAS
(IVA_CEC_COD)
;


CREATE INDEX ICMP_IVA_CIV_FK_I ON TCMP_IVAS
(IVA_CIV_COD)
;


CREATE INDEX ICMP_MIR_IAE_FK_I ON TCMP_MODULSIRPF
(MIR_CEC_COD, MIR_IAE_EPIGRAFE)
;


CREATE INDEX ICMP_MIR_MON_FK_I ON TCMP_MODULSIRPF
(MIR_CEC_COD, MIR_MON_COD)
;


CREATE INDEX ICMP_MIV_IAE_FK_I ON TCMP_MODULSIVA
(MIV_CEC_COD, MIV_IAE_EPIGRAFE)
;


CREATE INDEX ICMP_MIV_MON_FK_I ON TCMP_MODULSIVA
(MIV_CEC_COD, MIV_MON_COD)
;


CREATE INDEX ICMP_POB_CEC_FK_I ON TCMP_POBLACIONS
(POB_CEC_COD)
;


CREATE INDEX ICMP_POB_PRV_FK_I ON TCMP_POBLACIONS
(POB_CEC_COD, POB_PRV_COD)
;


CREATE UNIQUE INDEX RCMP_ACV_PK ON TCMP_ACV
(ACV_CEC_COD, ACV_ICV_COD, ACV_COD)
;


CREATE UNIQUE INDEX RCMP_APJ_PK ON TCMP_APJ
(APJ_CEC_COD, APJ_COD)
;


CREATE UNIQUE INDEX RCMP_ARRH_PK ON TCMP_347ARRE_HIST
(ARR_CEC_COD, ARR_EMP_COD, ARR_CLASSE, ARR_CLIPRO, ARR_OPH_SEQ, 
ARR_OPH_EJE, ARR_COD)
;


CREATE UNIQUE INDEX RCMP_ASP_PK ON TCMP_ASP
(ASP_COD, ASP_CEC_COD)
;


CREATE UNIQUE INDEX RCMP_CAM_PK ON TCMP_CAMPS
(CAM_CEC_COD, CAM_IMP_COD, CAM_LIM_NUM, CAM_NUM)
;


CREATE UNIQUE INDEX RCMP_CAV_PK ON TCMP_CAV
(CAV_CEC_COD, CAV_ICV_COD, CAV_ACV_COD, CAV_SEQ)
;


CREATE UNIQUE INDEX RCMP_CAV_UK ON TCMP_CAV
(CAV_CEC_COD, CAV_ICV_COD, CAV_ACV_COD, CAV_CLV_COD, CAV_ACV_COD002, 
CAV_CTE)
;


CREATE UNIQUE INDEX RCMP_CIV_PK ON TCMP_CLASEIVAS
(CIV_CEC_COD, CIV_COD)
;


CREATE UNIQUE INDEX RCMP_DPP_PK ON TCMP_DPP
(DPP_CEC_COD, DPP_ASP_COD, DPP_SEQ)
;


CREATE UNIQUE INDEX RCMP_HVD_PK ON TCMP_HVD
(HVD_CEC_COD, HVD_MON_COD, HVD_DIA)
;


CREATE UNIQUE INDEX RCMP_IVA_PK ON TCMP_IVAS
(IVA_CEC_COD, IVA_COD)
;


CREATE UNIQUE INDEX RCMP_MIR_PK ON TCMP_MODULSIRPF
(MIR_CEC_COD, MIR_IAE_EPIGRAFE, MIR_SEQ)
;


CREATE UNIQUE INDEX RCMP_MIV_PK ON TCMP_MODULSIVA
(MIV_CEC_COD, MIV_IAE_EPIGRAFE, MIV_SEQ)
;


CREATE UNIQUE INDEX RCMP_N43CON_PK ON TCMP_N43_CPLCON
(CON_CEC_COD, CON_EMP_COD, CON_CAB_SEQ, CON_MOV_SEQ, CON_SEQ)
;


CREATE UNIQUE INDEX RCMP_PDE002_PK ON TCMP_PRESUDESGLOSES002
(PDE_CEC_COD, PDE_EMP_COD, PDE_HPR_COD, PDE_CT5_COD, PDE_PRE_ANY, 
PDE_PRE_MES, PDE_SEQ)
;


CREATE UNIQUE INDEX RCMP_PJA_PK ON TCMP_PJA
(PJA_CEC_COD, PJA_APJ_COD, PJA_PRO_COD)
;


CREATE UNIQUE INDEX RCMP_POB_PK ON TCMP_POBLACIONS
(POB_CEC_COD, POB_COD)
;


CREATE UNIQUE INDEX RLVR_DAT_PK ON TLVR_DATOS
(DAT_DEC_NUM, DAT_CAM_NUM, DAT_SEQ)
;


CREATE TABLE TCMP_APP
(
  APP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  APP_ASP_COD  VARCHAR2(6 BYTE)                     NULL,
  APP_ORD      NUMBER(10)                           NULL,
  APP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  APP_VTO      VARCHAR2(1 BYTE)                     NULL,
  APP_DATCRE   DATE                                 NULL,
  APP_CTE      VARCHAR2(10 BYTE)                    NULL,
  APP_IVA_COD  VARCHAR2(4 BYTE)                     NULL,
  APP_MON_COD  VARCHAR2(1 BYTE)                     NULL,
  APP_CIV_COD  VARCHAR2(2 BYTE)                     NULL,
  APP_IMPDEB   NUMBER(15,3)                         NULL,
  APP_IMPHAB   NUMBER(15,3)                         NULL,
  APP_BASIVA   NUMBER(15,3)                         NULL,
  APP_CNC      VARCHAR2(255 BYTE)                   NULL,
  APP_CPA      VARCHAR2(10 BYTE)                    NULL,
  APP_NUMDOC   VARCHAR2(8 BYTE)                     NULL,
  APP_DATFAC   DATE                                 NULL,
  APP_NUMFAC   VARCHAR2(8 BYTE)                     NULL,
  APP_DATVAL   DATE                                 NULL,
  APP_PRC00A   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00B   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00C   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00D   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00E   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00F   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00G   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00H   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00I   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00J   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00K   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00L   VARCHAR2(500 BYTE)                   NULL,
  APP_PRC00M   VARCHAR2(500 BYTE)                   NULL,
  APP_PRCAPU   VARCHAR2(1 BYTE)                     NULL,
  APP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  APP_DATMOD   DATE                                 NULL,
  APP_NUM      NUMBER                               NULL
)
;


CREATE TABLE TCMP_CTESREGIVA
(
  CRI_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  CRI_IVA_COD        VARCHAR2(4 BYTE)               NULL,
  CRI_CIV_COD        VARCHAR2(2 BYTE)               NULL,
  CRI_CTAIVASOP      VARCHAR2(10 BYTE)              NULL,
  CRI_CTAIVAREP      VARCHAR2(10 BYTE)              NULL,
  CRI_USUCRE         VARCHAR2(30 BYTE)              NULL,
  CRI_DATCRE         DATE                           NULL,
  CRI_USUMOD         VARCHAR2(30 BYTE)              NULL,
  CRI_DATMOD         DATE                           NULL,
  CRI_SIITIP         VARCHAR2(1 BYTE)               NULL,
  CRI_SIIPRSSRV      VARCHAR2(1 BYTE)               NULL,
  CRI_SIIENTBIN      VARCHAR2(1 BYTE)               NULL,
  CRI_SIISUJNOTEXE   VARCHAR2(1 BYTE)               NULL,
  CRI_SIT_CODDSGTIP  VARCHAR2(2 BYTE)               NULL,
  CRI_SIT_CODEXE     VARCHAR2(2 BYTE)               NULL,
  CRI_SIISUJEXE      VARCHAR2(1 BYTE)               NULL,
  CRI_SIINOTSUJ      VARCHAR2(1 BYTE)               NULL,
  CRI_SIT_CODCLAEXD  VARCHAR2(2 BYTE)               NULL,
  CRI_SIT_CODCLAREB  VARCHAR2(2 BYTE)               NULL,
  CRI_SIIIMPSUJ      VARCHAR2(1 BYTE)               NULL,
  CRI_SIITIPREB      VARCHAR2(1 BYTE)               NULL,
  CRI_SIIREGAGRREB   VARCHAR2(1 BYTE)               NULL
)
;


CREATE TABLE TCMP_FBA
(
  FBA_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  FBA_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  FBA_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  FBA_RFA_NUMRGT  NUMBER(10)                        NULL,
  FBA_RFA_ANY     NUMBER(4)                         NULL,
  FBA_IVA_COD     VARCHAR2(4 BYTE)                  NULL,
  FBA_BAS         NUMBER(15,2)                      NULL,
  FBA_IVA         NUMBER(15,2)                      NULL,
  FBA_DATCRE      DATE                              NULL,
  FBA_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  FBA_DATMOD      DATE                              NULL,
  FBA_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TCMP_MIR_ICP
(
  ICP_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  ICP_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  ICP_MIR_SEQ       NUMBER(10)                      NULL,
  ICP_NUM           NUMBER(3)                       NULL,
  ICP_PTE           NUMBER(5,2)                     NULL,
  ICP_DATCRE        DATE                            NULL,
  ICP_USUCRE        VARCHAR2(30 BYTE)               NULL,
  ICP_DATMOD        DATE                            NULL,
  ICP_USUMOD        VARCHAR2(30 BYTE)               NULL
)
;


CREATE TABLE TCMP_NIFS
(
  NIF_CEC_COD           VARCHAR2(4 BYTE)            NULL,
  NIF_NIF               VARCHAR2(12 BYTE)           NULL,
  NIF_NOMFIS            VARCHAR2(40 BYTE)           NULL,
  NIF_TADFIS            VARCHAR2(2 BYTE)            NULL,
  NIF_DOMFIS            VARCHAR2(30 BYTE)           NULL,
  NIF_NUMFIS            VARCHAR2(5 BYTE)            NULL,
  NIF_ESCFIS            VARCHAR2(2 BYTE)            NULL,
  NIF_PISFIS            VARCHAR2(2 BYTE)            NULL,
  NIF_PTAFIS            VARCHAR2(2 BYTE)            NULL,
  NIF_POB_COD           VARCHAR2(8 BYTE)            NULL,
  NIF_TEL               VARCHAR2(30 BYTE)           NULL,
  NIF_FAX               VARCHAR2(30 BYTE)           NULL,
  NIF_EML               VARCHAR2(60 BYTE)           NULL,
  NIF_CON               VARCHAR2(100 BYTE)          NULL,
  NIF_USUCRE            VARCHAR2(30 BYTE)           NULL,
  NIF_DATCRE            DATE                        NULL,
  NIF_USUMOD            VARCHAR2(30 BYTE)           NULL,
  NIF_DATMOD            DATE                        NULL,
  NIF_NIFEXT            VARCHAR2(24 BYTE)           NULL,
  NIF_SIT_CODTIPIDFPAI  VARCHAR2(2 BYTE)            NULL,
  NIF_RGTAEA            VARCHAR2(1 BYTE)            NULL
)
;


CREATE INDEX ICMP_APP_ASP_FK ON TCMP_APP
(APP_ASP_COD, APP_CEC_COD)
;


CREATE INDEX ICMP_APP_CIV_FK ON TCMP_APP
(APP_CEC_COD, APP_CIV_COD)
;


CREATE INDEX ICMP_APP_IVA_FK ON TCMP_APP
(APP_IVA_COD, APP_CEC_COD)
;


CREATE INDEX ICMP_APP_MON_FK ON TCMP_APP
(APP_MON_COD, APP_CEC_COD)
;


CREATE INDEX ICMP_CRI_CIV_FK_I ON TCMP_CTESREGIVA
(CRI_CEC_COD, CRI_CIV_COD)
;


CREATE INDEX ICMP_CRI_IVA_FK_I ON TCMP_CTESREGIVA
(CRI_CEC_COD, CRI_IVA_COD)
;


CREATE INDEX ICMP_NIF_CEC_FK_I ON TCMP_NIFS
(NIF_CEC_COD)
;


CREATE INDEX ICMP_NIF_NOM ON TCMP_NIFS
(NIF_NOMFIS, NIF_CEC_COD)
;


CREATE INDEX ICMP_NIF_POB_FK_I ON TCMP_NIFS
(NIF_POB_COD)
;


CREATE UNIQUE INDEX RCMP_APP_PK ON TCMP_APP
(APP_ORD, APP_ASP_COD, APP_CEC_COD)
;


CREATE UNIQUE INDEX RCMP_CRI_PK ON TCMP_CTESREGIVA
(CRI_CEC_COD, CRI_IVA_COD, CRI_CIV_COD)
;


CREATE UNIQUE INDEX RCMP_FBA_PK ON TCMP_FBA
(FBA_CEC_COD, FBA_DIA_COD, FBA_EMP_COD, FBA_RFA_NUMRGT, FBA_RFA_ANY, 
FBA_IVA_COD)
;


CREATE INDEX RCMP_ICP_MIR_FK_I ON TCMP_MIR_ICP
(ICP_CEC_COD, ICP_IAE_EPIGRAFE, ICP_MIR_SEQ)
;


CREATE UNIQUE INDEX RCMP_ICP_PK ON TCMP_MIR_ICP
(ICP_CEC_COD, ICP_IAE_EPIGRAFE, ICP_MIR_SEQ, ICP_NUM)
;


CREATE UNIQUE INDEX RCMP_NIF_PK ON TCMP_NIFS
(NIF_CEC_COD, NIF_NIF)
;


CREATE TABLE TCMP_EMPRESAFIS
(
  FIS_CEC_COD         VARCHAR2(4 BYTE)              NULL,
  FIS_COD             VARCHAR2(4 BYTE)              NULL,
  FIS_NIF_NIF         VARCHAR2(12 BYTE)             NULL,
  FIS_TEL             VARCHAR2(30 BYTE)             NULL,
  FIS_FAX             VARCHAR2(30 BYTE)             NULL,
  FIS_EML             VARCHAR2(60 BYTE)             NULL,
  FIS_CON             VARCHAR2(100 BYTE)            NULL,
  FIS_HIS_COD         NUMBER(5)                     NULL,
  FIS_NIF_NIFRPR      VARCHAR2(12 BYTE)             NULL,
  FIS_CARRPR          VARCHAR2(30 BYTE)             NULL,
  FIS_ACCIONS         NUMBER(15)                DEFAULT 0                         NULL,
  FIS_NOMINAL         NUMBER(18,6)              DEFAULT 0                         NULL,
  FIS_CAPITAL         NUMBER(15,3)              DEFAULT 0                         NULL,
  FIS_CNA_COD         VARCHAR2(4 BYTE)              NULL,
  FIS_PRIGRA          NUMBER(5,2)               DEFAULT 0                         NULL,
  FIS_SEGGRA          NUMBER(5,2)               DEFAULT 0                         NULL,
  FIS_ENTTRA          VARCHAR2(1 BYTE)              NULL,
  FIS_REGFIS          VARCHAR2(1 BYTE)              NULL,
  FIS_PAREXE          VARCHAR2(1 BYTE)              NULL,
  FIS_INVMOB          VARCHAR2(1 BYTE)              NULL,
  FIS_INVINMOB1       VARCHAR2(1 BYTE)              NULL,
  FIS_INVINMOB7       VARCHAR2(1 BYTE)              NULL,
  FIS_REDDIM          VARCHAR2(1 BYTE)              NULL,
  FIS_TENVALEST       VARCHAR2(1 BYTE)              NULL,
  FIS_UTEESP          VARCHAR2(1 BYTE)              NULL,
  FIS_UTEEUR          VARCHAR2(1 BYTE)              NULL,
  FIS_ZEC             VARCHAR2(1 BYTE)              NULL,
  FIS_OPCART76        VARCHAR2(1 BYTE)              NULL,
  FIS_COOPRO          VARCHAR2(1 BYTE)              NULL,
  FIS_COOESPPRO       VARCHAR2(1 BYTE)              NULL,
  FIS_RESCOO          VARCHAR2(1 BYTE)              NULL,
  FIS_OTRREGESP       VARCHAR2(1 BYTE)              NULL,
  FIS_ESTABLE         VARCHAR2(1 BYTE)              NULL,
  FIS_NUECREA         VARCHAR2(1 BYTE)              NULL,
  FIS_TRIBUTA         VARCHAR2(1 BYTE)              NULL,
  FIS_CTAPTES         VARCHAR2(1 BYTE)              NULL,
  FIS_CTAMILE         VARCHAR2(1 BYTE)              NULL,
  FIS_CTAMILL         VARCHAR2(1 BYTE)              NULL,
  FIS_FIRMANTES       VARCHAR2(120 BYTE)            NULL,
  FIS_MON_COD         VARCHAR2(1 BYTE)              NULL,
  FIS_VALNOMINAL      NUMBER(18,6)              DEFAULT 0                         NULL,
  FIS_VALCAPITAL      NUMBER(15,3)              DEFAULT 0                         NULL,
  FIS_USUCRE          VARCHAR2(30 BYTE)             NULL,
  FIS_DATCRE          DATE                          NULL,
  FIS_USUMOD          VARCHAR2(30 BYTE)             NULL,
  FIS_DATMOD          DATE                          NULL,
  FIS_MON_CODDEF      VARCHAR2(1 BYTE)              NULL,
  FIS_ENTTRA002       VARCHAR2(1 BYTE)              NULL,
  FIS_ENTTRA003       VARCHAR2(1 BYTE)              NULL,
  FIS_REGESPCANARIAS  VARCHAR2(1 BYTE)              NULL,
  FIS_TRASELEMPATR    VARCHAR2(1 BYTE)              NULL,
  FIS_SOCCAPRIE       VARCHAR2(1 BYTE)              NULL,
  FIS_SOCDESIND       VARCHAR2(1 BYTE)              NULL,
  FIS_REGESPMIN       VARCHAR2(1 BYTE)              NULL,
  FIS_REGESPHID       VARCHAR2(1 BYTE)              NULL,
  FIS_OBS             VARCHAR2(1000 BYTE)           NULL,
  FIS_ENTARRVIV       VARCHAR2(1 BYTE)              NULL,
  FIS_INVCANARIAS     VARCHAR2(1 BYTE)              NULL,
  FIS_SOLCERTIF       VARCHAR2(1 BYTE)              NULL,
  FIS_FONPENSION      VARCHAR2(1 BYTE)              NULL,
  FIS_RGTMTL001       NUMBER(5)                     NULL,
  FIS_RGTMTL002       NUMBER(5)                     NULL,
  FIS_RGTMTL003       NUMBER(6)                     NULL
)
;


CREATE TABLE TCMP_EMPRESAX
(
  EMX_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  EMX_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  EMX_OPA      NUMBER                               NULL,
  EMX_OPB      NUMBER                               NULL,
  EMX_OPC      NUMBER                               NULL,
  EMX_OPD      NUMBER                               NULL,
  EMX_OPE      NUMBER                               NULL,
  EMX_IMPA     NUMBER(15,2)                         NULL,
  EMX_IMPB     NUMBER(15,2)                         NULL,
  EMX_IMPC     NUMBER(15,2)                         NULL,
  EMX_IMPD     NUMBER(15,2)                         NULL,
  EMX_IMPE     NUMBER(15,2)                         NULL,
  EMX_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EMX_DATCRE   DATE                                 NULL,
  EMX_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  EMX_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_EMPRESES
(
  EMP_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  EMP_COD        VARCHAR2(4 BYTE)                   NULL,
  EMP_NIF_NIF    VARCHAR2(12 BYTE)                  NULL,
  EMP_TAS_COD    VARCHAR2(2 BYTE)                   NULL,
  EMP_NOMCOM     VARCHAR2(40 BYTE)                  NULL,
  EMP_MON_COD    VARCHAR2(1 BYTE)                   NULL,
  EMP_TELCOM     VARCHAR2(30 BYTE)                  NULL,
  EMP_FAXCOM     VARCHAR2(30 BYTE)                  NULL,
  EMP_EMLCOM     VARCHAR2(60 BYTE)                  NULL,
  EMP_CONCOM     VARCHAR2(100 BYTE)                 NULL,
  EMP_LOGOTIP    LONG RAW                           NULL,
  EMP_MOSLOG     VARCHAR2(1 BYTE)               DEFAULT 'N'                       NULL,
  EMP_FIS_COD    VARCHAR2(4 BYTE)                   NULL,
  EMP_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  EMP_DATCRE     DATE                               NULL,
  EMP_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  EMP_DATMOD     DATE                               NULL,
  EMP_ACT        VARCHAR2(1 BYTE)               DEFAULT 'S'                       NULL,
  EMP_OBS        VARCHAR2(1000 BYTE)                NULL,
  EMP_REGCRICXA  VARCHAR2(1 BYTE)                   NULL,
  EMP_DESOPEVEN  VARCHAR2(500 BYTE)                 NULL
)
;


CREATE TABLE TCMP_EMPRE_OBLIGACIONS
(
  FOB_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  FOB_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  FOB_OBL_COD  VARCHAR2(3 BYTE)                     NULL,
  FOB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FOB_DATCRE   DATE                                 NULL,
  FOB_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  FOB_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_EXD
(
  EXD_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  EXD_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  EXD_COD      VARCHAR2(4 BYTE)                     NULL,
  EXD_NOM      VARCHAR2(60 BYTE)                    NULL,
  EXD_DATCRE   DATE                                 NULL,
  EXD_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EXD_DATMOD   DATE                                 NULL,
  EXD_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  EXD_TOC_COD  VARCHAR2(4 BYTE)                     NULL,
  EXD_DATINI   DATE                                 NULL,
  EXD_DATFIN   DATE                                 NULL,
  EXD_TCO_COD  VARCHAR2(4 BYTE)                     NULL,
  EXD_NIFADJ   VARCHAR2(11 BYTE)                    NULL,
  EXD_NOMADJ   VARCHAR2(40 BYTE)                    NULL,
  EXD_IMPADJ   NUMBER(15,2)                         NULL,
  EXD_FIN      VARCHAR2(1 BYTE)                     NULL,
  EXD_CPA      VARCHAR2(255 BYTE)                   NULL,
  EXD_PBL      VARCHAR2(1 BYTE)                     NULL,
  EXD_NUMPER   NUMBER(3)                            NULL,
  EXD_MODCTR   VARCHAR2(1 BYTE)                     NULL,
  EXD_IMPLIC   NUMBER(15,2)                         NULL,
  EXD_NUM      VARCHAR2(12 BYTE)                    NULL,
  EXD_DATADJ   DATE                                 NULL,
  EXD_BASADJ   NUMBER(15,2)                         NULL,
  EXD_IVAADJ   NUMBER(15,2)                         NULL
)
;


CREATE TABLE TCMP_EXERCICIS
(
  EJE_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  EJE_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  EJE_COD        VARCHAR2(4 BYTE)                   NULL,
  EJE_DATINI     DATE                               NULL,
  EJE_DATFIN     DATE                               NULL,
  EJE_MON_COD    VARCHAR2(1 BYTE)                   NULL,
  EJE_NUMDEC     NUMBER(1)                          NULL,
  EJE_TANCAT     VARCHAR2(1 BYTE)                   NULL,
  EJE_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  EJE_DATCRE     DATE                               NULL,
  EJE_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  EJE_DATMOD     DATE                               NULL,
  EJE_MESTAN     NUMBER(2)                          NULL,
  EJE_ANYTAN     NUMBER(4)                          NULL,
  EJE_DATEXPIMP  DATE                               NULL,
  EJE_DIACIERRE  DATE                               NULL
)
;


CREATE TABLE TCMP_GRUPSEMPRESES
(
  GEM_GRP_COD      VARCHAR2(15 BYTE)                NULL,
  GEM_EMP_CEC_COD  VARCHAR2(4 BYTE)                 NULL,
  GEM_EMP_COD      VARCHAR2(4 BYTE)                 NULL,
  GEM_USUCRE       VARCHAR2(30 BYTE)                NULL,
  GEM_DATCRE       DATE                             NULL,
  GEM_USUMOD       VARCHAR2(30 BYTE)                NULL,
  GEM_DATMOD       DATE                             NULL
)
;


CREATE TABLE TCMP_M00
(
  M00_CEC_COD          VARCHAR2(4 BYTE)             NULL,
  M00_FIS_COD          VARCHAR2(4 BYTE)             NULL,
  M00_EXC              VARCHAR2(4 BYTE)             NULL,
  M00_PRD              VARCHAR2(2 BYTE)             NULL,
  M00_MON_COD          VARCHAR2(1 BYTE)             NULL,
  M00_SINACT           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M00_FPAEFE           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M00_FPAADE           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M00_DIA              DATE                         NULL,
  M00_USUCRE           VARCHAR2(30 BYTE)            NULL,
  M00_DATCRE           DATE                         NULL,
  M00_BIMRPC001        NUMBER(15,3)                 NULL,
  M00_PTERPC001        NUMBER(5,2)                  NULL,
  M00_IVARPC001        NUMBER(15,3)                 NULL,
  M00_BIMRPC002        NUMBER(15,3)                 NULL,
  M00_PTERPC002        NUMBER(5,2)                  NULL,
  M00_IVARPC002        NUMBER(15,3)                 NULL,
  M00_BIMRPC003        NUMBER(15,3)                 NULL,
  M00_PTERPC003        NUMBER(5,2)                  NULL,
  M00_IVARPC003        NUMBER(15,3)                 NULL,
  M00_BIMREQRPC001     NUMBER(15,3)                 NULL,
  M00_PTEREQRPC001     NUMBER(5,2)                  NULL,
  M00_REQRPC001        NUMBER(15,3)                 NULL,
  M00_BIMREQRPC002     NUMBER(15,3)                 NULL,
  M00_PTEREQRPC002     NUMBER(5,2)                  NULL,
  M00_REQRPC002        NUMBER(15,3)                 NULL,
  M00_BIMREQRPC003     NUMBER                       NULL,
  M00_PTEREQRPC003     NUMBER(5,2)                  NULL,
  M00_REQRPC003        NUMBER(15,3)                 NULL,
  M00_BIMRPCINTRAC     NUMBER(15,3)                 NULL,
  M00_IVARPCINTRAC     NUMBER(15,3)                 NULL,
  M00_SUMRPC           NUMBER(15,3)                 NULL,
  M00_IVASOPINTERI     NUMBER(15,3)                 NULL,
  M00_IVASOPIMPORT     NUMBER(15,3)                 NULL,
  M00_IVASOPADQINTRAC  NUMBER(15,3)                 NULL,
  M00_IVASORAGRARI     NUMBER(15,3)                 NULL,
  M00_IVASOPREGINV     NUMBER(15,3)                 NULL,
  M00_SUMSOP           NUMBER(15,3)                 NULL,
  M00_DIFRPCSOP        NUMBER(15,3)                 NULL,
  M00_PTEADMEST        NUMBER(5,2)                  NULL,
  M00_IVAESTADO        NUMBER(15,3)                 NULL,
  M00_IVACOMPEN        NUMBER(15,3)                 NULL,
  M00_IVAENTINTRAC     NUMBER(15,3)                 NULL,
  M00_ESTADODIPUTA     NUMBER(15,3)                 NULL,
  M00_RESULTADO        NUMBER(15,3)                 NULL,
  M00_IMPCOMPEN        NUMBER(15,3)                 NULL,
  M00_IMPDEV           NUMBER(15,3)                 NULL,
  M00_BANDEV           VARCHAR2(4 BYTE)             NULL,
  M00_OFIDEV           VARCHAR2(4 BYTE)             NULL,
  M00_DCCDEV           VARCHAR2(2 BYTE)             NULL,
  M00_CCRDEV           VARCHAR2(10 BYTE)            NULL,
  M00_IMPING           NUMBER(15,3)                 NULL,
  M00_BANING           VARCHAR2(4 BYTE)             NULL,
  M00_OFIING           VARCHAR2(4 BYTE)             NULL,
  M00_DCCING           VARCHAR2(2 BYTE)             NULL,
  M00_CCRING           VARCHAR2(10 BYTE)            NULL,
  M00_USUMOD           VARCHAR2(30 BYTE)            NULL,
  M00_DATMOD           DATE                         NULL,
  M00_VENEXEIVA        NUMBER(15,3)                 NULL,
  M00_IVASOPREGPRO     NUMBER(15,3)                 NULL,
  M00_DEDDECLANT       NUMBER(15,3)                 NULL,
  M00_RESULTADOLIQ     NUMBER(15,3)                 NULL,
  M00_LOCALIDAD        VARCHAR2(16 BYTE)            NULL,
  M00_CODDECLANT       VARCHAR2(16 BYTE)            NULL,
  M00_NUMDECLANT       VARCHAR2(16 BYTE)            NULL,
  M00_FPADOMPAG        VARCHAR2(1 BYTE)             NULL,
  M00_REGDEVMES        VARCHAR2(1 BYTE)             NULL,
  M00_EXPOPEASI        NUMBER(15,3)                 NULL,
  M00_OPENOSDED        NUMBER(15,3)                 NULL,
  M00_INDAUTCOM        VARCHAR2(1 BYTE)             NULL,
  M00_CONJUNTA         VARCHAR2(1 BYTE)             NULL,
  M00_DECLCONCURSO     VARCHAR2(1 BYTE)             NULL,
  M00_REGSIM           VARCHAR2(1 BYTE)             NULL,
  M00_AUTLIQCON        VARCHAR2(1 BYTE)             NULL,
  M00_CONACR           VARCHAR2(1 BYTE)             NULL,
  M00_DATCONACR        DATE                         NULL,
  M00_AUTDECCON        VARCHAR2(1 BYTE)             NULL,
  M00_REGCRICXA        VARCHAR2(1 BYTE)             NULL,
  M00_DTIREGCRICXA     VARCHAR2(1 BYTE)             NULL,
  M00_PROESP           VARCHAR2(1 BYTE)             NULL,
  M00_REVPROESP        VARCHAR2(1 BYTE)             NULL,
  M00_CRICXAENTBAS     NUMBER(15,3)                 NULL,
  M00_CRICXAENTQUO     NUMBER(15,3)                 NULL,
  M00_CRICXAADQBAS     NUMBER(15,3)                 NULL,
  M00_CRICXAADQQUO     NUMBER(15,3)                 NULL,
  M00_IBNPAI           VARCHAR2(2 BYTE)             NULL,
  M00_IBNDCC           VARCHAR2(2 BYTE)             NULL,
  M00_BIMOPSSUJPAS     NUMBER(15,3)                 NULL,
  M00_QUOOPSSUJPAS     NUMBER(15,3)                 NULL,
  M00_BIMMOD           NUMBER(15,3)                 NULL,
  M00_QUOMOD           NUMBER(15,3)                 NULL,
  M00_BIMMODREC        NUMBER(15,3)                 NULL,
  M00_QUOMODREC        NUMBER(15,3)                 NULL,
  M00_IVAMODBAS        NUMBER(15,3)                 NULL,
  M00_IVAMODQUO        NUMBER(15,3)                 NULL,
  M00_RS_001           NUMBER(17,2)                 NULL,
  M00_RS_002           NUMBER(17,2)                 NULL,
  M00_RS_003           NUMBER(17,2)                 NULL,
  M00_RS_004           NUMBER(17,2)                 NULL,
  M00_RS_005           NUMBER(17,2)                 NULL,
  M00_RS_006           NUMBER(17,2)                 NULL,
  M00_RS_007           NUMBER(17,2)                 NULL,
  M00_RS_008           NUMBER(17,2)                 NULL,
  M00_RS_009           NUMBER(17,2)                 NULL,
  M00_RS_010           NUMBER(17,2)                 NULL,
  M00_RS_011           NUMBER(17,2)                 NULL,
  M00_RS_012           NUMBER(17,2)                 NULL,
  M00_IAE              VARCHAR2(5 BYTE)             NULL,
  M00_IAE001           VARCHAR2(5 BYTE)             NULL,
  M00_IAE002           VARCHAR2(5 BYTE)             NULL,
  M00_IAE003           VARCHAR2(5 BYTE)             NULL,
  M00_IAE004           VARCHAR2(5 BYTE)             NULL,
  M00_IAE005           VARCHAR2(5 BYTE)             NULL,
  M00_CLA              VARCHAR2(2 BYTE)             NULL,
  M00_CLA001           VARCHAR2(2 BYTE)             NULL,
  M00_CLA002           VARCHAR2(2 BYTE)             NULL,
  M00_CLA003           VARCHAR2(2 BYTE)             NULL,
  M00_CLA004           VARCHAR2(2 BYTE)             NULL,
  M00_CLA005           VARCHAR2(2 BYTE)             NULL,
  M00_076              NUMBER(17,2)                 NULL,
  M00_077              NUMBER(17,2)                 NULL,
  M00_080              NUMBER(17,2)                 NULL,
  M00_081              NUMBER(17,2)                 NULL,
  M00_082              NUMBER(17,2)                 NULL,
  M00_083              NUMBER(17,2)                 NULL,
  M00_084              NUMBER(17,2)                 NULL,
  M00_085              NUMBER(17,2)                 NULL,
  M00_086              NUMBER(17,2)                 NULL,
  M00_087              NUMBER(17,2)                 NULL,
  M00_088              NUMBER(17,2)                 NULL,
  M00_PER              VARCHAR2(1 BYTE)             NULL,
  M00_EJE_COD          VARCHAR2(4 BYTE)             NULL,
  M00_DIA_COD          VARCHAR2(2 BYTE)             NULL,
  M00_ASI_NUMASI       NUMBER(10)                   NULL,
  M00_BIC              VARCHAR2(11 BYTE)            NULL,
  M00_093              NUMBER(15,3)                 NULL,
  M00_094              NUMBER(15,3)                 NULL,
  M00_095              NUMBER(15,3)                 NULL,
  M00_096              NUMBER(15,3)                 NULL,
  M00_097              NUMBER(15,3)                 NULL,
  M00_098              NUMBER(15,3)                 NULL,
  M00_079              NUMBER(15,3)                 NULL,
  M00_099              NUMBER(15,3)                 NULL,
  M00_NOT390           VARCHAR2(1 BYTE)             NULL,
  M00_SII              VARCHAR2(1 BYTE)             NULL,
  M00_VOL              VARCHAR2(1 BYTE)             NULL
)
;


CREATE TABLE TCMP_M10
(
  M10_CEC_COD          VARCHAR2(4 BYTE)             NULL,
  M10_FIS_COD          VARCHAR2(4 BYTE)             NULL,
  M10_EXC              VARCHAR2(4 BYTE)             NULL,
  M10_PRD              VARCHAR2(1 BYTE)             NULL,
  M10_SINACT           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M10_FPAEFE           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M10_FPAADE           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M10_DOMICILIA        VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M10_MON_COD          VARCHAR2(1 BYTE)             NULL,
  M10_DATCRE           DATE                         NULL,
  M10_USUCRE           VARCHAR2(30 BYTE)            NULL,
  M10_DIA              DATE                         NULL,
  M10_DATMOD           DATE                         NULL,
  M10_USUMOD           VARCHAR2(30 BYTE)            NULL,
  M10_IAE_EPIGRAFE001  VARCHAR2(5 BYTE)             NULL,
  M10_IAE_EPIGRAFE002  VARCHAR2(5 BYTE)             NULL,
  M10_IAE_EPIGRAFE003  VARCHAR2(5 BYTE)             NULL,
  M10_IAE_EPIGRAFE004  VARCHAR2(5 BYTE)             NULL,
  M10_IAE_EPIGRAFE005  VARCHAR2(5 BYTE)             NULL,
  M10_ING1RS           NUMBER(15,3)                 NULL,
  M10_ING2RS           NUMBER(15,3)                 NULL,
  M10_ING3RS           NUMBER(15,3)                 NULL,
  M10_ING4RS           NUMBER(15,3)                 NULL,
  M10_ING5RS           NUMBER(15,3)                 NULL,
  M10_DESACT1          VARCHAR2(50 BYTE)            NULL,
  M10_INGACT1          NUMBER(15,3)                 NULL,
  M10_DESACT2          VARCHAR2(50 BYTE)            NULL,
  M10_INGACT2          NUMBER(15,3)                 NULL,
  M10_DESACT3          VARCHAR2(50 BYTE)            NULL,
  M10_INGACT3          NUMBER(15,3)                 NULL,
  M10_DESACT4          VARCHAR2(50 BYTE)            NULL,
  M10_INGACT4          NUMBER(15,3)                 NULL,
  M10_SUMING           NUMBER(15,3)                 NULL,
  M10_ADQINTRAC        NUMBER(15,3)                 NULL,
  M10_ACTFIJ           NUMBER(15,3)                 NULL,
  M10_INVSUJPAS        NUMBER(15,3)                 NULL,
  M10_TOTCUODEV        NUMBER(15,3)                 NULL,
  M10_IVADEDUC         NUMBER(15,3)                 NULL,
  M10_DIFCUOIVA        NUMBER(15,3)                 NULL,
  M10_CUOCOMPEN        NUMBER(15,3)                 NULL,
  M10_RESDIFCUO        NUMBER(15,3)                 NULL,
  M10_ENTINTRAC        NUMBER(15,3)                 NULL,
  M10_IMPCOMPEN        NUMBER(15,3)                 NULL,
  M10_IMPING           NUMBER(15,3)                 NULL,
  M10_BANING           VARCHAR2(4 BYTE)             NULL,
  M10_OFIING           VARCHAR2(4 BYTE)             NULL,
  M10_DCCING           VARCHAR2(2 BYTE)             NULL,
  M10_CCRING           VARCHAR2(10 BYTE)            NULL,
  M10_BANPAG           VARCHAR2(4 BYTE)             NULL,
  M10_OFIPAG           VARCHAR2(4 BYTE)             NULL,
  M10_DCCPAG           VARCHAR2(2 BYTE)             NULL,
  M10_CCRPAG           VARCHAR2(10 BYTE)            NULL,
  M10_LOCALIDAD        VARCHAR2(20 BYTE)            NULL,
  M10_COMPLEM          VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M10_NUMDECLANT       VARCHAR2(13 BYTE)            NULL,
  M10_IMPDEDUC         NUMBER(15,3)                 NULL,
  M10_RESLIQ           NUMBER(15,3)                 NULL
)
;


CREATE TABLE TCMP_M11
(
  M11_CEC_COD          VARCHAR2(4 BYTE)             NULL,
  M11_FIS_COD          VARCHAR2(4 BYTE)             NULL,
  M11_EXC              VARCHAR2(4 BYTE)             NULL,
  M11_SINACT           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M11_FPAEFE           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M11_FPAADE           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M11_MON_COD          VARCHAR2(1 BYTE)             NULL,
  M11_DATCRE           DATE                         NULL,
  M11_USUCRE           VARCHAR2(30 BYTE)            NULL,
  M11_DATMOD           DATE                         NULL,
  M11_USUMOD           VARCHAR2(30 BYTE)            NULL,
  M11_DIA              DATE                         NULL,
  M11_IAE_EPIGRAFE001  VARCHAR2(5 BYTE)             NULL,
  M11_CUOIAE001        NUMBER(15,3)                 NULL,
  M11_SOPORTADO1       NUMBER(15,3)                 NULL,
  M11_ING1RS           NUMBER(15,3)                 NULL,
  M11_IAE_EPIGRAFE002  VARCHAR2(5 BYTE)             NULL,
  M11_CUOIAE002        NUMBER(15,3)                 NULL,
  M11_SOPORTADO2       NUMBER(15,3)                 NULL,
  M11_ING2RS           NUMBER(15,3)                 NULL,
  M11_IAE_EPIGRAFE003  VARCHAR2(5 BYTE)             NULL,
  M11_CUOIAE003        NUMBER(15,3)                 NULL,
  M11_SOPORTADO3       NUMBER(15,3)                 NULL,
  M11_ING3RS           NUMBER(15,3)                 NULL,
  M11_IAE_EPIGRAFE004  VARCHAR2(5 BYTE)             NULL,
  M11_CUOIAE004        NUMBER(15,3)                 NULL,
  M11_SOPORTADO4       NUMBER(15,3)                 NULL,
  M11_ING4RS           NUMBER(15,3)                 NULL,
  M11_IAE_EPIGRAFE005  VARCHAR2(5 BYTE)             NULL,
  M11_CUOIAE005        NUMBER(15,3)                 NULL,
  M11_SOPORTADO5       NUMBER(15,3)                 NULL,
  M11_ING5RS           NUMBER(15,3)                 NULL,
  M11_DESACT1          VARCHAR2(50 BYTE)            NULL,
  M11_INGACT1          NUMBER(15,3)                 NULL,
  M11_DESACT2          VARCHAR2(50 BYTE)            NULL,
  M11_INGACT2          NUMBER(15,3)                 NULL,
  M11_DESACT3          VARCHAR2(50 BYTE)            NULL,
  M11_INGACT3          NUMBER(15,3)                 NULL,
  M11_DESACT4          VARCHAR2(50 BYTE)            NULL,
  M11_INGACT4          NUMBER(15,3)                 NULL,
  M11_SUMCUO           NUMBER(15,3)                 NULL,
  M11_SUMING           NUMBER(15,3)                 NULL,
  M11_RESULTADO        NUMBER(15,3)                 NULL,
  M11_ADQINTRAC        NUMBER(15,3)                 NULL,
  M11_ACTFIJ           NUMBER(15,3)                 NULL,
  M11_INVSUJPAS        NUMBER(15,3)                 NULL,
  M11_TOTCUO           NUMBER(15,3)                 NULL,
  M11_IVADEDUCAF       NUMBER(15,3)                 NULL,
  M11_IVADEDUCRE       NUMBER(15,3)                 NULL,
  M11_TOTIVADEDUC      NUMBER(15,3)                 NULL,
  M11_DIFRESIVADEDUC   NUMBER(15,3)                 NULL,
  M11_CUOCOMPEN        NUMBER(15,3)                 NULL,
  M11_DIFCUOCOMPEN     NUMBER(15,3)                 NULL,
  M11_ENTINTRAC        NUMBER(15,3)                 NULL,
  M11_IMPCOMPEN        NUMBER(15,3)                 NULL,
  M11_IMPDEV           NUMBER(15,3)                 NULL,
  M11_BANDEV           VARCHAR2(4 BYTE)             NULL,
  M11_OFIDEV           VARCHAR2(4 BYTE)             NULL,
  M11_DCCDEV           VARCHAR2(2 BYTE)             NULL,
  M11_CCRDEV           VARCHAR2(10 BYTE)            NULL,
  M11_IMPING           NUMBER(15,3)                 NULL,
  M11_BANING           VARCHAR2(4 BYTE)             NULL,
  M11_OFIING           VARCHAR2(4 BYTE)             NULL,
  M11_DCCING           VARCHAR2(2 BYTE)             NULL,
  M11_CCRING           VARCHAR2(10 BYTE)            NULL,
  M11_LOCALIDAD        VARCHAR2(16 BYTE)            NULL,
  M11_COMPLEM          VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  M11_NUMDECLANT       VARCHAR2(13 BYTE)            NULL,
  M11_IMPDEDUC         NUMBER(15,3)                 NULL,
  M11_RESLIQ           NUMBER(15,3)                 NULL
)
;


CREATE TABLE TCMP_M303IVADED
(
  I303_CEC_COD  VARCHAR2(4 BYTE)                    NULL,
  I303_FIS_COD  VARCHAR2(4 BYTE)                    NULL,
  I303_M00_EXC  VARCHAR2(4 BYTE)                    NULL,
  I303_M00_PRD  VARCHAR2(2 BYTE)                    NULL,
  I303_SEQ      NUMBER(2)                           NULL,
  I303_DATCRE   DATE                                NULL,
  I303_USUCRE   VARCHAR2(30 BYTE)                   NULL,
  I303_001      NUMBER(15,2)                        NULL,
  I303_002      NUMBER(15,2)                        NULL,
  I303_003      NUMBER(15,2)                        NULL,
  I303_004      NUMBER(15,2)                        NULL,
  I303_005      NUMBER(15,2)                        NULL,
  I303_006      NUMBER(15,2)                        NULL,
  I303_007      NUMBER(15,2)                        NULL,
  I303_008      NUMBER(15,2)                        NULL,
  I303_009      NUMBER(15,2)                        NULL,
  I303_010      NUMBER(15,2)                        NULL,
  I303_011      NUMBER(15,2)                        NULL,
  I303_012      NUMBER(15,2)                        NULL,
  I303_013      NUMBER(15,2)                        NULL,
  I303_014      NUMBER(15,2)                        NULL,
  I303_015      NUMBER(15,2)                        NULL,
  I303_016      NUMBER(15,2)                        NULL,
  I303_017      NUMBER(15,2)                        NULL,
  I303_018      NUMBER(15,2)                        NULL,
  I303_DATMOD   DATE                                NULL,
  I303_USUMOD   VARCHAR2(30 BYTE)                   NULL
)
;


CREATE TABLE TCMP_M303PRORRATA
(
  P303_CEC_COD  VARCHAR2(4 BYTE)                    NULL,
  P303_FIS_COD  VARCHAR2(4 BYTE)                    NULL,
  P303_M00_EXC  VARCHAR2(4 BYTE)                    NULL,
  P303_M00_PRD  VARCHAR2(2 BYTE)                    NULL,
  P303_SEQ      NUMBER(2)                           NULL,
  P303_CNAE     VARCHAR2(3 BYTE)                    NULL,
  P303_DATCRE   DATE                                NULL,
  P303_USUCRE   VARCHAR2(30 BYTE)                   NULL,
  P303_IMP      NUMBER(15,2)                        NULL,
  P303_IMPDED   NUMBER(15,2)                        NULL,
  P303_TIP      VARCHAR2(1 BYTE)                    NULL,
  P303_PTE      NUMBER(5,2)                         NULL,
  P303_DATMOD   DATE                                NULL,
  P303_USUMOD   VARCHAR2(30 BYTE)                   NULL
)
;


CREATE TABLE TCMP_M90
(
  M90_CEC_COD            VARCHAR2(4 BYTE)           NULL,
  M90_FIS_COD            VARCHAR2(4 BYTE)           NULL,
  M90_EXC                VARCHAR2(4 BYTE)           NULL,
  M90_TERCERAS           VARCHAR2(1 BYTE)           NULL,
  M90_EXPORTADORES       VARCHAR2(1 BYTE)       DEFAULT 'N'                       NULL,
  M90_SUSTITUTIVA        VARCHAR2(1 BYTE)           NULL,
  M90_MON_COD            VARCHAR2(1 BYTE)           NULL,
  M90_DATCRE             DATE                       NULL,
  M90_USUCRE             VARCHAR2(30 BYTE)          NULL,
  M90_NUMDECLANT         VARCHAR2(13 BYTE)          NULL,
  M90_IAE_EPIGRAFE1      VARCHAR2(5 BYTE)           NULL,
  M90_IAE_EPIGRAFE2      VARCHAR2(5 BYTE)           NULL,
  M90_IAE_EPIGRAFE3      VARCHAR2(5 BYTE)           NULL,
  M90_IAE_EPIGRAFE4      VARCHAR2(5 BYTE)           NULL,
  M90_IAE_EPIGRAFE5      VARCHAR2(5 BYTE)           NULL,
  M90_IAE_EPIGRAFE6      VARCHAR2(5 BYTE)           NULL,
  M90_CLAVE1             VARCHAR2(2 BYTE)           NULL,
  M90_CLAVE2             VARCHAR2(2 BYTE)           NULL,
  M90_CLAVE3             VARCHAR2(2 BYTE)           NULL,
  M90_CLAVE4             VARCHAR2(2 BYTE)           NULL,
  M90_CLAVE5             VARCHAR2(2 BYTE)           NULL,
  M90_CLAVE6             VARCHAR2(2 BYTE)           NULL,
  M90_NIFCONJUNTA        VARCHAR2(12 BYTE)          NULL,
  M90_NOMCONJUNTA        VARCHAR2(30 BYTE)          NULL,
  M90_DAT                DATE                       NULL,
  M90_LOCALIDAD          VARCHAR2(30 BYTE)          NULL,
  M90_DIA                NUMBER(2)                  NULL,
  M90_MES                VARCHAR2(10 BYTE)          NULL,
  M90_ANY                NUMBER(4)                  NULL,
  M90_RG_RO_BAS1         NUMBER(15,2)               NULL,
  M90_RG_RO_BAS2         NUMBER(15,2)               NULL,
  M90_RG_RO_BAS3         NUMBER(15,2)               NULL,
  M90_RG_RO_CUO1         NUMBER(15,2)               NULL,
  M90_RG_RO_CUO2         NUMBER(15,2)               NULL,
  M90_RG_RO_CUO3         NUMBER(15,2)               NULL,
  M90_RG_RO_PTE1         NUMBER(5,2)                NULL,
  M90_RG_RO_PTE2         NUMBER(5,2)                NULL,
  M90_RG_RO_PTE3         NUMBER(5,2)                NULL,
  M90_RG_RB_BAS1         NUMBER(15,2)               NULL,
  M90_RG_RB_BAS2         NUMBER(15,2)               NULL,
  M90_RG_RB_BAS3         NUMBER(15,2)               NULL,
  M90_RG_RB_CUO1         NUMBER(15,2)               NULL,
  M90_RG_RB_CUO2         NUMBER(15,2)               NULL,
  M90_RG_RB_CUO3         NUMBER(15,2)               NULL,
  M90_RG_RB_PTE1         NUMBER(5,2)                NULL,
  M90_RG_RB_PTE2         NUMBER(5,2)                NULL,
  M90_RG_RB_PTE3         NUMBER(5,2)                NULL,
  M90_RG_AV_BAS          NUMBER(15,2)               NULL,
  M90_RG_AV_CUO          NUMBER(15,2)               NULL,
  M90_RG_AV_PTE          NUMBER(5,2)                NULL,
  M90_RG_AI_BAS1         NUMBER(15,2)               NULL,
  M90_RG_AI_BAS2         NUMBER(15,2)               NULL,
  M90_RG_AI_BAS3         NUMBER(15,2)               NULL,
  M90_RG_AI_CUO1         NUMBER(15,2)               NULL,
  M90_RG_AI_CUO2         NUMBER(15,2)               NULL,
  M90_RG_AI_CUO3         NUMBER(15,2)               NULL,
  M90_RG_AI_PTE1         NUMBER(5,2)                NULL,
  M90_RG_AI_PTE2         NUMBER(5,2)                NULL,
  M90_RG_AI_PTE3         NUMBER(5,2)                NULL,
  M90_RG_SP_BAS          NUMBER(15,2)               NULL,
  M90_RG_SP_CUO          NUMBER(15,2)               NULL,
  M90_RG_MB_BAS          NUMBER(15,2)               NULL,
  M90_RG_MB_CUO          NUMBER(15,2)               NULL,
  M90_RG_QS_BAS          NUMBER(15,2)               NULL,
  M90_RG_QS_CUO          NUMBER(15,2)               NULL,
  M90_RG_TOTBAS          NUMBER(15,2)               NULL,
  M90_RG_TOTCUO          NUMBER(15,2)               NULL,
  M90_RG_RE_BAS1         NUMBER(15,2)               NULL,
  M90_RG_RE_BAS2         NUMBER(15,2)               NULL,
  M90_RG_RE_BAS3         NUMBER(15,2)               NULL,
  M90_RG_RE_BAS4         NUMBER(15,2)               NULL,
  M90_RG_RE_CUO1         NUMBER(15,2)               NULL,
  M90_RG_RE_CUO2         NUMBER(15,2)               NULL,
  M90_RG_RE_CUO3         NUMBER(15,2)               NULL,
  M90_RG_RE_CUO4         NUMBER(15,2)               NULL,
  M90_RG_RE_PTE1         NUMBER(5,2)                NULL,
  M90_RG_RE_PTE2         NUMBER(5,2)                NULL,
  M90_RG_RE_PTE3         NUMBER(5,2)                NULL,
  M90_RG_RE_PTE4         NUMBER(5,2)                NULL,
  M90_RG_MR_BAS          NUMBER(15,2)               NULL,
  M90_RG_MR_CUO          NUMBER(15,2)               NULL,
  M90_RG_MQ_BAS          NUMBER(15,2)               NULL,
  M90_RG_MQ_CUO          NUMBER(15,2)               NULL,
  M90_RG_TOTCUORE        NUMBER(15,2)               NULL,
  M90_RG_IDOI_BAS1       NUMBER(15,2)               NULL,
  M90_RG_IDOI_BAS2       NUMBER(15,2)               NULL,
  M90_RG_IDOI_CUO1       NUMBER(15,2)               NULL,
  M90_RG_IDOI_CUO2       NUMBER(15,2)               NULL,
  M90_RG_IDIM_BAS1       NUMBER(15,2)               NULL,
  M90_RG_IDIM_BAS2       NUMBER(15,2)               NULL,
  M90_RG_IDIM_CUO1       NUMBER(15,2)               NULL,
  M90_RG_IDIM_CUO2       NUMBER(15,2)               NULL,
  M90_RG_IDAI_BAS1       NUMBER(15,2)               NULL,
  M90_RG_IDAI_BAS2       NUMBER(15,2)               NULL,
  M90_RG_IDAI_CUO1       NUMBER(15,2)               NULL,
  M90_RG_IDAI_CUO2       NUMBER(15,2)               NULL,
  M90_RG_IDAG_BAS        NUMBER(15,2)               NULL,
  M90_RG_IDAG_CUO        NUMBER(15,2)               NULL,
  M90_RG_IDRECT          NUMBER(15,2)               NULL,
  M90_RG_IDREGU          NUMBER(15,2)               NULL,
  M90_RG_IDSUM           NUMBER(15,2)               NULL,
  M90_RG_RES             NUMBER(15,2)               NULL,
  M90_RS_IESUMCUO1       NUMBER(15,2)               NULL,
  M90_RS_IESUMCUO2       NUMBER(15,2)               NULL,
  M90_RS_IEAI            NUMBER(15,2)               NULL,
  M90_RS_IESP            NUMBER(15,2)               NULL,
  M90_RS_IEAF            NUMBER(15,2)               NULL,
  M90_RS_IETOTCUO        NUMBER(15,2)               NULL,
  M90_RS_IDAF            NUMBER(15,2)               NULL,
  M90_RS_IDBI            NUMBER(15,2)               NULL,
  M90_RS_IDSUM           NUMBER(15,2)               NULL,
  M90_RS_RES             NUMBER(15,2)               NULL,
  M90_LA_SUMRES          NUMBER(15,2)               NULL,
  M90_LA_COMPEN          NUMBER(15,2)               NULL,
  M90_LA_RES             NUMBER(15,2)               NULL,
  M90_TT_COMUN           NUMBER(5,2)                NULL,
  M90_TT_ALAVA           NUMBER(5,2)                NULL,
  M90_TT_GUIPUZCOA       NUMBER(5,2)                NULL,
  M90_TT_VIZCAYA         NUMBER(5,2)                NULL,
  M90_TT_NAVARRA         NUMBER(5,2)                NULL,
  M90_TT_SUMRES          NUMBER(15,2)               NULL,
  M90_TT_RESCOMUN        NUMBER(15,2)               NULL,
  M90_TT_COMPEN          NUMBER(15,2)               NULL,
  M90_TT_RES             NUMBER(15,2)               NULL,
  M90_RL_TOTING          NUMBER(15,2)               NULL,
  M90_RL_TOTDEV          NUMBER(15,2)               NULL,
  M90_RL_COMPEN          NUMBER(15,2)               NULL,
  M90_RL_DEVOL           NUMBER(15,2)               NULL,
  M90_VO_OPRG            NUMBER(15,2)               NULL,
  M90_VO_OPRS            NUMBER(15,2)               NULL,
  M90_VO_OPRA            NUMBER(15,2)               NULL,
  M90_VO_OPRE            NUMBER(15,2)               NULL,
  M90_VO_EIE             NUMBER(15,2)               NULL,
  M90_VO_EXP             NUMBER(15,2)               NULL,
  M90_VO_OE              NUMBER(15,2)               NULL,
  M90_VO_EBI             NUMBER(15,2)               NULL,
  M90_VO_EBIN            NUMBER(15,2)               NULL,
  M90_VO_TOT             NUMBER(15,2)               NULL,
  M90_OE_AIE             NUMBER(15,2)               NULL,
  M90_OE_OSP             NUMBER(15,2)               NULL,
  M90_OE_ONE             NUMBER(15,2)               NULL,
  M90_OE_EBOI            NUMBER(15,2)               NULL,
  M90_OE_EIBS            NUMBER(15,2)               NULL,
  M90_DATMOD             DATE                       NULL,
  M90_USUMOD             VARCHAR2(30 BYTE)          NULL,
  M90_OBS                VARCHAR2(2000 BYTE)        NULL,
  M90_RL_TOTDEVTRA       NUMBER(15,2)               NULL,
  M90_RL_GE_POS          NUMBER(15,2)               NULL,
  M90_RL_GE_NEG          NUMBER(15,2)               NULL,
  M90_RG_IDOIC_BAS       NUMBER(15,2)               NULL,
  M90_RG_IDOIC_CUO       NUMBER(15,2)               NULL,
  M90_RG_IDOIBI_BAS      NUMBER(15,2)               NULL,
  M90_RG_IDOIBI_CUO      NUMBER(15,2)               NULL,
  M90_RG_IDREGUPRORRATA  NUMBER(15,2)               NULL,
  M90_REGDEVMENSUAL      VARCHAR2(1 BYTE)           NULL,
  M90_RG_RO_BAS4         NUMBER(15,2)               NULL,
  M90_RG_RO_PTE4         NUMBER(5,2)                NULL,
  M90_RG_RO_CUO4         NUMBER(15,2)               NULL,
  M90_RG_RO_BAS5         NUMBER(15,2)               NULL,
  M90_RG_RO_PTE5         NUMBER(5,2)                NULL,
  M90_RG_RO_CUO5         NUMBER(15,2)               NULL,
  M90_RG_RB_BAS4         NUMBER(15,2)               NULL,
  M90_RG_RB_PTE4         NUMBER(5,2)                NULL,
  M90_RG_RB_CUO4         NUMBER(15,2)               NULL,
  M90_RG_RB_BAS5         NUMBER(15,2)               NULL,
  M90_RG_RB_PTE5         NUMBER(5,2)                NULL,
  M90_RG_RB_CUO5         NUMBER(15,2)               NULL,
  M90_RG_AV_BAS2         NUMBER(15,2)               NULL,
  M90_RG_AV_CUO2         NUMBER(15,2)               NULL,
  M90_RG_AV_PTE2         NUMBER(5,2)                NULL,
  M90_RG_AI_BAS4         NUMBER(15,2)               NULL,
  M90_RG_AI_PTE4         NUMBER(5,2)                NULL,
  M90_RG_AI_CUO4         NUMBER(15,2)               NULL,
  M90_RG_AI_BAS5         NUMBER(15,2)               NULL,
  M90_RG_AI_PTE5         NUMBER(5,2)                NULL,
  M90_RG_AI_CUO5         NUMBER(15,2)               NULL,
  M90_RG_IDAI_BAS3       NUMBER(15,2)               NULL,
  M90_RG_IDAI_CUO3       NUMBER(15,2)               NULL,
  M90_RG_RE_BAS5         NUMBER(15,2)               NULL,
  M90_RG_RE_PTE5         NUMBER(5,2)                NULL,
  M90_RG_RE_CUO5         NUMBER(15,2)               NULL,
  M90_RG_RE_BAS6         NUMBER(15,2)               NULL,
  M90_RG_RE_PTE6         NUMBER(5,2)                NULL,
  M90_RG_RE_CUO6         NUMBER(15,2)               NULL,
  M90_OE_ISP             NUMBER(15,2)               NULL,
  M90_DECLCONCUR         VARCHAR2(1 BYTE)           NULL,
  M90_CRICXA             VARCHAR2(1 BYTE)           NULL,
  M90_DTICRICXA          VARCHAR2(1 BYTE)           NULL,
  M90_CCSACR             VARCHAR2(1 BYTE)           NULL,
  M90_OE_CRICXAENTBAS    NUMBER(15,2)               NULL,
  M90_OE_CRICXAENTQUO    NUMBER(15,2)               NULL,
  M90_OE_CRICXAADQBAS    NUMBER(15,2)               NULL,
  M90_OE_CRICXAADQQUO    NUMBER(15,2)               NULL,
  M90_RG_IDRECT_BAS      NUMBER(15,2)               NULL,
  M90_VO_CRICXA          NUMBER(15,2)               NULL,
  M90_658                NUMBER(15,2)               NULL,
  M90_659                NUMBER(15,2)               NULL,
  M90_230                NUMBER(15,2)               NULL
)
;


CREATE TABLE TCMP_M90IVADED
(
  I90_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  I90_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  I90_M90_EXC  VARCHAR2(4 BYTE)                     NULL,
  I90_SEQ      NUMBER(2)                            NULL,
  I90_DATCRE   DATE                                 NULL,
  I90_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  I90_001      NUMBER(15,2)                         NULL,
  I90_002      NUMBER(15,2)                         NULL,
  I90_003      NUMBER(15,2)                         NULL,
  I90_004      NUMBER(15,2)                         NULL,
  I90_005      NUMBER(15,2)                         NULL,
  I90_006      NUMBER(15,2)                         NULL,
  I90_007      NUMBER(15,2)                         NULL,
  I90_008      NUMBER(15,2)                         NULL,
  I90_009      NUMBER(15,2)                         NULL,
  I90_010      NUMBER(15,2)                         NULL,
  I90_011      NUMBER(15,2)                         NULL,
  I90_012      NUMBER(15,2)                         NULL,
  I90_013      NUMBER(15,2)                         NULL,
  I90_014      NUMBER(15,2)                         NULL,
  I90_015      NUMBER(15,2)                         NULL,
  I90_016      NUMBER(15,2)                         NULL,
  I90_017      NUMBER(15,2)                         NULL,
  I90_DATMOD   DATE                                 NULL,
  I90_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  I90_018      NUMBER(15,2)                         NULL
)
;


CREATE TABLE TCMP_M90OAG
(
  A90_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  A90_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  A90_M90_EXC  VARCHAR2(4 BYTE)                     NULL,
  A90_SEQ      NUMBER(2)                            NULL,
  A90_DATCRE   DATE                                 NULL,
  A90_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  A90_COD      VARCHAR2(6 BYTE)                     NULL,
  A90_VOLING   NUMBER(15,2)                         NULL,
  A90_INDCUO   NUMBER(15,2)                         NULL,
  A90_CUODEV   NUMBER(15,2)                         NULL,
  A90_CUOSOP   NUMBER(15,2)                         NULL,
  A90_CUODRS   NUMBER(15,2)                         NULL,
  A90_DATMOD   DATE                                 NULL,
  A90_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_M90ORS
(
  R90_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  R90_FIS_COD       VARCHAR2(4 BYTE)                NULL,
  R90_M90_EXC       VARCHAR2(4 BYTE)                NULL,
  R90_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  R90_DATCRE        DATE                            NULL,
  R90_USUCRE        VARCHAR2(30 BYTE)               NULL,
  R90_SEQ           NUMBER(2)                       NULL,
  R90_UNI1          NUMBER(15,2)                    NULL,
  R90_IMP1          NUMBER(15,2)                    NULL,
  R90_UNI2          NUMBER(15,2)                    NULL,
  R90_IMP2          NUMBER(15,2)                    NULL,
  R90_UNI3          NUMBER(15,2)                    NULL,
  R90_IMP3          NUMBER(15,2)                    NULL,
  R90_UNI4          NUMBER(15,2)                    NULL,
  R90_IMP4          NUMBER(15,2)                    NULL,
  R90_UNI5          NUMBER(15,2)                    NULL,
  R90_IMP5          NUMBER(15,2)                    NULL,
  R90_UNI6          NUMBER(15,2)                    NULL,
  R90_IMP6          NUMBER(15,2)                    NULL,
  R90_UNI7          NUMBER(15,2)                    NULL,
  R90_IMP7          NUMBER(15,2)                    NULL,
  R90_CUODOC        NUMBER(15,2)                    NULL,
  R90_CUOSOC        NUMBER(15,2)                    NULL,
  R90_IND           NUMBER(5,2)                     NULL,
  R90_RES           NUMBER(15,2)                    NULL,
  R90_PTECUOMIN     NUMBER(5,2)                     NULL,
  R90_DEVCUO        NUMBER(15,2)                    NULL,
  R90_CUOMIN        NUMBER(15,2)                    NULL,
  R90_CUODRS        NUMBER(15,2)                    NULL,
  R90_DATMOD        DATE                            NULL,
  R90_USUMOD        VARCHAR2(30 BYTE)               NULL
)
;


CREATE TABLE TCMP_M90P
(
  P90_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  P90_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  P90_M90_EXC  VARCHAR2(4 BYTE)                     NULL,
  P90_SEQ      NUMBER(2)                            NULL,
  P90_CNAE     VARCHAR2(3 BYTE)                     NULL,
  P90_DATCRE   DATE                                 NULL,
  P90_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  P90_IMP      NUMBER(15,2)                         NULL,
  P90_IMPDED   NUMBER(15,2)                         NULL,
  P90_TIP      VARCHAR2(1 BYTE)                     NULL,
  P90_PTE      NUMBER(5,2)                          NULL,
  P90_DES      VARCHAR2(512 BYTE)                   NULL,
  P90_DATMOD   DATE                                 NULL,
  P90_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_M90_REPR
(
  E90_CEC_COD      VARCHAR2(4 BYTE)                 NULL,
  E90_FIS_COD      VARCHAR2(4 BYTE)                 NULL,
  E90_EXC          VARCHAR2(4 BYTE)                 NULL,
  E90_REP_NIF      VARCHAR2(12 BYTE)                NULL,
  E90_REP_DATPOD   DATE                             NULL,
  E90_REP_NOTARIA  VARCHAR2(20 BYTE)                NULL,
  E90_REP_VTOCAR   DATE                             NULL,
  E90_USUCRE       VARCHAR2(30 BYTE)                NULL,
  E90_DATCRE       DATE                             NULL,
  E90_NIF_NOMFIS   VARCHAR2(40 BYTE)                NULL
)
;


CREATE TABLE TCMP_MOD110
(
  M110_MON_COD       VARCHAR2(1 BYTE)               NULL,
  M110_CEC_COD       VARCHAR2(4 BYTE)               NULL,
  M110_FIS_COD       VARCHAR2(4 BYTE)               NULL,
  M110_EXC           VARCHAR2(4 BYTE)               NULL,
  M110_PRD           VARCHAR2(2 BYTE)               NULL,
  M110_FECHA         DATE                           NULL,
  M110_RTD_QUA_PERC  NUMBER(15,3)                   NULL,
  M110_RTD_IMP_PERC  NUMBER(15,3)                   NULL,
  M110_RTD_IMP_RET   NUMBER(15,3)                   NULL,
  M110_RTE_QUA_PERC  NUMBER(15,3)                   NULL,
  M110_RTE_IMP_PERC  NUMBER(15,3)                   NULL,
  M110_RTE_IMP_ING   NUMBER(15,3)                   NULL,
  M110_RAD_QUA_PERC  NUMBER(15,3)                   NULL,
  M110_RAD_IMP_PERC  NUMBER(15,3)                   NULL,
  M110_RAD_IMP_RET   NUMBER(15,3)                   NULL,
  M110_RAE_QUA_PERC  NUMBER(15,3)                   NULL,
  M110_RAE_IMP_PERC  NUMBER(15,3)                   NULL,
  M110_RAE_IMP_ING   NUMBER(15,3)                   NULL,
  M110_PPD_QUA_PERC  NUMBER(15,3)                   NULL,
  M110_PPD_IMP_PERC  NUMBER(15,3)                   NULL,
  M110_PPD_IMP_RET   NUMBER(15,3)                   NULL,
  M110_PPE_QUA_PERC  NUMBER(15,3)                   NULL,
  M110_PPE_IMP_PERC  NUMBER(15,3)                   NULL,
  M110_PPE_IMP_ING   NUMBER(15,3)                   NULL,
  M110_CCD_QUA_PERC  NUMBER(15,3)                   NULL,
  M110_CCD_IMP_SAT   NUMBER(15,3)                   NULL,
  M110_CCD_IMP_ING   NUMBER(15,3)                   NULL,
  M110_IMP_LIQ       NUMBER(15,3)                   NULL,
  M110_OFI           VARCHAR2(4 BYTE)               NULL,
  M110_BAN           VARCHAR2(4 BYTE)               NULL,
  M110_FPAEFE        VARCHAR2(1 BYTE)               NULL,
  M110_DCC           VARCHAR2(2 BYTE)               NULL,
  M110_FPAADE        VARCHAR2(1 BYTE)               NULL,
  M110_CCR           VARCHAR2(10 BYTE)              NULL,
  M110_DECL_COMP     VARCHAR2(1 BYTE)               NULL,
  M110_NUMDECLANT    VARCHAR2(13 BYTE)              NULL,
  M110_LOCALIDAD     VARCHAR2(20 BYTE)              NULL,
  M110_DATCRE        DATE                           NULL,
  M110_USUCRE        VARCHAR2(30 BYTE)              NULL,
  M110_DATMOD        DATE                           NULL,
  M110_USUMOD        VARCHAR2(30 BYTE)              NULL,
  M110_RES_ING       NUMBER(15,3)                   NULL,
  M110_RET_ING       NUMBER(15,3)                   NULL,
  M110_IMP_ING       NUMBER(15,3)                   NULL,
  M110_IBNPAI        VARCHAR2(2 BYTE)               NULL,
  M110_IBNDCC        VARCHAR2(2 BYTE)               NULL
)
;


CREATE TABLE TCMP_MOD115
(
  M115_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M115_MON_COD     VARCHAR2(1 BYTE)                 NULL,
  M115_FIS_COD     VARCHAR2(4 BYTE)                 NULL,
  M115_EXC         VARCHAR2(4 BYTE)                 NULL,
  M115_PRD         VARCHAR2(2 BYTE)                 NULL,
  M115_QUA_PERC    NUMBER(6)                        NULL,
  M115_BAS_RET     NUMBER(15,3)                     NULL,
  M115_RET_ING     NUMBER(15,3)                     NULL,
  M115_IMP_LIQ     NUMBER(15,3)                     NULL,
  M115_DECL_COMP   VARCHAR2(1 BYTE)                 NULL,
  M115_NUMDECLANT  VARCHAR2(13 BYTE)                NULL,
  M115_FPAEFE      VARCHAR2(1 BYTE)                 NULL,
  M115_FPAADE      VARCHAR2(1 BYTE)                 NULL,
  M115_BAN         VARCHAR2(4 BYTE)                 NULL,
  M115_OFI         VARCHAR2(4 BYTE)                 NULL,
  M115_DCC         VARCHAR2(2 BYTE)                 NULL,
  M115_CCR         VARCHAR2(10 BYTE)                NULL,
  M115_FECHA       DATE                             NULL,
  M115_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M115_DATCRE      DATE                             NULL,
  M115_USUMOD      VARCHAR2(30 BYTE)                NULL,
  M115_DATMOD      DATE                             NULL,
  M115_RES_ING     NUMBER(15,3)                     NULL,
  M115_IMP_ING     NUMBER(15,3)                     NULL,
  M115_IBNPAI      VARCHAR2(2 BYTE)                 NULL,
  M115_IBNDCC      VARCHAR2(2 BYTE)                 NULL
)
;


CREATE TABLE TCMP_MOD123
(
  M123_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M123_MON_COD     VARCHAR2(1 BYTE)                 NULL,
  M123_FIS_COD     VARCHAR2(4 BYTE)                 NULL,
  M123_EXC         VARCHAR2(4 BYTE)                 NULL,
  M123_PRD         VARCHAR2(2 BYTE)                 NULL,
  M123_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M123_DATCRE      DATE                             NULL,
  M123_QUA_PERC    NUMBER(6)                        NULL,
  M123_BAS_RET     NUMBER(15,3)                     NULL,
  M123_RET_ING     NUMBER(15,3)                     NULL,
  M123_INGANT      NUMBER(15,3)                     NULL,
  M123_REGULA      NUMBER(15,3)                     NULL,
  M123_RES         NUMBER(15,3)                     NULL,
  M123_IMP_ING     NUMBER(15,3)                     NULL,
  M123_FECHA       DATE                             NULL,
  M123_FPAEFE      VARCHAR2(1 BYTE)                 NULL,
  M123_FPAADE      VARCHAR2(1 BYTE)                 NULL,
  M123_BAN         VARCHAR2(4 BYTE)                 NULL,
  M123_OFI         VARCHAR2(4 BYTE)                 NULL,
  M123_DCC         VARCHAR2(2 BYTE)                 NULL,
  M123_CCR         VARCHAR2(10 BYTE)                NULL,
  M123_USUMOD      VARCHAR2(30 BYTE)                NULL,
  M123_DATMOD      DATE                             NULL,
  M123_OBS         VARCHAR2(350 BYTE)               NULL,
  M123_LOCALIDAD   VARCHAR2(16 BYTE)                NULL,
  M123_CODDECLANT  VARCHAR2(16 BYTE)                NULL,
  M123_NUMDECLANT  VARCHAR2(16 BYTE)                NULL,
  M123_RESULTADO   NUMBER(15,3)                     NULL,
  M123_INGDECLANT  NUMBER(15,3)                     NULL,
  M123_IBNPAI      VARCHAR2(2 BYTE)                 NULL,
  M123_IBNDCC      VARCHAR2(2 BYTE)                 NULL
)
;


CREATE TABLE TCMP_MOD130
(
  M130_CEC_COD        VARCHAR2(4 BYTE)              NULL,
  M130_MON_COD        VARCHAR2(1 BYTE)              NULL,
  M130_FIS_COD        VARCHAR2(4 BYTE)              NULL,
  M130_EXC            VARCHAR2(4 BYTE)              NULL,
  M130_PRD            VARCHAR2(1 BYTE)              NULL,
  M130_ECO_ING        NUMBER(15,3)                  NULL,
  M130_ECO_GAS        NUMBER(15,3)                  NULL,
  M130_ECO_PAGANT     NUMBER(15,3)                  NULL,
  M130_ECO_RETING     NUMBER(15,3)                  NULL,
  M130_AGR_ING        NUMBER(15,3)                  NULL,
  M130_AGR_RETING     NUMBER(15,3)                  NULL,
  M130_TOT_PAG        NUMBER(15,3)                  NULL,
  M130_TOT_DEDUC      NUMBER(15,3)                  NULL,
  M130_IMP_ING        NUMBER(15,3)                  NULL,
  M130_FPAEFE         VARCHAR2(1 BYTE)              NULL,
  M130_FPAADE         VARCHAR2(1 BYTE)              NULL,
  M130_BAN            VARCHAR2(4 BYTE)              NULL,
  M130_DECL_COMP      CHAR(1 BYTE)                  NULL,
  M130_NUMDECLANT     VARCHAR2(13 BYTE)             NULL,
  M130_LOCALIDAD      VARCHAR2(16 BYTE)             NULL,
  M130_OFI            VARCHAR2(4 BYTE)              NULL,
  M130_DCC            VARCHAR2(2 BYTE)              NULL,
  M130_CCR            VARCHAR2(10 BYTE)             NULL,
  M130_FECHA          DATE                          NULL,
  M130_USUCRE         VARCHAR2(30 BYTE)             NULL,
  M130_DATCRE         DATE                          NULL,
  M130_USUMOD         VARCHAR2(30 BYTE)             NULL,
  M130_DATMOD         DATE                          NULL,
  M130_ECO_REND       NUMBER(15,3)                  NULL,
  M130_ECO_PCTREND    NUMBER(15,3)                  NULL,
  M130_ECO_PAGFRA     NUMBER(15,3)                  NULL,
  M130_AGR_PCTING     NUMBER(15,3)                  NULL,
  M130_AGR_PAGFRA     NUMBER(15,3)                  NULL,
  M130_TOT_ING        NUMBER(15,3)                  NULL,
  M130_TOT_MINORADED  NUMBER(15,3)                  NULL,
  M130_TOT_DEDUC001   NUMBER(15,3)                  NULL,
  M130_DEDSEGPAG      VARCHAR2(1 BYTE)              NULL,
  M130_TOT_DEDUC002   NUMBER(15,3)                  NULL,
  M130_IBNPAI         VARCHAR2(2 BYTE)              NULL,
  M130_IBNDCC         VARCHAR2(2 BYTE)              NULL
)
;


CREATE TABLE TCMP_MOD131
(
  M131_MON_COD       VARCHAR2(1 BYTE)               NULL,
  M131_CEC_COD       VARCHAR2(4 BYTE)               NULL,
  M131_FIS_COD       VARCHAR2(4 BYTE)               NULL,
  M131_EXC           VARCHAR2(4 BYTE)               NULL,
  M131_PRD           VARCHAR2(1 BYTE)               NULL,
  M131_ECO_ACT1      VARCHAR2(4 BYTE)               NULL,
  M131_ECO_REND1     NUMBER(15,3)                   NULL,
  M131_ECO_PCT1      NUMBER(15,3)                   NULL,
  M131_ECO_ACT2      VARCHAR2(4 BYTE)               NULL,
  M131_ECO_REND2     NUMBER(15,3)                   NULL,
  M131_ECO_PCT2      NUMBER(15,3)                   NULL,
  M131_ECO_ACT3      VARCHAR2(4 BYTE)               NULL,
  M131_ECO_REND3     NUMBER(15,3)                   NULL,
  M131_ECO_PCT3      NUMBER(15,3)                   NULL,
  M131_ECO_ACT4      VARCHAR2(4 BYTE)               NULL,
  M131_ECO_REND4     NUMBER(15,3)                   NULL,
  M131_ECO_PCT4      NUMBER(15,3)                   NULL,
  M131_ECO_ACT5      VARCHAR2(4 BYTE)               NULL,
  M131_ECO_REND5     NUMBER(15,3)                   NULL,
  M131_ECO_PCT5      NUMBER(15,3)                   NULL,
  M131_ECO_RETING    NUMBER(13,3)                   NULL,
  M131_AGR_ING       NUMBER(15,3)                   NULL,
  M131_AGR_RETING    NUMBER(15,3)                   NULL,
  M131_TOT_DEDUC     NUMBER(15,3)                   NULL,
  M131_TOT_PAG       NUMBER(15,3)                   NULL,
  M131_TOT_ING       NUMBER(15,3)                   NULL,
  M131_IMP_ING       NUMBER(15,3)                   NULL,
  M131_FPAEFE        VARCHAR2(1 BYTE)               NULL,
  M131_FPAADE        VARCHAR2(1 BYTE)               NULL,
  M131_BAN_ING       VARCHAR2(4 BYTE)               NULL,
  M131_OFI_ING       VARCHAR2(4 BYTE)               NULL,
  M131_DCC_ING       VARCHAR2(2 BYTE)               NULL,
  M131_CCR_ING       VARCHAR2(10 BYTE)              NULL,
  M131_DOM_PAG       VARCHAR2(1 BYTE)               NULL,
  M131_DECL_COMP     VARCHAR2(1 BYTE)               NULL,
  M131_NUMDECLANT    VARCHAR2(13 BYTE)              NULL,
  M131_BAN_DOM       VARCHAR2(4 BYTE)               NULL,
  M131_OFI_DOM       VARCHAR2(4 BYTE)               NULL,
  M131_DCC_DOM       VARCHAR2(2 BYTE)               NULL,
  M131_CCR_DOM       VARCHAR2(10 BYTE)              NULL,
  M131_LOCALIDAD     VARCHAR2(20 BYTE)              NULL,
  M131_FECHA         DATE                           NULL,
  M131_USUCRE        VARCHAR2(30 BYTE)              NULL,
  M131_DATCRE        DATE                           NULL,
  M131_USUMOD        VARCHAR2(30 BYTE)              NULL,
  M131_DATMOD        DATE                           NULL,
  M131_ECO_RES1      NUMBER(15,3)                   NULL,
  M131_ECO_RES2      NUMBER(15,3)                   NULL,
  M131_ECO_RES3      NUMBER(15,3)                   NULL,
  M131_ECO_RES4      NUMBER(15,3)                   NULL,
  M131_ECO_RES5      NUMBER(15,3)                   NULL,
  M131_ECO_TOTRES    NUMBER(15,3)                   NULL,
  M131_ECO_PAG       NUMBER(15,3)                   NULL,
  M131_AGR_PCTING    NUMBER(15,3)                   NULL,
  M131_AGR_PAG       NUMBER(15,3)                   NULL,
  M131_DECL_NEG      VARCHAR2(1 BYTE)               NULL,
  M131_DEDUCIR       VARCHAR2(1 BYTE)               NULL,
  M131_MINORADED     NUMBER(15,3)                   NULL,
  M131_SUM_ECO_REND  NUMBER(15,3)                   NULL,
  M131_TOT_PRESTAMO  NUMBER(15,3)                   NULL,
  M131_IBNPAI_ING    VARCHAR2(2 BYTE)               NULL,
  M131_IBNDCC_ING    VARCHAR2(2 BYTE)               NULL
)
;


CREATE TABLE TCMP_MOD180_R1
(
  M81_EXC         VARCHAR2(4 BYTE)                  NULL,
  M81_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  M81_FIS_COD     VARCHAR2(4 BYTE)                  NULL,
  M81_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  M81_NUMDECL     VARCHAR2(13 BYTE)                 NULL,
  M81_DECL_COMP   VARCHAR2(1 BYTE)                  NULL,
  M81_DECL_SUST   VARCHAR2(1 BYTE)                  NULL,
  M81_NUMDECLANT  VARCHAR2(13 BYTE)                 NULL,
  M81_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  M81_DATCRE      DATE                              NULL,
  M81_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  M81_DATMOD      DATE                              NULL,
  M81_FECHA       DATE                              NULL
)
;


CREATE TABLE TCMP_MOD180_R2
(
  M82_EXC          VARCHAR2(4 BYTE)                 NULL,
  M82_CEC_COD      VARCHAR2(4 BYTE)                 NULL,
  M82_FIS_COD      VARCHAR2(4 BYTE)                 NULL,
  M82_SEQ          NUMBER                           NULL,
  M82_NIF_PERC     VARCHAR2(13 BYTE)                NULL,
  M82_NIF_REPR     VARCHAR2(13 BYTE)                NULL,
  M82_NOM_PERC     VARCHAR2(40 BYTE)                NULL,
  M82_PROVINCIA    VARCHAR2(2 BYTE)                 NULL,
  M82_MODALIDAD    VARCHAR2(1 BYTE)                 NULL,
  M82_PCTRET       CHAR(4 BYTE)                     NULL,
  M82_BAS_RETING1  NUMBER(15,3)                     NULL,
  M82_RETING1      NUMBER(15,3)                     NULL,
  M82_BAS_RETING2  NUMBER(15,3)                     NULL,
  M82_RETING2      NUMBER(15,3)                     NULL,
  M82_BAS_RETING3  NUMBER(15,3)                     NULL,
  M82_RETING3      NUMBER(15,3)                     NULL,
  M82_BAS_RETING4  NUMBER(15,3)                     NULL,
  M82_RETING4      NUMBER(15,3)                     NULL,
  M82_EXC_DEV      VARCHAR2(4 BYTE)                 NULL,
  M82_USUCRE       VARCHAR2(30 BYTE)                NULL,
  M82_DATCRE       DATE                             NULL,
  M82_USUMOD       VARCHAR2(30 BYTE)                NULL,
  M82_DATMOD       DATE                             NULL,
  M82_SITINM       VARCHAR2(1 BYTE)                 NULL,
  M82_CAD          VARCHAR2(25 BYTE)                NULL,
  M82_SGL          VARCHAR2(5 BYTE)                 NULL,
  M82_DOM          VARCHAR2(50 BYTE)                NULL,
  M82_TIPNUM       VARCHAR2(3 BYTE)                 NULL,
  M82_NUM          NUMBER(5)                        NULL,
  M82_CALNUM       VARCHAR2(3 BYTE)                 NULL,
  M82_BLC          VARCHAR2(3 BYTE)                 NULL,
  M82_POR          VARCHAR2(3 BYTE)                 NULL,
  M82_ESC          VARCHAR2(3 BYTE)                 NULL,
  M82_PIS          VARCHAR2(3 BYTE)                 NULL,
  M82_PTA          VARCHAR2(3 BYTE)                 NULL,
  M82_CPL          VARCHAR2(40 BYTE)                NULL,
  M82_POB          VARCHAR2(30 BYTE)                NULL,
  M82_MUN          VARCHAR2(30 BYTE)                NULL,
  M82_CODMUN       VARCHAR2(5 BYTE)                 NULL,
  M82_PRV          VARCHAR2(2 BYTE)                 NULL,
  M82_CPO          VARCHAR2(5 BYTE)                 NULL
)
;


CREATE TABLE TCMP_MOD180_R3
(
  M83_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  M83_FIS_COD     VARCHAR2(4 BYTE)                  NULL,
  M83_EXC         VARCHAR2(4 BYTE)                  NULL,
  M83_M82_SEQ     NUMBER                            NULL,
  M83_MES         NUMBER(2)                         NULL,
  M83_BAS_RETING  NUMBER(15,2)                  DEFAULT 0                         NULL,
  M83_RETING      NUMBER(15,2)                  DEFAULT 0                         NULL,
  M83_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  M83_DATCRE      DATE                              NULL,
  M83_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  M83_DATMOD      DATE                              NULL
)
;


CREATE TABLE TCMP_MOD190_R1
(
  M91_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  M91_FIS_COD     VARCHAR2(4 BYTE)                  NULL,
  M91_EXC         VARCHAR2(4 BYTE)                  NULL,
  M91_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  M91_DECL_SUST   VARCHAR2(1 BYTE)                  NULL,
  M91_DECL_COMP   VARCHAR2(1 BYTE)                  NULL,
  M91_NUMDECL     VARCHAR2(13 BYTE)                 NULL,
  M91_NUMDECLANT  VARCHAR2(13 BYTE)                 NULL,
  M91_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  M91_DATMOD      DATE                              NULL,
  M91_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  M91_DATCRE      DATE                              NULL,
  M91_FECHA       DATE                              NULL
)
;


CREATE TABLE TCMP_MOD190_R2
(
  M92_CEC_COD          VARCHAR2(4 BYTE)             NULL,
  M92_FIS_COD          VARCHAR2(4 BYTE)             NULL,
  M92_EXC              VARCHAR2(4 BYTE)             NULL,
  M92_SEQ              NUMBER                       NULL,
  M92_NIF_PERC         VARCHAR2(9 BYTE)             NULL,
  M92_NIF_REPR         VARCHAR2(9 BYTE)             NULL,
  M92_NOM_PERC         VARCHAR2(40 BYTE)            NULL,
  M92_PROVINCIA        VARCHAR2(2 BYTE)             NULL,
  M92_CLAVE            VARCHAR2(1 BYTE)             NULL,
  M92_SUBCLAVE         VARCHAR2(2 BYTE)             NULL,
  M92_DIN_PERC1        NUMBER(13,2)                 NULL,
  M92_DIN_PERC2        NUMBER(13,2)                 NULL,
  M92_ESP_INGEFE2      NUMBER(13,2)                 NULL,
  M92_ESP_INGEFE3      NUMBER(13,2)                 NULL,
  M92_ESP_INGEFE4      NUMBER(13,2)                 NULL,
  M92_ESP_VAL2         NUMBER(13,2)                 NULL,
  M92_ESP_VAL3         NUMBER(13,2)                 NULL,
  M92_ESP_VAL4         NUMBER(13,2)                 NULL,
  M92_DIN_RET2         NUMBER(13,2)                 NULL,
  M92_DIN_RET3         NUMBER(13,2)                 NULL,
  M92_DIN_RET4         NUMBER(13,2)                 NULL,
  M92_DIN_PERC3        NUMBER(13,2)                 NULL,
  M92_DIN_PERC4        NUMBER(13,2)                 NULL,
  M92_DIN_RET1         NUMBER(13,2)                 NULL,
  M92_ESP_VAL1         NUMBER(13,2)                 NULL,
  M92_ESP_INGEFE1      NUMBER(13,2)                 NULL,
  M92_ESP_INGREP       NUMBER(13,2)                 NULL,
  M92_EXC_DEV          VARCHAR2(4 BYTE)             NULL,
  M92_CEUTA            VARCHAR2(1 BYTE)             NULL,
  M92_TIP_CTR          VARCHAR2(1 BYTE)             NULL,
  M92_ANY              VARCHAR2(4 BYTE)             NULL,
  M92_DISCAP           VARCHAR2(1 BYTE)             NULL,
  M92_SIT_FAM          VARCHAR2(1 BYTE)             NULL,
  M92_NIF_CONY         VARCHAR2(9 BYTE)             NULL,
  M92_QUA_DESC0_3      INTEGER                      NULL,
  M92_QUA_DESC3_16     INTEGER                      NULL,
  M92_QUA_DESC16_25    INTEGER                      NULL,
  M92_QUA_DISC_33PCT   INTEGER                      NULL,
  M92_QUA_DISC_65PCT   INTEGER                      NULL,
  M92_TOT_DESC         INTEGER                      NULL,
  M92_REDUC            NUMBER(13,2)                 NULL,
  M92_GASTOS           NUMBER(13,2)                 NULL,
  M92_PENSION          NUMBER(13,2)                 NULL,
  M92_ALIMENTOS        NUMBER(13,2)                 NULL,
  M92_DESC_ENT         NUMBER(2)                    NULL,
  M92_ASC_ENT          NUMBER(1)                    NULL,
  M92_ASC_TOT          NUMBER(1)                    NULL,
  M92_ASC_33PCT        NUMBER(1)                    NULL,
  M92_ASC_65PCT        NUMBER(1)                    NULL,
  M92_USUCRE           VARCHAR2(30 BYTE)            NULL,
  M92_DATCRE           DATE                         NULL,
  M92_USUMOD           VARCHAR2(30 BYTE)            NULL,
  M92_DATMOD           DATE                         NULL,
  M92_MOVGEO           VARCHAR2(1 BYTE)             NULL,
  M92_ACTLAB           VARCHAR2(1 BYTE)             NULL,
  M92_DESC_3ENT        NUMBER(1)                    NULL,
  M92_DESC_REST        NUMBER(2)                    NULL,
  M92_DESC_RESTENT     NUMBER(2)                    NULL,
  M92_DISC_33ENT       NUMBER(2)                    NULL,
  M92_DISC_RED         NUMBER(2)                    NULL,
  M92_DISC_REDENT      NUMBER(2)                    NULL,
  M92_DISC_M65ENT      NUMBER(2)                    NULL,
  M92_ASC_75           NUMBER(1)                    NULL,
  M92_ASC_M75          NUMBER(1)                    NULL,
  M92_ASC_M75ENT       NUMBER(1)                    NULL,
  M92_ASCDISC_3365ENT  NUMBER(1)                    NULL,
  M92_ASCDISC_RED      NUMBER(1)                    NULL,
  M92_ASCDISC_REDENT   NUMBER(1)                    NULL,
  M92_ASCDISC_M65ENT   NUMBER(1)                    NULL,
  M92_COMPUTOHIJO1     VARCHAR2(1 BYTE)             NULL,
  M92_COMPUTOHIJO2     VARCHAR2(1 BYTE)             NULL,
  M92_COMPUTOHIJO3     VARCHAR2(1 BYTE)             NULL,
  M92_CMUPREVIVHAB     VARCHAR2(1 BYTE)             NULL
)
;


CREATE TABLE TCMP_MOD193
(
  M193_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M193_MON_COD     VARCHAR2(1 BYTE)                 NULL,
  M193_FIS_COD     VARCHAR2(4 BYTE)                 NULL,
  M193_EXC         VARCHAR2(4 BYTE)                 NULL,
  M193_DECL_COMP   VARCHAR2(1 BYTE)                 NULL,
  M193_DECL_SUST   VARCHAR2(1 BYTE)                 NULL,
  M193_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M193_DATCRE      DATE                             NULL,
  M193_USUMOD      VARCHAR2(30 BYTE)                NULL,
  M193_DATMOD      DATE                             NULL,
  M193_QUA_PERC    NUMBER(6)                        NULL,
  M193_BASRET      NUMBER(15,3)                     NULL,
  M193_RET_ING     NUMBER(15,3)                     NULL,
  M193_INGCTA      NUMBER(15,3)                     NULL,
  M193_INGANT      NUMBER(15,3)                     NULL,
  M193_INGCTA002   NUMBER(15,3)                     NULL,
  M193_IMPGTO      NUMBER(15,3)                     NULL,
  M193_FECHA       DATE                             NULL,
  M193_NUMDECLANT  VARCHAR2(13 BYTE)                NULL
)
;


CREATE TABLE TCMP_MOD193_GTO
(
  M193G_CEC_COD   VARCHAR2(4 BYTE)                  NULL,
  M193G_FIS_COD   VARCHAR2(4 BYTE)                  NULL,
  M193G_EXC       VARCHAR2(4 BYTE)                  NULL,
  M193G_SEQ       NUMBER                            NULL,
  M193G_USUCRE    VARCHAR2(30 BYTE)                 NULL,
  M193G_DATCRE    DATE                              NULL,
  M193G_NIF       VARCHAR2(13 BYTE)                 NULL,
  M193G_NIF_REPR  VARCHAR2(13 BYTE)                 NULL,
  M193G_NOM       VARCHAR2(40 BYTE)                 NULL,
  M193G_IMP       NUMBER(15,3)                      NULL,
  M193G_USUMOD    VARCHAR2(30 BYTE)                 NULL,
  M193G_DATMOD    DATE                              NULL
)
;


CREATE TABLE TCMP_MOD193_PERC
(
  M193P_EXC             VARCHAR2(4 BYTE)            NULL,
  M193P_CEC_COD         VARCHAR2(4 BYTE)            NULL,
  M193P_FIS_COD         VARCHAR2(4 BYTE)            NULL,
  M193P_SEQ             NUMBER                      NULL,
  M193P_USUCRE          VARCHAR2(30 BYTE)           NULL,
  M193P_DATCRE          DATE                        NULL,
  M193P_NIF_PERC        VARCHAR2(13 BYTE)           NULL,
  M193P_NIF_REPR        VARCHAR2(13 BYTE)           NULL,
  M193P_NOM_PERC        VARCHAR2(40 BYTE)           NULL,
  M193P_MEDIADOR        VARCHAR2(1 BYTE)            NULL,
  M193P_PROVINCIA       VARCHAR2(2 BYTE)            NULL,
  M193P_CLAVECOD        VARCHAR2(1 BYTE)            NULL,
  M193P_EMISOR          VARCHAR2(12 BYTE)           NULL,
  M193P_CLAVEPERC       VARCHAR2(1 BYTE)            NULL,
  M193P_NATURALEZA      VARCHAR2(2 BYTE)            NULL,
  M193P_PAGO            VARCHAR2(1 BYTE)            NULL,
  M193P_TIPCOD          VARCHAR2(1 BYTE)            NULL,
  M193P_CCC             VARCHAR2(20 BYTE)           NULL,
  M193P_PDTE            VARCHAR2(1 BYTE)            NULL,
  M193P_EXC_DEV         VARCHAR2(4 BYTE)            NULL,
  M193P_TIPPERC         VARCHAR2(1 BYTE)            NULL,
  M193P_PERCEPCION      NUMBER(15,3)                NULL,
  M193P_PTEMULT         NUMBER(3)                   NULL,
  M193P_REDUCCION       NUMBER(15,3)                NULL,
  M193P_BAS             NUMBER(15,3)                NULL,
  M193P_PTERET          NUMBER(4,2)                 NULL,
  M193P_RET             NUMBER(15,3)                NULL,
  M193P_INGANT          NUMBER(15,3)                NULL,
  M193P_NATURADECL      VARCHAR2(1 BYTE)            NULL,
  M193P_DATINIPRESTAMO  DATE                        NULL,
  M193P_DATFINPRESTAMO  DATE                        NULL,
  M193P_COMPENSACIONES  NUMBER(15,3)                NULL,
  M193P_GARANTIAS       NUMBER(15,3)                NULL,
  M193P_USUMOD          VARCHAR2(30 BYTE)           NULL,
  M193P_DATMOD          DATE                        NULL
)
;


CREATE TABLE TCMP_MOD201
(
  M201_NUM         NUMBER                           NULL,
  M201_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M201_FIS_COD     VARCHAR2(4 BYTE)                 NULL,
  M201_EXC         VARCHAR2(4 BYTE)                 NULL,
  M201_PRD         VARCHAR2(2 BYTE)                 NULL,
  M201_DATCRE      DATE                             NULL,
  M201_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M201_DATMOD      DATE                             NULL,
  M201_USUMOD      VARCHAR2(30 BYTE)                NULL,
  M201_MON_COD     VARCHAR2(1 BYTE)                 NULL,
  M201_DECL_COMP   NUMBER(1)                        NULL,
  M201_NUMDECLANT  VARCHAR2(13 BYTE)                NULL,
  M201_DAT_IRNR    DATE                             NULL,
  M201_LOC_REPR    VARCHAR2(16 BYTE)                NULL,
  M201_DAT_REPR    DATE                             NULL,
  M201_BASIMP      NUMBER(15,2)                     NULL,
  M201_RENDEV      NUMBER(1)                        NULL,
  M201_DEVTRA      NUMBER(1)                        NULL,
  M201_BANDEV      VARCHAR2(4 BYTE)                 NULL,
  M201_OFIDEV      VARCHAR2(4 BYTE)                 NULL,
  M201_DCCDEV      VARCHAR2(2 BYTE)                 NULL,
  M201_CCRDEV      VARCHAR2(10 BYTE)                NULL,
  M201_FPAEFE      NUMBER(1)                        NULL,
  M201_FPAADE      NUMBER(1)                        NULL,
  M201_IMPING      NUMBER(15,2)                     NULL,
  M201_BANING      VARCHAR2(4 BYTE)                 NULL,
  M201_OFIING      VARCHAR2(4 BYTE)                 NULL,
  M201_DCCING      VARCHAR2(2 BYTE)                 NULL,
  M201_CCRING      VARCHAR2(10 BYTE)                NULL,
  M201_DAT_DECL    DATE                             NULL,
  M201_CUOTACERO   NUMBER(1)                        NULL,
  M201_LOC_DECL    VARCHAR2(25 BYTE)                NULL,
  M201_IMPDEV      NUMBER(15,3)                     NULL,
  M201_DATINI      DATE                             NULL,
  M201_DATFIN      DATE                             NULL,
  M201_BASBONIF    NUMBER                           NULL,
  M201_BASDEDUC    NUMBER                           NULL,
  M201_NOTRIB      NUMBER                           NULL,
  M201_TRIB        NUMBER                           NULL,
  M201_C1          NUMBER(15,2)                     NULL,
  M201_E1          NUMBER(15,2)                     NULL,
  M201_C2          NUMBER(15,2)                     NULL,
  M201_E2          NUMBER(15,2)                     NULL,
  M201_C3          NUMBER(15,2)                     NULL,
  M201_E3          NUMBER(15,2)                     NULL,
  M201_E4          NUMBER(15,2)                     NULL,
  M201_C5          NUMBER(15,2)                     NULL,
  M201_E5          NUMBER(15,2)                     NULL,
  M201_C6          NUMBER(15,2)                     NULL,
  M201_E6          NUMBER(15,2)                     NULL,
  M201_C7          NUMBER(15,2)                     NULL,
  M201_E7          NUMBER(15,2)                     NULL,
  M201_C8          NUMBER(15,2)                     NULL,
  M201_E8          NUMBER(15,2)                     NULL,
  M201_C9          NUMBER(15,2)                     NULL,
  M201_C10         NUMBER(15,2)                     NULL,
  M201_E10         NUMBER(15,2)                     NULL,
  M201_TRANIF      VARCHAR2(9 BYTE)                 NULL,
  M201_TRADEN      VARCHAR2(40 BYTE)                NULL,
  M201_ADQNIF      VARCHAR2(9 BYTE)                 NULL,
  M201_ADQDEN      VARCHAR2(40 BYTE)                NULL,
  M201_DATACU      DATE                             NULL,
  M201_ENTNIF1     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF2     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF3     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF4     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF5     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF6     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF7     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF8     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF9     VARCHAR2(20 BYTE)                NULL,
  M201_ENTNIF10    VARCHAR2(9 BYTE)                 NULL,
  M201_ESPNIF1     VARCHAR2(9 BYTE)                 NULL,
  M201_ESPNIF2     VARCHAR2(9 BYTE)                 NULL,
  M201_ESPNIF3     VARCHAR2(9 BYTE)                 NULL,
  M201_ESPNIF4     VARCHAR2(9 BYTE)                 NULL,
  M201_ESPNIF5     VARCHAR2(9 BYTE)                 NULL,
  M201_TIPOPE      VARCHAR2(1 BYTE)                 NULL,
  M201_PTEENT      NUMBER(15,2)                     NULL,
  M201_PTESIT      NUMBER(15,2)                     NULL,
  M201_QUAESTAB    NUMBER(10)                       NULL,
  M201_001         NUMBER                           NULL,
  M201_002         NUMBER                           NULL,
  M201_003         NUMBER                           NULL,
  M201_004         NUMBER                           NULL,
  M201_005         NUMBER                           NULL,
  M201_006         NUMBER                           NULL,
  M201_011         NUMBER                           NULL,
  M201_013         NUMBER                           NULL,
  M201_014         NUMBER                           NULL,
  M201_015         NUMBER                           NULL,
  M201_016         NUMBER                           NULL,
  M201_017         NUMBER                           NULL,
  M201_018         NUMBER                           NULL,
  M201_019         NUMBER                           NULL,
  M201_020         NUMBER                           NULL,
  M201_021         NUMBER                           NULL,
  M201_026         NUMBER                           NULL,
  M201_027         NUMBER                           NULL,
  M201_028         NUMBER                           NULL,
  M201_029         NUMBER                           NULL,
  M201_030         NUMBER                           NULL,
  M201_031         NUMBER                           NULL,
  M201_032         NUMBER                           NULL,
  M201_033         NUMBER                           NULL,
  M201_034         NUMBER                           NULL,
  M201_035         NUMBER                           NULL,
  M201_037         NUMBER                           NULL,
  M201_038         NUMBER                           NULL,
  M201_039         NUMBER                           NULL,
  M201_041         NUMBER                           NULL,
  M201_042         NUMBER                           NULL,
  M201_043         NUMBER                           NULL,
  M201_044         NUMBER                           NULL,
  M201_045         NUMBER                           NULL,
  M201_048         NUMBER                           NULL,
  M201_050         NUMBER                           NULL,
  M201_051         NUMBER                           NULL,
  M201_052         NUMBER                           NULL,
  M201_053         NUMBER                           NULL,
  M201_054         NUMBER                           NULL,
  M201_055         NUMBER                           NULL,
  M201_056         NUMBER                           NULL,
  M201_060         NUMBER                           NULL,
  M201_061         NUMBER                           NULL,
  M201_062         NUMBER                           NULL,
  M201_063         NUMBER                           NULL,
  M201_064         NUMBER                           NULL,
  M201_065         NUMBER                           NULL,
  M201_066         NUMBER                           NULL,
  M201_072         NUMBER                           NULL,
  M201_073         NUMBER                           NULL,
  M201_074         NUMBER                           NULL,
  M201_075         NUMBER                           NULL,
  M201_076         NUMBER                           NULL,
  M201_077         NUMBER                           NULL,
  M201_078         NUMBER                           NULL,
  M201_079         NUMBER                           NULL,
  M201_080         NUMBER                           NULL,
  M201_081         NUMBER                           NULL,
  M201_082         NUMBER                           NULL,
  M201_083         NUMBER                           NULL,
  M201_084         NUMBER                           NULL,
  M201_085         NUMBER                           NULL,
  M201_086         NUMBER                           NULL,
  M201_087         NUMBER                           NULL,
  M201_088         NUMBER                           NULL,
  M201_089         NUMBER                           NULL,
  M201_090         NUMBER                           NULL,
  M201_091         NUMBER                           NULL,
  M201_092         NUMBER                           NULL,
  M201_094         NUMBER                           NULL,
  M201_095         NUMBER                           NULL,
  M201_096         NUMBER                           NULL,
  M201_097         NUMBER                           NULL,
  M201_098         NUMBER                           NULL,
  M201_101         NUMBER                           NULL,
  M201_102         NUMBER                           NULL,
  M201_114         NUMBER                           NULL,
  M201_134         NUMBER                           NULL,
  M201_154         NUMBER                           NULL,
  M201_155         NUMBER                           NULL,
  M201_156         NUMBER                           NULL,
  M201_157         NUMBER                           NULL,
  M201_158         NUMBER                           NULL,
  M201_166         NUMBER                           NULL,
  M201_175         NUMBER                           NULL,
  M201_184         NUMBER                           NULL,
  M201_185         NUMBER                           NULL,
  M201_186         NUMBER                           NULL,
  M201_188         NUMBER                           NULL,
  M201_189         NUMBER                           NULL,
  M201_190         NUMBER                           NULL,
  M201_191         NUMBER                           NULL,
  M201_192         NUMBER                           NULL,
  M201_193         NUMBER                           NULL,
  M201_194         NUMBER                           NULL,
  M201_195         NUMBER                           NULL,
  M201_196         NUMBER                           NULL,
  M201_197         NUMBER                           NULL,
  M201_198         NUMBER                           NULL,
  M201_201         NUMBER                           NULL,
  M201_202         NUMBER                           NULL,
  M201_203         NUMBER                           NULL,
  M201_204         NUMBER                           NULL,
  M201_210         NUMBER                           NULL,
  M201_214         NUMBER                           NULL,
  M201_215         NUMBER                           NULL,
  M201_216         NUMBER                           NULL,
  M201_217         NUMBER                           NULL,
  M201_218         NUMBER                           NULL,
  M201_220         NUMBER                           NULL,
  M201_225         NUMBER                           NULL,
  M201_231         NUMBER                           NULL,
  M201_248         NUMBER                           NULL,
  M201_271         NUMBER                           NULL,
  M201_272         NUMBER                           NULL,
  M201_273         NUMBER                           NULL,
  M201_274         NUMBER                           NULL,
  M201_275         NUMBER                           NULL,
  M201_276         NUMBER                           NULL,
  M201_277         NUMBER                           NULL,
  M201_278         NUMBER                           NULL,
  M201_279         NUMBER                           NULL,
  M201_280         NUMBER                           NULL,
  M201_281         NUMBER                           NULL,
  M201_282         NUMBER                           NULL,
  M201_283         NUMBER                           NULL,
  M201_284         NUMBER                           NULL,
  M201_285         NUMBER                           NULL,
  M201_286         NUMBER                           NULL,
  M201_287         NUMBER                           NULL,
  M201_288         NUMBER                           NULL,
  M201_289         NUMBER                           NULL,
  M201_290         NUMBER                           NULL,
  M201_291         NUMBER                           NULL,
  M201_292         NUMBER                           NULL,
  M201_293         NUMBER                           NULL,
  M201_294         NUMBER                           NULL,
  M201_295         NUMBER                           NULL,
  M201_296         NUMBER                           NULL,
  M201_297         NUMBER                           NULL,
  M201_298         NUMBER                           NULL,
  M201_299         NUMBER                           NULL,
  M201_306         NUMBER                           NULL,
  M201_312         NUMBER                           NULL,
  M201_313         NUMBER                           NULL,
  M201_314         NUMBER                           NULL,
  M201_320         NUMBER                           NULL,
  M201_326         NUMBER                           NULL,
  M201_333         NUMBER                           NULL,
  M201_340         NUMBER                           NULL,
  M201_341         NUMBER                           NULL,
  M201_342         NUMBER                           NULL,
  M201_343         NUMBER                           NULL,
  M201_344         NUMBER                           NULL,
  M201_345         NUMBER                           NULL,
  M201_346         NUMBER                           NULL,
  M201_347         NUMBER                           NULL,
  M201_348         NUMBER                           NULL,
  M201_349         NUMBER                           NULL,
  M201_350         NUMBER                           NULL,
  M201_351         NUMBER                           NULL,
  M201_402         NUMBER                           NULL,
  M201_405         NUMBER                           NULL,
  M201_414         NUMBER                           NULL,
  M201_415         NUMBER                           NULL,
  M201_420         NUMBER                           NULL,
  M201_421         NUMBER                           NULL,
  M201_426         NUMBER                           NULL,
  M201_427         NUMBER                           NULL,
  M201_433         NUMBER                           NULL,
  M201_434         NUMBER                           NULL,
  M201_435         NUMBER                           NULL,
  M201_436         NUMBER                           NULL,
  M201_437         NUMBER                           NULL,
  M201_438         NUMBER                           NULL,
  M201_439         NUMBER                           NULL,
  M201_440         NUMBER                           NULL,
  M201_441         NUMBER                           NULL,
  M201_442         NUMBER                           NULL,
  M201_443         NUMBER                           NULL,
  M201_444         NUMBER                           NULL,
  M201_445         NUMBER                           NULL,
  M201_446         NUMBER                           NULL,
  M201_447         NUMBER                           NULL,
  M201_448         NUMBER                           NULL,
  M201_449         NUMBER                           NULL,
  M201_450         NUMBER                           NULL,
  M201_451         NUMBER                           NULL,
  M201_452         NUMBER                           NULL,
  M201_453         NUMBER                           NULL,
  M201_454         NUMBER                           NULL,
  M201_455         NUMBER                           NULL,
  M201_456         NUMBER                           NULL,
  M201_457         NUMBER                           NULL,
  M201_458         NUMBER                           NULL,
  M201_459         NUMBER                           NULL,
  M201_460         NUMBER                           NULL,
  M201_461         NUMBER                           NULL,
  M201_462         NUMBER                           NULL,
  M201_463         NUMBER                           NULL,
  M201_464         NUMBER                           NULL,
  M201_465         NUMBER                           NULL,
  M201_466         NUMBER                           NULL,
  M201_467         NUMBER                           NULL,
  M201_468         NUMBER                           NULL,
  M201_469         NUMBER                           NULL,
  M201_470         NUMBER                           NULL,
  M201_471         NUMBER                           NULL,
  M201_472         NUMBER                           NULL,
  M201_473         NUMBER                           NULL,
  M201_474         NUMBER                           NULL,
  M201_475         NUMBER                           NULL,
  M201_476         NUMBER                           NULL,
  M201_477         NUMBER                           NULL,
  M201_478         NUMBER                           NULL,
  M201_479         NUMBER                           NULL,
  M201_480         NUMBER                           NULL,
  M201_481         NUMBER                           NULL,
  M201_482         NUMBER                           NULL,
  M201_483         NUMBER                           NULL,
  M201_484         NUMBER                           NULL,
  M201_485         NUMBER                           NULL,
  M201_486         NUMBER                           NULL,
  M201_487         NUMBER                           NULL,
  M201_488         NUMBER                           NULL,
  M201_489         NUMBER                           NULL,
  M201_490         NUMBER                           NULL,
  M201_491         NUMBER                           NULL,
  M201_492         NUMBER                           NULL,
  M201_493         NUMBER                           NULL,
  M201_494         NUMBER                           NULL,
  M201_495         NUMBER                           NULL,
  M201_496         NUMBER                           NULL,
  M201_497         NUMBER                           NULL,
  M201_500         NUMBER                           NULL,
  M201_501         NUMBER                           NULL,
  M201_502         NUMBER                           NULL,
  M201_503         NUMBER                           NULL,
  M201_504         NUMBER                           NULL,
  M201_505         NUMBER                           NULL,
  M201_506         NUMBER                           NULL,
  M201_507         NUMBER                           NULL,
  M201_508         NUMBER                           NULL,
  M201_509         NUMBER                           NULL,
  M201_510         NUMBER                           NULL,
  M201_511         NUMBER                           NULL,
  M201_512         NUMBER                           NULL,
  M201_513         NUMBER                           NULL,
  M201_514         NUMBER                           NULL,
  M201_515         NUMBER                           NULL,
  M201_516         NUMBER                           NULL,
  M201_518         NUMBER                           NULL,
  M201_519         NUMBER                           NULL,
  M201_520         NUMBER                           NULL,
  M201_521         NUMBER                           NULL,
  M201_522         NUMBER                           NULL,
  M201_523         NUMBER                           NULL,
  M201_524         NUMBER                           NULL,
  M201_525         NUMBER                           NULL,
  M201_526         NUMBER                           NULL,
  M201_527         NUMBER                           NULL,
  M201_528         NUMBER                           NULL,
  M201_531         NUMBER                           NULL,
  M201_532         NUMBER                           NULL,
  M201_533         NUMBER                           NULL,
  M201_534         NUMBER                           NULL,
  M201_535         NUMBER                           NULL,
  M201_536         NUMBER                           NULL,
  M201_539         NUMBER                           NULL,
  M201_540         NUMBER                           NULL,
  M201_543         NUMBER                           NULL,
  M201_544         NUMBER                           NULL,
  M201_545         NUMBER                           NULL,
  M201_546         NUMBER                           NULL,
  M201_547         NUMBER                           NULL,
  M201_548         NUMBER                           NULL,
  M201_549         NUMBER                           NULL,
  M201_550         NUMBER                           NULL,
  M201_551         NUMBER                           NULL,
  M201_552         NUMBER                           NULL,
  M201_553         NUMBER                           NULL,
  M201_554         NUMBER                           NULL,
  M201_555         NUMBER                           NULL,
  M201_556         NUMBER                           NULL,
  M201_557         NUMBER                           NULL,
  M201_558         NUMBER                           NULL,
  M201_559         NUMBER                           NULL,
  M201_560         NUMBER                           NULL,
  M201_561         NUMBER                           NULL,
  M201_563         NUMBER                           NULL,
  M201_564         NUMBER                           NULL,
  M201_565         NUMBER                           NULL,
  M201_566         NUMBER                           NULL,
  M201_567         NUMBER                           NULL,
  M201_568         NUMBER                           NULL,
  M201_569         NUMBER                           NULL,
  M201_571         NUMBER                           NULL,
  M201_572         NUMBER                           NULL,
  M201_573         NUMBER                           NULL,
  M201_574         NUMBER                           NULL,
  M201_575         NUMBER                           NULL,
  M201_576         NUMBER                           NULL,
  M201_577         NUMBER                           NULL,
  M201_580         NUMBER                           NULL,
  M201_581         NUMBER                           NULL,
  M201_582         NUMBER                           NULL,
  M201_583         NUMBER                           NULL,
  M201_584         NUMBER                           NULL,
  M201_585         NUMBER                           NULL,
  M201_587         NUMBER                           NULL,
  M201_588         NUMBER                           NULL,
  M201_589         NUMBER                           NULL,
  M201_590         NUMBER                           NULL,
  M201_592         NUMBER                           NULL,
  M201_594         NUMBER                           NULL,
  M201_595         NUMBER                           NULL,
  M201_596         NUMBER                           NULL,
  M201_598         NUMBER                           NULL,
  M201_599         NUMBER                           NULL,
  M201_600         NUMBER                           NULL,
  M201_601         NUMBER                           NULL,
  M201_602         NUMBER                           NULL,
  M201_603         NUMBER                           NULL,
  M201_604         NUMBER                           NULL,
  M201_605         NUMBER                           NULL,
  M201_606         NUMBER                           NULL,
  M201_607         NUMBER                           NULL,
  M201_608         NUMBER                           NULL,
  M201_609         NUMBER                           NULL,
  M201_610         NUMBER                           NULL,
  M201_611         NUMBER                           NULL,
  M201_612         NUMBER                           NULL,
  M201_613         NUMBER                           NULL,
  M201_614         NUMBER                           NULL,
  M201_615         NUMBER                           NULL,
  M201_616         NUMBER                           NULL,
  M201_617         NUMBER                           NULL,
  M201_618         NUMBER                           NULL,
  M201_619         NUMBER                           NULL,
  M201_620         NUMBER                           NULL,
  M201_621         NUMBER                           NULL,
  M201_622         NUMBER                           NULL,
  M201_623         NUMBER                           NULL,
  M201_624         NUMBER                           NULL,
  M201_625         NUMBER                           NULL,
  M201_626         NUMBER                           NULL,
  M201_627         NUMBER                           NULL,
  M201_628         NUMBER                           NULL,
  M201_629         NUMBER                           NULL,
  M201_634         NUMBER                           NULL,
  M201_635         NUMBER                           NULL,
  M201_636         NUMBER                           NULL,
  M201_637         NUMBER                           NULL,
  M201_638         NUMBER                           NULL,
  M201_639         NUMBER                           NULL,
  M201_640         NUMBER                           NULL,
  M201_641         NUMBER                           NULL,
  M201_642         NUMBER                           NULL,
  M201_643         NUMBER                           NULL,
  M201_644         NUMBER                           NULL,
  M201_645         NUMBER                           NULL,
  M201_646         NUMBER                           NULL,
  M201_647         NUMBER                           NULL,
  M201_648         NUMBER                           NULL,
  M201_649         NUMBER                           NULL,
  M201_650         NUMBER                           NULL,
  M201_651         NUMBER                           NULL,
  M201_652         NUMBER                           NULL,
  M201_653         NUMBER                           NULL,
  M201_654         NUMBER                           NULL,
  M201_655         NUMBER                           NULL,
  M201_656         NUMBER                           NULL,
  M201_657         NUMBER                           NULL,
  M201_658         NUMBER                           NULL,
  M201_659         NUMBER                           NULL,
  M201_660         NUMBER                           NULL,
  M201_661         NUMBER                           NULL,
  M201_662         NUMBER                           NULL,
  M201_663         NUMBER                           NULL,
  M201_664         NUMBER                           NULL,
  M201_665         NUMBER                           NULL,
  M201_666         NUMBER                           NULL,
  M201_667         NUMBER                           NULL,
  M201_668         NUMBER                           NULL,
  M201_669         NUMBER                           NULL,
  M201_670         NUMBER                           NULL,
  M201_671         NUMBER                           NULL,
  M201_672         NUMBER                           NULL,
  M201_673         NUMBER                           NULL,
  M201_674         NUMBER                           NULL,
  M201_675         NUMBER                           NULL,
  M201_676         NUMBER                           NULL,
  M201_677         NUMBER                           NULL,
  M201_678         NUMBER                           NULL,
  M201_679         NUMBER                           NULL,
  M201_680         NUMBER                           NULL,
  M201_681         NUMBER                           NULL,
  M201_682         NUMBER                           NULL,
  M201_683         NUMBER                           NULL,
  M201_684         NUMBER                           NULL,
  M201_685         NUMBER                           NULL,
  M201_686         NUMBER                           NULL,
  M201_687         NUMBER                           NULL,
  M201_688         NUMBER                           NULL,
  M201_689         NUMBER                           NULL,
  M201_690         NUMBER                           NULL,
  M201_691         NUMBER                           NULL,
  M201_692         NUMBER                           NULL,
  M201_693         NUMBER                           NULL,
  M201_694         NUMBER                           NULL,
  M201_695         NUMBER                           NULL,
  M201_696         NUMBER                           NULL,
  M201_697         NUMBER                           NULL,
  M201_698         NUMBER                           NULL,
  M201_699         NUMBER                           NULL,
  M201_700         NUMBER                           NULL,
  M201_701         NUMBER                           NULL,
  M201_702         NUMBER                           NULL,
  M201_703         NUMBER                           NULL,
  M201_705         NUMBER                           NULL,
  M201_706         NUMBER                           NULL,
  M201_707         NUMBER                           NULL,
  M201_708         NUMBER                           NULL,
  M201_709         NUMBER                           NULL,
  M201_710         NUMBER                           NULL,
  M201_711         NUMBER                           NULL,
  M201_712         NUMBER                           NULL,
  M201_713         NUMBER                           NULL,
  M201_714         NUMBER                           NULL,
  M201_715         NUMBER                           NULL,
  M201_716         NUMBER                           NULL,
  M201_717         NUMBER                           NULL,
  M201_718         NUMBER                           NULL,
  M201_719         NUMBER                           NULL,
  M201_720         NUMBER                           NULL,
  M201_721         NUMBER                           NULL,
  M201_722         NUMBER                           NULL,
  M201_723         NUMBER                           NULL,
  M201_724         NUMBER                           NULL,
  M201_725         NUMBER                           NULL,
  M201_726         NUMBER                           NULL,
  M201_727         NUMBER                           NULL,
  M201_728         NUMBER                           NULL,
  M201_729         NUMBER                           NULL,
  M201_730         NUMBER                           NULL,
  M201_731         NUMBER                           NULL,
  M201_732         NUMBER                           NULL,
  M201_733         NUMBER                           NULL,
  M201_734         NUMBER                           NULL,
  M201_735         NUMBER                           NULL,
  M201_736         NUMBER                           NULL,
  M201_737         NUMBER                           NULL,
  M201_738         NUMBER                           NULL,
  M201_739         NUMBER                           NULL,
  M201_740         NUMBER                           NULL,
  M201_741         NUMBER                           NULL,
  M201_742         NUMBER                           NULL,
  M201_743         NUMBER                           NULL,
  M201_744         NUMBER                           NULL,
  M201_745         NUMBER                           NULL,
  M201_746         NUMBER                           NULL,
  M201_747         NUMBER                           NULL,
  M201_748         NUMBER                           NULL,
  M201_749         NUMBER                           NULL,
  M201_750         NUMBER                           NULL,
  M201_751         NUMBER                           NULL,
  M201_752         NUMBER                           NULL,
  M201_753         NUMBER                           NULL,
  M201_754         NUMBER                           NULL,
  M201_755         NUMBER                           NULL,
  M201_756         NUMBER                           NULL,
  M201_757         NUMBER                           NULL,
  M201_758         NUMBER                           NULL,
  M201_759         NUMBER                           NULL,
  M201_760         NUMBER                           NULL,
  M201_761         NUMBER                           NULL,
  M201_762         NUMBER                           NULL,
  M201_763         NUMBER                           NULL,
  M201_764         NUMBER                           NULL,
  M201_765         NUMBER                           NULL,
  M201_766         NUMBER                           NULL,
  M201_767         NUMBER                           NULL,
  M201_768         NUMBER                           NULL,
  M201_769         NUMBER                           NULL,
  M201_770         NUMBER                           NULL,
  M201_771         NUMBER                           NULL,
  M201_772         NUMBER                           NULL,
  M201_773         NUMBER                           NULL,
  M201_774         NUMBER                           NULL,
  M201_775         NUMBER                           NULL,
  M201_776         NUMBER                           NULL,
  M201_777         NUMBER                           NULL,
  M201_778         NUMBER                           NULL,
  M201_779         NUMBER                           NULL,
  M201_780         NUMBER                           NULL,
  M201_781         NUMBER                           NULL,
  M201_782         NUMBER                           NULL,
  M201_783         NUMBER                           NULL,
  M201_784         NUMBER                           NULL,
  M201_785         NUMBER                           NULL,
  M201_786         NUMBER                           NULL,
  M201_787         NUMBER                           NULL,
  M201_788         NUMBER                           NULL,
  M201_789         NUMBER                           NULL,
  M201_790         NUMBER                           NULL,
  M201_791         NUMBER                           NULL,
  M201_792         NUMBER                           NULL,
  M201_793         NUMBER                           NULL,
  M201_794         NUMBER                           NULL,
  M201_795         NUMBER                           NULL,
  M201_796         NUMBER                           NULL,
  M201_797         NUMBER                           NULL,
  M201_798         NUMBER                           NULL,
  M201_799         NUMBER                           NULL,
  M201_800         NUMBER                           NULL,
  M201_801         NUMBER                           NULL,
  M201_802         NUMBER                           NULL,
  M201_803         NUMBER                           NULL,
  M201_804         NUMBER                           NULL,
  M201_805         NUMBER                           NULL,
  M201_806         NUMBER                           NULL,
  M201_807         NUMBER                           NULL,
  M201_808         NUMBER                           NULL,
  M201_809         NUMBER                           NULL,
  M201_810         NUMBER                           NULL,
  M201_811         NUMBER                           NULL,
  M201_812         NUMBER                           NULL,
  M201_813         NUMBER                           NULL,
  M201_814         NUMBER                           NULL,
  M201_815         NUMBER                           NULL,
  M201_816         NUMBER                           NULL,
  M201_817         NUMBER                           NULL,
  M201_818         NUMBER                           NULL,
  M201_819         NUMBER                           NULL,
  M201_820         NUMBER                           NULL,
  M201_821         NUMBER                           NULL,
  M201_822         NUMBER                           NULL,
  M201_823         NUMBER                           NULL,
  M201_824         NUMBER                           NULL,
  M201_825         NUMBER                           NULL,
  M201_826         NUMBER                           NULL,
  M201_827         NUMBER                           NULL,
  M201_828         NUMBER                           NULL,
  M201_829         NUMBER                           NULL,
  M201_830         NUMBER                           NULL,
  M201_831         NUMBER                           NULL,
  M201_832         NUMBER                           NULL,
  M201_833         NUMBER                           NULL,
  M201_834         NUMBER                           NULL,
  M201_835         NUMBER                           NULL,
  M201_836         NUMBER                           NULL,
  M201_837         NUMBER                           NULL,
  M201_838         NUMBER                           NULL,
  M201_839         NUMBER                           NULL,
  M201_840         NUMBER                           NULL,
  M201_841         NUMBER                           NULL,
  M201_842         NUMBER                           NULL,
  M201_843         NUMBER                           NULL,
  M201_844         NUMBER                           NULL,
  M201_845         NUMBER                           NULL,
  M201_846         NUMBER                           NULL,
  M201_847         NUMBER                           NULL,
  M201_848         NUMBER                           NULL,
  M201_849         NUMBER                           NULL,
  M201_850         NUMBER                           NULL,
  M201_851         NUMBER                           NULL,
  M201_852         NUMBER                           NULL,
  M201_853         NUMBER                           NULL,
  M201_854         NUMBER                           NULL,
  M201_855         NUMBER                           NULL,
  M201_856         NUMBER                           NULL,
  M201_857         NUMBER                           NULL,
  M201_858         NUMBER                           NULL,
  M201_859         NUMBER                           NULL,
  M201_860         NUMBER                           NULL,
  M201_861         NUMBER                           NULL,
  M201_862         NUMBER                           NULL,
  M201_863         NUMBER                           NULL,
  M201_864         NUMBER                           NULL,
  M201_865         NUMBER                           NULL,
  M201_866         NUMBER                           NULL,
  M201_867         NUMBER                           NULL,
  M201_868         NUMBER                           NULL,
  M201_869         NUMBER                           NULL,
  M201_870         NUMBER                           NULL,
  M201_871         NUMBER                           NULL,
  M201_872         NUMBER                           NULL,
  M201_873         NUMBER                           NULL,
  M201_874         NUMBER                           NULL,
  M201_875         NUMBER                           NULL,
  M201_876         NUMBER                           NULL,
  M201_877         NUMBER                           NULL,
  M201_878         NUMBER                           NULL,
  M201_879         NUMBER                           NULL,
  M201_880         NUMBER                           NULL,
  M201_881         NUMBER                           NULL,
  M201_882         NUMBER                           NULL,
  M201_883         NUMBER                           NULL,
  M201_884         NUMBER                           NULL,
  M201_885         NUMBER                           NULL,
  M201_886         NUMBER                           NULL,
  M201_887         NUMBER                           NULL,
  M201_888         NUMBER                           NULL,
  M201_889         NUMBER                           NULL,
  M201_890         NUMBER                           NULL,
  M201_891         NUMBER                           NULL,
  M201_892         NUMBER                           NULL,
  M201_893         NUMBER                           NULL,
  M201_894         NUMBER                           NULL,
  M201_895         NUMBER                           NULL,
  M201_896         NUMBER                           NULL,
  M201_897         NUMBER                           NULL,
  M201_898         NUMBER                           NULL,
  M201_899         NUMBER                           NULL,
  M201_900         NUMBER                           NULL,
  M201_928         NUMBER                           NULL,
  M201_929         NUMBER                           NULL,
  M201_930         NUMBER                           NULL,
  M201_931         NUMBER                           NULL,
  M201_932         NUMBER                           NULL,
  M201_933         NUMBER                           NULL,
  M201_934         NUMBER                           NULL,
  M201_935         NUMBER                           NULL,
  M201_939         NUMBER                           NULL,
  M201_940         NUMBER                           NULL,
  M201_941         NUMBER                           NULL,
  M201_942         NUMBER                           NULL,
  M201_943         NUMBER                           NULL,
  M201_944         NUMBER                           NULL,
  M201_945         NUMBER                           NULL,
  M201_946         NUMBER                           NULL,
  M201_947         NUMBER                           NULL,
  M201_948         NUMBER                           NULL,
  M201_949         NUMBER                           NULL,
  M201_971         NUMBER                           NULL,
  M201_972         NUMBER                           NULL,
  M201_974         NUMBER                           NULL,
  M201_980         NUMBER                           NULL,
  M201_987         NUMBER                           NULL,
  M201_988         NUMBER                           NULL,
  M201_990         NUMBER                           NULL,
  M201_991         NUMBER                           NULL,
  M201_992         NUMBER                           NULL,
  M201_993         NUMBER                           NULL,
  M201_994         NUMBER                           NULL,
  M201_995         NUMBER                           NULL,
  M201_996         NUMBER                           NULL,
  M201_997         NUMBER                           NULL,
  M201_998         NUMBER                           NULL,
  M201_558_2       NUMBER                           NULL,
  M201_704         NUMBER                           NULL,
  M201_057         NUMBER(4)                        NULL,
  M201_058         NUMBER(4)                        NULL,
  M201_059         NUMBER                           NULL,
  M201_099         NUMBER                           NULL,
  M201_100         NUMBER                           NULL,
  M201_071         NUMBER                           NULL,
  M201_187         NUMBER                           NULL,
  M201_300         NUMBER                           NULL,
  M201_001N        NUMBER                           NULL,
  M201_002N        NUMBER                           NULL,
  M201_003N        NUMBER                           NULL,
  M201_004N        NUMBER                           NULL,
  M201_005N        NUMBER                           NULL,
  M201_006N        NUMBER                           NULL,
  M201_498         NUMBER                           NULL,
  M201_586         NUMBER                           NULL,
  M201_591         NUMBER                           NULL,
  M201_597         NUMBER                           NULL,
  M201_007         NUMBER                           NULL,
  M201_633         NUMBER                           NULL,
  M201_067         NUMBER                           NULL,
  M201_068         NUMBER                           NULL,
  M201_069         NUMBER                           NULL,
  M201_070         NUMBER                           NULL,
  M201_093         NUMBER                           NULL,
  M201_008         NUMBER                           NULL,
  M201_009         NUMBER                           NULL,
  M201_010         NUMBER                           NULL,
  M201_200         NUMBER                           NULL,
  M201_257         NUMBER                           NULL,
  M201_011N        NUMBER                           NULL,
  M201_043N        NUMBER(15,2)                     NULL,
  M201_542         NUMBER(15,2)                     NULL,
  M201_541         NUMBER(15,2)                     NULL,
  M201_034N        NUMBER(15,2)                     NULL,
  M201_035N        NUMBER(15,2)                     NULL,
  M201_041N        NUMBER(15,2)                     NULL,
  M201_042N        NUMBER(15,2)                     NULL,
  M201_036         NUMBER(15,2)                     NULL,
  M201_040         NUMBER(15,2)                     NULL,
  M201_037N        NUMBER(15,2)                     NULL,
  M201_038N        NUMBER(15,2)                     NULL,
  M201_039N        NUMBER(15,2)                     NULL,
  M201_012         NUMBER(15,2)                     NULL,
  M201_013N        NUMBER(15,2)                     NULL,
  M201_014N        NUMBER(15,2)                     NULL,
  M201_015N        NUMBER(15,2)                     NULL,
  M201_016N        NUMBER(15,2)                     NULL,
  M201_017N        NUMBER(15,2)                     NULL,
  M201_018N        NUMBER(15,2)                     NULL,
  M201_019N        NUMBER(15,2)                     NULL,
  M201_026N        NUMBER(15,2)                     NULL,
  M201_027N        NUMBER(15,2)                     NULL,
  M201_028N        NUMBER(15,2)                     NULL,
  M201_029N        NUMBER(15,2)                     NULL,
  M201_030N        NUMBER(15,2)                     NULL,
  M201_031N        NUMBER(15,2)                     NULL,
  M201_032N        NUMBER(15,2)                     NULL,
  M201_033N        NUMBER(15,2)                     NULL,
  M201_025         NUMBER(15,2)                     NULL,
  M201_106         NUMBER(17,2)                     NULL,
  M201_110         NUMBER(17,2)                     NULL,
  M201_111         NUMBER(17,2)                     NULL,
  M201_115         NUMBER(17,2)                     NULL,
  M201_118         NUMBER(17,2)                     NULL,
  M201_119         NUMBER(17,2)                     NULL,
  M201_125         NUMBER(17,2)                     NULL,
  M201_126         NUMBER(17,2)                     NULL,
  M201_127         NUMBER(17,2)                     NULL,
  M201_168         NUMBER(17,2)                     NULL,
  M201_169         NUMBER(17,2)                     NULL,
  M201_177         NUMBER(17,2)                     NULL,
  M201_180         NUMBER(17,2)                     NULL,
  M201_301         NUMBER(17,2)                     NULL,
  M201_302         NUMBER(17,2)                     NULL,
  M201_303         NUMBER(17,2)                     NULL,
  M201_304         NUMBER(17,2)                     NULL,
  M201_305         NUMBER(17,2)                     NULL,
  M201_307         NUMBER(17,2)                     NULL,
  M201_308         NUMBER(17,2)                     NULL,
  M201_309         NUMBER(17,2)                     NULL,
  M201_315         NUMBER(17,2)                     NULL,
  M201_316         NUMBER(17,2)                     NULL,
  M201_317         NUMBER(17,2)                     NULL,
  M201_318         NUMBER(17,2)                     NULL,
  M201_319         NUMBER(17,2)                     NULL,
  M201_321         NUMBER(17,2)                     NULL,
  M201_322         NUMBER(17,2)                     NULL,
  M201_323         NUMBER(17,2)                     NULL,
  M201_324         NUMBER(17,2)                     NULL,
  M201_325         NUMBER(17,2)                     NULL,
  M201_387         NUMBER(17,2)                     NULL,
  M201_388         NUMBER(17,2)                     NULL,
  M201_391         NUMBER(17,2)                     NULL,
  M201_392         NUMBER(17,2)                     NULL,
  M201_393         NUMBER(17,2)                     NULL,
  M201_401         NUMBER(17,2)                     NULL,
  M201_406         NUMBER(17,2)                     NULL,
  M201_407         NUMBER(17,2)                     NULL,
  M201_416         NUMBER(17,2)                     NULL,
  M201_419         NUMBER(17,2)                     NULL,
  M201_380         NUMBER(17,2)                     NULL,
  M201_381         NUMBER(17,2)                     NULL,
  M201_382         NUMBER(17,2)                     NULL,
  M201_383         NUMBER(17,2)                     NULL,
  M201_384         NUMBER(17,2)                     NULL,
  M201_385         NUMBER(17,2)                     NULL,
  M201_386         NUMBER(17,2)                     NULL,
  M201_394         NUMBER(17,2)                     NULL,
  M201_396         NUMBER(17,2)                     NULL,
  M201_397         NUMBER(17,2)                     NULL,
  M201_398         NUMBER(17,2)                     NULL,
  M201_399         NUMBER(17,2)                     NULL,
  M201_400         NUMBER(17,2)                     NULL,
  M201_409         NUMBER(17,2)                     NULL,
  M201_410         NUMBER(17,2)                     NULL,
  M201_411         NUMBER(17,2)                     NULL,
  M201_412         NUMBER(17,2)                     NULL,
  M201_413         NUMBER(17,2)                     NULL,
  M201_390         NUMBER(17,2)                     NULL,
  M201_389         NUMBER(17,2)                     NULL,
  M201_352         NUMBER(17,2)                     NULL,
  M201_354         NUMBER(17,2)                     NULL,
  M201_355         NUMBER(17,2)                     NULL,
  M201_356         NUMBER(17,2)                     NULL,
  M201_357         NUMBER(17,2)                     NULL,
  M201_358         NUMBER(17,2)                     NULL,
  M201_359         NUMBER(17,2)                     NULL,
  M201_360         NUMBER(17,2)                     NULL,
  M201_361         NUMBER(17,2)                     NULL,
  M201_362         NUMBER(17,2)                     NULL,
  M201_363         NUMBER(17,2)                     NULL,
  M201_365         NUMBER(17,2)                     NULL,
  M201_367         NUMBER(17,2)                     NULL,
  M201_369         NUMBER(17,2)                     NULL,
  M201_370         NUMBER(17,2)                     NULL,
  M201_372         NUMBER(17,2)                     NULL,
  M201_373         NUMBER(17,2)                     NULL,
  M201_374         NUMBER(17,2)                     NULL,
  M201_375         NUMBER(17,2)                     NULL,
  M201_376         NUMBER(17,2)                     NULL,
  M201_377         NUMBER(17,2)                     NULL,
  M201_378         NUMBER(17,2)                     NULL,
  M201_379         NUMBER(17,2)                     NULL,
  M201_327         NUMBER(17,2)                     NULL,
  M201_328         NUMBER(17,2)                     NULL,
  M201_329         NUMBER(17,2)                     NULL,
  M201_330         NUMBER(17,2)                     NULL,
  M201_331         NUMBER(17,2)                     NULL,
  M201_332         NUMBER(17,2)                     NULL,
  M201_334         NUMBER(17,2)                     NULL,
  M201_335         NUMBER(17,2)                     NULL,
  M201_336         NUMBER(17,2)                     NULL,
  M201_337         NUMBER(17,2)                     NULL,
  M201_338         NUMBER(17,2)                     NULL,
  M201_339         NUMBER(17,2)                     NULL,
  M201_310         NUMBER(17,2)                     NULL,
  M201_311         NUMBER(17,2)                     NULL,
  M201_418         NUMBER(17,2)                     NULL,
  M201_417         NUMBER(17,2)                     NULL,
  M201_403         NUMBER(17,2)                     NULL,
  M201_404         NUMBER(17,2)                     NULL,
  M201_570         NUMBER(17,2)                     NULL,
  M201_022         NUMBER(17,2)                     NULL,
  M201_023         NUMBER(17,2)                     NULL,
  M201_024         NUMBER(17,2)                     NULL,
  M201_182         NUMBER(17,2)                     NULL,
  M201_181         NUMBER(17,2)                     NULL,
  M201_009N        NUMBER(17,2)                     NULL,
  M201_010N        NUMBER(17,2)                     NULL,
  M201_040A        VARCHAR2(7 BYTE)                 NULL,
  M201_183         NUMBER(17,2)                     NULL,
  M201_178         NUMBER(17,2)                     NULL,
  M201_179         NUMBER(17,2)                     NULL,
  M201_170         NUMBER(17,2)                     NULL,
  M201_165         NUMBER(17,2)                     NULL,
  M201_164         NUMBER(17,2)                     NULL,
  M201_117         NUMBER(17,2)                     NULL,
  M201_116         NUMBER(17,2)                     NULL,
  M201_113         NUMBER(17,2)                     NULL,
  M201_112         NUMBER(17,2)                     NULL,
  M201_109         NUMBER(17,2)                     NULL,
  M201_108         NUMBER(17,2)                     NULL,
  M201_107         NUMBER(17,2)                     NULL,
  M201_105         NUMBER(17,2)                     NULL,
  M201_104         NUMBER(17,2)                     NULL,
  M201_130         NUMBER(17,2)                     NULL,
  M201_129         NUMBER(17,2)                     NULL,
  M201_128         NUMBER(17,2)                     NULL,
  M201_124         NUMBER(17,2)                     NULL,
  M201_123         NUMBER(17,2)                     NULL,
  M201_122         NUMBER(17,2)                     NULL,
  M201_121         NUMBER(17,2)                     NULL,
  M201_103         NUMBER(19,4)                     NULL,
  M201_120         NUMBER(17,2)                     NULL,
  M201_IBNPAIDEV   VARCHAR2(2 BYTE)                 NULL,
  M201_IBNDCCDEV   VARCHAR2(2 BYTE)                 NULL,
  M201_IBNPAIING   VARCHAR2(2 BYTE)                 NULL,
  M201_IBNDCCING   VARCHAR2(2 BYTE)                 NULL,
  M201_BICDEV      VARCHAR2(11 BYTE)                NULL
)
;


CREATE TABLE TCMP_MOD201_ACCALT
(
  ACA_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  ACA_M201_NUM       NUMBER(5)                      NULL,
  ACA_SEQ            NUMBER(4)                      NULL,
  ACA_NIF_NIF        VARCHAR2(12 BYTE)              NULL,
  ACA_PRV_COD        VARCHAR2(3 BYTE)               NULL,
  ACA_NOMINAL        NUMBER(18,6)               DEFAULT 0                         NULL,
  ACA_PTEPAR         NUMBER(5,2)                DEFAULT 0                         NULL,
  ACA_USUCRE         VARCHAR2(30 BYTE)              NULL,
  ACA_DATCRE         DATE                           NULL,
  ACA_NIF_NOMFIS     VARCHAR2(40 BYTE)              NULL,
  ACA_USUMOD         VARCHAR2(30 BYTE)              NULL,
  ACA_DATMOD         DATE                           NULL,
  ACA_LIBROS         NUMBER(17,2)                   NULL,
  ACA_INGDIVEJE      NUMBER(17,2)                   NULL,
  ACA_PERDIDAEJEN1   NUMBER(17,2)                   NULL,
  ACA_PERDIDAEJE     NUMBER(17,2)                   NULL,
  ACA_VARDETERIORO   NUMBER(17,2)                   NULL,
  ACA_VARPATRIMONIO  NUMBER(17,2)                   NULL,
  ACA_SALIDAS        NUMBER(17,2)                   NULL,
  ACA_TRASPASOS      NUMBER(17,2)                   NULL,
  ACA_CAPITAL        NUMBER(17,2)                   NULL,
  ACA_FONDOS         NUMBER(17,2)                   NULL,
  ACA_PATRIMONIO     NUMBER(17,2)                   NULL,
  ACA_RESULTADO      NUMBER(17,2)                   NULL,
  ACA_RESERVAS       NUMBER(17,2)                   NULL
)
;


CREATE TABLE TCMP_MOD201_ACCPRO
(
  ACE_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  ACE_M201_NUM    NUMBER(5)                         NULL,
  ACE_SEQ         NUMBER(4)                         NULL,
  ACE_NIF_NIF     VARCHAR2(12 BYTE)                 NULL,
  ACE_FJ          VARCHAR2(1 BYTE)                  NULL,
  ACE_NOMINAL     NUMBER(18,6)                  DEFAULT 0                         NULL,
  ACE_PTEACC      NUMBER(5,2)                   DEFAULT 0                         NULL,
  ACE_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  ACE_DATCRE      DATE                              NULL,
  ACE_RPR         VARCHAR2(1 BYTE)                  NULL,
  ACE_PRV_COD     VARCHAR2(3 BYTE)                  NULL,
  ACE_NIF_NOMFIS  VARCHAR2(40 BYTE)                 NULL,
  ACE_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  ACE_DATMOD      DATE                              NULL
)
;


CREATE TABLE TCMP_MOD201_ADMIN
(
  ADM_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  ADM_M201_NUM    NUMBER(5)                         NULL,
  ADM_SEQ         NUMBER(3)                         NULL,
  ADM_NIF_NIF     VARCHAR2(12 BYTE)                 NULL,
  ADM_FJ          VARCHAR2(1 BYTE)                  NULL,
  ADM_PRV_COD     VARCHAR2(3 BYTE)                  NULL,
  ADM_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  ADM_DATCRE      DATE                              NULL,
  ADM_NIF_NOMFIS  VARCHAR2(40 BYTE)                 NULL,
  ADM_NIF_DOMFIS  VARCHAR2(30 BYTE)                 NULL,
  ADM_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  ADM_DATMOD      DATE                              NULL
)
;


CREATE TABLE TCMP_MOD201_DED
(
  M201_DED_CEC_COD  VARCHAR2(4 BYTE)                NULL,
  M201_DED_TIP      VARCHAR2(1 BYTE)                NULL,
  M201_DED_NUM      NUMBER                          NULL,
  M201_DED_SEQ      NUMBER                          NULL,
  M201_DED_BAS      NUMBER                          NULL,
  M201_DED_ENT      VARCHAR2(100 BYTE)              NULL,
  M201_DED_PTE      NUMBER                          NULL,
  M201_DED_USUCRE   VARCHAR2(30 BYTE)               NULL,
  M201_DED_DATCRE   DATE                            NULL,
  M201_DED_USUMOD   VARCHAR2(30 BYTE)               NULL,
  M201_DED_DATMOD   DATE                            NULL
)
;


CREATE TABLE TCMP_MOD201_OPEFIS
(
  OPA_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  OPA_M201_NUM  NUMBER(5)                           NULL,
  OPA_SEQ       NUMBER(4)                           NULL,
  OPA_FJ        VARCHAR2(1 BYTE)                    NULL,
  OPA_DESOPE    VARCHAR2(30 BYTE)                   NULL,
  OPA_PERENT    VARCHAR2(30 BYTE)                   NULL,
  OPA_PAI_COD   VARCHAR2(5 BYTE)                    NULL,
  OPA_IMP       NUMBER(15,3)                    DEFAULT 0                         NULL,
  OPA_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  OPA_DATCRE    DATE                                NULL,
  OPA_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  OPA_DATMOD    DATE                                NULL
)
;


CREATE TABLE TCMP_MOD201_PARAISOS
(
  VPA_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  VPA_M201_NUM  NUMBER(5)                           NULL,
  VPA_SEQ       NUMBER(4)                           NULL,
  VPA_TIPO      VARCHAR2(4 BYTE)                    NULL,
  VPA_ENTITAT   VARCHAR2(30 BYTE)                   NULL,
  VPA_PAI_COD   VARCHAR2(5 BYTE)                    NULL,
  VPA_IMPADQ    NUMBER(15,3)                    DEFAULT 0                         NULL,
  VPA_PTEPAR    NUMBER(5,2)                     DEFAULT 0                         NULL,
  VPA_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  VPA_DATCRE    DATE                                NULL,
  VPA_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  VPA_DATMOD    DATE                                NULL
)
;


CREATE TABLE TCMP_MOD201_R1
(
  M201_M201_NUM      NUMBER                         NULL,
  M201_M201_CEC_COD  VARCHAR2(4 BYTE)               NULL,
  M201_001           NUMBER                         NULL,
  M201_002           NUMBER                         NULL,
  M201_003           NUMBER                         NULL,
  M201_004           NUMBER                         NULL,
  M201_005           NUMBER                         NULL,
  M201_006           NUMBER                         NULL,
  M201_007           NUMBER                         NULL,
  M201_008           NUMBER                         NULL,
  M201_009           NUMBER                         NULL,
  M201_010           NUMBER                         NULL,
  M201_011           NUMBER                         NULL,
  M201_012           NUMBER                         NULL,
  M201_013           NUMBER                         NULL,
  M201_014           NUMBER                         NULL,
  M201_015           NUMBER                         NULL,
  M201_016           NUMBER                         NULL,
  M201_017           NUMBER                         NULL,
  M201_018           NUMBER                         NULL,
  M201_019           NUMBER                         NULL,
  M201_020           NUMBER                         NULL,
  M201_021           NUMBER                         NULL,
  M201_022           NUMBER                         NULL,
  M201_023           NUMBER                         NULL,
  M201_024           NUMBER                         NULL,
  M201_025           NUMBER                         NULL,
  M201_026           NUMBER                         NULL,
  M201_027           NUMBER                         NULL,
  M201_028           NUMBER                         NULL,
  M201_029           NUMBER                         NULL,
  M201_030           NUMBER                         NULL,
  M201_031           NUMBER                         NULL,
  M201_032           NUMBER                         NULL,
  M201_033           NUMBER                         NULL,
  M201_034           NUMBER                         NULL,
  M201_035           NUMBER                         NULL,
  M201_036           NUMBER                         NULL,
  M201_037           NUMBER                         NULL,
  M201_038           NUMBER                         NULL,
  M201_039           NUMBER                         NULL,
  M201_040           NUMBER                         NULL,
  M201_041           NUMBER                         NULL,
  M201_042           NUMBER                         NULL,
  M201_043           NUMBER                         NULL,
  M201_044           NUMBER                         NULL,
  M201_045           NUMBER                         NULL,
  M201_046           NUMBER                         NULL,
  M201_047           NUMBER                         NULL,
  M201_048           NUMBER                         NULL,
  M201_049           NUMBER                         NULL,
  M201_050           NUMBER                         NULL,
  M201_051           NUMBER                         NULL,
  M201_052           NUMBER                         NULL,
  M201_053           NUMBER                         NULL,
  M201_054           NUMBER                         NULL,
  M201_055           NUMBER                         NULL,
  M201_056           NUMBER                         NULL,
  M201_057           NUMBER                         NULL,
  M201_058           NUMBER                         NULL,
  M201_059           NUMBER                         NULL,
  M201_060           NUMBER                         NULL,
  M201_061           NUMBER                         NULL,
  M201_062           NUMBER                         NULL,
  M201_063           NUMBER                         NULL,
  M201_064           NUMBER                         NULL,
  M201_065           NUMBER                         NULL,
  M201_066           NUMBER                         NULL,
  M201_067           NUMBER                         NULL,
  M201_068           NUMBER                         NULL,
  M201_069           NUMBER                         NULL,
  M201_070           NUMBER                         NULL,
  M201_071           NUMBER                         NULL,
  M201_072           NUMBER                         NULL,
  M201_073           NUMBER                         NULL,
  M201_074           NUMBER                         NULL,
  M201_075           NUMBER                         NULL,
  M201_076           NUMBER                         NULL,
  M201_077           NUMBER                         NULL,
  M201_078           NUMBER                         NULL,
  M201_079           NUMBER                         NULL,
  M201_080           NUMBER                         NULL,
  M201_081           NUMBER                         NULL,
  M201_082           NUMBER                         NULL,
  M201_083           NUMBER                         NULL,
  M201_084           NUMBER                         NULL,
  M201_085           NUMBER                         NULL,
  M201_086           NUMBER                         NULL,
  M201_087           NUMBER                         NULL,
  M201_088           NUMBER                         NULL,
  M201_089           NUMBER                         NULL,
  M201_090           NUMBER                         NULL,
  M201_091           NUMBER                         NULL,
  M201_092           NUMBER                         NULL,
  M201_093           NUMBER                         NULL,
  M201_094           NUMBER                         NULL,
  M201_095           NUMBER                         NULL,
  M201_096           NUMBER                         NULL,
  M201_097           NUMBER                         NULL,
  M201_098           NUMBER                         NULL,
  M201_099           NUMBER                         NULL,
  M201_100           NUMBER                         NULL,
  M201_101           NUMBER                         NULL,
  M201_102           NUMBER                         NULL,
  M201_103           NUMBER                         NULL,
  M201_104           NUMBER                         NULL,
  M201_105           NUMBER                         NULL,
  M201_106           NUMBER                         NULL,
  M201_107           NUMBER                         NULL,
  M201_108           NUMBER                         NULL,
  M201_109           NUMBER                         NULL,
  M201_110           NUMBER                         NULL,
  M201_111           NUMBER                         NULL,
  M201_112           NUMBER                         NULL,
  M201_113           NUMBER                         NULL,
  M201_114           NUMBER                         NULL,
  M201_115           NUMBER                         NULL,
  M201_116           NUMBER                         NULL,
  M201_117           NUMBER                         NULL,
  M201_118           NUMBER                         NULL,
  M201_119           NUMBER                         NULL,
  M201_120           NUMBER                         NULL,
  M201_121           NUMBER                         NULL,
  M201_122           NUMBER                         NULL,
  M201_123           NUMBER                         NULL,
  M201_124           NUMBER                         NULL,
  M201_125           NUMBER                         NULL,
  M201_126           NUMBER                         NULL,
  M201_127           NUMBER                         NULL,
  M201_128           NUMBER                         NULL,
  M201_129           NUMBER                         NULL,
  M201_130           NUMBER                         NULL,
  M201_131           NUMBER                         NULL,
  M201_132           NUMBER                         NULL,
  M201_133           NUMBER                         NULL,
  M201_134           NUMBER                         NULL,
  M201_135           NUMBER                         NULL,
  M201_136           NUMBER                         NULL,
  M201_137           NUMBER                         NULL,
  M201_138           NUMBER                         NULL,
  M201_139           NUMBER                         NULL,
  M201_140           NUMBER                         NULL,
  M201_141           NUMBER                         NULL,
  M201_142           NUMBER                         NULL,
  M201_143           NUMBER                         NULL,
  M201_144           NUMBER                         NULL,
  M201_145           NUMBER                         NULL,
  M201_146           NUMBER                         NULL,
  M201_147           NUMBER                         NULL,
  M201_148           NUMBER                         NULL,
  M201_149           NUMBER                         NULL,
  M201_150           NUMBER                         NULL,
  M201_151           NUMBER                         NULL,
  M201_152           NUMBER                         NULL,
  M201_153           NUMBER                         NULL,
  M201_154           NUMBER                         NULL,
  M201_155           NUMBER                         NULL,
  M201_156           NUMBER                         NULL,
  M201_157           NUMBER                         NULL,
  M201_158           NUMBER                         NULL,
  M201_159           NUMBER                         NULL,
  M201_160           NUMBER                         NULL,
  M201_161           NUMBER                         NULL,
  M201_162           NUMBER                         NULL,
  M201_163           NUMBER                         NULL,
  M201_164           NUMBER                         NULL,
  M201_165           NUMBER                         NULL,
  M201_166           NUMBER                         NULL,
  M201_167           NUMBER                         NULL,
  M201_168           NUMBER                         NULL,
  M201_169           NUMBER                         NULL,
  M201_170           NUMBER                         NULL,
  M201_171           NUMBER                         NULL,
  M201_172           NUMBER                         NULL,
  M201_173           NUMBER                         NULL,
  M201_174           NUMBER                         NULL,
  M201_175           NUMBER                         NULL,
  M201_176           NUMBER                         NULL,
  M201_177           NUMBER                         NULL,
  M201_178           NUMBER                         NULL,
  M201_179           NUMBER                         NULL,
  M201_180           NUMBER                         NULL,
  M201_181           NUMBER                         NULL,
  M201_182           NUMBER                         NULL,
  M201_183           NUMBER                         NULL,
  M201_184           NUMBER                         NULL,
  M201_185           NUMBER                         NULL,
  M201_186           NUMBER                         NULL,
  M201_187           NUMBER                         NULL,
  M201_188           NUMBER                         NULL,
  M201_189           NUMBER                         NULL,
  M201_190           NUMBER                         NULL,
  M201_191           NUMBER                         NULL,
  M201_192           NUMBER                         NULL,
  M201_193           NUMBER                         NULL,
  M201_194           NUMBER                         NULL,
  M201_195           NUMBER                         NULL,
  M201_196           NUMBER                         NULL,
  M201_197           NUMBER                         NULL,
  M201_198           NUMBER                         NULL,
  M201_199           NUMBER                         NULL,
  M201_200           NUMBER                         NULL,
  M201_201           NUMBER                         NULL,
  M201_202           NUMBER                         NULL,
  M201_203           NUMBER                         NULL,
  M201_204           NUMBER                         NULL,
  M201_205           NUMBER                         NULL,
  M201_206           NUMBER                         NULL,
  M201_207           NUMBER                         NULL,
  M201_208           NUMBER                         NULL,
  M201_209           NUMBER                         NULL,
  M201_210           NUMBER                         NULL,
  M201_211           NUMBER                         NULL,
  M201_212           NUMBER                         NULL,
  M201_213           NUMBER                         NULL,
  M201_214           NUMBER                         NULL,
  M201_215           NUMBER                         NULL,
  M201_216           NUMBER                         NULL,
  M201_217           NUMBER                         NULL,
  M201_218           NUMBER                         NULL,
  M201_219           NUMBER                         NULL,
  M201_220           NUMBER                         NULL,
  M201_221           NUMBER                         NULL,
  M201_222           NUMBER                         NULL,
  M201_223           NUMBER                         NULL,
  M201_224           NUMBER                         NULL,
  M201_225           NUMBER                         NULL,
  M201_226           NUMBER                         NULL,
  M201_227           NUMBER                         NULL,
  M201_228           NUMBER                         NULL,
  M201_229           NUMBER                         NULL,
  M201_230           NUMBER                         NULL,
  M201_231           NUMBER                         NULL,
  M201_232           NUMBER                         NULL,
  M201_233           NUMBER                         NULL,
  M201_234           NUMBER                         NULL,
  M201_235           NUMBER                         NULL,
  M201_236           NUMBER                         NULL,
  M201_237           NUMBER                         NULL,
  M201_238           NUMBER                         NULL,
  M201_239           NUMBER                         NULL,
  M201_240           NUMBER                         NULL,
  M201_241           NUMBER                         NULL,
  M201_242           NUMBER                         NULL,
  M201_243           NUMBER                         NULL,
  M201_244           NUMBER                         NULL,
  M201_245           NUMBER                         NULL,
  M201_246           NUMBER                         NULL,
  M201_247           NUMBER                         NULL,
  M201_248           NUMBER                         NULL,
  M201_249           NUMBER                         NULL,
  M201_250           NUMBER                         NULL,
  M201_USUCRE        VARCHAR2(30 BYTE)              NULL,
  M201_DATCRE        DATE                           NULL,
  M201_USUMOD        VARCHAR2(30 BYTE)              NULL,
  M201_DATMOD        DATE                           NULL,
  M201_NRS001        VARCHAR2(22 BYTE)              NULL,
  M201_NRS002        VARCHAR2(22 BYTE)              NULL
)
;


CREATE TABLE TCMP_MOD201_R2
(
  M201_M201_NUM      NUMBER                         NULL,
  M201_M201_CEC_COD  VARCHAR2(4 BYTE)               NULL,
  M201_251           NUMBER                         NULL,
  M201_252           NUMBER                         NULL,
  M201_253           NUMBER                         NULL,
  M201_254           NUMBER                         NULL,
  M201_255           NUMBER                         NULL,
  M201_256           NUMBER                         NULL,
  M201_257           NUMBER                         NULL,
  M201_258           NUMBER                         NULL,
  M201_259           NUMBER                         NULL,
  M201_260           NUMBER                         NULL,
  M201_261           NUMBER                         NULL,
  M201_262           NUMBER                         NULL,
  M201_263           NUMBER                         NULL,
  M201_264           NUMBER                         NULL,
  M201_265           NUMBER                         NULL,
  M201_266           NUMBER                         NULL,
  M201_267           NUMBER                         NULL,
  M201_268           NUMBER                         NULL,
  M201_269           NUMBER                         NULL,
  M201_270           NUMBER                         NULL,
  M201_271           NUMBER                         NULL,
  M201_272           NUMBER                         NULL,
  M201_273           NUMBER                         NULL,
  M201_274           NUMBER                         NULL,
  M201_275           NUMBER                         NULL,
  M201_276           NUMBER                         NULL,
  M201_277           NUMBER                         NULL,
  M201_278           NUMBER                         NULL,
  M201_279           NUMBER                         NULL,
  M201_280           NUMBER                         NULL,
  M201_281           NUMBER                         NULL,
  M201_282           NUMBER                         NULL,
  M201_283           NUMBER                         NULL,
  M201_284           NUMBER                         NULL,
  M201_285           NUMBER                         NULL,
  M201_286           NUMBER                         NULL,
  M201_287           NUMBER                         NULL,
  M201_288           NUMBER                         NULL,
  M201_289           NUMBER                         NULL,
  M201_290           NUMBER                         NULL,
  M201_291           NUMBER                         NULL,
  M201_292           NUMBER                         NULL,
  M201_293           NUMBER                         NULL,
  M201_294           NUMBER                         NULL,
  M201_295           NUMBER                         NULL,
  M201_296           NUMBER                         NULL,
  M201_297           NUMBER                         NULL,
  M201_298           NUMBER                         NULL,
  M201_299           NUMBER                         NULL,
  M201_300           NUMBER                         NULL,
  M201_301           NUMBER                         NULL,
  M201_302           NUMBER                         NULL,
  M201_303           NUMBER                         NULL,
  M201_304           NUMBER                         NULL,
  M201_305           NUMBER                         NULL,
  M201_306           NUMBER                         NULL,
  M201_307           NUMBER                         NULL,
  M201_308           NUMBER                         NULL,
  M201_309           NUMBER                         NULL,
  M201_310           NUMBER                         NULL,
  M201_311           NUMBER                         NULL,
  M201_312           NUMBER                         NULL,
  M201_313           NUMBER                         NULL,
  M201_314           NUMBER                         NULL,
  M201_315           NUMBER                         NULL,
  M201_316           NUMBER                         NULL,
  M201_317           NUMBER                         NULL,
  M201_318           NUMBER                         NULL,
  M201_319           NUMBER                         NULL,
  M201_320           NUMBER                         NULL,
  M201_321           NUMBER                         NULL,
  M201_322           NUMBER                         NULL,
  M201_323           NUMBER                         NULL,
  M201_324           NUMBER                         NULL,
  M201_325           NUMBER                         NULL,
  M201_326           NUMBER                         NULL,
  M201_327           NUMBER                         NULL,
  M201_328           NUMBER                         NULL,
  M201_329           NUMBER                         NULL,
  M201_330           NUMBER                         NULL,
  M201_331           NUMBER                         NULL,
  M201_332           NUMBER                         NULL,
  M201_333           NUMBER                         NULL,
  M201_334           NUMBER                         NULL,
  M201_335           NUMBER                         NULL,
  M201_336           NUMBER                         NULL,
  M201_337           NUMBER                         NULL,
  M201_338           NUMBER                         NULL,
  M201_339           NUMBER                         NULL,
  M201_340           NUMBER                         NULL,
  M201_341           NUMBER                         NULL,
  M201_342           NUMBER                         NULL,
  M201_343           NUMBER                         NULL,
  M201_344           NUMBER                         NULL,
  M201_345           NUMBER                         NULL,
  M201_346           NUMBER                         NULL,
  M201_347           NUMBER                         NULL,
  M201_348           NUMBER                         NULL,
  M201_349           NUMBER                         NULL,
  M201_350           NUMBER                         NULL,
  M201_351           NUMBER                         NULL,
  M201_352           NUMBER                         NULL,
  M201_353           NUMBER                         NULL,
  M201_354           NUMBER                         NULL,
  M201_355           NUMBER                         NULL,
  M201_356           NUMBER                         NULL,
  M201_357           NUMBER                         NULL,
  M201_358           NUMBER                         NULL,
  M201_359           NUMBER                         NULL,
  M201_360           NUMBER                         NULL,
  M201_361           NUMBER                         NULL,
  M201_362           NUMBER                         NULL,
  M201_363           NUMBER                         NULL,
  M201_364           NUMBER                         NULL,
  M201_365           NUMBER                         NULL,
  M201_366           NUMBER                         NULL,
  M201_367           NUMBER                         NULL,
  M201_368           NUMBER                         NULL,
  M201_369           NUMBER                         NULL,
  M201_370           NUMBER                         NULL,
  M201_371           NUMBER                         NULL,
  M201_372           NUMBER                         NULL,
  M201_373           NUMBER                         NULL,
  M201_374           NUMBER                         NULL,
  M201_375           NUMBER                         NULL,
  M201_376           NUMBER                         NULL,
  M201_377           NUMBER                         NULL,
  M201_378           NUMBER                         NULL,
  M201_379           NUMBER                         NULL,
  M201_380           NUMBER                         NULL,
  M201_381           NUMBER                         NULL,
  M201_382           NUMBER                         NULL,
  M201_383           NUMBER                         NULL,
  M201_384           NUMBER                         NULL,
  M201_385           NUMBER                         NULL,
  M201_386           NUMBER                         NULL,
  M201_387           NUMBER                         NULL,
  M201_388           NUMBER                         NULL,
  M201_389           NUMBER                         NULL,
  M201_390           NUMBER                         NULL,
  M201_391           NUMBER                         NULL,
  M201_392           NUMBER                         NULL,
  M201_393           NUMBER                         NULL,
  M201_394           NUMBER                         NULL,
  M201_395           NUMBER                         NULL,
  M201_396           NUMBER                         NULL,
  M201_397           NUMBER                         NULL,
  M201_398           NUMBER                         NULL,
  M201_399           NUMBER                         NULL,
  M201_400           NUMBER                         NULL,
  M201_401           NUMBER                         NULL,
  M201_402           NUMBER                         NULL,
  M201_403           NUMBER                         NULL,
  M201_404           NUMBER                         NULL,
  M201_405           NUMBER                         NULL,
  M201_406           NUMBER                         NULL,
  M201_407           NUMBER                         NULL,
  M201_408           NUMBER                         NULL,
  M201_409           NUMBER                         NULL,
  M201_410           NUMBER                         NULL,
  M201_411           NUMBER                         NULL,
  M201_412           NUMBER                         NULL,
  M201_413           NUMBER                         NULL,
  M201_414           NUMBER                         NULL,
  M201_415           NUMBER                         NULL,
  M201_416           NUMBER                         NULL,
  M201_417           NUMBER                         NULL,
  M201_418           NUMBER                         NULL,
  M201_419           NUMBER                         NULL,
  M201_420           NUMBER                         NULL,
  M201_421           NUMBER                         NULL,
  M201_422           NUMBER                         NULL,
  M201_423           NUMBER                         NULL,
  M201_424           NUMBER                         NULL,
  M201_425           NUMBER                         NULL,
  M201_426           NUMBER                         NULL,
  M201_427           NUMBER                         NULL,
  M201_428           NUMBER                         NULL,
  M201_429           NUMBER                         NULL,
  M201_430           NUMBER                         NULL,
  M201_431           NUMBER                         NULL,
  M201_432           NUMBER                         NULL,
  M201_433           NUMBER                         NULL,
  M201_434           NUMBER                         NULL,
  M201_435           NUMBER                         NULL,
  M201_436           NUMBER                         NULL,
  M201_437           NUMBER                         NULL,
  M201_438           NUMBER                         NULL,
  M201_439           NUMBER                         NULL,
  M201_440           NUMBER                         NULL,
  M201_441           NUMBER                         NULL,
  M201_442           NUMBER                         NULL,
  M201_443           NUMBER                         NULL,
  M201_444           NUMBER                         NULL,
  M201_445           NUMBER                         NULL,
  M201_446           NUMBER                         NULL,
  M201_447           NUMBER                         NULL,
  M201_448           NUMBER                         NULL,
  M201_449           NUMBER                         NULL,
  M201_450           NUMBER                         NULL,
  M201_451           NUMBER                         NULL,
  M201_452           NUMBER                         NULL,
  M201_453           NUMBER                         NULL,
  M201_454           NUMBER                         NULL,
  M201_455           NUMBER                         NULL,
  M201_456           NUMBER                         NULL,
  M201_457           NUMBER                         NULL,
  M201_458           NUMBER                         NULL,
  M201_459           NUMBER                         NULL,
  M201_460           NUMBER                         NULL,
  M201_461           NUMBER                         NULL,
  M201_462           NUMBER                         NULL,
  M201_463           NUMBER                         NULL,
  M201_464           NUMBER                         NULL,
  M201_465           NUMBER                         NULL,
  M201_466           NUMBER                         NULL,
  M201_467           NUMBER                         NULL,
  M201_468           NUMBER                         NULL,
  M201_469           NUMBER                         NULL,
  M201_470           NUMBER                         NULL,
  M201_471           NUMBER                         NULL,
  M201_472           NUMBER                         NULL,
  M201_473           NUMBER                         NULL,
  M201_474           NUMBER                         NULL,
  M201_475           NUMBER                         NULL,
  M201_476           NUMBER                         NULL,
  M201_477           NUMBER                         NULL,
  M201_478           NUMBER                         NULL,
  M201_479           NUMBER                         NULL,
  M201_480           NUMBER                         NULL,
  M201_481           NUMBER                         NULL,
  M201_482           NUMBER                         NULL,
  M201_483           NUMBER                         NULL,
  M201_484           NUMBER                         NULL,
  M201_485           NUMBER                         NULL,
  M201_486           NUMBER                         NULL,
  M201_487           NUMBER                         NULL,
  M201_488           NUMBER                         NULL,
  M201_489           NUMBER                         NULL,
  M201_490           NUMBER                         NULL,
  M201_491           NUMBER                         NULL,
  M201_492           NUMBER                         NULL,
  M201_493           NUMBER                         NULL,
  M201_494           NUMBER                         NULL,
  M201_495           NUMBER                         NULL,
  M201_496           NUMBER                         NULL,
  M201_497           NUMBER                         NULL,
  M201_498           NUMBER                         NULL,
  M201_499           NUMBER                         NULL,
  M201_500           NUMBER                         NULL,
  M201_USUCRE        VARCHAR2(30 BYTE)              NULL,
  M201_DATCRE        DATE                           NULL,
  M201_USUMOD        VARCHAR2(30 BYTE)              NULL,
  M201_DATMOD        DATE                           NULL
)
;


CREATE TABLE TCMP_MOD201_R3
(
  M201_M201_CEC_COD  VARCHAR2(4 BYTE)               NULL,
  M201_M201_NUM      NUMBER                         NULL,
  M201_501           NUMBER                         NULL,
  M201_502           NUMBER                         NULL,
  M201_503           NUMBER                         NULL,
  M201_504           NUMBER                         NULL,
  M201_505           NUMBER                         NULL,
  M201_506           NUMBER                         NULL,
  M201_507           NUMBER                         NULL,
  M201_508           NUMBER                         NULL,
  M201_509           NUMBER                         NULL,
  M201_510           NUMBER                         NULL,
  M201_511           NUMBER                         NULL,
  M201_512           NUMBER                         NULL,
  M201_513           NUMBER                         NULL,
  M201_514           NUMBER                         NULL,
  M201_515           NUMBER                         NULL,
  M201_516           NUMBER                         NULL,
  M201_517           NUMBER                         NULL,
  M201_518           NUMBER                         NULL,
  M201_519           NUMBER                         NULL,
  M201_520           NUMBER                         NULL,
  M201_521           NUMBER                         NULL,
  M201_522           NUMBER                         NULL,
  M201_523           NUMBER                         NULL,
  M201_524           NUMBER                         NULL,
  M201_525           NUMBER                         NULL,
  M201_526           NUMBER                         NULL,
  M201_527           NUMBER                         NULL,
  M201_528           NUMBER                         NULL,
  M201_529           NUMBER                         NULL,
  M201_530           NUMBER                         NULL,
  M201_531           NUMBER                         NULL,
  M201_532           NUMBER                         NULL,
  M201_533           NUMBER                         NULL,
  M201_534           NUMBER                         NULL,
  M201_535           NUMBER                         NULL,
  M201_536           NUMBER                         NULL,
  M201_537           NUMBER                         NULL,
  M201_538           NUMBER                         NULL,
  M201_539           NUMBER                         NULL,
  M201_540           NUMBER                         NULL,
  M201_541           NUMBER                         NULL,
  M201_542           NUMBER                         NULL,
  M201_543           NUMBER                         NULL,
  M201_544           NUMBER                         NULL,
  M201_545           NUMBER                         NULL,
  M201_546           NUMBER                         NULL,
  M201_547           NUMBER                         NULL,
  M201_548           NUMBER                         NULL,
  M201_549           NUMBER                         NULL,
  M201_550           NUMBER                         NULL,
  M201_551           NUMBER                         NULL,
  M201_552           NUMBER                         NULL,
  M201_553           NUMBER                         NULL,
  M201_554           NUMBER                         NULL,
  M201_555           NUMBER                         NULL,
  M201_556           NUMBER                         NULL,
  M201_557           NUMBER                         NULL,
  M201_558           NUMBER                         NULL,
  M201_558_2         NUMBER                         NULL,
  M201_559           NUMBER                         NULL,
  M201_560           NUMBER                         NULL,
  M201_561           NUMBER                         NULL,
  M201_562           NUMBER                         NULL,
  M201_563           NUMBER                         NULL,
  M201_564           NUMBER                         NULL,
  M201_565           NUMBER                         NULL,
  M201_566           NUMBER                         NULL,
  M201_567           NUMBER                         NULL,
  M201_568           NUMBER                         NULL,
  M201_569           NUMBER                         NULL,
  M201_570           NUMBER                         NULL,
  M201_571           NUMBER                         NULL,
  M201_572           NUMBER                         NULL,
  M201_573           NUMBER                         NULL,
  M201_574           NUMBER                         NULL,
  M201_575           NUMBER                         NULL,
  M201_576           NUMBER                         NULL,
  M201_577           NUMBER                         NULL,
  M201_578           NUMBER                         NULL,
  M201_579           NUMBER                         NULL,
  M201_580           NUMBER                         NULL,
  M201_581           NUMBER                         NULL,
  M201_582           NUMBER                         NULL,
  M201_583           NUMBER                         NULL,
  M201_584           NUMBER                         NULL,
  M201_585           NUMBER                         NULL,
  M201_586           NUMBER                         NULL,
  M201_587           NUMBER                         NULL,
  M201_588           NUMBER                         NULL,
  M201_589           NUMBER                         NULL,
  M201_590           NUMBER                         NULL,
  M201_591           NUMBER                         NULL,
  M201_592           NUMBER                         NULL,
  M201_593           NUMBER                         NULL,
  M201_594           NUMBER                         NULL,
  M201_595           NUMBER                         NULL,
  M201_596           NUMBER                         NULL,
  M201_597           NUMBER                         NULL,
  M201_598           NUMBER                         NULL,
  M201_599           NUMBER                         NULL,
  M201_600           NUMBER                         NULL,
  M201_601           NUMBER                         NULL,
  M201_602           NUMBER                         NULL,
  M201_603           NUMBER                         NULL,
  M201_604           NUMBER                         NULL,
  M201_605           NUMBER                         NULL,
  M201_606           NUMBER                         NULL,
  M201_607           NUMBER                         NULL,
  M201_608           NUMBER                         NULL,
  M201_609           NUMBER                         NULL,
  M201_610           NUMBER                         NULL,
  M201_611           NUMBER                         NULL,
  M201_612           NUMBER                         NULL,
  M201_613           NUMBER                         NULL,
  M201_614           NUMBER                         NULL,
  M201_615           NUMBER                         NULL,
  M201_616           NUMBER                         NULL,
  M201_617           NUMBER                         NULL,
  M201_618           NUMBER                         NULL,
  M201_619           NUMBER                         NULL,
  M201_620           NUMBER                         NULL,
  M201_621           NUMBER                         NULL,
  M201_622           NUMBER                         NULL,
  M201_623           NUMBER                         NULL,
  M201_624           NUMBER                         NULL,
  M201_625           NUMBER                         NULL,
  M201_626           NUMBER                         NULL,
  M201_627           NUMBER                         NULL,
  M201_628           NUMBER                         NULL,
  M201_629           NUMBER                         NULL,
  M201_630           NUMBER                         NULL,
  M201_631           NUMBER                         NULL,
  M201_632           NUMBER                         NULL,
  M201_633           NUMBER                         NULL,
  M201_634           NUMBER                         NULL,
  M201_635           NUMBER                         NULL,
  M201_636           NUMBER                         NULL,
  M201_637           NUMBER                         NULL,
  M201_638           NUMBER                         NULL,
  M201_639           NUMBER                         NULL,
  M201_640           NUMBER                         NULL,
  M201_641           NUMBER                         NULL,
  M201_642           NUMBER                         NULL,
  M201_643           NUMBER                         NULL,
  M201_644           NUMBER                         NULL,
  M201_645           NUMBER                         NULL,
  M201_646           NUMBER                         NULL,
  M201_647           NUMBER                         NULL,
  M201_648           NUMBER                         NULL,
  M201_649           NUMBER                         NULL,
  M201_650           NUMBER                         NULL,
  M201_651           NUMBER                         NULL,
  M201_652           NUMBER                         NULL,
  M201_653           NUMBER                         NULL,
  M201_654           NUMBER                         NULL,
  M201_655           NUMBER                         NULL,
  M201_656           NUMBER                         NULL,
  M201_657           NUMBER                         NULL,
  M201_658           NUMBER                         NULL,
  M201_659           NUMBER                         NULL,
  M201_660           NUMBER                         NULL,
  M201_661           NUMBER                         NULL,
  M201_662           NUMBER                         NULL,
  M201_663           NUMBER                         NULL,
  M201_664           NUMBER                         NULL,
  M201_665           NUMBER                         NULL,
  M201_666           NUMBER                         NULL,
  M201_667           NUMBER                         NULL,
  M201_668           NUMBER                         NULL,
  M201_669           NUMBER                         NULL,
  M201_670           NUMBER                         NULL,
  M201_671           NUMBER                         NULL,
  M201_672           NUMBER                         NULL,
  M201_673           NUMBER                         NULL,
  M201_674           NUMBER                         NULL,
  M201_675           NUMBER                         NULL,
  M201_676           NUMBER                         NULL,
  M201_677           NUMBER                         NULL,
  M201_678           NUMBER                         NULL,
  M201_679           NUMBER                         NULL,
  M201_680           NUMBER                         NULL,
  M201_681           NUMBER                         NULL,
  M201_682           NUMBER                         NULL,
  M201_683           NUMBER                         NULL,
  M201_684           NUMBER                         NULL,
  M201_685           NUMBER                         NULL,
  M201_686           NUMBER                         NULL,
  M201_687           NUMBER                         NULL,
  M201_688           NUMBER                         NULL,
  M201_689           NUMBER                         NULL,
  M201_690           NUMBER                         NULL,
  M201_691           NUMBER                         NULL,
  M201_692           NUMBER                         NULL,
  M201_693           NUMBER                         NULL,
  M201_694           NUMBER                         NULL,
  M201_695           NUMBER                         NULL,
  M201_696           NUMBER                         NULL,
  M201_697           NUMBER                         NULL,
  M201_698           NUMBER                         NULL,
  M201_699           NUMBER                         NULL,
  M201_700           NUMBER                         NULL,
  M201_701           NUMBER                         NULL,
  M201_702           NUMBER                         NULL,
  M201_703           NUMBER                         NULL,
  M201_704           NUMBER                         NULL,
  M201_705           NUMBER                         NULL,
  M201_706           NUMBER                         NULL,
  M201_707           NUMBER                         NULL,
  M201_708           NUMBER                         NULL,
  M201_709           NUMBER                         NULL,
  M201_710           NUMBER                         NULL,
  M201_711           NUMBER                         NULL,
  M201_712           NUMBER                         NULL,
  M201_713           NUMBER                         NULL,
  M201_714           NUMBER                         NULL,
  M201_715           NUMBER                         NULL,
  M201_716           NUMBER                         NULL,
  M201_717           NUMBER                         NULL,
  M201_718           NUMBER                         NULL,
  M201_719           NUMBER                         NULL,
  M201_720           NUMBER                         NULL,
  M201_721           NUMBER                         NULL,
  M201_722           NUMBER                         NULL,
  M201_723           NUMBER                         NULL,
  M201_724           NUMBER                         NULL,
  M201_725           NUMBER                         NULL,
  M201_726           NUMBER                         NULL,
  M201_727           NUMBER                         NULL,
  M201_728           NUMBER                         NULL,
  M201_729           NUMBER                         NULL,
  M201_730           NUMBER                         NULL,
  M201_731           NUMBER                         NULL,
  M201_732           NUMBER                         NULL,
  M201_733           NUMBER                         NULL,
  M201_734           NUMBER                         NULL,
  M201_735           NUMBER                         NULL,
  M201_736           NUMBER                         NULL,
  M201_737           NUMBER                         NULL,
  M201_738           NUMBER                         NULL,
  M201_739           NUMBER                         NULL,
  M201_740           NUMBER                         NULL,
  M201_741           NUMBER                         NULL,
  M201_742           NUMBER                         NULL,
  M201_743           NUMBER                         NULL,
  M201_744           NUMBER                         NULL,
  M201_745           NUMBER                         NULL,
  M201_746           NUMBER                         NULL,
  M201_747           NUMBER                         NULL,
  M201_748           NUMBER                         NULL,
  M201_749           NUMBER                         NULL,
  M201_750           NUMBER                         NULL,
  M201_USUCRE        VARCHAR2(30 BYTE)              NULL,
  M201_DATCRE        DATE                           NULL,
  M201_USUMOD        VARCHAR2(30 BYTE)              NULL,
  M201_DATMOD        DATE                           NULL
)
;


CREATE TABLE TCMP_MOD201_R4
(
  M201_M201_CEC_COD  VARCHAR2(4 BYTE)               NULL,
  M201_M201_NUM      NUMBER                         NULL,
  M201_751           NUMBER                         NULL,
  M201_752           NUMBER                         NULL,
  M201_753           NUMBER                         NULL,
  M201_754           NUMBER                         NULL,
  M201_755           NUMBER                         NULL,
  M201_756           NUMBER                         NULL,
  M201_757           NUMBER                         NULL,
  M201_758           NUMBER                         NULL,
  M201_759           NUMBER                         NULL,
  M201_760           NUMBER                         NULL,
  M201_761           NUMBER                         NULL,
  M201_762           NUMBER                         NULL,
  M201_763           NUMBER                         NULL,
  M201_764           NUMBER                         NULL,
  M201_765           NUMBER                         NULL,
  M201_766           NUMBER                         NULL,
  M201_767           NUMBER                         NULL,
  M201_768           NUMBER                         NULL,
  M201_769           NUMBER                         NULL,
  M201_770           NUMBER                         NULL,
  M201_771           NUMBER                         NULL,
  M201_772           NUMBER                         NULL,
  M201_773           NUMBER                         NULL,
  M201_774           NUMBER                         NULL,
  M201_775           NUMBER                         NULL,
  M201_776           NUMBER                         NULL,
  M201_777           NUMBER                         NULL,
  M201_778           NUMBER                         NULL,
  M201_779           NUMBER                         NULL,
  M201_780           NUMBER                         NULL,
  M201_781           NUMBER                         NULL,
  M201_782           NUMBER                         NULL,
  M201_783           NUMBER                         NULL,
  M201_784           NUMBER                         NULL,
  M201_785           NUMBER                         NULL,
  M201_786           NUMBER                         NULL,
  M201_787           NUMBER                         NULL,
  M201_788           NUMBER                         NULL,
  M201_789           NUMBER                         NULL,
  M201_790           NUMBER                         NULL,
  M201_791           NUMBER                         NULL,
  M201_792           NUMBER                         NULL,
  M201_793           NUMBER                         NULL,
  M201_794           NUMBER                         NULL,
  M201_795           NUMBER                         NULL,
  M201_796           NUMBER                         NULL,
  M201_797           NUMBER                         NULL,
  M201_798           NUMBER                         NULL,
  M201_799           NUMBER                         NULL,
  M201_800           NUMBER                         NULL,
  M201_801           NUMBER                         NULL,
  M201_802           NUMBER                         NULL,
  M201_803           NUMBER                         NULL,
  M201_804           NUMBER                         NULL,
  M201_805           NUMBER                         NULL,
  M201_806           NUMBER                         NULL,
  M201_807           NUMBER                         NULL,
  M201_808           NUMBER                         NULL,
  M201_809           NUMBER                         NULL,
  M201_810           NUMBER                         NULL,
  M201_811           NUMBER                         NULL,
  M201_812           NUMBER                         NULL,
  M201_813           NUMBER                         NULL,
  M201_814           NUMBER                         NULL,
  M201_815           NUMBER                         NULL,
  M201_816           NUMBER                         NULL,
  M201_817           NUMBER                         NULL,
  M201_818           NUMBER                         NULL,
  M201_819           NUMBER                         NULL,
  M201_820           NUMBER                         NULL,
  M201_821           NUMBER                         NULL,
  M201_822           NUMBER                         NULL,
  M201_823           NUMBER                         NULL,
  M201_824           NUMBER                         NULL,
  M201_825           NUMBER                         NULL,
  M201_826           NUMBER                         NULL,
  M201_827           NUMBER                         NULL,
  M201_828           NUMBER                         NULL,
  M201_829           NUMBER                         NULL,
  M201_830           NUMBER                         NULL,
  M201_831           NUMBER                         NULL,
  M201_832           NUMBER                         NULL,
  M201_833           NUMBER                         NULL,
  M201_834           NUMBER                         NULL,
  M201_835           NUMBER                         NULL,
  M201_836           NUMBER                         NULL,
  M201_837           NUMBER                         NULL,
  M201_838           NUMBER                         NULL,
  M201_839           NUMBER                         NULL,
  M201_840           NUMBER                         NULL,
  M201_841           NUMBER                         NULL,
  M201_842           NUMBER                         NULL,
  M201_843           NUMBER                         NULL,
  M201_844           NUMBER                         NULL,
  M201_845           NUMBER                         NULL,
  M201_846           NUMBER                         NULL,
  M201_847           NUMBER                         NULL,
  M201_848           NUMBER                         NULL,
  M201_849           NUMBER                         NULL,
  M201_850           NUMBER                         NULL,
  M201_851           NUMBER                         NULL,
  M201_852           NUMBER                         NULL,
  M201_853           NUMBER                         NULL,
  M201_854           NUMBER                         NULL,
  M201_855           NUMBER                         NULL,
  M201_856           NUMBER                         NULL,
  M201_857           NUMBER                         NULL,
  M201_858           NUMBER                         NULL,
  M201_859           NUMBER                         NULL,
  M201_860           NUMBER                         NULL,
  M201_861           NUMBER                         NULL,
  M201_862           NUMBER                         NULL,
  M201_863           NUMBER                         NULL,
  M201_864           NUMBER                         NULL,
  M201_865           NUMBER                         NULL,
  M201_866           NUMBER                         NULL,
  M201_867           NUMBER                         NULL,
  M201_868           NUMBER                         NULL,
  M201_869           NUMBER                         NULL,
  M201_870           NUMBER                         NULL,
  M201_871           NUMBER                         NULL,
  M201_872           NUMBER                         NULL,
  M201_873           NUMBER                         NULL,
  M201_874           NUMBER                         NULL,
  M201_875           NUMBER                         NULL,
  M201_876           NUMBER                         NULL,
  M201_877           NUMBER                         NULL,
  M201_878           NUMBER                         NULL,
  M201_879           NUMBER                         NULL,
  M201_880           NUMBER                         NULL,
  M201_881           NUMBER                         NULL,
  M201_882           NUMBER                         NULL,
  M201_883           NUMBER                         NULL,
  M201_884           NUMBER                         NULL,
  M201_885           NUMBER                         NULL,
  M201_886           NUMBER                         NULL,
  M201_887           NUMBER                         NULL,
  M201_888           NUMBER                         NULL,
  M201_889           NUMBER                         NULL,
  M201_890           NUMBER                         NULL,
  M201_891           NUMBER                         NULL,
  M201_892           NUMBER                         NULL,
  M201_893           NUMBER                         NULL,
  M201_894           NUMBER                         NULL,
  M201_895           NUMBER                         NULL,
  M201_896           NUMBER                         NULL,
  M201_897           NUMBER                         NULL,
  M201_898           NUMBER                         NULL,
  M201_899           NUMBER                         NULL,
  M201_900           NUMBER                         NULL,
  M201_901           NUMBER                         NULL,
  M201_902           NUMBER                         NULL,
  M201_903           NUMBER                         NULL,
  M201_904           NUMBER                         NULL,
  M201_905           NUMBER                         NULL,
  M201_906           NUMBER                         NULL,
  M201_907           NUMBER                         NULL,
  M201_908           NUMBER                         NULL,
  M201_909           NUMBER                         NULL,
  M201_910           NUMBER                         NULL,
  M201_911           NUMBER                         NULL,
  M201_912           NUMBER                         NULL,
  M201_913           NUMBER                         NULL,
  M201_914           NUMBER                         NULL,
  M201_915           NUMBER                         NULL,
  M201_916           NUMBER                         NULL,
  M201_917           NUMBER                         NULL,
  M201_918           NUMBER                         NULL,
  M201_919           NUMBER                         NULL,
  M201_920           NUMBER                         NULL,
  M201_921           NUMBER                         NULL,
  M201_922           NUMBER                         NULL,
  M201_923           NUMBER                         NULL,
  M201_924           NUMBER                         NULL,
  M201_925           NUMBER                         NULL,
  M201_926           NUMBER                         NULL,
  M201_927           NUMBER                         NULL,
  M201_928           NUMBER                         NULL,
  M201_929           NUMBER                         NULL,
  M201_930           NUMBER                         NULL,
  M201_931           NUMBER                         NULL,
  M201_932           NUMBER                         NULL,
  M201_933           NUMBER                         NULL,
  M201_934           NUMBER                         NULL,
  M201_935           NUMBER                         NULL,
  M201_936           NUMBER                         NULL,
  M201_937           NUMBER                         NULL,
  M201_938           NUMBER                         NULL,
  M201_939           NUMBER                         NULL,
  M201_940           NUMBER                         NULL,
  M201_941           NUMBER                         NULL,
  M201_942           NUMBER                         NULL,
  M201_943           NUMBER                         NULL,
  M201_944           NUMBER                         NULL,
  M201_945           NUMBER                         NULL,
  M201_946           NUMBER                         NULL,
  M201_947           NUMBER                         NULL,
  M201_948           NUMBER                         NULL,
  M201_949           NUMBER                         NULL,
  M201_950           NUMBER                         NULL,
  M201_951           NUMBER                         NULL,
  M201_952           NUMBER                         NULL,
  M201_953           NUMBER                         NULL,
  M201_954           NUMBER                         NULL,
  M201_955           NUMBER                         NULL,
  M201_956           NUMBER                         NULL,
  M201_957           NUMBER                         NULL,
  M201_958           NUMBER                         NULL,
  M201_959           NUMBER                         NULL,
  M201_960           NUMBER                         NULL,
  M201_961           NUMBER                         NULL,
  M201_962           NUMBER                         NULL,
  M201_963           NUMBER                         NULL,
  M201_964           NUMBER                         NULL,
  M201_965           NUMBER                         NULL,
  M201_966           NUMBER                         NULL,
  M201_967           NUMBER                         NULL,
  M201_968           NUMBER                         NULL,
  M201_969           NUMBER                         NULL,
  M201_970           NUMBER                         NULL,
  M201_971           NUMBER                         NULL,
  M201_972           NUMBER                         NULL,
  M201_973           NUMBER                         NULL,
  M201_974           NUMBER                         NULL,
  M201_975           NUMBER                         NULL,
  M201_976           NUMBER                         NULL,
  M201_977           NUMBER                         NULL,
  M201_978           NUMBER                         NULL,
  M201_979           NUMBER                         NULL,
  M201_980           NUMBER                         NULL,
  M201_981           NUMBER                         NULL,
  M201_982           NUMBER                         NULL,
  M201_983           NUMBER                         NULL,
  M201_984           NUMBER                         NULL,
  M201_985           NUMBER                         NULL,
  M201_986           NUMBER                         NULL,
  M201_987           NUMBER                         NULL,
  M201_988           NUMBER                         NULL,
  M201_989           NUMBER                         NULL,
  M201_990           NUMBER                         NULL,
  M201_991           NUMBER                         NULL,
  M201_992           NUMBER                         NULL,
  M201_993           NUMBER                         NULL,
  M201_994           NUMBER                         NULL,
  M201_995           NUMBER                         NULL,
  M201_996           NUMBER                         NULL,
  M201_997           NUMBER                         NULL,
  M201_998           NUMBER                         NULL,
  M201_999           NUMBER                         NULL,
  M201_USUCRE        VARCHAR2(30 BYTE)              NULL,
  M201_DATCRE        DATE                           NULL,
  M201_USUMOD        VARCHAR2(30 BYTE)              NULL,
  M201_DATMOD        DATE                           NULL
)
;


CREATE TABLE TCMP_MOD201_REPR
(
  REP_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  REP_M201_NUM    NUMBER(5)                         NULL,
  REP_SEQ         NUMBER(3)                         NULL,
  REP_NIF_NIF     VARCHAR2(12 BYTE)                 NULL,
  REP_DATPOD      DATE                              NULL,
  REP_NOTARIA     VARCHAR2(20 BYTE)                 NULL,
  REP_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  REP_DATCRE      DATE                              NULL,
  REP_NIF_NOMFIS  VARCHAR2(40 BYTE)                 NULL,
  REP_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  REP_DATMOD      DATE                              NULL
)
;


CREATE TABLE TCMP_MOD201_SOCIOS
(
  M201_SOC_CEC_COD  VARCHAR2(4 BYTE)                NULL,
  M201_SOC_NUM      NUMBER                          NULL,
  M201_SOC_SEQ      NUMBER                          NULL,
  M201_SOC_NIF      VARCHAR2(12 BYTE)               NULL,
  M201_SOC_RPTE     VARCHAR2(1 BYTE)                NULL,
  M201_SOC_FJ       VARCHAR2(1 BYTE)                NULL,
  M201_SOC_NOMFIS   VARCHAR2(40 BYTE)               NULL,
  M201_SOC_PRV      VARCHAR2(3 BYTE)                NULL,
  M201_SOC_BASIMP   NUMBER                          NULL,
  M201_SOC_PTE      NUMBER                          NULL,
  M201_SOC_USUCRE   VARCHAR2(30 BYTE)               NULL,
  M201_SOC_DATCRE   DATE                            NULL,
  M201_SOC_USUMOD   VARCHAR2(30 BYTE)               NULL,
  M201_SOC_DATMOD   DATE                            NULL
)
;


CREATE TABLE TCMP_MOD201_VINC
(
  VIN_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  VIN_M201_NUM  NUMBER(5)                           NULL,
  VIN_SEQ       NUMBER(4)                           NULL,
  VIN_NIF       VARCHAR2(15 BYTE)                   NULL,
  VIN_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  VIN_DATCRE    DATE                                NULL,
  VIN_PRV       VARCHAR2(2 BYTE)                    NULL,
  VIN_FJ        VARCHAR2(1 BYTE)                    NULL,
  VIN_TIP       VARCHAR2(1 BYTE)                    NULL,
  VIN_TIPOPE    NUMBER(2)                           NULL,
  VIN_INGPAG    VARCHAR2(1 BYTE)                    NULL,
  VIN_VAL       VARCHAR2(2 BYTE)                    NULL,
  VIN_IMP       NUMBER(17,2)                        NULL,
  VIN_NOMFIS    VARCHAR2(40 BYTE)                   NULL,
  VIN_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  VIN_DATMOD    DATE                                NULL
)
;


CREATE TABLE TCMP_MOD202
(
  M202_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M202_FIS_COD     VARCHAR2(4 BYTE)                 NULL,
  M202_EXC         VARCHAR2(4 BYTE)                 NULL,
  M202_PRD         VARCHAR2(2 BYTE)                 NULL,
  M202_MON_COD     VARCHAR2(1 BYTE)                 NULL,
  M202_PAGFRA1     NUMBER(15,3)                     NULL,
  M202_ING         NUMBER(15,3)                     NULL,
  M202_PAGFRA2     NUMBER(15,3)                     NULL,
  M202_PTE         NUMBER(5,2)                      NULL,
  M202_RESULT      NUMBER(15,3)                     NULL,
  M202_PAGFRA3     NUMBER(15,3)                     NULL,
  M202_PAGHASTA    NUMBER(15,3)                     NULL,
  M202_RESULT2     NUMBER(15,3)                     NULL,
  M202_PAGRESTO    NUMBER(15,3)                     NULL,
  M202_RESULT3     NUMBER(15,3)                     NULL,
  M202_TOTPAG      NUMBER(15,3)                     NULL,
  M202_BONIF       NUMBER(15,3)                     NULL,
  M202_RETING      NUMBER(15,3)                     NULL,
  M202_PAGFRAANT   NUMBER(15,3)                     NULL,
  M202_TOTING      NUMBER(15,3)                     NULL,
  M202_DATDECL     DATE                             NULL,
  M202_FPAEFE      VARCHAR2(1 BYTE)                 NULL,
  M202_IMPING      NUMBER(15,3)                     NULL,
  M202_FPAADE      VARCHAR2(1 BYTE)                 NULL,
  M202_BAN         VARCHAR2(4 BYTE)                 NULL,
  M202_OFI         VARCHAR2(4 BYTE)                 NULL,
  M202_DCC         VARCHAR2(2 BYTE)                 NULL,
  M202_CCR         VARCHAR2(10 BYTE)                NULL,
  M202_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M202_DATCRE      DATE                             NULL,
  M202_USUMOD      VARCHAR2(30 BYTE)                NULL,
  M202_DATMOD      VARCHAR2(240 BYTE)               NULL,
  M202_RESULTANT1  NUMBER(15,3)                     NULL,
  M202_SOCBASGEN   NUMBER(15,3)                     NULL,
  M202_SOCBASESP   NUMBER(15,3)                     NULL,
  M202_SOCIMPGEN   NUMBER(15,3)                     NULL,
  M202_SOCIMPESP   NUMBER(15,3)                     NULL,
  M202_SOCIMPTOT   NUMBER(15,3)                     NULL,
  M202_RESULTANT2  NUMBER(15,3)                     NULL,
  M202_NUMDECLANT  VARCHAR2(20 BYTE)                NULL,
  M202_DECLCOMP    VARCHAR2(1 BYTE)                 NULL,
  M202_DECLNEG     VARCHAR2(1 BYTE)                 NULL,
  M202_DATINIPRD   DATE                             NULL,
  M202_GRANEMP     VARCHAR2(1 BYTE)                 NULL,
  M202_NUM001      NUMBER(15,3)                     NULL,
  M202_NUM002      NUMBER(15,3)                     NULL,
  M202_NUM003      NUMBER(15,3)                     NULL,
  M202_NUM004      NUMBER(15,3)                     NULL,
  M202_OPC001      VARCHAR2(1 BYTE)                 NULL,
  M202_OPC002      VARCHAR2(1 BYTE)                 NULL,
  M202_OPC003      VARCHAR2(1 BYTE)                 NULL,
  M202_OPC004      VARCHAR2(1 BYTE)                 NULL,
  M202_OPC005      VARCHAR2(1 BYTE)                 NULL,
  M202_NUM005      NUMBER(15,3)                     NULL,
  M202_NUM006      NUMBER(15,3)                     NULL,
  M202_NUM007      NUMBER(15,3)                     NULL,
  M202_NUM008      NUMBER(15,3)                     NULL,
  M202_NUM009      NUMBER(15,3)                     NULL,
  M202_NUM010      NUMBER(15,3)                     NULL,
  M202_NUM011      NUMBER(15,3)                     NULL,
  M202_NUM012      NUMBER(15,3)                     NULL,
  M202_OPC006      VARCHAR2(5 BYTE)                 NULL,
  M202_NUM013      NUMBER(15,3)                     NULL,
  M202_NUM014      NUMBER(15,3)                     NULL,
  M202_IBNPAI      VARCHAR2(2 BYTE)                 NULL,
  M202_IBNDCC      VARCHAR2(2 BYTE)                 NULL
)
;


CREATE TABLE TCMP_MOD216
(
  M216_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M216_FIS_COD     VARCHAR2(4 BYTE)                 NULL,
  M216_EXC         VARCHAR2(4 BYTE)                 NULL,
  M216_PRD         VARCHAR2(2 BYTE)                 NULL,
  M216_MON_COD     VARCHAR2(1 BYTE)                 NULL,
  M216_NEG         VARCHAR2(1 BYTE)                 NULL,
  M216_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M216_DATCRE      DATE                             NULL,
  M216_NUM001      NUMBER(15,3)                     NULL,
  M216_NUM002      NUMBER(15,3)                     NULL,
  M216_NUM003      NUMBER(15,3)                     NULL,
  M216_NUM004      NUMBER(15,3)                     NULL,
  M216_NUM005      NUMBER(15,3)                     NULL,
  M216_NUM006      NUMBER(15,3)                     NULL,
  M216_NUM007      NUMBER(15,3)                     NULL,
  M216_IMPING      NUMBER(15,3)                     NULL,
  M216_IBN         VARCHAR2(34 BYTE)                NULL,
  M216_DECLCOM     VARCHAR2(1 BYTE)                 NULL,
  M216_NUMDECLANT  VARCHAR2(13 BYTE)                NULL,
  M216_USUMOD      VARCHAR2(30 BYTE)                NULL,
  M216_DATMOD      VARCHAR2(240 BYTE)               NULL
)
;


CREATE TABLE TCMP_MOD340
(
  M340_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M340_FIS_COD     VARCHAR2(4 BYTE)                 NULL,
  M340_EXC         VARCHAR2(4 BYTE)                 NULL,
  M340_PRD         VARCHAR2(2 BYTE)                 NULL,
  M340_SOP         VARCHAR2(1 BYTE)                 NULL,
  M340_MON_COD     VARCHAR2(2 BYTE)                 NULL,
  M340_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M340_DATCRE      DATE                             NULL,
  M340_FECHA       DATE                             NULL,
  M340_DECL_COMP   VARCHAR2(1 BYTE)                 NULL,
  M340_DECL_SUST   VARCHAR2(1 BYTE)                 NULL,
  M340_NUMDECLANT  VARCHAR2(13 BYTE)                NULL,
  M340_NUMDECL     VARCHAR2(13 BYTE)                NULL,
  M340_USUMOD      VARCHAR2(30 BYTE)                NULL,
  M340_DATMOD      DATE                             NULL,
  M340_CODELEIVA   VARCHAR2(16 BYTE)                NULL
)
;


CREATE TABLE TCMP_MOD340_R1
(
  M3401_CEC_COD  VARCHAR2(4 BYTE)                   NULL,
  M3401_FIS_COD  VARCHAR2(4 BYTE)                   NULL,
  M3401_EXC      VARCHAR2(4 BYTE)                   NULL,
  M3401_PRD      VARCHAR2(2 BYTE)                   NULL,
  M3401_SEQ      NUMBER(5)                          NULL,
  M3401_TIPREG   VARCHAR2(1 BYTE)                   NULL,
  M3401_USUCRE   VARCHAR2(30 BYTE)                  NULL,
  M3401_DATCRE   DATE                               NULL,
  M3401_DAT      DATE                               NULL,
  M3401_BIM      NUMBER(15,3)                       NULL,
  M3401_PTEIVA   NUMBER(5,2)                        NULL,
  M3401_QUOIMS   NUMBER(15,3)                       NULL,
  M3401_TOTFAC   NUMBER(15,3)                       NULL,
  M3401_NOM      VARCHAR2(40 BYTE)                  NULL,
  M3401_NIF      VARCHAR2(13 BYTE)                  NULL,
  M3401_QUODED   NUMBER(15,3)                       NULL,
  M3401_TIPNIF   VARCHAR2(1 BYTE)                   NULL,
  M3401_NUMFAC   VARCHAR2(40 BYTE)                  NULL,
  M3401_CLA      VARCHAR2(1 BYTE)                   NULL,
  M3401_TIQINI   NUMBER(6)                          NULL,
  M3401_TIQFIN   NUMBER(6)                          NULL,
  M3401_PTEREQ   NUMBER(3,2)                        NULL,
  M3401_QUOREQ   NUMBER(15,3)                       NULL,
  M3401_PAI      VARCHAR2(2 BYTE)                   NULL,
  M3401_TIPOPE   VARCHAR2(1 BYTE)                   NULL,
  M3401_CLADCL   VARCHAR2(1 BYTE)                   NULL,
  M3401_PLAOPE   NUMBER(1)                          NULL,
  M3401_DES      VARCHAR2(35 BYTE)                  NULL,
  M3401_DOM      VARCHAR2(40 BYTE)                  NULL,
  M3401_POB      VARCHAR2(22 BYTE)                  NULL,
  M3401_CPO      VARCHAR2(10 BYTE)                  NULL,
  M3401_USUMOD   VARCHAR2(30 BYTE)                  NULL,
  M3401_DATMOD   DATE                               NULL,
  M3401_NIFEXT   VARCHAR2(20 BYTE)                  NULL,
  M3401_SITIMM   VARCHAR2(1 BYTE)                   NULL,
  M3401_REFIMM   VARCHAR2(25 BYTE)                  NULL,
  M3401_IMPMET   NUMBER(15,2)                       NULL,
  M3401_EXCMET   VARCHAR2(4 BYTE)                   NULL,
  M3401_IMPTRF   NUMBER(15,2)                       NULL,
  M3401_DIACOB   DATE                               NULL,
  M3401_IMPCOB   NUMBER(13,2)                       NULL,
  M3401_TIPCOB   VARCHAR2(1 BYTE)                   NULL,
  M3401_CCR      VARCHAR2(34 BYTE)                  NULL
)
;


CREATE TABLE TCMP_MOD349_R1
(
  M349_CEC_COD     VARCHAR2(4 BYTE)                 NULL,
  M349_FIS_COD     VARCHAR2(4 BYTE)                 NULL,
  M349_EXC         VARCHAR2(4 BYTE)                 NULL,
  M349_PRD         VARCHAR2(2 BYTE)                 NULL,
  M349_DAT         DATE                             NULL,
  M349_NUMDECL     VARCHAR2(13 BYTE)                NULL,
  M349_DECL_COMP   VARCHAR2(1 BYTE)                 NULL,
  M349_NUMDECLANT  VARCHAR2(13 BYTE)                NULL,
  M349_DECL_SUST   VARCHAR2(1 BYTE)                 NULL,
  M349_DATCRE      DATE                             NULL,
  M349_USUCRE      VARCHAR2(30 BYTE)                NULL,
  M349_DATMOD      DATE                             NULL,
  M349_USUMOD      VARCHAR2(30 BYTE)                NULL
)
;


CREATE TABLE TCMP_MOD349_R2
(
  M3492_CEC_COD     VARCHAR2(4 BYTE)                NULL,
  M3492_FIS_COD     VARCHAR2(4 BYTE)                NULL,
  M3492_EXC         VARCHAR2(4 BYTE)                NULL,
  M3492_PRD         VARCHAR2(2 BYTE)                NULL,
  M3492_SEQ         NUMBER(10)                      NULL,
  M3492_PAIABR      VARCHAR2(2 BYTE)                NULL,
  M3492_NIFOPE      VARCHAR2(13 BYTE)               NULL,
  M3492_NOM         VARCHAR2(40 BYTE)               NULL,
  M3492_DATCRE      DATE                            NULL,
  M3492_CLAVE       VARCHAR2(240 BYTE)              NULL,
  M3492_RECTIF      VARCHAR2(1 BYTE)                NULL,
  M3492_RECTIF_EXC  VARCHAR2(4 BYTE)                NULL,
  M3492_RECTIF_PRD  VARCHAR2(2 BYTE)                NULL,
  M3492_RECTIF_BIM  NUMBER(15,3)                    NULL,
  M3492_RECTIF_ANT  NUMBER(15,3)                    NULL,
  M3492_USUCRE      VARCHAR2(30 BYTE)               NULL,
  M3492_DATMOD      DATE                            NULL,
  M3492_USUMOD      VARCHAR2(30 BYTE)               NULL
)
;


CREATE TABLE TCMP_OPERFISCALS
(
  OPA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  OPA_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  OPA_SEQ      NUMBER(10)                           NULL,
  OPA_ANY      NUMBER(4)                            NULL,
  OPA_DESOPE   VARCHAR2(30 BYTE)                    NULL,
  OPA_PERENT   VARCHAR2(30 BYTE)                    NULL,
  OPA_FJ       VARCHAR2(1 BYTE)                     NULL,
  OPA_PAI_COD  VARCHAR2(5 BYTE)                     NULL,
  OPA_MON_COD  VARCHAR2(1 BYTE)                     NULL,
  OPA_IMP      NUMBER(15,3)                     DEFAULT 0                         NULL,
  OPA_VALIMP   NUMBER(15,3)                     DEFAULT 0                         NULL,
  OPA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OPA_DATCRE   DATE                                 NULL,
  OPA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  OPA_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_REPRESENTANS
(
  REP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  REP_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  REP_SEQ      NUMBER(10)                           NULL,
  REP_NIF_NIF  VARCHAR2(12 BYTE)                    NULL,
  REP_DATPOD   DATE                                 NULL,
  REP_NOTARIA  VARCHAR2(20 BYTE)                    NULL,
  REP_VTOCAR   DATE                                 NULL,
  REP_ACTIU    VARCHAR2(1 BYTE)                 DEFAULT 'A'                       NULL,
  REP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  REP_DATCRE   DATE                                 NULL,
  REP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  REP_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_SCO
(
  SCO_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  SCO_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  SCO_COD      VARCHAR2(4 BYTE)                     NULL,
  SCO_ULTNUM   NUMBER(10)                           NULL,
  SCO_DATCRE   DATE                                 NULL,
  SCO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  SCO_DATMOD   DATE                                 NULL,
  SCO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  SCO_NOM      VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_V00
(
  V00_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  V00_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  V00_M00_EXC  VARCHAR2(4 BYTE)                     NULL,
  V00_M00_PRD  VARCHAR2(2 BYTE)                     NULL,
  V00_DMO_MDL  VARCHAR2(3 BYTE)                     NULL,
  V00_DMO_GRP  VARCHAR2(3 BYTE)                     NULL,
  V00_DMO_COD  VARCHAR2(3 BYTE)                     NULL,
  V00_PTE      NUMBER(5,2)                          NULL,
  V00_BIM      NUMBER(15,3)                         NULL,
  V00_CUOTA    NUMBER(15,3)                         NULL,
  V00_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  V00_DATCRE   DATE                                 NULL,
  V00_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  V00_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_V10
(
  V10_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  V10_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  V10_M10_EXC  VARCHAR2(4 BYTE)                     NULL,
  V10_M10_PRD  VARCHAR2(1 BYTE)                     NULL,
  V10_DMO_MDL  VARCHAR2(3 BYTE)                     NULL,
  V10_DMO_GRP  VARCHAR2(3 BYTE)                     NULL,
  V10_DMO_COD  VARCHAR2(3 BYTE)                     NULL,
  V10_DATCRE   DATE                                 NULL,
  V10_CUOTA    NUMBER(15,3)                     DEFAULT 0                         NULL,
  V10_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  V10_DATMOD   DATE                                 NULL,
  V10_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_V11
(
  V11_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  V11_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  V11_M11_EXC  VARCHAR2(4 BYTE)                     NULL,
  V11_DMO_MDL  VARCHAR2(3 BYTE)                     NULL,
  V11_DMO_GRP  VARCHAR2(3 BYTE)                     NULL,
  V11_DMO_COD  VARCHAR2(3 BYTE)                     NULL,
  V11_DATCRE   DATE                                 NULL,
  V11_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  V11_CUOTA    NUMBER(15,3)                     DEFAULT 0                         NULL,
  V11_DATMOD   DATE                                 NULL,
  V11_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_VALPARAISOS
(
  VPA_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  VPA_FIS_CODI  VARCHAR2(4 BYTE)                    NULL,
  VPA_SEQ       NUMBER(10)                          NULL,
  VPA_ANY       NUMBER(4)                           NULL,
  VPA_TIPO      VARCHAR2(4 BYTE)                    NULL,
  VPA_ENTITAT   VARCHAR2(30 BYTE)                   NULL,
  VPA_PAI_COD   VARCHAR2(5 BYTE)                    NULL,
  VPA_MON_COD   VARCHAR2(1 BYTE)                    NULL,
  VPA_IMPADQ    NUMBER(15,3)                    DEFAULT 0                         NULL,
  VPA_PTEPAR    NUMBER(5,2)                     DEFAULT 0                         NULL,
  VPA_VALIMP    NUMBER(15,3)                    DEFAULT 0                         NULL,
  VPA_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  VPA_DATCRE    DATE                                NULL,
  VPA_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  VPA_DATMOD    DATE                                NULL
)
;


CREATE INDEX ICMP_A90_M90_FK_I ON TCMP_M90OAG
(A90_CEC_COD, A90_FIS_COD, A90_M90_EXC)
;


CREATE INDEX ICMP_EJE_EMP_FK_I ON TCMP_EXERCICIS
(EJE_CEC_COD, EJE_EMP_COD)
;


CREATE INDEX ICMP_EJE_MON_FK_I ON TCMP_EXERCICIS
(EJE_CEC_COD, EJE_MON_COD)
;


CREATE INDEX ICMP_EMP_CEC_FK_I ON TCMP_EMPRESES
(EMP_CEC_COD)
;


CREATE INDEX ICMP_EMP_FIS_FK_I ON TCMP_EMPRESES
(EMP_CEC_COD, EMP_FIS_COD)
;


CREATE INDEX ICMP_EMP_MON_FK_I ON TCMP_EMPRESES
(EMP_CEC_COD, EMP_MON_COD)
;


CREATE INDEX ICMP_EMP_NIF_FK_I ON TCMP_EMPRESES
(EMP_CEC_COD, EMP_NIF_NIF)
;


CREATE INDEX ICMP_EMP_TAS_FK_I ON TCMP_EMPRESES
(EMP_CEC_COD, EMP_TAS_COD)
;


CREATE INDEX ICMP_FIS_CEC_FK_I ON TCMP_EMPRESAFIS
(FIS_CEC_COD)
;


CREATE INDEX ICMP_FIS_CNA_FK_I ON TCMP_EMPRESAFIS
(FIS_CEC_COD, FIS_CNA_COD)
;


CREATE INDEX ICMP_FIS_HIS_FK_I ON TCMP_EMPRESAFIS
(FIS_CEC_COD, FIS_HIS_COD)
;


CREATE INDEX ICMP_FIS_MON_FK_I ON TCMP_EMPRESAFIS
(FIS_CEC_COD, FIS_MON_COD)
;


CREATE INDEX ICMP_FIS_NIF_FK_I ON TCMP_EMPRESAFIS
(FIS_CEC_COD, FIS_NIF_NIF)
;


CREATE INDEX ICMP_FIS_NIF_RPR_FK_I ON TCMP_EMPRESAFIS
(FIS_CEC_COD, FIS_NIF_NIFRPR)
;


CREATE INDEX ICMP_FIS_OBL_FIS_FK_I ON TCMP_EMPRE_OBLIGACIONS
(FOB_CEC_COD, FOB_FIS_COD)
;


CREATE INDEX ICMP_FIS_OBL_OBL_FK_I ON TCMP_EMPRE_OBLIGACIONS
(FOB_CEC_COD, FOB_OBL_COD)
;


CREATE INDEX ICMP_GEM_EMP_FK_I ON TCMP_GRUPSEMPRESES
(GEM_EMP_CEC_COD, GEM_EMP_COD)
;


CREATE INDEX ICMP_GEM_GRP_FK_I ON TCMP_GRUPSEMPRESES
(GEM_EMP_CEC_COD, GEM_GRP_COD)
;


CREATE INDEX ICMP_M00_FIS_FK_I ON TCMP_M00
(M00_CEC_COD, M00_FIS_COD)
;


CREATE INDEX ICMP_M00_MON_FK_I ON TCMP_M00
(M00_CEC_COD, M00_MON_COD)
;


CREATE INDEX ICMP_M10_FIS_FK_I ON TCMP_M10
(M10_CEC_COD, M10_FIS_COD)
;


CREATE INDEX ICMP_M10_MON_FK_I ON TCMP_M10
(M10_CEC_COD, M10_MON_COD)
;


CREATE INDEX ICMP_M110_FIS_FK ON TCMP_MOD110
(M110_CEC_COD, M110_FIS_COD)
;


CREATE INDEX ICMP_M115_FIS_FK_I ON TCMP_MOD115
(M115_FIS_COD)
;


CREATE INDEX ICMP_M11_FIS_FK_I ON TCMP_M11
(M11_CEC_COD, M11_FIS_COD)
;


CREATE INDEX ICMP_M11_MON_FK_I ON TCMP_M11
(M11_CEC_COD, M11_MON_COD)
;


CREATE INDEX ICMP_M130_FIS_FK_I ON TCMP_MOD130
(M130_CEC_COD, M130_FIS_COD)
;


CREATE INDEX ICMP_M131_FIS_FK_I ON TCMP_MOD131
(M131_CEC_COD, M131_FIS_COD)
;


CREATE INDEX ICMP_M180_R1_FK ON TCMP_MOD180_R1
(M81_CEC_COD, M81_FIS_COD)
;


CREATE INDEX ICMP_M190_R2_FK ON TCMP_MOD190_R2
(M92_CEC_COD, M92_FIS_COD, M92_EXC)
;


CREATE INDEX ICMP_M201_FIS_FK_I ON TCMP_MOD201
(M201_CEC_COD, M201_FIS_COD)
;


CREATE INDEX ICMP_M202_FIS_FK_I ON TCMP_MOD202
(M202_CEC_COD, M202_FIS_COD)
;


CREATE INDEX ICMP_M3491_FIS_FK_I ON TCMP_MOD349_R1
(M349_CEC_COD, M349_FIS_COD)
;


CREATE INDEX ICMP_M349_FK_I ON TCMP_MOD349_R2
(M3492_CEC_COD, M3492_FIS_COD, M3492_EXC, M3492_PRD)
;


CREATE INDEX ICMP_M90_FIS_FK_I ON TCMP_M90
(M90_CEC_COD, M90_FIS_COD)
;


CREATE INDEX ICMP_M91_FIS_FK_I ON TCMP_MOD190_R1
(M91_CEC_COD, M91_FIS_COD)
;


CREATE INDEX ICMP_MOD180_R2_FK ON TCMP_MOD180_R2
(M82_CEC_COD, M82_FIS_COD, M82_EXC)
;


CREATE INDEX ICMP_OPA_FIS_FK_I ON TCMP_OPERFISCALS
(OPA_CEC_COD, OPA_FIS_COD)
;


CREATE INDEX ICMP_OPA_MON_FK_I ON TCMP_OPERFISCALS
(OPA_CEC_COD, OPA_MON_COD)
;


CREATE INDEX ICMP_OPA_PAI_FK_I ON TCMP_OPERFISCALS
(OPA_CEC_COD, OPA_PAI_COD)
;


CREATE INDEX ICMP_P303_M00_FK_I ON TCMP_M303PRORRATA
(P303_CEC_COD, P303_FIS_COD, P303_M00_EXC, P303_M00_PRD)
;


CREATE INDEX ICMP_P90_M90_FK_I ON TCMP_M90P
(P90_CEC_COD, P90_FIS_COD, P90_M90_EXC)
;


CREATE INDEX ICMP_R90_IAE_FK_I ON TCMP_M90ORS
(R90_CEC_COD, R90_IAE_EPIGRAFE)
;


CREATE INDEX ICMP_R90_M90_FK_I ON TCMP_M90ORS
(R90_CEC_COD, R90_FIS_COD, R90_M90_EXC)
;


CREATE INDEX ICMP_REP_FIS_FK_I ON TCMP_REPRESENTANS
(REP_CEC_COD, REP_FIS_COD)
;


CREATE INDEX ICMP_REP_NIF_FK_I ON TCMP_REPRESENTANS
(REP_CEC_COD, REP_NIF_NIF)
;


CREATE INDEX ICMP_V00_DMO_FK_I ON TCMP_V00
(V00_CEC_COD, V00_DMO_MDL, V00_DMO_GRP, V00_DMO_COD)
;


CREATE INDEX ICMP_V00_M00_FK_I ON TCMP_V00
(V00_CEC_COD, V00_FIS_COD, V00_M00_EXC, V00_M00_PRD)
;


CREATE INDEX ICMP_V10_DMO_FK_I ON TCMP_V10
(V10_CEC_COD, V10_DMO_MDL, V10_DMO_GRP, V10_DMO_COD)
;


CREATE INDEX ICMP_V10_M10_FK_I ON TCMP_V10
(V10_CEC_COD, V10_FIS_COD, V10_M10_EXC, V10_M10_PRD)
;


CREATE INDEX ICMP_V11_DMO_FK_I ON TCMP_V11
(V11_CEC_COD, V11_DMO_MDL, V11_DMO_GRP, V11_DMO_COD)
;


CREATE INDEX ICMP_V11_M11_FK_I ON TCMP_V11
(V11_CEC_COD, V11_FIS_COD, V11_M11_EXC)
;


CREATE INDEX ICMP_VPA_FIS_FK_I ON TCMP_VALPARAISOS
(VPA_CEC_COD, VPA_FIS_CODI)
;


CREATE INDEX ICMP_VPA_MON_FK_I ON TCMP_VALPARAISOS
(VPA_CEC_COD, VPA_MON_COD)
;


CREATE INDEX ICMP_VPA_PAI_FK_I ON TCMP_VALPARAISOS
(VPA_CEC_COD, VPA_PAI_COD)
;


CREATE UNIQUE INDEX RCMP_A90_PK ON TCMP_M90OAG
(A90_CEC_COD, A90_FIS_COD, A90_M90_EXC, A90_SEQ)
;


CREATE UNIQUE INDEX RCMP_EJE_PK ON TCMP_EXERCICIS
(EJE_CEC_COD, EJE_EMP_COD, EJE_COD)
;


CREATE UNIQUE INDEX RCMP_EMP_PK ON TCMP_EMPRESES
(EMP_CEC_COD, EMP_COD)
;


CREATE UNIQUE INDEX RCMP_EMX_PK ON TCMP_EMPRESAX
(EMX_CEC_COD, EMX_EMP_COD)
;


CREATE UNIQUE INDEX RCMP_EXD_PK ON TCMP_EXD
(EXD_CEC_COD, EXD_EMP_COD, EXD_COD)
;


CREATE UNIQUE INDEX RCMP_FIS_OBL_PK ON TCMP_EMPRE_OBLIGACIONS
(FOB_CEC_COD, FOB_FIS_COD, FOB_OBL_COD)
;


CREATE UNIQUE INDEX RCMP_FIS_PK ON TCMP_EMPRESAFIS
(FIS_CEC_COD, FIS_COD)
;


CREATE UNIQUE INDEX RCMP_GEM_PK ON TCMP_GRUPSEMPRESES
(GEM_GRP_COD, GEM_EMP_CEC_COD, GEM_EMP_COD)
;


CREATE UNIQUE INDEX RCMP_I303_PK ON TCMP_M303IVADED
(I303_CEC_COD, I303_FIS_COD, I303_M00_EXC, I303_M00_PRD, I303_SEQ)
;


CREATE UNIQUE INDEX RCMP_M00_PK ON TCMP_M00
(M00_CEC_COD, M00_FIS_COD, M00_EXC, M00_PRD)
;


CREATE UNIQUE INDEX RCMP_M10_PK ON TCMP_M10
(M10_CEC_COD, M10_FIS_COD, M10_EXC, M10_PRD)
;


CREATE UNIQUE INDEX RCMP_M110_PK ON TCMP_MOD110
(M110_CEC_COD, M110_FIS_COD, M110_EXC, M110_PRD)
;


CREATE UNIQUE INDEX RCMP_M115_PK ON TCMP_MOD115
(M115_CEC_COD, M115_FIS_COD, M115_EXC, M115_PRD)
;


CREATE UNIQUE INDEX RCMP_M11_PK ON TCMP_M11
(M11_CEC_COD, M11_FIS_COD, M11_EXC)
;


CREATE UNIQUE INDEX RCMP_M123_PK ON TCMP_MOD123
(M123_CEC_COD, M123_FIS_COD, M123_EXC, M123_PRD)
;


CREATE UNIQUE INDEX RCMP_M130_PK ON TCMP_MOD130
(M130_CEC_COD, M130_FIS_COD, M130_EXC, M130_PRD)
;


CREATE UNIQUE INDEX RCMP_M131_PK ON TCMP_MOD131
(M131_CEC_COD, M131_FIS_COD, M131_EXC, M131_PRD)
;


CREATE UNIQUE INDEX RCMP_M180_R1_PK ON TCMP_MOD180_R1
(M81_CEC_COD, M81_FIS_COD, M81_EXC)
;


CREATE UNIQUE INDEX RCMP_M190_PK ON TCMP_MOD190_R2
(M92_CEC_COD, M92_FIS_COD, M92_EXC, M92_SEQ)
;


CREATE UNIQUE INDEX RCMP_M190_R1_PK ON TCMP_MOD190_R1
(M91_CEC_COD, M91_FIS_COD, M91_EXC)
;


CREATE UNIQUE INDEX RCMP_M193G_PK ON TCMP_MOD193_GTO
(M193G_CEC_COD, M193G_FIS_COD, M193G_EXC, M193G_SEQ)
;


CREATE UNIQUE INDEX RCMP_M193P_PK ON TCMP_MOD193_PERC
(M193P_CEC_COD, M193P_FIS_COD, M193P_EXC, M193P_SEQ)
;


CREATE UNIQUE INDEX RCMP_M193_PK ON TCMP_MOD193
(M193_CEC_COD, M193_FIS_COD, M193_EXC)
;


CREATE UNIQUE INDEX RCMP_M201ACA_PK ON TCMP_MOD201_ACCALT
(ACA_CEC_COD, ACA_M201_NUM, ACA_SEQ)
;


CREATE UNIQUE INDEX RCMP_M201ACE_PK ON TCMP_MOD201_ACCPRO
(ACE_CEC_COD, ACE_M201_NUM, ACE_SEQ)
;


CREATE UNIQUE INDEX RCMP_M201ADM_PK ON TCMP_MOD201_ADMIN
(ADM_CEC_COD, ADM_M201_NUM, ADM_SEQ)
;


CREATE UNIQUE INDEX RCMP_M201OPA_PK ON TCMP_MOD201_OPEFIS
(OPA_CEC_COD, OPA_M201_NUM, OPA_SEQ)
;


CREATE UNIQUE INDEX RCMP_M201REP_PK ON TCMP_MOD201_REPR
(REP_CEC_COD, REP_M201_NUM, REP_SEQ)
;


CREATE UNIQUE INDEX RCMP_M201VIN_PK ON TCMP_MOD201_VINC
(VIN_CEC_COD, VIN_M201_NUM, VIN_SEQ)
;


CREATE UNIQUE INDEX RCMP_M201VPA_PK ON TCMP_MOD201_PARAISOS
(VPA_CEC_COD, VPA_M201_NUM, VPA_SEQ)
;


CREATE UNIQUE INDEX RCMP_M201_DED_PK ON TCMP_MOD201_DED
(M201_DED_CEC_COD, M201_DED_TIP, M201_DED_NUM, M201_DED_SEQ)
;


CREATE UNIQUE INDEX RCMP_M201_PK ON TCMP_MOD201
(M201_CEC_COD, M201_NUM)
;


CREATE UNIQUE INDEX RCMP_M201_R1_PK ON TCMP_MOD201_R1
(M201_M201_CEC_COD, M201_M201_NUM)
;


CREATE UNIQUE INDEX RCMP_M201_R2_PK ON TCMP_MOD201_R2
(M201_M201_CEC_COD, M201_M201_NUM)
;


CREATE UNIQUE INDEX RCMP_M201_R3_PK ON TCMP_MOD201_R3
(M201_M201_CEC_COD, M201_M201_NUM)
;


CREATE UNIQUE INDEX RCMP_M201_R4_PK ON TCMP_MOD201_R4
(M201_M201_CEC_COD, M201_M201_NUM)
;


CREATE UNIQUE INDEX RCMP_M201_SOC_PK ON TCMP_MOD201_SOCIOS
(M201_SOC_CEC_COD, M201_SOC_NUM, M201_SOC_SEQ)
;


CREATE UNIQUE INDEX RCMP_M202_PK ON TCMP_MOD202
(M202_CEC_COD, M202_FIS_COD, M202_EXC, M202_PRD)
;


CREATE UNIQUE INDEX RCMP_M216_PK ON TCMP_MOD216
(M216_CEC_COD, M216_FIS_COD, M216_EXC, M216_PRD)
;


CREATE UNIQUE INDEX RCMP_M340R1_PK ON TCMP_MOD340_R1
(M3401_CEC_COD, M3401_FIS_COD, M3401_EXC, M3401_PRD, M3401_SEQ)
;


CREATE UNIQUE INDEX RCMP_M340_PK ON TCMP_MOD340
(M340_CEC_COD, M340_FIS_COD, M340_EXC, M340_PRD)
;


CREATE UNIQUE INDEX RCMP_M3491_PK ON TCMP_MOD349_R1
(M349_CEC_COD, M349_EXC, M349_PRD, M349_FIS_COD)
;


CREATE UNIQUE INDEX RCMP_M3492_PK ON TCMP_MOD349_R2
(M3492_CEC_COD, M3492_FIS_COD, M3492_EXC, M3492_PRD, M3492_SEQ)
;


CREATE UNIQUE INDEX RCMP_M390_PK ON TCMP_M90_REPR
(E90_CEC_COD, E90_FIS_COD, E90_EXC, E90_REP_NIF)
;


CREATE UNIQUE INDEX RCMP_M83_PK ON TCMP_MOD180_R3
(M83_CEC_COD, M83_FIS_COD, M83_M82_SEQ, M83_EXC, M83_MES)
;


CREATE UNIQUE INDEX RCMP_M90IVADED_PK ON TCMP_M90IVADED
(I90_CEC_COD, I90_FIS_COD, I90_M90_EXC, I90_SEQ)
;


CREATE UNIQUE INDEX RCMP_M90_PK ON TCMP_M90
(M90_FIS_COD, M90_CEC_COD, M90_EXC)
;


CREATE UNIQUE INDEX RCMP_MOD180_R2_PK ON TCMP_MOD180_R2
(M82_CEC_COD, M82_FIS_COD, M82_EXC, M82_SEQ)
;


CREATE UNIQUE INDEX RCMP_OPA_PK ON TCMP_OPERFISCALS
(OPA_CEC_COD, OPA_FIS_COD, OPA_SEQ)
;


CREATE UNIQUE INDEX RCMP_P303_PK ON TCMP_M303PRORRATA
(P303_CEC_COD, P303_FIS_COD, P303_M00_EXC, P303_M00_PRD, P303_SEQ)
;


CREATE UNIQUE INDEX RCMP_P90_PK ON TCMP_M90P
(P90_CEC_COD, P90_FIS_COD, P90_M90_EXC, P90_SEQ)
;


CREATE UNIQUE INDEX RCMP_R90_PK ON TCMP_M90ORS
(R90_CEC_COD, R90_FIS_COD, R90_M90_EXC, R90_IAE_EPIGRAFE)
;


CREATE UNIQUE INDEX RCMP_REP_PK ON TCMP_REPRESENTANS
(REP_CEC_COD, REP_FIS_COD, REP_SEQ)
;


CREATE UNIQUE INDEX RCMP_SCO_PK ON TCMP_SCO
(SCO_CEC_COD, SCO_EMP_COD, SCO_COD)
;


CREATE UNIQUE INDEX RCMP_V00_PK ON TCMP_V00
(V00_CEC_COD, V00_FIS_COD, V00_M00_EXC, V00_M00_PRD, V00_DMO_MDL, 
V00_DMO_GRP, V00_DMO_COD, V00_PTE)
;


CREATE UNIQUE INDEX RCMP_V10_PK ON TCMP_V10
(V10_CEC_COD, V10_FIS_COD, V10_M10_EXC, V10_M10_PRD, V10_DMO_MDL, 
V10_DMO_GRP, V10_DMO_COD)
;


CREATE UNIQUE INDEX RCMP_V11_PK ON TCMP_V11
(V11_CEC_COD, V11_FIS_COD, V11_M11_EXC, V11_DMO_MDL, V11_DMO_GRP, 
V11_DMO_COD)
;


CREATE UNIQUE INDEX RCMP_VPA_PK ON TCMP_VALPARAISOS
(VPA_CEC_COD, VPA_FIS_CODI, VPA_SEQ)
;


CREATE OR REPLACE FORCE VIEW PERBORRAR
AS 
SELECT   m201_m201_cec_cod,
            m201_m201_num,
            m201_003 AS m201_153,
            m201_004 AS m201_154,
            m201_005 AS m201_155,
            m201_006 AS m201_156,
            m201_007 AS m201_157,
            m201_008 AS m201_158,
            m201_009 AS m201_159,
            m201_010 AS m201_160,
            m201_011 AS m201_161,
            m201_012 AS m201_728,
            m201_013 AS m201_729,
            m201_014 AS m201_730,
            m201_015 AS m201_731,
            m201_016 AS m201_732,
            m201_017 AS m201_733,
            m201_018 AS m201_734,
            M201_019 AS m201_163,
            m201_020 AS m201_167,
            m201_021 AS m201_pg18_2,
            m201_022 AS m201_pg18_3,
            m201_023 AS m201_pg18_4,
            m201_024 AS m201_pg18_5,
            m201_025 AS m201_pg18_7,
            m201_026 AS m201_pg18_9,
            m201_027 AS m201_pg18_10,
            m201_028 AS m201_pg18_11,
            m201_029 AS m201_pg18_13,
            m201_030 AS m201_pg18_15,
            m201_031 AS m201_pg18_16,
            m201_032 AS m201_pg18_18,
            m201_033 AS m201_650n,
            m201_034 AS m201_651n,
            m201_035 AS m201_652n,
            m201_036 AS m201_653n,
            m201_037 AS m201_654n,
            m201_038 AS m201_655n,
            m201_039 AS m201_656n,
            m201_040 AS m201_657n,
            m201_041 AS m201_658n,
            m201_042 AS m201_659n,
            m201_043 AS m201_660n,
            m201_044 AS m201_661n,
            m201_045 AS m201_662n,
            m201_046 AS m201_663n,
            m201_047 AS m201_664n,
            m201_048 AS m201_665n,
            m201_049 AS m201_666n,
            m201_050 AS m201_415n,
            m201_051 AS m201_416n,
            m201_052 AS m201_920,
            m201_053 AS m201_921,
            m201_054 AS m201_720,
            m201_055 AS m201_721,
            m201_056 AS m201_739,
            m201_057 AS m201_904,
            m201_058 AS m201_905,
            m201_059 AS m201_906,
            m201_060 AS m201_907,
            m201_061 AS m201_908,
            m201_062 AS m201_909,
            m201_063 AS m201_910,
            m201_064 AS m201_911,
            m201_065 AS m201_912,
            m201_066 AS m201_250,
            m201_067 AS m201_251,
            m201_068 AS m201_562,
            /*nous pel 2010*/
            m201_069 AS m201_135,
            m201_070 AS m201_136,
            m201_071 AS m201_137,
            m201_072 AS m201_926,
            m201_073 AS m201_138,
            m201_074 AS m201_139,
            m201_075 AS m201_140,
            m201_076 AS m201_c4n,
            m201_077 AS m201_e4n,
            m201_078 AS m201_935,
            m201_079 AS m201_936,
            m201_080 AS m201_937,
            m201_081 AS m201_960,
            m201_082 AS m201_961,
            m201_083 AS m201_962,
            m201_084 AS m201_997,
            m201_085 AS m201_998,
            m201_086 AS m201_999,
            /*nous pel 2012*/
            m201_087 AS m201_364,
            m201_088 AS m201_368,
            m201_089 AS m201_1240,
            m201_089 AS m201_1241,
            m201_090 AS m201_1242,
            m201_091 AS m201_1243,
            m201_092 AS m201_1244,
            m201_093 AS m201_1245,
            m201_094 AS m201_1246,
            m201_095 AS m201_1247,
            m201_096 AS m201_1248,
            m201_097 AS m201_1249,
            m201_098 AS m201_1250,
            m201_099 AS m201_1251,
            m201_100 AS m201_1252,
            m201_101 AS m201_1253,
            m201_102 AS m201_1254,
            m201_103 AS m201_1255,
            m201_104 AS m201_1256,
            m201_105 AS m201_1257,
            m201_106 AS m201_1258,
            m201_107 AS m201_1259,
            m201_108 AS m201_1260,
            m201_109 AS m201_1202,
            m201_110 AS m201_1203,
            m201_111 AS m201_1204,
            m201_112 AS m201_1205,
            m201_113 AS m201_1206,
            m201_114 AS m201_1462,
M201_124 AS m201_1463,
M201_125 AS m201_1209,
M201_126 AS m201_1210,
M201_127 AS m201_1211,
M201_128 AS m201_1464,
M201_129 AS m201_1465,
M201_130 AS m201_1466,
M201_131 AS m201_955,
M201_132 AS m201_956,
M201_133 AS m201_957,
M201_134 AS m201_1217,
M201_135 AS m201_1218,
M201_136 AS m201_1219,
M201_137 AS m201_1467,
M201_138 AS m201_1468,
M201_139 AS m201_1469,
-- pg 19
M201_140 AS m201_1270,
M201_141 AS m201_1271,
M201_142 AS m201_1522,
-- pg16
            /*nous pel 2011*/
            m201_143 as m201_141n,
            m201_144 as m201_142n,
            m201_145 as m201_143n,
-- ok
            m201_115 AS m201_273,
            m201_116 AS m201_274,
            m201_117 AS m201_537,
            m201_118 AS m201_538,
            m201_119 AS m201_539,
            m201_120 AS m201_546,
            m201_121 AS m201_963,
            m201_122 AS m201_964,
            m201_123 AS m201_965,
-- nous 2018, pg 20
m201_001 as m201_1736,
m201_002 as m201_1737/*,
m201_315 as m201_1738,
m201_316 as m201_1739,
m201_319 as m201_1740*/
     FROM   tcmp_mod201_r1;


CREATE OR REPLACE FORCE VIEW VCMP_M00_ANUAL
AS 
select regim, m00_cec_cod, m00_fis_cod, m00_exc, pteiva, sum(m00_bimrpc) as bim, sum(m00_ivarpc) as iva from (
    select 'RG' as regim, m00_cec_cod, m00_fis_cod, m00_exc, M00_PTERPC001 as pteiva, M00_BIMRPC001 as M00_BIMRPC, M00_IVARPC001 as M00_IVARPC
	from tcmp_m00 where M00_PTERPC001 is not null
	union all
	select 'RG', m00_cec_cod, m00_fis_cod, m00_exc, M00_PTERPC002 as pteiva, M00_BIMRPC002 as M00_BIMRPC, M00_IVARPC002 as M00_IVARPC
	from tcmp_m00 where M00_PTERPC002 is not null
	union all
	select 'RG', m00_cec_cod, m00_fis_cod, m00_exc, M00_PTERPC003 as pteiva, M00_BIMRPC003 as M00_BIMRPC, M00_IVARPC003 as M00_IVARPC
	from tcmp_m00 where M00_PTERPC003 is not null
	--
	union all
    select 'RE', m00_cec_cod, m00_fis_cod, m00_exc, M00_PTEREQRPC001, M00_BIMREQRPC001, M00_REQRPC001
	  from tcmp_m00 where m00_ptereqrpc001 is not null
	union all
    select 'RE', m00_cec_cod, m00_fis_cod, m00_exc, M00_PTEREQRPC002, M00_BIMREQRPC002, M00_REQRPC002
	  from tcmp_m00 where m00_ptereqrpc002 is not null
    union all
    select 'RE', m00_cec_cod, m00_fis_cod, m00_exc, M00_PTEREQRPC003, M00_BIMREQRPC003, M00_REQRPC003
	  from tcmp_m00 where m00_ptereqrpc003 is not null
)
group by m00_cec_cod, m00_fis_cod, m00_exc, pteiva, regim;


CREATE OR REPLACE FORCE VIEW VCMP_MOD201_CRR
AS 
select m201_m201_cec_cod, m201_m201_num,
m201_251 as m201_n01, m201_252 as m201_n02, m201_253 as m201_n03, m201_254 as m201_n04, m201_255 as m201_n05,
m201_256 as m201_n06, m201_257 as m201_n07, m201_258 as m201_n08, m201_259 as m201_n09, m201_260 as m201_n10,
m201_261 as m201_n11, m201_262 as m201_n12, m201_263 as m201_n13, m201_264 as m201_n14, m201_265 as m201_n15,
m201_266 as m201_n16, m201_267 as m201_n17, m201_268 as m201_n18, m201_269 as m201_n19, m201_270 as m201_n20,
m201_271 as m201_n21, m201_272 as m201_n22, m201_273 as m201_n23, m201_274 as m201_n24, m201_275 as m201_n25,
m201_276 as m201_n26, m201_277 as m201_n27, m201_278 as m201_n28, m201_279 as m201_n29, m201_280 as m201_n30,
m201_281 as m201_n31,
m201_282 as m201_n32,
m201_283 as m201_n33,
m201_284 as m201_n34,
m201_285 as m201_n35,
m201_286 as m201_n36,
m201_287 as m201_n37,
m201_288 as m201_n38,
m201_289 as m201_n39,
m201_290 as m201_n40,
m201_291 as m201_n41,
m201_292 as m201_n42
from tcmp_mod201_r2;


CREATE OR REPLACE FORCE VIEW VCMP_MOD201_DAT
AS 
select m201_m201_cec_cod, m201_m201_num,
m201_001 as m201_151, m201_002 as m201_152, m201_003 as m201_153,
m201_004 as m201_154, m201_005 as m201_155, m201_006 as m201_156,
m201_007 as m201_157, m201_008 as m201_158, m201_009 as m201_159,
m201_010 as m201_160, m201_011 as m201_161, m201_012 as m201_728,
m201_013 as m201_729, m201_014 as m201_730, m201_015 as m201_731,
m201_016 as m201_732, m201_017 as m201_733, m201_018 as m201_734,
M201_019 as m201_163, m201_020 as m201_167,
m201_021 as m201_pg18_2,
m201_022 as m201_pg18_3, m201_023 as m201_pg18_4,
m201_024 as m201_pg18_5,
m201_025 as m201_pg18_7,
m201_026 as m201_pg18_9, m201_027 as m201_pg18_10,
m201_028 as m201_pg18_11,
m201_029 as m201_pg18_13,
m201_030 as m201_pg18_15, m201_031 as m201_pg18_16,
m201_032 as m201_pg18_18,
m201_033 as m201_650n,
m201_034 as m201_651n,
m201_035 as m201_652n,
m201_036 as m201_653n,
m201_037 as m201_654n,
m201_038 as m201_655n,
m201_039 as m201_656n,
m201_040 as m201_657n,
m201_041 as m201_658n,
m201_042 as m201_659n,
m201_043 as m201_660n,
m201_044 as m201_661n,
m201_045 as m201_662n,
m201_046 as m201_663n,
m201_047 as m201_664n,
m201_048 as m201_665n,
m201_049 as m201_666n,
m201_050 as m201_415n, m201_051 as m201_416n,
m201_052 AS m201_920, m201_053 AS m201_921,
m201_054 as m201_720, m201_055 as m201_721, m201_056 as m201_739,
m201_057 as m201_904, m201_058 as m201_905, m201_059 as m201_906,
m201_060 as m201_907, m201_061 as m201_908, m201_062 as m201_909,
m201_063 as m201_910, m201_064 as m201_911, m201_065 as m201_912,
m201_066 as m201_250, m201_067 as m201_251, m201_068 as m201_562,
/*nous pel 2010*/
m201_069 as m201_135, m201_070 as m201_136, m201_071 as m201_137, m201_072 as m201_926,
m201_073 as m201_138, m201_074 as m201_139, m201_075 as m201_140,
m201_076 as m201_c4n, m201_077 as m201_e4n, m201_078 as m201_935, m201_079 as m201_936, m201_080 as m201_937,
/*nous pel 2011*/
m201_141, m201_142, m201_143, m201_081 as m201_960, m201_082 as m201_961, m201_083 as m201_962,
m201_084 as m201_997, m201_085 as m201_998, m201_086 as m201_999,
/*nous pel 2012*/
m201_087 as m201_364, m201_088 as m201_368, m201_nrs001, m201_nrs002,
m201_089 as m201_176, m201_090 as m201_177, m201_091 as m201_178, m201_092 as m201_179,
m201_093 as m201_043n, m201_094 as m201_049, m201_095 as m201_249, m201_096 as m201_252,
m201_097 as m201_253, m201_098 as m201_254, m201_099 as m201_255, m201_100 as m201_258,
m201_101 as m201_259, m201_102 as m201_260, m201_103 as m201_261, m201_104 as m201_262,
m201_105 as m201_263, m201_106 as m201_264, m201_107 as m201_265, m201_108 as m201_266,
m201_109 as m201_267, m201_110 as m201_268, m201_111 as m201_269, m201_112 as m201_270,
m201_113 as m201_271, m201_114 as m201_272, m201_115 as m201_273, m201_116 as m201_274,
m201_117 as m201_537, m201_118 as m201_538, m201_119 as m201_539, m201_120 as m201_546,
m201_121 as m201_963, m201_122 as m201_964, m201_123 as m201_965
from tcmp_mod201_r1;


CREATE OR REPLACE FORCE VIEW VCMP_MOD201_DAT2016
AS 
SELECT   m201_m201_cec_cod,
            m201_m201_num,
            m201_001 AS m201_151,
            m201_002 AS m201_152,
            m201_003 AS m201_153,
            m201_004 AS m201_154,
            m201_005 AS m201_155,
            m201_006 AS m201_156,
            m201_007 AS m201_157,
            m201_008 AS m201_158,
            m201_009 AS m201_159,
            m201_010 AS m201_160,
            m201_011 AS m201_161,
            m201_012 AS m201_728,
            m201_013 AS m201_729,
            m201_014 AS m201_730,
            m201_015 AS m201_731,
            m201_016 AS m201_732,
            m201_017 AS m201_733,
            m201_018 AS m201_734,
            M201_019 AS m201_163,
            m201_020 AS m201_167,
            m201_021 AS m201_pg18_2,
            m201_022 AS m201_pg18_3,
            m201_023 AS m201_pg18_4,
            m201_024 AS m201_pg18_5,
            m201_025 AS m201_pg18_7,
            m201_026 AS m201_pg18_9,
            m201_027 AS m201_pg18_10,
            m201_028 AS m201_pg18_11,
            m201_029 AS m201_pg18_13,
            m201_030 AS m201_pg18_15,
            m201_031 AS m201_pg18_16,
            m201_032 AS m201_pg18_18,
            m201_033 AS m201_650n,
            m201_034 AS m201_651n,
            m201_035 AS m201_652n,
            m201_036 AS m201_653n,
            m201_037 AS m201_654n,
            m201_038 AS m201_655n,
            m201_039 AS m201_656n,
            m201_040 AS m201_657n,
            m201_041 AS m201_658n,
            m201_042 AS m201_659n,
            m201_043 AS m201_660n,
            m201_044 AS m201_661n,
            m201_045 AS m201_662n,
            m201_046 AS m201_663n,
            m201_047 AS m201_664n,
            m201_048 AS m201_665n,
            m201_049 AS m201_666n,
            m201_050 AS m201_415n,
            m201_051 AS m201_416n,
            m201_052 AS m201_920,
            m201_053 AS m201_921,
            m201_054 AS m201_720,
            m201_055 AS m201_721,
            m201_056 AS m201_739,
            m201_057 AS m201_904,
            m201_058 AS m201_905,
            m201_059 AS m201_906,
            m201_060 AS m201_907,
            m201_061 AS m201_908,
            m201_062 AS m201_909,
            m201_063 AS m201_910,
            m201_064 AS m201_911,
            m201_065 AS m201_912,
            m201_066 AS m201_250,
            m201_067 AS m201_251,
            m201_068 AS m201_562,
            /*nous pel 2010*/
            m201_069 AS m201_135,
            m201_070 AS m201_136,
            m201_071 AS m201_137,
            m201_072 AS m201_926,
            m201_073 AS m201_138,
            m201_074 AS m201_139,
            m201_075 AS m201_140,
            m201_076 AS m201_c4n,
            m201_077 AS m201_e4n,
            m201_078 AS m201_935,
            m201_079 AS m201_936,
            m201_080 AS m201_937,
            m201_081 AS m201_960,
            m201_082 AS m201_961,
            m201_083 AS m201_962,
            m201_084 AS m201_997,
            m201_085 AS m201_998,
            m201_086 AS m201_999,
            /*nous pel 2012*/
            m201_087 AS m201_364,
            m201_088 AS m201_368,
/*            m201_nrs001, m201_nrs002,*/
            m201_089 AS m201_1240,
            m201_089 AS m201_1241,
            m201_090 AS m201_1242,
            m201_091 AS m201_1243,
            m201_092 AS m201_1244,
            m201_093 AS m201_1245,
            m201_094 AS m201_1246,
            m201_095 AS m201_1247,
            m201_096 AS m201_1248,
            m201_097 AS m201_1249,
            m201_098 AS m201_1250,
            m201_099 AS m201_1251,
            m201_100 AS m201_1252,
            m201_101 AS m201_1253,
            m201_102 AS m201_1254,
            m201_103 AS m201_1255,
            m201_104 AS m201_1256,
            m201_105 AS m201_1257,
            m201_106 AS m201_1258,
            m201_107 AS m201_1259,
            m201_108 AS m201_1260,
            m201_109 AS m201_1202,
            m201_110 AS m201_1203,
            m201_111 AS m201_1204,
            m201_112 AS m201_1205,
            m201_113 AS m201_1206,
            m201_114 AS m201_1462,
M201_124 AS m201_1463,
M201_125 AS m201_1209,
M201_126 AS m201_1210,
M201_127 AS m201_1211,
M201_128 AS m201_1464,
M201_129 AS m201_1465,
M201_130 AS m201_1466,
M201_131 AS m201_955,
M201_132 AS m201_956,
M201_133 AS m201_957,
M201_134 AS m201_1217,
M201_135 AS m201_1218,
M201_136 AS m201_1219,
M201_137 AS m201_1467,
M201_138 AS m201_1468,
M201_139 AS m201_1469,
-- pg 19
M201_140 AS m201_1270,
M201_141 AS m201_1271,
M201_142 AS m201_1522,
-- pg16
            /*nous pel 2011*/
            m201_143 as m201_141n,
            m201_144 as m201_142n,
            m201_145 as m201_143n,
-- ok
            m201_115 AS m201_273,
            m201_116 AS m201_274,
            m201_117 AS m201_537,
            m201_118 AS m201_538,
            m201_119 AS m201_539,
            m201_120 AS m201_546,
            m201_121 AS m201_963,
            m201_122 AS m201_964,
            m201_123 AS m201_965
     FROM   tcmp_mod201_r1;


CREATE OR REPLACE FORCE VIEW VCMP_MOD201_DAT2017
AS 
SELECT   m201_m201_cec_cod,
            m201_m201_num,
m201_001 as m201_1736, -- nou 2018, pg 20
m201_002 as m201_1737, -- nou 2018, pg 20
            m201_003 AS m201_153,
            m201_004 AS m201_154,
            m201_005 AS m201_155,
            m201_006 AS m201_156,
            m201_007 AS m201_157,
            m201_008 AS m201_158,
            m201_009 AS m201_159,
            m201_010 AS m201_160,
            m201_011 AS m201_161,
            m201_012 AS m201_728,
            m201_013 AS m201_729,
            m201_014 AS m201_730,
            m201_015 AS m201_731,
            m201_016 AS m201_732,
            m201_017 AS m201_733,
            m201_018 AS m201_734,
            M201_019 AS m201_163,
            m201_020 AS m201_167,
            m201_021 AS m201_pg18_2,
            m201_022 AS m201_pg18_3,
            m201_023 AS m201_pg18_4,
            m201_024 AS m201_pg18_5,
            m201_025 AS m201_pg18_7,
            m201_026 AS m201_pg18_9,
            m201_027 AS m201_pg18_10,
            m201_028 AS m201_pg18_11,
            m201_029 AS m201_pg18_13,
            m201_030 AS m201_pg18_15,
            m201_031 AS m201_pg18_16,
            m201_032 AS m201_pg18_18,
            m201_033 AS m201_650n,
            m201_034 AS m201_651n,
            m201_035 AS m201_652n,
            m201_036 AS m201_653n,
            m201_037 AS m201_654n,
            m201_038 AS m201_655n,
            m201_039 AS m201_656n,
            m201_040 AS m201_657n,
            m201_041 AS m201_658n,
            m201_042 AS m201_659n,
            m201_043 AS m201_660n,
            m201_044 AS m201_661n,
            m201_045 AS m201_662n,
            m201_046 AS m201_663n,
            m201_047 AS m201_664n,
            m201_048 AS m201_665n,
            m201_049 AS m201_666n,
            m201_050 AS m201_1741, -- nou 2018, pg 20
            m201_051 AS m201_1742, -- nou 2018, pg 20
            m201_052 AS m201_920,
            m201_053 AS m201_921,
            m201_054 AS m201_720,
            m201_055 AS m201_721,
            m201_056 AS m201_739,
            m201_057 AS m201_904,
            m201_058 AS m201_905,
            m201_059 AS m201_906,
            m201_060 AS m201_907,
            m201_061 AS m201_908,
            m201_062 AS m201_909,
            m201_063 AS m201_910,
            m201_064 AS m201_911,
            m201_065 AS m201_912,
            m201_066 AS m201_250,
            m201_067 AS m201_251,
            m201_068 AS m201_562,
            /*nous pel 2010*/
            m201_069 AS m201_135,
            m201_070 AS m201_136,
            m201_071 AS m201_137,
            m201_072 AS m201_926,
            m201_073 AS m201_138,
            m201_074 AS m201_139,
            m201_075 AS m201_140,
            m201_076 AS m201_c4n,
            m201_077 AS m201_e4n,
            m201_078 AS m201_935,
            m201_079 AS m201_936,
            m201_080 AS m201_937,
            m201_081 AS m201_960,
            m201_082 AS m201_961,
            m201_083 AS m201_962,
            m201_084 AS m201_997,
            m201_085 AS m201_998,
            m201_086 AS m201_999,
            /*nous pel 2012*/
            m201_087 AS m201_364,
            m201_088 AS m201_368,
            m201_089 AS m201_1240,
            m201_090 AS m201_1242,
            m201_091 AS m201_1243,
            m201_092 AS m201_1244,
            m201_093 AS m201_1245,
            m201_094 AS m201_1246,
            m201_095 AS m201_1247,
            m201_096 AS m201_1248,
            m201_097 AS m201_1249,
            m201_098 AS m201_1250,
            m201_099 AS m201_1251,
            m201_100 AS m201_1252,
            m201_101 AS m201_1253,
            m201_102 AS m201_1254,
            m201_103 AS m201_1255,
            m201_104 AS m201_1256,
            m201_105 AS m201_1257,
            m201_106 AS m201_1258,
            m201_107 AS m201_1259,
            m201_108 AS m201_1260,
            m201_109 AS m201_1202,
            m201_110 AS m201_1203,
            m201_111 AS m201_1204,
            m201_112 AS m201_1205,
            m201_113 AS m201_1206,
            m201_114 AS m201_1462,
            m201_115 AS m201_273,
            m201_116 AS m201_274,
            m201_117 AS m201_537,
            m201_118 AS m201_1241,
            m201_119 AS m201_1743, -- nou 2018, pag 20
            m201_121 AS m201_963,
            m201_122 AS m201_964,
            m201_123 AS m201_965,
M201_124 AS m201_1463,
M201_125 AS m201_1209,
M201_126 AS m201_1210,
M201_127 AS m201_1211,
M201_128 AS m201_1464,
M201_129 AS m201_1465,
M201_130 AS m201_1466,
M201_131 AS m201_955,
M201_132 AS m201_956,
M201_133 AS m201_957,
M201_134 AS m201_1217,
M201_135 AS m201_1218,
M201_136 AS m201_1219,
M201_137 AS m201_1467,
M201_138 AS m201_1468,
M201_139 AS m201_1469,
-- pg 19
M201_140 AS m201_1270,
M201_141 AS m201_1271,
M201_142 AS m201_1522,
-- pg16
            m201_143 as m201_141n,
            m201_144 as m201_142n,
            m201_145 as m201_143n,
m201_146 as m201_1738, -- nou 2018, pag 20
m201_147 as m201_1739, -- nou 2018, pag 20
m201_148 as m201_1740 -- nou 2018, pag 20
     FROM   tcmp_mod201_r1;


CREATE OR REPLACE FORCE VIEW VCMP_MOD201_PG09
AS 
select m201_m201_cec_cod, m201_m201_num,
m201_501 as m201_pg09_336, m201_502 as m201_pg09_337, m201_503 as m201_pg09_338, m201_504 as m201_pg09_339, m201_505 as m201_pg09_340,
m201_506 as m201_pg09_341, m201_507 as m201_pg09_342, m201_508 as m201_pg09_343, m201_509 as m201_pg09_344, m201_510 as m201_pg09_345,
m201_511 as m201_pg09_346, m201_512 as m201_pg09_347, m201_513 as m201_pg09_348, m201_514 as m201_pg09_349, m201_515 as m201_pg09_350,
m201_516 as m201_pg09_351, m201_517 as m201_pg09_352, m201_518 as m201_pg09_353, m201_519 as m201_pg09_354, m201_520 as m201_pg09_355
from tcmp_mod201_r3;


CREATE TABLE TCMP_347OPH
(
  OPH_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  OPH_EMP_COD       VARCHAR2(4 BYTE)                NULL,
  OPH_CLASSE        VARCHAR2(1 BYTE)                NULL,
  OPH_CLIPRO        VARCHAR2(10 BYTE)               NULL,
  OPH_IMPORT        NUMBER(15,2)                    NULL,
  OPH_TIPUS         VARCHAR2(1 BYTE)                NULL,
  OPH_NIF           VARCHAR2(12 BYTE)               NULL,
  OPH_NOM           VARCHAR2(40 BYTE)               NULL,
  OPH_PRVPAI        VARCHAR2(5 BYTE)                NULL,
  OPH_POB           VARCHAR2(30 BYTE)               NULL,
  OPH_SEGU          VARCHAR2(1 BYTE)                NULL,
  OPH_ARRE          VARCHAR2(1 BYTE)                NULL,
  OPH_USUCRE        VARCHAR2(30 BYTE)               NULL,
  OPH_DATCRE        DATE                            NULL,
  OPH_USUMOD        VARCHAR2(30 BYTE)               NULL,
  OPH_DATMOD        DATE                            NULL,
  OPH_EJE           VARCHAR2(4 BYTE)                NULL,
  OPH_IMPORTMET     NUMBER(15,2)                    NULL,
  OPH_IMPORTTRA     NUMBER(15,2)                    NULL,
  OPH_EXCMET        VARCHAR2(4 BYTE)                NULL,
  OPH_SEQ           NUMBER(3)                   DEFAULT 0                         NULL,
  OPH_IMP001        NUMBER(15,2)                    NULL,
  OPH_IMP002        NUMBER(15,2)                    NULL,
  OPH_IMP003        NUMBER(15,2)                    NULL,
  OPH_IMP004        NUMBER(15,2)                    NULL,
  OPH_IMPTRA001     NUMBER(15,2)                    NULL,
  OPH_IMPTRA002     NUMBER(15,2)                    NULL,
  OPH_IMPTRA003     NUMBER(15,2)                    NULL,
  OPH_IMPTRA004     NUMBER(15,2)                    NULL,
  OPH_CRICXA        NUMBER(15,2)                    NULL,
  OPH_NIFCEE        VARCHAR2(17 BYTE)               NULL,
  OPH_OPSREGCRICXA  VARCHAR2(1 BYTE)                NULL,
  OPH_OPSINVSUJPAS  VARCHAR2(1 BYTE)                NULL,
  OPH_OPSREGDIP     VARCHAR2(1 BYTE)                NULL
)
;


CREATE TABLE TCMP_ACCIONSALTRES
(
  ACA_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  ACA_FIS_COD   VARCHAR2(4 BYTE)                    NULL,
  ACA_SEQ       NUMBER(10)                          NULL,
  ACA_NIF_NIF   VARCHAR2(12 BYTE)                   NULL,
  ACA_PRV_COD   VARCHAR2(3 BYTE)                    NULL,
  ACA_MON_COD   VARCHAR2(1 BYTE)                    NULL,
  ACA_NOMINAL   NUMBER(18,6)                    DEFAULT 0                         NULL,
  ACA_PTEPAR    NUMBER(5,2)                     DEFAULT 0                         NULL,
  ACA_ACTIU     VARCHAR2(1 BYTE)                DEFAULT 'A'                       NULL,
  ACA_DATBAIXA  DATE                                NULL,
  ACA_VALNOM    NUMBER(18,6)                    DEFAULT 0                         NULL,
  ACA_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  ACA_DATCRE    DATE                                NULL,
  ACA_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  ACA_DATMOD    DATE                                NULL,
  ACA_SOCPAR    VARCHAR2(1 BYTE)                DEFAULT 'S'                       NULL
)
;


CREATE TABLE TCMP_ACCIONSPROPIES
(
  ACE_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  ACE_FIS_COD   VARCHAR2(4 BYTE)                    NULL,
  ACE_SEQ       NUMBER(10)                          NULL,
  ACE_NIF_NIF   VARCHAR2(12 BYTE)                   NULL,
  ACE_RPR       VARCHAR2(1 BYTE)                    NULL,
  ACE_RESIDENT  VARCHAR2(1 BYTE)                    NULL,
  ACE_FJ        VARCHAR2(1 BYTE)                    NULL,
  ACE_DATALT    DATE                                NULL,
  ACE_DATBAI    DATE                                NULL,
  ACE_ACCIONS   NUMBER(15)                      DEFAULT 0                         NULL,
  ACE_MON_COD   VARCHAR2(1 BYTE)                    NULL,
  ACE_NOMINAL   NUMBER(18,6)                    DEFAULT 0                         NULL,
  ACE_PTEACC    NUMBER(5,2)                     DEFAULT 0                         NULL,
  ACE_NUMACC    VARCHAR2(100 BYTE)                  NULL,
  ACE_ACTIU     VARCHAR2(1 BYTE)                DEFAULT 'A'                       NULL,
  ACE_VALNOM    NUMBER(18,6)                    DEFAULT 0                         NULL,
  ACE_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  ACE_DATCRE    DATE                                NULL,
  ACE_EDADALTA  NUMBER(3)                           NULL,
  ACE_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  ACE_DATMOD    DATE                                NULL
)
;


CREATE TABLE TCMP_ACTIVITATS
(
  ACT_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  ACT_FIS_COD       VARCHAR2(4 BYTE)                NULL,
  ACT_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  ACT_SEQ           NUMBER(10)                      NULL,
  ACT_PRV_COD       VARCHAR2(3 BYTE)                NULL,
  ACT_POB_COD       VARCHAR2(8 BYTE)                NULL,
  ACT_CLAIVA        VARCHAR2(1 BYTE)                NULL,
  ACT_DATALT        DATE                            NULL,
  ACT_REGPOR        VARCHAR2(1 BYTE)                NULL,
  ACT_PTEPOR        NUMBER(5,2)                 DEFAULT 0                         NULL,
  ACT_PORESP        VARCHAR2(1 BYTE)                NULL,
  ACT_DATBAI        DATE                            NULL,
  ACT_ACTIU         VARCHAR2(1 BYTE)            DEFAULT 'A'                       NULL,
  ACT_USUCRE        VARCHAR2(30 BYTE)               NULL,
  ACT_DATCRE        DATE                            NULL,
  ACT_USUMOD        VARCHAR2(30 BYTE)               NULL,
  ACT_DATMOD        DATE                            NULL,
  ACT_AUXILIAR      VARCHAR2(4 BYTE)                NULL,
  ACT_PRINCIPAL     VARCHAR2(1 BYTE)                NULL
)
;


CREATE TABLE TCMP_ADMINISTRADORS
(
  ADM_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  ADM_FIS_COD   VARCHAR2(4 BYTE)                    NULL,
  ADM_NIF_NIF   VARCHAR2(12 BYTE)                   NULL,
  ADM_SEQ       NUMBER(10)                          NULL,
  ADM_FJ        VARCHAR2(1 BYTE)                    NULL,
  ADM_PRV_COD   VARCHAR2(3 BYTE)                    NULL,
  ADM_ACTIU     VARCHAR2(1 BYTE)                DEFAULT 'A'                       NULL,
  ADM_DATBAIXA  DATE                                NULL,
  ADM_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  ADM_DATCRE    DATE                                NULL,
  ADM_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  ADM_DATMOD    DATE                                NULL
)
;


CREATE TABLE TCMP_ANUALSIMPSOCI
(
  AIS_CEC_COD      VARCHAR2(4 BYTE)                 NULL,
  AIS_FIS_COD      VARCHAR2(4 BYTE)                 NULL,
  AIS_ANY          NUMBER(4)                        NULL,
  AIS_INACTIVA     VARCHAR2(1 BYTE)                 NULL,
  AIS_BASNEGCER    VARCHAR2(1 BYTE)                 NULL,
  AIS_DEVOLU       VARCHAR2(1 BYTE)                 NULL,
  AIS_PERULTIND    NUMBER(5)                    DEFAULT 0                         NULL,
  AIS_PERULTTOT    NUMBER(5)                    DEFAULT 0                         NULL,
  AIS_MEDACTFIJ    NUMBER(7,2)                  DEFAULT 0                         NULL,
  AIS_MEDANTFIJ    NUMBER(7,2)                  DEFAULT 0                         NULL,
  AIS_MEDACTNOF    NUMBER(7,2)                  DEFAULT 0                         NULL,
  AIS_MEDANTNOF    NUMBER(7,2)                  DEFAULT 0                         NULL,
  AIS_DATCIEEJE    DATE                             NULL,
  AIS_PAGREGMER    NUMBER(5)                    DEFAULT 0                         NULL,
  AIS_PAGMEMORIA   NUMBER(5)                    DEFAULT 0                         NULL,
  AIS_OBS          VARCHAR2(225 BYTE)               NULL,
  AIS_NOUCRE       VARCHAR2(1 BYTE)                 NULL,
  AIS_USUCRE       VARCHAR2(30 BYTE)                NULL,
  AIS_DATCRE       DATE                             NULL,
  AIS_USUMOD       VARCHAR2(30 BYTE)                NULL,
  AIS_DATMOD       DATE                             NULL,
  AIS_DISCAP       NUMBER(12,2)                     NULL,
  AIS_DISCAP_ANT   NUMBER(12,2)                     NULL,
  AIS_FIJOH        NUMBER(12,2)                     NULL,
  AIS_FIJOM        NUMBER(12,2)                     NULL,
  AIS_FIJOH_ANT    NUMBER(12,2)                     NULL,
  AIS_FIJOM_ANT    NUMBER(12,2)                     NULL,
  AIS_NOFIJOH      NUMBER(12,2)                     NULL,
  AIS_NOFIJOM      NUMBER(12,2)                     NULL,
  AIS_NOFIJOH_ANT  NUMBER(12,2)                     NULL,
  AIS_NOFIJOM_ANT  NUMBER(12,2)                     NULL
)
;


CREATE TABLE TCMP_BFI
(
  BFI_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  BFI_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  BFI_BAN      VARCHAR2(4 BYTE)                     NULL,
  BFI_OFI      VARCHAR2(4 BYTE)                     NULL,
  BFI_CCR      VARCHAR2(10 BYTE)                    NULL,
  BFI_DEF      VARCHAR2(1 BYTE)                     NULL,
  BFI_DCC      VARCHAR2(2 BYTE)                     NULL,
  BFI_DATCRE   DATE                                 NULL,
  BFI_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  BFI_DATMOD   DATE                                 NULL,
  BFI_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  BFI_IBNPAI   VARCHAR2(2 BYTE)                     NULL,
  BFI_IBNDCC   VARCHAR2(2 BYTE)                     NULL,
  BFI_IBNBIC   VARCHAR2(11 BYTE)                    NULL
)
;


CREATE TABLE TCMP_COMPTES1
(
  CT1_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CT1_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CT1_COD      VARCHAR2(1 BYTE)                     NULL,
  CT1_DES      VARCHAR2(30 BYTE)                    NULL,
  CT1_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CT1_DATCRE   DATE                                 NULL,
  CT1_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CT1_DATMOD   DATE                                 NULL,
  CT1_DESANT   VARCHAR2(30 BYTE)                    NULL,
  CT1_DESLLA   VARCHAR2(255 BYTE)                   NULL
)
;


CREATE TABLE TCMP_COMPTES2
(
  CT2_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CT2_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CT2_COD      VARCHAR2(2 BYTE)                     NULL,
  CT2_DES      VARCHAR2(30 BYTE)                    NULL,
  CT2_CT1_COD  VARCHAR2(1 BYTE)                     NULL,
  CT2_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CT2_DATCRE   DATE                                 NULL,
  CT2_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CT2_DATMOD   DATE                                 NULL,
  CT2_DESANT   VARCHAR2(30 BYTE)                    NULL,
  CT2_DESLLA   VARCHAR2(255 BYTE)                   NULL
)
;


CREATE TABLE TCMP_COMPTES3
(
  CT3_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CT3_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CT3_COD      VARCHAR2(3 BYTE)                     NULL,
  CT3_DES      VARCHAR2(30 BYTE)                    NULL,
  CT3_CT2_COD  VARCHAR2(2 BYTE)                     NULL,
  CT3_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CT3_DATCRE   DATE                                 NULL,
  CT3_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CT3_DATMOD   DATE                                 NULL,
  CT3_DESANT   VARCHAR2(30 BYTE)                    NULL,
  CT3_DESLLA   VARCHAR2(255 BYTE)                   NULL
)
;


CREATE TABLE TCMP_COMPTES4
(
  CT4_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CT4_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CT4_COD      VARCHAR2(4 BYTE)                     NULL,
  CT4_DES      VARCHAR2(30 BYTE)                    NULL,
  CT4_CT3_COD  VARCHAR2(3 BYTE)                     NULL,
  CT4_DH       VARCHAR2(1 BYTE)                     NULL,
  CT4_DADCLI   VARCHAR2(1 BYTE)                     NULL,
  CT4_DADBAN   VARCHAR2(1 BYTE)                     NULL,
  CT4_DADAMO   VARCHAR2(1 BYTE)                     NULL,
  CT4_DADNEG   VARCHAR2(1 BYTE)                     NULL,
  CT4_DADRET   VARCHAR2(1 BYTE)                     NULL,
  CT4_DADLLO   VARCHAR2(1 BYTE)                     NULL,
  CT4_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CT4_DATCRE   DATE                                 NULL,
  CT4_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CT4_DATMOD   DATE                                 NULL,
  CT4_DSG      VARCHAR2(1 BYTE)                     NULL,
  CT4_DESANT   VARCHAR2(30 BYTE)                    NULL,
  CT4_DESLLA   VARCHAR2(255 BYTE)                   NULL,
  CT4_DESOPE   VARCHAR2(500 BYTE)                   NULL
)
;


CREATE TABLE TCMP_COMPTES5
(
  CT5_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  CT5_EMP_COD       VARCHAR2(4 BYTE)                NULL,
  CT5_COD           VARCHAR2(10 BYTE)               NULL,
  CT5_DES           VARCHAR2(30 BYTE)               NULL,
  CT5_CT4_COD       VARCHAR2(4 BYTE)                NULL,
  CT5_ALI           VARCHAR2(14 BYTE)               NULL,
  CT5_OBS           VARCHAR2(225 BYTE)              NULL,
  CT5_MON_COD       VARCHAR2(1 BYTE)                NULL,
  CT5_USUCRE        VARCHAR2(30 BYTE)               NULL,
  CT5_DATCRE        DATE                            NULL,
  CT5_USUMOD        VARCHAR2(30 BYTE)               NULL,
  CT5_DATMOD        DATE                            NULL,
  CT5_DAT           DATE                            NULL,
  CT5_GRU           VARCHAR2(10 BYTE)               NULL,
  CT5_CONTRA        VARCHAR2(10 BYTE)               NULL,
  CT5_NAVDEPPRO     VARCHAR2(1 BYTE)                NULL,
  CT5_RSC           NUMBER(15,3)                    NULL,
  CT5_BLO           VARCHAR2(1 BYTE)            DEFAULT 'N'                       NULL,
  CT5_DATAVI        DATE                            NULL,
  CT5_AVI           VARCHAR2(64 BYTE)               NULL,
  CT5_GRU002        VARCHAR2(10 BYTE)               NULL,
  CT5_GRU003        VARCHAR2(10 BYTE)               NULL,
  CT5_GRU004        VARCHAR2(10 BYTE)               NULL,
  CT5_GEN           VARCHAR2(1 BYTE)                NULL,
  CT5_EMPGRU        VARCHAR2(1 BYTE)                NULL,
  CT5_IG            VARCHAR2(1 BYTE)                NULL,
  CT5_TVE_COD       VARCHAR2(4 BYTE)                NULL,
  CT5_FPA_COD       VARCHAR2(4 BYTE)                NULL,
  CT5_CLV_COD       VARCHAR2(4 BYTE)                NULL,
  CT5_DESANT        VARCHAR2(30 BYTE)               NULL,
  CT5_DESLLA        VARCHAR2(255 BYTE)              NULL,
  CT5_MCA           VARCHAR2(1 BYTE)                NULL,
  CT5_TIPPLA        VARCHAR2(1 BYTE)                NULL,
  CT5_CTEPON        VARCHAR2(10 BYTE)               NULL,
  CT5_DIA_CODCPA    VARCHAR2(2 BYTE)                NULL,
  CT5_TAS_CODCPA    VARCHAR2(2 BYTE)                NULL,
  CT5_EMPPUB        VARCHAR2(1 BYTE)                NULL,
  CT5_REGCRICXA     VARCHAR2(1 BYTE)                NULL,
  CT5_DISDEPPRJFAC  VARCHAR2(1 BYTE)                NULL,
  CT5_DESOPE        VARCHAR2(500 BYTE)              NULL
)
;


CREATE TABLE TCMP_CONMODIRPFS
(
  CMR_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  CMR_FIS_COD       VARCHAR2(4 BYTE)                NULL,
  CMR_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  CMR_ANY           NUMBER(4)                       NULL,
  CMR_SEQ           NUMBER(10)                      NULL,
  CMR_CORTEM        NUMBER(5,2)                 DEFAULT 0                         NULL,
  CMR_CORPOB        NUMBER(5,2)                 DEFAULT 0                         NULL,
  CMR_CORGEN        NUMBER(5,2)                 DEFAULT 0                         NULL,
  CMR_PTEPAR        NUMBER(8,5)                 DEFAULT 0                         NULL,
  CMR_USUCRE        VARCHAR2(30 BYTE)               NULL,
  CMR_DATCRE        DATE                            NULL,
  CMR_USUMOD        VARCHAR2(30 BYTE)               NULL,
  CMR_DATMOD        DATE                            NULL,
  CMR_CUOINV        NUMBER(15,3)                    NULL
)
;


CREATE TABLE TCMP_CONMODIVAS
(
  CMI_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  CMI_FIS_COD       VARCHAR2(4 BYTE)                NULL,
  CMI_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  CMI_ANY           NUMBER(4)                       NULL,
  CMI_SEQ           NUMBER(10)                      NULL,
  CMI_CORTEM        NUMBER(5,2)                 DEFAULT 0                         NULL,
  CMI_CORPOB        NUMBER(5,2)                 DEFAULT 0                         NULL,
  CMI_USUCRE        VARCHAR2(30 BYTE)               NULL,
  CMI_DATCRE        DATE                            NULL,
  CMI_USUMOD        VARCHAR2(30 BYTE)               NULL,
  CMI_DATMOD        DATE                            NULL
)
;


CREATE TABLE TCMP_DADESCLIPROS
(
  DCP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DCP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DCP_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  DCP_NOMCOM   VARCHAR2(30 BYTE)                    NULL,
  DCP_NIF_NIF  VARCHAR2(12 BYTE)                    NULL,
  DCP_TEL      VARCHAR2(30 BYTE)                    NULL,
  DCP_FAX      VARCHAR2(30 BYTE)                    NULL,
  DCP_EML      VARCHAR2(60 BYTE)                    NULL,
  DCP_CON      VARCHAR2(100 BYTE)                   NULL,
  DCP_OPESEG   VARCHAR2(1 BYTE)                     NULL,
  DCP_OPELLO   VARCHAR2(1 BYTE)                     NULL,
  DCP_RPR      VARCHAR2(1 BYTE)                     NULL,
  DCP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DCP_DATCRE   DATE                                 NULL,
  DCP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DCP_DATMOD   DATE                                 NULL,
  DCP_347      VARCHAR2(1 BYTE)                     NULL,
  DCP_POB_COD  VARCHAR2(8 BYTE)                     NULL,
  DCP_DOM      VARCHAR2(30 BYTE)                    NULL,
  DCP_NOTORD   VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TCMP_DEL
(
  DEL_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DEL_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DEL_COD      VARCHAR2(4 BYTE)                     NULL,
  DEL_NOM      VARCHAR2(60 BYTE)                    NULL,
  DEL_DATCRE   DATE                                 NULL,
  DEL_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DEL_DATMOD   DATE                                 NULL,
  DEL_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_DEPARTAMENTS
(
  DEP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DEP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DEP_COD      VARCHAR2(4 BYTE)                     NULL,
  DEP_NOM      VARCHAR2(30 BYTE)                    NULL,
  DEP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DEP_DATCRE   DATE                                 NULL,
  DEP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DEP_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_DEPCTA
(
  DCT_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  DCT_FIS_COD        VARCHAR2(4 BYTE)               NULL,
  DCT_EXC            VARCHAR2(4 BYTE)               NULL,
  DCT_EXC_ANT        VARCHAR2(4 BYTE)               NULL,
  DCT_FIJO           NUMBER(12,2)                   NULL,
  DCT_FIJO_ANT       NUMBER(12,2)                   NULL,
  DCT_NOFIJO         NUMBER(12,2)                   NULL,
  DCT_NOFIJO_ANT     NUMBER(12,2)                   NULL,
  DCT_DAT            DATE                           NULL,
  DCT_TOTPAG         NUMBER(10)                     NULL,
  DCT_CAUSA          VARCHAR2(100 BYTE)             NULL,
  DCT_BA1_A          NUMBER(15,3)                   NULL,
  DCT_BA1_B          NUMBER(15,3)                   NULL,
  DCT_BA1_BI         NUMBER(15,3)                   NULL,
  DCT_BA1_BII        NUMBER(15,3)                   NULL,
  DCT_BA1_BIII       NUMBER(15,3)                   NULL,
  DCT_BA1_BIV        NUMBER(15,3)                   NULL,
  DCT_BA1_BV         NUMBER(15,3)                   NULL,
  DCT_BA1_BVI        NUMBER(15,3)                   NULL,
  DCT_BA1_C          NUMBER(15,3)                   NULL,
  DCT_BA1_D          NUMBER(15,3)                   NULL,
  DCT_BA1_DI         NUMBER(15,3)                   NULL,
  DCT_BA1_DII        NUMBER(15,3)                   NULL,
  DCT_BA1_DIII       NUMBER(15,3)                   NULL,
  DCT_BA1_DIV        NUMBER(15,3)                   NULL,
  DCT_BA1_DV         NUMBER(15,3)                   NULL,
  DCT_BA1_DVI        NUMBER(15,3)                   NULL,
  DCT_BA1_DVII       NUMBER(15,3)                   NULL,
  DCT_BA1_TOT        NUMBER(15,3)                   NULL,
  DCT_BA1_A_ANT      NUMBER(15,3)                   NULL,
  DCT_BA1_B_ANT      NUMBER(15,3)                   NULL,
  DCT_BA1_BI_ANT     NUMBER(15,3)                   NULL,
  DCT_BA1_BII_ANT    NUMBER(15,3)                   NULL,
  DCT_BA1_BIII_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_BIV_ANT    NUMBER(15,3)                   NULL,
  DCT_BA1_BV_ANT     NUMBER(15,3)                   NULL,
  DCT_BA1_BVI_ANT    NUMBER(15,3)                   NULL,
  DCT_BA1_C_ANT      NUMBER(15,3)                   NULL,
  DCT_BA1_D_ANT      NUMBER(15,3)                   NULL,
  DCT_BA1_DI_ANT     NUMBER(15,3)                   NULL,
  DCT_BA1_DII_ANT    NUMBER(15,3)                   NULL,
  DCT_BA1_DIII_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_DIV_ANT    NUMBER(15,3)                   NULL,
  DCT_BA1_DV_ANT     NUMBER(15,3)                   NULL,
  DCT_BA1_DVI_ANT    NUMBER(15,3)                   NULL,
  DCT_BA1_DVII_ANT   NUMBER(15,3)                   NULL,
  DCT_BA1_TOT_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_A          NUMBER(15,3)                   NULL,
  DCT_BA2_AI         NUMBER(15,3)                   NULL,
  DCT_BA2_AII        NUMBER(15,3)                   NULL,
  DCT_BA2_AIII       NUMBER(15,3)                   NULL,
  DCT_BA2_AIV        NUMBER(15,3)                   NULL,
  DCT_BA2_AIV1       NUMBER(15,3)                   NULL,
  DCT_BA2_AIV2       NUMBER(15,3)                   NULL,
  DCT_BA2_AV         NUMBER(15,3)                   NULL,
  DCT_BA2_AVI        NUMBER(15,3)                   NULL,
  DCT_BA2_AVII       NUMBER(15,3)                   NULL,
  DCT_BA2_AVIII      NUMBER(15,3)                   NULL,
  DCT_BA2_B          NUMBER(15,3)                   NULL,
  DCT_BA2_C          NUMBER(15,3)                   NULL,
  DCT_BA2_D          NUMBER(15,3)                   NULL,
  DCT_BA2_E          NUMBER(15,3)                   NULL,
  DCT_BA2_F          NUMBER(15,3)                   NULL,
  DCT_BA2_TOT        NUMBER(15,3)                   NULL,
  DCT_BA2_A_ANT      NUMBER(15,3)                   NULL,
  DCT_BA2_AI_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_AII_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_AIII_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AIV_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_AIV1_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AIV2_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AV_ANT     NUMBER(15,3)                   NULL,
  DCT_BA2_AVI_ANT    NUMBER(15,3)                   NULL,
  DCT_BA2_AVII_ANT   NUMBER(15,3)                   NULL,
  DCT_BA2_AVIII_ANT  NUMBER(15,3)                   NULL,
  DCT_BA2_B_ANT      NUMBER(15,3)                   NULL,
  DCT_BA2_C_ANT      NUMBER(15,3)                   NULL,
  DCT_BA2_D_ANT      NUMBER(15,3)                   NULL,
  DCT_BA2_E_ANT      NUMBER(15,3)                   NULL,
  DCT_BA2_F_ANT      NUMBER(15,3)                   NULL,
  DCT_BA2_TOT_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A          NUMBER(15,3)                   NULL,
  DCT_PA1_A1         NUMBER(15,3)                   NULL,
  DCT_PA1_A2         NUMBER(15,3)                   NULL,
  DCT_PA1_A2A        NUMBER(15,3)                   NULL,
  DCT_PA1_A2B        NUMBER(15,3)                   NULL,
  DCT_PA1_A3         NUMBER(15,3)                   NULL,
  DCT_PA1_A4         NUMBER(15,3)                   NULL,
  DCT_PA1_A5         NUMBER(15,3)                   NULL,
  DCT_PA1_AI         NUMBER(15,3)                   NULL,
  DCT_PA1_A6         NUMBER(15,3)                   NULL,
  DCT_PA1_A6A        NUMBER(15,3)                   NULL,
  DCT_PA1_A6B        NUMBER(15,3)                   NULL,
  DCT_PA1_A6C        NUMBER(15,3)                   NULL,
  DCT_PA1_A6D        NUMBER(15,3)                   NULL,
  DCT_PA1_A7         NUMBER(15,3)                   NULL,
  DCT_PA1_A8         NUMBER(15,3)                   NULL,
  DCT_PA1_AII        NUMBER(15,3)                   NULL,
  DCT_PA1_AIII       NUMBER(15,3)                   NULL,
  DCT_PA1_A9         NUMBER(15,3)                   NULL,
  DCT_PA1_A10        NUMBER(15,3)                   NULL,
  DCT_PA1_A11        NUMBER(15,3)                   NULL,
  DCT_PA1_A12        NUMBER(15,3)                   NULL,
  DCT_PA1_A13        NUMBER(15,3)                   NULL,
  DCT_PA1_AIV        NUMBER(15,3)                   NULL,
  DCT_PA1_AV         NUMBER(15,3)                   NULL,
  DCT_PA1_A14        NUMBER(15,3)                   NULL,
  DCT_PA1_A15        NUMBER(15,3)                   NULL,
  DCT_PA1_AVI        NUMBER(15,3)                   NULL,
  DCT_PA1_A_ANT      NUMBER(15,3)                   NULL,
  DCT_PA1_A1_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A2_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A2A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A2B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A3_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A4_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A5_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_AI_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A6_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A6A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A6B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A6C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A6D_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A7_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A8_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_AII_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_AIII_ANT   NUMBER(15,3)                   NULL,
  DCT_PA1_A9_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A10_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A11_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A12_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A13_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_AIV_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_AV_ANT     NUMBER(15,3)                   NULL,
  DCT_PA1_A14_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_A15_ANT    NUMBER(15,3)                   NULL,
  DCT_PA1_AVI_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B          NUMBER(15,3)                   NULL,
  DCT_PA2_B1         NUMBER(15,3)                   NULL,
  DCT_PA2_B1A        NUMBER(15,3)                   NULL,
  DCT_PA2_B1B        NUMBER(15,3)                   NULL,
  DCT_PA2_BI         NUMBER(15,3)                   NULL,
  DCT_PA2_B2         NUMBER(15,3)                   NULL,
  DCT_PA2_B2A        NUMBER(15,3)                   NULL,
  DCT_PA2_B2B        NUMBER(15,3)                   NULL,
  DCT_PA2_B2C        NUMBER(15,3)                   NULL,
  DCT_PA2_B2D        NUMBER(15,3)                   NULL,
  DCT_PA2_B3         NUMBER(15,3)                   NULL,
  DCT_PA2_BII        NUMBER(15,3)                   NULL,
  DCT_PA2_BIII       NUMBER(15,3)                   NULL,
  DCT_PA2_B4         NUMBER(15,3)                   NULL,
  DCT_PA2_B5         NUMBER(15,3)                   NULL,
  DCT_PA2_B6         NUMBER(15,3)                   NULL,
  DCT_PA2_B7         NUMBER(15,3)                   NULL,
  DCT_PA2_B8         NUMBER(15,3)                   NULL,
  DCT_PA2_BIV        NUMBER(15,3)                   NULL,
  DCT_PA2_BV         NUMBER(15,3)                   NULL,
  DCT_PA2_BVI        NUMBER(15,3)                   NULL,
  DCT_PA2_B_ANT      NUMBER(15,3)                   NULL,
  DCT_PA2_B1_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_B1A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B1B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_BI_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_B2_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_B2A_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B2B_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B2C_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B2D_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_B3_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_BII_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_BIII_ANT   NUMBER(15,3)                   NULL,
  DCT_PA2_B4_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_B5_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_B6_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_B7_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_B8_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_BIV_ANT    NUMBER(15,3)                   NULL,
  DCT_PA2_BV_ANT     NUMBER(15,3)                   NULL,
  DCT_PA2_BVI_ANT    NUMBER(15,3)                   NULL,
  DCT_TIP            VARCHAR2(1 BYTE)               NULL,
  DCP_USUCRE         VARCHAR2(30 BYTE)              NULL,
  DCP_DATCRE         DATE                           NULL,
  DCP_USUMOD         VARCHAR2(30 BYTE)              NULL,
  DCP_DATMOD         DATE                           NULL,
  DCT_DATINI         DATE                           NULL
)
;


CREATE TABLE TCMP_DEPCTA08
(
  DC8_CEC_COD      VARCHAR2(4 BYTE)                 NULL,
  DC8_FIS_COD      VARCHAR2(4 BYTE)                 NULL,
  DC8_EXC          VARCHAR2(4 BYTE)                 NULL,
  DC8_COD          VARCHAR2(4 BYTE)                 NULL,
  DC8_TIP          VARCHAR2(1 BYTE)                 NULL,
  DC8_EXC_ANT      VARCHAR2(4 BYTE)                 NULL,
  DC8_FIJO         NUMBER(12,2)                     NULL,
  DC8_FIJO_ANT     NUMBER(12,2)                     NULL,
  DC8_NOFIJO       NUMBER(12,2)                     NULL,
  DC8_NOFIJO_ANT   NUMBER(12,2)                     NULL,
  DC8_DAT          DATE                             NULL,
  DC8_TOTPAG       NUMBER(10)                       NULL,
  DC8_CAUSA        VARCHAR2(100 BYTE)               NULL,
  DC8_USUCRE       VARCHAR2(30 BYTE)                NULL,
  DC8_DATCRE       DATE                             NULL,
  DC8_USUMOD       VARCHAR2(30 BYTE)                NULL,
  DC8_DATMOD       DATE                             NULL,
  DC8_DATINI       DATE                             NULL,
  DC8_MCR          VARCHAR2(1 BYTE)                 NULL,
  DC8_DISCAP       NUMBER(12,2)                     NULL,
  DC8_DISCAP_ANT   NUMBER(12,2)                     NULL,
  DC8_FIJOH        NUMBER(12,2)                     NULL,
  DC8_FIJOM        NUMBER(12,2)                     NULL,
  DC8_FIJOH_ANT    NUMBER(12,2)                     NULL,
  DC8_FIJOM_ANT    NUMBER(12,2)                     NULL,
  DC8_NOFIJOH      NUMBER(12,2)                     NULL,
  DC8_NOFIJOM      NUMBER(12,2)                     NULL,
  DC8_NOFIJOH_ANT  NUMBER(12,2)                     NULL,
  DC8_NOFIJOM_ANT  NUMBER(12,2)                     NULL
)
;


CREATE TABLE TCMP_DEPPRO
(
  DPJ_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DPJ_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  DPJ_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DPJ_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  DPJ_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DPJ_DATCRE   DATE                                 NULL
)
;


CREATE TABLE TCMP_DEPPROCT5
(
  DPR_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DPR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DPR_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  DPR_SEQ      NUMBER(10)                           NULL,
  DPR_PTEDEP   NUMBER(5,2)                      DEFAULT 0                         NULL,
  DPR_PTEPRO   NUMBER(5,2)                      DEFAULT 0                         NULL,
  DPR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DPR_DATCRE   DATE                                 NULL,
  DPR_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  DPR_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  DPR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DPR_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_DIARIS
(
  DIA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DIA_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DIA_COD      VARCHAR2(2 BYTE)                     NULL,
  DIA_DES      VARCHAR2(30 BYTE)                    NULL,
  DIA_TIPDIA   VARCHAR2(1 BYTE)                     NULL,
  DIA_TANCAT   VARCHAR2(1 BYTE)                     NULL,
  DIA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DIA_DATCRE   DATE                                 NULL,
  DIA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DIA_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_DSC
(
  DSC_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  DSC_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  DSC_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  DSC_CEC_CODDTI  VARCHAR2(4 BYTE)                  NULL,
  DSC_EMP_CODDTI  VARCHAR2(4 BYTE)                  NULL,
  DSC_CT5_CODDTI  VARCHAR2(10 BYTE)                 NULL,
  DSC_DIA_CODDTI  VARCHAR2(2 BYTE)                  NULL,
  DSC_PTE         NUMBER(5,2)                       NULL,
  DSC_DATCRE      DATE                              NULL,
  DSC_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  DSC_DATMOD      DATE                              NULL,
  DSC_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TCMP_EGR
(
  EGR_AGE_COD  VARCHAR2(4 BYTE)                     NULL,
  EGR_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  EGR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  EGR_DATCRE   DATE                                 NULL,
  EGR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EGR_IDF      VARCHAR2(1 BYTE)                     NULL,
  EGR_PTE      NUMBER(5,2)                          NULL,
  EGR_DATMOD   DATE                                 NULL,
  EGR_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_LEA
(
  LEA_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  LEA_EMP_COD       VARCHAR2(4 BYTE)                NULL,
  LEA_COD           VARCHAR2(15 BYTE)               NULL,
  LEA_PRDPAG        VARCHAR2(1 BYTE)                NULL,
  LEA_TIP           VARCHAR2(1 BYTE)                NULL,
  LEA_TIPANY        VARCHAR2(1 BYTE)                NULL,
  LEA_PRDREVIRS     VARCHAR2(1 BYTE)                NULL,
  LEA_MON_COD       VARCHAR2(2 BYTE)                NULL,
  LEA_NUMPAG        NUMBER(3)                       NULL,
  LEA_CPI           NUMBER(15,2)                    NULL,
  LEA_DIACTC        DATE                            NULL,
  LEA_DIAINIPAGIRS  DATE                            NULL,
  LEA_DIAINIPAGCPI  DATE                            NULL,
  LEA_DES           VARCHAR2(60 BYTE)               NULL,
  LEA_USUCRE        VARCHAR2(30 BYTE)               NULL,
  LEA_DATCRE        DATE                            NULL,
  LEA_CT5_CODAMO    VARCHAR2(10 BYTE)               NULL,
  LEA_CT5_CODLEA    VARCHAR2(10 BYTE)               NULL,
  LEA_CT5_CODBAN    VARCHAR2(10 BYTE)               NULL,
  LEA_CT5_CODPLA    VARCHAR2(10 BYTE)               NULL,
  LEA_CT5_CODDSP    VARCHAR2(10 BYTE)               NULL,
  LEA_DIAPAG        NUMBER(2)                       NULL,
  LEA_DIA_COD       VARCHAR2(2 BYTE)                NULL,
  LEA_IVA_COD       VARCHAR2(4 BYTE)                NULL,
  LEA_NUMCTR        VARCHAR2(20 BYTE)               NULL,
  LEA_EJE_COD       VARCHAR2(4 BYTE)                NULL,
  LEA_ASI_NUMASI    NUMBER(10)                      NULL,
  LEA_USUMOD        VARCHAR2(30 BYTE)               NULL,
  LEA_DATMOD        DATE                            NULL,
  LEA_OBS           VARCHAR2(1000 BYTE)             NULL,
  LEA_ULTDIAREVIRS  DATE                            NULL,
  LEA_VALRES        NUMBER(15,2)                    NULL,
  LEA_CLS           VARCHAR2(1 BYTE)                NULL,
  LEA_CT5_CODCMI    VARCHAR2(10 BYTE)               NULL,
  LEA_NIF           VARCHAR2(12 BYTE)               NULL,
  LEA_NOM           VARCHAR2(40 BYTE)               NULL,
  LEA_PRDPAGIRS     VARCHAR2(1 BYTE)                NULL,
  LEA_TIPIRS        VARCHAR2(1 BYTE)                NULL,
  LEA_PAGINI        VARCHAR2(1 BYTE)                NULL,
  LEA_CT5_CODACR    VARCHAR2(10 BYTE)               NULL,
  LEA_TIPANYIRS     VARCHAR2(1 BYTE)                NULL
)
;


CREATE TABLE TCMP_LLOGUERS
(
  LLO_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  LLO_EMP_COD   VARCHAR2(4 BYTE)                    NULL,
  LLO_CT5_COD   VARCHAR2(10 BYTE)                   NULL,
  LLO_SEQ       NUMBER(10)                          NULL,
  LLO_TAD       VARCHAR2(2 BYTE)                    NULL,
  LLO_DOM       VARCHAR2(30 BYTE)                   NULL,
  LLO_NUM       NUMBER(5)                           NULL,
  LLO_ESC       VARCHAR2(2 BYTE)                    NULL,
  LLO_PIS       VARCHAR2(2 BYTE)                    NULL,
  LLO_PTA       VARCHAR2(2 BYTE)                    NULL,
  LLO_POB_COD   VARCHAR2(8 BYTE)                    NULL,
  LLO_CADASTRE  VARCHAR2(20 BYTE)                   NULL,
  LLO_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  LLO_DATCRE    DATE                                NULL,
  LLO_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  LLO_DATMOD    DATE                                NULL
)
;


CREATE TABLE TCMP_M390DSG
(
  M90D_CEC_COD  VARCHAR2(4 BYTE)                    NULL,
  M90D_FIS_COD  VARCHAR2(4 BYTE)                    NULL,
  M90D_M90_EXC  VARCHAR2(4 BYTE)                    NULL,
  M90D_DMO_MDL  VARCHAR2(3 BYTE)                    NULL,
  M90D_DMO_GRP  VARCHAR2(3 BYTE)                    NULL,
  M90D_DMO_COD  VARCHAR2(3 BYTE)                    NULL,
  M90D_PTE      NUMBER(5,2)                         NULL,
  M90D_BIM      NUMBER(15,3)                        NULL,
  M90D_QUO      NUMBER(15,3)                        NULL,
  M90D_USUCRE   VARCHAR2(30 BYTE)                   NULL,
  M90D_DATCRE   DATE                                NULL,
  M90D_USUMOD   VARCHAR2(30 BYTE)                   NULL,
  M90D_DATMOD   DATE                                NULL
)
;


CREATE TABLE TCMP_MODEMPIVA
(
  MEI_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  MEI_FIS_COD       VARCHAR2(4 BYTE)                NULL,
  MEI_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  MEI_CMI_ANY       NUMBER(4)                       NULL,
  MEI_CMI_SEQ       NUMBER(10)                      NULL,
  MEI_MIV_SEQ       NUMBER(10)                      NULL,
  MEI_MAGINIMOD     NUMBER(15,3)                DEFAULT 0                         NULL,
  MEI_MAGFINMOD     NUMBER(15,3)                DEFAULT 0                         NULL,
  MEI_USUCRE        VARCHAR2(30 BYTE)               NULL,
  MEI_DATCRE        DATE                            NULL,
  MEI_USUMOD        VARCHAR2(30 BYTE)               NULL,
  MEI_DATMOD        DATE                            NULL
)
;


CREATE TABLE TCMP_MODIRPFEMP
(
  MPF_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  MPF_FIS_COD       VARCHAR2(4 BYTE)                NULL,
  MPF_IAE_EPIGRAFE  VARCHAR2(5 BYTE)                NULL,
  MPF_CMR_ANY       NUMBER(4)                       NULL,
  MPF_CMR_SEQ       NUMBER(10)                      NULL,
  MPF_MIR_SEQ       NUMBER(10)                      NULL,
  MPF_MAGINIMOD     NUMBER(15,3)                DEFAULT 0                         NULL,
  MPF_MAGFINMOD     NUMBER(15,3)                DEFAULT 0                         NULL,
  MPF_USUCRE        VARCHAR2(30 BYTE)               NULL,
  MPF_DATCRE        DATE                            NULL,
  MPF_USUMOD        VARCHAR2(30 BYTE)               NULL,
  MPF_DATMOD        DATE                            NULL,
  MPF_MAGINIANT     NUMBER(15,3)                    NULL,
  MPF_MAGFINANT     NUMBER(15,3)                    NULL
)
;


CREATE TABLE TCMP_PARTITRANS
(
  TRA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  TRA_FIS_COD  VARCHAR2(4 BYTE)                     NULL,
  TRA_ACE_SEQ  NUMBER(10)                           NULL,
  TRA_ANY      NUMBER(4)                            NULL,
  TRA_MON_COD  VARCHAR2(1 BYTE)                     NULL,
  TRA_BASIMP   NUMBER(15,3)                     DEFAULT 0                         NULL,
  TRA_VALBAS   NUMBER(15,3)                     DEFAULT 0                         NULL,
  TRA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TRA_DATCRE   DATE                                 NULL,
  TRA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TRA_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_PRESUDESGLOSES_ANUAL
(
  PDA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PDA_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDA_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  PDA_PRE_ANY  NUMBER(4)                            NULL,
  PDA_SEQ      NUMBER(10)                           NULL,
  PDA_PTE      NUMBER(5,2)                      DEFAULT 0                         NULL,
  PDA_IMPPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PDA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PDA_DATCRE   DATE                                 NULL,
  PDA_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDA_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  PDA_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  PDA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PDA_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_PRESUPOSTS
(
  PRE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PRE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PRE_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  PRE_ANY      NUMBER(4)                            NULL,
  PRE_MES      NUMBER(2)                            NULL,
  PRE_MON_COD  VARCHAR2(1 BYTE)                     NULL,
  PRE_IMPPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PRE_VALPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PRE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PRE_DATCRE   DATE                                 NULL,
  PRE_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PRE_DATMOD   DATE                                 NULL,
  PRE_MOD      NUMBER(15,3)                         NULL
)
;


CREATE TABLE TCMP_PROJECTEDIARI
(
  PDI_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PDI_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDI_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  PDI_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  PDI_DATCRE   DATE                                 NULL,
  PDI_USUCRE   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_RETENCIONS
(
  RET_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  RET_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  RET_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  RET_NIF_NIF  VARCHAR2(12 BYTE)                    NULL,
  RET_RPR      VARCHAR2(1 BYTE)                     NULL,
  RET_SITFAM   VARCHAR2(3 BYTE)                     NULL,
  RET_PTERET   NUMBER(5,2)                      DEFAULT 0                         NULL,
  RET_CLA      VARCHAR2(1 BYTE)                     NULL,
  RET_DINESP   VARCHAR2(1 BYTE)                     NULL,
  RET_DATALT   DATE                                 NULL,
  RET_TIPCON   VARCHAR2(30 BYTE)                    NULL,
  RET_DATFIN   DATE                                 NULL,
  RET_DATBAI   DATE                                 NULL,
  RET_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  RET_DATCRE   DATE                                 NULL,
  RET_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  RET_DATMOD   DATE                                 NULL,
  RET_TIP      VARCHAR2(1 BYTE)                 DEFAULT 'B'                       NULL,
  RET_CTE      VARCHAR2(10 BYTE)                    NULL,
  RET_CLA002   VARCHAR2(2 BYTE)                     NULL
)
;


CREATE TABLE TCMP_RSC
(
  RSC_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  RSC_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  RSC_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  RSC_SEQ         NUMBER(10)                        NULL,
  RSC_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  RSC_BLO         VARCHAR2(1 BYTE)                  NULL,
  RSC_ANY         NUMBER(4)                         NULL,
  RSC_DATRSV      DATE                              NULL,
  RSC_IMP         NUMBER(15,2)                      NULL,
  RSC_DATCRE      DATE                              NULL,
  RSC_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  RSC_CT5_CODDSP  VARCHAR2(10 BYTE)                 NULL,
  RSC_PRO_COD     VARCHAR2(4 BYTE)                  NULL,
  RSC_DEP_COD     VARCHAR2(4 BYTE)                  NULL,
  RSC_DES         VARCHAR2(1000 BYTE)               NULL,
  RSC_RESPOL      VARCHAR2(30 BYTE)                 NULL,
  RSC_DATMOD      DATE                              NULL,
  RSC_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  RSC_OBS         VARCHAR2(1000 BYTE)               NULL,
  RSC_OBSBLO      VARCHAR2(1000 BYTE)               NULL
)
;


CREATE TABLE TCMP_RST
(
  RST_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  RST_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  RST_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  RST_COD         VARCHAR2(2 BYTE)                  NULL,
  RST_CIV_COD     VARCHAR2(2 BYTE)                  NULL,
  RST_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  RST_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  RST_RETBASTOT   VARCHAR2(1 BYTE)                  NULL,
  RST_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  RST_DATCRE      DATE                              NULL,
  RST_CT5_CODRET  VARCHAR2(10 BYTE)                 NULL,
  RST_CT5_CODVEN  VARCHAR2(10 BYTE)                 NULL,
  RST_DES         VARCHAR2(30 BYTE)                 NULL,
  RST_RET         NUMBER(5,2)                       NULL,
  RST_DATMOD      DATE                              NULL,
  RST_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TCMP_SER
(
  SER_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  SER_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  SER_COD         VARCHAR2(3 BYTE)                  NULL,
  SER_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  SER_DATCRE      DATE                              NULL,
  SER_ULTNUM0     NUMBER(10)                        NULL,
  SER_ULTNUM1     NUMBER(10)                        NULL,
  SER_DES         VARCHAR2(50 BYTE)                 NULL,
  SER_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  SER_DATMOD      DATE                              NULL,
  SER_TAS_COD     VARCHAR2(2 BYTE)                  NULL,
  SER_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  SER_CT5_CODRET  VARCHAR2(10 BYTE)                 NULL,
  SER_CT5_CODVEN  VARCHAR2(10 BYTE)                 NULL
)
;


CREATE TABLE TCMP_VALORSNEGO
(
  VAL_CEC_COD   VARCHAR2(4 BYTE)                    NULL,
  VAL_EMP_COD   VARCHAR2(4 BYTE)                    NULL,
  VAL_CT5_COD   VARCHAR2(10 BYTE)                   NULL,
  VAL_SOCIETAT  VARCHAR2(40 BYTE)                   NULL,
  VAL_ACCIONS   NUMBER(15)                      DEFAULT 0                         NULL,
  VAL_NUMACC    VARCHAR2(100 BYTE)                  NULL,
  VAL_DATADQ    DATE                                NULL,
  VAL_VALADQ    NUMBER(15,3)                    DEFAULT 0                         NULL,
  VAL_DATVEN    DATE                                NULL,
  VAL_VALVEN    NUMBER(15,3)                    DEFAULT 0                         NULL,
  VAL_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  VAL_DATCRE    DATE                                NULL,
  VAL_USUMOD    VARCHAR2(30 BYTE)                   NULL,
  VAL_DATMOD    DATE                                NULL
)
;


CREATE TABLE TCMP_VENCIMENTS
(
  VEN_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  VEN_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  VEN_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  VEN_SEQ         NUMBER(10)                        NULL,
  VEN_IG          VARCHAR2(1 BYTE)                  NULL,
  VEN_DATDOC      DATE                              NULL,
  VEN_DATVTO      DATE                              NULL,
  VEN_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  VEN_CON         VARCHAR2(30 BYTE)                 NULL,
  VEN_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  VEN_IMPVTO      NUMBER(15,3)                  DEFAULT 0                         NULL,
  VEN_NUMFAC      VARCHAR2(8 BYTE)                  NULL,
  VEN_DESTI       VARCHAR2(10 BYTE)                 NULL,
  VEN_ACTIU       VARCHAR2(1 BYTE)              DEFAULT 'S'                       NULL,
  VEN_REMESA      VARCHAR2(10 BYTE)                 NULL,
  VEN_DATREM      DATE                              NULL,
  VEN_VALIMP      NUMBER(15,3)                  DEFAULT 0                         NULL,
  VEN_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  VEN_DATCRE      DATE                              NULL,
  VEN_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  VEN_DATMOD      DATE                              NULL,
  VEN_CONTAPU     NUMBER(10)                        NULL,
  VEN_OBS         VARCHAR2(1000 BYTE)               NULL,
  VEN_CIV_COD     VARCHAR2(2 BYTE)                  NULL,
  VEN_IVA_COD     VARCHAR2(4 BYTE)                  NULL,
  VEN_CLV_COD     VARCHAR2(4 BYTE)                  NULL,
  VEN_DATAUX      DATE                              NULL,
  VEN_CNCAUX      VARCHAR2(255 BYTE)                NULL,
  VEN_DATCNF      DATE                              NULL,
  VEN_CT5_CODORI  VARCHAR2(10 BYTE)                 NULL
)
;


CREATE INDEX ICMP_ACA_FIS_FK_I ON TCMP_ACCIONSALTRES
(ACA_CEC_COD, ACA_FIS_COD)
;


CREATE INDEX ICMP_ACA_MON_FK_I ON TCMP_ACCIONSALTRES
(ACA_CEC_COD, ACA_MON_COD)
;


CREATE INDEX ICMP_ACA_NIF_FK_I ON TCMP_ACCIONSALTRES
(ACA_CEC_COD, ACA_NIF_NIF)
;


CREATE INDEX ICMP_ACA_PRV_FK_I ON TCMP_ACCIONSALTRES
(ACA_CEC_COD, ACA_PRV_COD)
;


CREATE INDEX ICMP_ACE_FIS_FK_I ON TCMP_ACCIONSPROPIES
(ACE_CEC_COD, ACE_FIS_COD)
;


CREATE INDEX ICMP_ACE_MON_FK_I ON TCMP_ACCIONSPROPIES
(ACE_CEC_COD, ACE_MON_COD)
;


CREATE INDEX ICMP_ACE_NIF_FK_I ON TCMP_ACCIONSPROPIES
(ACE_CEC_COD, ACE_NIF_NIF)
;


CREATE INDEX ICMP_ACT_FIS_FK_I ON TCMP_ACTIVITATS
(ACT_CEC_COD, ACT_FIS_COD)
;


CREATE INDEX ICMP_ACT_IAE_FK_I ON TCMP_ACTIVITATS
(ACT_CEC_COD, ACT_IAE_EPIGRAFE)
;


CREATE INDEX ICMP_ACT_POB_FK_I ON TCMP_ACTIVITATS
(ACT_CEC_COD, ACT_POB_COD)
;


CREATE INDEX ICMP_ACT_PRV_FK_I ON TCMP_ACTIVITATS
(ACT_CEC_COD, ACT_PRV_COD)
;


CREATE INDEX ICMP_ADM_FIS_FK_I ON TCMP_ADMINISTRADORS
(ADM_CEC_COD, ADM_FIS_COD)
;


CREATE INDEX ICMP_ADM_NIF_FK_I ON TCMP_ADMINISTRADORS
(ADM_CEC_COD, ADM_NIF_NIF)
;


CREATE INDEX ICMP_ADM_PRV_FK_I ON TCMP_ADMINISTRADORS
(ADM_CEC_COD, ADM_PRV_COD)
;


CREATE INDEX ICMP_AIS_FIS_FK_I ON TCMP_ANUALSIMPSOCI
(AIS_CEC_COD, AIS_FIS_COD)
;


CREATE INDEX ICMP_BFI_FIS_FK_I ON TCMP_BFI
(BFI_CEC_COD, BFI_FIS_COD)
;


CREATE INDEX ICMP_CMI_FIS_FK_I ON TCMP_CONMODIVAS
(CMI_CEC_COD, CMI_FIS_COD)
;


CREATE INDEX ICMP_CMI_IAE_FK_I ON TCMP_CONMODIVAS
(CMI_CEC_COD, CMI_IAE_EPIGRAFE)
;


CREATE INDEX ICMP_CMR_FIS_FK_I ON TCMP_CONMODIRPFS
(CMR_CEC_COD, CMR_FIS_COD)
;


CREATE INDEX ICMP_CMR_IAE_FK_I ON TCMP_CONMODIRPFS
(CMR_IAE_EPIGRAFE)
;


CREATE INDEX ICMP_CT1_EMP_FK_I ON TCMP_COMPTES1
(CT1_CEC_COD, CT1_EMP_COD)
;


CREATE INDEX ICMP_CT2_CT1_FK_I ON TCMP_COMPTES2
(CT2_CEC_COD, CT2_EMP_COD, CT2_CT1_COD)
;


CREATE INDEX ICMP_CT2_EMP_FK_I ON TCMP_COMPTES2
(CT2_CEC_COD, CT2_EMP_COD)
;


CREATE INDEX ICMP_CT3_CT2_FK_I ON TCMP_COMPTES3
(CT3_CEC_COD, CT3_EMP_COD, CT3_CT2_COD)
;


CREATE INDEX ICMP_CT3_EMP_FK_I ON TCMP_COMPTES3
(CT3_CEC_COD, CT3_EMP_COD)
;


CREATE INDEX ICMP_CT4_CT3_FK_I ON TCMP_COMPTES4
(CT4_CEC_COD, CT4_EMP_COD, CT4_CT3_COD)
;


CREATE INDEX ICMP_CT4_EMP_FK_I ON TCMP_COMPTES4
(CT4_CEC_COD, CT4_EMP_COD)
;


CREATE INDEX ICMP_CT5_ALI_FK_I ON TCMP_COMPTES5
(CT5_CEC_COD, CT5_EMP_COD, CT5_ALI)
;


CREATE INDEX ICMP_CT5_CT4_FK_I ON TCMP_COMPTES5
(CT5_CEC_COD, CT5_EMP_COD, CT5_CT4_COD)
;


CREATE INDEX ICMP_CT5_EMP_FK_I ON TCMP_COMPTES5
(CT5_CEC_COD, CT5_EMP_COD)
;


CREATE INDEX ICMP_CT5_MON_FK_I ON TCMP_COMPTES5
(CT5_CEC_COD, CT5_MON_COD)
;


CREATE INDEX ICMP_DCP_NIF_FK_I ON TCMP_DADESCLIPROS
(DCP_CEC_COD, DCP_NIF_NIF)
;


CREATE INDEX ICMP_DCT_CEC_FK_I ON TCMP_DEPCTA
(DCT_CEC_COD)
;


CREATE INDEX ICMP_DCT_FIS_FK_I ON TCMP_DEPCTA
(DCT_CEC_COD, DCT_FIS_COD)
;


CREATE INDEX ICMP_DEP_EMP_FK_I ON TCMP_DEPARTAMENTS
(DEP_CEC_COD, DEP_EMP_COD)
;


CREATE INDEX ICMP_DIA_EMP_FK_I ON TCMP_DIARIS
(DIA_CEC_COD, DIA_EMP_COD)
;


CREATE INDEX ICMP_DPR_CT5_FK_I ON TCMP_DEPPROCT5
(DPR_CEC_COD, DPR_EMP_COD, DPR_CT5_COD)
;


CREATE INDEX ICMP_DPR_DEP_FK_I ON TCMP_DEPPROCT5
(DPR_CEC_COD, DPR_EMP_COD, DPR_DEP_COD)
;


CREATE INDEX ICMP_DPR_PRO_FK_I ON TCMP_DEPPROCT5
(DPR_CEC_COD, DPR_PRO_COD)
;


CREATE INDEX ICMP_LLO_CT5_FK_I ON TCMP_LLOGUERS
(LLO_CEC_COD, LLO_EMP_COD, LLO_CT5_COD)
;


CREATE INDEX ICMP_LLO_POB_FK_I ON TCMP_LLOGUERS
(LLO_CEC_COD, LLO_POB_COD)
;


CREATE INDEX ICMP_MEI_CMI_FK_I ON TCMP_MODEMPIVA
(MEI_CEC_COD, MEI_FIS_COD, MEI_IAE_EPIGRAFE, MEI_CMI_ANY, MEI_CMI_SEQ)
;


CREATE INDEX ICMP_MEI_MIV_FK_I ON TCMP_MODEMPIVA
(MEI_CEC_COD, MEI_IAE_EPIGRAFE, MEI_MIV_SEQ)
;


CREATE INDEX ICMP_MPF_CMR_FK_I ON TCMP_MODIRPFEMP
(MPF_CEC_COD, MPF_FIS_COD, MPF_IAE_EPIGRAFE, MPF_CMR_ANY, MPF_CMR_SEQ)
;


CREATE INDEX ICMP_MPF_MIR_FK_I ON TCMP_MODIRPFEMP
(MPF_CEC_COD, MPF_IAE_EPIGRAFE, MPF_MIR_SEQ)
;


CREATE INDEX ICMP_OPH_FIS_FK ON TCMP_347OPH
(OPH_CEC_COD, OPH_EMP_COD)
;


CREATE INDEX ICMP_PDI_PRO_FK_I ON TCMP_PROJECTEDIARI
(PDI_CEC_COD, PDI_PRO_COD)
;


CREATE INDEX ICMP_PRE_CT5_FK_I ON TCMP_PRESUPOSTS
(PRE_CEC_COD, PRE_EMP_COD, PRE_CT5_COD)
;


CREATE INDEX ICMP_PRE_MON_FK_I ON TCMP_PRESUPOSTS
(PRE_CEC_COD, PRE_MON_COD)
;


CREATE INDEX ICMP_RET_NIF_FK_I ON TCMP_RETENCIONS
(RET_EMP_COD, RET_NIF_NIF)
;


CREATE INDEX ICMP_RST_CIV_FK_I ON TCMP_RST
(RST_CEC_COD, RST_CIV_COD)
;


CREATE INDEX ICMP_RST_CT5RET_FK_I ON TCMP_RST
(RST_CEC_COD, RST_CT5_COD, RST_CT5_CODRET)
;


CREATE INDEX ICMP_RST_CT5VTA_FK_I ON TCMP_RST
(RST_CEC_COD, RST_EMP_COD, RST_CT5_CODVEN)
;


CREATE INDEX ICMP_RST_CT5_FK_I ON TCMP_RST
(RST_CEC_COD, RST_EMP_COD, RST_CT5_COD)
;


CREATE INDEX ICMP_RST_DIA_FK_I ON TCMP_RST
(RST_CEC_COD, RST_EMP_COD, RST_DIA_COD)
;


CREATE INDEX ICMP_RST_MON_FK_I ON TCMP_RST
(RST_CEC_COD, RST_MON_COD)
;


CREATE INDEX ICMP_SER_CT5RET_FK_I ON TCMP_SER
(SER_CEC_COD, SER_EMP_COD, SER_CT5_CODRET)
;


CREATE INDEX ICMP_SER_CT5VEN_FK_I ON TCMP_SER
(SER_CEC_COD, SER_EMP_COD, SER_CT5_CODVEN)
;


CREATE INDEX ICMP_SER_EJE_FK_I ON TCMP_SER
(SER_CEC_COD, SER_EMP_COD, SER_EJE_COD)
;


CREATE INDEX ICMP_SER_EMP_FK_I ON TCMP_SER
(SER_CEC_COD, SER_EMP_COD)
;


CREATE INDEX ICMP_SER_TAS_FK_I ON TCMP_SER
(SER_CEC_COD, SER_TAS_COD)
;


CREATE INDEX ICMP_TRA_ACE_FK_I ON TCMP_PARTITRANS
(TRA_CEC_COD, TRA_FIS_COD, TRA_ACE_SEQ)
;


CREATE INDEX ICMP_TRA_MON_FK_I ON TCMP_PARTITRANS
(TRA_CEC_COD, TRA_MON_COD)
;


CREATE INDEX ICMP_VEN_CT5_FK_I ON TCMP_VENCIMENTS
(VEN_CEC_COD, VEN_EMP_COD, VEN_CT5_COD)
;


CREATE INDEX ICMP_VEN_DIA_FK_I ON TCMP_VENCIMENTS
(VEN_CEC_COD, VEN_EMP_COD, VEN_DIA_COD)
;


CREATE INDEX ICMP_VEN_MON_FK_I ON TCMP_VENCIMENTS
(VEN_CEC_COD, VEN_MON_COD)
;


CREATE UNIQUE INDEX RCMP_ACA_PK ON TCMP_ACCIONSALTRES
(ACA_CEC_COD, ACA_FIS_COD, ACA_SEQ)
;


CREATE UNIQUE INDEX RCMP_ACE_PK ON TCMP_ACCIONSPROPIES
(ACE_CEC_COD, ACE_FIS_COD, ACE_SEQ)
;


CREATE UNIQUE INDEX RCMP_ACT_PK ON TCMP_ACTIVITATS
(ACT_CEC_COD, ACT_FIS_COD, ACT_IAE_EPIGRAFE, ACT_SEQ)
;


CREATE UNIQUE INDEX RCMP_ADM_PK ON TCMP_ADMINISTRADORS
(ADM_CEC_COD, ADM_FIS_COD, ADM_NIF_NIF, ADM_SEQ)
;


CREATE UNIQUE INDEX RCMP_AIS_PK ON TCMP_ANUALSIMPSOCI
(AIS_CEC_COD, AIS_FIS_COD, AIS_ANY)
;


CREATE UNIQUE INDEX RCMP_BFI_PK ON TCMP_BFI
(BFI_CEC_COD, BFI_FIS_COD, BFI_BAN, BFI_OFI, BFI_CCR)
;


CREATE UNIQUE INDEX RCMP_CMI_PK ON TCMP_CONMODIVAS
(CMI_CEC_COD, CMI_FIS_COD, CMI_IAE_EPIGRAFE, CMI_ANY, CMI_SEQ)
;


CREATE UNIQUE INDEX RCMP_CMR_PK ON TCMP_CONMODIRPFS
(CMR_CEC_COD, CMR_FIS_COD, CMR_IAE_EPIGRAFE, CMR_ANY, CMR_SEQ)
;


CREATE UNIQUE INDEX RCMP_CT1_PK ON TCMP_COMPTES1
(CT1_CEC_COD, CT1_EMP_COD, CT1_COD)
;


CREATE UNIQUE INDEX RCMP_CT2_PK ON TCMP_COMPTES2
(CT2_CEC_COD, CT2_EMP_COD, CT2_COD)
;


CREATE UNIQUE INDEX RCMP_CT3_PK ON TCMP_COMPTES3
(CT3_CEC_COD, CT3_EMP_COD, CT3_COD)
;


CREATE UNIQUE INDEX RCMP_CT4_PK ON TCMP_COMPTES4
(CT4_CEC_COD, CT4_EMP_COD, CT4_COD)
;


CREATE UNIQUE INDEX RCMP_CT5_PK ON TCMP_COMPTES5
(CT5_CEC_COD, CT5_EMP_COD, CT5_COD)
;


CREATE UNIQUE INDEX RCMP_DC8_PK ON TCMP_DEPCTA08
(DC8_CEC_COD, DC8_FIS_COD, DC8_EXC, DC8_COD, DC8_TIP)
;


CREATE UNIQUE INDEX RCMP_DCP_PK ON TCMP_DADESCLIPROS
(DCP_CEC_COD, DCP_EMP_COD, DCP_CT5_COD)
;


CREATE UNIQUE INDEX RCMP_DCT_PK ON TCMP_DEPCTA
(DCT_CEC_COD, DCT_FIS_COD, DCT_EXC, DCT_TIP)
;


CREATE UNIQUE INDEX RCMP_DEP_PK ON TCMP_DEPARTAMENTS
(DEP_CEC_COD, DEP_EMP_COD, DEP_COD)
;


CREATE UNIQUE INDEX RCMP_DIA_PK ON TCMP_DIARIS
(DIA_CEC_COD, DIA_EMP_COD, DIA_COD)
;


CREATE UNIQUE INDEX RCMP_DPJ_PK ON TCMP_DEPPRO
(DPJ_CEC_COD, DPJ_PRO_COD, DPJ_EMP_COD, DPJ_DEP_COD)
;


CREATE UNIQUE INDEX RCMP_DPR_PK ON TCMP_DEPPROCT5
(DPR_CEC_COD, DPR_EMP_COD, DPR_CT5_COD, DPR_SEQ)
;


CREATE UNIQUE INDEX RCMP_DSC_PK ON TCMP_DSC
(DSC_CEC_COD, DSC_EMP_COD, DSC_CT5_COD, DSC_CEC_CODDTI, DSC_EMP_CODDTI, 
DSC_CT5_CODDTI, DSC_DIA_CODDTI)
;


CREATE UNIQUE INDEX RCMP_EGR_PK ON TCMP_EGR
(EGR_AGE_COD, EGR_CEC_COD, EGR_EMP_COD)
;


CREATE UNIQUE INDEX RCMP_LEA_PK ON TCMP_LEA
(LEA_CEC_COD, LEA_EMP_COD, LEA_COD)
;


CREATE UNIQUE INDEX RCMP_LLO_PK ON TCMP_LLOGUERS
(LLO_CEC_COD, LLO_EMP_COD, LLO_CT5_COD, LLO_SEQ)
;


CREATE UNIQUE INDEX RCMP_M390DSG_PK ON TCMP_M390DSG
(M90D_CEC_COD, M90D_FIS_COD, M90D_M90_EXC, M90D_DMO_GRP, M90D_DMO_COD)
;


CREATE UNIQUE INDEX RCMP_MEI_PK ON TCMP_MODEMPIVA
(MEI_CEC_COD, MEI_FIS_COD, MEI_IAE_EPIGRAFE, MEI_CMI_ANY, MEI_CMI_SEQ, 
MEI_MIV_SEQ)
;


CREATE UNIQUE INDEX RCMP_MPF_PK ON TCMP_MODIRPFEMP
(MPF_CEC_COD, MPF_FIS_COD, MPF_IAE_EPIGRAFE, MPF_CMR_ANY, MPF_CMR_SEQ, 
MPF_MIR_SEQ)
;


CREATE UNIQUE INDEX RCMP_OPH_PK ON TCMP_347OPH
(OPH_CEC_COD, OPH_EMP_COD, OPH_CLASSE, OPH_CLIPRO, OPH_SEQ)
;


CREATE UNIQUE INDEX RCMP_PDA_PK ON TCMP_PRESUDESGLOSES_ANUAL
(PDA_CEC_COD, PDA_EMP_COD, PDA_CT5_COD, PDA_PRE_ANY, PDA_SEQ)
;


CREATE UNIQUE INDEX RCMP_PDI_PK ON TCMP_PROJECTEDIARI
(PDI_CEC_COD, PDI_EMP_COD, PDI_DIA_COD, PDI_PRO_COD)
;


CREATE UNIQUE INDEX RCMP_PRE_PK ON TCMP_PRESUPOSTS
(PRE_CEC_COD, PRE_EMP_COD, PRE_CT5_COD, PRE_ANY, PRE_MES)
;


CREATE UNIQUE INDEX RCMP_RET_PK ON TCMP_RETENCIONS
(RET_CEC_COD, RET_EMP_COD, RET_CT5_COD)
;


CREATE UNIQUE INDEX RCMP_RSC_PK ON TCMP_RSC
(RSC_CEC_COD, RSC_EMP_COD, RSC_DIA_COD, RSC_SEQ)
;


CREATE UNIQUE INDEX RCMP_RST_PK ON TCMP_RST
(RST_CEC_COD, RST_EMP_COD, RST_CT5_COD, RST_COD)
;


CREATE UNIQUE INDEX RCMP_SER_PK ON TCMP_SER
(SER_CEC_COD, SER_EMP_COD, SER_COD)
;


CREATE UNIQUE INDEX RCMP_TCMP_DEL_PK ON TCMP_DEL
(DEL_CEC_COD, DEL_EMP_COD, DEL_COD)
;


CREATE UNIQUE INDEX RCMP_TRA_PK ON TCMP_PARTITRANS
(TRA_CEC_COD, TRA_FIS_COD, TRA_ACE_SEQ, TRA_ANY)
;


CREATE UNIQUE INDEX RCMP_VAL_PK ON TCMP_VALORSNEGO
(VAL_CEC_COD, VAL_EMP_COD, VAL_CT5_COD)
;


CREATE UNIQUE INDEX RCMP_VEN_PK ON TCMP_VENCIMENTS
(VEN_CEC_COD, VEN_EMP_COD, VEN_DIA_COD, VEN_SEQ)
;


CREATE OR REPLACE FORCE VIEW VCMP_MDLPRD
AS 
SELECT m00_cec_cod , m00_fis_cod , m00_exc, m00_prd, '303' FROM TCMP_M00 where m00_exc > '2008'
UNION all
SELECT oph_cec_cod , oph_emp_cod , to_char(NULL) as mod_exc, to_char(NULL) as mod_prd, '347' as mod_num from TCMP_347OPH
UNION all
 SELECT m00_cec_cod , m00_fis_cod , m00_exc, m00_prd, '300' FROM TCMP_M00 where m00_exc <= '2008'
UNION all
 SELECT m11_cec_cod , m11_fis_cod , m11_exc, NULL, '311' FROM TCMP_M11
UNION all
 SELECT m10_cec_cod , m10_fis_cod , m10_exc, m10_prd, '310' FROM TCMP_M10
UNION all
 SELECT m90_cec_cod , m90_fis_cod , m90_exc, null,    '390' FROM TCMP_M90
UNION all
 SELECT m110_cec_cod , m110_fis_cod , m110_exc, m110_prd, '110' FROM TCMP_MOD110
UNION all
 SELECT m115_cec_cod , m115_fis_cod , m115_exc, m115_prd, '115' FROM TCMP_MOD115
UNION all
 SELECT m123_cec_cod , m123_fis_cod , m123_exc, m123_prd, '123' FROM TCMP_MOD123
UNION all
 SELECT m130_cec_cod , m130_fis_cod , m130_exc, m130_prd, '130' FROM TCMP_MOD130
UNION all
 SELECT m131_cec_cod , m131_fis_cod , m131_exc, m131_prd, '131' FROM TCMP_MOD131
UNION all
 SELECT m81_cec_cod , m81_fis_cod , m81_exc, NULL, '180' FROM TCMP_MOD180_R1
UNION all
 SELECT m91_cec_cod , m91_fis_cod , m91_exc, NULL, '190' FROM TCMP_MOD190_R1
UNION all
 SELECT m193_cec_cod , m193_fis_cod , m193_exc, null, '193'  FROM TCMP_MOD193
UNION all
 SELECT m201_cec_cod , m201_fis_cod , m201_exc, null, '200' FROM TCMP_MOD201 where m201_exc >='2009'
UNION all
 SELECT m201_cec_cod , m201_fis_cod , m201_exc, null, '201' FROM TCMP_MOD201 where m201_exc <'2009'
UNION all
 SELECT m202_cec_cod , m202_fis_cod , m202_exc, m202_prd, '202' FROM TCMP_MOD202
UNION all
 SELECT m340_cec_cod , m340_fis_cod , m340_exc, m340_prd, '340' FROM TCMP_MOD340
UNION all
 SELECT m349_cec_cod , m349_fis_cod , m349_exc, m349_prd, '349' FROM TCMP_MOD349_r1;


CREATE TABLE TCMP_347ARRE
(
  ARR_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ARR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  ARR_CLASSE   VARCHAR2(1 BYTE)                     NULL,
  ARR_CLIPRO   VARCHAR2(10 BYTE)                    NULL,
  ARR_COD      VARCHAR2(8 BYTE)                     NULL,
  ARR_IMPORT   NUMBER(15,2)                         NULL,
  ARR_NIF      VARCHAR2(12 BYTE)                    NULL,
  ARR_NOM      VARCHAR2(40 BYTE)                    NULL,
  ARR_PRVPAI   VARCHAR2(5 BYTE)                     NULL,
  ARR_POB      VARCHAR2(30 BYTE)                    NULL,
  ARR_SG       VARCHAR2(5 BYTE)                     NULL,
  ARR_DOM      VARCHAR2(50 BYTE)                    NULL,
  ARR_NUM      NUMBER(5)                            NULL,
  ARR_ESC      VARCHAR2(3 BYTE)                     NULL,
  ARR_PIS      VARCHAR2(3 BYTE)                     NULL,
  ARR_PORTA    VARCHAR2(3 BYTE)                     NULL,
  ARR_CAD      VARCHAR2(25 BYTE)                    NULL,
  ARR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ARR_DATCRE   DATE                                 NULL,
  ARR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  ARR_DATMOD   DATE                                 NULL,
  ARR_SITINM   VARCHAR2(1 BYTE)                     NULL,
  ARR_TIPNUM   VARCHAR2(3 BYTE)                     NULL,
  ARR_CALNUM   VARCHAR2(3 BYTE)                     NULL,
  ARR_BLC      VARCHAR2(3 BYTE)                     NULL,
  ARR_POR      VARCHAR2(3 BYTE)                     NULL,
  ARR_CPL      VARCHAR2(40 BYTE)                    NULL,
  ARR_MUN      VARCHAR2(30 BYTE)                    NULL,
  ARR_CODMUN   VARCHAR2(5 BYTE)                     NULL,
  ARR_CPO      VARCHAR2(5 BYTE)                     NULL,
  ARR_OPH_SEQ  NUMBER(3)                            NULL
)
;


CREATE TABLE TCMP_ADJ
(
  ADJ_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  ADJ_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  ADJ_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  ADJ_SEQ         NUMBER(6)                         NULL,
  ADJ_ANY         NUMBER(4)                         NULL,
  ADJ_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  ADJ_TAN         VARCHAR2(1 BYTE)                  NULL,
  ADJ_CT5_CODPRO  VARCHAR2(10 BYTE)                 NULL,
  ADJ_DATADJ      DATE                              NULL,
  ADJ_BAS         NUMBER(15,2)                  DEFAULT 0                         NULL,
  ADJ_IVA         NUMBER(15,2)                  DEFAULT 0                         NULL,
  ADJ_NIFPRO      VARCHAR2(12 BYTE)                 NULL,
  ADJ_NOMPRO      VARCHAR2(30 BYTE)                 NULL,
  ADJ_DATCRE      DATE                              NULL,
  ADJ_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  ADJ_RSC_SEQ     NUMBER(10)                        NULL,
  ADJ_CT5_CODDSP  VARCHAR2(10 BYTE)                 NULL,
  ADJ_DEP_COD     VARCHAR2(4 BYTE)                  NULL,
  ADJ_PRO_COD     VARCHAR2(4 BYTE)                  NULL,
  ADJ_IVA_COD     VARCHAR2(4 BYTE)                  NULL,
  ADJ_RESPOL      VARCHAR2(30 BYTE)                 NULL,
  ADJ_DES         VARCHAR2(1000 BYTE)               NULL,
  ADJ_NUM         VARCHAR2(20 BYTE)                 NULL,
  ADJ_DATMOD      DATE                              NULL,
  ADJ_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  ADJ_OBS         VARCHAR2(1000 BYTE)               NULL,
  ADJ_OBSTAN      VARCHAR2(1000 BYTE)               NULL,
  ADJ_CTR         VARCHAR2(1 BYTE)              DEFAULT 'N'                       NULL
)
;


CREATE TABLE TCMP_ADP
(
  ADP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ADP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  ADP_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  ADP_ADJ_SEQ  NUMBER(10)                           NULL,
  ADP_SEQ      NUMBER(10)                           NULL,
  ADP_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  ADP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ADP_DATCRE   DATE                                 NULL,
  ADP_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  ADP_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  ADP_PTE      NUMBER(5,2)                          NULL,
  ADP_IMP      NUMBER(15,2)                         NULL,
  ADP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  ADP_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_AMORTIZACIONS
(
  AMO_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  AMO_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  AMO_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  AMO_CT5_CODDEB  VARCHAR2(10 BYTE)                 NULL,
  AMO_CT5_CODHAB  VARCHAR2(10 BYTE)                 NULL,
  AMO_PTEEMP      NUMBER(5,2)                   DEFAULT 0                         NULL,
  AMO_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  AMO_DATCRE      DATE                              NULL,
  AMO_DES         VARCHAR2(75 BYTE)                 NULL,
  AMO_TIPADQ      VARCHAR2(2 BYTE)                  NULL,
  AMO_PRDFIS      NUMBER(2)                         NULL,
  AMO_ANYMEN      VARCHAR2(1 BYTE)                  NULL,
  AMO_AMOANTFIS   NUMBER(15,3)                      NULL,
  AMO_AMOANTCMP   NUMBER(15,3)                      NULL,
  AMO_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  AMO_DATMOD      DATE                              NULL,
  AMO_COD         VARCHAR2(25 BYTE)                 NULL,
  AMO_UBI_COD     VARCHAR2(6 BYTE)                  NULL,
  AMO_DATBAI      DATE                              NULL
)
;


CREATE TABLE TCMP_BANCS
(
  BAN_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  BAN_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  BAN_CT5_COD    VARCHAR2(10 BYTE)                  NULL,
  BAN_NUMCTA     VARCHAR2(20 BYTE)                  NULL,
  BAN_TIPOCTA    VARCHAR2(30 BYTE)                  NULL,
  BAN_LIMPOLIZA  NUMBER(15,3)                   DEFAULT 0                         NULL,
  BAN_DATVTO     DATE                               NULL,
  BAN_LIQINT     VARCHAR2(30 BYTE)                  NULL,
  BAN_AMOCAP     VARCHAR2(30 BYTE)                  NULL,
  BAN_PTEINT     NUMBER(5,2)                    DEFAULT 0                         NULL,
  BAN_PTEDES     NUMBER(5,2)                    DEFAULT 0                         NULL,
  BAN_DATREV     DATE                               NULL,
  BAN_INCVALING  NUMBER(5,2)                    DEFAULT 0                         NULL,
  BAN_INCVALGAS  NUMBER(5,2)                    DEFAULT 0                         NULL,
  BAN_CON        VARCHAR2(100 BYTE)                 NULL,
  BAN_TEL        VARCHAR2(30 BYTE)                  NULL,
  BAN_FAX        VARCHAR2(30 BYTE)                  NULL,
  BAN_EML        VARCHAR2(60 BYTE)                  NULL,
  BAN_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  BAN_DATCRE     DATE                               NULL,
  BAN_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  BAN_DATMOD     DATE                               NULL,
  BAN_IBAN_PAIS  VARCHAR2(2 BYTE)                   NULL,
  BAN_IBAN_DC    VARCHAR2(2 BYTE)                   NULL,
  BAN_IBAN_BBAN  VARCHAR2(30 BYTE)                  NULL,
  BAN_BIC        VARCHAR2(11 BYTE)                  NULL,
  BAN_BAN        VARCHAR2(4 BYTE)                   NULL,
  BAN_OFI        VARCHAR2(4 BYTE)                   NULL,
  BAN_CCR        VARCHAR2(10 BYTE)                  NULL
)
;


CREATE TABLE TCMP_CRV
(
  CRV_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CRV_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CRV_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  CRV_RSC_SEQ  NUMBER(10)                           NULL,
  CRV_SEQ      NUMBER(10)                           NULL,
  CRV_IMP      NUMBER(15,2)                         NULL,
  CRV_DATCRE   DATE                                 NULL,
  CRV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CRV_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  CRV_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  CRV_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  CRV_DATMOD   DATE                                 NULL,
  CRV_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_CTABAN
(
  CTB_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CTB_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CTB_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  CTB_BAN      VARCHAR2(4 BYTE)                     NULL,
  CTB_OFI      VARCHAR2(4 BYTE)                     NULL,
  CTB_CCR      VARCHAR2(10 BYTE)                    NULL,
  CTB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CTB_DATCRE   DATE                                 NULL
)
;


CREATE TABLE TCMP_DAM
(
  DAM_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  DAM_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  DAM_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  DAM_ANYMES      VARCHAR2(1 BYTE)                  NULL,
  DAM_ANY         NUMBER(4)                         NULL,
  DAM_MES         NUMBER(2)                         NULL,
  DAM_CT5_CODDEB  VARCHAR2(10 BYTE)                 NULL,
  DAM_CT5_CODHAB  VARCHAR2(10 BYTE)                 NULL,
  DAM_IMPFIS      NUMBER(15,2)                      NULL,
  DAM_IMPCMP      NUMBER(15,2)                      NULL,
  DAM_DATAMO      DATE                              NULL,
  DAM_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  DAM_DATCRE      DATE                              NULL,
  DAM_EXC         VARCHAR2(4 BYTE)                  NULL,
  DAM_DRI         VARCHAR2(2 BYTE)                  NULL,
  DAM_NUMASI      NUMBER(10)                        NULL,
  DAM_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  DAM_DATMOD      DATE                              NULL,
  DAM_EXCCMP      VARCHAR2(4 BYTE)                  NULL,
  DAM_DRICMP      VARCHAR2(2 BYTE)                  NULL,
  DAM_NUMASICMP   NUMBER(10)                        NULL,
  DAM_AMO_COD     VARCHAR2(25 BYTE)                 NULL
)
;


CREATE TABLE TCMP_DEPPROVEN
(
  DVE_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  DVE_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  DVE_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  DVE_VEN_NUMVEN  NUMBER(10)                        NULL,
  DVE_SEQ         NUMBER(10)                        NULL,
  DVE_DEP_COD     VARCHAR2(4 BYTE)                  NULL,
  DVE_PTEDEP      NUMBER(5,2)                       NULL,
  DVE_IMPDEP      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DVE_PRO_COD     VARCHAR2(4 BYTE)                  NULL,
  DVE_PTEPRO      NUMBER(5,2)                       NULL,
  DVE_IMPPRO      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DVE_VALDEP      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DVE_VALPRO      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DVE_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  DVE_DATCRE      DATE                              NULL,
  DVE_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  DVE_DATMOD      DATE                              NULL
)
;


CREATE TABLE TCMP_DIARIEXERCICI
(
  DEX_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DEX_EJE_COD  VARCHAR2(4 BYTE)                     NULL,
  DEX_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DEX_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  DEX_NUNASI   NUMBER(10)                       DEFAULT 0                         NULL,
  DEX_SOPORT   VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  DEX_NUMSOP   NUMBER(10)                       DEFAULT 0                         NULL,
  DEX_NUMAPU   NUMBER(10)                       DEFAULT 0                         NULL,
  DEX_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DEX_DATCRE   DATE                                 NULL,
  DEX_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DEX_DATMOD   DATE                                 NULL,
  DEX_ENURPC   VARCHAR2(1 BYTE)                     NULL,
  DEX_NUMRPC   NUMBER(10)                           NULL
)
;


CREATE TABLE TCMP_DIS
(
  DIS_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DIS_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DIS_LEA_COD  VARCHAR2(15 BYTE)                    NULL,
  DIS_DIA      DATE                                 NULL,
  DIS_IMP      NUMBER(15,2)                         NULL,
  DIS_DATCRE   DATE                                 NULL,
  DIS_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DIS_DATMOD   DATE                                 NULL,
  DIS_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DIS_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TCMP_ECE
(
  ECE_AGE_COD  VARCHAR2(4 BYTE)                     NULL,
  ECE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ECE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  ECE_CTA      VARCHAR2(10 BYTE)                    NULL,
  ECE_DATCRE   DATE                                 NULL,
  ECE_USUCRE   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_ELE
(
  ELE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  ELE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  ELE_LEA_COD  VARCHAR2(15 BYTE)                    NULL,
  ELE_SEQ      NUMBER(2)                            NULL,
  ELE_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  ELE_DATCRE   DATE                                 NULL,
  ELE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ELE_AMO_COD  VARCHAR2(15 BYTE)                    NULL,
  ELE_DATMOD   DATE                                 NULL,
  ELE_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_EMA
(
  EMA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  EMA_ICV_COD  VARCHAR2(4 BYTE)                     NULL,
  EMA_ACV_COD  VARCHAR2(4 BYTE)                     NULL,
  EMA_CAV_SEQ  NUMBER(3)                            NULL,
  EMA_SEQ      NUMBER(10)                           NULL,
  EMA_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  EMA_EJE_COD  VARCHAR2(4 BYTE)                     NULL,
  EMA_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  EMA_DATCRE   DATE                                 NULL,
  EMA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EMA_NOM      VARCHAR2(30 BYTE)                    NULL,
  EMA_MES001   NUMBER(15,2)                         NULL,
  EMA_MES002   NUMBER(15,2)                         NULL,
  EMA_MES003   NUMBER(15,2)                         NULL,
  EMA_MES004   NUMBER(15,2)                         NULL,
  EMA_MES005   NUMBER(15,2)                         NULL,
  EMA_MES006   NUMBER(15,2)                         NULL,
  EMA_MES007   NUMBER(15,2)                         NULL,
  EMA_MES008   NUMBER(15,2)                         NULL,
  EMA_MES009   NUMBER(15,2)                         NULL,
  EMA_MES010   NUMBER(15,2)                         NULL,
  EMA_MES011   NUMBER(15,2)                         NULL,
  EMA_MES012   NUMBER(15,2)                         NULL,
  EMA_DATMOD   DATE                                 NULL,
  EMA_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_INTERESOS
(
  INT_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  INT_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  INT_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  INT_SEQ      NUMBER                               NULL,
  INT_DATINI   DATE                                 NULL,
  INT_DATFI    DATE                                 NULL,
  INT_PTEINT   NUMBER(5,2)                          NULL,
  INT_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  INT_DATCRE   DATE                                 NULL,
  INT_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  INT_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TCMP_LST
(
  LST_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  LST_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  LST_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  LST_RST_COD     VARCHAR2(2 BYTE)                  NULL,
  LST_NUM         NUMBER(10)                        NULL,
  LST_IVA_COD     VARCHAR2(4 BYTE)                  NULL,
  LST_ORD         NUMBER(5)                         NULL,
  LST_IMP         NUMBER(15,3)                      NULL,
  LST_ACUBAS      VARCHAR2(1 BYTE)                  NULL,
  LST_APLRET      VARCHAR2(1 BYTE)                  NULL,
  LST_VALIMP      NUMBER(15,3)                      NULL,
  LST_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  LST_DATCRE      DATE                              NULL,
  LST_CT5_CODVEN  VARCHAR2(10 BYTE)                 NULL,
  LST_DES         VARCHAR2(50 BYTE)                 NULL,
  LST_DATMOD      DATE                              NULL,
  LST_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TCMP_MILLORES
(
  MLL_AMO_CT5_COD  VARCHAR2(10 BYTE)                NULL,
  MLL_CEC_COD      VARCHAR2(4 BYTE)                 NULL,
  MLL_EMP_COD      VARCHAR2(4 BYTE)                 NULL,
  MLL_SEQ          NUMBER                           NULL,
  MLL_DATCRE       DATE                             NULL,
  MLL_USUCRE       VARCHAR2(30 BYTE)                NULL,
  MLL_DATMLL       DATE                             NULL,
  MLL_BASFIS       NUMBER(15,3)                     NULL,
  MLL_COEANYFIS    NUMBER(5,2)                      NULL,
  MLL_COEMENFIS    NUMBER(5,2)                      NULL,
  MLL_RSIFIS       NUMBER(15,3)                     NULL,
  MLL_DATINIFIS    DATE                             NULL,
  MLL_DATFINFIS    DATE                             NULL,
  MLL_BASCMP       NUMBER(15,3)                     NULL,
  MLL_COEANYCMP    NUMBER(5,2)                      NULL,
  MLL_COEMENCMP    NUMBER(5,2)                      NULL,
  MLL_RSICMP       NUMBER(15,3)                     NULL,
  MLL_DATINICMP    DATE                             NULL,
  MLL_DATFINCMP    DATE                             NULL,
  MLL_USUMOD       VARCHAR2(30 BYTE)                NULL,
  MLL_DATMOD       DATE                             NULL,
  MLL_DES          VARCHAR2(1000 BYTE)              NULL,
  MLL_AMO_COD      VARCHAR2(25 BYTE)                NULL
)
;


CREATE TABLE TCMP_PRESUDESGLOSES
(
  PDE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  PDE_PRE_ANY  NUMBER(4)                            NULL,
  PDE_PRE_MES  NUMBER(2)                            NULL,
  PDE_SEQ      NUMBER(10)                           NULL,
  PDE_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  PDE_PTE      NUMBER(5,2)                      DEFAULT 0                         NULL,
  PDE_IMPPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PDE_VALPRE   NUMBER(15,3)                     DEFAULT 0                         NULL,
  PDE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PDE_DATCRE   DATE                                 NULL,
  PDE_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PDE_DATMOD   DATE                                 NULL,
  PDE_EXD_COD  VARCHAR2(4 BYTE)                     NULL,
  PDE_DEL_COD  VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TCMP_REB
(
  REB_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  REB_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  REB_DIA_COD    VARCHAR2(2 BYTE)                   NULL,
  REB_SER_COD    VARCHAR2(3 BYTE)                   NULL,
  REB_NUM        NUMBER(10)                         NULL,
  REB_CT5_COD    VARCHAR2(10 BYTE)                  NULL,
  REB_MON_COD    VARCHAR2(1 BYTE)                   NULL,
  REB_CIV_COD    VARCHAR2(2 BYTE)                   NULL,
  REB_DAT        DATE                               NULL,
  REB_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  REB_DATCRE     DATE                               NULL,
  REB_EJE_COD    VARCHAR2(4 BYTE)                   NULL,
  REB_NOM        VARCHAR2(50 BYTE)                  NULL,
  REB_NIF        VARCHAR2(12 BYTE)                  NULL,
  REB_BAN        NUMBER(4)                          NULL,
  REB_OFI        NUMBER(4)                          NULL,
  REB_DCC        VARCHAR2(2 BYTE)                   NULL,
  REB_CCC        NUMBER(10)                         NULL,
  REB_ASI        NUMBER(10)                         NULL,
  REB_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  REB_DATMOD     DATE                               NULL,
  REB_RST_COD    VARCHAR2(2 BYTE)                   NULL,
  REB_RETBASTOT  VARCHAR2(1 BYTE)                   NULL,
  REB_RET        NUMBER(5,2)                        NULL,
  REB_IBNPAI     VARCHAR2(2 BYTE)                   NULL,
  REB_IBNDCC     VARCHAR2(2 BYTE)                   NULL,
  REB_IBNBIC     VARCHAR2(11 BYTE)                  NULL
)
;


CREATE TABLE TCMP_TMP_ASI
(
  AST_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  AST_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  AST_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  AST_EJE_COD  VARCHAR2(4 BYTE)                     NULL,
  AST_NUMASI   NUMBER(10)                           NULL,
  AST_TAS_COD  VARCHAR2(2 BYTE)                     NULL,
  AST_DAT      DATE                                 NULL,
  AST_OBS      VARCHAR2(150 BYTE)                   NULL
)
;


CREATE TABLE TCMP_VCP
(
  VCP_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  VCP_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  VCP_DIA_COD    VARCHAR2(2 BYTE)                   NULL,
  VCP_VEN_SEQ    NUMBER(10)                         NULL,
  VCP_SEQ        NUMBER(10)                         NULL,
  VCP_DATCOBPAG  DATE                               NULL,
  VCP_IMP        NUMBER(15,3)                   DEFAULT 0                         NULL,
  VCP_VALIMP     NUMBER(15,3)                   DEFAULT 0                         NULL,
  VCP_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  VCP_DATCRE     DATE                               NULL,
  VCP_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  VCP_DATMOD     DATE                               NULL,
  VCP_CONTAPU    NUMBER(10)                         NULL
)
;


CREATE INDEX ICMP_ADJ_RSC_FK_I ON TCMP_ADJ
(ADJ_CEC_COD, ADJ_EMP_COD, ADJ_DIA_COD, ADJ_RSC_SEQ)
;


CREATE INDEX ICMP_AMO_CT5_TE_FK ON TCMP_AMORTIZACIONS
(AMO_CEC_COD, AMO_EMP_COD, AMO_CT5_CODHAB)
;


CREATE INDEX ICMP_AMO_CT5_TE_UNA_FK ON TCMP_AMORTIZACIONS
(AMO_CEC_COD, AMO_EMP_COD, AMO_CT5_CODDEB)
;


CREATE INDEX ICMP_AMO_UBI_FK ON TCMP_AMORTIZACIONS
(AMO_CEC_COD, AMO_UBI_COD)
;


CREATE INDEX ICMP_ARR_OPH_FK_I ON TCMP_347ARRE
(ARR_CEC_COD, ARR_EMP_COD, ARR_CLASSE, ARR_CLIPRO)
;


CREATE INDEX ICMP_AST_DEX_FK ON TCMP_TMP_ASI
(AST_CEC_COD, AST_EMP_COD, AST_EJE_COD, AST_DIA_COD)
;


CREATE INDEX ICMP_AST_TAS_FK ON TCMP_TMP_ASI
(AST_TAS_COD, AST_CEC_COD)
;


CREATE INDEX ICMP_CRV_RSC_FK_I ON TCMP_CRV
(CRV_CEC_COD, CRV_EMP_COD, CRV_DIA_COD, CRV_RSC_SEQ)
;


CREATE INDEX ICMP_DAM_CT5DEB_FK ON TCMP_DAM
(DAM_CT5_CODDEB, DAM_EMP_COD, DAM_CEC_COD)
;


CREATE INDEX ICMP_DAM_CT5HAB_FK ON TCMP_DAM
(DAM_CT5_CODHAB, DAM_EMP_COD, DAM_CEC_COD)
;


CREATE INDEX ICMP_DEX_DIA_FK_I ON TCMP_DIARIEXERCICI
(DEX_CEC_COD, DEX_EMP_COD, DEX_DIA_COD)
;


CREATE INDEX ICMP_DEX_EJE_FK_I ON TCMP_DIARIEXERCICI
(DEX_CEC_COD, DEX_EMP_COD, DEX_EJE_COD)
;


CREATE INDEX ICMP_DVE_DEP_FK_I ON TCMP_DEPPROVEN
(DVE_CEC_COD, DVE_EMP_COD, DVE_DEP_COD)
;


CREATE INDEX ICMP_DVE_PRO_FK_I ON TCMP_DEPPROVEN
(DVE_CEC_COD, DVE_PRO_COD)
;


CREATE INDEX ICMP_DVE_VEN_FK_I ON TCMP_DEPPROVEN
(DVE_CEC_COD, DVE_EMP_COD, DVE_DIA_COD, DVE_VEN_NUMVEN)
;


CREATE INDEX ICMP_ELE_AMO_FK_I ON TCMP_ELE
(ELE_CEC_COD, ELE_EMP_COD, ELE_CT5_COD, ELE_AMO_COD)
;


CREATE INDEX ICMP_INT_BAN_FK_I ON TCMP_INTERESOS
(INT_CEC_COD, INT_EMP_COD, INT_CT5_COD)
;


CREATE INDEX ICMP_LST_IVA_FK_I ON TCMP_LST
(LST_CEC_COD, LST_IVA_COD)
;


CREATE INDEX ICMP_LST_RST_FK_I ON TCMP_LST
(LST_CEC_COD, LST_EMP_COD, LST_CT5_COD, LST_RST_COD)
;


CREATE INDEX ICMP_PDE_DEP_FK_I ON TCMP_PRESUDESGLOSES
(PDE_CEC_COD, PDE_EMP_COD, PDE_DEP_COD)
;


CREATE INDEX ICMP_PDE_DIA_FK_I ON TCMP_PRESUDESGLOSES
(PDE_CEC_COD, PDE_EMP_COD, PDE_DIA_COD)
;


CREATE INDEX ICMP_PDE_PRE_FK_I ON TCMP_PRESUDESGLOSES
(PDE_CEC_COD, PDE_EMP_COD, PDE_CT5_COD, PDE_PRE_ANY, PDE_PRE_MES)
;


CREATE INDEX ICMP_PDE_PRO_FK_I ON TCMP_PRESUDESGLOSES
(PDE_CEC_COD, PDE_PRO_COD)
;


CREATE INDEX ICMP_REB_CIV_FK_I ON TCMP_REB
(REB_CEC_COD, REB_CIV_COD)
;


CREATE INDEX ICMP_REB_CT5_FK_I ON TCMP_REB
(REB_CEC_COD, REB_EMP_COD, REB_CT5_COD)
;


CREATE INDEX ICMP_REB_DIA_FK_I ON TCMP_REB
(REB_CEC_COD, REB_EMP_COD, REB_DIA_COD)
;


CREATE INDEX ICMP_REB_EJE_FK_I ON TCMP_REB
(REB_CEC_COD, REB_EMP_COD, REB_EJE_COD)
;


CREATE INDEX ICMP_REB_MON_FK_I ON TCMP_REB
(REB_CEC_COD, REB_MON_COD)
;


CREATE INDEX ICMP_REB_SER_FK_I ON TCMP_REB
(REB_CEC_COD, REB_EMP_COD, REB_SER_COD)
;


CREATE INDEX ICMP_VCP_VEN_FK_I ON TCMP_VCP
(VCP_CEC_COD, VCP_EMP_COD, VCP_DIA_COD, VCP_VEN_SEQ)
;


CREATE UNIQUE INDEX RCMP_ADJ_PK ON TCMP_ADJ
(ADJ_CEC_COD, ADJ_EMP_COD, ADJ_DIA_COD, ADJ_SEQ)
;


CREATE UNIQUE INDEX RCMP_ADP_PK ON TCMP_ADP
(ADP_CEC_COD, ADP_EMP_COD, ADP_DIA_COD, ADP_ADJ_SEQ, ADP_SEQ)
;


CREATE UNIQUE INDEX RCMP_AMO_PK ON TCMP_AMORTIZACIONS
(AMO_CEC_COD, AMO_EMP_COD, AMO_CT5_COD, AMO_COD)
;


CREATE UNIQUE INDEX RCMP_ARR_PK ON TCMP_347ARRE
(ARR_CEC_COD, ARR_EMP_COD, ARR_CLASSE, ARR_CLIPRO, ARR_OPH_SEQ, 
ARR_COD)
;


CREATE UNIQUE INDEX RCMP_BAN_PK ON TCMP_BANCS
(BAN_CEC_COD, BAN_EMP_COD, BAN_CT5_COD)
;


CREATE UNIQUE INDEX RCMP_CRV_PK ON TCMP_CRV
(CRV_CEC_COD, CRV_EMP_COD, CRV_DIA_COD, CRV_RSC_SEQ, CRV_SEQ)
;


CREATE UNIQUE INDEX RCMP_CTB_PK ON TCMP_CTABAN
(CTB_CEC_COD, CTB_EMP_COD, CTB_CT5_COD, CTB_BAN, CTB_OFI, 
CTB_CCR)
;


CREATE UNIQUE INDEX RCMP_DAM_PK ON TCMP_DAM
(DAM_CEC_COD, DAM_EMP_COD, DAM_CT5_COD, DAM_AMO_COD, DAM_ANYMES, 
DAM_ANY, DAM_MES)
;


CREATE UNIQUE INDEX RCMP_DEX_PK ON TCMP_DIARIEXERCICI
(DEX_CEC_COD, DEX_EMP_COD, DEX_EJE_COD, DEX_DIA_COD)
;


CREATE UNIQUE INDEX RCMP_DIS_PK ON TCMP_DIS
(DIS_CEC_COD, DIS_EMP_COD, DIS_LEA_COD, DIS_DIA)
;


CREATE UNIQUE INDEX RCMP_DVE_PK ON TCMP_DEPPROVEN
(DVE_CEC_COD, DVE_EMP_COD, DVE_DIA_COD, DVE_VEN_NUMVEN, DVE_SEQ)
;


CREATE UNIQUE INDEX RCMP_ECE_PK ON TCMP_ECE
(ECE_AGE_COD, ECE_CEC_COD, ECE_EMP_COD, ECE_CTA)
;


CREATE UNIQUE INDEX RCMP_ELE_PK ON TCMP_ELE
(ELE_CEC_COD, ELE_EMP_COD, ELE_LEA_COD, ELE_SEQ)
;


CREATE UNIQUE INDEX RCMP_ELE_UK ON TCMP_ELE
(ELE_CEC_COD, ELE_EMP_COD, ELE_LEA_COD, ELE_CT5_COD, ELE_AMO_COD)
;


CREATE UNIQUE INDEX RCMP_EMA_PK ON TCMP_EMA
(EMA_CEC_COD, EMA_ACV_COD, EMA_ICV_COD, EMA_CAV_SEQ, EMA_SEQ)
;


CREATE UNIQUE INDEX RCMP_INT_PK ON TCMP_INTERESOS
(INT_CT5_COD, INT_CEC_COD, INT_EMP_COD, INT_SEQ)
;


CREATE UNIQUE INDEX RCMP_LST_PK ON TCMP_LST
(LST_CEC_COD, LST_EMP_COD, LST_CT5_COD, LST_RST_COD, LST_NUM)
;


CREATE UNIQUE INDEX RCMP_MLL_PK ON TCMP_MILLORES
(MLL_CEC_COD, MLL_EMP_COD, MLL_AMO_CT5_COD, MLL_AMO_COD, MLL_SEQ)
;


CREATE UNIQUE INDEX RCMP_PDE_PK ON TCMP_PRESUDESGLOSES
(PDE_CEC_COD, PDE_EMP_COD, PDE_CT5_COD, PDE_PRE_ANY, PDE_PRE_MES, 
PDE_SEQ)
;


CREATE UNIQUE INDEX RCMP_REB_PK ON TCMP_REB
(REB_CEC_COD, REB_EMP_COD, REB_DIA_COD, REB_SER_COD, REB_NUM)
;


CREATE UNIQUE INDEX RCMP_TMP_ASI_PK ON TCMP_TMP_ASI
(AST_CEC_COD, AST_EMP_COD, AST_EJE_COD, AST_DIA_COD, AST_NUMASI)
;


CREATE UNIQUE INDEX RCMP_VCP_PK ON TCMP_VCP
(VCP_CEC_COD, VCP_EMP_COD, VCP_DIA_COD, VCP_VEN_SEQ, VCP_SEQ)
;


CREATE OR REPLACE FORCE VIEW VCMP_ADJ
AS 
select t.adj_CEC_COD, t.adj_EMP_COD, t.adj_DIA_COD, t.adj_SEQ, t.adj_ANY, t.adj_MON_COD, t.adj_tan, t.adj_CT5_CODPRO,
t.adj_DATadj, t.adj_NIFPRO, t.adj_NOMPRO, t.adj_rsc_SEQ,
v.adj_CT5_CODDSP, t.adj_IVA_COD, v.adj_DEP_COD, v.adj_PRO_COD,
t.adj_RESPOL, t.adj_DES, t.adj_num, t.adj_OBS, t.adj_CTR, (t.adj_bas * v.adj_ptedeppro/100) as adj_bas,
(t.adj_iva * v.adj_ptedeppro/100) as adj_iva,
 v.adj_tot, v.adj_ptedeppro
from (
select adj_CEC_COD, adj_EMP_COD, adj_DIA_COD, adj_SEQ,
adj_CT5_CODDSP, adj_DEP_COD, adj_PRO_COD, 100 as adj_ptedeppro, (adj_bas + adj_iva) as adj_tot
from tcmp_adj
where (adj_CEC_COD, adj_EMP_COD, adj_DIA_COD, adj_SEQ) not in
(select adp_CEC_COD, adp_EMP_COD, adp_DIA_COD, adp_adj_SEQ
   from tcmp_adp
  where adp_cec_cod = adj_cec_cod
    and adp_emp_cod = adj_emp_cod
    and adp_dia_cod = adj_dia_cod
    and adp_adj_seq = adj_seq)
union all
select adp_CEC_COD, adp_EMP_COD, adp_DIA_COD, adp_adj_SEQ,
adp_CT5_COD, adp_DEP_COD, adp_PRO_COD, adp_pte as adj_ptedeppro, adp_IMP as adj_tot
from tcmp_adp
) v, tcmp_adj t
where v.adj_cec_cod=t.adj_cec_cod and v.adj_emp_cod=t.adj_emp_cod and v.adj_dia_cod=t.adj_dia_cod
and v.adj_seq=t.adj_seq;


CREATE OR REPLACE FORCE VIEW VCMP_CTABAN
AS 
select ban_cec_cod, ban_emp_cod, ban_ct5_cod, ban_ban, ban_ofi, ban_ccr
   from tcmp_bancs
  where ban_ccr is not null
UNION /*no vull duplicats*/
 select ctb_cec_cod, ctb_emp_cod, ctb_ct5_cod, ctb_ban, ctb_ofi, ctb_ccr
   from tcmp_ctaban;


CREATE TABLE TCMP_ACUMULATS
(
  ACU_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  ACU_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  ACU_EJE_COD    VARCHAR2(4 BYTE)                   NULL,
  ACU_DIA_COD    VARCHAR2(2 BYTE)                   NULL,
  ACU_CT5_COD    VARCHAR2(10 BYTE)                  NULL,
  ACU_ANY        NUMBER(4)                          NULL,
  ACU_UNIDEBINI  NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_UNIHABINI  NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_UNISALN_1  NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEBINI     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HABINI     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_SALN_1     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB001     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB001     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB002     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB002     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB003     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB003     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB004     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB004     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB005     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB005     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB006     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB006     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB007     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB007     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB008     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB008     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB009     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB009     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB010     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB010     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB011     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB011     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEB012     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HAB012     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_DEBTAN     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_HABTAN     NUMBER(15,3)                   DEFAULT 0                         NULL,
  ACU_CANMONINI  NUMBER(10,4)                       NULL,
  ACU_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  ACU_DATCRE     DATE                               NULL,
  ACU_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  ACU_DATMOD     DATE                               NULL
)
;


CREATE TABLE TCMP_ASIENTOS
(
  ASI_CEC_COD           VARCHAR2(4 BYTE)            NULL,
  ASI_EMP_COD           VARCHAR2(4 BYTE)            NULL,
  ASI_EJE_COD           VARCHAR2(4 BYTE)            NULL,
  ASI_DIA_COD           VARCHAR2(2 BYTE)            NULL,
  ASI_NUMASI            NUMBER(10)                  NULL,
  ASI_TAS_COD           VARCHAR2(2 BYTE)            NULL,
  ASI_DAT               DATE                        NULL,
  ASI_USUCRE            VARCHAR2(30 BYTE)           NULL,
  ASI_DATCRE            DATE                        NULL,
  ASI_MODIFICABLE       VARCHAR2(1 BYTE)            NULL,
  ASI_OBS               VARCHAR2(4000 BYTE)         NULL,
  ASI_DATAVI            DATE                        NULL,
  ASI_MARAVI            VARCHAR2(1 BYTE)            NULL,
  ASI_USUMOD            VARCHAR2(30 BYTE)           NULL,
  ASI_DATMOD            DATE                        NULL,
  ASI_NUMASI001         NUMBER(10)                  NULL,
  ASI_PRD               VARCHAR2(1 BYTE)            NULL,
  ASI_EJE_CODPRDORI     VARCHAR2(4 BYTE)            NULL,
  ASI_DIA_CODPRDORI     VARCHAR2(2 BYTE)            NULL,
  ASI_ASI_NUMASIPRDORI  NUMBER(10)                  NULL,
  ASI_DATPRS            DATE                        NULL,
  ASI_DATCNF            DATE                        NULL
)
;


CREATE TABLE TCMP_DAMMLL
(
  DAM_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  DAM_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DAM_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  DAM_AMO_COD  VARCHAR2(25 BYTE)                    NULL,
  DAM_MLL_SEQ  NUMBER(3)                            NULL,
  DAM_ANYMES   VARCHAR2(1 BYTE)                     NULL,
  DAM_ANY      NUMBER(4)                            NULL,
  DAM_MES      NUMBER(2)                            NULL,
  DAM_IMPFIS   NUMBER(15,2)                         NULL,
  DAM_IMPCMP   NUMBER(15,2)                         NULL,
  DAM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DAM_DATCRE   DATE                                 NULL
)
;


CREATE TABLE TCMP_FPV
(
  FPV_CEC_COD       VARCHAR2(4 BYTE)                NULL,
  FPV_EMP_COD       VARCHAR2(4 BYTE)                NULL,
  FPV_DIA_COD       VARCHAR2(2 BYTE)                NULL,
  FPV_SEQ           NUMBER(10)                      NULL,
  FPV_ANY           NUMBER(4)                       NULL,
  FPV_MON_COD       VARCHAR2(1 BYTE)                NULL,
  FPV_CNF           VARCHAR2(1 BYTE)                NULL,
  FPV_CT5_CODPRO    VARCHAR2(10 BYTE)               NULL,
  FPV_DAT           DATE                            NULL,
  FPV_DATRGT        DATE                            NULL,
  FPV_BAS           NUMBER(15,2)                DEFAULT 0                         NULL,
  FPV_IVA           NUMBER(15,2)                DEFAULT 0                         NULL,
  FPV_NIFPRO        VARCHAR2(12 BYTE)               NULL,
  FPV_NUM           VARCHAR2(60 BYTE)               NULL,
  FPV_NOMPRO        VARCHAR2(40 BYTE)               NULL,
  FPV_DATCRE        DATE                            NULL,
  FPV_USUCRE        VARCHAR2(30 BYTE)               NULL,
  FPV_ADJ_SEQ       NUMBER(6)                       NULL,
  FPV_EJE_COD       VARCHAR2(4 BYTE)                NULL,
  FPV_ASI_NUMASI    NUMBER(10)                      NULL,
  FPV_CT5_CODDSP    VARCHAR2(10 BYTE)               NULL,
  FPV_IVA_COD       VARCHAR2(4 BYTE)                NULL,
  FPV_NUMRGT        VARCHAR2(10 BYTE)               NULL,
  FPV_DEP_COD       VARCHAR2(4 BYTE)                NULL,
  FPV_PRO_COD       VARCHAR2(4 BYTE)                NULL,
  FPV_DATCNF        DATE                            NULL,
  FPV_RESTEC        VARCHAR2(30 BYTE)               NULL,
  FPV_RESPOL        VARCHAR2(30 BYTE)               NULL,
  FPV_DATMOD        DATE                            NULL,
  FPV_USUMOD        VARCHAR2(30 BYTE)               NULL,
  FPV_DES           VARCHAR2(1000 BYTE)             NULL,
  FPV_OBS           VARCHAR2(1000 BYTE)             NULL,
  FPV_CTR           VARCHAR2(1 BYTE)                NULL,
  FPV_PTERET        NUMBER(5,2)                     NULL,
  FPV_RET           NUMBER(15,2)                    NULL,
  FPV_ICLINFPLAPAG  VARCHAR2(1 BYTE)                NULL,
  FPV_TIPPLA        VARCHAR2(1 BYTE)                NULL,
  FPV_EXD_COD       VARCHAR2(4 BYTE)                NULL,
  FPV_TOC_COD       VARCHAR2(4 BYTE)                NULL,
  FPV_CNFTEC        VARCHAR2(1 BYTE)                NULL,
  FPV_DATCNFTEC     DATE                            NULL,
  FPV_ESTFIR        VARCHAR2(2 BYTE)                NULL,
  FPV_FIRCNL        VARCHAR2(1 BYTE)                NULL,
  FPV_FIRCNLTEC     VARCHAR2(1 BYTE)                NULL,
  FPV_FIRCNLPOL     VARCHAR2(1 BYTE)                NULL,
  FPV_DATCNLFIRTEC  DATE                            NULL,
  FPV_DATCNLFIRPOL  DATE                            NULL,
  FPV_OBSCNCTEC     VARCHAR2(1000 BYTE)             NULL,
  FPV_OBSCNCPOL     VARCHAR2(1000 BYTE)             NULL
)
;


CREATE TABLE TCMP_LRE
(
  LRE_REB_NUM    NUMBER(10)                         NULL,
  LRE_CEC_COD    VARCHAR2(4 BYTE)                   NULL,
  LRE_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  LRE_DIA_COD    VARCHAR2(2 BYTE)                   NULL,
  LRE_SER_COD    VARCHAR2(3 BYTE)                   NULL,
  LRE_NUM        NUMBER(10)                         NULL,
  LRE_IVA_COD    VARCHAR2(4 BYTE)                   NULL,
  LRE_ORD        NUMBER(5)                          NULL,
  LRE_IMP        NUMBER(15,3)                       NULL,
  LRE_ACUBASIMP  VARCHAR2(1 BYTE)                   NULL,
  LRE_RET        VARCHAR2(1 BYTE)                   NULL,
  LRE_VALIMP     NUMBER(15,3)                       NULL,
  LRE_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  LRE_DATCRE     DATE                               NULL,
  LRE_DES        VARCHAR2(50 BYTE)                  NULL,
  LRE_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  LRE_DATMOD     DATE                               NULL
)
;


CREATE TABLE TCMP_QUO
(
  QUO_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  QUO_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  QUO_LEA_COD        VARCHAR2(15 BYTE)              NULL,
  QUO_NUM            NUMBER(3)                      NULL,
  QUO_DIA            DATE                           NULL,
  QUO_IRS            NUMBER(15,2)                   NULL,
  QUO_CPI            NUMBER(15,2)                   NULL,
  QUO_IVA            NUMBER(15,2)                   NULL,
  QUO_QUO            NUMBER(15,2)                   NULL,
  QUO_PTEIRS         NUMBER(8,6)                    NULL,
  QUO_USUCRE         VARCHAR2(30 BYTE)              NULL,
  QUO_DATCRE         DATE                           NULL,
  QUO_RNTCPIPEN      NUMBER(15,2)                   NULL,
  QUO_VEN_SEQ        NUMBER(10)                     NULL,
  QUO_DIA_COD        VARCHAR2(2 BYTE)               NULL,
  QUO_USUMOD         VARCHAR2(30 BYTE)              NULL,
  QUO_DATMOD         DATE                           NULL,
  QUO_FAC            VARCHAR2(8 BYTE)               NULL,
  QUO_CMI            NUMBER(15,2)                   NULL,
  QUO_EJE_CODFIN     VARCHAR2(4 BYTE)               NULL,
  QUO_DIA_CODFIN     VARCHAR2(2 BYTE)               NULL,
  QUO_ASI_NUMASIFIN  NUMBER(10)                     NULL,
  QUO_CMIIVA         NUMBER(15,2)                   NULL,
  QUO_DIAORI         DATE                           NULL
)
;


CREATE TABLE TCMP_RFP
(
  RFP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  RFP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  RFP_SEQ      NUMBER(10)                           NULL,
  RFP_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  RFP_FPV_SEQ  NUMBER(10)                           NULL,
  RFP_USU      VARCHAR2(30 BYTE)                    NULL,
  RFP_ROL      VARCHAR2(3 BYTE)                     NULL,
  RFP_RES      VARCHAR2(100 BYTE)                   NULL,
  RFP_CNF      VARCHAR2(1 BYTE)                     NULL,
  RFP_DATCNF   DATE                                 NULL,
  RFP_FIRCNL   VARCHAR2(1 BYTE)                     NULL,
  RFP_DATCNL   DATE                                 NULL,
  RFP_OBSCNL   VARCHAR2(4000 BYTE)                  NULL,
  RFP_USUDTI   VARCHAR2(30 BYTE)                    NULL,
  RFP_DATDTI   DATE                                 NULL,
  RFP_OBSCNV   VARCHAR2(1000 BYTE)                  NULL,
  RFP_DATCRE   DATE                                 NULL,
  RFP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  RFP_DATMOD   DATE                                 NULL,
  RFP_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_SII
(
  SII_CEC_COD              VARCHAR2(4 BYTE)         NULL,
  SII_EMP_COD              VARCHAR2(4 BYTE)         NULL,
  SII_SEQ                  NUMBER(10)               NULL,
  SII_TIPLLB               VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODTIPCMU        VARCHAR2(2 BYTE)         NULL,
  SII_MON_COD              VARCHAR2(2 BYTE)         NULL,
  SII_EJE_COD              VARCHAR2(4 BYTE)         NULL,
  SII_DIA_COD              VARCHAR2(2 BYTE)         NULL,
  SII_ASI_NUMASI           NUMBER(10)               NULL,
  SII_EJE                  VARCHAR2(4 BYTE)         NULL,
  SII_PRD                  VARCHAR2(2 BYTE)         NULL,
  SII_NUM                  VARCHAR2(60 BYTE)        NULL,
  SII_NUM002               VARCHAR2(60 BYTE)        NULL,
  SII_DAT                  DATE                     NULL,
  SII_SIT_CODFAC           VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODRCT           VARCHAR2(2 BYTE)         NULL,
  SII_BASRCT               NUMBER(14,2)             NULL,
  SII_QUORCT               NUMBER(14,2)             NULL,
  SII_REQRCT               NUMBER(14,2)             NULL,
  SII_DATOPE               DATE                     NULL,
  SII_SIT_CODCLA           VARCHAR2(2 BYTE)         NULL,
  SII_IMPTOT               NUMBER(14,2)             NULL,
  SII_DESOPE               VARCHAR2(500 BYTE)       NULL,
  SII_SIT_CODIMM           VARCHAR2(2 BYTE)         NULL,
  SII_REFIMM               VARCHAR2(25 BYTE)        NULL,
  SII_IMPTRFIVA            NUMBER(14,2)             NULL,
  SII_EMIALT               VARCHAR2(1 BYTE)         NULL,
  SII_VARDTI               VARCHAR2(1 BYTE)         NULL,
  SII_CUP                  VARCHAR2(1 BYTE)         NULL,
  SII_NOMCPA               VARCHAR2(120 BYTE)       NULL,
  SII_NIFRPR               VARCHAR2(9 BYTE)         NULL,
  SII_NIFCPA               VARCHAR2(9 BYTE)         NULL,
  SII_SIT_CODPAICPA        VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODTIPIDFPAI     VARCHAR2(2 BYTE)         NULL,
  SII_IDFCPA               VARCHAR2(20 BYTE)        NULL,
  SII_IDFBIN               VARCHAR2(40 BYTE)        NULL,
  SII_BINFECINI            DATE                     NULL,
  SII_BINFECFIN            NUMBER(4,2)              NULL,
  SII_BINRGLANY            NUMBER(14,2)             NULL,
  SII_BINIDFENT            VARCHAR2(40 BYTE)        NULL,
  SII_BINRGLEFE            NUMBER(14,2)             NULL,
  SII_SIT_CODICOTIPOPE     VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODICOCLA        VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODICOPAI        VARCHAR2(2 BYTE)         NULL,
  SII_ICOPLAOPE            NUMBER(3)                NULL,
  SII_ICODESBIN            VARCHAR2(40 BYTE)        NULL,
  SII_ICODIROPE            VARCHAR2(120 BYTE)       NULL,
  SII_ICOFACDOC            VARCHAR2(150 BYTE)       NULL,
  SII_DATCOBPAG            DATE                     NULL,
  SII_SIT_CODTIPCOB        VARCHAR2(2 BYTE)         NULL,
  SII_IBN                  VARCHAR2(34 BYTE)        NULL,
  SII_NUMFACCOB            VARCHAR2(60 BYTE)        NULL,
  SII_NUMFACGRPCOB         VARCHAR2(60 BYTE)        NULL,
  SII_EST                  VARCHAR2(1 BYTE)         NULL,
  SII_DATENV               DATE                     NULL,
  SII_DATREGCMP            DATE                     NULL,
  SII_QUO                  NUMBER(14,2)             NULL,
  SII_TXTENV               VARCHAR2(1000 BYTE)      NULL,
  SII_TIP                  VARCHAR2(1 BYTE)         NULL,
  SII_SUJNOTEXEFAC         VARCHAR2(1 BYTE)         NULL,
  SII_SUJEXEFAC            VARCHAR2(1 BYTE)         NULL,
  SII_NOTSUJFAC            VARCHAR2(1 BYTE)         NULL,
  SII_SUJNOTEXEOPESRV      VARCHAR2(1 BYTE)         NULL,
  SII_SUJEXEOPESRV         VARCHAR2(1 BYTE)         NULL,
  SII_NOTSUJOPESRV         VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODEXEFAC        VARCHAR2(2 BYTE)         NULL,
  SII_BIMEXEFAC            NUMBER(14,2)             NULL,
  SII_SIT_CODEXEOPESRV     VARCHAR2(2 BYTE)         NULL,
  SII_BIMEXEOPESRV         NUMBER(14,2)             NULL,
  SII_IMPSUJFAC001         NUMBER(14,2)             NULL,
  SII_IMPSUJFAC002         NUMBER(14,2)             NULL,
  SII_IMPSUJOPESRV001      NUMBER(14,2)             NULL,
  SII_IMPSUJOPESRV002      NUMBER(14,2)             NULL,
  SII_PRSSRV               VARCHAR2(1 BYTE)         NULL,
  SII_ENTBIN               VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODDSGTIPFAC     VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODDSGTIPOPESRV  VARCHAR2(2 BYTE)         NULL,
  SII_DATCRE               DATE                 DEFAULT NULL                      NULL,
  SII_USUCRE               VARCHAR2(30 BYTE)    DEFAULT NULL                      NULL,
  SII_DATMOD               DATE                     NULL,
  SII_USUMOD               VARCHAR2(30 BYTE)        NULL,
  SII_SIT_CODCLA001        VARCHAR2(2 BYTE)         NULL,
  SII_SIT_CODCLA002        VARCHAR2(2 BYTE)         NULL,
  SII_NUMREG               VARCHAR2(15 BYTE)        NULL,
  SII_DATASI               DATE                     NULL,
  SII_DATREB               DATE                     NULL,
  SII_SUJNOTEXEOPEBIN      VARCHAR2(1 BYTE)         NULL,
  SII_SIT_CODDSGTIPOPEBIN  VARCHAR2(2 BYTE)         NULL,
  SII_SUJEXEOPEBIN         VARCHAR2(1 BYTE)         NULL,
  SII_BIMEXEOPEBIN         NUMBER(14,2)             NULL,
  SII_SIT_CODEXEOPEBIN     VARCHAR2(2 BYTE)         NULL,
  SII_NOTSUJOPEBIN         VARCHAR2(1 BYTE)         NULL,
  SII_IMPSUJOPEBIN001      NUMBER(14,2)             NULL,
  SII_IMPSUJOPEBIN002      NUMBER(14,2)             NULL,
  SII_SIT_CODIMM002        VARCHAR2(2 BYTE)         NULL,
  SII_REFIMM002            VARCHAR2(25 BYTE)        NULL,
  SII_SIT_CODIMM003        VARCHAR2(2 BYTE)         NULL,
  SII_REFIMM003            VARCHAR2(25 BYTE)        NULL,
  SII_FACSIM               VARCHAR2(1 BYTE)         NULL,
  SII_FACNOTIDF            VARCHAR2(1 BYTE)         NULL,
  SII_ETTNIF               VARCHAR2(9 BYTE)         NULL,
  SII_ETTNOM               VARCHAR2(120 BYTE)       NULL,
  SII_FACALT               VARCHAR2(1 BYTE)         NULL,
  SII_REFEXT               VARCHAR2(60 BYTE)        NULL,
  SII_NOTPLA               VARCHAR2(1 BYTE)         NULL,
  SII_IMPSUP               VARCHAR2(1 BYTE)         NULL,
  SII_FACALTORGMTL         VARCHAR2(1 BYTE)         NULL
)
;


CREATE TABLE TCMP_TMP_APU
(
  APT_AST_NUMASI  NUMBER(10)                        NULL,
  APT_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  APT_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  APT_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  APT_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  APT_MON_COD     VARCHAR2(1 BYTE)                  NULL,
  APT_CT5_COD     VARCHAR2(10 BYTE)                 NULL,
  APT_NUMAPU      NUMBER(10)                        NULL,
  APT_IMPDEB      NUMBER(15,3)                      NULL,
  APT_IMPHAB      NUMBER(15,3)                      NULL,
  APT_BASIVA      NUMBER(15,3)                      NULL,
  APT_VALIMPDEB   NUMBER(15,3)                      NULL,
  APT_VALIMPHAB   NUMBER(15,3)                      NULL,
  APT_VALBASIVA   NUMBER(15,3)                      NULL,
  APT_IVA_COD     VARCHAR2(4 BYTE)                  NULL,
  APT_IVA_CODINT  VARCHAR2(4 BYTE)                  NULL,
  APT_CIV_COD     VARCHAR2(2 BYTE)                  NULL,
  APT_CIV_CODINT  VARCHAR2(2 BYTE)                  NULL,
  APT_CNC         VARCHAR2(255 BYTE)                NULL,
  APT_CPA         VARCHAR2(10 BYTE)                 NULL,
  APT_NUMDOC      VARCHAR2(8 BYTE)                  NULL,
  APT_DATFAC      DATE                              NULL,
  APT_NUMFAC      VARCHAR2(8 BYTE)                  NULL,
  APT_DATVAL      DATE                              NULL,
  APT_APP_ORD     NUMBER(10)                        NULL
)
;


CREATE TABLE TCMP_VEP
(
  VEP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  VEP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  VEP_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  VEP_FPV_SEQ  NUMBER(10)                           NULL,
  VEP_SEQ      NUMBER(10)                           NULL,
  VEP_DAT      DATE                                 NULL,
  VEP_IMP      NUMBER(15,2)                         NULL,
  VEP_DATCRE   DATE                                 NULL,
  VEP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VEP_DATMOD   DATE                                 NULL,
  VEP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  VEP_VEN_SEQ  NUMBER(10)                           NULL
)
;


CREATE INDEX ICMP_ACU_CT5_FK_I ON TCMP_ACUMULATS
(ACU_CEC_COD, ACU_EMP_COD, ACU_CT5_COD)
;


CREATE INDEX ICMP_ACU_DEX_FK_I ON TCMP_ACUMULATS
(ACU_CEC_COD, ACU_EMP_COD, ACU_EJE_COD, ACU_DIA_COD)
;


CREATE INDEX ICMP_APT_AST_FK ON TCMP_TMP_APU
(APT_CEC_COD, APT_DIA_COD, APT_EMP_COD, APT_EJE_COD, APT_AST_NUMASI)
;


CREATE INDEX ICMP_APT_CIVCODINT_FK ON TCMP_TMP_APU
(APT_CIV_CODINT, APT_CEC_COD)
;


CREATE INDEX ICMP_APT_CIV_FK ON TCMP_TMP_APU
(APT_CIV_COD, APT_CEC_COD)
;


CREATE INDEX ICMP_APT_CT5_FK ON TCMP_TMP_APU
(APT_CT5_COD, APT_EMP_COD, APT_CEC_COD)
;


CREATE INDEX ICMP_APT_IVACODINT_FK ON TCMP_TMP_APU
(APT_IVA_CODINT, APT_CEC_COD)
;


CREATE INDEX ICMP_APT_IVA_FK ON TCMP_TMP_APU
(APT_IVA_COD, APT_CEC_COD)
;


CREATE INDEX ICMP_APT_MON_FK ON TCMP_TMP_APU
(APT_MON_COD, APT_CEC_COD)
;


CREATE INDEX ICMP_ASI_DEX_FK_I ON TCMP_ASIENTOS
(ASI_CEC_COD, ASI_EMP_COD, ASI_EJE_COD, ASI_DIA_COD)
;


CREATE INDEX ICMP_ASI_TAS_FK_I ON TCMP_ASIENTOS
(ASI_CEC_COD, ASI_TAS_COD)
;


CREATE INDEX ICMP_FPV_ADJ_FK_I ON TCMP_FPV
(FPV_CEC_COD, FPV_EMP_COD, FPV_DIA_COD, FPV_ADJ_SEQ)
;


CREATE INDEX ICMP_LRE_IVA_FK_I ON TCMP_LRE
(LRE_CEC_COD, LRE_IVA_COD)
;


CREATE INDEX ICMP_LRE_REB_FK_I ON TCMP_LRE
(LRE_CEC_COD, LRE_EMP_COD, LRE_DIA_COD, LRE_SER_COD, LRE_REB_NUM)
;


CREATE INDEX ICMP_QUO_VEN_FK_I ON TCMP_QUO
(QUO_CEC_COD, QUO_EMP_COD, QUO_DIA_COD, QUO_VEN_SEQ)
;


CREATE INDEX ICMP_RFP_EMP_FK_I ON TCMP_RFP
(RFP_CEC_COD, RFP_EMP_COD)
;


CREATE INDEX ICMP_RFP_FPV_FK_I ON TCMP_RFP
(RFP_CEC_COD, RFP_EMP_COD, RFP_DIA_COD, RFP_FPV_SEQ)
;


CREATE UNIQUE INDEX RCMP_ACU_PK ON TCMP_ACUMULATS
(ACU_CEC_COD, ACU_EMP_COD, ACU_CT5_COD, ACU_EJE_COD, ACU_DIA_COD, 
ACU_ANY)
;


CREATE UNIQUE INDEX RCMP_ASI_PK ON TCMP_ASIENTOS
(ASI_CEC_COD, ASI_EMP_COD, ASI_EJE_COD, ASI_DIA_COD, ASI_NUMASI)
;


CREATE UNIQUE INDEX RCMP_DAML_PK ON TCMP_DAMMLL
(DAM_CEC_COD, DAM_EMP_COD, DAM_CT5_COD, DAM_AMO_COD, DAM_MLL_SEQ, 
DAM_ANYMES, DAM_ANY, DAM_MES)
;


CREATE UNIQUE INDEX RCMP_FPV_PK ON TCMP_FPV
(FPV_CEC_COD, FPV_EMP_COD, FPV_DIA_COD, FPV_SEQ)
;


CREATE UNIQUE INDEX RCMP_LRE_PK ON TCMP_LRE
(LRE_REB_NUM, LRE_CEC_COD, LRE_EMP_COD, LRE_DIA_COD, LRE_SER_COD, 
LRE_NUM)
;


CREATE UNIQUE INDEX RCMP_QUO_PK ON TCMP_QUO
(QUO_CEC_COD, QUO_EMP_COD, QUO_LEA_COD, QUO_NUM)
;


CREATE UNIQUE INDEX RCMP_RFP_PK ON TCMP_RFP
(RFP_CEC_COD, RFP_EMP_COD, RFP_SEQ)
;


CREATE UNIQUE INDEX RCMP_SII_PK ON TCMP_SII
(SII_CEC_COD, SII_EMP_COD, SII_SEQ)
;


CREATE UNIQUE INDEX RCMP_TMP_APU_PK ON TCMP_TMP_APU
(APT_CEC_COD, APT_EMP_COD, APT_EJE_COD, APT_DIA_COD, APT_AST_NUMASI, 
APT_NUMAPU)
;


CREATE UNIQUE INDEX RCMP_VEP_PK ON TCMP_VEP
(VEP_CEC_COD, VEP_EMP_COD, VEP_DIA_COD, VEP_FPV_SEQ, VEP_SEQ)
;


CREATE OR REPLACE FORCE VIEW VCMP_SALDOS
AS 
select cec_cod, emp_cod, eje_cod, codi, dia_cod, tan_saldo_da - tan_saldo_ha + si as saldo_tan from (
select cec_cod, emp_cod, eje_cod, dia_cod,
codi,
sum(di)-sum(hi) si,
--decode('S'/*:p_tan*/,'S',(sum(dm)+sum(dt)),sum(dm)) dm,
--decode('S'/*:p_tan*/,'S',(sum(hm)+sum(ht)),sum(hm)) hm,
sum(da)+sum(dt) tan_saldo_da,
sum(da) saldo_da,
sum(ha)+sum(ht) tan_saldo_ha,
sum(ha) saldo_ha
--decode('S'/*:p_tan*/,'S',(sum(da)+sum(dt)+sum(di)),(sum(da)+sum(di))) dai,
--decode('S'/*:p_tan*/,'S',(sum(ha)+sum(ht)+sum(hi)),(sum(ha)+sum(hi))) hai
from
(
SELECT acu_cec_cod as cec_cod, acu_emp_cod as emp_cod, acu_eje_cod as eje_cod,
acu_dia_cod as dia_cod,
substr(acu_ct5_cod,1,3/*:cta*/) codi,
sum(ACU_DEBINI) di,
sum(ACU_HABINI) hi,
sum(ACU_DEBTAN) dt,
sum(ACU_HABTAN) ht,
decode(to_number(to_char(eje_datfin,'MM')),
1,sum(ACU_DEB001),
2,sum(ACU_DEB002),
3,sum(ACU_DEB003),
4,sum(ACU_DEB004),
5,sum(ACU_DEB005),
6,sum(ACU_DEB006),
7,sum(ACU_DEB007),
8,sum(ACU_DEB008),
9,sum(ACU_DEB009),
10,sum(ACU_DEB010),
11,sum(ACU_DEB011),
12,sum(ACU_DEB012)) dm,
decode(to_number(to_char(eje_datfin,'MM')),
1,sum(ACU_HAB001),
2,sum(ACU_HAB002),
3,sum(ACU_HAB003),
4,sum(ACU_HAB004),
5,sum(ACU_HAB005),
6,sum(ACU_HAB006),
7,sum(ACU_HAB007),
8,sum(ACU_HAB008),
9,sum(ACU_HAB009),
10,sum(ACU_HAB010),
11,sum(ACU_HAB011),
12,sum(ACU_HAB012)) hm,
SUM(decode(to_number(to_char(eje_datfin,'MM')),GREATEST(1,to_number(to_char(eje_datfin,'MM'))),ACU_DEB001, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(2,to_number(to_char(eje_datfin,'MM'))),ACU_DEB002, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(3,to_number(to_char(eje_datfin,'MM'))),ACU_DEB003, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(4,to_number(to_char(eje_datfin,'MM'))),ACU_DEB004, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(5,to_number(to_char(eje_datfin,'MM'))),ACU_DEB005, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(6,to_number(to_char(eje_datfin,'MM'))),ACU_DEB006, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(7,to_number(to_char(eje_datfin,'MM'))),ACU_DEB007, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(8,to_number(to_char(eje_datfin,'MM'))),ACU_DEB008, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(9,to_number(to_char(eje_datfin,'MM'))),ACU_DEB009, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(10,to_number(to_char(eje_datfin,'MM'))),ACU_DEB010, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(11,to_number(to_char(eje_datfin,'MM'))),ACU_DEB011, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(12,to_number(to_char(eje_datfin,'MM'))),ACU_DEB012, 0)) da,
SUM(decode(to_number(to_char(eje_datfin,'MM')),GREATEST(1,to_number(to_char(eje_datfin,'MM'))),ACU_HAB001, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(2,to_number(to_char(eje_datfin,'MM'))),ACU_HAB002, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(3,to_number(to_char(eje_datfin,'MM'))),ACU_HAB003, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(4,to_number(to_char(eje_datfin,'MM'))),ACU_HAB004, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(5,to_number(to_char(eje_datfin,'MM'))),ACU_HAB005, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(6,to_number(to_char(eje_datfin,'MM'))),ACU_HAB006, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(7,to_number(to_char(eje_datfin,'MM'))),ACU_HAB007, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(8,to_number(to_char(eje_datfin,'MM'))),ACU_HAB008, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(9,to_number(to_char(eje_datfin,'MM'))),ACU_HAB009, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(10,to_number(to_char(eje_datfin,'MM'))),ACU_HAB010, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(11,to_number(to_char(eje_datfin,'MM'))),ACU_HAB011, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),GREATEST(12,to_number(to_char(eje_datfin,'MM'))),ACU_HAB012, 0)) ha
FROM TCMP_ACUMULATS, tcmp_exercicis
where acu_cec_cod=eje_cec_cod and acu_emp_cod=eje_emp_cod and acu_eje_cod=eje_cod
 /*acu_cec_cod ='7400'
   and acu_emp_cod = '0001'
   and acu_eje_cod = '2001'*/
--   and acu_dia_cod in '||rtrim(ltrim(:ll_diaris,''''),'''')||'
   and acu_any = to_number(to_char(eje_datfin,'YYYY'))
group by acu_cec_cod, acu_emp_cod, acu_eje_cod, acu_dia_cod, substr(acu_ct5_cod,1,3/*:cta*/), eje_Datfin --to_number(to_char(eje_datfin,'YYYY'))
union all
SELECT acu_cec_cod, acu_emp_cod, acu_eje_cod, acu_dia_cod,
substr(acu_ct5_cod,1,3/*:cta*/) codi,
sum(ACU_DEBINI) di,
sum(ACU_HABINI) hi,
sum(ACU_DEBTAN) dt,
sum(ACU_HABTAN) ht,
0 dm,
0 hm,
SUM(decode(to_number(to_char(eje_datfin,'MM')),least(1,to_number(to_char(eje_datfin,'MM'))),ACU_DEB001, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(2,to_number(to_char(eje_datfin,'MM'))),ACU_DEB002, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(3,to_number(to_char(eje_datfin,'MM'))),ACU_DEB003, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(4,to_number(to_char(eje_datfin,'MM'))),ACU_DEB004, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(5,to_number(to_char(eje_datfin,'MM'))),ACU_DEB005, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(6,to_number(to_char(eje_datfin,'MM'))),ACU_DEB006, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(7,to_number(to_char(eje_datfin,'MM'))),ACU_DEB007, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(8,to_number(to_char(eje_datfin,'MM'))),ACU_DEB008, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(9,to_number(to_char(eje_datfin,'MM'))),ACU_DEB009, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(10,to_number(to_char(eje_datfin,'MM'))),ACU_DEB010, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(11,to_number(to_char(eje_datfin,'MM'))),ACU_DEB011, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(12,to_number(to_char(eje_datfin,'MM'))),ACU_DEB012, 0)) da,
SUM(decode(to_number(to_char(eje_datfin,'MM')),least(1,to_number(to_char(eje_datfin,'MM'))),ACU_HAB001, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(2,to_number(to_char(eje_datfin,'MM'))),ACU_HAB002, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(3,to_number(to_char(eje_datfin,'MM'))),ACU_HAB003, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(4,to_number(to_char(eje_datfin,'MM'))),ACU_HAB004, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(5,to_number(to_char(eje_datfin,'MM'))),ACU_HAB005, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(6,to_number(to_char(eje_datfin,'MM'))),ACU_HAB006, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(7,to_number(to_char(eje_datfin,'MM'))),ACU_HAB007, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(8,to_number(to_char(eje_datfin,'MM'))),ACU_HAB008, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(9,to_number(to_char(eje_datfin,'MM'))),ACU_HAB009, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(10,to_number(to_char(eje_datfin,'MM'))),ACU_HAB010, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(11,to_number(to_char(eje_datfin,'MM'))),ACU_HAB011, 0) +
            decode(to_number(to_char(eje_datfin,'MM')),least(12,to_number(to_char(eje_datfin,'MM'))),ACU_HAB012, 0)) ha
from tcmp_acumulats, tcmp_exercicis
where acu_cec_cod=eje_cec_cod and acu_emp_cod=eje_emp_cod and acu_eje_cod=eje_cod
/*acu_cec_cod ='7400'
   and acu_emp_cod = '0001'
   and acu_eje_cod = '2001'*/
--   and acu_dia_cod in '||rtrim(ltrim(:ll_diaris,''''),'''')||'
   and acu_any < to_number(to_char(eje_datfin,'YYYY'))
group by acu_cec_cod, acu_emp_cod, acu_eje_cod, acu_dia_cod, substr(acu_ct5_cod,1,3/*:cta*/), eje_Datfin --to_number(to_char(eje_datfin,'YYYY'))
)
--where codi between '6' and '7'
group by cec_cod, emp_cod, eje_cod, dia_cod, codi
)
 WITH READ ONLY;


CREATE TABLE TCMP_APUNTS
(
  APU_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  APU_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  APU_EJE_COD        VARCHAR2(4 BYTE)               NULL,
  APU_DIA_COD        VARCHAR2(2 BYTE)               NULL,
  APU_ASI_NUMASI     NUMBER(10)                     NULL,
  APU_NUMAPU         NUMBER(10)                     NULL,
  APU_CT5_COD        VARCHAR2(10 BYTE)              NULL,
  APU_MON_COD        VARCHAR2(1 BYTE)               NULL,
  APU_IMPDEB         NUMBER(15,3)               DEFAULT 0                         NULL,
  APU_IMPHAB         NUMBER(15,3)               DEFAULT 0                         NULL,
  APU_CON            VARCHAR2(255 BYTE)             NULL,
  APU_IVA_COD        VARCHAR2(4 BYTE)               NULL,
  APU_IVA_CODINT     VARCHAR2(4 BYTE)               NULL,
  APU_CIV_COD        VARCHAR2(2 BYTE)               NULL,
  APU_CIV_CODINT     VARCHAR2(2 BYTE)               NULL,
  APU_CONTRA         VARCHAR2(10 BYTE)              NULL,
  APU_NUMDOC         VARCHAR2(8 BYTE)               NULL,
  APU_DATFAC         DATE                           NULL,
  APU_NUMFAC         VARCHAR2(60 BYTE)              NULL,
  APU_BASIVA         NUMBER(15,3)               DEFAULT 0                         NULL,
  APU_PUNTEO         VARCHAR2(1 BYTE)               NULL,
  APU_MARCAERR       DATE                           NULL,
  APU_VALIMPDEB      NUMBER(15,3)               DEFAULT 0                         NULL,
  APU_VALIMPHAB      NUMBER(15,3)               DEFAULT 0                         NULL,
  APU_VALBASIVA      NUMBER(15,3)               DEFAULT 0                         NULL,
  APU_ACU_ANY        NUMBER(4)                      NULL,
  APU_USUCRE         VARCHAR2(30 BYTE)              NULL,
  APU_DATCRE         DATE                           NULL,
  APU_USUMOD         VARCHAR2(30 BYTE)              NULL,
  APU_DATMOD         DATE                           NULL,
  APU_DATVLR         DATE                           NULL,
  APU_ASI_DAT        DATE                           NULL,
  APU_NUMDOCFRT      VARCHAR2(8 BYTE)               NULL,
  APU_NIFCPA         VARCHAR2(12 BYTE)              NULL,
  APU_NOMCPA         VARCHAR2(40 BYTE)              NULL,
  APU_DATOPE         DATE                           NULL,
  APU_EJE_COD002     VARCHAR2(4 BYTE)               NULL,
  APU_ASI_NUMASI002  NUMBER(10)                     NULL
)
;


CREATE TABLE TCMP_APUNT_COBPAG
(
  ACP_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  ACP_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  ACP_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  ACP_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  ACP_ASI_NUMASI  NUMBER(10)                        NULL,
  ACP_APU_NUMAPU  NUMBER(10)                        NULL,
  ACP_VEN_SEQ     NUMBER(10)                        NULL,
  ACP_VCP_SEQ     NUMBER(10)                        NULL,
  ACP_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  ACP_DATCRE      DATE                              NULL,
  ACP_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  ACP_DATMOD      DATE                              NULL
)
;


CREATE TABLE TCMP_APUNT_VENCIMENT
(
  AVE_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  AVE_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  AVE_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  AVE_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  AVE_ASI_NUMASI  NUMBER(10)                        NULL,
  AVE_APU_NUMAPU  NUMBER(10)                        NULL,
  AVE_VEN_SEQ     NUMBER(10)                        NULL,
  AVE_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  AVE_DATCRE      DATE                              NULL,
  AVE_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  AVE_DATMOD      DATE                              NULL
)
;


CREATE TABLE TCMP_DEPPROCOM
(
  DCO_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  DCO_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  DCO_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  DCO_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  DCO_ASI_NUMASI  NUMBER(10)                        NULL,
  DCO_APU_NUMAPU  NUMBER(10)                        NULL,
  DCO_SEQ         NUMBER(10)                        NULL,
  DCO_PTEDEP      NUMBER(5,2)                   DEFAULT 0                         NULL,
  DCO_IMPDEP      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DCO_PTEPRO      NUMBER(5,2)                   DEFAULT 0                         NULL,
  DCO_IMPPRO      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DCO_VALDEP      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DCO_VALPRO      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DCO_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  DCO_DATCRE      DATE                              NULL,
  DCO_PRO_COD     VARCHAR2(4 BYTE)                  NULL,
  DCO_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  DCO_DATMOD      DATE                              NULL,
  DCO_DEP_COD     VARCHAR2(4 BYTE)                  NULL,
  DCO_ORI         VARCHAR2(1 BYTE)                  NULL,
  DCO_EXD_COD     VARCHAR2(4 BYTE)                  NULL,
  DCO_PTEEXD      NUMBER(5,2)                       NULL,
  DCO_IMPEXD      NUMBER(15,3)                      NULL,
  DCO_VALEXD      NUMBER(15,3)                      NULL,
  DCO_DEL_COD     VARCHAR2(4 BYTE)                  NULL,
  DCO_PTEDEL      NUMBER(5,2)                       NULL,
  DCO_IMPDEL      NUMBER(15,3)                      NULL,
  DCO_VALDEL      NUMBER(15,3)                      NULL,
  DCO_OBS         VARCHAR2(4000 BYTE)               NULL
)
;


CREATE TABLE TCMP_DESGLOSEAPUNT
(
  DAP_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  DAP_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  DAP_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  DAP_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  DAP_ASI_NUMASI  NUMBER(10)                        NULL,
  DAP_APU_NUMAPU  NUMBER(10)                        NULL,
  DAP_SEQ         NUMBER(10)                        NULL,
  DAP_CON         VARCHAR2(255 BYTE)                NULL,
  DAP_IMP         NUMBER(15,3)                  DEFAULT 0                         NULL,
  DAP_DOC         VARCHAR2(8 BYTE)                  NULL,
  DAP_VALIMP      NUMBER(15,3)                  DEFAULT 0                         NULL,
  DAP_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  DAP_DATCRE      DATE                              NULL,
  DAP_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  DAP_DATMOD      DATE                              NULL
)
;


CREATE TABLE TCMP_DSA
(
  DSA_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  DSA_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  DSA_EJE_COD        VARCHAR2(4 BYTE)               NULL,
  DSA_DIA_COD        VARCHAR2(2 BYTE)               NULL,
  DSA_ASI_NUMASI     NUMBER(10)                     NULL,
  DSA_APU_NUMAPU     NUMBER(10)                     NULL,
  DSA_CEC_CODDTI     VARCHAR2(4 BYTE)               NULL,
  DSA_EMP_CODDTI     VARCHAR2(4 BYTE)               NULL,
  DSA_EJE_CODDTI     VARCHAR2(4 BYTE)               NULL,
  DSA_DIA_CODDTI     VARCHAR2(2 BYTE)               NULL,
  DSA_ASI_NUMASIDTI  NUMBER(10)                     NULL,
  DSA_DATCRE         DATE                           NULL,
  DSA_USUCRE         VARCHAR2(30 BYTE)              NULL
)
;


CREATE TABLE TCMP_EFA
(
  EFA_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  EFA_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  EFA_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  EFA_FPV_SEQ  NUMBER(10)                           NULL,
  EFA_SEQ      NUMBER(3)                            NULL,
  EFA_EST_COD  VARCHAR2(4 BYTE)                     NULL,
  EFA_DAT      DATE                                 NULL,
  EFA_DATCRE   DATE                                 NULL,
  EFA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EFA_DATMOD   DATE                                 NULL,
  EFA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  EFA_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TCMP_FDP
(
  FDP_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  FDP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  FDP_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  FDP_FPV_SEQ  NUMBER(10)                           NULL,
  FDP_SEQ      NUMBER(10)                           NULL,
  FDP_CT5_COD  VARCHAR2(10 BYTE)                    NULL,
  FDP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FDP_DATCRE   DATE                                 NULL,
  FDP_PRO_COD  VARCHAR2(4 BYTE)                     NULL,
  FDP_DEP_COD  VARCHAR2(4 BYTE)                     NULL,
  FDP_PTE      NUMBER(5,2)                          NULL,
  FDP_IMP      NUMBER(15,2)                         NULL,
  FDP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  FDP_DATMOD   DATE                                 NULL,
  FDP_BAS      NUMBER(15,2)                         NULL,
  FDP_EXD_COD  VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TCMP_FIV
(
  FIV_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  FIV_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  FIV_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  FIV_FPV_SEQ  NUMBER(10)                           NULL,
  FIV_IVA_COD  VARCHAR2(4 BYTE)                     NULL,
  FIV_BAS      NUMBER(15,2)                         NULL,
  FIV_IVA      NUMBER(15,2)                         NULL,
  FIV_DATCRE   DATE                                 NULL,
  FIV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FIV_DATMOD   DATE                                 NULL,
  FIV_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TCMP_N43APU
(
  A43_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  A43_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  A43_CAB_SEQ     NUMBER(10)                        NULL,
  A43_MOV_SEQ     NUMBER(10)                        NULL,
  A43_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  A43_DIA_COD     VARCHAR2(4 BYTE)                  NULL,
  A43_ASI_NUMASI  NUMBER(10)                        NULL,
  A43_APU_NUMAPU  NUMBER(10)                        NULL,
  A43_DATCRE      DATE                              NULL,
  A43_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  A43_NUM         NUMBER(10)                        NULL
)
;


CREATE TABLE TCMP_SID
(
  SID_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  SID_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  SID_SII_SEQ     NUMBER(10)                        NULL,
  SID_SEQ         NUMBER(10)                        NULL,
  SID_IVATIPIMS   NUMBER(5,2)                       NULL,
  SID_IVABIM      NUMBER(14,2)                      NULL,
  SID_IVAQUO      NUMBER(14,2)                      NULL,
  SID_IVATIPREQ   NUMBER(5,2)                       NULL,
  SID_IVAQUOREQ   NUMBER(14,2)                      NULL,
  SID_PTECMS      NUMBER(5,2)                       NULL,
  SID_IMPCMS      NUMBER(14,2)                      NULL,
  SID_TIP         VARCHAR2(1 BYTE)                  NULL,
  SID_DATCRE      DATE                          DEFAULT NULL                      NULL,
  SID_USUCRE      VARCHAR2(30 BYTE)             DEFAULT NULL                      NULL,
  SID_DATMOD      DATE                              NULL,
  SID_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  SID_BIMEXE      NUMBER(14,2)                      NULL,
  SID_SIT_CODEXE  VARCHAR2(2 BYTE)                  NULL,
  SID_SIT_CODIMM  VARCHAR2(2 BYTE)                  NULL,
  SID_REFIMM      VARCHAR2(25 BYTE)                 NULL
)
;


CREATE TABLE TCMP_SIE
(
  SIE_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  SIE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  SIE_ESI_SEQ  NUMBER(10)                           NULL,
  SIE_SII_SEQ  NUMBER(10)                           NULL,
  SIE_DATCRE   DATE                             DEFAULT NULL                      NULL,
  SIE_USUCRE   VARCHAR2(30 BYTE)                DEFAULT NULL                      NULL
)
;


CREATE TABLE TCMP_SIF
(
  SIF_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  SIF_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  SIF_SII_SEQ  NUMBER(10)                           NULL,
  SIF_TIP      VARCHAR2(1 BYTE)                     NULL,
  SIF_SEQ      NUMBER(2)                            NULL,
  SIF_DATFAC   DATE                                 NULL,
  SIF_NUMFAC   VARCHAR2(60 BYTE)                    NULL,
  SIF_DATCRE   DATE                             DEFAULT NULL                      NULL,
  SIF_USUCRE   VARCHAR2(30 BYTE)                DEFAULT NULL                      NULL,
  SIF_DATMOD   DATE                                 NULL,
  SIF_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE INDEX ICMP_A43_APU_FK ON TCMP_N43APU
(A43_CEC_COD, A43_EMP_COD, A43_EJE_COD, A43_DIA_COD, A43_ASI_NUMASI, 
A43_APU_NUMAPU)
;


CREATE INDEX ICMP_A43_NUM ON TCMP_N43APU
(A43_EJE_COD)
;


CREATE INDEX ICMP_APU_ACU_FK_I ON TCMP_APUNTS
(APU_CEC_COD, APU_EMP_COD, APU_CT5_COD, APU_EJE_COD, APU_DIA_COD, 
APU_ACU_ANY)
;


CREATE INDEX ICMP_APU_ASI_FK_I ON TCMP_APUNTS
(APU_CEC_COD, APU_EMP_COD, APU_EJE_COD, APU_DIA_COD, APU_ASI_NUMASI)
;


CREATE INDEX ICMP_APU_CIV_FK_I ON TCMP_APUNTS
(APU_CEC_COD, APU_CIV_COD)
;


CREATE INDEX ICMP_APU_CT5_FK_I ON TCMP_APUNTS
(APU_CEC_COD, APU_EMP_COD, APU_CT5_COD)
;


CREATE INDEX ICMP_APU_DAT ON TCMP_APUNTS
(APU_CEC_COD, APU_EMP_COD, APU_ASI_DAT)
;


CREATE INDEX ICMP_APU_DATCT5 ON TCMP_APUNTS
(APU_CEC_COD, APU_EMP_COD, APU_CT5_COD, APU_ASI_DAT)
;


CREATE INDEX ICMP_APU_IVA_FK_I ON TCMP_APUNTS
(APU_CEC_COD, APU_IVA_COD)
;


CREATE INDEX ICMP_APU_MON_FK_I ON TCMP_APUNTS
(APU_CEC_COD, APU_MON_COD)
;


CREATE INDEX ICMP_APU_VCP_I ON TCMP_APUNT_COBPAG
(ACP_CEC_COD, ACP_EMP_COD, ACP_DIA_COD, ACP_VEN_SEQ, ACP_VCP_SEQ)
;


CREATE INDEX ICMP_APU_VEN_I ON TCMP_APUNT_VENCIMENT
(AVE_CEC_COD, AVE_EMP_COD, AVE_DIA_COD, AVE_VEN_SEQ)
;


CREATE INDEX ICMP_DAP_APU_FK_I ON TCMP_DESGLOSEAPUNT
(DAP_CEC_COD, DAP_EMP_COD, DAP_EJE_COD, DAP_DIA_COD, DAP_ASI_NUMASI, 
DAP_APU_NUMAPU)
;


CREATE INDEX ICMP_DCO_APU_FK_I ON TCMP_DEPPROCOM
(DCO_CEC_COD, DCO_EMP_COD, DCO_EJE_COD, DCO_DIA_COD, DCO_ASI_NUMASI, 
DCO_APU_NUMAPU)
;


CREATE INDEX ICMP_DCO_DEP_FK_I ON TCMP_DEPPROCOM
(DCO_CEC_COD, DCO_EMP_COD, DCO_DEP_COD)
;


CREATE INDEX ICMP_DCO_PRO_FK_I ON TCMP_DEPPROCOM
(DCO_CEC_COD, DCO_PRO_COD)
;


CREATE INDEX ICMP_VCP_APU_I ON TCMP_APUNT_COBPAG
(ACP_CEC_COD, ACP_EMP_COD, ACP_EJE_COD, ACP_DIA_COD, ACP_ASI_NUMASI, 
ACP_APU_NUMAPU)
;


CREATE INDEX ICMP_VEN_APU_I ON TCMP_APUNT_VENCIMENT
(AVE_CEC_COD, AVE_EMP_COD, AVE_EJE_COD, AVE_DIA_COD, AVE_ASI_NUMASI, 
AVE_APU_NUMAPU)
;


CREATE UNIQUE INDEX RCMP_A43_UK ON TCMP_N43APU
(A43_CEC_COD, A43_EMP_COD, A43_CAB_SEQ, A43_MOV_SEQ, A43_EJE_COD, 
A43_DIA_COD, A43_ASI_NUMASI, A43_APU_NUMAPU)
;


CREATE UNIQUE INDEX RCMP_ACP_PK ON TCMP_APUNT_COBPAG
(ACP_CEC_COD, ACP_EMP_COD, ACP_EJE_COD, ACP_DIA_COD, ACP_ASI_NUMASI, 
ACP_APU_NUMAPU, ACP_VEN_SEQ, ACP_VCP_SEQ)
;


CREATE UNIQUE INDEX RCMP_APU_PK ON TCMP_APUNTS
(APU_CEC_COD, APU_EMP_COD, APU_EJE_COD, APU_DIA_COD, APU_ASI_NUMASI, 
APU_NUMAPU)
;


CREATE UNIQUE INDEX RCMP_AVE_PK ON TCMP_APUNT_VENCIMENT
(AVE_CEC_COD, AVE_EMP_COD, AVE_EJE_COD, AVE_DIA_COD, AVE_ASI_NUMASI, 
AVE_APU_NUMAPU, AVE_VEN_SEQ)
;


CREATE UNIQUE INDEX RCMP_DAP_PK ON TCMP_DESGLOSEAPUNT
(DAP_CEC_COD, DAP_EMP_COD, DAP_EJE_COD, DAP_DIA_COD, DAP_ASI_NUMASI, 
DAP_APU_NUMAPU, DAP_SEQ)
;


CREATE UNIQUE INDEX RCMP_DCO_PK ON TCMP_DEPPROCOM
(DCO_CEC_COD, DCO_EMP_COD, DCO_EJE_COD, DCO_DIA_COD, DCO_ASI_NUMASI, 
DCO_APU_NUMAPU, DCO_SEQ)
;


CREATE UNIQUE INDEX RCMP_EFA_PK ON TCMP_EFA
(EFA_CEC_COD, EFA_EMP_COD, EFA_DIA_COD, EFA_FPV_SEQ, EFA_SEQ)
;


CREATE UNIQUE INDEX RCMP_FDP_PK ON TCMP_FDP
(FDP_CEC_COD, FDP_EMP_COD, FDP_DIA_COD, FDP_FPV_SEQ, FDP_SEQ)
;


CREATE UNIQUE INDEX RCMP_FIV_PK ON TCMP_FIV
(FIV_CEC_COD, FIV_DIA_COD, FIV_EMP_COD, FIV_FPV_SEQ, FIV_IVA_COD)
;


CREATE UNIQUE INDEX RCMP_SID_PK ON TCMP_SID
(SID_CEC_COD, SID_EMP_COD, SID_SII_SEQ, SID_SEQ)
;


CREATE UNIQUE INDEX RCMP_SIF_PK ON TCMP_SIF
(SIF_CEC_COD, SIF_EMP_COD, SIF_SII_SEQ, SIF_TIP, SIF_SEQ)
;


CREATE OR REPLACE FORCE VIEW VCMP_CT5APUIVA
AS 
select apu_cec_cod, apu_emp_cod, apu_eje_cod, apu_dia_cod, apu_asi_dat, apu_ct5_cod,
       apu_mon_cod, eje_mon_cod, apu_impdeb, apu_imphab, apu_valimpdeb, apu_valimphab
     , (select max(apu_iva_codint) from tcmp_apunts where apu_cec_cod=a.apu_cec_cod and apu_emp_cod=a.apu_emp_cod and apu_eje_cod=a.apu_eje_cod and apu_dia_cod=a.apu_dia_cod and apu_asi_numasi=a.apu_asi_numasi and apu_civ_codint is not null) as iva
     , (select max(apu_civ_codint) from tcmp_apunts where apu_cec_cod=a.apu_cec_cod and apu_emp_cod=a.apu_emp_cod and apu_eje_cod=a.apu_eje_cod and apu_dia_cod=a.apu_dia_cod and apu_asi_numasi=a.apu_asi_numasi and apu_civ_codint is not null) as civ
from tcmp_apunts a, tcmp_exercicis
where eje_cec_cod=apu_cec_cod and eje_emp_cod=apu_emp_cod and eje_cod=apu_eje_cod;


CREATE OR REPLACE FORCE VIEW VCMP_FPV
AS 
SELECT   t.fpv_CEC_COD,
            t.fpv_EMP_COD,
            t.fpv_DIA_COD,
            t.fpv_SEQ,
            t.fpv_ANY,
            t.fpv_MON_COD,
            t.fpv_CNF,
            t.fpv_CT5_CODPRO,
            t.fpv_DAT,
            t.fpv_DATRGT,
            t.fpv_NIFPRO,
            t.fpv_NUM,
            t.fpv_NOMPRO,
            t.fpv_ADJ_SEQ,
            t.fpv_EJE_COD,
            t.fpv_ASI_NUMASI,
            v.fpv_CT5_CODDSP,
            t.fpv_IVA_COD,
            t.fpv_NUMRGT,
            v.fpv_DEP_COD,
            v.fpv_PRO_COD,
            v.fpv_exd_cod,
            t.fpv_DATCNF,
            t.fpv_RESTEC,
            t.fpv_RESPOL,
            t.fpv_DES,
            t.fpv_OBS,
            t.fpv_CTR,
            t.fpv_PTERET,
            v.fpv_bas                    /*(t.fpv_bas * v.fpv_ptedeppro/100)*/
                     AS fpv_bas,
            (t.fpv_ret * v.fpv_ptedeppro / 100) AS fpv_ret,
            (t.fpv_iva * v.fpv_ptedeppro / 100) AS fpv_iva,
            v.fpv_tot
     FROM   (SELECT   FPV_CEC_COD,
                      FPV_EMP_COD,
                      FPV_DIA_COD,
                      FPV_SEQ,
                      FPV_CT5_CODDSP,
                      FPV_DEP_COD,
                      FPV_PRO_COD, fpv_exd_cod,
                      100 AS fpv_ptedeppro,
                      (fpv_bas + fpv_iva - NVL (fpv_ret, 0)) AS fpv_tot,
                      fpv_bas
               FROM   tcmp_fpv
              WHERE   (FPV_CEC_COD, FPV_EMP_COD, FPV_DIA_COD, FPV_SEQ) NOT IN
                            (SELECT   FDP_CEC_COD,
                                      FDP_EMP_COD,
                                      FDP_DIA_COD,
                                      FDP_FPV_SEQ
                               FROM   tcmp_fdp
                              WHERE       fdp_cec_cod = fpv_cec_cod
                                      AND fdp_emp_cod = fpv_emp_cod
                                      AND fdp_dia_cod = fpv_dia_cod
                                      AND fdp_fpv_seq = fpv_seq)
             UNION ALL
             SELECT   FDP_CEC_COD,
                      FDP_EMP_COD,
                      FDP_DIA_COD,
                      FDP_FPV_SEQ,
                      FDP_CT5_COD,
                      FDP_DEP_COD,
                      FDP_PRO_COD, fdp_exd_cod,
                      fdp_pte AS fpv_ptedeppro,
                      FDP_IMP AS fpv_tot,
                      NVL (fdp_bas, ROUND (fpv_bas * fdp_pte / 100, 2))
                         AS fpv_bas
               FROM   tcmp_fdp, tcmp_fpv
              WHERE       fdp_cec_cod = fpv_cec_cod
                      AND fdp_emp_cod = fpv_emp_cod
                      AND fdp_dia_cod = fpv_dia_cod
                      AND fdp_fpv_seq = fpv_seq) v,
            tcmp_fpv t
    WHERE       v.fpv_cec_cod = t.fpv_cec_cod
            AND v.fpv_emp_cod = t.fpv_emp_cod
            AND v.fpv_dia_cod = t.fpv_dia_cod
            AND v.fpv_seq = t.fpv_seq;


CREATE OR REPLACE FORCE VIEW VCMP_LSTEMV
AS 
select /*+ INDEX(tcmp_comptes5 RCMP_CT5_PK) */
cec_cod, emp_cod, tipo,
ct5,
ct5_des,
dat, decode('N','S',asi001, numasi) Asiento, con,
debe, haber, contra, iva, civ, dia, ndoc,
des_contra, ct5_gru, ct5_gru002, ct5_gru003, ct5_gru004, ct1_cod, ct1_des, ct2_cod, ct2_des, ct3_cod, ct3_des,
ct4_cod, ct4_des,
to_char(dat, 'yyyy') Ano, decode(numasi,0,0,to_char(dat, 'MM')) Mes, (debe-haber) Saldo,
decode(NUMASI,0,0,1) IniMov, numasi  from (
SELECT 'M' tipo,APU_CEC_COD CEC_COD,APU_EMP_COD EMP_COD,APU_ASI_NUMASI NUMASI,ASI_NUMASI001 ASI001,
APU_ASI_DAT DAT,ASI_OBS OBS,APU_CT5_COD CT5,
APU_DIA_COD DIA,APU_CON CON,APU_IVA_COD IVA, APU_CIV_COD CIV, APU_CONTRA CONTRA,APU_NUMDOC NDOC,
decode('E', apu_mon_cod, apu_impdeb, eje_mon_cod, apu_valimpdeb, round(apu_valimpdeb*mon_valcan/166.386,2)) DEBE,
decode('E', apu_mon_cod, apu_imphab, eje_mon_cod, apu_valimphab, round(apu_valimphab*mon_valcan/166.386,2)) HABER,
CT5_DES DES_CONTRA
FROM TCMP_APUNTS, TCMP_ASIENTOS, tcmp_exercicis, tcmp_monedes, TCMP_COMPTES5
WHERE /*TCMP_APUNTS.APU_CEC_COD = :global.idf_cod AND APU_EMP_COD = decode(:global.emp_cod, '0001', '1001', :global.emp_cod)
AND*/ APU_ASI_DAT BETWEEN plim_contenidor.get_dat1 AND plim_contenidor.get_dat2 AND APU_CEC_COD=ASI_CEC_COD
AND APU_EMP_COD=ASI_EMP_COD
AND APU_EJE_COD=ASI_EJE_COD
AND APU_DIA_COD=ASI_DIA_COD
AND APU_ASI_NUMASI=ASI_NUMASI
AND EJE_CEC_COD=APU_CEC_COD
AND EJE_EMP_COD=APU_EMP_COD
AND EJE_COD=APU_EJE_COD
AND MON_CEC_COD=EJE_CEC_COD
AND MON_COD=EJE_MON_COD
AND CT5_CEC_COD(+)=APU_CEC_COD AND CT5_EMP_COD(+)=APU_EMP_COD AND CT5_COD(+)=APU_CONTRA
UNION all
select 'I' tipo,cec,emp, asi, 1 ASI001,
plim_contenidor.get_dat1,
obs,ct5,dia, 'Saldo Anterior' as con, iva,
civ,contra,ndoc,sum(debe),sum(haber),des_contra from (
SELECT acu_cec_cod cec,acu_emp_cod emp,0 asi,to_date('01/01/1900', 'dd/mm/yyyy') dat,'' obs,acu_ct5_cod ct5, ACU_DIA_COD dia,
'' con,'' iva,'' civ,'' contra,'' ndoc,
round(mon_valcan*sum(decode(ACU_EJE_COD,to_char(plim_contenidor.get_dat1,'yyyy'),ACU_DEBINI,0))/(499158/3000),2) debe,
round(mon_valcan*sum(decode(ACU_EJE_COD,to_char(plim_contenidor.get_dat1,'yyyy'),ACU_HABINI,0))/(499158/3000),2) haber,
'' des_contra
FROM TCMP_ACUMULATS, tcmp_exercicis, tcmp_monedes
WHERE /*ACU_CEC_COD=:global.idf_cod AND ACU_EMP_COD=decode(:global.emp_cod, '0001', '1001', :global.emp_cod)
AND*/ ACU_EJE_COD>=to_char(plim_contenidor.get_dat1,'yyyy')
AND EJE_CEC_COD=ACU_CEC_COD AND EJE_EMP_COD=ACU_EMP_COD AND EJE_COD=ACU_EJE_COD
AND MON_CEC_COD=EJE_CEC_COD AND MON_COD=EJE_MON_COD
GROUP BY acu_cec_cod,acu_emp_cod,acu_ct5_cod,ACU_DIA_COD, mon_valcan
union all
SELECT APU_CEC_COD cec,APU_EMP_COD emp,0 asi,
to_date('01/01/1900', 'dd/mm/yyyy') dat,'' obs,
apu_ct5_cod ct5,apu_dia_cod dia,'' con,'' iva,'' civ,'' contra,'' ndoc,
decode('E', apu_mon_cod, sum(apu_impdeb), eje_mon_cod, sum(apu_valimpdeb), round(sum(apu_valimpdeb*mon_valcan/166.386),2)) DEBE,
decode('E', apu_mon_cod, sum(apu_imphab), eje_mon_cod, sum(apu_valimphab), round(sum(apu_valimphab*mon_valcan/166.386),2)) HABER,
'' des_contra
FROM TCMP_APUNTS, TCMP_ASIENTOS, tcmp_exercicis, tcmp_monedes
WHERE /*APU_CEC_COD = :global.idf_cod AND APU_EMP_COD = decode(:global.emp_cod, '0001', '1001', :global.emp_cod)
AND*/ --APU_ASI_DAT BETWEEN plim_contenidor.get_dat1 AND plim_contenidor.get_dat2
 APU_ASI_DAT BETWEEN trunc(plim_contenidor.get_dat1, 'YYYY') AND (plim_contenidor.get_dat1-1)
AND APU_CEC_COD=ASI_CEC_COD AND APU_EMP_COD=ASI_EMP_COD AND APU_EJE_COD=ASI_EJE_COD
AND APU_DIA_COD=ASI_DIA_COD AND APU_ASI_NUMASI=ASI_NUMASI
AND EJE_CEC_COD=APU_CEC_COD AND EJE_EMP_COD=APU_EMP_COD AND EJE_COD=APU_EJE_COD
AND MON_CEC_COD=EJE_CEC_COD AND MON_COD=EJE_MON_COD
GROUP BY APU_CEC_COD,APU_EMP_COD,APU_CT5_COD, apu_dia_cod, mon_valcan, apu_mon_cod, eje_mon_cod)
group by cec,emp,asi,dat,obs,ct5,dia,con,iva,civ,contra, ndoc,des_contra
having SUM(debe)<>0 or SUM(haber)<>0 ),
tcmp_comptes5, tcmp_comptes4, tcmp_comptes3, tcmp_comptes2, tcmp_comptes1
where ct5_cec_cod = cec_cod and ct5_emp_cod = emp_cod and ct5_cod = ct5
and ct4_cec_cod=ct5_cec_cod and ct4_emp_cod=ct5_emp_cod and ct4_cod=ct5_ct4_cod
and ct3_cec_cod=ct4_cec_cod and ct3_emp_cod=ct4_emp_cod and ct3_cod=ct4_ct3_cod
and ct2_cec_cod=ct3_cec_cod and ct2_emp_cod=ct3_emp_cod and ct2_cod=ct3_ct2_cod
and ct1_cec_cod=ct2_cec_cod and ct1_emp_cod=ct2_emp_cod and ct1_cod=ct2_ct1_cod
--
--begin
--  plim_contenidor.put_dat1('01/06/2014');


CREATE OR REPLACE FORCE VIEW VCMP_N43_NOCONCILIAT
AS 
select apu_cec_cod, apu_emp_cod, apu_asi_dat, apu_con, apu_impdeb, apu_imphab, to_number(null) N43Debe, to_number(null) N43Haber, (apu_impdeb-apu_imphab) as pdt
 from tcmp_apunts
where /*apu_cec_cod=:global.cod_cliceco and apu_emp_cod= :global.empresa
  AND*/ apu_ct5_cod = plim_contenidor.get_var1 /* compte comptable */ 
  /*and apu_asi_dat between to_date(instance.data_inici, 'dd/mm/yyyy') and :f_final*/
  and (APU_CEC_COD, APU_EMP_COD, APU_EJE_COD, APU_DIA_COD, APU_ASI_NUMASI, APU_NUMAPU) not in
 (select A43_CEC_COD, A43_EMP_COD, A43_EJE_COD, A43_DIA_COD, A43_ASI_NUMASI, A43_APU_NUMAPU
    from tcmp_n43apu, tcmp_n43_pplmov b
   where A43_CEC_COD=apu_cec_cod and A43_EMP_COD=apu_emp_cod and A43_EJE_COD=apu_eje_cod
     and A43_DIA_COD=apu_dia_cod and A43_ASI_NUMASI=apu_asi_numasi and A43_APU_NUMAPU=apu_numapu
     and a43_cec_cod = b.mov_cec_cod and a43_emp_cod=b.mov_emp_cod and a43_cab_seq=b.mov_cab_seq and a43_mov_seq=b.mov_seq
     and b.mov_datope <= plim_contenidor.get_dat1
  )
-- no conciliat entre mateixos apunts
  and (APU_CEC_COD, APU_EMP_COD, APU_EJE_COD, APU_DIA_COD, APU_ASI_NUMASI, APU_NUMAPU) not in
 (select A43_CEC_COD, A43_EMP_COD, A43_EJE_COD, A43_DIA_COD, A43_ASI_NUMASI, A43_APU_NUMAPU
   from tcmp_n43apu
  where A43_CEC_COD=apu_cec_cod and A43_EMP_COD=apu_emp_cod and A43_EJE_COD=apu_eje_cod
    and A43_DIA_COD=apu_dia_cod and A43_ASI_NUMASI=apu_asi_numasi and A43_APU_NUMAPU=apu_numapu and A43_CAB_SEQ is null
    and (a43_cec_cod, a43_emp_cod, a43_num) in
   (select a43_cec_cod, a43_emp_cod, a43_num
      from tcmp_n43apu, tcmp_apunts b
     where A43_CAB_SEQ is null
       and b.apu_cec_cod=a43_cec_cod and b.apu_emp_cod=a43_emp_cod
       and b.apu_eje_cod=a43_eje_cod and b.apu_dia_cod=a43_dia_cod
       and b.apu_asi_numasi=a43_asi_numasi and b.apu_numapu=a43_apu_numapu
       and apu_asi_dat<=plim_contenidor.get_dat1
   )
 )
--
union all
--
--> n43 no conciliat o conciliat posteriorment a la data
select mov_cec_cod, mov_emp_cod, mov_datope, rtrim(ltrim(pcmp_n43.f_concepte (mov_cec_cod, mov_emp_cod, mov_cab_seq, mov_seq) || mov_ref001 || ' ' || mov_ref002)), to_number(null), to_number(null), mov_deb, mov_hab, (mov_hab-mov_deb) as pdt
  from vcmp_n43_pplmov a, tcmp_n43_cabcta, tcmp_n43apu n
 where /*mov_cec_cod= :global.cod_cliceco and mov_emp_cod= :global.empresa
   and*/ cab_cec_cod=mov_cec_cod and cab_emp_cod=mov_emp_cod and cab_seq=mov_cab_seq
   /*and mov_datope between to_date(instance.data_inici, 'dd/mm/yyyy') and :f_final*/
   and (CAB_BAN, CAB_OFI, CAB_CCR) in
 (select BAN_BAN, BAN_OFI, BAN_CCR
    from vCMP_CTABAN
   where ban_cec_cod=cab_cec_cod and ban_emp_cod=cab_emp_cod and ban_ban=cab_ban and ban_ofi=cab_ofi and ban_ccr=cab_ccr
     and BAN_CT5_COD= plim_contenidor.get_var1
 ) 
and  A43_CEC_COD(+) = MOV_CEC_COD
And    A43_EMP_COD(+) = MOV_EMP_COD
And    A43_CAB_SEQ(+) = MOV_CAB_SEQ
And    A43_MOV_SEQ(+) = MOV_SEQ
and (a43_num is null or a43_num is not null and (Select max(mov_datope)
From   TCMP_N43_PPLMOV, TCMP_N43APU b
Where  A43_CEC_COD = MOV_CEC_COD
And    A43_EMP_COD = MOV_EMP_COD
And    A43_CAB_SEQ = MOV_CAB_SEQ
And    A43_MOV_SEQ = MOV_SEQ
and b.a43_cec_cod=n.a43_cec_cod and b.a43_emp_cod=n.a43_emp_cod and b.a43_num = n.a43_num)>plim_contenidor.get_dat1)
/* ABANS  and (mov_CEC_COD, mov_EMP_COD, MOV_CAB_SEQ, MOV_SEQ) not in
 (select A43_CEC_COD, A43_EMP_COD, A43_CAB_SEQ, A43_MOV_SEQ
    from tcmp_n43apu, tcmp_n43_pplmov b
   where A43_CEC_COD=a.mov_cec_cod and A43_EMP_COD=a.mov_emp_cod and A43_cab_seq=a.mov_cab_seq
     and A43_mov_seq=a.mov_seq
     and a43_cec_cod = b.mov_cec_cod and a43_emp_cod=b.mov_emp_cod and a43_cab_seq=b.mov_cab_seq and a43_mov_seq=b.mov_seq
     and b.mov_datope <= :f_final
 )*/
order by 1;


CREATE OR REPLACE FORCE VIEW VCMP_SII_IMM
AS 
select sid_cec_cod, sid_emp_cod, sid_sii_seq, sid_seq, sid_sit_codimm, sid_refimm
from tcmp_sid
where sid_tip ='7'
union all
  -- immoble 1
select sii_cec_cod, sii_emp_cod, sii_seq, -3, sii_sit_codimm, sii_refimm
from tcmp_sii
where sii_sit_codimm is not null or sii_refimm is not null
union all
  -- immoble 2
select sii_cec_cod, sii_emp_cod, sii_seq, -2, sii_sit_codimm002, sii_refimm002
from tcmp_sii
where sii_sit_codimm002 is not null or sii_refimm002 is not null
union all
  -- immoble 3
select sii_cec_cod, sii_emp_cod, sii_seq, -1, sii_sit_codimm003, sii_refimm003
from tcmp_sii
where sii_sit_codimm003 is not null or sii_refimm003 is not null;


CREATE OR REPLACE FORCE VIEW VCMP_SII_SUJEXE
AS 
select sid_cec_cod, sid_emp_cod, sid_sii_seq, sid_seq, sid_tip, sid_bimexe, sid_sit_codexe
from tcmp_sid
where sid_tip in ('4', '5', '6')
union all
  -- factura - sujeta/exenta
select sii_cec_cod, sii_emp_cod, sii_seq, -1, '4', sii_bimexefac, sii_sit_codexefac
from tcmp_sii
where sii_bimexefac is not null or sii_sit_codexefac is not null
union all
  -- Tipo Operación - Prestación de servicios - sujeta/exenta
select sii_cec_cod, sii_emp_cod, sii_seq, -1, '5', sii_bimexeopesrv, sii_sit_codexeopesrv
from tcmp_sii
where sii_bimexeopesrv is not null or sii_sit_codexeopesrv is not null
union all
  -- Tipo Operación - Entrega de bienes - sujeta/exenta
select sii_cec_cod, sii_emp_cod, sii_seq, -1, '6', sii_bimexeopebin, sii_sit_codexeopebin
from tcmp_sii
where sii_bimexeopebin is not null or sii_sit_codexeopebin is not null;


CREATE TABLE TCMP_ACO
(
  ACO_CEC_COD     VARCHAR2(4 BYTE)                  NULL,
  ACO_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  ACO_EJE_COD     VARCHAR2(4 BYTE)                  NULL,
  ACO_DIA_COD     VARCHAR2(2 BYTE)                  NULL,
  ACO_ASI_NUMASI  NUMBER(10)                        NULL,
  ACO_APU_NUMAPU  NUMBER(10)                        NULL,
  ACO_SCO_COD     VARCHAR2(4 BYTE)                  NULL,
  ACO_NUM         NUMBER(10)                        NULL,
  ACO_TOT         VARCHAR2(1 BYTE)              DEFAULT 'N'                       NULL,
  ACO_DATCRE      DATE                              NULL,
  ACO_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  ACO_DATMOD      DATE                              NULL,
  ACO_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TCMP_APUFAC
(
  APF_CEC_COD        VARCHAR2(4 BYTE)               NULL,
  APF_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  APF_EJE_COD        VARCHAR2(4 BYTE)               NULL,
  APF_DIA_COD        VARCHAR2(4 BYTE)               NULL,
  APF_ASI_NUMASI     NUMBER(10)                     NULL,
  APF_APU_NUMAPU     NUMBER                         NULL,
  APF_EJE_CODIVA     VARCHAR2(4 BYTE)               NULL,
  APF_ASI_NUMASIIVA  NUMBER(10)                     NULL,
  APF_APU_NUMAPUIVA  NUMBER                         NULL,
  APF_DPG_COD        VARCHAR2(4 BYTE)               NULL,
  APF_DAT            DATE                           NULL,
  APF_IMP            NUMBER(17,3)                   NULL,
  APF_DATCRE         DATE                           NULL,
  APF_USUCRE         VARCHAR2(30 BYTE)              NULL,
  APF_DATMOD         DATE                           NULL,
  APF_USUMOD         VARCHAR2(30 BYTE)              NULL,
  APF_CCR            VARCHAR2(34 BYTE)              NULL,
  APF_EJE_CODPAG     VARCHAR2(4 BYTE)               NULL,
  APF_ASI_NUMASIPAG  NUMBER(10)                     NULL
)
;


CREATE UNIQUE INDEX RCMP_ACO_PK ON TCMP_ACO
(ACO_CEC_COD, ACO_EMP_COD, ACO_EJE_COD, ACO_DIA_COD, ACO_ASI_NUMASI, 
ACO_APU_NUMAPU)
;


CREATE UNIQUE INDEX RCMP_APF_PK ON TCMP_APUFAC
(APF_CEC_COD, APF_EMP_COD, APF_EJE_COD, APF_DIA_COD, APF_ASI_NUMASI, 
APF_APU_NUMAPU, APF_EJE_CODIVA, APF_ASI_NUMASIIVA, APF_APU_NUMAPUIVA)
;


CREATE OR REPLACE FORCE VIEW VCMP_APUFAC
AS 
SELECT /*+INDEX(tcmp_apunts icmp_apu_contra)*/
apu_cec_cod, apu_emp_cod, apu_eje_cod, apu_dia_cod, apu_asi_numasi, apu_numapu,
apu_ct5_cod, apu_contra, apu_basiva, (apu_imphab+apu_impdeb) AS apu_iva,
apu_datfac, apu_numfac, apu_asi_dat, apu_con,
SUM(apf_imp) AS liquidat
FROM TCMP_APUNTS, TCMP_APUFAC
WHERE (apu_ct5_cod LIKE '472%' OR apu_ct5_cod LIKE '477%')
AND apu_iva_codint IS NOT NULL AND apu_civ_cod IS NOT NULL
AND apu_asi_dat >= TO_DATE(/*Fcmp_Par(apu_cec_cod, 'REGCRICXA_INI',*/ '01/01/2014'/*)*/, 'dd/mm/yyyy')
--
AND apu_cec_cod=apf_cec_cod(+) AND apu_emp_cod=apf_emp_cod(+)
AND apu_eje_cod=apf_eje_codiva(+) AND apu_dia_cod=apf_dia_cod(+)
AND apu_asi_numasi=apf_asi_numasiiva(+) AND apu_numapu=apf_apu_numapuiva(+)
GROUP BY apu_cec_cod, apu_emp_cod, apu_eje_cod, apu_dia_cod, apu_asi_numasi, apu_numapu,
apu_ct5_cod, apu_contra, apu_basiva, apu_imphab, apu_impdeb, apu_datfac, apu_numfac, apu_asi_dat, apu_con
HAVING ((apu_basiva+apu_imphab+apu_impdeb)>0 AND (apu_basiva+apu_imphab+apu_impdeb)>NVL(SUM(apf_imp),0))
        OR ((apu_basiva+apu_imphab+apu_impdeb)<0 AND (apu_basiva+apu_imphab+apu_impdeb)<NVL(SUM(apf_imp),0));


CREATE OR REPLACE FORCE VIEW VCMP_LLIBREIVA
AS 
SELECT   tipus,
            apu_cec_cod,
            apu_emp_cod,
            apu_eje_cod,
            apu_dia_cod,
            apu_ct5_cod,
            asi_tas_cod,
            apu_asi_dat,
            apu_numdoc,
            apu_numdocfrt,
            apu_numfac,
            apu_con,
            valor_base_val, valor_base,
            apu_iva_codint,
            apu_civ_cod,
            cuota_val, cuota,
            apu_contra,
            ct5_des,
            dcp_nif_nif,
            apu_nifcpa,
            apu_nomcpa,
            asientocobro,
            datasientocobro,
            asientofactura,
            apuntfactura,
            totalfac,
            liq,
            apu_mon_cod,
            TotPdtLiq,
            BasPdtLiq,
            QuoPdtLiq,
            cricxaccr,
            apu_asi_numasi,
            apu_numapu,
            mon_valcan
     FROM   (-- emp no criteri de caixa: repercutit com sempre; soportat, ct5 no criteri com sempre, ct5 de criteri segons pagos
             SELECT    'NC-SN' AS tipus   /*NoCriteriCaixa-SoportatNoCriteri*/
                                       ,
                       apu_cec_cod,
                       apu_emp_cod,
                       apu_eje_cod,
                       apu_ct5_cod,
                       apu_dia_cod,
                       ASI_TAS_COD,
                       TCMP_APUNTS.APU_ASI_DAT,
                       TCMP_APUNTS.APU_NUMDOC,
                       apu_numdocfrt,
                       TCMP_APUNTS.APU_NUMFAC,
                       TCMP_APUNTS.APU_CON,
                       TCMP_APUNTS.APU_valBASIVA VALOR_BASE_val,
                       TCMP_APUNTS.APU_BASIVA VALOR_BASE,
                       TCMP_APUNTS.APU_IVA_CODINT,
                       TCMP_APUNTS.APU_CIV_COD,
                       DECODE (
                          plim_contenidor.get_Var1                 /*:tipiva*/
                                                  ,
                          '1'                                     /*soportat*/
                             ,
                          (TCMP_APUNTS.APU_valIMPDEB
                           - TCMP_APUNTS.APU_valIMPHAB),
                          (TCMP_APUNTS.APU_valIMPHAB
                           - TCMP_APUNTS.APU_valIMPDEB)
                       )
                          AS CUOTA_val,
                       DECODE (
                          plim_contenidor.get_Var1,                 /*:tipiva*/
                          '1',                                     /*soportat*/
                          (TCMP_APUNTS.APU_IMPDEB - TCMP_APUNTS.APU_IMPHAB),
                          (TCMP_APUNTS.APU_IMPHAB - TCMP_APUNTS.APU_IMPDEB)
                       ) AS CUOTA,
                       TCMP_APUNTS.APU_CONTRA,
                       TCMP_COMPTES5.CT5_DES,
                       TCMP_DADESCLIPROS.DCP_NIF_NIF,
                       apu_nifcpa,
                       apu_nomcpa,
                       --
                       TO_NUMBER (NULL) AS asientoCobro,
                       TO_DATE (NULL) AS datasientocobro,
                       apu_asi_numasi AS asientoFactura,
                       apu_numapu AS apuntFactura,
                       (apu_valbasiva + apu_valimphab + apu_valimpdeb)
                          AS totalFac,
                       (apu_valbasiva + apu_valimphab + apu_valimpdeb) AS liq,
                       apu_mon_cod,
                       0 AS TotPdtLiq,
                       0 AS BasPdtLiq,
                       0 AS QuoPdtLiq,
                       TO_CHAR (NULL) AS cricxaccr,
                       apu_asi_numasi,
                       apu_numapu           /* de la factura, no hi ha cobro*/
                                 ,
                       mon_valcan
                FROM   TCMP_APUNTS,
                       TCMP_COMPTES5,
                       TCMP_DADESCLIPROS,
                       TCMP_ASIENTOS,
                       TCMP_EMPRESES,
                       TCMP_EXERCICIS,
                       TCMP_MONEDES
               WHERE   TCMP_COMPTES5.CT5_CEC_COD(+) = TCMP_APUNTS.APU_CEC_COD
                       AND TCMP_COMPTES5.CT5_EMP_COD(+) =
                             TCMP_APUNTS.APU_EMP_COD
                       AND TCMP_COMPTES5.CT5_COD(+) = TCMP_APUNTS.APU_CONTRA
                       AND DCP_CEC_COD(+) = ct5_CEC_COD
                       AND DCP_EMP_COD(+) = ct5_EMP_COD
                       AND DCP_CT5_COD(+) = ct5_cod
                       AND APU_CEC_COD = ASI_CEC_COD
                       AND APU_EMP_COD = ASI_EMP_COD
                       AND APU_EJE_COD = ASI_EJE_COD
                       AND APU_DIA_COD = ASI_DIA_COD
                       AND APU_ASI_NUMASI = ASI_NUMASI
                       AND emp_cec_cod = asi_cec_cod
                       AND emp_cod = asi_emp_cod
                       AND asi_cec_cod = eje_cec_cod
                       AND asi_emp_cod = eje_emp_cod
                       AND asi_eje_cod = eje_cod
                       AND mon_cec_cod = eje_cec_cod
                       AND mon_cod = eje_mon_cod
                       AND ( (NVL (emp_regcricxa, 'N') = 'N'  /* no criteri */
                                                            AND ( (plim_contenidor.get_Var1 /*:tipiva*/
                                                                                           = '2' /*repercutit*/
                                                                                                ) OR (plim_contenidor.get_Var1 /*:tipiva*/
                                                                                                                              = '1' /*soportat*/
                                                                                                                                   AND NVL (ct5_regcricxa, 'N') = 'N')))
                            OR (NVL (emp_regcricxa, 'N') = 'S'
                                AND INSTR (
                                      Fcmp_Par (apu_cec_cod,
                                                'CIV_NOCRICXA',
                                                '#'),
                                      '#' || apu_civ_cod || '#'
                                   ) > 0))
             --
             UNION ALL
             -- emp no criteri de caixa: repercutit com sempre; soportat, ct5 no criteri com sempre, ct5 de criteri segons pagos
             SELECT   'NC-SS' AS tipus    /*NoCriteriCaixa-SoportatSiCriteri*/
                                      ,
                      apu_cec_cod,
                      apu_emp_cod,
                      apu_eje_cod,
                      apu_ct5_cod,
                      apu_dia_cod,
                      ASI_TAS_COD,
                      apu_asi_dat,
                      apu_numdoc,
                      apu_numdocfrt,
                      apu_numfac,
                      apu_con,
                      ( (liq / totalfac) * VALOR_BASE) AS valor_base_val,
                      ( (liq / totalfac) * VALOR_BASE) AS valor_base,
                      apu_iva_codint,
                      apu_civ_cod,
                      ( (liq / totalfac) * CUOTA) AS cuota_val, ( (liq / totalfac) * CUOTA) AS cuota,
                      apu_contra,
                      CT5_DES,
                      DCP_NIF_NIF,
                      apu_nifcpa,
                      apu_nomcpa,
                      asientoCobro,
                      datasientocobro,
                      asientoFactura,
                      apuntFactura,
                      totalFac,
                      liq,
                      apu_mon_cod,
                      totalfac - liqAData AS TotPdtLiq,
                      valor_base - ( (liqAData / totalfac) * VALOR_BASE)
                         AS BasPdtLiq,
                      cuota - (liqAData / totalfac) * CUOTA AS QuoPdtLiq,
                      cricxaccr,
                      TO_NUMBER (NULL) AS apu_asi_numasi,
                      TO_NUMBER (NULL) AS apu_numapu /*no podem filtrar per si està compensat o no*/
                                                    ,
                      mon_valcan
               FROM   (SELECT   f.apu_cec_cod AS apu_cec_cod,
                                f.apu_emp_cod AS apu_emp_cod,
                                f.apu_eje_cod AS apu_eje_cod,
                                f.APU_CT5_COD AS apu_ct5_cod,
                                f.APU_DIA_COD AS apu_dia_cod,
                                ASI_TAS_COD,
                                apf_dat AS apu_asi_dat,
                                f.apu_numdoc,
                                f.apu_numdocfrt,
                                f.apu_numfac,
                                f.apu_con,
                                f.APU_valBASIVA AS VALOR_BASE_val, f.APU_BASIVA AS VALOR_BASE,
                                f.apu_iva_codint,
                                f.apu_civ_cod AS apu_civ_cod,
                                DECODE (plim_contenidor.get_Var1,   /*:tipiva*/
                                        '1',                     /*1=soportat*/
                                        (f.APU_VALIMPDEB - f.APU_VALIMPHAB),
                                        (f.APU_VALIMPHAB - f.APU_VALIMPDEB))
                                   AS CUOTA_val,
                                DECODE (plim_contenidor.get_Var1,   /*:tipiva*/
                                        '1',                     /*1=soportat*/
                                        (f.APU_IMPDEB - f.APU_IMPHAB),
                                        (f.APU_IMPHAB - f.APU_IMPDEB))
                                   AS CUOTA,
                                f.apu_contra AS apu_contra,
                                CT5_DES,
                                DCP_NIF_NIF,
                                f.apu_nifcpa AS apu_nifcpa,
                                f.apu_nomcpa AS apu_nomcpa,
                                cp.apu_asi_numasi AS asientoCobro,
                                cp.apu_asi_dat AS datasientocobro,
                                f.apu_asi_numasi AS asientoFactura,
                                f.apu_numapu AS apuntFactura,
                                (  f.apu_valbasiva
                                 + f.apu_valimphab
                                 + f.apu_valimpdeb)
                                   AS totalFac,
                                apf_imp AS liq,
                                f.apu_mon_cod,
                                apf_ccr AS cricxaccr,
                                Fcmp_Apf_Impliq (f.APU_CEC_COD,
                                                 f.APU_EMP_COD,
                                                 f.APU_EJE_COD,
                                                 f.APU_DIA_COD,
                                                 f.APU_ASI_NUMASI,
                                                 f.APU_NUMAPU,
                                                 plim_contenidor.get_dat1)
                                   AS liqAData,
                                mon_valcan
                         FROM   TCMP_APUNTS cp,
                                TCMP_APUFAC,
                                TCMP_APUNTS f,
                                TCMP_ASIENTOS,
                                TCMP_EMPRESES,
                                TCMP_COMPTES5,
                                TCMP_DADESCLIPROS,
                                TCMP_EXERCICIS,
                                TCMP_MONEDES
                        WHERE       cp.apu_cec_cod = apf_cec_cod
                                AND cp.apu_emp_cod = apf_emp_cod
                                AND cp.apu_eje_cod = APF_EJE_COD
                                AND cp.apu_dia_cod = APF_DIA_COD
                                AND cp.apu_asi_numasi = APF_ASI_NUMASI
                                AND cp.apu_numapu = APF_APU_NUMAPU
                                AND f.apu_cec_cod = apf_cec_cod
                                AND f.apu_emp_cod = apf_emp_cod
                                AND f.apu_eje_cod = APF_EJE_CODIVA
                                AND f.apu_dia_cod = APF_DIA_COD
                                AND f.apu_asi_numasi = APF_ASI_NUMASIIVA
                                AND f.apu_numapu = APF_APU_NUMAPUIVA
                                AND f.APU_CEC_COD = ASI_CEC_COD
                                AND f.APU_EMP_COD = ASI_EMP_COD
                                AND f.APU_EJE_COD = ASI_EJE_COD
                                AND f.APU_DIA_COD = ASI_DIA_COD
                                AND f.APU_ASI_NUMASI = ASI_NUMASI
                                AND CT5_CEC_COD(+) = f.APU_CEC_COD
                                AND CT5_EMP_COD(+) = f.APU_EMP_COD
                                AND CT5_COD(+) = f.APU_CONTRA
                                AND DCP_CEC_COD(+) = ct5_CEC_COD
                                AND DCP_EMP_COD(+) = ct5_EMP_COD
                                AND DCP_CT5_COD(+) = ct5_cod
                                AND emp_cec_cod = asi_cec_cod
                                AND emp_cod = asi_emp_cod
                                AND asi_cec_cod = eje_cec_cod
                                AND asi_emp_cod = eje_emp_cod
                                AND asi_eje_cod = eje_cod
                                AND mon_cec_cod = eje_cec_cod
                                AND mon_cod = eje_mon_cod
                                AND NVL (emp_regcricxa, 'N') = 'N' /* emp amb criteri de caixa */
                                AND ( (plim_contenidor.get_Var1    /*:tipiva*/
                                                               = '1' /*soportat*/
                                                                    AND NVL (ct5_regcricxa, 'N') = 'S'))
                                AND (f.apu_cec_cod <> '1200'
                                     OR (f.apu_cec_cod = '1200'
                                         AND (plim_contenidor.get_Var1 = '2'
                                              OR (plim_contenidor.get_Var1 =
                                                     '1'
                                                  AND (apf_dpg_cod <> 'T'
                                                       OR (apf_dpg_cod = 'T'
                                                           AND apf_asi_numasipag IS NOT NULL))))))/*aqui no fa falta tractar el règims del paràmetre, ja q aquestes comptes no estaran marcades amb règim cxa*/
                                                                                                  )
              WHERE   liq <> 0
             --
             UNION ALL
             -- emp amb criteri de caixa: repercutit i soportat segons pagos
             SELECT   'CC-C' AS tipus                  /*CriteriCaixa-Cobrat*/
                                     ,
                      apu_cec_cod,
                      apu_emp_cod,
                      apu_eje_cod,
                      apu_ct5_cod,
                      apu_dia_cod,
                      ASI_TAS_COD,
                      apu_asi_dat,
                      apu_numdoc,
                      apu_numdocfrt,
                      apu_numfac,
                      apu_con,
                      ( (liq / totalfac) * VALOR_BASE_val) AS valor_base_val,
                      ( (liq / totalfac) * VALOR_BASE) AS valor_base,
                      apu_iva_codint,
                      apu_civ_cod,
                      ( (liq / totalfac) * CUOTA) AS cuota_val,
                      ( (liq / totalfac) * CUOTA) AS cuota,
                      apu_contra,
                      CT5_DES,
                      DCP_NIF_NIF,
                      apu_nifcpa,
                      apu_nomcpa,
                      asientoCobro,
                      datasientocobro,
                      asientoFactura,
                      apuntFactura,
                      totalFac,
                      liq,
                      apu_mon_cod,
                      totalfac - liqAData AS TotPdtLiq,
                      valor_base - ( (liqAData / totalfac) * VALOR_BASE)
                         AS BasPdtLiq,
                      cuota - (liqAData / totalfac) * CUOTA AS QuoPdtLiq,
                      cricxaccr,
                      TO_NUMBER (NULL) AS apu_asi_numasi,
                      TO_NUMBER (NULL) AS apu_numapu, /*no podem filtrar per si està compensat o no*/
                      mon_valcan
               FROM   (SELECT   f.apu_cec_cod AS apu_cec_cod,
                                f.apu_emp_cod AS apu_emp_cod,
                                f.apu_eje_cod,
                                f.APU_CT5_COD AS apu_ct5_cod,
                                f.APU_DIA_COD AS apu_dia_cod,
                                ASI_TAS_COD,
                                apf_dat AS apu_asi_dat,
                                f.apu_numdoc,
                                f.apu_numdocfrt,
                                f.apu_numfac,
                                f.apu_con,
                                f.APU_VALBASIVA AS VALOR_BASE_val,
                                f.APU_BASIVA AS VALOR_BASE,
                                f.apu_iva_codint,
                                f.apu_civ_cod AS apu_civ_cod,
                                DECODE (plim_contenidor.get_Var1,   /*:tipiva*/
                                        '1',                     /*1=soportat*/
                                        (f.APU_VALIMPDEB - f.APU_VALIMPHAB),
                                        (f.APU_VALIMPHAB - f.APU_VALIMPDEB))
                                   AS CUOTA_val,
                                DECODE (plim_contenidor.get_Var1,   /*:tipiva*/
                                        '1',                     /*1=soportat*/
                                        (f.APU_IMPDEB - f.APU_IMPHAB),
                                        (f.APU_IMPHAB - f.APU_IMPDEB))
                                   AS CUOTA,
                                f.apu_contra AS apu_contra,
                                CT5_DES,
                                DCP_NIF_NIF,
                                f.apu_nifcpa AS apu_nifcpa,
                                f.apu_nomcpa AS apu_nomcpa,
                                cp.apu_asi_numasi AS asientoCobro,
                                cp.apu_asi_dat AS datasientocobro,
                                f.apu_asi_numasi AS asientoFactura,
                                f.apu_numapu AS apuntFactura,
                                (  f.apu_valbasiva
                                 + f.apu_valimphab
                                 + f.apu_valimpdeb)
                                   AS totalFac,
                                apf_imp AS liq,
                                f.apu_mon_cod,
                                apf_ccr AS cricxaccr,
                                Fcmp_Apf_Impliq (f.APU_CEC_COD,
                                                 f.APU_EMP_COD,
                                                 f.APU_EJE_COD,
                                                 f.APU_DIA_COD,
                                                 f.APU_ASI_NUMASI,
                                                 f.APU_NUMAPU,
                                                 plim_contenidor.get_dat1)
                                   AS liqAData,
                                mon_valcan
                         FROM   TCMP_APUNTS cp,
                                TCMP_APUFAC,
                                TCMP_APUNTS f,
                                TCMP_ASIENTOS,
                                TCMP_EMPRESES,
                                TCMP_COMPTES5,
                                TCMP_DADESCLIPROS,
                                TCMP_EXERCICIS,
                                TCMP_MONEDES
                        WHERE       cp.apu_cec_cod = apf_cec_cod
                                AND cp.apu_emp_cod = apf_emp_cod
                                AND cp.apu_eje_cod = APF_EJE_COD
                                AND cp.apu_dia_cod = APF_DIA_COD
                                AND cp.apu_asi_numasi = APF_ASI_NUMASI
                                AND cp.apu_numapu = APF_APU_NUMAPU
                                AND f.apu_cec_cod = apf_cec_cod
                                AND f.apu_emp_cod = apf_emp_cod
                                AND f.apu_eje_cod = APF_EJE_CODIVA
                                AND f.apu_dia_cod = APF_DIA_COD
                                AND f.apu_asi_numasi = APF_ASI_NUMASIIVA
                                AND f.apu_numapu = APF_APU_NUMAPUIVA
                                AND f.APU_CEC_COD = ASI_CEC_COD
                                AND f.APU_EMP_COD = ASI_EMP_COD
                                AND f.APU_EJE_COD = ASI_EJE_COD
                                AND f.APU_DIA_COD = ASI_DIA_COD
                                AND f.APU_ASI_NUMASI = ASI_NUMASI
                                AND CT5_CEC_COD(+) = f.APU_CEC_COD
                                AND CT5_EMP_COD(+) = f.APU_EMP_COD
                                AND CT5_COD(+) = f.APU_CONTRA
                                AND DCP_CEC_COD(+) = ct5_CEC_COD
                                AND DCP_EMP_COD(+) = ct5_EMP_COD
                                AND DCP_CT5_COD(+) = ct5_cod
                                AND asi_cec_cod = eje_cec_cod
                                AND asi_emp_cod = eje_emp_cod
                                AND asi_eje_cod = eje_cod
                                AND mon_cec_cod = eje_cec_cod
                                AND mon_cod = eje_mon_cod
                                AND emp_cec_cod = asi_cec_cod
                                AND emp_cod = asi_emp_cod
                                AND NVL (emp_regcricxa, 'N') = 'S' /* emp amb criteri de caixa */
                                AND INSTR (
                                      Fcmp_Par (f.apu_cec_cod,
                                                'CIV_NOCRICXA',
                                                '#'),
                                      '#' || f.apu_civ_cod || '#'
                                   ) = 0/*  and (f.apu_cec_cod<>'1200' or
                                                                                                                                       (f.apu_cec_cod='1200' and
        (plim_contenidor.get_Var1='2' or
        (plim_contenidor.get_Var1='1' and (apf_dpg_cod<>'T' or (apf_dpg_cod='T' and apf_asi_numasipag is not null))))))*/
                                        )
              WHERE   liq <> 0)
    WHERE   plim_contenidor.get_Var1 IS NOT NULL;


CREATE OR REPLACE FORCE VIEW VCMP_LLIBREIVA1200_CC
AS 
SELECT tipus, apu_cec_cod, apu_emp_cod, apu_eje_cod, apu_dia_cod, apu_ct5_cod, asi_tas_cod, apu_asi_dat, apu_numdoc, apu_numdocfrt, apu_numfac,
apu_con, valor_base, apu_iva_codint, apu_civ_cod, cuota, apu_contra, ct5_des, dcp_nif_nif, apu_nifcpa, apu_nomcpa,
asientocobro, datasientocobro, asientofactura, apuntfactura, totalfac, liq, apu_mon_cod, TotPdtLiq, BasPdtLiq, QuoPdtLiq, cricxaccr,
apu_asi_numasi, apu_numapu, mon_valcan
 FROM (
-- emp no criteri de caixa: repercutit com sempre; soportat, ct5 no criteri com sempre, ct5 de criteri segons pagos
SELECT 'NC-SN' AS tipus /*NoCriteriCaixa-SoportatNoCriteri*/, apu_cec_cod, apu_emp_cod, apu_eje_cod, apu_ct5_cod, apu_dia_cod, ASI_TAS_COD,
TCMP_APUNTS.APU_ASI_DAT, TCMP_APUNTS.APU_NUMDOC, apu_numdocfrt, TCMP_APUNTS.APU_NUMFAC, TCMP_APUNTS.APU_CON,
TCMP_APUNTS.APU_valBASIVA VALOR_BASE,
TCMP_APUNTS.APU_IVA_CODINT,
TCMP_APUNTS.APU_CIV_COD,
DECODE(plim_contenidor.get_Var1 /*:tipiva*/, '1' /*soportat*/,
  (TCMP_APUNTS.APU_valIMPDEB - TCMP_APUNTS.APU_valIMPHAB),
  (TCMP_APUNTS.APU_valIMPHAB - TCMP_APUNTS.APU_valIMPDEB)
) AS CUOTA,
TCMP_APUNTS.APU_CONTRA, TCMP_COMPTES5.CT5_DES,
TCMP_DADESCLIPROS.DCP_NIF_NIF, apu_nifcpa, apu_nomcpa,
--
TO_NUMBER(NULL) AS asientoCobro, TO_DATE(NULL) AS datasientocobro, apu_asi_numasi AS asientoFactura, apu_numapu AS apuntFactura,
(apu_valbasiva+apu_valimphab+apu_valimpdeb) AS totalFac,
(apu_valbasiva+apu_valimphab+apu_valimpdeb) AS liq, apu_mon_cod,
0 AS TotPdtLiq, 0 AS BasPdtLiq, 0 AS QuoPdtLiq, TO_CHAR(NULL) AS cricxaccr,
apu_asi_numasi, apu_numapu /* de la factura, no hi ha cobro*/, mon_valcan
FROM TCMP_APUNTS, TCMP_COMPTES5,TCMP_DADESCLIPROS, TCMP_ASIENTOS, TCMP_EMPRESES, TCMP_EXERCICIS, TCMP_MONEDES
 WHERE TCMP_COMPTES5.CT5_CEC_COD(+)=TCMP_APUNTS.APU_CEC_COD
 AND TCMP_COMPTES5.CT5_EMP_COD(+)=TCMP_APUNTS.APU_EMP_COD
 AND TCMP_COMPTES5.CT5_COD(+)=TCMP_APUNTS.APU_CONTRA
 AND DCP_CEC_COD(+)=ct5_CEC_COD AND DCP_EMP_COD(+)=ct5_EMP_COD AND DCP_CT5_COD(+)=ct5_cod
 AND APU_CEC_COD=ASI_CEC_COD AND APU_EMP_COD=ASI_EMP_COD
 AND APU_EJE_COD=ASI_EJE_COD AND APU_DIA_COD=ASI_DIA_COD AND APU_ASI_NUMASI=ASI_NUMASI
 AND emp_cec_cod=asi_cec_cod AND emp_cod=asi_emp_cod
 AND asi_cec_cod=eje_cec_cod AND asi_emp_cod=eje_emp_cod AND asi_eje_cod=eje_cod
 AND mon_cec_cod=eje_cec_cod AND mon_cod=eje_mon_cod
 AND ((NVL(emp_regcricxa,'N')='N' /* no criteri */
       AND ((plim_contenidor.get_Var1 /*:tipiva*/='2'/*repercutit*/) OR (plim_contenidor.get_Var1 /*:tipiva*/='1'/*soportat*/
       AND (NVL(ct5_regcricxa,'N')='N') OR
(apu_cec_cod='1200' AND NVL(ct5_regcricxa,'N')='S' AND apu_civ_codint='0x3')))
	  ) OR (NVL(emp_regcricxa,'N')='S' AND INSTR(Fcmp_Par(apu_cec_cod, 'CIV_NOCRICXA', '#'), '#'||apu_civ_cod||'#')>0)
	 )
 --
 UNION ALL
 -- emp no criteri de caixa: repercutit com sempre; soportat, ct5 no criteri com sempre, ct5 de criteri segons pagos
 SELECT 'NC-SS' AS tipus /*NoCriteriCaixa-SoportatSiCriteri*/, apu_cec_cod, apu_emp_cod, apu_eje_cod, apu_ct5_cod, apu_dia_cod, ASI_TAS_COD,
apu_asi_dat, apu_numdoc, apu_numdocfrt, apu_numfac, apu_con,
((liq/totalfac) * VALOR_BASE) AS valor_base,
apu_iva_codint, apu_civ_cod, ((liq/totalfac) * CUOTA) AS cuota,
apu_contra, CT5_DES, DCP_NIF_NIF, apu_nifcpa, apu_nomcpa,
asientoCobro, datasientocobro, asientoFactura, apuntFactura,
totalFac,
liq, apu_mon_cod,
totalfac-liqAData AS TotPdtLiq, valor_base-((liqAData/totalfac) * VALOR_BASE) AS BasPdtLiq, cuota-(liqAData/totalfac) * CUOTA AS QuoPdtLiq,
cricxaccr, TO_NUMBER(NULL) AS apu_asi_numasi, TO_NUMBER(NULL) AS apu_numapu /*no podem filtrar per si esta compensat o no*/, mon_valcan
 FROM (
SELECT
f.apu_cec_cod AS apu_cec_cod, f.apu_emp_cod AS apu_emp_cod, f.apu_eje_cod AS apu_eje_cod,
f.APU_CT5_COD AS apu_ct5_cod, f.APU_DIA_COD AS apu_dia_cod, ASI_TAS_COD,
apf_dat AS apu_asi_dat, f.apu_numdoc, f.apu_numdocfrt, f.apu_numfac, f.apu_con,
f.APU_BASIVA AS VALOR_BASE,
f.apu_iva_codint, f.apu_civ_cod AS apu_civ_cod,
DECODE(plim_contenidor.get_Var1 /*:tipiva*/, '1' /*1=soportat*/,
  (f.APU_VALIMPDEB - f.APU_VALIMPHAB),
  (f.APU_VALIMPHAB - f.APU_VALIMPDEB) ) AS CUOTA,
f.apu_contra AS apu_contra, CT5_DES, DCP_NIF_NIF, f.apu_nifcpa AS apu_nifcpa, f.apu_nomcpa AS apu_nomcpa,
cp.apu_asi_numasi AS asientoCobro, cp.apu_asi_dat AS datasientocobro, f.apu_asi_numasi AS asientoFactura, f.apu_numapu AS apuntFactura,
(f.apu_valbasiva+f.apu_valimphab+f.apu_valimpdeb) AS totalFac,
apf_imp AS liq,
f.apu_mon_cod, apf_ccr AS cricxaccr,
Fcmp_Apf_Impliq(f.APU_CEC_COD, f.APU_EMP_COD, f.APU_EJE_COD, f.APU_DIA_COD, f.APU_ASI_NUMASI, f.APU_NUMAPU, plim_contenidor.get_dat1) AS liqAData, mon_valcan
 FROM TCMP_APUNTS cp, TCMP_APUFAC, TCMP_APUNTS f, TCMP_ASIENTOS, TCMP_EMPRESES,
      TCMP_COMPTES5, TCMP_DADESCLIPROS, TCMP_EXERCICIS, TCMP_MONEDES
WHERE cp.apu_cec_cod=apf_cec_cod AND cp.apu_emp_cod=apf_emp_cod
  AND cp.apu_eje_cod=APF_EJE_COD AND cp.apu_dia_cod=APF_DIA_COD
  AND cp.apu_asi_numasi=APF_ASI_NUMASI AND cp.apu_numapu=APF_APU_NUMAPU
  AND f.apu_cec_cod=apf_cec_cod AND f.apu_emp_cod=apf_emp_cod
  AND f.apu_eje_cod=APF_EJE_CODIVA AND f.apu_dia_cod=APF_DIA_COD
  AND f.apu_asi_numasi=APF_ASI_NUMASIIVA AND f.apu_numapu=APF_APU_NUMAPUIVA
  AND f.APU_CEC_COD=ASI_CEC_COD AND f.APU_EMP_COD=ASI_EMP_COD AND f.APU_EJE_COD=ASI_EJE_COD
  AND f.APU_DIA_COD=ASI_DIA_COD AND f.APU_ASI_NUMASI=ASI_NUMASI
  AND CT5_CEC_COD(+)=f.APU_CEC_COD AND CT5_EMP_COD(+)=f.APU_EMP_COD AND CT5_COD(+)=f.APU_CONTRA
  AND DCP_CEC_COD(+)=ct5_CEC_COD AND DCP_EMP_COD(+)=ct5_EMP_COD AND DCP_CT5_COD(+)=ct5_cod
  AND emp_cec_cod=asi_cec_cod AND emp_cod=asi_emp_cod
   AND asi_cec_cod=eje_cec_cod AND asi_emp_cod=eje_emp_cod AND asi_eje_cod=eje_cod
 AND mon_cec_cod=eje_cec_cod AND mon_cod=eje_mon_cod
  AND NVL(emp_regcricxa,'N')='N' /* emp amb criteri de caixa */
 AND ((plim_contenidor.get_Var1 /*:tipiva*/='1'/*soportat*/ AND NVL(ct5_regcricxa,'N')='S'))
 AND (f.apu_cec_cod<>'1200' OR
      (f.apu_cec_cod='1200' AND
        (plim_contenidor.get_Var1='2' OR
        (plim_contenidor.get_Var1='1' AND f.apu_civ_codint!='0x3' AND
         (/*(f.apu_asi_dat<'01/08/2015') OR*/ (f.apu_asi_dat>='01/08/2015' /*mateur, 28/8/15*/ AND
		 (apf_dpg_cod<>'T' OR (apf_dpg_cod='T' AND apf_asi_numasipag IS NOT NULL))))))))
 /*aqui no fa falta tractar el regims del parametre, ja q aquestes comptes no estaran marcades amb regim cxa*/
 ) WHERE liq<>0
 --
 UNION ALL
 -- emp amb criteri de caixa: repercutit i soportat segons pagos
SELECT 'CC-C' AS tipus /*CriteriCaixa-Cobrat*/,
 apu_cec_cod, apu_emp_cod, apu_eje_cod, apu_ct5_cod, apu_dia_cod, ASI_TAS_COD,
apu_asi_dat, apu_numdoc, apu_numdocfrt, apu_numfac, apu_con,
((liq/totalfac) * VALOR_BASE) AS valor_base,
apu_iva_codint, apu_civ_cod, ((liq/totalfac) * CUOTA) AS cuota,
apu_contra, CT5_DES, DCP_NIF_NIF, apu_nifcpa, apu_nomcpa,
asientoCobro, datasientocobro, asientoFactura, apuntFactura,
totalFac,
liq, apu_mon_cod,
totalfac-liqAData AS TotPdtLiq, valor_base-((liqAData/totalfac) * VALOR_BASE) AS BasPdtLiq, cuota-(liqAData/totalfac) * CUOTA AS QuoPdtLiq,
cricxaccr, TO_NUMBER(NULL) AS apu_asi_numasi, TO_NUMBER(NULL) AS apu_numapu /*no podem filtrar per si esta compensat o no*/, mon_valcan FROM (
SELECT
f.apu_cec_cod AS apu_cec_cod, f.apu_emp_cod AS apu_emp_cod, f.apu_eje_cod, f.APU_CT5_COD AS apu_ct5_cod, f.APU_DIA_COD AS apu_dia_cod, ASI_TAS_COD,
apf_dat AS apu_asi_dat, f.apu_numdoc, f.apu_numdocfrt, f.apu_numfac, f.apu_con,
f.APU_VALBASIVA AS VALOR_BASE,
f.apu_iva_codint, f.apu_civ_cod AS apu_civ_cod,
DECODE(plim_contenidor.get_Var1 /*:tipiva*/, '1' /*1=soportat*/,
  (f.APU_VALIMPDEB - f.APU_VALIMPHAB),
  (f.APU_VALIMPHAB - f.APU_VALIMPDEB) ) AS CUOTA,
f.apu_contra AS apu_contra, CT5_DES, DCP_NIF_NIF, f.apu_nifcpa AS apu_nifcpa, f.apu_nomcpa AS apu_nomcpa,
cp.apu_asi_numasi AS asientoCobro, cp.apu_asi_dat AS datasientocobro, f.apu_asi_numasi AS asientoFactura, f.apu_numapu AS apuntFactura,
(f.apu_valbasiva+f.apu_valimphab+f.apu_valimpdeb) AS totalFac,
apf_imp AS liq,
f.apu_mon_cod, apf_ccr AS cricxaccr,
Fcmp_Apf_Impliq(f.APU_CEC_COD, f.APU_EMP_COD, f.APU_EJE_COD, f.APU_DIA_COD, f.APU_ASI_NUMASI, f.APU_NUMAPU, plim_contenidor.get_dat1) AS liqAData,
mon_valcan
 FROM TCMP_APUNTS cp, TCMP_APUFAC, TCMP_APUNTS f, TCMP_ASIENTOS, TCMP_EMPRESES,
      TCMP_COMPTES5, TCMP_DADESCLIPROS, TCMP_EXERCICIS, TCMP_MONEDES
WHERE cp.apu_cec_cod=apf_cec_cod AND cp.apu_emp_cod=apf_emp_cod
  AND cp.apu_eje_cod=APF_EJE_COD AND cp.apu_dia_cod=APF_DIA_COD
  AND cp.apu_asi_numasi=APF_ASI_NUMASI AND cp.apu_numapu=APF_APU_NUMAPU
  AND f.apu_cec_cod=apf_cec_cod AND f.apu_emp_cod=apf_emp_cod
  AND f.apu_eje_cod=APF_EJE_CODIVA AND f.apu_dia_cod=APF_DIA_COD
  AND f.apu_asi_numasi=APF_ASI_NUMASIIVA AND f.apu_numapu=APF_APU_NUMAPUIVA
  AND f.APU_CEC_COD=ASI_CEC_COD AND f.APU_EMP_COD=ASI_EMP_COD AND f.APU_EJE_COD=ASI_EJE_COD
  AND f.APU_DIA_COD=ASI_DIA_COD AND f.APU_ASI_NUMASI=ASI_NUMASI
  AND CT5_CEC_COD(+)=f.APU_CEC_COD AND CT5_EMP_COD(+)=f.APU_EMP_COD AND CT5_COD(+)=f.APU_CONTRA
  AND DCP_CEC_COD(+)=ct5_CEC_COD AND DCP_EMP_COD(+)=ct5_EMP_COD AND DCP_CT5_COD(+)=ct5_cod
   AND asi_cec_cod=eje_cec_cod AND asi_emp_cod=eje_emp_cod AND asi_eje_cod=eje_cod
 AND mon_cec_cod=eje_cec_cod AND mon_cod=eje_mon_cod
  AND emp_cec_cod=asi_cec_cod AND emp_cod=asi_emp_cod AND
  NVL(emp_regcricxa,'N')='S' /* emp amb criteri de caixa */
  AND INSTR(Fcmp_Par(f.apu_cec_cod, 'CIV_NOCRICXA', '#'), '#'||f.apu_civ_cod||'#')=0
/*  and (f.apu_cec_cod<>'1200' or
      (f.apu_cec_cod='1200' and
        (plim_contenidor.get_Var1='2' or
        (plim_contenidor.get_Var1='1' and (apf_dpg_cod<>'T' or (apf_dpg_cod='T' and apf_asi_numasipag is not null))))))*/
  ) WHERE liq<>0
 ) WHERE plim_contenidor.get_Var1 IS NOT NULL;


ALTER TABLE TCMP_347OPH_HIST ADD (
  CONSTRAINT RCMP_OPHH_PK
 PRIMARY KEY
 (OPH_CEC_COD, OPH_EMP_COD, OPH_CLASSE, OPH_CLIPRO, OPH_SEQ, OPH_EJE)
    USING INDEX 
    );

ALTER TABLE TCMP_ACASA_FACTURES ADD (
  CONSTRAINT RCMP_ACASA_FAC_PK
 PRIMARY KEY
 (FAC_CEC_COD, FAC_EMP_COD, FAC_EJE_COD, FAC_DIA_COD, FAC_ASI_NUMASI)
    USING INDEX 
    );

ALTER TABLE TCMP_ACASA_FACTURES_IVA ADD (
  CONSTRAINT RCMP_ACASA_IVA_PK
 PRIMARY KEY
 (IVA_CEC_COD, IVA_EMP_COD, IVA_EJE_COD, IVA_DIA_COD, IVA_ASI_NUMASI, IVA_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_ACASA_FACTURES_PRO ADD (
  CONSTRAINT RCMP_ACASA_PRO_PK
 PRIMARY KEY
 (PRO_CEC_COD, PRO_EMP_COD, PRO_EJE_COD, PRO_DIA_COD, PRO_ASI_NUMASI, PRO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_AGE ADD (
  CONSTRAINT RCMP_AGE_PK
 PRIMARY KEY
 (AGE_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_AMORTIZACIONS_PLA2008 ADD (
  CONSTRAINT RCMP_AMO08_PK
 PRIMARY KEY
 (AMO08_CEC_COD, AMO08_EMP_COD, AMO08_TIP, AMO08_CT5_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_APUNTS_PLA2008 ADD (
  CONSTRAINT RCMP_APU08_PK
 PRIMARY KEY
 (APU08_CEC_COD, APU08_EMP_COD, APU08_EJE_COD, APU08_DIA_COD, APU08_CONTRA, APU08_ASI_NUMASI, APU08_NUMAPU)
    USING INDEX 
    );

ALTER TABLE TCMP_CLICECO ADD (
  CONSTRAINT RCMP_CEC_PK
 PRIMARY KEY
 (CEC_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_CLV ADD (
  CONSTRAINT RCMP_CLV_PK
 PRIMARY KEY
 (CLV_CEC_COD, CLV_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_CNAES ADD (
  CONSTRAINT RCMP_CNA_PK
 PRIMARY KEY
 (CNA_CEC_COD, CNA_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_CONCEPTES ADD (
  CONSTRAINT RCMP_CON_PK
 PRIMARY KEY
 (CON_CEC_COD, CON_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_CONCOM ADD (
  CONSTRAINT RCMP_CCO_PK
 PRIMARY KEY
 (CCO_CEC_COD, CCO_COD));

ALTER TABLE TCMP_CT4CLV ADD (
  CONSTRAINT RCMP_CTV_PK
 PRIMARY KEY
 (CTV_CEC_COD, CTV_CT4_COD, CTV_CLV_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DELETE ADD (
  CONSTRAINT RCMP_DEL_PK
 PRIMARY KEY
 (DEL_CEC_COD, DEL_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPCTA002 ADD (
  CONSTRAINT RCMP_DCT002_PK
 PRIMARY KEY
 (DCT_CEC_COD, DCT_FIS_COD, DCT_EXC)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPCTA003 ADD (
  CONSTRAINT RCMP_DCT003_PK
 PRIMARY KEY
 (DCT_CEC_COD, DCT_FIS_COD, DCT_EXC)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPCTA08_BAL ADD (
  CONSTRAINT RCMP_DCB_PK
 PRIMARY KEY
 (DCB_CEC_COD, DCB_FIS_COD, DCB_EXC, DCB_COD, DCB_TIP, DCB_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPCTA08_PNP ADD (
  CONSTRAINT RCMP_PNP_PK
 PRIMARY KEY
 (PNP_CEC_COD, PNP_FIS_COD, PNP_EXC, PNP_COD, PNP_TIP, PNP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPPROCOM_TRASPAS ADD (
  CONSTRAINT RCMP_DCOTRS_PK
 PRIMARY KEY
 (DCO_USU, DCO_CEC_COD, DCO_EMP_COD, DCO_EJE_COD, DCO_DIA_COD, DCO_ASI_NUMASIAUX, DCO_APU_NUMAPUAUX, DCO_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DINAMICS ADD (
  CONSTRAINT RCMP_DIN_PK
 PRIMARY KEY
 (DIN_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DMO ADD (
  CONSTRAINT RCMP_DMO_PK
 PRIMARY KEY
 (DMO_CEC_COD, DMO_MDL, DMO_GRP, DMO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DPG ADD (
  CONSTRAINT RCMP_DPG_PK
 PRIMARY KEY
 (DPG_CEC_COD, DPG_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_EFC ADD (
  CONSTRAINT RCMP_EFC_PK
 PRIMARY KEY
 (EFC_CEC_COD, EFC_NUMREG, EFC_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ESI ADD (
  CONSTRAINT RCMP_ESI_PK
 PRIMARY KEY
 (ESI_CEC_COD, ESI_EMP_COD, ESI_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_EST ADD (
  CONSTRAINT RCMP_EST_PK
 PRIMARY KEY
 (EST_CEC_COD, EST_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_FCE ADD (
  CONSTRAINT RCMP_FCE_PK
 PRIMARY KEY
 (FCE_CEC_COD, FCE_NUMREG)
    USING INDEX 
    );

ALTER TABLE TCMP_FPA ADD (
  CONSTRAINT RCMP_FPA_PK
 PRIMARY KEY
 (FPA_CEC_COD, FPA_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_GRUPS ADD (
  CONSTRAINT RCMP_GRP_PK
 PRIMARY KEY
 (GRP_CEC_COD, GRP_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_HISENDES ADD (
  CONSTRAINT RCMP_HIS_PK
 PRIMARY KEY
 (HIS_CEC_COD, HIS_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_HPR ADD (
  CONSTRAINT RCMP_HPR_PK
 PRIMARY KEY
 (HPR_CEC_COD, HPR_EMP_COD, HPR_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_IAES ADD (
  CONSTRAINT RCMP_IAE_PK
 PRIMARY KEY
 (IAE_CEC_COD, IAE_EPIGRAFE)
    USING INDEX 
    );

ALTER TABLE TCMP_ICV ADD (
  CONSTRAINT RCMP_ICV_PK
 PRIMARY KEY
 (ICV_CEC_COD, ICV_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_IMPRESSIONS ADD (
  CONSTRAINT RCMP_IMP_PK
 PRIMARY KEY
 (IMP_CEC_COD, IMP_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_INFORMES ADD (
  CONSTRAINT RCMP_INF_PK
 PRIMARY KEY
 (INF_CEC_COD, INF_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_INFORMES_BMP ADD (
  CONSTRAINT RCMP_INB_PK
 PRIMARY KEY
 (INB_CEC_COD, INB_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_LINIES_DINAMIC ADD (
  CONSTRAINT RCMP_LDI_PK
 PRIMARY KEY
 (LDI_DIN_COD, LDI_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_LINIES_IMPRESSIO ADD (
  CONSTRAINT RCMP_LIM_PK
 PRIMARY KEY
 (LIM_CEC_COD, LIM_IMP_COD, LIM_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_LINIES_INFORME ADD (
  CONSTRAINT RCMP_LIN_PK
 PRIMARY KEY
 (LIN_INF_COD, LIN_CEC_COD, LIN_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_LINIES_INFORME_BMP ADD (
  CONSTRAINT RCMP_LIB_PK
 PRIMARY KEY
 (LIB_CEC_COD, LIB_INB_COD, LIB_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_LSTTAN ADD (
  CONSTRAINT RCMP_TAN_PK
 PRIMARY KEY
 (TAN_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD200DSG ADD (
  CONSTRAINT RCMP_M200DSG_PK
 PRIMARY KEY
 (M200DSG_CEC_COD, M200DSG_M201_NUM, M200DSG_COD, M200DSG_DMO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD347 ADD (
  CONSTRAINT RCMP_M347_PK
 PRIMARY KEY
 (M347_CEC_COD, M347_EMP_COD, M347_EXC)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD347_R1 ADD (
  CONSTRAINT RCMP_M3471_PK
 PRIMARY KEY
 (M3471_CEC_COD, M3471_EMP_COD, M3471_EXC, M3471_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD347_R2 ADD (
  CONSTRAINT RCMP_M3472_PK
 PRIMARY KEY
 (M3472_CEC_COD, M3472_EMP_COD, M3472_EXC, M3472_M3471_SEQ, M3472_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_MONEDES ADD (
  CONSTRAINT RCMP_MON_PK
 PRIMARY KEY
 (MON_CEC_COD, MON_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_MULLER_FAC ADD (
  CONSTRAINT RCMP_MULLERFAC_PK
 PRIMARY KEY
 (EMPRESA, NUMSERIEFACTURAEMISOR, TIPOIMPOSITIVO)
    USING INDEX 
    );

ALTER TABLE TCMP_MULLER_FPV ADD (
  CONSTRAINT RCMP_MULLERFPV_PK
 PRIMARY KEY
 (EMPRESA, NIF, NUMSERIEFACTURAEMISOR, TIPOIMPOSITIVO)
    USING INDEX 
    );

ALTER TABLE TCMP_MULLER_TIK ADD (
  CONSTRAINT RCMP_MULLERTIK_PK
 PRIMARY KEY
 (EMPRESA, TIENDA, CAJA, FECHAFACTURA)
    USING INDEX 
    );

ALTER TABLE TCMP_N43_CABCTA ADD (
  CONSTRAINT RCMP_CAB_PK
 PRIMARY KEY
 (CAB_CEC_COD, CAB_EMP_COD, CAB_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_N43_FINCTA ADD (
  CONSTRAINT RCMP_FIN_PK
 PRIMARY KEY
 (FIN_CEC_COD, FIN_CAB_SEQ, FIN_SEQ));

ALTER TABLE TCMP_N43_IMPAPU ADD (
  CONSTRAINT RCMP_IAP_PK
 PRIMARY KEY
 (IAP_CEC_COD, IAP_EMP_COD, IAP_CAB_SEQ, IAP_SEQ));

ALTER TABLE TCMP_N43_PPLMOV ADD (
  CONSTRAINT RCMP_MOV_PK
 PRIMARY KEY
 (MOV_CEC_COD, MOV_EMP_COD, MOV_CAB_SEQ, MOV_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_OBLIGACIONS ADD (
  CONSTRAINT RCMP_ICMP_OBL_PK
 PRIMARY KEY
 (OBL_CEC_COD, OBL_COD));

ALTER TABLE TCMP_OPERACIONS ADD (
  CONSTRAINT RCMP_OPE_PK
 PRIMARY KEY
 (OPE_CEC_COD, OPE_INF_COD, OPE_LIN_COD, OPE_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_OPERACIONS_BMP ADD (
  CONSTRAINT RCMP_OPB_PK
 PRIMARY KEY
 (OPB_CEC_COD, OPB_INB_COD, OPB_LIB_COD, OPB_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_PAISOS ADD (
  CONSTRAINT RCMP_PAI_PK
 PRIMARY KEY
 (PAI_CEC_COD, PAI_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_PARAMETRES ADD (
  CONSTRAINT RCMP_PAR_PK
 PRIMARY KEY
 (PAR_CEC_COD, PAR_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_PDD ADD (
  CONSTRAINT RCMP_PDD_PK
 PRIMARY KEY
 (PDD_CEC_COD, PDD_PRO_COD, PDD_PRO_COD002)
    USING INDEX 
    );

ALTER TABLE TCMP_PRESENTA ADD (
  CONSTRAINT RCMP_PRS_PK
 PRIMARY KEY
 (PRS_CEC_COD, PRS_NIF)
    USING INDEX 
    );

ALTER TABLE TCMP_PRESUDESGLOSES_ANUAL002 ADD (
  CONSTRAINT RCMP_PDA002_PK
 PRIMARY KEY
 (PDA_CEC_COD, PDA_EMP_COD, PDA_HPR_COD, PDA_CT5_COD, PDA_PRE_ANY, PDA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_PRESUPOSTS002 ADD (
  CONSTRAINT RCMP_PRE002_PK
 PRIMARY KEY
 (PRE_CEC_COD, PRE_EMP_COD, PRE_HPR_COD, PRE_CT5_COD, PRE_ANY, PRE_MES)
    USING INDEX 
    );

ALTER TABLE TCMP_PROJECTES ADD (
  CONSTRAINT RCMP_PRO_PK
 PRIMARY KEY
 (PRO_CEC_COD, PRO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_PROVINCIES ADD (
  CONSTRAINT RCMP_PRV_PK
 PRIMARY KEY
 (PRV_CEC_COD, PRV_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_RFA ADD (
  CONSTRAINT RCMP_RFA_PK
 PRIMARY KEY
 (RFA_CEC_COD, RFA_EMP_COD, RFA_DIA_COD, RFA_NUMRGT, RFA_ANY)
    USING INDEX 
    );

ALTER TABLE TCMP_SALDOS07_PLA2008 ADD (
  CONSTRAINT RCMP_SAL07_PK
 PRIMARY KEY
 (SAL07_CEC_COD, SAL07_EMP_COD, SAL07_CT5_COD, SAL07_DIA_COD, SAL07_CT5_CODDTI)
    USING INDEX 
    );

ALTER TABLE TCMP_SALDOS_PLA2008 ADD (
  CONSTRAINT RCMP_SAL08_PK
 PRIMARY KEY
 (SAL08_CEC_COD, SAL08_EMP_COD, SAL08_CT5_COD, SAL08_DIA_COD, SAL08_CT5_CODDTI)
    USING INDEX 
    );

ALTER TABLE TCMP_SELVEN001 ADD (
  CONSTRAINT RCMP_SLV001_PK
 PRIMARY KEY
 (SLV_CEC_COD, SLV_EMP_COD, SLV_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_SELVEN002 ADD (
  CONSTRAINT RCMP_SLV002_PK
 PRIMARY KEY
 (SLV002_CEC_COD, SLV002_EMP_COD, SLV002_SLV_SEQ, SLV002_DIA_COD, SLV002_VEN_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_TCO ADD (
  CONSTRAINT RCMP_TCO_PK
 PRIMARY KEY
 (TCO_CEC_COD, TCO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_TIPUSASIENTOS ADD (
  CONSTRAINT RCMP_TAS_PK
 PRIMARY KEY
 (TAS_CEC_COD, TAS_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_TMP_BSS ADD (
  CONSTRAINT RCMP_TMP_BSS_PK
 PRIMARY KEY
 (BSS_NUMFIT, BSS_CEC_COD, BSS_EMP_COD, BSS_EJE_COD, BSS_CT5_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_TMP_BSSBMP ADD (
  CONSTRAINT RCMP_BSSTMP_PK
 PRIMARY KEY
 (BSS_CEC_COD, BSS_COD, BSS_ORD)
    USING INDEX 
    );

ALTER TABLE TCMP_TOC ADD (
  CONSTRAINT RCMP_TOC_PK
 PRIMARY KEY
 (TOC_CEC_COD, TOC_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_TRASPAS ADD (
  CONSTRAINT RCMP_TRS_PK
 PRIMARY KEY
 (TRS_USU, TRS_CEC_COD, TRS_EMP_COD, TRS_EJE_COD, TRS_DIA_COD, TRS_ASIAUX, TRS_APUAUX)
    USING INDEX 
    );

ALTER TABLE TCMP_TVE ADD (
  CONSTRAINT RCMP_TVE_PK
 PRIMARY KEY
 (TVE_CEC_COD, TVE_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_UBI ADD (
  CONSTRAINT RCMP_UBI_PK
 PRIMARY KEY
 (UBI_CEC_COD, UBI_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_UH_TRASPASSOS ADD (
  CONSTRAINT RCMP_UHTRS_PK
 PRIMARY KEY
 (TRS_CEC_COD, TRS_EMP_COD, TRS_EJE_COD, TRS_DIA_COD, TRS_ASI_NUMASI, TRS_APU_NUMAPU)
    USING INDEX 
    );

ALTER TABLE TCMP_USUARISGRUPS ADD (
  CONSTRAINT RCMP_UGR_PK
 PRIMARY KEY
 (UGR_CEC_COD, UGR_GRP_COD, UGR_USU_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_VENCIMENTS_PLA2008 ADD (
  CONSTRAINT RCMP_VEN08_PK
 PRIMARY KEY
 (VEN08_CEC_COD, VEN08_EMP_COD, VEN08_DIA_COD, VEN08_SEQ, VEN08_DTI)
    USING INDEX 
    );

ALTER TABLE TCMP_VMO ADD (
  CONSTRAINT RCMP_VMO_PK
 PRIMARY KEY
 (VMO_CEC_COD, VMO_FIS_COD, VMO_EXC, VMO_PRD, VMO_MDL, VMO_GRP, VMO_COD)
    USING INDEX 
    );

ALTER TABLE TLVR_CAMPOS ADD (
  CONSTRAINT RLVR_CAM_PK
 PRIMARY KEY
 (CAM_NUM)
    USING INDEX 
    );

ALTER TABLE TLVR_DECLAR ADD (
  CONSTRAINT RLVR_DEC_PK
 PRIMARY KEY
 (DEC_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_347ARRE_HIST ADD (
  CONSTRAINT RCMP_ARRH_PK
 PRIMARY KEY
 (ARR_CEC_COD, ARR_EMP_COD, ARR_CLASSE, ARR_CLIPRO, ARR_OPH_SEQ, ARR_OPH_EJE, ARR_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_ACV ADD (
  CONSTRAINT RCMP_ACV_PK
 PRIMARY KEY
 (ACV_CEC_COD, ACV_ICV_COD, ACV_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_APJ ADD (
  CONSTRAINT RCMP_APJ_PK
 PRIMARY KEY
 (APJ_CEC_COD, APJ_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_ASP ADD (
  CONSTRAINT RCMP_ASP_PK
 PRIMARY KEY
 (ASP_COD, ASP_CEC_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_CAMPS ADD (
  CONSTRAINT RCMP_CAM_PK
 PRIMARY KEY
 (CAM_CEC_COD, CAM_IMP_COD, CAM_LIM_NUM, CAM_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_CAV ADD (
  CONSTRAINT RCMP_CAV_PK
 PRIMARY KEY
 (CAV_CEC_COD, CAV_ICV_COD, CAV_ACV_COD, CAV_SEQ)
    USING INDEX 
    ,
  CONSTRAINT RCMP_CAV_UK
 UNIQUE (CAV_CEC_COD, CAV_ICV_COD, CAV_ACV_COD, CAV_CLV_COD, CAV_ACV_COD002, CAV_CTE)
    USING INDEX 
    );

ALTER TABLE TCMP_CLASEIVAS ADD (
  CONSTRAINT RCMP_CIV_PK
 PRIMARY KEY
 (CIV_CEC_COD, CIV_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DPP ADD (
  CONSTRAINT RCMP_DPP_PK
 PRIMARY KEY
 (DPP_CEC_COD, DPP_ASP_COD, DPP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_HVD ADD (
  CONSTRAINT RCMP_HVD_PK
 PRIMARY KEY
 (HVD_CEC_COD, HVD_MON_COD, HVD_DIA)
    USING INDEX 
    );

ALTER TABLE TCMP_IVAS ADD (
  CONSTRAINT RCMP_IVA_PK
 PRIMARY KEY
 (IVA_CEC_COD, IVA_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_MODULSIRPF ADD (
  CONSTRAINT RCMP_MIR_PK
 PRIMARY KEY
 (MIR_CEC_COD, MIR_IAE_EPIGRAFE, MIR_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MODULSIVA ADD (
  CONSTRAINT RCMP_MIV_PK
 PRIMARY KEY
 (MIV_CEC_COD, MIV_IAE_EPIGRAFE, MIV_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_N43_CPLCON ADD (
  CONSTRAINT RCMP_N43CON_PK
 PRIMARY KEY
 (CON_CEC_COD, CON_EMP_COD, CON_CAB_SEQ, CON_MOV_SEQ, CON_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_PJA ADD (
  CONSTRAINT RCMP_PJA_PK
 PRIMARY KEY
 (PJA_CEC_COD, PJA_APJ_COD, PJA_PRO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_POBLACIONS ADD (
  CONSTRAINT RCMP_POB_PK
 PRIMARY KEY
 (POB_CEC_COD, POB_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_PRESUDESGLOSES002 ADD (
  CONSTRAINT RCMP_PDE002_PK
 PRIMARY KEY
 (PDE_CEC_COD, PDE_EMP_COD, PDE_HPR_COD, PDE_CT5_COD, PDE_PRE_ANY, PDE_PRE_MES, PDE_SEQ)
    USING INDEX 
    );

ALTER TABLE TLVR_DATOS ADD (
  CONSTRAINT RLVR_DAT_PK
 PRIMARY KEY
 (DAT_DEC_NUM, DAT_CAM_NUM, DAT_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_APP ADD (
  CONSTRAINT RCMP_APP_PK
 PRIMARY KEY
 (APP_ORD, APP_ASP_COD, APP_CEC_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_CTESREGIVA ADD (
  CONSTRAINT RCMP_CRI_PK
 PRIMARY KEY
 (CRI_CEC_COD, CRI_IVA_COD, CRI_CIV_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_FBA ADD (
  CONSTRAINT RCMP_FBA_PK
 PRIMARY KEY
 (FBA_CEC_COD, FBA_DIA_COD, FBA_EMP_COD, FBA_RFA_NUMRGT, FBA_IVA_COD, FBA_RFA_ANY)
    USING INDEX 
    );

ALTER TABLE TCMP_MIR_ICP ADD (
  CONSTRAINT RCMP_ICP_PK
 PRIMARY KEY
 (ICP_CEC_COD, ICP_IAE_EPIGRAFE, ICP_MIR_SEQ, ICP_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_NIFS ADD (
  CONSTRAINT RCMP_NIF_PK
 PRIMARY KEY
 (NIF_CEC_COD, NIF_NIF)
    USING INDEX 
    );

ALTER TABLE TCMP_EMPRESAFIS ADD (
  CONSTRAINT RCMP_FIS_PK
 PRIMARY KEY
 (FIS_CEC_COD, FIS_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_EMPRESAX ADD (
  CONSTRAINT RCMP_EMX_PK
 PRIMARY KEY
 (EMX_CEC_COD, EMX_EMP_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_EMPRESES ADD (
  CONSTRAINT RCMP_EMP_PK
 PRIMARY KEY
 (EMP_CEC_COD, EMP_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_EMPRE_OBLIGACIONS ADD (
  CONSTRAINT RCMP_FIS_OBL_PK
 PRIMARY KEY
 (FOB_CEC_COD, FOB_FIS_COD, FOB_OBL_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_EXD ADD (
  CONSTRAINT RCMP_EXD_PK
 PRIMARY KEY
 (EXD_CEC_COD, EXD_EMP_COD, EXD_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_EXERCICIS ADD (
  CONSTRAINT RCMP_EJE_PK
 PRIMARY KEY
 (EJE_CEC_COD, EJE_EMP_COD, EJE_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_GRUPSEMPRESES ADD (
  CONSTRAINT RCMP_GEM_PK
 PRIMARY KEY
 (GEM_GRP_COD, GEM_EMP_CEC_COD, GEM_EMP_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_M00 ADD (
  CONSTRAINT RCMP_M00_PK
 PRIMARY KEY
 (M00_CEC_COD, M00_FIS_COD, M00_EXC, M00_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_M10 ADD (
  CONSTRAINT RCMP_M10_PK
 PRIMARY KEY
 (M10_CEC_COD, M10_FIS_COD, M10_EXC, M10_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_M11 ADD (
  CONSTRAINT RCMP_M11_PK
 PRIMARY KEY
 (M11_CEC_COD, M11_FIS_COD, M11_EXC)
    USING INDEX 
    );

ALTER TABLE TCMP_M303IVADED ADD (
  CONSTRAINT RCMP_I303_PK
 PRIMARY KEY
 (I303_CEC_COD, I303_FIS_COD, I303_M00_EXC, I303_M00_PRD, I303_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_M303PRORRATA ADD (
  CONSTRAINT RCMP_P303_PK
 PRIMARY KEY
 (P303_CEC_COD, P303_FIS_COD, P303_M00_EXC, P303_M00_PRD, P303_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_M90 ADD (
  CONSTRAINT RCMP_M90_PK
 PRIMARY KEY
 (M90_FIS_COD, M90_CEC_COD, M90_EXC)
    USING INDEX 
    );

ALTER TABLE TCMP_M90IVADED ADD (
  CONSTRAINT RCMP_M90IVADED_PK
 PRIMARY KEY
 (I90_CEC_COD, I90_FIS_COD, I90_M90_EXC, I90_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_M90OAG ADD (
  CONSTRAINT RCMP_A90_PK
 PRIMARY KEY
 (A90_CEC_COD, A90_FIS_COD, A90_M90_EXC, A90_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_M90ORS ADD (
  CONSTRAINT RCMP_R90_PK
 PRIMARY KEY
 (R90_CEC_COD, R90_FIS_COD, R90_M90_EXC, R90_IAE_EPIGRAFE)
    USING INDEX 
    );

ALTER TABLE TCMP_M90P ADD (
  CONSTRAINT RCMP_P90_PK
 PRIMARY KEY
 (P90_CEC_COD, P90_FIS_COD, P90_M90_EXC, P90_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_M90_REPR ADD (
  CONSTRAINT RCMP_M390_PK
 PRIMARY KEY
 (E90_CEC_COD, E90_FIS_COD, E90_EXC, E90_REP_NIF)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD115 ADD (
  CONSTRAINT RCMP_M115_PK
 PRIMARY KEY
 (M115_CEC_COD, M115_FIS_COD, M115_EXC, M115_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD123 ADD (
  CONSTRAINT RCMP_M123_PK
 PRIMARY KEY
 (M123_CEC_COD, M123_FIS_COD, M123_EXC, M123_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD130 ADD (
  CONSTRAINT RCMP_M130_PK
 PRIMARY KEY
 (M130_CEC_COD, M130_FIS_COD, M130_EXC, M130_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD131 ADD (
  CONSTRAINT RCMP_M131_PK
 PRIMARY KEY
 (M131_CEC_COD, M131_FIS_COD, M131_EXC, M131_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD180_R1 ADD (
  CONSTRAINT RCMP_M180_R1_PK
 PRIMARY KEY
 (M81_CEC_COD, M81_FIS_COD, M81_EXC)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD180_R2 ADD (
  CONSTRAINT RCMP_MOD180_R2_PK
 PRIMARY KEY
 (M82_CEC_COD, M82_FIS_COD, M82_EXC, M82_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD180_R3 ADD (
  CONSTRAINT RCMP_M83_PK
 PRIMARY KEY
 (M83_CEC_COD, M83_FIS_COD, M83_M82_SEQ, M83_EXC, M83_MES)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD190_R1 ADD (
  CONSTRAINT RCMP_M190_R1_PK
 PRIMARY KEY
 (M91_CEC_COD, M91_FIS_COD, M91_EXC)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD190_R2 ADD (
  CONSTRAINT RCMP_M190_PK
 PRIMARY KEY
 (M92_CEC_COD, M92_FIS_COD, M92_EXC, M92_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD193 ADD (
  CONSTRAINT RCMP_M193_PK
 PRIMARY KEY
 (M193_CEC_COD, M193_FIS_COD, M193_EXC)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD193_GTO ADD (
  CONSTRAINT RCMP_M193G_PK
 PRIMARY KEY
 (M193G_CEC_COD, M193G_FIS_COD, M193G_EXC, M193G_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD193_PERC ADD (
  CONSTRAINT RCMP_M193P_PK
 PRIMARY KEY
 (M193P_CEC_COD, M193P_FIS_COD, M193P_EXC, M193P_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201 ADD (
  CONSTRAINT RCMP_M201_PK
 PRIMARY KEY
 (M201_CEC_COD, M201_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_ACCALT ADD (
  CONSTRAINT RCMP_M201ACA_PK
 PRIMARY KEY
 (ACA_CEC_COD, ACA_M201_NUM, ACA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_ACCPRO ADD (
  CONSTRAINT RCMP_M201ACE_PK
 PRIMARY KEY
 (ACE_CEC_COD, ACE_M201_NUM, ACE_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_ADMIN ADD (
  CONSTRAINT RCMP_M201ADM_PK
 PRIMARY KEY
 (ADM_CEC_COD, ADM_M201_NUM, ADM_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_DED ADD (
  CONSTRAINT RCMP_M201_DED_PK
 PRIMARY KEY
 (M201_DED_CEC_COD, M201_DED_TIP, M201_DED_NUM, M201_DED_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_OPEFIS ADD (
  CONSTRAINT RCMP_M201OPA_PK
 PRIMARY KEY
 (OPA_CEC_COD, OPA_M201_NUM, OPA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_PARAISOS ADD (
  CONSTRAINT RCMP_M201VPA_PK
 PRIMARY KEY
 (VPA_CEC_COD, VPA_M201_NUM, VPA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_R1 ADD (
  CONSTRAINT RCMP_M201_R1_PK
 PRIMARY KEY
 (M201_M201_CEC_COD, M201_M201_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_R2 ADD (
  CONSTRAINT RCMP_M201_R2_PK
 PRIMARY KEY
 (M201_M201_CEC_COD, M201_M201_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_R3 ADD (
  CONSTRAINT RCMP_M201_R3_PK
 PRIMARY KEY
 (M201_M201_CEC_COD, M201_M201_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_R4 ADD (
  CONSTRAINT RCMP_M201_R4_PK
 PRIMARY KEY
 (M201_M201_CEC_COD, M201_M201_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_REPR ADD (
  CONSTRAINT RCMP_M201REP_PK
 PRIMARY KEY
 (REP_CEC_COD, REP_M201_NUM, REP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_SOCIOS ADD (
  CONSTRAINT RCMP_M201_SOC_PK
 PRIMARY KEY
 (M201_SOC_CEC_COD, M201_SOC_NUM, M201_SOC_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD201_VINC ADD (
  CONSTRAINT RCMP_M201VIN_PK
 PRIMARY KEY
 (VIN_CEC_COD, VIN_M201_NUM, VIN_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD202 ADD (
  CONSTRAINT RCMP_M202_PK
 PRIMARY KEY
 (M202_CEC_COD, M202_FIS_COD, M202_EXC, M202_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD216 ADD (
  CONSTRAINT RCMP_M216_PK
 PRIMARY KEY
 (M216_CEC_COD, M216_FIS_COD, M216_EXC, M216_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD340 ADD (
  CONSTRAINT RCMP_M340_PK
 PRIMARY KEY
 (M340_CEC_COD, M340_FIS_COD, M340_EXC, M340_PRD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD340_R1 ADD (
  CONSTRAINT RCMP_M340R1_PK
 PRIMARY KEY
 (M3401_CEC_COD, M3401_FIS_COD, M3401_EXC, M3401_PRD, M3401_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD349_R1 ADD (
  CONSTRAINT RCMP_M3491_PK
 PRIMARY KEY
 (M349_CEC_COD, M349_EXC, M349_PRD, M349_FIS_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_MOD349_R2 ADD (
  CONSTRAINT RCMP_M3492_PK
 PRIMARY KEY
 (M3492_CEC_COD, M3492_FIS_COD, M3492_EXC, M3492_PRD, M3492_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_OPERFISCALS ADD (
  CONSTRAINT RCMP_OPA_PK
 PRIMARY KEY
 (OPA_CEC_COD, OPA_FIS_COD, OPA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_REPRESENTANS ADD (
  CONSTRAINT RCMP_REP_PK
 PRIMARY KEY
 (REP_CEC_COD, REP_FIS_COD, REP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_SCO ADD (
  CONSTRAINT RCMP_SCO_PK
 PRIMARY KEY
 (SCO_CEC_COD, SCO_EMP_COD, SCO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_V00 ADD (
  CONSTRAINT RCMP_V00_PK
 PRIMARY KEY
 (V00_CEC_COD, V00_FIS_COD, V00_M00_EXC, V00_M00_PRD, V00_DMO_MDL, V00_DMO_GRP, V00_DMO_COD, V00_PTE)
    USING INDEX 
    );

ALTER TABLE TCMP_V10 ADD (
  CONSTRAINT RCMP_V10_PK
 PRIMARY KEY
 (V10_CEC_COD, V10_FIS_COD, V10_M10_EXC, V10_M10_PRD, V10_DMO_MDL, V10_DMO_GRP, V10_DMO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_V11 ADD (
  CONSTRAINT RCMP_V11_PK
 PRIMARY KEY
 (V11_CEC_COD, V11_FIS_COD, V11_M11_EXC, V11_DMO_MDL, V11_DMO_GRP, V11_DMO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_VALPARAISOS ADD (
  CONSTRAINT RCMP_VPA_PK
 PRIMARY KEY
 (VPA_CEC_COD, VPA_FIS_CODI, VPA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_347OPH ADD (
  CONSTRAINT RCMP_OPH_PK
 PRIMARY KEY
 (OPH_CEC_COD, OPH_EMP_COD, OPH_CLASSE, OPH_CLIPRO, OPH_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ACCIONSALTRES ADD (
  CONSTRAINT RCMP_ACA_PK
 PRIMARY KEY
 (ACA_CEC_COD, ACA_FIS_COD, ACA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ACCIONSPROPIES ADD (
  CONSTRAINT RCMP_ACE_PK
 PRIMARY KEY
 (ACE_CEC_COD, ACE_FIS_COD, ACE_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ACTIVITATS ADD (
  CONSTRAINT RCMP_ACT_PK
 PRIMARY KEY
 (ACT_CEC_COD, ACT_FIS_COD, ACT_IAE_EPIGRAFE, ACT_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ADMINISTRADORS ADD (
  CONSTRAINT RCMP_ADM_PK
 PRIMARY KEY
 (ADM_CEC_COD, ADM_FIS_COD, ADM_NIF_NIF, ADM_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ANUALSIMPSOCI ADD (
  CONSTRAINT RCMP_AIS_PK
 PRIMARY KEY
 (AIS_CEC_COD, AIS_FIS_COD, AIS_ANY)
    USING INDEX 
    );

ALTER TABLE TCMP_BFI ADD (
  CONSTRAINT RCMP_BFI_PK
 PRIMARY KEY
 (BFI_CEC_COD, BFI_FIS_COD, BFI_BAN, BFI_OFI, BFI_CCR)
    USING INDEX 
    );

ALTER TABLE TCMP_COMPTES1 ADD (
  CONSTRAINT RCMP_CT1_PK
 PRIMARY KEY
 (CT1_CEC_COD, CT1_EMP_COD, CT1_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_COMPTES2 ADD (
  CONSTRAINT RCMP_CT2_PK
 PRIMARY KEY
 (CT2_CEC_COD, CT2_EMP_COD, CT2_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_COMPTES3 ADD (
  CONSTRAINT RCMP_CT3_PK
 PRIMARY KEY
 (CT3_CEC_COD, CT3_EMP_COD, CT3_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_COMPTES4 ADD (
  CONSTRAINT RCMP_CT4_PK
 PRIMARY KEY
 (CT4_CEC_COD, CT4_EMP_COD, CT4_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_COMPTES5 ADD (
  CONSTRAINT RCMP_CT5_PK
 PRIMARY KEY
 (CT5_CEC_COD, CT5_EMP_COD, CT5_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_CONMODIRPFS ADD (
  CONSTRAINT RCMP_CMR_PK
 PRIMARY KEY
 (CMR_CEC_COD, CMR_FIS_COD, CMR_IAE_EPIGRAFE, CMR_ANY, CMR_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_CONMODIVAS ADD (
  CONSTRAINT RCMP_CMI_PK
 PRIMARY KEY
 (CMI_CEC_COD, CMI_FIS_COD, CMI_IAE_EPIGRAFE, CMI_ANY, CMI_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DADESCLIPROS ADD (
  CONSTRAINT RCMP_DCP_PK
 PRIMARY KEY
 (DCP_CEC_COD, DCP_EMP_COD, DCP_CT5_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DEL ADD (
  CONSTRAINT RCMP_TCMP_DEL_PK
 PRIMARY KEY
 (DEL_CEC_COD, DEL_EMP_COD, DEL_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPARTAMENTS ADD (
  CONSTRAINT RCMP_DEP_PK
 PRIMARY KEY
 (DEP_CEC_COD, DEP_EMP_COD, DEP_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPCTA ADD (
  CONSTRAINT RCMP_DCT_PK
 PRIMARY KEY
 (DCT_CEC_COD, DCT_FIS_COD, DCT_EXC, DCT_TIP)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPCTA08 ADD (
  CONSTRAINT RCMP_DC8_PK
 PRIMARY KEY
 (DC8_CEC_COD, DC8_FIS_COD, DC8_EXC, DC8_COD, DC8_TIP)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPPRO ADD (
  CONSTRAINT RCMP_DPJ_PK
 PRIMARY KEY
 (DPJ_CEC_COD, DPJ_PRO_COD, DPJ_EMP_COD, DPJ_DEP_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPPROCT5 ADD (
  CONSTRAINT RCMP_DPR_PK
 PRIMARY KEY
 (DPR_CEC_COD, DPR_EMP_COD, DPR_CT5_COD, DPR_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DIARIS ADD (
  CONSTRAINT RCMP_DIA_PK
 PRIMARY KEY
 (DIA_CEC_COD, DIA_EMP_COD, DIA_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DSC ADD (
  CONSTRAINT RCMP_DSC_PK
 PRIMARY KEY
 (DSC_CEC_COD, DSC_EMP_COD, DSC_CT5_COD, DSC_CEC_CODDTI, DSC_EMP_CODDTI, DSC_CT5_CODDTI, DSC_DIA_CODDTI)
    USING INDEX 
    );

ALTER TABLE TCMP_EGR ADD (
  CONSTRAINT RCMP_EGR_PK
 PRIMARY KEY
 (EGR_AGE_COD, EGR_CEC_COD, EGR_EMP_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_LEA ADD (
  CONSTRAINT RCMP_LEA_PK
 PRIMARY KEY
 (LEA_CEC_COD, LEA_EMP_COD, LEA_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_LLOGUERS ADD (
  CONSTRAINT RCMP_LLO_PK
 PRIMARY KEY
 (LLO_CEC_COD, LLO_EMP_COD, LLO_CT5_COD, LLO_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_M390DSG ADD (
  CONSTRAINT RCMP_M390DSG_PK
 PRIMARY KEY
 (M90D_CEC_COD, M90D_FIS_COD, M90D_M90_EXC, M90D_DMO_GRP, M90D_DMO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_MODEMPIVA ADD (
  CONSTRAINT RCMP_MEI_PK
 PRIMARY KEY
 (MEI_CEC_COD, MEI_FIS_COD, MEI_IAE_EPIGRAFE, MEI_CMI_ANY, MEI_CMI_SEQ, MEI_MIV_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_MODIRPFEMP ADD (
  CONSTRAINT RCMP_MPF_PK
 PRIMARY KEY
 (MPF_CEC_COD, MPF_FIS_COD, MPF_IAE_EPIGRAFE, MPF_CMR_ANY, MPF_CMR_SEQ, MPF_MIR_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_PARTITRANS ADD (
  CONSTRAINT RCMP_TRA_PK
 PRIMARY KEY
 (TRA_CEC_COD, TRA_FIS_COD, TRA_ACE_SEQ, TRA_ANY)
    USING INDEX 
    );

ALTER TABLE TCMP_PRESUDESGLOSES_ANUAL ADD (
  CONSTRAINT RCMP_PDA_PK
 PRIMARY KEY
 (PDA_CEC_COD, PDA_EMP_COD, PDA_CT5_COD, PDA_PRE_ANY, PDA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_PRESUPOSTS ADD (
  CONSTRAINT RCMP_PRE_PK
 PRIMARY KEY
 (PRE_CEC_COD, PRE_EMP_COD, PRE_CT5_COD, PRE_ANY, PRE_MES)
    USING INDEX 
    );

ALTER TABLE TCMP_PROJECTEDIARI ADD (
  CONSTRAINT RCMP_PDI_PK
 PRIMARY KEY
 (PDI_CEC_COD, PDI_EMP_COD, PDI_DIA_COD, PDI_PRO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_RETENCIONS ADD (
  CONSTRAINT RCMP_RET_PK
 PRIMARY KEY
 (RET_CEC_COD, RET_EMP_COD, RET_CT5_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_RSC ADD (
  CONSTRAINT RCMP_RSC_PK
 PRIMARY KEY
 (RSC_CEC_COD, RSC_EMP_COD, RSC_DIA_COD, RSC_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_RST ADD (
  CONSTRAINT RCMP_RST_PK
 PRIMARY KEY
 (RST_CEC_COD, RST_EMP_COD, RST_CT5_COD, RST_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_SER ADD (
  CONSTRAINT RCMP_SER_PK
 PRIMARY KEY
 (SER_CEC_COD, SER_EMP_COD, SER_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_VALORSNEGO ADD (
  CONSTRAINT RCMP_VAL_PK
 PRIMARY KEY
 (VAL_CEC_COD, VAL_EMP_COD, VAL_CT5_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_VENCIMENTS ADD (
  CONSTRAINT RCMP_VEN_PK
 PRIMARY KEY
 (VEN_CEC_COD, VEN_EMP_COD, VEN_DIA_COD, VEN_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_347ARRE ADD (
  CONSTRAINT RCMP_ARR_PK
 PRIMARY KEY
 (ARR_CEC_COD, ARR_EMP_COD, ARR_CLASSE, ARR_CLIPRO, ARR_OPH_SEQ, ARR_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_ADJ ADD (
  CONSTRAINT RCMP_ADJ_PK
 PRIMARY KEY
 (ADJ_CEC_COD, ADJ_EMP_COD, ADJ_DIA_COD, ADJ_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ADP ADD (
  CONSTRAINT RCMP_ADP_PK
 PRIMARY KEY
 (ADP_CEC_COD, ADP_EMP_COD, ADP_DIA_COD, ADP_ADJ_SEQ, ADP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_AMORTIZACIONS ADD (
  CONSTRAINT RCMP_AMO_PK
 PRIMARY KEY
 (AMO_CEC_COD, AMO_EMP_COD, AMO_CT5_COD, AMO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_BANCS ADD (
  CONSTRAINT RCMP_BAN_PK
 PRIMARY KEY
 (BAN_CEC_COD, BAN_EMP_COD, BAN_CT5_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_CRV ADD (
  CONSTRAINT RCMP_CRV_PK
 PRIMARY KEY
 (CRV_CEC_COD, CRV_EMP_COD, CRV_DIA_COD, CRV_RSC_SEQ, CRV_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_CTABAN ADD (
  CONSTRAINT RCMP_CTB_PK
 PRIMARY KEY
 (CTB_CEC_COD, CTB_EMP_COD, CTB_CT5_COD, CTB_BAN, CTB_OFI, CTB_CCR)
    USING INDEX 
    );

ALTER TABLE TCMP_DAM ADD (
  CONSTRAINT RCMP_DAM_PK
 PRIMARY KEY
 (DAM_CEC_COD, DAM_EMP_COD, DAM_CT5_COD, DAM_AMO_COD, DAM_ANYMES, DAM_ANY, DAM_MES)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPPROVEN ADD (
  CONSTRAINT RCMP_DVE_PK
 PRIMARY KEY
 (DVE_CEC_COD, DVE_EMP_COD, DVE_DIA_COD, DVE_VEN_NUMVEN, DVE_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DIARIEXERCICI ADD (
  CONSTRAINT RCMP_DEX_PK
 PRIMARY KEY
 (DEX_CEC_COD, DEX_EMP_COD, DEX_EJE_COD, DEX_DIA_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_DIS ADD (
  CONSTRAINT RCMP_DIS_PK
 PRIMARY KEY
 (DIS_CEC_COD, DIS_EMP_COD, DIS_LEA_COD, DIS_DIA)
    USING INDEX 
    );

ALTER TABLE TCMP_ECE ADD (
  CONSTRAINT RCMP_ECE_PK
 PRIMARY KEY
 (ECE_AGE_COD, ECE_CEC_COD, ECE_EMP_COD, ECE_CTA)
    USING INDEX 
    );

ALTER TABLE TCMP_ELE ADD (
  CONSTRAINT RCMP_ELE_PK
 PRIMARY KEY
 (ELE_CEC_COD, ELE_EMP_COD, ELE_LEA_COD, ELE_SEQ)
    USING INDEX 
    ,
  CONSTRAINT RCMP_ELE_UK
 UNIQUE (ELE_CEC_COD, ELE_EMP_COD, ELE_LEA_COD, ELE_CT5_COD, ELE_AMO_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_EMA ADD (
  CONSTRAINT RCMP_EMA_PK
 PRIMARY KEY
 (EMA_CEC_COD, EMA_ACV_COD, EMA_ICV_COD, EMA_CAV_SEQ, EMA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_INTERESOS ADD (
  CONSTRAINT RCMP_INT_PK
 PRIMARY KEY
 (INT_CT5_COD, INT_CEC_COD, INT_EMP_COD, INT_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_LST ADD (
  CONSTRAINT RCMP_LST_PK
 PRIMARY KEY
 (LST_CEC_COD, LST_EMP_COD, LST_CT5_COD, LST_RST_COD, LST_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_MILLORES ADD (
  CONSTRAINT RCMP_MLL_PK
 PRIMARY KEY
 (MLL_CEC_COD, MLL_EMP_COD, MLL_AMO_CT5_COD, MLL_AMO_COD, MLL_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_PRESUDESGLOSES ADD (
  CONSTRAINT RCMP_PDE_PK
 PRIMARY KEY
 (PDE_CEC_COD, PDE_EMP_COD, PDE_CT5_COD, PDE_PRE_ANY, PDE_PRE_MES, PDE_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_REB ADD (
  CONSTRAINT RCMP_REB_PK
 PRIMARY KEY
 (REB_CEC_COD, REB_EMP_COD, REB_DIA_COD, REB_SER_COD, REB_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_TMP_ASI ADD (
  CONSTRAINT RCMP_TMP_ASI_PK
 PRIMARY KEY
 (AST_CEC_COD, AST_EMP_COD, AST_EJE_COD, AST_DIA_COD, AST_NUMASI)
    USING INDEX 
    );

ALTER TABLE TCMP_VCP ADD (
  CONSTRAINT RCMP_VCP_PK
 PRIMARY KEY
 (VCP_CEC_COD, VCP_EMP_COD, VCP_DIA_COD, VCP_VEN_SEQ, VCP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ACUMULATS ADD (
  CONSTRAINT RCMP_ACU_PK
 PRIMARY KEY
 (ACU_CEC_COD, ACU_EMP_COD, ACU_CT5_COD, ACU_EJE_COD, ACU_DIA_COD, ACU_ANY)
    USING INDEX 
    );

ALTER TABLE TCMP_ASIENTOS ADD (
  CONSTRAINT RCMP_ASI_PK
 PRIMARY KEY
 (ASI_CEC_COD, ASI_EMP_COD, ASI_EJE_COD, ASI_DIA_COD, ASI_NUMASI)
    USING INDEX 
    );

ALTER TABLE TCMP_DAMMLL ADD (
  CONSTRAINT RCMP_DAML_PK
 PRIMARY KEY
 (DAM_CEC_COD, DAM_EMP_COD, DAM_CT5_COD, DAM_AMO_COD, DAM_MLL_SEQ, DAM_ANYMES, DAM_ANY, DAM_MES)
    USING INDEX 
    );

ALTER TABLE TCMP_FPV ADD (
  CONSTRAINT RCMP_FPV_PK
 PRIMARY KEY
 (FPV_CEC_COD, FPV_EMP_COD, FPV_DIA_COD, FPV_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_LRE ADD (
  CONSTRAINT RCMP_LRE_PK
 PRIMARY KEY
 (LRE_REB_NUM, LRE_CEC_COD, LRE_EMP_COD, LRE_DIA_COD, LRE_SER_COD, LRE_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_QUO ADD (
  CONSTRAINT RCMP_QUO_PK
 PRIMARY KEY
 (QUO_CEC_COD, QUO_EMP_COD, QUO_LEA_COD, QUO_NUM)
    USING INDEX 
    );

ALTER TABLE TCMP_RFP ADD (
  CONSTRAINT RCMP_RFP_PK
 PRIMARY KEY
 (RFP_CEC_COD, RFP_EMP_COD, RFP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_SII ADD (
  CONSTRAINT RCMP_SII_PK
 PRIMARY KEY
 (SII_CEC_COD, SII_EMP_COD, SII_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_TMP_APU ADD (
  CONSTRAINT RCMP_TMP_APU_PK
 PRIMARY KEY
 (APT_CEC_COD, APT_EMP_COD, APT_EJE_COD, APT_DIA_COD, APT_AST_NUMASI, APT_NUMAPU)
    USING INDEX 
    );

ALTER TABLE TCMP_VEP ADD (
  CONSTRAINT RCMP_VEP_PK
 PRIMARY KEY
 (VEP_CEC_COD, VEP_EMP_COD, VEP_DIA_COD, VEP_FPV_SEQ, VEP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_APUNTS ADD (
  CONSTRAINT RCMP_APU_PK
 PRIMARY KEY
 (APU_CEC_COD, APU_EMP_COD, APU_EJE_COD, APU_DIA_COD, APU_ASI_NUMASI, APU_NUMAPU)
    USING INDEX 
    );

ALTER TABLE TCMP_APUNT_COBPAG ADD (
  CONSTRAINT RCMP_ACP_PK
 PRIMARY KEY
 (ACP_CEC_COD, ACP_EMP_COD, ACP_EJE_COD, ACP_DIA_COD, ACP_ASI_NUMASI, ACP_APU_NUMAPU, ACP_VEN_SEQ, ACP_VCP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_APUNT_VENCIMENT ADD (
  CONSTRAINT RCMP_AVE_PK
 PRIMARY KEY
 (AVE_CEC_COD, AVE_EMP_COD, AVE_EJE_COD, AVE_DIA_COD, AVE_ASI_NUMASI, AVE_APU_NUMAPU, AVE_VEN_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DEPPROCOM ADD (
  CONSTRAINT RCMP_DCO_PK
 PRIMARY KEY
 (DCO_CEC_COD, DCO_EMP_COD, DCO_EJE_COD, DCO_DIA_COD, DCO_ASI_NUMASI, DCO_APU_NUMAPU, DCO_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_DESGLOSEAPUNT ADD (
  CONSTRAINT RCMP_DAP_PK
 PRIMARY KEY
 (DAP_CEC_COD, DAP_EMP_COD, DAP_EJE_COD, DAP_DIA_COD, DAP_ASI_NUMASI, DAP_APU_NUMAPU, DAP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_EFA ADD (
  CONSTRAINT RCMP_EFA_PK
 PRIMARY KEY
 (EFA_CEC_COD, EFA_EMP_COD, EFA_DIA_COD, EFA_FPV_SEQ, EFA_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_FDP ADD (
  CONSTRAINT RCMP_FDP_PK
 PRIMARY KEY
 (FDP_CEC_COD, FDP_EMP_COD, FDP_DIA_COD, FDP_FPV_SEQ, FDP_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_FIV ADD (
  CONSTRAINT RCMP_FIV_PK
 PRIMARY KEY
 (FIV_CEC_COD, FIV_DIA_COD, FIV_EMP_COD, FIV_FPV_SEQ, FIV_IVA_COD)
    USING INDEX 
    );

ALTER TABLE TCMP_SID ADD (
  CONSTRAINT RCMP_SID_PK
 PRIMARY KEY
 (SID_CEC_COD, SID_EMP_COD, SID_SII_SEQ, SID_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_SIF ADD (
  CONSTRAINT RCMP_SIF_PK
 PRIMARY KEY
 (SIF_CEC_COD, SIF_EMP_COD, SIF_SII_SEQ, SIF_TIP, SIF_SEQ)
    USING INDEX 
    );

ALTER TABLE TCMP_ACO ADD (
  CONSTRAINT RCMP_ACO_PK
 PRIMARY KEY
 (ACO_CEC_COD, ACO_EMP_COD, ACO_EJE_COD, ACO_DIA_COD, ACO_ASI_NUMASI, ACO_APU_NUMAPU)
    USING INDEX 
    );

ALTER TABLE TCMP_APUFAC ADD (
  CONSTRAINT RCMP_APF_PK
 PRIMARY KEY
 (APF_CEC_COD, APF_EMP_COD, APF_EJE_COD, APF_DIA_COD, APF_ASI_NUMASI, APF_APU_NUMAPU, APF_EJE_CODIVA, APF_ASI_NUMASIIVA, APF_APU_NUMAPUIVA)
    USING INDEX 
    );

ALTER TABLE TCMP_ACASA_FACTURES_IVA ADD (
  CONSTRAINT RCMP_ACASA_IVA_FAC_FK 
 FOREIGN KEY (IVA_CEC_COD, IVA_EMP_COD, IVA_EJE_COD, IVA_DIA_COD, IVA_ASI_NUMASI) 
 REFERENCES TCMP_ACASA_FACTURES (FAC_CEC_COD,FAC_EMP_COD,FAC_EJE_COD,FAC_DIA_COD,FAC_ASI_NUMASI));

ALTER TABLE TCMP_ACASA_FACTURES_PRO ADD (
  CONSTRAINT RCMP_ACASA_PRO_FAC_FK 
 FOREIGN KEY (PRO_CEC_COD, PRO_EMP_COD, PRO_EJE_COD, PRO_DIA_COD, PRO_ASI_NUMASI) 
 REFERENCES TCMP_ACASA_FACTURES (FAC_CEC_COD,FAC_EMP_COD,FAC_EJE_COD,FAC_DIA_COD,FAC_ASI_NUMASI));

ALTER TABLE TCMP_CLV ADD (
  CONSTRAINT RCMP_CLV_CEC_FK 
 FOREIGN KEY (CLV_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_CNAES ADD (
  CONSTRAINT RCMP_CNA_CEC_FK 
 FOREIGN KEY (CNA_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_CONCEPTES ADD (
  CONSTRAINT RCMP_CON_CEC_FK 
 FOREIGN KEY (CON_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_DELETE ADD (
  CONSTRAINT RCMP_DEL_CEC_FK 
 FOREIGN KEY (DEL_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_DMO ADD (
  CONSTRAINT RCMP_DMO_CEC_FK 
 FOREIGN KEY (DMO_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_DPG ADD (
  CONSTRAINT RCMP_DPG_CEC_FK 
 FOREIGN KEY (DPG_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_EST ADD (
  CONSTRAINT RCMP_EST_CEC_FK 
 FOREIGN KEY (EST_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_FPA ADD (
  CONSTRAINT RCMP_FPA_CEC_FK 
 FOREIGN KEY (FPA_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_GRUPS ADD (
  CONSTRAINT RCMP_GRP_CEC_FK 
 FOREIGN KEY (GRP_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_HISENDES ADD (
  CONSTRAINT RCMP_HIS_CEC_FK 
 FOREIGN KEY (HIS_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_IAES ADD (
  CONSTRAINT RCMP_IAE_CEC_FK 
 FOREIGN KEY (IAE_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_ICV ADD (
  CONSTRAINT RCMP_ICV_CEC_FK 
 FOREIGN KEY (ICV_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_IMPRESSIONS ADD (
  CONSTRAINT RCMP_IMP_CEC_FK 
 FOREIGN KEY (IMP_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_INFORMES ADD (
  CONSTRAINT RCMP_INF_CEC_FK 
 FOREIGN KEY (INF_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_INFORMES_BMP ADD (
  CONSTRAINT RCMP_INB_CEC_FK 
 FOREIGN KEY (INB_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_LINIES_DINAMIC ADD (
  CONSTRAINT RCMP_LDI_DIN_FK 
 FOREIGN KEY (LDI_DIN_COD) 
 REFERENCES TCMP_DINAMICS (DIN_COD));

ALTER TABLE TCMP_LINIES_IMPRESSIO ADD (
  CONSTRAINT RCMP_LIM_IMP_FK 
 FOREIGN KEY (LIM_CEC_COD, LIM_IMP_COD) 
 REFERENCES TCMP_IMPRESSIONS (IMP_CEC_COD,IMP_COD));

ALTER TABLE TCMP_LINIES_INFORME ADD (
  CONSTRAINT RCMP_LIN_INF_FK 
 FOREIGN KEY (LIN_CEC_COD, LIN_INF_COD) 
 REFERENCES TCMP_INFORMES (INF_CEC_COD,INF_COD));

ALTER TABLE TCMP_LINIES_INFORME_BMP ADD (
  CONSTRAINT RCMP_LIB_INB_FK 
 FOREIGN KEY (LIB_CEC_COD, LIB_INB_COD) 
 REFERENCES TCMP_INFORMES_BMP (INB_CEC_COD,INB_COD));

ALTER TABLE TCMP_LSTTAN ADD (
  CONSTRAINT RCMP_TAN_CEC_FK 
 FOREIGN KEY (TAN_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_MOD347_R1 ADD (
  CONSTRAINT RCMP_M3471_M347_FK 
 FOREIGN KEY (M3471_CEC_COD, M3471_EMP_COD, M3471_EXC) 
 REFERENCES TCMP_MOD347 (M347_CEC_COD,M347_EMP_COD,M347_EXC));

ALTER TABLE TCMP_MOD347_R2 ADD (
  CONSTRAINT RCMP_M3472_M3471_FK 
 FOREIGN KEY (M3472_CEC_COD, M3472_EMP_COD, M3472_EXC, M3472_M3471_SEQ) 
 REFERENCES TCMP_MOD347_R1 (M3471_CEC_COD,M3471_EMP_COD,M3471_EXC,M3471_SEQ));

ALTER TABLE TCMP_MONEDES ADD (
  CONSTRAINT RCMP_MON_CEC_FK 
 FOREIGN KEY (MON_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_N43_FINCTA ADD (
  CONSTRAINT RCMP_FIN_CAB_FK 
 FOREIGN KEY (FIN_CEC_COD, FIN_EMP_COD, FIN_CAB_SEQ) 
 REFERENCES TCMP_N43_CABCTA (CAB_CEC_COD,CAB_EMP_COD,CAB_SEQ));

ALTER TABLE TCMP_N43_IMPAPU ADD (
  CONSTRAINT RCMP_IAP_CAB_FK 
 FOREIGN KEY (IAP_CEC_COD, IAP_EMP_COD, IAP_CAB_SEQ) 
 REFERENCES TCMP_N43_CABCTA (CAB_CEC_COD,CAB_EMP_COD,CAB_SEQ));

ALTER TABLE TCMP_N43_PPLMOV ADD (
  CONSTRAINT RCMP_MOV_CAB_FK 
 FOREIGN KEY (MOV_CEC_COD, MOV_EMP_COD, MOV_CAB_SEQ) 
 REFERENCES TCMP_N43_CABCTA (CAB_CEC_COD,CAB_EMP_COD,CAB_SEQ));

ALTER TABLE TCMP_OBLIGACIONS ADD (
  CONSTRAINT RCMP_OBL_CEC_FK 
 FOREIGN KEY (OBL_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_OPERACIONS ADD (
  CONSTRAINT RCMP_OPE_LIN_FK 
 FOREIGN KEY (OPE_INF_COD, OPE_CEC_COD, OPE_LIN_COD) 
 REFERENCES TCMP_LINIES_INFORME (LIN_INF_COD,LIN_CEC_COD,LIN_COD));

ALTER TABLE TCMP_OPERACIONS_BMP ADD (
  CONSTRAINT RCMP_OPB_LIB_FK 
 FOREIGN KEY (OPB_CEC_COD, OPB_INB_COD, OPB_LIB_COD) 
 REFERENCES TCMP_LINIES_INFORME_BMP (LIB_CEC_COD,LIB_INB_COD,LIB_COD));

ALTER TABLE TCMP_PAISOS ADD (
  CONSTRAINT RCMP_PAI_CEC_FK 
 FOREIGN KEY (PAI_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_PARAMETRES ADD (
  CONSTRAINT RCMP_PAR_CEC_FK 
 FOREIGN KEY (PAR_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_PRESENTA ADD (
  CONSTRAINT RCMP_PRS_CEC_FK 
 FOREIGN KEY (PRS_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_PRESUDESGLOSES_ANUAL002 ADD (
  CONSTRAINT RCMP_PDA002_HPR_FK 
 FOREIGN KEY (PDA_CEC_COD, PDA_EMP_COD, PDA_HPR_COD) 
 REFERENCES TCMP_HPR (HPR_CEC_COD,HPR_EMP_COD,HPR_COD));

ALTER TABLE TCMP_PRESUPOSTS002 ADD (
  CONSTRAINT RCMP_PRE002_HPR_FK 
 FOREIGN KEY (PRE_CEC_COD, PRE_EMP_COD, PRE_HPR_COD) 
 REFERENCES TCMP_HPR (HPR_CEC_COD,HPR_EMP_COD,HPR_COD));

ALTER TABLE TCMP_PROJECTES ADD (
  CONSTRAINT RCMP_PRO_CEC_FK 
 FOREIGN KEY (PRO_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_PRO_MON_FK 
 FOREIGN KEY (PRO_CEC_COD, PRO_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_PROVINCIES ADD (
  CONSTRAINT RCMP_PRV_CEC_FK 
 FOREIGN KEY (PRV_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_PRV_PAI_FK 
 FOREIGN KEY (PRV_CEC_COD, PRV_PAI_COD) 
 REFERENCES TCMP_PAISOS (PAI_CEC_COD,PAI_COD));

ALTER TABLE TCMP_SELVEN002 ADD (
  CONSTRAINT RCMP_SLV002_SLV001_FK 
 FOREIGN KEY (SLV002_CEC_COD, SLV002_EMP_COD, SLV002_SLV_SEQ) 
 REFERENCES TCMP_SELVEN001 (SLV_CEC_COD,SLV_EMP_COD,SLV_SEQ));

ALTER TABLE TCMP_TCO ADD (
  CONSTRAINT RCMP_TCO_CEC_FK 
 FOREIGN KEY (TCO_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_TIPUSASIENTOS ADD (
  CONSTRAINT RCMP_TAS_CEC_FK 
 FOREIGN KEY (TAS_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_TOC ADD (
  CONSTRAINT RCMP_TOC_CEC_FK 
 FOREIGN KEY (TOC_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_TVE ADD (
  CONSTRAINT RCMP_TVE_CEC_FK 
 FOREIGN KEY (TVE_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_UBI ADD (
  CONSTRAINT RCMP_UBI_CEC_FK 
 FOREIGN KEY (UBI_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_USUARISGRUPS ADD (
  CONSTRAINT RCMP_UGR_GRP_FK 
 FOREIGN KEY (UGR_CEC_COD, UGR_GRP_COD) 
 REFERENCES TCMP_GRUPS (GRP_CEC_COD,GRP_COD));

ALTER TABLE TCMP_347ARRE_HIST ADD (
  CONSTRAINT RCMP_ARRH_OPHH_FK 
 FOREIGN KEY (ARR_CEC_COD, ARR_EMP_COD, ARR_CLASSE, ARR_CLIPRO, ARR_OPH_SEQ, ARR_OPH_EJE) 
 REFERENCES TCMP_347OPH_HIST (OPH_CEC_COD,OPH_EMP_COD,OPH_CLASSE,OPH_CLIPRO,OPH_SEQ,OPH_EJE));

ALTER TABLE TCMP_ACV ADD (
  CONSTRAINT RCMP_ACV_ACV_FK 
 FOREIGN KEY (ACV_CEC_COD, ACV_ICV_COD, ACV_ACV_COD) 
 REFERENCES TCMP_ACV (ACV_CEC_COD,ACV_ICV_COD,ACV_COD),
  CONSTRAINT RCMP_ACV_ICV_FK 
 FOREIGN KEY (ACV_CEC_COD, ACV_ICV_COD) 
 REFERENCES TCMP_ICV (ICV_CEC_COD,ICV_COD));

ALTER TABLE TCMP_APJ ADD (
  CONSTRAINT RCMP_APJ_CEC_FK 
 FOREIGN KEY (APJ_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_ASP ADD (
  CONSTRAINT RCMP_ASP_CEC_FK 
 FOREIGN KEY (ASP_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_ASP_TAS_FK 
 FOREIGN KEY (ASP_CEC_COD, ASP_TAS_COD) 
 REFERENCES TCMP_TIPUSASIENTOS (TAS_CEC_COD,TAS_COD));

ALTER TABLE TCMP_CAMPS ADD (
  CONSTRAINT RCMP_CAM_LIM_FK 
 FOREIGN KEY (CAM_CEC_COD, CAM_IMP_COD, CAM_LIM_NUM) 
 REFERENCES TCMP_LINIES_IMPRESSIO (LIM_CEC_COD,LIM_IMP_COD,LIM_NUM));

ALTER TABLE TCMP_CAV ADD (
  CONSTRAINT RCMP_CAV_ACV002_FK 
 FOREIGN KEY (CAV_CEC_COD, CAV_ICV_COD, CAV_ACV_COD002) 
 REFERENCES TCMP_ACV (ACV_CEC_COD,ACV_ICV_COD,ACV_COD),
  CONSTRAINT RCMP_CAV_ACV_FK 
 FOREIGN KEY (CAV_CEC_COD, CAV_ICV_COD, CAV_ACV_COD) 
 REFERENCES TCMP_ACV (ACV_CEC_COD,ACV_ICV_COD,ACV_COD),
  CONSTRAINT RCMP_CAV_CLV_FK 
 FOREIGN KEY (CAV_CEC_COD, CAV_CLV_COD) 
 REFERENCES TCMP_CLV (CLV_CEC_COD,CLV_COD));

ALTER TABLE TCMP_CLASEIVAS ADD (
  CONSTRAINT RCMP_CIV_CEC_FK 
 FOREIGN KEY (CIV_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD));

ALTER TABLE TCMP_DPP ADD (
  CONSTRAINT RCMP_DPP_ASP_FK 
 FOREIGN KEY (DPP_ASP_COD, DPP_CEC_COD) 
 REFERENCES TCMP_ASP (ASP_COD,ASP_CEC_COD),
  CONSTRAINT RCMP_DPP_PRO_FK 
 FOREIGN KEY (DPP_CEC_COD, DPP_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_HVD ADD (
  CONSTRAINT RCMP_HVD_MON_FK 
 FOREIGN KEY (HVD_CEC_COD, HVD_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_IVAS ADD (
  CONSTRAINT RCMP_IVA_CEC_FK 
 FOREIGN KEY (IVA_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_IVA_CIV_FK 
 FOREIGN KEY (IVA_CEC_COD, IVA_CIV_COD) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD));

ALTER TABLE TCMP_MODULSIRPF ADD (
  CONSTRAINT RCMP_MIR_IAE_FK 
 FOREIGN KEY (MIR_CEC_COD, MIR_IAE_EPIGRAFE) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_MIR_MON_FK 
 FOREIGN KEY (MIR_CEC_COD, MIR_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_MODULSIVA ADD (
  CONSTRAINT RCMP_MIV_IAE_FK 
 FOREIGN KEY (MIV_CEC_COD, MIV_IAE_EPIGRAFE) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_MIV_MON_FK 
 FOREIGN KEY (MIV_CEC_COD, MIV_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_N43_CPLCON ADD (
  CONSTRAINT RCMP_N43CON_CAB_FK 
 FOREIGN KEY (CON_CEC_COD, CON_EMP_COD, CON_CAB_SEQ, CON_MOV_SEQ) 
 REFERENCES TCMP_N43_PPLMOV (MOV_CEC_COD,MOV_EMP_COD,MOV_CAB_SEQ,MOV_SEQ));

ALTER TABLE TCMP_PJA ADD (
  CONSTRAINT RCMP_PJA_APJ_FK 
 FOREIGN KEY (PJA_CEC_COD, PJA_APJ_COD) 
 REFERENCES TCMP_APJ (APJ_CEC_COD,APJ_COD),
  CONSTRAINT RCMP_PJA_PRO_FK 
 FOREIGN KEY (PJA_CEC_COD, PJA_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_POBLACIONS ADD (
  CONSTRAINT RCMP_POB_CEC_FK 
 FOREIGN KEY (POB_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_POB_PRV_FK 
 FOREIGN KEY (POB_CEC_COD, POB_PRV_COD) 
 REFERENCES TCMP_PROVINCIES (PRV_CEC_COD,PRV_COD));

ALTER TABLE TCMP_PRESUDESGLOSES002 ADD (
  CONSTRAINT RCMP_PDE002_PRE002_FK 
 FOREIGN KEY (PDE_CEC_COD, PDE_EMP_COD, PDE_HPR_COD, PDE_CT5_COD, PDE_PRE_ANY, PDE_PRE_MES) 
 REFERENCES TCMP_PRESUPOSTS002 (PRE_CEC_COD,PRE_EMP_COD,PRE_HPR_COD,PRE_CT5_COD,PRE_ANY,PRE_MES));

ALTER TABLE TLVR_DATOS ADD (
  CONSTRAINT RLVR_DEC_CAM_FK 
 FOREIGN KEY (DAT_CAM_NUM) 
 REFERENCES TLVR_CAMPOS (CAM_NUM),
  CONSTRAINT RLVR_DEC_DEC_FK 
 FOREIGN KEY (DAT_DEC_NUM) 
 REFERENCES TLVR_DECLAR (DEC_NUM));

ALTER TABLE TCMP_APP ADD (
  CONSTRAINT RCMP_APP_ASP_FK 
 FOREIGN KEY (APP_ASP_COD, APP_CEC_COD) 
 REFERENCES TCMP_ASP (ASP_COD,ASP_CEC_COD),
  CONSTRAINT RCMP_APP_CIV_FK 
 FOREIGN KEY (APP_CEC_COD, APP_CIV_COD) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_APP_IVA_FK 
 FOREIGN KEY (APP_CEC_COD, APP_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_APP_MON_FK 
 FOREIGN KEY (APP_CEC_COD, APP_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_CTESREGIVA ADD (
  CONSTRAINT RCMP_CRI_CIV_FK 
 FOREIGN KEY (CRI_CEC_COD, CRI_CIV_COD) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_CRI_IVA_FK 
 FOREIGN KEY (CRI_CEC_COD, CRI_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD));

ALTER TABLE TCMP_FBA ADD (
  CONSTRAINT RCMP_FBA_IVA_FK 
 FOREIGN KEY (FBA_CEC_COD, FBA_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_FBA_RFA_FK 
 FOREIGN KEY (FBA_CEC_COD, FBA_EMP_COD, FBA_DIA_COD, FBA_RFA_NUMRGT, FBA_RFA_ANY) 
 REFERENCES TCMP_RFA (RFA_CEC_COD,RFA_EMP_COD,RFA_DIA_COD,RFA_NUMRGT,RFA_ANY));

ALTER TABLE TCMP_MIR_ICP ADD (
  CONSTRAINT RCMP_ICP_MIR_FK 
 FOREIGN KEY (ICP_CEC_COD, ICP_IAE_EPIGRAFE, ICP_MIR_SEQ) 
 REFERENCES TCMP_MODULSIRPF (MIR_CEC_COD,MIR_IAE_EPIGRAFE,MIR_SEQ));

ALTER TABLE TCMP_NIFS ADD (
  CONSTRAINT RCMP_NIF_CEC_FK 
 FOREIGN KEY (NIF_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_NIF_POB_FK 
 FOREIGN KEY (NIF_CEC_COD, NIF_POB_COD) 
 REFERENCES TCMP_POBLACIONS (POB_CEC_COD,POB_COD));

ALTER TABLE TCMP_EMPRESAFIS ADD (
  CONSTRAINT RCMP_FIS_CEC_FK 
 FOREIGN KEY (FIS_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_FIS_CNA_FK 
 FOREIGN KEY (FIS_CEC_COD, FIS_CNA_COD) 
 REFERENCES TCMP_CNAES (CNA_CEC_COD,CNA_COD),
  CONSTRAINT RCMP_FIS_HIS_FK 
 FOREIGN KEY (FIS_CEC_COD, FIS_HIS_COD) 
 REFERENCES TCMP_HISENDES (HIS_CEC_COD,HIS_COD),
  CONSTRAINT RCMP_FIS_MONDEF_FK 
 FOREIGN KEY (FIS_CEC_COD, FIS_MON_CODDEF) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_FIS_MON_FK 
 FOREIGN KEY (FIS_CEC_COD, FIS_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_FIS_NIF_FK 
 FOREIGN KEY (FIS_CEC_COD, FIS_NIF_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF),
  CONSTRAINT RCMP_FIS_NIF_RPR_FK 
 FOREIGN KEY (FIS_CEC_COD, FIS_NIF_NIFRPR) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF));

ALTER TABLE TCMP_EMPRESAX ADD (
  CONSTRAINT RCMP_EMX_FIS_FK 
 FOREIGN KEY (EMX_CEC_COD, EMX_EMP_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_EMPRESES ADD (
  CONSTRAINT RCMP_EMP_CEC_FK 
 FOREIGN KEY (EMP_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_EMP_FIS_FK 
 FOREIGN KEY (EMP_CEC_COD, EMP_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_EMP_MON_FK 
 FOREIGN KEY (EMP_CEC_COD, EMP_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_EMP_NIF_FK 
 FOREIGN KEY (EMP_CEC_COD, EMP_NIF_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF),
  CONSTRAINT RCMP_EMP_TAS_FK 
 FOREIGN KEY (EMP_CEC_COD, EMP_TAS_COD) 
 REFERENCES TCMP_TIPUSASIENTOS (TAS_CEC_COD,TAS_COD));

ALTER TABLE TCMP_EMPRE_OBLIGACIONS ADD (
  CONSTRAINT RCMP_FIS_OBL_FIS_FK 
 FOREIGN KEY (FOB_CEC_COD, FOB_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_FIS_OBL_OBL_FK 
 FOREIGN KEY (FOB_CEC_COD, FOB_OBL_COD) 
 REFERENCES TCMP_OBLIGACIONS (OBL_CEC_COD,OBL_COD));

ALTER TABLE TCMP_EXD ADD (
  CONSTRAINT RCMP_EXD_EMP_FK 
 FOREIGN KEY (EXD_CEC_COD, EXD_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD),
  CONSTRAINT RCMP_EXD_TCO_FK 
 FOREIGN KEY (EXD_CEC_COD, EXD_TCO_COD) 
 REFERENCES TCMP_TCO (TCO_CEC_COD,TCO_COD),
  CONSTRAINT RCMP_EXD_TOC_FK 
 FOREIGN KEY (EXD_CEC_COD, EXD_TOC_COD) 
 REFERENCES TCMP_TOC (TOC_CEC_COD,TOC_COD));

ALTER TABLE TCMP_EXERCICIS ADD (
  CONSTRAINT RCMP_EJE_EMP_FK 
 FOREIGN KEY (EJE_CEC_COD, EJE_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD),
  CONSTRAINT RCMP_EJE_MON_FK 
 FOREIGN KEY (EJE_CEC_COD, EJE_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_GRUPSEMPRESES ADD (
  CONSTRAINT RCMP_GEM_EMP_FK 
 FOREIGN KEY (GEM_EMP_CEC_COD, GEM_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD),
  CONSTRAINT RCMP_GEM_GRP_FK 
 FOREIGN KEY (GEM_EMP_CEC_COD, GEM_GRP_COD) 
 REFERENCES TCMP_GRUPS (GRP_CEC_COD,GRP_COD));

ALTER TABLE TCMP_M00 ADD (
  CONSTRAINT RCMP_M00_FIS_FK 
 FOREIGN KEY (M00_CEC_COD, M00_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_M00_MON_FK 
 FOREIGN KEY (M00_CEC_COD, M00_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_M10 ADD (
  CONSTRAINT RCMP_M10_FIS_FK 
 FOREIGN KEY (M10_CEC_COD, M10_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_M10_IAE001_FK 
 FOREIGN KEY (M10_CEC_COD, M10_IAE_EPIGRAFE001) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M10_IAE002_FK 
 FOREIGN KEY (M10_CEC_COD, M10_IAE_EPIGRAFE002) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M10_IAE003_FK 
 FOREIGN KEY (M10_CEC_COD, M10_IAE_EPIGRAFE003) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M10_IAE004_FK 
 FOREIGN KEY (M10_CEC_COD, M10_IAE_EPIGRAFE004) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M10_IAE005_FK 
 FOREIGN KEY (M10_CEC_COD, M10_IAE_EPIGRAFE005) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M10_MON_FK 
 FOREIGN KEY (M10_CEC_COD, M10_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_M11 ADD (
  CONSTRAINT RCMP_M11_FIS_FK 
 FOREIGN KEY (M11_CEC_COD, M11_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_M11_IAE001_FK 
 FOREIGN KEY (M11_CEC_COD, M11_IAE_EPIGRAFE001) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M11_IAE002_FK 
 FOREIGN KEY (M11_CEC_COD, M11_IAE_EPIGRAFE002) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M11_IAE003_FK 
 FOREIGN KEY (M11_CEC_COD, M11_IAE_EPIGRAFE003) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M11_IAE004_FK 
 FOREIGN KEY (M11_CEC_COD, M11_IAE_EPIGRAFE004) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M11_IAE005_FK 
 FOREIGN KEY (M11_CEC_COD, M11_IAE_EPIGRAFE005) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M11_MON_FK 
 FOREIGN KEY (M11_CEC_COD, M11_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_M303IVADED ADD (
  CONSTRAINT RCMP_I303_M00_FK 
 FOREIGN KEY (I303_CEC_COD, I303_FIS_COD, I303_M00_EXC, I303_M00_PRD) 
 REFERENCES TCMP_M00 (M00_CEC_COD,M00_FIS_COD,M00_EXC,M00_PRD));

ALTER TABLE TCMP_M303PRORRATA ADD (
  CONSTRAINT RCMP_P303_M00_FK 
 FOREIGN KEY (P303_CEC_COD, P303_FIS_COD, P303_M00_EXC, P303_M00_PRD) 
 REFERENCES TCMP_M00 (M00_CEC_COD,M00_FIS_COD,M00_EXC,M00_PRD));

ALTER TABLE TCMP_M90 ADD (
  CONSTRAINT RCMP_M90_FIS_FK 
 FOREIGN KEY (M90_CEC_COD, M90_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_M90_IAE1_FK 
 FOREIGN KEY (M90_CEC_COD, M90_IAE_EPIGRAFE1) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M90_IAE2_FK 
 FOREIGN KEY (M90_CEC_COD, M90_IAE_EPIGRAFE2) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M90_IAE3_FK 
 FOREIGN KEY (M90_CEC_COD, M90_IAE_EPIGRAFE3) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M90_IAE4_FK 
 FOREIGN KEY (M90_CEC_COD, M90_IAE_EPIGRAFE4) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M90_IAE5_FK 
 FOREIGN KEY (M90_CEC_COD, M90_IAE_EPIGRAFE5) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M90_IAE6_FK 
 FOREIGN KEY (M90_CEC_COD, M90_IAE_EPIGRAFE6) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_M90_MON_FK 
 FOREIGN KEY (M90_CEC_COD, M90_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_M90IVADED ADD (
  CONSTRAINT RCMP_M90IVADED_M90_FK 
 FOREIGN KEY (I90_FIS_COD, I90_CEC_COD, I90_M90_EXC) 
 REFERENCES TCMP_M90 (M90_FIS_COD,M90_CEC_COD,M90_EXC));

ALTER TABLE TCMP_M90OAG ADD (
  CONSTRAINT RCMP_A90_M90_FK 
 FOREIGN KEY (A90_FIS_COD, A90_CEC_COD, A90_M90_EXC) 
 REFERENCES TCMP_M90 (M90_FIS_COD,M90_CEC_COD,M90_EXC));

ALTER TABLE TCMP_M90ORS ADD (
  CONSTRAINT RCMP_R90_IAE_FK 
 FOREIGN KEY (R90_CEC_COD, R90_IAE_EPIGRAFE) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_R90_M90_FK 
 FOREIGN KEY (R90_FIS_COD, R90_CEC_COD, R90_M90_EXC) 
 REFERENCES TCMP_M90 (M90_FIS_COD,M90_CEC_COD,M90_EXC));

ALTER TABLE TCMP_M90P ADD (
  CONSTRAINT RCMP_P90_M90_FK 
 FOREIGN KEY (P90_FIS_COD, P90_CEC_COD, P90_M90_EXC) 
 REFERENCES TCMP_M90 (M90_FIS_COD,M90_CEC_COD,M90_EXC));

ALTER TABLE TCMP_M90_REPR ADD (
  CONSTRAINT RCMP_M390_M90_FK 
 FOREIGN KEY (E90_FIS_COD, E90_CEC_COD, E90_EXC) 
 REFERENCES TCMP_M90 (M90_FIS_COD,M90_CEC_COD,M90_EXC),
  CONSTRAINT RCMP_M390_NIF_FK 
 FOREIGN KEY (E90_CEC_COD, E90_REP_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF));

ALTER TABLE TCMP_MOD110 ADD (
  CONSTRAINT RCMP_M110_FIS_FK 
 FOREIGN KEY (M110_CEC_COD, M110_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD115 ADD (
  CONSTRAINT RCMP_M115_FIS_FK 
 FOREIGN KEY (M115_CEC_COD, M115_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD123 ADD (
  CONSTRAINT RCMP_M123_FIS_FK 
 FOREIGN KEY (M123_CEC_COD, M123_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD130 ADD (
  CONSTRAINT RCMP_M130_FIS_FK 
 FOREIGN KEY (M130_CEC_COD, M130_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD131 ADD (
  CONSTRAINT RCMP_M131_FIS_FK 
 FOREIGN KEY (M131_CEC_COD, M131_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD180_R1 ADD (
  CONSTRAINT RCMP_M180_R1_FK 
 FOREIGN KEY (M81_CEC_COD, M81_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD180_R2 ADD (
  CONSTRAINT RCMP_MOD180_R2_FK 
 FOREIGN KEY (M82_CEC_COD, M82_FIS_COD, M82_EXC) 
 REFERENCES TCMP_MOD180_R1 (M81_CEC_COD,M81_FIS_COD,M81_EXC));

ALTER TABLE TCMP_MOD180_R3 ADD (
  CONSTRAINT RCMP_M83_M82_FK 
 FOREIGN KEY (M83_CEC_COD, M83_FIS_COD, M83_EXC, M83_M82_SEQ) 
 REFERENCES TCMP_MOD180_R2 (M82_CEC_COD,M82_FIS_COD,M82_EXC,M82_SEQ));

ALTER TABLE TCMP_MOD190_R1 ADD (
  CONSTRAINT RCMP_M91_FIS_FK 
 FOREIGN KEY (M91_CEC_COD, M91_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD190_R2 ADD (
  CONSTRAINT RCMP_M190_R2_FK 
 FOREIGN KEY (M92_CEC_COD, M92_FIS_COD, M92_EXC) 
 REFERENCES TCMP_MOD190_R1 (M91_CEC_COD,M91_FIS_COD,M91_EXC));

ALTER TABLE TCMP_MOD193 ADD (
  CONSTRAINT RCMP_M193_FIS_FK 
 FOREIGN KEY (M193_CEC_COD, M193_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD193_GTO ADD (
  CONSTRAINT RCMP_MOD193G_M193_FK 
 FOREIGN KEY (M193G_CEC_COD, M193G_FIS_COD, M193G_EXC) 
 REFERENCES TCMP_MOD193 (M193_CEC_COD,M193_FIS_COD,M193_EXC));

ALTER TABLE TCMP_MOD193_PERC ADD (
  CONSTRAINT RCMP_MOD193_FK 
 FOREIGN KEY (M193P_CEC_COD, M193P_FIS_COD, M193P_EXC) 
 REFERENCES TCMP_MOD193 (M193_CEC_COD,M193_FIS_COD,M193_EXC));

ALTER TABLE TCMP_MOD201 ADD (
  CONSTRAINT RCMP_M201_CEC_FK 
 FOREIGN KEY (M201_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_M201_FIS_FK 
 FOREIGN KEY (M201_CEC_COD, M201_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD201_ACCALT ADD (
  CONSTRAINT RCMP_ACA_M201_FK 
 FOREIGN KEY (ACA_CEC_COD, ACA_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_ACCPRO ADD (
  CONSTRAINT RCMP_ACE_M201_FK 
 FOREIGN KEY (ACE_CEC_COD, ACE_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_ADMIN ADD (
  CONSTRAINT RCMP_ADM_M201_FK 
 FOREIGN KEY (ADM_CEC_COD, ADM_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_DED ADD (
  CONSTRAINT RCMP_M201_DED_FK 
 FOREIGN KEY (M201_DED_CEC_COD, M201_DED_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_OPEFIS ADD (
  CONSTRAINT RCMP_OPA_M201_FK 
 FOREIGN KEY (OPA_CEC_COD, OPA_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_PARAISOS ADD (
  CONSTRAINT RCMP_VPA_M201_FK 
 FOREIGN KEY (VPA_CEC_COD, VPA_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_R1 ADD (
  CONSTRAINT RCMP_M201_R1_FK 
 FOREIGN KEY (M201_M201_CEC_COD, M201_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_R2 ADD (
  CONSTRAINT RCMP_M201_R2_FK 
 FOREIGN KEY (M201_M201_CEC_COD, M201_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_R3 ADD (
  CONSTRAINT RCMP_M201_R3_FK 
 FOREIGN KEY (M201_M201_CEC_COD, M201_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_R4 ADD (
  CONSTRAINT RCMP_M201_R4_FK 
 FOREIGN KEY (M201_M201_CEC_COD, M201_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_REPR ADD (
  CONSTRAINT RCMP_REP_M201_FK 
 FOREIGN KEY (REP_CEC_COD, REP_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_SOCIOS ADD (
  CONSTRAINT RCMP_M201_SOC_FK 
 FOREIGN KEY (M201_SOC_CEC_COD, M201_SOC_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD201_VINC ADD (
  CONSTRAINT RCMP_M201VIN_M201_FK 
 FOREIGN KEY (VIN_CEC_COD, VIN_M201_NUM) 
 REFERENCES TCMP_MOD201 (M201_CEC_COD,M201_NUM));

ALTER TABLE TCMP_MOD202 ADD (
  CONSTRAINT RCMP_M202_FIS_FK 
 FOREIGN KEY (M202_CEC_COD, M202_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD216 ADD (
  CONSTRAINT RCMP_M216_FIS_FK 
 FOREIGN KEY (M216_CEC_COD, M216_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD340 ADD (
  CONSTRAINT RCMP_M340_FIS_FK 
 FOREIGN KEY (M340_CEC_COD, M340_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD340_R1 ADD (
  CONSTRAINT RCMP_M340R1_FIS_FK 
 FOREIGN KEY (M3401_CEC_COD, M3401_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD349_R1 ADD (
  CONSTRAINT RCMP_M3491_FIS_FK 
 FOREIGN KEY (M349_CEC_COD, M349_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_MOD349_R2 ADD (
  CONSTRAINT RCMP_M3492_M3491_FK 
 FOREIGN KEY (M3492_CEC_COD, M3492_EXC, M3492_PRD, M3492_FIS_COD) 
 REFERENCES TCMP_MOD349_R1 (M349_CEC_COD,M349_EXC,M349_PRD,M349_FIS_COD));

ALTER TABLE TCMP_OPERFISCALS ADD (
  CONSTRAINT RCMP_OPA_FIS_FK 
 FOREIGN KEY (OPA_CEC_COD, OPA_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_OPA_MON_FK 
 FOREIGN KEY (OPA_CEC_COD, OPA_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_OPA_PAI_FK 
 FOREIGN KEY (OPA_CEC_COD, OPA_PAI_COD) 
 REFERENCES TCMP_PAISOS (PAI_CEC_COD,PAI_COD));

ALTER TABLE TCMP_REPRESENTANS ADD (
  CONSTRAINT RCMP_REP_FIS_FK 
 FOREIGN KEY (REP_CEC_COD, REP_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_REP_NIF_FK 
 FOREIGN KEY (REP_CEC_COD, REP_NIF_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF));

ALTER TABLE TCMP_SCO ADD (
  CONSTRAINT RCMP_SCO_EMP_FK 
 FOREIGN KEY (SCO_CEC_COD, SCO_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_V00 ADD (
  CONSTRAINT RCMP_V00_DMO_FK 
 FOREIGN KEY (V00_CEC_COD, V00_DMO_MDL, V00_DMO_GRP, V00_DMO_COD) 
 REFERENCES TCMP_DMO (DMO_CEC_COD,DMO_MDL,DMO_GRP,DMO_COD),
  CONSTRAINT RCMP_V00_M00_FK 
 FOREIGN KEY (V00_CEC_COD, V00_FIS_COD, V00_M00_EXC, V00_M00_PRD) 
 REFERENCES TCMP_M00 (M00_CEC_COD,M00_FIS_COD,M00_EXC,M00_PRD));

ALTER TABLE TCMP_V10 ADD (
  CONSTRAINT RCMP_V10_DMO_FK 
 FOREIGN KEY (V10_CEC_COD, V10_DMO_MDL, V10_DMO_GRP, V10_DMO_COD) 
 REFERENCES TCMP_DMO (DMO_CEC_COD,DMO_MDL,DMO_GRP,DMO_COD),
  CONSTRAINT RCMP_V10_M10_FK 
 FOREIGN KEY (V10_CEC_COD, V10_FIS_COD, V10_M10_EXC, V10_M10_PRD) 
 REFERENCES TCMP_M10 (M10_CEC_COD,M10_FIS_COD,M10_EXC,M10_PRD));

ALTER TABLE TCMP_V11 ADD (
  CONSTRAINT RCMP_V11_DMO_FK 
 FOREIGN KEY (V11_CEC_COD, V11_DMO_MDL, V11_DMO_GRP, V11_DMO_COD) 
 REFERENCES TCMP_DMO (DMO_CEC_COD,DMO_MDL,DMO_GRP,DMO_COD),
  CONSTRAINT RCMP_V11_M11_FK 
 FOREIGN KEY (V11_CEC_COD, V11_FIS_COD, V11_M11_EXC) 
 REFERENCES TCMP_M11 (M11_CEC_COD,M11_FIS_COD,M11_EXC));

ALTER TABLE TCMP_VALPARAISOS ADD (
  CONSTRAINT RCMP_VPA_FIS_FK 
 FOREIGN KEY (VPA_CEC_COD, VPA_FIS_CODI) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_VPA_MON_FK 
 FOREIGN KEY (VPA_CEC_COD, VPA_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_VPA_PAI_FK 
 FOREIGN KEY (VPA_CEC_COD, VPA_PAI_COD) 
 REFERENCES TCMP_PAISOS (PAI_CEC_COD,PAI_COD));

ALTER TABLE TCMP_347OPH ADD (
  CONSTRAINT RCMP_OPH_FIS_FK 
 FOREIGN KEY (OPH_CEC_COD, OPH_EMP_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_ACCIONSALTRES ADD (
  CONSTRAINT RCMP_ACA_FIS_FK 
 FOREIGN KEY (ACA_CEC_COD, ACA_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_ACA_MON_FK 
 FOREIGN KEY (ACA_CEC_COD, ACA_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_ACA_NIF_FK 
 FOREIGN KEY (ACA_CEC_COD, ACA_NIF_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF),
  CONSTRAINT RCMP_ACA_PRV_FK 
 FOREIGN KEY (ACA_CEC_COD, ACA_PRV_COD) 
 REFERENCES TCMP_PROVINCIES (PRV_CEC_COD,PRV_COD));

ALTER TABLE TCMP_ACCIONSPROPIES ADD (
  CONSTRAINT RCMP_ACE_FIS_FK 
 FOREIGN KEY (ACE_CEC_COD, ACE_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_ACE_MON_FK 
 FOREIGN KEY (ACE_CEC_COD, ACE_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_ACE_NIF_FK 
 FOREIGN KEY (ACE_CEC_COD, ACE_NIF_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF));

ALTER TABLE TCMP_ACTIVITATS ADD (
  CONSTRAINT RCMP_ACT_FIS_FK 
 FOREIGN KEY (ACT_CEC_COD, ACT_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_ACT_IAE_FK 
 FOREIGN KEY (ACT_CEC_COD, ACT_IAE_EPIGRAFE) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE),
  CONSTRAINT RCMP_ACT_POB_FK 
 FOREIGN KEY (ACT_CEC_COD, ACT_POB_COD) 
 REFERENCES TCMP_POBLACIONS (POB_CEC_COD,POB_COD),
  CONSTRAINT RCMP_ACT_PRV_FK 
 FOREIGN KEY (ACT_CEC_COD, ACT_PRV_COD) 
 REFERENCES TCMP_PROVINCIES (PRV_CEC_COD,PRV_COD));

ALTER TABLE TCMP_ADMINISTRADORS ADD (
  CONSTRAINT RCMP_ADM_FIS_FK 
 FOREIGN KEY (ADM_CEC_COD, ADM_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_ADM_NIF_FK 
 FOREIGN KEY (ADM_CEC_COD, ADM_NIF_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF),
  CONSTRAINT RCMP_ADM_PRV_FK 
 FOREIGN KEY (ADM_CEC_COD, ADM_PRV_COD) 
 REFERENCES TCMP_PROVINCIES (PRV_CEC_COD,PRV_COD));

ALTER TABLE TCMP_ANUALSIMPSOCI ADD (
  CONSTRAINT RCMP_AIS_FIS_FK 
 FOREIGN KEY (AIS_CEC_COD, AIS_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_BFI ADD (
  CONSTRAINT RCMP_BFI_FIS_FK 
 FOREIGN KEY (BFI_CEC_COD, BFI_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_COMPTES1 ADD (
  CONSTRAINT RCMP_CT1_EMP_FK 
 FOREIGN KEY (CT1_CEC_COD, CT1_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_COMPTES2 ADD (
  CONSTRAINT RCMP_CT2_CT1_FK 
 FOREIGN KEY (CT2_CEC_COD, CT2_EMP_COD, CT2_CT1_COD) 
 REFERENCES TCMP_COMPTES1 (CT1_CEC_COD,CT1_EMP_COD,CT1_COD),
  CONSTRAINT RCMP_CT2_EMP_FK 
 FOREIGN KEY (CT2_CEC_COD, CT2_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_COMPTES3 ADD (
  CONSTRAINT RCMP_CT3_CT2_FK 
 FOREIGN KEY (CT3_CEC_COD, CT3_EMP_COD, CT3_CT2_COD) 
 REFERENCES TCMP_COMPTES2 (CT2_CEC_COD,CT2_EMP_COD,CT2_COD),
  CONSTRAINT RCMP_CT3_EMP_FK 
 FOREIGN KEY (CT3_CEC_COD, CT3_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_COMPTES4 ADD (
  CONSTRAINT RCMP_CT4_CT3_FK 
 FOREIGN KEY (CT4_CEC_COD, CT4_EMP_COD, CT4_CT3_COD) 
 REFERENCES TCMP_COMPTES3 (CT3_CEC_COD,CT3_EMP_COD,CT3_COD),
  CONSTRAINT RCMP_CT4_EMP_FK 
 FOREIGN KEY (CT4_CEC_COD, CT4_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_COMPTES5 ADD (
  CONSTRAINT RCMP_CT5_CLV_FK 
 FOREIGN KEY (CT5_CEC_COD, CT5_CLV_COD) 
 REFERENCES TCMP_CLV (CLV_CEC_COD,CLV_COD),
  CONSTRAINT RCMP_CT5_CT4_FK 
 FOREIGN KEY (CT5_CEC_COD, CT5_EMP_COD, CT5_CT4_COD) 
 REFERENCES TCMP_COMPTES4 (CT4_CEC_COD,CT4_EMP_COD,CT4_COD),
  CONSTRAINT RCMP_CT5_EMP_FK 
 FOREIGN KEY (CT5_CEC_COD, CT5_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD),
  CONSTRAINT RCMP_CT5_FPA_FK 
 FOREIGN KEY (CT5_CEC_COD, CT5_FPA_COD) 
 REFERENCES TCMP_FPA (FPA_CEC_COD,FPA_COD),
  CONSTRAINT RCMP_CT5_MON_FK 
 FOREIGN KEY (CT5_CEC_COD, CT5_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_CT5_TVE_FK 
 FOREIGN KEY (CT5_CEC_COD, CT5_TVE_COD) 
 REFERENCES TCMP_TVE (TVE_CEC_COD,TVE_COD));

ALTER TABLE TCMP_CONMODIRPFS ADD (
  CONSTRAINT RCMP_CMR_FIS_FK 
 FOREIGN KEY (CMR_CEC_COD, CMR_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_CMR_IAE_FK 
 FOREIGN KEY (CMR_CEC_COD, CMR_IAE_EPIGRAFE) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE));

ALTER TABLE TCMP_CONMODIVAS ADD (
  CONSTRAINT RCMP_CMI_FIS_FK 
 FOREIGN KEY (CMI_CEC_COD, CMI_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD),
  CONSTRAINT RCMP_CMI_IAE_FK 
 FOREIGN KEY (CMI_CEC_COD, CMI_IAE_EPIGRAFE) 
 REFERENCES TCMP_IAES (IAE_CEC_COD,IAE_EPIGRAFE));

ALTER TABLE TCMP_DADESCLIPROS ADD (
  CONSTRAINT RCMP_DCP_CT5_FK 
 FOREIGN KEY (DCP_CEC_COD, DCP_EMP_COD, DCP_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_DCP_NIF_FK 
 FOREIGN KEY (DCP_CEC_COD, DCP_NIF_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF),
  CONSTRAINT RCMP_DCP_POB_FK 
 FOREIGN KEY (DCP_CEC_COD, DCP_POB_COD) 
 REFERENCES TCMP_POBLACIONS (POB_CEC_COD,POB_COD));

ALTER TABLE TCMP_DEL ADD (
  CONSTRAINT RCMP_DEL_EMP_FK 
 FOREIGN KEY (DEL_CEC_COD, DEL_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_DEPARTAMENTS ADD (
  CONSTRAINT RCMP_DEP_EMP_FK 
 FOREIGN KEY (DEP_CEC_COD, DEP_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_DEPCTA ADD (
  CONSTRAINT RCMP_DCT_CEC_FK 
 FOREIGN KEY (DCT_CEC_COD) 
 REFERENCES TCMP_CLICECO (CEC_COD),
  CONSTRAINT RCMP_DCT_FIS_FK 
 FOREIGN KEY (DCT_CEC_COD, DCT_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_DEPCTA08 ADD (
  CONSTRAINT RCMP_DC8_FIS_FK 
 FOREIGN KEY (DC8_CEC_COD, DC8_FIS_COD) 
 REFERENCES TCMP_EMPRESAFIS (FIS_CEC_COD,FIS_COD));

ALTER TABLE TCMP_DEPPRO ADD (
  CONSTRAINT RCMP_DPJ_DEP_FK 
 FOREIGN KEY (DPJ_CEC_COD, DPJ_EMP_COD, DPJ_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_DPJ_PRO_FK 
 FOREIGN KEY (DPJ_CEC_COD, DPJ_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_DEPPROCT5 ADD (
  CONSTRAINT RCMP_DPR_CT5_FK 
 FOREIGN KEY (DPR_CEC_COD, DPR_EMP_COD, DPR_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_DPR_DEP_FK 
 FOREIGN KEY (DPR_CEC_COD, DPR_EMP_COD, DPR_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_DPR_PRO_FK 
 FOREIGN KEY (DPR_CEC_COD, DPR_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_DIARIS ADD (
  CONSTRAINT RCMP_DIA_EMP_FK 
 FOREIGN KEY (DIA_CEC_COD, DIA_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_DSC ADD (
  CONSTRAINT RCMP_DSC_CT5DTI_FK 
 FOREIGN KEY (DSC_CEC_CODDTI, DSC_EMP_CODDTI, DSC_CT5_CODDTI) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_DSC_CT5_FK 
 FOREIGN KEY (DSC_CEC_COD, DSC_EMP_COD, DSC_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_DSC_DIA_FK 
 FOREIGN KEY (DSC_CEC_CODDTI, DSC_EMP_CODDTI, DSC_DIA_CODDTI) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD));

ALTER TABLE TCMP_EGR ADD (
  CONSTRAINT RCMP_EGR_AGE_FK 
 FOREIGN KEY (EGR_AGE_COD) 
 REFERENCES TCMP_AGE (AGE_COD),
  CONSTRAINT RCMP_EGR_EMP_FK 
 FOREIGN KEY (EGR_CEC_COD, EGR_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD));

ALTER TABLE TCMP_LEA ADD (
  CONSTRAINT RCMP_LEA_DIA_FK 
 FOREIGN KEY (LEA_CEC_COD, LEA_EMP_COD, LEA_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_LEA_EMP_FK 
 FOREIGN KEY (LEA_CEC_COD, LEA_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD),
  CONSTRAINT RCMP_LEA_IVA_FK 
 FOREIGN KEY (LEA_CEC_COD, LEA_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD));

ALTER TABLE TCMP_LLOGUERS ADD (
  CONSTRAINT RCMP_LLO_CT5_FK 
 FOREIGN KEY (LLO_CEC_COD, LLO_EMP_COD, LLO_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_LLO_POB_FK 
 FOREIGN KEY (LLO_CEC_COD, LLO_POB_COD) 
 REFERENCES TCMP_POBLACIONS (POB_CEC_COD,POB_COD));

ALTER TABLE TCMP_M390DSG ADD (
  CONSTRAINT RCMP_M390DSG_DMO_FK 
 FOREIGN KEY (M90D_CEC_COD, M90D_DMO_MDL, M90D_DMO_GRP, M90D_DMO_COD) 
 REFERENCES TCMP_DMO (DMO_CEC_COD,DMO_MDL,DMO_GRP,DMO_COD),
  CONSTRAINT RCMP_M390DSG_M90_FK 
 FOREIGN KEY (M90D_FIS_COD, M90D_CEC_COD, M90D_M90_EXC) 
 REFERENCES TCMP_M90 (M90_FIS_COD,M90_CEC_COD,M90_EXC));

ALTER TABLE TCMP_MODEMPIVA ADD (
  CONSTRAINT RCMP_MEI_CMI_FK 
 FOREIGN KEY (MEI_CEC_COD, MEI_FIS_COD, MEI_IAE_EPIGRAFE, MEI_CMI_ANY, MEI_CMI_SEQ) 
 REFERENCES TCMP_CONMODIVAS (CMI_CEC_COD,CMI_FIS_COD,CMI_IAE_EPIGRAFE,CMI_ANY,CMI_SEQ),
  CONSTRAINT RCMP_MEI_MIV_FK 
 FOREIGN KEY (MEI_CEC_COD, MEI_IAE_EPIGRAFE, MEI_MIV_SEQ) 
 REFERENCES TCMP_MODULSIVA (MIV_CEC_COD,MIV_IAE_EPIGRAFE,MIV_SEQ));

ALTER TABLE TCMP_MODIRPFEMP ADD (
  CONSTRAINT RCMP_MPF_CMR_FK 
 FOREIGN KEY (MPF_CEC_COD, MPF_FIS_COD, MPF_IAE_EPIGRAFE, MPF_CMR_ANY, MPF_CMR_SEQ) 
 REFERENCES TCMP_CONMODIRPFS (CMR_CEC_COD,CMR_FIS_COD,CMR_IAE_EPIGRAFE,CMR_ANY,CMR_SEQ),
  CONSTRAINT RCMP_MPF_MIR_FK 
 FOREIGN KEY (MPF_CEC_COD, MPF_IAE_EPIGRAFE, MPF_MIR_SEQ) 
 REFERENCES TCMP_MODULSIRPF (MIR_CEC_COD,MIR_IAE_EPIGRAFE,MIR_SEQ));

ALTER TABLE TCMP_PARTITRANS ADD (
  CONSTRAINT RCMP_TRA_ACE_FK 
 FOREIGN KEY (TRA_CEC_COD, TRA_FIS_COD, TRA_ACE_SEQ) 
 REFERENCES TCMP_ACCIONSPROPIES (ACE_CEC_COD,ACE_FIS_COD,ACE_SEQ),
  CONSTRAINT RCMP_TRA_MON_FK 
 FOREIGN KEY (TRA_CEC_COD, TRA_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_PRESUDESGLOSES_ANUAL ADD (
  CONSTRAINT RCMP_PDA_DEP_FK 
 FOREIGN KEY (PDA_CEC_COD, PDA_EMP_COD, PDA_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_PDA_DIA_FK 
 FOREIGN KEY (PDA_CEC_COD, PDA_EMP_COD, PDA_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_PDA_PRO_FK 
 FOREIGN KEY (PDA_CEC_COD, PDA_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_PRESUPOSTS ADD (
  CONSTRAINT RCMP_PRE_CT5_FK 
 FOREIGN KEY (PRE_CEC_COD, PRE_EMP_COD, PRE_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_PRE_MON_FK 
 FOREIGN KEY (PRE_CEC_COD, PRE_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_PROJECTEDIARI ADD (
  CONSTRAINT RCMP_PDI_DIA_FK 
 FOREIGN KEY (PDI_CEC_COD, PDI_EMP_COD, PDI_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_PDI_PRO_FK 
 FOREIGN KEY (PDI_CEC_COD, PDI_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_RETENCIONS ADD (
  CONSTRAINT RCMP_RET_CT5_FK 
 FOREIGN KEY (RET_CEC_COD, RET_EMP_COD, RET_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_RET_NIF_FK 
 FOREIGN KEY (RET_CEC_COD, RET_NIF_NIF) 
 REFERENCES TCMP_NIFS (NIF_CEC_COD,NIF_NIF));

ALTER TABLE TCMP_RSC ADD (
  CONSTRAINT RCMP_RSC_CT5DSP_FK 
 FOREIGN KEY (RSC_CEC_COD, RSC_EMP_COD, RSC_CT5_CODDSP) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_RSC_DEP_FK 
 FOREIGN KEY (RSC_CEC_COD, RSC_EMP_COD, RSC_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_RSC_DIA_FK 
 FOREIGN KEY (RSC_CEC_COD, RSC_EMP_COD, RSC_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_RSC_MON_FK 
 FOREIGN KEY (RSC_CEC_COD, RSC_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_RSC_PRO_FK 
 FOREIGN KEY (RSC_CEC_COD, RSC_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_RST ADD (
  CONSTRAINT RCMP_RST_CIV_FK 
 FOREIGN KEY (RST_CEC_COD, RST_CIV_COD) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_RST_CT5RET_FK 
 FOREIGN KEY (RST_CEC_COD, RST_EMP_COD, RST_CT5_CODRET) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_RST_CT5VTA_FK 
 FOREIGN KEY (RST_CEC_COD, RST_EMP_COD, RST_CT5_CODVEN) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_RST_CT5_FK 
 FOREIGN KEY (RST_CEC_COD, RST_EMP_COD, RST_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_RST_DIA_FK 
 FOREIGN KEY (RST_CEC_COD, RST_EMP_COD, RST_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_RST_MON_FK 
 FOREIGN KEY (RST_CEC_COD, RST_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_SER ADD (
  CONSTRAINT RCMP_SER_CT5RET_FK 
 FOREIGN KEY (SER_CEC_COD, SER_EMP_COD, SER_CT5_CODRET) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_SER_CT5VEN_FK 
 FOREIGN KEY (SER_CEC_COD, SER_EMP_COD, SER_CT5_CODVEN) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_SER_EMP_FK 
 FOREIGN KEY (SER_CEC_COD, SER_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD),
  CONSTRAINT RCMP_SER_TAS_FK 
 FOREIGN KEY (SER_CEC_COD, SER_TAS_COD) 
 REFERENCES TCMP_TIPUSASIENTOS (TAS_CEC_COD,TAS_COD));

ALTER TABLE TCMP_VALORSNEGO ADD (
  CONSTRAINT RCMP_VAL_CT5_FK 
 FOREIGN KEY (VAL_CEC_COD, VAL_EMP_COD, VAL_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD));

ALTER TABLE TCMP_VENCIMENTS ADD (
  CONSTRAINT RCMP_VEN_CIV_FK 
 FOREIGN KEY (VEN_CEC_COD, VEN_CIV_COD) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_VEN_CLV_FK 
 FOREIGN KEY (VEN_CEC_COD, VEN_CLV_COD) 
 REFERENCES TCMP_CLV (CLV_CEC_COD,CLV_COD),
  CONSTRAINT RCMP_VEN_CT5_FK 
 FOREIGN KEY (VEN_CEC_COD, VEN_EMP_COD, VEN_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_VEN_DIA_FK 
 FOREIGN KEY (VEN_CEC_COD, VEN_EMP_COD, VEN_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_VEN_IVA_FK 
 FOREIGN KEY (VEN_CEC_COD, VEN_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_VEN_MON_FK 
 FOREIGN KEY (VEN_CEC_COD, VEN_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_347ARRE ADD (
  CONSTRAINT RCMP_ARR_OPH_FK 
 FOREIGN KEY (ARR_CEC_COD, ARR_EMP_COD, ARR_CLASSE, ARR_CLIPRO, ARR_OPH_SEQ) 
 REFERENCES TCMP_347OPH (OPH_CEC_COD,OPH_EMP_COD,OPH_CLASSE,OPH_CLIPRO,OPH_SEQ));

ALTER TABLE TCMP_ADJ ADD (
  CONSTRAINT RCMP_ADJ_CT5DSP_FK 
 FOREIGN KEY (ADJ_CEC_COD, ADJ_EMP_COD, ADJ_CT5_CODDSP) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_ADJ_CT5_FK 
 FOREIGN KEY (ADJ_CEC_COD, ADJ_EMP_COD, ADJ_CT5_CODPRO) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_ADJ_DEP_FK 
 FOREIGN KEY (ADJ_CEC_COD, ADJ_EMP_COD, ADJ_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_ADJ_DIA_FK 
 FOREIGN KEY (ADJ_CEC_COD, ADJ_EMP_COD, ADJ_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_ADJ_IVA_FK 
 FOREIGN KEY (ADJ_CEC_COD, ADJ_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_ADJ_MON_FK 
 FOREIGN KEY (ADJ_CEC_COD, ADJ_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_ADJ_PRO_FK 
 FOREIGN KEY (ADJ_CEC_COD, ADJ_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD),
  CONSTRAINT RCMP_ADJ_RSC_FK 
 FOREIGN KEY (ADJ_CEC_COD, ADJ_EMP_COD, ADJ_DIA_COD, ADJ_RSC_SEQ) 
 REFERENCES TCMP_RSC (RSC_CEC_COD,RSC_EMP_COD,RSC_DIA_COD,RSC_SEQ));

ALTER TABLE TCMP_ADP ADD (
  CONSTRAINT RCMP_ADP_ADJ_FK 
 FOREIGN KEY (ADP_CEC_COD, ADP_EMP_COD, ADP_DIA_COD, ADP_ADJ_SEQ) 
 REFERENCES TCMP_ADJ (ADJ_CEC_COD,ADJ_EMP_COD,ADJ_DIA_COD,ADJ_SEQ),
  CONSTRAINT RCMP_ADP_CT5_FK 
 FOREIGN KEY (ADP_CEC_COD, ADP_EMP_COD, ADP_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_ADP_DEP_FK 
 FOREIGN KEY (ADP_CEC_COD, ADP_EMP_COD, ADP_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_ADP_PRO_FK 
 FOREIGN KEY (ADP_CEC_COD, ADP_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_AMORTIZACIONS ADD (
  CONSTRAINT RCMP_AMO_CT5DEB_FK 
 FOREIGN KEY (AMO_CEC_COD, AMO_EMP_COD, AMO_CT5_CODDEB) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_AMO_CT5HAB_FK 
 FOREIGN KEY (AMO_CEC_COD, AMO_EMP_COD, AMO_CT5_CODHAB) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_AMO_CT5_FK 
 FOREIGN KEY (AMO_CEC_COD, AMO_EMP_COD, AMO_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_AMO_UBI_FK 
 FOREIGN KEY (AMO_CEC_COD, AMO_UBI_COD) 
 REFERENCES TCMP_UBI (UBI_CEC_COD,UBI_COD));

ALTER TABLE TCMP_BANCS ADD (
  CONSTRAINT RCMP_BAN_CT5_FK 
 FOREIGN KEY (BAN_CEC_COD, BAN_EMP_COD, BAN_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD));

ALTER TABLE TCMP_CRV ADD (
  CONSTRAINT RCMP_CRV_CT5_FK 
 FOREIGN KEY (CRV_CEC_COD, CRV_EMP_COD, CRV_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_CRV_DEP_FK 
 FOREIGN KEY (CRV_CEC_COD, CRV_EMP_COD, CRV_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_CRV_PRO_FK 
 FOREIGN KEY (CRV_CEC_COD, CRV_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD),
  CONSTRAINT RCMP_CRV_RSC_FK 
 FOREIGN KEY (CRV_CEC_COD, CRV_EMP_COD, CRV_DIA_COD, CRV_RSC_SEQ) 
 REFERENCES TCMP_RSC (RSC_CEC_COD,RSC_EMP_COD,RSC_DIA_COD,RSC_SEQ));

ALTER TABLE TCMP_CTABAN ADD (
  CONSTRAINT RCMP_CTB_BAN_FK 
 FOREIGN KEY (CTB_CEC_COD, CTB_EMP_COD, CTB_CT5_COD) 
 REFERENCES TCMP_BANCS (BAN_CEC_COD,BAN_EMP_COD,BAN_CT5_COD));

ALTER TABLE TCMP_DAM ADD (
  CONSTRAINT RCMP_DAM_CT5DEB_FK 
 FOREIGN KEY (DAM_CEC_COD, DAM_EMP_COD, DAM_CT5_CODDEB) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_DAM_CT5HAB_FK 
 FOREIGN KEY (DAM_CEC_COD, DAM_EMP_COD, DAM_CT5_CODHAB) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_DAM_CT5_FK 
 FOREIGN KEY (DAM_CEC_COD, DAM_EMP_COD, DAM_CT5_COD, DAM_AMO_COD) 
 REFERENCES TCMP_AMORTIZACIONS (AMO_CEC_COD,AMO_EMP_COD,AMO_CT5_COD,AMO_COD));

ALTER TABLE TCMP_DEPPROVEN ADD (
  CONSTRAINT RCMP_DVE_DEP_FK 
 FOREIGN KEY (DVE_CEC_COD, DVE_EMP_COD, DVE_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_DVE_PRO_FK 
 FOREIGN KEY (DVE_CEC_COD, DVE_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD),
  CONSTRAINT RCMP_DVE_VEN_FK 
 FOREIGN KEY (DVE_CEC_COD, DVE_EMP_COD, DVE_DIA_COD, DVE_VEN_NUMVEN) 
 REFERENCES TCMP_VENCIMENTS (VEN_CEC_COD,VEN_EMP_COD,VEN_DIA_COD,VEN_SEQ));

ALTER TABLE TCMP_DIARIEXERCICI ADD (
  CONSTRAINT RCMP_DEX_DIA_FK 
 FOREIGN KEY (DEX_CEC_COD, DEX_EMP_COD, DEX_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_DEX_EJE_FK 
 FOREIGN KEY (DEX_CEC_COD, DEX_EMP_COD, DEX_EJE_COD) 
 REFERENCES TCMP_EXERCICIS (EJE_CEC_COD,EJE_EMP_COD,EJE_COD));

ALTER TABLE TCMP_DIS ADD (
  CONSTRAINT RCMP_DIS_LEA_FK 
 FOREIGN KEY (DIS_CEC_COD, DIS_EMP_COD, DIS_LEA_COD) 
 REFERENCES TCMP_LEA (LEA_CEC_COD,LEA_EMP_COD,LEA_COD));

ALTER TABLE TCMP_ECE ADD (
  CONSTRAINT RCMP_ECE_EGR_FK 
 FOREIGN KEY (ECE_AGE_COD, ECE_CEC_COD, ECE_EMP_COD) 
 REFERENCES TCMP_EGR (EGR_AGE_COD,EGR_CEC_COD,EGR_EMP_COD));

ALTER TABLE TCMP_ELE ADD (
  CONSTRAINT RCMP_ELE_AMO_FK 
 FOREIGN KEY (ELE_CEC_COD, ELE_EMP_COD, ELE_CT5_COD, ELE_AMO_COD) 
 REFERENCES TCMP_AMORTIZACIONS (AMO_CEC_COD,AMO_EMP_COD,AMO_CT5_COD,AMO_COD),
  CONSTRAINT RCMP_ELE_CT5_FK 
 FOREIGN KEY (ELE_CEC_COD, ELE_EMP_COD, ELE_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_ELE_LEA_FK 
 FOREIGN KEY (ELE_CEC_COD, ELE_EMP_COD, ELE_LEA_COD) 
 REFERENCES TCMP_LEA (LEA_CEC_COD,LEA_EMP_COD,LEA_COD));

ALTER TABLE TCMP_EMA ADD (
  CONSTRAINT RCMP_EMA_CAV_FK 
 FOREIGN KEY (EMA_CEC_COD, EMA_ICV_COD, EMA_ACV_COD, EMA_CAV_SEQ) 
 REFERENCES TCMP_CAV (CAV_CEC_COD,CAV_ICV_COD,CAV_ACV_COD,CAV_SEQ),
  CONSTRAINT RCMP_EMA_DEX_FK 
 FOREIGN KEY (EMA_CEC_COD, EMA_EMP_COD, EMA_EJE_COD, EMA_DIA_COD) 
 REFERENCES TCMP_DIARIEXERCICI (DEX_CEC_COD,DEX_EMP_COD,DEX_EJE_COD,DEX_DIA_COD));

ALTER TABLE TCMP_INTERESOS ADD (
  CONSTRAINT RCMP_INT_BAN_FK 
 FOREIGN KEY (INT_CEC_COD, INT_EMP_COD, INT_CT5_COD) 
 REFERENCES TCMP_BANCS (BAN_CEC_COD,BAN_EMP_COD,BAN_CT5_COD));

ALTER TABLE TCMP_LST ADD (
  CONSTRAINT RCMP_LST_CT5VEN_FK 
 FOREIGN KEY (LST_CEC_COD, LST_EMP_COD, LST_CT5_CODVEN) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_LST_IVA_FK 
 FOREIGN KEY (LST_CEC_COD, LST_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_LST_RST_FK 
 FOREIGN KEY (LST_CEC_COD, LST_EMP_COD, LST_CT5_COD, LST_RST_COD) 
 REFERENCES TCMP_RST (RST_CEC_COD,RST_EMP_COD,RST_CT5_COD,RST_COD));

ALTER TABLE TCMP_MILLORES ADD (
  CONSTRAINT RCMP_MLL_AMO_FK 
 FOREIGN KEY (MLL_CEC_COD, MLL_EMP_COD, MLL_AMO_CT5_COD, MLL_AMO_COD) 
 REFERENCES TCMP_AMORTIZACIONS (AMO_CEC_COD,AMO_EMP_COD,AMO_CT5_COD,AMO_COD));

ALTER TABLE TCMP_PRESUDESGLOSES ADD (
  CONSTRAINT RCMP_PDE_DEL_FK 
 FOREIGN KEY (PDE_CEC_COD, PDE_EMP_COD, PDE_DEL_COD) 
 REFERENCES TCMP_DEL (DEL_CEC_COD,DEL_EMP_COD,DEL_COD),
  CONSTRAINT RCMP_PDE_DEP_FK 
 FOREIGN KEY (PDE_CEC_COD, PDE_EMP_COD, PDE_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_PDE_DIA_FK 
 FOREIGN KEY (PDE_CEC_COD, PDE_EMP_COD, PDE_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_PDE_EXD_FK 
 FOREIGN KEY (PDE_CEC_COD, PDE_EMP_COD, PDE_EXD_COD) 
 REFERENCES TCMP_EXD (EXD_CEC_COD,EXD_EMP_COD,EXD_COD),
  CONSTRAINT RCMP_PDE_PRE_FK 
 FOREIGN KEY (PDE_CEC_COD, PDE_EMP_COD, PDE_CT5_COD, PDE_PRE_ANY, PDE_PRE_MES) 
 REFERENCES TCMP_PRESUPOSTS (PRE_CEC_COD,PRE_EMP_COD,PRE_CT5_COD,PRE_ANY,PRE_MES),
  CONSTRAINT RCMP_PDE_PRO_FK 
 FOREIGN KEY (PDE_CEC_COD, PDE_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_REB ADD (
  CONSTRAINT RCMP_REB_CIV_FK 
 FOREIGN KEY (REB_CEC_COD, REB_CIV_COD) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_REB_CT5_FK 
 FOREIGN KEY (REB_CEC_COD, REB_EMP_COD, REB_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_REB_DIA_FK 
 FOREIGN KEY (REB_CEC_COD, REB_EMP_COD, REB_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_REB_MON_FK 
 FOREIGN KEY (REB_CEC_COD, REB_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_REB_SER_FK 
 FOREIGN KEY (REB_CEC_COD, REB_EMP_COD, REB_SER_COD) 
 REFERENCES TCMP_SER (SER_CEC_COD,SER_EMP_COD,SER_COD));

ALTER TABLE TCMP_TMP_ASI ADD (
  CONSTRAINT RCMP_AST_DEX_FK 
 FOREIGN KEY (AST_CEC_COD, AST_EMP_COD, AST_EJE_COD, AST_DIA_COD) 
 REFERENCES TCMP_DIARIEXERCICI (DEX_CEC_COD,DEX_EMP_COD,DEX_EJE_COD,DEX_DIA_COD),
  CONSTRAINT RCMP_AST_TAS_FK 
 FOREIGN KEY (AST_CEC_COD, AST_TAS_COD) 
 REFERENCES TCMP_TIPUSASIENTOS (TAS_CEC_COD,TAS_COD));

ALTER TABLE TCMP_VCP ADD (
  CONSTRAINT RCMP_VCP_VEN_FK 
 FOREIGN KEY (VCP_CEC_COD, VCP_EMP_COD, VCP_DIA_COD, VCP_VEN_SEQ) 
 REFERENCES TCMP_VENCIMENTS (VEN_CEC_COD,VEN_EMP_COD,VEN_DIA_COD,VEN_SEQ));

ALTER TABLE TCMP_ACUMULATS ADD (
  CONSTRAINT RCMP_ACU_CT5_FK 
 FOREIGN KEY (ACU_CEC_COD, ACU_EMP_COD, ACU_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_ACU_DEX_FK 
 FOREIGN KEY (ACU_CEC_COD, ACU_EMP_COD, ACU_EJE_COD, ACU_DIA_COD) 
 REFERENCES TCMP_DIARIEXERCICI (DEX_CEC_COD,DEX_EMP_COD,DEX_EJE_COD,DEX_DIA_COD));

ALTER TABLE TCMP_ASIENTOS ADD (
  CONSTRAINT RCMP_ASI_DEX_FK 
 FOREIGN KEY (ASI_CEC_COD, ASI_EMP_COD, ASI_EJE_COD, ASI_DIA_COD) 
 REFERENCES TCMP_DIARIEXERCICI (DEX_CEC_COD,DEX_EMP_COD,DEX_EJE_COD,DEX_DIA_COD),
  CONSTRAINT RCMP_ASI_TAS_FK 
 FOREIGN KEY (ASI_CEC_COD, ASI_TAS_COD) 
 REFERENCES TCMP_TIPUSASIENTOS (TAS_CEC_COD,TAS_COD));

ALTER TABLE TCMP_DAMMLL ADD (
  CONSTRAINT RCMP_DAM_MLL_FK 
 FOREIGN KEY (DAM_CEC_COD, DAM_EMP_COD, DAM_CT5_COD, DAM_AMO_COD, DAM_MLL_SEQ) 
 REFERENCES TCMP_MILLORES (MLL_CEC_COD,MLL_EMP_COD,MLL_AMO_CT5_COD,MLL_AMO_COD,MLL_SEQ));

ALTER TABLE TCMP_FPV ADD (
  CONSTRAINT RCMP_FPV_ADJ_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_EMP_COD, FPV_DIA_COD, FPV_ADJ_SEQ) 
 REFERENCES TCMP_ADJ (ADJ_CEC_COD,ADJ_EMP_COD,ADJ_DIA_COD,ADJ_SEQ),
  CONSTRAINT RCMP_FPV_ASI_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_EMP_COD, FPV_EJE_COD, FPV_DIA_COD, FPV_ASI_NUMASI) 
 REFERENCES TCMP_ASIENTOS (ASI_CEC_COD,ASI_EMP_COD,ASI_EJE_COD,ASI_DIA_COD,ASI_NUMASI),
  CONSTRAINT RCMP_FPV_CT5DSP_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_EMP_COD, FPV_CT5_CODDSP) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_FPV_CT5PRO_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_EMP_COD, FPV_CT5_CODPRO) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_FPV_DEP_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_EMP_COD, FPV_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_FPV_DIA_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_EMP_COD, FPV_DIA_COD) 
 REFERENCES TCMP_DIARIS (DIA_CEC_COD,DIA_EMP_COD,DIA_COD),
  CONSTRAINT RCMP_FPV_IVA_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_FPV_MON_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD),
  CONSTRAINT RCMP_FPV_PRO_FK 
 FOREIGN KEY (FPV_CEC_COD, FPV_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_LRE ADD (
  CONSTRAINT RCMP_LRE_IVA_FK 
 FOREIGN KEY (LRE_CEC_COD, LRE_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_LRE_REB_FK 
 FOREIGN KEY (LRE_CEC_COD, LRE_EMP_COD, LRE_DIA_COD, LRE_SER_COD, LRE_REB_NUM) 
 REFERENCES TCMP_REB (REB_CEC_COD,REB_EMP_COD,REB_DIA_COD,REB_SER_COD,REB_NUM));

ALTER TABLE TCMP_QUO ADD (
  CONSTRAINT RCMP_QUO_ASI_FK 
 FOREIGN KEY (QUO_CEC_COD, QUO_EMP_COD, QUO_EJE_CODFIN, QUO_DIA_CODFIN, QUO_ASI_NUMASIFIN) 
 REFERENCES TCMP_ASIENTOS (ASI_CEC_COD,ASI_EMP_COD,ASI_EJE_COD,ASI_DIA_COD,ASI_NUMASI),
  CONSTRAINT RCMP_QUO_LEA_FK 
 FOREIGN KEY (QUO_CEC_COD, QUO_EMP_COD, QUO_LEA_COD) 
 REFERENCES TCMP_LEA (LEA_CEC_COD,LEA_EMP_COD,LEA_COD),
  CONSTRAINT RCMP_QUO_VEN_FK 
 FOREIGN KEY (QUO_CEC_COD, QUO_EMP_COD, QUO_DIA_COD, QUO_VEN_SEQ) 
 REFERENCES TCMP_VENCIMENTS (VEN_CEC_COD,VEN_EMP_COD,VEN_DIA_COD,VEN_SEQ));

ALTER TABLE TCMP_RFP ADD (
  CONSTRAINT RCMP_RFP_EMP_FK 
 FOREIGN KEY (RFP_CEC_COD, RFP_EMP_COD) 
 REFERENCES TCMP_EMPRESES (EMP_CEC_COD,EMP_COD),
  CONSTRAINT RCMP_RFP_FPV_FK 
 FOREIGN KEY (RFP_CEC_COD, RFP_EMP_COD, RFP_DIA_COD, RFP_FPV_SEQ) 
 REFERENCES TCMP_FPV (FPV_CEC_COD,FPV_EMP_COD,FPV_DIA_COD,FPV_SEQ));

ALTER TABLE TCMP_SII ADD (
  CONSTRAINT RCMP_SII_ASI_FK 
 FOREIGN KEY (SII_CEC_COD, SII_EMP_COD, SII_EJE_COD, SII_DIA_COD, SII_ASI_NUMASI) 
 REFERENCES TCMP_ASIENTOS (ASI_CEC_COD,ASI_EMP_COD,ASI_EJE_COD,ASI_DIA_COD,ASI_NUMASI));

ALTER TABLE TCMP_TMP_APU ADD (
  CONSTRAINT RCMP_APT_AST_FK 
 FOREIGN KEY (APT_CEC_COD, APT_EMP_COD, APT_EJE_COD, APT_DIA_COD, APT_AST_NUMASI) 
 REFERENCES TCMP_TMP_ASI (AST_CEC_COD,AST_EMP_COD,AST_EJE_COD,AST_DIA_COD,AST_NUMASI),
  CONSTRAINT RCMP_APT_CIVCODINT_FK 
 FOREIGN KEY (APT_CEC_COD, APT_CIV_CODINT) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_APT_CIV_FK 
 FOREIGN KEY (APT_CEC_COD, APT_CIV_COD) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_APT_CT5_FK 
 FOREIGN KEY (APT_CEC_COD, APT_EMP_COD, APT_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_APT_IVACODINT_FK 
 FOREIGN KEY (APT_CEC_COD, APT_IVA_CODINT) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_APT_IVA_FK 
 FOREIGN KEY (APT_CEC_COD, APT_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_APT_MON_FK 
 FOREIGN KEY (APT_CEC_COD, APT_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_VEP ADD (
  CONSTRAINT RCMP_VEP_FPV_FK 
 FOREIGN KEY (VEP_CEC_COD, VEP_EMP_COD, VEP_DIA_COD, VEP_FPV_SEQ) 
 REFERENCES TCMP_FPV (FPV_CEC_COD,FPV_EMP_COD,FPV_DIA_COD,FPV_SEQ));

ALTER TABLE TCMP_APUNTS ADD (
  CONSTRAINT RCMP_APU_ACU_FK 
 FOREIGN KEY (APU_CEC_COD, APU_EMP_COD, APU_CT5_COD, APU_EJE_COD, APU_DIA_COD, APU_ACU_ANY) 
 REFERENCES TCMP_ACUMULATS (ACU_CEC_COD,ACU_EMP_COD,ACU_CT5_COD,ACU_EJE_COD,ACU_DIA_COD,ACU_ANY),
  CONSTRAINT RCMP_APU_ASI_FK 
 FOREIGN KEY (APU_CEC_COD, APU_EMP_COD, APU_EJE_COD, APU_DIA_COD, APU_ASI_NUMASI) 
 REFERENCES TCMP_ASIENTOS (ASI_CEC_COD,ASI_EMP_COD,ASI_EJE_COD,ASI_DIA_COD,ASI_NUMASI),
  CONSTRAINT RCMP_APU_CIV_FK 
 FOREIGN KEY (APU_CEC_COD, APU_CIV_COD) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_APU_CIV_INT_FK 
 FOREIGN KEY (APU_CEC_COD, APU_CIV_CODINT) 
 REFERENCES TCMP_CLASEIVAS (CIV_CEC_COD,CIV_COD),
  CONSTRAINT RCMP_APU_CT5_FK 
 FOREIGN KEY (APU_CEC_COD, APU_EMP_COD, APU_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_APU_IVA_FK 
 FOREIGN KEY (APU_CEC_COD, APU_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_APU_IVA_INT_FK 
 FOREIGN KEY (APU_CEC_COD, APU_IVA_CODINT) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD),
  CONSTRAINT RCMP_APU_MON_FK 
 FOREIGN KEY (APU_CEC_COD, APU_MON_COD) 
 REFERENCES TCMP_MONEDES (MON_CEC_COD,MON_COD));

ALTER TABLE TCMP_APUNT_COBPAG ADD (
  CONSTRAINT RCMP_APU_VCP_FK 
 FOREIGN KEY (ACP_CEC_COD, ACP_EMP_COD, ACP_DIA_COD, ACP_VEN_SEQ, ACP_VCP_SEQ) 
 REFERENCES TCMP_VCP (VCP_CEC_COD,VCP_EMP_COD,VCP_DIA_COD,VCP_VEN_SEQ,VCP_SEQ),
  CONSTRAINT RCMP_VCP_APU_FK 
 FOREIGN KEY (ACP_CEC_COD, ACP_EMP_COD, ACP_EJE_COD, ACP_DIA_COD, ACP_ASI_NUMASI, ACP_APU_NUMAPU) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU));

ALTER TABLE TCMP_APUNT_VENCIMENT ADD (
  CONSTRAINT RCMP_APU_VEN_FK 
 FOREIGN KEY (AVE_CEC_COD, AVE_EMP_COD, AVE_DIA_COD, AVE_VEN_SEQ) 
 REFERENCES TCMP_VENCIMENTS (VEN_CEC_COD,VEN_EMP_COD,VEN_DIA_COD,VEN_SEQ),
  CONSTRAINT RCMP_VEN_APU_FK 
 FOREIGN KEY (AVE_CEC_COD, AVE_EMP_COD, AVE_EJE_COD, AVE_DIA_COD, AVE_ASI_NUMASI, AVE_APU_NUMAPU) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU));

ALTER TABLE TCMP_DEPPROCOM ADD (
  CONSTRAINT RCMP_DCO_APU_FK 
 FOREIGN KEY (DCO_CEC_COD, DCO_EMP_COD, DCO_EJE_COD, DCO_DIA_COD, DCO_ASI_NUMASI, DCO_APU_NUMAPU) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU),
  CONSTRAINT RCMP_DCO_DEL_FK 
 FOREIGN KEY (DCO_CEC_COD, DCO_EMP_COD, DCO_DEL_COD) 
 REFERENCES TCMP_DEL (DEL_CEC_COD,DEL_EMP_COD,DEL_COD),
  CONSTRAINT RCMP_DCO_DEP_FK 
 FOREIGN KEY (DCO_CEC_COD, DCO_EMP_COD, DCO_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_DCO_EXD_FK 
 FOREIGN KEY (DCO_CEC_COD, DCO_EMP_COD, DCO_EXD_COD) 
 REFERENCES TCMP_EXD (EXD_CEC_COD,EXD_EMP_COD,EXD_COD),
  CONSTRAINT RCMP_DCO_PRO_FK 
 FOREIGN KEY (DCO_CEC_COD, DCO_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_DESGLOSEAPUNT ADD (
  CONSTRAINT RCMP_DAP_APU_FK 
 FOREIGN KEY (DAP_CEC_COD, DAP_EMP_COD, DAP_EJE_COD, DAP_DIA_COD, DAP_ASI_NUMASI, DAP_APU_NUMAPU) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU));

ALTER TABLE TCMP_DSA ADD (
  CONSTRAINT RCMP_DSA_APU_FK 
 FOREIGN KEY (DSA_CEC_COD, DSA_EMP_COD, DSA_EJE_COD, DSA_DIA_COD, DSA_ASI_NUMASI, DSA_APU_NUMAPU) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU),
  CONSTRAINT RCMP_DSA_ASIDTI_FK 
 FOREIGN KEY (DSA_CEC_CODDTI, DSA_EMP_CODDTI, DSA_EJE_CODDTI, DSA_DIA_CODDTI, DSA_ASI_NUMASIDTI) 
 REFERENCES TCMP_ASIENTOS (ASI_CEC_COD,ASI_EMP_COD,ASI_EJE_COD,ASI_DIA_COD,ASI_NUMASI));

ALTER TABLE TCMP_EFA ADD (
  CONSTRAINT RCMP_EFA_EST_FK 
 FOREIGN KEY (EFA_CEC_COD, EFA_EST_COD) 
 REFERENCES TCMP_EST (EST_CEC_COD,EST_COD),
  CONSTRAINT RCMP_EFA_FPV_FK 
 FOREIGN KEY (EFA_CEC_COD, EFA_EMP_COD, EFA_DIA_COD, EFA_FPV_SEQ) 
 REFERENCES TCMP_FPV (FPV_CEC_COD,FPV_EMP_COD,FPV_DIA_COD,FPV_SEQ));

ALTER TABLE TCMP_FDP ADD (
  CONSTRAINT RCMP_FDP_CT5_FK 
 FOREIGN KEY (FDP_CEC_COD, FDP_EMP_COD, FDP_CT5_COD) 
 REFERENCES TCMP_COMPTES5 (CT5_CEC_COD,CT5_EMP_COD,CT5_COD),
  CONSTRAINT RCMP_FDP_DEP_FK 
 FOREIGN KEY (FDP_CEC_COD, FDP_EMP_COD, FDP_DEP_COD) 
 REFERENCES TCMP_DEPARTAMENTS (DEP_CEC_COD,DEP_EMP_COD,DEP_COD),
  CONSTRAINT RCMP_FDP_FPV_FK 
 FOREIGN KEY (FDP_CEC_COD, FDP_EMP_COD, FDP_DIA_COD, FDP_FPV_SEQ) 
 REFERENCES TCMP_FPV (FPV_CEC_COD,FPV_EMP_COD,FPV_DIA_COD,FPV_SEQ),
  CONSTRAINT RCMP_FDP_PRO_FK 
 FOREIGN KEY (FDP_CEC_COD, FDP_PRO_COD) 
 REFERENCES TCMP_PROJECTES (PRO_CEC_COD,PRO_COD));

ALTER TABLE TCMP_FIV ADD (
  CONSTRAINT RCMP_FIV_FPV_FK 
 FOREIGN KEY (FIV_CEC_COD, FIV_EMP_COD, FIV_DIA_COD, FIV_FPV_SEQ) 
 REFERENCES TCMP_FPV (FPV_CEC_COD,FPV_EMP_COD,FPV_DIA_COD,FPV_SEQ),
  CONSTRAINT RCMP_FIV_IVA_FK 
 FOREIGN KEY (FIV_CEC_COD, FIV_IVA_COD) 
 REFERENCES TCMP_IVAS (IVA_CEC_COD,IVA_COD));

ALTER TABLE TCMP_N43APU ADD (
  CONSTRAINT RCMP_A43_APU_FK 
 FOREIGN KEY (A43_CEC_COD, A43_EMP_COD, A43_EJE_COD, A43_DIA_COD, A43_ASI_NUMASI, A43_APU_NUMAPU) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU),
  CONSTRAINT RCMP_A43_MOV_FK 
 FOREIGN KEY (A43_CEC_COD, A43_EMP_COD, A43_CAB_SEQ, A43_MOV_SEQ) 
 REFERENCES TCMP_N43_PPLMOV (MOV_CEC_COD,MOV_EMP_COD,MOV_CAB_SEQ,MOV_SEQ));

ALTER TABLE TCMP_SID ADD (
  CONSTRAINT RCMP_SID_SII_FK 
 FOREIGN KEY (SID_CEC_COD, SID_EMP_COD, SID_SII_SEQ) 
 REFERENCES TCMP_SII (SII_CEC_COD,SII_EMP_COD,SII_SEQ));

ALTER TABLE TCMP_SIE ADD (
  CONSTRAINT RCMP_SIE_ESI_FK 
 FOREIGN KEY (SIE_CEC_COD, SIE_EMP_COD, SIE_ESI_SEQ) 
 REFERENCES TCMP_ESI (ESI_CEC_COD,ESI_EMP_COD,ESI_SEQ),
  CONSTRAINT RCMP_SIE_SII_FK 
 FOREIGN KEY (SIE_CEC_COD, SIE_EMP_COD, SIE_SII_SEQ) 
 REFERENCES TCMP_SII (SII_CEC_COD,SII_EMP_COD,SII_SEQ));

ALTER TABLE TCMP_SIF ADD (
  CONSTRAINT RCMP_SIF_SII_FK 
 FOREIGN KEY (SIF_CEC_COD, SIF_EMP_COD, SIF_SII_SEQ) 
 REFERENCES TCMP_SII (SII_CEC_COD,SII_EMP_COD,SII_SEQ));

ALTER TABLE TCMP_ACO ADD (
  CONSTRAINT RCMP_ACO_APU_FK 
 FOREIGN KEY (ACO_CEC_COD, ACO_EMP_COD, ACO_EJE_COD, ACO_DIA_COD, ACO_ASI_NUMASI, ACO_APU_NUMAPU) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU),
  CONSTRAINT RCMP_ACO_SCO_FK 
 FOREIGN KEY (ACO_CEC_COD, ACO_EMP_COD, ACO_SCO_COD) 
 REFERENCES TCMP_SCO (SCO_CEC_COD,SCO_EMP_COD,SCO_COD));

ALTER TABLE TCMP_APUFAC ADD (
  CONSTRAINT RCMP_APF_APU002_FK 
 FOREIGN KEY (APF_CEC_COD, APF_EMP_COD, APF_EJE_CODIVA, APF_DIA_COD, APF_ASI_NUMASIIVA, APF_APU_NUMAPUIVA) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU),
  CONSTRAINT RCMP_APF_APU_FK 
 FOREIGN KEY (APF_CEC_COD, APF_EMP_COD, APF_EJE_COD, APF_DIA_COD, APF_ASI_NUMASI, APF_APU_NUMAPU) 
 REFERENCES TCMP_APUNTS (APU_CEC_COD,APU_EMP_COD,APU_EJE_COD,APU_DIA_COD,APU_ASI_NUMASI,APU_NUMAPU));

