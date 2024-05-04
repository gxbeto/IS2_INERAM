package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_importdata extends GXProcedure
{
   public wwp_importdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_importdata.class ), "" );
   }

   public wwp_importdata( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String aP1 ,
                              String aP2 ,
                              String aP3 ,
                              GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 )
   {
      wwp_importdata.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ,
                             boolean[] aP5 )
   {
      wwp_importdata.this.AV12SelctionName = aP0;
      wwp_importdata.this.AV9ImportType = aP1;
      wwp_importdata.this.AV8FilePath = aP2;
      wwp_importdata.this.AV14ExtraParmsJson = aP3;
      wwp_importdata.this.aP4 = aP4;
      wwp_importdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = wwp_importdata.this.AV11Messages;
      this.aP5[0] = wwp_importdata.this.AV10IsOk;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      /* GeneXus formulas. */
   }

   private boolean AV10IsOk ;
   private String AV12SelctionName ;
   private String AV9ImportType ;
   private String AV8FilePath ;
   private String AV14ExtraParmsJson ;
   private boolean[] aP5 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP4 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV11Messages ;
}

