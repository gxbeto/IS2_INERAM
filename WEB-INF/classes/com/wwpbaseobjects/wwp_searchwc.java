package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wwp_searchwc", "/com.wwpbaseobjects.wwp_searchwc"})
public final  class wwp_searchwc extends GXWebPanelStub
{
   public wwp_searchwc( )
   {
   }

   public wwp_searchwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_searchwc.class ));
   }

   public wwp_searchwc( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_searchwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_searchwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Search WC";
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

