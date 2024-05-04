package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.protocolo", "/com.protocolo"})
public final  class protocolo extends GXWebPanelStub
{
   public protocolo( )
   {
   }

   public protocolo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( protocolo.class ));
   }

   public protocolo( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new protocolo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new protocolo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Protocolo";
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

