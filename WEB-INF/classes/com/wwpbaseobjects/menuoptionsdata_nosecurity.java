package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuoptionsdata_nosecurity extends GXProcedure
{
   public menuoptionsdata_nosecurity( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuoptionsdata_nosecurity.class ), "" );
   }

   public menuoptionsdata_nosecurity( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> executeUdp( short aP0 ,
                                                                               boolean aP1 )
   {
      menuoptionsdata_nosecurity.this.aP2 = new GXBaseCollection[] {new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        boolean aP1 ,
                        GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             boolean aP1 ,
                             GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP2 )
   {
      menuoptionsdata_nosecurity.this.AV8MenuItemId = aP0;
      menuoptionsdata_nosecurity.this.AV7IsRootFather = aP1;
      menuoptionsdata_nosecurity.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV8MenuItemId) ,
                                           Short.valueOf(A11MenuItemFatherId) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor P00072 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8MenuItemId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11MenuItemFatherId = P00072_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = P00072_n11MenuItemFatherId[0] ;
         A10MenuItemId = P00072_A10MenuItemId[0] ;
         A18MenuItemLinkParameters = P00072_A18MenuItemLinkParameters[0] ;
         A13MenuItemLink = P00072_A13MenuItemLink[0] ;
         A14MenuItemLinkTarget = P00072_A14MenuItemLinkTarget[0] ;
         A15MenuItemIconClass = P00072_A15MenuItemIconClass[0] ;
         A12MenuItemCaption = P00072_A12MenuItemCaption[0] ;
         A22MenuItemOrder = P00072_A22MenuItemOrder[0] ;
         Gxm1dvelop_menu = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         Gxm2rootcol.add(Gxm1dvelop_menu, 0);
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( A10MenuItemId, 4, 0) );
         if ( ! (GXutil.strcmp("", GXutil.trim( A18MenuItemLinkParameters))==0) )
         {
            AV11MenuItemLink = A13MenuItemLink + "?" + A18MenuItemLinkParameters ;
         }
         else
         {
            AV11MenuItemLink = A13MenuItemLink ;
         }
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( formatLink(AV11MenuItemLink, new String[] {}, new String[] {})  );
         if ( GXutil.strcmp(A14MenuItemLinkTarget, "_") != 0 )
         {
            Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( A14MenuItemLinkTarget );
         }
         else
         {
            Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
         }
         if ( AV7IsRootFather )
         {
            Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( A15MenuItemIconClass );
         }
         else
         {
            Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
         }
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( A12MenuItemCaption );
         GXt_objcol_SdtDVelop_Menu_Item1 = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>() ;
         GXv_objcol_SdtDVelop_Menu_Item2[0] = GXt_objcol_SdtDVelop_Menu_Item1 ;
         new com.wwpbaseobjects.menuoptionsdata_nosecurity(remoteHandle, context).execute( A10MenuItemId, false, GXv_objcol_SdtDVelop_Menu_Item2) ;
         GXt_objcol_SdtDVelop_Menu_Item1 = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Subitems( GXt_objcol_SdtDVelop_Menu_Item1 );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = menuoptionsdata_nosecurity.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
      P00072_A11MenuItemFatherId = new short[1] ;
      P00072_n11MenuItemFatherId = new boolean[] {false} ;
      P00072_A10MenuItemId = new short[1] ;
      P00072_A18MenuItemLinkParameters = new String[] {""} ;
      P00072_A13MenuItemLink = new String[] {""} ;
      P00072_A14MenuItemLinkTarget = new String[] {""} ;
      P00072_A15MenuItemIconClass = new String[] {""} ;
      P00072_A12MenuItemCaption = new String[] {""} ;
      P00072_A22MenuItemOrder = new short[1] ;
      A18MenuItemLinkParameters = "" ;
      A13MenuItemLink = "" ;
      A14MenuItemLinkTarget = "" ;
      A15MenuItemIconClass = "" ;
      A12MenuItemCaption = "" ;
      Gxm1dvelop_menu = new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV11MenuItemLink = "" ;
      GXt_objcol_SdtDVelop_Menu_Item1 = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.menuoptionsdata_nosecurity__default(),
         new Object[] {
             new Object[] {
            P00072_A11MenuItemFatherId, P00072_n11MenuItemFatherId, P00072_A10MenuItemId, P00072_A18MenuItemLinkParameters, P00072_A13MenuItemLink, P00072_A14MenuItemLinkTarget, P00072_A15MenuItemIconClass, P00072_A12MenuItemCaption, P00072_A22MenuItemOrder
            }
         }
      );
      /* GeneXus formulas. */
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtDVelop_Menu_Item2 = new GXBaseCollection[1] ;
   }

   private short AV8MenuItemId ;
   private short A11MenuItemFatherId ;
   private short A10MenuItemId ;
   private short A22MenuItemOrder ;
   private boolean AV7IsRootFather ;
   private boolean n11MenuItemFatherId ;
   private String A18MenuItemLinkParameters ;
   private String A13MenuItemLink ;
   private String A14MenuItemLinkTarget ;
   private String A15MenuItemIconClass ;
   private String A12MenuItemCaption ;
   private String AV11MenuItemLink ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P00072_A11MenuItemFatherId ;
   private boolean[] P00072_n11MenuItemFatherId ;
   private short[] P00072_A10MenuItemId ;
   private String[] P00072_A18MenuItemLinkParameters ;
   private String[] P00072_A13MenuItemLink ;
   private String[] P00072_A14MenuItemLinkTarget ;
   private String[] P00072_A15MenuItemIconClass ;
   private String[] P00072_A12MenuItemCaption ;
   private short[] P00072_A22MenuItemOrder ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> Gxm2rootcol ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> GXt_objcol_SdtDVelop_Menu_Item1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item2[] ;
   private com.wwpbaseobjects.SdtDVelop_Menu_Item Gxm1dvelop_menu ;
}

final  class menuoptionsdata_nosecurity__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00072( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV8MenuItemId ,
                                          short A11MenuItemFatherId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[1];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT MenuItemFatherId, MenuItemId, MenuItemLinkParameters, MenuItemLink, MenuItemLinkTarget, MenuItemIconClass, MenuItemCaption, MenuItemOrder FROM MenuItem" ;
      if ( AV8MenuItemId > 0 )
      {
         addWhere(sWhereString, "(MenuItemFatherId = ?)");
      }
      else
      {
         GXv_int3[0] = (byte)(1) ;
      }
      if ( AV8MenuItemId == 0 )
      {
         addWhere(sWhereString, "(MenuItemFatherId IS NULL or (MenuItemFatherId = 0))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MenuItemOrder" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P00072(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00072", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((short[]) buf[8])[0] = rslt.getShort(8);
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
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

