package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethomemodulessample extends GXProcedure
{
   public gethomemodulessample( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethomemodulessample.class ), "" );
   }

   public gethomemodulessample( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> executeUdp( )
   {
      gethomemodulessample.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>[] aP0 )
   {
      gethomemodulessample.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Panel de Control" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-home" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage( httpContext.convertURL( context.getHttpContext().getImagePath( "d085396f-788e-4174-bb1c-d2d0832ea599", "", context.getHttpContext().getTheme( ))) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( "Control integral de uso del protocolos." );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Listas" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-tasks" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage( httpContext.convertURL( context.getHttpContext().getImagePath( "8b339ea3-0806-4fdc-b87f-6f4b66cf669e", "", context.getHttpContext().getTheme( ))) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( "Tareas pendientes" );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Correcciones Pendientes" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-tags" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(2) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage( httpContext.convertURL( context.getHttpContext().getImagePath( "4688f42a-4096-4b76-bddb-a886e286486f", "", context.getHttpContext().getTheme( ))) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( "Puntos de mejora continua" );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Asistentes" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-briefcase" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage( httpContext.convertURL( context.getHttpContext().getImagePath( "4c659b0a-96d5-4099-bfb6-c43d7184e732", "", context.getHttpContext().getTheme( ))) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( "Rutas de ejecucion de tareas" );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Usuarios" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-user" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Reclamos" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( "Reclamos abiertos: 24" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(2) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(2) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue( (byte)(24) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Roles" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-cog" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Repositorios" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-database" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Otras Configuraciones" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-bullseye" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Cambiar Password" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-key" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Aplicaciones" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-file" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Protocolos Activos" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(3) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue( (byte)(2) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Crear Usuario" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-user-plus" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Comentarios" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-comments" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Redes Sociales" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-rss" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(2) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Trips" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-plane" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Cuentas" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( "Su cuentas expira en : 56" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(2) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(2) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue( (byte)(56) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Emails" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "fa fa-envelope" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Mi perfil" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "far fa-id-card" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Pendientes" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(3) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue( (byte)(15) );
      Gxm1homemodulessdt = (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      Gxm2rootcol.add(Gxm1homemodulessdt, 0);
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( "Projectos" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( "far fa-calendar-alt" );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( (byte)(1) );
      Gxm1homemodulessdt.setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( (byte)(2) );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = gethomemodulessample.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>(com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem.class, "HomeModulesSDTItem", "Gregory", remoteHandle);
      Gxm1homemodulessdt = new com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem(remoteHandle, context);
      /* GeneXus formulas. */
   }

   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem>[] aP0 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem> Gxm2rootcol ;
   private com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem Gxm1homemodulessdt ;
}

