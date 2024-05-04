package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.protocolow2", "/com.protocolow2"})
public final  class protocolow2 extends GXWebPanelStub
{
   public protocolow2( )
   {
   }

   public protocolow2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( protocolow2.class ));
   }

   public protocolow2( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new protocolow2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new protocolow2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Protocolo: Contenidos ";
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

