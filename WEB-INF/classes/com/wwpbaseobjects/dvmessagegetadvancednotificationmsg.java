package com.wwpbaseobjects ;
import com.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dvmessagegetadvancednotificationmsg extends GXProcedure
{
   public dvmessagegetadvancednotificationmsg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dvmessagegetadvancednotificationmsg.class ), "" );
   }

   public dvmessagegetadvancednotificationmsg( int remoteHandle ,
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
                             String aP5 ,
                             String aP6 ,
                             String aP7 )
   {
      dvmessagegetadvancednotificationmsg.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String[] aP8 )
   {
      dvmessagegetadvancednotificationmsg.this.AV36Title = aP0;
      dvmessagegetadvancednotificationmsg.this.AV34Text = aP1;
      dvmessagegetadvancednotificationmsg.this.AV38Type = aP2;
      dvmessagegetadvancednotificationmsg.this.AV18ControlSelector = aP3;
      dvmessagegetadvancednotificationmsg.this.AV23Hide = aP4;
      dvmessagegetadvancednotificationmsg.this.AV19IsDesktopNotification = aP5;
      dvmessagegetadvancednotificationmsg.this.AV21DesktopNotificationIconUrl = aP6;
      dvmessagegetadvancednotificationmsg.this.AV40ClickRedirectURL = aP7;
      dvmessagegetadvancednotificationmsg.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      AV31Parms = "{" ;
      if ( ! (GXutil.strcmp("", AV36Title)==0) )
      {
         AV31Parms += "\"title\":\"" + GXutil.trim( GXutil.strReplace( AV36Title, "\"", "")) + "\"," ;
      }
      if ( ! (GXutil.strcmp("", AV34Text)==0) )
      {
         AV31Parms += "\"text\":\"" + GXutil.trim( GXutil.strReplace( AV34Text, "\"", "")) + "\"," ;
      }
      if ( GXutil.strcmp(AV38Type, "nospecify") != 0 )
      {
         AV31Parms += "\"type\":\"" + AV38Type + "\"," ;
      }
      if ( ! (GXutil.strcmp("", AV18ControlSelector)==0) )
      {
         AV31Parms += "\"att\":\"" + (GXutil.startsWith( GXutil.trim( AV18ControlSelector), "#") ? "" : "#") + GXutil.trim( GXutil.strReplace( AV18ControlSelector, "\"", "")) + "\"," ;
      }
      if ( GXutil.strcmp(AV23Hide, "na") != 0 )
      {
         AV31Parms += "\"hide\":" + GXutil.trim( AV23Hide) + "," ;
      }
      if ( ! (GXutil.strcmp("", AV40ClickRedirectURL)==0) )
      {
         AV31Parms += "\"clickUrl\":\"" + GXutil.trim( AV40ClickRedirectURL) + "\"," ;
      }
      if ( ( GXutil.strcmp(AV19IsDesktopNotification, "na") != 0 ) || ! (GXutil.strcmp("", AV21DesktopNotificationIconUrl)==0) )
      {
         AV31Parms += "\"desktop\": {" ;
         if ( GXutil.strcmp(AV19IsDesktopNotification, "na") != 0 )
         {
            AV31Parms += "\"desktop\":" + GXutil.trim( AV19IsDesktopNotification) + "," ;
         }
         if ( ! (GXutil.strcmp("", AV21DesktopNotificationIconUrl)==0) )
         {
            AV31Parms += "\"icon\":\"" + GXutil.trim( AV21DesktopNotificationIconUrl) + "\"," ;
         }
         AV31Parms += "}" ;
      }
      AV31Parms += "}" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = dvmessagegetadvancednotificationmsg.this.AV31Parms;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31Parms = "" ;
      /* GeneXus formulas. */
   }

   private String AV36Title ;
   private String AV34Text ;
   private String AV38Type ;
   private String AV18ControlSelector ;
   private String AV23Hide ;
   private String AV19IsDesktopNotification ;
   private String AV21DesktopNotificationIconUrl ;
   private String AV40ClickRedirectURL ;
   private String AV31Parms ;
   private String[] aP8 ;
}

