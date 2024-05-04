package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.protocoloconsultar", "/com.protocoloconsultar"})
public final  class protocoloconsultar extends GXWebPanelStub
{
   public protocoloconsultar( )
   {
   }

   public protocoloconsultar( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( protocoloconsultar.class ));
   }

   public protocoloconsultar( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new protocoloconsultar_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new protocoloconsultar_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Protocolo: Definicion de Contenidos ";
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

