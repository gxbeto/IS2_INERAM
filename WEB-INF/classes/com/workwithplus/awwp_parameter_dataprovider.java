package com.workwithplus ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class awwp_parameter_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.GXcfg.class);
      awwp_parameter_dataprovider pgm = new awwp_parameter_dataprovider (-1);
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

   public awwp_parameter_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( awwp_parameter_dataprovider.class ), "" );
   }

   public awwp_parameter_dataprovider( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<com.workwithplus.SdtWWP_Parameter> executeUdp( )
   {
      awwp_parameter_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<com.workwithplus.SdtWWP_Parameter>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<com.workwithplus.SdtWWP_Parameter>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<com.workwithplus.SdtWWP_Parameter>[] aP0 )
   {
      awwp_parameter_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      Gxm1wwp_parameter = (com.workwithplus.SdtWWP_Parameter)new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_parameter, 0);
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterkey( "AD_Application_Name" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametercategory( "Application data" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( "Application name" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametervalue( "WorkWithPlus" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( true );
      Gxm1wwp_parameter = (com.workwithplus.SdtWWP_Parameter)new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_parameter, 0);
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterkey( "AD_Application_Title" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametercategory( "Application data" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( "Application title" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametervalue( "ineram" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( true );
      Gxm1wwp_parameter = (com.workwithplus.SdtWWP_Parameter)new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_parameter, 0);
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterkey( "AD_Application_Phone" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametercategory( "Application data" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( "Application phone" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametervalue( "+1 550 8923" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( true );
      Gxm1wwp_parameter = (com.workwithplus.SdtWWP_Parameter)new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_parameter, 0);
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterkey( "AD_Application_Mail" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametercategory( "Application data" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( "Application mail" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametervalue( "info@mail.com" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( true );
      Gxm1wwp_parameter = (com.workwithplus.SdtWWP_Parameter)new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_parameter, 0);
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterkey( "AD_Application_Website" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametercategory( "Application data" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( "Application website" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametervalue( "http://www.web.com" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( true );
      Gxm1wwp_parameter = (com.workwithplus.SdtWWP_Parameter)new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_parameter, 0);
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterkey( "AD_Application_Address" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametercategory( "Application data" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( "Application address" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametervalue( "French Boulevard 2859" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( true );
      Gxm1wwp_parameter = (com.workwithplus.SdtWWP_Parameter)new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_parameter, 0);
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterkey( "AD_Application_Neighbour" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametercategory( "Application data" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( "Application neighbour" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametervalue( "Downtown" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( true );
      Gxm1wwp_parameter = (com.workwithplus.SdtWWP_Parameter)new com.workwithplus.SdtWWP_Parameter( remoteHandle, context);
      Gxm2rootcol.add(Gxm1wwp_parameter, 0);
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterkey( "AD_Application_CityAndCountry" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametercategory( "Application data" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdescription( "Application city and country" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparametervalue( "Paris, France" );
      Gxm1wwp_parameter.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( true );
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(wwp_parameter_dataprovider.class);
      return new com.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = awwp_parameter_dataprovider.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBCCollection<com.workwithplus.SdtWWP_Parameter>(com.workwithplus.SdtWWP_Parameter.class, "WWP_Parameter", "Gregory", remoteHandle);
      Gxm1wwp_parameter = new com.workwithplus.SdtWWP_Parameter(remoteHandle);
      /* GeneXus formulas. */
   }

   private GXBCCollection<com.workwithplus.SdtWWP_Parameter>[] aP0 ;
   private GXBCCollection<com.workwithplus.SdtWWP_Parameter> Gxm2rootcol ;
   private com.workwithplus.SdtWWP_Parameter Gxm1wwp_parameter ;
}

