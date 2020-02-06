--
-- Create Schema Script 
--   Database Version   : 9.2.0.6.0 
--   TOAD Version       : 9.7.0.51 
--   DB Connect String  : DES 
--   Schema             : RRHH 
--   Script Created by  : CECOGEST 
--   Script Created at  : 05/02/2020 9:17:42 
--   Physical Location  :  
--   Notes              :  
--

-- Object Counts: 
--   Indexes: 359       Columns: 811        
--   Sequences: 44 
--   Tables: 137        Columns: 2280       Constraints: 375    
--   Views: 99          


CREATE SEQUENCE SRHU_AMN
  START WITH 1
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SRHU_CTLFFO
  START WITH 33
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  NOCACHE
  NOORDER;


CREATE SEQUENCE SRHU_EXL
  START WITH 21
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SRHU_PPF
  START WITH 1
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  NOCACHE
  NOORDER;




CREATE TABLE RRHH_REF_CODES
(
  RV_LOW_VALUE     VARCHAR2(240 BYTE)               NULL,
  RV_HIGH_VALUE    VARCHAR2(240 BYTE)               NULL,
  RV_ABBREVIATION  VARCHAR2(240 BYTE)               NULL,
  RV_DOMAIN        VARCHAR2(100 BYTE)               NULL,
  RV_MEANING       VARCHAR2(240 BYTE)               NULL,
  RV_TYPE          VARCHAR2(10 BYTE)                NULL
)
;


CREATE TABLE TRHU_BAI_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  BAI_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  BAI_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  BAI_TBA_COD     VARCHAR2(4 BYTE)                  NULL,
  BAI_SBA_COD     VARCHAR2(6 BYTE)                  NULL,
  BAI_DATINI      DATE                              NULL,
  BAI_DATFIN      DATE                              NULL,
  BAI_DATCRE      DATE                              NULL,
  BAI_OBS         VARCHAR2(1000 BYTE)               NULL,
  BAI_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  BAI_DATMOD      DATE                              NULL,
  BAI_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TRHU_CEN
(
  CEN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CEN_COD      VARCHAR2(6 BYTE)                     NULL,
  CEN_DATCRE   DATE                                 NULL,
  CEN_NOM      VARCHAR2(40 BYTE)                    NULL,
  CEN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CEN_DATMOD   DATE                                 NULL,
  CEN_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_COV
(
  COV_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  COV_COD        VARCHAR2(4 BYTE)                   NULL,
  COV_NOM        VARCHAR2(30 BYTE)                  NULL,
  COV_COL        VARCHAR2(15 BYTE)                  NULL,
  COV_DATCRE     DATE                               NULL,
  COV_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  COV_DATMOD     DATE                               NULL,
  COV_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  COV_OBS        VARCHAR2(1000 BYTE)                NULL,
  COV_PTEMES     NUMBER(5,2)                        NULL,
  COV_MAXHOE     NUMBER(10,2)                       NULL,
  COV_IMPPNC     NUMBER(10,2)                       NULL,
  COV_FACPNC     NUMBER(10,2)                       NULL,
  COV_DISPNC     NUMBER                             NULL,
  COV_HORVAC     NUMBER(4)                          NULL,
  COV_HORLLI     NUMBER(4)                          NULL,
  COV_HORLLI002  NUMBER(4)                          NULL,
  COV_VACDIANAT  VARCHAR2(1 BYTE)               DEFAULT 'N'                       NULL,
  COV_HORSET     NUMBER(18,2)                       NULL,
  COV_FCHOEDLS   NUMBER(5,2)                        NULL,
  COV_FCHOEDMS   NUMBER(5,2)                        NULL,
  COV_FCHOEDCS   NUMBER(5,2)                        NULL,
  COV_FCHOEDJS   NUMBER(5,2)                        NULL,
  COV_FCHOEDVS   NUMBER(5,2)                        NULL,
  COV_FCHOEDSE   NUMBER(5,2)                        NULL,
  COV_FCHOEDME   NUMBER(5,2)                        NULL,
  COV_MINPAU     NUMBER(5,2)                        NULL,
  COV_FCHNODLS   NUMBER(5,2)                        NULL,
  COV_FCHNODMS   NUMBER(5,2)                        NULL,
  COV_FCHNODCS   NUMBER(5,2)                        NULL,
  COV_FCHNODJS   NUMBER(5,2)                        NULL,
  COV_FCHNODVS   NUMBER(5,2)                        NULL,
  COV_FCHNODSE   NUMBER(5,2)                        NULL,
  COV_FCHNODME   NUMBER(5,2)                        NULL
)
;


CREATE TABLE TRHU_CSTOPE
(
  CSTOPE_IDF_COD  VARCHAR2(4 BYTE)                  NULL,
  CSTOPE_EMP_COD  VARCHAR2(4 BYTE)                  NULL,
  CSTOPE_OPE_COD  VARCHAR2(6 BYTE)                  NULL,
  CSTOPE_MES      NUMBER(2)                         NULL,
  CSTOPE_ANY      NUMBER(4)                         NULL,
  CST_CST         NUMBER(18,2)                      NULL,
  CST_CSH         NUMBER(18,2)                      NULL,
  CSTOPE_ICN      NUMBER(18,2)                      NULL
)
;


CREATE TABLE TRHU_CTR_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  CTR_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  CTR_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  CTR_TCT_COD     VARCHAR2(4 BYTE)                  NULL,
  CTR_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  CTR_DATINI      DATE                              NULL,
  CTR_DATFIN      DATE                              NULL,
  CTR_OBS         VARCHAR2(1000 BYTE)               NULL,
  CTR_DATCRE      DATE                              NULL,
  CTR_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  CTR_DATMOD      DATE                              NULL,
  CTR_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  CTR_HORVAC      NUMBER(4)                         NULL,
  CTR_DATBAI      DATE                              NULL,
  CTR_OBSBAI      VARCHAR2(1000 BYTE)               NULL,
  CTR_DATSOLBAI   DATE                              NULL,
  CTR_SOLBAI      VARCHAR2(1 BYTE)                  NULL,
  CTR_CRLFFO      VARCHAR2(1 BYTE)                  NULL,
  CTR_COV_COD     VARCHAR2(4 BYTE)                  NULL,
  CTR_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL
)
;


CREATE TABLE TRHU_FFO
(
  FFO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FFO_COD      NUMBER(10)                           NULL,
  FFO_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  FFO_CLN_DAT  DATE                                 NULL,
  FFO_DATCRE   DATE                                 NULL,
  FFO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FFO_FFM_COD  NUMBER(10)                           NULL,
  FFO_OBS      VARCHAR2(1000 BYTE)                  NULL,
  FFO_DATMOD   DATE                                 NULL,
  FFO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  FFO_REF      VARCHAR2(20 BYTE)                    NULL,
  FFO_DOC      VARCHAR2(120 BYTE)                   NULL,
  FFO_TIP      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_HISTPCN
(
  PCN_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_CAT_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_SCT_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_CNM_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_DATCRE     DATE                               NULL,
  PCN_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  PCN_IMP        NUMBER(15,2)                       NULL,
  PCN_IMP002     NUMBER(15,2)                       NULL,
  PCN_DATMOD     DATE                               NULL,
  PCN_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  PCN_VALDIVEUR  NUMBER(15,8)                       NULL
)
;


CREATE TABLE TRHU_HISTPFC
(
  PFC_COF_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_CAT_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_SCT_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_DIASET     NUMBER(1)                          NULL,
  PFC_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_PRU        NUMBER(15,2)                       NULL,
  PFC_VALDIVEUR  NUMBER(15,8)                       NULL,
  PFC_DATCRE     DATE                               NULL,
  PFC_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  PFC_HORDEF     NUMBER(4,2)                        NULL,
  PFC_DATMOD     DATE                               NULL,
  PFC_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  PFC_CST        NUMBER(15,2)                       NULL,
  PFC_TIPAPLCST  NUMBER(1)                          NULL,
  PFC_PTECST     NUMBER(5,2)                        NULL
)
;


CREATE TABLE TRHU_IDF
(
  IDF_COD     VARCHAR2(4 BYTE)                      NULL,
  IDF_PRNLOG  VARCHAR2(1 BYTE)                  DEFAULT 'N'                       NULL,
  IDF_NOM     VARCHAR2(40 BYTE)                     NULL,
  IDF_LOG     LONG RAW                              NULL,
  IDF_DATCRE  DATE                                  NULL,
  IDF_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  IDF_DATMOD  DATE                                  NULL,
  IDF_USUMOD  VARCHAR2(30 BYTE)                     NULL
)
;


CREATE TABLE TRHU_IMP_APP
(
  IAP_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  IAP_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  IAP_SEQ         NUMBER(18)                        NULL,
  IAP_MAQ_COD     VARCHAR2(15 BYTE)                 NULL,
  IAP_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  IAP_CLI_COD     VARCHAR2(6 BYTE)                  NULL,
  IAP_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL,
  IAP_ALB_NUM     NUMBER(18)                        NULL,
  IAP_UNI         NUMBER(18,4)                      NULL,
  IAP_COF_COD     VARCHAR2(4 BYTE)                  NULL,
  IAP_DATINI      DATE                              NULL,
  IAP_DATFIN      DATE                              NULL,
  IAP_LFF         NUMBER(18)                        NULL,
  IAP_IDACTINT    NUMBER(18)                        NULL,
  IAP_MAQ_COD002  VARCHAR2(15 BYTE)                 NULL,
  IAP_OBS         VARCHAR2(2000 BYTE)               NULL,
  IAP_DATCRE      DATE                              NULL,
  IAP_DATMOD      DATE                              NULL,
  IAP_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  IAP_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  IAP_FFO_COD     NUMBER(10)                        NULL,
  IAP_FFM_COD     NUMBER(10)                        NULL,
  IAP_LFF_NUM     NUMBER(10)                        NULL,
  IAP_ETP_NUM     NUMBER(3)                         NULL,
  IAP_ETP_COD     VARCHAR2(3 BYTE)                  NULL,
  IAP_UCE_SEQ     NUMBER(10)                        NULL,
  IAP_LES_SEQ     NUMBER(10)                        NULL,
  IAP_ZON_COD     VARCHAR2(4 BYTE)                  NULL
)
;


CREATE TABLE TRHU_IMP_BAI
(
  BAI_REF      NUMBER(10)                           NULL,
  BAI_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  BAI_TBA_COD  VARCHAR2(4 BYTE)                     NULL,
  BAI_SBA_COD  VARCHAR2(4 BYTE)                     NULL,
  BAI_DATINI   DATE                                 NULL,
  BAI_DATFIN   DATE                                 NULL,
  BAI_APL      NUMBER(10)                           NULL,
  BAI_ULTMOD   DATE                                 NULL,
  BAI_ACTRHU   VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_IMP_CCS
(
  CCS_REF      NUMBER(10)                           NULL,
  CCS_APL      NUMBER(10)                           NULL,
  CCS_ACTRHU   VARCHAR2(1 BYTE)                     NULL,
  CCS_ULTMOD   DATE                                 NULL,
  CCS_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  CCS_CAT_COD  VARCHAR2(4 BYTE)                     NULL,
  CCS_TCT_COD  VARCHAR2(4 BYTE)                     NULL,
  CCS_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CCS_SCT_COD  VARCHAR2(4 BYTE)                     NULL,
  CCS_SEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CCS_DATINI   DATE                                 NULL,
  CCS_DATFIN   DATE                                 NULL,
  CCS_NIF      VARCHAR2(12 BYTE)                    NULL
)
;


CREATE TABLE TRHU_IMP_OPE
(
  OPE_REF        NUMBER(10)                         NULL,
  OPE_COD        VARCHAR2(6 BYTE)                   NULL,
  OPE_CML        VARCHAR2(1 BYTE)                   NULL,
  OPE_ENTSOR     VARCHAR2(1 BYTE)                   NULL,
  OPE_NIF        VARCHAR2(12 BYTE)                  NULL,
  OPE_EML        VARCHAR2(60 BYTE)                  NULL,
  OPE_CPO_COD    VARCHAR2(5 BYTE)                   NULL,
  OPE_POB        VARCHAR2(30 BYTE)                  NULL,
  OPE_PRV        VARCHAR2(30 BYTE)                  NULL,
  OPE_TEL        VARCHAR2(60 BYTE)                  NULL,
  OPE_DOM        VARCHAR2(60 BYTE)                  NULL,
  OPE_HOR_COD    VARCHAR2(4 BYTE)                   NULL,
  OPE_PIN        VARCHAR2(25 BYTE)                  NULL,
  OPE_TOR        VARCHAR2(1 BYTE)                   NULL,
  OPE_ACT        VARCHAR2(1 BYTE)                   NULL,
  OPE_NOM        VARCHAR2(40 BYTE)                  NULL,
  OPE_APL        NUMBER(10)                         NULL,
  OPE_ULTMOD     DATE                               NULL,
  OPE_ACTRHU     VARCHAR2(1 BYTE)                   NULL,
  OPE_CALHOR     VARCHAR2(1 BYTE)                   NULL,
  OPE_PRUEXTDLS  NUMBER(15,2)                       NULL,
  OPE_PRUEXTDMS  NUMBER(15,2)                       NULL,
  OPE_PRUEXTDCS  NUMBER(15,2)                       NULL,
  OPE_PRUEXTDJS  NUMBER(15,2)                       NULL,
  OPE_PRUEXTDVS  NUMBER(15,2)                       NULL,
  OPE_PRUEXTDSE  NUMBER(15,2)                       NULL,
  OPE_PRUEXTDME  NUMBER(15,2)                       NULL,
  OPE_PRUHORNOR  NUMBER(15,2)                       NULL,
  OPE_PRUNITDLS  NUMBER(15,2)                       NULL,
  OPE_PRUNITDMS  NUMBER(15,2)                       NULL,
  OPE_PRUNITDCS  NUMBER(15,2)                       NULL,
  OPE_PRUNITDJS  NUMBER(15,2)                       NULL,
  OPE_PRUNITDVS  NUMBER(15,2)                       NULL,
  OPE_PRUNITDSE  NUMBER(15,2)                       NULL,
  OPE_PRUNITDME  NUMBER(15,2)                       NULL
)
;


CREATE TABLE TRHU_IMP_VAC
(
  VAC_REF      NUMBER(10)                           NULL,
  VAC_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  VAC_TIP      NUMBER(1)                            NULL,
  VAC_HOR      NUMBER(5,2)                          NULL,
  VAC_DATINI   DATE                                 NULL,
  VAC_DATFIN   DATE                                 NULL,
  VAC_APL      NUMBER(10)                           NULL,
  VAC_ULTMOD   DATE                                 NULL,
  VAC_ACTRHU   VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_OBO_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  OBO_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  OBO_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  OBO_SEQ         NUMBER(10)                        NULL,
  OBO_DATCRE      DATE                              NULL,
  OBO_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  OBO_REF         VARCHAR2(15 BYTE)                 NULL,
  OBO_OBS         VARCHAR2(2000 BYTE)               NULL,
  OBO_DATMOD      DATE                              NULL,
  OBO_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TRHU_OPD
(
  OPD_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  OPD_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  OPD_SEQ      NUMBER(3)                            NULL,
  OPD_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  OPD_DEL_COD  VARCHAR2(4 BYTE)                     NULL,
  OPD_DATINI   DATE                                 NULL,
  OPD_PTE      NUMBER(5,2)                          NULL,
  OPD_DATCRE   DATE                                 NULL,
  OPD_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OPD_DATFIN   DATE                                 NULL,
  OPD_DATMOD   DATE                                 NULL,
  OPD_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_OPE_JN
(
  JN_OPERATION         CHAR(3 BYTE)                 NULL,
  JN_ORACLE_USER       VARCHAR2(30 BYTE)            NULL,
  JN_DATETIME          DATE                         NULL,
  JN_APPLN             VARCHAR2(30 BYTE)            NULL,
  OPE_IDF_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_COD              VARCHAR2(6 BYTE)             NULL,
  OPE_NOM              VARCHAR2(40 BYTE)            NULL,
  OPE_ACT              VARCHAR2(1 BYTE)             NULL,
  OPE_ENTSOR           VARCHAR2(1 BYTE)             NULL,
  OPE_CML              VARCHAR2(1 BYTE)             NULL,
  OPE_HOR_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_TOR              VARCHAR2(1 BYTE)             NULL,
  OPE_PIN              VARCHAR2(25 BYTE)            NULL,
  OPE_DATCRE           DATE                         NULL,
  OPE_USUCRE           VARCHAR2(30 BYTE)            NULL,
  OPE_ENC              VARCHAR2(1 BYTE)             NULL,
  OPE_IND              VARCHAR2(1 BYTE)             NULL,
  OPE_HORESP           VARCHAR2(1 BYTE)             NULL,
  OPE_APLDIA           VARCHAR2(1 BYTE)             NULL,
  OPE_DLS              VARCHAR2(1 BYTE)             NULL,
  OPE_DMS              VARCHAR2(1 BYTE)             NULL,
  OPE_DCS              VARCHAR2(1 BYTE)             NULL,
  OPE_DJS              VARCHAR2(1 BYTE)             NULL,
  OPE_DVS              VARCHAR2(1 BYTE)             NULL,
  OPE_DSE              VARCHAR2(1 BYTE)             NULL,
  OPE_DME              VARCHAR2(1 BYTE)             NULL,
  OPE_NGR              VARCHAR2(1 BYTE)             NULL,
  OPE_CTLFFO           VARCHAR2(1 BYTE)             NULL,
  OPE_CTLHOE           VARCHAR2(1 BYTE)             NULL,
  OPE_CALHOR           NUMBER(1)                    NULL,
  OPE_HORCAN           VARCHAR2(1 BYTE)             NULL,
  OPE_ESTCIV           VARCHAR2(1 BYTE)             NULL,
  OPE_DCC              VARCHAR2(2 BYTE)             NULL,
  OPE_FIL              NUMBER(2)                    NULL,
  OPE_TCS_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_HORLLI           NUMBER(4)                    NULL,
  OPE_HORLLI002        NUMBER(4)                    NULL,
  OPE_BAN_CODCCR       NUMBER(4)                    NULL,
  OPE_OFB_CODCCR       NUMBER(4)                    NULL,
  OPE_ZON_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_EMP_CODCCR       VARCHAR2(4 BYTE)             NULL,
  OPE_HOR_COD002       VARCHAR2(4 BYTE)             NULL,
  OPE_HOR_CODNIT       VARCHAR2(4 BYTE)             NULL,
  OPE_GRE_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_OFB              NUMBER(4)                    NULL,
  OPE_BAN              NUMBER(4)                    NULL,
  OPE_HORVAC           NUMBER(4)                    NULL,
  OPE_CPO              VARCHAR2(5 BYTE)             NULL,
  OPE_MTR              NUMBER(5)                    NULL,
  OPE_CODALT           VARCHAR2(30 BYTE)            NULL,
  OPE_OPE_COD          VARCHAR2(6 BYTE)             NULL,
  OPE_CCR_COD          NUMBER(10)                   NULL,
  OPE_CTECMP           VARCHAR2(10 BYTE)            NULL,
  OPE_CCR              NUMBER(10)                   NULL,
  OPE_DATNAI           DATE                         NULL,
  OPE_DATMOD           DATE                         NULL,
  OPE_DAT              DATE                         NULL,
  OPE_NIF              VARCHAR2(12 BYTE)            NULL,
  OPE_NSS              VARCHAR2(15 BYTE)            NULL,
  OPE_NMN1             NUMBER(15,3)                 NULL,
  OPE_NMN2             NUMBER(15,3)                 NULL,
  OPE_PRUEXTDLS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDMS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDCS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDJS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDVS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDSE        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDME        NUMBER(15,2)                 NULL,
  OPE_PRUHORNOR        NUMBER(15,2)                 NULL,
  OPE_PRUNITDLS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDMS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDCS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDJS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDVS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDSE        NUMBER(15,2)                 NULL,
  OPE_PRUNITDME        NUMBER(15,2)                 NULL,
  OPE_CPLSAL1          NUMBER(15,2)                 NULL,
  OPE_CPLSAL2          NUMBER(15,2)                 NULL,
  OPE_COSADD           NUMBER(15,2)                 NULL,
  OPE_USU_COD          VARCHAR2(30 BYTE)            NULL,
  OPE_POB              VARCHAR2(30 BYTE)            NULL,
  OPE_PRV              VARCHAR2(30 BYTE)            NULL,
  OPE_USUMOD           VARCHAR2(30 BYTE)            NULL,
  OPE_NOMPAE           VARCHAR2(40 BYTE)            NULL,
  OPE_NOMMAE           VARCHAR2(40 BYTE)            NULL,
  OPE_LLCNAI           VARCHAR2(60 BYTE)            NULL,
  OPE_EML              VARCHAR2(60 BYTE)            NULL,
  OPE_TEL              VARCHAR2(60 BYTE)            NULL,
  OPE_DOM              VARCHAR2(60 BYTE)            NULL,
  OPE_OBS              VARCHAR2(1000 BYTE)          NULL,
  OPE_DATVALTRG        DATE                         NULL,
  OPE_VAD_COD          NUMBER(10)                   NULL,
  OPE_PJB              VARCHAR2(1 BYTE)             NULL,
  OPE_DIAPJB           DATE                         NULL,
  OPE_HORANYPJB        NUMBER(4)                    NULL,
  OPE_HORPENANYANTPJB  NUMBER(4)                    NULL,
  OPE_OBSPJB           VARCHAR2(1000 BYTE)          NULL,
  OPE_PLUPDT           VARCHAR2(1 BYTE)             NULL,
  OPE_TOR_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_TORDIAINI        DATE                         NULL,
  OPE_GFE_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_SEX              VARCHAR2(1 BYTE)             NULL,
  OPE_TELEMP           VARCHAR2(60 BYTE)            NULL,
  OPE_TPC              VARCHAR2(15 BYTE)            NULL,
  OPE_MNS              NUMBER(3)                    NULL,
  OPE_COSIDR           VARCHAR2(1 BYTE)             NULL,
  OPE_TGTCOD           VARCHAR2(30 BYTE)            NULL,
  OPE_HORRUT           VARCHAR2(1 BYTE)             NULL,
  OPE_DERDIE           VARCHAR2(1 BYTE)             NULL,
  OPE_PTENMN           NUMBER(3)                    NULL,
  OPE_IBNPAI           VARCHAR2(2 BYTE)             NULL,
  OPE_IBNDCC           VARCHAR2(2 BYTE)             NULL,
  OPE_IBNBIC           VARCHAR2(11 BYTE)            NULL,
  OPE_EXP_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_DISCOS           VARCHAR2(2 BYTE)             NULL,
  OPE_ANECMP           VARCHAR2(4 BYTE)             NULL,
  OPE_DEPCMP           VARCHAR2(4 BYTE)             NULL,
  OPE_DEPCMPFXE        VARCHAR2(1 BYTE)             NULL,
  OPE_CEN_COD          VARCHAR2(6 BYTE)             NULL,
  OPE_DTEHOR           NUMBER(5,3)                  NULL,
  OPE_ADO              VARCHAR2(1 BYTE)             NULL,
  OPE_MAXHOE001        NUMBER(3,1)                  NULL,
  OPE_PTENMN002        NUMBER(3)                    NULL,
  OPE_EMLEMP           VARCHAR2(30 BYTE)            NULL,
  OPE_NOTHOREXT        VARCHAR2(1 BYTE)             NULL
)
;


CREATE TABLE TRHU_OPP
(
  OPP_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  OPP_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  OPP_SEQ      NUMBER(3)                            NULL,
  OPP_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  OPP_EXD_COD  VARCHAR2(4 BYTE)                     NULL,
  OPP_DATINI   DATE                                 NULL,
  OPP_PTE      NUMBER(5,2)                          NULL,
  OPP_DATCRE   DATE                                 NULL,
  OPP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OPP_DATFIN   DATE                                 NULL,
  OPP_DATMOD   DATE                                 NULL,
  OPP_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_OPR
(
  OPR_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  OPR_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  OPR_SEQ         NUMBER(3)                         NULL,
  OPR_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  OPR_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL,
  OPR_DATINI      DATE                              NULL,
  OPR_PTE         NUMBER(5,2)                       NULL,
  OPR_DATCRE      DATE                              NULL,
  OPR_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  OPR_DATFIN      DATE                              NULL,
  OPR_DATMOD      DATE                              NULL,
  OPR_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  OPR_ETP_COD001  VARCHAR2(4 BYTE)                  NULL,
  OPR_UCE_COD001  VARCHAR2(30 BYTE)                 NULL,
  OPR_LES_COD001  VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TRHU_OPX
(
  OPX_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  OPX_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  OPX_EXT_NUM  VARCHAR2(6 BYTE)                     NULL,
  OPX_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  OPX_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OPX_DATCRE   DATE                                 NULL,
  OPX_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  OPX_DATMOD   DATE                                 NULL,
  OPX_DATINI   DATE                                 NULL,
  OPX_DATFIN   DATE                                 NULL,
  OPX_CAT_COD  VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TRHU_PAR
(
  PAR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PAR_COD      VARCHAR2(15 BYTE)                    NULL,
  PAR_VAL      VARCHAR2(1000 BYTE)                  NULL,
  PAR_DES      VARCHAR2(1000 BYTE)                  NULL,
  PAR_DATCRE   DATE                                 NULL,
  PAR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PAR_DATMOD   DATE                                 NULL,
  PAR_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_PCA_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  PCA_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  PCA_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  PCA_CAT_COD     VARCHAR2(4 BYTE)                  NULL,
  PCA_SCT_COD     VARCHAR2(4 BYTE)                  NULL,
  PCA_DATINI      DATE                              NULL,
  PCA_DATCRE      DATE                              NULL,
  PCA_DATFIN      DATE                              NULL,
  PCA_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  PCA_DATMOD      DATE                              NULL,
  PCA_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TRHU_PLT
(
  PLT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PLT_COD      VARCHAR2(4 BYTE)                     NULL,
  PLT_DES      VARCHAR2(250 BYTE)                   NULL,
  PLT_PLT_COD  VARCHAR2(4 BYTE)                     NULL,
  PLT_FNC      VARCHAR2(1500 BYTE)                  NULL,
  PLT_FCOMIN   NUMBER(1)                            NULL,
  PLT_APD001   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD002   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD003   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD004   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD005   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD006   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD007   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD008   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD009   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD010   VARCHAR2(1 BYTE)                     NULL,
  PLT_APD011   NUMBER(1)                            NULL,
  PLT_APD012   NUMBER(1)                            NULL,
  PLT_APD013   NUMBER(1)                            NULL,
  PLT_APD014   NUMBER(1)                            NULL,
  PLT_APD015   NUMBER(1)                            NULL,
  PLT_EXPERT   NUMBER(1)                            NULL,
  PLT_CONOCI   VARCHAR2(1500 BYTE)                  NULL
)
;


CREATE TABLE TRHU_PSE_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  PSE_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  PSE_SEC_COD     VARCHAR2(4 BYTE)                  NULL,
  PSE_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  PSE_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  PSE_DATINI      DATE                              NULL,
  PSE_DATCRE      DATE                              NULL,
  PSE_DATFIN      DATE                              NULL,
  PSE_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  PSE_DATMOD      DATE                              NULL,
  PSE_USUMOD      VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TRHU_RDI_JN
(
  JN_OPERATION    CHAR(3 BYTE)                      NULL,
  JN_ORACLE_USER  VARCHAR2(30 BYTE)                 NULL,
  JN_DATETIME     DATE                              NULL,
  JN_APPLN        VARCHAR2(30 BYTE)                 NULL,
  RDI_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_CLN_DAT     DATE                              NULL,
  RDI_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  RDI_HORTEO      NUMBER(22)                        NULL,
  RDI_HORNOR      NUMBER(22)                        NULL,
  RDI_HOREXT      NUMBER(22)                        NULL,
  RDI_PRUEXT      NUMBER(15,2)                      NULL,
  RDI_HOR_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_DATCRE      DATE                              NULL,
  RDI_REG_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  RDI_DATMOD      DATE                              NULL,
  RDI_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  RDI_SEC_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_CAT_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_SCT_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_OBS         VARCHAR2(1000 BYTE)               NULL,
  RDI_PRUHORNOR   NUMBER(15,2)                      NULL,
  RDI_HOR_COD002  VARCHAR2(4 BYTE)                  NULL,
  RDI_HOR_CODNIT  VARCHAR2(4 BYTE)                  NULL,
  RDI_PRUHORNIT   NUMBER(15,2)                      NULL,
  RDI_HORNIT      NUMBER(22)                        NULL,
  RDI_HORVAC      NUMBER(22)                        NULL,
  RDI_ANL_COD     VARCHAR2(6 BYTE)                  NULL,
  RDI_HORLLI002   NUMBER(22)                        NULL,
  RDI_ZON_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_HORLLI      NUMBER(22)                        NULL,
  RDI_HORCMS      NUMBER(15,2)                      NULL
)
;


CREATE TABLE TRHU_REG
(
  REG_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  REG_COD        VARCHAR2(4 BYTE)                   NULL,
  REG_PRS        VARCHAR2(1 BYTE)                   NULL,
  REG_HOR        VARCHAR2(1 BYTE)                   NULL,
  REG_MNTREG     VARCHAR2(1 BYTE)                   NULL,
  REG_PLN        VARCHAR2(1 BYTE)                   NULL,
  REG_NOM        VARCHAR2(30 BYTE)                  NULL,
  REG_DATCRE     DATE                               NULL,
  REG_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  REG_DATMOD     DATE                               NULL,
  REG_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  REG_MAXHORLAB  NUMBER(3)                          NULL,
  REG_MINHORLAB  NUMBER(3)                          NULL
)
;


CREATE TABLE TRHU_SNO
(
  SNO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  SNO_COD      VARCHAR2(4 BYTE)                     NULL,
  SNO_DES      VARCHAR2(1000 BYTE)                  NULL,
  SNO_DATCRE   DATE                                 NULL,
  SNO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  SNO_DATMOD   DATE                                 NULL,
  SNO_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_TAM
(
  TAM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TAM_COD      VARCHAR2(4 BYTE)                     NULL,
  TAM_DES      VARCHAR2(60 BYTE)                    NULL
)
;


CREATE TABLE TRHU_TAN
(
  TAN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TAN_COD      VARCHAR2(4 BYTE)                     NULL,
  TAN_NOM      VARCHAR2(30 BYTE)                    NULL,
  TAN_DES      VARCHAR2(1000 BYTE)                  NULL,
  TAN_DATCRE   DATE                                 NULL,
  TAN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TAN_DATMOD   DATE                                 NULL,
  TAN_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TAN_GEN      VARCHAR2(1 BYTE)                 DEFAULT 'S'                       NULL
)
;


CREATE TABLE TRHU_TBA
(
  TBA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TBA_COD      VARCHAR2(4 BYTE)                     NULL,
  TBA_NOM      VARCHAR2(30 BYTE)                    NULL,
  TBA_OBS      VARCHAR2(1000 BYTE)                  NULL,
  TBA_DATCRE   DATE                                 NULL,
  TBA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TBA_DATMOD   DATE                                 NULL,
  TBA_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_TCA
(
  TCA_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  TCA_COD        VARCHAR2(4 BYTE)                   NULL,
  TCA_DES        VARCHAR2(60 BYTE)                  NULL,
  TCA_CDC        VARCHAR2(1 BYTE)                   NULL,
  TCA_DATCRE     DATE                               NULL,
  TCA_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  TCA_DIAAVICDC  NUMBER(3)                          NULL,
  TCA_DATMOD     DATE                               NULL,
  TCA_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  TCA_OBS        VARCHAR2(1000 BYTE)                NULL
)
;


CREATE TABLE TRHU_TCI
(
  TCI_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TCI_COD      VARCHAR2(6 BYTE)                     NULL,
  TCI_DES      VARCHAR2(60 BYTE)                    NULL,
  TCI_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TCI_DATCRE   DATE                                 NULL,
  TCI_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TCI_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_TCN
(
  TCN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TCN_COD      VARCHAR2(4 BYTE)                     NULL,
  TCN_DATCRE   DATE                                 NULL,
  TCN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TCN_TIP      NUMBER(1)                            NULL,
  TCN_NOM      VARCHAR2(30 BYTE)                    NULL,
  TCN_DES      VARCHAR2(1000 BYTE)                  NULL,
  TCN_DATMOD   DATE                                 NULL,
  TCN_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_TCT
(
  TCT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TCT_COD      VARCHAR2(4 BYTE)                     NULL,
  TCT_NOM      VARCHAR2(30 BYTE)                    NULL,
  TCT_OBS      VARCHAR2(1000 BYTE)                  NULL,
  TCT_DATCRE   DATE                                 NULL,
  TCT_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TCT_DATMOD   DATE                                 NULL,
  TCT_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TCT_TIP      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_TDI
(
  TDI_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TDI_COD      VARCHAR2(4 BYTE)                     NULL,
  TDI_REG_COD  VARCHAR2(4 BYTE)                     NULL,
  TDI_NOM      VARCHAR2(30 BYTE)                    NULL,
  TDI_DATCRE   DATE                                 NULL,
  TDI_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TDI_DATMOD   DATE                                 NULL,
  TDI_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_TDS
(
  TDS_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TDS_COD      VARCHAR2(6 BYTE)                     NULL,
  TDS_DES      VARCHAR2(60 BYTE)                    NULL,
  TDS_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TDS_DATCRE   DATE                                 NULL,
  TDS_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TDS_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_TFE
(
  TFE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TFE_COD      VARCHAR2(4 BYTE)                     NULL,
  TFE_DATCRE   DATE                                 NULL,
  TFE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TFE_DES      VARCHAR2(1000 BYTE)                  NULL,
  TFE_DATMOD   DATE                                 NULL,
  TFE_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_TIC
(
  TIC_COD      VARCHAR2(4 BYTE)                     NULL,
  TIC_DES      VARCHAR2(1000 BYTE)                  NULL,
  TIC_DATCRE   DATE                                 NULL,
  TIC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TIC_DATMOD   DATE                                 NULL,
  TIC_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TIC_IDF_COD  VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TRHU_TMO
(
  TMO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TMO_COD      VARCHAR2(4 BYTE)                     NULL,
  TMO_DES      VARCHAR2(30 BYTE)                    NULL,
  TMO_TLL      VARCHAR2(1 BYTE)                     NULL,
  TMO_CRLRPO   VARCHAR2(1 BYTE)                     NULL,
  TMO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TMO_DATCRE   DATE                                 NULL,
  TMO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TMO_DATMOD   DATE                                 NULL
)
;


CREATE GLOBAL TEMPORARY TABLE TRHU_TMP_FOTOPE
(
  PSCPRO_COD  VARCHAR2(6 BYTE)                      NULL,
  PSCREF      NUMBER(10)                            NULL,
  COD         VARCHAR2(200 BYTE)                    NULL,
  NOM         VARCHAR2(200 BYTE)                    NULL,
  LLINATGES   VARCHAR2(200 BYTE)                    NULL,
  NIF         VARCHAR2(20 BYTE)                     NULL,
  DIA         DATE                                  NULL,
  SEL         NUMBER(1)                             NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TRHU_TMP_HORMEN
(
  OPE_COD      VARCHAR2(40 BYTE)                    NULL,
  OPE_NOM      VARCHAR2(40 BYTE)                    NULL,
  CAT_OPE      VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS1   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS2   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS3   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS4   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS5   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS6   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS7   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS8   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS9   VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS10  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS11  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS12  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS13  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS14  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS15  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS16  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS17  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS18  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS19  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS20  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS21  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS22  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS23  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS24  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS25  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS26  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS27  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS28  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS29  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS30  VARCHAR2(40 BYTE)                    NULL,
  DIA_HORAS31  VARCHAR2(40 BYTE)                    NULL,
  HMES         VARCHAR2(40 BYTE)                    NULL,
  HN           VARCHAR2(40 BYTE)                    NULL,
  HEX          VARCHAR2(40 BYTE)                    NULL,
  HNOC         VARCHAR2(40 BYTE)                    NULL,
  HX1          VARCHAR2(40 BYTE)                    NULL,
  HX2          VARCHAR2(40 BYTE)                    NULL,
  HX3          VARCHAR2(40 BYTE)                    NULL,
  HX4          VARCHAR2(40 BYTE)                    NULL,
  HX5          VARCHAR2(40 BYTE)                    NULL,
  HX6          VARCHAR2(40 BYTE)                    NULL,
  HX7          VARCHAR2(40 BYTE)                    NULL,
  HX8          VARCHAR2(40 BYTE)                    NULL,
  HX9          VARCHAR2(40 BYTE)                    NULL,
  HX10         VARCHAR2(40 BYTE)                    NULL,
  HX11         VARCHAR2(40 BYTE)                    NULL,
  HX12         VARCHAR2(40 BYTE)                    NULL,
  HX13         VARCHAR2(40 BYTE)                    NULL,
  HX14         VARCHAR2(40 BYTE)                    NULL,
  HX15         VARCHAR2(40 BYTE)                    NULL,
  HX16         VARCHAR2(40 BYTE)                    NULL,
  HX17         VARCHAR2(40 BYTE)                    NULL,
  HX18         VARCHAR2(40 BYTE)                    NULL,
  HX19         VARCHAR2(40 BYTE)                    NULL,
  HX20         VARCHAR2(40 BYTE)                    NULL,
  HX21         VARCHAR2(40 BYTE)                    NULL,
  HX22         VARCHAR2(40 BYTE)                    NULL,
  HX23         VARCHAR2(40 BYTE)                    NULL,
  HX24         VARCHAR2(40 BYTE)                    NULL,
  HX25         VARCHAR2(40 BYTE)                    NULL,
  HX26         VARCHAR2(40 BYTE)                    NULL,
  HX27         VARCHAR2(40 BYTE)                    NULL,
  HX28         VARCHAR2(40 BYTE)                    NULL,
  HX29         VARCHAR2(40 BYTE)                    NULL,
  HX30         VARCHAR2(40 BYTE)                    NULL,
  CON1         VARCHAR2(40 BYTE)                    NULL,
  CON2         VARCHAR2(40 BYTE)                    NULL,
  CON3         VARCHAR2(40 BYTE)                    NULL,
  CON4         VARCHAR2(40 BYTE)                    NULL,
  CON5         VARCHAR2(40 BYTE)                    NULL,
  CON6         VARCHAR2(40 BYTE)                    NULL,
  CON7         VARCHAR2(40 BYTE)                    NULL,
  CON8         VARCHAR2(40 BYTE)                    NULL,
  CON9         VARCHAR2(40 BYTE)                    NULL,
  CON10        VARCHAR2(40 BYTE)                    NULL,
  CON11        VARCHAR2(40 BYTE)                    NULL,
  CON12        VARCHAR2(40 BYTE)                    NULL,
  CON13        VARCHAR2(40 BYTE)                    NULL,
  CON14        VARCHAR2(40 BYTE)                    NULL,
  CON15        VARCHAR2(40 BYTE)                    NULL,
  CON16        VARCHAR2(40 BYTE)                    NULL,
  CON17        VARCHAR2(40 BYTE)                    NULL,
  CON18        VARCHAR2(40 BYTE)                    NULL,
  CON19        VARCHAR2(40 BYTE)                    NULL,
  CON20        VARCHAR2(40 BYTE)                    NULL,
  CON21        VARCHAR2(40 BYTE)                    NULL,
  CON22        VARCHAR2(40 BYTE)                    NULL,
  CON23        VARCHAR2(40 BYTE)                    NULL,
  CON24        VARCHAR2(40 BYTE)                    NULL,
  CON25        VARCHAR2(40 BYTE)                    NULL,
  CON26        VARCHAR2(40 BYTE)                    NULL,
  CON27        VARCHAR2(40 BYTE)                    NULL,
  CON28        VARCHAR2(40 BYTE)                    NULL,
  CON29        VARCHAR2(40 BYTE)                    NULL,
  CON30        VARCHAR2(40 BYTE)                    NULL,
  ANT          VARCHAR2(40 BYTE)                    NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TRHU_TMP_LFF
(
  LFF_COF_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_FFO_COD        NUMBER(10)                     NULL,
  LFF_IDF_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_CLI_COD        VARCHAR2(6 BYTE)               NULL,
  LFF_DIV_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_PRU            NUMBER(15,2)                   NULL,
  LFF_DATCRE         DATE                           NULL,
  LFF_USUCRE         VARCHAR2(30 BYTE)              NULL,
  LFF_PDA_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_CAP_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_PRE_COD        NUMBER(10)                     NULL,
  LFF_DATMOD         DATE                           NULL,
  LFF_USUMOD         VARCHAR2(30 BYTE)              NULL,
  LFF_HOR            NUMBER(2)                      NULL,
  LFF_MIN            NUMBER(2)                      NULL,
  LFF_HORDEC         NUMBER(15,2)                   NULL,
  LFF_IMP            NUMBER(15,2)                   NULL,
  LFF_DES            VARCHAR2(255 BYTE)             NULL,
  LFF_LACNUMDOC      NUMBER(10)                     NULL,
  LFF_LAC_NUM        NUMBER(10)                     NULL,
  LFF_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_SEC_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_OBS            VARCHAR2(1000 BYTE)            NULL,
  LFF_ORI            VARCHAR2(1 BYTE)               NULL,
  LFF_NUM            NUMBER(10)                     NULL,
  LFF_MAQ_COD        VARCHAR2(15 BYTE)              NULL,
  LFF_SCL_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_AVI_NUM        NUMBER(10)                     NULL,
  LFF_AGN_MAQ        VARCHAR2(16 BYTE)              NULL,
  LFF_AGN_NUM        NUMBER(10)                     NULL,
  LFF_RMF_NUM        NUMBER(10)                     NULL,
  LFF_FSB_NUM        NUMBER(10)                     NULL,
  LFF_CSTUNI         NUMBER(15,2)                   NULL,
  LFF_MAQ_CODFEI     VARCHAR2(15 BYTE)              NULL,
  LFF_CSTMAQ         NUMBER(17,5)                   NULL,
  LFF_MAQ_CODFEI002  VARCHAR2(15 BYTE)              NULL,
  LFF_CSTMAQ002      NUMBER(17,5)                   NULL,
  LFF_FOB_NUM        NUMBER(10)                     NULL,
  LFF_PRJ_NUM        VARCHAR2(6 BYTE)               NULL,
  LFF_ETP_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_ETP_NUM        NUMBER(3)                      NULL,
  LFF_UCE_SEQ        NUMBER(10)                     NULL,
  LFF_LES_SEQ        NUMBER(10)                     NULL,
  LFF_HORMAQ002      NUMBER(2)                      NULL,
  LFF_MINMAQ002      NUMBER(2)                      NULL,
  LFF_HORDECMAQ002   NUMBER(5,2)                    NULL,
  LFF_HORMAQ         NUMBER(2)                      NULL,
  LFF_MINMAQ         NUMBER(2)                      NULL,
  LFF_HORDECMAQ      NUMBER(5,2)                    NULL,
  LFF_RLE_COD        VARCHAR2(30 BYTE)              NULL,
  LFF_MCA            VARCHAR2(1 BYTE)               NULL,
  LFF_INR_COD        NUMBER(18)                     NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TRHU_TMP_LSTDIE
(
  LFF_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  FFO_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  OPE_NOM      VARCHAR2(40 BYTE)                    NULL,
  LFF_COF_COD  VARCHAR2(4 BYTE)                     NULL,
  COF_NOM      VARCHAR2(30 BYTE)                    NULL,
  FFO_CLN_DAT  DATE                                 NULL,
  LFF_PRJ_NUM  VARCHAR2(6 BYTE)                     NULL,
  PRJ_NOM      VARCHAR2(250 BYTE)                   NULL,
  LFF_HORDEC   NUMBER(15,2)                         NULL,
  LFF_PRU      NUMBER(15,2)                         NULL,
  IMPORTE      NUMBER                               NULL,
  FFO_REF      VARCHAR2(60 BYTE)                    NULL,
  OPE_NIF      VARCHAR2(20 BYTE)                    NULL
)
ON COMMIT PRESERVE ROWS;


CREATE GLOBAL TEMPORARY TABLE TRHU_TMP_RESNMNPRJ
(
  IDF               VARCHAR2(4 BYTE)                NULL,
  EMP               VARCHAR2(4 BYTE)                NULL,
  DIA               DATE                            NULL,
  OPE               VARCHAR2(6 BYTE)                NULL,
  NOMOPE            VARCHAR2(200 BYTE)              NULL,
  HORES             NUMBER(18,4)                    NULL,
  PRJ               VARCHAR2(6 BYTE)                NULL,
  NMN_QUAMEN        NUMBER(18,4)                    NULL,
  NMN_COSSSEMP      NUMBER(18,4)                    NULL,
  NOMINAHORA        NUMBER(18,4)                    NULL,
  SEGSOCIALHORA     NUMBER(18,4)                    NULL,
  NOMINAHORADIA     NUMBER(18,4)                    NULL,
  SEGSOCIALHORADIA  NUMBER(18,4)                    NULL
)
ON COMMIT PRESERVE ROWS;


CREATE TABLE TRHU_TOR
(
  TOR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TOR_COD      VARCHAR2(6 BYTE)                     NULL,
  TOR_NOM      VARCHAR2(30 BYTE)                    NULL,
  TOR_OBS      VARCHAR2(1000 BYTE)                  NULL,
  TOR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TOR_DATCRE   DATE                                 NULL,
  TOR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TOR_DATMOD   DATE                                 NULL,
  TOR_PRVFES   VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_TRM
(
  TRM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRM_COD      VARCHAR2(4 BYTE)                     NULL,
  TRM_DES      VARCHAR2(60 BYTE)                    NULL,
  TRM_DATCRE   DATE                                 NULL,
  TRM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TRM_DATMOD   DATE                                 NULL,
  TRM_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_TTR
(
  TTR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TTR_COD      NUMBER(10)                           NULL,
  TTR_DES      VARCHAR2(1000 BYTE)                  NULL,
  TTR_DATCRE   DATE                                 NULL,
  TTR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TTR_DATMOD   DATE                                 NULL,
  TTR_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_VAD
(
  VAD_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  VAD_COD      NUMBER(10)                           NULL,
  VAD_TIP      NUMBER(2)                            NULL,
  VAD_DES      VARCHAR2(60 BYTE)                    NULL,
  VAD_DATCRE   DATE                                 NULL,
  VAD_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VAD_DATMOD   DATE                                 NULL,
  VAD_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_ZON
(
  ZON_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  ZON_COD      VARCHAR2(4 BYTE)                     NULL,
  ZON_ZONTRE   VARCHAR2(1 BYTE)                     NULL,
  ZON_NOM      VARCHAR2(30 BYTE)                    NULL,
  ZON_OBS      VARCHAR2(1000 BYTE)                  NULL,
  ZON_DATCRE   DATE                                 NULL,
  ZON_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ZON_DATMOD   DATE                                 NULL,
  ZON_USUMOD   VARCHAR2(30 BYTE)                    NULL
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


CREATE INDEX IRHU_COV_IDF_FK ON TRHU_COV
(COV_IDF_COD)
;


CREATE INDEX IRHU_FFO_DAT ON TRHU_FFO
(FFO_IDF_COD, FFO_CLN_DAT)
;


CREATE INDEX IRHU_FFO_DAT002 ON TRHU_FFO
(FFO_IDF_COD, FFO_COD, FFO_CLN_DAT)
;


CREATE INDEX IRHU_FFO_FFM_FK ON TRHU_FFO
(FFO_FFM_COD, FFO_IDF_COD)
;


CREATE INDEX IRHU_FFO_OPEDAT ON TRHU_FFO
(FFO_IDF_COD, FFO_OPE_COD, FFO_CLN_DAT)
;


CREATE INDEX IRHU_FFO_RDI_FK ON TRHU_FFO
(FFO_CLN_DAT, FFO_OPE_COD, FFO_IDF_COD)
;


CREATE INDEX IRHU_PAR_IDF_FK ON TRHU_PAR
(PAR_IDF_COD)
;


CREATE INDEX IRHU_REG_IDF_FK ON TRHU_REG
(REG_IDF_COD)
;


CREATE INDEX IRHU_SNO_IDF_FK ON TRHU_SNO
(SNO_IDF_COD)
;


CREATE INDEX IRHU_TAN_IDF_FK ON TRHU_TAN
(TAN_IDF_COD)
;


CREATE INDEX IRHU_TBA_IDF_FK ON TRHU_TBA
(TBA_IDF_COD)
;


CREATE INDEX IRHU_TCN_IDF_FK_I ON TRHU_TCN
(TCN_IDF_COD)
;


CREATE INDEX IRHU_TCT_IDF_FK ON TRHU_TCT
(TCT_IDF_COD)
;


CREATE INDEX IRHU_TDI_IDF_FK ON TRHU_TDI
(TDI_IDF_COD)
;


CREATE INDEX IRHU_TDI_REG_FK ON TRHU_TDI
(TDI_REG_COD, TDI_IDF_COD)
;


CREATE INDEX IRHU_TMO_IDF_FK ON TRHU_TMO
(TMO_IDF_COD)
;


CREATE INDEX IRHU_TOR_IDF_FK ON TRHU_TOR
(TOR_IDF_COD)
;


CREATE INDEX IRHU_TTR_IDF_FK ON TRHU_TTR
(TTR_IDF_COD)
;


CREATE INDEX IRHU_ZON_IDF_FK ON TRHU_ZON
(ZON_IDF_COD)
;


CREATE INDEX IRMA_CMB002_IDF_FK ON TRMA_CMB002
(CMB_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_CEN_PK ON TRHU_CEN
(CEN_IDF_COD, CEN_COD)
;


CREATE UNIQUE INDEX RRHU_COV_PK ON TRHU_COV
(COV_IDF_COD, COV_COD)
;


CREATE UNIQUE INDEX RRHU_CSTOPE_PK ON TRHU_CSTOPE
(CSTOPE_IDF_COD, CSTOPE_EMP_COD, CSTOPE_OPE_COD, CSTOPE_MES, CSTOPE_ANY)
;


CREATE UNIQUE INDEX RRHU_FFO_PK ON TRHU_FFO
(FFO_COD, FFO_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_IDF_PK ON TRHU_IDF
(IDF_COD)
;


CREATE UNIQUE INDEX RRHU_IMPAPP_PK ON TRHU_IMP_APP
(IAP_SEQ, IAP_EMP_COD, IAP_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_IMP_BAI_PK ON TRHU_IMP_BAI
(BAI_REF)
;


CREATE UNIQUE INDEX RRHU_IMP_CCS_PK ON TRHU_IMP_CCS
(CCS_REF)
;


CREATE UNIQUE INDEX RRHU_IMP_OPE_PK ON TRHU_IMP_OPE
(OPE_REF)
;


CREATE UNIQUE INDEX RRHU_IMP_VAC_PK ON TRHU_IMP_VAC
(VAC_REF)
;


CREATE UNIQUE INDEX RRHU_OPD_PK ON TRHU_OPD
(OPD_IDF_COD, OPD_OPE_COD, OPD_SEQ)
;


CREATE UNIQUE INDEX RRHU_OPP_PK ON TRHU_OPP
(OPP_IDF_COD, OPP_OPE_COD, OPP_SEQ)
;


CREATE UNIQUE INDEX RRHU_OPR_PK ON TRHU_OPR
(OPR_IDF_COD, OPR_OPE_COD, OPR_SEQ)
;


CREATE UNIQUE INDEX RRHU_PAR_PK ON TRHU_PAR
(PAR_COD, PAR_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_PLT_PK ON TRHU_PLT
(PLT_IDF_COD, PLT_COD)
;


CREATE UNIQUE INDEX RRHU_REG_PK ON TRHU_REG
(REG_IDF_COD, REG_COD)
;


CREATE UNIQUE INDEX RRHU_SNO_PK ON TRHU_SNO
(SNO_COD, SNO_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_TAM_PK ON TRHU_TAM
(TAM_IDF_COD, TAM_COD)
;


CREATE UNIQUE INDEX RRHU_TAN_PK ON TRHU_TAN
(TAN_COD, TAN_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_TBA_PK ON TRHU_TBA
(TBA_COD, TBA_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_TCA_PK ON TRHU_TCA
(TCA_IDF_COD, TCA_COD)
;


CREATE UNIQUE INDEX RRHU_TCI_PK ON TRHU_TCI
(TCI_IDF_COD, TCI_COD)
;


CREATE UNIQUE INDEX RRHU_TCN_PK ON TRHU_TCN
(TCN_COD, TCN_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_TCT_PK ON TRHU_TCT
(TCT_COD, TCT_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_TDI_PK ON TRHU_TDI
(TDI_COD, TDI_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_TDS_PK ON TRHU_TDS
(TDS_IDF_COD, TDS_COD)
;


CREATE UNIQUE INDEX RRHU_TFE_PK ON TRHU_TFE
(TFE_IDF_COD, TFE_COD)
;


CREATE UNIQUE INDEX RRHU_TIC_PK ON TRHU_TIC
(TIC_IDF_COD, TIC_COD)
;


CREATE UNIQUE INDEX RRHU_TMO_PK ON TRHU_TMO
(TMO_IDF_COD, TMO_COD)
;


CREATE UNIQUE INDEX RRHU_TMPLFF_PK ON TRHU_TMP_LFF
(LFF_IDF_COD, LFF_FFO_COD, LFF_NUM);


CREATE UNIQUE INDEX RRHU_TOR_PK ON TRHU_TOR
(TOR_IDF_COD, TOR_COD)
;


CREATE UNIQUE INDEX RRHU_TRM_PK ON TRHU_TRM
(TRM_IDF_COD, TRM_COD)
;


CREATE UNIQUE INDEX RRHU_TTR_PK ON TRHU_TTR
(TTR_COD, TTR_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_VAD_PK ON TRHU_VAD
(VAD_IDF_COD, VAD_COD)
;


CREATE UNIQUE INDEX RRHU_ZON_PK ON TRHU_ZON
(ZON_IDF_COD, ZON_COD)
;


CREATE UNIQUE INDEX RRMA_CMB002_PK ON TRMA_CMB002
(CMB_IDF_COD, CMB_REF)
;


CREATE INDEX X_RRHH_REF_CODES_1 ON RRHH_REF_CODES
(RV_DOMAIN, RV_LOW_VALUE)
;


CREATE TABLE TRHU_ANL
(
  ANL_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  ANL_COD      VARCHAR2(6 BYTE)                     NULL,
  ANL_NOM      VARCHAR2(30 BYTE)                    NULL,
  ANL_DATINI   DATE                                 NULL,
  ANL_DATFIN   DATE                                 NULL,
  ANL_DATCRE   DATE                                 NULL,
  ANL_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ANL_DATMOD   DATE                                 NULL,
  ANL_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_CAT
(
  CAT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CAT_COD      VARCHAR2(4 BYTE)                     NULL,
  CAT_NOM      VARCHAR2(30 BYTE)                    NULL,
  CAT_OBS      VARCHAR2(1000 BYTE)                  NULL,
  CAT_ART_COD  VARCHAR2(15 BYTE)                    NULL,
  CAT_DATCRE   DATE                                 NULL,
  CAT_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CAT_DATMOD   DATE                                 NULL,
  CAT_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CAT_SOUBAS   NUMBER(15,3)                         NULL,
  CAT_COV_COD  VARCHAR2(4 BYTE)                     NULL,
  CAT_ACT      VARCHAR2(1 BYTE)                     NULL,
  CAT_RLE_COD  VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_CIN
(
  CIN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CIN_NUM      NUMBER(10)                           NULL,
  CIN_ANY      NUMBER(4)                            NULL,
  CIN_MES      NUMBER(2)                            NULL,
  CIN_TCI_COD  VARCHAR2(6 BYTE)                     NULL,
  CIN_IMP      NUMBER(15,2)                         NULL,
  CIN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CIN_DATCRE   DATE                                 NULL,
  CIN_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CIN_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_CLN
(
  CLN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CLN_DAT      DATE                                 NULL,
  CLN_TDI_COD  VARCHAR2(4 BYTE)                     NULL,
  CLN_DES      VARCHAR2(1000 BYTE)                  NULL,
  CLN_OBS      VARCHAR2(1000 BYTE)                  NULL,
  CLN_DATCRE   DATE                                 NULL,
  CLN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CLN_DATMOD   DATE                                 NULL,
  CLN_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_CNM
(
  CNM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CNM_COD      VARCHAR2(4 BYTE)                     NULL,
  CNM_TCN_COD  VARCHAR2(4 BYTE)                     NULL,
  CNM_NOM      VARCHAR2(30 BYTE)                    NULL,
  CNM_DATCRE   DATE                                 NULL,
  CNM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CNM_NUMCAS   NUMBER(3)                            NULL,
  CNM_DES      VARCHAR2(1000 BYTE)                  NULL,
  CNM_DATMOD   DATE                                 NULL,
  CNM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CNM_FML      VARCHAR2(255 BYTE)                   NULL,
  CNM_NMN      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_CNT
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


CREATE TABLE TRHU_COF
(
  COF_COD           VARCHAR2(4 BYTE)                NULL,
  COF_IDF_COD       VARCHAR2(4 BYTE)                NULL,
  COF_CREAUT        VARCHAR2(1 BYTE)                NULL,
  COF_NOM           VARCHAR2(30 BYTE)               NULL,
  COF_DATCRE        DATE                            NULL,
  COF_USUCRE        VARCHAR2(30 BYTE)               NULL,
  COF_TRSALB        VARCHAR2(1 BYTE)                NULL,
  COF_UNI           VARCHAR2(10 BYTE)               NULL,
  COF_QUA           VARCHAR2(1 BYTE)                NULL,
  COF_PRUUNI        VARCHAR2(1 BYTE)                NULL,
  COF_IMP           VARCHAR2(1 BYTE)                NULL,
  COF_TIPIMP        VARCHAR2(1 BYTE)                NULL,
  COF_TIPUNI        VARCHAR2(1 BYTE)                NULL,
  COF_CNM_COD       VARCHAR2(4 BYTE)                NULL,
  COF_DATMOD        DATE                            NULL,
  COF_USUMOD        VARCHAR2(30 BYTE)               NULL,
  COF_ORIART        VARCHAR2(1 BYTE)                NULL,
  COF_PRUTRA        VARCHAR2(1 BYTE)                NULL,
  COF_ART_COD       VARCHAR2(15 BYTE)               NULL,
  COF_MAXUNI        NUMBER                          NULL,
  COF_ACCCML        VARCHAR2(1 BYTE)                NULL,
  COF_AVIOBL        VARCHAR2(1 BYTE)                NULL,
  COF_FCTCMSHOR     NUMBER(4,2)                     NULL,
  COF_COF_COD       VARCHAR2(4 BYTE)                NULL,
  COF_TIPUNI002     VARCHAR2(1 BYTE)                NULL,
  COF_COF_COD002    VARCHAR2(4 BYTE)                NULL,
  COF_PDA           VARCHAR2(1 BYTE)                NULL,
  COF_FCTCMSHORCMS  NUMBER(4,2)                     NULL
)
;


CREATE TABLE TRHU_CUR
(
  CUR_TIC_COD  VARCHAR2(4 BYTE)                     NULL,
  CUR_COD      VARCHAR2(6 BYTE)                     NULL,
  CUR_DES      VARCHAR2(1000 BYTE)                  NULL,
  CUR_DATINI   DATE                                 NULL,
  CUR_DUR      NUMBER                               NULL,
  CUR_IPT      VARCHAR2(30 BYTE)                    NULL,
  CUR_VDS      VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  CUR_DATCRE   DATE                                 NULL,
  CUR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CUR_DATMOD   DATE                                 NULL,
  CUR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CUR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CUR_NUMALU   NUMBER(4)                            NULL,
  CUR_TEM      NUMBER(1)                            NULL,
  CUR_DATFIN   DATE                                 NULL,
  CUR_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRHU_EMA
(
  EMA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  EMA_COD      VARCHAR2(4 BYTE)                     NULL,
  EMA_DATCRE   DATE                                 NULL,
  EMA_NOM      VARCHAR2(30 BYTE)                    NULL,
  EMA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  EMA_DATMOD   DATE                                 NULL,
  EMA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  EMA_RPT      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_EMP
(
  EMP_IDF_COD                VARCHAR2(4 BYTE)       NULL,
  EMP_COD                    VARCHAR2(4 BYTE)       NULL,
  EMP_NOM                    VARCHAR2(40 BYTE)      NULL,
  EMP_PRNLOG                 VARCHAR2(1 BYTE)       NULL,
  EMP_DOM                    VARCHAR2(60 BYTE)      NULL,
  EMP_CPO                    VARCHAR2(5 BYTE)       NULL,
  EMP_POB                    VARCHAR2(30 BYTE)      NULL,
  EMP_CIF                    VARCHAR2(12 BYTE)      NULL,
  EMP_TEL                    VARCHAR2(60 BYTE)      NULL,
  EMP_FAX                    VARCHAR2(60 BYTE)      NULL,
  EMP_EML                    VARCHAR2(60 BYTE)      NULL,
  EMP_WWW                    VARCHAR2(60 BYTE)      NULL,
  EMP_LOG                    LONG RAW               NULL,
  EMP_DATCRE                 DATE                   NULL,
  EMP_USUCRE                 VARCHAR2(30 BYTE)      NULL,
  EMP_DATMOD                 DATE                   NULL,
  EMP_USUMOD                 VARCHAR2(30 BYTE)      NULL,
  EMP_EMPCMP                 VARCHAR2(4 BYTE)       NULL,
  EMP_EXCCMP                 VARCHAR2(4 BYTE)       NULL,
  EMP_TIPASICMP              VARCHAR2(2 BYTE)       NULL,
  EMP_DRI001                 VARCHAR2(2 BYTE)       NULL,
  EMP_DRI002                 VARCHAR2(2 BYTE)       NULL,
  EMP_CTE                    VARCHAR2(10 BYTE)      NULL,
  EMP_CTERET                 VARCHAR2(10 BYTE)      NULL,
  EMP_CTESGR                 VARCHAR2(10 BYTE)      NULL,
  EMP_CTEEMB                 VARCHAR2(10 BYTE)      NULL,
  EMP_CTETEROPE              VARCHAR2(1 BYTE)       NULL,
  EMP_CTERETTEROPE           VARCHAR2(1 BYTE)       NULL,
  EMP_CTESGRTEROPE           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEEMBTEROPE           VARCHAR2(1 BYTE)       NULL,
  EMP_ASIGRP                 VARCHAR2(1 BYTE)       NULL,
  EMP_CRECTE                 VARCHAR2(1 BYTE)       NULL,
  EMP_VACDIANAT              VARCHAR2(1 BYTE)   DEFAULT 'N'                       NULL,
  EMP_CTESGREMP              VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERSGREMP           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEORGSGREMP           VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERORGSGREMP        VARCHAR2(1 BYTE)       NULL,
  EMP_CTEBANEMP              VARCHAR2(10 BYTE)      NULL,
  EMP_ASIPRRPAGEXT           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEPRRPAGEXT           VARCHAR2(10 BYTE)      NULL,
  EMP_CTESEGSAN              VARCHAR2(10 BYTE)      NULL,
  EMP_CTEANC                 VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERPRRPAGEXT        VARCHAR2(1 BYTE)       NULL,
  EMP_CTETERSEGSAN           VARCHAR2(1 BYTE)       NULL,
  EMP_CTETERANC              VARCHAR2(1 BYTE)       NULL,
  EMP_CTEPRRPAGEXTPDTPAG     VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERPRRPAGEXTPDTPAG  VARCHAR2(1 BYTE)       NULL,
  EMP_CTEALTDSPSOC           VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERALTDSPSOC        VARCHAR2(1 BYTE)       NULL,
  EMP_CTEINZERO              VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERINZERO           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEINZTMP              VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERINZTMP           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEINZALT              VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERINZALT           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEDTEVAR              VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERDTEVAR           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEIRPMAT              VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERIRPMAT           VARCHAR2(1 BYTE)       NULL,
  EMP_CTESGRCVN              VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERPEN              VARCHAR2(1 BYTE)       NULL,
  EMP_CTETERVAC              VARCHAR2(1 BYTE)       NULL,
  EMP_CTETERDSPDPL           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEPEN                 VARCHAR2(10 BYTE)      NULL,
  EMP_CTEVAC                 VARCHAR2(10 BYTE)      NULL,
  EMP_CTEDSPDPL              VARCHAR2(10 BYTE)      NULL,
  EMP_CTETERMLT              VARCHAR2(1 BYTE)       NULL,
  EMP_CTETERDIF              VARCHAR2(1 BYTE)       NULL,
  EMP_CTETERNOTPRS           VARCHAR2(1 BYTE)       NULL,
  EMP_CTEMLT                 VARCHAR2(10 BYTE)      NULL,
  EMP_CTEDIF                 VARCHAR2(10 BYTE)      NULL,
  EMP_CTENOTPRS              VARCHAR2(10 BYTE)      NULL,
  EMP_INRCLD                 VARCHAR2(1 BYTE)       NULL,
  EMP_CTENMNANT              VARCHAR2(10 BYTE)      NULL,
  EMP_CTEMAT                 VARCHAR2(10 BYTE)      NULL
)
;


CREATE TABLE TRHU_FEX
(
  FEX_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FEX_TFE_COD  VARCHAR2(4 BYTE)                     NULL,
  FEX_COD      VARCHAR2(6 BYTE)                     NULL,
  FEX_RGL      VARCHAR2(1 BYTE)                     NULL,
  FEX_VDS      VARCHAR2(1 BYTE)                     NULL,
  FEX_DATCRE   DATE                                 NULL,
  FEX_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FEX_DES      VARCHAR2(1000 BYTE)                  NULL,
  FEX_DATVDS   DATE                                 NULL,
  FEX_TTL      VARCHAR2(1000 BYTE)                  NULL,
  FEX_OBS      VARCHAR2(1000 BYTE)                  NULL,
  FEX_DATMOD   DATE                                 NULL,
  FEX_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_FPE
(
  FPE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FPE_COD      VARCHAR2(4 BYTE)                     NULL,
  FPE_TDI_COD  VARCHAR2(4 BYTE)                     NULL,
  FPE_TIP      VARCHAR2(1 BYTE)                     NULL,
  FPE_MES      NUMBER(2)                            NULL,
  FPE_NOM      VARCHAR2(30 BYTE)                    NULL,
  FPE_OBS      VARCHAR2(1000 BYTE)                  NULL,
  FPE_DIAMES   NUMBER(2)                            NULL,
  FPE_SET      NUMBER(1)                            NULL,
  FPE_DIASET   NUMBER(1)                            NULL,
  FPE_DATCRE   DATE                                 NULL,
  FPE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FPE_DATMOD   DATE                                 NULL,
  FPE_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_GFE
(
  GFE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  GFE_COD      VARCHAR2(4 BYTE)                     NULL,
  GFE_NOM      VARCHAR2(60 BYTE)                    NULL,
  GFE_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRHU_GRE
(
  GRE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  GRE_COD      VARCHAR2(4 BYTE)                     NULL,
  GRE_DATCRE   DATE                                 NULL,
  GRE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  GRE_NOM      VARCHAR2(30 BYTE)                    NULL,
  GRE_DES      VARCHAR2(1000 BYTE)                  NULL,
  GRE_DATMOD   DATE                                 NULL,
  GRE_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  GRE_NUMHOR   NUMBER(4,2)                      DEFAULT 8                         NULL
)
;


CREATE TABLE TRHU_GSE
(
  GSE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  GSE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  GSE_COD      VARCHAR2(4 BYTE)                     NULL,
  GSE_NOM      VARCHAR2(30 BYTE)                    NULL,
  GSE_DATCRE   DATE                                 NULL,
  GSE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  GSE_DATMOD   DATE                                 NULL,
  GSE_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_HOD
(
  HOD_COD      VARCHAR2(4 BYTE)                     NULL,
  HOD_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  HOD_NOM      VARCHAR2(30 BYTE)                    NULL,
  HOD_HOR      INTEGER                              NULL,
  HOD_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  HOD_DATCRE   DATE                                 NULL,
  HOD_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  HOD_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_HOR
(
  HOR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  HOR_COD      VARCHAR2(4 BYTE)                     NULL,
  HOR_NOM      VARCHAR2(30 BYTE)                    NULL,
  HOR_TIP      VARCHAR2(1 BYTE)                     NULL,
  HOR_DES      VARCHAR2(1000 BYTE)                  NULL,
  HOR_HOR      NUMBER(15,2)                         NULL,
  HOR_DATCRE   DATE                                 NULL,
  HOR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  HOR_DATMOD   DATE                                 NULL,
  HOR_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_IHO
(
  IHO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  IHO_HOR_COD  VARCHAR2(4 BYTE)                     NULL,
  IHO_LIN      NUMBER(10)                           NULL,
  IHO_ENT      DATE                                 NULL,
  IHO_SOR      DATE                                 NULL,
  IHO_DLS      VARCHAR2(1 BYTE)                     NULL,
  IHO_DMS      VARCHAR2(1 BYTE)                     NULL,
  IHO_DCS      VARCHAR2(1 BYTE)                     NULL,
  IHO_DJS      VARCHAR2(1 BYTE)                     NULL,
  IHO_DVS      VARCHAR2(1 BYTE)                     NULL,
  IHO_DSE      VARCHAR2(1 BYTE)                     NULL,
  IHO_DME      VARCHAR2(1 BYTE)                     NULL,
  IHO_DATCRE   DATE                                 NULL,
  IHO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  IHO_DATMOD   DATE                                 NULL,
  IHO_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_LFE
(
  LFE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  LFE_GFE_COD  VARCHAR2(4 BYTE)                     NULL,
  LFE_COD      VARCHAR2(4 BYTE)                     NULL,
  LFE_DES      VARCHAR2(60 BYTE)                    NULL,
  LFE_REG_COD  VARCHAR2(4 BYTE)                     NULL,
  LFE_TIPFES   VARCHAR2(1 BYTE)                     NULL,
  LFE_MES      NUMBER(2)                            NULL,
  LFE_DIAMES   NUMBER(2)                            NULL,
  LFE_SET      NUMBER(1)                            NULL,
  LFE_DIASET   NUMBER(1)                            NULL,
  LFE_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRHU_MAO
(
  MAO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  MAO_COD      VARCHAR2(15 BYTE)                    NULL,
  MAO_TMO_COD  VARCHAR2(4 BYTE)                     NULL,
  MAO_DES      VARCHAR2(30 BYTE)                    NULL,
  MAO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  MAO_DATCRE   DATE                                 NULL,
  MAO_ART_COD  VARCHAR2(15 BYTE)                    NULL,
  MAO_MESRPO   NUMBER(3)                            NULL,
  MAO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  MAO_DATMOD   DATE                                 NULL,
  MAO_OBS      VARCHAR2(1000 BYTE)                  NULL,
  MAO_CHKBLO   VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_NOD
(
  NOD_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  NOD_NUM         NUMBER(10)                        NULL,
  NOD_TIP         VARCHAR2(1 BYTE)                  NULL,
  NOD_ZON_CODORI  VARCHAR2(4 BYTE)                  NULL,
  NOD_ZON_CODDTI  VARCHAR2(4 BYTE)                  NULL,
  NOD_SNO_COD     VARCHAR2(4 BYTE)                  NULL,
  NOD_DATCRE      DATE                              NULL,
  NOD_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  NOD_TIP1        VARCHAR2(10 BYTE)                 NULL,
  NOD_DATMOD      DATE                              NULL,
  NOD_DES         VARCHAR2(1000 BYTE)               NULL,
  NOD_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  NOD_PORCMU      NUMBER(2)                         NULL,
  NOD_PRACMU      VARCHAR2(1 BYTE)                  NULL,
  NOD_VELCMU      NUMBER(6)                         NULL,
  NOD_BITDAD      NUMBER(2)                         NULL,
  NOD_BITATU      NUMBER(2)                         NULL,
  NOD_TIPLLE      VARCHAR2(1 BYTE)                  NULL,
  NOD_PORBOM      NUMBER(2)                         NULL,
  NOD_WAV         VARCHAR2(50 BYTE)                 NULL
)
;


CREATE TABLE TRHU_OPE
(
  OPE_IDF_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_COD              VARCHAR2(6 BYTE)             NULL,
  OPE_NOM              VARCHAR2(40 BYTE)            NULL,
  OPE_ACT              VARCHAR2(1 BYTE)             NULL,
  OPE_ENTSOR           VARCHAR2(1 BYTE)         DEFAULT 'S'                       NULL,
  OPE_CML              VARCHAR2(1 BYTE)             NULL,
  OPE_HOR_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_TOR              VARCHAR2(1 BYTE)             NULL,
  OPE_PIN              VARCHAR2(25 BYTE)            NULL,
  OPE_DATCRE           DATE                         NULL,
  OPE_USUCRE           VARCHAR2(30 BYTE)            NULL,
  OPE_ENC              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_IND              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_HORESP           VARCHAR2(1 BYTE)             NULL,
  OPE_APLDIA           VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_DLS              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_DMS              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_DCS              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_DJS              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_DVS              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_DSE              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_DME              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_NGR              VARCHAR2(1 BYTE)         DEFAULT 'N'                       NULL,
  OPE_CTLFFO           VARCHAR2(1 BYTE)         DEFAULT 'C'                       NULL,
  OPE_CTLHOE           VARCHAR2(1 BYTE)         DEFAULT 'C'                       NULL,
  OPE_CALHOR           NUMBER(1)                    NULL,
  OPE_HORCAN           VARCHAR2(1 BYTE)             NULL,
  OPE_ESTCIV           VARCHAR2(1 BYTE)             NULL,
  OPE_DCC              VARCHAR2(2 BYTE)             NULL,
  OPE_FIL              NUMBER(2)                    NULL,
  OPE_TCS_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_HORLLI           NUMBER(4)                    NULL,
  OPE_HORLLI002        NUMBER(4)                    NULL,
  OPE_BAN_CODCCR       NUMBER(4)                    NULL,
  OPE_OFB_CODCCR       NUMBER(4)                    NULL,
  OPE_ZON_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_EMP_CODCCR       VARCHAR2(4 BYTE)             NULL,
  OPE_HOR_COD002       VARCHAR2(4 BYTE)             NULL,
  OPE_HOR_CODNIT       VARCHAR2(4 BYTE)             NULL,
  OPE_GRE_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_OFB              NUMBER(4)                    NULL,
  OPE_BAN              NUMBER(4)                    NULL,
  OPE_HORVAC           NUMBER(4)                    NULL,
  OPE_CPO              VARCHAR2(5 BYTE)             NULL,
  OPE_MTR              NUMBER(5)                    NULL,
  OPE_CODALT           VARCHAR2(30 BYTE)            NULL,
  OPE_OPE_COD          VARCHAR2(6 BYTE)             NULL,
  OPE_CCR_COD          NUMBER(10)                   NULL,
  OPE_CTECMP           VARCHAR2(10 BYTE)            NULL,
  OPE_CCR              NUMBER(10)                   NULL,
  OPE_DATNAI           DATE                         NULL,
  OPE_DATMOD           DATE                         NULL,
  OPE_DAT              DATE                         NULL,
  OPE_NIF              VARCHAR2(12 BYTE)            NULL,
  OPE_NSS              VARCHAR2(15 BYTE)            NULL,
  OPE_NMN1             NUMBER(15,3)                 NULL,
  OPE_NMN2             NUMBER(15,3)                 NULL,
  OPE_PRUEXTDLS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDMS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDCS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDJS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDVS        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDSE        NUMBER(15,2)                 NULL,
  OPE_PRUEXTDME        NUMBER(15,2)                 NULL,
  OPE_PRUHORNOR        NUMBER(15,2)                 NULL,
  OPE_PRUNITDLS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDMS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDCS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDJS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDVS        NUMBER(15,2)                 NULL,
  OPE_PRUNITDSE        NUMBER(15,2)                 NULL,
  OPE_PRUNITDME        NUMBER(15,2)                 NULL,
  OPE_CPLSAL1          NUMBER(15,2)                 NULL,
  OPE_CPLSAL2          NUMBER(15,2)                 NULL,
  OPE_COSADD           NUMBER(15,2)                 NULL,
  OPE_USU_COD          VARCHAR2(30 BYTE)            NULL,
  OPE_POB              VARCHAR2(30 BYTE)            NULL,
  OPE_PRV              VARCHAR2(30 BYTE)            NULL,
  OPE_USUMOD           VARCHAR2(30 BYTE)            NULL,
  OPE_NOMPAE           VARCHAR2(40 BYTE)            NULL,
  OPE_NOMMAE           VARCHAR2(40 BYTE)            NULL,
  OPE_LLCNAI           VARCHAR2(60 BYTE)            NULL,
  OPE_EML              VARCHAR2(60 BYTE)            NULL,
  OPE_TEL              VARCHAR2(60 BYTE)            NULL,
  OPE_DOM              VARCHAR2(60 BYTE)            NULL,
  OPE_OBS              VARCHAR2(1000 BYTE)          NULL,
  OPE_DATVALTRG        DATE                         NULL,
  OPE_VAD_COD          NUMBER(10)                   NULL,
  OPE_PJB              VARCHAR2(1 BYTE)             NULL,
  OPE_DIAPJB           DATE                         NULL,
  OPE_HORANYPJB        NUMBER(4)                    NULL,
  OPE_HORPENANYANTPJB  NUMBER(4)                    NULL,
  OPE_OBSPJB           VARCHAR2(1000 BYTE)          NULL,
  OPE_PLUPDT           VARCHAR2(1 BYTE)             NULL,
  OPE_TOR_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_TORDIAINI        DATE                         NULL,
  OPE_GFE_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_SEX              VARCHAR2(1 BYTE)             NULL,
  OPE_TELEMP           VARCHAR2(60 BYTE)            NULL,
  OPE_TPC              VARCHAR2(15 BYTE)            NULL,
  OPE_MNS              NUMBER(3)                    NULL,
  OPE_TGTCOD           VARCHAR2(30 BYTE)            NULL,
  OPE_HORRUT           VARCHAR2(1 BYTE)             NULL,
  OPE_DERDIE           VARCHAR2(1 BYTE)             NULL,
  OPE_PTENMN           NUMBER(3)                    NULL,
  OPE_IBNPAI           VARCHAR2(2 BYTE)             NULL,
  OPE_IBNDCC           VARCHAR2(2 BYTE)             NULL,
  OPE_IBNBIC           VARCHAR2(11 BYTE)            NULL,
  OPE_EXP_COD          VARCHAR2(4 BYTE)             NULL,
  OPE_DISCOS           VARCHAR2(2 BYTE)             NULL,
  OPE_ANECMP           VARCHAR2(4 BYTE)             NULL,
  OPE_DEPCMP           VARCHAR2(4 BYTE)             NULL,
  OPE_DEPCMPFXE        VARCHAR2(1 BYTE)             NULL,
  OPE_CEN_COD          VARCHAR2(6 BYTE)             NULL,
  OPE_DTEHOR           NUMBER(5,3)                  NULL,
  OPE_ADO              VARCHAR2(1 BYTE)             NULL,
  OPE_MAXHOE001        NUMBER(3,1)                  NULL,
  OPE_PTENMN002        NUMBER(3)                    NULL,
  OPE_EMLEMP           VARCHAR2(30 BYTE)            NULL,
  OPE_COSIDR           VARCHAR2(1 BYTE)             NULL,
  OPE_PAS              VARCHAR2(4 BYTE)             NULL,
  OPE_APP              VARCHAR2(1 BYTE)             NULL,
  OPE_ALI              VARCHAR2(30 BYTE)            NULL,
  OPE_HOR_COD003       VARCHAR2(4 BYTE)             NULL,
  OPE_MDCNTF           VARCHAR2(1 BYTE)             NULL,
  OPE_NOTHOREXT        VARCHAR2(1 BYTE)             NULL,
  OPE_USUCLD           VARCHAR2(100 BYTE)           NULL
)
;


CREATE TABLE TRHU_OPM
(
  OPM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  OPM_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  OPM_BLO      VARCHAR2(1 BYTE)                     NULL,
  OPM_BAI      VARCHAR2(1 BYTE)                     NULL,
  OPM_DATCRE   DATE                                 NULL,
  OPM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OPM_TEL      VARCHAR2(60 BYTE)                    NULL,
  OPM_EXN      VARCHAR2(60 BYTE)                    NULL,
  OPM_DATMOD   DATE                                 NULL,
  OPM_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_PEO
(
  PEO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PEO_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  PEO_PLT_COD  VARCHAR2(4 BYTE)                     NULL,
  PEO_DAT      DATE                                 NULL,
  PEO_OBS      VARCHAR2(1000 BYTE)                  NULL,
  PEO_FORACA   VARCHAR2(1 BYTE)                     NULL,
  PEO_FORESP   VARCHAR2(1 BYTE)                     NULL,
  PEO_EXP      VARCHAR2(1 BYTE)                     NULL,
  PEO_OTROS    VARCHAR2(1 BYTE)                     NULL,
  PEO_VAL      VARCHAR2(2 BYTE)                     NULL
)
;


CREATE TABLE TRHU_PNO
(
  PNO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PNO_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PNO_COD      VARCHAR2(6 BYTE)                     NULL,
  PNO_FECINI   DATE                                 NULL,
  PNO_FECFIN   DATE                                 NULL,
  PNO_DATCRE   DATE                                 NULL,
  PNO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PNO_NOM      VARCHAR2(30 BYTE)                    NULL,
  PNO_DES      VARCHAR2(1000 BYTE)                  NULL,
  PNO_DATMOD   DATE                                 NULL,
  PNO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PNO_TAN      VARCHAR2(1 BYTE)                     NULL,
  PNO_ANL_COD  VARCHAR2(6 BYTE)                     NULL,
  PNO_FNQ      VARCHAR2(1 BYTE)                 DEFAULT 'N'                       NULL,
  PNO_PNO_COD  VARCHAR2(6 BYTE)                     NULL
)
;


CREATE TABLE TRHU_POR
(
  POR_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  POR_REG_COD    VARCHAR2(4 BYTE)                   NULL,
  POR_OPE_COD    VARCHAR2(6 BYTE)                   NULL,
  POR_PRUEXTDLS  NUMBER(15,2)                       NULL,
  POR_PRUEXTDMS  NUMBER(15,2)                       NULL,
  POR_PRUEXTDCS  NUMBER(15,2)                       NULL,
  POR_PRUEXTDJS  NUMBER(15,2)                       NULL,
  POR_PRUEXTDVS  NUMBER(15,2)                       NULL,
  POR_PRUEXTDSE  NUMBER(15,2)                       NULL,
  POR_PRUEXTDME  NUMBER(15,2)                       NULL,
  POR_PRUNITDLS  NUMBER(15,2)                       NULL,
  POR_PRUNITDMS  NUMBER(15,2)                       NULL,
  POR_PRUNITDCS  NUMBER(15,2)                       NULL,
  POR_PRUNITDJS  NUMBER(15,2)                       NULL,
  POR_PRUNITDVS  NUMBER(15,2)                       NULL,
  POR_PRUNITDSE  NUMBER(15,2)                       NULL,
  POR_PRUNITDME  NUMBER(15,2)                       NULL,
  POR_DATMOD     DATE                               NULL,
  POR_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  POR_DATCRE     DATE                               NULL,
  POR_USUCRE     VARCHAR2(30 BYTE)                  NULL
)
;


CREATE TABLE TRHU_PPF
(
  PPF_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  PPF_SEQ        NUMBER(10)                         NULL,
  PPF_UNI        NUMBER(5,2)                        NULL,
  PPF_DIAINI     DATE                               NULL,
  PPF_REF        VARCHAR2(20 BYTE)                  NULL,
  PPF_LUN        VARCHAR2(1 BYTE)                   NULL,
  PPF_MAR        VARCHAR2(1 BYTE)                   NULL,
  PPF_MIE        VARCHAR2(1 BYTE)                   NULL,
  PPF_JUE        VARCHAR2(1 BYTE)                   NULL,
  PPF_VIE        VARCHAR2(1 BYTE)                   NULL,
  PPF_SAB        VARCHAR2(1 BYTE)                   NULL,
  PPF_DOM        VARCHAR2(1 BYTE)                   NULL,
  PPF_FES        VARCHAR2(1 BYTE)                   NULL,
  PPF_VAC        VARCHAR2(1 BYTE)                   NULL,
  PPF_BAJ        VARCHAR2(1 BYTE)                   NULL,
  PPF_CMS        VARCHAR2(1 BYTE)                   NULL,
  PPF_LLIDIS     VARCHAR2(1 BYTE)                   NULL,
  PPF_DIAFIN     DATE                               NULL,
  PPF_ULTDIACAR  DATE                               NULL,
  PPF_OPE_COD    VARCHAR2(6 BYTE)                   NULL,
  PPF_COF_COD    VARCHAR2(4 BYTE)                   NULL,
  PPF_CLI_COD    VARCHAR2(6 BYTE)                   NULL,
  PPF_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  PPF_PRJ_NUM    VARCHAR2(6 BYTE)                   NULL,
  PPF_ETP_NUM    NUMBER(3)                          NULL,
  PPF_ETP_COD    VARCHAR2(4 BYTE)                   NULL,
  PPF_UCE_SEQ    NUMBER(10)                         NULL,
  PPF_LES_SEQ    NUMBER(10)                         NULL,
  PPF_RLE_SEQ    NUMBER(10)                         NULL,
  PPF_PRU        NUMBER                             NULL
)
;


CREATE TABLE TRHU_PRT
(
  PRT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PRT_COD      NUMBER(10)                           NULL,
  PRT_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PRT_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  PRT_CNM_COD  VARCHAR2(4 BYTE)                     NULL,
  PRT_DATINI   DATE                                 NULL,
  PRT_IMP      NUMBER(15,2)                         NULL,
  PRT_ACT      VARCHAR2(1 BYTE)                     NULL,
  PRT_IMPMEN   NUMBER(15,2)                         NULL,
  PRT_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PRT_DATCRE   DATE                                 NULL,
  PRT_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PRT_DATMOD   DATE                                 NULL,
  PRT_CLS      INTEGER                              NULL,
  PRT_DATFI    DATE                                 NULL,
  PRT_OBS      VARCHAR2(1000 BYTE)                  NULL,
  PRT_MOVCXA   VARCHAR2(10 BYTE)                    NULL
)
;


CREATE TABLE TRHU_RVM
(
  RVM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  RVM_COD      NUMBER(10)                           NULL,
  RVM_DAT      DATE                                 NULL,
  RVM_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  RVM_DATCRE   DATE                                 NULL,
  RVM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  RVM_DATMOD   DATE                                 NULL,
  RVM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  RVM_OBS      VARCHAR2(1000 BYTE)                  NULL,
  RVM_TRM_COD  VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TRHU_SBA
(
  SBA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  SBA_TBA_COD  VARCHAR2(4 BYTE)                     NULL,
  SBA_COD      VARCHAR2(6 BYTE)                     NULL,
  SBA_NOM      VARCHAR2(30 BYTE)                    NULL,
  SBA_OBS      VARCHAR2(1000 BYTE)                  NULL,
  SBA_DATCRE   DATE                                 NULL,
  SBA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  SBA_DATMOD   DATE                                 NULL,
  SBA_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_SCT
(
  SCT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  SCT_CAT_COD  VARCHAR2(4 BYTE)                     NULL,
  SCT_COD      VARCHAR2(4 BYTE)                     NULL,
  SCT_NOM      VARCHAR2(30 BYTE)                    NULL,
  SCT_OBS      VARCHAR2(1000 BYTE)                  NULL,
  SCT_DATCRE   DATE                                 NULL,
  SCT_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  SCT_DATMOD   DATE                                 NULL,
  SCT_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  SCT_ART_COD  VARCHAR2(15 BYTE)                    NULL,
  SCT_ACT      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_SEC
(
  SEC_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  SEC_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  SEC_COD      VARCHAR2(4 BYTE)                     NULL,
  SEC_NOM      VARCHAR2(30 BYTE)                    NULL,
  SEC_DATCRE   DATE                                 NULL,
  SEC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  SEC_CTLFFO   VARCHAR2(1 BYTE)                     NULL,
  SEC_CTLHOE   VARCHAR2(1 BYTE)                     NULL,
  SEC_FCT      NUMBER(5,2)                          NULL,
  SEC_DATMOD   DATE                                 NULL,
  SEC_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  SEC_OBS      VARCHAR2(1000 BYTE)                  NULL,
  SEC_ROLVIS   VARCHAR2(15 BYTE)                    NULL,
  SEC_CTE      VARCHAR2(10 BYTE)                    NULL,
  SEC_GSE_COD  VARCHAR2(4 BYTE)                     NULL,
  SEC_DISCOS   VARCHAR2(2 BYTE)                     NULL,
  SEC_ANECMP   VARCHAR2(4 BYTE)                     NULL,
  SEC_DEPCMP   VARCHAR2(4 BYTE)                     NULL,
  SEC_DTEHOR   NUMBER(5,3)                          NULL,
  SEC_DRICMP   VARCHAR2(2 BYTE)                     NULL
)
;


CREATE TABLE TRHU_STR
(
  STR_IDF_COD      VARCHAR2(4 BYTE)                 NULL,
  STR_TOR_COD      VARCHAR2(6 BYTE)                 NULL,
  STR_NUM          NUMBER(10)                       NULL,
  STR_ORD          NUMBER(3)                        NULL,
  STR_USUCRE       VARCHAR2(30 BYTE)                NULL,
  STR_DATCRE       DATE                             NULL,
  STR_REG_COD1     VARCHAR2(4 BYTE)                 NULL,
  STR_REG_COD2     VARCHAR2(4 BYTE)                 NULL,
  STR_REG_COD3     VARCHAR2(4 BYTE)                 NULL,
  STR_REG_COD4     VARCHAR2(4 BYTE)                 NULL,
  STR_REG_COD5     VARCHAR2(4 BYTE)                 NULL,
  STR_REG_COD6     VARCHAR2(4 BYTE)                 NULL,
  STR_REG_COD7     VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD1     VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD2     VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD3     VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD4     VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD5     VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD6     VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD7     VARCHAR2(4 BYTE)                 NULL,
  STR_ZON_COD1     VARCHAR2(4 BYTE)                 NULL,
  STR_ZON_COD2     VARCHAR2(4 BYTE)                 NULL,
  STR_ZON_COD3     VARCHAR2(4 BYTE)                 NULL,
  STR_ZON_COD4     VARCHAR2(4 BYTE)                 NULL,
  STR_ZON_COD5     VARCHAR2(4 BYTE)                 NULL,
  STR_ZON_COD6     VARCHAR2(4 BYTE)                 NULL,
  STR_ZON_COD7     VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD0021  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD0022  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD0023  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD0024  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD0025  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD0026  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_COD0027  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_CODNIT1  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_CODNIT2  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_CODNIT3  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_CODNIT4  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_CODNIT5  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_CODNIT6  VARCHAR2(4 BYTE)                 NULL,
  STR_HOR_CODNIT7  VARCHAR2(4 BYTE)                 NULL,
  STR_USUMOD       VARCHAR2(30 BYTE)                NULL,
  STR_DATMOD       DATE                             NULL
)
;


CREATE TABLE TRHU_TLL
(
  TLL_MAO_COD  VARCHAR2(15 BYTE)                    NULL,
  TLL_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TLL_COD      VARCHAR2(6 BYTE)                     NULL,
  TLL_DES      VARCHAR2(30 BYTE)                    NULL,
  TLL_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TLL_DATCRE   DATE                                 NULL,
  TLL_ART_COD  VARCHAR2(15 BYTE)                    NULL,
  TLL_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TLL_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_TRA
(
  TRA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  TRA_COD      NUMBER(10)                           NULL,
  TRA_DATHOR   DATE                                 NULL,
  TRA_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  TRA_TTR_COD  NUMBER(10)                           NULL,
  TRA_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  TRA_OBS      VARCHAR2(1000 BYTE)                  NULL,
  TRA_PRE_COD  NUMBER(10)                           NULL,
  TRA_LPR_NUM  NUMBER(10)                           NULL,
  TRA_DATCRE   DATE                                 NULL,
  TRA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TRA_NOD_NUM  NUMBER(10)                           NULL,
  TRA_DATMOD   DATE                                 NULL,
  TRA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  TRA_LAT      NUMBER(15,7)                         NULL,
  TRA_LNG      NUMBER(15,7)                         NULL
)
;


CREATE INDEX IRHU_ANL_IDF_FK ON TRHU_ANL
(ANL_IDF_COD)
;


CREATE INDEX IRHU_CAT_ART_FK ON TRHU_CAT
(CAT_ART_COD, CAT_IDF_COD)
;


CREATE INDEX IRHU_CAT_COV_FK ON TRHU_CAT
(CAT_IDF_COD, CAT_COV_COD)
;


CREATE INDEX IRHU_CAT_IDF_FK ON TRHU_CAT
(CAT_IDF_COD)
;


CREATE INDEX IRHU_CLN_IDF_FK ON TRHU_CLN
(CLN_IDF_COD)
;


CREATE INDEX IRHU_CLN_TDI_FK ON TRHU_CLN
(CLN_TDI_COD, CLN_IDF_COD)
;


CREATE INDEX IRHU_CNM_IDF_FK_I ON TRHU_CNM
(CNM_IDF_COD)
;


CREATE INDEX IRHU_CNM_TCN_FK_I ON TRHU_CNM
(CNM_TCN_COD, CNM_IDF_COD)
;


CREATE INDEX IRHU_CNT_IDF_FK ON TRHU_CNT
(CNT_IDF_COD)
;


CREATE INDEX IRHU_COF_CNM_FK ON TRHU_COF
(COF_CNM_COD, COF_IDF_COD)
;


CREATE INDEX IRHU_COF_COF_FK ON TRHU_COF
(COF_IDF_COD, COF_COF_COD)
;


CREATE INDEX IRHU_COF_FK ON TRHU_PPF
(PPF_IDF_COD, PPF_COF_COD)
;


CREATE INDEX IRHU_COF_IDF_FK ON TRHU_COF
(COF_IDF_COD)
;


CREATE INDEX IRHU_EMP_IDF_FK ON TRHU_EMP
(EMP_IDF_COD)
;


CREATE INDEX IRHU_FPE_IDF_FK ON TRHU_FPE
(FPE_IDF_COD)
;


CREATE INDEX IRHU_FPE_TDI_FK ON TRHU_FPE
(FPE_TDI_COD, FPE_IDF_COD)
;


CREATE INDEX IRHU_GRE_IDF_FK_I ON TRHU_GRE
(GRE_IDF_COD)
;


CREATE INDEX IRHU_HOD_IDF_FK ON TRHU_HOD
(HOD_IDF_COD)
;


CREATE INDEX IRHU_HOR_IDF_FK ON TRHU_HOR
(HOR_IDF_COD)
;


CREATE INDEX IRHU_IHO_HOR_FK ON TRHU_IHO
(IHO_HOR_COD, IHO_IDF_COD)
;


CREATE INDEX IRHU_LES_PPF_FK ON TRHU_PPF
(PPF_IDF_COD, PPF_EMP_COD, PPF_PRJ_NUM, PPF_ETP_NUM, PPF_ETP_COD, 
PPF_LES_SEQ)
;


CREATE INDEX IRHU_LFE_REG_FK ON TRHU_LFE
(LFE_IDF_COD, LFE_REG_COD)
;


CREATE INDEX IRHU_MAO_ART_FK ON TRHU_MAO
(MAO_IDF_COD, MAO_ART_COD)
;


CREATE INDEX IRHU_MAO_IDF_FK ON TRHU_MAO
(MAO_IDF_COD)
;


CREATE INDEX IRHU_MAO_TMO_FK ON TRHU_MAO
(MAO_IDF_COD, MAO_TMO_COD)
;


CREATE INDEX IRHU_NOD_IDF_FK ON TRHU_NOD
(NOD_IDF_COD)
;


CREATE INDEX IRHU_NOD_SNO_FK ON TRHU_NOD
(NOD_SNO_COD, NOD_IDF_COD)
;


CREATE INDEX IRHU_NOD_ZONDTI_FK ON TRHU_NOD
(NOD_ZON_CODDTI, NOD_IDF_COD)
;


CREATE INDEX IRHU_NOD_ZONORI_FK ON TRHU_NOD
(NOD_ZON_CODORI, NOD_IDF_COD)
;


CREATE INDEX IRHU_OPE_FK ON TRHU_PEO
(PEO_IDF_COD, PEO_OPE_COD)
;


CREATE INDEX IRHU_OPE_GFE_FK ON TRHU_OPE
(OPE_IDF_COD, OPE_GFE_COD)
;


CREATE INDEX IRHU_OPE_GRE_FK ON TRHU_OPE
(OPE_GRE_COD, OPE_IDF_COD)
;


CREATE INDEX IRHU_OPE_HOR002_FK ON TRHU_OPE
(OPE_HOR_COD002, OPE_IDF_COD)
;


CREATE INDEX IRHU_OPE_HOR003_FK ON TRHU_OPE
(OPE_IDF_COD, OPE_HOR_COD003)
;


CREATE INDEX IRHU_OPE_HORNIT_FK ON TRHU_OPE
(OPE_HOR_CODNIT, OPE_IDF_COD)
;


CREATE INDEX IRHU_OPE_HOR_FK ON TRHU_OPE
(OPE_IDF_COD, OPE_HOR_COD)
;


CREATE INDEX IRHU_OPE_IDF_FK ON TRHU_OPE
(OPE_IDF_COD)
;


CREATE UNIQUE INDEX IRHU_OPE_OPE002_UK ON TRHU_OPE
(OPE_IDF_COD, OPE_PIN)
;


CREATE INDEX IRHU_OPE_OPE_FK ON TRHU_OPE
(OPE_OPE_COD, OPE_IDF_COD)
;


CREATE INDEX IRHU_OPE_TCS_FK ON TRHU_OPE
(OPE_IDF_COD, OPE_TCS_COD)
;


CREATE INDEX IRHU_OPE_TOR_FK ON TRHU_OPE
(OPE_IDF_COD, OPE_TOR_COD)
;


CREATE INDEX IRHU_OPE_ZON_FK ON TRHU_OPE
(OPE_IDF_COD, OPE_ZON_COD)
;


CREATE INDEX IRHU_PLT_FK ON TRHU_PEO
(PEO_IDF_COD, PEO_PLT_COD)
;


CREATE INDEX IRHU_PNO_ANL_FK ON TRHU_PNO
(PNO_ANL_COD, PNO_IDF_COD)
;


CREATE INDEX IRHU_PNO_EMP_FK_I ON TRHU_PNO
(PNO_EMP_COD, PNO_IDF_COD)
;


CREATE INDEX IRHU_POR_IDF_FK ON TRHU_POR
(POR_IDF_COD)
;


CREATE INDEX IRHU_POR_OPE_FK ON TRHU_POR
(POR_IDF_COD, POR_OPE_COD)
;


CREATE INDEX IRHU_POR_REG_FK ON TRHU_POR
(POR_IDF_COD, POR_REG_COD)
;


CREATE INDEX IRHU_PPF_UCE_FK ON TRHU_PPF
(PPF_IDF_COD, PPF_EMP_COD, PPF_PRJ_NUM, PPF_ETP_NUM, PPF_ETP_COD, 
PPF_UCE_SEQ)
;


CREATE INDEX IRHU_PRT_CNM_FK_I ON TRHU_PRT
(PRT_IDF_COD, PRT_CNM_COD)
;


CREATE INDEX IRHU_PRT_EMP_FK_I ON TRHU_PRT
(PRT_IDF_COD, PRT_EMP_COD)
;


CREATE INDEX IRHU_PRT_IDF_FK_I ON TRHU_PRT
(PRT_IDF_COD)
;


CREATE INDEX IRHU_PRT_OPE_FK_I ON TRHU_PRT
(PRT_IDF_COD, PRT_OPE_COD)
;


CREATE INDEX IRHU_RVM_IDF_FK ON TRHU_RVM
(RVM_IDF_COD)
;


CREATE INDEX IRHU_RVM_OPE_FK ON TRHU_RVM
(RVM_OPE_COD, RVM_IDF_COD)
;


CREATE INDEX IRHU_SBA_TBA_FK ON TRHU_SBA
(SBA_TBA_COD, SBA_IDF_COD)
;


CREATE INDEX IRHU_SCT_CAT_FK ON TRHU_SCT
(SCT_CAT_COD, SCT_IDF_COD)
;


CREATE INDEX IRHU_SEC_EMP_FK ON TRHU_SEC
(SEC_EMP_COD, SEC_IDF_COD)
;


CREATE INDEX IRHU_STR_HOR0021_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD0021)
;


CREATE INDEX IRHU_STR_HOR0022_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD0022)
;


CREATE INDEX IRHU_STR_HOR0023_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD0023)
;


CREATE INDEX IRHU_STR_HOR0024_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD0024)
;


CREATE INDEX IRHU_STR_HOR0025_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD0025)
;


CREATE INDEX IRHU_STR_HOR0026_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD0026)
;


CREATE INDEX IRHU_STR_HOR0027_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD0027)
;


CREATE INDEX IRHU_STR_HOR2_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD2)
;


CREATE INDEX IRHU_STR_HOR3_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD3)
;


CREATE INDEX IRHU_STR_HOR4_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD4)
;


CREATE INDEX IRHU_STR_HOR5_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD5)
;


CREATE INDEX IRHU_STR_HOR6_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD6)
;


CREATE INDEX IRHU_STR_HOR7_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD7)
;


CREATE INDEX IRHU_STR_HORNIT1_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_CODNIT1)
;


CREATE INDEX IRHU_STR_HORNIT2_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_CODNIT2)
;


CREATE INDEX IRHU_STR_HORNIT3_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_CODNIT3)
;


CREATE INDEX IRHU_STR_HORNIT4_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_CODNIT4)
;


CREATE INDEX IRHU_STR_HORNIT5_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_CODNIT5)
;


CREATE INDEX IRHU_STR_HORNIT6_FK ON TRHU_STR
(STR_HOR_CODNIT6)
;


CREATE INDEX IRHU_STR_HORNIT7_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_CODNIT7)
;


CREATE INDEX IRHU_STR_HOR_FK ON TRHU_STR
(STR_IDF_COD, STR_HOR_COD1)
;


CREATE INDEX IRHU_STR_REG1_FK ON TRHU_STR
(STR_IDF_COD, STR_REG_COD1)
;


CREATE INDEX IRHU_STR_REG2_FK ON TRHU_STR
(STR_IDF_COD, STR_REG_COD2)
;


CREATE INDEX IRHU_STR_REG3_FK ON TRHU_STR
(STR_IDF_COD, STR_REG_COD3)
;


CREATE INDEX IRHU_STR_REG4_FK ON TRHU_STR
(STR_IDF_COD, STR_REG_COD4)
;


CREATE INDEX IRHU_STR_REG5_FK ON TRHU_STR
(STR_IDF_COD, STR_REG_COD5)
;


CREATE INDEX IRHU_STR_REG6_FK ON TRHU_STR
(STR_IDF_COD, STR_REG_COD6)
;


CREATE INDEX IRHU_STR_REG7_FK ON TRHU_STR
(STR_IDF_COD, STR_REG_COD7)
;


CREATE INDEX IRHU_STR_TOR_FK ON TRHU_STR
(STR_IDF_COD, STR_TOR_COD)
;


CREATE INDEX IRHU_STR_ZON1_FK ON TRHU_STR
(STR_IDF_COD, STR_ZON_COD1)
;


CREATE INDEX IRHU_STR_ZON2_FK ON TRHU_STR
(STR_IDF_COD, STR_ZON_COD2)
;


CREATE INDEX IRHU_STR_ZON3_FK ON TRHU_STR
(STR_IDF_COD, STR_ZON_COD3)
;


CREATE INDEX IRHU_STR_ZON4_FK ON TRHU_STR
(STR_IDF_COD, STR_ZON_COD4)
;


CREATE INDEX IRHU_STR_ZON5_FK ON TRHU_STR
(STR_IDF_COD, STR_ZON_COD5)
;


CREATE INDEX IRHU_STR_ZON6_FK ON TRHU_STR
(STR_IDF_COD, STR_ZON_COD6)
;


CREATE INDEX IRHU_STR_ZON7_FK ON TRHU_STR
(STR_IDF_COD, STR_ZON_COD7)
;


CREATE INDEX IRHU_TLL_ART_FK ON TRHU_TLL
(TLL_IDF_COD, TLL_ART_COD)
;


CREATE INDEX IRHU_TLL_MAO_FK ON TRHU_TLL
(TLL_IDF_COD, TLL_MAO_COD)
;


CREATE INDEX IRHU_TRA_IDF_FK ON TRHU_TRA
(TRA_IDF_COD)
;


CREATE INDEX IRHU_TRA_NOD_FK ON TRHU_TRA
(TRA_NOD_NUM, TRA_IDF_COD)
;


CREATE INDEX IRHU_TRA_OPE_FK ON TRHU_TRA
(TRA_OPE_COD, TRA_IDF_COD)
;


CREATE INDEX IRHU_TRA_TTR_FK ON TRHU_TRA
(TRA_TTR_COD, TRA_IDF_COD)
;


CREATE UNIQUE INDEX PPF_PK ON TRHU_PPF
(PPF_IDF_COD, PPF_SEQ)
;


CREATE UNIQUE INDEX RRHU_ANL_PK ON TRHU_ANL
(ANL_IDF_COD, ANL_COD)
;


CREATE UNIQUE INDEX RRHU_CAT_PK ON TRHU_CAT
(CAT_COD, CAT_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_CIN_PK ON TRHU_CIN
(CIN_IDF_COD, CIN_NUM)
;


CREATE UNIQUE INDEX RRHU_CIN_UK ON TRHU_CIN
(CIN_IDF_COD, CIN_ANY, CIN_MES, CIN_TCI_COD)
;


CREATE UNIQUE INDEX RRHU_CLN_PK ON TRHU_CLN
(CLN_DAT, CLN_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_CNM_PK ON TRHU_CNM
(CNM_COD, CNM_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_CNT_PK ON TRHU_CNT
(CNT_COD, CNT_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_COF_PK ON TRHU_COF
(COF_COD, COF_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_CUR_PK ON TRHU_CUR
(CUR_IDF_COD, CUR_TIC_COD, CUR_COD)
;


CREATE UNIQUE INDEX RRHU_EMA_PK ON TRHU_EMA
(EMA_IDF_COD, EMA_COD)
;


CREATE UNIQUE INDEX RRHU_EMP_PK ON TRHU_EMP
(EMP_COD, EMP_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_FEX_PK ON TRHU_FEX
(FEX_IDF_COD, FEX_TFE_COD, FEX_COD)
;


CREATE UNIQUE INDEX RRHU_FPE_PK ON TRHU_FPE
(FPE_COD, FPE_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_GFE_PK ON TRHU_GFE
(GFE_IDF_COD, GFE_COD)
;


CREATE UNIQUE INDEX RRHU_GRE_PK ON TRHU_GRE
(GRE_COD, GRE_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_GSE_PK ON TRHU_GSE
(GSE_IDF_COD, GSE_EMP_COD, GSE_COD)
;


CREATE UNIQUE INDEX RRHU_HOD_PK ON TRHU_HOD
(HOD_COD, HOD_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_HOR_PK ON TRHU_HOR
(HOR_COD, HOR_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_IHO_PK ON TRHU_IHO
(IHO_LIN, IHO_HOR_COD, IHO_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_LFE_PK ON TRHU_LFE
(LFE_IDF_COD, LFE_GFE_COD, LFE_COD)
;


CREATE UNIQUE INDEX RRHU_MAO_PK ON TRHU_MAO
(MAO_IDF_COD, MAO_COD)
;


CREATE UNIQUE INDEX RRHU_NOD_PK ON TRHU_NOD
(NOD_NUM, NOD_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_OPE_PK ON TRHU_OPE
(OPE_COD, OPE_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_OPM_PK ON TRHU_OPM
(OPM_IDF_COD, OPM_OPE_COD)
;


CREATE UNIQUE INDEX RRHU_PEO_PK ON TRHU_PEO
(PEO_IDF_COD, PEO_OPE_COD, PEO_PLT_COD)
;


CREATE UNIQUE INDEX RRHU_PNO_PK ON TRHU_PNO
(PNO_COD, PNO_EMP_COD, PNO_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_POR_PK ON TRHU_POR
(POR_IDF_COD, POR_REG_COD, POR_OPE_COD)
;


CREATE UNIQUE INDEX RRHU_PRT_PK ON TRHU_PRT
(PRT_IDF_COD, PRT_COD)
;


CREATE UNIQUE INDEX RRHU_RVM_PK ON TRHU_RVM
(RVM_IDF_COD, RVM_COD)
;


CREATE UNIQUE INDEX RRHU_SBA_PK ON TRHU_SBA
(SBA_COD, SBA_TBA_COD, SBA_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_SCT_PK ON TRHU_SCT
(SCT_COD, SCT_CAT_COD, SCT_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_SEC_PK ON TRHU_SEC
(SEC_COD, SEC_EMP_COD, SEC_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_STR_PK ON TRHU_STR
(STR_IDF_COD, STR_TOR_COD, STR_NUM)
;


CREATE UNIQUE INDEX RRHU_STR_UK ON TRHU_STR
(STR_IDF_COD, STR_TOR_COD, STR_ORD)
;


CREATE UNIQUE INDEX RRHU_TLL_PK ON TRHU_TLL
(TLL_IDF_COD, TLL_MAO_COD, TLL_COD)
;


CREATE UNIQUE INDEX RRHU_TRA_PK ON TRHU_TRA
(TRA_COD, TRA_IDF_COD)
;


CREATE UNIQUE INDEX SRHU_RVM ON TRHU_RVM
(RVM_COD)
;


CREATE OR REPLACE FORCE VIEW VRHU_OPEPDA
AS 
select ope_cod email, ope_pas password
from trhu_ope
where ope_pas is not null
/*and ope_eml is not null*/;


CREATE TABLE TRHU_AMN
(
  AMN_SEQ      NUMBER(10)                           NULL,
  AMN_DAT      DATE                                 NULL,
  AMN_TIP      VARCHAR2(1 BYTE)                     NULL,
  AMN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  AMN_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  AMN_DATCRE   DATE                                 NULL,
  AMN_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  AMN_DATMOD   DATE                                 NULL,
  AMN_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  AMN_OBS      VARCHAR2(1000 BYTE)                  NULL,
  AMN_TAM_COD  VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TRHU_ANC
(
  ANC_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  ANC_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  ANC_NUM        NUMBER(10)                         NULL,
  ANC_OPE_COD    VARCHAR2(6 BYTE)                   NULL,
  ANC_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  ANC_DIA        DATE                               NULL,
  ANC_IMP        NUMBER(15,2)                       NULL,
  ANC_EST        NUMBER(1)                          NULL,
  ANC_CLS        NUMBER(1)                          NULL,
  ANC_VALDIVEUR  NUMBER(15,8)                       NULL,
  ANC_DES        VARCHAR2(1000 BYTE)                NULL,
  ANC_DATCRE     DATE                               NULL,
  ANC_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  ANC_DATMOD     DATE                               NULL,
  ANC_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  ANC_TIP        VARCHAR2(1 BYTE)                   NULL,
  ANC_PNO_COD    VARCHAR2(6 BYTE)                   NULL,
  ANC_MOVCXA     VARCHAR2(10 BYTE)                  NULL
)
;


CREATE TABLE TRHU_BAI
(
  BAI_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  BAI_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  BAI_TBA_COD  VARCHAR2(4 BYTE)                     NULL,
  BAI_SBA_COD  VARCHAR2(6 BYTE)                     NULL,
  BAI_DATINI   DATE                                 NULL,
  BAI_DATFIN   DATE                                 NULL,
  BAI_DATCRE   DATE                                 NULL,
  BAI_OBS      VARCHAR2(1000 BYTE)                  NULL,
  BAI_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  BAI_DATMOD   DATE                                 NULL,
  BAI_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_CAC
(
  CAC_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CAC_COF_COD  VARCHAR2(4 BYTE)                     NULL,
  CAC_CAT_COD  VARCHAR2(4 BYTE)                     NULL,
  CAC_ART_COD  VARCHAR2(15 BYTE)                    NULL,
  CAC_DES      VARCHAR2(1000 BYTE)                  NULL,
  CAC_SCT_COD  VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TRHU_CCS
(
  CCS_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CCS_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CCS_CTECMP   VARCHAR2(10 BYTE)                    NULL,
  CCS_SEC_COD  VARCHAR2(4 BYTE)                     NULL,
  CCS_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CCS_DATCRE   DATE                                 NULL,
  CCS_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CCS_DATMOD   DATE                                 NULL,
  CCS_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRHU_CNH
(
  CNH_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  CNH_OPE_COD    VARCHAR2(6 BYTE)                   NULL,
  CNH_CNM_COD    VARCHAR2(4 BYTE)                   NULL,
  CNH_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  CNH_DATCRE     DATE                               NULL,
  CNH_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  CNH_IMP        NUMBER(15,2)                       NULL,
  CNH_IMP002     NUMBER(15,2)                       NULL,
  CNH_DATMOD     DATE                               NULL,
  CNH_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  CNH_VALDIVEUR  NUMBER(15,8)                       NULL,
  CNH_DES        VARCHAR2(250 BYTE)                 NULL,
  CNH_CALPRP     VARCHAR2(1 BYTE)                   NULL,
  CNH_DTEBAI     VARCHAR2(1 BYTE)                   NULL
)
;


CREATE TABLE TRHU_CNO
(
  CNO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CNO_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  CNO_TCA_COD  VARCHAR2(4 BYTE)                     NULL,
  CNO_DIAEXD   DATE                                 NULL,
  CNO_DATCRE   DATE                                 NULL,
  CNO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CNO_DIACDC   DATE                                 NULL,
  CNO_DATMOD   DATE                                 NULL,
  CNO_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CNO_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRHU_COC
(
  COC_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  COC_CNM_COD  VARCHAR2(4 BYTE)                     NULL,
  COC_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  COC_DATCRE   DATE                                 NULL,
  COC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  COC_NUMCAS   NUMBER(3)                            NULL,
  COC_DATMOD   DATE                                 NULL,
  COC_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_COT
(
  COT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  COT_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  COT_COF_COD  VARCHAR2(4 BYTE)                     NULL,
  COT_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  COT_DATCRE   DATE                                 NULL,
  COT_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  COT_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_CRI
(
  CRI_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CRI_SEQ      NUMBER(10)                           NULL,
  CRI_ORD      VARCHAR2(1 BYTE)                     NULL,
  CRI_DIA      DATE                                 NULL,
  CRI_HOR      DATE                                 NULL,
  CRI_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  CRI_EMA_COD  VARCHAR2(4 BYTE)                     NULL,
  CRI_DATCRE   DATE                                 NULL,
  CRI_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CRI_DES      VARCHAR2(1000 BYTE)                  NULL,
  CRI_DATMOD   DATE                                 NULL,
  CRI_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CRI_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRHU_CTLFFO
(
  CFF_SEQ      NUMBER(10)                           NULL,
  CFF_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CFF_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  CFF_CLI_COD  VARCHAR2(6 BYTE)                     NULL,
  CFF_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CFF_PRJ_NUM  VARCHAR2(6 BYTE)                     NULL,
  CFF_PRE_COD  NUMBER                               NULL,
  CFF_DATINI   DATE                                 NULL,
  CFF_DATFIN   DATE                                 NULL,
  CFF_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CFF_DATCRE   DATE                                 NULL,
  CFF_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CFF_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_CTR
(
  CTR_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  CTR_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  CTR_TCT_COD     VARCHAR2(4 BYTE)                  NULL,
  CTR_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  CTR_DATINI      DATE                              NULL,
  CTR_DATFIN      DATE                              NULL,
  CTR_OBS         VARCHAR2(1000 BYTE)               NULL,
  CTR_DATCRE      DATE                              NULL,
  CTR_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  CTR_DATMOD      DATE                              NULL,
  CTR_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  CTR_HORVAC      NUMBER(4)                         NULL,
  CTR_DATBAI      DATE                              NULL,
  CTR_OBSBAI      VARCHAR2(1000 BYTE)               NULL,
  CTR_DATSOLBAI   DATE                              NULL,
  CTR_SOLBAI      VARCHAR2(1 BYTE)                  NULL,
  CTR_CRLFFO      VARCHAR2(1 BYTE)              DEFAULT 'N'                       NULL,
  CTR_COV_COD     VARCHAR2(4 BYTE)                  NULL,
  CTR_PRJ_NUM     VARCHAR2(6 BYTE)                  NULL,
  CTR_PRJ_NUMNMN  VARCHAR2(6 BYTE)                  NULL
)
;


CREATE TABLE TRHU_CVA
(
  CVA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  CVA_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  CVA_ANL_COD  VARCHAR2(6 BYTE)                     NULL,
  CVA_COV_COD  VARCHAR2(4 BYTE)                     NULL,
  CVA_DATCRE   DATE                                 NULL,
  CVA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CVA_DATMOD   DATE                                 NULL,
  CVA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  CVA_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRHU_DED
(
  DED_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  DED_COD      NUMBER(10)                           NULL,
  DED_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DED_DIA1     DATE                                 NULL,
  DED_DIA2     DATE                                 NULL,
  DED_HOR      NUMBER(4,2)                          NULL,
  DED_DES      VARCHAR2(60 BYTE)                    NULL,
  DED_PRJ_NUM  VARCHAR2(6 BYTE)                     NULL,
  DED_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  DED_DATCRE   DATE                                 NULL,
  DED_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DED_DATMOD   DATE                                 NULL,
  DED_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_DET
(
  DET_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  DET_COD      NUMBER(10)                           NULL,
  DET_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DET_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  DET_PRJ_NUM  VARCHAR2(6 BYTE)                     NULL,
  DET_DIA      DATE                                 NULL,
  DET_HOR      NUMBER(4,2)                          NULL,
  DET_DATCRE   DATE                                 NULL,
  DET_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DET_NUMDOC   VARCHAR2(20 BYTE)                    NULL,
  DET_DATMOD   DATE                                 NULL,
  DET_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_DFE
(
  DFE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  DFE_TFE_COD  VARCHAR2(4 BYTE)                     NULL,
  DFE_FEX_COD  VARCHAR2(6 BYTE)                     NULL,
  DFE_COD      VARCHAR2(6 BYTE)                     NULL,
  DFE_DES      VARCHAR2(1000 BYTE)                  NULL,
  DFE_DATCRE   DATE                                 NULL,
  DFE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DFE_DATINI   DATE                                 NULL,
  DFE_DATFIN   DATE                                 NULL,
  DFE_OBS      VARCHAR2(1000 BYTE)                  NULL,
  DFE_DATMOD   DATE                                 NULL,
  DFE_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_DLD
(
  DLD_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  DLD_REF      NUMBER(10)                           NULL,
  DLD_DIA      DATE                                 NULL,
  DLD_COV_COD  VARCHAR2(4 BYTE)                     NULL,
  DLD_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DLD_OBS      VARCHAR2(1000 BYTE)                  NULL,
  DLD_GFE_COD  VARCHAR2(4 BYTE)                     NULL
)
;


CREATE TABLE TRHU_DSP
(
  DSP_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  DSP_COD      VARCHAR2(6 BYTE)                     NULL,
  DSP_NOM      VARCHAR2(60 BYTE)                    NULL,
  DSP_IMEI     VARCHAR2(32 BYTE)                    NULL,
  DSP_TEL      VARCHAR2(16 BYTE)                    NULL,
  DSP_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  DSP_TDS_COD  VARCHAR2(4 BYTE)                     NULL,
  DSP_DATCRE   DATE                                 NULL,
  DSP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DSP_DATMOD   DATE                                 NULL,
  DSP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DSP_GCM      VARCHAR2(155 BYTE)                   NULL,
  DSP_OCU      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TRHU_ERE
(
  ERE_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  ERE_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  ERE_SEQ         NUMBER(10)                        NULL,
  ERE_DIAINI      DATE                              NULL,
  ERE_DIAFIN      DATE                              NULL,
  ERE_REG_COD     VARCHAR2(4 BYTE)                  NULL,
  ERE_HOR_COD     VARCHAR2(4 BYTE)                  NULL,
  ERE_HOR_COD002  VARCHAR2(4 BYTE)                  NULL,
  ERE_HOR_CODNIT  VARCHAR2(4 BYTE)                  NULL,
  ERE_PTE         NUMBER(5,2)                       NULL,
  ERE_OBS         VARCHAR2(1000 BYTE)               NULL,
  ERE_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  ERE_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  ERE_DATCRE      DATE                              NULL,
  ERE_DATMOD      DATE                              NULL,
  ERE_PTETEO      NUMBER(5,2)                       NULL,
  ERE_REF         VARCHAR2(30 BYTE)                 NULL
)
;


CREATE TABLE TRHU_EXL
(
  EXL_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  EXL_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  EXL_SEC      NUMBER(10)                           NULL,
  EXL_EMP      VARCHAR2(60 BYTE)                    NULL,
  EXL_CRG      VARCHAR2(60 BYTE)                    NULL,
  EXL_DIAINI   DATE                                 NULL,
  EXL_DIAFIN   DATE                                 NULL,
  EXL_OBS      VARCHAR2(1000 BYTE)                  NULL
)
;


CREATE TABLE TRHU_FCP
(
  FCP_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FCP_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  FCP_COF_COD  VARCHAR2(4 BYTE)                     NULL,
  FCP_DATCRE   DATE                                 NULL,
  FCP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FCP_FCT      NUMBER(4,2)                          NULL,
  FCP_DATMOD   DATE                                 NULL,
  FCP_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_FEXOPE
(
  FEXOPE_IDF_COD    VARCHAR2(4 BYTE)                NULL,
  FEXOPE_TFE_COD    VARCHAR2(4 BYTE)                NULL,
  FEXOPE_FEX_COD    VARCHAR2(6 BYTE)                NULL,
  FEXOPE_OPE_COD    VARCHAR2(6 BYTE)                NULL,
  FEXOPE_DATCRE     DATE                            NULL,
  FEXOPE_USUCRE     VARCHAR2(30 BYTE)               NULL,
  FEXOPE_DATREBINI  DATE                            NULL,
  FEXOPE_DATREBFIN  DATE                            NULL,
  FEXOPE_DATVDS     DATE                            NULL,
  FEXOPE_DATMOD     DATE                            NULL,
  FEXOPE_USUMOD     VARCHAR2(30 BYTE)               NULL,
  FEXOPE_OBS        VARCHAR2(1000 BYTE)             NULL,
  FEXOPE_DFE_COD    VARCHAR2(6 BYTE)                NULL,
  FEXOPE_SEQ        NUMBER(10)                      NULL
)
;


CREATE TABLE TRHU_FOR
(
  FOR_CUR_COD  VARCHAR2(6 BYTE)                     NULL,
  FOR_TIC_COD  VARCHAR2(4 BYTE)                     NULL,
  FOR_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FOR_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  FOR_DATVDS   DATE                                 NULL,
  FOR_DATCRE   DATE                                 NULL,
  FOR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FOR_DATMOD   DATE                                 NULL,
  FOR_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  FOR_DATFET   DATE                                 NULL,
  FOR_EFI      VARCHAR2(1 BYTE)                     NULL,
  FOR_DES      VARCHAR2(60 BYTE)                    NULL,
  FOR_OBS      VARCHAR2(1000 BYTE)                  NULL,
  FOR_LLCEXP   VARCHAR2(300 BYTE)                   NULL
)
;


CREATE TABLE TRHU_FOT
(
  FOT_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  FOT_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  FOT_FOTO     LONG RAW                             NULL
)
;


CREATE TABLE TRHU_HAN
(
  HAN_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  HAN_ANL_COD  VARCHAR2(6 BYTE)                     NULL,
  HAN_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  HAN_TIP      NUMBER(1)                            NULL,
  HAN_HDIANU   NUMBER(6,2)                          NULL,
  HAN_HDIANT   NUMBER(6,2)                          NULL,
  HAN_USUCRE   VARCHAR2(60 BYTE)                    NULL,
  HAN_DATCRE   DATE                                 NULL,
  HAN_USUMOD   VARCHAR2(60 BYTE)                    NULL,
  HAN_DATMOD   DATE                                 NULL,
  HAN_HLDANT   NUMBER(18,2)                         NULL,
  HAN_HOEANT   NUMBER(6,2)                          NULL
)
;


CREATE TABLE TRHU_HDC
(
  HDC_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  HDC_COD      NUMBER(10)                           NULL,
  HDC_COV_COD  VARCHAR2(4 BYTE)                     NULL,
  HDC_HOD_COD  VARCHAR2(4 BYTE)                     NULL,
  HDC_ANL_COD  VARCHAR2(6 BYTE)                     NULL,
  HDC_HOR      INTEGER                              NULL,
  HDC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  HDC_DATCRE   DATE                                 NULL,
  HDC_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  HDC_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_HDO
(
  HDO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  HDO_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  HDO_DAT      DATE                                 NULL,
  HDO_DATCRE   DATE                                 NULL,
  HDO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  HDO_DISCOS   VARCHAR2(1 BYTE)                     NULL,
  HDO_DATMOD   DATE                                 NULL,
  HDO_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_HLI
(
  HLI_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  HLI_ANL_COD  VARCHAR2(6 BYTE)                     NULL,
  HLI_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  HLI_HORANU   NUMBER(6,2)                          NULL,
  HLI_HORANT   NUMBER(6,2)                          NULL,
  HLI_USUCRE   VARCHAR2(60 BYTE)                    NULL,
  HLI_DATCRE   DATE                                 NULL,
  HLI_USUMOD   VARCHAR2(60 BYTE)                    NULL,
  HLI_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_IDO
(
  IDO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  IDO_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  IDO_IDI_COD  VARCHAR2(4 BYTE)                     NULL,
  IDO_NIVXER   NUMBER(2)                            NULL,
  IDO_NIVESC   NUMBER(2)                            NULL,
  IDO_COMORA   NUMBER(2)                            NULL,
  IDO_OBS      VARCHAR2(1000 BYTE)                  NULL,
  IDO_DATCRE   DATE                                 NULL,
  IDO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  IDO_DATMOD   DATE                                 NULL,
  IDO_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_INA
(
  INA_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  INA_IDF_COD        VARCHAR2(4 BYTE)               NULL,
  INA_SBA_COD        VARCHAR2(6 BYTE)               NULL,
  INA_TBA_COD        VARCHAR2(4 BYTE)               NULL,
  INA_OPE_CODBAI     VARCHAR2(6 BYTE)               NULL,
  INA_BAI_DATINI     DATE                           NULL,
  INA_COD            NUMBER(10)                     NULL,
  INA_DATCRE         DATE                           NULL,
  INA_USUCRE         VARCHAR2(30 BYTE)              NULL,
  INA_TRENOR         VARCHAR2(1 BYTE)               NULL,
  INA_MTUMAT         VARCHAR2(1 BYTE)               NULL,
  INA_LLC            VARCHAR2(1 BYTE)               NULL,
  INA_MTP            VARCHAR2(1 BYTE)               NULL,
  INA_ORG            VARCHAR2(1 BYTE)               NULL,
  INA_ALT            VARCHAR2(1 BYTE)               NULL,
  INA_DAT            DATE                           NULL,
  INA_HOR            DATE                           NULL,
  INA_PER001         VARCHAR2(60 BYTE)              NULL,
  INA_PER002         VARCHAR2(60 BYTE)              NULL,
  INA_PER003         VARCHAR2(60 BYTE)              NULL,
  INA_TERPRT         DATE                           NULL,
  INA_DATIVS         DATE                           NULL,
  INA_DATREV         DATE                           NULL,
  INA_VAD_COD001     NUMBER(10)                     NULL,
  INA_VAD_COD002     NUMBER(10)                     NULL,
  INA_VAD_COD003     NUMBER(10)                     NULL,
  INA_VAD_COD004     NUMBER(10)                     NULL,
  INA_VAD_COD005     NUMBER(10)                     NULL,
  INA_VAD_COD006     NUMBER(10)                     NULL,
  INA_VAD_COD007     NUMBER(10)                     NULL,
  INA_VAD_COD008     NUMBER(10)                     NULL,
  INA_CAT_COD001     VARCHAR2(4 BYTE)               NULL,
  INA_CAT_COD002     VARCHAR2(4 BYTE)               NULL,
  INA_CAT_COD003     VARCHAR2(4 BYTE)               NULL,
  INA_PRJ_NUM        VARCHAR2(6 BYTE)               NULL,
  INA_OPE_CODIVS     VARCHAR2(6 BYTE)               NULL,
  INA_OPE_CODREV     VARCHAR2(6 BYTE)               NULL,
  INA_OPE_CODENC     VARCHAR2(6 BYTE)               NULL,
  INA_OPE_CODOBR     VARCHAR2(6 BYTE)               NULL,
  INA_VAD_COD009001  NUMBER(10)                     NULL,
  INA_VAD_COD009002  NUMBER(10)                     NULL,
  INA_VAD_COD009003  NUMBER(10)                     NULL,
  INA_VAD_COD009004  NUMBER(10)                     NULL,
  INA_DATMOD         DATE                           NULL,
  INA_USUMOD         VARCHAR2(30 BYTE)              NULL,
  INA_DES            VARCHAR2(2000 BYTE)            NULL,
  INA_MSR            VARCHAR2(250 BYTE)             NULL,
  INA_MTUDIR         VARCHAR2(2000 BYTE)            NULL,
  INA_RAZMTU         VARCHAR2(2000 BYTE)            NULL,
  INA_PEV            VARCHAR2(2000 BYTE)            NULL,
  INA_REVRIS         VARCHAR2(1 BYTE)               NULL,
  INA_VAD_COD009005  NUMBER(10)                     NULL,
  INA_VAD_COD010IVS  NUMBER(10)                     NULL,
  INA_VAD_COD010REV  NUMBER(10)                     NULL,
  INA_VAD_COD011     NUMBER(10)                     NULL,
  INA_VAD_COD010OPE  NUMBER(10)                     NULL
)
;


CREATE TABLE TRHU_LIV
(
  LIV_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  LIV_DAT      DATE                                 NULL,
  LIV_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  LIV_HOR      NUMBER                               NULL,
  LIV_PRUHOR   NUMBER(15,2)                         NULL,
  LIV_PAG      VARCHAR2(1 BYTE)                     NULL,
  LIV_CLS      VARCHAR2(1 BYTE)                     NULL,
  LIV_DATCRE   DATE                                 NULL,
  LIV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  LIV_DATMOD   DATE                                 NULL,
  LIV_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  LIV_HORVAC   NUMBER                               NULL,
  LIV_HORLLI   NUMBER                               NULL,
  LIV_DATCOB   DATE                                 NULL
)
;


CREATE TABLE TRHU_LMT
(
  LMT_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  LMT_REF         NUMBER(10)                        NULL,
  LMT_MAO_COD     VARCHAR2(15 BYTE)                 NULL,
  LMT_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  LMT_DAT         DATE                              NULL,
  LMT_UNI         NUMBER(10)                        NULL,
  LMT_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  LMT_DATCRE      DATE                              NULL,
  LMT_TLL_COD     VARCHAR2(6 BYTE)                  NULL,
  LMT_ART_COD     VARCHAR2(15 BYTE)                 NULL,
  LMT_DATRPO      DATE                              NULL,
  LMT_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  LMT_DATMOD      DATE                              NULL,
  LMT_MAG_COD     VARCHAR2(4 BYTE)                  NULL,
  LMT_OBS         VARCHAR2(1000 BYTE)               NULL,
  LMT_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  LMT_ALB_NUMDOC  NUMBER(10)                        NULL,
  LMT_LAC_NUM     NUMBER(10)                        NULL,
  LMT_NUMDOC      VARCHAR2(20 BYTE)                 NULL,
  LMT_IMP         NUMBER(15,2)                      NULL
)
;


CREATE TABLE TRHU_NMN
(
  NMN_IDF_COD             VARCHAR2(4 BYTE)          NULL,
  NMN_EMP_COD             VARCHAR2(4 BYTE)          NULL,
  NMN_OPE_COD             VARCHAR2(6 BYTE)          NULL,
  NMN_PNO_COD             VARCHAR2(6 BYTE)          NULL,
  NMN_DIV_COD             VARCHAR2(4 BYTE)          NULL,
  NMN_FIN                 VARCHAR2(1 BYTE)      DEFAULT 'N'                       NULL,
  NMN_DATCRE              DATE                      NULL,
  NMN_USUCRE              VARCHAR2(30 BYTE)         NULL,
  NMN_NUMDIA              NUMBER(2)                 NULL,
  NMN_DCC                 VARCHAR2(2 BYTE)          NULL,
  NMN_CCR                 NUMBER(10)                NULL,
  NMN_HORTOT              NUMBER(8,2)               NULL,
  NMN_HOREXTTOT           NUMBER(8,2)               NULL,
  NMN_HOREXT              NUMBER(8,2)               NULL,
  NMN_QUAMEN              NUMBER(15,2)              NULL,
  NMN_PRRPAGEXT           NUMBER(15,2)              NULL,
  NMN_BAS                 NUMBER(15,2)              NULL,
  NMN_BASHOREXT           NUMBER(15,2)              NULL,
  NMN_BASIRP              NUMBER(15,2)              NULL,
  NMN_PTEINDNOR           NUMBER(10,4)              NULL,
  NMN_PTEATU              NUMBER(10,4)              NULL,
  NMN_PTEFCOPFS           NUMBER(10,4)              NULL,
  NMN_PTEHOREXT           NUMBER(10,4)              NULL,
  NMN_PTEIRP              NUMBER(10,4)              NULL,
  NMN_DATMOD              DATE                      NULL,
  NMN_USUMOD              VARCHAR2(30 BYTE)         NULL,
  NMN_OBS                 VARCHAR2(1000 BYTE)       NULL,
  NMN_BAN                 NUMBER(4)                 NULL,
  NMN_OFI                 NUMBER(4)                 NULL,
  NMN_VALDIVEUR           NUMBER(15,8)              NULL,
  NMN_DATFNQ              DATE                      NULL,
  NMN_TIPFNQ              NUMBER(2)                 NULL,
  NMN_SS                  NUMBER(15,2)              NULL,
  NMN_EMB                 NUMBER(15,2)              NULL,
  NMN_COSSSEMP            NUMBER(15,2)              NULL,
  NMN_EXCCMP              VARCHAR2(4 BYTE)          NULL,
  NMN_DRICMP              VARCHAR2(2 BYTE)          NULL,
  NMN_ASICMP              NUMBER(10)                NULL,
  NMN_ASICMP002           NUMBER(10)                NULL,
  NMN_DRICMP002           VARCHAR2(2 BYTE)          NULL,
  NMN_BNF                 NUMBER(15,2)              NULL,
  NMN_MOVCXA              VARCHAR2(10 BYTE)         NULL,
  NMN_HORCMS001           NUMBER(5,2)               NULL,
  NMN_HORCMS002           NUMBER(5,2)               NULL,
  NMN_IMPHORCMS001        NUMBER(15,2)              NULL,
  NMN_IMPHORCMS002        NUMBER(15,2)              NULL,
  NMN_ASISGR              NUMBER(10)                NULL,
  NMN_ASIRET              NUMBER(10)                NULL,
  NMN_ASIPAG              NUMBER(10)                NULL,
  NMN_OBSHOR              VARCHAR2(1000 BYTE)       NULL,
  NMN_ANC                 NUMBER(15,2)              NULL,
  NMN_SEGSAN              NUMBER(15,2)              NULL,
  NMN_IBNPAI              VARCHAR2(2 BYTE)          NULL,
  NMN_IBNDCC              VARCHAR2(2 BYTE)          NULL,
  NMN_IBNBIC              VARCHAR2(11 BYTE)         NULL,
  NMN_ALTDSPSOC           NUMBER(15,2)              NULL,
  NMN_PAGCTE              NUMBER(15,2)              NULL,
  NMN_LIQPAGEXT           NUMBER(15,2)              NULL,
  NMN_INZERO              NUMBER(15,2)              NULL,
  NMN_INZTMP              NUMBER(15,2)              NULL,
  NMN_INZALT              NUMBER(15,2)              NULL,
  NMN_PAGEXTPRR           NUMBER(15,2)              NULL,
  NMN_DTEVAR              NUMBER(15,2)              NULL,
  NMN_IRPMAT              NUMBER(15,2)              NULL,
  NMN_SGRCVN              NUMBER(17,5)              NULL,
  NMN_ICN                 NUMBER(17,5)              NULL,
  NMN_ACUHORCMSNOTHOREXT  NUMBER(5,2)               NULL,
  NMN_PEN                 NUMBER(15,2)              NULL,
  NMN_VAC                 NUMBER(15,2)              NULL,
  NMN_DSPDPL              NUMBER(15,2)              NULL,
  NMN_MLT                 NUMBER(15,2)              NULL,
  NMN_DIF                 NUMBER(15,2)              NULL,
  NMN_NOTPRS              NUMBER(15,2)              NULL,
  NMN_NMNANT              NUMBER(15,2)              NULL,
  NMN_MAT                 NUMBER(15,2)              NULL
)
;


CREATE TABLE TRHU_OBO
(
  OBO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  OBO_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  OBO_SEQ      NUMBER(10)                           NULL,
  OBO_DATCRE   DATE                                 NULL,
  OBO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  OBO_REF      VARCHAR2(15 BYTE)                    NULL,
  OBO_OBS      VARCHAR2(2000 BYTE)                  NULL,
  OBO_DATMOD   DATE                                 NULL,
  OBO_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_PCA
(
  PCA_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PCA_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  PCA_CAT_COD  VARCHAR2(4 BYTE)                     NULL,
  PCA_SCT_COD  VARCHAR2(4 BYTE)                     NULL,
  PCA_DATINI   DATE                                 NULL,
  PCA_DATCRE   DATE                                 NULL,
  PCA_DATFIN   DATE                                 NULL,
  PCA_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PCA_DATMOD   DATE                                 NULL,
  PCA_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  PCA_ACT      VARCHAR2(300 BYTE)                   NULL
)
;


CREATE TABLE TRHU_PCN
(
  PCN_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_CAT_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_SCT_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_CNM_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  PCN_DATCRE     DATE                               NULL,
  PCN_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  PCN_IMP        NUMBER(15,2)                       NULL,
  PCN_IMP002     NUMBER(15,2)                       NULL,
  PCN_DATMOD     DATE                               NULL,
  PCN_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  PCN_VALDIVEUR  NUMBER(15,8)                       NULL
)
;


CREATE TABLE TRHU_PFC
(
  PFC_COF_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_CAT_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_SCT_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_DIASET     NUMBER(1)                          NULL,
  PFC_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  PFC_PRU        NUMBER(15,2)                       NULL,
  PFC_VALDIVEUR  NUMBER(15,8)                       NULL,
  PFC_DATCRE     DATE                               NULL,
  PFC_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  PFC_HORDEF     NUMBER(4,2)                        NULL,
  PFC_DATMOD     DATE                               NULL,
  PFC_USUMOD     VARCHAR2(30 BYTE)                  NULL,
  PFC_CST        NUMBER(15,2)                       NULL,
  PFC_TIPAPLCST  NUMBER(1)                          NULL,
  PFC_PTECST     NUMBER(5,2)                        NULL
)
;


CREATE TABLE TRHU_PSE
(
  PSE_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  PSE_SEC_COD  VARCHAR2(4 BYTE)                     NULL,
  PSE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  PSE_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  PSE_DATINI   DATE                                 NULL,
  PSE_DATCRE   DATE                                 NULL,
  PSE_DATFIN   DATE                                 NULL,
  PSE_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PSE_DATMOD   DATE                                 NULL,
  PSE_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TRHU_RDI
(
  RDI_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_CLN_DAT     DATE                              NULL,
  RDI_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  RDI_HORTEO      NUMBER                            NULL,
  RDI_HORNOR      NUMBER                            NULL,
  RDI_HOREXT      NUMBER                            NULL,
  RDI_PRUEXT      NUMBER(15,2)                      NULL,
  RDI_HOR_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_DATCRE      DATE                              NULL,
  RDI_REG_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  RDI_DATMOD      DATE                              NULL,
  RDI_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  RDI_SEC_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_EMP_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_CAT_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_SCT_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_OBS         VARCHAR2(1000 BYTE)               NULL,
  RDI_PRUHORNOR   NUMBER(15,2)                      NULL,
  RDI_HOR_COD002  VARCHAR2(4 BYTE)                  NULL,
  RDI_HOR_CODNIT  VARCHAR2(4 BYTE)                  NULL,
  RDI_PRUHORNIT   NUMBER(15,2)                  DEFAULT null                      NULL,
  RDI_HORNIT      NUMBER                        DEFAULT 0                         NULL,
  RDI_HORVAC      NUMBER                            NULL,
  RDI_ANL_COD     VARCHAR2(6 BYTE)                  NULL,
  RDI_HORLLI002   NUMBER                            NULL,
  RDI_ZON_COD     VARCHAR2(4 BYTE)                  NULL,
  RDI_HORLLI      NUMBER                            NULL,
  RDI_HORCMS      NUMBER(15,2)                      NULL,
  RDI_ERE         VARCHAR2(1 BYTE)                  NULL
)
;


CREATE INDEX IRHU_AMN_OPE_FK ON TRHU_AMN
(AMN_IDF_COD, AMN_OPE_COD)
;


CREATE INDEX IRHU_ANC_OPE_FK ON TRHU_ANC
(ANC_IDF_COD, ANC_OPE_COD)
;


CREATE INDEX IRHU_ANC_PNO_FK ON TRHU_ANC
(ANC_PNO_COD, ANC_EMP_COD, ANC_IDF_COD)
;


CREATE INDEX IRHU_BAI_OPE_FK ON TRHU_BAI
(BAI_OPE_COD, BAI_IDF_COD)
;


CREATE INDEX IRHU_BAI_SBA_FK ON TRHU_BAI
(BAI_SBA_COD, BAI_TBA_COD, BAI_IDF_COD)
;


CREATE INDEX IRHU_CAC_CAT_FK_I ON TRHU_CAC
(CAC_IDF_COD, CAC_CAT_COD)
;


CREATE INDEX IRHU_CAC_COF_FK_I ON TRHU_CAC
(CAC_IDF_COD, CAC_COF_COD)
;


CREATE INDEX IRHU_CAC_SCT_FK_I ON TRHU_CAC
(CAC_IDF_COD, CAC_CAT_COD, CAC_SCT_COD)
;


CREATE INDEX IRHU_CNH_CNM_FK_I ON TRHU_CNH
(CNH_CNM_COD, CNH_IDF_COD)
;


CREATE INDEX IRHU_CNH_OPE_FK_I ON TRHU_CNH
(CNH_OPE_COD, CNH_IDF_COD)
;


CREATE INDEX IRHU_COT_COF_FK ON TRHU_COT
(COT_IDF_COD, COT_COF_COD)
;


CREATE INDEX IRHU_COT_OPE_FK ON TRHU_COT
(COT_IDF_COD, COT_OPE_COD)
;


CREATE UNIQUE INDEX IRHU_CTLFFO_OPEPRJ_UK ON TRHU_CTLFFO
(CFF_IDF_COD, CFF_OPE_COD, CFF_EMP_COD, CFF_PRJ_NUM, CFF_PRE_COD, 
CFF_CLI_COD)
;


CREATE INDEX IRHU_CTR_COV_FK ON TRHU_CTR
(CTR_IDF_COD, CTR_COV_COD)
;


CREATE INDEX IRHU_CTR_EMP_FK ON TRHU_CTR
(CTR_EMP_COD, CTR_IDF_COD)
;


CREATE INDEX IRHU_CTR_OPE_FK ON TRHU_CTR
(CTR_OPE_COD, CTR_IDF_COD)
;


CREATE INDEX IRHU_CTR_TCT_FK ON TRHU_CTR
(CTR_TCT_COD, CTR_IDF_COD)
;


CREATE INDEX IRHU_DED_PRJ_FK ON TRHU_DED
(DED_IDF_COD, DED_EMP_COD, DED_PRJ_NUM)
;


CREATE INDEX IRHU_DLD_GFE_FK ON TRHU_DLD
(DLD_IDF_COD, DLD_GFE_COD)
;


CREATE INDEX IRHU_DSP_OPE_FK ON TRHU_DSP
(DSP_IDF_COD, DSP_OPE_COD)
;


CREATE INDEX IRHU_DSP_TDS_FK ON TRHU_DSP
(DSP_IDF_COD, DSP_TDS_COD)
;


CREATE INDEX IRHU_ERE_HORCOD002_FK ON TRHU_ERE
(ERE_IDF_COD, ERE_HOR_COD002)
;


CREATE INDEX IRHU_ERE_HORNIT_FK ON TRHU_ERE
(ERE_IDF_COD, ERE_HOR_CODNIT)
;


CREATE INDEX IRHU_ERE_HOR_FK ON TRHU_ERE
(ERE_IDF_COD, ERE_HOR_COD)
;


CREATE INDEX IRHU_ERE_OPE_FK ON TRHU_ERE
(ERE_IDF_COD, ERE_OPE_COD)
;


CREATE INDEX IRHU_ERE_REG_FK ON TRHU_ERE
(ERE_IDF_COD, ERE_REG_COD)
;


CREATE INDEX IRHU_FEXOPE_CUR_FK ON TRHU_FEXOPE
(FEXOPE_TFE_COD, FEXOPE_FEX_COD)
;


CREATE INDEX IRHU_FEXOPE_OPE_FK ON TRHU_FEXOPE
(FEXOPE_IDF_COD, FEXOPE_OPE_COD)
;


CREATE INDEX IRHU_FOR_CUR_FK ON TRHU_FOR
(FOR_TIC_COD, FOR_CUR_COD)
;


CREATE INDEX IRHU_FOR_OPE_FK ON TRHU_FOR
(FOR_IDF_COD, FOR_OPE_COD)
;


CREATE INDEX IRHU_HAN_ANL_FK ON TRHU_HAN
(HAN_IDF_COD, HAN_ANL_COD)
;


CREATE INDEX IRHU_HAN_OPE_FK ON TRHU_HAN
(HAN_IDF_COD, HAN_OPE_COD)
;


CREATE INDEX IRHU_HDC_ANL_FK ON TRHU_HDC
(HDC_IDF_COD, HDC_ANL_COD)
;


CREATE INDEX IRHU_HDC_COV_FK ON TRHU_HDC
(HDC_IDF_COD, HDC_COV_COD)
;


CREATE INDEX IRHU_HDC_HOD_FK ON TRHU_HDC
(HDC_IDF_COD, HDC_HOD_COD)
;


CREATE INDEX IRHU_HLI_ANL_FK ON TRHU_HLI
(HLI_IDF_COD, HLI_ANL_COD)
;


CREATE INDEX IRHU_HLI_OPE_FK ON TRHU_HLI
(HLI_IDF_COD, HLI_OPE_COD)
;


CREATE INDEX IRHU_INA_OPEBAI_FK ON TRHU_INA
(INA_IDF_COD, INA_OPE_CODBAI)
;


CREATE INDEX IRHU_INA_OPEENC_FK ON TRHU_INA
(INA_IDF_COD, INA_OPE_CODENC)
;


CREATE INDEX IRHU_INA_OPEIVS_FK ON TRHU_INA
(INA_IDF_COD, INA_OPE_CODIVS)
;


CREATE INDEX IRHU_INA_OPEOBR_FK ON TRHU_INA
(INA_IDF_COD, INA_OPE_CODOBR)
;


CREATE INDEX IRHU_INA_OPEREV_FK ON TRHU_INA
(INA_IDF_COD, INA_OPE_CODREV)
;


CREATE INDEX IRHU_LIV_DAT_FK ON TRHU_LIV
(LIV_IDF_COD, LIV_DAT)
;


CREATE INDEX IRHU_LIV_OPE_FK ON TRHU_LIV
(LIV_OPE_COD, LIV_IDF_COD)
;


CREATE INDEX IRHU_LMT_ART_FK ON TRHU_LMT
(LMT_IDF_COD, LMT_ART_COD)
;


CREATE INDEX IRHU_LMT_IDF_FK ON TRHU_LMT
(LMT_IDF_COD)
;


CREATE INDEX IRHU_LMT_MAG_FK ON TRHU_LMT
(LMT_IDF_COD, LMT_MAG_COD)
;


CREATE INDEX IRHU_LMT_MAO_FK ON TRHU_LMT
(LMT_IDF_COD, LMT_MAO_COD)
;


CREATE INDEX IRHU_LMT_OPE_FK ON TRHU_LMT
(LMT_IDF_COD, LMT_OPE_COD)
;


CREATE INDEX IRHU_LMT_TLL_FK ON TRHU_LMT
(LMT_IDF_COD, LMT_MAO_COD, LMT_TLL_COD)
;


CREATE INDEX IRHU_NMN_DIV_FK_I ON TRHU_NMN
(NMN_DIV_COD, NMN_IDF_COD)
;


CREATE INDEX IRHU_NMN_OPE_FK_I ON TRHU_NMN
(NMN_OPE_COD, NMN_IDF_COD)
;


CREATE INDEX IRHU_NMN_PNO_FK_I ON TRHU_NMN
(NMN_PNO_COD, NMN_EMP_COD, NMN_IDF_COD)
;


CREATE INDEX IRHU_PCA_OPE_FK ON TRHU_PCA
(PCA_OPE_COD, PCA_IDF_COD)
;


CREATE INDEX IRHU_PCA_SCT_FK ON TRHU_PCA
(PCA_SCT_COD, PCA_CAT_COD, PCA_IDF_COD)
;


CREATE INDEX IRHU_PCN_CNM_FK_I ON TRHU_PCN
(PCN_CNM_COD, PCN_IDF_COD)
;


CREATE INDEX IRHU_PCN_SCT_FK_I ON TRHU_PCN
(PCN_SCT_COD, PCN_CAT_COD, PCN_IDF_COD)
;


CREATE INDEX IRHU_PFC_COF_FK ON TRHU_PFC
(PFC_COF_COD, PFC_IDF_COD)
;


CREATE INDEX IRHU_PFC_SCT_FK ON TRHU_PFC
(PFC_SCT_COD, PFC_CAT_COD, PFC_IDF_COD)
;


CREATE INDEX IRHU_PSE_OPE_FK ON TRHU_PSE
(PSE_OPE_COD, PSE_IDF_COD)
;


CREATE INDEX IRHU_PSE_SEC_FK ON TRHU_PSE
(PSE_SEC_COD, PSE_EMP_COD, PSE_IDF_COD)
;


CREATE INDEX IRHU_RDI_ANL_FK ON TRHU_RDI
(RDI_ANL_COD, RDI_IDF_COD)
;


CREATE INDEX IRHU_RDI_CLN_FK ON TRHU_RDI
(RDI_CLN_DAT, RDI_IDF_COD)
;


CREATE INDEX IRHU_RDI_HOR002_FK ON TRHU_RDI
(RDI_HOR_COD002, RDI_IDF_COD)
;


CREATE INDEX IRHU_RDI_HORNIT_FK ON TRHU_RDI
(RDI_HOR_CODNIT, RDI_IDF_COD)
;


CREATE INDEX IRHU_RDI_HOR_FK ON TRHU_RDI
(RDI_HOR_COD, RDI_IDF_COD)
;


CREATE UNIQUE INDEX IRHU_RDI_OPEDAT ON TRHU_RDI
(RDI_IDF_COD, RDI_OPE_COD, RDI_CLN_DAT)
;


CREATE INDEX IRHU_RDI_OPE_FK ON TRHU_RDI
(RDI_OPE_COD, RDI_IDF_COD)
;


CREATE INDEX IRHU_RDI_REG_FK ON TRHU_RDI
(RDI_REG_COD, RDI_IDF_COD)
;


CREATE INDEX IRHU_RDI_SCT_FK ON TRHU_RDI
(RDI_SCT_COD, RDI_CAT_COD, RDI_IDF_COD)
;


CREATE INDEX IRHU_RDI_SEC_FK ON TRHU_RDI
(RDI_SEC_COD, RDI_EMP_COD, RDI_IDF_COD)
;


CREATE INDEX IRHU_RDI_ZON_FK ON TRHU_RDI
(RDI_IDF_COD, RDI_ZON_COD)
;


CREATE UNIQUE INDEX RRHU_AMN_PK ON TRHU_AMN
(AMN_SEQ)
;


CREATE UNIQUE INDEX RRHU_ANC_PK ON TRHU_ANC
(ANC_IDF_COD, ANC_EMP_COD, ANC_NUM)
;


CREATE UNIQUE INDEX RRHU_BAI_PK ON TRHU_BAI
(BAI_IDF_COD, BAI_OPE_COD, BAI_TBA_COD, BAI_SBA_COD, BAI_DATINI)
;


CREATE UNIQUE INDEX RRHU_CAC_UK ON TRHU_CAC
(CAC_IDF_COD, CAC_COF_COD, CAC_CAT_COD, CAC_SCT_COD)
;


CREATE UNIQUE INDEX RRHU_CCS_PK ON TRHU_CCS
(CCS_IDF_COD, CCS_EMP_COD, CCS_CTECMP)
;


CREATE UNIQUE INDEX RRHU_CNH_PK ON TRHU_CNH
(CNH_CNM_COD, CNH_OPE_COD, CNH_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_CNO_PK ON TRHU_CNO
(CNO_IDF_COD, CNO_OPE_COD, CNO_TCA_COD)
;


CREATE UNIQUE INDEX RRHU_COC_PK ON TRHU_COC
(COC_IDF_COD, COC_CNM_COD, COC_OPE_COD)
;


CREATE UNIQUE INDEX RRHU_COT_PK ON TRHU_COT
(COT_IDF_COD, COT_OPE_COD, COT_COF_COD)
;


CREATE UNIQUE INDEX RRHU_CRI_PK ON TRHU_CRI
(CRI_IDF_COD, CRI_SEQ)
;


CREATE UNIQUE INDEX RRHU_CTLFFO_PK ON TRHU_CTLFFO
(CFF_SEQ)
;


CREATE UNIQUE INDEX RRHU_CTR_PK ON TRHU_CTR
(CTR_IDF_COD, CTR_EMP_COD, CTR_OPE_COD, CTR_TCT_COD, CTR_DATINI)
;


CREATE UNIQUE INDEX RRHU_CVA_PK ON TRHU_CVA
(CVA_IDF_COD, CVA_EMP_COD, CVA_ANL_COD, CVA_COV_COD)
;


CREATE INDEX RRHU_DED_OPE_FK ON TRHU_DED
(DED_IDF_COD, DED_OPE_COD)
;


CREATE UNIQUE INDEX RRHU_DED_PK ON TRHU_DED
(DED_IDF_COD, DED_COD)
;


CREATE UNIQUE INDEX RRHU_DET_PK ON TRHU_DET
(DET_IDF_COD, DET_COD)
;


CREATE UNIQUE INDEX RRHU_DET_UK ON TRHU_DET
(DET_IDF_COD, DET_EMP_COD, DET_PRJ_NUM, DET_OPE_COD, DET_DIA)
;


CREATE UNIQUE INDEX RRHU_DFE_PK ON TRHU_DFE
(DFE_IDF_COD, DFE_TFE_COD, DFE_FEX_COD, DFE_COD)
;


CREATE UNIQUE INDEX RRHU_DLD_PK ON TRHU_DLD
(DLD_IDF_COD, DLD_REF)
;


CREATE UNIQUE INDEX RRHU_DSP_PK ON TRHU_DSP
(DSP_IDF_COD, DSP_COD)
;


CREATE UNIQUE INDEX RRHU_ERE_PK ON TRHU_ERE
(ERE_IDF_COD, ERE_SEQ)
;


CREATE UNIQUE INDEX RRHU_EXL_PK ON TRHU_EXL
(EXL_IDF_COD, EXL_OPE_COD, EXL_SEC)
;


CREATE UNIQUE INDEX RRHU_FCP_PK ON TRHU_FCP
(FCP_IDF_COD, FCP_OPE_COD, FCP_COF_COD)
;


CREATE UNIQUE INDEX RRHU_FEXOPE_PK ON TRHU_FEXOPE
(FEXOPE_IDF_COD, FEXOPE_OPE_COD, FEXOPE_SEQ)
;


CREATE UNIQUE INDEX RRHU_FOR_PK ON TRHU_FOR
(FOR_CUR_COD, FOR_TIC_COD, FOR_IDF_COD, FOR_OPE_COD)
;


CREATE UNIQUE INDEX RRHU_FOT_PK ON TRHU_FOT
(FOT_IDF_COD, FOT_OPE_COD)
;


CREATE UNIQUE INDEX RRHU_HAN_PK ON TRHU_HAN
(HAN_IDF_COD, HAN_ANL_COD, HAN_OPE_COD, HAN_TIP)
;


CREATE UNIQUE INDEX RRHU_HDC_PK ON TRHU_HDC
(HDC_IDF_COD, HDC_COD)
;


CREATE UNIQUE INDEX RRHU_HDO_PK ON TRHU_HDO
(HDO_IDF_COD, HDO_OPE_COD, HDO_DAT)
;


CREATE UNIQUE INDEX RRHU_HLI_PK ON TRHU_HLI
(HLI_IDF_COD, HLI_ANL_COD, HLI_OPE_COD)
;


CREATE INDEX RRHU_ICVA_ANL_FK ON TRHU_CVA
(CVA_IDF_COD, CVA_ANL_COD)
;


CREATE INDEX RRHU_ICVA_COV_FK ON TRHU_CVA
(CVA_IDF_COD, CVA_COV_COD)
;


CREATE INDEX RRHU_ICVA_EMP_FK ON TRHU_CVA
(CVA_IDF_COD, CVA_EMP_COD)
;


CREATE UNIQUE INDEX RRHU_IDO_PK ON TRHU_IDO
(IDO_IDF_COD, IDO_OPE_COD, IDO_IDI_COD)
;


CREATE UNIQUE INDEX RRHU_INA_PK ON TRHU_INA
(INA_IDF_COD, INA_TBA_COD, INA_SBA_COD, INA_OPE_CODBAI, INA_BAI_DATINI, 
INA_COD)
;


CREATE UNIQUE INDEX RRHU_LIV_PK ON TRHU_LIV
(LIV_IDF_COD, LIV_OPE_COD, LIV_DAT, LIV_CLS)
;


CREATE UNIQUE INDEX RRHU_LMT_PK ON TRHU_LMT
(LMT_IDF_COD, LMT_REF)
;


CREATE UNIQUE INDEX RRHU_NMN_PK ON TRHU_NMN
(NMN_OPE_COD, NMN_PNO_COD, NMN_EMP_COD, NMN_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_OBO_PK ON TRHU_OBO
(OBO_IDF_COD, OBO_OPE_COD, OBO_SEQ)
;


CREATE UNIQUE INDEX RRHU_PCA_PK ON TRHU_PCA
(PCA_DATINI, PCA_SCT_COD, PCA_OPE_COD, PCA_CAT_COD, PCA_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_PCN_PK ON TRHU_PCN
(PCN_CNM_COD, PCN_SCT_COD, PCN_CAT_COD, PCN_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_PFC_PK ON TRHU_PFC
(PFC_COF_COD, PFC_SCT_COD, PFC_CAT_COD, PFC_DIASET, PFC_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_PSE_PK ON TRHU_PSE
(PSE_DATINI, PSE_OPE_COD, PSE_SEC_COD, PSE_EMP_COD, PSE_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_RDI_PK ON TRHU_RDI
(RDI_CLN_DAT, RDI_OPE_COD, RDI_IDF_COD)
;


CREATE OR REPLACE FORCE VIEW VRHU_CAT
AS 
SELECT
 A.PCA_IDF_COD, A.PCA_OPE_COD, A.PCA_CAT_COD, CAT_NOM, A.PCA_SCT_COD, S.SCT_NOM, A.PCA_DATINI, A.PCA_DATFIN
FROM
 TRHU_PCA A, TRHU_CAT, TRHU_SCT S
WHERE
 A.PCA_IDF_COD = CAT_IDF_COD AND
 A.PCA_CAT_COD = CAT_COD AND
 A.PCA_DATINI = (SELECT MAX(B.PCA_DATINI)
                FROM    TRHU_PCA B
                WHERE   A.PCA_IDF_COD = B.PCA_IDF_COD AND
                        A.PCA_OPE_COD = B.PCA_OPE_COD)
 --AND (nvl(A.PCA_DATFIN, trunc(sysdate, 'dd'))) <= trunc(sysdate, 'dd')
 AND A.PCA_SCT_COD = S.SCT_COD
 AND A.PCA_IDF_COD = S.SCT_IDF_COD
 AND A.PCA_CAT_COD = S.SCT_CAT_COD;


CREATE OR REPLACE FORCE VIEW VRHU_CMS
AS 
(select ope_idf_cod as cms_idf_cod, pno_emp_cod as cms_emp_cod, ope_cod as cms_ope_cod , 'N' as cms_tip,
pno_fecfin as cms_dia, nvl(nmn_horcms001,0) as cms_hor001, nvl(nmn_horcms002,0) as cms_hor002
from trhu_ope, trhu_pno, trhu_nmn
where nmn_idf_cod = pno_idf_cod and nmn_emp_cod = pno_emp_cod and nmn_pno_cod = pno_cod
and ope_idf_cod = nmn_idf_cod and ope_cod = nmn_ope_cod
and ( nvl(nmn_horcms001,0) <> 0  or nvl(nmn_horcms002,0) <>0 )
)
union all
(
select rdi_idf_cod as cms_idf_cod, rdi_emp_cod as cms_cmp_cod, rdi_ope_cod as cms_ope_cod, 'R' as cms_tip,
rdi_cln_dat as cms_dia, 0 as cms_hor001, rdi_horcms as cms_hor002
from trhu_rdi
where nvl(rdi_horcms,0) <> 0
);


CREATE OR REPLACE FORCE VIEW VRHU_CTLHOROPE
AS 
(SELECT rdi_idf_cod, rdi_emp_cod, rdi_ope_cod CodiOpe,
       ope_nom NomOpe, rdi_cln_dat Data, rdi_reg_cod CodiDia,
       reg_nom TipusDia, rdi_horteo HoresTeo, (rdi_hornor+rdi_horext+rdi_hornit) HoresReals,
       rdi_sec_cod CodiSeccio, sec_nom NomSeccio,
	   to_char(rdi_cln_dat, 'YYYY') A�o, to_char(rdi_cln_dat, 'MM') Mes
  FROM trhu_rdi, trhu_ope, trhu_reg, trhu_sec
 WHERE ope_cod = rdi_ope_cod
        AND ope_idf_cod = rdi_idf_cod
        AND reg_idf_cod = rdi_idf_cod
        AND reg_cod = rdi_reg_cod
        AND sec_cod = rdi_sec_cod
        AND sec_emp_cod = rdi_emp_cod
        AND sec_idf_cod = rdi_idf_cod);


CREATE OR REPLACE FORCE VIEW VRHU_CTR
AS 
SELECT ctr_idf_cod VRH_IDF_COD, ctr_emp_cod VRH_EMP_COD, ctr_datini VRH_DATINI, ctr_tct_cod VRH_TCT_COD,
ctr_ope_cod VRH_OPE_COD, ctr_datfin VRH_DATFI, least(NVL(ctr_datbai, ctr_datfin),NVL(ctr_datfin,ctr_datbai)) vrh_diafin
 FROM TRHU_CTR
WHERE LEAST(NVL(ctr_datbai,NVL(ctr_datfin, SYSDATE)),NVL(ctr_datfin,NVL(ctr_datbai, SYSDATE))) >= SYSDATE;


CREATE OR REPLACE FORCE VIEW VRHU_CTROPE
AS 
SELECT CTR_IDF_COD Identificador, CTR_OPE_COD CodOperario, ope_nom NomOperario,
   CTR_TCT_COD, CTR_EMP_COD CodEmpresaCtr, emp_nom NomEmpresaCtr, CTR_DATINI FecIniContrato, CTR_DATFIN FecFinContrato,
          CTR_DATBAI FecBaja, CTR_OBSBAI ObservBaja, CTR_DATSOLBAI FecSolBaja, CTR_SOLBAI SolicitaBaja,
          CTR_COV_COD Convenio, Cov_nom NombreConvenio,
          frhu_sec_ope(ctr_idf_cod, ctr_ope_cod, 'C', nvl(ctr_datfin, sysdate), ctr_emp_cod) Seccio,
          frhu_sec_ope(ctr_idf_cod, ctr_ope_cod, 'D', nvl(ctr_datfin, sysdate), ctr_emp_cod) NomSeccio,
          pca_cat_cod CodCategoria, (select cat_nom from trhu_cat where cat_idf_cod = ctr_idf_cod and cat_cod = pca_cat_cod) NomCategoria,
          pca_sct_cod CodSubcategoria,
          (select sct_nom from trhu_sct where sct_idf_cod = ctr_idf_cod and sct_cat_cod = pca_cat_cod and sct_cod = pca_sct_cod) NomSubCategoria
FROM  TRHU_CTR, trhu_cov, trhu_emp, trhu_ope, trhu_pca
WHERE cov_idf_cod = ctr_idf_cod and cov_cod = ctr_cov_cod
and emp_idf_cod = ctr_idf_cod and emp_cod = ctr_emp_cod
and ope_idf_cod = ctr_idf_cod and ope_cod = ctr_ope_cod
and pca_idf_cod = ctr_idf_cod and pca_ope_cod = ctr_ope_cod
and pca_datini = (select max(pca_datini)
                  from trhu_pca
                  where pca_idf_cod = ctr_idf_cod and pca_ope_cod = ctr_ope_cod and
                  flim_solapa_fecha(pca_datini,
                                    nvl(pca_datfin, to_Date(to_char(sysdate, 'dd/mm/yyyy'), 'dd/mm/yyyy')),
                                    ctr_datini,
                                    nvl(pca_datfin, nvl(ctr_datbai, to_Date(to_char(sysdate, 'dd/mm/yyyy'), 'dd/mm/yyyy')))
                                    ) <> 0);


CREATE OR REPLACE FORCE VIEW VRHU_FOT
AS 
select ope_cod, ope_nom, ope_nif, fot_foto, ope_datvaltrg, 
  nvl(null, ( select min(rvm_dat) 
              from trhu_rvm 
              where rvm_idf_cod = ope_idf_cod and rvm_ope_cod = ope_cod and rvm_trm_cod = 'P' 
              and rvm_dat >= nvl(ope_datvaltrg, sysdate-1)) 
            ) as dia 
  from trhu_ope, trhu_fot 
  where ope_idf_cod = '0800' and ope_act = 'S' 
  and fot_idf_cod = ope_idf_cod and fot_ope_cod = ope_cod 
  and nvl(ope_datvaltrg, trunc(sysdate, 'dd')) < 
    (select min(rvm_dat) 
    from trhu_rvm 
    where rvm_idf_cod = ope_idf_cod and rvm_ope_cod = ope_cod and rvm_trm_cod = 'P' 
    and rvm_dat >= nvl(ope_datvaltrg, sysdate-1));


CREATE OR REPLACE FORCE VIEW VRHU_OPEACT
AS 
SELECT ope1.ope_idf_cod idf, ope1.ope_cod  ope_cod, ope1.ope_nom  Nombre, ctr_tct_cod,
       ope1.ope_dat FechaAlta , ope1.ope_nif Nif, ctr_emp_cod emp, ctr_datini, ctr_datfin,
       ctr_datsolbai SolicitudBaja, ctr_datbai,
       cat_cod CCategoria, cat_nom Categoria, pca_datini, pca_datfin,
       sct_cod CSubcategoria, sct_nom Subcategoria,
       pca_datini InicioCategoria , pca_datfin  FinCategoria,
       sec_cod Seccion, sec_nom NombreSeccion, pse_datini, pse_datfin, gse_cod, gse_nom,
       ope_ope_cod, (select o.ope_nom from trhu_ope o where o.ope_idf_cod = ope1.ope_idf_cod and o.ope_cod = ope1.ope_ope_cod) NomEncargado
FROM   trhu_ctr, trhu_ope ope1, trhu_pca, trhu_cat, trhu_sct, TRHU_PSE, TRHU_SEC, trhu_gse
WHERE  ope1.ope_idf_cod = ctr_idf_cod
       AND ope1.ope_cod = ctr_ope_cod
 --
       AND pca_idf_cod = ope1.ope_idf_cod
       AND pca_ope_cod = ope1.ope_cod
 --
       AND cat_idf_cod = pca_idf_cod
       AND cat_cod = pca_cat_cod
 --
       AND sct_idf_cod = pca_idf_cod
       AND sct_cat_cod = pca_cat_cod
       AND sct_cod = pca_sct_cod
       AND SEC_IDF_COD = PSE_IDF_COD AND SEC_EMP_COD = PSE_EMP_COD AND SEC_COD = PSE_SEC_COD
       AND pse_idf_cod(+) = ctr_idf_cod AND pse_emp_cod(+) = ctr_emp_cod AND pse_ope_cod (+)= ctr_ope_cod
 --
       and gse_idf_cod(+) = sec_idf_cod and gse_emp_cod(+) = sec_emp_cod and gse_cod(+) = sec_gse_cod;


CREATE OR REPLACE FORCE VIEW VRHU_OPEVAC
AS 
SELECT han_ope_cod Empleado, ope_nom Nombre,
          NVL (han_hdianu, 0) + NVL (han_hdiant, 0) TotalVacaciones,
          frhu_horredvacere(han_idf_cod, han_ope_cod, to_char(sysdate, 'yyyy')) HorRedVacEre,
          Frhu_datosvac (han_idf_cod, han_ope_cod, 'cns', han_anl_cod)
             VacConsumidas,
          Frhu_datosvac (han_idf_cod, han_ope_cod, 'pln', han_anl_cod)
             VacPlanificadas,
          Frhu_datosvac (han_idf_cod, han_ope_cod, 'dis', han_anl_cod)
             VacDisponibles,
          Frhu_datosvac (han_idf_cod, han_ope_cod, 'disdat', han_anl_cod)
             VacDisponiblesHoy, pca_cat_cod Categoria, cat_nom NomCategoria,
          (SELECT SUM (cms_hor001
                       - CASE
                            WHEN cms_dia <= SYSDATE THEN cms_hor002
                            ELSE 0
                         END
                       - CASE
                            WHEN cms_dia <= SYSDATE THEN 0
                            ELSE cms_hor002
                         END)
           FROM   vrhu_cms
           WHERE  cms_idf_cod = ope_idf_cod AND cms_ope_cod = ope_cod)
             Pendientecompensar
   FROM   trhu_han, trhu_ope, vrhu_cat
   WHERE      han_anl_cod = TO_CHAR (SYSDATE, 'yyyy')
          AND han_idf_cod = ope_idf_cod
          AND han_ope_cod = ope_cod
          AND pca_idf_cod = ope_idf_cod
          AND pca_ope_cod = ope_cod
          AND ope_act = 'S'
          AND (han_hdianu <> 0 OR han_hdiant <> 0);


CREATE OR REPLACE FORCE VIEW VRHU_OPEVACBAIWSDL
AS 
select rdi_idf_cod, frhu_empctr(rdi_idf_cod, rdi_ope_cod, null) Emp_cod, 
(select emp_nom from trhu_emp where emp_idf_cod = rdi_idf_cod and emp_cod = frhu_empctr(rdi_idf_cod, rdi_ope_cod, null)) emp_nom, 
rdi_cln_dat, ope_cod, ope_nom, 
FRHU_SEC_OPE (rdi_idf_cod, rdi_ope_cod, 'C', rdi_cln_dat) Sec_cod, 
FRHU_SEC_OPE (rdi_idf_cod, rdi_ope_cod, 'D', rdi_cln_dat) Sec_Nom, 
decode(rdi_reg_cod, frhu_parametre(rdi_idf_cod, 'REGBAI', 'B'), 'Baja', 'Vacaciones') Estado 
from trhu_rdi, trhu_ope 
where ope_idf_cod = rdi_idf_cod 
and ope_cod = rdi_ope_cod 
and (rdi_Reg_cod in (frhu_parametre(rdi_idf_cod, 'REGVAC', 'V'), frhu_parametre(rdi_idf_cod, 'REGBAI', 'B')) or nvl(rdi_horvac, 0) > 0) 
and ope_Act = 'S';


CREATE OR REPLACE FORCE VIEW VRHU_PCA_ULT
AS 
SELECT 
 A.PCA_IDF_COD PCA_IDF_COD, 
 A.PCA_OPE_COD PCA_OPE_COD, 
 A.PCA_CAT_COD PCA_CAT_COD, 
 A.PCA_SCT_COD PCA_SCT_COD, 
 A.PCA_DATINI  PCA_DATINI, 
 A.PCA_DATFIN  PCA_DATFIN 
FROM 
 TRHU_PCA A 
WHERE 
 A.PCA_DATINI = 
  (SELECT 
     MAX(B.PCA_DATINI) 
   FROM 
     TRHU_PCA B 
   WHERE 
     A.PCA_IDF_COD = B.PCA_IDF_COD AND 
     A.PCA_OPE_COD = B.PCA_OPE_COD);


CREATE OR REPLACE FORCE VIEW VRHU_RDINMN
AS 
SELECT   DiaSem,
            rdi_idf_cod,
            rdi_ope_cod,
            ope_nom,
            ope_act,
            rdi_cln_dat,
            rdi_horteo,
            rdi_hornor,
            rdi_horextreal,
            Rdi_horext,
            rdi_hor_cod,
            rdi_hornit,
            rdi_horvac,
            DECODE (frhu_isdiasem (rdi_cln_dat, '1,2,3,4,5'),
                    1, (rdi_horextreal - rdi_horext),
                    0)
               rdi_hornit002,
            rdi_pruhornit,
            pruhorext
     FROM   (SELECT   rdi_idf_cod,
                      rdi_ope_cod,
                      ope_nom,
                      ope_act,
                      rdi_cln_dat,
                      rdi_hor_cod,
                      rdi_horteo,
                      rdi_hornor,
                      rdi_horext rdi_horextreal,
                      DECODE (
                         frhu_isdiasem (rdi_cln_dat, '1,2,3,4,5'),
                         1,
                         LEAST (rdi_horext, NVL (OPE_MAXHOE001, rdi_horext)),
                         rdi_horext
                      )
                         rdi_horext,
                      rdi_hornit,
                      NVL (rdi_pruhornit, 0) rdi_pruhornit,
                      ope_maxhoe001,
                      NVL (
                         frhu_prucon (
                            rdi_idf_cod,
                            rdi_ope_cod,
                            frhu_parametre (rdi_idf_cod, 'COR_HOE_CNM'),
                            rdi_cln_dat,
                            0,
                            'N',
                            'EURO'
                         ),
                         0
                      )
                         pruhorext,
                      rdi_horvac,
                      flim_diasem (rdi_cln_dat) DiaSem
               FROM   TRHU_RDI, trhu_ope
              WHERE   ope_idf_cod = rdi_idf_cod AND ope_cod = rdi_ope_cod);


CREATE OR REPLACE FORCE VIEW VRHU_ULTCTR
AS 
SELECT "CTR_IDF_COD","CTR_OPE_COD","CTR_TCT_COD","CTR_EMP_COD","CTR_DATINI","CTR_DATFIN","CTR_OBS","CTR_DATCRE","CTR_USUCRE","CTR_DATMOD","CTR_USUMOD","CTR_HORVAC","CTR_DATBAI","CTR_OBSBAI","CTR_DATSOLBAI","CTR_SOLBAI","CTR_CRLFFO","CTR_COV_COD" FROM TRHU_CTR E
 WHERE
  E.CTR_DATINI =
   (SELECT MAX(I.CTR_DATINI) FROM
     TRHU_CTR I
	 WHERE
	  I.CTR_IDF_COD = E.CTR_IDF_COD AND
          I.CTR_EMP_COD = E.CTR_EMP_COD AND
	  I.CTR_OPE_COD = E.CTR_OPE_COD);


CREATE OR REPLACE FORCE VIEW VRHU_VAC
AS 
SELECT   han_idf_cod Identificador,
              han_anl_cod AnyLaboral,
              ope_cod CodiOperari,
              ope_nom NomOperario,
              han_hdianu HoresVacAny,
              han_hdiant - NVL (HAN_HLDANT, 0) HorVacPendAnterior,
              HAN_HLDANT HorLibDispPendAnterior,
              frhu_horredvacere (han_idf_cod, han_ope_cod, han_anl_cod)
                 ReduccioHoresVacances,
                han_hdianu
              + han_hdiant
              - frhu_horredvacere (han_idf_cod, han_ope_cod, han_anl_cod)
                 total,
              Frhu_datosvac (han_idf_cod,
                             han_ope_cod,
                             'cns',
                             han_anl_cod)
                 VacConsumidas,
              Frhu_datosvac (han_idf_cod,
                             han_ope_cod,
                             'pln',
                             han_anl_cod)
                 VacPlanificadas,
              Frhu_datosvac (han_idf_cod,
                             han_ope_cod,
                             'dis',
                             han_anl_cod)
                 VacDisponibles,
              Frhu_datosvac (han_idf_cod,
                             han_ope_cod,
                             'disdat',
                             han_anl_cod)
                 VacDisponiblesHoy,
              frhu_calchorset (han_idf_cod, han_ope_cod, 'h') HorasSemana,
              frhu_calchorset (han_idf_cod, han_ope_cod, '%') PercenHorasSemana,
              frhu_empctr (han_idf_cod, han_ope_cod, '0001') Empresa,
              (SELECT   emp_nom
                 FROM   trhu_emp
                WHERE   emp_idf_cod = han_idf_cod
                        AND emp_cod =
                              frhu_empctr (han_idf_cod, han_ope_cod, '0001'))
                 Nomempresa,
              FRHU_SEC_OPE (han_idf_cod, han_ope_cod, 'C') CodiSeccio,
              FRHU_SEC_OPE (han_idf_cod, han_ope_cod, 'D') NomSeccio,
              pca_cat_cod Categoria,
              cat_nom NomCategoria,
              pca_sct_cod Subcategoria,
              (SELECT   sct_nom
                 FROM   trhu_sct
                WHERE       sct_idf_cod = pca_idf_cod
                        AND sct_cat_cod = pca_cat_cod
                        AND sct_cod = pca_sct_cod)
                 NomSubcategoria,
              (SELECT   SUM(cms_hor001
                            - CASE
                                 WHEN cms_dia <= SYSDATE THEN cms_hor002
                                 ELSE 0
                              END
                            - CASE
                                 WHEN cms_dia <= SYSDATE THEN 0
                                 ELSE cms_hor002
                              END)
                 FROM   vrhu_cms
                WHERE   cms_idf_cod = ope_idf_cod AND cms_ope_cod = ope_cod)
                 Pendientecompensar,
              ope_act Activo,
              FRHU_HORLIBDISHOY (han_ope_cod, han_idf_cod) HorasLibreDispHoy
       FROM   trhu_han, trhu_ope, vrhu_cat
      WHERE       han_idf_cod = ope_idf_cod
              AND han_ope_cod = ope_cod
              AND pca_idf_cod = ope_idf_cod
              AND pca_ope_cod = ope_cod
   ORDER BY   ope_nom, ope_cod;


CREATE OR REPLACE FORCE VIEW VRHU_VPS
AS 
SELECT
 A.PSE_IDF_COD VPS_IDF_COD,
 A.PSE_OPE_COD VPS_OPE_COD,
 A.PSE_EMP_COD VPS_EMP_COD,
 A.PSE_SEC_COD VPS_SEC_COD,
 SEC_NOM       VPS_SEC_NOM
 , sec_ctlffo  vps_ctlffo, sec_ctlhoe vps_ctlhoe, sec_gse_cod vps_gse_cod
FROM
 TRHU_PSE A, TRHU_SEC
WHERE
 A.PSE_IDF_COD = SEC_IDF_COD AND
 A.PSE_EMP_COD = SEC_EMP_COD AND
 A.PSE_SEC_COD = SEC_COD AND
 A.PSE_DATINI =
  (SELECT
     MAX(B.PSE_DATINI)
   FROM
     TRHU_PSE B
   WHERE
     A.PSE_IDF_COD = B.PSE_IDF_COD AND
     A.PSE_OPE_COD = B.PSE_OPE_COD AND
     A.PSE_EMP_COD = B.PSE_EMP_COD);


CREATE OR REPLACE FORCE VIEW VWEB_OPE
AS 
SELECT ope.ope_idf_cod  Identificador, ope.ope_cod  C�digo, ope.ope_nom  Nombre,
       ope.ope_act  Activo, ope.ope_entsor  EntradaSalida, ope.ope_cml  Comercial,
       ope.ope_hor_cod HorarioNormal, ope.ope_tor  ListadoTurnos, ope.ope_pin  Pin,
       ope.ope_dom Domicilio, ope.ope_cpo CodPostal, ope.ope_pob Poblaci�n,
       ope.ope_tel Tel�fono,ope.ope_telemp Telefono_empresa, ope.ope_nss  NumSegSocial , ope.ope_mtr Matr�cula,
       ope.ope_datnai  FechaNacimiento ,
       decode (ope.ope_estciv, 'C', 'Casado', 'D', 'Divorciado', 'V', 'Viudo', 'S', 'Soltero', 'Otros')  EstadoCivil ,
       ope.ope_fil  NumHijos , ope.ope_nompae  NombrePadre , ope.ope_nommae  NombreMadre,
       ope.ope_llcnai  LugarNacimiento, ope.ope_dat  FechaAlta , ope.ope_nif  Nif , ope.ope_horvac  HorasVacaciones,
       ope.ope_nmn1  Nomina1 , ope.ope_nmn2  Nomina2 , ope.ope_pruextdls  PrecioExtraLunes,
       ope.ope_pruextdms  PrecioExtraMartes , ope.ope_pruextdcs  PrecioExtraMi�rcoles,
       ope.ope_pruextdjs   PrecioExtraJueves ,        ope.ope_pruextdvs  PrecioExtraViernes , ope.ope_pruextdse   PrecioExtraS�bado, ope.ope_pruextdme   PrecioExtraDomingo ,
       ope.ope_pruhornor  PrecioHoraNormal , ope.ope_hor_cod002  HorarioDescanso, ope.ope_hor_codnit  HorarioNocturno ,
       ope.ope_prunitdls  PrecioHocheLunes , ope.ope_prunitdms  PrecioNocheMartes, ope.ope_prunitdcs  PrecioNocheMi�rcoles ,
       ope.ope_prunitdjs  PrecioHocheJueves , ope.ope_prunitdvs  PrecioNocheViernes, ope.ope_prunitdse  PrecioNocheS�bado ,
       ope.ope_prunitdme  PrecioHocheDomingo , ope.ope_dcc  DigitoControl, ope.ope_ccr  NumCuenta, ope.ope_ofb Oficina , ope.ope_ban Banco ,
       ope.ope_enc  Encargado , emp.emp_cod  C�digoEmpresa , emp.emp_nom  Empresa ,
	   ope.ope_ope_cod Cod_Encargado, nvl((select ope_nom from trhu_ope where ope_idf_cod = ope.ope_idf_cod and ope_cod = ope.ope_ope_cod),'') Nombre_encargado,
       ctr.ctr_datini  InicioContrato , ctr.ctr_datfin  FinContrato , decode(ctr.ctr_solbai, 'O', 'Operario', 'Empresa')  SolicitaBaja ,
       ctr.ctr_datsolbai  SolicitudBaja , ctr.ctr_datbai  FechaBaja ,
       ctr.ctr_horvac  HorasVacacionesContrato , ctr.ctr_tct_cod  C�digoTipoContrato , tct.tct_nom  TipoContrato ,
	   ctr_prj_num ObraContrato, prj_nom NombreObra,
       cat.cat_cod  CodigoCategoria , cat.cat_nom  Categor�a , sct.sct_cod  C�digoSubcategoria , sct.sct_nom  Subcategor�a,
       pca.pca_datini  InicioCategor�a , pca.pca_datfin  FinCategor�a, ope.ope_ope_cod REPONSABLECOD, OPE2.OPE_NOM RESPONSABLENOMBRE,
       vps_sec_cod Seccion, vps_sec_nom NombreSeccion, vps_ctlffo ControlHojasTrab, ope.ope_diapjb DiaPrejubilacion,
       vps_gse_cod GrupoSeccion, gse_nom NombreGrupoSeccion
 FROM trhu_cat cat, trhu_ctr ctr, trhu_emp emp,
 trhu_ope ope, trhu_pca pca, trhu_sct sct,
 trhu_tct tct, trhu_ope ope2, vrhu_vps v, tges_prj prj, trhu_gse
 WHERE  emp.emp_cod = ctr.ctr_emp_cod
        and ope.ope_idf_cod = ope2.ope_idf_cod(+)
        and ope.ope_ope_cod = ope2.ope_cod(+)
        AND emp.emp_idf_cod = ctr.ctr_idf_cod
        AND ope.ope_cod = ctr.ctr_ope_cod
        AND ope.ope_idf_cod = ctr.ctr_idf_cod
        AND ope.ope_cod = pca.pca_ope_cod
        AND ope.ope_idf_cod = pca.pca_idf_cod
        AND cat.cat_cod = sct.sct_cat_cod
        AND cat.cat_idf_cod = sct.sct_idf_cod
        AND sct.sct_cod = pca.pca_sct_cod
        AND sct.sct_cat_cod = pca.pca_cat_cod
        AND sct.sct_idf_cod = pca.pca_idf_cod
        AND tct.tct_cod = ctr.ctr_tct_cod
        AND tct.tct_idf_cod = ctr.ctr_idf_cod
        and pca_datini = (select max(pca_datini)
                           from trhu_pca pca2
                           where pca2.pca_ope_cod = ope.ope_cod
                           and pca2.pca_idf_cod = pca.pca_idf_cod)
        and ctr_datini = (select max(ctr_datini)
                          from trhu_ctr ctr2
                          where ctr2.ctr_idf_cod = ctr.ctr_idf_cod
                          and ctr2.ctr_emp_cod = ctr.ctr_emp_cod
                          and ctr2.ctr_ope_cod = ctr.ctr_ope_cod)
	    and prj.prj_idf_cod(+) = ctr.ctr_idf_cod
		and prj.prj_emp_cod(+) = ctr.ctr_emp_cod
    	and prj.prj_num(+) = ctr.ctr_prj_num
       and vps_idf_cod = ctr.ctr_idf_cod
       and vps_emp_cod = ctr.ctr_emp_cod
       and vps_ope_cod = ctr.ctr_ope_cod
	   and gse_idf_cod(+)=vps_idf_cod and gse_emp_cod(+)=vps_emp_cod and gse_cod(+)=vps_gse_cod;


CREATE TABLE TRHU_CMH
(
  CMH_IDF_COD    VARCHAR2(4 BYTE)                   NULL,
  CMH_EMP_COD    VARCHAR2(4 BYTE)                   NULL,
  CMH_OPE_COD    VARCHAR2(6 BYTE)                   NULL,
  CMH_PNO_COD    VARCHAR2(6 BYTE)                   NULL,
  CMH_COF_COD    VARCHAR2(4 BYTE)                   NULL,
  CMH_HORCNC     NUMBER(5,2)                        NULL,
  CMH_FCT        NUMBER(4,2)                        NULL,
  CMH_IMPNOTCOB  NUMBER(15,2)                       NULL,
  CMH_HOREXTFIN  NUMBER(5,2)                        NULL,
  CMH_DATCRE     DATE                               NULL,
  CMH_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  CMH_DATMOD     DATE                               NULL,
  CMH_USUMOD     VARCHAR2(30 BYTE)                  NULL
)
;


CREATE TABLE TRHU_HOL
(
  HOL_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  HOL_CLN_DAT  DATE                                 NULL,
  HOL_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  HOL_HOD_COD  VARCHAR2(4 BYTE)                     NULL,
  HOL_HOR      NUMBER(5,2)                          NULL,
  HOL_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  HOL_DATCRE   DATE                                 NULL,
  HOL_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  HOL_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TRHU_INR
(
  INR_IDF_COD     VARCHAR2(4 BYTE)                  NULL,
  INR_COD         NUMBER(10)                        NULL,
  INR_DAT         DATE                              NULL,
  INR_INI         DATE                              NULL,
  INR_CLN_DAT     DATE                              NULL,
  INR_DATCRE      DATE                              NULL,
  INR_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  INR_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  INR_ZON_COD     VARCHAR2(4 BYTE)                  NULL,
  INR_NOD_NUMENT  NUMBER(10)                        NULL,
  INR_NOD_NUMSOR  NUMBER(10)                        NULL,
  INR_FIN         DATE                              NULL,
  INR_OBS         VARCHAR2(1000 BYTE)               NULL,
  INR_OPE_COD     VARCHAR2(6 BYTE)                  NULL,
  INR_DATMOD      DATE                              NULL,
  INR_COF_COD     VARCHAR2(4 BYTE)                  NULL,
  INR_FFO_COD     NUMBER(10)                        NULL
)
;


CREATE TABLE TRHU_LFF
(
  LFF_COF_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_FFO_COD        NUMBER(10)                     NULL,
  LFF_IDF_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_CLI_COD        VARCHAR2(6 BYTE)               NULL,
  LFF_DIV_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_PRU            NUMBER(15,2)                   NULL,
  LFF_DATCRE         DATE                           NULL,
  LFF_USUCRE         VARCHAR2(30 BYTE)              NULL,
  LFF_PDA_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_CAP_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_PRE_COD        NUMBER(10)                     NULL,
  LFF_DATMOD         DATE                           NULL,
  LFF_USUMOD         VARCHAR2(30 BYTE)              NULL,
  LFF_HOR            NUMBER(2)                      NULL,
  LFF_MIN            NUMBER(2)                      NULL,
  LFF_HORDEC         NUMBER(15,2)                   NULL,
  LFF_IMP            NUMBER(15,2)                   NULL,
  LFF_DES            VARCHAR2(255 BYTE)             NULL,
  LFF_LACNUMDOC      NUMBER(10)                     NULL,
  LFF_LAC_NUM        NUMBER(10)                     NULL,
  LFF_EMP_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_SEC_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_OBS            VARCHAR2(1000 BYTE)            NULL,
  LFF_ORI            VARCHAR2(1 BYTE)           DEFAULT 'F'                       NULL,
  LFF_NUM            NUMBER(10)                     NULL,
  LFF_MAQ_COD        VARCHAR2(15 BYTE)              NULL,
  LFF_SCL_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_AVI_NUM        NUMBER(10)                     NULL,
  LFF_AGN_MAQ        VARCHAR2(16 BYTE)              NULL,
  LFF_AGN_NUM        NUMBER(10)                     NULL,
  LFF_RMF_NUM        NUMBER(10)                     NULL,
  LFF_FSB_NUM        NUMBER(10)                     NULL,
  LFF_CSTUNI         NUMBER(15,2)                   NULL,
  LFF_MAQ_CODFEI     VARCHAR2(15 BYTE)              NULL,
  LFF_CSTMAQ         NUMBER(17,5)                   NULL,
  LFF_MAQ_CODFEI002  VARCHAR2(15 BYTE)              NULL,
  LFF_CSTMAQ002      NUMBER(17,5)                   NULL,
  LFF_FOB_NUM        NUMBER(10)                     NULL,
  LFF_PRJ_NUM        VARCHAR2(6 BYTE)               NULL,
  LFF_ETP_COD        VARCHAR2(4 BYTE)               NULL,
  LFF_ETP_NUM        NUMBER(3)                      NULL,
  LFF_UCE_SEQ        NUMBER(10)                     NULL,
  LFF_LES_SEQ        NUMBER(10)                     NULL,
  LFF_HORMAQ002      NUMBER(2)                      NULL,
  LFF_MINMAQ002      NUMBER(2)                      NULL,
  LFF_HORDECMAQ002   NUMBER(5,2)                    NULL,
  LFF_HORMAQ         NUMBER(2)                      NULL,
  LFF_MINMAQ         NUMBER(2)                      NULL,
  LFF_HORDECMAQ      NUMBER(5,2)                    NULL,
  LFF_RLE_COD        VARCHAR2(30 BYTE)              NULL,
  LFF_MCA            VARCHAR2(1 BYTE)               NULL,
  LFF_INR_COD        NUMBER(18)                     NULL,
  LFF_APL_REF        NUMBER(12)                     NULL,
  LFF_PDA_SEQ        NUMBER(10)                     NULL,
  LFF_EXT            VARCHAR2(1 BYTE)               NULL,
  LFF_ZON_COD        VARCHAR2(4 BYTE)               NULL
)
;


CREATE TABLE TRHU_LNM
(
  LNM_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  LNM_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  LNM_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  LNM_PNO_COD  VARCHAR2(6 BYTE)                     NULL,
  LNM_CNM_COD  VARCHAR2(4 BYTE)                     NULL,
  LNM_DATCRE   DATE                                 NULL,
  LNM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  LNM_IMP      NUMBER(15,2)                         NULL,
  LNM_IMP002   NUMBER(15,2)                         NULL,
  LNM_DATMOD   DATE                                 NULL,
  LNM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  LNM_DES      VARCHAR2(250 BYTE)                   NULL
)
;


CREATE INDEX IRHU_HOL_HOD_FK ON TRHU_HOL
(HOL_IDF_COD, HOL_HOD_COD)
;


CREATE INDEX IRHU_HOL_RDI_FK ON TRHU_HOL
(HOL_IDF_COD, HOL_CLN_DAT, HOL_OPE_COD)
;


CREATE INDEX IRHU_INR_COF_FK ON TRHU_INR
(INR_COF_COD, INR_IDF_COD)
;


CREATE INDEX IRHU_INR_FFO_FK ON TRHU_INR
(INR_FFO_COD, INR_IDF_COD)
;


CREATE INDEX IRHU_INR_IDF_FK ON TRHU_INR
(INR_IDF_COD)
;


CREATE INDEX IRHU_INR_NODSOR_FK ON TRHU_INR
(INR_NOD_NUMSOR, INR_IDF_COD)
;


CREATE INDEX IRHU_INR_NOD_FK ON TRHU_INR
(INR_NOD_NUMENT, INR_IDF_COD)
;


CREATE INDEX IRHU_INR_RDI_FK ON TRHU_INR
(INR_CLN_DAT, INR_OPE_COD, INR_IDF_COD)
;


CREATE INDEX IRHU_INR_ZON_FK ON TRHU_INR
(INR_ZON_COD, INR_IDF_COD)
;


CREATE INDEX IRHU_LFF_AVI_FK ON TRHU_LFF
(LFF_IDF_COD, LFF_AVI_NUM)
;


CREATE INDEX IRHU_LFF_CAP_FK ON TRHU_LFF
(LFF_CAP_COD, LFF_PRE_COD, LFF_EMP_COD, LFF_IDF_COD)
;


CREATE INDEX IRHU_LFF_CLI_FK ON TRHU_LFF
(LFF_CLI_COD, LFF_IDF_COD)
;


CREATE INDEX IRHU_LFF_COF_FK ON TRHU_LFF
(LFF_COF_COD, LFF_IDF_COD)
;


CREATE INDEX IRHU_LFF_DIV_FK ON TRHU_LFF
(LFF_DIV_COD, LFF_IDF_COD)
;


CREATE INDEX IRHU_LFF_FFO_FK ON TRHU_LFF
(LFF_FFO_COD, LFF_IDF_COD)
;


CREATE INDEX IRHU_LFF_FOB_FK_I ON TRHU_LFF
(LFF_IDF_COD, LFF_EMP_COD, LFF_FOB_NUM)
;


CREATE INDEX IRHU_LFF_INR_FK ON TRHU_LFF
(LFF_IDF_COD, LFF_INR_COD)
;


CREATE INDEX IRHU_LFF_LAC_FK ON TRHU_LFF
(LFF_LACNUMDOC, LFF_LAC_NUM, LFF_IDF_COD, LFF_EMP_COD)
;


CREATE INDEX IRHU_LFF_LES_FK_I ON TRHU_LFF
(LFF_IDF_COD, LFF_EMP_COD, LFF_PRJ_NUM, LFF_ETP_COD, LFF_ETP_NUM, 
LFF_LES_SEQ)
;


CREATE INDEX IRHU_LFF_MAQ002_FK ON TRHU_LFF
(LFF_IDF_COD, LFF_MAQ_CODFEI002)
;


CREATE INDEX IRHU_LFF_MAQ_FK ON TRHU_LFF
(LFF_IDF_COD, LFF_MAQ_CODFEI)
;


CREATE INDEX IRHU_LFF_PDA_FK ON TRHU_LFF
(LFF_PDA_COD, LFF_PRE_COD, LFF_CAP_COD, LFF_EMP_COD, LFF_IDF_COD)
;


CREATE INDEX IRHU_LFF_PRE_FK ON TRHU_LFF
(LFF_PRE_COD, LFF_EMP_COD, LFF_IDF_COD)
;


CREATE INDEX IRHU_LFF_SCL_FK ON TRHU_LFF
(LFF_IDF_COD, LFF_CLI_COD, LFF_SCL_COD)
;


CREATE INDEX IRHU_LFF_SEC_FK ON TRHU_LFF
(LFF_SEC_COD, LFF_EMP_COD, LFF_IDF_COD)
;


CREATE INDEX IRHU_LFF_UCE_FK_I ON TRHU_LFF
(LFF_IDF_COD, LFF_EMP_COD, LFF_PRJ_NUM, LFF_ETP_COD, LFF_ETP_NUM, 
LFF_UCE_SEQ)
;


CREATE INDEX IRHU_LNM_CNM_FK_I ON TRHU_LNM
(LNM_CNM_COD, LNM_IDF_COD)
;


CREATE INDEX IRHU_LNM_NMN_FK_I ON TRHU_LNM
(LNM_PNO_COD, LNM_OPE_COD, LNM_EMP_COD, LNM_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_CMH_PK ON TRHU_CMH
(CMH_IDF_COD, CMH_EMP_COD, CMH_PNO_COD, CMH_OPE_COD, CMH_COF_COD)
;


CREATE UNIQUE INDEX RRHU_HOL_PK ON TRHU_HOL
(HOL_IDF_COD, HOL_CLN_DAT, HOL_OPE_COD, HOL_HOD_COD)
;


CREATE UNIQUE INDEX RRHU_INR_PK ON TRHU_INR
(INR_COD, INR_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_LFF_PK ON TRHU_LFF
(LFF_FFO_COD, LFF_NUM, LFF_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_LNM_PK ON TRHU_LNM
(LNM_CNM_COD, LNM_OPE_COD, LNM_PNO_COD, LNM_EMP_COD, LNM_IDF_COD)
;


CREATE OR REPLACE FORCE VIEW VRHU_ALB_ALE
AS 
SELECT   IDF,
              EMP,
              DATA,
              CODIOPERARI,
              NOMOPERARI,
              TIPUSHORA,
              TEMPS,
              CODICLIENT,
              NOMCLIENT,
              ALBARA,
              CLASSE,
              FACTURA,
              PRESSUPOST,
              VEHICLE,
              KM,
              SECCIO,
              NOMSECCIO,
              REGIMEN,
              pre_ser_cod,
              pre_num,
              pre_ver,
              alb_ser_cod,
              alb_num,
              fac_ser_cod,
              fac_num,
              DECODE (fac_cer_num, NULL, 0, 1) AS facturaCertificacio,
              pre_cod,
              alb_numdoc,
              projecte
       FROM   (  SELECT   inr_idf_cod IDF,
                          NULL EMP,
                          inr_cln_dat DATA,
                          ope_cod CODIOPERARI,
                          ope_nom NOMOPERARI,
                          'M' TIPUSHORA,
                          ROUND (SUM ( (inr_fin - inr_ini) * 24), 2) TEMPS,
                          NULL CODICLIENT,
                          NULL NOMCLIENT,
                          NULL ALBARA,
                          NULL CLASSE,
                          NULL FACTURA,
                          NULL PRESSUPOST,
                          NULL VEHICLE,
                          0 KM,
                          frhu_sec_ope (ope_idf_cod,
                                        ope_cod,
                                        'C',
                                        inr_cln_dat)
                             SECCIO,
                          frhu_sec_ope (ope_idf_cod,
                                        ope_cod,
                                        'D',
                                        inr_cln_dat)
                             NOMSECCIO,
                          FRHU_RDIREG (ope_idf_cod, ope_cod, inr_cln_dat) REGIMEN,
                          TO_CHAR (NULL) AS pre_ser_cod,
                          TO_NUMBER (NULL) AS pre_num,
                          TO_NUMBER (NULL) AS pre_ver,
                          TO_CHAR (NULL) AS alb_ser_cod,
                          TO_NUMBER (NULL) AS alb_num,
                          TO_CHAR (NULL) fac_ser_cod,
                          TO_NUMBER (NULL) fac_num,
                          TO_NUMBER (NULL) fac_cer_num,
                          TO_NUMBER (NULL) pre_cod,
                          TO_NUMBER (NULL) AS alb_numdoc,
                          TO_CHAR (NULL) AS projecte
                   FROM   trhu_inr, trhu_ope
                  WHERE       inr_idf_cod = ope_idf_cod
                          AND inr_ope_cod = ope_cod
                          AND ROUND ( (inr_fin - inr_ini) * 24, 2) <> 0
               GROUP BY   inr_idf_cod,
                          inr_cln_dat,
                          ope_idf_cod,
                          ope_cod,
                          ope_nom
               UNION ALL
               --
               SELECT   lff_idf_cod IDF,
                        lff_emp_cod EMP,
                        ffo_cln_dat DATA,
                        ffo_ope_cod CODIOPERARI,
                        ope_nom NOMOPERARI,
                        'P' TIPUSHORA,
                        ROUND (NVL (lff_hor, 0) + (NVL (lff_min, 0) / 60), 2)
                           TEMPS,
                        NVL (alb_cli_cod, lff_cli_cod) CODICLIENT,
                        cli_nomcom NOMCLIENT,
                        DECODE (alb_num,
                                NULL, NULL,
                                alb_ser_cod || '\' || alb_num)
                           ALBARA,
                        alb_cls CLASSE,
                        DECODE (fac_num,
                                NULL, NULL,
                                fac_ser_cod || '\' || fac_num)
                           FACTURA,
                        DECODE (pre_num,
                                NULL, NULL,
                                pre_ser_cod || '\' || pre_num)
                           PRESSUPOST,
                        NULL VEHICLE,
                        0 KM,
                        frhu_sec_ope (lff_idf_cod,
                                      ffo_ope_cod,
                                      'C',
                                      ffo_cln_dat)
                           SECCIO,
                        frhu_sec_ope (lff_idf_cod,
                                      ffo_ope_cod,
                                      'D',
                                      ffo_cln_dat)
                           NOMSECCIO,
                        FRHU_RDIREG (lff_idf_cod, ffo_ope_cod, ffo_cln_dat)
                           REGIMEN,
                        pre_ser_cod,
                        pre_num,
                        pre_ver,
                        alb_ser_cod,
                        alb_num,
                        fac_ser_cod,
                        fac_num,
                        fac_cer_num,
                        pre_cod,
                        alb_numdoc,
                        lff_prj_num AS projecte
                 FROM   trhu_ffo,
                        trhu_lff,
                        tges_alb,
                        tges_cli,
                        tges_pre,
                        trhu_ope,
                        tges_fac
                WHERE       ffo_idf_cod = lff_idf_cod
                        AND ffo_cod = lff_ffo_cod
                        AND alb_idf_cod(+) = lff_idf_cod
                        AND alb_emp_cod(+) = lff_emp_cod
                        AND alb_numdoc(+) = lff_lacnumdoc
                        AND cli_idf_cod = lff_idf_cod
                        AND cli_cod = lff_cli_cod
                        AND pre_idf_cod(+) = lff_idf_cod
                        AND pre_emp_cod(+) = lff_emp_cod
                        AND pre_cod(+) = lff_pre_cod
                        AND fac_idf_cod(+) = alb_idf_cod
                        AND fac_emp_cod(+) = alb_emp_cod
                        AND fac_ser_cod(+) = alb_ser_codfac
                        AND fac_cls(+) = alb_fac_cls
                        AND fac_num(+) = alb_fac_num
                        AND ffo_ope_cod = ope_cod
                        AND ffo_idf_cod = ope_idf_cod
                        AND ROUND (NVL (lff_hor, 0) + (NVL (lff_min, 0) / 60),
                                   2) <> 0
               --
               UNION ALL
               SELECT   rdi_idf_cod IDF,
                        rdi_emp_cod EMP,
                        rdi_cln_dat DATA,
                        rdi_ope_cod CODIOPERARI,
                        ope_nom NOMOPERARI,
                        'T' TIPUSHORA,
                        RDI_HORTEO TEMPS,
                        TO_CHAR (NULL) CODICLIENT,
                        TO_CHAR (NULL) NOMCLIENT,
                        TO_CHAR (NULL) ALBARA,
                        TO_CHAR (NULL) CLASSE,
                        TO_CHAR (NULL) FACTURA,
                        TO_CHAR (NULL) PRESSUPOST,
                        TO_CHAR (NULL) VEHICLE,
                        0 KM,
                        frhu_sec_ope (ope_idf_cod,
                                      ope_cod,
                                      'C',
                                      rdi_cln_dat)
                           SECCIO,
                        frhu_sec_ope (ope_idf_cod,
                                      ope_cod,
                                      'D',
                                      rdi_cln_dat)
                           NOMSECCIO,
                        FRHU_RDIREG (ope_idf_cod, ope_cod, rdi_cln_dat) REGIMEN,
                        TO_CHAR (NULL) AS pre_ser_cod,
                        TO_NUMBER (NULL) AS pre_num,
                        TO_NUMBER (NULL) AS pre_ver,
                        TO_CHAR (NULL) AS alb_ser_cod,
                        TO_NUMBER (NULL) AS alb_num,
                        TO_CHAR (NULL) AS fac_ser_cod,
                        TO_NUMBER (NULL) AS fac_num,
                        TO_NUMBER (NULL) AS fac_cer_num,
                        TO_NUMBER (NULL) AS pre_cod,
                        TO_NUMBER (NULL) AS alb_numdoc,
                        TO_CHAR (NULL) AS projecte
                 FROM   trhu_rdi, trhu_ope
                WHERE       rdi_idf_cod = ope_idf_cod
                        AND rdi_ope_cod = ope_cod
                        AND RDI_HORTEO <> 0
               --
               UNION ALL
               SELECT   alb_idf_cod IDF,
                        alb_emp_cod EMP,
                        alb_dia DATA,
                        ale_ope_cod CODIOPERARI,
                        ope_nom NOMOPERARI,
                        'D' TIPUSHORA,
                        ROUND (
                           NVL (ale_hordpl, 0) + (NVL (ale_mindpl, 0) / 60),
                           2
                        )
                           TEMPS,
                        alb_cli_cod CODICLIENT,
                        cli_nomcom NOMCLIENT,
                        DECODE (alb_num,
                                NULL, NULL,
                                alb_ser_cod || '\' || alb_num)
                           ALBARA,
                        alb_cls CLASSE,
                        DECODE (fac_num,
                                NULL, NULL,
                                fac_ser_cod || '\' || fac_num)
                           FACTURA,
                        DECODE (pre_num,
                                NULL, NULL,
                                pre_ser_cod || '\' || pre_num)
                           PRESSUPOST,
                        mtr_cod VEHICLE,
                        ale_kmt KM,
                        frhu_sec_ope (ale_idf_cod,
                                      ale_ope_cod,
                                      'C',
                                      alb_dia)
                           SECCIO,
                        frhu_sec_ope (ale_idf_cod,
                                      ale_ope_cod,
                                      'D',
                                      alb_dia)
                           NOMSECCIO,
                        FRHU_RDIREG (ale_idf_cod, ale_ope_cod, alb_dia) REGIMEN,
                        pre_ser_cod,
                        pre_num,
                        pre_ver,
                        alb_ser_cod,
                        alb_num,
                        fac_ser_cod,
                        fac_num,
                        fac_cer_num,
                        pre_cod,
                        alb_numdoc,
                        alb_prj_num AS projecte
                 FROM   tges_ale,
                        tges_alb,
                        tges_cli,
                        tges_pre,
                        tges_mtr,
                        trhu_ope,
                        tges_fac
                WHERE       alb_idf_cod = ale_idf_cod
                        AND alb_emp_cod = ale_emp_cod
                        AND alb_numdoc = ale_alb_numdoc
                        AND cli_idf_cod = alb_idf_cod
                        AND cli_cod = alb_cli_cod
                        AND pre_idf_cod(+) = ale_idf_cod
                        AND pre_emp_cod(+) = ale_emp_cod
                        AND pre_cod(+) = ale_pre_cod
                        AND mtr_idf_cod(+) = ale_idf_cod
                        AND mtr_tra_cod(+) = ale_tra_cod
                        AND mtr_cod(+) = ale_mtr_cod
                        AND fac_idf_cod(+) = alb_idf_cod
                        AND fac_emp_cod(+) = alb_emp_cod
                        AND fac_ser_cod(+) = alb_ser_codfac
                        AND fac_cls(+) = alb_fac_cls
                        AND fac_num(+) = alb_fac_num
                        AND ale_ope_cod = ope_cod
                        AND ale_idf_cod = ope_idf_cod
                         AND (ROUND (
                              NVL (ale_hordpl, 0) + (NVL (ale_mindpl, 0) / 60),
                              2
                           ) <> 0 or ale_kmt <> 0)
               --
               UNION ALL
               SELECT   alb_idf_cod IDF,
                        alb_emp_cod EMP,
                        alb_dia DATA,
                        ale_ope_cod CODIOPERARI,
                        ope_nom NOMOPERARI,
                        'E' TIPUSHORA,
                        ROUND (
                           NVL (ale_hortem, 0) + (NVL (ale_mintem, 0) / 60),
                           2
                        )
                           TEMPS,
                        alb_cli_cod CODICLIENT,
                        cli_nomcom NOMCLIENT,
                        alb_ser_cod || '\' || alb_num ALBARA,
                        alb_cls CLASSE,
                        DECODE (fac_num,
                                NULL, NULL,
                                fac_ser_cod || '\' || fac_num)
                           FACTURA,
                        DECODE (pre_num,
                                NULL, NULL,
                                pre_ser_cod || '\' || pre_num)
                           PRESSUPOST,
                        mtr_cod VEHICLE,
                        0 KM,
                        frhu_sec_ope (ale_idf_cod,
                                      ale_ope_cod,
                                      'C',
                                      alb_dia)
                           SECCIO,
                        frhu_sec_ope (ale_idf_cod,
                                      ale_ope_cod,
                                      'D',
                                      alb_dia)
                           NOMSECCIO,
                        FRHU_RDIREG (ale_idf_cod, ale_ope_cod, alb_dia) REGIMEN,
                        pre_ser_cod,
                        pre_num,
                        pre_ver,
                        alb_ser_cod,
                        alb_num,
                        fac_ser_cod,
                        fac_num,
                        fac_cer_num,
                        pre_cod,
                        alb_numdoc,
                        alb_prj_num AS projecte
                 FROM   tges_ale,
                        tges_alb,
                        tges_cli,
                        tges_pre,
                        tges_mtr,
                        trhu_ope,
                        tges_fac
                WHERE       alb_idf_cod = ale_idf_cod
                        AND alb_emp_cod = ale_emp_cod
                        AND alb_numdoc = ale_alb_numdoc
                        AND cli_idf_cod = alb_idf_cod
                        AND cli_cod = alb_cli_cod
                        AND pre_idf_cod(+) = ale_idf_cod
                        AND pre_emp_cod(+) = ale_emp_cod
                        AND pre_cod(+) = ale_pre_cod
                        AND mtr_idf_cod(+) = ale_idf_cod
                        AND mtr_tra_cod(+) = ale_tra_cod
                        AND mtr_cod(+) = ale_mtr_cod
                        AND fac_idf_cod(+) = alb_idf_cod
                        AND fac_emp_cod(+) = alb_emp_cod
                        AND fac_ser_cod(+) = alb_ser_codfac
                        AND fac_cls(+) = alb_fac_cls
                        AND fac_num(+) = alb_fac_num
                        AND ale_ope_cod = ope_cod
                        AND ale_idf_cod = ope_idf_cod
                        AND ROUND (
                              NVL (ale_hortem, 0) + (NVL (ale_mintem, 0) / 60),
                              2
                           ) <> 0)
   ORDER BY   DATA, ALBARA, CODIOPERARI;


CREATE OR REPLACE FORCE VIEW VRHU_COSOPEPNO
AS 
SELECT pno_idf_cod, pno_emp_cod, pno_cod, pno_fecini, pno_fecfin, pno_any, pno_mes, 
pno_nom, nmn_ope_cod,nmn_div_cod, nmn_valdiveur, nmn_hortot, nmn_cos001, nmn_cos002, 
sum(decode(nvl(cof_tipuni,0),1, 0, 
decode(nvl(cof_uni,'.'),frhu_parametre(pno_idf_cod,'COFUNIHOR'),0, nvl(lff_imp,0)))) as nmn_cos003 
from ( 
select pno_idf_cod,pno_emp_cod,pno_cod,pno_fecini,pno_fecfin, 
to_char(pno_fecfin,'YYYY') as pno_any, to_char(pno_fecfin,'MM') as pno_mes, 
pno_nom,nmn_ope_cod, nmn_div_cod, nmn_valdiveur, nvl(nmn_hortot,0) as nmn_hortot, 
(nvl(nmn_quamen,0) + nvl(nmn_cosssemp,0) - nvl(nmn_bnf,0) + nvl(nmn_prrpagext,0) ) as nmn_cos001, 
sum(nvl(lnm_imp002,0)) as nmn_cos002 
from trhu_pno, trhu_nmn, trhu_lnm 
where pno_idf_cod = nmn_idf_cod and pno_emp_cod = nmn_emp_cod and pno_cod = nmn_pno_cod 
and lnm_idf_cod(+) = nmn_idf_cod and lnm_emp_cod(+) = nmn_emp_cod and lnm_pno_cod(+) = nmn_pno_cod and lnm_ope_cod(+) = nmn_ope_cod 
and lnm_cnm_cod <> frhu_parametre(pno_idf_cod,'COR_ANC_CNM') 
group by 
pno_idf_cod,pno_emp_cod,pno_cod,pno_fecini,pno_fecfin, 
pno_nom,nmn_ope_cod,nmn_div_cod, nmn_valdiveur, nmn_hortot,nmn_quamen, nmn_ss, nmn_basirp, nmn_cosssemp,nmn_bnf,nmn_prrpagext 
),trhu_ffo, trhu_lff, trhu_cof 
where ffo_idf_cod(+) = pno_idf_cod and ffo_ope_cod(+) = nmn_ope_cod and 
 nvl(ffo_cln_dat, pno_fecini) between pno_fecini and pno_fecfin and 
 lff_idf_cod(+) = ffo_idf_cod and lff_ffo_cod(+) = ffo_cod and nvl(lff_emp_cod,pno_emp_cod) = pno_emp_cod 
and cof_idf_cod(+) = lff_idf_cod and cof_cod(+) = lff_cof_cod 
group by pno_idf_cod,pno_emp_cod,pno_cod,pno_fecini,pno_fecfin, pno_any, pno_mes, 
pno_nom,nmn_ope_cod, nmn_div_cod,nmn_valdiveur, nmn_hortot, nmn_cos001, nmn_cos002;


CREATE OR REPLACE FORCE VIEW VRHU_COSOPEPRJ
AS 
(
select 'HO' as tip, ffo_idf_cod, ffo_cod,ffo_ope_cod,ffo_cln_dat, to_char(ffo_cln_dat,'YYYY') as ffo_any,to_char(ffo_cln_dat,'MM') as ffo_mes,
ffo_ref,lff_cof_cod,cof_nom,
lff_emp_cod, lff_prj_num, prj_nom, nvl(prj_div_cod,lff_div_cod) as div_cod,
nvl(lff_hordec,0) as lff_hordec,
fges_canvi_divisa(ffo_idf_cod,lff_pru,lff_div_cod, nvl(prj_div_cod,lff_div_cod)) as lff_pru,
fges_canvi_divisa(ffo_idf_cod,lff_cstuni,lff_div_cod, nvl(prj_div_cod,lff_div_cod) ) as lff_cstuni,
fges_canvi_divisa(ffo_idf_cod,nvl(lff_hordec,0) * nvl(lff_cstuni,0),lff_div_cod, nvl(prj_div_cod,lff_div_cod)  ) as lff_cst --PENSAR EN CANVI DE DIVISA
from trhu_ffo, trhu_lff, trhu_cof, tges_prj
where lff_idf_cod = ffo_idf_cod and lff_ffo_cod = ffo_cod and
cof_idf_cod = lff_idf_cod and cof_cod = lff_cof_cod
and
(
  cof_tipuni = 1 or cof_uni =  ( select  par_val from trhu_par where par_idf_cod = lff_idf_cod and par_cod = 'COFUNIHOR' )
)
and lff_idf_cod = prj_idf_cod(+) and lff_emp_cod = prj_emp_cod(+) and lff_prj_num = prj_num(+)

)
union all

(
select 'NH' as tip, ffo_idf_cod, ffo_cod,ffo_ope_cod,ffo_cln_dat, to_char(ffo_cln_dat,'YYYY') as ffo_any,to_char(ffo_cln_dat,'MM') as ffo_mes,
ffo_ref,lff_cof_cod,cof_nom,
lff_emp_cod, lff_prj_num, prj_nom, nvl(prj_div_cod,lff_div_cod) as div_cod,
nvl(lff_hordec,0) as lff_hordec,
fges_canvi_divisa(ffo_idf_cod,lff_pru,lff_div_cod, nvl(prj_div_cod,lff_div_cod)) as lff_pru,
fges_canvi_divisa(ffo_idf_cod,lff_cstuni,lff_div_cod, nvl(prj_div_cod,lff_div_cod) ) as lff_cstuni,
fges_canvi_divisa( ffo_idf_cod, nvl(lff_hordec,0) * nvl(lff_cstuni,0),lff_div_cod, nvl(prj_div_cod,lff_div_cod) ) as lff_cst --PENSAR EN CANVI DE DIVISA
from trhu_ffo, trhu_lff, trhu_cof, tges_prj
where lff_idf_cod = ffo_idf_cod and lff_ffo_cod = ffo_cod and
cof_idf_cod = lff_idf_cod and cof_cod = lff_cof_cod
and
(
  cof_tipuni = 2 and cof_uni <> ( select  par_val from trhu_par where par_idf_cod = lff_idf_cod and par_cod = 'COFUNIHOR' )
)
and lff_idf_cod = prj_idf_cod(+) and lff_emp_cod = prj_emp_cod(+) and lff_prj_num = prj_num(+)

);


CREATE OR REPLACE FORCE VIEW VRHU_HORDESC
AS 
SELECT   RDI_IDF_COD, 
            RDI_CLN_DAT, 
            RDI_OPE_COD, 
            OPE_NOM, 
            HORTEO, 
            HORVAC, 
            HORBAI, 
            ope_act, 
            ope_hor_cod, 
            HorPms, 
            HORFETTOT, 
            HORFETNET, 
            vps_sec_cod, 
            vps_sec_nom, 
            empctr, 
            /* 
             horteo+DECODE (NVL (OPE_CTLHOE, 'N'), 'N', LEAST (0, frhu_covfchoe (rdi_idf_cod, rdi_ope_cod, cov_cod, HorExtDia, rdi_cln_Dat)), 
       frhu_covfchoe (rdi_idf_cod, rdi_ope_cod, cov_cod, HorExtDia, rdi_cln_Dat)) HORREALS*/ 
            horteo+frhu_covfchoe (rdi_idf_cod, rdi_ope_cod, cov_cod, HorExtDia, rdi_cln_Dat) HORREALS, OPE_CTLHOE, 
            /*DECODE (NVL (OPE_CTLHOE, 'N'), 
                    'N', LEAST (0,*/ frhu_covfchoe (rdi_idf_cod, 
                                                  rdi_ope_cod, 
                                                  cov_cod, 
                                                  HorExtDia, 
                                                  rdi_cln_Dat)/*), 
                    frhu_covfchoe (rdi_idf_cod, 
                                   rdi_ope_cod, 
                                   cov_cod, 
                                   HorExtDia, 
                                   rdi_cln_Dat))*/ 
               HorExtDia, 
            HorextIni 
     FROM   (SELECT   rdi_idf_cod, 
                      rdi_cln_dat, 
                      rdi_ope_cod, 
                      ope_nom, 
                      horteo, 
                      ope_act, 
                      ope_hor_cod, 
                      HorPms, 
                      horvac, 
                      horbai, 
                      horfettot, 
                      horfetnet, 
                      vps_sec_cod, 
                      vps_sec_nom, 
                      empctr, 
                      cov_cod, 
                      OPE_CTLHOE, 
                      GREATEST ( 
                         0, 
                         LEAST ( (horfettot - horfetnet) * 60, MinPerDia) 
                      ) 
                         mindescans                            /*, MinPerDia*/ 
                                   , 
                      /* round(frhu_covfchno (rdi_idf_cod, rdi_ope_cod, cov_cod,*/ 
                      (horfetnet 
                       + (GREATEST ( 
                             0, 
                             LEAST ( (horfettot - horfetnet) * 60, MinPerDia) 
                          ) 
                          / 60))                         /*, rdi_cln_dat),2)*/ 
                         HORREALS, 
                      /* round(frhu_covfchno (rdi_idf_cod, rdi_ope_cod, cov_cod,*/ 
                      (horfetnet 
                       + (GREATEST ( 
                             0, 
                             LEAST ( (horfettot - horfetnet) * 60, MinPerDia) 
                          ) 
                          / 60))                         /*, rdi_cln_dat),2)*/ 
                      - horteo 
                         HorExtDia, 
                      OPE_COSADD HorextIni 
               FROM   (SELECT   rdi_idf_cod, 
                                rdi_cln_dat, 
                                rdi_ope_cod, 
                                ope_nom, 
                                rdi_hornor hornor, 
                                ROUND ( 
                                   DECODE ( 
                                      FRHU_TDIFPE (rdi_idf_Cod, rdi_cln_Dat), 
                                      frhu_parametre (rdi_idf_cod, 
                                                      'REGFES', 
                                                      'F'), 
                                      DECODE ( 
                                         rdi_reg_cod, 
                                         frhu_parametre (rdi_idf_cod, 
                                                         'REGFES', 
                                                         'F'), 
                                         rdi_horteo, 
                                         frhu_parametre (rdi_idf_cod, 
                                                         'REGVAC', 
                                                         'V'), 
                                         decode(FRHU_COVTIPVAC (rdi_idf_cod, vps_emp_cod, FRHU_OPECOV (rdi_idf_cod, rdi_ope_cod)), 'N', rdi_horvac, 0), 
                                         frhu_parametre (rdi_idf_cod, 
                                                         'REGBAI', 
                                                         'B'), 
                                         0, 
                                         FRHU_HrsTeo (rdi_idf_cod, 
                                                      rdi_cln_dat, 
                                                      rdi_hor_cod) 
                                      ), 
                                      rdi_horteo 
                                   ), 
                                   2 
                                ) 
                                   horteo, 
                                ope_hor_cod, 
                                NVL (rdi_horvac, 0) horvac, 
                                DECODE ( 
                                   rdi_reg_cod, 
                                   frhu_parametre (rdi_idf_cod, 
                                                   'REGBAI', 
                                                   'B'), 
                                   FRHU_HrsTeo (rdi_idf_cod, 
                                                rdi_cln_Dat, 
                                                ope_hor_cod), 
                                   0 
                                ) 
                                   horbai, 
                                frhu_tothorsuminr (rdi_idf_cod, 
                                                   rdi_ope_cod, 
                                                   rdi_cln_dat) 
                                   horfettot, 
                                OPE_CTLHOE, 
                                frhu_ctrempdia (rdi_idf_cod, 
                                                rdi_ope_cod, 
                                                rdi_cln_Dat) 
                                   empctr, 
                                NVL ( 
                                   (SELECT   SUM(frhu_difhor (inr_idf_cod, 
                                                              inr_ini, 
                                                              inr_fin)) 
                                      FROM   trhu_inr 
                                     WHERE       inr_idf_cod = rdi_idf_cod 
                                             AND inr_cln_Dat = rdi_cln_Dat 
                                             AND inr_ope_cod = rdi_ope_cod 
                                             AND inr_fin IS NOT NULL), 
                                   0 
                                ) 
                                   horfetnet, 
                                DECODE ( 
                                   frhu_tothorsuminr (rdi_idf_cod, 
                                                      rdi_ope_cod, 
                                                      rdi_cln_dat), 
                                   0, 
                                   0, 
                                   frhu_getcovmindesc ( 
                                      rdi_idf_cod, 
                                      FRHU_OPECOV (rdi_idf_cod, 
                                                   rdi_ope_cod, 
                                                   rdi_cln_dat, 
                                                   rdi_cln_dat) 
                                   ) 
                                ) 
                                   MinPerDia, 
                                vps_sec_cod, 
                                vps_sec_nom, 
                                FRHU_OPECOV (rdi_idf_cod, 
                                             rdi_ope_cod, 
                                             rdi_cln_dat, 
                                             rdi_cln_dat) 
                                   cov_cod, 
                                OPE_COSADD, 
                                ope_act, 
                                NVL ( 
                                   (SELECT   SUM (hol_hor) 
                                      FROM   trhu_hol 
                                     WHERE       hol_idf_cod = rdi_idf_cod 
                                             AND hol_cln_dat = rdi_cln_dat 
                                             AND hol_ope_cod = rdi_ope_cod), 
                                   0 
                                ) 
                                   HorPms 
                         FROM   trhu_rdi, trhu_ope, vrhu_vps 
                        WHERE       ope_idf_cod = rdi_idf_cod 
                                AND ope_cod = rdi_ope_cod 
                                AND vps_idf_cod = rdi_idf_cod 
                                AND vps_emp_cod = 
                                      frhu_ctrempdia (rdi_idf_cod, 
                                                      rdi_ope_cod, 
                                                      rdi_cln_Dat) 
                                AND vps_ope_cod = rdi_ope_cod));


CREATE OR REPLACE FORCE VIEW VRHU_INR
AS 
select INR_IDF_COD, INR_COD, INR_CLN_DAT, INR_OPE_COD, INR_ZON_COD, /*INR_DATCRE, INR_USUCRE,*/
        INR_NOD_NUMENT, INR_NOD_NUMSOR, INR_INI, INR_FIN, INR_USUMOD, INR_DATMOD, INR_OBS,
        INR_DAT, INR_COF_COD, INR_FFO_COD,
        frhu_difhor(inr_idf_cod, inr_ini, inr_fin) as diferencia
   from trhu_inr;


CREATE OR REPLACE FORCE VIEW VRHU_LFF
AS 
SELECT LFF_COF_COD, LFF_FFO_COD, LFF_IDF_COD, LFF_CLI_COD,
          LFF_DIV_COD, LFF_PRU, LFF_DATCRE, LFF_USUCRE, LFF_PDA_COD,
          LFF_CAP_COD, LFF_PRE_COD, LFF_DATMOD, LFF_USUMOD, LFF_HOR,
          LFF_MIN, LFF_HORDEC, LFF_IMP, LFF_DES, LFF_LACNUMDOC,
          LFF_LAC_NUM, LFF_EMP_COD, LFF_SEC_COD, LFF_OBS, LFF_ORI,
          LFF_NUM, LFF_MAQ_COD, LFF_SCL_COD, LFF_AVI_NUM,
          LFF_AGN_MAQ, LFF_AGN_NUM, LFF_RMF_NUM, LFF_FSB_NUM,
          LFF_CSTUNI, LFF_MAQ_CODFEI, LFF_CSTMAQ, LFF_MAQ_CODFEI002,
          LFF_CSTMAQ002, LFF_FOB_NUM, LFF_PRJ_NUM, LFF_ETP_COD,
          LFF_ETP_NUM, LFF_UCE_SEQ, LFF_LES_SEQ, LFF_HORMAQ002,
          LFF_MINMAQ002, LFF_HORDECMAQ002, LFF_HORMAQ, LFF_MINMAQ,
          LFF_HORDECMAQ, LFF_RLE_COD
   FROM   trhu_lff;


CREATE OR REPLACE FORCE VIEW VRHU_LFFCNM
AS 
SELECT ffo_cln_dat, ffo_ope_cod, ope_nom, LFF_COF_COD, cof_nom, LFF_FFO_COD, LFF_IDF_COD, LFF_CLI_COD,
          LFF_DIV_COD, LFF_PRU, LFF_DATCRE, LFF_USUCRE, LFF_PDA_COD, LFF_CAP_COD,
          LFF_PRE_COD, LFF_DATMOD, LFF_USUMOD, LFF_HOR, LFF_MIN, LFF_HORDEC, LFF_IMP,
          LFF_DES, LFF_LACNUMDOC, LFF_LAC_NUM, LFF_EMP_COD, LFF_SEC_COD, LFF_OBS, LFF_ORI,
          LFF_NUM, LFF_MAQ_COD, LFF_SCL_COD, LFF_AVI_NUM, LFF_AGN_MAQ, LFF_AGN_NUM,
          LFF_RMF_NUM, LFF_FSB_NUM, LFF_CSTUNI, LFF_MAQ_CODFEI, LFF_CSTMAQ, LFF_MAQ_CODFEI002,
          LFF_CSTMAQ002, LFF_FOB_NUM, LFF_PRJ_NUM, prj_nom, LFF_ETP_COD, LFF_ETP_NUM, LFF_UCE_SEQ,
          LFF_LES_SEQ, LFF_HORMAQ002, LFF_MINMAQ002, LFF_HORDECMAQ002, LFF_HORMAQ, LFF_MINMAQ,
          LFF_HORDECMAQ, LFF_RLE_COD, cnm_cod, CNM_NOM, VPS_EMP_COD, VPS_SEC_COD, VPS_SEC_NOM, OPE_NIF, FFO_REF
   FROM  trhu_ffo, trhu_ope, trhu_lff, trhu_cof, trhu_cnm, vrhu_vps, tges_cli, tges_prj
   where ffo_idf_cod = lff_idf_cod and ffo_cod = lff_ffo_cod and vps_idf_cod = ffo_idf_cod
   and cli_idf_cod = lff_idf_cod and cli_cod = lff_cli_cod
   and ope_idf_cod = ffo_idf_cod and ope_cod = ffo_ope_cod
   and prj_idf_cod = lff_idf_cod and prj_emp_cod = lff_emp_cod and prj_num = lff_prj_num
   and vps_ope_cod = ffo_ope_cod and cof_idf_cod = lff_idf_cod and cof_cod = lff_cof_cod
   and cnm_idf_cod = cof_idf_cod and cnm_cod = cof_cnm_cod;


CREATE OR REPLACE FORCE VIEW VRHU_LSTRESLFF
AS 
select FFO_IDF_COD IDF, lff_emp_cod EMP, FFO_CLN_DAT FECHA, FFO_OPE_COD OPERARIO, OPE_NOM NOMBRE, PRJ_NUM PROJECTO, PRJ_NOM NOMPROJECTE, COF_COD CONCEPTO, 
         LFF_HORDEC HORAS, HORESEXTRA HORASEXTRA, PRUHOREXT, round(HORESEXTRA * PRUHOREXT,2) Importe 
  from ( 
  SELECT ffo_idf_cod, ffo_cln_dat, ffo_ope_cod, ope_nom, prj_num, prj_nom, lff_cof_cod cof_cod, lff_emp_cod, 
  lff_hordec, 
  DECODE ( (SELECT MAX (lff_ffo_cod) || MAX (l1.lff_num) 
            FROM trhu_lff l1 
            WHERE l1.lff_idf_cod = ffo_idf_cod 
                  AND l1.lff_ffo_cod = 
                      (SELECT  MAX (f2.ffo_cod) 
                       FROM  trhu_ffo f2 
                       WHERE  f2.ffo_idf_cod = f.ffo_idf_cod 
                       AND f2.ffo_ope_cod = f.ffo_ope_cod 
                       AND f2.ffo_cln_dat = f.ffo_cln_dat)), lff_ffo_cod || lff_num, rdi_horext, 0) HoresExtra, 
                       frhu_pruhorext(ffo_idf_cod, ffo_ope_cod, ffo_cln_dat,0) PruHorExt 
    FROM   trhu_lff, trhu_ffo f, tges_prj, trhu_ope, trhu_rdi 
   WHERE   lff_idf_cod = ffo_idf_cod AND lff_ffo_cod = ffo_cod 
           AND prj_idf_cod(+) = lff_idf_cod AND prj_emp_cod(+) = lff_emp_cod AND prj_num(+) = lff_prj_num 
           AND ope_idf_cod = ffo_idf_cod AND ope_cod = ffo_ope_cod AND rdi_idf_cod = ffo_idf_cod 
           AND rdi_cln_dat = ffo_cln_dat AND rdi_ope_cod = ffo_ope_cod 
);


CREATE OR REPLACE FORCE VIEW VRHU_OPE
AS 
SELECT   ope.ope_idf_cod Identificador,
            ope.ope_cod Codigo,
            ope.ope_cod C�digo,
            ope.ope_nom Nombre,
            ope.ope_act Activo,
            ope.ope_entsor EntradaSalida,
            ope.ope_cml Comercial,
            ope.ope_hor_cod HorarioNormal,
            ope.ope_tor ListadoTurnos,
            ope.ope_pin Pin,
            ope.ope_dom Domicilio,
            ope.ope_cpo CodPostal,
            ope.ope_pob Poblacion,
            ope.ope_pob Poblaci�n,
            ope.ope_tel Telefono,
            ope.ope_tel AS TEL�FONO,
            ope.ope_nss NumSegSocial,
            ope.ope_mtr Matricula, ope.ope_mtr as matr�cula,
            ope.ope_datnai FechaNacimiento,
            DECODE (ope.ope_estciv,
                    'C', 'Casado',
                    'D', 'Divorciado',
                    'V', 'Viudo',
                    'S', 'Soltero',
                    'Otros')
               EstadoCivil,
            ope.ope_fil NumHijos,
            ope.ope_nompae NombrePadre,
            ope.ope_nommae NombreMadre,
            ope.ope_llcnai LugarNacimiento,
            ope.ope_dat FechaAlta,
            ope.ope_nif Nif,
            ope.ope_horvac HorasVacaciones,
            ope.ope_nmn1 Nomina1,
            ope.ope_nmn2 Nomina2,
            ope.ope_pruextdls PrecioExtraLunes,
            ope.ope_pruextdms PrecioExtraMartes,
            ope.ope_pruextdcs PrecioExtraMiercoles,
            ope.ope_pruextdjs PrecioExtraJueves,
            ope.ope_pruextdvs PrecioExtraViernes,
            ope.ope_pruextdse PrecioExtraSabado,
            ope.ope_pruextdme PrecioExtraDomingo,
            ope.ope_pruhornor PrecioHoraNormal,
            ope.ope_hor_cod002 HorarioDescanso,
            ope.ope_hor_codnit HorarioNocturno,
            ope.ope_prunitdls PrecioHocheLunes,
            ope.ope_prunitdms PrecioNocheMartes,
            ope.ope_prunitdcs PrecioNocheMiercoles,
            ope.ope_prunitdjs PrecioHocheJueves,
            ope.ope_prunitdvs PrecioNocheViernes,
            ope.ope_prunitdse PrecioNocheSabado,
            ope.ope_prunitdme PrecioHocheDomingo,
            ope.ope_dcc DigitoControl,
            ope.ope_ccr NumCuenta,
            ope.ope_ofb Oficina,
            ope.ope_ban Banco,
            ope.ope_enc Encargado,
            emp.emp_cod CodigoEmpresa,
            emp.emp_cod c�digoempresa,
            emp.emp_nom Empresa,
            ctr.ctr_datini InicioContrato,
            ctr.ctr_datfin FinContrato,
            DECODE (ctr.ctr_solbai, 'O', 'Operario', 'Empresa') SolicitaBaja,
            ctr.ctr_datsolbai SolicitudBaja,
            ctr.ctr_datbai FechaBaja,
            ctr.ctr_horvac HorasVacacionesContrato,
            ctr.ctr_tct_cod CodigoTipoContrato, ctr.ctr_tct_cod as c�digotipocontrato,
            tct.tct_nom TipoContrato,
            ctr_prj_num ObraContrato,
            prj_nom NombreObra,
            cat.cat_cod CodigoCategoria,
            cat.cat_cod CodigoCategor�a,
            cat.cat_nom Categoria,
            cat.cat_nom Categor�a,
            sct.sct_cod CodigoSubcategoria,
            sct.sct_cod C�digoSubcategoria,
            sct.sct_nom Subcategoria,
            sct.sct_nom AS subcategor�a,
            pca.pca_datini InicioCategoria, pca.pca_datini as iniciocategor�a,
            pca.pca_datfin FinCategoria, pca.pca_datfin as fincategor�a,
            ope.ope_ope_cod REPONSABLECOD,
            OPE2.OPE_NOM RESPONSABLENOMBRE,
            vps_sec_cod Seccion,
            vps_sec_nom NombreSeccion,
            vps_ctlffo ControlHojasTrab,
            ope.ope_diapjb DiaPrejubilacion,
            vps_gse_cod GrupoSeccion,
            gse_nom NombreGrupoSeccion,
            cat_cov_cod ConvenioCategoria,
            cov_nom NomConvenioCategoria,
            FRHU_OPECOV (ope.ope_idf_cod,
                         ope.ope_cod,
                         ctr.ctr_datini,
                         NVL (ctr.ctr_datbai, NVL (ctr.ctr_datfin, SYSDATE)),
                         NULL)
               ConvenioOperario,
            FRHU_OPECOV (ope.ope_idf_cod,
                         ope.ope_cod,
                         ctr.ctr_datini,
                         NVL (ctr.ctr_datbai, NVL (ctr.ctr_datfin, SYSDATE)),
                         NULL,
                         'D')
               NombreConvenioOperario,
            ope.OPE_MNS PerCenMinusvalia,
            DECODE (ope.ope_sex,
                    'M',
                    'Masculino',
                    'F',
                    'Femenino')
               Sexo,
            rvm_dat FecUltRevision,
            rvm_trm_cod CodigoTipoResultado,
            trm_Des DescripTipoResultado,
            rvm_obs ObservResultado,
            OPE.OPE_DERDIE DerechoDietas,
            OPE.OPE_HORRUT DerechoHCamino
     FROM   trhu_cat cat,
            trhu_ctr ctr,
            trhu_emp emp,
            trhu_ope ope,
            trhu_pca pca,
            trhu_sct sct,
            trhu_tct tct,
            trhu_ope ope2,
            vrhu_vps v,
            tges_prj prj,
            trhu_gse,
            trhu_cov,
            trhu_rvm,
            trhu_trm
    WHERE       emp.emp_cod = ctr.ctr_emp_cod
            AND ope.ope_idf_cod = ope2.ope_idf_cod(+)
            AND ope.ope_ope_cod = ope2.ope_cod(+)
            AND emp.emp_idf_cod = ctr.ctr_idf_cod
            AND ope.ope_cod = ctr.ctr_ope_cod
            AND ope.ope_idf_cod = ctr.ctr_idf_cod
            AND ope.ope_cod = pca.pca_ope_cod
            AND ope.ope_idf_cod = pca.pca_idf_cod
            AND cat.cat_cod = sct.sct_cat_cod
            AND cat.cat_idf_cod = sct.sct_idf_cod
            AND sct.sct_cod = pca.pca_sct_cod
            AND sct.sct_cat_cod = pca.pca_cat_cod
            AND sct.sct_idf_cod = pca.pca_idf_cod
            AND tct.tct_cod = ctr.ctr_tct_cod
            AND tct.tct_idf_cod = ctr.ctr_idf_cod
            AND cat.cat_idf_cod = cov_idf_cod(+)
            AND cat.cat_cov_cod = cov_cod(+)
            AND pca_datini =
                  (SELECT   MAX (pca_datini)
                     FROM   trhu_pca pca2
                    WHERE   pca2.pca_ope_cod = ope.ope_cod
                            AND pca2.pca_idf_cod = pca.pca_idf_cod)
            AND ctr_datini =
                  (SELECT   MAX (ctr_datini)
                     FROM   trhu_ctr ctr2
                    WHERE       ctr2.ctr_idf_cod = ctr.ctr_idf_cod
                            AND ctr2.ctr_emp_cod = ctr.ctr_emp_cod
                            AND ctr2.ctr_ope_cod = ctr.ctr_ope_cod)
            AND prj.prj_idf_cod(+) = ctr.ctr_idf_cod
            AND prj.prj_emp_cod(+) = ctr.ctr_emp_cod
            AND prj.prj_num(+) = ctr.ctr_prj_num
            AND vps_idf_cod = ctr.ctr_idf_cod
            AND vps_emp_cod = ctr.ctr_emp_cod
            AND vps_ope_cod = ctr.ctr_ope_cod
            AND gse_idf_cod(+) = vps_idf_cod
            AND gse_emp_cod(+) = vps_emp_cod
            AND gse_cod(+) = vps_gse_cod
            AND rvm_idf_cod(+) = ope.ope_idf_cod
            AND rvm_ope_cod(+) = ope.ope_cod
            AND ( (rvm_dat IS NULL)
                 OR (rvm_dat IS NOT NULL
                     AND rvm_dat =
                           (SELECT   MAX (rvm_dat)
                              FROM   trhu_rvm r
                             WHERE   r.rvm_idf_cod = ope.ope_idf_cod
                                     AND r.rvm_ope_cod = ope.ope_cod)))
            AND trm_idf_cod(+) = rvm_idf_cod
            AND trm_cod(+) = rvm_trm_cod;


CREATE OR REPLACE FORCE VIEW VRHU_OPECTR
AS 
SELECT ope.ope_idf_cod  Identificador, ope.ope_cod  C�digo, ope.ope_nom  Nombre,
       ope.ope_act  Activo, ope.ope_entsor  EntradaSalida, ope.ope_cml  Comercial,
       ope.ope_hor_cod HorarioNormal, ope.ope_tor  ListadoTurnos, ope.ope_pin  Pin,
       ope.ope_dom Domicilio, ope.ope_cpo CodPostal, ope.ope_pob Poblaci�n,
       ope.ope_tel Tel�fono, ope.ope_nss  NumSegSocial , ope.ope_mtr Matr�cula,
       ope.ope_datnai  FechaNacimiento ,
       decode (ope.ope_estciv, 'C', 'Casado', 'D', 'Divorciado', 'V', 'Viudo', 'S', 'Soltero', 'Otros')  EstadoCivil ,
       ope.ope_fil  NumHijos , ope.ope_nompae  NombrePadre , ope.ope_nommae  NombreMadre,
       ope.ope_llcnai  LugarNacimiento, ope.ope_dat  FechaAlta , ope.ope_nif  Nif , ope.ope_horvac  HorasVacaciones,
       ope.ope_nmn1  Nomina1 , ope.ope_nmn2  Nomina2 , ope.ope_pruextdls  PrecioExtraLunes,
       ope.ope_pruextdms  PrecioExtraMartes , ope.ope_pruextdcs  PrecioExtraMi�rcoles,
       ope.ope_pruextdjs   PrecioExtraJueves ,        ope.ope_pruextdvs  PrecioExtraViernes , ope.ope_pruextdse   PrecioExtraS�bado, ope.ope_pruextdme   PrecioExtraDomingo ,
       ope.ope_pruhornor  PrecioHoraNormal , ope.ope_hor_cod002  HorarioDescanso, ope.ope_hor_codnit  HorarioNocturno ,
       ope.ope_prunitdls  PrecioHocheLunes , ope.ope_prunitdms  PrecioNocheMartes, ope.ope_prunitdcs  PrecioNocheMi�rcoles ,
       ope.ope_prunitdjs  PrecioHocheJueves , ope.ope_prunitdvs  PrecioNocheViernes, ope.ope_prunitdse  PrecioNocheS�bado ,
       ope.ope_prunitdme  PrecioHocheDomingo , ope.ope_dcc  DigitoControl, ope.ope_ccr  NumCuenta, ope.ope_ofb Oficina , ope.ope_ban Banco ,
       ope.ope_enc  Encargado , emp.emp_cod  C�digoEmpresa , emp.emp_nom  Empresa ,
       ctr.ctr_datini  InicioContrato , ctr.ctr_datfin  FinContrato , decode(ctr.ctr_solbai, 'O', 'Operario', 'Empresa')  SolicitaBaja ,
       ctr.ctr_datsolbai  SolicitudBaja , ctr.ctr_datbai  FechaBaja ,
       ctr.ctr_horvac  HorasVacacionesContrato , ctr.ctr_tct_cod  C�digoTipoContrato , tct.tct_nom  TipoContrato ,
       cat.cat_cod  CodigoCategoria , cat.cat_nom  Categor�a , sct.sct_cod  C�digoSubcategoria , sct.sct_nom  Subcategor�a,
       pca.pca_datini  InicioCategor�a , pca.pca_datfin  FinCategor�a, ope.ope_ope_cod REPONSABLECOD, OPE2.OPE_NOM RESPONSABLENOMBRE,
       vps_sec_cod Seccion, vps_sec_nom NombreSeccion, vps_ctlffo ControlHojasTrab
 FROM trhu_cat cat, trhu_ctr ctr, trhu_emp emp,
 trhu_ope ope, trhu_pca pca, trhu_sct sct,
 trhu_tct tct, trhu_ope ope2, vrhu_vps v
 WHERE  emp.emp_cod = ctr.ctr_emp_cod
        and ope.ope_idf_cod = ope2.ope_idf_cod(+)
        and ope.ope_ope_cod = ope2.ope_cod(+)
        AND emp.emp_idf_cod = ctr.ctr_idf_cod
        AND ope.ope_cod = ctr.ctr_ope_cod
        AND ope.ope_idf_cod = ctr.ctr_idf_cod
        AND ope.ope_cod = pca.pca_ope_cod
        AND ope.ope_idf_cod = pca.pca_idf_cod
        AND cat.cat_cod = sct.sct_cat_cod
        AND cat.cat_idf_cod = sct.sct_idf_cod
        AND sct.sct_cod = pca.pca_sct_cod
        AND sct.sct_cat_cod = pca.pca_cat_cod
        AND sct.sct_idf_cod = pca.pca_idf_cod
        AND tct.tct_cod = ctr.ctr_tct_cod
        AND tct.tct_idf_cod = ctr.ctr_idf_cod
        and pca_datini = (select max(pca_datini)
                           from trhu_pca pca2
                           where pca2.pca_ope_cod = ope.ope_cod
                           and pca2.pca_idf_cod = pca.pca_idf_cod)
        and ctr_datini = (select max(ctr_datini)
                          from trhu_ctr ctr2
                          where ctr2.ctr_idf_cod = ctr.ctr_idf_cod
                          and ctr2.ctr_emp_cod = ctr.ctr_emp_cod
                          and ctr2.ctr_ope_cod = ctr.ctr_ope_cod)
       and vps_idf_cod = ctr.ctr_idf_cod
       and vps_emp_cod = ctr.ctr_emp_cod
       and vps_ope_cod = ctr.ctr_ope_cod;


CREATE OR REPLACE FORCE VIEW VRHU_OPEOBS
AS 
select ope_idf_cod Identificador, ope_cod CodiOperario, ope_nom NomOperario,
vps_emp_cod Empresa, vps_sec_cod CodiSeccion, vps_sec_nom NomSeccion,
pca_sct_cod CodiSubcategoria, sct_nom NomSubcategoria, ope_act OperarioActivo,
obo_ref RefObserv, obo_obs Observaciones
from trhu_ope, vrhu_vps, vrhu_cat, trhu_obo
where ope_idf_cod = vps_idf_cod
  and ope_cod     = vps_ope_cod
  and ope_idf_cod = pca_idf_cod
  and ope_cod     = pca_ope_cod
  and ope_idf_cod = obo_idf_cod
  and ope_cod     = obo_ope_cod
  and fgus_te_role('VISTAOPEOBS') = 'S'
order by ope_idf_cod, ope_cod;


CREATE OR REPLACE FORCE VIEW VRHU_OPEPRUVAC
AS 
SELECT   IDENTIFICADOR, 
            codigo AS CODIGO, 
            NOMBRE, 
            ACTIVO, 
            ENTRADASALIDA, 
            COMERCIAL, 
            HORARIONORMAL, 
            LISTADOTURNOS, 
            PIN, 
            DOMICILIO, 
            CODPOSTAL, 
            poblacion AS POBLACION, 
            telefono AS TELEFONO, 
            NUMSEGSOCIAL, 
            matricula AS MATRICULA, 
            FECHANACIMIENTO, 
            ESTADOCIVIL, 
            NUMHIJOS, 
            NOMBREPADRE, 
            NOMBREMADRE, 
            LUGARNACIMIENTO, 
            FECHAALTA, 
            NIF, 
            NOMINA1, 
            NOMINA2, 
            DIGITOCONTROL, 
            NUMCUENTA, 
            OFICINA, 
            BANCO, 
            ENCARGADO, 
            codigoempresa AS CODIGOEMPRESA, 
            EMPRESA, 
            INICIOCONTRATO, 
            FINCONTRATO, 
            SOLICITABAJA, 
            SOLICITUDBAJA, 
            FECHABAJA, 
            HORASVACACIONESCONTRATO, 
            codigotipocontrato AS CODIGOTIPOCONTRATO, 
            TIPOCONTRATO, 
            CODIGOCATEGORIA, 
            categoria AS CATEGORIA, 
            codigosubcategoria AS CODIGOSUBCATEGORIA, 
            subcategoria AS SUBCATEGORIA, 
            iniciocategoria AS INICIOCATEGORIA, 
            fincategoria AS FINCATEGORIA, 
            REPONSABLECOD, 
            RESPONSABLENOMBRE, 
            SECCION, 
            NOMBRESECCION, 
            CONTROLHOJASTRAB, 
            (SELECT   pcn_imp 
               FROM   trhu_pcn 
              WHERE       pcn_idf_cod = identificador 
                      AND pcn_cat_cod = codigocategoria 
                      AND pcn_sct_cod = codigosubcategoria 
                      AND pcn_cnm_cod = '0005') 
               AS preu_horext, 
            (SELECT   pfc_pru 
               FROM   trhu_pfc 
              WHERE       pfc_idf_cod = identificador 
                      AND pfc_cat_cod = codigocategoria 
                      AND pfc_sct_cod = codigosubcategoria 
                      AND pfc_cof_cod = 'HC') 
               AS preu_horescami, 
            (SELECT   pfc_pru 
               FROM   trhu_pfc 
              WHERE       pfc_idf_cod = identificador 
                      AND pfc_cat_cod = codigocategoria 
                      AND pfc_sct_cod = codigosubcategoria 
                      AND pfc_cof_cod = 'HE') 
               AS preu_horesesp, 
            (SELECT   pfc_pru 
               FROM   trhu_pfc 
              WHERE       pfc_idf_cod = identificador 
                      AND pfc_cat_cod = codigocategoria 
                      AND pfc_sct_cod = codigosubcategoria 
                      AND pfc_cof_cod = 'HD') 
               AS preu_horesdiumenge, 
            (SELECT   pfc_pru 
               FROM   trhu_pfc 
              WHERE       pfc_idf_cod = identificador 
                      AND pfc_cat_cod = codigocategoria 
                      AND pfc_sct_cod = codigosubcategoria 
                      AND pfc_cof_cod = 'HS') 
               AS preu_horesdissabte, 
            han_hdianu AS horasvacaciones, 
            han_hdiant - NVL (han_hldant, 0) AS horasvacacionesAnteriores, 
            NVL (han_hldant, 0) HorasLibDispAnteriores, 
            (select hli_horant 
             from trhu_hli where hli_idf_cod = identificador 
             and hli_ope_cod = codigo 
             and hli_anl_cod = han_anl_cod ) HorasLibAnteriores, 
            frhu_horredvacere (identificador, 
                               codigo, 
                               frhu_anl (identificador, SYSDATE)) 
               HorasRedVacEre, 
            han_hdianu + han_hdiant 
            - frhu_horredvacere (identificador, 
                                 codigo, 
                                 frhu_anl (identificador, SYSDATE)) 
               HorasVacacionestotales, 
            NVL ( 
               FRHU_HORCON ( 
                  codigo, 
                  identificador, 
                  TRUNC (SYSDATE, 'DD'), 
                  flim_avalua_char('select anl_cod from trhu_anl where anl_idf_cod = ''' 
                                   || identificador 
                                   || ''' and anl_datini <= trunc(sysdate,''DD'') and anl_datfin >= trunc(sysdate,''DD'')') 
               ), 
               0 
            ) 
               AS HConsumides, 
            NVL ( 
               FRHU_HORPLN ( 
                  codigo, 
                  identificador, 
                  TRUNC (SYSDATE, 'DD'), 
                  flim_avalua_char('select anl_cod from trhu_anl where anl_idf_cod = ''' 
                                   || identificador 
                                   || ''' and anl_datini <= trunc(sysdate,''DD'') and anl_datfin >= trunc(sysdate,''DD'')') 
               ), 
               0 
            ) 
               AS HPlanificadas, 
            NVL ( 
               FRHU_HORDIS ( 
                  codigo, 
                  identificador, 
                  TRUNC (SYSDATE, 'DD'), 
                  flim_avalua_char('select anl_cod from trhu_anl where anl_idf_cod = ''' 
                                   || identificador 
                                   || ''' and anl_datini <= trunc(sysdate,''DD'') and anl_datfin >= trunc(sysdate,''DD'')') 
               ), 
               0 
            ) 
               AS HDisponibles, 
            NVL ( 
               FRHU_HORHOY ( 
                  codigo, 
                  identificador, 
                  TRUNC (SYSDATE, 'DD'), 
                  flim_avalua_char('select anl_cod from trhu_anl where anl_idf_cod = ''' 
                                   || identificador 
                                   || ''' and anl_datini <= trunc(sysdate,''DD'') and anl_datfin >= trunc(sysdate,''DD'')') 
               ), 
               0 
            ) 
               AS HDisponiblesHoy, 
            NVL ( 
               FRHU_HORLIQ2 ( 
                  codigo, 
                  identificador, 
                  TRUNC (SYSDATE, 'DD'), 
                  flim_avalua_char('select anl_cod from trhu_anl where anl_idf_cod = ''' 
                                   || identificador 
                                   || ''' and anl_datini <= trunc(sysdate,''DD'') and anl_datfin >= trunc(sysdate,''DD'')') 
               ), 
               0 
            ) 
               AS HLiquidadas, 
            frhu_calchorset (identificador, codigo, 'h') HorasSemana, 
            frhu_calchorset (identificador, codigo, '%') PercenHorasSemana, 
            (SELECT   SUM(cms_hor001 
                          - CASE 
                               WHEN cms_dia <= SYSDATE THEN cms_hor002 
                               ELSE 0 
                            END 
                          - CASE 
                               WHEN cms_dia <= SYSDATE THEN 0 
                               ELSE cms_hor002 
                            END) 
               FROM   vrhu_cms 
              WHERE   cms_idf_cod = identificador AND cms_ope_cod = codigo) Pendientecompensar, 
            FRHU_HORLIBDISHOY (codigo, IDENTIFICADOR) HorasLibreDispHoy, 
             FRHU_HORLIBDISHOY (codigo, IDENTIFICADOR, to_date('31/12/' ||to_char(sysdate, 'yyyy'), 'dd/mm/yyyy')) HorasLibreDisp 
     FROM   vrhu_ope, trhu_han 
    WHERE   ( (    han_idf_cod = identificador 
               AND han_ope_cod = codigo 
               AND han_anl_cod = frhu_anl (identificador, SYSDATE)) 
             OR han_ope_cod IS NULL);


CREATE TABLE TRHU_ANO
(
  ANO_IDF_COD  VARCHAR2(4 BYTE)                     NULL,
  ANO_COD      NUMBER(10)                           NULL,
  ANO_COR      VARCHAR2(1 BYTE)                     NULL,
  ANO_TAN_COD  VARCHAR2(4 BYTE)                     NULL,
  ANO_DAT      DATE                                 NULL,
  ANO_OPE_COD  VARCHAR2(6 BYTE)                     NULL,
  ANO_ENTTEO   DATE                                 NULL,
  ANO_SORTEO   DATE                                 NULL,
  ANO_OBS      VARCHAR2(1000 BYTE)                  NULL,
  ANO_INR_COD  NUMBER(10)                           NULL,
  ANO_DATCRE   DATE                                 NULL,
  ANO_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ANO_DATMOD   DATE                                 NULL,
  ANO_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE INDEX IRHU_ANO_IDF_FK ON TRHU_ANO
(ANO_IDF_COD)
;


CREATE INDEX IRHU_ANO_INR_FK ON TRHU_ANO
(ANO_INR_COD, ANO_IDF_COD)
;


CREATE INDEX IRHU_ANO_OPE_FK ON TRHU_ANO
(ANO_OPE_COD, ANO_IDF_COD)
;


CREATE INDEX IRHU_ANO_TAN_FK ON TRHU_ANO
(ANO_TAN_COD, ANO_IDF_COD)
;


CREATE UNIQUE INDEX RRHU_ANO_PK ON TRHU_ANO
(ANO_COD, ANO_IDF_COD)
;


CREATE OR REPLACE FORCE VIEW VRHU_CMPCNM
AS 
select idf_cod, emp_cod, 
 FRHU_SEC_OPE (idf_cod, ope_cod, 'C', NULL, emp_cod) vps_sec_cod, 
 FRHU_SEC_OPE (idf_cod, ope_cod, 'D', NULL, emp_cod) vps_sec_nom, 
 ope_cod, ope_nom, cnm_cod, cnm_nom, pno_cod, sum(unids) unidades, 
 round(decode(sum(unids), 0, null, sum(ImportePartes)/sum(unids)), 2) PreuMig, 
 sum(ImportePartes) ImportePartes, sum(ImporteNomina) ImporteNomina 
from ( 
  select /*+first_rows*/ lff_idf_cod idf_cod, lff_emp_cod emp_cod, 
    ffo_ope_cod ope_cod, ope_nom, cnm_cod, cnm_nom, pno_cod, 
    (lff_hordec) unids, round((lff_hordec*lff_pru),2) ImportePartes, 0 ImporteNomina, pno_fecini 
  from VRHU_LFFCNM, trhu_pno 
  where pno_idf_cod = lff_idf_cod and pno_emp_cod = lff_emp_cod 
  and ffo_cln_dat between PNO_FECINI and PNO_FECFIN 
union all 
  select /*+first_rows*/ nmn_idf_cod idf_cod, nmn_emp_cod emp_cod, ope_cod, ope_nom, 
  cnm_cod, cnm_nom, pno_cod, 0 unids, 0 ImportePartes, lnm_imp ImporteNomina, pno_fecini 
  from TRHU_OPE, TRHU_NMN, TRHU_LNM, TRHU_CNM, trhu_pno 
  where lnm_ope_cod(+) = nmn_ope_cod and lnm_pno_cod = nmn_pno_cod 
  AND lnm_emp_cod(+) = nmn_emp_cod and lnm_idf_cod = nmn_idf_cod 
  AND ope_cod = nmn_ope_cod and ope_idf_cod = nmn_idf_cod 
  AND cnm_cod(+) = lnm_cnm_cod and cnm_idf_cod(+) = lnm_idf_cod 
  and pno_idf_cod = nmn_idf_cod and pno_emp_cod = nmn_emp_cod and pno_cod = nmn_pno_cod 
) 
group by idf_cod, emp_cod, ope_cod, ope_nom, cnm_cod, cnm_nom, pno_cod;


ALTER TABLE TRHU_CEN ADD (
  CONSTRAINT RRHU_CEN_PK
 PRIMARY KEY
 (CEN_IDF_COD, CEN_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_COV ADD (
  CONSTRAINT RRHU_COV_PK
 PRIMARY KEY
 (COV_IDF_COD, COV_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CSTOPE ADD (
  CONSTRAINT RRHU_CSTOPE_PK
 PRIMARY KEY
 (CSTOPE_IDF_COD, CSTOPE_EMP_COD, CSTOPE_OPE_COD, CSTOPE_MES, CSTOPE_ANY)
    USING INDEX 
    );

ALTER TABLE TRHU_FFO ADD (
  CONSTRAINT RRHU_FFO_PK
 PRIMARY KEY
 (FFO_COD, FFO_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_IDF ADD (
  CONSTRAINT RRHU_IDF_PK
 PRIMARY KEY
 (IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_IMP_APP ADD (
  CONSTRAINT RRHU_IMPAPP_PK
 PRIMARY KEY
 (IAP_SEQ, IAP_EMP_COD, IAP_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_IMP_BAI ADD (
  CONSTRAINT RRHU_IMP_BAI_PK
 PRIMARY KEY
 (BAI_REF)
    USING INDEX 
    );

ALTER TABLE TRHU_IMP_CCS ADD (
  CONSTRAINT RRHU_IMP_CCS_PK
 PRIMARY KEY
 (CCS_REF)
    USING INDEX 
    );

ALTER TABLE TRHU_IMP_OPE ADD (
  CONSTRAINT RRHU_IMP_OPE_PK
 PRIMARY KEY
 (OPE_REF)
    USING INDEX 
    );

ALTER TABLE TRHU_IMP_VAC ADD (
  CONSTRAINT RRHU_IMP_VAC_PK
 PRIMARY KEY
 (VAC_REF)
    USING INDEX 
    );

ALTER TABLE TRHU_OPD ADD (
  CONSTRAINT RRHU_OPD_PK
 PRIMARY KEY
 (OPD_IDF_COD, OPD_OPE_COD, OPD_SEQ)
    USING INDEX 
    );

ALTER TABLE TRHU_OPP ADD (
  CONSTRAINT RRHU_OPP_PK
 PRIMARY KEY
 (OPP_IDF_COD, OPP_OPE_COD, OPP_SEQ)
    USING INDEX 
    );

ALTER TABLE TRHU_OPR ADD (
  CONSTRAINT RRHU_OPR_PK
 PRIMARY KEY
 (OPR_IDF_COD, OPR_OPE_COD, OPR_SEQ)
    USING INDEX 
    );

ALTER TABLE TRHU_OPX ADD (
  PRIMARY KEY
 (OPX_IDF_COD, OPX_EMP_COD, OPX_EXT_NUM, OPX_OPE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PAR ADD (
  CONSTRAINT RRHU_PAR_PK
 PRIMARY KEY
 (PAR_COD, PAR_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PLT ADD (
  CONSTRAINT RRHU_PLT_PK
 PRIMARY KEY
 (PLT_IDF_COD, PLT_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_REG ADD (
  CONSTRAINT RRHU_REG_PK
 PRIMARY KEY
 (REG_IDF_COD, REG_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_SNO ADD (
  CONSTRAINT RRHU_SNO_PK
 PRIMARY KEY
 (SNO_COD, SNO_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TAM ADD (
  CONSTRAINT RRHU_TAM_PK
 PRIMARY KEY
 (TAM_IDF_COD, TAM_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TAN ADD (
  CONSTRAINT RRHU_TAN_PK
 PRIMARY KEY
 (TAN_COD, TAN_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TBA ADD (
  CONSTRAINT RRHU_TBA_PK
 PRIMARY KEY
 (TBA_COD, TBA_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TCA ADD (
  CONSTRAINT RRHU_TCA_PK
 PRIMARY KEY
 (TCA_IDF_COD, TCA_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TCI ADD (
  CONSTRAINT RRHU_TCI_PK
 PRIMARY KEY
 (TCI_IDF_COD, TCI_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TCN ADD (
  CONSTRAINT RRHU_TCN_PK
 PRIMARY KEY
 (TCN_COD, TCN_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TCT ADD (
  CONSTRAINT RRHU_TCT_PK
 PRIMARY KEY
 (TCT_COD, TCT_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TDI ADD (
  CONSTRAINT RRHU_TDI_PK
 PRIMARY KEY
 (TDI_COD, TDI_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TDS ADD (
  CONSTRAINT RRHU_TDS_PK
 PRIMARY KEY
 (TDS_IDF_COD, TDS_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TFE ADD (
  CONSTRAINT RRHU_TFE_PK
 PRIMARY KEY
 (TFE_IDF_COD, TFE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TIC ADD (
  CONSTRAINT RRHU_TIC_PK
 PRIMARY KEY
 (TIC_IDF_COD, TIC_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TMO ADD (
  CONSTRAINT RRHU_TMO_PK
 PRIMARY KEY
 (TMO_IDF_COD, TMO_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TMP_LFF ADD (
  CONSTRAINT RRHU_TMPLFF_PK
 PRIMARY KEY
 (LFF_IDF_COD, LFF_FFO_COD, LFF_NUM));

ALTER TABLE TRHU_TOR ADD (
  CONSTRAINT RRHU_TOR_PK
 PRIMARY KEY
 (TOR_IDF_COD, TOR_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TRM ADD (
  CONSTRAINT RRHU_TRM_PK
 PRIMARY KEY
 (TRM_IDF_COD, TRM_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TTR ADD (
  CONSTRAINT RRHU_TTR_PK
 PRIMARY KEY
 (TTR_COD, TTR_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_VAD ADD (
  CONSTRAINT RRHU_VAD_PK
 PRIMARY KEY
 (VAD_IDF_COD, VAD_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_ZON ADD (
  CONSTRAINT RRHU_ZON_PK
 PRIMARY KEY
 (ZON_IDF_COD, ZON_COD)
    USING INDEX 
    );

ALTER TABLE TRMA_CMB002 ADD (
  CONSTRAINT RRMA_CMB002_PK
 PRIMARY KEY
 (CMB_IDF_COD, CMB_REF)
    USING INDEX 
    );

ALTER TABLE TRHU_ANL ADD (
  CONSTRAINT RRHU_ANL_PK
 PRIMARY KEY
 (ANL_IDF_COD, ANL_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CAT ADD (
  CONSTRAINT RRHU_CAT_PK
 PRIMARY KEY
 (CAT_COD, CAT_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CIN ADD (
  CONSTRAINT RRHU_CIN_PK
 PRIMARY KEY
 (CIN_IDF_COD, CIN_NUM)
    USING INDEX 
    ,
  CONSTRAINT RRHU_CIN_UK
 UNIQUE (CIN_IDF_COD, CIN_ANY, CIN_MES, CIN_TCI_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CLN ADD (
  CONSTRAINT RRHU_CLN_PK
 PRIMARY KEY
 (CLN_DAT, CLN_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CNM ADD (
  CONSTRAINT RRHU_CNM_PK
 PRIMARY KEY
 (CNM_COD, CNM_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CNT ADD (
  CONSTRAINT RRHU_CNT_PK
 PRIMARY KEY
 (CNT_COD, CNT_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_COF ADD (
  CONSTRAINT RRHU_COF_PK
 PRIMARY KEY
 (COF_COD, COF_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CUR ADD (
  CONSTRAINT RRHU_CUR_PK
 PRIMARY KEY
 (CUR_IDF_COD, CUR_TIC_COD, CUR_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_EMA ADD (
  CONSTRAINT RRHU_EMA_PK
 PRIMARY KEY
 (EMA_IDF_COD, EMA_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_EMP ADD (
  CONSTRAINT RRHU_EMP_PK
 PRIMARY KEY
 (EMP_COD, EMP_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_FEX ADD (
  CONSTRAINT RRHU_FEX_PK
 PRIMARY KEY
 (FEX_IDF_COD, FEX_TFE_COD, FEX_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_FPE ADD (
  CONSTRAINT RRHU_FPE_PK
 PRIMARY KEY
 (FPE_COD, FPE_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_GFE ADD (
  CONSTRAINT RRHU_GFE_PK
 PRIMARY KEY
 (GFE_IDF_COD, GFE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_GRE ADD (
  CONSTRAINT RRHU_GRE_PK
 PRIMARY KEY
 (GRE_COD, GRE_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_GSE ADD (
  CONSTRAINT RRHU_GSE_PK
 PRIMARY KEY
 (GSE_IDF_COD, GSE_EMP_COD, GSE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_HOD ADD (
  CONSTRAINT RRHU_HOD_PK
 PRIMARY KEY
 (HOD_COD, HOD_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_HOR ADD (
  CONSTRAINT RRHU_HOR_PK
 PRIMARY KEY
 (HOR_COD, HOR_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_IHO ADD (
  CONSTRAINT RRHU_IHO_PK
 PRIMARY KEY
 (IHO_LIN, IHO_HOR_COD, IHO_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_LFE ADD (
  CONSTRAINT RRHU_LFE_PK
 PRIMARY KEY
 (LFE_IDF_COD, LFE_GFE_COD, LFE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_MAO ADD (
  CONSTRAINT RRHU_MAO_PK
 PRIMARY KEY
 (MAO_IDF_COD, MAO_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_NOD ADD (
  CONSTRAINT RRHU_NOD_PK
 PRIMARY KEY
 (NOD_NUM, NOD_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_OPE ADD (
  CONSTRAINT RRHU_OPE_PK
 PRIMARY KEY
 (OPE_COD, OPE_IDF_COD)
    USING INDEX 
    ,
  CONSTRAINT RRHU_OPE_OPE002_UK
 UNIQUE (OPE_IDF_COD, OPE_PIN));

ALTER TABLE TRHU_OPM ADD (
  CONSTRAINT RRHU_OPM_PK
 PRIMARY KEY
 (OPM_IDF_COD, OPM_OPE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PEO ADD (
  CONSTRAINT RRHU_PEO_PK
 PRIMARY KEY
 (PEO_IDF_COD, PEO_OPE_COD, PEO_PLT_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PNO ADD (
  CONSTRAINT RRHU_PNO_PK
 PRIMARY KEY
 (PNO_COD, PNO_EMP_COD, PNO_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_POR ADD (
  CONSTRAINT RRHU_POR_PK
 PRIMARY KEY
 (POR_IDF_COD, POR_REG_COD, POR_OPE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PPF ADD (
  CONSTRAINT RRHU_PPF_PK
 PRIMARY KEY
 (PPF_IDF_COD, PPF_SEQ));

ALTER TABLE TRHU_PRT ADD (
  CONSTRAINT RRHU_PRT_PK
 PRIMARY KEY
 (PRT_IDF_COD, PRT_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_RVM ADD (
  CONSTRAINT RRHU_RVM_PK
 PRIMARY KEY
 (RVM_IDF_COD, RVM_COD)
    USING INDEX 
    ,
  CONSTRAINT SRHU_RVM
 UNIQUE (RVM_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_SBA ADD (
  CONSTRAINT RRHU_SBA_PK
 PRIMARY KEY
 (SBA_COD, SBA_TBA_COD, SBA_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_SCT ADD (
  CONSTRAINT RRHU_SCT_PK
 PRIMARY KEY
 (SCT_COD, SCT_CAT_COD, SCT_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_SEC ADD (
  CONSTRAINT RRHU_SEC_PK
 PRIMARY KEY
 (SEC_COD, SEC_EMP_COD, SEC_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_STR ADD (
  CONSTRAINT RRHU_STR_PK
 PRIMARY KEY
 (STR_IDF_COD, STR_TOR_COD, STR_NUM)
    USING INDEX 
    ,
  CONSTRAINT RRHU_STR_UK
 UNIQUE (STR_IDF_COD, STR_TOR_COD, STR_ORD)
    USING INDEX 
    );

ALTER TABLE TRHU_TLL ADD (
  CONSTRAINT RRHU_TLL_PK
 PRIMARY KEY
 (TLL_IDF_COD, TLL_MAO_COD, TLL_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_TRA ADD (
  CONSTRAINT RRHU_TRA_PK
 PRIMARY KEY
 (TRA_COD, TRA_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_AMN ADD (
  CONSTRAINT RRHU_AMN_PK
 PRIMARY KEY
 (AMN_SEQ)
    USING INDEX 
    );

ALTER TABLE TRHU_ANC ADD (
  CONSTRAINT RRHU_ANC_PK
 PRIMARY KEY
 (ANC_IDF_COD, ANC_EMP_COD, ANC_NUM)
    USING INDEX 
    );

ALTER TABLE TRHU_BAI ADD (
  CONSTRAINT RRHU_BAI_PK
 PRIMARY KEY
 (BAI_IDF_COD, BAI_OPE_COD, BAI_TBA_COD, BAI_SBA_COD, BAI_DATINI)
    USING INDEX 
    );

ALTER TABLE TRHU_CAC ADD (
  CONSTRAINT RRHU_CAC_UK
 UNIQUE (CAC_IDF_COD, CAC_COF_COD, CAC_CAT_COD, CAC_SCT_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CCS ADD (
  CONSTRAINT RRHU_CCS_PK
 PRIMARY KEY
 (CCS_IDF_COD, CCS_EMP_COD, CCS_CTECMP)
    USING INDEX 
    );

ALTER TABLE TRHU_CNH ADD (
  CONSTRAINT RRHU_CNH_PK
 PRIMARY KEY
 (CNH_CNM_COD, CNH_OPE_COD, CNH_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CNO ADD (
  CONSTRAINT RRHU_CNO_PK
 PRIMARY KEY
 (CNO_IDF_COD, CNO_OPE_COD, CNO_TCA_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_COC ADD (
  CONSTRAINT RRHU_COC_PK
 PRIMARY KEY
 (COC_IDF_COD, COC_CNM_COD, COC_OPE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_COT ADD (
  CONSTRAINT RRHU_COT_PK
 PRIMARY KEY
 (COT_IDF_COD, COT_OPE_COD, COT_COF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CRI ADD (
  CONSTRAINT RRHU_CRI_PK
 PRIMARY KEY
 (CRI_IDF_COD, CRI_SEQ)
    USING INDEX 
    );

ALTER TABLE TRHU_CTLFFO ADD (
  CONSTRAINT RRHU_CTLFFO_PK
 PRIMARY KEY
 (CFF_SEQ)
    USING INDEX 
    );

ALTER TABLE TRHU_CTR ADD (
  CONSTRAINT RRHU_CTR_PK
 PRIMARY KEY
 (CTR_IDF_COD, CTR_EMP_COD, CTR_OPE_COD, CTR_TCT_COD, CTR_DATINI)
    USING INDEX 
    );

ALTER TABLE TRHU_CVA ADD (
  CONSTRAINT RRHU_CVA_PK
 PRIMARY KEY
 (CVA_IDF_COD, CVA_EMP_COD, CVA_ANL_COD, CVA_COV_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_DED ADD (
  CONSTRAINT RRHU_DED_PK
 PRIMARY KEY
 (DED_IDF_COD, DED_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_DET ADD (
  CONSTRAINT RRHU_DET_PK
 PRIMARY KEY
 (DET_IDF_COD, DET_COD)
    USING INDEX 
    ,
  CONSTRAINT RRHU_DET_UK
 UNIQUE (DET_IDF_COD, DET_EMP_COD, DET_PRJ_NUM, DET_OPE_COD, DET_DIA)
    USING INDEX 
    );

ALTER TABLE TRHU_DFE ADD (
  CONSTRAINT RRHU_DFE_PK
 PRIMARY KEY
 (DFE_IDF_COD, DFE_TFE_COD, DFE_FEX_COD, DFE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_DLD ADD (
  CONSTRAINT RRHU_DLD_PK
 PRIMARY KEY
 (DLD_IDF_COD, DLD_REF)
    USING INDEX 
    );

ALTER TABLE TRHU_DSP ADD (
  CONSTRAINT RRHU_DSP_PK
 PRIMARY KEY
 (DSP_IDF_COD, DSP_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_ERE ADD (
  CONSTRAINT RRHU_RGES_ERE_PK
 PRIMARY KEY
 (ERE_IDF_COD, ERE_SEQ));

ALTER TABLE TRHU_EXL ADD (
  CONSTRAINT RRHU_EXL_PK
 PRIMARY KEY
 (EXL_IDF_COD, EXL_OPE_COD, EXL_SEC)
    USING INDEX 
    );

ALTER TABLE TRHU_FCP ADD (
  CONSTRAINT RRHU_FCP_PK
 PRIMARY KEY
 (FCP_IDF_COD, FCP_OPE_COD, FCP_COF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_FEXOPE ADD (
  CONSTRAINT RRHU_FEXOPE_PK
 PRIMARY KEY
 (FEXOPE_IDF_COD, FEXOPE_OPE_COD, FEXOPE_SEQ)
    USING INDEX 
    );

ALTER TABLE TRHU_FOR ADD (
  CONSTRAINT RRHU_FOR_PK
 PRIMARY KEY
 (FOR_CUR_COD, FOR_TIC_COD, FOR_IDF_COD, FOR_OPE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_FOT ADD (
  CONSTRAINT RRHU_FOT_PK
 PRIMARY KEY
 (FOT_IDF_COD, FOT_OPE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_HAN ADD (
  CONSTRAINT RRHU_HAN_PK
 PRIMARY KEY
 (HAN_IDF_COD, HAN_ANL_COD, HAN_OPE_COD, HAN_TIP)
    USING INDEX 
    );

ALTER TABLE TRHU_HDC ADD (
  CONSTRAINT RRHU_HDC_PK
 PRIMARY KEY
 (HDC_IDF_COD, HDC_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_HDO ADD (
  CONSTRAINT RRHU_HDO_PK
 PRIMARY KEY
 (HDO_IDF_COD, HDO_OPE_COD, HDO_DAT)
    USING INDEX 
    );

ALTER TABLE TRHU_HLI ADD (
  CONSTRAINT RRHU_HLI_PK
 PRIMARY KEY
 (HLI_IDF_COD, HLI_ANL_COD, HLI_OPE_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_IDO ADD (
  CONSTRAINT RRHU_IDO_PK
 PRIMARY KEY
 (IDO_IDF_COD, IDO_OPE_COD, IDO_IDI_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_INA ADD (
  CONSTRAINT RRHU_INA_PK
 PRIMARY KEY
 (INA_IDF_COD, INA_TBA_COD, INA_SBA_COD, INA_OPE_CODBAI, INA_BAI_DATINI, INA_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_LIV ADD (
  CONSTRAINT RRHU_LIV_PK
 PRIMARY KEY
 (LIV_IDF_COD, LIV_OPE_COD, LIV_DAT, LIV_CLS)
    USING INDEX 
    );

ALTER TABLE TRHU_LMT ADD (
  CONSTRAINT RRHU_LMT_PK
 PRIMARY KEY
 (LMT_IDF_COD, LMT_REF)
    USING INDEX 
    );

ALTER TABLE TRHU_NMN ADD (
  CONSTRAINT RRHU_NMN_PK
 PRIMARY KEY
 (NMN_OPE_COD, NMN_PNO_COD, NMN_EMP_COD, NMN_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_OBO ADD (
  CONSTRAINT RRHU_OBO_PK
 PRIMARY KEY
 (OBO_IDF_COD, OBO_OPE_COD, OBO_SEQ)
    USING INDEX 
    );

ALTER TABLE TRHU_PCA ADD (
  CONSTRAINT RRHU_PCA_PK
 PRIMARY KEY
 (PCA_DATINI, PCA_SCT_COD, PCA_OPE_COD, PCA_CAT_COD, PCA_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PCN ADD (
  CONSTRAINT RRHU_PCN_PK
 PRIMARY KEY
 (PCN_CNM_COD, PCN_SCT_COD, PCN_CAT_COD, PCN_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PFC ADD (
  CONSTRAINT RRHU_PFC_PK
 PRIMARY KEY
 (PFC_COF_COD, PFC_SCT_COD, PFC_CAT_COD, PFC_DIASET, PFC_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PSE ADD (
  CONSTRAINT RRHU_PSE_PK
 PRIMARY KEY
 (PSE_DATINI, PSE_OPE_COD, PSE_SEC_COD, PSE_EMP_COD, PSE_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_RDI ADD (
  CONSTRAINT RRHU_RDI_PK
 PRIMARY KEY
 (RDI_CLN_DAT, RDI_OPE_COD, RDI_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_CMH ADD (
  CONSTRAINT RRHU_CMH_PK
 PRIMARY KEY
 (CMH_IDF_COD, CMH_EMP_COD, CMH_PNO_COD, CMH_OPE_COD, CMH_COF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_HOL ADD (
  CONSTRAINT RRHU_HOL_PK
 PRIMARY KEY
 (HOL_IDF_COD, HOL_CLN_DAT, HOL_OPE_COD, HOL_HOD_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_INR ADD (
  CONSTRAINT RRHU_INR_PK
 PRIMARY KEY
 (INR_COD, INR_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_LFF ADD (
  CONSTRAINT RRHU_LFF_PK
 PRIMARY KEY
 (LFF_FFO_COD, LFF_NUM, LFF_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_LNM ADD (
  CONSTRAINT RRHU_LNM_PK
 PRIMARY KEY
 (LNM_CNM_COD, LNM_OPE_COD, LNM_PNO_COD, LNM_EMP_COD, LNM_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_ANO ADD (
  CONSTRAINT RRHU_ANO_PK
 PRIMARY KEY
 (ANO_COD, ANO_IDF_COD)
    USING INDEX 
    );

ALTER TABLE TRHU_PAR ADD (
  CONSTRAINT RRHU_PAR_IDF_FK 
 FOREIGN KEY (PAR_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_PLT ADD (
  CONSTRAINT RRHU_PLT_IDF_FK 
 FOREIGN KEY (PLT_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_PLT_PLT_FK 
 FOREIGN KEY (PLT_IDF_COD, PLT_PLT_COD) 
 REFERENCES TRHU_PLT (PLT_IDF_COD,PLT_COD));

ALTER TABLE TRHU_REG ADD (
  CONSTRAINT RRHU_REG_IDF_FK 
 FOREIGN KEY (REG_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_SNO ADD (
  CONSTRAINT RRHU_SNO_IDF_FK 
 FOREIGN KEY (SNO_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TAM ADD (
  CONSTRAINT RRHU_TAM_IDF_FK 
 FOREIGN KEY (TAM_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TAN ADD (
  CONSTRAINT RRHU_TAN_IDF_FK 
 FOREIGN KEY (TAN_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TBA ADD (
  CONSTRAINT RRHU_TBA_IDF_FK 
 FOREIGN KEY (TBA_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TCA ADD (
  CONSTRAINT RRHU_TCA_IDF_FK 
 FOREIGN KEY (TCA_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TCN ADD (
  CONSTRAINT RRHU_TCN_IDF_FK 
 FOREIGN KEY (TCN_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TCT ADD (
  CONSTRAINT RRHU_TCT_IDF_FK 
 FOREIGN KEY (TCT_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TDI ADD (
  CONSTRAINT RRHU_TDI_IDF_FK 
 FOREIGN KEY (TDI_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_TDI_REG_FK 
 FOREIGN KEY (TDI_IDF_COD, TDI_REG_COD) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD));

ALTER TABLE TRHU_TMO ADD (
  CONSTRAINT RRHU_TMO_IDF_FK 
 FOREIGN KEY (TMO_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TOR ADD (
  CONSTRAINT RRHU_TOR_IDF_FK 
 FOREIGN KEY (TOR_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TRM ADD (
  CONSTRAINT RRHU_TRM_IDF_FK 
 FOREIGN KEY (TRM_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_TTR ADD (
  CONSTRAINT RRHU_TTR_IDF_FK 
 FOREIGN KEY (TTR_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_VAD ADD (
  CONSTRAINT RRHU_VAD_IDF_FK 
 FOREIGN KEY (VAD_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_ZON ADD (
  CONSTRAINT RRHU_ZON_IDF_FK 
 FOREIGN KEY (ZON_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_ANL ADD (
  CONSTRAINT RRHU_ANL_IDF_FK 
 FOREIGN KEY (ANL_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_CAT ADD (
  CONSTRAINT RRHU_CAT_IDF_FK 
 FOREIGN KEY (CAT_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_CIN ADD (
  CONSTRAINT RRHU_CIN_TCI_FK 
 FOREIGN KEY (CIN_IDF_COD, CIN_TCI_COD) 
 REFERENCES TRHU_TCI (TCI_IDF_COD,TCI_COD));

ALTER TABLE TRHU_CLN ADD (
  CONSTRAINT RRHU_CLN_IDF_FK 
 FOREIGN KEY (CLN_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_CLN_TDI_FK 
 FOREIGN KEY (CLN_TDI_COD, CLN_IDF_COD) 
 REFERENCES TRHU_TDI (TDI_COD,TDI_IDF_COD));

ALTER TABLE TRHU_CNM ADD (
  CONSTRAINT RRHU_CNM_IDF_FK 
 FOREIGN KEY (CNM_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_CNM_TCN_FK 
 FOREIGN KEY (CNM_TCN_COD, CNM_IDF_COD) 
 REFERENCES TRHU_TCN (TCN_COD,TCN_IDF_COD));

ALTER TABLE TRHU_CNT ADD (
  CONSTRAINT RRHU_CNT_IDF_FK 
 FOREIGN KEY (CNT_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_COF ADD (
  CONSTRAINT RRHU_COF_CNM_FK 
 FOREIGN KEY (COF_CNM_COD, COF_IDF_COD) 
 REFERENCES TRHU_CNM (CNM_COD,CNM_IDF_COD),
  CONSTRAINT RRHU_COF_COF_FK 
 FOREIGN KEY (COF_COF_COD, COF_IDF_COD) 
 REFERENCES TRHU_COF (COF_COD,COF_IDF_COD),
  CONSTRAINT RRHU_COF_IDF_FK 
 FOREIGN KEY (COF_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_CUR ADD (
  CONSTRAINT RRHU_CUR_TIC_FK 
 FOREIGN KEY (CUR_IDF_COD, CUR_TIC_COD) 
 REFERENCES TRHU_TIC (TIC_IDF_COD,TIC_COD));

ALTER TABLE TRHU_EMA ADD (
  CONSTRAINT RRHU_EMA_IDF_FK 
 FOREIGN KEY (EMA_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_EMP ADD (
  CONSTRAINT RRHU_EMP_IDF_FK 
 FOREIGN KEY (EMP_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_FEX ADD (
  CONSTRAINT RRHU_FEX_TFE_FK 
 FOREIGN KEY (FEX_IDF_COD, FEX_TFE_COD) 
 REFERENCES TRHU_TFE (TFE_IDF_COD,TFE_COD));

ALTER TABLE TRHU_FPE ADD (
  CONSTRAINT RRHU_FPE_IDF_FK 
 FOREIGN KEY (FPE_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_FPE_TDI_FK 
 FOREIGN KEY (FPE_TDI_COD, FPE_IDF_COD) 
 REFERENCES TRHU_TDI (TDI_COD,TDI_IDF_COD));

ALTER TABLE TRHU_GFE ADD (
  CONSTRAINT RRHU_GFE_IDF_FK 
 FOREIGN KEY (GFE_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_GRE ADD (
  CONSTRAINT RRHU_GRE_IDF_FK 
 FOREIGN KEY (GRE_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_GSE ADD (
  CONSTRAINT RRHU_GSE_EMP_FK 
 FOREIGN KEY (GSE_EMP_COD, GSE_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD));

ALTER TABLE TRHU_HOD ADD (
  CONSTRAINT RRHU_HOD_IDF_FK 
 FOREIGN KEY (HOD_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_HOR ADD (
  CONSTRAINT RRHU_HOR_IDF_FK 
 FOREIGN KEY (HOR_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_IHO ADD (
  CONSTRAINT RRHU_IHO_HOR_FK 
 FOREIGN KEY (IHO_HOR_COD, IHO_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD));

ALTER TABLE TRHU_LFE ADD (
  CONSTRAINT RRHU_LFE_GFE_FK 
 FOREIGN KEY (LFE_IDF_COD, LFE_GFE_COD) 
 REFERENCES TRHU_GFE (GFE_IDF_COD,GFE_COD),
  CONSTRAINT RRHU_LFE_REG_FK 
 FOREIGN KEY (LFE_IDF_COD, LFE_REG_COD) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD));

ALTER TABLE TRHU_MAO ADD (
  CONSTRAINT RRHU_MAO_IDF_FK 
 FOREIGN KEY (MAO_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_MAO_TMO_FK 
 FOREIGN KEY (MAO_IDF_COD, MAO_TMO_COD) 
 REFERENCES TRHU_TMO (TMO_IDF_COD,TMO_COD));

ALTER TABLE TRHU_NOD ADD (
  CONSTRAINT RRHU_NOD_IDF_FK 
 FOREIGN KEY (NOD_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_NOD_SNO_FK 
 FOREIGN KEY (NOD_SNO_COD, NOD_IDF_COD) 
 REFERENCES TRHU_SNO (SNO_COD,SNO_IDF_COD),
  CONSTRAINT RRHU_NOD_ZON_DTI_FK 
 FOREIGN KEY (NOD_IDF_COD, NOD_ZON_CODDTI) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD),
  CONSTRAINT RRHU_NOD_ZON_ORI_FK 
 FOREIGN KEY (NOD_IDF_COD, NOD_ZON_CODORI) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD));

ALTER TABLE TRHU_OPE ADD (
  CONSTRAINT RRHU_OPE_GFE_FK 
 FOREIGN KEY (OPE_IDF_COD, OPE_GFE_COD) 
 REFERENCES TRHU_GFE (GFE_IDF_COD,GFE_COD),
  CONSTRAINT RRHU_OPE_GRE_FK 
 FOREIGN KEY (OPE_GRE_COD, OPE_IDF_COD) 
 REFERENCES TRHU_GRE (GRE_COD,GRE_IDF_COD),
  CONSTRAINT RRHU_OPE_HOR002_FK 
 FOREIGN KEY (OPE_HOR_COD002, OPE_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_OPE_HOR003_FK 
 FOREIGN KEY (OPE_HOR_COD003, OPE_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_OPE_HORNIT_FK 
 FOREIGN KEY (OPE_HOR_CODNIT, OPE_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_OPE_HOR_FK 
 FOREIGN KEY (OPE_HOR_COD, OPE_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_OPE_IDF_FK 
 FOREIGN KEY (OPE_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_OPE_OPE_FK 
 FOREIGN KEY (OPE_OPE_COD, OPE_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_OPE_TOR_FK 
 FOREIGN KEY (OPE_IDF_COD, OPE_TOR_COD) 
 REFERENCES TRHU_TOR (TOR_IDF_COD,TOR_COD),
  CONSTRAINT RRHU_OPE_VAD_FK 
 FOREIGN KEY (OPE_IDF_COD, OPE_VAD_COD) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_OPE_ZON_FK 
 FOREIGN KEY (OPE_IDF_COD, OPE_ZON_COD) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD));

ALTER TABLE TRHU_OPM ADD (
  CONSTRAINT RRHU_OPM_OPE_FK 
 FOREIGN KEY (OPM_OPE_COD, OPM_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_PEO ADD (
  CONSTRAINT RGES_PEO_PLT_FK 
 FOREIGN KEY (PEO_IDF_COD, PEO_PLT_COD) 
 REFERENCES TRHU_PLT (PLT_IDF_COD,PLT_COD),
  CONSTRAINT RRHU_PEO_OPE_FK 
 FOREIGN KEY (PEO_OPE_COD, PEO_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_PNO ADD (
  CONSTRAINT RRHU_PNO_ANL_FK 
 FOREIGN KEY (PNO_IDF_COD, PNO_ANL_COD) 
 REFERENCES TRHU_ANL (ANL_IDF_COD,ANL_COD),
  CONSTRAINT RRHU_PNO_EMP_FK 
 FOREIGN KEY (PNO_EMP_COD, PNO_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD));

ALTER TABLE TRHU_POR ADD (
  CONSTRAINT RRHU_POR_IDF_FK 
 FOREIGN KEY (POR_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_POR_OPE_FK 
 FOREIGN KEY (POR_OPE_COD, POR_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_POR_REG_FK 
 FOREIGN KEY (POR_IDF_COD, POR_REG_COD) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD));

ALTER TABLE TRHU_PPF ADD (
  CONSTRAINT RRHU_PPF_COF_FK 
 FOREIGN KEY (PPF_COF_COD, PPF_IDF_COD) 
 REFERENCES TRHU_COF (COF_COD,COF_IDF_COD),
  CONSTRAINT RRHU_PPF_IDF_FK 
 FOREIGN KEY (PPF_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_PPF_OPE_FK 
 FOREIGN KEY (PPF_OPE_COD, PPF_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_PRT ADD (
  CONSTRAINT RRHU_PRT_CNM_FK 
 FOREIGN KEY (PRT_CNM_COD, PRT_IDF_COD) 
 REFERENCES TRHU_CNM (CNM_COD,CNM_IDF_COD),
  CONSTRAINT RRHU_PRT_EMP_FK 
 FOREIGN KEY (PRT_EMP_COD, PRT_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD),
  CONSTRAINT RRHU_PRT_IDF_FK 
 FOREIGN KEY (PRT_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_PRT_OPE_FK 
 FOREIGN KEY (PRT_OPE_COD, PRT_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_RVM ADD (
  CONSTRAINT RRHU_RVM_IDF_FK 
 FOREIGN KEY (RVM_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_RVM_OPE_FK 
 FOREIGN KEY (RVM_OPE_COD, RVM_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_RVM_TRM_FK 
 FOREIGN KEY (RVM_IDF_COD, RVM_TRM_COD) 
 REFERENCES TRHU_TRM (TRM_IDF_COD,TRM_COD));

ALTER TABLE TRHU_SBA ADD (
  CONSTRAINT RRHU_SBA_TBA_FK 
 FOREIGN KEY (SBA_TBA_COD, SBA_IDF_COD) 
 REFERENCES TRHU_TBA (TBA_COD,TBA_IDF_COD));

ALTER TABLE TRHU_SCT ADD (
  CONSTRAINT RRHU_SCT_CAT_FK 
 FOREIGN KEY (SCT_CAT_COD, SCT_IDF_COD) 
 REFERENCES TRHU_CAT (CAT_COD,CAT_IDF_COD));

ALTER TABLE TRHU_SEC ADD (
  CONSTRAINT RRHU_SEC_EMP_FK 
 FOREIGN KEY (SEC_EMP_COD, SEC_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD),
  CONSTRAINT RRHU_SEC_GSE_FK 
 FOREIGN KEY (SEC_IDF_COD, SEC_EMP_COD, SEC_GSE_COD) 
 REFERENCES TRHU_GSE (GSE_IDF_COD,GSE_EMP_COD,GSE_COD));

ALTER TABLE TRHU_STR ADD (
  CONSTRAINT RRHU_STR_HOR0021_FK 
 FOREIGN KEY (STR_HOR_COD0021, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR0022_FK 
 FOREIGN KEY (STR_HOR_COD0022, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR0023_FK 
 FOREIGN KEY (STR_HOR_COD0023, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR0024_FK 
 FOREIGN KEY (STR_HOR_COD0024, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR0025_FK 
 FOREIGN KEY (STR_HOR_COD0025, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR0026_FK 
 FOREIGN KEY (STR_HOR_COD0026, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR0027_FK 
 FOREIGN KEY (STR_HOR_COD0027, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR1_FK 
 FOREIGN KEY (STR_HOR_COD1, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR2_FK 
 FOREIGN KEY (STR_HOR_COD2, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR3_FK 
 FOREIGN KEY (STR_HOR_COD3, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR4_FK 
 FOREIGN KEY (STR_HOR_COD4, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR5_FK 
 FOREIGN KEY (STR_HOR_COD5, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR6_FK 
 FOREIGN KEY (STR_HOR_COD6, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HOR7_FK 
 FOREIGN KEY (STR_HOR_COD7, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HORNIT1_FK 
 FOREIGN KEY (STR_HOR_CODNIT1, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HORNIT2_FK 
 FOREIGN KEY (STR_HOR_CODNIT2, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HORNIT3_FK 
 FOREIGN KEY (STR_HOR_CODNIT3, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HORNIT4_FK 
 FOREIGN KEY (STR_HOR_CODNIT4, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HORNIT5_FK 
 FOREIGN KEY (STR_HOR_CODNIT5, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HORNIT6_FK 
 FOREIGN KEY (STR_HOR_CODNIT6, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_HORNIT7_FK 
 FOREIGN KEY (STR_HOR_CODNIT7, STR_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_STR_REG1_FK 
 FOREIGN KEY (STR_IDF_COD, STR_REG_COD1) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD),
  CONSTRAINT RRHU_STR_REG2_FK 
 FOREIGN KEY (STR_IDF_COD, STR_REG_COD2) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD),
  CONSTRAINT RRHU_STR_REG3_FK 
 FOREIGN KEY (STR_IDF_COD, STR_REG_COD3) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD),
  CONSTRAINT RRHU_STR_REG4_FK 
 FOREIGN KEY (STR_IDF_COD, STR_REG_COD4) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD),
  CONSTRAINT RRHU_STR_REG5_FK 
 FOREIGN KEY (STR_IDF_COD, STR_REG_COD5) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD),
  CONSTRAINT RRHU_STR_REG6_FK 
 FOREIGN KEY (STR_IDF_COD, STR_REG_COD6) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD),
  CONSTRAINT RRHU_STR_REG7_FK 
 FOREIGN KEY (STR_IDF_COD, STR_REG_COD7) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD),
  CONSTRAINT RRHU_STR_TOR_FK 
 FOREIGN KEY (STR_IDF_COD, STR_TOR_COD) 
 REFERENCES TRHU_TOR (TOR_IDF_COD,TOR_COD),
  CONSTRAINT RRHU_STR_ZON1_FK 
 FOREIGN KEY (STR_IDF_COD, STR_ZON_COD1) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD),
  CONSTRAINT RRHU_STR_ZON2_FK 
 FOREIGN KEY (STR_IDF_COD, STR_ZON_COD2) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD),
  CONSTRAINT RRHU_STR_ZON3_FK 
 FOREIGN KEY (STR_IDF_COD, STR_ZON_COD3) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD),
  CONSTRAINT RRHU_STR_ZON4_FK 
 FOREIGN KEY (STR_IDF_COD, STR_ZON_COD4) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD),
  CONSTRAINT RRHU_STR_ZON5_FK 
 FOREIGN KEY (STR_IDF_COD, STR_ZON_COD5) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD),
  CONSTRAINT RRHU_STR_ZON6_FK 
 FOREIGN KEY (STR_IDF_COD, STR_ZON_COD6) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD),
  CONSTRAINT RRHU_STR_ZON7_FK 
 FOREIGN KEY (STR_IDF_COD, STR_ZON_COD7) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD));

ALTER TABLE TRHU_TLL ADD (
  CONSTRAINT RRHU_TLL_MAO_FK 
 FOREIGN KEY (TLL_IDF_COD, TLL_MAO_COD) 
 REFERENCES TRHU_MAO (MAO_IDF_COD,MAO_COD));

ALTER TABLE TRHU_TRA ADD (
  CONSTRAINT RRHU_TRA_IDF_FK 
 FOREIGN KEY (TRA_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_TRA_NOD_FK 
 FOREIGN KEY (TRA_NOD_NUM, TRA_IDF_COD) 
 REFERENCES TRHU_NOD (NOD_NUM,NOD_IDF_COD),
  CONSTRAINT RRHU_TRA_OPE_FK 
 FOREIGN KEY (TRA_OPE_COD, TRA_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_TRA_TTR_FK 
 FOREIGN KEY (TRA_TTR_COD, TRA_IDF_COD) 
 REFERENCES TRHU_TTR (TTR_COD,TTR_IDF_COD));

ALTER TABLE TRHU_AMN ADD (
  CONSTRAINT RRHU_AMN_OPE_FK 
 FOREIGN KEY (AMN_OPE_COD, AMN_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_AMN_TAM_FK 
 FOREIGN KEY (AMN_IDF_COD, AMN_TAM_COD) 
 REFERENCES TRHU_TAM (TAM_IDF_COD,TAM_COD));

ALTER TABLE TRHU_ANC ADD (
  CONSTRAINT RRHU_ANC_EMP_FK 
 FOREIGN KEY (ANC_EMP_COD, ANC_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD),
  CONSTRAINT RRHU_ANC_OPE_FK 
 FOREIGN KEY (ANC_OPE_COD, ANC_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_ANC_PNO_FK 
 FOREIGN KEY (ANC_PNO_COD, ANC_EMP_COD, ANC_IDF_COD) 
 REFERENCES TRHU_PNO (PNO_COD,PNO_EMP_COD,PNO_IDF_COD));

ALTER TABLE TRHU_BAI ADD (
  CONSTRAINT RRHU_BAI_OPE_FK 
 FOREIGN KEY (BAI_OPE_COD, BAI_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_BAI_SBA_FK 
 FOREIGN KEY (BAI_SBA_COD, BAI_TBA_COD, BAI_IDF_COD) 
 REFERENCES TRHU_SBA (SBA_COD,SBA_TBA_COD,SBA_IDF_COD));

ALTER TABLE TRHU_CAC ADD (
  CONSTRAINT RRHU_CAC_CAT_FK 
 FOREIGN KEY (CAC_CAT_COD, CAC_IDF_COD) 
 REFERENCES TRHU_CAT (CAT_COD,CAT_IDF_COD),
  CONSTRAINT RRHU_CAC_COF_FK 
 FOREIGN KEY (CAC_COF_COD, CAC_IDF_COD) 
 REFERENCES TRHU_COF (COF_COD,COF_IDF_COD),
  CONSTRAINT RRHU_CAC_SCT_FK 
 FOREIGN KEY (CAC_SCT_COD, CAC_CAT_COD, CAC_IDF_COD) 
 REFERENCES TRHU_SCT (SCT_COD,SCT_CAT_COD,SCT_IDF_COD));

ALTER TABLE TRHU_CCS ADD (
  CONSTRAINT RRHU_CCS_EMP_FK 
 FOREIGN KEY (CCS_EMP_COD, CCS_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD),
  CONSTRAINT RRHU_CCS_SEC_FK 
 FOREIGN KEY (CCS_SEC_COD, CCS_EMP_COD, CCS_IDF_COD) 
 REFERENCES TRHU_SEC (SEC_COD,SEC_EMP_COD,SEC_IDF_COD));

ALTER TABLE TRHU_CNH ADD (
  CONSTRAINT RRHU_CNH_CNM_FK 
 FOREIGN KEY (CNH_CNM_COD, CNH_IDF_COD) 
 REFERENCES TRHU_CNM (CNM_COD,CNM_IDF_COD),
  CONSTRAINT RRHU_CNH_OPE_FK 
 FOREIGN KEY (CNH_OPE_COD, CNH_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_CNO ADD (
  CONSTRAINT RRHU_CNO_OPE_FK 
 FOREIGN KEY (CNO_OPE_COD, CNO_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_CNO_TCA_FK 
 FOREIGN KEY (CNO_IDF_COD, CNO_TCA_COD) 
 REFERENCES TRHU_TCA (TCA_IDF_COD,TCA_COD));

ALTER TABLE TRHU_COC ADD (
  CONSTRAINT RRHU_COC_CNM_FK 
 FOREIGN KEY (COC_CNM_COD, COC_IDF_COD) 
 REFERENCES TRHU_CNM (CNM_COD,CNM_IDF_COD),
  CONSTRAINT RRHU_COC_OPE_FK 
 FOREIGN KEY (COC_OPE_COD, COC_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_COT ADD (
  CONSTRAINT RRHU_COT_COF_FK 
 FOREIGN KEY (COT_COF_COD, COT_IDF_COD) 
 REFERENCES TRHU_COF (COF_COD,COF_IDF_COD),
  CONSTRAINT RRHU_COT_OPE_FK 
 FOREIGN KEY (COT_OPE_COD, COT_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_CRI ADD (
  CONSTRAINT RRHU_CRI_EMA_FK 
 FOREIGN KEY (CRI_IDF_COD, CRI_EMA_COD) 
 REFERENCES TRHU_EMA (EMA_IDF_COD,EMA_COD),
  CONSTRAINT RRHU_CRI_OPM_FK 
 FOREIGN KEY (CRI_IDF_COD, CRI_OPE_COD) 
 REFERENCES TRHU_OPM (OPM_IDF_COD,OPM_OPE_COD));

ALTER TABLE TRHU_CTLFFO ADD (
  CONSTRAINT RRHU_CTLFFO_OPE_FK 
 FOREIGN KEY (CFF_OPE_COD, CFF_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_CTR ADD (
  CONSTRAINT RRHU_CTR_EMP_FK 
 FOREIGN KEY (CTR_EMP_COD, CTR_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD),
  CONSTRAINT RRHU_CTR_OPE_FK 
 FOREIGN KEY (CTR_OPE_COD, CTR_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_CTR_TCT_FK 
 FOREIGN KEY (CTR_TCT_COD, CTR_IDF_COD) 
 REFERENCES TRHU_TCT (TCT_COD,TCT_IDF_COD));

ALTER TABLE TRHU_CVA ADD (
  CONSTRAINT RRHU_CVA_ANL_FK 
 FOREIGN KEY (CVA_IDF_COD, CVA_ANL_COD) 
 REFERENCES TRHU_ANL (ANL_IDF_COD,ANL_COD),
  CONSTRAINT RRHU_CVA_EMP_FK 
 FOREIGN KEY (CVA_EMP_COD, CVA_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD));

ALTER TABLE TRHU_DED ADD (
  CONSTRAINT RRHU_DED_OPE_FK 
 FOREIGN KEY (DED_OPE_COD, DED_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_DET ADD (
  CONSTRAINT RRHU_DET_OPE_FK 
 FOREIGN KEY (DET_OPE_COD, DET_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_DFE ADD (
  CONSTRAINT RRHU_DFE_FEX_FK 
 FOREIGN KEY (DFE_IDF_COD, DFE_TFE_COD, DFE_FEX_COD) 
 REFERENCES TRHU_FEX (FEX_IDF_COD,FEX_TFE_COD,FEX_COD));

ALTER TABLE TRHU_DLD ADD (
  CONSTRAINT RRHU_DLD_COV_FK 
 FOREIGN KEY (DLD_IDF_COD, DLD_COV_COD) 
 REFERENCES TRHU_COV (COV_IDF_COD,COV_COD),
  CONSTRAINT RRHU_DLD_EMP_FK 
 FOREIGN KEY (DLD_EMP_COD, DLD_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD),
  CONSTRAINT RRHU_DLD_GFE_FK 
 FOREIGN KEY (DLD_IDF_COD, DLD_GFE_COD) 
 REFERENCES TRHU_GFE (GFE_IDF_COD,GFE_COD),
  CONSTRAINT RRHU_DLD_IDF_FK 
 FOREIGN KEY (DLD_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD));

ALTER TABLE TRHU_DSP ADD (
  CONSTRAINT RRHU_RHU_DSP_OPE_FK 
 FOREIGN KEY (DSP_OPE_COD, DSP_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_RHU_DSP_TDS_FK 
 FOREIGN KEY (DSP_IDF_COD, DSP_TDS_COD) 
 REFERENCES TRHU_TDS (TDS_IDF_COD,TDS_COD));

ALTER TABLE TRHU_ERE ADD (
  CONSTRAINT RRHU_ERE_HOR_COD002_FK 
 FOREIGN KEY (ERE_HOR_COD002, ERE_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_ERE_HOR_CODNIT_FK 
 FOREIGN KEY (ERE_HOR_CODNIT, ERE_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_ERE_HOR_FK 
 FOREIGN KEY (ERE_HOR_COD, ERE_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_ERE_OPE_FK 
 FOREIGN KEY (ERE_OPE_COD, ERE_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_ERE_REG_FK 
 FOREIGN KEY (ERE_IDF_COD, ERE_REG_COD) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD));

ALTER TABLE TRHU_EXL ADD (
  CONSTRAINT RRHU_EXL_OPE_FK 
 FOREIGN KEY (EXL_OPE_COD, EXL_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_FCP ADD (
  CONSTRAINT RRHU_FCP_COF_FK 
 FOREIGN KEY (FCP_COF_COD, FCP_IDF_COD) 
 REFERENCES TRHU_COF (COF_COD,COF_IDF_COD),
  CONSTRAINT RRHU_FCP_OPE_FK 
 FOREIGN KEY (FCP_OPE_COD, FCP_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_FEXOPE ADD (
  CONSTRAINT RRHU_FEXOPE_DFE_FK 
 FOREIGN KEY (FEXOPE_IDF_COD, FEXOPE_TFE_COD, FEXOPE_FEX_COD, FEXOPE_DFE_COD) 
 REFERENCES TRHU_DFE (DFE_IDF_COD,DFE_TFE_COD,DFE_FEX_COD,DFE_COD),
  CONSTRAINT RRHU_FEXOPE_FEX_FK 
 FOREIGN KEY (FEXOPE_IDF_COD, FEXOPE_TFE_COD, FEXOPE_FEX_COD) 
 REFERENCES TRHU_FEX (FEX_IDF_COD,FEX_TFE_COD,FEX_COD),
  CONSTRAINT RRHU_FEXOPE_OPE_FK 
 FOREIGN KEY (FEXOPE_OPE_COD, FEXOPE_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_FOR ADD (
  CONSTRAINT RRHU_FOR_CUR_FK 
 FOREIGN KEY (FOR_IDF_COD, FOR_TIC_COD, FOR_CUR_COD) 
 REFERENCES TRHU_CUR (CUR_IDF_COD,CUR_TIC_COD,CUR_COD),
  CONSTRAINT RRHU_FOR_OPE_FK 
 FOREIGN KEY (FOR_OPE_COD, FOR_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_FOT ADD (
  CONSTRAINT RRHU_FOT_OPE_FK 
 FOREIGN KEY (FOT_OPE_COD, FOT_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_HAN ADD (
  CONSTRAINT RRHU_HAN_ANL_FK 
 FOREIGN KEY (HAN_IDF_COD, HAN_ANL_COD) 
 REFERENCES TRHU_ANL (ANL_IDF_COD,ANL_COD),
  CONSTRAINT RRHU_HAN_OPE_FK 
 FOREIGN KEY (HAN_OPE_COD, HAN_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_HDC ADD (
  CONSTRAINT RRHU_HDC_ANL_FK 
 FOREIGN KEY (HDC_IDF_COD, HDC_ANL_COD) 
 REFERENCES TRHU_ANL (ANL_IDF_COD,ANL_COD),
  CONSTRAINT RRHU_HDC_HOD_FK 
 FOREIGN KEY (HDC_HOD_COD, HDC_IDF_COD) 
 REFERENCES TRHU_HOD (HOD_COD,HOD_IDF_COD));

ALTER TABLE TRHU_HDO ADD (
  CONSTRAINT RRHU_HDO_OPE_FK 
 FOREIGN KEY (HDO_OPE_COD, HDO_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_HLI ADD (
  CONSTRAINT RRHU_HLI_ANL_FK 
 FOREIGN KEY (HLI_IDF_COD, HLI_ANL_COD) 
 REFERENCES TRHU_ANL (ANL_IDF_COD,ANL_COD),
  CONSTRAINT RRHU_HLI_OPE_FK 
 FOREIGN KEY (HLI_OPE_COD, HLI_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_IDO ADD (
  CONSTRAINT RRHU_IDO_OPE_FK 
 FOREIGN KEY (IDO_OPE_COD, IDO_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_INA ADD (
  CONSTRAINT RRHU_INA_BAI_FK 
 FOREIGN KEY (INA_IDF_COD, INA_OPE_CODBAI, INA_TBA_COD, INA_SBA_COD, INA_BAI_DATINI) 
 REFERENCES TRHU_BAI (BAI_IDF_COD,BAI_OPE_COD,BAI_TBA_COD,BAI_SBA_COD,BAI_DATINI),
  CONSTRAINT RRHU_INA_CAT001_FK 
 FOREIGN KEY (INA_CAT_COD001, INA_IDF_COD) 
 REFERENCES TRHU_CAT (CAT_COD,CAT_IDF_COD),
  CONSTRAINT RRHU_INA_CAT002_FK 
 FOREIGN KEY (INA_CAT_COD002, INA_IDF_COD) 
 REFERENCES TRHU_CAT (CAT_COD,CAT_IDF_COD),
  CONSTRAINT RRHU_INA_CAT003_FK 
 FOREIGN KEY (INA_CAT_COD003, INA_IDF_COD) 
 REFERENCES TRHU_CAT (CAT_COD,CAT_IDF_COD),
  CONSTRAINT RRHU_INA_EMP_FK 
 FOREIGN KEY (INA_EMP_COD, INA_IDF_COD) 
 REFERENCES TRHU_EMP (EMP_COD,EMP_IDF_COD),
  CONSTRAINT RRHU_INA_OPEENC_FK 
 FOREIGN KEY (INA_OPE_CODENC, INA_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_INA_OPEIVS_FK 
 FOREIGN KEY (INA_OPE_CODIVS, INA_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_INA_OPEOBR_FK 
 FOREIGN KEY (INA_OPE_CODOBR, INA_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_INA_OPEREV_FK 
 FOREIGN KEY (INA_OPE_CODREV, INA_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_INA_VAD001_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD001) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD002_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD002) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD003_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD003) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD004_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD004) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD005_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD005) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD006_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD006) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD007_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD007) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD008_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD008) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD009001_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD009001) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD009002_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD009002) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD009003_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD009003) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD009004_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD009004) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD009005_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD009005) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD010IVS_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD010IVS) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD010OPE_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD010OPE) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD010REV_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD010REV) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD),
  CONSTRAINT RRHU_INA_VAD011_FK 
 FOREIGN KEY (INA_IDF_COD, INA_VAD_COD011) 
 REFERENCES TRHU_VAD (VAD_IDF_COD,VAD_COD));

ALTER TABLE TRHU_LIV ADD (
  CONSTRAINT RRHU_LIV_OPE_FK 
 FOREIGN KEY (LIV_OPE_COD, LIV_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_LMT ADD (
  CONSTRAINT RRHU_LMT_IDF_FK 
 FOREIGN KEY (LMT_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_LMT_MAO_FK 
 FOREIGN KEY (LMT_IDF_COD, LMT_MAO_COD) 
 REFERENCES TRHU_MAO (MAO_IDF_COD,MAO_COD),
  CONSTRAINT RRHU_LMT_OPE_FK 
 FOREIGN KEY (LMT_OPE_COD, LMT_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_LMT_TLL_FK 
 FOREIGN KEY (LMT_IDF_COD, LMT_MAO_COD, LMT_TLL_COD) 
 REFERENCES TRHU_TLL (TLL_IDF_COD,TLL_MAO_COD,TLL_COD));

ALTER TABLE TRHU_NMN ADD (
  CONSTRAINT RRHU_NMN_OPE_FK 
 FOREIGN KEY (NMN_OPE_COD, NMN_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_NMN_PNO_FK 
 FOREIGN KEY (NMN_PNO_COD, NMN_EMP_COD, NMN_IDF_COD) 
 REFERENCES TRHU_PNO (PNO_COD,PNO_EMP_COD,PNO_IDF_COD));

ALTER TABLE TRHU_OBO ADD (
  CONSTRAINT RRHU_OBO_OPE_FK 
 FOREIGN KEY (OBO_OPE_COD, OBO_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD));

ALTER TABLE TRHU_PCA ADD (
  CONSTRAINT RRHU_PCA_OPE_FK 
 FOREIGN KEY (PCA_OPE_COD, PCA_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_PCA_SCT_FK 
 FOREIGN KEY (PCA_SCT_COD, PCA_CAT_COD, PCA_IDF_COD) 
 REFERENCES TRHU_SCT (SCT_COD,SCT_CAT_COD,SCT_IDF_COD));

ALTER TABLE TRHU_PCN ADD (
  CONSTRAINT RRHU_PCN_CNM_FK 
 FOREIGN KEY (PCN_CNM_COD, PCN_IDF_COD) 
 REFERENCES TRHU_CNM (CNM_COD,CNM_IDF_COD),
  CONSTRAINT RRHU_PCN_SCT_FK 
 FOREIGN KEY (PCN_SCT_COD, PCN_CAT_COD, PCN_IDF_COD) 
 REFERENCES TRHU_SCT (SCT_COD,SCT_CAT_COD,SCT_IDF_COD));

ALTER TABLE TRHU_PFC ADD (
  CONSTRAINT RRHU_PFC_COF_FK 
 FOREIGN KEY (PFC_COF_COD, PFC_IDF_COD) 
 REFERENCES TRHU_COF (COF_COD,COF_IDF_COD),
  CONSTRAINT RRHU_PFC_SCT_FK 
 FOREIGN KEY (PFC_SCT_COD, PFC_CAT_COD, PFC_IDF_COD) 
 REFERENCES TRHU_SCT (SCT_COD,SCT_CAT_COD,SCT_IDF_COD));

ALTER TABLE TRHU_PSE ADD (
  CONSTRAINT RRHU_PSE_OPE_FK 
 FOREIGN KEY (PSE_OPE_COD, PSE_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_PSE_SEC_FK 
 FOREIGN KEY (PSE_SEC_COD, PSE_EMP_COD, PSE_IDF_COD) 
 REFERENCES TRHU_SEC (SEC_COD,SEC_EMP_COD,SEC_IDF_COD));

ALTER TABLE TRHU_RDI ADD (
  CONSTRAINT RRHU_RDI_ANL_FK 
 FOREIGN KEY (RDI_IDF_COD, RDI_ANL_COD) 
 REFERENCES TRHU_ANL (ANL_IDF_COD,ANL_COD),
  CONSTRAINT RRHU_RDI_CLN_FK 
 FOREIGN KEY (RDI_CLN_DAT, RDI_IDF_COD) 
 REFERENCES TRHU_CLN (CLN_DAT,CLN_IDF_COD),
  CONSTRAINT RRHU_RDI_HOR002_FK 
 FOREIGN KEY (RDI_HOR_COD002, RDI_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_RDI_HORNIT_FK 
 FOREIGN KEY (RDI_HOR_CODNIT, RDI_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_RDI_HOR_FK 
 FOREIGN KEY (RDI_HOR_COD, RDI_IDF_COD) 
 REFERENCES TRHU_HOR (HOR_COD,HOR_IDF_COD),
  CONSTRAINT RRHU_RDI_OPE_FK 
 FOREIGN KEY (RDI_OPE_COD, RDI_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_RDI_REG_FK 
 FOREIGN KEY (RDI_IDF_COD, RDI_REG_COD) 
 REFERENCES TRHU_REG (REG_IDF_COD,REG_COD),
  CONSTRAINT RRHU_RDI_SCT_FK 
 FOREIGN KEY (RDI_SCT_COD, RDI_CAT_COD, RDI_IDF_COD) 
 REFERENCES TRHU_SCT (SCT_COD,SCT_CAT_COD,SCT_IDF_COD),
  CONSTRAINT RRHU_RDI_SEC_FK 
 FOREIGN KEY (RDI_SEC_COD, RDI_EMP_COD, RDI_IDF_COD) 
 REFERENCES TRHU_SEC (SEC_COD,SEC_EMP_COD,SEC_IDF_COD),
  CONSTRAINT RRHU_RDI_ZON_FK 
 FOREIGN KEY (RDI_IDF_COD, RDI_ZON_COD) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD));

ALTER TABLE TRHU_CMH ADD (
  CONSTRAINT RRHU_CMH_COF_FK 
 FOREIGN KEY (CMH_COF_COD, CMH_IDF_COD) 
 REFERENCES TRHU_COF (COF_COD,COF_IDF_COD),
  CONSTRAINT RRHU_CMH_NMN_FK 
 FOREIGN KEY (CMH_OPE_COD, CMH_PNO_COD, CMH_EMP_COD, CMH_IDF_COD) 
 REFERENCES TRHU_NMN (NMN_OPE_COD,NMN_PNO_COD,NMN_EMP_COD,NMN_IDF_COD));

ALTER TABLE TRHU_HOL ADD (
  CONSTRAINT RRHU_HOL_HOD_FK 
 FOREIGN KEY (HOL_HOD_COD, HOL_IDF_COD) 
 REFERENCES TRHU_HOD (HOD_COD,HOD_IDF_COD),
  CONSTRAINT RRHU_HOL_RDI_FK 
 FOREIGN KEY (HOL_CLN_DAT, HOL_OPE_COD, HOL_IDF_COD) 
 REFERENCES TRHU_RDI (RDI_CLN_DAT,RDI_OPE_COD,RDI_IDF_COD));

ALTER TABLE TRHU_INR ADD (
  CONSTRAINT RRHU_INR_COF_FK 
 FOREIGN KEY (INR_COF_COD, INR_IDF_COD) 
 REFERENCES TRHU_COF (COF_COD,COF_IDF_COD),
  CONSTRAINT RRHU_INR_FFO_FK 
 FOREIGN KEY (INR_FFO_COD, INR_IDF_COD) 
 REFERENCES TRHU_FFO (FFO_COD,FFO_IDF_COD),
  CONSTRAINT RRHU_INR_IDF_FK 
 FOREIGN KEY (INR_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_INR_NOD_ENT_FK 
 FOREIGN KEY (INR_NOD_NUMENT, INR_IDF_COD) 
 REFERENCES TRHU_NOD (NOD_NUM,NOD_IDF_COD),
  CONSTRAINT RRHU_INR_NOD_SOR_FK 
 FOREIGN KEY (INR_NOD_NUMSOR, INR_IDF_COD) 
 REFERENCES TRHU_NOD (NOD_NUM,NOD_IDF_COD),
  CONSTRAINT RRHU_INR_RDI_FK 
 FOREIGN KEY (INR_CLN_DAT, INR_OPE_COD, INR_IDF_COD) 
 REFERENCES TRHU_RDI (RDI_CLN_DAT,RDI_OPE_COD,RDI_IDF_COD),
  CONSTRAINT RRHU_INR_ZON_FK 
 FOREIGN KEY (INR_IDF_COD, INR_ZON_COD) 
 REFERENCES TRHU_ZON (ZON_IDF_COD,ZON_COD));

ALTER TABLE TRHU_LFF ADD (
  CONSTRAINT RRHU_LFF_INR_FK 
 FOREIGN KEY (LFF_INR_COD, LFF_IDF_COD) 
 REFERENCES TRHU_INR (INR_COD,INR_IDF_COD));

ALTER TABLE TRHU_LNM ADD (
  CONSTRAINT RRHU_LNM_CNM_FK 
 FOREIGN KEY (LNM_CNM_COD, LNM_IDF_COD) 
 REFERENCES TRHU_CNM (CNM_COD,CNM_IDF_COD),
  CONSTRAINT RRHU_LNM_NMN_FK 
 FOREIGN KEY (LNM_OPE_COD, LNM_PNO_COD, LNM_EMP_COD, LNM_IDF_COD) 
 REFERENCES TRHU_NMN (NMN_OPE_COD,NMN_PNO_COD,NMN_EMP_COD,NMN_IDF_COD));

ALTER TABLE TRHU_ANO ADD (
  CONSTRAINT RRHU_ANO_IDF_FK 
 FOREIGN KEY (ANO_IDF_COD) 
 REFERENCES TRHU_IDF (IDF_COD),
  CONSTRAINT RRHU_ANO_INR_FK 
 FOREIGN KEY (ANO_INR_COD, ANO_IDF_COD) 
 REFERENCES TRHU_INR (INR_COD,INR_IDF_COD),
  CONSTRAINT RRHU_ANO_OPE_FK 
 FOREIGN KEY (ANO_OPE_COD, ANO_IDF_COD) 
 REFERENCES TRHU_OPE (OPE_COD,OPE_IDF_COD),
  CONSTRAINT RRHU_ANO_TAN_FK 
 FOREIGN KEY (ANO_TAN_COD, ANO_IDF_COD) 
 REFERENCES TRHU_TAN (TAN_COD,TAN_IDF_COD));

