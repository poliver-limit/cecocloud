--
-- Create Schema Script 
--   Database Version   : 9.2.0.6.0 
--   TOAD Version       : 9.7.0.51 
--   DB Connect String  : DES 
--   Schema             : RRMM 
--   Script Created by  : CECOGEST 
--   Script Created at  : 05/02/2020 9:17:45 
--   Physical Location  :  
--   Notes              :  
--

-- Object Counts: 
--   Indexes: 156       Columns: 365        
--   Sequences: 1 
--   Tables: 56         Columns: 869        Constraints: 146    
--   Views: 7           


CREATE SEQUENCE SRMA_CMB
  START WITH 1161
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE TABLE TRMA_EPR
(
  EPR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  EPR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  EPR_PRJ_NUM  VARCHAR2(6 BYTE)                     NULL,
  EPR_ETP_COD  VARCHAR2(4 BYTE)                     NULL,
  EPR_UCE_SEQ  NUMBER(18)                           NULL,
  EPR_LES_SEQ  NUMBER(18)                           NULL
)
;


CREATE TABLE TRMA_GCR
(
  GCR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  GCR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  GCR_DAT      DATE                                 NULL,
  GCR_SIM      VARCHAR2(255 BYTE)                   NULL,
  GCR_TIP      NUMBER                               NULL,
  GCR_COBGPS   NUMBER                               NULL,
  GCR_DES      VARCHAR2(255 BYTE)                   NULL,
  GCR_KMS      NUMBER                               NULL,
  GCR_LAT      NUMBER                               NULL,
  GCR_LNG      NUMBER                               NULL,
  GCR_MED      NUMBER                               NULL,
  GCR_VEL      NUMBER                               NULL,
  GCR_ALT      NUMBER                               NULL,
  GCR_DIS      NUMBER                               NULL,
  GCR_EST      NUMBER                               NULL,
  GCR_DATMSJ   DATE                                 NULL,
  GCR_X        NUMBER                               NULL,
  GCR_XNOT     NUMBER                               NULL,
  GCR_Y        NUMBER                               NULL,
  GCR_VAL      NUMBER                               NULL,
  GCR_YNOT     NUMBER                               NULL,
  GCR_DATNOT   DATE                                 NULL,
  GCR_VIA      VARCHAR2(255 BYTE)                   NULL,
  GCR_POB      VARCHAR2(255 BYTE)                   NULL
)
;


CREATE TABLE TRMA_IDF
(
  IDF_COD     VARCHAR2(4 BYTE)                      NULL,
  IDF_DATCRE  DATE                                  NULL,
  IDF_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  IDF_NOM     VARCHAR2(30 BYTE)                     NULL,
  IDF_DATMOD  DATE                                  NULL,
  IDF_USUMOD  VARCHAR2(30 BYTE)                     NULL
)
;


CREATE TABLE TRMA_INR
(
  INR_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  INR_COD         NUMBER(18)                        NULL,
  INR_DAT         DATE                              NULL,
  INR_TIPENT      VARCHAR2(2 BYTE)                  NULL,
  INR_MAQ_COD     VARCHAR2(30 BYTE)                 NULL,
  INR_TGTNUM      VARCHAR2(30 BYTE)                 NULL,
  INR_PTHIMG      VARCHAR2(500 BYTE)                NULL,
  INR_PESBSC      NUMBER(18)                        NULL,
  INR_TARA        NUMBER(18)                        NULL,
  INR_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  INR_ALB_NUMDOC  NUMBER(18)                        NULL,
  INR_IDF_CODMAQ  VARCHAR2(15 BYTE)                 NULL,
  INR_EMP_CODMAQ  VARCHAR2(15 BYTE)                 NULL,
  INR_TRA_COD     VARCHAR2(6 BYTE)                  NULL,
  INR_MTR_COD     VARCHAR2(10 BYTE)                 NULL,
  INR_PESANT      NUMBER(18,4)                      NULL,
  INR_PMA         NUMBER(18,4)                      NULL,
  INR_OPE_COD     VARCHAR2(6 BYTE)                  NULL
)
;


CREATE TABLE TRMA_MMQ
(
  MMQ_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  MMQ_COD      VARCHAR2(6 BYTE)                     NULL,
  MMQ_DES      VARCHAR2(60 BYTE)                    NULL,
  MMQ_CSMMIG   NUMBER(6,2)                          NULL,
  MMQ_TIPCMB   VARCHAR2(60 BYTE)                    NULL,
  MMQ_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRMA_PAC
(
  PAC_IDF_COD        VARCHAR2(4 BYTE)               NULL,
  PAC_SEQ            NUMBER(18)                     NULL,
  PAC_CSE            VARCHAR2(150 BYTE)             NULL,
  PAC_NCS            VARCHAR2(150 BYTE)             NULL,
  PAC_NEXPSE         VARCHAR2(150 BYTE)             NULL,
  PAC_GCSEG          VARCHAR2(150 BYTE)             NULL,
  PAC_TELCON         VARCHAR2(150 BYTE)             NULL,
  PAC_EMLCON         VARCHAR2(150 BYTE)             NULL,
  PAC_FECACC         DATE                           NULL,
  PAC_LUGACC         VARCHAR2(1000 BYTE)            NULL,
  PAC_VIC            VARCHAR2(1 BYTE)               NULL,
  PAC_VEHDIS         VARCHAR2(1 BYTE)               NULL,
  PAC_OBJDIF         VARCHAR2(1 BYTE)               NULL,
  PAC_TESTIG         VARCHAR2(1000 BYTE)            NULL,
  PAC_MAQ_COD        VARCHAR2(15 BYTE)              NULL,
  PAC_NCSMAQ         VARCHAR2(150 BYTE)             NULL,
  PAC_NPOLSEMAQ      VARCHAR2(150 BYTE)             NULL,
  PAC_NCAVER         VARCHAR2(150 BYTE)             NULL,
  PAC_FECVAL         DATE                           NULL,
  PAC_DANYPR         VARCHAR2(1 BYTE)               NULL,
  PAC_MAQ_COD002     VARCHAR2(15 BYTE)              NULL,
  PAC_NCSREM         VARCHAR2(150 BYTE)             NULL,
  PAC_NPOSEREM       VARCHAR2(150 BYTE)             NULL,
  PAC_FECVALREM      DATE                           NULL,
  PAC_OPE_COD        VARCHAR2(6 BYTE)               NULL,
  PAC_OPE_NOM        VARCHAR2(40 BYTE)              NULL,
  PAC_DATNAI         DATE                           NULL,
  PAC_OPEDOM         VARCHAR2(60 BYTE)              NULL,
  PAC_OPETEL         VARCHAR2(60 BYTE)              NULL,
  PAC_OPEEML         VARCHAR2(60 BYTE)              NULL,
  PAC_OPENPC         VARCHAR2(150 BYTE)             NULL,
  PAC_TIPPER         VARCHAR2(150 BYTE)             NULL,
  PAC_FECVALPER      DATE                           NULL,
  PAC_OPE_CODJGR     VARCHAR2(6 BYTE)               NULL,
  PAC_OPE_CODJOB     VARCHAR2(6 BYTE)               NULL,
  PAC_OPE_CODENC     VARCHAR2(6 BYTE)               NULL,
  PAC_NOMASEB        VARCHAR2(150 BYTE)             NULL,
  PAC_DIRASEB        VARCHAR2(150 BYTE)             NULL,
  PAC_TELASEB        VARCHAR2(150 BYTE)             NULL,
  PAC_EMLASEB        VARCHAR2(150 BYTE)             NULL,
  PAC_MRCVEHB        VARCHAR2(150 BYTE)             NULL,
  PAC_MTRB           VARCHAR2(150 BYTE)             NULL,
  PAC_MTRREMB        VARCHAR2(150 BYTE)             NULL,
  PAC_PAIREMB        VARCHAR2(150 BYTE)             NULL,
  PAC_NCSB           VARCHAR2(150 BYTE)             NULL,
  PAC_NPOLB          VARCHAR2(150 BYTE)             NULL,
  PAC_NCVERDE        VARCHAR2(150 BYTE)             NULL,
  PAC_FECVALSEG      DATE                           NULL,
  PAC_PAIVEHB        VARCHAR2(150 BYTE)             NULL,
  PAC_NOMCNDVEHB     VARCHAR2(150 BYTE)             NULL,
  PAC_DATNAICNDB     DATE                           NULL,
  PAC_DIRCNDVEHB     VARCHAR2(150 BYTE)             NULL,
  PAC_PAICNDVEHB     VARCHAR2(150 BYTE)             NULL,
  PAC_TELCNDVEHB     VARCHAR2(150 BYTE)             NULL,
  PAC_EMLCNDVEHB     VARCHAR2(150 BYTE)             NULL,
  PAC_NPECNDVEHB     VARCHAR2(150 BYTE)             NULL,
  PAC_TIPCNDVEHB     VARCHAR2(150 BYTE)             NULL,
  PAC_FECVALCNDVEHB  DATE                           NULL,
  PAC_DAPRVEHB       VARCHAR2(1000 BYTE)            NULL,
  PAC_OBSVEHB        VARCHAR2(2000 BYTE)            NULL,
  PAC_CPAESTVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAABRVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAIESVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPASALVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAENTVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAEPZVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPACPZVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPACOLVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPACAMVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAADEVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAGDEVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAGIZVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAATRVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAINVVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPADCRVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPASEMVEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAESTVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAABRVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAIESVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPASALVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAENTVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAEPZVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPACPZVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPACOLVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPACAMVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAADEVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAGDEVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAGIZVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAATRVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPAINVVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPADCRVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_CPASEMVEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_OPE_CODPAS     VARCHAR2(6 BYTE)               NULL,
  PAC_DOCAJT         VARCHAR2(2000 BYTE)            NULL,
  PAC_DATCRE         DATE                           NULL,
  PAC_USUCRE         VARCHAR2(30 BYTE)              NULL,
  PAC_DATMOD         DATE                           NULL,
  PAC_USUMOD         VARCHAR2(30 BYTE)              NULL,
  PAC_DAPRVEHA       VARCHAR2(1000 BYTE)            NULL,
  PAC_OBSVEHA        VARCHAR2(2000 BYTE)            NULL,
  PAC_CPACO2VEHA     VARCHAR2(1 BYTE)               NULL,
  PAC_CPACO2VEHB     VARCHAR2(1 BYTE)               NULL,
  PAC_ARX            VARCHAR2(1 BYTE)               NULL,
  PAC_CEN            VARCHAR2(100 BYTE)             NULL
)
;


CREATE TABLE TRMA_PRC
(
  PRC_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  PRC_SEQ         NUMBER(18)                        NULL,
  PRC_CSE         VARCHAR2(150 BYTE)                NULL,
  PRC_NCS         VARCHAR2(150 BYTE)                NULL,
  PRC_NEXPSE      VARCHAR2(150 BYTE)                NULL,
  PRC_GCSEG       VARCHAR2(150 BYTE)                NULL,
  PRC_TELCON      VARCHAR2(150 BYTE)                NULL,
  PRC_EMLCON      VARCHAR2(150 BYTE)                NULL,
  PRC_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL,
  PRC_CIASIN      VARCHAR2(150 BYTE)                NULL,
  PRC_NEXSIN      VARCHAR2(150 BYTE)                NULL,
  PRC_FECACC      DATE                              NULL,
  PRC_LUGACC      VARCHAR2(1000 BYTE)               NULL,
  PRC_VIC         VARCHAR2(1 BYTE)                  NULL,
  PRC_TESTIG      VARCHAR2(1000 BYTE)               NULL,
  PRC_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  PRC_MAQ_COD002  VARCHAR2(15 BYTE)                 NULL,
  PRC_NCSMAQ      VARCHAR2(150 BYTE)                NULL,
  PRC_NPOLSEMAQ   VARCHAR2(150 BYTE)                NULL,
  PRC_NCAVER      VARCHAR2(150 BYTE)                NULL,
  PRC_FECVAL      DATE                              NULL,
  PRC_DANYPR      VARCHAR2(1 BYTE)                  NULL,
  PRC_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  PRC_OPE_NOM     VARCHAR2(40 BYTE)                 NULL,
  PRC_DATNAI      DATE                              NULL,
  PRC_OPEDOM      VARCHAR2(60 BYTE)                 NULL,
  PRC_OPETEL      VARCHAR2(60 BYTE)                 NULL,
  PRC_OPEEML      VARCHAR2(60 BYTE)                 NULL,
  PRC_OPEOBS      VARCHAR2(1000 BYTE)               NULL,
  PRC_OPE_CODJGR  VARCHAR2(6 BYTE)                  NULL,
  PRC_OPE_CODJOB  VARCHAR2(6 BYTE)                  NULL,
  PRC_OPE_CODENC  VARCHAR2(6 BYTE)                  NULL,
  PRC_DANPER      VARCHAR2(1 BYTE)                  NULL,
  PRC_PERNOM      VARCHAR2(150 BYTE)                NULL,
  PRC_PERDNI      VARCHAR2(150 BYTE)                NULL,
  PRC_PERDOM      VARCHAR2(150 BYTE)                NULL,
  PRC_PERTEL      VARCHAR2(150 BYTE)                NULL,
  PRC_PEREML      VARCHAR2(150 BYTE)                NULL,
  PRC_DANMAT      VARCHAR2(1 BYTE)                  NULL,
  PRC_TIPINS      VARCHAR2(1000 BYTE)               NULL,
  PRC_OPE_CODPAS  VARCHAR2(6 BYTE)                  NULL,
  PRC_DOCAJT      VARCHAR2(2000 BYTE)               NULL,
  PRC_DATCRE      DATE                              NULL,
  PRC_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  PRC_DATMOD      DATE                              NULL,
  PRC_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  PRC_ARX         VARCHAR2(1 BYTE)                  NULL,
  PRC_QUAINZ      NUMBER(15,2)                      NULL,
  PRC_CEN         VARCHAR2(100 BYTE)                NULL
)
;


CREATE TABLE TRMA_SEG
(
  SEG_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  SEG_PAC_SEQ  NUMBER(18)                           NULL,
  SEG_SEQ      NUMBER(18)                           NULL,
  SEG_DIA      DATE                                 NULL,
  SEG_TEX      VARCHAR2(2000 BYTE)                  NULL,
  SEG_DATCRE   DATE                                 NULL,
  SEG_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  SEG_DATMOD   DATE                                 NULL,
  SEG_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_SRC
(
  SRC_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  SRC_PRC_SEQ  NUMBER(18)                           NULL,
  SRC_SEQ      NUMBER(18)                           NULL,
  SRC_DIA      DATE                                 NULL,
  SRC_TEX      VARCHAR2(2000 BYTE)                  NULL,
  SRC_DATCRE   DATE                                 NULL,
  SRC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  SRC_DATMOD   DATE                                 NULL,
  SRC_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_TCM
(
  TCM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TCM_COD      VARCHAR2(4 BYTE)                     NULL,
  TCM_DATCRE   DATE                                 NULL,
  TCM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TCM_NOM      VARCHAR2(30 BYTE)                    NULL,
  TCM_DES      VARCHAR2(1000 BYTE)                  NULL,
  TCM_DATMOD   DATE                                 NULL,
  TCM_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_TCO
(
  TCO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TCO_COD      VARCHAR2(4 BYTE)                     NULL,
  TCO_DATCRE   DATE                                 NULL,
  TCO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TCO_NOM      VARCHAR2(30 BYTE)                    NULL,
  TCO_DES      VARCHAR2(1000 BYTE)                  NULL,
  TCO_DATMOD   DATE                                 NULL,
  TCO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TCO_CTECMP   VARCHAR2(10 BYTE)                    NULL,
  TCO_ASICST   VARCHAR2(1 BYTE)                     NULL,
  TCO_TRS      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRMA_TIM
(
  TIM_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  TIM_COD        VARCHAR2(4 BYTE)                   NULL,
  TIM_DATCRE     DATE                               NULL,
  TIM_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  TIM_NOM        VARCHAR2(30 BYTE)                  NULL,
  TIM_UNIMAXDIA  NUMBER(10,3)                       NULL,
  TIM_ART_COD    VARCHAR2(15 BYTE)                  NULL,
  TIM_DES        VARCHAR2(1000 BYTE)                NULL,
  TIM_DATMOD     DATE                               NULL,
  TIM_USUMOD     VARCHAR2(30 BYTE)                  NULL
)
;


CREATE TABLE TRMA_TPI
(
  TPI_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TPI_COD      VARCHAR2(4 BYTE)                     NULL,
  TPI_DATCRE   DATE                                 NULL,
  TPI_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TPI_NOM      VARCHAR2(30 BYTE)                    NULL,
  TPI_DES      VARCHAR2(1000 BYTE)                  NULL,
  TPI_DATMOD   DATE                                 NULL,
  TPI_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_TRA
(
  TRA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRA_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  TRA_DAT      DATE                                 NULL,
  TRA_PRJ_NUM  VARCHAR2(6 BYTE)                     NULL,
  TRA_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  TRA_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  TRA_HORDEC   NUMBER(15,2)                         NULL,
  TRA_HOR      NUMBER(2)                            NULL,
  TRA_MIN      NUMBER(2)                            NULL
)
;


CREATE TABLE TRMA_TRG
(
  TRG_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRG_COD      VARCHAR2(4 BYTE)                     NULL,
  TRG_DATCRE   DATE                                 NULL,
  TRG_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TRG_NOM      VARCHAR2(30 BYTE)                    NULL,
  TRG_DATMOD   DATE                                 NULL,
  TRG_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_TRS
(
  TRS_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRS_COD      VARCHAR2(4 BYTE)                     NULL,
  TRS_DATCRE   DATE                                 NULL,
  TRS_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TRS_NOM      VARCHAR2(30 BYTE)                    NULL,
  TRS_DES      VARCHAR2(1000 BYTE)                  NULL,
  TRS_DATMOD   DATE                                 NULL,
  TRS_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_TRV
(
  TRV_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRV_COD      VARCHAR2(4 BYTE)                     NULL,
  TRV_DATCRE   DATE                                 NULL,
  TRV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TRV_NOM      VARCHAR2(30 BYTE)                    NULL,
  TRV_TCO_COD  VARCHAR2(4 BYTE)                     NULL,
  TRV_DES      VARCHAR2(1000 BYTE)                  NULL,
  TRV_DATMOD   DATE                                 NULL,
  TRV_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TRV_PRDDAT   NUMBER(4)                            NULL,
  TRV_PRDVAL   NUMBER(10,2)                         NULL
)
;


CREATE TABLE TRMA_TZN
(
  TZN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TZN_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  TZN_SIM      VARCHAR2(25 BYTE)                    NULL,
  TZN_ZONCOD   NUMBER(10)                           NULL,
  TZN_MVLCOD   NUMBER(10)                           NULL,
  TZN_HORINI   DATE                                 NULL,
  TZN_HORFIN   DATE                                 NULL,
  TZN_TMP      DATE                                 NULL
)
;


CREATE UNIQUE INDEX IRMA_PAC_PK ON TRMA_PAC
(PAC_IDF_COD, PAC_SEQ)
;


CREATE UNIQUE INDEX IRMA_PRC_PK ON TRMA_PRC
(PRC_IDF_COD, PRC_SEQ)
;


CREATE INDEX IRMA_SEG_PAC_FK_I ON TRMA_SEG
(SEG_IDF_COD, SEG_PAC_SEQ)
;


CREATE INDEX IRMA_SRC_PRC_FK_I ON TRMA_SRC
(SRC_IDF_COD, SRC_PRC_SEQ)
;


CREATE INDEX IRMA_TCM_IDF_FK_I ON TRMA_TCM
(TCM_IDF_COD)
;


CREATE INDEX IRMA_TCO_IDF_FK_I ON TRMA_TCO
(TCO_IDF_COD)
;


CREATE INDEX IRMA_TIM_ART_FK_I ON TRMA_TIM
(TIM_ART_COD, TIM_IDF_COD)
;


CREATE INDEX IRMA_TIM_IDF_FK_I ON TRMA_TIM
(TIM_IDF_COD)
;


CREATE INDEX IRMA_TPI_IDF_FK_I ON TRMA_TPI
(TPI_IDF_COD)
;


CREATE INDEX IRMA_TRS_IDF_FK_I ON TRMA_TRS
(TRS_IDF_COD)
;


CREATE INDEX IRMA_TRV_IDF_FK_I ON TRMA_TRV
(TRV_IDF_COD)
;


CREATE INDEX IRMA_TRV_TCO_FK_I ON TRMA_TRV
(TRV_TCO_COD, TRV_IDF_COD)
;


CREATE UNIQUE INDEX PK_TRMA_EPR ON TRMA_EPR
(EPR_IDF_COD, EPR_EMP_COD, EPR_PRJ_NUM)
;


CREATE UNIQUE INDEX RRMA_GCR_PK ON TRMA_GCR
(GCR_IDF_COD, GCR_EMP_COD, GCR_DAT, GCR_TIP, GCR_SIM)
;


CREATE UNIQUE INDEX RRMA_IDF_PK ON TRMA_IDF
(IDF_COD)
;


CREATE UNIQUE INDEX RRMA_INR_PK ON TRMA_INR
(INR_IDF_COD, INR_COD)
;


CREATE UNIQUE INDEX RRMA_MMQ_PK ON TRMA_MMQ
(MMQ_IDF_COD, MMQ_COD)
;


CREATE UNIQUE INDEX RRMA_SEG_PK ON TRMA_SEG
(SEG_IDF_COD, SEG_PAC_SEQ, SEG_SEQ)
;


CREATE UNIQUE INDEX RRMA_SRC_PK ON TRMA_SRC
(SRC_IDF_COD, SRC_PRC_SEQ, SRC_SEQ)
;


CREATE UNIQUE INDEX RRMA_TCM_PK ON TRMA_TCM
(TCM_COD, TCM_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_TCO_PK ON TRMA_TCO
(TCO_COD, TCO_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_TIM_PK ON TRMA_TIM
(TIM_COD, TIM_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_TPI_PK ON TRMA_TPI
(TPI_COD, TPI_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_TRA_PK ON TRMA_TRA
(TRA_IDF_COD, TRA_EMP_COD, TRA_DAT, TRA_PRJ_NUM, TRA_OPE_COD, 
TRA_MAQ_COD)
;


CREATE UNIQUE INDEX RRMA_TRG_PK ON TRMA_TRG
(TRG_IDF_COD, TRG_COD)
;


CREATE UNIQUE INDEX RRMA_TRS_PK ON TRMA_TRS
(TRS_COD, TRS_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_TRV_PK ON TRMA_TRV
(TRV_COD, TRV_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_TZN_PK ON TRMA_TZN
(TZN_IDF_COD, TZN_EMP_COD, TZN_ZONCOD, TZN_SIM, TZN_HORINI)
;


CREATE TABLE TRMA_CAM
(
  CAM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CAM_COD      VARCHAR2(4 BYTE)                     NULL,
  CAM_TIP      VARCHAR2(1 BYTE)                     NULL,
  CAM_AMP      NUMBER(4)                            NULL,
  CAM_NOM      VARCHAR2(256 BYTE)                   NULL,
  CAM_DATCRE   DATE                                 NULL,
  CAM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CAM_DATMOD   DATE                                 NULL,
  CAM_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_CLT
(
  CLT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CLT_COD      VARCHAR2(4 BYTE)                     NULL,
  CLT_NOM      VARCHAR2(60 BYTE)                    NULL
)
;


CREATE TABLE TRMA_CMB002
(
  CMB_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  CMB_REF         NUMBER(10)                        NULL,
  CMB_DIA         DATE                              NULL,
  CMB_LIT         NUMBER(10,3)                      NULL,
  CMB_ART_COD     VARCHAR2(15 BYTE)                 NULL,
  CMB_DIV_COD     VARCHAR2(4 BYTE)                  NULL,
  CMB_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  CMB_DATCRE      DATE                              NULL,
  CMB_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  CMB_HOR         DATE                              NULL,
  CMB_DES         VARCHAR2(60 BYTE)                 NULL,
  CMB_PRU         NUMBER(17,5)                      NULL,
  CMB_UNI         NUMBER(15,2)                      NULL,
  CMB_STD         VARCHAR2(6 BYTE)                  NULL,
  CMB_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  CMB_ALB_NUMDOC  NUMBER(10)                        NULL,
  CMB_LAC_NUM     NUMBER(10)                        NULL,
  CMB_DATMOD      DATE                              NULL,
  CMB_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  CMB_CPO_COD     VARCHAR2(8 BYTE)                  NULL,
  CMB_EMP_CODCMB  VARCHAR2(4 BYTE)                  NULL,
  CMB_ALBMAN      VARCHAR2(10 BYTE)                 NULL,
  CMB_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL
)
;


CREATE TABLE TRMA_CNT
(
  CNT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CNT_COD      VARCHAR2(15 BYTE)                    NULL,
  CNT_ULTVAL   NUMBER(15)                           NULL,
  CNT_DES      VARCHAR2(1000 BYTE)                  NULL,
  CNT_DATCRE   DATE                                 NULL,
  CNT_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CNT_DATMOD   DATE                                 NULL,
  CNT_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_CPA
(
  CPA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CPA_COD      VARCHAR2(4 BYTE)                     NULL,
  CPA_CTECMP   VARCHAR2(10 BYTE)                    NULL,
  CPA_DATCRE   DATE                                 NULL,
  CPA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CPA_NOM      VARCHAR2(60 BYTE)                    NULL,
  CPA_DATMOD   DATE                                 NULL,
  CPA_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_EMP
(
  EMP_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  EMP_COD      VARCHAR2(4 BYTE)                     NULL,
  EMP_PRNLOG   VARCHAR2(1 BYTE)                     NULL,
  EMP_DIV_COD  VARCHAR2(4 BYTE)                     NULL,
  EMP_DATCRE   DATE                                 NULL,
  EMP_NOM      VARCHAR2(40 BYTE)                    NULL,
  EMP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EMP_DOM      VARCHAR2(60 BYTE)                    NULL,
  EMP_CPO      VARCHAR2(6 BYTE)                     NULL,
  EMP_POB      VARCHAR2(30 BYTE)                    NULL,
  EMP_CIF      VARCHAR2(12 BYTE)                    NULL,
  EMP_TEL      VARCHAR2(60 BYTE)                    NULL,
  EMP_FAX      VARCHAR2(60 BYTE)                    NULL,
  EMP_EML      VARCHAR2(60 BYTE)                    NULL,
  EMP_WWW      VARCHAR2(60 BYTE)                    NULL,
  EMP_CODCMP   VARCHAR2(10 BYTE)                    NULL,
  EMP_LOG      LONG RAW                             NULL,
  EMP_DATMOD   DATE                                 NULL,
  EMP_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_EXP
(
  EXP_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  EXP_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  EXP_COD        VARCHAR2(6 BYTE)                   NULL,
  EXP_DATCRE     DATE                               NULL,
  EXP_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  EXP_NOM        VARCHAR2(30 BYTE)                  NULL,
  EXP_DES        VARCHAR2(1000 BYTE)                NULL,
  EXP_PARNUM001  NUMBER(15,3)                       NULL,
  EXP_PARNUM002  NUMBER(15,3)                       NULL,
  EXP_PARNUM003  NUMBER(15,3)                       NULL,
  EXP_PARNUM004  NUMBER(15,3)                       NULL,
  EXP_PARNUM005  NUMBER(15,3)                       NULL,
  EXP_PARTXT001  VARCHAR2(60 BYTE)                  NULL,
  EXP_PARTXT002  VARCHAR2(60 BYTE)                  NULL,
  EXP_PARTXT003  VARCHAR2(60 BYTE)                  NULL,
  EXP_PARTXT004  VARCHAR2(60 BYTE)                  NULL,
  EXP_PARTXT005  VARCHAR2(60 BYTE)                  NULL,
  EXP_DATMOD     DATE                               NULL,
  EXP_USUMOD     VARCHAR2(30 BYTE)                  NULL
)
;


CREATE TABLE TRMA_FAM
(
  FAM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FAM_COD      VARCHAR2(4 BYTE)                     NULL,
  FAM_DATCRE   DATE                                 NULL,
  FAM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FAM_NOM      VARCHAR2(30 BYTE)                    NULL,
  FAM_DES      VARCHAR2(1000 BYTE)                  NULL,
  FAM_DATMOD   DATE                                 NULL,
  FAM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  FAM_RLE_COD  VARCHAR2(30 BYTE)                    NULL,
  FAM_DIPMAX   NUMBER(5)                            NULL
)
;


CREATE TABLE TRMA_FFM
(
  FFM_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  FFM_COD        NUMBER(10)                         NULL,
  FFM_DIA        DATE                               NULL,
  FFM_OPE_COD    VARCHAR2(6 BYTE)                   NULL,
  FFM_DATCRE     DATE                               NULL,
  FFM_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  FFM_REF        VARCHAR2(20 BYTE)                  NULL,
  FFM_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  FFM_PRE_COD    NUMBER(10)                         NULL,
  FFM_CAP_COD    VARCHAR2(4 BYTE)                   NULL,
  FFM_PDA_COD    VARCHAR2(4 BYTE)                   NULL,
  FFM_PRJ_NUM    VARCHAR2(6 BYTE)                   NULL,
  FFM_OBS        VARCHAR2(1000 BYTE)                NULL,
  FFM_DATMOD     DATE                               NULL,
  FFM_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  FFM_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  FFM_DOC        VARCHAR2(60 BYTE)                  NULL,
  FFM_VALDIVEUR  NUMBER(15,8)                       NULL,
  FFM_CLI_COD    VARCHAR2(6 BYTE)                   NULL,
  FFM_ETP_COD    VARCHAR2(4 BYTE)                   NULL,
  FFM_ETP_NUM    NUMBER(3)                          NULL,
  FFM_UCE_SEQ    NUMBER(10)                         NULL,
  FFM_LES_SEQ    NUMBER(10)                         NULL,
  FFM_RLE_COD    VARCHAR2(30 BYTE)                  NULL
)
;


CREATE TABLE TRMA_FRB
(
  FRB_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FRB_COD      VARCHAR2(6 BYTE)                     NULL,
  FRB_DATCRE   DATE                                 NULL,
  FRB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FRB_NOM      VARCHAR2(60 BYTE)                    NULL,
  FRB_OBS      VARCHAR2(1000 BYTE)                  NULL,
  FRB_DATMOD   DATE                                 NULL,
  FRB_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_GRA
(
  GRA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  GRA_COD      VARCHAR2(4 BYTE)                     NULL,
  GRA_DATCRE   DATE                                 NULL,
  GRA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  GRA_NOM      VARCHAR2(30 BYTE)                    NULL,
  GRA_DES      VARCHAR2(1000 BYTE)                  NULL,
  GRA_DATMOD   DATE                                 NULL,
  GRA_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_LLC
(
  LLC_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  LLC_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  LLC_EXP_COD  VARCHAR2(6 BYTE)                     NULL,
  LLC_COD      VARCHAR2(4 BYTE)                     NULL,
  LLC_DATCRE   DATE                                 NULL,
  LLC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  LLC_NOM      VARCHAR2(30 BYTE)                    NULL,
  LLC_DES      VARCHAR2(1000 BYTE)                  NULL,
  LLC_DATMOD   DATE                                 NULL,
  LLC_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_MAQ
(
  MAQ_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  MAQ_COD         VARCHAR2(15 BYTE)                 NULL,
  MAQ_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  MAQ_FAM_COD     VARCHAR2(4 BYTE)                  NULL,
  MAQ_TIM_COD     VARCHAR2(4 BYTE)                  NULL,
  MAQ_PVPUNI      NUMBER(15,2)                      NULL,
  MAQ_DATCRE      DATE                              NULL,
  MAQ_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  MAQ_EST         NUMBER(1)                         NULL,
  MAQ_EXP_COD     VARCHAR2(6 BYTE)                  NULL,
  MAQ_FRB_COD     VARCHAR2(6 BYTE)                  NULL,
  MAQ_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  MAQ_LLC_COD     VARCHAR2(4 BYTE)                  NULL,
  MAQ_DATCPR      DATE                              NULL,
  MAQ_NOM         VARCHAR2(30 BYTE)                 NULL,
  MAQ_CTECMP      VARCHAR2(10 BYTE)                 NULL,
  MAQ_DES         VARCHAR2(1000 BYTE)               NULL,
  MAQ_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  MAQ_DATMOD      DATE                              NULL,
  MAQ_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  MAQ_CMA_COD     VARCHAR2(15 BYTE)                 NULL,
  MAQ_PVPCPL      NUMBER(15,2)                      NULL,
  MAQ_TIPCTL      NUMBER(1)                         NULL,
  MAQ_CTECMPLEA   VARCHAR2(10 BYTE)                 NULL,
  MAQ_LEAVNT      VARCHAR2(1 BYTE)              DEFAULT 'N'                       NULL,
  MAQ_PRUCPR      NUMBER(15,2)                      NULL,
  MAQ_TAR         NUMBER(18,2)                      NULL,
  MAQ_PMA         NUMBER(18,2)                      NULL,
  MAQ_CLT_COD     VARCHAR2(4 BYTE)                  NULL,
  MAQ_NUMSER      VARCHAR2(15 BYTE)                 NULL,
  MAQ_NUMCER      VARCHAR2(15 BYTE)                 NULL,
  MAQ_NUMIDF      VARCHAR2(30 BYTE)                 NULL,
  MAQ_MCA         VARCHAR2(40 BYTE)                 NULL,
  MAQ_TIP         VARCHAR2(40 BYTE)                 NULL,
  MAQ_VAR         VARCHAR2(40 BYTE)                 NULL,
  MAQ_DENCML      VARCHAR2(40 BYTE)                 NULL,
  MAQ_MTMA_MMA    NUMBER(15,2)                      NULL,
  MAQ_MTMA_MMA1E  NUMBER(15,2)                      NULL,
  MAQ_MTMA_MMA3E  NUMBER(15,2)                      NULL,
  MAQ_MTMA_MMA4E  NUMBER(15,2)                      NULL,
  MAQ_MMR_S_F     NUMBER(15,2)                      NULL,
  MAQ_MMR_C_F     NUMBER(15,2)                      NULL,
  MAQ_NEUMA       VARCHAR2(40 BYTE)                 NULL,
  MAQ_NUMASI      VARCHAR2(40 BYTE)                 NULL,
  MAQ_VOLBOD      VARCHAR2(40 BYTE)                 NULL,
  MAQ_CLAS        VARCHAR2(40 BYTE)                 NULL,
  MAQ_ALT         NUMBER(15,2)                      NULL,
  MAQ_ANCH        NUMBER(15,2)                      NULL,
  MAQ_VIAANT      NUMBER(15,2)                      NULL,
  MAQ_VIAPOST     NUMBER(15,2)                      NULL,
  MAQ_VOLPOST     NUMBER(15,2)                      NULL,
  MAQ_LONG        NUMBER(15,2)                      NULL,
  MAQ_DISEJE12    NUMBER(15,2)                      NULL,
  MAQ_DISEJE23    NUMBER(15,2)                      NULL,
  MAQ_DISEJE34    NUMBER(15,2)                      NULL,
  MAQ_DIS5        NUMBER(15,2)                      NULL,
  MAQ_MOTMCA      VARCHAR2(40 BYTE)                 NULL,
  MAQ_MOTTIP      VARCHAR2(40 BYTE)                 NULL,
  MAQ_NUMCIL      NUMBER(15,2)                      NULL,
  MAQ_CIL         NUMBER(15,2)                      NULL,
  MAQ_POTFIS      NUMBER(15,2)                      NULL,
  MAQ_POTREAL     NUMBER(15,2)                      NULL,
  MAQ_OPC         VARCHAR2(1000 BYTE)               NULL,
  MAQ_OBS         VARCHAR2(1000 BYTE)               NULL,
  MAQ_REFO        VARCHAR2(1000 BYTE)               NULL,
  MAQ_MTMA_MMA2E  NUMBER(15,2)                      NULL,
  MAQ_MTR         VARCHAR2(15 BYTE)                 NULL,
  MAQ_MMQ_COD     VARCHAR2(6 BYTE)                  NULL,
  MAQ_GENOBS      VARCHAR2(2500 BYTE)               NULL,
  MAQ_PTEFNR      NUMBER(5,2)                       NULL,
  MAQ_TRG_COD     VARCHAR2(4 BYTE)                  NULL,
  MAQ_TGTNUM      VARCHAR2(30 BYTE)                 NULL,
  MAQ_CODEXTCMB   VARCHAR2(60 BYTE)                 NULL,
  MAQ_TAL_COD     VARCHAR2(4 BYTE)                  NULL,
  MAQ_EMP_CODTAL  VARCHAR2(4 BYTE)                  NULL,
  MAQ_CPL         VARCHAR2(1 BYTE)                  NULL,
  MAQ_COSKMT      NUMBER(15,5)                      NULL,
  MAQ_APP         VARCHAR2(2 BYTE)                  NULL,
  MAQ_TIPCPL      NUMBER(1)                         NULL
)
;


CREATE TABLE TRMA_MES
(
  MES_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  MES_REF         NUMBER(10)                        NULL,
  MES_DATSOR      DATE                              NULL,
  MES_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  MES_DATCRE      DATE                              NULL,
  MES_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  MES_DATENT      DATE                              NULL,
  MES_DATNOTDEV   DATE                              NULL,
  MES_OPE_CODSOR  VARCHAR2(6 BYTE)                  NULL,
  MES_OPE_CODENT  VARCHAR2(6 BYTE)                  NULL,
  MES_OBSSOR      VARCHAR2(1000 BYTE)               NULL,
  MES_OBSENT      VARCHAR2(1000 BYTE)               NULL,
  MES_OBSNOTDEV   VARCHAR2(1000 BYTE)               NULL,
  MES_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  MES_EXP_COD     VARCHAR2(6 BYTE)                  NULL,
  MES_LLC_COD     VARCHAR2(4 BYTE)                  NULL,
  MES_PRE_COD     NUMBER(10)                        NULL,
  MES_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL,
  MES_DATMOD      DATE                              NULL,
  MES_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  MES_HORSOR      DATE                              NULL,
  MES_HORENT      DATE                              NULL
)
;


CREATE TABLE TRMA_MNT
(
  MNT_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  MNT_COD        VARCHAR2(4 BYTE)                   NULL,
  MNT_DES        VARCHAR2(60 BYTE)                  NULL,
  MNT_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  MNT_DATCRE     DATE                               NULL,
  MNT_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  MNT_TRV_COD    VARCHAR2(4 BYTE)                   NULL,
  MNT_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  MNT_DATMOD     DATE                               NULL,
  MNT_FITPRTACT  VARCHAR2(500 BYTE)                 NULL
)
;


CREATE TABLE TRMA_MTM
(
  MTM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  MTM_MNT_COD  VARCHAR2(4 BYTE)                     NULL,
  MTM_TIM_COD  VARCHAR2(4 BYTE)                     NULL,
  MTM_TEM      NUMBER(5,2)                          NULL,
  MTM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  MTM_DATCRE   DATE                                 NULL,
  MTM_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  MTM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  MTM_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRMA_REP
(
  REP_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  REP_MAQ_COD    VARCHAR2(15 BYTE)                  NULL,
  REP_NUM        NUMBER(10)                         NULL,
  REP_DIA        DATE                               NULL,
  REP_DIAFIN     DATE                               NULL,
  REP_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  REP_VALDIVEUR  VARCHAR2(15 BYTE)                  NULL,
  REP_DATCRE     DATE                               NULL,
  REP_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  REP_DES        VARCHAR2(1000 BYTE)                NULL,
  REP_OBS        VARCHAR2(1000 BYTE)                NULL,
  REP_DATMOD     DATE                               NULL,
  REP_USUMOD     VARCHAR2(30 BYTE)                  NULL
)
;


CREATE TABLE TRMA_TRE
(
  TRE_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  TRE_MNT_COD    VARCHAR2(4 BYTE)                   NULL,
  TRE_ORD        NUMBER(10)                         NULL,
  TRE_DES        VARCHAR2(60 BYTE)                  NULL,
  TRE_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  TRE_DATCRE     DATE                               NULL,
  TRE_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  TRE_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  TRE_DATMOD     DATE                               NULL,
  TRE_FITPRTACT  VARCHAR2(500 BYTE)                 NULL,
  TRE_HOR        NUMBER(5,2)                        NULL
)
;


CREATE TABLE TRMA_TRR
(
  TRR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRR_MNT_COD  VARCHAR2(4 BYTE)                     NULL,
  TRR_TRE_ORD  NUMBER(10)                           NULL,
  TRR_COD      VARCHAR2(6 BYTE)                     NULL,
  TRR_DES      VARCHAR2(60 BYTE)                    NULL,
  TRR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TRR_DATCRE   DATE                                 NULL,
  TRR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  TRR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TRR_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRMA_VAT
(
  VAT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  VAT_TRG_COD  VARCHAR2(4 BYTE)                     NULL,
  VAT_ORD      NUMBER(2)                            NULL,
  VAT_CAM_COD  VARCHAR2(4 BYTE)                     NULL,
  VAT_DATCRE   DATE                                 NULL,
  VAT_USUCRE   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_VCM
(
  VCM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  VCM_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  VCM_TCM_COD  VARCHAR2(4 BYTE)                     NULL,
  VCM_DATCRE   DATE                                 NULL,
  VCM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VCM_DIV_COD  VARCHAR2(4 BYTE)                     NULL,
  VCM_VAL      NUMBER(12,3)                         NULL,
  VCM_ULTACL   DATE                                 NULL,
  VCM_COSUNI   NUMBER(15,3)                         NULL,
  VCM_PRDUNI   NUMBER(15,3)                         NULL,
  VCM_PRDTEM   NUMBER(5)                            NULL,
  VCM_DATMOD   DATE                                 NULL,
  VCM_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE INDEX IRMA_CLT_IDF_FK_I ON TRMA_CLT
(CLT_IDF_COD)
;


CREATE INDEX IRMA_CMB002_IDF_FK ON TRMA_CMB002
(CMB_IDF_COD)
;


CREATE INDEX IRMA_CNT_IDF_FK ON TRMA_CNT
(CNT_IDF_COD)
;


CREATE INDEX IRMA_EMP_DIV_FK_I ON TRMA_EMP
(EMP_DIV_COD, EMP_IDF_COD)
;


CREATE INDEX IRMA_EMP_IDF_FK_I ON TRMA_EMP
(EMP_IDF_COD)
;


CREATE INDEX IRMA_EXP_EMP_FK_I ON TRMA_EXP
(EXP_EMP_COD, EXP_IDF_COD)
;


CREATE INDEX IRMA_FAM_IDF_FK_I ON TRMA_FAM
(FAM_IDF_COD)
;


CREATE INDEX IRMA_FFM_CAP_FK_I ON TRMA_FFM
(FFM_CAP_COD, FFM_PRE_COD, FFM_EMP_COD, FFM_IDF_COD)
;


CREATE INDEX IRMA_FFM_CLI_FK ON TRMA_FFM
(FFM_CLI_COD, FFM_IDF_COD)
;


CREATE INDEX IRMA_FFM_DIV_FK ON TRMA_FFM
(FFM_DIV_COD, FFM_IDF_COD)
;


CREATE INDEX IRMA_FFM_IDF_FK_I ON TRMA_FFM
(FFM_IDF_COD)
;


CREATE INDEX IRMA_FFM_OPE_FK_I ON TRMA_FFM
(FFM_OPE_COD, FFM_IDF_COD)
;


CREATE INDEX IRMA_FFM_PDA_FK_I ON TRMA_FFM
(FFM_PDA_COD, FFM_CAP_COD, FFM_PRE_COD, FFM_EMP_COD, FFM_IDF_COD)
;


CREATE INDEX IRMA_FFM_PRE_FK_I ON TRMA_FFM
(FFM_PRE_COD, FFM_EMP_COD, FFM_IDF_COD)
;


CREATE INDEX IRMA_FFM_PRJ_FK_I ON TRMA_FFM
(FFM_PRJ_NUM, FFM_EMP_COD, FFM_IDF_COD)
;


CREATE INDEX IRMA_FRB_IDF_FK_I ON TRMA_FRB
(FRB_IDF_COD)
;


CREATE INDEX IRMA_GRA_IDF_FK_I ON TRMA_GRA
(GRA_IDF_COD)
;


CREATE INDEX IRMA_LLC_EXP_FK_I ON TRMA_LLC
(LLC_EXP_COD, LLC_EMP_COD, LLC_IDF_COD)
;


CREATE INDEX IRMA_MAQ_EMP_FK_I ON TRMA_MAQ
(MAQ_EMP_COD, MAQ_IDF_COD)
;


CREATE INDEX IRMA_MAQ_EXP_FK_I ON TRMA_MAQ
(MAQ_EXP_COD, MAQ_EMP_COD, MAQ_IDF_COD)
;


CREATE INDEX IRMA_MAQ_FAM_FK_I ON TRMA_MAQ
(MAQ_FAM_COD, MAQ_IDF_COD)
;


CREATE INDEX IRMA_MAQ_FRB_FK_I ON TRMA_MAQ
(MAQ_FRB_COD, MAQ_IDF_COD)
;


CREATE INDEX IRMA_MAQ_LLC_FK_I ON TRMA_MAQ
(MAQ_LLC_COD, MAQ_EXP_COD, MAQ_IDF_COD, MAQ_EMP_COD)
;


CREATE INDEX IRMA_MAQ_MAQ_FK ON TRMA_MAQ
(MAQ_CMA_COD, MAQ_IDF_COD)
;


CREATE INDEX IRMA_MAQ_MMQ_FK_I ON TRMA_MAQ
(MAQ_IDF_COD, MAQ_MMQ_COD)
;


CREATE INDEX IRMA_MAQ_OPE_FK_I ON TRMA_MAQ
(MAQ_OPE_COD, MAQ_IDF_COD)
;


CREATE INDEX IRMA_MAQ_TIM_FK_I ON TRMA_MAQ
(MAQ_TIM_COD, MAQ_IDF_COD)
;


CREATE INDEX IRMA_MES_IDF_FK_I ON TRMA_MES
(MES_IDF_COD)
;


CREATE INDEX IRMA_MES_LLC_FK_I ON TRMA_MES
(MES_LLC_COD, MES_EXP_COD, MES_IDF_COD, MES_EMP_COD)
;


CREATE INDEX IRMA_MES_MAQ_FK_I ON TRMA_MES
(MES_MAQ_COD, MES_IDF_COD)
;


CREATE INDEX IRMA_MES_OPEENT_FK_I ON TRMA_MES
(MES_OPE_CODENT, MES_IDF_COD)
;


CREATE INDEX IRMA_MES_OPESOR_FK_I ON TRMA_MES
(MES_OPE_CODSOR, MES_IDF_COD)
;


CREATE INDEX IRMA_MES_PRE_FK_I ON TRMA_MES
(MES_PRE_COD, MES_IDF_COD, MES_EMP_COD)
;


CREATE INDEX IRMA_MES_PRJ_FK_I ON TRMA_MES
(MES_PRJ_NUM, MES_EMP_COD, MES_IDF_COD)
;


CREATE INDEX IRMA_REP_DIV_FK_I ON TRMA_REP
(REP_DIV_COD, REP_IDF_COD)
;


CREATE INDEX IRMA_REP_MAQ_FK_I ON TRMA_REP
(REP_MAQ_COD, REP_IDF_COD)
;


CREATE INDEX IRMA_TRR_TRE_FK ON TRMA_TRR
(TRR_IDF_COD, TRR_MNT_COD, TRR_TRE_ORD)
;


CREATE INDEX IRMA_VCM_DIV_FK_I ON TRMA_VCM
(VCM_DIV_COD, VCM_IDF_COD)
;


CREATE INDEX IRMA_VCM_MAQ_FK_I ON TRMA_VCM
(VCM_MAQ_COD, VCM_IDF_COD)
;


CREATE INDEX IRMA_VCM_TCM_FK_I ON TRMA_VCM
(VCM_TCM_COD, VCM_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_CAM_PK ON TRMA_CAM
(CAM_IDF_COD, CAM_COD)
;


CREATE UNIQUE INDEX RRMA_CLT_PK ON TRMA_CLT
(CLT_IDF_COD, CLT_COD)
;


CREATE UNIQUE INDEX RRMA_CMB002_PK ON TRMA_CMB002
(CMB_IDF_COD, CMB_REF)
;


CREATE UNIQUE INDEX RRMA_CNT_PK ON TRMA_CNT
(CNT_IDF_COD, CNT_COD)
;


CREATE UNIQUE INDEX RRMA_CPA_PK ON TRMA_CPA
(CPA_IDF_COD, CPA_COD)
;


CREATE UNIQUE INDEX RRMA_EMP_PK ON TRMA_EMP
(EMP_COD, EMP_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_EXP_PK ON TRMA_EXP
(EXP_COD, EXP_EMP_COD, EXP_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_FAM_PK ON TRMA_FAM
(FAM_COD, FAM_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_FFM_PK ON TRMA_FFM
(FFM_COD, FFM_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_FRB_PK ON TRMA_FRB
(FRB_COD, FRB_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_GRA_PK ON TRMA_GRA
(GRA_COD, GRA_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_LLC_PK ON TRMA_LLC
(LLC_COD, LLC_EXP_COD, LLC_EMP_COD, LLC_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_MAQ_PK ON TRMA_MAQ
(MAQ_COD, MAQ_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_MES_PK ON TRMA_MES
(MES_REF, MES_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_MNT_PK ON TRMA_MNT
(MNT_IDF_COD, MNT_COD)
;


CREATE UNIQUE INDEX RRMA_MTM_PK ON TRMA_MTM
(MTM_IDF_COD, MTM_MNT_COD, MTM_TIM_COD)
;


CREATE UNIQUE INDEX RRMA_REP_PK ON TRMA_REP
(REP_MAQ_COD, REP_NUM, REP_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_TRE_PK ON TRMA_TRE
(TRE_IDF_COD, TRE_MNT_COD, TRE_ORD)
;


CREATE UNIQUE INDEX RRMA_TRR_PK ON TRMA_TRR
(TRR_IDF_COD, TRR_EMP_COD, TRR_MNT_COD, TRR_TRE_ORD, TRR_COD)
;


CREATE UNIQUE INDEX RRMA_VAT_PK ON TRMA_VAT
(VAT_IDF_COD, VAT_TRG_COD, VAT_ORD)
;


CREATE UNIQUE INDEX RRMA_VAT_UK ON TRMA_VAT
(VAT_IDF_COD, VAT_TRG_COD, VAT_CAM_COD)
;


CREATE UNIQUE INDEX RRMA_VCM_PK ON TRMA_VCM
(VCM_MAQ_COD, VCM_TCM_COD, VCM_IDF_COD)
;


CREATE OR REPLACE FORCE VIEW VRMA_CSMCMB
AS 
SELECT distinct maq_idf_cod, MAQ_EMP_COD, MAQ_COD, MAQ_NOM, MAQ_MMQ_COD, MMQ_DES, MAQ_FAM_COD,
                FAM_nom, maq_clt_cod, mmq_csmmig CONSUMOMEDIO, maq_exp_cod
FROM trma_maq, TRMA_MMQ, TRMA_FAM
WHERE MMQ_IDF_COD (+) = MAQ_IDF_COD
AND MMQ_COD (+) = MAQ_MMQ_COD
AND FAM_IDF_COD = MAQ_IDF_COD
AND FAM_COD = MAQ_FAM_COD;


CREATE OR REPLACE FORCE VIEW VRMA_INR
AS 
select INR_IDF_COD, INR_COD, INR_DAT, INR_TIPENT, INR_MAQ_COD, INR_TGTNUM, INR_PTHIMG, INR_PESBSC, MAQ_NOM
from trma_inr, trma_maq
where inr_idf_cod = maq_idf_cod (+)
and inr_maq_cod = maq_cod (+);


CREATE OR REPLACE FORCE VIEW VRMA_MAQ
AS 
SELECT MAQ_IDF_COD IDENTIFICADOR, PGES_DES.IDF(MAQ_IDF_COD) IDENTIFICADOR_NOMBRE, MAQ_COD CODIGO_MAQUINA, 
              MAQ_NOM NOMBRE_MAQUINA, MAQ_DES DESCRIPCION, MAQ_EMP_COD EMPRESA, PGES_DES.EMP(MAQ_IDF_COD,MAQ_EMP_COD) EMPRESA_NOMBRE, 
              MAQ_FAM_COD FAMILIA, FAM_NOM FAMILIA_NOMBRE, MAQ_TIM_COD TIPO, TIM_NOM TIPO_NOMBRE, MAQ_PVPUNI COSTE_UNIDAD, 
              MAQ_EST ESTADO, MAQ_OPE_COD OPERARIO, PGES_DES.OPE(MAQ_IDF_COD,MAQ_OPE_COD) OPERARIO_NOMBRE, 
              MAQ_EXP_COD EXPLOTACION, EXP_NOM EXPLOTACION_NOMBRE, MAQ_FRB_COD FABRICANTE, FRB_NOM FABRICANTE_NOMBRE, 
              MAQ_LLC_COD LUGAR, LLC_NOM LUGAR_NOMBRE,MAQ_DATCPR FECHA_ADQUISICION, MAQ_CTECMP CUENTA_CONTABLE, 
              MAQ_MAQ_COD CODIGO_ALTERNATIVO, 
              MAQ_CMA_COD MAQUINA_COMPLEMENTARIA, MAQ_PVPCPL COSTE_COMPLEMENTARIA,   TRMA_VAL_DAT(MAQ_IDF_COD,MAQ_COD,'000001') "Data de compra",  TRMA_VAL_NUM(MAQ_IDF_COD,MAQ_COD,'000002') "Import compra",  TRMA_VAL_DES(MAQ_IDF_COD,MAQ_COD,'000003') "01-COMPANIA DE SEGUROS" FROM    TRMA_MAQ, TRMA_FAM, TRMA_TIM, TRMA_FRB, TRMA_EXP, TRMA_LLC  WHERE  MAQ_IDF_COD = '8290' AND MAQ_IDF_COD = FAM_IDF_COD  AND MAQ_FAM_COD = FAM_COD  AND MAQ_IDF_COD = TIM_IDF_COD  AND MAQ_TIM_COD = TIM_COD  AND MAQ_IDF_COD = FRB_IDF_COD(+)  AND MAQ_FRB_COD = FRB_COD(+)  AND MAQ_IDF_COD = EXP_IDF_COD(+)  AND MAQ_EMP_COD = EXP_EMP_COD(+) AND MAQ_EXP_COD = EXP_COD(+)  AND MAQ_IDF_COD = LLC_IDF_COD(+)  AND MAQ_EMP_COD = LLC_EMP_COD(+) AND MAQ_EXP_COD = LLC_EXP_COD(+)
                          AND MAQ_LLC_COD = LLC_COD(+);


CREATE TABLE TRMA_AGN
(
  AGN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  AGN_REF      NUMBER(10)                           NULL,
  AGN_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  AGN_DIAENT   DATE                                 NULL,
  AGN_EST      NUMBER(1)                            NULL,
  AGN_DATCRE   DATE                                 NULL,
  AGN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  AGN_TCM_COD  VARCHAR2(4 BYTE)                     NULL,
  AGN_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  AGN_TRV_COD  VARCHAR2(4 BYTE)                     NULL,
  AGN_TCO_COD  VARCHAR2(4 BYTE)                     NULL,
  AGN_DIAVEN   DATE                                 NULL,
  AGN_VALCNT   NUMBER(15,2)                         NULL,
  AGN_DATMOD   DATE                                 NULL,
  AGN_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  AGN_CNC      VARCHAR2(1000 BYTE)                  NULL,
  AGN_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRMA_AMM
(
  AMM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  AMM_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  AMM_ANO      NUMBER(4)                            NULL,
  AMM_MES      NUMBER(2)                            NULL,
  AMM_IMP      NUMBER(15,3)                         NULL,
  AMM_DIV_COD  VARCHAR2(4 BYTE)                     NULL,
  AMM_DATCRE   DATE                                 NULL,
  AMM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  AMM_AUT      VARCHAR2(1 BYTE)                     NULL,
  AMM_DATMOD   DATE                                 NULL,
  AMM_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_ARE
(
  ARE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  ARE_MNT_COD  VARCHAR2(4 BYTE)                     NULL,
  ARE_TIM_COD  VARCHAR2(4 BYTE)                     NULL,
  ARE_NUM      NUMBER(10)                           NULL,
  ARE_ART_COD  VARCHAR2(15 BYTE)                    NULL,
  ARE_UNI      NUMBER(15,3)                         NULL,
  ARE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ARE_DATCRE   DATE                                 NULL,
  ARE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  ARE_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  ARE_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRMA_ATR
(
  ATR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  ATR_COD      VARCHAR2(6 BYTE)                     NULL,
  ATR_TIP      NUMBER(1)                            NULL,
  ATR_GRA_COD  VARCHAR2(4 BYTE)                     NULL,
  ATR_DATCRE   DATE                                 NULL,
  ATR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ATR_NOM      VARCHAR2(30 BYTE)                    NULL,
  ATR_DES      VARCHAR2(1000 BYTE)                  NULL,
  ATR_DATMOD   DATE                                 NULL,
  ATR_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_CMB
(
  CMB_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  CMB_REF         NUMBER(10)                        NULL,
  CMB_DIA         DATE                              NULL,
  CMB_LIT         NUMBER(10,3)                      NULL,
  CMB_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  CMB_ART_COD     VARCHAR2(15 BYTE)                 NULL,
  CMB_DIV_COD     VARCHAR2(4 BYTE)                  NULL,
  CMB_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  CMB_DATCRE      DATE                              NULL,
  CMB_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  CMB_HOR         DATE                              NULL,
  CMB_DES         VARCHAR2(60 BYTE)                 NULL,
  CMB_PRU         NUMBER(17,5)                      NULL,
  CMB_UNI         NUMBER(15,2)                      NULL,
  CMB_STD         VARCHAR2(6 BYTE)                  NULL,
  CMB_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  CMB_ALB_NUMDOC  NUMBER(10)                        NULL,
  CMB_LAC_NUM     NUMBER(10)                        NULL,
  CMB_DATMOD      DATE                              NULL,
  CMB_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  CMB_CPO_COD     VARCHAR2(8 BYTE)                  NULL,
  CMB_EMP_CODCMB  VARCHAR2(4 BYTE)                  NULL,
  CMB_ALBMAN      VARCHAR2(10 BYTE)                 NULL,
  CMB_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL
)
;


CREATE TABLE TRMA_CPM
(
  CPM_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  CPM_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  CPM_MAQ_COD002  VARCHAR2(15 BYTE)                 NULL
)
;


CREATE TABLE TRMA_FAT
(
  FAT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FAT_FAM_COD  VARCHAR2(4 BYTE)                     NULL,
  FAT_ATR_COD  VARCHAR2(6 BYTE)                     NULL,
  FAT_DATCRE   DATE                                 NULL,
  FAT_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FAT_DATMOD   DATE                                 NULL,
  FAT_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_IND
(
  IND_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  IND_REF         NUMBER(10)                        NULL,
  IND_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  IND_TPI_COD     VARCHAR2(4 BYTE)                  NULL,
  IND_DATRGT      DATE                              NULL,
  IND_DATIND      DATE                              NULL,
  IND_DATCRE      DATE                              NULL,
  IND_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  IND_EST         NUMBER(1)                         NULL,
  IND_OPE_CODENT  VARCHAR2(6 BYTE)                  NULL,
  IND_AGN_REF     NUMBER(10)                        NULL,
  IND_TRS_COD     VARCHAR2(4 BYTE)                  NULL,
  IND_DES         VARCHAR2(1000 BYTE)               NULL,
  IND_DATSOL      DATE                              NULL,
  IND_OPE_CODFIN  VARCHAR2(6 BYTE)                  NULL,
  IND_DESSOL      VARCHAR2(1000 BYTE)               NULL,
  IND_OBS         VARCHAR2(1000 BYTE)               NULL,
  IND_DATMOD      DATE                              NULL,
  IND_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TRMA_ITE
(
  ITE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  ITE_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  ITE_REF      NUMBER(10)                           NULL,
  ITE_DIA      DATE                                 NULL,
  ITE_DIV_COD  VARCHAR2(4 BYTE)                     NULL,
  ITE_IMP      NUMBER(15,2)                         NULL,
  ITE_DATCRE   DATE                                 NULL,
  ITE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ITE_DES      VARCHAR2(60 BYTE)                    NULL,
  ITE_OBS      VARCHAR2(1000 BYTE)                  NULL,
  ITE_DATMOD   DATE                                 NULL,
  ITE_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_ITR
(
  ITR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  ITR_MNT_COD  VARCHAR2(4 BYTE)                     NULL,
  ITR_TRE_ORD  NUMBER(10)                           NULL,
  ITR_SEQ      NUMBER(3)                            NULL,
  ITR_DES      VARCHAR2(150 BYTE)                   NULL,
  ITR_FITDOC   VARCHAR2(250 BYTE)                   NULL,
  ITR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ITR_DATCRE   DATE                                 NULL,
  ITR_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  ITR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  ITR_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRMA_MAO
(
  MAO_SEQ         NUMBER(10)                        NULL,
  MAO_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  MAO_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  MAO_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  MAO_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL,
  MAO_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  MAO_DATCRE      DATE                              NULL,
  MAO_DATINI      DATE                              NULL,
  MAO_DATFIN      DATE                              NULL,
  MAO_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  MAO_DATMOD      DATE                              NULL,
  MAO_OBS         VARCHAR2(1000 BYTE)               NULL,
  MAO_PTE         NUMBER(5,2)                       NULL,
  MAO_ETP_COD001  VARCHAR2(4 BYTE)                  NULL,
  MAO_UCE_SEQ001  NUMBER(18)                        NULL,
  MAO_LES_SEQ001  NUMBER(18)                        NULL,
  MAO_ETP_COD002  VARCHAR2(4 BYTE)                  NULL,
  MAO_UCE_SEQ002  NUMBER(18)                        NULL,
  MAO_LES_SEQ002  NUMBER(18)                        NULL,
  MAO_ETP_COD003  VARCHAR2(4 BYTE)                  NULL,
  MAO_UCE_SEQ003  NUMBER(18)                        NULL,
  MAO_LES_SEQ003  NUMBER(18)                        NULL,
  MAO_ETP_COD004  VARCHAR2(4 BYTE)                  NULL,
  MAO_UCE_SEQ004  NUMBER(18)                        NULL,
  MAO_LES_SEQ004  NUMBER(18)                        NULL,
  MAO_PTE001      NUMBER(5,2)                       NULL,
  MAO_PTE002      NUMBER(5,2)                       NULL,
  MAO_PTE003      NUMBER(5,2)                       NULL,
  MAO_PTE004      NUMBER(5,2)                       NULL
)
;


CREATE TABLE TRMA_TMA
(
  TMA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TMA_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  TMA_TRG_COD  VARCHAR2(4 BYTE)                     NULL,
  TMA_VAT_ORD  NUMBER(2)                            NULL,
  TMA_DATCRE   DATE                                 NULL,
  TMA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TMA_VAL      VARCHAR2(1024 BYTE)                  NULL,
  TMA_DATMOD   DATE                                 NULL,
  TMA_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_VAL
(
  VAL_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  VAL_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  VAL_ATR_COD  VARCHAR2(6 BYTE)                     NULL,
  VAL_DATCRE   DATE                                 NULL,
  VAL_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VAL_NUM      NUMBER(15,3)                         NULL,
  VAL_DAT      DATE                                 NULL,
  VAL_DES      VARCHAR2(60 BYTE)                    NULL,
  VAL_DATMOD   DATE                                 NULL,
  VAL_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE INDEX IRMA_AGN_IDF_FK_I ON TRMA_AGN
(AGN_IDF_COD)
;


CREATE INDEX IRMA_AGN_MAQ_FK_I ON TRMA_AGN
(AGN_MAQ_COD, AGN_IDF_COD)
;


CREATE INDEX IRMA_AGN_OPE_FK_I ON TRMA_AGN
(AGN_OPE_COD, AGN_IDF_COD)
;


CREATE INDEX IRMA_AGN_TCM_FK_I ON TRMA_AGN
(AGN_TCM_COD, AGN_IDF_COD)
;


CREATE INDEX IRMA_AGN_TCO_FK_I ON TRMA_AGN
(AGN_TCO_COD, AGN_IDF_COD)
;


CREATE INDEX IRMA_AGN_TRV_FK_I ON TRMA_AGN
(AGN_TRV_COD, AGN_IDF_COD)
;


CREATE INDEX IRMA_AMM_DIV_FK ON TRMA_AMM
(AMM_DIV_COD, AMM_IDF_COD)
;


CREATE INDEX IRMA_AMM_MAQ_FK ON TRMA_AMM
(AMM_MAQ_COD, AMM_IDF_COD)
;


CREATE INDEX IRMA_ATR_GRA_FK_I ON TRMA_ATR
(ATR_GRA_COD, ATR_IDF_COD)
;


CREATE INDEX IRMA_ATR_IDF_FK_I ON TRMA_ATR
(ATR_IDF_COD)
;


CREATE INDEX IRMA_CMB_IDF_FK ON TRMA_CMB
(CMB_IDF_COD)
;


CREATE INDEX IRMA_CMB_MAQ_FK ON TRMA_CMB
(CMB_IDF_COD, CMB_MAQ_COD)
;


CREATE INDEX IRMA_FAT_ATR_FK_I ON TRMA_FAT
(FAT_ATR_COD, FAT_IDF_COD)
;


CREATE INDEX IRMA_FAT_FAM_FK_I ON TRMA_FAT
(FAT_FAM_COD, FAT_IDF_COD)
;


CREATE INDEX IRMA_IND_AGN_FK_I ON TRMA_IND
(IND_AGN_REF, IND_IDF_COD)
;


CREATE INDEX IRMA_IND_IDF_FK_I ON TRMA_IND
(IND_IDF_COD)
;


CREATE INDEX IRMA_IND_MAQ_FK_I ON TRMA_IND
(IND_MAQ_COD, IND_IDF_COD)
;


CREATE INDEX IRMA_IND_OPEENT_FK_I ON TRMA_IND
(IND_OPE_CODENT, IND_IDF_COD)
;


CREATE INDEX IRMA_IND_OPEFIN_FK_I ON TRMA_IND
(IND_OPE_CODFIN, IND_IDF_COD)
;


CREATE INDEX IRMA_IND_TPI_FK_I ON TRMA_IND
(IND_TPI_COD, IND_IDF_COD)
;


CREATE INDEX IRMA_IND_TRS_FK_I ON TRMA_IND
(IND_TRS_COD, IND_IDF_COD)
;


CREATE INDEX IRMA_ITE_DIV_FK_I ON TRMA_ITE
(ITE_DIV_COD, ITE_IDF_COD)
;


CREATE INDEX IRMA_ITE_MAQ_FK_I ON TRMA_ITE
(ITE_MAQ_COD, ITE_IDF_COD)
;


CREATE INDEX IRMA_ITR_TRE_FK ON TRMA_ITR
(ITR_IDF_COD, ITR_EMP_COD, ITR_MNT_COD, ITR_TRE_ORD)
;


CREATE INDEX IRMA_MAO_MAQ_FK ON TRMA_MAO
(MAO_IDF_COD, MAO_MAQ_COD)
;


CREATE INDEX IRMA_MAO_PRJ_FK ON TRMA_MAO
(MAO_IDF_COD, MAO_EMP_COD, MAO_PRJ_NUM)
;


CREATE INDEX IRMA_TRMA_MAQ002_FK ON TRMA_CPM
(CPM_IDF_COD, CPM_MAQ_COD002)
;


CREATE INDEX IRMA_TRMA_MAQ_FK ON TRMA_CPM
(CPM_IDF_COD, CPM_MAQ_COD)
;


CREATE INDEX IRMA_VAL_ATR_FK_I ON TRMA_VAL
(VAL_ATR_COD, VAL_IDF_COD)
;


CREATE INDEX IRMA_VAL_MAQ_FK_I ON TRMA_VAL
(VAL_MAQ_COD, VAL_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_AGN_PK ON TRMA_AGN
(AGN_REF, AGN_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_AMM_PK ON TRMA_AMM
(AMM_MAQ_COD, AMM_IDF_COD, AMM_ANO, AMM_MES)
;


CREATE UNIQUE INDEX RRMA_ARE_PK ON TRMA_ARE
(ARE_IDF_COD, ARE_MNT_COD, ARE_TIM_COD, ARE_NUM)
;


CREATE UNIQUE INDEX RRMA_ATR_PK ON TRMA_ATR
(ATR_COD, ATR_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_CMB_PK ON TRMA_CMB
(CMB_IDF_COD, CMB_REF)
;


CREATE UNIQUE INDEX RRMA_FAT_PK ON TRMA_FAT
(FAT_ATR_COD, FAT_FAM_COD, FAT_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_IND_PK ON TRMA_IND
(IND_REF, IND_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_ITE_PK ON TRMA_ITE
(ITE_REF, ITE_MAQ_COD, ITE_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_ITR_PK ON TRMA_ITR
(ITR_IDF_COD, ITR_EMP_COD, ITR_MNT_COD, ITR_TRE_ORD, ITR_SEQ)
;


CREATE UNIQUE INDEX RRMA_MAO_MAO2_UK001 ON TRMA_MAO
(MAO_IDF_COD, MAO_MAQ_COD, MAO_EMP_COD, MAO_PRJ_NUM, MAO_DATINI)
;


CREATE UNIQUE INDEX RRMA_MAO_MAO3_UK002 ON TRMA_MAO
(MAO_IDF_COD, MAO_MAQ_COD, MAO_EMP_COD, MAO_PRJ_NUM, MAO_DATINI, 
MAO_DATFIN)
;


CREATE UNIQUE INDEX RRMA_MAO_PK ON TRMA_MAO
(MAO_SEQ)
;


CREATE UNIQUE INDEX RRMA_TMA_PK ON TRMA_TMA
(TMA_IDF_COD, TMA_MAQ_COD, TMA_TRG_COD, TMA_VAT_ORD)
;


CREATE UNIQUE INDEX RRMA_VAL_PK ON TRMA_VAL
(VAL_ATR_COD, VAL_MAQ_COD, VAL_IDF_COD)
;


CREATE UNIQUE INDEX TRMA_CPM_PK ON TRMA_CPM
(CPM_IDF_COD, CPM_MAQ_COD, CPM_MAQ_COD002)
;


CREATE OR REPLACE FORCE VIEW VRMA_AMM
AS 
SELECT
AMM_IDF_COD, AMM_MAQ_COD, AMM_ANO as amm_ano, AMM_MES, AMM_IMP, AMM_DIV_COD, amm_aut
from trma_amm;


CREATE OR REPLACE FORCE VIEW VRMA_APIMAQCPL
AS 
SELECT 'S' escpl, maq_idf_cod, maq_emp_cod, CPM_MAQ_COD, maq_cod, maq_nom, maq_cma_cod, maq_tipcpl, maq_datmod, maq_datcre, maq_cpl, 'S' maq_app, maq_est, maq_ope_cod 
   FROM  trma_cpm, trma_maq 
   WHERE maq_idf_cod = cpm_idf_cod AND maq_cod = CPM_MAQ_COD002 
union all 
   SELECT 'S' escpl,maq_idf_cod, maq_emp_cod, null CPM_MAQ_COD, maq_cod, maq_nom, maq_cma_cod, maq_tipcpl, maq_datmod, maq_datcre, maq_cpl, maq_app, maq_est, maq_ope_cod 
   FROM   trma_maq 
   WHERE (maq_cma_cod is not null or nvl(maq_cpl, 'N') = 'S') and nvl(maq_app, 'N') = 'S' 
union all 
   SELECT 'N' escpl, maq_idf_cod, maq_emp_cod, null CPM_MAQ_COD, maq_cod, maq_nom, maq_cma_cod, maq_tipcpl, maq_datmod, maq_datcre, maq_cpl, maq_app, maq_est, maq_ope_cod 
   FROM   trma_maq 
   WHERE (maq_cma_cod is null and nvl(maq_cpl, 'N') = 'N') and nvl(maq_app, 'N') = 'S';


CREATE OR REPLACE FORCE VIEW VRMA_REVMAQ
AS 
SELECT 
  maq_emp_codtal, maq_tal_cod, tal_nom, 
  agn_ref, 
  agn_maq_cod || ' ' || maq_nom Maquina, 
  agn_maq_cod, 
  maq_nom, 
  agn_trv_cod || ' ' || trv_nom TipoRevision, 
  agn_trv_cod, 
  trv_nom, 
  agn_cnc Concepto, 
  agn_diaven Vencimiento, 
  agn_tcm_cod || ' ' || tcm_nom TipoContador, 
  agn_tcm_cod, 
  tcm_nom, 
  decode(agn_est, 
  0, 
  'Pendiente', 
  1, 
  'Iniciado', 
  2, 
  'Terminado') Estado, 
  agn_idf_cod, 
  vcm_val vcm_valact, 
  agn_valcnt valprevisto, 
  agn_est, 
  '' Tipo, 
  decode(least(trunc(sysdate, 
  'DD')-trunc(agn_diaven, 
  'DD'), 
  0), 
  0, 
  'Quedan: ' ||  ' ' /*to_char(trunc(sysdate, 
  'DD')-trunc(agn_diaven, 
  'DD'))*/ || ' Días', 
  trunc(sysdate, 
  'DD')-trunc(agn_diaven, 
  'DD'), 
  'Superado en: ' || to_char(abs(trunc(sysdate, 
  'DD')-trunc(agn_diaven, 
  'DD'))) || ' Días'        ) Informe, 
  decode(agn_valcnt, 
  least(vcm_val, 
  agn_valcnt), 
  0, 
  1) Ord, 
  nvl(TRMA_VAL_DES (agn_idf_cod, 
  agn_maq_cod, 
  frma_parametre(agn_idf_cod, 
  'P_ATRMTR', '')), 
  MAQ_MTR) Matricula, 
  maq_ope_cod operario_cod, 
  ope_nom operario_nom 
FROM trma_maq, trma_agn, trma_trv, trma_tcm, trma_vcm, trhu_ope, tges_tal 
WHERE 
  maq_cod = agn_maq_cod  AND 
  maq_idf_cod = agn_idf_cod AND 
  trv_cod(+) = agn_trv_cod AND 
  trv_idf_cod(+) = agn_idf_cod AND 
  tcm_cod(+) = agn_tcm_cod AND 
  tcm_idf_cod(+) = agn_idf_cod AND 
  agn_idf_cod = vcm_idf_cod(+) AND 
  agn_tcm_cod = vcm_tcm_cod(+) AND 
  agn_maq_cod = vcm_maq_cod(+) AND 
  maq_idf_cod = ope_idf_cod(+) AND 
  maq_ope_cod = ope_cod(+) and 
  tal_idf_cod(+) = maq_idf_cod and 
  tal_emp_cod(+) = maq_emp_codtal and 
  tal_cod(+) = maq_tal_cod;


CREATE TABLE TRMA_COS
(
  COS_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  COS_COD        NUMBER(10)                         NULL,
  COS_TCO_COD    VARCHAR2(4 BYTE)                   NULL,
  COS_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  COS_DATCRE     DATE                               NULL,
  COS_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  COS_VALDIVEUR  VARCHAR2(15 BYTE)                  NULL,
  COS_IMP        NUMBER(15,2)                       NULL,
  COS_AGN_REF    NUMBER(10)                         NULL,
  COS_IND_REF    NUMBER(10)                         NULL,
  COS_MAQ_COD    VARCHAR2(15 BYTE)                  NULL,
  COS_REP_NUM    NUMBER(10)                         NULL,
  COS_DES        VARCHAR2(30 BYTE)                  NULL,
  COS_OBS        VARCHAR2(1000 BYTE)                NULL,
  COS_DATMOD     DATE                               NULL,
  COS_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  COS_DIA        DATE                               NULL,
  COS_EST        NUMBER(1)                          NULL,
  COS_KMS        NUMBER                             NULL,
  COS_CPA_COD    VARCHAR2(4 BYTE)                   NULL,
  COS_TRS        VARCHAR2(1 BYTE)                   NULL,
  COS_EXCCMP     VARCHAR2(4 BYTE)                   NULL,
  COS_DRICMP     VARCHAR2(2 BYTE)                   NULL,
  COS_ASICMP     NUMBER(10)                         NULL
)
;


CREATE TABLE TRMA_FEM
(
  FEM_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  FEM_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  FEM_FFM_COD     NUMBER(10)                        NULL,
  FEM_DATCRE      DATE                              NULL,
  FEM_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  FEM_UNITRE      NUMBER(15,2)                      NULL,
  FEM_ITE_REF     NUMBER(10)                        NULL,
  FEM_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  FEM_ALB_NUMDOC  NUMBER(10)                        NULL,
  FEM_LAC_NUM     NUMBER(10)                        NULL,
  FEM_DATMOD      DATE                              NULL,
  FEM_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  FEM_PRU         NUMBER(17,5)                      NULL
)
;


CREATE TABLE TRMA_LRP
(
  LRP_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  LRP_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  LRP_REP_NUM  NUMBER(10)                           NULL,
  LRP_NUMLIN   NUMBER(10)                           NULL,
  LRP_TCO_COD  VARCHAR2(4 BYTE)                     NULL,
  LRP_DATCRE   DATE                                 NULL,
  LRP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  LRP_COS_COD  NUMBER(10)                           NULL,
  LRP_ART_COD  VARCHAR2(15 BYTE)                    NULL,
  LRP_UNI      NUMBER(10,3)                         NULL,
  LRP_PRU      NUMBER(15,3)                         NULL,
  LRP_DES      VARCHAR2(60 BYTE)                    NULL,
  LRP_OBS      VARCHAR2(1000 BYTE)                  NULL,
  LRP_DATMOD   DATE                                 NULL,
  LRP_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRMA_VLF
(
  VLF_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  VLF_TCM_COD  VARCHAR2(4 BYTE)                     NULL,
  VLF_MAQ_COD  VARCHAR2(15 BYTE)                    NULL,
  VLF_FFM_COD  NUMBER(10)                           NULL,
  VLF_UNI      NUMBER(12,3)                         NULL,
  VLF_DATCRE   DATE                                 NULL,
  VLF_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VLF_VALINI   NUMBER(12,3)                         NULL,
  VLF_VALFIN   NUMBER(12,3)                         NULL,
  VLF_DATMOD   DATE                                 NULL,
  VLF_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE INDEX IRMA_COS_AGN_FK_I ON TRMA_COS
(COS_AGN_REF, COS_IDF_COD)
;


CREATE INDEX IRMA_COS_DIV_FK_I ON TRMA_COS
(COS_DIV_COD, COS_IDF_COD)
;


CREATE INDEX IRMA_COS_IDF_FK_I ON TRMA_COS
(COS_IDF_COD)
;


CREATE INDEX IRMA_COS_IND_FK_I ON TRMA_COS
(COS_IND_REF, COS_IDF_COD)
;


CREATE INDEX IRMA_COS_MAQ_FK_I ON TRMA_COS
(COS_MAQ_COD, COS_IDF_COD)
;


CREATE INDEX IRMA_COS_REP_FK_I ON TRMA_COS
(COS_REP_NUM, COS_MAQ_COD, COS_IDF_COD)
;


CREATE INDEX IRMA_COS_TCO_FK_I ON TRMA_COS
(COS_TCO_COD, COS_IDF_COD)
;


CREATE INDEX IRMA_FEM_FFM_FK_I ON TRMA_FEM
(FEM_FFM_COD, FEM_IDF_COD)
;


CREATE INDEX IRMA_FEM_ITE_FK_I ON TRMA_FEM
(FEM_ITE_REF, FEM_MAQ_COD, FEM_IDF_COD)
;


CREATE INDEX IRMA_FEM_LAC_FK_I ON TRMA_FEM
(FEM_ALB_NUMDOC, FEM_LAC_NUM, FEM_EMP_COD, FEM_IDF_COD)
;


CREATE INDEX IRMA_FEM_MAQ_FK_I ON TRMA_FEM
(FEM_MAQ_COD, FEM_IDF_COD)
;


CREATE INDEX IRMA_LRP_ART_FK_I ON TRMA_LRP
(LRP_ART_COD, LRP_IDF_COD)
;


CREATE INDEX IRMA_LRP_COS_FK_I ON TRMA_LRP
(LRP_COS_COD, LRP_IDF_COD)
;


CREATE INDEX IRMA_LRP_REP_FK_I ON TRMA_LRP
(LRP_REP_NUM, LRP_MAQ_COD, LRP_IDF_COD)
;


CREATE INDEX IRMA_LRP_TCO_FK_I ON TRMA_LRP
(LRP_TCO_COD, LRP_IDF_COD)
;


CREATE INDEX IRMA_VLF_FEM_FK_I ON TRMA_VLF
(VLF_MAQ_COD, VLF_FFM_COD, VLF_IDF_COD)
;


CREATE INDEX IRMA_VLF_TCM_FK_I ON TRMA_VLF
(VLF_TCM_COD, VLF_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_COS_PK ON TRMA_COS
(COS_COD, COS_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_FEM_PK ON TRMA_FEM
(FEM_FFM_COD, FEM_MAQ_COD, FEM_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_LRP_PK ON TRMA_LRP
(LRP_REP_NUM, LRP_MAQ_COD, LRP_NUMLIN, LRP_IDF_COD)
;


CREATE UNIQUE INDEX RRMA_VLF_PK ON TRMA_VLF
(VLF_TCM_COD, VLF_MAQ_COD, VLF_FFM_COD, VLF_IDF_COD)
;


CREATE OR REPLACE FORCE VIEW VRMA_COSMAQPRJ
AS 
select ffm_idf_cod,ffm_emp_cod,ffm_prj_num, prj_nom, nvl(prj_div_cod,ffm_div_cod) as div_cod,
ffm_dia, to_char(ffm_dia, 'YYYY') as ffm_any, to_char(ffm_dia,'MM') as ffm_mes,
fem_maq_cod,nvl(fem_unitre,0) as fem_unitre,
fges_canvi_divisa(ffm_idf_cod,nvl(fem_pru,0),ffm_div_cod, nvl(prj_div_cod,ffm_div_cod) ) as fem_pru,
fges_canvi_divisa(ffm_idf_cod,nvl(fem_unitre,0) * nvl(fem_pru,0),ffm_div_cod, nvl(prj_div_cod,ffm_div_cod) ) as fem_imp
from trma_ffm,trma_fem, tges_prj
where fem_idf_cod = ffm_idf_cod and fem_ffm_cod = ffm_cod
and prj_idf_cod(+) = ffm_idf_cod and prj_emp_cod(+) = ffm_emp_cod and prj_num(+) = ffm_prj_num;


ALTER TABLE TRMA_EPR ADD (
  CONSTRAINT PK_TRMA_EPR
 PRIMARY KEY
 (EPR_IDF_COD, EPR_EMP_COD, EPR_PRJ_NUM)
    USING INDEX 
    );

ALTER TABLE TRMA_GCR ADD (
  CONSTRAINT RRMA_GCR_PK
 PRIMARY KEY
 (GCR_IDF_COD, GCR_EMP_COD, GCR_DAT, GCR_TIP, GCR_SIM)
    USING INDEX 
    );

ALTER TABLE TRMA_IDF ADD (
  CONSTRAINT RRMA_IDF_PK
 PRIMARY KEY
 (IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_INR ADD (
  CONSTRAINT RRMA_INR_PK
 PRIMARY KEY
 (INR_IDF_COD, INR_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_MMQ ADD (
  CONSTRAINT RRMA_MMQ_PK
 PRIMARY KEY
 (MMQ_IDF_COD, MMQ_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_PAC ADD (
  CONSTRAINT RRMA_PAC_PK
 PRIMARY KEY
 (PAC_IDF_COD, PAC_SEQ));

ALTER TABLE TRMA_PRC ADD (
  CONSTRAINT RRMA_PRC_PK
 PRIMARY KEY
 (PRC_IDF_COD, PRC_SEQ));

ALTER TABLE TRMA_SEG ADD (
  CONSTRAINT RRMA_SEG_PK
 PRIMARY KEY
 (SEG_IDF_COD, SEG_PAC_SEQ, SEG_SEQ)
    USING INDEX 
    );

ALTER TABLE TRMA_SRC ADD (
  CONSTRAINT RRMA_SRC_PK
 PRIMARY KEY
 (SRC_IDF_COD, SRC_PRC_SEQ, SRC_SEQ)
    USING INDEX 
    );

ALTER TABLE TRMA_TCM ADD (
  CONSTRAINT RRMA_TCM_PK
 PRIMARY KEY
 (TCM_COD, TCM_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TCO ADD (
  CONSTRAINT RRMA_TCO_PK
 PRIMARY KEY
 (TCO_COD, TCO_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TIM ADD (
  CONSTRAINT RRMA_TIM_PK
 PRIMARY KEY
 (TIM_COD, TIM_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TPI ADD (
  CONSTRAINT RRMA_TPI_PK
 PRIMARY KEY
 (TPI_COD, TPI_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TRA ADD (
  CONSTRAINT RRMA_TRA_PK
 PRIMARY KEY
 (TRA_IDF_COD, TRA_EMP_COD, TRA_DAT, TRA_PRJ_NUM, TRA_OPE_COD, TRA_MAQ_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TRG ADD (
  CONSTRAINT RRMA_TRG_PK
 PRIMARY KEY
 (TRG_IDF_COD, TRG_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TRS ADD (
  CONSTRAINT RRMA_TRS_PK
 PRIMARY KEY
 (TRS_COD, TRS_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TRV ADD (
  CONSTRAINT RRMA_TRV_PK
 PRIMARY KEY
 (TRV_COD, TRV_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TZN ADD (
  CONSTRAINT RRMA_TZN_PK
 PRIMARY KEY
 (TZN_IDF_COD, TZN_EMP_COD, TZN_ZONCOD, TZN_SIM, TZN_HORINI)
    USING INDEX 
    );

ALTER TABLE TRMA_CAM ADD (
  CONSTRAINT RRMA_CAM_PK
 PRIMARY KEY
 (CAM_IDF_COD, CAM_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_CLT ADD (
  CONSTRAINT RRMA_CLT_PK
 PRIMARY KEY
 (CLT_IDF_COD, CLT_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_CMB002 ADD (
  CONSTRAINT RRMA_CMB002_PK
 PRIMARY KEY
 (CMB_IDF_COD, CMB_REF)
    USING INDEX 
    );

ALTER TABLE TRMA_CNT ADD (
  CONSTRAINT RRMA_CNT_PK
 PRIMARY KEY
 (CNT_IDF_COD, CNT_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_CPA ADD (
  CONSTRAINT RRMA_CPA_PK
 PRIMARY KEY
 (CPA_IDF_COD, CPA_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_EMP ADD (
  CONSTRAINT RRMA_EMP_PK
 PRIMARY KEY
 (EMP_COD, EMP_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_EXP ADD (
  CONSTRAINT RRMA_EXP_PK
 PRIMARY KEY
 (EXP_COD, EXP_EMP_COD, EXP_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_FAM ADD (
  CONSTRAINT RRMA_FAM_PK
 PRIMARY KEY
 (FAM_COD, FAM_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_FFM ADD (
  CONSTRAINT RRMA_FFM_PK
 PRIMARY KEY
 (FFM_COD, FFM_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_FRB ADD (
  CONSTRAINT RRMA_FRB_PK
 PRIMARY KEY
 (FRB_COD, FRB_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_GRA ADD (
  CONSTRAINT RRMA_GRA_PK
 PRIMARY KEY
 (GRA_COD, GRA_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_LLC ADD (
  CONSTRAINT RRMA_LLC_PK
 PRIMARY KEY
 (LLC_COD, LLC_EXP_COD, LLC_EMP_COD, LLC_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_MAQ ADD (
  CONSTRAINT RRMA_MAQ_PK
 PRIMARY KEY
 (MAQ_COD, MAQ_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_MES ADD (
  CONSTRAINT RRMA_MES_PK
 PRIMARY KEY
 (MES_REF, MES_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_MNT ADD (
  CONSTRAINT RRMA_MNT_PK
 PRIMARY KEY
 (MNT_IDF_COD, MNT_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_MTM ADD (
  CONSTRAINT RRMA_MTM_PK
 PRIMARY KEY
 (MTM_IDF_COD, MTM_MNT_COD, MTM_TIM_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_REP ADD (
  CONSTRAINT RRMA_REP_PK
 PRIMARY KEY
 (REP_MAQ_COD, REP_NUM, REP_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_TRE ADD (
  CONSTRAINT RRMA_TRE_PK
 PRIMARY KEY
 (TRE_IDF_COD, TRE_MNT_COD, TRE_ORD)
    USING INDEX 
    );

ALTER TABLE TRMA_TRR ADD (
  CONSTRAINT RRMA_TRR_PK
 PRIMARY KEY
 (TRR_IDF_COD, TRR_EMP_COD, TRR_MNT_COD, TRR_TRE_ORD, TRR_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_VAT ADD (
  CONSTRAINT RRMA_VAT_PK
 PRIMARY KEY
 (VAT_IDF_COD, VAT_TRG_COD, VAT_ORD)
    USING INDEX 
    ,
  CONSTRAINT RRMA_VAT_UK
 UNIQUE (VAT_IDF_COD, VAT_TRG_COD, VAT_CAM_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_VCM ADD (
  CONSTRAINT RRMA_VCM_PK
 PRIMARY KEY
 (VCM_MAQ_COD, VCM_TCM_COD, VCM_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_AGN ADD (
  CONSTRAINT RRMA_AGN_PK
 PRIMARY KEY
 (AGN_REF, AGN_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_AMM ADD (
  CONSTRAINT RRMA_AMM_PK
 PRIMARY KEY
 (AMM_MAQ_COD, AMM_IDF_COD, AMM_ANO, AMM_MES)
    USING INDEX 
    );

ALTER TABLE TRMA_ARE ADD (
  CONSTRAINT RRMA_ARE_PK
 PRIMARY KEY
 (ARE_IDF_COD, ARE_MNT_COD, ARE_TIM_COD, ARE_NUM)
    USING INDEX 
    );

ALTER TABLE TRMA_ATR ADD (
  CONSTRAINT RRMA_ATR_PK
 PRIMARY KEY
 (ATR_COD, ATR_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_CMB ADD (
  CONSTRAINT RRMA_CMB_PK
 PRIMARY KEY
 (CMB_IDF_COD, CMB_REF)
    USING INDEX 
    );

ALTER TABLE TRMA_CPM ADD (
  CONSTRAINT TRMA_CPM_PK
 PRIMARY KEY
 (CPM_IDF_COD, CPM_MAQ_COD, CPM_MAQ_COD002)
    USING INDEX 
    );

ALTER TABLE TRMA_FAT ADD (
  CONSTRAINT RRMA_FAT_PK
 PRIMARY KEY
 (FAT_ATR_COD, FAT_FAM_COD, FAT_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_IND ADD (
  CONSTRAINT RRMA_IND_PK
 PRIMARY KEY
 (IND_REF, IND_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_ITE ADD (
  CONSTRAINT RRMA_ITE_PK
 PRIMARY KEY
 (ITE_REF, ITE_MAQ_COD, ITE_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_ITR ADD (
  CONSTRAINT RRMA_ITR_PK
 PRIMARY KEY
 (ITR_IDF_COD, ITR_EMP_COD, ITR_MNT_COD, ITR_TRE_ORD, ITR_SEQ)
    USING INDEX 
    );

ALTER TABLE TRMA_MAO ADD (
  CONSTRAINT RRMA_MAO_PK
 PRIMARY KEY
 (MAO_SEQ)
    USING INDEX 
    ,
  CONSTRAINT RRMA_MAO_MAO2_UK001
 UNIQUE (MAO_IDF_COD, MAO_MAQ_COD, MAO_EMP_COD, MAO_PRJ_NUM, MAO_DATINI)
    USING INDEX 
    ,
  CONSTRAINT RRMA_MAO_MAO3_UK002
 UNIQUE (MAO_IDF_COD, MAO_MAQ_COD, MAO_EMP_COD, MAO_PRJ_NUM, MAO_DATINI, MAO_DATFIN)
    USING INDEX 
    );

ALTER TABLE TRMA_TMA ADD (
  CONSTRAINT RRMA_TMA_PK
 PRIMARY KEY
 (TMA_IDF_COD, TMA_MAQ_COD, TMA_TRG_COD, TMA_VAT_ORD)
    USING INDEX 
    );

ALTER TABLE TRMA_VAL ADD (
  CONSTRAINT RRMA_VAL_PK
 PRIMARY KEY
 (VAL_ATR_COD, VAL_MAQ_COD, VAL_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_COS ADD (
  CONSTRAINT RRMA_COS_PK
 PRIMARY KEY
 (COS_COD, COS_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_FEM ADD (
  CONSTRAINT RRMA_FEM_PK
 PRIMARY KEY
 (FEM_FFM_COD, FEM_MAQ_COD, FEM_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_LRP ADD (
  CONSTRAINT RRMA_LRP_PK
 PRIMARY KEY
 (LRP_REP_NUM, LRP_MAQ_COD, LRP_NUMLIN, LRP_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_VLF ADD (
  CONSTRAINT RRMA_VLF_PK
 PRIMARY KEY
 (VLF_TCM_COD, VLF_MAQ_COD, VLF_FFM_COD, VLF_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_SEG ADD (
  CONSTRAINT RRMA_SEG_PAC_FK 
 FOREIGN KEY (SEG_IDF_COD, SEG_PAC_SEQ) 
 REFERENCES TRMA_PAC (PAC_IDF_COD,PAC_SEQ));

ALTER TABLE TRMA_SRC ADD (
  CONSTRAINT RRMA_SRC_PRC_FK 
 FOREIGN KEY (SRC_IDF_COD, SRC_PRC_SEQ) 
 REFERENCES TRMA_PRC (PRC_IDF_COD,PRC_SEQ));

ALTER TABLE TRMA_TCM ADD (
  CONSTRAINT RRMA_TCM_IDF_FK 
 FOREIGN KEY (TCM_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_TCO ADD (
  CONSTRAINT RRMA_TCO_IDF_FK 
 FOREIGN KEY (TCO_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_TIM ADD (
  CONSTRAINT RRMA_TIM_IDF_FK 
 FOREIGN KEY (TIM_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_TPI ADD (
  CONSTRAINT RRMA_TPI_IDF_FK 
 FOREIGN KEY (TPI_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_TRG ADD (
  CONSTRAINT RRMA_TRG_IDF_FK 
 FOREIGN KEY (TRG_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_TRS ADD (
  CONSTRAINT RRMA_TRS_IDF_FK 
 FOREIGN KEY (TRS_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_TRV ADD (
  CONSTRAINT RRMA_TRV_IDF_FK 
 FOREIGN KEY (TRV_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD),
  CONSTRAINT RRMA_TRV_TCO_FK 
 FOREIGN KEY (TRV_TCO_COD, TRV_IDF_COD) 
 REFERENCES TRMA_TCO (TCO_COD,TCO_IDF_COD));

ALTER TABLE TRMA_CAM ADD (
  CONSTRAINT RRMA_CAM_IDF_FK 
 FOREIGN KEY (CAM_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_CLT ADD (
  CONSTRAINT RRMA_CLT_IDF_FK 
 FOREIGN KEY (CLT_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_CMB002 ADD (
  CONSTRAINT RRMA_CMB002_IDF_FK 
 FOREIGN KEY (CMB_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_CNT ADD (
  CONSTRAINT RRMA_CNT_IDF_FK 
 FOREIGN KEY (CNT_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_CPA ADD (
  CONSTRAINT RRMA_CPA_IDF_FK 
 FOREIGN KEY (CPA_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_EMP ADD (
  CONSTRAINT RRMA_EMP_IDF_FK 
 FOREIGN KEY (EMP_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_EXP ADD (
  CONSTRAINT RRMA_EXP_EMP_FK 
 FOREIGN KEY (EXP_EMP_COD, EXP_IDF_COD) 
 REFERENCES TRMA_EMP (EMP_COD,EMP_IDF_COD));

ALTER TABLE TRMA_FAM ADD (
  CONSTRAINT RRMA_FAM_IDF_FK 
 FOREIGN KEY (FAM_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_FFM ADD (
  CONSTRAINT RRMA_FFM_IDF_FK 
 FOREIGN KEY (FFM_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_FRB ADD (
  CONSTRAINT RRMA_FRB_IDF_FK 
 FOREIGN KEY (FRB_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_GRA ADD (
  CONSTRAINT RRMA_GRA_IDF_FK 
 FOREIGN KEY (GRA_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_LLC ADD (
  CONSTRAINT RRMA_LLC_EXP_FK 
 FOREIGN KEY (LLC_EXP_COD, LLC_EMP_COD, LLC_IDF_COD) 
 REFERENCES TRMA_EXP (EXP_COD,EXP_EMP_COD,EXP_IDF_COD));

ALTER TABLE TRMA_MAQ ADD (
  CONSTRAINT RRMA_MAQ_CLT_FK 
 FOREIGN KEY (MAQ_IDF_COD, MAQ_CLT_COD) 
 REFERENCES TRMA_CLT (CLT_IDF_COD,CLT_COD),
  CONSTRAINT RRMA_MAQ_EMP_FK 
 FOREIGN KEY (MAQ_EMP_COD, MAQ_IDF_COD) 
 REFERENCES TRMA_EMP (EMP_COD,EMP_IDF_COD),
  CONSTRAINT RRMA_MAQ_EXP_FK 
 FOREIGN KEY (MAQ_EXP_COD, MAQ_EMP_COD, MAQ_IDF_COD) 
 REFERENCES TRMA_EXP (EXP_COD,EXP_EMP_COD,EXP_IDF_COD),
  CONSTRAINT RRMA_MAQ_FAM_FK 
 FOREIGN KEY (MAQ_FAM_COD, MAQ_IDF_COD) 
 REFERENCES TRMA_FAM (FAM_COD,FAM_IDF_COD),
  CONSTRAINT RRMA_MAQ_FRB_FK 
 FOREIGN KEY (MAQ_FRB_COD, MAQ_IDF_COD) 
 REFERENCES TRMA_FRB (FRB_COD,FRB_IDF_COD),
  CONSTRAINT RRMA_MAQ_LLC_FK 
 FOREIGN KEY (MAQ_LLC_COD, MAQ_EXP_COD, MAQ_EMP_COD, MAQ_IDF_COD) 
 REFERENCES TRMA_LLC (LLC_COD,LLC_EXP_COD,LLC_EMP_COD,LLC_IDF_COD),
  CONSTRAINT RRMA_MAQ_MAQ_FK 
 FOREIGN KEY (MAQ_CMA_COD, MAQ_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD),
  CONSTRAINT RRMA_MAQ_MMQ_FK 
 FOREIGN KEY (MAQ_IDF_COD, MAQ_MMQ_COD) 
 REFERENCES TRMA_MMQ (MMQ_IDF_COD,MMQ_COD),
  CONSTRAINT RRMA_MAQ_TIM_FK 
 FOREIGN KEY (MAQ_TIM_COD, MAQ_IDF_COD) 
 REFERENCES TRMA_TIM (TIM_COD,TIM_IDF_COD),
  CONSTRAINT RRMA_MAQ_TRG_FK 
 FOREIGN KEY (MAQ_IDF_COD, MAQ_TRG_COD) 
 REFERENCES TRMA_TRG (TRG_IDF_COD,TRG_COD));

ALTER TABLE TRMA_MES ADD (
  CONSTRAINT RRMA_MES_IDF_FK 
 FOREIGN KEY (MES_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD),
  CONSTRAINT RRMA_MES_LLC_FK 
 FOREIGN KEY (MES_LLC_COD, MES_EXP_COD, MES_EMP_COD, MES_IDF_COD) 
 REFERENCES TRMA_LLC (LLC_COD,LLC_EXP_COD,LLC_EMP_COD,LLC_IDF_COD),
  CONSTRAINT RRMA_MES_MAQ_FK 
 FOREIGN KEY (MES_MAQ_COD, MES_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_MNT ADD (
  CONSTRAINT RRMA_MNT_TRV_FK 
 FOREIGN KEY (MNT_TRV_COD, MNT_IDF_COD) 
 REFERENCES TRMA_TRV (TRV_COD,TRV_IDF_COD));

ALTER TABLE TRMA_MTM ADD (
  CONSTRAINT RRMA_MTM_MNT_FK 
 FOREIGN KEY (MTM_IDF_COD, MTM_MNT_COD) 
 REFERENCES TRMA_MNT (MNT_IDF_COD,MNT_COD),
  CONSTRAINT RRMA_MTM_TIM_FK 
 FOREIGN KEY (MTM_TIM_COD, MTM_IDF_COD) 
 REFERENCES TRMA_TIM (TIM_COD,TIM_IDF_COD));

ALTER TABLE TRMA_REP ADD (
  CONSTRAINT RRMA_REP_MAQ_FK 
 FOREIGN KEY (REP_MAQ_COD, REP_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_TRE ADD (
  CONSTRAINT RRMA_TRE_MNT_FK 
 FOREIGN KEY (TRE_IDF_COD, TRE_MNT_COD) 
 REFERENCES TRMA_MNT (MNT_IDF_COD,MNT_COD));

ALTER TABLE TRMA_TRR ADD (
  CONSTRAINT RRMA_TRR_TRE_FK 
 FOREIGN KEY (TRR_IDF_COD, TRR_MNT_COD, TRR_TRE_ORD) 
 REFERENCES TRMA_TRE (TRE_IDF_COD,TRE_MNT_COD,TRE_ORD));

ALTER TABLE TRMA_VAT ADD (
  CONSTRAINT RRMA_VAT_CAM_FK 
 FOREIGN KEY (VAT_IDF_COD, VAT_CAM_COD) 
 REFERENCES TRMA_CAM (CAM_IDF_COD,CAM_COD),
  CONSTRAINT RRMA_VAT_TRG_FK 
 FOREIGN KEY (VAT_IDF_COD, VAT_TRG_COD) 
 REFERENCES TRMA_TRG (TRG_IDF_COD,TRG_COD));

ALTER TABLE TRMA_VCM ADD (
  CONSTRAINT RRMA_VCM_MAQ_FK 
 FOREIGN KEY (VCM_MAQ_COD, VCM_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD),
  CONSTRAINT RRMA_VCM_TCM_FK 
 FOREIGN KEY (VCM_TCM_COD, VCM_IDF_COD) 
 REFERENCES TRMA_TCM (TCM_COD,TCM_IDF_COD));

ALTER TABLE TRMA_AGN ADD (
  CONSTRAINT RRMA_AGN_IDF_FK 
 FOREIGN KEY (AGN_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD),
  CONSTRAINT RRMA_AGN_MAQ_FK 
 FOREIGN KEY (AGN_MAQ_COD, AGN_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD),
  CONSTRAINT RRMA_AGN_TCM_FK 
 FOREIGN KEY (AGN_TCM_COD, AGN_IDF_COD) 
 REFERENCES TRMA_TCM (TCM_COD,TCM_IDF_COD),
  CONSTRAINT RRMA_AGN_TCO_FK 
 FOREIGN KEY (AGN_TCO_COD, AGN_IDF_COD) 
 REFERENCES TRMA_TCO (TCO_COD,TCO_IDF_COD),
  CONSTRAINT RRMA_AGN_TRV_FK 
 FOREIGN KEY (AGN_TRV_COD, AGN_IDF_COD) 
 REFERENCES TRMA_TRV (TRV_COD,TRV_IDF_COD));

ALTER TABLE TRMA_AMM ADD (
  CONSTRAINT RRMA_AMM_MAQ_FK 
 FOREIGN KEY (AMM_MAQ_COD, AMM_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_ARE ADD (
  CONSTRAINT RRMA_ARE_MTM_FK 
 FOREIGN KEY (ARE_IDF_COD, ARE_MNT_COD, ARE_TIM_COD) 
 REFERENCES TRMA_MTM (MTM_IDF_COD,MTM_MNT_COD,MTM_TIM_COD));

ALTER TABLE TRMA_ATR ADD (
  CONSTRAINT RRMA_ATR_GRA_FK 
 FOREIGN KEY (ATR_GRA_COD, ATR_IDF_COD) 
 REFERENCES TRMA_GRA (GRA_COD,GRA_IDF_COD),
  CONSTRAINT RRMA_ATR_IDF_FK 
 FOREIGN KEY (ATR_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD));

ALTER TABLE TRMA_CMB ADD (
  CONSTRAINT RRMA_CMB_IDF_FK 
 FOREIGN KEY (CMB_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD),
  CONSTRAINT RRMA_CMB_MAQ_FK 
 FOREIGN KEY (CMB_MAQ_COD, CMB_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_CPM ADD (
  CONSTRAINT RRMA_TRMA_MAQ002_FK 
 FOREIGN KEY (CPM_MAQ_COD002, CPM_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD),
  CONSTRAINT RRMA_TRMA_MAQ_FK 
 FOREIGN KEY (CPM_MAQ_COD, CPM_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_FAT ADD (
  CONSTRAINT RRMA_FAT_ATR_FK 
 FOREIGN KEY (FAT_ATR_COD, FAT_IDF_COD) 
 REFERENCES TRMA_ATR (ATR_COD,ATR_IDF_COD),
  CONSTRAINT RRMA_FAT_FAM_FK 
 FOREIGN KEY (FAT_FAM_COD, FAT_IDF_COD) 
 REFERENCES TRMA_FAM (FAM_COD,FAM_IDF_COD));

ALTER TABLE TRMA_IND ADD (
  CONSTRAINT RRMA_IND_AGN_FK 
 FOREIGN KEY (IND_AGN_REF, IND_IDF_COD) 
 REFERENCES TRMA_AGN (AGN_REF,AGN_IDF_COD),
  CONSTRAINT RRMA_IND_IDF_FK 
 FOREIGN KEY (IND_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD),
  CONSTRAINT RRMA_IND_MAQ_FK 
 FOREIGN KEY (IND_MAQ_COD, IND_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD),
  CONSTRAINT RRMA_IND_TPI_FK 
 FOREIGN KEY (IND_TPI_COD, IND_IDF_COD) 
 REFERENCES TRMA_TPI (TPI_COD,TPI_IDF_COD),
  CONSTRAINT RRMA_IND_TRS_FK 
 FOREIGN KEY (IND_TRS_COD, IND_IDF_COD) 
 REFERENCES TRMA_TRS (TRS_COD,TRS_IDF_COD));

ALTER TABLE TRMA_ITE ADD (
  CONSTRAINT RRMA_ITE_MAQ_FK 
 FOREIGN KEY (ITE_MAQ_COD, ITE_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_ITR ADD (
  CONSTRAINT RRMA_ITR_TRE_FK 
 FOREIGN KEY (ITR_IDF_COD, ITR_MNT_COD, ITR_TRE_ORD) 
 REFERENCES TRMA_TRE (TRE_IDF_COD,TRE_MNT_COD,TRE_ORD));

ALTER TABLE TRMA_MAO ADD (
  CONSTRAINT RRMA_MAO_MAQ_FK 
 FOREIGN KEY (MAO_MAQ_COD, MAO_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_TMA ADD (
  CONSTRAINT RRMA_TMA_MAQ_FK 
 FOREIGN KEY (TMA_MAQ_COD, TMA_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD),
  CONSTRAINT RRMA_TMA_VAT_FK 
 FOREIGN KEY (TMA_IDF_COD, TMA_TRG_COD, TMA_VAT_ORD) 
 REFERENCES TRMA_VAT (VAT_IDF_COD,VAT_TRG_COD,VAT_ORD));

ALTER TABLE TRMA_VAL ADD (
  CONSTRAINT RRMA_VAL_ATR_FK 
 FOREIGN KEY (VAL_ATR_COD, VAL_IDF_COD) 
 REFERENCES TRMA_ATR (ATR_COD,ATR_IDF_COD),
  CONSTRAINT RRMA_VAL_MAQ_FK 
 FOREIGN KEY (VAL_MAQ_COD, VAL_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_COS ADD (
  CONSTRAINT RRMA_COS_AGN_FK 
 FOREIGN KEY (COS_AGN_REF, COS_IDF_COD) 
 REFERENCES TRMA_AGN (AGN_REF,AGN_IDF_COD),
  CONSTRAINT RRMA_COS_CPA_FK 
 FOREIGN KEY (COS_IDF_COD, COS_CPA_COD) 
 REFERENCES TRMA_CPA (CPA_IDF_COD,CPA_COD),
  CONSTRAINT RRMA_COS_IDF_FK 
 FOREIGN KEY (COS_IDF_COD) 
 REFERENCES TRMA_IDF (IDF_COD),
  CONSTRAINT RRMA_COS_IND_FK 
 FOREIGN KEY (COS_IND_REF, COS_IDF_COD) 
 REFERENCES TRMA_IND (IND_REF,IND_IDF_COD),
  CONSTRAINT RRMA_COS_MAQ_FK 
 FOREIGN KEY (COS_MAQ_COD, COS_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD),
  CONSTRAINT RRMA_COS_REP_FK 
 FOREIGN KEY (COS_MAQ_COD, COS_REP_NUM, COS_IDF_COD) 
 REFERENCES TRMA_REP (REP_MAQ_COD,REP_NUM,REP_IDF_COD),
  CONSTRAINT RRMA_COS_TCO_FK 
 FOREIGN KEY (COS_TCO_COD, COS_IDF_COD) 
 REFERENCES TRMA_TCO (TCO_COD,TCO_IDF_COD));

ALTER TABLE TRMA_FEM ADD (
  CONSTRAINT RRMA_FEM_FFM_FK 
 FOREIGN KEY (FEM_FFM_COD, FEM_IDF_COD) 
 REFERENCES TRMA_FFM (FFM_COD,FFM_IDF_COD),
  CONSTRAINT RRMA_FEM_ITE_FK 
 FOREIGN KEY (FEM_ITE_REF, FEM_MAQ_COD, FEM_IDF_COD) 
 REFERENCES TRMA_ITE (ITE_REF,ITE_MAQ_COD,ITE_IDF_COD),
  CONSTRAINT RRMA_FEM_MAQ_FK 
 FOREIGN KEY (FEM_MAQ_COD, FEM_IDF_COD) 
 REFERENCES TRMA_MAQ (MAQ_COD,MAQ_IDF_COD));

ALTER TABLE TRMA_LRP ADD (
  CONSTRAINT RRMA_LRP_COS_FK 
 FOREIGN KEY (LRP_COS_COD, LRP_IDF_COD) 
 REFERENCES TRMA_COS (COS_COD,COS_IDF_COD),
  CONSTRAINT RRMA_LRP_REP_FK 
 FOREIGN KEY (LRP_MAQ_COD, LRP_REP_NUM, LRP_IDF_COD) 
 REFERENCES TRMA_REP (REP_MAQ_COD,REP_NUM,REP_IDF_COD),
  CONSTRAINT RRMA_LRP_TCO_FK 
 FOREIGN KEY (LRP_TCO_COD, LRP_IDF_COD) 
 REFERENCES TRMA_TCO (TCO_COD,TCO_IDF_COD));

ALTER TABLE TRMA_VLF ADD (
  CONSTRAINT RRMA_VLF_FEM_FK 
 FOREIGN KEY (VLF_FFM_COD, VLF_MAQ_COD, VLF_IDF_COD) 
 REFERENCES TRMA_FEM (FEM_FFM_COD,FEM_MAQ_COD,FEM_IDF_COD),
  CONSTRAINT RRMA_VLF_TCM_FK 
 FOREIGN KEY (VLF_TCM_COD, VLF_IDF_COD) 
 REFERENCES TRMA_TCM (TCM_COD,TCM_IDF_COD));

