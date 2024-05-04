package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dvmessagegetbasicnotificationmsg extends GXProcedure
{
   public dvmessagegetbasicnotificationmsg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dvmessagegetbasicnotificationmsg.class ), "" );
   }

   public dvmessagegetbasicnotificationmsg( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 )
   {
      dvmessagegetbasicnotificationmsg.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 )
   {
      dvmessagegetbasicnotificationmsg.this.AV14Title = aP0;
      dvmessagegetbasicnotificationmsg.this.AV13Text = aP1;
      dvmessagegetbasicnotificationmsg.this.AV15Type = aP2;
      dvmessagegetbasicnotificationmsg.this.AV10ControlSelector = aP3;
      dvmessagegetbasicnotificationmsg.this.AV11Hide = aP4;
      dvmessagegetbasicnotificationmsg.this.AV9ClickRedirectURL = aP5;
      dvmessagegetbasicnotificationmsg.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      GXt_char1 = AV12Parms ;
      GXv_char2[0] = GXt_char1 ;
      new com.wwpbaseobjects.dvmessagegetadvancednotificationmsg(remoteHandle, context).execute( AV14Title, AV13Text, AV15Type, AV10ControlSelector, AV11Hide, "false", "", AV9ClickRedirectURL, GXv_char2) ;
      dvmessagegetbasicnotificationmsg.this.GXt_char1 = GXv_char2[0] ;
      AV12Parms = GXt_char1 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = dvmessagegetbasicnotificationmsg.this.AV12Parms;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Parms = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
   }

   private String AV14Title ;
   private String AV13Text ;
   private String AV15Type ;
   private String AV10ControlSelector ;
   private String AV11Hide ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV9ClickRedirectURL ;
   private String AV12Parms ;
   private String[] aP6 ;
}

