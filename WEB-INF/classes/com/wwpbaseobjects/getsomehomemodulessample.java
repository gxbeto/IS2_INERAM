package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsomehomemodulessample extends GXProcedure
{
   public getsomehomemodulessample( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsomehomemodulessample.class ), "" );
   }

   public getsomehomemodulessample( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> executeUdp( )
   {
      getsomehomemodulessample.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>[] aP0 )
   {
      getsomehomemodulessample.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 = AV5HomeModulesSDT ;
      GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2[0] = GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 ;
      new com.wwpbaseobjects.gethomemodulessample(remoteHandle, context).execute( GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2) ;
      GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 = GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2[0] ;
      AV5HomeModulesSDT = GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 ;
      Gxv1skipcount = 0 ;
      AV10GXV1 = 1 ;
      while ( AV10GXV1 <= AV5HomeModulesSDT.size() )
      {
         AV6HomeModulesSDTItem = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)((com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)AV5HomeModulesSDT.elementAt(-1+AV10GXV1));
         Gxv1skipcount = (int)(Gxv1skipcount+1) ;
         Gxm2homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
         Gxm3rootcol.add(Gxm2homemodulessdt, 0);
         Gxm2homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( AV6HomeModulesSDTItem.getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle() );
         Gxm2homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( AV6HomeModulesSDTItem.getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass() );
         Gxm2homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage( AV6HomeModulesSDTItem.getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage() );
         Gxm2homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi( AV6HomeModulesSDTItem.getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi() );
         Gxm2homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( AV6HomeModulesSDTItem.getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription() );
         Gxm2homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink( AV6HomeModulesSDTItem.getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink() );
         if ( ( 6 != 0 ) && ( Gxv1skipcount >= 6 ) )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         AV10GXV1 = (int)(AV10GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getsomehomemodulessample.this.Gxm3rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm3rootcol = new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>(com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem.class, "HomeModulesSDTItem", "Gregory", remoteHandle);
      AV5HomeModulesSDT = new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>(com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem.class, "HomeModulesSDTItem", "Gregory", remoteHandle);
      GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 = new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>(com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem.class, "HomeModulesSDTItem", "Gregory", remoteHandle);
      AV6HomeModulesSDTItem = new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2homemodulessdt = new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      /* GeneXus formulas. */
      initializeGenerics();
   }

   @SuppressWarnings("unchecked")
   private void initializeGenerics( )
   {
      GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2 = new GXBaseCollection[1] ;
   }

   private int Gxv1skipcount ;
   private int AV10GXV1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>[] aP0 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> Gxm3rootcol ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> AV5HomeModulesSDT ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> GXt_objcol_SdtHomeModulesSDT_HomeModulesSDTItem1 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> GXv_objcol_SdtHomeModulesSDT_HomeModulesSDTItem2[] ;
   private com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem AV6HomeModulesSDTItem ;
   private com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem Gxm2homemodulessdt ;
}

