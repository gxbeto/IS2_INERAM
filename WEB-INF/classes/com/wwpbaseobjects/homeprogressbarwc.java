package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.homeprogressbarwc", "/com.wwpbaseobjects.homeprogressbarwc"})
public final  class homeprogressbarwc extends GXWebPanelStub
{
   public homeprogressbarwc( )
   {
   }

   public homeprogressbarwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( homeprogressbarwc.class ));
   }

   public homeprogressbarwc( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new homeprogressbarwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new homeprogressbarwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Home Progress Bar WC";
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

