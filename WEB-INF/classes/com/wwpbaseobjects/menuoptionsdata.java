package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuoptionsdata extends GXProcedure
{
   public menuoptionsdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuoptionsdata.class ), "" );
   }

   public menuoptionsdata( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> executeUdp( )
   {
      menuoptionsdata.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 )
   {
      menuoptionsdata.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      AV5id = (short)(0) ;
      Gxm1dvelop_menu = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.home", new String[] {}, new String[] {})  );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-home" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Inicio" );
      Gxm1dvelop_menu = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-tasks" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 1" );
      Gxm3dvelop_menu_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 1.1" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm3dvelop_menu_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 1.2" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm3dvelop_menu_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 1.3" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm1dvelop_menu = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-key" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 2" );
      Gxm3dvelop_menu_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 2.1" );
      Gxm4dvelop_menu_subitems_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 2.1.1" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm4dvelop_menu_subitems_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 2.1.2" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm4dvelop_menu_subitems_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 2.1.3" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm3dvelop_menu_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
      Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 2.2" );
      Gxm4dvelop_menu_subitems_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems_subitems, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 2.2.1" );
      Gxm4dvelop_menu_subitems_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm1dvelop_menu = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-briefcase" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Opción de Menú 3" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
      Gxm1dvelop_menu = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-edit" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Menú de Desarrollo" );
      Gxv5skipcount = 0 ;
      AV13GXV2 = 1 ;
      GXt_objcol_SdtProgramNames_ProgramName1 = AV12GXV1 ;
      GXv_objcol_SdtProgramNames_ProgramName2[0] = GXt_objcol_SdtProgramNames_ProgramName1 ;
      new com.wwpbaseobjects.listwwpprograms(remoteHandle, context).execute( GXv_objcol_SdtProgramNames_ProgramName2) ;
      GXt_objcol_SdtProgramNames_ProgramName1 = GXv_objcol_SdtProgramNames_ProgramName2[0] ;
      AV12GXV1 = GXt_objcol_SdtProgramNames_ProgramName1 ;
      while ( AV13GXV2 <= AV12GXV1.size() )
      {
         AV6ProgramName = (com.wwpbaseobjects.SdtProgramNames_ProgramName)((com.wwpbaseobjects.SdtProgramNames_ProgramName)AV12GXV1.elementAt(-1+AV13GXV2));
         Gxv5skipcount = (int)(Gxv5skipcount+1) ;
         Gxm3dvelop_menu_subitems = (com.wwpbaseobjects.SdtDVelop_Menu_Item)new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm3dvelop_menu_subitems, 0);
         AV5id = (short)(AV5id+1) ;
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Link() );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
         Gxm3dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Description() );
         if ( ( 20 != 0 ) && ( Gxv5skipcount >= 20 ) )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         AV13GXV2 = (int)(AV13GXV2+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = menuoptionsdata.this.Gxm2rootcol;
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
      Gxm1dvelop_menu = new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm3dvelop_menu_subitems = new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm4dvelop_menu_subitems_subitems = new com.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV12GXV1 = new GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>(com.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Gregory", remoteHandle);
      GXt_objcol_SdtProgramNames_ProgramName1 = new GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>(com.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Gregory", remoteHandle);
      AV6ProgramName = new com.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      /* GeneXus formulas. */
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtProgramNames_ProgramName2 = new GXBaseCollection[1] ;
   }

   private short AV5id ;
   private int Gxv5skipcount ;
   private int AV13GXV2 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP0 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName> AV12GXV1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName> GXt_objcol_SdtProgramNames_ProgramName1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName> GXv_objcol_SdtProgramNames_ProgramName2[] ;
   private GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> Gxm2rootcol ;
   private com.wwpbaseobjects.SdtProgramNames_ProgramName AV6ProgramName ;
   private com.wwpbaseobjects.SdtDVelop_Menu_Item Gxm1dvelop_menu ;
   private com.wwpbaseobjects.SdtDVelop_Menu_Item Gxm3dvelop_menu_subitems ;
   private com.wwpbaseobjects.SdtDVelop_Menu_Item Gxm4dvelop_menu_subitems_subitems ;
}

