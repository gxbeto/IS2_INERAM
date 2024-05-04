package com ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class protocololoaddvcombo extends GXProcedure
{
   public protocololoaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( protocololoaddvcombo.class ), "" );
   }

   public protocololoaddvcombo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             long aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      protocololoaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        long aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             long aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      protocololoaddvcombo.this.AV16ComboName = aP0;
      protocololoaddvcombo.this.AV17TrnMode = aP1;
      protocololoaddvcombo.this.AV18IsDynamicCall = aP2;
      protocololoaddvcombo.this.AV19ProtID = aP3;
      protocololoaddvcombo.this.AV20SearchTxtParms = aP4;
      protocololoaddvcombo.this.aP5 = aP5;
      protocololoaddvcombo.this.aP6 = aP6;
      protocololoaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0];
      AV10MaxItems = 10 ;
      AV12PageIndex = (short)(((GXutil.strcmp("", AV20SearchTxtParms)==0)||GXutil.startsWith( AV17TrnMode, "GET") ? 0 : (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( AV20SearchTxtParms, 1, 2), "."))))) ;
      AV13SearchTxt = ((GXutil.strcmp("", AV20SearchTxtParms)==0)||GXutil.startsWith( AV17TrnMode, "GET") ? AV20SearchTxtParms : GXutil.substring( AV20SearchTxtParms, 3, -1)) ;
      AV11SkipItems = (short)(AV12PageIndex*AV10MaxItems) ;
      if ( GXutil.strcmp(AV16ComboName, "EnfID") == 0 )
      {
         /* Execute user subroutine: 'LOADCOMBOITEMS_ENFID' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(AV16ComboName, "CntdID") == 0 )
      {
         /* Execute user subroutine: 'LOADCOMBOITEMS_CNTDID' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_ENFID' Routine */
      returnInSub = false ;
      if ( AV18IsDynamicCall )
      {
         GXPagingFrom2 = AV11SkipItems ;
         GXPagingTo2 = AV10MaxItems ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV13SearchTxt ,
                                              A2EnfNombre } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN
                                              }
         });
         lV13SearchTxt = GXutil.concat( GXutil.rtrim( AV13SearchTxt), "%", "") ;
         /* Using cursor P002H2 */
         pr_default.execute(0, new Object[] {lV13SearchTxt, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2EnfNombre = P002H2_A2EnfNombre[0] ;
            n2EnfNombre = P002H2_n2EnfNombre[0] ;
            A1EnfID = P002H2_A1EnfID[0] ;
            n1EnfID = P002H2_n1EnfID[0] ;
            AV15Combo_DataItem = (com.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A1EnfID, 10, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A2EnfNombre );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV10MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV23Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV17TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV17TrnMode, "GET") != 0 )
            {
               /* Using cursor P002H3 */
               pr_default.execute(1, new Object[] {Long.valueOf(AV19ProtID)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A25ProtID = P002H3_A25ProtID[0] ;
                  A1EnfID = P002H3_A1EnfID[0] ;
                  n1EnfID = P002H3_n1EnfID[0] ;
                  A2EnfNombre = P002H3_A2EnfNombre[0] ;
                  n2EnfNombre = P002H3_n2EnfNombre[0] ;
                  A2EnfNombre = P002H3_A2EnfNombre[0] ;
                  n2EnfNombre = P002H3_n2EnfNombre[0] ;
                  AV21SelectedValue = ((0==A1EnfID) ? "" : GXutil.trim( GXutil.str( A1EnfID, 10, 0))) ;
                  AV22SelectedText = A2EnfNombre ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV27EnfID = GXutil.lval( AV13SearchTxt) ;
               /* Using cursor P002H4 */
               pr_default.execute(2, new Object[] {Long.valueOf(AV27EnfID)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1EnfID = P002H4_A1EnfID[0] ;
                  n1EnfID = P002H4_n1EnfID[0] ;
                  A2EnfNombre = P002H4_A2EnfNombre[0] ;
                  n2EnfNombre = P002H4_n2EnfNombre[0] ;
                  AV22SelectedText = A2EnfNombre ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
            }
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_CNTDID' Routine */
      returnInSub = false ;
      if ( AV18IsDynamicCall )
      {
         GXPagingFrom5 = AV11SkipItems ;
         GXPagingTo5 = AV10MaxItems ;
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV13SearchTxt ,
                                              A24CntdDesc } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV13SearchTxt = GXutil.concat( GXutil.rtrim( AV13SearchTxt), "%", "") ;
         /* Using cursor P002H5 */
         pr_default.execute(3, new Object[] {lV13SearchTxt, Integer.valueOf(GXPagingFrom5), Integer.valueOf(GXPagingTo5), Integer.valueOf(GXPagingTo5)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A24CntdDesc = P002H5_A24CntdDesc[0] ;
            A23CntdID = P002H5_A23CntdID[0] ;
            n23CntdID = P002H5_n23CntdID[0] ;
            AV15Combo_DataItem = (com.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A23CntdID, 10, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A24CntdDesc );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV10MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV23Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV17TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV17TrnMode, "GET") != 0 )
            {
               /* Using cursor P002H6 */
               pr_default.execute(4, new Object[] {Long.valueOf(AV19ProtID)});
               while ( (pr_default.getStatus(4) != 101) )
               {
                  A25ProtID = P002H6_A25ProtID[0] ;
                  A23CntdID = P002H6_A23CntdID[0] ;
                  n23CntdID = P002H6_n23CntdID[0] ;
                  A24CntdDesc = P002H6_A24CntdDesc[0] ;
                  A24CntdDesc = P002H6_A24CntdDesc[0] ;
                  AV21SelectedValue = ((0==A23CntdID) ? "" : GXutil.trim( GXutil.str( A23CntdID, 10, 0))) ;
                  AV22SelectedText = A24CntdDesc ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(4);
            }
            else
            {
               AV28CntdID = GXutil.lval( AV13SearchTxt) ;
               /* Using cursor P002H7 */
               pr_default.execute(5, new Object[] {Long.valueOf(AV28CntdID)});
               while ( (pr_default.getStatus(5) != 101) )
               {
                  A23CntdID = P002H7_A23CntdID[0] ;
                  n23CntdID = P002H7_n23CntdID[0] ;
                  A24CntdDesc = P002H7_A24CntdDesc[0] ;
                  AV22SelectedText = A24CntdDesc ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(5);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = protocololoaddvcombo.this.AV21SelectedValue;
      this.aP6[0] = protocololoaddvcombo.this.AV22SelectedText;
      this.aP7[0] = protocololoaddvcombo.this.AV23Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21SelectedValue = "" ;
      AV22SelectedText = "" ;
      AV23Combo_DataJson = "" ;
      AV9WWPContext = new com.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.wwpbaseobjects.SdtWWPContext[1] ;
      AV13SearchTxt = "" ;
      lV13SearchTxt = "" ;
      A2EnfNombre = "" ;
      P002H2_A2EnfNombre = new String[] {""} ;
      P002H2_n2EnfNombre = new boolean[] {false} ;
      P002H2_A1EnfID = new long[1] ;
      P002H2_n1EnfID = new boolean[] {false} ;
      AV15Combo_DataItem = new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P002H3_A25ProtID = new long[1] ;
      P002H3_A1EnfID = new long[1] ;
      P002H3_n1EnfID = new boolean[] {false} ;
      P002H3_A2EnfNombre = new String[] {""} ;
      P002H3_n2EnfNombre = new boolean[] {false} ;
      P002H4_A1EnfID = new long[1] ;
      P002H4_n1EnfID = new boolean[] {false} ;
      P002H4_A2EnfNombre = new String[] {""} ;
      P002H4_n2EnfNombre = new boolean[] {false} ;
      A24CntdDesc = "" ;
      P002H5_A24CntdDesc = new String[] {""} ;
      P002H5_A23CntdID = new long[1] ;
      P002H5_n23CntdID = new boolean[] {false} ;
      P002H6_A25ProtID = new long[1] ;
      P002H6_A23CntdID = new long[1] ;
      P002H6_n23CntdID = new boolean[] {false} ;
      P002H6_A24CntdDesc = new String[] {""} ;
      P002H7_A23CntdID = new long[1] ;
      P002H7_n23CntdID = new boolean[] {false} ;
      P002H7_A24CntdDesc = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.protocololoaddvcombo__default(),
         new Object[] {
             new Object[] {
            P002H2_A2EnfNombre, P002H2_n2EnfNombre, P002H2_A1EnfID
            }
            , new Object[] {
            P002H3_A25ProtID, P002H3_A1EnfID, P002H3_n1EnfID, P002H3_A2EnfNombre, P002H3_n2EnfNombre
            }
            , new Object[] {
            P002H4_A1EnfID, P002H4_A2EnfNombre, P002H4_n2EnfNombre
            }
            , new Object[] {
            P002H5_A24CntdDesc, P002H5_A23CntdID
            }
            , new Object[] {
            P002H6_A25ProtID, P002H6_A23CntdID, P002H6_n23CntdID, P002H6_A24CntdDesc
            }
            , new Object[] {
            P002H7_A23CntdID, P002H7_A24CntdDesc
            }
         }
      );
      /* GeneXus formulas. */
   }

   private short AV12PageIndex ;
   private short AV11SkipItems ;
   private int AV10MaxItems ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int GXPagingFrom5 ;
   private int GXPagingTo5 ;
   private long AV19ProtID ;
   private long A1EnfID ;
   private long A25ProtID ;
   private long AV27EnfID ;
   private long A23CntdID ;
   private long AV28CntdID ;
   private String AV17TrnMode ;
   private String A2EnfNombre ;
   private String A24CntdDesc ;
   private boolean AV18IsDynamicCall ;
   private boolean returnInSub ;
   private boolean n2EnfNombre ;
   private boolean n1EnfID ;
   private boolean n23CntdID ;
   private String AV23Combo_DataJson ;
   private String AV16ComboName ;
   private String AV20SearchTxtParms ;
   private String AV21SelectedValue ;
   private String AV22SelectedText ;
   private String AV13SearchTxt ;
   private String lV13SearchTxt ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P002H2_A2EnfNombre ;
   private boolean[] P002H2_n2EnfNombre ;
   private long[] P002H2_A1EnfID ;
   private boolean[] P002H2_n1EnfID ;
   private long[] P002H3_A25ProtID ;
   private long[] P002H3_A1EnfID ;
   private boolean[] P002H3_n1EnfID ;
   private String[] P002H3_A2EnfNombre ;
   private boolean[] P002H3_n2EnfNombre ;
   private long[] P002H4_A1EnfID ;
   private boolean[] P002H4_n1EnfID ;
   private String[] P002H4_A2EnfNombre ;
   private boolean[] P002H4_n2EnfNombre ;
   private String[] P002H5_A24CntdDesc ;
   private long[] P002H5_A23CntdID ;
   private boolean[] P002H5_n23CntdID ;
   private long[] P002H6_A25ProtID ;
   private long[] P002H6_A23CntdID ;
   private boolean[] P002H6_n23CntdID ;
   private String[] P002H6_A24CntdDesc ;
   private long[] P002H7_A23CntdID ;
   private boolean[] P002H7_n23CntdID ;
   private String[] P002H7_A24CntdDesc ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class protocololoaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13SearchTxt ,
                                          String A2EnfNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[4];
      Object[] GXv_Object3 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " EnfNombre, EnfID" ;
      sFromString = " FROM Enfermedades" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV13SearchTxt)==0) )
      {
         addWhere(sWhereString, "(EnfNombre like '%' || ?)");
      }
      else
      {
         GXv_int2[0] = (byte)(1) ;
      }
      sOrderString += " ORDER BY EnfNombre, EnfID" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P002H5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13SearchTxt ,
                                          String A24CntdDesc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[4];
      Object[] GXv_Object5 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " CntdDesc, CntdID" ;
      sFromString = " FROM Contenidos" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV13SearchTxt)==0) )
      {
         addWhere(sWhereString, "(CntdDesc like '%' || ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      sOrderString += " ORDER BY CntdDesc, CntdID" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P002H2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P002H5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002H3", "SELECT T1.ProtID, T1.EnfID, T2.EnfNombre FROM (Protocolo T1 LEFT JOIN Enfermedades T2 ON T2.EnfID = T1.EnfID) WHERE T1.ProtID = ? ORDER BY T1.ProtID ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002H4", "SELECT EnfID, EnfNombre FROM Enfermedades WHERE EnfID = ? ORDER BY EnfID  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002H5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002H6", "SELECT T1.ProtID, T1.CntdID, T2.CntdDesc FROM (Protocolo T1 LEFT JOIN Contenidos T2 ON T2.CntdID = T1.CntdID) WHERE T1.ProtID = ? ORDER BY T1.ProtID ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002H7", "SELECT CntdID, CntdDesc FROM Contenidos WHERE CntdID = ? ORDER BY CntdID  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 60);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((long[]) buf[2])[0] = rslt.getLong(2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 60);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 60);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 4 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 60);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 60);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
      }
   }

}

