package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.protocolowc", "/com.protocolowc"})
public final  class protocolowc extends GXWebPanelStub
{
   public protocolowc( )
   {
   }

   public protocolowc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( protocolowc.class ));
   }

   public protocolowc( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new protocolowc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new protocolowc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Editar Contenido";
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

