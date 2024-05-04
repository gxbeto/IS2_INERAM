package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.homeprogressbarcirclewc", "/com.wwpbaseobjects.homeprogressbarcirclewc"})
public final  class homeprogressbarcirclewc extends GXWebPanelStub
{
   public homeprogressbarcirclewc( )
   {
   }

   public homeprogressbarcirclewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( homeprogressbarcirclewc.class ));
   }

   public homeprogressbarcirclewc( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new homeprogressbarcirclewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new homeprogressbarcirclewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Home Progress Bar Circle WC";
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

}

