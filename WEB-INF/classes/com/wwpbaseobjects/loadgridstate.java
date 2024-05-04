package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loadgridstate extends GXProcedure
{
   public loadgridstate( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loadgridstate.class ), "" );
   }

   public loadgridstate( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      loadgridstate.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      loadgridstate.this.AV8UserCustomKey = aP0;
      loadgridstate.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      GXv_char1[0] = AV9UserCustomValue ;
      new com.wwpbaseobjects.loaduserkeyvalue(remoteHandle, context).execute( AV8UserCustomKey, GXv_char1) ;
      loadgridstate.this.AV9UserCustomValue = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = loadgridstate.this.AV9UserCustomValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9UserCustomValue = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
   }

   private String GXv_char1[] ;
   private String AV8UserCustomKey ;
   private String AV9UserCustomValue ;
   private String[] aP1 ;
}

