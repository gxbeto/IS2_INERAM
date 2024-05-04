package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.protocolow3", "/com.protocolow3"})
public final  class protocolow3 extends GXWebPanelStub
{
   public protocolow3( )
   {
   }

   public protocolow3( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( protocolow3.class ));
   }

   public protocolow3( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new protocolow3_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new protocolow3_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Protocolow2";
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

