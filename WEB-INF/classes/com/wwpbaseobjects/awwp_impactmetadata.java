package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class awwp_impactmetadata extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.GXcfg.class);
      awwp_impactmetadata pgm = new awwp_impactmetadata (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public awwp_impactmetadata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( awwp_impactmetadata.class ), "" );
   }

   public awwp_impactmetadata( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(wwp_impactmetadata.class);
      return new com.GXcfg();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
   }

}

