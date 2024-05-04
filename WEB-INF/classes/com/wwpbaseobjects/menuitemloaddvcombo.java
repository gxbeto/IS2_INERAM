package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuitemloaddvcombo extends GXProcedure
{
   public menuitemloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuitemloaddvcombo.class ), "" );
   }

   public menuitemloaddvcombo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      menuitemloaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
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
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      menuitemloaddvcombo.this.AV16ComboName = aP0;
      menuitemloaddvcombo.this.AV17TrnMode = aP1;
      menuitemloaddvcombo.this.AV18IsDynamicCall = aP2;
      menuitemloaddvcombo.this.AV19MenuItemId = aP3;
      menuitemloaddvcombo.this.AV20SearchTxtParms = aP4;
      menuitemloaddvcombo.this.aP5 = aP5;
      menuitemloaddvcombo.this.aP6 = aP6;
      menuitemloaddvcombo.this.aP7 = aP7;
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
      if ( GXutil.strcmp(AV16ComboName, "MenuItemFatherId") == 0 )
      {
         /* Execute user subroutine: 'LOADCOMBOITEMS_MENUITEMFATHERID' */
         S111 ();
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
      /* 'LOADCOMBOITEMS_MENUITEMFATHERID' Routine */
      returnInSub = false ;
      if ( AV18IsDynamicCall )
      {
         GXPagingFrom2 = AV11SkipItems ;
         GXPagingTo2 = AV10MaxItems ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV13SearchTxt ,
                                              A12MenuItemCaption } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV13SearchTxt = GXutil.concat( GXutil.rtrim( AV13SearchTxt), "%", "") ;
         /* Using cursor P002C2 */
         pr_default.execute(0, new Object[] {lV13SearchTxt, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A12MenuItemCaption = P002C2_A12MenuItemCaption[0] ;
            A10MenuItemId = P002C2_A10MenuItemId[0] ;
            AV15Combo_DataItem = (com.wwpbaseobjects.SdtDVB_SDTComboData_Item)new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A10MenuItemId, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A12MenuItemCaption );
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
               /* Using cursor P002C3 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV19MenuItemId)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A10MenuItemId = P002C3_A10MenuItemId[0] ;
                  A11MenuItemFatherId = P002C3_A11MenuItemFatherId[0] ;
                  n11MenuItemFatherId = P002C3_n11MenuItemFatherId[0] ;
                  AV21SelectedValue = ((0==A11MenuItemFatherId) ? "" : GXutil.trim( GXutil.str( A11MenuItemFatherId, 4, 0))) ;
                  AV27MenuItemIdAux = A11MenuItemFatherId ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV27MenuItemIdAux = (short)(GXutil.lval( AV13SearchTxt)) ;
            }
            /* Using cursor P002C4 */
            pr_default.execute(2, new Object[] {Short.valueOf(AV27MenuItemIdAux)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A10MenuItemId = P002C4_A10MenuItemId[0] ;
               A12MenuItemCaption = P002C4_A12MenuItemCaption[0] ;
               AV22SelectedText = A12MenuItemCaption ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = menuitemloaddvcombo.this.AV21SelectedValue;
      this.aP6[0] = menuitemloaddvcombo.this.AV22SelectedText;
      this.aP7[0] = menuitemloaddvcombo.this.AV23Combo_DataJson;
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
      A12MenuItemCaption = "" ;
      P002C2_A12MenuItemCaption = new String[] {""} ;
      P002C2_A10MenuItemId = new short[1] ;
      AV15Combo_DataItem = new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P002C3_A10MenuItemId = new short[1] ;
      P002C3_A11MenuItemFatherId = new short[1] ;
      P002C3_n11MenuItemFatherId = new boolean[] {false} ;
      P002C4_A10MenuItemId = new short[1] ;
      P002C4_A12MenuItemCaption = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.menuitemloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P002C2_A12MenuItemCaption, P002C2_A10MenuItemId
            }
            , new Object[] {
            P002C3_A10MenuItemId, P002C3_A11MenuItemFatherId, P002C3_n11MenuItemFatherId
            }
            , new Object[] {
            P002C4_A10MenuItemId, P002C4_A12MenuItemCaption
            }
         }
      );
      /* GeneXus formulas. */
   }

   private short AV19MenuItemId ;
   private short AV12PageIndex ;
   private short AV11SkipItems ;
   private short A10MenuItemId ;
   private short A11MenuItemFatherId ;
   private short AV27MenuItemIdAux ;
   private int AV10MaxItems ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private String AV17TrnMode ;
   private boolean AV18IsDynamicCall ;
   private boolean returnInSub ;
   private boolean n11MenuItemFatherId ;
   private String AV23Combo_DataJson ;
   private String AV16ComboName ;
   private String AV20SearchTxtParms ;
   private String AV21SelectedValue ;
   private String AV22SelectedText ;
   private String AV13SearchTxt ;
   private String lV13SearchTxt ;
   private String A12MenuItemCaption ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P002C2_A12MenuItemCaption ;
   private short[] P002C2_A10MenuItemId ;
   private short[] P002C3_A10MenuItemId ;
   private short[] P002C3_A11MenuItemFatherId ;
   private boolean[] P002C3_n11MenuItemFatherId ;
   private short[] P002C4_A10MenuItemId ;
   private String[] P002C4_A12MenuItemCaption ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private com.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class menuitemloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002C2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV13SearchTxt ,
                                          String A12MenuItemCaption )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[4];
      Object[] GXv_Object3 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " MenuItemCaption, MenuItemId" ;
      sFromString = " FROM MenuItem" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV13SearchTxt)==0) )
      {
         addWhere(sWhereString, "(MenuItemCaption like '%' || ?)");
      }
      else
      {
         GXv_int2[0] = (byte)(1) ;
      }
      sOrderString += " ORDER BY MenuItemCaption, MenuItemId" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
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
                  return conditional_P002C2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002C2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002C3", "SELECT MenuItemId, MenuItemFatherId FROM MenuItem WHERE MenuItemId = ? ORDER BY MenuItemId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P002C4", "SELECT MenuItemId, MenuItemCaption FROM MenuItem WHERE MenuItemId = ? ORDER BY MenuItemId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

