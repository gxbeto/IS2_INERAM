package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.contenidos", "/com.contenidos"})
public final  class contenidos extends GXWebPanelStub
{
   public contenidos( )
   {
   }

   public contenidos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( contenidos.class ));
   }

   public contenidos( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new contenidos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new contenidos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Contenidos";
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

