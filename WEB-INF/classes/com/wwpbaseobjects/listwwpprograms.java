package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class listwwpprograms extends GXProcedure
{
   public listwwpprograms( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( listwwpprograms.class ), "" );
   }

   public listwwpprograms( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName> executeUdp( )
   {
      listwwpprograms.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      listwwpprograms.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      AV9ProgramNames = new GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>(com.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Gregory", remoteHandle) ;
      GXv_SdtWWPContext1[0] = AV16WWPContext;
      new com.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV16WWPContext = GXv_SdtWWPContext1[0];
      AV13name = "WWPBaseObjects.MenuItemAppMenuWW" ;
      AV14description = "Application Menus" ;
      AV15link = formatLink("com.wwpbaseobjects.menuitemappmenuww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "ContenidosWW" ;
      AV14description = " Contenidos" ;
      AV15link = formatLink("com.contenidosww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "ProtocoloWW" ;
      AV14description = " Protocolo" ;
      AV15link = formatLink("com.protocoloww", new String[] {GXutil.URLEncode(GXutil.ltrimstr(0,9,0))}, new String[] {"SelectedProtID"})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "EnfermedadesWW" ;
      AV14description = " Enfermedades" ;
      AV15link = formatLink("com.enfermedadesww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "WorkWithPlus.WWP_ParameterWW" ;
      AV14description = "Parámetro" ;
      AV15link = formatLink("com.workwithplus.wwp_parameterww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADDPROGRAM' Routine */
      returnInSub = false ;
      AV8IsAuthorized = true ;
      if ( AV8IsAuthorized )
      {
         AV10ProgramName = (com.wwpbaseobjects.SdtProgramNames_ProgramName)new com.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Name( AV13name );
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Description( AV14description );
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Link( AV15link );
         AV9ProgramNames.add(AV10ProgramName, 0);
      }
   }

   protected void cleanup( )
   {
      this.aP0[0] = listwwpprograms.this.AV9ProgramNames;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ProgramNames = new GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>(com.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Gregory", remoteHandle);
      AV16WWPContext = new com.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.wwpbaseobjects.SdtWWPContext[1] ;
      AV13name = "" ;
      AV14description = "" ;
      AV15link = "" ;
      AV10ProgramName = new com.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      /* GeneXus formulas. */
   }

   private long A25ProtID ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private String AV13name ;
   private String AV14description ;
   private String AV15link ;
   private GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 ;
   private GXBaseCollection<com.wwpbaseobjects.SdtProgramNames_ProgramName> AV9ProgramNames ;
   private com.wwpbaseobjects.SdtProgramNames_ProgramName AV10ProgramName ;
   private com.wwpbaseobjects.SdtWWPContext AV16WWPContext ;
   private com.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

