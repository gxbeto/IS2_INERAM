package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.enfermedadesww", "/com.enfermedadesww"})
public final  class enfermedadesww extends GXWebPanelStub
{
   public enfermedadesww( )
   {
   }

   public enfermedadesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( enfermedadesww.class ));
   }

   public enfermedadesww( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new enfermedadesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new enfermedadesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Enfermedades";
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

