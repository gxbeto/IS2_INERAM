package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwp_downloadreport_impl extends GXWebProcedure
{
   public wwp_downloadreport_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   protected void privateExecute( )
   {
      AV9fileName = AV12webSession.getValue("WWPExportFilePath") ;
      AV11name = AV12webSession.getValue("WWPExportFileName") ;
      if ( ! (GXutil.strcmp("", AV9fileName)==0) && ! (GXutil.strcmp("", AV11name)==0) )
      {
         AV12webSession.remove("WWPExportFilePath");
         AV12webSession.remove("WWPExportFileName");
         if ( ! httpContext.isAjaxRequest( ) )
         {
            AV10httpResponse.addHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            AV10httpResponse.addHeader("X-Frame-Options", "deny");
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            AV10httpResponse.addHeader("Type-Options", "nosniff");
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            AV10httpResponse.addHeader("Content-Disposition", "attachment;filename="+AV11name);
         }
         AV10httpResponse.addFile(AV9fileName);
      }
      else
      {
         AV10httpResponse.addString("Not found");
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      AV9fileName = "" ;
      AV12webSession = httpContext.getWebSession();
      AV11name = "" ;
      AV10httpResponse = httpContext.getHttpResponse();
      /* GeneXus formulas. */
   }

   private short gxcookieaux ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private boolean entryPointCalled ;
   private String AV9fileName ;
   private String AV11name ;
   private com.genexus.webpanels.WebSession AV12webSession ;
   private com.genexus.internet.HttpResponse AV10httpResponse ;
}

