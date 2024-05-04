package com.workwithplus ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_parameter_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.GXcfg.class);
      wwp_parameter_dataprovider pgm = new wwp_parameter_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<com.workwithplus.SdtWWP_Parameter>[] aP0 = new GXBCCollection[] {new GXBCCollection<com.workwithplus.SdtWWP_Parameter>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public wwp_parameter_dataprovider( )
   {
      super( -1 , new ModelContext( wwp_parameter_dataprovider.class ), "" );
      Application.init(com.GXcfg.class);
   }

   public wwp_parameter_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_parameter_dataprovider.class ), "" );
   }

   public wwp_parameter_dataprovider( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<com.workwithplus.SdtWWP_Parameter> executeUdp( )
   {
      GXBCCollection<com.workwithplus.SdtWWP_Parameter>[] aP0 = new GXBCCollection[] {new GXBCCollection<com.workwithplus.SdtWWP_Parameter>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<com.workwithplus.SdtWWP_Parameter>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<com.workwithplus.SdtWWP_Parameter>[] aP0 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.workwithplus.awwp_parameter_dataprovider(remoteHandle, context).execute( aP0 );
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      Application.cleanup(context, this, remoteHandle);
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

