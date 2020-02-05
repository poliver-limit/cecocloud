--
-- Create Schema Script 
--   Database Version   : 9.2.0.6.0 
--   TOAD Version       : 9.7.0.51 
--   DB Connect String  : DES 
--   Schema             : LIMIT 
--   Script Created by  : CECOGEST 
--   Script Created at  : 05/02/2020 9:17:33 
--   Physical Location  :  
--   Notes              :  
--

-- Object Counts: 
--   Indexes: 78        Columns: 157        
--   Sequences: 11 
--   Tables: 52         Columns: 504        Constraints: 73     
--   Types: 1 
--   Views: 36          


CREATE SEQUENCE DISCOVERER_SEQ
  START WITH 2
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE EUL$ID_SEQ
  START WITH 114241
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE EUL_ID_SEQ
  START WITH 116502
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SLIM_BLQ
  START WITH 3987
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SLIM_CND
  START WITH 120
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SLIM_DBG
  START WITH 2326793
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  NOORDER;


CREATE SEQUENCE SLIM_FXC
  START WITH 37
  MAXVALUE 9999999999
  MINVALUE 1
  CYCLE
  NOCACHE
  NOORDER;


CREATE SEQUENCE SLIM_HPR
  START WITH 1062932
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SLIM_LOG
  START WITH 0
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;


CREATE SEQUENCE SLIM_TMP
  START WITH 272421
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;
  

CREATE TABLE TLIM_ACC
(
  ACC_MAQ  VARCHAR2(64 BYTE)                        NULL,
  ACC_APL  VARCHAR2(24 BYTE)                        NULL,
  ACC_USU  VARCHAR2(64 BYTE)                        NULL
)
;


CREATE TABLE TLIM_BLQ
(
  BLQ_COD     NUMBER(10)                            NULL,
  BLQ_APL     VARCHAR2(15 BYTE)                     NULL,
  BLQ_TIP     VARCHAR2(30 BYTE)                     NULL,
  BLQ_FEC     DATE                                  NULL,
  BLQ_IDF     VARCHAR2(30 BYTE)                     NULL,
  BLQ_USU     VARCHAR2(30 BYTE)                     NULL,
  BLQ_DATCRE  DATE                                  NULL,
  BLQ_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  BLQ_DATMOD  DATE                                  NULL,
  BLQ_USUMOD  VARCHAR2(30 BYTE)                     NULL
)
;


CREATE TABLE TLIM_CCO
(
  CCO_CLC_COD  VARCHAR2(4 BYTE)                     NULL,
  CCO_SEQ      NUMBER(10)                           NULL,
  CCO_DES      VARCHAR2(150 BYTE)                   NULL,
  CCO_EMI      VARCHAR2(150 BYTE)                   NULL,
  CCO_USU      VARCHAR2(50 BYTE)                    NULL,
  CCO_PWD      VARCHAR2(50 BYTE)                    NULL,
  CCO_SRV      VARCHAR2(150 BYTE)                   NULL
)
;


CREATE TABLE TLIM_CLC
(
  CLC_COD     VARCHAR2(6 BYTE)                      NULL,
  CLC_NOM     VARCHAR2(40 BYTE)                     NULL,
  CLC_DATCRE  DATE                                  NULL,
  CLC_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  CLC_DATMOD  DATE                                  NULL,
  CLC_USUMOD  VARCHAR2(30 BYTE)                     NULL
)
;


CREATE TABLE TLIM_CND
(
  CND_CLC_COD  VARCHAR2(4 BYTE)                     NULL,
  CND_COD      NUMBER(18)                           NULL,
  CND_VAR      VARCHAR2(60 BYTE)                    NULL,
  CND_SQL      VARCHAR2(4000 BYTE)                  NULL
)
;


CREATE TABLE TLIM_DEBUG
(
  DBG_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  DBG_DATCRE  DATE                                  NULL,
  DBG_SEQ     NUMBER(38)                            NULL,
  DBG_MIS     VARCHAR2(4000 BYTE)                   NULL
)
;


CREATE TABLE TLIM_DIV
(
  DIV_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  DIV_COD      VARCHAR2(4 BYTE)                     NULL,
  DIV_NOM      VARCHAR2(30 BYTE)                    NULL,
  DIV_VAL      VARCHAR2(15 BYTE)                    NULL,
  DIV_DECPRU   NUMBER(1)                            NULL,
  DIV_DECIMP   NUMBER(1)                            NULL,
  DIV_DATCRE   DATE                                 NULL,
  DIV_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DIV_ABR      VARCHAR2(5 BYTE)                     NULL,
  DIV_CODCMP   VARCHAR2(1 BYTE)                     NULL,
  DIV_DATACL   DATE                                 NULL,
  DIV_DATMOD   DATE                                 NULL,
  DIV_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DIV_IMG      LONG RAW                             NULL
)
;


CREATE TABLE TLIM_DOP
(
  DOP_CLC_COD  VARCHAR2(4 BYTE)                     NULL,
  DOP_TIP      VARCHAR2(1 BYTE)                     NULL,
  DOP_COD      VARCHAR2(4 BYTE)                     NULL,
  DOP_DES      VARCHAR2(500 BYTE)                   NULL,
  DOP_DATCRE   DATE                                 NULL,
  DOP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DOP_DATMOD   DATE                                 NULL,
  DOP_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_DWB
(
  DWB_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  DWB_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  DWB_REF      NUMBER(10)                           NULL,
  DWB_TIP      NUMBER(3)                            NULL,
  DWB_CAT      VARCHAR2(10 BYTE)                    NULL,
  DWB_ACC      NUMBER(1)                            NULL,
  DWB_DATCRE   DATE                                 NULL,
  DWB_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DWB_DATMOD   DATE                                 NULL,
  DWB_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DWB_COD      VARCHAR2(20 BYTE)                    NULL,
  DWB_NOM      VARCHAR2(60 BYTE)                    NULL,
  DWB_NOMCAT   VARCHAR2(60 BYTE)                    NULL,
  DWB_LNK      VARCHAR2(250 BYTE)                   NULL,
  DWB_DES      VARCHAR2(2000 BYTE)                  NULL
)
;


CREATE TABLE TLIM_FRD
(
  FRD_COD      NUMBER(10)                           NULL,
  FRD_DIV_COD  VARCHAR2(4 BYTE)                     NULL,
  FRD_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  FRD_ETI      VARCHAR2(30 BYTE)                    NULL,
  FRD_VAL      NUMBER(14,8)                         NULL,
  FRD_DATCRE   DATE                                 NULL,
  FRD_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FRD_DATMOD   DATE                                 NULL,
  FRD_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_FRM
(
  FRM_NOM      VARCHAR2(30 BYTE)                    NULL,
  FRM_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  FRM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  FRM_DATCRE   DATE                                 NULL,
  FRM_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  FRM_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TLIM_FXC
(
  FXC_CLC_COD  VARCHAR2(4 BYTE)                     NULL,
  FXC_SEQ      NUMBER(10)                           NULL,
  FXC_INF      VARCHAR2(255 BYTE)                   NULL
)
;


CREATE TABLE TLIM_HISTPROG
(
  HPR_COD  NUMBER(10)                               NULL,
  HPR_PRG  VARCHAR2(30 BYTE)                        NULL,
  HPR_USU  VARCHAR2(30 BYTE)                        NULL,
  HPR_ENT  DATE                                     NULL,
  HPR_SOR  DATE                                     NULL,
  HPR_OBS  VARCHAR2(100 BYTE)                       NULL,
  HPR_IDF  VARCHAR2(4 BYTE)                         NULL,
  HPR_EMP  VARCHAR2(4 BYTE)                         NULL
)
;


CREATE TABLE TLIM_HVD
(
  HVD_CLC_COD    VARCHAR2(4 BYTE)                   NULL,
  HVD_DIV_COD    VARCHAR2(4 BYTE)                   NULL,
  HVD_DIA        DATE                               NULL,
  HVD_VALDIVEUR  NUMBER(15,8)                       NULL,
  HVD_DATCRE     DATE                               NULL,
  HVD_USUCRE     VARCHAR2(30 BYTE)                  NULL,
  HVD_DATMOD     DATE                               NULL,
  HVD_USUMOD     VARCHAR2(30 BYTE)                  NULL
)
;


CREATE TABLE TLIM_IDI
(
  IDI_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  IDI_COD      VARCHAR2(4 BYTE)                     NULL,
  IDI_NOM      VARCHAR2(30 BYTE)                    NULL,
  IDI_USUCRE   VARCHAR2(30 BYTE)                                 NULL,
  IDI_DATCRE   DATE                             DEFAULT sysdate                   NULL,
  IDI_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  IDI_DATMOD   DATE                                 NULL
)
;


CREATE GLOBAL TEMPORARY TABLE TLIM_LOG
(
  LOG_SEQ  NUMBER(38)                               NULL,
  LOG_TXT  VARCHAR2(2000 BYTE)                      NULL,
  LOG_DAT  DATE                                     NULL
)
ON COMMIT PRESERVE ROWS;


CREATE TABLE TLIM_MNU
(
  MNU_APL      VARCHAR2(3 BYTE)                     NULL,
  MNU_COD      NUMBER(3)                            NULL,
  MNU_NIV      NUMBER(1)                            NULL,
  MNU_ORD      NUMBER(2)                            NULL,
  MNU_MNU_COD  NUMBER(3)                            NULL,
  MNU_NOM      VARCHAR2(64 BYTE)                    NULL,
  MNU_FRM      VARCHAR2(128 BYTE)                   NULL,
  MNU_DTI      VARCHAR2(12 BYTE)                    NULL,
  MNU_REF      VARCHAR2(24 BYTE)                    NULL
)
;


CREATE TABLE TLIM_MSE
(
  MSE_CLC_COD  VARCHAR2(4 BYTE)                     NULL,
  MSE_SEQ      NUMBER(18)                           NULL,
  MSE_APL_COD  VARCHAR2(15 BYTE)                    NULL,
  MSE_TEL      VARCHAR2(60 BYTE)                    NULL,
  MSE_EML      VARCHAR2(60 BYTE)                    NULL,
  MSE_ASU      VARCHAR2(500 BYTE)                   NULL,
  MSE_TXT      VARCHAR2(1000 BYTE)                  NULL,
  MSE_TIP      VARCHAR2(1 BYTE)                     NULL,
  MSE_ENV      VARCHAR2(1 BYTE)                     NULL,
  MSE_TIPENV   VARCHAR2(1 BYTE)                     NULL,
  MSE_CLI_COD  VARCHAR2(10 BYTE)                    NULL,
  MSE_DATENV   DATE                                 NULL,
  MSE_REP      NUMBER(18)                           NULL,
  MSE_EMP_COD  VARCHAR2(4 BYTE)                     NULL,
  MSE_PRE_COD  NUMBER(18)                           NULL,
  MSE_EPR_SEQ  NUMBER(18)                           NULL,
  MSE_MEF_SEQ  NUMBER(10)                           NULL
)
;


CREATE TABLE TLIM_ORI
(
  ORI_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  ORI_COD      VARCHAR2(6 BYTE)                     NULL,
  ORI_DATCRE   DATE                                 NULL,
  ORI_NOM      VARCHAR2(30 BYTE)                    NULL,
  ORI_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  ORI_UBI      VARCHAR2(1000 BYTE)                  NULL,
  ORI_DATMOD   DATE                                 NULL,
  ORI_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_PAI
(
  PAI_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  PAI_COD      VARCHAR2(5 BYTE)                     NULL,
  PAI_NOM      VARCHAR2(30 BYTE)                    NULL,
  PAI_CEE      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TLIM_PAR
(
  PAR_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  PAR_COD      VARCHAR2(15 BYTE)                    NULL,
  PAR_VAL      VARCHAR2(100 BYTE)                   NULL,
  PAR_DATCRE   DATE                                 NULL,
  PAR_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  PAR_DES      VARCHAR2(200 BYTE)                   NULL,
  PAR_DATMOD   DATE                                 NULL,
  PAR_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_PARAMETRES
(
  PAR_COD     VARCHAR2(15 BYTE)                     NULL,
  PAR_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  PAR_DATCRE  DATE                                  NULL,
  PAR_VAL     VARCHAR2(100 BYTE)                    NULL,
  PAR_DES     VARCHAR2(200 BYTE)                    NULL,
  PAR_USUMOD  VARCHAR2(30 BYTE)                     NULL,
  PAR_DATMOD  DATE                                  NULL
)
;


CREATE TABLE TLIM_PER
(
  PER_001     VARCHAR2(64 BYTE)                     NULL,
  PER_002     VARCHAR2(12 BYTE)                     NULL,
  PER_DATCRE  DATE                                  NULL,
  PER_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  PER_DES     VARCHAR2(255 BYTE)                    NULL
)
;


CREATE TABLE TLIM_PLM
(
  PLM_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  PLM_SEQ      NUMBER(10)                           NULL,
  PLM_APL_COD  VARCHAR2(15 BYTE)                    NULL,
  PLM_TXT      VARCHAR2(1000 BYTE)                  NULL,
  PLM_TIP      VARCHAR2(1 BYTE)                     NULL,
  PLM_GRL      VARCHAR2(1 BYTE)                     NULL
)
;


CREATE TABLE TLIM_PNI
(
  PNI_COD     VARCHAR2(2 BYTE)                      NULL,
  PNI_TIPNIF  VARCHAR2(1 BYTE)                      NULL,
  PNI_NOM     VARCHAR2(40 BYTE)                     NULL,
  PNI_TAMNIF  VARCHAR2(15 BYTE)                     NULL
)
;


CREATE TABLE TLIM_PRG
(
  PRG_COD  VARCHAR2(30 BYTE)                        NULL,
  PRG_NOM  VARCHAR2(60 BYTE)                        NULL
)
;


CREATE TABLE TLIM_PRP
(
  PRP_CLC_COD    VARCHAR2(4 BYTE)                   NULL,
  PRP_SEQ        NUMBER(10)                         NULL,
  PRP_DES        VARCHAR2(1000 BYTE)                NULL,
  PRP_EXE        VARCHAR2(250 BYTE)                 NULL,
  PRP_HOR        NUMBER                             NULL,
  PRP_MIN        NUMBER                             NULL,
  PRP_EML        VARCHAR2(250 BYTE)                 NULL,
  PRP_ASU        VARCHAR2(250 BYTE)                 NULL,
  PRP_TIP        NUMBER(1)                          NULL,
  PRP_LSTPAR     VARCHAR2(4000 BYTE)                NULL,
  PRP_LSTPAREML  VARCHAR2(4000 BYTE)                NULL,
  PRP_DIAMES     NUMBER(18)                         NULL,
  PRP_DLS        VARCHAR2(1 BYTE)                   NULL,
  PRP_DMS        VARCHAR2(1 BYTE)                   NULL,
  PRP_DCS        VARCHAR2(1 BYTE)                   NULL,
  PRP_DJS        VARCHAR2(1 BYTE)                   NULL,
  PRP_DVS        VARCHAR2(1 BYTE)                   NULL,
  PRP_DSE        VARCHAR2(1 BYTE)                   NULL,
  PRP_DME        VARCHAR2(1 BYTE)                   NULL,
  PRP_DIA        VARCHAR2(1 BYTE)                   NULL,
  PRP_ACT        VARCHAR2(1 BYTE)                   NULL,
  PRP_USU        VARCHAR2(15 BYTE)                  NULL,
  PRP_PWD        VARCHAR2(15 BYTE)                  NULL,
  PRP_ULTDIAEJE  DATE                               NULL,
  PRP_FIT        VARCHAR2(500 BYTE)                 NULL,
  PRP_TXTEML     VARCHAR2(1000 BYTE)                NULL,
  PRP_NOFILEEML  VARCHAR2(1 BYTE)                   NULL
)
;


CREATE TABLE TLIM_PRV
(
  PRV_COD      VARCHAR2(3 BYTE)                     NULL,
  PRV_NOM      VARCHAR2(30 BYTE)                    NULL,
  PRV_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  PRV_PAI_COD  VARCHAR2(5 BYTE)                     NULL
)
;


CREATE TABLE TLIM_SEQ
(
  SEQ_NUM  NUMBER(10)                               NULL
)
;


CREATE TABLE TLIM_SIT
(
  SIT_TIP     VARCHAR2(7 BYTE)                      NULL,
  SIT_COD     VARCHAR2(2 BYTE)                      NULL,
  SIT_DATCRE  DATE                                  NULL,
  SIT_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  SIT_DES     VARCHAR2(300 BYTE)                    NULL,
  SIT_USUMOD  VARCHAR2(30 BYTE)                     NULL,
  SIT_DATMOD  DATE                                  NULL
)
;


CREATE TABLE TLIM_SNC
(
  SNC_CLC_COD   VARCHAR2(4 BYTE)                    NULL,
  SNC_SEQ       NUMBER(18)                          NULL,
  SNC_TIPDML    VARCHAR2(10 BYTE)                   NULL,
  SNC_TABLE     VARCHAR2(30 BYTE)                   NULL,
  SNC_SQL       VARCHAR2(4000 BYTE)                 NULL,
  SNC_USUCRE    VARCHAR2(30 BYTE)                   NULL,
  SNC_DATETIME  DATE                                NULL,
  SNC_TRS       VARCHAR2(1 BYTE)                    NULL,
  SNC_OWNER     VARCHAR2(30 BYTE)                   NULL
)
;


CREATE TABLE TLIM_TAD
(
  TAD_COD     VARCHAR2(2 BYTE)                      NULL,
  TAD_DES     VARCHAR2(30 BYTE)                     NULL,
  TAD_DATCRE  DATE                                  NULL,
  TAD_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  TAD_DATMOD  DATE                                  NULL,
  TAD_USUMOD  VARCHAR2(30 BYTE)                     NULL
)
;


CREATE TABLE TLIM_TMP
(
  TMP_SEQ    NUMBER(10)                             NULL,
  TMP_LIN    NUMBER(10)                             NULL,
  TMP_IDF    VARCHAR2(4 BYTE)                       NULL,
  TMP_EMP    VARCHAR2(4 BYTE)                       NULL,
  TMP_COD1   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD2   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD3   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD4   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD5   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD6   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD7   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD8   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD9   VARCHAR2(30 BYTE)                      NULL,
  TMP_COD10  VARCHAR2(30 BYTE)                      NULL,
  TMP_DES1   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES2   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES3   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES4   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES5   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES6   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES7   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES8   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES9   VARCHAR2(2000 BYTE)                    NULL,
  TMP_DES10  VARCHAR2(2000 BYTE)                    NULL,
  TMP_NUM1   NUMBER(18,5)                           NULL,
  TMP_NUM2   NUMBER(18,5)                           NULL,
  TMP_NUM3   NUMBER(18,5)                           NULL,
  TMP_NUM4   NUMBER(18,5)                           NULL,
  TMP_NUM5   NUMBER(18,5)                           NULL,
  TMP_NUM6   NUMBER(18,5)                           NULL,
  TMP_NUM7   NUMBER(18,5)                           NULL,
  TMP_NUM8   NUMBER(18,5)                           NULL,
  TMP_NUM9   NUMBER(15,5)                           NULL,
  TMP_NUM10  NUMBER(15,5)                           NULL,
  TMP_NUM11  NUMBER(15,5)                           NULL,
  TMP_NUM12  NUMBER(15,5)                           NULL,
  TMP_NUM13  NUMBER(15,5)                           NULL,
  TMP_NUM14  NUMBER(15,5)                           NULL,
  TMP_NUM15  NUMBER(15,5)                           NULL,
  TMP_NUM16  NUMBER(15,5)                           NULL,
  TMP_NUM17  NUMBER(15,5)                           NULL,
  TMP_NUM18  NUMBER(15,5)                           NULL,
  TMP_NUM19  NUMBER(15,5)                           NULL,
  TMP_NUM20  NUMBER(15,5)                           NULL,
  TMP_DAT1   DATE                                   NULL,
  TMP_DAT2   DATE                                   NULL,
  TMP_DAT3   DATE                                   NULL,
  TMP_DAT4   DATE                                   NULL,
  TMP_DAT5   DATE                                   NULL,
  TMP_NUM21  NUMBER(15,2)                           NULL,
  TMP_NUM22  NUMBER(15,2)                           NULL,
  TMP_NUM23  NUMBER(15,2)                           NULL,
  TMP_NUM24  NUMBER(15,2)                           NULL,
  TMP_NUM25  NUMBER(15,2)                           NULL,
  TMP_NUM26  NUMBER(15,2)                           NULL,
  TMP_NUM27  NUMBER(15,2)                           NULL
)
;


CREATE TABLE TLIM_TMR
(
  TMR_ID      NUMBER(15)                            NULL,
  TMR_IDLIN   NUMBER(15)                            NULL,
  TMR_ALFA01  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA02  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA03  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA04  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA05  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA06  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA07  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA08  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA09  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA10  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA11  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA12  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA13  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA14  VARCHAR2(2000 BYTE)                   NULL,
  TMR_ALFA15  VARCHAR2(2000 BYTE)                   NULL,
  TMR_NUM01   NUMBER(25,7)                          NULL,
  TMR_NUM02   NUMBER(25,7)                          NULL,
  TMR_NUM03   NUMBER(25,7)                          NULL,
  TMR_NUM04   NUMBER(25,7)                          NULL,
  TMR_NUM05   NUMBER(25,7)                          NULL,
  TMR_NUM06   NUMBER(25,7)                          NULL,
  TMR_NUM07   NUMBER(25,7)                          NULL,
  TMR_NUM08   NUMBER(25,7)                          NULL,
  TMR_NUM09   NUMBER(25,7)                          NULL,
  TMR_NUM10   NUMBER(25,7)                          NULL,
  TMR_NUM11   NUMBER(25,7)                          NULL,
  TMR_NUM12   NUMBER(25,7)                          NULL,
  TMR_NUM13   NUMBER(25,7)                          NULL,
  TMR_NUM14   NUMBER(25,7)                          NULL,
  TMR_NUM15   NUMBER(25,7)                          NULL,
  TMR_DIA01   DATE                                  NULL,
  TMR_DIA02   DATE                                  NULL,
  TMR_DIA03   DATE                                  NULL,
  TMR_DIA04   DATE                                  NULL,
  TMR_DIA05   DATE                                  NULL,
  TMR_DIA06   DATE                                  NULL,
  TMR_DIA07   DATE                                  NULL,
  TMR_DIA08   DATE                                  NULL,
  TMR_DIA09   DATE                                  NULL,
  TMR_DIA10   DATE                                  NULL,
  TMR_DIA11   DATE                                  NULL,
  TMR_DIA12   DATE                                  NULL,
  TMR_DIA13   DATE                                  NULL,
  TMR_DIA14   DATE                                  NULL,
  TMR_DIA15   DATE                                  NULL
)
;


CREATE TABLE TLIM_TRD
(
  TRD_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  TRD_COD      VARCHAR2(20 BYTE)                    NULL,
  TRD_IDI_COD  VARCHAR2(4 BYTE)                     NULL,
  TRD_VAL      VARCHAR2(4000 BYTE)                  NULL,
  TRD_DATCRE   DATE                                 NULL,
  TRD_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  TRD_DATMOD   DATE                                 NULL,
  TRD_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_VIA
(
  VIA_APL     VARCHAR2(15 BYTE)                     NULL,
  VIA_VBD     VARCHAR2(100 BYTE)                    NULL,
  VIA_NOM     VARCHAR2(60 BYTE)                     NULL,
  VIA_PRI     NUMBER(2)                             NULL,
  VIA_USUCRE  VARCHAR2(30 BYTE)                     NULL,
  VIA_DATCRE  DATE                                  NULL,
  VIA_USUMOD  VARCHAR2(30 BYTE)                     NULL,
  VIA_DATMOD  DATE                                  NULL,
  VIA_OWN     VARCHAR2(50 BYTE)                     NULL
)
;


CREATE TABLE TLIM_VIC
(
  VIC_SEQ      NUMBER(10)                           NULL,
  VIC_VIA_APL  VARCHAR2(15 BYTE)                    NULL,
  VIC_VIA_VBD  VARCHAR2(100 BYTE)                   NULL,
  VIC_NOM_CNS  VARCHAR2(60 BYTE)                    NULL,
  VIC_SEL      VARCHAR2(1000 BYTE)                  NULL,
  VIC_WHR      VARCHAR2(1000 BYTE)                  NULL,
  VIC_ORD      VARCHAR2(1000 BYTE)                  NULL,
  VIC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VIC_DATCRE   DATE                                 NULL,
  VIC_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  VIC_DATMOD   DATE                                 NULL,
  VIC_TAM      VARCHAR2(150 BYTE)                   NULL
)
;





CREATE INDEX ILIM_DBG_USU ON TLIM_DEBUG
(DBG_USUCRE)
;


CREATE INDEX ILIM_DIV_CLC_FK_I ON TLIM_DIV
(DIV_CLC_COD)
;


CREATE INDEX ILIM_FRD_DIV_FK ON TLIM_FRD
(FRD_DIV_COD, FRD_CLC_COD)
;


CREATE INDEX ILIM_FRM_CLC_FK ON TLIM_FRM
(FRM_CLC_COD)
;


CREATE INDEX ILIM_IDI_CLC_FK_I ON TLIM_IDI
(IDI_CLC_COD)
;


CREATE INDEX ILIM_ORI_CLC_FK_I ON TLIM_ORI
(ORI_CLC_COD)
;


CREATE INDEX ILIM_PAI_CLC_FK_I ON TLIM_PAI
(PAI_CLC_COD)
;


CREATE INDEX ILIM_PAR_CLC_FK ON TLIM_PAR
(PAR_CLC_COD)
;


CREATE UNIQUE INDEX ILIM_PAR_PK ON TLIM_PAR
(PAR_COD, PAR_CLC_COD)
;


CREATE INDEX ILIM_PRV_PAI_FK_I ON TLIM_PRV
(PRV_CLC_COD, PRV_PAI_COD)
;


CREATE UNIQUE INDEX ILIM_TRD_PK ON TLIM_TRD
(TRD_CLC_COD, TRD_COD, TRD_IDI_COD)
;


CREATE INDEX ILIM_VIC_VIA_FK ON TLIM_VIC
(VIC_VIA_APL, VIC_VIA_VBD)
;





CREATE UNIQUE INDEX RLIM_ACC_PK ON TLIM_ACC
(ACC_MAQ, ACC_USU, ACC_APL)
;


CREATE UNIQUE INDEX RLIM_BLQ_PK ON TLIM_BLQ
(BLQ_COD)
;


CREATE UNIQUE INDEX RLIM_CCO_PK ON TLIM_CCO
(CCO_CLC_COD, CCO_SEQ)
;


CREATE UNIQUE INDEX RLIM_CLC_PK ON TLIM_CLC
(CLC_COD)
;


CREATE UNIQUE INDEX RLIM_CND_PK ON TLIM_CND
(CND_CLC_COD, CND_COD, CND_VAR)
;


CREATE UNIQUE INDEX RLIM_DIV_PK ON TLIM_DIV
(DIV_COD, DIV_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_DWB_PK ON TLIM_DWB
(DWB_CLC_COD, DWB_REF)
;


CREATE UNIQUE INDEX RLIM_FRD_PK ON TLIM_FRD
(FRD_COD, FRD_DIV_COD, FRD_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_FRM_PK ON TLIM_FRM
(FRM_NOM, FRM_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_FXC_PK ON TLIM_FXC
(FXC_CLC_COD, FXC_SEQ)
;


CREATE UNIQUE INDEX RLIM_HPR_PK ON TLIM_HISTPROG
(HPR_COD)
;


CREATE UNIQUE INDEX RLIM_HVD_PK ON TLIM_HVD
(HVD_CLC_COD, HVD_DIV_COD, HVD_DIA)
;


CREATE UNIQUE INDEX RLIM_IDI_PK ON TLIM_IDI
(IDI_CLC_COD, IDI_COD)
;


CREATE UNIQUE INDEX RLIM_MNU_PK ON TLIM_MNU
(MNU_COD)
;


CREATE UNIQUE INDEX RLIM_MSE_PK ON TLIM_MSE
(MSE_SEQ, MSE_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_ORI_PK ON TLIM_ORI
(ORI_COD, ORI_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_PAI_PK ON TLIM_PAI
(PAI_CLC_COD, PAI_COD)
;


CREATE UNIQUE INDEX RLIM_PAR_PK ON TLIM_PARAMETRES
(PAR_COD)
;


CREATE UNIQUE INDEX RLIM_PER_PK ON TLIM_PER
(PER_001, PER_002)
;


CREATE UNIQUE INDEX RLIM_PLM_PK ON TLIM_PLM
(PLM_SEQ, PLM_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_PNI_PK ON TLIM_PNI
(PNI_COD)
;


CREATE UNIQUE INDEX RLIM_PRG_PK ON TLIM_PRG
(PRG_COD)
;


CREATE UNIQUE INDEX RLIM_PRP_PK ON TLIM_PRP
(PRP_CLC_COD, PRP_SEQ)
;


CREATE UNIQUE INDEX RLIM_PRV_PK ON TLIM_PRV
(PRV_COD, PRV_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_SIT_PK ON TLIM_SIT
(SIT_TIP, SIT_COD)
;


CREATE UNIQUE INDEX RLIM_SNC_PK ON TLIM_SNC
(SNC_CLC_COD, SNC_SEQ)
;


CREATE UNIQUE INDEX RLIM_TAD_PK ON TLIM_TAD
(TAD_COD)
;


CREATE UNIQUE INDEX RLIM_TMP_PK ON TLIM_TMP
(TMP_SEQ, TMP_LIN)
;


CREATE UNIQUE INDEX RLIM_TMR_PK ON TLIM_TMR
(TMR_ID, TMR_IDLIN)
;


CREATE UNIQUE INDEX RLIM_VIA_PK ON TLIM_VIA
(VIA_APL, VIA_VBD)
;


CREATE UNIQUE INDEX RLIM_VIC_PK ON TLIM_VIC
(VIC_SEQ)
;





CREATE TABLE TLIM_APL
(
  APL_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  APL_COD      VARCHAR2(15 BYTE)                    NULL,
  APL_NOM      VARCHAR2(70 BYTE)                    NULL,
  APL_EJE      VARCHAR2(1000 BYTE)                  NULL,
  APL_DATCRE   DATE                                 NULL,
  APL_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  APL_DATMOD   DATE                                 NULL,
  APL_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_CAM
(
  CAM_NOM      VARCHAR2(100 BYTE)                   NULL,
  CAM_FRM_NOM  VARCHAR2(30 BYTE)                    NULL,
  CAM_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  CAM_DATCRE   DATE                                 NULL,
  CAM_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CAM_DATMOD   DATE                                 NULL,
  CAM_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_CFG
(
  CFG_COD      VARCHAR2(30 BYTE)                    NULL,
  CFG_FRM_NOM  VARCHAR2(30 BYTE)                    NULL,
  CFG_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  CFG_DATCRE   DATE                                 NULL,
  CFG_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  CFG_DATMOD   DATE                                 NULL,
  CFG_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_CPO
(
  CPO_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  CPO_CPO      VARCHAR2(6 BYTE)                     NULL,
  CPO_POB      VARCHAR2(30 BYTE)                    NULL,
  CPO_PRV      VARCHAR2(30 BYTE)                    NULL,
  CPO_PAI      VARCHAR2(30 BYTE)                    NULL,
  CPO_CODMUN   NUMBER(3)                            NULL,
  CPO_MUN      VARCHAR2(30 BYTE)                    NULL,
  CPO_PRV_COD  VARCHAR2(3 BYTE)                     NULL
)
;


CREATE TABLE TLIM_DAP
(
  DAP_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  DAP_ORI_COD  VARCHAR2(6 BYTE)                     NULL,
  DAP_COD      VARCHAR2(120 BYTE)                   NULL,
  DAP_NOM      VARCHAR2(1000 BYTE)                  NULL,
  DAP_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DAP_DATCRE   DATE                                 NULL,
  DAP_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  DAP_DATMOD   DATE                                 NULL
)
;


CREATE TABLE TLIM_TDO
(
  TDO_CLC_COD     VARCHAR2(6 BYTE)                  NULL,
  TDO_COD         VARCHAR2(4 BYTE)                  NULL,
  TDO_APL_COD     VARCHAR2(15 BYTE)                 NULL,
  TDO_APL_COD002  VARCHAR2(15 BYTE)                 NULL,
  TDO_DATCRE      DATE                              NULL,
  TDO_NOM         VARCHAR2(30 BYTE)                 NULL,
  TDO_USUCRE      VARCHAR2(30 BYTE)                 NULL,
  TDO_PLT         VARCHAR2(30 BYTE)                 NULL,
  TDO_NOMDOCDEF   VARCHAR2(1000 BYTE)               NULL,
  TDO_DATMOD      DATE                              NULL,
  TDO_USUMOD      VARCHAR2(30 BYTE)                 NULL,
  TDO_EXN         VARCHAR2(3 BYTE)                  NULL,
  TDO_FUNINC      NUMBER(2)                         NULL,
  TDO_TIPPRGCPT   VARCHAR2(1 BYTE)                  NULL
)
;


CREATE TABLE TLIM_VAL
(
  VAL_CAM_NOM  VARCHAR2(100 BYTE)                   NULL,
  VAL_CFG_COD  VARCHAR2(30 BYTE)                    NULL,
  VAL_FRM_NOM  VARCHAR2(30 BYTE)                    NULL,
  VAL_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  VAL_VAL      VARCHAR2(2000 BYTE)                  NULL,
  VAL_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  VAL_DATCRE   DATE                                 NULL,
  VAL_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  VAL_DATMOD   DATE                                 NULL
)
;


CREATE INDEX ILIM_APL_CLC_FK_I ON TLIM_APL
(APL_CLC_COD)
;


CREATE INDEX ILIM_CAM_FRM_FK ON TLIM_CAM
(CAM_FRM_NOM, CAM_CLC_COD)
;


CREATE INDEX ILIM_CFG_FRM_FK ON TLIM_CFG
(CFG_FRM_NOM, CFG_CLC_COD)
;


CREATE INDEX ILIM_CPO_CLC_FK_I ON TLIM_CPO
(CPO_CLC_COD)
;


CREATE INDEX ILIM_CPO_PRV_FK_I ON TLIM_CPO
(CPO_PRV_COD, CPO_CLC_COD)
;


CREATE INDEX ILIM_DAP_ORI_FK_I ON TLIM_DAP
(DAP_ORI_COD, DAP_CLC_COD)
;


CREATE INDEX ILIM_TDO_APL002_FK_I ON TLIM_TDO
(TDO_APL_COD002, TDO_CLC_COD)
;


CREATE INDEX ILIM_TDO_APL_FK_I ON TLIM_TDO
(TDO_APL_COD, TDO_CLC_COD)
;


CREATE INDEX ILIM_TDO_CLC_FK_I ON TLIM_TDO
(TDO_CLC_COD)
;


CREATE INDEX ILIM_VAL_CAM_FK ON TLIM_VAL
(VAL_CAM_NOM, VAL_FRM_NOM, VAL_CLC_COD)
;


CREATE INDEX ILIM_VAL_CFG_FK ON TLIM_VAL
(VAL_CFG_COD, VAL_FRM_NOM, VAL_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_APL_PK ON TLIM_APL
(APL_COD, APL_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_CAM_PK ON TLIM_CAM
(CAM_NOM, CAM_FRM_NOM, CAM_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_CFG_PK ON TLIM_CFG
(CFG_COD, CFG_FRM_NOM, CFG_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_CPO_PK ON TLIM_CPO
(CPO_CLC_COD, CPO_CPO)
;


CREATE UNIQUE INDEX RLIM_DAP_PK ON TLIM_DAP
(DAP_CLC_COD, DAP_ORI_COD, DAP_COD)
;


CREATE UNIQUE INDEX RLIM_TDO_PK ON TLIM_TDO
(TDO_COD, TDO_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_VAL_PK ON TLIM_VAL
(VAL_CAM_NOM, VAL_CFG_COD, VAL_FRM_NOM, VAL_CLC_COD)
;


CREATE TABLE TLIM_DOC
(
  DOC_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  DOC_ORI_COD  VARCHAR2(6 BYTE)                     NULL,
  DOC_DAP_COD  VARCHAR2(120 BYTE)                   NULL,
  DOC_SEQ      NUMBER(5)                            NULL,
  DOC_TDO_COD  VARCHAR2(4 BYTE)                     NULL,
  DOC_DATCRE   DATE                                 NULL,
  DOC_NOM      VARCHAR2(1000 BYTE)                  NULL,
  DOC_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  DOC_PTH      VARCHAR2(1000 BYTE)                  NULL,
  DOC_NOMFIT   VARCHAR2(1000 BYTE)                  NULL,
  DOC_UBIFSC   VARCHAR2(15 BYTE)                    NULL,
  DOC_OBS      VARCHAR2(1000 BYTE)                  NULL,
  DOC_DATMOD   DATE                                 NULL,
  DOC_USUMOD   VARCHAR2(30 BYTE)                    NULL
)
;


CREATE TABLE TLIM_REF
(
  REF_DAP_COD  VARCHAR2(120 BYTE)                   NULL,
  REF_CLC_COD  VARCHAR2(6 BYTE)                     NULL,
  REF_ORI_COD  VARCHAR2(6 BYTE)                     NULL,
  REF_DOC_COD  VARCHAR2(50 BYTE)                    NULL,
  REF_DOC_SEQ  NUMBER(5)                            NULL,
  REF_SEQ      NUMBER(3)                            NULL,
  REF_USUCRE   VARCHAR2(30 BYTE)                    NULL,
  REF_DATCRE   DATE                                 NULL,
  REF_USUMOD   VARCHAR2(30 BYTE)                    NULL,
  REF_DATMOD   DATE                                 NULL
)
;


CREATE INDEX ILIM_DOC_DAP_FK_I ON TLIM_DOC
(DOC_CLC_COD, DOC_ORI_COD, DOC_DAP_COD)
;


CREATE INDEX ILIM_DOC_ORI_FK_I ON TLIM_DOC
(DOC_ORI_COD, DOC_CLC_COD)
;


CREATE INDEX ILIM_DOC_TDO_FK_I ON TLIM_DOC
(DOC_TDO_COD, DOC_CLC_COD)
;


CREATE INDEX ILIM_REF_DAP_FK_I ON TLIM_REF
(REF_CLC_COD, REF_ORI_COD, REF_DAP_COD)
;


CREATE INDEX ILIM_REF_DOC_FK_I ON TLIM_REF
(REF_DOC_COD, REF_DOC_SEQ)
;


CREATE UNIQUE INDEX RLIM_DOC_PK ON TLIM_DOC
(DOC_DAP_COD, DOC_SEQ, DOC_ORI_COD, DOC_CLC_COD)
;


CREATE UNIQUE INDEX RLIM_REF_PK ON TLIM_REF
(REF_DAP_COD, REF_CLC_COD, REF_ORI_COD, REF_DOC_COD, REF_DOC_SEQ, 
REF_SEQ)
;


ALTER TABLE TLIM_ACC ADD (
  CONSTRAINT RLIM_ACC_PK
 PRIMARY KEY
 (ACC_MAQ, ACC_USU, ACC_APL)
    USING INDEX 
    );

ALTER TABLE TLIM_BLQ ADD (
  CONSTRAINT RLIM_BLQ_PK
 PRIMARY KEY
 (BLQ_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_CCO ADD (
  CONSTRAINT RLIM_CCO_PK
 PRIMARY KEY
 (CCO_CLC_COD, CCO_SEQ)
    USING INDEX 
    );

ALTER TABLE TLIM_CLC ADD (
  CONSTRAINT RLIM_CLC_PK
 PRIMARY KEY
 (CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_CND ADD (
  CONSTRAINT RLIM_CND_PK
 PRIMARY KEY
 (CND_CLC_COD, CND_COD, CND_VAR)
    USING INDEX 
    );

ALTER TABLE TLIM_DIV ADD (
  CONSTRAINT RLIM_DIV_PK
 PRIMARY KEY
 (DIV_COD, DIV_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_DOP ADD (
  PRIMARY KEY
 (DOP_CLC_COD, DOP_TIP, DOP_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_DWB ADD (
  CONSTRAINT RLIM_DWB_PK
 PRIMARY KEY
 (DWB_CLC_COD, DWB_REF)
    USING INDEX 
    );

ALTER TABLE TLIM_FRD ADD (
  CONSTRAINT RLIM_FRD_PK
 PRIMARY KEY
 (FRD_COD, FRD_DIV_COD, FRD_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_FRM ADD (
  CONSTRAINT RLIM_FRM_PK
 PRIMARY KEY
 (FRM_NOM, FRM_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_FXC ADD (
  CONSTRAINT RLIM_FXC_PK
 PRIMARY KEY
 (FXC_CLC_COD, FXC_SEQ)
    USING INDEX 
    );

ALTER TABLE TLIM_HISTPROG ADD (
  CONSTRAINT RLIM_HPR_PK
 PRIMARY KEY
 (HPR_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_HVD ADD (
  CONSTRAINT RLIM_HVD_PK
 PRIMARY KEY
 (HVD_CLC_COD, HVD_DIV_COD, HVD_DIA)
    USING INDEX 
    );

ALTER TABLE TLIM_IDI ADD (
  CONSTRAINT RLIM_IDI_PK
 PRIMARY KEY
 (IDI_CLC_COD, IDI_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_MNU ADD (
  CONSTRAINT RLIM_MNU_PK
 PRIMARY KEY
 (MNU_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_MSE ADD (
  CONSTRAINT RLIM_MSE_PK
 PRIMARY KEY
 (MSE_SEQ, MSE_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_ORI ADD (
  CONSTRAINT RLIM_ORI_PK
 PRIMARY KEY
 (ORI_COD, ORI_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_PAI ADD (
  CONSTRAINT RLIM_PAI_PK
 PRIMARY KEY
 (PAI_CLC_COD, PAI_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_PAR ADD (
  CONSTRAINT ILIM_PAR_PK
 PRIMARY KEY
 (PAR_COD, PAR_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_PARAMETRES ADD (
  CONSTRAINT RLIM_PAR_PK
 PRIMARY KEY
 (PAR_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_PER ADD (
  CONSTRAINT RLIM_PER_PK
 PRIMARY KEY
 (PER_001, PER_002)
    USING INDEX 
    );

ALTER TABLE TLIM_PLM ADD (
  CONSTRAINT RLIM_PLM_PK
 PRIMARY KEY
 (PLM_SEQ, PLM_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_PNI ADD (
  CONSTRAINT RLIM_PNI_PK
 PRIMARY KEY
 (PNI_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_PRG ADD (
  CONSTRAINT RLIM_PRG_PK
 PRIMARY KEY
 (PRG_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_PRP ADD (
  CONSTRAINT RLIM_PRP_PK
 PRIMARY KEY
 (PRP_CLC_COD, PRP_SEQ)
    USING INDEX 
    );

ALTER TABLE TLIM_PRV ADD (
  CONSTRAINT RLIM_PRV_PK
 PRIMARY KEY
 (PRV_COD, PRV_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_SIT ADD (
  CONSTRAINT RLIM_SIT_PK
 PRIMARY KEY
 (SIT_TIP, SIT_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_SNC ADD (
  CONSTRAINT RLIM_SNC_PK
 PRIMARY KEY
 (SNC_CLC_COD, SNC_SEQ)
    USING INDEX 
    );

ALTER TABLE TLIM_TAD ADD (
  CONSTRAINT RLIM_TAD_PK
 PRIMARY KEY
 (TAD_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_TMP ADD (
  CONSTRAINT RLIM_TMP_PK
 PRIMARY KEY
 (TMP_SEQ, TMP_LIN)
    USING INDEX 
    );

ALTER TABLE TLIM_TMR ADD (
  CONSTRAINT RLIM_TMR_PK
 PRIMARY KEY
 (TMR_ID, TMR_IDLIN)
    USING INDEX 
    );

ALTER TABLE TLIM_TRD ADD (
  CONSTRAINT ILIM_TRD_PK
 PRIMARY KEY
 (TRD_CLC_COD, TRD_COD, TRD_IDI_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_VIA ADD (
  CONSTRAINT RLIM_VIA_PK
 PRIMARY KEY
 (VIA_APL, VIA_VBD)
    USING INDEX 
    );

ALTER TABLE TLIM_VIC ADD (
  CONSTRAINT RLIM_VIC_PK
 PRIMARY KEY
 (VIC_SEQ)
    USING INDEX 
    );

ALTER TABLE TLIM_APL ADD (
  CONSTRAINT RLIM_APL_PK
 PRIMARY KEY
 (APL_COD, APL_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_CAM ADD (
  CONSTRAINT RLIM_CAM_PK
 PRIMARY KEY
 (CAM_NOM, CAM_FRM_NOM, CAM_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_CFG ADD (
  CONSTRAINT RLIM_CFG_PK
 PRIMARY KEY
 (CFG_COD, CFG_FRM_NOM, CFG_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_CPO ADD (
  CONSTRAINT RLIM_CPO_PK
 PRIMARY KEY
 (CPO_CLC_COD, CPO_CPO)
    USING INDEX 
    );

ALTER TABLE TLIM_DAP ADD (
  CONSTRAINT RLIM_DAP_PK
 PRIMARY KEY
 (DAP_CLC_COD, DAP_ORI_COD, DAP_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_TDO ADD (
  CONSTRAINT RLIM_TDO_PK
 PRIMARY KEY
 (TDO_COD, TDO_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_VAL ADD (
  CONSTRAINT RLIM_VAL_PK
 PRIMARY KEY
 (VAL_CAM_NOM, VAL_CFG_COD, VAL_FRM_NOM, VAL_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_DOC ADD (
  CONSTRAINT RLIM_DOC_PK
 PRIMARY KEY
 (DOC_DAP_COD, DOC_SEQ, DOC_ORI_COD, DOC_CLC_COD)
    USING INDEX 
    );

ALTER TABLE TLIM_REF ADD (
  CONSTRAINT RLIM_REF_PK
 PRIMARY KEY
 (REF_DAP_COD, REF_CLC_COD, REF_ORI_COD, REF_DOC_COD, REF_DOC_SEQ, REF_SEQ)
    USING INDEX 
    );

ALTER TABLE TLIM_DIV ADD (
  CONSTRAINT RLIM_DIV_CLC_FK 
 FOREIGN KEY (DIV_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_DWB ADD (
  CONSTRAINT RLIM_DWB_CLC_FK 
 FOREIGN KEY (DWB_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_FRD ADD (
  CONSTRAINT RLIM_FRD_DIV_FK 
 FOREIGN KEY (FRD_DIV_COD, FRD_CLC_COD) 
 REFERENCES TLIM_DIV (DIV_COD,DIV_CLC_COD));

ALTER TABLE TLIM_FRM ADD (
  CONSTRAINT RLIM_FRM_CLC_FK 
 FOREIGN KEY (FRM_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_HVD ADD (
  CONSTRAINT RLIM_HVD_DIV_FK 
 FOREIGN KEY (HVD_DIV_COD, HVD_CLC_COD) 
 REFERENCES TLIM_DIV (DIV_COD,DIV_CLC_COD));

ALTER TABLE TLIM_IDI ADD (
  CONSTRAINT RLIM_IDI_CLC_FK 
 FOREIGN KEY (IDI_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_MNU ADD (
  CONSTRAINT RLIM_MNU_MNU_FK 
 FOREIGN KEY (MNU_COD) 
 REFERENCES TLIM_MNU (MNU_COD));

ALTER TABLE TLIM_MSE ADD (
  CONSTRAINT RLIM_MSE_CLC_FK 
 FOREIGN KEY (MSE_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_ORI ADD (
  CONSTRAINT RLIM_ORI_CLC_FK 
 FOREIGN KEY (ORI_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_PAI ADD (
  CONSTRAINT RLIM_PAI_CLC_FK 
 FOREIGN KEY (PAI_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_PAR ADD (
  CONSTRAINT ILIM_PAR_CLC_FK 
 FOREIGN KEY (PAR_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_PLM ADD (
  CONSTRAINT RLIM_PLM_CLC_FK 
 FOREIGN KEY (PLM_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_PRV ADD (
  CONSTRAINT RLIM_PRV_PAI_FK 
 FOREIGN KEY (PRV_CLC_COD, PRV_PAI_COD) 
 REFERENCES TLIM_PAI (PAI_CLC_COD,PAI_COD));

ALTER TABLE TLIM_TRD ADD (
  CONSTRAINT ILIM_TRD_CLC_FK 
 FOREIGN KEY (TRD_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_VIC ADD (
  CONSTRAINT RLIM_VIC_VIA_FK 
 FOREIGN KEY (VIC_VIA_APL, VIC_VIA_VBD) 
 REFERENCES TLIM_VIA (VIA_APL,VIA_VBD));

ALTER TABLE TLIM_APL ADD (
  CONSTRAINT RLIM_APL_CLC_FK 
 FOREIGN KEY (APL_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_CAM ADD (
  CONSTRAINT RLIM_CAM_FRM_FK 
 FOREIGN KEY (CAM_FRM_NOM, CAM_CLC_COD) 
 REFERENCES TLIM_FRM (FRM_NOM,FRM_CLC_COD));

ALTER TABLE TLIM_CFG ADD (
  CONSTRAINT RLIM_CFG_FRM_FK 
 FOREIGN KEY (CFG_FRM_NOM, CFG_CLC_COD) 
 REFERENCES TLIM_FRM (FRM_NOM,FRM_CLC_COD));

ALTER TABLE TLIM_CPO ADD (
  CONSTRAINT RLIM_CPO_CLC_FK 
 FOREIGN KEY (CPO_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD),
  CONSTRAINT RLIM_CPO_PRV_FK 
 FOREIGN KEY (CPO_PRV_COD, CPO_CLC_COD) 
 REFERENCES TLIM_PRV (PRV_COD,PRV_CLC_COD));

ALTER TABLE TLIM_DAP ADD (
  CONSTRAINT RLIM_DAP_ORI_FK 
 FOREIGN KEY (DAP_ORI_COD, DAP_CLC_COD) 
 REFERENCES TLIM_ORI (ORI_COD,ORI_CLC_COD));

ALTER TABLE TLIM_TDO ADD (
  CONSTRAINT RLIM_TDO_APL002_FK 
 FOREIGN KEY (TDO_APL_COD002, TDO_CLC_COD) 
 REFERENCES TLIM_APL (APL_COD,APL_CLC_COD),
  CONSTRAINT RLIM_TDO_APL_FK 
 FOREIGN KEY (TDO_APL_COD, TDO_CLC_COD) 
 REFERENCES TLIM_APL (APL_COD,APL_CLC_COD),
  CONSTRAINT RLIM_TDO_CLC_FK 
 FOREIGN KEY (TDO_CLC_COD) 
 REFERENCES TLIM_CLC (CLC_COD));

ALTER TABLE TLIM_VAL ADD (
  CONSTRAINT RLIM_VAL_CAM_FK 
 FOREIGN KEY (VAL_CAM_NOM, VAL_FRM_NOM, VAL_CLC_COD) 
 REFERENCES TLIM_CAM (CAM_NOM,CAM_FRM_NOM,CAM_CLC_COD),
  CONSTRAINT RLIM_VAL_CFG_FK 
 FOREIGN KEY (VAL_CFG_COD, VAL_FRM_NOM, VAL_CLC_COD) 
 REFERENCES TLIM_CFG (CFG_COD,CFG_FRM_NOM,CFG_CLC_COD));

ALTER TABLE TLIM_DOC ADD (
  CONSTRAINT RLIM_DOC_DAP_FK 
 FOREIGN KEY (DOC_CLC_COD, DOC_ORI_COD, DOC_DAP_COD) 
 REFERENCES TLIM_DAP (DAP_CLC_COD,DAP_ORI_COD,DAP_COD),
  CONSTRAINT RLIM_DOC_TDO_FK 
 FOREIGN KEY (DOC_TDO_COD, DOC_CLC_COD) 
 REFERENCES TLIM_TDO (TDO_COD,TDO_CLC_COD));

ALTER TABLE TLIM_REF ADD (
  CONSTRAINT RLIM_REF_DAP_FK 
 FOREIGN KEY (REF_CLC_COD, REF_ORI_COD, REF_DAP_COD) 
 REFERENCES TLIM_DAP (DAP_CLC_COD,DAP_ORI_COD,DAP_COD),
  CONSTRAINT RLIM_REF_DOC_FK 
 FOREIGN KEY (REF_DOC_COD, REF_DOC_SEQ, REF_ORI_COD, REF_CLC_COD) 
 REFERENCES TLIM_DOC (DOC_DAP_COD,DOC_SEQ,DOC_ORI_COD,DOC_CLC_COD));

