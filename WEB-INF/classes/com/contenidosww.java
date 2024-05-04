package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.contenidosww", "/com.contenidosww"})
public final  class contenidosww extends GXWebPanelStub
{
   public contenidosww( )
   {
   }

   public contenidosww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( contenidosww.class ));
   }

   public contenidosww( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new contenidosww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new contenidosww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Contenidos";
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

