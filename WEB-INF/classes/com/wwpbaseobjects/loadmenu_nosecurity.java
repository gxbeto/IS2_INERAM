package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loadmenu_nosecurity extends GXProcedure
{
   public loadmenu_nosecurity( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loadmenu_nosecurity.class ), "" );
   }

   public loadmenu_nosecurity( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> executeUdp( String aP0 )
   {
      loadmenu_nosecurity.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP1 )
   {
      loadmenu_nosecurity.this.AV8MenuItemCaption = aP0;
      loadmenu_nosecurity.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      AV18GXLvl2 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV8MenuItemCaption ,
                                           A12MenuItemCaption ,
                                           Short.valueOf(A11MenuItemFatherId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor P002B2 */
      pr_default.execute(0, new Object[] {AV8MenuItemCaption});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A11MenuItemFatherId = P002B2_A11MenuItemFatherId[0] ;
         n11MenuItemFatherId = P002B2_n11MenuItemFatherId[0] ;
         A12MenuItemCaption = P002B2_A12MenuItemCaption[0] ;
         A10MenuItemId = P002B2_A10MenuItemId[0] ;
         A20MenuItemShowDeveloperMenuOptio = P002B2_A20MenuItemShowDeveloperMenuOptio[0] ;
         A21MenuItemShowEditMenuOptions = P002B2_A21MenuItemShowEditMenuOptions[0] ;
         AV18GXLvl2 = (byte)(1) ;
         AV9MenuItemId = A10MenuItemId ;
         AV16MenuItemShowDeveloperMenuOption = A20MenuItemShowDeveloperMenuOptio ;
         AV17MenuItemShowEditMenuOptions = A21MenuItemShowEditMenuOptions ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P002B4 */
      pr_default.execute(1);
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40000GXC1 = P002B4_A40000GXC1[0] ;
         n40000GXC1 = P002B4_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
      }
      pr_default.close(1);
      if ( AV18GXLvl2 == 0 )
      {
         if ( A40000GXC1 == 0 )
         {
            AV13MenuItem = (com.wwpbaseobjects.SdtMenuItem)new com.wwpbaseobjects.SdtMenuItem( remoteHandle, context);
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemcaption( "MainMenu" );
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions( true );
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption( true );
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemtype( (byte)(2) );
            AV13MenuItem.Save();
            AV9MenuItemId = AV13MenuItem.getgxTv_SdtMenuItem_Menuitemid() ;
            AV13MenuItem = (com.wwpbaseobjects.SdtMenuItem)new com.wwpbaseobjects.SdtMenuItem( remoteHandle, context);
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemcaption( "Home" );
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemtype( (byte)(1) );
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemlink( formatLink("com.home", new String[] {}, new String[] {})  );
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemfatherid( AV9MenuItemId );
            AV13MenuItem.setgxTv_SdtMenuItem_Menuitemiconclass( "menu-icon fa fa-home" );
            AV13MenuItem.Save();
            Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.loadmenu_nosecurity");
            /* Using cursor P002B5 */
            pr_default.execute(2, new Object[] {AV8MenuItemCaption});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A11MenuItemFatherId = P002B5_A11MenuItemFatherId[0] ;
               n11MenuItemFatherId = P002B5_n11MenuItemFatherId[0] ;
               A12MenuItemCaption = P002B5_A12MenuItemCaption[0] ;
               A10MenuItemId = P002B5_A10MenuItemId[0] ;
               A20MenuItemShowDeveloperMenuOptio = P002B5_A20MenuItemShowDeveloperMenuOptio[0] ;
               A21MenuItemShowEditMenuOptions = P002B5_A21MenuItemShowEditMenuOptions[0] ;
               AV9MenuItemId = A10MenuItemId ;
               AV16MenuItemShowDeveloperMenuOption = A20MenuItemShowDeveloperMenuOptio ;
               AV17MenuItemShowEditMenuOptions = A21MenuItemShowEditMenuOptions ;
               pr_default.readNext(2);
            }
            pr_default.close(2);
         }
      }
      if ( AV9MenuItemId > 0 )
      {
         GXt_objcol_SdtDVelop_Menu_Item1 = AV10DVelopMenu ;
         GXv_objcol_SdtDVelop_Menu_Item2[0] = GXt_objcol_SdtDVelop_Menu_Item1 ;
         new com.wwpbaseobjects.menuoptionsdata_nosecurity(remoteHandle, context).execute( AV9MenuItemId, true, GXv_objcol_SdtDVelop_Menu_Item2) ;
         GXt_objcol_SdtDVelop_Menu_Item1 = GXv_objcol_SdtDVelop_Menu_Item2[0] ;
         AV10DVelopMenu = GXt_objcol_SdtDVelop_Menu_Item1 ;
      }
      if ( ( AV9MenuItemId == 0 ) || AV17MenuItemShowEditMenuOptions )
      {
         AV11DVelopMenuItem = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         AV11DVelopMenuItem.setgxTv_SdtDVelop_Menu_Item_Id( "Edit" );
         AV11DVelopMenuItem.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.wwpbaseobjects.menuitemappmenuww", new String[] {}, new String[] {})  );
         AV11DVelopMenuItem.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-tasks" );
         AV11DVelopMenuItem.setgxTv_SdtDVelop_Menu_Item_Caption( "Edit Menu Options" );
         AV10DVelopMenu.add(AV11DVelopMenuItem, 0);
      }
      if ( ( AV9MenuItemId == 0 ) || AV16MenuItemShowDeveloperMenuOption )
      {
         AV11DVelopMenuItem = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         AV11DVelopMenuItem.setgxTv_SdtDVelop_Menu_Item_Id( "DeveloperMenu" );
         AV11DVelopMenuItem.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-edit" );
         AV11DVelopMenuItem.setgxTv_SdtDVelop_Menu_Item_Caption( "Developer Menu" );
         AV14id = (short)(10000) ;
         AV21GXV2 = 1 ;
         GXt_objcol_SdtProgramNames_ProgramName3 = AV20GXV1 ;
         GXv_objcol_SdtProgramNames_ProgramName4[0] = GXt_objcol_SdtProgramNames_ProgramName3 ;
         new com.wwpbaseobjects.listwwpprograms(remoteHandle, context).execute( GXv_objcol_SdtProgramNames_ProgramName4) ;
         GXt_objcol_SdtProgramNames_ProgramName3 = GXv_objcol_SdtProgramNames_ProgramName4[0] ;
         AV20GXV1 = GXt_objcol_SdtProgramNames_ProgramName3 ;
         while ( AV21GXV2 <= AV20GXV1.size() )
         {
            AV15ProgramName = (com.wwpbaseobjects.SdtProgramNames_ProgramName)((com.wwpbaseobjects.SdtProgramNames_ProgramName)AV20GXV1.elementAt(-1+AV21GXV2));
            AV12DVelopMenuItemDeveloperMenu = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
            AV14id = (short)(AV14id+1) ;
            AV12DVelopMenuItemDeveloperMenu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV14id, 4, 0) );
            AV12DVelopMenuItemDeveloperMenu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
            AV12DVelopMenuItemDeveloperMenu.setgxTv_SdtDVelop_Menu_Item_Link( AV15ProgramName.getgxTv_SdtProgramNames_ProgramName_Link() );
            AV12DVelopMenuItemDeveloperMenu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
            AV12DVelopMenuItemDeveloperMenu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
            AV12DVelopMenuItemDeveloperMenu.setgxTv_SdtDVelop_Menu_Item_Caption( AV15ProgramName.getgxTv_SdtProgramNames_ProgramName_Description() );
            AV11DVelopMenuItem.getgxTv_SdtDVelop_Menu_Item_Subitems().add(AV12DVelopMenuItemDeveloperMenu, 0);
            AV21GXV2 = (int)(AV21GXV2+1) ;
         }
         AV10DVelopMenu.add(AV11DVelopMenuItem, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = loadmenu_nosecurity.this.AV10DVelopMenu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10DVelopMenu = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
      A12MenuItemCaption = "" ;
      P002B2_A11MenuItemFatherId = new short[1] ;
      P002B2_n11MenuItemFatherId = new boolean[] {false} ;
      P002B2_A12MenuItemCaption = new String[] {""} ;
      P002B2_A10MenuItemId = new short[1] ;
      P002B2_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      P002B2_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      P002B4_A40000GXC1 = new int[1] ;
      P002B4_n40000GXC1 = new boolean[] {false} ;
      AV13MenuItem = new com.wwpbaseobjects.SdtMenuItem(remoteHandle);
      P002B5_A11MenuItemFatherId = new short[1] ;
      P002B5_n11MenuItemFatherId = new boolean[] {false} ;
      P002B5_A12MenuItemCaption = new String[] {""} ;
      P002B5_A10MenuItemId = new short[1] ;
      P002B5_A20MenuItemShowDeveloperMenuOptio = new boolean[] {false} ;
      P002B5_A21MenuItemShowEditMenuOptions = new boolean[] {false} ;
      GXt_objcol_SdtDVelop_Menu_Item1 = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
      AV11DVelopMenuItem = new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV20GXV1 = new GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>(com.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Gregory", remoteHandle);
      GXt_objcol_SdtProgramNames_ProgramName3 = new GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>(com.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Gregory", remoteHandle);
      AV15ProgramName = new com.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      AV12DVelopMenuItemDeveloperMenu = new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.wwpbaseobjects.loadmenu_nosecurity__default(),
         new Object[] {
             new Object[] {
            P002B2_A11MenuItemFatherId, P002B2_n11MenuItemFatherId, P002B2_A12MenuItemCaption, P002B2_A10MenuItemId, P002B2_A20MenuItemShowDeveloperMenuOptio, P002B2_A21MenuItemShowEditMenuOptions
            }
            , new Object[] {
            P002B4_A40000GXC1, P002B4_n40000GXC1
            }
            , new Object[] {
            P002B5_A11MenuItemFatherId, P002B5_n11MenuItemFatherId, P002B5_A12MenuItemCaption, P002B5_A10MenuItemId, P002B5_A20MenuItemShowDeveloperMenuOptio, P002B5_A21MenuItemShowEditMenuOptions
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
      GXv_objcol_SdtProgramNames_ProgramName4 = new GXBaseCollection[1] ;
   }

   private byte AV18GXLvl2 ;
   private short A11MenuItemFatherId ;
   private short A10MenuItemId ;
   private short AV9MenuItemId ;
   private short AV14id ;
   private int A40000GXC1 ;
   private int AV21GXV2 ;
   private boolean n11MenuItemFatherId ;
   private boolean A20MenuItemShowDeveloperMenuOptio ;
   private boolean A21MenuItemShowEditMenuOptions ;
   private boolean AV16MenuItemShowDeveloperMenuOption ;
   private boolean AV17MenuItemShowEditMenuOptions ;
   private boolean n40000GXC1 ;
   private String AV8MenuItemCaption ;
   private String A12MenuItemCaption ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P002B2_A11MenuItemFatherId ;
   private boolean[] P002B2_n11MenuItemFatherId ;
   private String[] P002B2_A12MenuItemCaption ;
   private short[] P002B2_A10MenuItemId ;
   private boolean[] P002B2_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] P002B2_A21MenuItemShowEditMenuOptions ;
   private int[] P002B4_A40000GXC1 ;
   private boolean[] P002B4_n40000GXC1 ;
   private short[] P002B5_A11MenuItemFatherId ;
   private boolean[] P002B5_n11MenuItemFatherId ;
   private String[] P002B5_A12MenuItemCaption ;
   private short[] P002B5_A10MenuItemId ;
   private boolean[] P002B5_A20MenuItemShowDeveloperMenuOptio ;
   private boolean[] P002B5_A21MenuItemShowEditMenuOptions ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> AV10DVelopMenu ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> GXt_objcol_SdtDVelop_Menu_Item1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item2[] ;
   private GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName> AV20GXV1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName> GXt_objcol_SdtProgramNames_ProgramName3 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName> GXv_objcol_SdtProgramNames_ProgramName4[] ;
   private com.wwpbaseobjects.SdtDVelop_Menu_Item AV11DVelopMenuItem ;
   private com.wwpbaseobjects.SdtDVelop_Menu_Item AV12DVelopMenuItemDeveloperMenu ;
   private com.wwpbaseobjects.SdtMenuItem AV13MenuItem ;
   private com.wwpbaseobjects.SdtProgramNames_ProgramName AV15ProgramName ;
}

final  class loadmenu_nosecurity__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P002B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV8MenuItemCaption ,
                                          String A12MenuItemCaption ,
                                          short A11MenuItemFatherId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[1];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT MenuItemFatherId, MenuItemCaption, MenuItemId, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions FROM MenuItem" ;
      addWhere(sWhereString, "((MenuItemFatherId = 0) or MenuItemFatherId IS NULL)");
      if ( ! (GXutil.strcmp("", AV8MenuItemCaption)==0) )
      {
         addWhere(sWhereString, "(LOWER(MenuItemCaption) = ( LOWER(?)))");
      }
      else
      {
         GXv_int5[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MenuItemId" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P002B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002B4", "SELECT COALESCE( T1.GXC1, 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1 FROM MenuItem ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P002B5", "SELECT MenuItemFatherId, MenuItemCaption, MenuItemId, MenuItemShowDeveloperMenuOptio, MenuItemShowEditMenuOptions FROM MenuItem WHERE (LOWER(MenuItemCaption) = ( LOWER(?))) AND ((MenuItemFatherId = 0) or MenuItemFatherId IS NULL) ORDER BY MenuItemId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
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
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
      }
   }

}

