package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wwp_wcmodules", "/com.wwpbaseobjects.wwp_wcmodules"})
public final  class wwp_wcmodules extends GXWebPanelStub
{
   public wwp_wcmodules( )
   {
   }

   public wwp_wcmodules( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_wcmodules.class ));
   }

   public wwp_wcmodules( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_wcmodules_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_wcmodules_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_WCModules";
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

