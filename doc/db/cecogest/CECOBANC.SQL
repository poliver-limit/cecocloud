--
-- Create Schema Script 
--   Database Version   : 9.2.0.6.0 
--   TOAD Version       : 9.7.0.51 
--   DB Connect String  : DES 
--   Schema             : CECOBANC 
--   Script Created by  : CECOGEST 
--   Script Created at  : 05/02/2020 9:16:48 
--   Physical Location  :  
--   Notes              :  
--

-- Object Counts: 
--   Indexes: 30        Columns: 86         
--   Tables: 23         Columns: 359        Constraints: 30     
--   Views: 28          


CREATE TABLE CECOBANC_REF_CODES
(
  RV_LOW_VALUE     VARCHAR2(240 BYTE)               NULL,
  RV_HIGH_VALUE    VARCHAR2(240 BYTE)               NULL,
  RV_ABBREVIATION  VARCHAR2(240 BYTE)               NULL,
  RV_DOMAIN        VARCHAR2(100 BYTE)               NULL,
  RV_MEANING       VARCHAR2(240 BYTE)               NULL,
  RV_TYPE          VARCHAR2(10 BYTE)                NULL
)
;


CREATE TABLE TBAN_CNF
(
  CNF_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CNF_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  CNF_COD      NUMBER(10)                           NULL,
  CNF_CLI      VARCHAR2(6 BYTE)                     NULL,
  CNF_NIF      VARCHAR2(9 BYTE)                     NULL,
  CNF_DIA      DATE                                 NULL,
  CNF_IMP      NUMBER(15,3)                         NULL,
  CNF_MON_COD  VARCHAR2(4 BYTE)                     NULL,
  CNF_NOMCLI   VARCHAR2(40 BYTE)                    NULL
)
;


CREATE TABLE TBAN_FIT
(
  FIT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FIT_COD      NUMBER(10)                           NULL,
  FIT_LIN      NUMBER(4)                            NULL,
  FIT_TXT      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TBAN_IDF
(
  IDF_COD     VARCHAR2(4 BYTE)                      NULL,
  IDF_NOM     VARCHAR2(40 BYTE)                     NULL,
  IDF_PRNLOG  VARCHAR2(1 BYTE)                      NULL,
  IDF_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  IDF_DATCRE  DATE                                  NULL,
  IDF_LOG     LONG RAW                              NULL,
  IDF_USUMOD  VARCHAR2(30 BYTE)                     NULL,
  IDF_DATMOD  DATE                                  NULL
)
;


CREATE TABLE TBAN_LCF
(
  LCF_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  LCF_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  LCF_CNF_COD  NUMBER(10)                           NULL,
  LCF_LIN      NUMBER(4)                            NULL,
  LCF_NIF      VARCHAR2(9 BYTE)                     NULL,
  LCF_NOM      VARCHAR2(40 BYTE)                    NULL,
  LCF_DOM      VARCHAR2(40 BYTE)                    NULL,
  LCF_NUMDOM   VARCHAR2(7 BYTE)                     NULL,
  LCF_CPO      NUMBER(5)                            NULL,
  LCF_MUN      VARCHAR2(30 BYTE)                    NULL,
  LCF_PRV      VARCHAR2(30 BYTE)                    NULL,
  LCF_TEL      VARCHAR2(10 BYTE)                    NULL,
  LCF_FAX      VARCHAR2(10 BYTE)                    NULL,
  LCF_BAN      VARCHAR2(4 BYTE)                     NULL,
  LCF_OFC      VARCHAR2(4 BYTE)                     NULL,
  LCF_DCC      VARCHAR2(2 BYTE)                     NULL,
  LCF_CCR      VARCHAR2(10 BYTE)                    NULL,
  LCF_NUMFAC   VARCHAR2(11 BYTE)                    NULL,
  LCF_DATFAC   DATE                                 NULL,
  LCF_IMPFAC   NUMBER(15,3)                         NULL,
  LCF_DATVEN   DATE                                 NULL,
  LCF_IBAN     VARCHAR2(34 BYTE)                    NULL,
  LCF_SWIFT    VARCHAR2(11 BYTE)                    NULL,
  LCF_PAIS     VARCHAR2(2 BYTE)                     NULL,
  LCF_EML      VARCHAR2(64 BYTE)                    NULL
)
;


CREATE TABLE TBAN_PAR
(
  PAR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PAR_COD      VARCHAR2(15 BYTE)                    NULL,
  PAR_VAL      VARCHAR2(100 BYTE)                   NULL,
  PAR_DES      VARCHAR2(1000 BYTE)                  NULL,
  PAR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PAR_DATCRE   DATE                                 NULL,
  PAR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PAR_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TBAN_PRS
(
  PRS_COD      VARCHAR2(10 BYTE)                    NULL,
  PRS_NIF      VARCHAR2(10 BYTE)                    NULL,
  PRS_NOM      VARCHAR2(40 BYTE)                    NULL,
  PRS_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PRS_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PRS_DATCRE   DATE                                 NULL,
  PRS_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PRS_DATMOD   DATE                                 NULL,
  PRS_SUF      VARCHAR2(3 BYTE)                     NULL
)
;


CREATE TABLE TBAN_REF
(
  REF_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  REF_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  REF_COD      VARCHAR2(35 BYTE)                    NULL,
  REF_DATCRE   DATE                                 NULL,
  REF_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  REF_IBNPAI   VARCHAR2(2 BYTE)                     NULL,
  REF_IBNDCC   VARCHAR2(2 BYTE)                     NULL,
  REF_IBNBAN   VARCHAR2(30 BYTE)                    NULL,
  REF_DATMOD   DATE                                 NULL,
  REF_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  REF_CNT      NUMBER(3)                            NULL
)
;


CREATE GLOBAL TEMPORARY TABLE TBAN_TMP_FAC
(
  FAC_PAG_SEQ  NUMBER(5)                            NULL,
  FAC_IMP      NUMBER(15,2)                         NULL,
  FAC_NOM      VARCHAR2(512 BYTE)                   NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TBAN_TMP_PAG
(
  PAG_SEQ      NUMBER(5)                            NULL,
  PAG_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  PAG_CODBEN   VARCHAR2(12 BYTE)                    NULL,
  PAG_NOM      VARCHAR2(40 BYTE)                    NULL,
  PAG_IDF      VARCHAR2(6 BYTE)                     NULL,
  PAG_EML      VARCHAR2(64 BYTE)                    NULL
)
ON COMMIT PRESERVE ROWS;


CREATE TABLE TBAN_TRFCOP
(
  TRF_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  TRF_EMP_COD    VARCHAR2(10 BYTE)                  NULL,
  TRF_SEQ        NUMBER(10)                         NULL,
  TRF_CODBEN     VARCHAR2(12 BYTE)                  NULL,
  TRF_IDF        VARCHAR2(6 BYTE)                   NULL,
  TRF_OPE        VARCHAR2(2 BYTE)                   NULL,
  TRF_NOM        VARCHAR2(36 BYTE)                  NULL,
  TRF_TIP        VARCHAR2(1 BYTE)                   NULL,
  TRF_DSP        NUMBER(4)                          NULL,
  TRF_ORD        NUMBER(4)                          NULL,
  TRF_DATCRE     DATE                               NULL,
  TRF_IMP        NUMBER(12,2)                       NULL,
  TRF_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  TRF_ABL        VARCHAR2(1 BYTE)                   NULL,
  TRF_ABN        NUMBER(1)                          NULL,
  TRF_DIAPRN     DATE                           DEFAULT sysdate                   NULL,
  TRF_USUPRN     VARCHAR2(30 BYTE)              DEFAULT user                      NULL,
  TRF_BAN        NUMBER(4)                          NULL,
  TRF_OFC        NUMBER(4)                          NULL,
  TRF_DCC        VARCHAR2(2 BYTE)                   NULL,
  TRF_CCR        NUMBER(10)                         NULL,
  TRF_DOM0       VARCHAR2(36 BYTE)                  NULL,
  TRF_DOM1       VARCHAR2(36 BYTE)                  NULL,
  TRF_POB        VARCHAR2(36 BYTE)                  NULL,
  TRF_PRV        VARCHAR2(36 BYTE)                  NULL,
  TRF_CNC0       VARCHAR2(36 BYTE)                  NULL,
  TRF_CNC1       VARCHAR2(36 BYTE)                  NULL,
  TRF_NIFXEC     VARCHAR2(18 BYTE)                  NULL,
  TRF_REFXEC     VARCHAR2(18 BYTE)                  NULL,
  TRF_DATVEN     DATE                               NULL,
  TRF_DIA        VARCHAR2(2 BYTE)                   NULL,
  TRF_EMP        VARCHAR2(4 BYTE)                   NULL,
  TRF_SER_COD    NUMBER(4)                          NULL,
  TRF_NUMSER     NUMBER(9)                          NULL,
  TRF_ORDIMP     NUMBER(9)                          NULL,
  TRF_NIFBEN     VARCHAR2(12 BYTE)                  NULL,
  TRF_IBAN_PAIS  VARCHAR2(2 BYTE)                   NULL,
  TRF_IBAN_DC    VARCHAR2(2 BYTE)                   NULL,
  TRF_IBAN_BBAN  VARCHAR2(30 BYTE)                  NULL,
  TRF_BIC        VARCHAR2(11 BYTE)                  NULL,
  TRF_PAIS       VARCHAR2(36 BYTE)                  NULL,
  TRF_PAI        VARCHAR2(2 BYTE)                   NULL
)
;


CREATE GLOBAL TEMPORARY TABLE TBAN_TRF_CMPVEN
(
  TRF_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRF_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  TRF_CODBEN   VARCHAR2(12 BYTE)                    NULL,
  TRF_IDF      VARCHAR2(6 BYTE)                     NULL,
  VEN_CEC_COD  VARCHAR2(4 BYTE)                     NULL,
  VEN_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  VEN_DIA_COD  VARCHAR2(2 BYTE)                     NULL,
  VEN_SEQ      NUMBER(10)                           NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TBAN_TRF_GESVRE
(
  TRF_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRF_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  TRF_CODBEN   VARCHAR2(12 BYTE)                    NULL,
  TRF_IDF      VARCHAR2(6 BYTE)                     NULL,
  VRE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  VRE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  VRE_REM_NUM  NUMBER(10)                           NULL,
  VRE_NUM      NUMBER(10)                           NULL
)
ON COMMIT PRESERVE ROWS;


CREATE INDEX IBAN_PRS_IDF_FK_I ON TBAN_PRS
(PRS_IDF_COD)
;


CREATE UNIQUE INDEX RBAN_CNF_PK ON TBAN_CNF
(CNF_IDF_COD, CNF_EMP_COD, CNF_COD)
;


CREATE UNIQUE INDEX RBAN_FIT_PK ON TBAN_FIT
(FIT_IDF_COD, FIT_COD, FIT_LIN)
;


CREATE UNIQUE INDEX RBAN_IDF_PK ON TBAN_IDF
(IDF_COD)
;


CREATE UNIQUE INDEX RBAN_LCF_PK ON TBAN_LCF
(LCF_IDF_COD, LCF_EMP_COD, LCF_CNF_COD, LCF_LIN)
;


CREATE UNIQUE INDEX RBAN_PAR_PK ON TBAN_PAR
(PAR_IDF_COD, PAR_COD)
;


CREATE UNIQUE INDEX RBAN_PRS_PK ON TBAN_PRS
(PRS_IDF_COD, PRS_COD)
;


CREATE UNIQUE INDEX RBAN_REF_PK ON TBAN_REF
(REF_IDF_COD, REF_EMP_COD, REF_COD)
;


CREATE UNIQUE INDEX RBAN_TRFCOP_PK ON TBAN_TRFCOP
(TRF_IDF_COD, TRF_EMP_COD, TRF_SEQ)
;


CREATE INDEX X_CECOBANC_REF_CODES_1 ON CECOBANC_REF_CODES
(RV_DOMAIN, RV_LOW_VALUE)
;




CREATE TABLE TBAN_EMP
(
  EMP_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  EMP_COD         VARCHAR2(10 BYTE)                 NULL,
  EMP_NIF         VARCHAR2(10 BYTE)                 NULL,
  EMP_NOM         VARCHAR2(40 BYTE)                 NULL,
  EMP_DOM0        VARCHAR2(36 BYTE)                 NULL,
  EMP_POB         VARCHAR2(36 BYTE)                 NULL,
  EMP_BAN         NUMBER(4)                         NULL,
  EMP_OFB         NUMBER(4)                         NULL,
  EMP_DCC         VARCHAR2(2 BYTE)                  NULL,
  EMP_CCR         NUMBER(10)                        NULL,
  EMP_REL         NUMBER(1)                         NULL,
  EMP_MON         VARCHAR2(1 BYTE)                  NULL,
  EMP_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  EMP_DATCRE      DATE                              NULL,
  EMP_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  EMP_DATMOD      DATE                              NULL,
  EMP_CTACMP      VARCHAR2(10 BYTE)                 NULL,
  EMP_NOMEMP      VARCHAR2(36 BYTE)                 NULL,
  EMP_DOMEMP      VARCHAR2(36 BYTE)                 NULL,
  EMP_TELEMP      VARCHAR2(60 BYTE)                 NULL,
  EMP_NIFEMP      VARCHAR2(10 BYTE)                 NULL,
  EMP_CODEMP      VARCHAR2(4 BYTE)                  NULL,
  EMP_DIA         VARCHAR2(2 BYTE)                  NULL,
  EMP_ACUVTO      VARCHAR2(1 BYTE)              DEFAULT 'N'                       NULL,
  EMP_DESTINI001  VARCHAR2(10 BYTE)                 NULL,
  EMP_DESTORI001  VARCHAR2(10 BYTE)                 NULL,
  EMP_DESTINI002  VARCHAR2(10 BYTE)                 NULL,
  EMP_DESTORI002  VARCHAR2(10 BYTE)                 NULL,
  EMP_POBBAN      VARCHAR2(36 BYTE)                 NULL,
  EMP_BANREB      NUMBER(4)                         NULL,
  EMP_OFBREB      NUMBER(4)                         NULL,
  EMP_CODPRV      VARCHAR2(2 BYTE)              DEFAULT '00'                      NULL,
  EMP_INE         VARCHAR2(9 BYTE)                  NULL,
  EMP_SUF         VARCHAR2(3 BYTE)              DEFAULT '000'                     NULL,
  EMP_IDFBAN      VARCHAR2(11 BYTE)                 NULL,
  EMP_PRS_COD     VARCHAR2(10 BYTE)                 NULL,
  EMP_TIP         VARCHAR2(1 BYTE)                  NULL,
  EMP_LOGEMP      LONG RAW                          NULL,
  EMP_TRFGENVEN   VARCHAR2(1 BYTE)                  NULL,
  EMP_TRFTIPDEF   VARCHAR2(1 BYTE)                  NULL,
  EMP_TRFOPEDEF   VARCHAR2(2 BYTE)                  NULL,
  EMP_TRFDSPDEF   VARCHAR2(4 BYTE)                  NULL,
  EMP_TRFORDDEF   VARCHAR2(4 BYTE)                  NULL,
  EMP_IDFACR      VARCHAR2(35 BYTE)                 NULL,
  EMP_BIC         VARCHAR2(11 BYTE)                 NULL,
  EMP_IBNBAN      VARCHAR2(30 BYTE)                 NULL,
  EMP_DESTINI003  VARCHAR2(10 BYTE)                 NULL,
  EMP_NUMCTRCNF   VARCHAR2(16 BYTE)                 NULL,
  EMP_ADEDIR      VARCHAR2(4 BYTE)                  NULL,
  EMP_MODREF      VARCHAR2(1 BYTE)                  NULL,
  EMP_IDFCMP      VARCHAR2(4 BYTE)                  NULL,
  EMP_TIPADE      VARCHAR2(4 BYTE)                  NULL,
  EMP_TIPCRD      VARCHAR2(4 BYTE)                  NULL
)
;


CREATE TABLE TBAN_FACCOP
(
  FAC_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FAC_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  FAC_TRF_SEQ  NUMBER(10)                           NULL,
  FAC_NUM      VARCHAR2(10 BYTE)                    NULL,
  FAC_DAT      DATE                                 NULL,
  FAC_IMP      NUMBER(15,2)                         NULL,
  FAC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FAC_DATCRE   DATE                                 NULL,
  FAC_REF      VARCHAR2(10 BYTE)                    NULL
)
;


CREATE TABLE TBAN_LIM
(
  LIM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  LIM_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  LIM_LIN      NUMBER(10)                           NULL,
  LIM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  LIM_DATCRE   DATE                                 NULL,
  LIM_DES      VARCHAR2(132 BYTE)                   NULL,
  LIM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  LIM_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TBAN_SER
(
  SER_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  SER_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  SER_COD      NUMBER(4)                            NULL,
  SER_NUM      NUMBER(9)                            NULL,
  SER_CRL1     NUMBER(1)                            NULL,
  SER_CRL2     NUMBER(4)                            NULL,
  SER_CRL3     NUMBER(1)                            NULL,
  SER_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  SER_DATCRE   DATE                                 NULL,
  SER_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  SER_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TBAN_TRF
(
  TRF_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  TRF_EMP_COD    VARCHAR2(10 BYTE)                  NULL,
  TRF_CODBEN     VARCHAR2(12 BYTE)                  NULL,
  TRF_IDF        VARCHAR2(6 BYTE)                   NULL,
  TRF_OPE        VARCHAR2(2 BYTE)                   NULL,
  TRF_NOM        VARCHAR2(36 BYTE)                  NULL,
  TRF_BAN        NUMBER(4)                          NULL,
  TRF_OFC        NUMBER(4)                          NULL,
  TRF_DCC        VARCHAR2(2 BYTE)                   NULL,
  TRF_CCR        NUMBER(10)                         NULL,
  TRF_TIP        VARCHAR2(1 BYTE)                   NULL,
  TRF_DSP        NUMBER(4)                          NULL,
  TRF_ORD        NUMBER(4)                          NULL,
  TRF_DATCRE     DATE                               NULL,
  TRF_IMP        NUMBER(12,2)                       NULL,
  TRF_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  TRF_ABL        VARCHAR2(1 BYTE)                   NULL,
  TRF_DOM0       VARCHAR2(36 BYTE)                  NULL,
  TRF_DOM1       VARCHAR2(36 BYTE)                  NULL,
  TRF_POB        VARCHAR2(36 BYTE)                  NULL,
  TRF_PRV        VARCHAR2(36 BYTE)                  NULL,
  TRF_CNC0       VARCHAR2(36 BYTE)                  NULL,
  TRF_CNC1       VARCHAR2(36 BYTE)                  NULL,
  TRF_NIFXEC     VARCHAR2(18 BYTE)                  NULL,
  TRF_REFXEC     VARCHAR2(18 BYTE)                  NULL,
  TRF_DATVEN     DATE                               NULL,
  TRF_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  TRF_DATMOD     DATE                               NULL,
  TRF_DIA        VARCHAR2(2 BYTE)                   NULL,
  TRF_EMP        VARCHAR2(4 BYTE)                   NULL,
  TRF_NUMSER     NUMBER(9)                          NULL,
  TRF_ORDIMP     NUMBER(9)                          NULL,
  TRF_NIFBEN     VARCHAR2(12 BYTE)                  NULL,
  TRF_ABN        NUMBER(1)                      DEFAULT 2                         NULL,
  TRF_IBAN_PAIS  VARCHAR2(2 BYTE)                   NULL,
  TRF_IBAN_DC    VARCHAR2(2 BYTE)                   NULL,
  TRF_IBAN_BBAN  VARCHAR2(30 BYTE)                  NULL,
  TRF_BIC        VARCHAR2(11 BYTE)                  NULL,
  TRF_PAIS       VARCHAR2(36 BYTE)                  NULL,
  TRF_PAI        VARCHAR2(2 BYTE)                   NULL
)
;


CREATE INDEX IBAN_EMP_IDF_FK ON TBAN_EMP
(EMP_IDF_COD)
;


CREATE INDEX IBAN_EMP_PRS_FK ON TBAN_EMP
(EMP_IDF_COD, EMP_PRS_COD)
;


CREATE INDEX IBAN_LIM_EMP_FK ON TBAN_LIM
(LIM_IDF_COD, LIM_EMP_COD)
;


CREATE INDEX IBAN_SER_EMP_FK ON TBAN_SER
(SER_IDF_COD, SER_EMP_COD)
;


CREATE INDEX IBAN_TRF_EMP_FK ON TBAN_TRF
(TRF_IDF_COD, TRF_EMP_COD)
;


CREATE UNIQUE INDEX RBAN_EMP_PK ON TBAN_EMP
(EMP_IDF_COD, EMP_COD)
;


CREATE UNIQUE INDEX RBAN_FACCOP_PK ON TBAN_FACCOP
(FAC_IDF_COD, FAC_EMP_COD, FAC_TRF_SEQ, FAC_NUM)
;


CREATE UNIQUE INDEX RBAN_LIM_PK ON TBAN_LIM
(LIM_EMP_COD, LIM_IDF_COD, LIM_LIN)
;


CREATE UNIQUE INDEX RBAN_SER_PK ON TBAN_SER
(SER_EMP_COD, SER_IDF_COD, SER_COD)
;


CREATE UNIQUE INDEX RBAN_TRF_PK ON TBAN_TRF
(TRF_IDF_COD, TRF_EMP_COD, TRF_CODBEN, TRF_IDF)
;


CREATE TABLE TBAN_ADE
(
  ADE_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  ADE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  ADE_COD      VARCHAR2(12 BYTE)                    NULL,
  ADE_NOM      VARCHAR2(40 BYTE)                    NULL,
  ADE_DOM      VARCHAR2(40 BYTE)                    NULL,
  ADE_CPO      NUMBER(5)                            NULL,
  ADE_POB      VARCHAR2(35 BYTE)                    NULL,
  ADE_BAN      NUMBER(4)                            NULL,
  ADE_OFB      NUMBER(4)                            NULL,
  ADE_DCC      VARCHAR2(2 BYTE)                     NULL,
  ADE_CCR      NUMBER(10)                           NULL,
  ADE_IMP      NUMBER(12,2)                         NULL,
  ADE_BLO      VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  ADE_DATCRE   DATE                                 NULL,
  ADE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ADE_CON      VARCHAR2(640 BYTE)                   NULL,
  ADE_DATMOD   DATE                                 NULL,
  ADE_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  ADE_SEQ      NUMBER(3)                        DEFAULT 0                         NULL,
  ADE_IBNPAI   VARCHAR2(2 BYTE)                     NULL,
  ADE_IBNDCC   VARCHAR2(2 BYTE)                     NULL,
  ADE_IBNBAN   VARCHAR2(30 BYTE)                    NULL,
  ADE_IBNBIC   VARCHAR2(11 BYTE)                    NULL,
  ADE_TIPIDF   VARCHAR2(1 BYTE)                     NULL,
  ADE_PAI      VARCHAR2(2 BYTE)                     NULL,
  ADE_IDF      VARCHAR2(35 BYTE)                    NULL,
  ADE_PRV      VARCHAR2(40 BYTE)                    NULL,
  ADE_REF      VARCHAR2(35 BYTE)                    NULL,
  ADE_DATFIR   DATE                                 NULL,
  ADE_TIPADE   VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TBAN_CAM
(
  CAM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CAM_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  CAM_LIM_LIN  NUMBER(10)                           NULL,
  CAM_NUM      NUMBER(10)                           NULL,
  CAM_COD      VARCHAR2(15 BYTE)                    NULL,
  CAM_POS      NUMBER(10)                           NULL,
  CAM_LON      NUMBER(10)                           NULL,
  CAM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CAM_DATCRE   DATE                                 NULL,
  CAM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CAM_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TBAN_CRD
(
  CRD_EMP_COD  VARCHAR2(10 BYTE)                    NULL,
  CRD_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CRD_COD      VARCHAR2(12 BYTE)                    NULL,
  CRD_REF      VARCHAR2(8 BYTE)                     NULL,
  CRD_NOM      VARCHAR2(40 BYTE)                    NULL,
  CRD_DOM      VARCHAR2(40 BYTE)                    NULL,
  CRD_CODPRV   VARCHAR2(2 BYTE)                     NULL,
  CRD_CPO      NUMBER(5)                            NULL,
  CRD_POB      VARCHAR2(35 BYTE)                    NULL,
  CRD_BAN      NUMBER(4)                            NULL,
  CRD_OFB      NUMBER(4)                            NULL,
  CRD_DCC      VARCHAR2(2 BYTE)                     NULL,
  CRD_CCR      NUMBER(10)                           NULL,
  CRD_DIAFAC   DATE                                 NULL,
  CRD_DIAVEN   DATE                                 NULL,
  CRD_IMP      NUMBER(12,2)                         NULL,
  CRD_BLO      VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  CRD_DATCRE   DATE                                 NULL,
  CRD_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CRD_CON      VARCHAR2(640 BYTE)                   NULL,
  CRD_DATMOD   DATE                                 NULL,
  CRD_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CRD_TIPADE   VARCHAR2(4 BYTE)                     NULL,
  CRD_TIPIDF   VARCHAR2(1 BYTE)                     NULL,
  CRD_IBNPAI   VARCHAR2(2 BYTE)                     NULL,
  CRD_IBNDCC   VARCHAR2(2 BYTE)                     NULL,
  CRD_IBNBAN   VARCHAR2(30 BYTE)                    NULL,
  CRD_IBNBIC   VARCHAR2(11 BYTE)                    NULL
)
;


CREATE TABLE TBAN_DAD
(
  DAD_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  DAD_EMP_COD     VARCHAR2(10 BYTE)                 NULL,
  DAD_TRF_CODBEN  VARCHAR2(12 BYTE)                 NULL,
  DAD_TRF_IDF     VARCHAR2(6 BYTE)                  NULL,
  DAD_LIN         NUMBER(10)                        NULL,
  DAD_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  DAD_DATCRE      DATE                              NULL,
  DAD_DES         VARCHAR2(132 BYTE)                NULL,
  DAD_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  DAD_DATMOD      DATE                              NULL
)
;


CREATE TABLE TBAN_FAC
(
  FAC_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  FAC_EMP_COD     VARCHAR2(10 BYTE)                 NULL,
  FAC_TRF_CODBEN  VARCHAR2(12 BYTE)                 NULL,
  FAC_TRF_IDF     VARCHAR2(6 BYTE)                  NULL,
  FAC_NUM         VARCHAR2(10 BYTE)                 NULL,
  FAC_DAT         DATE                              NULL,
  FAC_IMP         NUMBER(15,2)                      NULL,
  FAC_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  FAC_DATCRE      DATE                              NULL,
  FAC_REF         VARCHAR2(10 BYTE)                 NULL,
  FAC_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  FAC_DATMOD      DATE                              NULL
)
;


CREATE INDEX IBAN_ADE_EMP_FK ON TBAN_ADE
(ADE_EMP_COD, ADE_IDF_COD)
;


CREATE INDEX IBAN_CAM_LIM_FK ON TBAN_CAM
(CAM_EMP_COD, CAM_IDF_COD, CAM_LIM_LIN)
;


CREATE INDEX IBAN_CRD_EMP_FK ON TBAN_CRD
(CRD_EMP_COD, CRD_IDF_COD)
;


CREATE UNIQUE INDEX IBAN_CRD_PK ON TBAN_CRD
(CRD_REF, CRD_COD, CRD_EMP_COD, CRD_IDF_COD)
;


CREATE INDEX IBAN_DAD_TRF_FK ON TBAN_DAD
(DAD_IDF_COD, DAD_EMP_COD, DAD_TRF_CODBEN, DAD_TRF_IDF)
;


CREATE INDEX IBAN_FAC_TRF_FK ON TBAN_FAC
(FAC_IDF_COD, FAC_EMP_COD, FAC_TRF_CODBEN, FAC_TRF_IDF)
;


CREATE UNIQUE INDEX RBAN_ADE_PK ON TBAN_ADE
(ADE_COD, ADE_EMP_COD, ADE_IDF_COD, ADE_SEQ)
;


CREATE UNIQUE INDEX RBAN_CAM_PK ON TBAN_CAM
(CAM_LIM_LIN, CAM_EMP_COD, CAM_IDF_COD, CAM_NUM)
;


CREATE UNIQUE INDEX RBAN_DAD_PK ON TBAN_DAD
(DAD_EMP_COD, DAD_IDF_COD, DAD_TRF_CODBEN, DAD_TRF_IDF, DAD_LIN)
;


CREATE UNIQUE INDEX RBAN_FAC_PK ON TBAN_FAC
(FAC_IDF_COD, FAC_EMP_COD, FAC_TRF_CODBEN, FAC_TRF_IDF, FAC_NUM)
;


ALTER TABLE TBAN_CNF ADD (
  CONSTRAINT RBAN_CNF_PK
 PRIMARY KEY
 (CNF_IDF_COD, CNF_EMP_COD, CNF_COD)
    USING INDEX 
    );

ALTER TABLE TBAN_FIT ADD (
  CONSTRAINT RBAN_FIT_PK
 PRIMARY KEY
 (FIT_IDF_COD, FIT_COD, FIT_LIN)
    USING INDEX 
    );

ALTER TABLE TBAN_IDF ADD (
  CONSTRAINT RBAN_IDF_PK
 PRIMARY KEY
 (IDF_COD)
    USING INDEX 
    );

ALTER TABLE TBAN_LCF ADD (
  CONSTRAINT RBAN_LCF_PK
 PRIMARY KEY
 (LCF_IDF_COD, LCF_EMP_COD, LCF_CNF_COD, LCF_LIN)
    USING INDEX 
    );

ALTER TABLE TBAN_PAR ADD (
  CONSTRAINT RBAN_PAR_PK
 PRIMARY KEY
 (PAR_IDF_COD, PAR_COD)
    USING INDEX 
    );

ALTER TABLE TBAN_PRS ADD (
  CONSTRAINT RBAN_PRS_PK
 PRIMARY KEY
 (PRS_IDF_COD, PRS_COD)
    USING INDEX 
    );

ALTER TABLE TBAN_REF ADD (
  CONSTRAINT RBAN_REF_PK
 PRIMARY KEY
 (REF_IDF_COD, REF_EMP_COD, REF_COD)
    USING INDEX 
    );

ALTER TABLE TBAN_TRFCOP ADD (
  CONSTRAINT RBAN_TRFCOP_PK
 PRIMARY KEY
 (TRF_IDF_COD, TRF_EMP_COD, TRF_SEQ)
    USING INDEX 
    );

ALTER TABLE TBAN_EMP ADD (
  CONSTRAINT RBAN_EMP_PK
 PRIMARY KEY
 (EMP_IDF_COD, EMP_COD)
    USING INDEX 
    );

ALTER TABLE TBAN_FACCOP ADD (
  CONSTRAINT RBAN_FACCOP_PK
 PRIMARY KEY
 (FAC_IDF_COD, FAC_EMP_COD, FAC_TRF_SEQ, FAC_NUM)
    USING INDEX 
    );

ALTER TABLE TBAN_LIM ADD (
  CONSTRAINT RBAN_LIM_PK
 PRIMARY KEY
 (LIM_EMP_COD, LIM_IDF_COD, LIM_LIN)
    USING INDEX 
    );

ALTER TABLE TBAN_SER ADD (
  CONSTRAINT RBAN_SER_PK
 PRIMARY KEY
 (SER_EMP_COD, SER_IDF_COD, SER_COD)
    USING INDEX 
    );

ALTER TABLE TBAN_TRF ADD (
  CONSTRAINT RBAN_TRF_PK
 PRIMARY KEY
 (TRF_IDF_COD, TRF_EMP_COD, TRF_CODBEN, TRF_IDF)
    USING INDEX 
    );

ALTER TABLE TBAN_ADE ADD (
  CONSTRAINT RBAN_ADE_PK
 PRIMARY KEY
 (ADE_COD, ADE_EMP_COD, ADE_IDF_COD, ADE_SEQ)
    USING INDEX 
    );

ALTER TABLE TBAN_CAM ADD (
  CONSTRAINT RBAN_CAM_PK
 PRIMARY KEY
 (CAM_LIM_LIN, CAM_EMP_COD, CAM_IDF_COD, CAM_NUM)
    USING INDEX 
    );

ALTER TABLE TBAN_CRD ADD (
  CONSTRAINT IBAN_CRD_PK
 PRIMARY KEY
 (CRD_REF, CRD_COD, CRD_EMP_COD, CRD_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TBAN_DAD ADD (
  CONSTRAINT RBAN_DAD_PK
 PRIMARY KEY
 (DAD_EMP_COD, DAD_IDF_COD, DAD_TRF_CODBEN, DAD_TRF_IDF, DAD_LIN)
    USING INDEX 
    );

ALTER TABLE TBAN_FAC ADD (
  CONSTRAINT RBAN_FAC_PK
 PRIMARY KEY
 (FAC_IDF_COD, FAC_EMP_COD, FAC_TRF_CODBEN, FAC_TRF_IDF, FAC_NUM)
    USING INDEX 
    );

ALTER TABLE TBAN_PRS ADD (
  CONSTRAINT RBAN_PRS_IDF_FK 
 FOREIGN KEY (PRS_IDF_COD) 
 REFERENCES TBAN_IDF (IDF_COD));

ALTER TABLE TBAN_EMP ADD (
  CONSTRAINT RBAN_EMP_IDF_FK 
 FOREIGN KEY (EMP_IDF_COD) 
 REFERENCES TBAN_IDF (IDF_COD),
  CONSTRAINT RBAN_EMP_PRS_FK 
 FOREIGN KEY (EMP_IDF_COD, EMP_PRS_COD) 
 REFERENCES TBAN_PRS (PRS_IDF_COD,PRS_COD));

ALTER TABLE TBAN_FACCOP ADD (
  CONSTRAINT RBAN_FACCOP_TRFCOP_FK 
 FOREIGN KEY (FAC_IDF_COD, FAC_EMP_COD, FAC_TRF_SEQ) 
 REFERENCES TBAN_TRFCOP (TRF_IDF_COD,TRF_EMP_COD,TRF_SEQ));

ALTER TABLE TBAN_LIM ADD (
  CONSTRAINT RBAN_LIM_EMP_FK 
 FOREIGN KEY (LIM_IDF_COD, LIM_EMP_COD) 
 REFERENCES TBAN_EMP (EMP_IDF_COD,EMP_COD));

ALTER TABLE TBAN_SER ADD (
  CONSTRAINT RBAN_SER_EMP_FK 
 FOREIGN KEY (SER_IDF_COD, SER_EMP_COD) 
 REFERENCES TBAN_EMP (EMP_IDF_COD,EMP_COD));

ALTER TABLE TBAN_TRF ADD (
  CONSTRAINT RBAN_TRF_EMP_FK 
 FOREIGN KEY (TRF_IDF_COD, TRF_EMP_COD) 
 REFERENCES TBAN_EMP (EMP_IDF_COD,EMP_COD));

ALTER TABLE TBAN_ADE ADD (
  CONSTRAINT RBAN_ADE_EMP_FK 
 FOREIGN KEY (ADE_IDF_COD, ADE_EMP_COD) 
 REFERENCES TBAN_EMP (EMP_IDF_COD,EMP_COD));

ALTER TABLE TBAN_CAM ADD (
  CONSTRAINT RBAN_CAM_LIM_FK 
 FOREIGN KEY (CAM_EMP_COD, CAM_IDF_COD, CAM_LIM_LIN) 
 REFERENCES TBAN_LIM (LIM_EMP_COD,LIM_IDF_COD,LIM_LIN));

ALTER TABLE TBAN_CRD ADD (
  CONSTRAINT RBAN_CRD_EMP_FK 
 FOREIGN KEY (CRD_IDF_COD, CRD_EMP_COD) 
 REFERENCES TBAN_EMP (EMP_IDF_COD,EMP_COD));

ALTER TABLE TBAN_DAD ADD (
  CONSTRAINT RBAN_DAD_TRF_FK 
 FOREIGN KEY (DAD_IDF_COD, DAD_EMP_COD, DAD_TRF_CODBEN, DAD_TRF_IDF) 
 REFERENCES TBAN_TRF (TRF_IDF_COD,TRF_EMP_COD,TRF_CODBEN,TRF_IDF));

ALTER TABLE TBAN_FAC ADD (
  CONSTRAINT RBAN_FAC_TRF_FK 
 FOREIGN KEY (FAC_IDF_COD, FAC_EMP_COD, FAC_TRF_CODBEN, FAC_TRF_IDF) 
 REFERENCES TBAN_TRF (TRF_IDF_COD,TRF_EMP_COD,TRF_CODBEN,TRF_IDF));

