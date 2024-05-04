package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.promptgeolocation", "/com.wwpbaseobjects.promptgeolocation"})
public final  class promptgeolocation extends GXWebPanelStub
{
   public promptgeolocation( )
   {
   }

   public promptgeolocation( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( promptgeolocation.class ));
   }

   public promptgeolocation( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new promptgeolocation_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new promptgeolocation_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Seleccionar Geolocalización";
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

